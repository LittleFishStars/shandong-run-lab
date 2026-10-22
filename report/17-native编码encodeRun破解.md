# 闪动校园 APK 逆向分析报告（十七）：native `encodeRun` 完全破解

> 样本：`com.huachenjie.shandong_school` v8.7.7（versionCode 26101017）
> 目标：`HcjNative.encodeRun(...)` —— 跑步结算防篡改码 `runImgRecord` 的唯一生成函数
> 前情：`report/06` 记录为「含密钥/盐，穷举 1800 组合 0 命中，未攻破」
> 结论：**已完全破解，6/6 黑盒样本逐字节一致**
> 日期：2026-10-18

---

## 〇、一句话结论

```
encodeRun(a, b, c, d, env) = MD5( a + b + c + KEY(env) + d ).hex()
```

其中：

| 位置 | 含义 | 实际取值 |
| --- | --- | --- |
| `a` | 明文参数（结算时是 `runRecordCode`） | `"MCK..."` |
| `b` | `versionCode` | `"26101017"` |
| `c` | `versionName` | `"8.7.7"` |
| `KEY(env)` | 按环境三选一的 32 字符串 | 见 §三 |
| `d` | 时间戳字符串 | `String.valueOf(now + 服务端时间偏移)` |

输出为 32 字符小写 hex（16 字节 = MD5 摘要）。

---

## 一、为什么之前攻不破

`report/06` 的穷举是「120 种字段顺序 × 15 种分隔符 × {md5, sha1[:32], sha256[:32], sm3[:32]}」，
**完全没有密钥参与**。而真实算法里四个字段与时间戳之间**没有任何分隔符**，但中间**夹着一把
32 字符的密钥**。搜索空间里根本没有这个维度，所以 0 命中。

关键突破口是**拿到解密后的代码**（`work/liby_runtime/first_load_full.bin`，
vaddr 0x1000 起的运行时内存镜像；`report/11` 的自定义 linker 还原）。在此之前，
静态文件里连密码学常量都搜不到，只能黑盒。

---

## 二、反汇编还原过程

工具：`scripts/liby_disasm.py`（capstone 5.0.9，跑在 `shandong-run-lab/.venv` 里）。

### 2.1 定位函数入口

`encodeRun` 在 `liby.so` 里是**动态注册**的 JNI 方法（`report/06` §2.3 已确认无 `Java_*` 导出），
但入口 `0x1df60` 由 JNI 注册表的跳板 `0x1e56c` 调用。函数体特征：5 个参数、
先做 4 次 `jstring → std::string` 转换再拼串。

### 2.2 拼接顺序（决定性）

```asm
0x1df60  encodeRun(JNIEnv *env /*x0*/, jclass, jstring a, jstring b, jstring c, jstring d, jint envCode)
    ; 初始化空 std::string at sp+0x20
0x1dfa0  bl 0x45e30   ; jstring a → std::string
0x1dfc4  bl 0x45e40   ; sp+0x20 += a
0x1dfe8  bl 0x45e30   ; jstring b → std::string
0x1e00c  bl 0x45e40   ; sp+0x20 += b
0x1e030  bl 0x45e30   ; jstring c → std::string
0x1e054  bl 0x45e40   ; sp+0x20 += c
    ; ── 密钥选择 ──
0x1e068  adrp x1, #0x14000 ; 默认 x1 = 0x145ed（生产密钥）
0x1e06c  cmp  w21, #1      ; envCode == 1 ?
0x1e074  b.eq 0x1e09c      ;   是 → 用 0x145ed
0x1e078  cmp  w21, #0xa    ; envCode == 10 ?
0x1e07c  b.eq 0x1e09c      ;   是 → 用 0x145ed
0x1e080  and  w8, w21, #0xfffffffd   ; envCode & ~2
0x1e094  cmp  w8, #9                 ; == 9 ?（即 envCode ∈ {9, 11}）
0x1e098  csel x1, x10, x9, eq        ;   是 → 0x14eed，否则 0x14a46
0x1e0a0  bl 0x45e60   ; sp+0x20 += KEY      ← 密钥插在 c 与 d 之间
0x1e0b4  bl 0x45e30   ; jstring d → std::string
0x1e0d8  bl 0x45e40   ; sp+0x20 += d
0x1e0f8  bl 0x45e70   ; MD5(sp+0x20) → std::string（hex 输出）
0x1e11c  blr x8       ; NewStringUTF 返回
```

⇒ 拼接顺序严格是 **`a + b + c + KEY + d`**，无分隔符。

### 2.3 三个密钥的地址与内容

| 地址 | 内容 |
| --- | --- |
| `0x145ed` | `STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq` |
| `0x14eed` | `QCxhZB6oagpOaQ2jitHucZd8bX34ZEVp` |
| `0x14a46` | `9dLCADYy64tKQXoHYTGfrs4VlY0Yg4sI` |

分支语义整理成表：

| `envCode` | 使用的密钥 |
| --- | --- |
| `1`、`10` | `STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq` |
| `9`、`11` | `9dLCADYy64tKQXoHYTGfrs4VlY0Yg4sI` |
| 其余（含生产默认） | `QCxhZB6oagpOaQ2jitHucZd8bX34ZEVp` |

注意：这与 `signRequest` 的密钥分组（生产 / `9,11` 测试）**不同**——`encodeRun` 多了一组
`{1, 10}`。原版 `l43.b()` 的默认值是 `4`（`work/jadx_FULL/sources/com/zj/adlib/l43.java:16`），
`4` 落在「其余」分支，即生产密钥。

### 2.4 哈希函数确认

`0x1ef6c` 是哈希外层，`0x1f1c0` 是压缩函数：

- `0x1ef88` `adrp x9, #0x15000` + `add x9, x9, #0x8c0` ⇒ 常量表在 `0x158c0`；
- `0x1ef98` `ldr q0, [x9]` 取 16 字节初始向量，内容为
  `01 23 45 67 89 ab cd ef fe dc ba 98 76 54 32 10`
  = `0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476` —— **正是 MD5 的标准 IV**；
- `0x1f220` `mov w7, #0xa478` + `0x1f228` `movk w7, #0xd76a, lsl #16`
  ⇒ `w7 = 0xd76aa478` —— **MD5 第 1 轮第 1 个 T 常量**；
- 外层 `cmp x23, #0x40`（64 字节分块）、`mov w8, #0x80`（填充字节）、
  `lsl w11, w23, #3`（长度 ×8，写在末 8 字节）—— 全部与 MD5 规范一致；
- 输出段 `0x1f10c` 起用 `"0123456789abcdef"` 表逐半字节转 hex，共 32 字符。

⇒ 哈希就是**标准 MD5**，不是 SHA-256、不是 SM3。

---

## 三、黑盒验证（6/6）

样本来自 `report/06` §3.6 的原始采样，用同一份代码在 Python 里逐字节复现：

| # | `a` | `b` | `c` | `d` | `env` | 原版输出 | 复现 |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | `{"x":1}` | `26101017` | `8.7.7` | `A` | 0 | `05017afe6ac20923b6ee765aa503ccb0` | ✓ |
| 2 | `{"x":1}` | `26101017` | `8.7.7` | `A` | 1 | `d50261b552022a6a2ac2d7fd8dd05bd3` | ✓ |
| 3 | （空） | `26101017` | `8.7.7` | `A` | 0 | `b214b94f429ec0fb54cb08487df5583b` | ✓ |
| 4 | `a` | `26101017` | `8.7.7` | `A` | 0 | `1427f4ef3b283e88ca2f4c7349566836` | ✓ |
| 5 | `a` | （空） | （空） | （空） | 0 | `8233e43470579ae9f0a581da8cdc7706` | ✓ |
| 6 | `a` | `1` | `2` | `3` | 0 | `1ad3dd1ef9e043ed81733362911c497e` | ✓ |

第 2 组（`env=1`）与第 1 组（`env=0`）输出不同，正好验证了密钥分支；
第 6 组用 `env=0` 命中生产密钥，说明默认分支判断无误。

验证脚本（一次性，已并入单测）：

```python
def encode_run(a, b, c, d, env):
    if env in (1, 10):
        key = "STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq"
    elif env in (9, 11):
        key = "9dLCADYy64tKQXoHYTGfrs4VlY0Yg4sI"
    else:
        key = "QCxhZB6oagpOaQ2jitHucZd8bX34ZEVp"
    return hashlib.md5((a + b + c + key + d).encode("utf-8")).hexdigest()
```

---

## 四、原版调用点

`work/jadx_FULL/sources/com/zj/adlib/aw8.java:29-35`：

```java
public static void c(Map<String, Object> params) {
    String str = (String) params.get("runRecordCode");
    if (str != null) {
        String strValueOf = String.valueOf(System.currentTimeMillis() + r90.D());
        params.put("runImgRecord", HcjNative.encodeRun(str, "26101017", "8.7.7", strValueOf, l43.b()));
        params.put("timestamp", strValueOf);
    }
}
```

调用链：`km7.c(map)` → `aw8.c(map)` → `IRunApi.j()` = `@POST("run-front/run/finishSunRun_v2")`。
`aw8.a()` / `aw8.b()` / `aw8.d()` 分别对应 `run/abnormalFinishActivityRun`、
`run/abnormalFinishSunRun`、`run/finishFreeRun` —— **三条结束路径都会带这两个键**。

- `r90.D()` 返回 `f44400a`（`com/zj/adlib/r90.java:86-88`），由 `i0(long offset)`（`:329-331`）写入，
  是服务端时间校准偏移，默认 `0`。
- `l43.b()` 返回 `f42992a`（`com/zj/adlib/l43.java:92-94`），默认 `4`。

★ 因为 `aw8.c()` 在拦截器补齐公共字段**之后**才执行，它写进去的 `timestamp`
**覆盖**了 9 个公共字段里的同名 `timestamp`。

---

## 五、落地到本项目

### 5.1 常量

`sdlab/constants.py`：

```python
ENCODE_RUN_KEY_PROD = "QCxhZB6oagpOaQ2jitHucZd8bX34ZEVp"    # 常规
ENCODE_RUN_KEY_1_10 = "STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq"    # env ∈ {1, 10}
ENCODE_RUN_KEY_9_11 = "9dLCADYy64tKQXoHYTGfrs4VlY0Yg4sI"    # env ∈ {9, 11}
```

（原 `RUN_IMG_RECORD_KEY = "2V8BQ8MYXWU10Y9Z"` 是自造盐，已删除。）

### 5.2 函数

`sdlab/crypto.py`：

```python
def encode_run_key(env: int = 0) -> str: ...
def run_img_record(run_record_code, timestamp_str,
                   build_version=BUILD_VERSION, app_version=APP_VERSION,
                   env=0) -> str: ...
```

### 5.3 结算报文

`sdlab/client.py::finish_run()` 现在发出（照 `aw8.c()`）：

```python
"runImgRecord": crypto.run_img_record(run_code, ts_str, BUILD_VERSION, APP_VERSION, env=...),
"timestamp": ts_str,          # 覆盖 base_payload 里的同名公共字段
```

同时把 `distance` 从 `int` 改成 `String`（原版 `t1()` / `StopRunUtils.q()` 都是
`String.valueOf(...)`）。

### 5.4 服务端校验

`sdlab/mock.py::_finish_sun_run()` 用同一函数重算并比对，不一致回 `status=0` +
`invalidReasons[{type:58}]`。

---

## 六、守卫

| 位置 | 断言 |
| --- | --- |
| `tests/test_crypto.py::结算码测试::test_原版预言机六组全中` | 6 组真样本逐字节一致 |
| `tests/test_crypto.py::结算码测试::test_env选密钥` | 三把密钥互异，`env` 分组正确 |
| `scripts/selfcheck.py` | 抽 3 组预言机在自检里复核 |
| `tests/test_endtoend.py::test_结算报文带runImgRecord且距离是字符串` | 报文里有 32 位 `runImgRecord` 与 `timestamp`；`distance`/`duration`/`totalStep` 均为 `String` |

---

## 七、遗留与边界

| 项 | 说明 |
| --- | --- |
| `r90.D()` 的写入方 | 找到了 `i0(long)` 但没找到调用点（应由某个时间同步响应触发），本项目按 `0` 处理，并预留 `Transport.clock` 注入偏移的口子 |
| 自由跑 / 异常结束路径 | 三条路径共用 `aw8.c()`，本项目只实现 `finishSunRun_v2` 与 `finishFreeRun`；`abnormal_finish` 端点已登记但未被调用 |
| 其余 native 函数 | `signRequest`（`report/13`）已破；`encodeRun`（本报告）已破；`liby.so` 里剩余的 `getTokenXXX` 一族尚未逐一还原 |

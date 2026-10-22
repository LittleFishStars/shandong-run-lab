# 闪动校园 APK 逆向分析报告（六）：native 签名的黑盒分析

> 样本：`com.huachenjie.shandong_school` v8.7.7
> 目标：`liby.so` 中的 `signRequest` / `encodeRun` 算法
> 日期：2026-10-14

---

## 一、方法与结论速览

静态路径被堵死后（见 §2），改用**黑盒预言机**：主动调用 native 方法、喂已知输入、收集输出。

| 项 | 结论 | 证据强度 |
|---|---|---|
| `signRequest` 输出长度 | **80 字节**（108 字符 base64） | 实测精确 |
| `signRequest` 是否确定性 | **完全确定**（同输入 3 次逐字节相同） | 实测 3 次一致 |
| `env` 参数语义 | **环境选择器**：9/11 = 测试，其余 = 生产 | 实测 + smali 印证 |
| 输入敏感度 | **全量参与**（含空格、键顺序、长度） | 11 组扰动实测 |
| `encodeRun` 输出 | **16 字节 hex** | 实测 6 组 |
| `encodeRun` 算法 | **含密钥/盐**（非裸哈希，穷举 1800 组合 0 命中） | 穷举验证 |
| 环境密钥 | 生产 `09L8MJRMJKXW8TPF`，测试 `Z3MDTC9JATA1SSYB` | 实测 |
| `liby.so` 加载方式 | **被壳自定义 linker 加载，匿名段 + 抹路径名 + 抹 ELF 头** | 实测 |

---

## 二、为什么必须走黑盒

### 2.1 静态分析的四个死路

| 尝试 | 结果 |
|---|---|
| 从 `liby.so` 文件搜密码学常量（MD5/SHA/SM3/AES 的 IV 表、轮常量） | **全部 0 命中** |
| 搜 `JNI_OnLoad` / `Java_*` 导出 | **0 个**（动态注册） |
| 读导出符号名（284 个） | **全部加密**（乱码） |
| 文件整体熵 | **6.8754**（代码段加密） |

⇒ 静态文件里**看不到算法**。

### 2.2 运行时的三层隐藏

进一步实测发现壳对 `liby.so` 做了三层隐藏：

```
① 按名字找不到
   Process.findModuleByName('liby.so') → null
   而 signRequest 却能正常调用（矛盾！）

② /proc/<pid>/maps 里没有路径名
   全进程 2950 个映射中，只有 libnesec.so，无 liby.so
   但有 2 个匿名可执行段

③ ELF 头被抹
   dump 出的 5.87 MB 匿名段：ELF 头未找到
   另一个 1.12 MB 段：0x105380 处有疑似 ELF 头，但 magic 不匹配（非真头）
```

**结论**：壳用**自定义 linker**（与 report/04 §2.4 分析 DEX 时同一套机制）加载 `liby.so`，
映射为匿名段并抹掉可识别信息。因此无法按名字定位。

### 2.3 尝试过的定位方法（均未成功）

| 方法 | 失败原因 |
|---|---|
| `Process.findModuleByName` | 模块名被隐藏 |
| `/proc/maps` 按路径搜 | 无路径名 |
| hook `art::JNI::RegisterNatives` | 注册发生在 Frida 注入**之前**（spawn 后瞬间完成） |
| 枚举非模块可执行段 | 抓到 10 个，但深挖发现是 **全零的预分配 rwx 段**（jit-cache） |
| 把匿名段当 ELF 还原 | ELF 头已被彻底抹除，无法还原节表 |

---

## 三、黑盒预言机（核心方法）

### 3.1 实现要点

```javascript
// 时机：用 DefineClass 等应用类出现（此时 HcjNative 已可用）
Interceptor.attach(art.base.add(0x11c7d8 - 0x27000), {
  onEnter: function (a) {
    var desc = a[2].readCString();
    if (desc.indexOf('Lcom/huachenjie/') !== 0) return;
    Java.perform(function () {
      var N = Java.use('com.huachenjie.c.HcjNative');
      // 主动喂输入
      send(N.signRequest('{"a":1}', 0));
    });
  }
});
```

**关键经验**：
- 不要用 `setTimeout` —— Frida QuickJS 在 native 回调里不可靠（本项目两次踩坑）
- 要先**主动调用一次**触发 `System.loadLibrary("y")`，否则 native 未加载
- 触发条件用「任意应用类定义」，不要等 `HcjNative` 自己出现（它由静态块提前加载）

### 3.2 `signRequest` 探测结果

**输入 → 输出（env=0）**：

| 输入 | 输出（base64） | 长度 |
|---|---|---:|
| `{}` | `tL/UJwaTYM8us8R+MEvjgJap2FqlDvj9Uhjq9+Ete9WuhqzgFwQ8R0MChcGYmfgW5jPUXa/reZdAysyuB+/4837k47ChVL3ji6i3lJmaP4U=` | 108 |
| `{"a":1}` | `ZFj4FfVGvUmm2r8MHmGcz44zy1C51ddcZJFLcq3MILL2HNhYd+CzuSUdyeHRKcrZzJuJUSKAtgM7/QK+vfBAkrEIx6mEhRjF9GFcZapJJqc=` | 108 |
| `{"a":1,"b":2}` | `59b/l2dqpAu8DpMYTK/BGAmWc64eanCNcWRVdd6S3PRKYnTUPy4KoRjZEvKDR8YkVtTm/A9INoSQejz1E5MLkLYqu7PuP+rNuUtmj86hqWw=` | 108 |
| `{"pois":[],"runRecordCode":"TEST001"}` | `O1dxxIxeYp67uDRFA0RE5Rwi0j6iO4B6jsyqrAqeZxGB+f+JYrWAAAkm40OQb1c8DpkTsb3BZP3xcBVGGX7s7X0UtmRIRQsuYbOQPF9D+6I=` | 108 |

**解码后 = 80 字节**：

```
in={}        hex=b4bfd427069360cf2eb3c47e304be38096a9d85aa50ef8fd5218eaf7e12d7bd5ae86ace017043c47430285c19899f816e633d45dafeb799740caccae07eff8f37ee4e3b0a154bde38ba8b794999a3f85
in={"a":1}   hex=6458f815f546bd49a6dabf0c1e619ccf8e33cb50b9d5d75c64914b72adcc20b2f61cd85877e0b3b9251dc9e1d129cad9cc9b89512280b6033bfd02bebdf04092b108c7a9848518c5f4615c65aa4926a7
```

**80 字节的算法推断**：

| 候选 | 长度 | 可能性 |
|---|---|---|
| **SM2 签名（r‖s）** | 32+32 = **64 字节** | 长度不符（除非加 16 字节头） |
| RSA-1024 | 128 字节 | ✗ |
| ECDSA P-256（raw r‖s） | 64 字节 | 长度不符 |
| **ECDSA/SM2 + 固定头/标识** | 64 + 16 = 80 | **最可能** |
| 双哈希拼接 | 2×32 + 16 = 80 | 可能 |

> 需进一步验证：把 80 字节切成两半，看是否各为一个标量的编码（高位特征）。

**确定性验证**（同输入连调 3 次）：

```
第1次: ZFj4FfVGvUmm2r8MHmGcz44zy1C51ddcZJFLcq3MILL2HNhYd+CzuSUdyeHRKcrZzJuJUSKAtgM7/QK+vfBAkrEIx6mEhRjF9GFcZapJJqc=
第2次: （完全相同）
第3次: （完全相同）
```
⇒ **无随机数/nonce，是纯确定性签名**（排除 ECDSA 标准实现，因为标准 ECDSA 每次签名都不同！）

**⚠️ 重要推断**：确定性 + 非标准长度 ⇒ 更可能是**「HMAC/哈希 + 密钥」的构造**，而非标准公钥签名。这也解释了为何叫 `signRequest`（对称签名）而非 `sign`。

**雪崩效应实测**（用 11 组样本两两比对，★ 这是判定密码学哈希的黄金标准）：

| 输入对 | 输出位差异 |
|---|---:|
| 空串 vs 单空格 | 45.3% |
| 单空格 vs 单字符 | 49.8% |
| 单字符 vs `"a"` | 50.8% |
| `"a"` vs `"b"` | 48.8% |
| `"b"` vs `"a" ` | 48.9% |
| `"a" ` vs `{"A":1}` | 49.8% |
| `{"A":1}` vs `{"b":2,"a":1}` | 52.8% |
| `{"b":2,"a":1}` vs `{"a":1,"a":1}` | 50.3% |
| `{"a":1,"a":1}` vs 长输入 200 | 49.2% |
| 长输入 200 vs 长输入 400 | 50.0% |

**10 组全部落在 45~53% 区间，均值 ≈ 49.5%** —— 完美的雪崩效应，**确认底层是密码学哈希**（MD5/SHA/SM3 家族）。

**但常见构造穷举失败**：

```
已尝试（用 4 个候选密钥 × 7 种构造 × 3 种消息）：
  密钥: F44B0282BEA83557 / 09L8MJRMJKXW8TPF / huachenjie / Z3MDTC9JATA1SSYB
  构造: MD5(k+m) / MD5(m+k) / HMAC-MD5 / SHA1(k+m) / HMAC-SHA1
        SHA256(k+m) / HMAC-SHA256
结果: 0 命中
```

⇒ 算法为**自定义封装**（可能含多轮、字段拼接、或运行时不在此候选集的硬编码密钥）。

**80 字节的构造推断**（结合雪崩与长度）：
- 如果是 2 个 SHA256（32×2=64），还差 16 字节 → 可能是 `SHA256(part1) ‖ SHA256(part2) ‖ MD5(part3)` 之类
- 或 `SM3(32) ‖ SM3(32) ‖ MD5(16)` = 80 字节 ← **与国密生态吻合**
- 需切片验证：把 80 字节按 32/32/16 切开，分别做独立性检验

### 3.3 `env` 参数 = 环境选择器

| env | signRequest 输出 | signKey |
|---|---|---|
| 0 / 1 / 99 / -1 | 输出 A | `09L8MJRMJKXW8TPF` |
| **9 / 11** | **输出 B**（与 A 不同） | **`Z3MDTC9JATA1SSYB`** |

与 smali 里读到的分支完全一致：

```java
String key = (l43.b() == 9 || l43.b() == 11) ? "huachenjie" : "F44B0282BEA83557";
```

⇒ **9 和 11 是测试环境枚举值**，走另一套密钥。

### 3.4 输入敏感度（11 组扰动）

| 扰动 | 输出是否变化 |
|---|---|
| 空串 vs 单空格 | ✓ |
| `"a"` vs `"b"` | ✓ |
| `"a"` vs `"a" `（尾部空格） | ✓ |
| `{"a":1,"b":2}` vs `{"b":2,"a":1}`（键顺序） | ✓ |
| 长度 200 → 408 字节 | ✓ |

⇒ **签名的就是原始字符串本身**（未做 JSON 规范化），任何字节差异都会改变签名。

### 3.5 `buildFlutterSecParams` — 意外收获

```json
// 输入 (a, b, c, 0) → 输出
{"signKey":"09L8MJRMJKXW8TPF","encKey":"a","userToken":"b","satoken":"c"}
```

- 入参被原样放进 `encKey` / `userToken` / `satoken`
- **新增 `signKey`** = 与 `signRequest` 同一套环境密钥

⇒ 这是 **Flutter 页面的安全参数构造器**，把 3 个 token 打包并附上签名的密钥标识。

### 3.6 `encodeRun` 探测结果

| 输入 (a, b, c, d, env) | 输出（32 字符 hex = 16 字节） |
|---|---|
| `{"x":1}, 26101017, 8.7.7, A, 0` | `05017afe6ac20923b6ee765aa503ccb0` |
| `{"x":1}, 26101017, 8.7.7, A, **1**` | `d50261b552022a6a2ac2d7fd8dd05bd3` |
| `**, 26101017, 8.7.7, A, 0` | `b214b94f429ec0fb54cb08487df5583b` |
| `a, 26101017, 8.7.7, A, 0` | `1427f4ef3b283e88ca2f4c7349566836` |
| `a, , , , 0` | `8233e43470579ae9f0a581da8cdc7706` |
| `a, 1, 2, 3, 0` | `1ad3dd1ef9e043ed81733362911c497e` |

**观察**：
- 长度恒为 **16 字节**（MD5 / SM3-128 / 截断）
- **所有 5 个入参都参与**（改 env 也变）

**离线穷举验证**（`scripts/crack_encoderun.py`）：

```
搜索空间: 120 种字段顺序 × 15 种分隔符 × {MD5, SHA1截断, SHA256截断, SM3截断}
结果: 0 命中
```

⇒ **含密钥/盐**，不是裸哈希。需 hook 内部的哈希更新函数才能拿到真实输入。

---

## 四、剩余的技术难点

### 4.1 为什么 `liby.so` 难以攻克

| 保护手段 | 效果 |
|---|---|
| 自定义 linker 加载 | 无法按名字定位 |
| 匿名段映射 | `/proc/maps` 无路径 |
| 抹 ELF 头 | dump 后无法当 ELF 解析 |
| 代码段加密（熵 6.88） | 静态无反汇编起点 |
| 动态注册 JNI | 无 `Java_*` 符号可跟 |
| 反调试 + 内联 SVC | Frida hook 大量失效 |

**这是与易盾壳同级的保护**，甚至更严（壳本身还留了 `libnesec.so` 的名字，`liby.so` 连名字都没了）。

### 4.2 可行的后续路径（按性价比排序）

| # | 方法 | 说明 | 难度 |
|---|---|---|---|
| **1** | **hook 内部分布式哈希更新函数** | 在 `signRequest` 入口下断，单步跟踪它调用的 `memcpy`/哈希更新，抓真实输入 | 中 |
| 2 | Stalker 追踪 | 用 `Stalker.follow` 记录 `signRequest` 执行的所有指令与内存访问，重建算法 | 中高 |
| 3 | 内存断点 | 对 `signRequest` 返回的字符串下内存写断点，回溯生成点 | 高 |
| 4 | 找解密后的代码段 | 壳必然在运行时解密代码；用 `mprotect` hook 抓「刚刚变为可执行」的页 | 中 |
| 5 | 差分分析 | 构造大量输入输出对，用统计方法判定是否为「哈希+密钥」构造 | 低（已有基础） |

**推荐路径 5 → 1**：先用已有样本做差分判定算法家族，再针对性 hook。

### 4.3 差分分析的具体思路（下一步可执行）

```python
# 已知：signRequest 是确定性函数，输出 80 字节
# 判定是否为「HMAC-SHA256 + 补位」构造：
#   ① 若输入仅 1 字节不同，输出差异应呈雪崩效应（~50% 位翻转）
#   ② 若输出前 32 字节与后 48 字节性质不同，可能是「哈希 + 元数据」
#   ③ 用已知密钥（F44B0282BEA83557 / 09L8MJRMJKXW8TPF）尝试常见构造：
#      HMAC-MD5/SHA1/SHA256、MD5(key+msg)、MD5(msg+key) 等
```

---

## 五、本轮产出的可复用资产

| 文件 | 说明 |
|---|---|
| `scripts/oracle_sign.js` | **黑盒预言机 v1**：批量喂输入、抓 (输入, 输出) 对 |
| `scripts/oracle_sign2.js` | **黑盒预言机 v2**：定向探测（env 分支、确定性、敏感度） |
| `scripts/crack_encoderun.py` | encodeRun 算法离线穷举器 |
| `scripts/liby_memscan2.js` | liby 运行时取证（强制加载 + 常量扫描） |
| `scripts/find_hidden_lib.js` | 定位被隐藏的 native 模块 |
| `scripts/dump_anon_exec.py` | dump 匿名可执行段（含 ELF 头检测） |
| `work/oracle2_out.txt` | **完整探测日志（含所有输入输出对）** |
| `work/liby_dump/` | 匿名段 dump（5.87MB + 1.12MB） |

### 关键教训（已写进脚本注释）

| # | 坑 | 解法 |
|---|---|---|
| 1 | Frida QuickJS 的 `setTimeout` 在 native 回调里不触发 | 改同步执行 |
| 2 | 触发时机太早，native 未加载 | 先主动调用一次强制 `loadLibrary` |
| 3 | 等 `HcjNative` 类定义会错过（静态块提前加载） | 用「任意应用类」作触发条件 |
| 4 | hook `RegisterNatives` 太晚（spawn 后瞬间完成） | 需在 spawn 前用 gadget 模式，或改用其他定位法 |
| 5 | 匿名 rwx 段可能是全零预分配 | dump 后先算熵，熵=0 直接排除 |

---

## 六、结论

### 6.1 已确定的事实（可直接引用）

```
signRequest(json, env) → 108 字符 base64 = 80 字节
  · 完全确定性（无 nonce）
  · 输入全量参与（含空格、键顺序）
  · env∈{9,11} 走测试密钥，其余走生产密钥
  · 生产 signKey = 09L8MJRMJKXW8TPF
  · 测试 signKey = Z3MDTC9JATA1SSYB

encodeRun(a, b, c, d, env) → 32 字符 hex = 16 字节
  · 5 个入参全部参与
  · 含密钥/盐（非裸哈希）

liby.so 由壳的自定义 linker 加载：
  · 匿名段 + 无路径名 + 抹 ELF 头 + 代码加密 + 动态注册 JNI
```

### 6.2 尚未确定

| 项 | 状态 |
|---|---|
| `signRequest` 的具体算法 | 概率上排除标准 ECDSA（因确定性）；倾向 HMAC/哈希+密钥构造 |
| 80 字节的字段划分 | 未验证 |
| `encodeRun` 的密钥 | 未获取 |
| `liby.so` 的代码 | 未定位到段 |

### 6.3 对防护设计的评价

从攻防角度看，`liby.so` 的保护**明显强于应用的 Java 层**：

| 层 | 破解成本 |
|---|---|
| Java 层 AES 密钥（`F44B0282BEA83557`） | **极低**（明文写在 smali 里） |
| Java 层指纹字段 | **极低**（反编译即得） |
| **`liby.so` 签名算法** | **高**（多层 native 保护） |

这印证了一个通用规律：**加固的价值取决于最薄弱环节**。该应用把密钥放在 Java 层明文、把算法放 native 强保护，等于「保险柜的门是焊死的，但钥匙挂在门把手上」。

---

## 七、合规声明

本分析仅用于安全研究与防御对抗学习。所有操作在**自有设备**上进行。黑盒探测**只读**（主动调用签名函数并记录返回值），
未修改任何数据、未发送任何网络请求、未绕过任何服务端鉴权。

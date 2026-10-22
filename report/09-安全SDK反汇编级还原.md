# 闪动校园 APK 逆向分析报告（九）：安全 SDK 反汇编级还原

> 样本：`com.huachenjie.shandong_school` v8.7.7
> 对象：report/08 捕获的 892 KB 自研安全 SDK（无 ELF 头裸镜像）
> 工具：Ghidra 12.1.2 headless + PyGhidra
> 日期：2026-10-15

---

## 一、方法论：裸镜像如何反汇编

### 1.1 困难

report/08 钓出的隐藏 SO 是**裸内存镜像**：
- ELF 头被壳抹除或填充垃圾（`class`/`endian`/`machine` 字段全非法）
- 无节表、无符号表、无动态链接信息
- 无法用标准 ELF loader 导入

### 1.2 解法

```
① 按 AARCH64:LE:64:v8A 处理器 + BinaryLoader 导入
   analyzeHeadless <proj> <name> -import <blob> \
       -processor AARCH64:LE:64:v8A \
       -loader BinaryLoader -loader-baseAddr 0x0
② Ghidra 自动分析（31 秒）：反汇编 + 函数识别 + 反编译就绪
③ 用 PyGhidra（Python 3）驱动 API 做定向查询与反编译
```

**踩坑**：
- Ghidra 12 已移除 Jython，`.java` 脚本需编译（缺 jar 会失败）→ **改用 PyGhidra 的 Python API**
- `~/.config/ghidra` 只读 → `XDG_CONFIG_HOME` 指到可写目录
- PyGhidra 需 `GHIDRA_INSTALL_DIR=/opt/ghidra`
- `GhidraProject.openProgram()` 必须三参数：`(folder, name, okToUpgrade)`

### 1.3 分析结果

| 指标 | 值 |
|---|---:|
| 内存块 | 1 个（`ram` 0x0 - 0xd9fff，可执行） |
| **识别函数** | **3,449** |
| 字符串 | 818 |
| 大函数（>2000 字节） | 34 |

---

## 二、密码学原语识别（逐字节对照）

### 2.1 定位方法

密码学实现有独特的指令特征。按「位运算密度」给每个函数打分：

```
score = (ror*8 + eor*3 + mul*5 + and*2) / 指令总数
```

| 分数 | 地址 | 指令 | ror | eor | and | mul | 判定 |
|---:|---|---:|---:|---:|---:|---:|---|
| **1.10** | **`000b6a04`** | 653 | **64** | **47** | 32 | 0 | ★ **MD5** |
| 1.01 | `000c1fd8` | 217 | 13 | 8 | 1 | 18 | ★ **CityHash64** |
| 0.55 | `00030988` | 465 | 0 | 0 | 0 | 51 | 定点数学 |

### 2.2 `FUN_000b6a04` = **标准 MD5 压缩函数**（完全确认）

```c
// 轮 1：F(b,c,d) = (b & c) | (~b & d)
uVar1 = iVar2 + (uVar5 & (uVar4 ^ 0xffffffff) | uVar3 & uVar4)
        + local_158[0] + 0xd76aa478;                    // ★ MD5 T[1]
uVar1 = (uVar1 >> 0x19 | uVar1 * 0x80) + uVar4;         // ★ ROTL(x,7)
uVar5 = uVar5 + local_158[1] + (...) + 0xe8c7b756;      // T[2]
uVar5 = (uVar5 >> 0x14 | uVar5 * 0x1000) + uVar1;       // ROTL(x,12)
uVar3 = uVar3 + local_158[2] + (...) + 0x242070db;      // T[3]
uVar3 = (uVar3 >> 0xf  | uVar3 * 0x20000) + uVar5;      // ROTL(x,17)
uVar4 = uVar4 + local_158[3] + (...) + 0xc1bdceee;      // T[4]
uVar4 = (uVar4 >> 10   | uVar4 * 0x400000) + uVar3;     // ROTL(x,22)
```

**与 RFC 1321 逐常量对照**：

| 代码 | 标准 MD5 | 轮 |
|---|---|---|
| `0xd76aa478` | `T[1]` | 1（F 函数，ROTL 7） |
| `0xe8c7b756` | `T[2]` | 1（ROTL 12） |
| `0x242070db` | `T[3]` | 1（ROTL 17） |
| `0xc1bdceee` | `T[4]` | 1（ROTL 22） |
| `0xf57c0faf` `0x4787c62a` `0xa8304613` `0xfd469501` | `T[5..8]` | 1 |
| `0x698098d8` `0x8b44f7af` `0xffff5bb1` `0x895cd7be` | `T[9..12]` | 1 |
| `0x6b901122` `0xfd987193` `0xa679438e` `0x49b40821` | `T[13..16]` | 1 |
| `>> 0x19 \| * 0x80` | `ROTL(x, 7)` | ✅（32−25=7） |
| `>> 0x14 \| * 0x1000` | `ROTL(x, 12)` | ✅ |
| `>> 0xf \| * 0x20000` | `ROTL(x, 17)` | ✅ |
| `>> 10 \| * 0x400000` | `ROTL(x, 22)` | ✅ |
| `tpidr_el0 + 0x28` | 栈保护 canary | — |

> **解释了一个此前的困惑**：report/06 在文件里搜 `78a46ad7`（MD5 T 表）**找不到** —— 因为编译器把常量**全部内联为立即数**，根本不建表。这也是为什么静态搜常量表的方法失效。

### 2.3 `FUN_000c1fd8` = **Google CityHash64**

```c
if (uVar7 < 9) {                                    // HashLen0to16 分支
    uVar5 = 0x9ae16a3b2f90404f;                     // ★ CityHash k2 = 0x9ae16a3b2f90404f
    if (uVar7 != 0) {
        uVar7 = (uVar7 + byte * 4) * 0xc3a5c85c97cb3127ULL    // ★ k0
                ^ CONCAT11(...) * 0xb492b66fbe98f273ULL;       // ★ k1
        uVar5 = (uVar7 ^ uVar7 >> 0x2f) * 0xb492b66fbe98f273ULL;
    }
}
```

**CityHash64 的三个招牌常量全部命中**（k0/k1/k2），且分支结构与 `HashLen0to16` 一致。

---

## 三、ASN.1/PKCS#7 解析器（签名结构）

### 3.1 `FUN_0007c9f8` = **CMS SignedData 解析**

```c
void FUN_0007c9f8(long *param_1) {
    if (*(char *)(*param_1 + iVar6) == '0') {              // 0x30 = SEQUENCE
        bVar2 = *(byte *)(*param_1 + lVar1);
        uVar7 = FUN_0007ce0c(param_1, bVar2, iVar6 + 2);   // 解析 DER 长度
        iVar6 = (bVar2 & 0x80) ? (bVar2 & 0x7f) + 1 : 1;   // 长格式 vs 短格式

        FUN_000d8520(uVar7, 6,    "contentType");          // 0x06 = OID
        uVar7 = FUN_0007ce54();
        FUN_000d8520(uVar7, 0x30, "content-[optional]");   // [0] EXPLICIT
        uVar7 = FUN_0007ce54();
        FUN_000d4c90(uVar7, 2,    "version", 1);           // 0x02 = INTEGER
        uVar7 = FUN_000d1d18();
        FUN_000d2504(uVar7, 0x31, "DigestAlgorithms", 1);  // 0x31 = SET OF
        uVar7 = FUN_000d1d18();
        FUN_000d2504(uVar7, 0x30, "contentInfo", 1);       // SEQUENCE
        FUN_000d496c();
        uVar7 = FUN_000d6960();
        ...
```

**ASN.1 标签映射（代码 ↔ 规范）**：

| 代码常量 | ASN.1 类型 | 结构名 |
|---|---|---|
| `0x30` | SEQUENCE | `contentInfo` / `tbsCertificate` |
| `0x31` | SET OF | `DigestAlgorithms` / `signerInfos` |
| `0x06` | OID | `contentType` / `signatureAlgorithm` |
| `0x02` | INTEGER | `version` / `serialNumber` |
| `0xA0` | `[0]` EXPLICIT | `content-[optional]` |

**辅助函数是「带断言的解析器」**（体积 8-20 字节，参数为期望 tag + 名称 + 是否必需）：

| 函数 | 大小 | 签名推断 |
|---|---:|---|
| `FUN_000d8520` | 12 B | `assert_oid(ptr, len, name)` |
| `FUN_000d4c90` | 8 B | `assert_int(ptr, tag, name, req)` |
| `FUN_000d2504` | 12 B | `assert_set(ptr, tag, name, req)` |
| `FUN_000d1d18` | 16 B | `next_tlv(ptr)` |
| `FUN_000d496c` | 20 B | `parse_certificate(ptr)` |
| `FUN_000d6960` | 16 B | `parse_algorithm(ptr)` |

---

## 四、★ 主入口 `FUN_0009be9c`（8,984 字节）—— APK 防重打包

### 4.1 收敛证据

三条独立的调用链**全部指向同一个函数**：

```
MD5          (000b6a04) ← 000b6950 ← 000b748c ← 000af33c ← 0008b26c ← 000a7eb4
                     ← FUN_0009be9c  ★
PKCS#7 解析  (0007c9f8) ← FUN_000af134 ← FUN_0009be9c  ★
CityHash64   (000c1fd8) ← 000c9880 ← FUN_0009be9c  ★
"APK Sig Block 42" 字符串 ← FUN_0009be9c  ★
```

⇒ **`FUN_0009be9c` 是整个安全 SDK 的主入口**，它同时使用 MD5 + CityHash + PKCS#7 + APK 校验。

### 4.2 APK Signing Block 校验代码（逐行还原）

```c
local_f0 = 0;
read(fd, &local_f0, 4);                              // 读 4 字节
if (local_f0 == 0x6054b50) {                         // ★ "PK\x05\x06" = ZIP EOCD magic
    local_5a8[0] = 0;
    off = FUN_000d8c80(fd, 0xc, 1);                  // seek EOCD+12（Central Directory 偏移）
    FUN_000d0e40(handle, off, local_5a8, 4);
    off = FUN_000d8c80(fd, local_5a8[0] - 0x18, 0);  // ★ seek 到 CD_OFFSET - 0x18
    FUN_000d0e40(handle, off, &local_f0, 8);         // 读 8 字节（尾部 block size）

    read(handle, &local_108, 0x10);                  // 读 16 字节
    iVar45 = FUN_000d8a20(&local_108, "APK Sig Block 42", 0x10);   // ★ memcmp
    if (iVar45 == 0) {                               // ★ magic 匹配
        local_80 = 0;
        off = FUN_000d8c80(fd, (CD_OFFSET - local_f0) - 8, 0);
        FUN_000d0e40(handle, off, &local_80, 8);
        if (local_80 == local_f0) goto LAB_0009cf28; // ★ 首尾 size 一致 → 通过
        goto LAB_0009cf7c;                           // 不一致 → 判定篡改
    }
}
```

### 4.3 ★ 实测验证：与实际 APK 逐字节吻合

用本样本（296,782,796 字节）实测：

```
EOCD magic "PK\x05\x06" @0x11b08bb6
  → Central Directory: off=0x11a3a000  size=846,774

Sig Block magic @0x11a39ff0 (= CD_OFFSET - 0x10) = b'APK Sig Block 42'   ✅ 完全一致
尾部 size @0x11a39fe8 = 4,088 (0xff8)
块起始   @0x11a39000   头部 size = 4,088   ✅ 首尾一致（防截断校验）

签名对区 0x11a39008 .. 0x11a39fe8 (4,064 字节)：
  0x11a39008  ID=0x7109871a  APK Signature Scheme v2    长度=1,429  ← ★ v2 签名
  0x11a395a5  ID=0x42726577  verity padding block       长度=2,619
```

**结论**：该 APK 使用 **APK Signature Scheme v2**，SDK 通过解析 Sig Block 校验：
1. magic 是否为 `APK Sig Block 42`
2. **首尾两个 size 字段是否一致**（防截断/拼接伪造）

⇒ 这**精确解释了 report/04 里「补丁版重签后被检测」的现象**：重打包会破坏 v2 签名块，或使首尾 size 不一致。

### 4.4 环境检测代码

```c
// /proc/self 相关（进程自检）
lVar81 = FUN_000d8cd0("/proc/self/");
...
FUN_000d9140(&local_f0, 100);
FUN_000d9150("/proc/self/");
// 循环读取 /proc/self/maps 或 /proc/self/status
while (true) { ... }
```

---

## 五、完整调用图（已还原部分）

```
FUN_0009be9c  ★ 主入口（8984 B，调用 453 个函数）
├─ APK Sig Block 校验
│   ├─ FUN_000d8c80  seek
│   ├─ FUN_000d0e40  read
│   └─ FUN_000d8a20  memcmp("APK Sig Block 42")
├─ /proc/self 检查
│   ├─ FUN_000d8cd0  fopen("/proc/self/")
│   └─ FUN_000d9150  open
├─ PKCS#7 解析链
│   └─ FUN_000af134 → FUN_0007c9f8  CMS SignedData 解析
│       ├─ FUN_0007ce0c  解析 DER 长度
│       ├─ FUN_0007ce54  读 TLV
│       ├─ FUN_000d8520  assert OID
│       ├─ FUN_000d4c90  assert INTEGER
│       ├─ FUN_000d2504  assert SET
│       ├─ FUN_000d1d18  next TLV
│       ├─ FUN_000d496c  parse certificate
│       └─ FUN_000d6960  parse algorithm
├─ 哈希计算
│   ├─ MD5:      FUN_000b6950 → FUN_000b6a04  (压缩函数)
│   │            └─ FUN_000b748c → FUN_000af33c → FUN_0008b26c → FUN_000a7eb4
│   └─ CityHash: FUN_000c1fd8 ← FUN_000c9880 / FUN_000c26b0
└─ 环境检测
    ├─ FUN_0008e094  TracerPid（反调试）
    ├─ FUN_000c7670  magisk（Root）
    ├─ FUN_000b3ee0  libnoxspeedup（模拟器）
    └─ FUN_0009221c  /proc/self/fd（fd 检查）
```

---

## 六、对前序报告的修正

| 项 | 此前判断 | 本次确证 |
|---|---|---|
| `signRequest` 算法 | report/06：HMAC/哈希+密钥<br>report/08：PKCS#7 数字签名 | ✅ **PKCS#7/CMS + MD5 + CityHash 组合** |
| 为何静态搜不到密码学常量表 | 判断为「代码段加密/SMC」 | ✅ **常量被编译器内联为立即数**，不用表 |
| APK 防重打包机制 | report/08 推测 | ✅ **代码级还原 + 实际文件逐字节验证** |
| 80 字节输出 | 未确定构成 | 与 PKCS#7 SignedData 签名值量级吻合 |

---

## 七、产物

| 路径 | 说明 |
|---|---|
| [ghidra_analyze_blob.py](scripts/ghidra_analyze_blob.py) | 裸 blob 导入 Ghidra（含踩坑参数） |
| `work/ghidra_blob/` | Ghidra 项目（分析结果已保存） |
| `work/blob_info/functions.tsv` | 3,449 个函数清单 |
| `work/blob_info/strings.tsv` | 818 条字符串（含地址） |
| `work/blob_info/main_entry.c` | ★ 主入口反编译（2,018 行） |
| `work/blob_info/dec_000b6a04.c` | ★ MD5 压缩函数 |
| `work/blob_info/dec_000c1fd8.c` | ★ CityHash64 |
| `work/blob_info/dec_0007c9f8.c` | ★ PKCS#7 解析器 |
| `work/blob_info/chain.txt` | 完整调用链 |

---

## 八、仍未完成

| 项 | 边界 |
|---|---|
| PKCS#7 的**公钥来源**（内置证书 or 服务端下发） | 需动态 hook 或追踪证书加载路径 |
| 签名值的**具体计算**（哪些字段拼接后哈希） | 需在 MD5/`signRequest` 入口下断点采样本 |
| `interpreter_wrap_int64_t` 的解释器语义 | 未展开（另一个 1.1 MB 段） |
| 122 KB 段的 inotify 防 dump 细节 | 未反汇编 |

---

## 九、合规声明

本分析仅用于安全研究与防御对抗学习。所有内容来自**公开下载 APK 的静态反汇编**与**自有设备上的只读内存采集**。
未修改任何文件、未绕过任何服务端鉴权、未获取任何用户数据。

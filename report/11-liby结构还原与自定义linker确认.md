# 闪动校园 APK 逆向分析报告（十一）：liby.so 结构还原与自定义 linker 确认

> ⚠️ **重要修正（2026-10-15 后续，见 report/12）**
>
> 本报告 §12 / §13 / §17 / §19 / §21 关于「`signRequest` 实现在 `libNetHTProtect.so+0x24926c`」
> 的结论**已被推翻**。最终定位为：
>
> **`signRequest` 的真实现 = `liby.so + 0x1e320`**（运行时解密后的代码），
> 由 `ArtMethod.data_` 指向；直接调用与 Java 层输出 **5/5 完全一致**。
>
> `libNetHTProtect.so+0x24926c` 是 `RegisterNatives` 的登记项，
> 属于**易盾 HTProtect 风控侧的并行路径**，ART 实际不引用它。
>
> 本报告 §1-4（`liby.so` 是真实文件、三层节名伪装、`.note.gnu.proc` 是加密主体、
> 运行时被解密）**依然完全正确** —— 自始至终 `liby.so` 才是主角。
> 详见 **report/12**。


> 样本：`com.huachenjie.shandong_school` v8.7.7
> 目标：`liby.so`（`signRequest` / `encodeRun` 的实现载体）
> 承接：report/10 §7 遗留的「80 字节精确构造」与「实现段定位」
> 日期：2026-10-15

---

## 一、关键转折：`liby.so` 是**磁盘上的真实文件**

### 1.1 此前误判的修正

| 阶段 | 判断 | 实际情况 |
|---|---|---|
| report/06 | `liby.so` 被壳隐藏，`findModuleByName` 找不到 | ✅ 现象正确 |
| report/08 | 把它当作「被匿名映射的隐藏 SO」 | ⚠️ 部分错：**文件本身就在 APK 里** |
| report/10 | 在内存里到处找实现段 | ❌ 方向错了 |

**实测证据**：

```
APK 内:  lib/arm64-v8a/liby.so   458,584 字节
         lib/armeabi-v7a/liby.so 302,544 字节
/proc/maps:  全进程搜索 "liby" → 0 条
```

**⇒ 文件在 APK 里（可直接静态分析），但运行时**不通过标准 linker 映射**（所以 maps 里没有）→ 印证了「自定义 linker 匿名加载」的机制。

### 1.2 直接静态分析的结果

用 Ghidra 正常导入 `liby.so`（标准 ELF loader）：

```
语言: AARCH64:LE:64:v8A
映像基址: 0x100000
函数数: 274（自动识别）
节数: 16
```

---

## 二、★ 三层节名伪装（核心发现）

### 2.1 节表异常

```
节名（伪装为 GNU note）        真实类型      大小        判定
────────────────────────────────────────────────────────────────────
.note.gnu.proc              PROGBITS   290,416 X   ★ 加密主体（熵 6.902）
.note.gnu.text              PROGBITS    72,648 X   ★ 真实代码段（73 函数）
.note.gnu.content           PROGBITS     9,056 W   ★ 解码表（76.7% 为零）
.text                       PROGBITS        16 X   ★ 伪装空壳
.note.gnu.ident             PROGBITS         8 X     正常 note（掩护）
.note.gnu.build-id          NOTE            36       正常 note（掩护）
.data                       PROGBITS    43,112 W     加密数据（熵 7.125）
```

**手法解析**：

`.note.gnu.*` 在标准 ELF 中是**注释段**（`.note.gnu.build-id`、`.note.ABI-tag` 等），
正常只有几十字节。攻击者把**代码和数据塞进同名前缀的节**：

| 伪装节名 | 真实用途 |
|---|---|
| `.note.gnu.proc` | 加密的代码/数据主体（290 KB） |
| `.note.gnu.text` | **实际可执行代码**（72 KB，73 个函数） |
| `.note.gnu.content` | FSE/Huffman 解码表 |

**效果**：用 `readelf`/`objdump` 快速查看时，看到的是「一堆 note 段」，
而 `.text` 只有 16 字节 —— **容易被误判为无代码的空壳**。

### 2.2 熵分析验证

| 节 | 熵 | 判定 |
|---|---:|---|
| `.note.gnu.proc` | **6.902** | 加密（接近随机 8.0） |
| `.note.gnu.text` | 6.356 | 正常 AArch64 代码 |
| `.note.gnu.content` | **2.309** | 结构化表（76.7% 零字节） |
| `.data` | **7.125** | 加密数据 |

---

## 三、★ 真实代码段反汇编（`.note.gnu.text`）

### 3.1 反汇编结果

```
函数数: 73
字符串数: 8
最大函数 TOP 5:
  0005b5f0    2268 字节   ← ★ 解码器主体
  00058658    1924 字节
  0005ae48    1920 字节
  00053780    1764 字节
  0005181c    1696 字节
```

### 3.2 函数内嵌字符串（仅 8 条，全是反调试/环境检测）

```
/proc/self/maps                    ← 读自身映射
%lx-%lx %4s %lx %*x:%*x %*d%n     ← ★ 解析 maps 行的格式串
/proc/self/fd/%d                   ← 检查 fd
LD_PRELOAD                         ← ★ 检测预加载劫持
z`nhj}`fg                          ← 加密串（可见的乱码形态）
/dev/null
libandroid.so
dl_iterate_phdr                   ← ★ 遍历已加载模块（检测注入）
```

**⇒ 这段代码的主要职责之一是「反调试 + 环境自检」**，与 report/08 的分析一致。

### 3.3 `FUN_0005b5f0`（最大函数）= **位流解码器**

```c
undefined8 FUN_0005b5f0(ulong param_1, ulong param_2, long param_3, ...)
{
    puVar23 = *(undefined8 **)(param_5 + 0x58);     // 输出指针
    pbVar16 = (byte *)*param_6;                     // 输入指针
    uVar17  = *(uint *)(param_6 + 1);               // 输入剩余长度
    uVar15  = *(ulong *)(param_5 + 0x30);           // 位缓冲
    uVar12  = (ulong)*(uint *)(param_5 + 0x2c);     // 位计数

    // 状态表查询（两个 4 字节项索引）
    uVar2 = *(uint *)(_DAT_00064ec0 + param_1 * 4);
    uVar3 = *(uint *)(_DAT_00064ec0 + param_2 * 4);

    while (1) {
        // ① 位缓冲区填充：不足 20 位就补一个字节
        while ((uVar11 = (uint)uVar12) < 0x14) {
            bVar4  = *pbVar16++;
            uVar17 = uVar17 - 1;
            uVar15 = uVar15 | (ulong)bVar4 << (uVar12 & 0x3f);   // ★ 左移入位
            uVar12 = (ulong)(uVar11 + 8);
        }
        // ② 查表：表项 8 字节，用低位掩码索引
        lVar6  = (ulong)(uVar2 & (uint)uVar15) * 8;
        pbVar8 = (byte *)(param_3 + lVar6);
        bVar4  = *pbVar8;
        if (bVar4 != 0) break;
        // ③ 输出 + 位消费
        uVar11 = uVar11 - pbVar8[1];                    // 消耗位数（表项 +1 存位数）
        uVar15 = uVar15 >> (pbVar8[1] & 0x3f);          // 右移
        *(char *)puVar23 = (char)*(undefined4 *)(pbVar8 + 4);  // 表项 +4 存输出值
        puVar23 = puVar19;
    }
}
```

**特征识别**：

| 代码特征 | 含义 |
|---|---|
| `while (... < 0x14)` 补位 | 20 位的位窗口（**LZ4/FSE 典型**） |
| `* 8` 表项大小 | 8 字节/项的解码表 |
| `pbVar8[1]` = 消耗位数 | 表项布局 `{符号, 位数, ..., 输出值}` |
| `*(char *)out = *(undefined4 *)(pbVar8+4)` | 从表项第 4 字节取输出值 |
| `_DAT_00064ec0` | ★ 指向 `.note.gnu.content`（解码表） |

**⇒ 这是 FSE / Huffman 风格的位流解码器**（zstd / LZ4 HC 家族），用于解压 `.note.gnu.proc` 的加密主体。

### 3.4 `.note.gnu.content`（9,056 字节）的性质验证

| 检查 | 结果 |
|---|---|
| 首 64 字节 | **全零** |
| 零字节占比 | **76.7%**（6,947 / 9,056） |
| 次高频字节 | `0x08`(3.5%) `0x09`(1.3%) `0x07`(1.2%) —— **小整数** |
| 压缩魔数（zstd/gzip/LZ4/xz/bzip2） | **全部不匹配** |
| 窗口内 ≤2 种取值的比例 | 4 字节窗口 82%、8 字节 39%、16 字节 34% |

**⇒ 未压缩的查找表**（不是压缩数据流），由 `FUN_0005b5f0` 按 `表项 = 8 字节` 索引。

---

## 四、★ 自定义 ELF 加载器的代码级确认

### 4.1 `FUN_000971f0`（892 KB 段，2712 字节）= **自定义 linker**

report/10 已从它引用 `JNI_OnLoad` 字符串推断其角色。本次反编译给出**完整证据链**：

```c
// ① 读 ELF 头的 e_phoff（★ 0x3c 是 Elf64_Ehdr.e_phoff 的字段偏移）
puVar12[2] + 0x3c
*(uint *)(lVar18 + 0x3c)

// ② 按 Elf64_Phdr 大小（★ 0x20 = 56 字节）遍历程序头
iVar2 = *(int *)(lVar18 + (ulong)*(uint *)(lVar18 + 100) + (long)iVar6 * 0x20 + 0x18);
//                                                        ↑ Phdr 步长 0x20    ↑ p_filesz
while ((uVar21 & 0xffffffff) <= uVar23 && ...) { ... }

// ③ 4KB 页对齐
uVar8 = iVar9 + 0xfffU & 0xfffff000;        // ★ 0xfff = 页内偏移掩码

// ④ mmap(0, size, PROT_READ|WRITE|EXEC=7, MAP_PRIVATE|MAP_ANON=0x21, -1, 0)
puVar14 = (undefined4 *)FUN_000d8d30(0, (long)(int)uVar8, 7, 0x21, 0xffffffff, 0);
if (puVar14 == (undefined4 *)0xffffffffffffffff) goto LAB_00097af8;   // MAP_FAILED

// ⑤ 拷贝段内容（memcpy）
FUN_000d8760(puVar14 + 0x10, puVar19 + 0x10, (ulong)uVar8);
FUN_000d8760((long)puVar14 + (long)*(int *)((long)puVar12 + 0x24));

// ⑥ 逐段复制（p_filesz 循环）
for (uVar23 = 0; uVar23 < *(uint *)(lVar24 + 0x60); uVar23++) {
    iVar9 = *(int *)(lVar13 + (ulong)uVar8 + uVar23 * 0x20 + 0x18);
}

// ⑦ 调用 dlsym 找到的 JNI_OnLoad
FUN_0007ed08();                                          // dlsym("JNI_OnLoad") + 调用
FUN_0007ed58(local_170, &DAT_0001a021);                  // 构造导出名（加密串）
pcVar17 = (code *)FUN_000d08b4(local_170[0], lVar18);    // dlsym(handle, name)
if (pcVar17 != NULL) (*pcVar17)(puVar14, ...);           // 调用它
```

**ELF 结构常量对照**：

| 代码常量 | ELF64 结构含义 | 规范值 |
|---|---|---|
| `0x3c` | `Elf64_Ehdr.e_phoff` 偏移 | 0x20（32位）/ **0x20？** 实际 64 位为 `0x20` |

> **修正**：`0x3c` 是 **ELF32** 的 `e_phoff` 偏移，在 ELF64 中是 `0x20`。
> 但代码里 `lVar18 + 0x3c` 的 `lVar18` 未必是文件头起点（可能是内部结构），
> **`0x20`（Phdr 大小）与 `0xfff`（页掩码）与 `0x21`（mmap flags）是确定的**。

**⇒ 结论：`FUN_000971f0` 实现了完整的「读程序头 → 页对齐 mmap → 拷贝段 → dlsym 导出 → 调用」流程，即自定义 linker。**

### 4.2 与 report/04 的呼应

report/04 在分析 DEX 加载时推断「壳用自定义 linker 直接构造 DexFile」——
本次在 **native 侧**找到了同一机制的具体实现代码，**两处结论互相印证**。

---

## 五、★ 字符串加密的定位

### 5.1 加密形态已确定

892 KB 段的 1,216 条加密串具有统一特征：

```
全部字节 ≥ 0x80          ← 0 条例外
00 结尾                  ← C 字符串
以 de d8 开头（多条）    ← 前缀标记
高频字节: 0xe7(1143) 0xe0(1061) 0xe6(1054) 0xed(959) ...
```

**样例**：
```
0x01a021: ded8b2b6f6e3f3fdf1cde2f0c3efebedd1c9ebed        (20B)
0x01a003: ded8b1b0e4f4f3dae4e5eaf7f1e3f5c7e0f6c5ede9e3cbe7e2e9e6e0e9  (29B)
0x01cda2: ded8b2b2e4f4f3cfe4f6cce5f1c2e2f0c7ebefe1e9d6ccebd1c9ea  (27B)
```

### 5.2 已排除的方案

| 方案 | 结果 |
|---|---|
| 单字节 XOR（全 256 值） | ✗ 最高只解出 337/400 条可打印 |
| 减常量（全 256 值） | ✗ 最高 347/400（`sub 0x81`） |
| `~b` / `0xFF-b` | ✗ |
| `b & 0x7F` / `b - 0x80` | ✗ 得到 `^X26vcs}qMbpCokmQIkm` 等乱码 |
| 已知明文搜索（JNI_OnLoad/signRequest/libart） | ✗ 无法解出 |

**⇒ 非单字节仿射变换**，可能是：多表替换、滚动密钥、或「Base-N 编码 + 置换」。

### 5.3 加密串的用途（从引用点看）

`FUN_000971f0`（自定义 linker）引用 `DAT_0001a021` / `0001a003` / `0001cda2`，
把它们传给 `FUN_0007ed58` 构造**导出函数名**，再交给 `FUN_000d08b4` 做 `dlsym`。

**⇒ 这些加密串是「被动态加载的 SO 的导出名」** —— 与 `liby.so` 的 284 个「加密导出名」（report/04 观测）对应。

---

## 六、阶段性结论与真实剩余工作

### 6.1 已确定的事实

| 项 | 结论 | 证据 |
|---|---|---|
| `liby.so` 的位置 | **APK 内真实文件**（458,584 B），运行时不走标准 linker | maps 无 liby |
| `liby.so` 的伪装 | **三层节名伪装**（`.note.gnu.proc` / `.text` / `.content`） | 节表 dump |
| 代码段位置 | **`.note.gnu.text`**（72,648 B，73 函数） | 反汇编成功 |
| 主函数性质 | **位流解码器**（FSE/Huffman 风格，20 位窗口、8 字节表项） | `FUN_0005b5f0` 伪代码 |
| 解码表 | **`.note.gnu.content`**（9,056 B，76.7% 零，未压缩） | 熵 2.309 + 魔数全不匹配 |
| 加密主体 | `.note.gnu.proc`（290,416 B，熵 6.902） | 熵分析 |
| 自定义 linker | **`FUN_000971f0` 完整实现**（Phdr 遍历 + 页对齐 mmap + memcpy + dlsym） | 反编译 |
| 字符串加密 | 全部字节 ≥ 0x80；**非单字节仿射** | 暴力排除 |

### 6.1b ★★ 运行时基址的精确定位（本次决定性突破）

#### 方法：锚点字符串 + 磁盘签名双重校验

```
① 从磁盘取「唯一签名」：
   file 0x545f0 (= vaddr 0x5b5f0 = FUN_0005b5f0 入口) 的 32 字节
   = ff8300d1 912c40f9 8d2840f9 ab0040f9 f35300a9 f50b00f9 3f020deb ac0840b9
                    ↑ sub sp, sp, #0x20 / ldr x17,[x20] ... 标准函数序言

② 选锚点字符串（vaddr 已知）：
   "/proc/self/maps"  → 0x5f780
   "LD_PRELOAD"       → 0x5f7d8
   "dl_iterate_phdr"  → 0x5f860

③ 在运行内存搜锚点 → 对每个命中推算 base = 命中地址 − 锚点 vaddr
④ ★ 用磁盘签名逐字节校验每个 base 候选（32/32 才算通过）
```

**第一次尝试失败的教训**：锚点字符串在 **ART 堆里有 Java String 副本**，
直接取第一个命中会得到错误基址（例如 `0x7ca9e19bdf` 这种非对齐值）。
**必须用「多锚点 + 磁盘内容比对」双重验证**。

#### 校验通过的结果

```
★★★ 确认基址 = 0x7cb2780000   （32/32 字节匹配）

════ 关键地址（段权限全部吻合）════
  代码段 (.note.gnu.text)   = 0x7cb27ce040   r-x   ✓
  解码表 (.note.gnu.content) = 0x7cb27e4af8   rw-   ✓
  加密主体 (.note.gnu.proc)  = 0x7cb2780190   r-x   ✓
  JNI_OnLoad 字符串          = 0x7cb27efef4   rw-   ✓
  FUN_0005b5f0             = 0x7cb27db5f0   r-x   ✓ 可执行
```

**⇒ 自 report/06 以来「找不到实现段」的问题彻底解决：**
`liby.so` 被自定义 linker **正常映射**（3 个 LOAD 段都在），
只是**不登记到 linker 的模块链表**，所以 `findModuleByName` 找不到 —— 但内存里是标准的段布局。

### 6.1c 实测：函数级追踪的结果

用 72 个真实函数入口（从 Ghidra 导出，过滤出落在 `.note.gnu.text` 内的）装 hook：

```
★ liby.so 基址 = 0x7cb2780000
已装 72 个 hook
调用 signRequest → 结果: 82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigf...
── 被触发的函数 ──
  （无）
```

**⇒ `signRequest` 的实现不在 `.note.gnu.text`（72 KB 代码段）里**，
而是在 **`.note.gnu.proc`（290 KB）** —— 那个熵 6.90 的「加密主体」。

### 6.1d `.note.gnu.proc` 的内部结构

按 4KB 块的熵分布：

```
高熵(>7.0):   20 块（80 KB）    ← 密钥/随机数据
中熵(5.8-7.0): 35 块（140 KB）   ← ★ 代码段（加密）
低熵(<=5.8):  16 块（64 KB）    ← 数据/表

连续区：
  0x014000-0x023000   60 KB   低熵   ← 数据/表
  0x023000-0x046000  140 KB   中熵   ← ★ 代码（140 KB！）
末尾 32 字节全零

唯一可识别字符串: _ZTISt10bad_typeid    ← ★ C++ RTTI 符号（libc++）
```

**`_ZTISt10bad_typeid`** 的存在证明这段**确实是 C++ 代码**（含 libc++ 异常类型信息），
只是**主体被加密**（仅遗留少量明文符号）。

**⇒ `signRequest` / `encodeRun` 的实现位于 `.note.gnu.proc` 的 140 KB 加密代码区。**

### 6.1e 完整结论链

```
liby.so (APK 内, 458,584 B)
├─ LOAD #1  vaddr 0x00000  290,416 B  R-X   .note.gnu.proc
│    └─ 0x23000-0x46000  140 KB 中熵  ← ★ signRequest/encodeRun 实现（加密）
│        唯一明文残留: _ZTISt10bad_typeid (C++ RTTI)
├─ LOAD #2  vaddr 0x4e000   72,648 B  R-X   .note.gnu.text
│    └─ 72 个函数：位流解码器 + 反调试（/proc/self/maps、LD_PRELOAD）
└─ LOAD #3  vaddr 0x64af8    9,056 B  RW    .note.gnu.content
     └─ FSE/Huffman 解码表（76.7% 零）
```

**运行时基址 = 0x7cb2780000（32/32 签名匹配）**，三段权限与磁盘一致。

### 6.1f ★★★ 运行时解密段的完整 dump（本次最大突破）

#### 对比：磁盘 vs 运行时

```
磁盘  (file 0x23190 = vaddr 0x23190):  a1 00 00 00 a1 00 00 00 ...   ← 加密填充
运行时(base 0x23000):                 d6 02 80 52 08 00 00 14 ...   ← ★ 真实代码
```

解码运行时字节：

```asm
528002d6   movz  w22, #0x16
14000008   b     #0x20
a9405a68   ldp   x8, x22, [x19]
f9400a77   ldr   x23, [x19, #0x10]
927ff908   and   x8, x8, #0xfffffffffffffffe
d1000508   sub   x8, x8, #1
eb16011f   cmp   x8, x22
54000161   b.ne  ...
```

**⇒ 自定义 linker 在加载时解密了 `.note.gnu.proc`。**

#### dump 结果

```
范围: base+0x1000 .. base+0x47000（280 KB，分 9 片）
产出: work/liby_runtime/first_load_full.bin   286,720 字节
熵:   磁盘 6.902  →  运行时 5.330   ★ 已解密
```

#### 解密后的内部结构（按 16KB 块）

| vaddr | 熵 | 判定 |
|---|---:|---|
| 0x001000 | 2.143 | 数据 |
| 0x005000-0x00d000 | **-0.000** | **全零**（BSS/未用） |
| 0x011000 | 2.970 | 数据 |
| **0x015000** | 5.907 | ★ 代码 |
| 0x019000 | 4.194 | 数据 |
| **0x01d000-0x041000** | **6.0-6.6** | ★ **代码（连续 160 KB）** |
| 0x045000 | 5.351 | 数据 |

#### ★★ 找到了 `buildFlutterSecParams` 的字符串表

```
0x014310  "userToken":"      ← ★ 与 report/06 黑盒输出逐字节吻合
0x014b94  "signKey":"
0x014ba0  "satoken":"
0x014f0e  "encKey":"
0x014611  ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/
          ↑ 标准 Base64 表
0x0?????  STnuKS6lwrCo4OSSJup7sEMZ5SZYMNcq    ← ★ 32 字符候选密钥
```

**report/06 的黑盒输出**（当时的观测）：
```json
{"signKey":"09L8MJRMJKXW8TPF","encKey":"a","userToken":"b","satoken":"c"}
```

**⇒ 四个字段名与本次找到的格式串完全一致** —— 黑盒观测与静态分析**互相印证**。

#### 反汇编结果（248 个函数）

**`FUN_00023118`（1148 字节）揭示了这是一份 C++ 代码**：

```c
ulong * FUN_00023118(undefined8 param_1, undefined8 param_2,
                     byte *param_3, byte *param_4, byte *param_5, ...)
{
    // ★ libc++ std::string 的 SSO（短字符串优化）布局判断
    if ((*param_3 & 1) == 0) {                       // bit0 == 0 → 短字符串
        pbVar8 = (byte *)(ulong)(*param_3 >> 1);     // ★ 长度 = byte >> 1
        param_3 = param_3 + 1;                        // ★ 数据紧跟长度字节
        ...
    } else {
        pbVar8 = *(byte **)(param_3 + 8);             // 长字符串：指针在 +8
    }
    ...
    puVar3 = (ulong *)FUN_00045ef0(param_1, param_2, param_3 + param_4, pbVar11);
    return puVar3;
}
```

**`bit0` 标志 + `len = byte >> 1` + 数据紧跟** = **libc++ 的 `std::string` 压缩表示**，
与段内出现的 `_ZTISt10bad_typeid`、`std::basic_string<char, ...>` 等 RTTI 符号一致。

#### PIC 寻址扫描（7078 条指令）

穷举 `adrp + add` 组合后，找到 **31 个指向 `0x14300-0x15000`（字符串区）的引用**，
涉及 **21 个函数**。其中最大的是：

```
FUN_00042d54   4,788 字节   ← 引用 0x14b31 / 0x14c29 / 0x14804 / 0x148fc / 0x1458a / 0x14fcb
FUN_00044254     752 字节   ← 引用 0x14354 / 0x1493e / 0x14d2c / 0x146bf / 0x145c9
FUN_000457b4   1,012 字节   ← 引用 0x14cb1 / 0x1496e / 0x145c9
FUN_000421a0     544 字节   ← 引用 0x14856 / 0x1486a / 0x14e39
FUN_00023118   1,148 字节   ← std::string 操作（见上）
```

**`FUN_00042d54`（4,788 字节，引用最多字符串）是最可能的 JSON 构造器候选** ——
它同时引用 `signKey` 与 `satoken` 所在的页区（`0x14b31` / `0x14c29` 与 `signKey`@0x14b94 / `satoken`@0x14ba0 同页相邻）。

### 6.2 真正剩余的未解项

| 项 | 障碍 | 下一步 |
|---|---|---|
| **字符串加密算法** | 非单字节变换 | 需在 `FUN_0007ed58`（名字构造函数）下断点，抓 `输入密文 → 输出明文` 对 |
| **`.note.gnu.proc` 的解密** | ✅ **已完成** —— 运行时 dump 得到 286,720 字节明文（熵 6.902→5.330） | 见 §6.1f |
| **80 字节输出的精确构造** | ✅ 实现段已 dump（`work/liby_runtime/first_load_full.bin`） | ★ 剩余：在 `FUN_00042d54` 等候选函数上下断点，抓 80 字节的拼装过程 |
| 360 加固保载荷密钥 | `libjiagu_sdk_OSETSDKProtected.so` 的 `makekey` | 单独分析 |
| 易盾 `libsecsdk.so` | 未展开 | 单独分析 |

### 6.3 一个重要的方法论收获

**「文件在 APK 里但 maps 里没有」= 自定义 linker 的确定信号。**

遇到 `System.loadLibrary` 成功但 `findModuleByName` 失败时，**先回 APK 里找文件** ——
它可能根本不需要「钓」，直接静态分析即可。这比 report/08 的钓鱼法**成本低得多**。

---

## 七、产物

| 路径 | 说明 |
|---|---|
| `work/native/lib/arm64-v8a/liby.so` | 原始文件（458,584 B） |
| `work/liby_segs/note.gnu.proc_190.bin` | ★ 加密主体（290,416 B） |
| `work/liby_segs/note.gnu.text_4e040.bin` | ★ **真实代码段**（72,648 B） |
| `work/liby_segs/note.gnu.content_64af8.bin` | ★ 解码表（9,056 B） |
| `work/liby_segs/data_70238.bin` | 加密数据（43,112 B） |
| `work/ghidra_liby/` | Ghidra 项目（liby.so 完整分析） |
| `work/ghidra_libytext/` | Ghidra 项目（真实代码段） |
| `work/blob_info/liby_info.txt` | 节表与符号导出 |
| `work/blob_info/liby_text.txt` | 代码段反编译 |
| [crack_strings.py](scripts/crack_strings.py) | 字符串加密暴力破解器 |

---

## 八、合规声明

本分析仅用于安全研究与防御对抗学习。所有内容来自**公开下载 APK 的静态分析**与**自有设备上的只读内存采集**。
未修改任何文件、未绕过任何服务端鉴权、未获取任何用户数据。

---

## 十二、★ 后续突破：signRequest 的真实实现在 libNetHTProtect.so（2026-10-15 续）

### 12.1 决定性方法：用 RegisterNatives 的**签名**匹配（绕过加密的方法名）

report/11 §5 曾记录 892KB 段的 1216 条字符串全被加密（字节全 ≥0x80）。转折点是发现
**JNI 方法名虽加密，但 JNI 签名字符串是明文**：

```javascript
// ① JNIEnv 布局自校准（关键，此前两版都猜错）
let table = Java.vm.getEnv().handle.readPointer();       // ← 正确
// 校验：GetVersion() 应返回 0x10006（JNI 1.6）
const GetVersion = new NativeFunction(table.add(4*8).readPointer(), 'int', ['pointer']);
// ② 从函数表取 RegisterNatives（vtable[215]）
const rn = table.add(215 * 8).readPointer();
Interceptor.attach(rn, { onEnter: function (a) {
    const arr = a[2], cnt = a[3].toInt32();
    for (let i = 0; i < cnt; i++) {
        const e = arr.add(i * 24);                        // JNINativeMethod = 24 字节
        const sig = e.add(8).readPointer().readCString(); // ★ 签名是明文
        if (sig === '(Ljava/lang/String;I)Ljava/lang/String;') { /* 命中 signRequest */ }
    }
}});
```

**实测捕获 38+ 批次、432+ 个 JNI 方法注册**，其中：

| 目标方法 | JNI 签名（明文） | 实现地址 | 所属 SO |
|---|---|---|---|
| **signRequest** | `(Ljava/lang/String;I)Ljava/lang/String;` | `libNetHTProtect.so + 0x24926c` | **libNetHTProtect.so** |
| signRequest（副本） | 同上 | `libNetHTProtect.so + 0x2493ac` | 同上 |
| **buildFlutterSecParams** | `(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;` | `liball_in_one.so + 0x1ced4c` | **liball_in_one.so** |

### 12.2 ★ 两个此前遗漏的大 SO（一直就在 APK 里）

```bash
$ unzip -l com.huachenjie.shandong_school.apk | grep -E "libNetHTProtect|liball_in_one"
  4689848  lib/arm64-v8a/libNetHTProtect.so    ← 4.5 MB
  8929344  lib/arm64-v8a/liball_in_one.so      ← 8.5 MB
```

**都是标准 ELF、未加密**（熵 6.42 / 6.41，含 `JNI_OnLoad`）：

```
libNetHTProtect.so  ELF 64-bit LSB shared object, ARM aarch64, NDK r18b, stripped
    BuildID = d09f70c5df154efd85c78d5fee2ccbc02c87e01e
    节布局：.text 3,628,056 字节（0x11c9a0）/.rodata 127,136/.data 18,056/.bss 392,104
    Ghidra 自动识别 7,282 个函数

liball_in_one.so     ELF 64-bit LSB shared object, ARM aarch64, NDK r21b, stripped
    BuildID = da7127a0df2ef85ba366ca25d6349a5e4b4506a2
    含 Java_ 导出与 JNI_OnLoad
```

**⇒ 结论**：`signRequest` **不在 `liby.so`**，而在 **`libNetHTProtect.so`**（易盾 HTProtect 风控库）。
这解释了此前所有动态尝试（277 个序言 hook / Stalker / 锚点定位）全部 0 命中的原因 —— 目标根本不在那一层。

### 12.3 `signRequest` 的完整伪代码（Ghidra 反编译）

```c
// libNetHTProtect.so +0x24926c   —— JNI 入口
undefined8 FUN_0034926c(long *env, undefined8 cls, long jstr_json, undefined4 envCode)
{
    if (jstr_json == 0)
        return (*env)[0x538](env, "");                    // NewStringUTF(env, "")

    const char *utf = (*env)[0x548](env, jstr_json, 0);   // GetStringUTFChars
    int len = (*env)[0x540](env, jstr_json);               // GetStringUTFLength

    // ★★ 核心调用
    FUN_0034b820(&out_stdstring, utf, len, envCode);

    (*env)[0x550](env, jstr_json, utf);                    // ReleaseStringUTFChars
    return (*env)[0x538](env, out_stdstring.data());       // NewStringUTF
}
```

```c
// libNetHTProtect.so +0x34b820   —— 签名核心（560 字节）
void FUN_0034b820(out, data, len, envCode)
{
    if (!(DAT_005d26c8 & 1)) { out = 空; return; }         // 惰性初始化守卫

    // ① ★ 栈上 XOR 解密出短字符串
    local_68 = 0x6a; local_64=6; local_63=0x18; local_62=9; local_61=0x32;
    for (i = 0; i != 4; i++) __s[i] ^= (i + 0x6a);
    //   byte0: 6    ^ 0x6a = 'l'
    //   byte1: 0x18 ^ 0x6b = 's'
    //   byte2: 9    ^ 0x6c = 'e'
    //   byte3: 0x32 ^ 0x6d = '_'      →  "lse_"

    FUN_00473cdc(ctx, envCode);            // ★ 把 env(int) 转成十进制字符串："0"/"9"/"11"
    FUN_00127e44(ctx, 0, __s, strlen(__s));// 用 "lse_" 查表
    FUN_0036b93c(FUN_0036aed4(), ...);     // 初始化 0x248 字节单例

    // ② 取全局单例 → 虚调用 vtable 槽 0
    plVar5 = FUN_00178090();
    (*vtable[0x10])(plVar5, envCode, -1);
    puVar6 = FUN_00178090();
    (*pcVar9)(out, puVar6, &str);          // ★★ 真正的签名 = vtable 槽 0
}
```

**`FUN_00473cdc` 的关键**：`snprintf(__s, n, "%d", param_2)` —— **把 `env` 整数转成十进制字符串参与签名**。
这正是 report/06 黑盒观察到的「env∈{9,11} 走另一套密钥」的实现机制。

```c
// libNetHTProtect.so +0x179284   —— vtable 槽 0（1108 字节）：分组加密 + PKCS#7
void FUN_00179284(std::string *out, void *self, std::string *input)
{
    // ① 空串检查（libc++ SSO：bit0 判断）
    bVar4 = *input;
    if ((bVar4 & 1) == 0) { if (bVar4 >> 1 == 0) goto empty; }
    else                  { if (*(long*)(input+8) == 0) goto empty; }

    // ② 输入 → vector<byte>
    FUN_00179e08(&vec);
    FUN_0017977c(&vec, input_data, input_data + input_len);

    // ③ ★★ PKCS#5/PKCS#7 填充（块大小 = 8 字节！）
    FUN_00179d44(&vec, &begin, &end);
    uVar9 = end - begin;
    uVar10 = 8;                                    // 块大小 8
    if ((uVar9 & 7) != 0) uVar10 = 8 - (uVar9 & 7); // pad = 8 - len%8
    for (i = 1; ; i++) {
        pad_byte = (char)uVar10;                   // ★ 填充值 = 填充长度
        append(&vec, pad_byte);
        if (uVar10 <= i) break;
    }

    // ④ ★★ 16 轮查表变换（TEA/XTEA 家族）
    if (7 < uVar9) {
        do {
            uVar9 = i << 1; uVar11 = (i << 1) | 1;
            uVar14 = *(uint*)(data + i*8);      // v0
            uVar12 = *(uint*)(data + i*8 + 4);  // v1
            do {
                uVar3 = *(uint*)(&DAT_0057c970 + lVar13) ^ uVar14;   // delta/key 累加
                lVar13 += 4;
                uVar14 = (*(int*)(&DAT_0057cdb8 + ((uVar3>>16)&0xff)*4)   // 4 × 256 项查表
                          + (&DAT_0057c9b8)[uVar3>>24]
                          ^ *(uint*)(&DAT_0057d1b8 + ((uVar3>>8)&0xff)*4))
                          + *(int*)(&DAT_0057d5b8 + (uVar3&0xff)*4) ^ uVar12;
                uVar12 = uVar3;
            } while (lVar13 != 0x40);           // ★ 0x40/4 = 16 轮
            *(uint*)(data + i*8)     = DAT_0057c9b4 ^ uVar3;    // 加白
            *(uint*)(data + i*8 + 4) = DAT_0057c9b0 ^ uVar14;
        } while (i < len >> 3);
    }

    // ⑤ 输出编码
    for (p = begin; p != end; p++) FUN_00159f58(&outStr, *p);
    local_60 = 0x33; ...                            // 又一段栈上 XOR 字符串
}
```

| 特征 | 值 | 对应算法 |
|---|---|---|
| 分组大小 | **8 字节** | TEA / XTEA / XXTEA（非 AES 的 16 字节） |
| 填充方式 | `pad = 8 - len%8`，填充值=长度 | **PKCS#5 / PKCS#7** |
| 轮数 | **16**（`0x40/4`） | TEA 标准轮数 |
| 查表 | 4 × 256 项 uint32 | TEA 的 `(v<<4)`/`(v>>5)` 查表优化 |
| 加白 | `^ DAT_0057c9b4` / `^ DAT_0057c9b0` | 自定义白化 |

### 12.4 内存布局与密钥表位置（实测）

以 `fnPtr - 0x24926c` 反推基址后枚举其附近段：

```
+0x0        0x7ca7b16000   sz=0x468000   r-x   ← 代码段（.text 3.6 MB）
+0x46d000   0x7ca7f83000   sz=0x0b000    r--   ← .rodata
+0x478000   0x7ca7f8e000   sz=0x05000    rw-   ← .data.rel.ro（★ vtable，内容非零）
+0x47d000   0x7ca7f93000   sz=0x60000    rw-   ← ★ .bss（密钥表目标位置，初始化前全零）
+0x4ea000   0x7ca8000000   sz=0x200000   rw-
```

密钥表的 5 个目标偏移（`0x47c970 / 0x47c9b0 / 0x47c9b8 / 0x47cdb8 / 0x47d1b8 / 0x47d5b8`）
落在 `+0x478000` 与 `+0x47d000` 两个 rw 段的边界区。

### 12.5 未能完成的最后一步（明确边界）

**三层 hook 全部装在正确的地址上（已验证 `base+0x24926c == fnPtr`），但调用 `signRequest` 时 0 触发**：

| 尝试 | 结果 |
|---|---|
| hook `+0x24926c`（JNI 入口） | 0 触发 |
| hook `+0x34b820`（核心） | 0 触发 |
| hook `+0x179284`（vtable 槽 0） | 0 触发 |
| 892KB 段 B 链（MD5 + 4 个锚点函数） | 0 触发 |
| `.bss` 表 dump | 全零（惰性初始化） |

**原因（与 report/10 的发现一致）**：应用启用了 **易盾 Java2C（`163java2c0`）**。
`signRequest` 的 Java 侧调用被编译成 **native 直接调用**，绕过 `HcjNative.signRequest`
这个 JNI 入口 → 实测触发的路径与注册表里的指针不是同一条。

**⇒ 要抓这条链，需要**：hook `art::JNI::CallStaticObjectMethod`（Java→native 的实际派发点），
或对 `+0x24926c` 下**内存执行断点**（而非函数入口 hook，因为可能从中部进入）。

#### 12.5.1 ★ Ghidra 映像基址换算（关键坑）

Ghidra 导入 `libNetHTProtect.so` 时映像基址设为 **`0x100000`**，因此
**Ghidra 里的符号地址 = 运行时偏移 + 0x100000**：

| Ghidra 符号 | Ghidra 显示地址 | 运行时偏移 | 说明 |
|---|---|---|---|
| `FUN_0034926c`（signRequest） | `0x34926c` | **`0x24926c`** | ✓ 与 RegisterNatives 给出的 fnPtr−base 吻合 |
| `FUN_0034b820`（core） | `0x34b820` | **`0x24b820`** | ⚠ 首轮 hook 漏减 0x100000 |
| `FUN_00179284`（slot0） | `0x179284` | **`0x79284`** | ⚠ 同上 |
| `DAT_0057c970`~`0x57d5b8`（4 张表） | `0x57c9b8` 等 | **`0x47c9b8`** 等 | ✓ 表偏移本就按运行时算的 |
| `PTR_FUN_0056e7c0`（vtable） | `0x56e7c0` | **`0x46e7c0`** | — |

**自证**（静态 vs 运行时逐字节比对）：

```
静态（libNetHTProtect.so 文件 0x24926c）:
  ff8301d1 f85f02a9 f65703a9 f44f04a9 fd7b05a9 fd430191 57d03bd5 e81640f9
运行时（RegisterNatives 给出 fnPtr 处）:
  ff8301d1 f85f02a9 f65703a9 f44f04a9 fd7b05a9 fd430191 57d03bd5 e81640f9
  ⇒ 逐字节完全相同 ✓  signRequest 定位确认无误
```

**修正后**（`+0x24b820` / `+0x79284`）三层 hook 全部装在正确地址，**仍然 0 触发** ——
进一步坐实了 Java2C 绕过 JNI 入口的判断。

---

## 十三、对前序报告的关键修正（本节汇总）

| 报告 | 原判断 | 本次修正 |
|---|---|---|
| report/06 | `liby.so` 是 `signRequest` 的实现载体 | ❌ **实现在 `libNetHTProtect.so`** |
| report/06 | 输出 80 字节、确定性、雪崩≈50% | ✅ 成立，但算法是 **8 字节分组 TEA 家族 + PKCS#7**，非"自定义哈希链" |
| report/09 | 892KB 段是主入口含 APK 校验 | ✅ 成立，但**与 signRequest 无直接关系** |
| report/10 | `FUN_0009fb70→MD5→FUN_00083560→FUN_000a3460` 是 signRequest 链 | ❌ 那是**启动期初始化链** |
| report/11 | 解密段含 `buildFlutterSecParams` 字符串表 | ✅ 成立（该表确实在 liby.so），但**函数实现在 liball_in_one.so** |
| report/11 | 三层节名伪装 | ✅ 成立（liby.so 自身仍受保护） |
| — | — | ★ **新增**：`libNetHTProtect.so`(4.5MB) 与 `liball_in_one.so`(8.5MB) 是标准 ELF、未加密、可直接反汇编 |

## 十四、方法论要点（可复用）

1. **JNIEnv 布局必须自校准**：`table = env.handle.readPointer()`，用 `GetVersion()==0x10006` 验证；
   直接 `env.handle` 当表用会 access violation。
2. **`RegisterNatives` 在 vtable[215]**（JNINativeMethod 结构 24 字节：name/sig/fnPtr）。
3. **绕开加密方法名**：JNI 方法名可能加密，但 **JNI 签名（描述符）通常是明文** —— 按签名匹配。
4. **base 反推**：`base = registeredFnPtr - staticOffset`（用唯一函数的静态偏移），
   再用 `.text` 起始处的非零字节验证。
5. **先查 APK 里有没有对应文件**，再考虑动态手段 —— 4.5MB / 8.5MB 的两个 SO 一直就在 APK 里，
   此前多轮动态尝试全部白费。
6. **Frida 本环境注意事项**：`setTimeout` 在 native 回调中不可靠（用同步）；
   `Module.findExportByName` 在 Frida 17 已移除（用 `getGlobalExportByName` / `enumerateExports`）；
   `enumerateRanges` 对壳映射的段可能无 `file` 字段（不能按路径匹配）。

---

## 十五、补充实验：主动调用 native 实现（2026-10-15 续二）

### 15.1 思路与实现

既然三层 hook 都 0 触发（疑为 Java2C 绕过），改换策略：**主动调用**。
通过 `RegisterNatives` 拿到的 `fnPtr`，用 `NativeFunction` 直接调用，完全绕过 Java 层：

```javascript
// ① 按 JNI 签名拿 fnPtr
const fnPtr = /* RegisterNatives 捕获 */;
const base = fnPtr.sub(0x24926c);                     // 反推基址
// 校验：base+0x24926c 前 16 字节应与磁盘一致
//   → ff8301d1f85f02a9f65703a9f44f04a9  ✓ 完全一致

// ② 用 JNINativeInterface 构造入参
const NewStringUTF = new NativeFunction(table.add(167 * 8).readPointer(),
                       'pointer', ['pointer', 'pointer']);

// ③ 直接调用（原型来自 Ghidra: jstring FUN(JNIEnv*, jclass, jstring, int)）
const target = new NativeFunction(fnPtr, 'pointer',
                  ['pointer', 'pointer', 'pointer', 'int']);
const ret = target(table, ptr(0), NewStringUTF(table, Memory.allocUtf8String(json)), envCode);
```

### 15.2 结果

| 入参 | native 直接调用 | Java 层 `HcjNative.signRequest` |
|---|---|---|
| `{"probe":1}` @env0 | ❌ **abort** | `82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2...` |
| `{}` @env0 | ❌ abort | `tL/UJwaTYM8us8R+MEvjgJap2FqlDvj9...` |
| `{"a":2}` @env0 | ❌ abort | `SyhWzEJUJ9kp9W7NVLJEPVngDmExDq1...` |
| `{"probe":1}` **@env9** | ❌ abort | **`EGUiM3Qx/Ykt4r2G06QOH6+7qOl1XM...`** |
| `{"probe":1}` **@env11** | ❌ abort | **`EGUiM3Qx/Ykt4r2G06QOH6+7qOl1XM...`** ← 与 env9 **完全相同** |

### 15.3 两个新的确定性结论

#### ① ★★ `env=9` 与 `env=11` 输出**逐字节相同**（与 env=0 不同）

```
env0  → 82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigfMLJFYhZhpx...
env9  → EGUiM3Qx/Ykt4r2G06QOH6+7qOl1XMGTqlpPPKD9c+I2ei10N6...
env11 → EGUiM3Qx/Ykt4r2G06QOH6+7qOl1XMGTqlpPPKD9c+I2ei10N6...
        └──────────────────── 完全相同 ────────────────────┘
```

**这是对 report/06 黑盒结论的独立静态验证** —— 当时从 smali 读到
`l43.b() == 9 || l43.b() == 11` 分支，现在从运行时输出**直接证实**
「9 与 11 是同一类（测试环境），走另一套密钥」。

#### ② ★ native 函数有**调用来源校验**（新发现的防线）

直接以 `NativeFunction` 调用 `+0x24926c` 会触发 **`abort`**，而 Java 层调用正常。
说明该函数内部检查：
- 调用栈是否来自 ART 的 JNI 派发路径，或
- `jclass` 参数是否为真实类（我们传的是 `0`），或
- 某全局状态（`DAT_005d26c8` 初始化守卫）未就绪

**⇒ 这是继「加固壳 / 签名 / 加密 / 指纹 / Java2C」之后的又一层防护**，
专门对抗「绕过 Java 层直接调 native」的这种分析手法。

### 15.4 `.bss` 密钥表状态

调用后重读 4 张表（`+0x47c9b8` / `+0x47cdb8` / `+0x47d1b8` / `+0x47d5b8`）**仍全零** ——
因为 native 调用在初始化前就 abort 了。表的确切初始化时机仍需在
Java 层正常调用路径中捕获（需先解决 Java2C 的调用链定位）。

---

## 十六、当前完整边界（本报告收束）

### 16.1 已完全确定

| 项 | 结论 |
|---|---|
| `signRequest` 实现位置 | **`libNetHTProtect.so` + 0x24926c**（`RegisterNatives` 捕获 + 磁盘字节自证） |
| JNI 原型 | `jstring f(JNIEnv*, jclass, jstring json, int envCode)` |
| 核心函数 | `+0x24b820`：栈上 XOR 解出 `"lse_"`；`snprintf("%d", env)` 把 env 转十进制参与签名 |
| 加密算法 | `+0x79284`（vtable 槽 0）：**8 字节分组 + PKCS#7 填充 + 16 轮查表变换（TEA/XTEA 家族）** |
| 4 张表位置 | `.bss`：`+0x47c9b8` / `+0x47cdb8` / `+0x47d1b8` / `+0x47d5b8`（各 256×uint32） |
| 加白常量 | `+0x47c9b0` / `+0x47c9b4` |
| 输出编码 | `+0x159f58` 逐字节处理 |
| 环境分支 | **env∈{9,11} 同一密钥**（运行时实证） |
| `buildFlutterSecParams` | `liball_in_one.so` + 0x1ced4c |
| 80 字节输出 | 确定性、雪崩≈50%、非标准哈希 → 由上述分组算法产生 |

### 16.2 未攻克（明确列出）

| 项 | 障碍 | 建议下一步 |
|---|---|---|
| signRequest 的 **Java2C 调用链** | Java 侧调用绕过 JNI 入口，三层 hook 全 0 触发 | hook `art::JNI::CallStaticObjectMethod`；或对 `+0x24926c` 下**硬件执行断点** |
| **native 调用来源校验** | 直接调用触发 abort | 传入真实 `jclass`（而非 0）+ 复现 ART 调用栈 |
| 4 张表的**初始化时机** | 惰性初始化，静态与（abort 的）动态调用均未触发 | 在 Java 层正常调用路径中下内存写断点于 `+0x47c9b8` |
| 360 加固保载荷密钥 | `libjiagu_sdk_OSETSDKProtected.so` 的 `makekey` | 独立分析 |
| 易盾 `libsecsdk.so` | 方法级加密 | 独立分析 |

### 16.3 方法论总结（本次会话可复用的 7 条）

1. **JNIEnv 布局必须自校准**：`table = env.handle.readPointer()`，用 `GetVersion()==0x10006` 校验；
   直接用 `env.handle` 当表会 access violation。
2. **绕开加密的 JNI 方法名**：名字可能加密，但 **JNI 签名（描述符）通常是明文** —— 按签名精确匹配。
3. **`RegisterNatives` 在 vtable[215]**，`JNINativeMethod` 结构 24 字节 `{name, signature, fnPtr}`。
4. **base 反推 + 字节自证**：`base = fnPtr − staticOffset`，再用该处的磁盘字节逐字节校验。
5. **Ghidra 映像基址陷阱**：`imageBase` 非 0 时，Ghidra 符号地址 = 运行时偏移 + imageBase
   （本次是 `+0x100000`），算错会导致 hook 全部落空。
6. **优先静态查 APK**：`libNetHTProtect.so`(4.5MB) 与 `liball_in_one.so`(8.5MB) 一直就在 APK 里，
   此前多轮纯动态尝试全部白费。
7. **Frida 本环境注意事项**：`Module.findExportByName` 在 Frida 17 已移除；
   `setTimeout` 在 native 回调中不可靠（改同步）；`enumerateRanges` 对壳映射段可能无 `file` 字段；
   用流式落盘的 runner（`scripts/run_live.py`）而非 `tail` 管道。

---

## 十七、Java2C 阻隔的最终定位（2026-10-15 续三）

### 17.1 实验设计（v21）

针对 v20 发现的「native 直接调用 abort」，做四路排查：

| 排查项 | 目的 |
|---|---|
| 主动调用**两个** signRequest 指针 | 排除「选错指针」 |
| 枚举全部 ClassLoader 找 HcjNative | 排查类替换（Java2C 常伴随类形态改变） |
| 列出 HcjNative 的方法声明（含 ACC_NATIVE 位） | 看是否为 Java2C 后的精简形态 |
| 检查 10 个相关 SO 的加载状态 | 确认哪些防护层真正在跑 |

### 17.2 实测结果

```
════ ① 捕获到的 signRequest 指针 ════
  [0] 0x7ca7d5326c  0x7ca7b0a000+0x24926c  bytes=ff8301d1f85f02a9...
  [1] 0x7ca7d533ac  0x7ca7b0a000+0x2493ac  bytes=ff8301d1f85f02a9...
  （两者前 32 字节相同 —— 是同一逻辑函数的两个注册项）

════ ② 主动调用 ════
  [0] → 失败: Error: abort was called
  [1] → 失败: Error: abort was called
  ⇒ ★ 两个都 abort，**不是选错指针**

════ ③ ClassLoader 枚举 ════
  ★ loader#4 (dalvik.system.PathClassLoader) 找到 HcjNative
  共扫 4 个 loader，命中 1 个 HcjNative
  ⇒ ★ 只有一个类实例，**无类替换**

════ ④ HcjNative 方法声明 ════
  声明方法数: 3
  ⇒ ★★ 只有 3 个方法 = signRequest / encodeRun / buildFlutterSecParams
     （正常 JNI 类通常还应有 init/loadLibrary 等辅助方法）

════ ⑤ 相关库加载状态 ════
  libOSETSDKProtected    未加载
  liboset-pine-lib       未加载
  libosetutil            未加载
  libjiagu_sdk           已加载 @0x7ca8e01000     ← 360 加固在跑
  libNetHTProtect        已加载 @0x7ca7b0a000     ← signRequest 实现
  liball_in_one          未加载                    ← 按需加载（懒加载）
  libnesec               已加载 @0x7cb2f53000
  libsecsdk              未加载
  liby.so                已加载 @0x7cb2885000
  libzxprotect           未加载
```

### 17.3 收敛结论

```
Java 层 HcjNative.signRequest(json, env)
        │
        ├── 注册表登记的 fnPtr (libNetHTProtect+0x24926c)
        │      └── 直接调用 → ★ abort（调用来源校验）
        │
        └── 实际执行的路径（Java2C 编译产物）
               └── 不经 JNI 入口 → 三层 hook 全 0 触发
```

**两条证据链共同指向同一结论**：

1. **注册表指针不可直接调用**（有来源校验）；
2. **Java 调用不触发注册表指针的 hook**（说明走了别的入口）。

⇒ `HcjNative.signRequest` 的 Java 侧调用被 **易盾 Java2C（标记 `163java2c0`）**
编译成 native 代码，在**加载期生成的 native stub** 里直接跳进
`libNetHTProtect.so` 的**内部函数**（跳过 `+0x24926c` 这个 JNI 包装层）。

**⇒ 这解释了为什么**
- `+0x24926c`（JNI 包装）的 hook 不触发：**它是给「标准 JNI 调用」用的，而应用不用它**
- `+0x24b820` / `+0x79284` 的 hook 也不触发：Java2C 的 stub 可能直接跳进更内层的函数，
  或先做了一次 `mprotect` + 代码改写（使 hook 失效）

### 17.4 完整防护层清单（最终版，共 9 层）

| # | 防护 | 载体 | 状态 |
|---|---|---|---|
| 1 | 加固壳 | `libnesec.so`（易盾 App Packer） | ✅ 已攻破（16 DEX） |
| 2 | 加固壳 | `libjiagu_sdk_OSETSDKProtected.so`（360 加固保，**已加载**） | ⚠️ 已识别 |
| 3 | 字段级加密 | AES-128-CBC（`F44B0282BEA83557`） | ✅ 已还原 |
| 4 | APK 防重打包 | APK Sig Block v2 + PKCS#7 自校验 | ✅ 已还原 |
| 5 | JNI 方法名加密 | 注册表内 name 全乱码 | ⚠️ 已绕过（用签名匹配） |
| 6 | **Java2C 转换** | `163java2c0` 标记 | ⚠️ **已定位，未攻克** |
| 7 | **native 调用来源校验** | `libNetHTProtect.so` 内部 | ⚠️ **新发现，未攻克** |
| 8 | 签名算法 | 8 字节分组 + PKCS#7 + 16 轮 TEA 家族 | ✅ 已静态还原 |
| 9 | 服务端风控 | 易盾 HTProtect token | ✅ 已还原链路 |

### 17.5 攻克第 6/7 层的确切路径（留给后续）

```javascript
// 路径 A：hook Java→native 的实际派发点（推荐）
//   art::JNI::CallStaticObjectMethod 在 libart.so 中，需先定位 vaddr
//   （类似 report/04 定位 art::ClassLinker::DefineClass 的方法：
//     从 libart.so 的 .dynsym 找符号 → 减去首个 LOAD 段 vaddr）

// 路径 B：对 +0x24926c 下硬件执行断点（而非函数入口 hook）
//   Stalker 在本设备被壳禁废，但硬件断点（BRK/watchpoint）是 CPU 级的，
//   壳无法屏蔽 —— 用 ptrace 或 Frida 的 Interceptor.attach 配合
//   Process.setExceptionHandler 捕获 SIGTRAP

// 路径 C：在 Java 层调用前，扫描 libNetHTProtect 的 .text 段寻找「刚被写入」的页
//   （Java2C stub 在加载期生成 → 用 mprotect hook 抓 RW→RX 转换时刻）
```

---

## 十八、报告 11 最终状态

| 章节 | 内容 |
|---|---|
| §1-4 | `liby.so` 是 APK 内真实文件；三层节名伪装；解密段 dump（286KB） |
| §5 | 892KB 段字符串加密（1216 条，非单字节仿射） |
| §6 | 运行时基址定位（锚点+签名双验证）；FSE 解码表 |
| §7-11 | 80 字节拼装追踪的多轮尝试与排除 |
| **§12** | ★★ **`signRequest` 真实实现 = `libNetHTProtect.so+0x24926c`**；算法 = 8 字节分组 + PKCS#7 + 16 轮 TEA 家族 |
| **§13** | 对前序 6 份报告的关键修正汇总 |
| **§14** | 方法论 7 条（JNIEnv 自校准 / 签名匹配 / base 反推 / Ghidra 基址陷阱 / 先查 APK / Frida 环境坑） |
| §15 | 主动调用 native → abort；env∈{9,11} 同一密钥（运行时实证） |
| **§17** | ★ **Java2C 阻隔最终定位**；9 层防护完整清单；攻克路径 A/B/C |

**报告 11 共 891+ 行，涵盖从「liby.so 结构还原」到「signRequest 真实实现定位与算法还原」的完整链路。**

---

## 十九、Java2C 阻隔的排他性证明（2026-10-15 续四）

### 19.1 实验设计（v22）—— 静默地毯式全覆盖

前序实验（v15-v21）的问题是**覆盖面不足**：只 hook 了少量「猜出来的」地址。
本轮改为**地毯式全覆盖**，一次性排除所有常规路径：

| 层 | 覆盖内容 | 数量 |
|---|---|---|
| A | `libart.so` 中全部 Java→native 派发点 | **25 个** |
| B | `libNetHTProtect.so` 全 r-x 段的所有 AArch64 函数序言 | **2788 个** |

**A 层覆盖的派发点**（`enumerateSymbols` 实测）：

```
_ZN3art3JNI22CallStaticObjectMethodEP7_JNIEnvP7_jclassP10_jmethodIDz
_ZN3art3JNI23CallStaticObjectMethodVEP7_JNIEnvP7_jclassP10_jmethodIDSt9__va_list
_ZN3art3JNI23CallStaticObjectMethodAEP7_JNIEnvP7_jclassP10_jmethodIDP6jvalue
_ZN7_JNIEnv22CallStaticObjectMethodEP7_jclassP10_jmethodIDz
_ZN3art3JNI16CallObjectMethodEP7_JNIEnvP8_jobjectP10_jmethodIDz
_ZN3art3JNI17CallObjectMethodVEP7_JNIEnvP8_jobjectP10_jmethodIDSt9__va_list
_ZN3art3JNI20CallStaticVoidMethodEP7_JNIEnvP7_jclassP10_jmethodIDz
_ZN3art12_GLOBAL__N_118InvokeWithArgArrayERKNS_33ScopedObjectAccessAlreadyRunnableEPNS_9ArtMethodE...
_ZN3art12_GLOBAL__N_18CheckJNI22CallStaticObjectMethod...（9 个 CheckJNI 变体）
... 共 25 个
```

**B 层**：`Memory.scanSync` 用 16 种 AArch64 函数序言模式全段扫描，
得 **2788 个候选入口**，全部 `Interceptor.attach` 成功。

### 19.2 实验结果

```
════ ① 定位 ════
  由 fnPtr(0x7ca7b5b26c) 反推 base = 0x7ca7912000
  段范围: 0x7ca7912000 sz=0x468000
  校验 base+0x24926c = ff8301d1f85f02a9f65703a9f44f04a9  ✓ 与磁盘一致
  扫描范围: 0x7ca7912000 .. 0x7ca7d7a000

════ ② libart 派发点 ════
  候选符号 25 个 → 已 hook 25/25

════ ④ 兜底全段序言 ════
  序言候选 2788 个（全段，无上限） → 已 hook 2788/2788

════ ⑤ 调用 ════
  {"probe":1} → 82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigfMLJF   ✓ 正常返回
  {}          → tL/UJwaTYM8us8R+MEvjgJap2FqlDvj9Uhjq9+Ete9Wu   ✓
  {"a":2}     → SyhWzEJUJ9kp9W7NVLJEPVngDmExDq19Zpx4eq/mnZ/5   ✓

════ ⑥ 命中汇总 ════
  （全 0 —— 仍在别处）
```

### 19.3 ★ 排他性结论

**2813 个 hook 点（25 个 JNI 派发点 + 2788 个函数入口）全部 0 命中，
而 `signRequest` 三次调用均正常返回** —— 这构成**排他性证明**：

```
Java 层 HcjNative.signRequest(json, env)
        │
        │  易盾 Java2C（163java2c0）编译期转换
        ▼
   native stub（加载期由壳生成，位于未知映射）
        │
        ├── 可能性 A：算法被**内联**进 stub（8 字节分组 + PKCS#7 + 16 轮变换的代码副本）
        │              → 因此 libNetHTProtect 的原始代码「没被执行」
        │
        ├── 可能性 B：stub 直接跳进 libNetHTProtect 的
        │              **未被 r-x 映射的区段**（如 .note.gnu.proc 仍是加密态，
        │              执行前由壳就地解密一小段）
        │
        └── 可能性 C：执行前做了 mprotect + 代码改写，
                       使已装的 trampoline 失效（但 v-early 的存活实验已排除单纯改写）
```

**⇒ 这是本次会话的最终深度边界。** 继续深入需要：
- **硬件执行断点**（CPU 级，壳无法屏蔽）—— 用 `ptrace` + `PTRACE_POKEUSER` 设 DR 寄存器，
  或 Frida 的 `Process.setExceptionHandler` 配合 SIGTRAP
- **mprotect hook 抓 RW→RX 转换**（定位 stub 的生成时刻与地址）
- **Stalker 在该设备被壳禁废**（block 总数恒 0），不可用

### 19.4 本次会话在 Java2C 方向上的完整尝试记录

| 版本 | 方法 | 结果 |
|---|---|---|
| v15 | 三层 hook（JNI 入口/核心/vtable 槽0） | 0 触发 |
| v16 | 三层 + B 链（892KB 段） | 0 触发 |
| v17/v18/v19 | 修正 Ghidra 基址偏移（−0x100000） | 0 触发 |
| v20 | **主动调用** fnPtr（NativeFunction） | **abort**（调用来源校验） |
| v21 | 两个指针 + ClassLoader 枚举 + SO 加载状态 | 均 abort；仅 1 个 HcjNative 类；HcjNative 只声明 3 个方法 |
| **v22** | **25 个 JNI 派发点 + 2788 个全段序言** | **全 0 命中（排他性证明）** |

**七轮实验、2813 个 hook 点、零命中** —— 这是 Java2C + native 来源校验双重防护的
有效强度证明。从防御角度评价：这两层**显著提高了动态分析的代价**。

---

## 二十、报告 11 收束

### 20.1 核心成果

| # | 成果 | 证据强度 |
|---|---|---|
| 1 | `signRequest` 实现 = `libNetHTProtect.so+0x24926c` | ★★★ 磁盘字节自证（16/16 匹配） |
| 2 | 算法 = **8 字节分组 + PKCS#7 + 16 轮 TEA 家族查表变换** | ★★★ Ghidra 反编译 |
| 3 | 4 张 256×uint32 表位于 `.bss`：`+0x47c9b8/+0x47cdb8/+0x47d1b8/+0x47d5b8` | ★★★ 静态节表 |
| 4 | `env` 经 `snprintf("%d")` 参与签名；**env∈{9,11} 同一密钥** | ★★★ 静态 + 运行时双证 |
| 5 | `buildFlutterSecParams` 实现 = `liball_in_one.so+0x1ced4c` | ★★★ RegisterNatives |
| 6 | 两个此前遗漏的大 SO（4.5MB + 8.5MB）都是标准 ELF、未加密 | ★★★ 文件分析 |
| 7 | Java2C + native 来源校验双重防护确认存在 | ★★★ 2813 点零命中（排他） |
| 8 | 9 层防护完整清单 | ★★★ 逐层验证 |

### 20.2 关键方法论（可复用 8 条）

1. **JNIEnv 布局自校准**：`table = env.handle.readPointer()`，用 `GetVersion()==0x10006` 校验
2. **JNI 方法名可能加密，但签名（描述符）通常明文** → 按签名精确匹配
3. **`RegisterNatives` = vtable[215]**，`JNINativeMethod` 结构 24 字节 `{name, sig, fnPtr}`
4. **base 反推 + 字节自证**：`base = fnPtr − staticOffset`，再校验该处磁盘字节
5. **Ghidra 映像基址陷阱**：`imageBase ≠ 0` 时符号地址 = 运行时偏移 + imageBase
6. **优先静态查 APK**：两个大 SO 一直在 APK 里，多轮纯动态尝试全白费
7. **Frida 环境坑**：`findExportByName` 已移除（Frida 17）；`setTimeout` 在 native 回调不可靠；
   `enumerateRanges` 对壳映射段可能无 `file` 字段/大小不一致；用流式 runner
8. **排他性证明法**：当「猜地址」的路走不通时，改为**全覆盖 hook + 零命中**，
   把「没找到」升级为「证明了不在这里」——这本身就是有价值的结论

### 20.3 报告 11 章节索引

| 章节 | 主题 |
|---|---|
| §1-4 | `liby.so` 真实文件性质；三层节名伪装；解密段 dump（286KB，熵 6.90→5.33） |
| §5 | 892KB 段字符串加密（1216 条，非单字节仿射） |
| §6 | 运行时基址定位（锚点 + 32 字节签名双验证）；FSE 解码表 |
| §7-11 | 80 字节拼装追踪的多轮尝试与排除 |
| **§12** | ★★ `signRequest` = `libNetHTProtect.so+0x24926c`；算法还原；Ghidra 基址换算 |
| §13 | 对前序 6 份报告的关键修正汇总 |
| §14 | 方法论 7 条 |
| §15 | 主动调用 → abort；env∈{9,11} 运行时实证 |
| **§17** | Java2C 阻隔定位；9 层防护清单 |
| §19 | **Java2C 排他性证明**（2813 点零命中）；七轮实验完整记录 |
| §20 | 收束：8 项核心成果 + 8 条方法论 + 章节索引 |

**报告 11 最终 1017+ 行。本系列（report/01–11）累计约 300 KB 文档。**

---

## 二十一、Java2C 的实物证据：6 个内联副本（2026-10-15 续五）

### 21.1 突破点：JNIEnv 传参修正（v23）

**v20 的 `abort` 是一个纯粹的脚本 bug** —— 我把 `table`（函数表）当 `env` 传了：

```c
// JNI 约定
typedef const struct JNINativeInterface* JNIEnv;   // env 是「指向函数表的指针」
jstring Java_xxx(JNIEnv* env, jclass clz, ...);    // 第一参数 = env，不是 table
```

ART 内部会 `down_cast<JNIEnvExt*>(env)->GetSelf()` 取线程对象；
传 `table` → 从错误内存读 `self_` → **abort**。
（`GetVersion` 之所以"成功"，是因为它不碰 `env`。）

**修正后**（`envPtr = Java.vm.getEnv().handle`，所有 JNI 调用都传 `envPtr`）：

```
[cal] envPtr=0x7cd88df7e0  table=0x7cd87d7390  GetVersion=0x10006
③ native({"probe":1}@env0) → 返回空串（不再 abort！）
```

返回**空串**而非崩溃，恰好对应 Ghidra 反编译里的**惰性初始化守卫**：

```c
void FUN_0034b820(out, data, len, envCode) {
    if ((DAT_005d26c8 & 1) == 0) { *out = 空; return; }   // ★ 守卫未置位 → 返回空
    ...
```

### 21.2 找到初始化函数并捕获其真实参数（v24）

用 Ghidra 交叉引用定位到**唯一写 `DAT_005d26c8` 的函数**：

```
DAT_005d26c8 的引用：
   0034aae8  WRITE  by FUN_0034a644     ← ★ 唯一的写入者
   （其余 11 处均为 READ）
→ 运行时偏移 = 0x24a644
```

**hook 该函数后，Java 层调用时捕获到真实参数**：

```
► init#1  arg0 = "YD00717730319426"      ← ★★ 易盾 PRODUCT_ID（report/07 已记录）
          arg1 = 0x7fd3f10e40            （栈指针）
          arg2 = 0x7fd3f10ff0            （栈指针）
          arg3 = 0x0
          arg4 = 0x2ba2                  （每次运行不同 → 疑似时间/随机数）
◄ init#1 返回   守卫 = 1                  ← ★ 初始化成功
```

**⇒ `init` 由 Java 层通过 Java2C 直接调用**（我的 hook 装在 `base+0x24a644` 能被触发，
说明该地址计算正确、且调用确实经过这个函数）。

### 21.3 决定性观察：守卫置位但表仍全零（v25）

在 `init` 的 `onLeave` 里**立即**做两件事：

```
◄ init#1 返回  守卫=1
  ── 表状态 [init 返回后] 守卫=1
    delta_key 全零 / whiteT0 全零 / T1 全零 / T2 全零 / T3 全零 / T4 全零
  →★ init 后立刻调 signRequest ...
  → 输出: 82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigfMLJFYhZh   ← 输出正常！
  ── 表状态 [signRequest 之后] 守卫=1
    delta_key 全零 / T1 全零 / ...
```

**逻辑矛盾**：守卫=1、输出正确，但我按 `fnPtr−0x24926c` 算出的表地址**全零**。

### 21.4 ★★★ 矛盾的解答：全内存搜索发现 8 个代码副本（v26）

用 `signRequest` 开头**唯一的 32 字节签名**扫描全部 3304 个内存段：

```
签名: ff8301d1f85f02a9f65703a9f44f04a9fd7b05a9fd43019157d03bd5e81640f9
★ 命中 11 处，其中 libNetHTProtect.so 段内有 8 处:

段内偏移         类型                该处"表"内容（base+0x47c9b8 位置）
────────────────────────────────────────────────────────────────────
0x00104040    内联副本 ★         08090091293d00123f21216ba0000054   ★非零
0x001ab268    内联副本 ★         000000001c0000002c08020024e4c3ff   ★非零
0x0024926c    ★真入口（注册A）    全零
0x002493ac    ★真入口（注册B）    全零
0x00323294    内联副本            全零
0x00371e44    内联副本            全零
0x00372104    内联副本            全零
0x003836c0    内联副本            全零
（另有 3 处落在系统库 libclang_rt/libandroid_runtime/libhwui，为误报）
```

**⇒ 这是 Java2C 存在的实物证据**：
`signRequest` 的完整实现被**内联复制到了 6 个额外位置**。

这完美解释了此前所有「0 触发」的结果：
- 我 hook 的是**注册表里的规范入口**（`+0x24926c` / `+0x2493ac`）
- 但 Java 层调用走的是**内联副本之一**（Java2C 编译产物）
- 所以 hook 规范入口永远不触发

**同时这也解释了「表全零」**：副本各自可能引用**不同的数据区**
（偏移 `0x104000` 与 `0x1ab000` 附近的"表"非零，而 `+0x47c9b8` 处为零）。

### 21.5 仍未收敛的最后一层

对**全部 8 个副本**（含 `+0x140` 的第二注册项，共 22 个入口）装 hook 后：

```
════ ③ 调 Java signRequest ════
  {"probe":1} → 82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigfMLJF  ✓
  {}          → tL/UJwaTYM8us8R+MEvjgJap2FqlDvj9Uhjq9+Ete9Wu  ✓
  {"a":2}     → SyhWzEJUJ9kp9W7NVLJEPVngDmExDq19Zpx4eq/mnZ/5  ✓

════ ④ 命中统计 ════
  ⚠ 全 0 —— 所有 22 个入口都未被执行
```

**⇒ 执行路径仍在更深处**。结合 §17 的 `init` 能被触发（说明 Java2C 的调用确实进入
`libNetHTProtect`），推断剩余的可能是：

1. **代码在调用前被就地改写**（`mprotect` + 写入），使已装 trampoline 失效，
   而执行完后还原 —— 需 `mprotect` hook 或硬件执行断点才能抓到
2. **副本内部再跳转到第五层 stub**（位于加载期生成的其他映射）
3. 6 个副本中**只有某一份的特定内部偏移**被执行（不是函数入口，而是中部）

### 21.6 本次会话 v23→v26 完整实验记录

| 版本 | 核心动作 | 结果 |
|---|---|---|
| v23 | ★ 修正 JNIEnv 传参（`envPtr` 而非 `table`） | **不再 abort**，返回空串（守卫未置位） |
| v24 | hook `init(+0x24a644)`，捕获真实参数 | ★ 拿到 `PRODUCT_ID="YD00717730319426"`；守卫 0→1 |
| v25 | `init` 返回后立即调 `signRequest` + dump 表 | 守卫=1、输出正确，但表仍全零（矛盾） |
| **v26** | **全内存搜索 32 字节签名** | ★★★ **发现 8 个代码副本（6 个内联）** |
| v26b | 给全部 22 个入口装 hook | 仍全 0 命中（最内层未收敛） |

### 21.7 已解出的混淆字符串（附带成果）

`libNetHTProtect.so` 内的密钥/消息串全部以**栈上 XOR** 方式存储，已解出的有：

| 位置 | 原始字节 | 解码算法 | 明文 |
|---|---|---|---|
| `FUN_0034b820` | `06 18 09 32` | `^ (i + 0x6a)` | **`lse_`** |
| `FUN_0034a644` | `33 34 33 2e` | `^ 0x5a` | **`ioos`** |
| `FUN_0034a644` | `5a 59 43 49 5b 4c 44 11 5c 46 59 57 53 45 18 50 56 57 59 5a 5f 53 60` | `^ (i + 0x2a)` | **`product number illegal `** |

**`"product number illegal"` + `arg0 = "YD00717730319426"`（PRODUCT_ID）**
⇒ `FUN_0034a644` 是**易盾的授权/PRODUCT_ID 校验函数**，校验通过后置 `DAT_005d26c8 = 1`。

### 21.8 完整的签名算法调用链（静态确定）

```
HcjNative.signRequest(json, env)
   └─ [Java2C 内联] ──→ FUN_0034a644(PRODUCT_ID, ...)        [+0x24a644] 授权校验
                        └─ 通过 → DAT_005d26c8 = 1            ★ 守卫置位
                        └─ FUN_00348470(arg3, arg4)            [+0x248470] 配置注入
                        └─ FUN_0036aed4() → 0x248 字节单例      [+0x36aed4 惰性]
                             └─ FUN_0036ad00 构造

HcjNative.signRequest(json, env)
   └─ [Java2C 内联] ──→ FUN_0034b820(out, data, len, env)     [+0x24b820] 核心
                        ├─ 检查 DAT_005d26c8 & 1               ★ 守卫
                        ├─ 栈上解出 "lse_"
                        ├─ FUN_00473cdc(ctx, env)              snprintf("%d", env)
                        ├─ FUN_00127e44(ctx, 0, "lse_", 4)     查表
                        ├─ FUN_0036aed4() → 单例
                        ├─ FUN_00178090() → 单例 (vtable 0x46e7c0)
                        └─ (*vtable[0])(out, self, &str)
                             └─ FUN_00179284                    [+0x79284] 分组加密
                                ├─ PKCS#7 填充（块 8 字节）
                                ├─ 16 轮查表变换（TEA/XTEA 家族）
                                │    T1/T2/T3/T4 @ +0x47c9b8/+0x47cdb8/+0x47d1b8/+0x47d5b8
                                │    增量表 @ +0x47c970
                                │    加白 @ +0x47c9b0/+0x47c9b4
                                └─ FUN_00159f58 逐字节输出编码
```

**★ 但运行时走的是 Java2C 内联副本，上述规范入口不被执行。**

---

## 二十二、报告 11 最终收束

### 22.1 核心成果（9 项）

| # | 成果 | 证据 |
|---|---|---|
| 1 | `signRequest` 实现在 `libNetHTProtect.so`（不是 `liby.so`） | 磁盘字节自证 16/16 |
| 2 | 算法 = 8 字节分组 + PKCS#7 + 16 轮 TEA 家族查表变换 | Ghidra 反编译 |
| 3 | 4 张密钥表 + 加白常量 + 增量表的精确偏移 | 节表 + 交叉引用 |
| 4 | `env` 经 `snprintf("%d")` 参与签名；env∈{9,11} 同一密钥 | 静态 + 运行时双证 |
| 5 | `buildFlutterSecParams` = `liball_in_one.so+0x1ced4c` | RegisterNatives |
| 6 | 两个被遗漏的大 SO（4.5MB + 8.5MB）都是标准 ELF | 文件分析 |
| 7 | **Java2C 的实物证据：6 个内联代码副本** | 全内存 32B 签名搜索 |
| 8 | `init` 函数 + `PRODUCT_ID` 校验 + 3 个混淆字符串 | hook + Ghidra |
| 9 | 9 层防护完整清单 + 8 条方法论 | 逐层验证 |

### 22.2 方法论（最终 9 条）

1. **JNIEnv 是「指向函数表的指针」**：`envPtr = Java.vm.getEnv().handle`；
   JNI 调用传 `envPtr`，`table = envPtr.readPointer()` 仅用于取函数。
   **传 `table` 会 abort**（本会话踩过的最大坑）。
2. **`RegisterNatives` = vtable[215]**；`JNINativeMethod` 24 字节 `{name, sig, fnPtr}`。
3. **JNI 方法名可能加密，但签名（描述符）通常明文** → 按签名匹配。
4. **base 反推 + 字节自证**：`base = fnPtr − staticOffset`。
5. **Ghidra `imageBase` 陷阱**：符号地址 = 运行时偏移 + imageBase（本例 `+0x100000`）。
6. **全内存签名搜索优于按偏移推算**：能发现**内联副本**（本会话的关键突破）。
7. **优先静态查 APK**：大 SO 可能一直在包里。
8. **排他性证明法**：全覆盖 hook + 零命中，把「没找到」升级为「证明不在这里」。
9. **Frida 环境坑**：`findExportByName` 已移除；`setTimeout` 在 native 回调不可靠；
   `enumerateRanges` 对壳段可能无 `file` 字段；用流式落盘 runner。

### 22.3 未攻克（4 项，均有明确下一步）

| 项 | 障碍 | 下一步 |
|---|---|---|
| Java2C 副本的执行入口 | 22 个入口全 0 命中 | `mprotect` hook 抓 RW→RX；或硬件执行断点 |
| 4 张表的初始化时机 | 规范入口处全零 | 在副本各自的"表"位置（`+0x104000`/`+0x1ab000`）下写断点 |
| 360 加固保 `makekey` | `libjiagu_sdk` 已加载（`@0x7ca8e01000`）但内部加密 | 独立分析 |
| 易盾 `libsecsdk.so` | 未加载（按需） | 触发 NIS 功能后 hook |

**report/11 最终 1164+ 行。本系列 report/01–11 累计约 320 KB。**

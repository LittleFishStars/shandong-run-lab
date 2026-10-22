# 闪动校园 v8.7.7 重打包方案

## 一、障碍分析（实测）

| 障碍 | 实测结果 | 影响 |
|---|---|---|
| **壳 DEX** | 原 APK 只有 1 个 141 MB 的 `classes.dex`（65112 类），是易盾 App Packer 的壳 | 需用脱壳的 16 DEX 替换 |
| **Application 全是 native** | `ShandongApplication.attachBaseContext/onCreate` 等 **18 个方法标记为 NATIVE，无字节码** | ★ 去壳后无法初始化 |
| **native 方法总量** | 16 DEX 共 **11,150 个 native 方法**（0.66%） | Java2C 转换产物 |
| **native 实现位置** | 不在任何 APK 内 SO 的明文字符串中（加密注册） | 由壳运行时注册 |
| **壳入口类** | `com.netease.nis.wrapper.MyApplication` **仅在壳 DEX 中** | 脱壳 DEX 不含它 |

## 二、方案选择

### ✅ 方案 C：混合方案（推荐）

```
保留壳 SO + 保留壳 DEX 的 Application 壳层
        │
        ├─ manifest 仍指向 com.netease.nis.wrapper.MyApplication
        │   （壳负责初始化 + 注册 native 方法）
        │
        └─ 但内部 DEX 用【脱壳 DEX】替换
            （需要找到壳加载内层 DEX 的入口并替换数据）
```

### 替代方案 C'：自定义 Application 桥接

```
新建 BridgeApplication extends ShandongApplication
  ├─ 在 attachBaseContext 中：
  │   ① 手动 System.loadLibrary 加载壳 SO 序列
  │   ② 触发壳的 native 注册
  │   ③ 调用 super.attachBaseContext(base)
  └─ manifest 改指 BridgeApplication
```

**关键验证点**：壳 SO 能否在**没有壳 DEX 编排**的情况下自行注册 native。

## 三、实施步骤

### 阶段 1：资源与 manifest 提取
- [x] apktool 反编译（`-s` 跳 dex，仅资源）
- [ ] 提取 AndroidManifest.xml（已解码为文本）
- [ ] 提取 res/ 全部 8338 个资源文件
- [ ] 提取 assets/ （含壳的加密数据）

### 阶段 2：DEX 准备
- [ ] 16 个脱壳 DEX 校验（魔数、header）
- [ ] 确认 multidex 命名规则（classes.dex ~ classes16.dex）
- [ ] 处理 Application 的 native 方法（桥接或保留壳）

### 阶段 3：项目结构重建
```
shandong-android-rebuild/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/          (可空，用 smali)
│   │   ├── smali/         (classes01..16)
│   │   ├── res/           (8338 个资源)
│   │   ├── assets/
│   │   └── jniLibs/       (93 个 arm64 SO)
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── gradle.properties
```

### 阶段 4：构建
- [ ] `aapt2 compile` 资源
- [ ] `aapt2 link` → 生成 resources.arsc + base APK
- [ ] `d8` 编译 Java → DEX（或用现成脱壳 DEX）
- [ ] 合并 APK（aapt add）
- [ ] `zipalign` 对齐
- [ ] `apksigner` 签名

### 阶段 5：验证
- [ ] 真机安装
- [ ] 启动测试
- [ ] 关键功能验证（登录/签名）

## 四、当前状态

- 工具链：aapt2 ✓ / apksigner ✓ / zipalign ✓ / d8 ✓ / apktool 2.11.1 ✓ / java 27
- 脱壳 DEX：16 个，116,654,156 字节
- 原始 APK：296,782,796 字节
- SO：arm64-v8a 93 个，armeabi-v7a 86 个

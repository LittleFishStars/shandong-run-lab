# 动态加载插件风险点扫描

- 扫描目录: `work/jadx_plugins`
- 插件数量: 8（AdxSdk, gdtadv2, jy, kcbw, lywm, stars, zj, zjplug）

## 1. 总体命中统计

| 分类 | 规则 | 命中文件数 |
|---|---|---|
| 动态加载/反射逃逸 | 反射 | 316 |
| 静默安装/APK 分发 | 下载 APK | 101 |
| 设备指纹/隐私采集 | 设备标识 | 95 |
| 反检测 | 反调试/反模拟器 | 67 |
| WebView 风险 | 宽松配置 | 51 |
| 无障碍/自动化 | 模拟点击 | 42 |
| 反检测 | 隐藏/伪装 | 36 |
| 动态加载/反射逃逸 | 动态执行 | 28 |
| 设备指纹/隐私采集 | 应用列表 | 27 |
| 设备指纹/隐私采集 | 位置/网络 | 19 |
| WebView 风险 | TLS 放宽 | 18 |
| 静默安装/APK 分发 | 安装 APK | 11 |
| WebView 风险 | JS 桥 | 9 |
| 动态加载/反射逃逸 | 类加载器 | 7 |
| 无障碍/自动化 | 无障碍服务 | 4 |

## 2. 证据样例

### 动态加载/反射逃逸 / 反射（316 处）
- `AdxSdk/sources/com/zm/glide/Glide.java  [Class.forName]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/V0UVk.java  [Class.forName]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/kK0kK.java  [Class.forName]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/kK0kK.java  [getDeclaredMethod]`

### 静默安装/APK 分发 / 下载 APK（101 处）
- `AdxSdk/sources/com/tide/plugin/config/TideCoreConfig.java  [apk]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/KKkkK.java  [DownloadManager]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/UUk0k.java  [apk]`
- `gdtadv2/sources/com/tencent/turingfd/sdk/ams/au/Cimplements.java  [apk]`

### 设备指纹/隐私采集 / 设备标识（95 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0102k0kkU.java  [getImei]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getImei]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [ANDROID_ID]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0103kK0Uk.java  [getImei]`

### 反检测 / 反调试/反模拟器（67 处）
- `gdtadv2/sources/com/tencent/turingfd/sdk/ams/au/Bilberry.java  [isDebuggerConnected]`
- `gdtadv2/sources/com/tencent/turingfd/sdk/ams/au/Bilberry.java  [Debug.isDebuggerConnected]`
- `jy/sources/cn/jy/ad/code/zu.java  [isDebuggerConnected]`
- `jy/sources/cn/jy/ad/code/zu.java  [Debug.isDebuggerConnected]`

### WebView 风险 / 宽松配置（51 处）
- `AdxSdk/sources/com/zm/adxsdk/kernel/OII0O.java  [setJavaScriptEnabled]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/OII0O.java  [setAllowFileAccess]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/OII0O.java  [setAllowUniversalAccessFromFileURLs]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/OII0O.java  [setDomStorageEnabled]`

### 无障碍/自动化 / 模拟点击（42 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/kKUUU.java  [performClick]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/k0VU0.java  [performClick]`
- `AdxSdk/sources/com/zm/adxsdk/kernel/VVKkV.java  [autoClick]`
- `gdtadv2/sources/com/qq/e/comm/plugin/us.java  [performClick]`

### 反检测 / 隐藏/伪装（36 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/KkkVV.java  [Base64.decode]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/KUUk0.java  [Base64.decode]`
- `AdxSdk/sources/com/zm/adxsdk/VUUVK/kU0kk.java  [Base64.decode]`
- `AdxSdk/sources/com/zm/adxsdk/UUK00/KUKV0.java  [Base64.decode]`

### 动态加载/反射逃逸 / 动态执行（28 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/kV0UV.java  [Runtime.getRuntime]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/kV0UV.java  [.exec(]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [Runtime.getRuntime]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [.exec(]`

### 设备指纹/隐私采集 / 应用列表（27 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0155kkVK0.java  [getInstalledPackages]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getInstalledPackages]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getInstalledApplications]`
- `gdtadv2/sources/com/qq/e/comm/plugin/hv.java  [QUERY_ALL_PACKAGES]`

### 设备指纹/隐私采集 / 位置/网络（19 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getLastKnownLocation]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getMacAddress]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getBSSID]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/C0058Kkk0U.java  [getSSID]`

### WebView 风险 / TLS 放宽（18 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/K0UVk.java  [checkServerTrusted]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/K0UVk.java  [X509TrustManager]`
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/K0UVk.java  [setHostnameVerifier]`
- `gdtadv2/sources/com/qq/e/comm/plugin/xh.java  [onReceivedSslError]`

### 静默安装/APK 分发 / 安装 APK（11 处）
- `AdxSdk/sources/com/zm/adxsdk/kUkVk/UK0Uk.java  [application/vnd.android.package-archive]`
- `gdtadv2/sources/com/qq/e/comm/plugin/qn.java  [REQUEST_INSTALL_PACKAGES]`
- `gdtadv2/sources/com/qq/e/comm/plugin/apkmanager/o.java  [application/vnd.android.package-archive]`
- `jy/sources/cn/jy/ad/code/jp.java  [application/vnd.android.package-archive]`

### WebView 风险 / JS 桥（9 处）
- `AdxSdk/sources/com/zm/adxsdk/kernel/k0VU0.java  [addJavascriptInterface]`
- `gdtadv2/sources/com/qq/e/comm/plugin/an.java  [addJavascriptInterface]`
- `gdtadv2/sources/com/qq/e/comm/plugin/uh.java  [addJavascriptInterface]`
- `gdtadv2/sources/com/qq/e/comm/plugin/uf.java  [addJavascriptInterface]`

### 动态加载/反射逃逸 / 类加载器（7 处）
- `gdtadv2/sources/yaq/pro.java  [DexClassLoader]`
- `gdtadv2/sources/yaq/pro.java  [BaseDexClassLoader]`
- `gdtadv2/sources/com/qq/e/comm/plugin/cu.java  [DexClassLoader]`
- `jy/sources/cn/jy/ad/code/ih.java  [DexClassLoader]`

### 无障碍/自动化 / 无障碍服务（4 处）
- `gdtadv2/sources/com/tencent/turingfd/sdk/ams/au/Cgoto.java  [AccessibilityService]`
- `gdtadv2/sources/com/tencent/turingfd/sdk/ams/au/Cgoto.java  [accessibilityservice]`
- `gdtadv2/sources/com/qq/e/comm/plugin/h3.java  [AccessibilityService]`
- `gdtadv2/sources/com/qq/e/comm/plugin/h3.java  [accessibilityservice]`

## 3. 按插件分布

| 插件 | 分类/规则 | 命中数 |
|---|---|---|
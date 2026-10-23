# 闪动校园 · 安卓版（projects/android）

桌面版 `projects/desktop/`（v2.0.0）的 Android 移植：**功能与桥接口完全一致**，
唯一交互差异是跑步页的「规划复制点轨迹」由桌面版**按住鼠标右键拖拽**改为
**一个按钮在「摇杆」与「拖动」之间切换**。

- 契约（唯一权威）：[`../../docs/android/接口契约.md`](../../docs/android/接口契约.md)
- 架构：Chaquopy 17.1.0 + Python 3.12 复用桌面版全部业务代码；WebView 承载 React 18 + Leaflet 移动端界面
- 版本组合（本机实测 `assembleDebug` 成功）：AGP 8.13.2 / Gradle 9.3.1 / JDK 21 / compileSdk 36 / buildTools 36.0.0 / minSdk 24

## 构建

```bash
cp local.properties.example local.properties   # 改成本机 SDK 路径
./scripts/build_web.sh                         # 前端 → app/src/main/assets/web/
./scripts/build_apk.sh                         # → app/build/outputs/apk/debug/
./scripts/install.sh                           # adb 安装并启动
```

## 自检（不需要手机）

```bash
python3 scripts/android_check.py               # 对 android_api.dispatch 走 mock 全流程
```

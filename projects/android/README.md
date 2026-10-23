# 闪动校园 · 安卓版（projects/android）

桌面版 `projects/desktop/`（v2.0.0）的 Android 移植：**功能与桥接口完全一致**，
唯一交互差异是跑步页的「规划复制点轨迹」由桌面版**按住鼠标右键拖拽**改为
**一个按钮在「摇杆」与「拖动」之间切换**（契约 §4）。

- 契约（唯一权威）：[`../../docs/android/接口契约.md`](../../docs/android/接口契约.md)
- 界面验收截图：[`../../docs/android/screenshots/`](../../docs/android/screenshots/)（412×915 视口，四页）

## 架构

```
MainActivity（WebView 承载移动端前端）
  └─ window.SDAndroid.call(method, argsJson)   ←→  JsApiBridge（单线程串行）
         └─ Chaquopy 17.1.0 · Python 3.12
              └─ android_api.dispatch(method, args_json)
                    └─ 桌面版 App 门面（协议/加密/存储/仿真零改动）
```

- 前端：React 18 + Leaflet（esbuild 单文件 bundle，自绘移动端组件，无 antd）
- 后端：桌面版 `shandong_school_cracked` **整包 vendoring**（仅去掉 `gui.py`，
  新增 `android_api.py` / `android_env.py` 两个适配文件）
- 设备指纹：Java 读 `Build.*` 注入（`modelName = MANUFACTURER|MODEL` 等，对齐原版语义）
- 版本组合（本机实测）：AGP 8.13.2 / Gradle 9.3.1 / JDK 21 / compileSdk 36 /
  buildTools 36.0.0 / minSdk 24 / targetSdk 36 / abiFilters arm64-v8a + x86_64

## 构建

```bash
cp local.properties.example local.properties   # 改成本机 SDK 路径
./scripts/build_web.sh                         # 前端 → app/src/main/assets/web/
./scripts/build_apk.sh                         # → app/build/outputs/apk/debug/（约 40 MB）
./scripts/install.sh                           # adb 安装并启动
```

沙箱注意（脚本已内置兜底）：`~/.gradle`、`~/Android/Sdk`、`~/.local/share/android` 只读时，
`GRADLE_USER_HOME` / `ANDROID_USER_HOME` 自动落到 `<workspace>/tmp/`；JDK 固定 21
（27 会让 Groovy 报 `Unsupported class file major version 71`）。

## 自检（不需要手机）

```bash
python3 scripts/android_check.py               # 对 android_api.dispatch 走 mock 全流程
```

| 验证项 | 结果 |
| --- | --- |
| 方法集与契约 §2 / 桌面 `gui.JsApi` 一致 | ✓ 43 个，零偏差 |
| 43 方法逐一真调（已登录态，mock） | ✓ 42 成功 + 1 白名单（check_update 查 GitHub），0 失败 |
| mock 全流程：登录→选点→开跑→摇杆 300 m→结算→记录→导出 | ✓（Python 3.14 与 3.12 双通过，23/23） |
| 桌面版回归（同一套业务代码） | ✓ selfcheck 76/76 |
| 四页 UI 可视化验收（412×915 + HTTP 桥） | ✓ 登录/选起始点/首页/跑步，无 JS 错误 |

> 沙箱里没有设备/模拟器（无 KVM、`adb devices` 为空），**真机运行验证**由
> `scripts/install.sh` 完成：连接设备后 `adb install -r` + 启动即可。

## 已知边界

- `mock` 的 `runRecordDetail` 恒回空 `targetPoints/pois`（mock 局限，桌面同款），不影响真实服务端。
- `PyApplication` 下 Python 在主进程内运行；Android 低内存杀进程时跑步会话随进程结束
  （与桌面版行为一致，未加前台服务保活）。
- 前端 `bridge.js` 三级降级：SDAndroid（原生桥）→ pywebview（桌面壳）→ POST /api（浏览器/HTTP 桥），
  因此同一份 bundle 也能直接用桌面 `--mode mock` + 浏览器打开调试。

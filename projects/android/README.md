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
| 方法集与契约 §2 / 桌面 `gui.JsApi` 一致 | ✓ 44 个，零偏差 |
| 44 方法逐一真调（已登录态，mock） | ✓ 43 成功 + 1 白名单（check_update 查 GitHub），0 失败 |
| mock 全流程：登录→选点→开跑→摇杆 300 m→结算→记录→导出 | ✓（Python 3.14 与 3.12 双通过，23/23） |
| 桌面版回归（同一套业务代码） | ✓ selfcheck 76/76 |
| 四页 UI 可视化验收（412×915 + HTTP 桥） | ✓ 登录/选起始点/首页/跑步，无 JS 错误 |

### Android 模拟器实测（KVM + AVD，API 34 x86_64）

截图见 [`docs/android/screenshots/emu-*.png`](../../docs/android/screenshots/)：

| 验证项 | 结果 |
| --- | --- |
| 安装与启动 | ✓ `Displayed MainActivity +2s857ms`，无 `FATAL`/`AndroidRuntime` |
| Chaquopy Python 3.12 | ✓ logcat 见 `stdlib-x86_64/_json/_hashlib/_blake2.cpython-312.so` 加载 |
| Pillow（滑块验证码依赖） | ✓ `requirements/PIL/_imaging.so` 加载 |
| WebView 前端 | ✓ `chromium: SD_READY injected` |
| 触摸交互 | ✓ 点输入框弹键盘、文字输入、页面避让正常 |
| 地图 | ✓ 高德瓦片真实加载、围栏/起点/打卡点渲染正确 |
| 摇杆推杆 | ✓ 推 5 秒距离 0→5 m，桥→Python→UI 回传链路通 |
| **摇杆/拖动切换** | ✓ 切拖动后摇杆变提示文案、按钮高亮变「拖动」 |
| **拖动规划轨迹** | ✓ 青色虚线 + 末端复制点，计划距离 220 m，人开始沿轨迹走 |
| **切回摇杆保留轨迹** | ✓ 轨迹不丢、继续自动走（距离 3→87 m，实时配速 7'13"） |
| 免密登录 | ✓ 重启应用直接恢复会话进选点页 |
| 检查更新 | ✓ 弹窗真实拉到 GitHub release（当前 2.1.1 / 最新 2.2.0） |

> 建模拟器：`android sdk install "system-images;android-34;google_apis;x86_64"`，
> 手工写 `~/.local/share/android/avd/sdtest{.ini,.avd/config.ini}`（本机无 `avdmanager`），
> 启动：`emulator -avd sdtest -no-window -no-audio -no-boot-anim -gpu swiftshader_indirect`。

## 已知边界

- `mock` 的 `runRecordDetail` 恒回空 `targetPoints/pois`（mock 局限，桌面同款），不影响真实服务端。
- `PyApplication` 下 Python 在主进程内运行；Android 低内存杀进程时跑步会话随进程结束
  （与桌面版行为一致，未加前台服务保活）。
- 前端 `bridge.js` 三级降级：SDAndroid（原生桥）→ pywebview（桌面壳）→ POST /api（浏览器/HTTP 桥），
  因此同一份 bundle 也能直接用桌面 `--mode mock` + 浏览器打开调试。

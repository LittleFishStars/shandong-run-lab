# 闪动校园逆向与破解重构

本仓库是「闪动校园」`com.huachenjie.shandong_school` v8.7.7 的**逆向工作区 + 24 篇分析报告**，
外加一个可运行的**桌面工作台复刻**（阳光跑协议全链路复原）。

- 逆向结论：[`report/`](report/README.md)（报告 01–24 唯一出处）
- 桌面工程：[`projects/desktop/`](projects/desktop/)（闪动校园·阳光跑 工作台）

> ⚠️ **用途声明**：本仓库仅用于**个人学习、协议研究**。请勿用于任何影响真实校园跑数据、或与自身无关的账号的用途。

---

## 项目结构

```
ShanDong/
├── samples/         原始样本（唯一的 APK，勿改，Git LFS 存储）
├── report/          分析报告 01–24（逆向结论的唯一出处，见 report/README.md）
├── docs/            整理记录：docs/CLEANUP-2026-10-22.md、docs/desktop/（协议/打包文档与截图）
├── reference/       签名算法的参考实现 + 外部规格（reference/spec/spec-b18.txt）
├── scripts/         逆向脚本（dump / 脱壳 / 签名 / 核对，约 120 个 py + js + sh）
├── work/            逆向工作区（dex/ native/ evidence/ dumps/ records/ meta/ toolchain/，见 work/README.md）
│   ├── dex/             ★ 反编译核心：脱壳 16 DEX、jadx_FULL 全量反编译、壳 DEX
│   ├── native/          ★ 原生层证据：libart、wrapper smali、全部 SO（179 个）、隐藏 SO、Ghidra 产物
│   ├── evidence/        静态证据：certs、blob_info、plugins（三方载荷）、jars
│   ├── dumps/           内存 dump 与易盾 payload
│   ├── records/         运行时记录（37 个 trace/参数表、日志、Frida 会话）
│   ├── meta/            盘点清单与产出（inventory、manifest、plugin_risk、domains/urls）
│   └── toolchain/       apktool、smali/baksmali、frida-server 等工具链
├── projects/         可运行工程
│   ├── desktop/      ★ 桌面工作台 shandong-school_cracked（Python 包，GUI+CLI，见 projects/desktop/README.md）
│   └── android/      ★ 安卓版（Chaquopy 复用同一套 Python 业务 + WebView 移动端界面，见 projects/android/README.md）
├── .github/workflows/   CI（打 tag 自动双平台构建 + 发 Release）
├── .gitattributes       Git LFS 规则（*.apk/*.dex/*.so/*.bin/*.jar/*.a/*.xz/*.zip/*.png）
└── tmp/              临时产物（脚本会自动重建，可随时清）
```

- 各目录说明见 `work/README.md`（逐项）与 `report/README.md`；工程文档在 `projects/desktop/README.md`。

---

## 使用方法

完整的使用说明都在 [`projects/desktop/README.md`](projects/desktop/README.md)（安装 → CLI → CLI 与自检），这里只给一个最直接的入口。

### 桌面工作台（可执行文件，免装 Python）

到 [Releases](https://github.com/LittleFishStars/shandong-school_cracked/releases) 下对应平台的可执行程序，双击即用：

| 平台 | 文件 |
|---|---|
| Windows x64 | `shandong-school_cracked-<版本>-windows-x64.exe`（或 `.zip`） |
| Linux x86_64 | `shandong-school_cracked-<版本>-linux` |

### 源码拉起来（Python 3.10+）

需要 Python 3.10+（本机 Arch 实测 3.14）。`pywebview` 与 `pycryptodome` 都可选，缺失时自动降级（密码学后端兜底到纯标准库 AES）：

```bash
cd projects/desktop
python3 -m venv --system-site-packages .venv        # Arch：继承系统包，省一次下载
.venv/bin/pip install pywebview                    # 桌面窗口（可选，缺了自动走浏览器）
.venv/bin/pip install pycryptodome                 # 密码学后端（可选，没有则用 cryptography/纯标准库）
.venv/bin/python -m shandong_school_cracked        # 图形界面
.venv/bin/python -m shandong_school_cracked run -d 2000          # CLI：跑 2 公里并上传
.venv/bin/python -m shandong_school_cracked info                 # 环境信息（后端、数据目录）
.venv/bin/python -m shandong_school_cracked --help               # 全部 CLI 子命令
```

密码学后端 `pycryptodome → cryptography → 纯标准库` 自动择优，全部缺失也能跑（内置纯 Python AES）。

### 逆向复现

```bash
# 脱壳主 DEX（work/dex/ 下已存有全量结果，可跳过直达分析）
unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex

# jadx 全量反编译（work/dex/jadx_FULL 的再生方式）
jadx -d work/dex/jadx_FULL --no-res samples/com.huachenjie.shandong_school.apk

# 清单类脚本（产出统一进 work/meta/）：扫三方 SDK（默认 arm64-v8a）/ 资产与域名盘点
python3 scripts/sdk_inventory.py
python3 scripts/assets_inventory.py

# 解析 manifest（需先 aapt dump xmltree，产物可喂给 parse_manifest.py 生成摘要）
aapt dump xmltree samples/com.huachenjie.shandong_school.apk AndroidManifest.xml > /tmp/manifest.xmltree.json
```

更多复现命令见 `work/README.md` 的「常用复现命令」。

---

## 软件操作（桌面工作台）

工作台是一个**图形界面 + 命令行**二合一程序：不带参数双击 = 开界面；终端里带参数 = CLI。
详细说明见 [`projects/desktop/README.md`](projects/desktop/README.md)，这里讲主流程怎么用。

### 图形界面

界面按 App 原版分页，无多余浮层：

| 页面 | 内容 |
|---|---|
| **登录** | 左侧「⚡ 闪动校园」+ 右侧卡片：手机号、密码、**登录**、**选择已有账号**（切历史账号下拉，免密登录） |
| **选起始点** | 顶部「选择起始点」+ 右上「确认」，下方全屏地图，点一下即设起点，确认后回首页 |
| **首页** | 全屏地图（围栏 + 起点）+ 右侧目标距离下拉、**开始**大圆钮、**更多**小圆钮；左上角**重新选择起始点**、右上角**账户**入口、底部进度条 |
| **跑步** | 同一张地图跟踪本次轨迹；右侧距离 / 配速、摇杆、**结束**小圆钮。**在跑步页地图上按住鼠标右键拖拽可规划复制点路径**（从当前「人」的位置拉出一条轨迹，再次拖动可从轨迹终点继续延长），松开即完成，程序按规划路径驱动前进；推摇杆可随时清空计划改手动 |
| **账户** | 头像 / 昵称 / **退出登录** / 跑步记录列表 + 头部「已完成 X km / 要求 Y km」进度；记录卡显示计入里程（大号，按日上限封顶）、状态标签、本次总里程、时长/配速/消耗 |
| **更多** | 跑步参数（运行模式、围栏、平均步频 ± 波动、步幅、配速、目标自动结算、保存参数、换 deviceId）+ **事件流**（实时日志带清屏） |

**典型主流程**：

```text
登录 → （自动拉取围栏与规则）→ 选起始点页（点地图选点 → 确认）
     → 首页点「开始」→ 跑步页摇杆 → 「结束」上传结算 → 回到首页
```
到达目标里程会自动结算，同样回到首页。

> 提示：启动总是先进登录页（即使本地会话还在）——点「**选择已有账号**」即可免密进入；
> 选起始点 / 换起始点的入口在**首页左上角「重新选择起始点」**。

### 命令行（CLI）

```bash
# ① 桌面窗口（不带子命令默认就开窗口，等同 ./shandong-school_cracked-<平台>）
./shandong-school_cracked-<平台>

# ② 跑一次完整流程（不开界面，适合脚本化 / 排错）
./shandong-school_cracked-<平台> run -d 2000                 # 跑 2 公里并上传
./shandong-school_cracked-<平台> run -d 1500 --no-upload --json | tail -40   # 只生成不上传

# ③ 纯本地仿真：不碰真实服务端，全程打内置 Mock（127.0.0.1 随机端口），适合离线调试
./shandong-school_cracked-<平台> --mode mock gui        # Mock 开窗口
./shandong-school_cracked-<平台> --mode mock run -d 2000

# ④ 环境信息（后端、数据目录、默认目标）
./shandong-school_cracked-<平台> info
```

源码方式运行时把 `./shandong-school_cracked-<平台>` 换成 `.venv/bin/python -m shandong_school_cracked` 即可。
所有子命令见 `--help`。
## 开发

目录约定、测试、打包、CI、提交推送等开发 / 逆向相关内容见 **[CONTRIBUTING.md](CONTRIBUTING.md)**。

---

## 免责声明

- 本项目是**逆向学习与协议研究**的产物，与「闪动校园 / 华辰杰（hewc / huachenjie）」**官方及其作者无关**。
- 协议细节来自对本机 APK（`com.huachenjie.shandong_school` v8.7.7）的**静态分析**与**服务端常量交叉验证**。
- **仅用于**个人学习与协议研究。**请勿**：
  - 用于模拟/伪造真实成绩，影响任何平台的公平性与数据真实性；
  - 用于与自身无关的账号，或任何违反校规、平台条款或法律法规的用途。
- 本项目按「AS-IS」提供，**不提供任何形式的担保**；使用者对其任何形式的**后果自负**（学业、平台、法律风险）。
- 若你是权益方并要求移除相关内容，请通过本仓库的 issue 联系。

# 闪动校园（com.huachenjie.shandong_school v8.7.7）逆向与复刻

本仓库同时承载三样东西：**逆向工作区**、**24 篇分析报告**、以及一个**可运行的桌面前端复刻工程（shandong-school_cracked）**。
对一个包的使用/建工程有疑问，先看下面的「项目结构」，再对号入座进对应目录。

- **逆向结论**：见 [`report/`](report/README.md)（报告 01–24 的唯一出处）。
- **可运行的工程**：见 [`projects/desktop/`](projects/desktop/)（闪动校园·阳光跑 桌面工作台）。
- **环境与路径约定**：`samples/` 只读；`tmp/` 可随时清；`work/` 只留证据与输入。

> ⚠️ **用途声明**：本仓库仅用于**个人学习、协议研究与本地仿真调试**。请勿用于任何影响真实校园跑数据、
> 或与自身无关的账号的用途。默认运行在**真实模式**（直连 `api.huachenjie.com`）；想纯本地调试请把登录方式切成「本地登录」。

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
│   └── desktop/      ★ 桌面工作台 shandong-school_cracked（Python 包，GUI+CLI，见 projects/desktop/README.md）
├── .github/workflows/   CI（打 tag 自动双平台构建 + 发 Release）
├── .gitattributes       Git LFS 规则（*.apk/*.dex/*.so/*.bin/*.jar/*.a/*.xz/*.zip/*.png）
└── tmp/              临时产物（脚本会自动重建，可随时清）
```

- 目录树只列主干，`work/**` 每一层都有说明：`work/README.md`、`report/README.md`。
- 应用的完整文档（功能、安装、用法、模块结构、测试）见 [`projects/desktop/README.md`](projects/desktop/README.md)（单目录就是独立文档，下同）。
- 版本记录：应用在 `projects/desktop/README.md` 的「版本更新」；逆向每个阶段的结论见 `report/`。

### 仓库与版本控制约定

**一个仓库装下整个项目**：`github.com/LittleFishStars/shandong-school_cracked`（应用、报告、脚本、脱壳产物、native 证据全在里面）。

| 内容 | 存储方式 |
|---|---|
| 文本：报告、脚本、版本信息、jadx 全量源码、清单 | 普通 git 对象 |
| 二进制：`.apk` `.dex` `.so` `.bin` `.jar` `.a` `.xz` `.zip` `.png`、无扩展的 `frida-server` | **Git LFS**（`.gitattributes`，147 个对象 / 约 550 MB） |
| 不入库 | 虚拟环境（`.venv`、`.venv-frida`）、`node_modules`、`tmp/`、`dist/`、`build/`、签名密钥 `work/noshell.keystore` |

```bash
# 首次克隆（需要 git-lfs）
git lfs install
git clone ssh://git@ssh.github.com:443/LittleFishStars/shandong-school_cracked.git
cd shandong-school_cracked && git lfs pull    # 拉取大文件（约 550 MB）
```

> 本机推送：/etc/ssh 配置属主异常，用仓库里的包装脚本
> `GIT_SSH_COMMAND="$PWD/scripts/git-ssh-wrap.sh" git push origin main`

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

```bash
cd projects/desktop
python3 -m venv .venv
.venv/bin/pip install -r requirements.txt          # 若有；否则按需装
.venv/bin/pip install pywebview                    # 桌面窗口（可选，缺了自动走浏览器）
.venv/bin/pip install pycryptodome                 # 密码学后端（可选，没有则用 cryptography）
.venv/bin/python -m shandong_school_cracked        # 图形界面
.venv/bin/python -m shandong_school_cracked run -d 2000          # CLI：跑 2 公里并上传
.venv/bin/python -m shandong_school_cracked mock --port 8899     # CLI：只起本地 Mock 服务端
.venv/bin/python -m shandong_school_cracked info                 # 环境信息（后端、数据目录）
.venv/bin/python -m shandong_school_cracked --help               # 全部 CLI 子命令
```

### 逆向复现

```bash
# 样本里的壳 classes.dex（work/ 已清理，按需现场解包）
unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex

# jadx 全量反编译（work/dex/jadx_FULL 的再生方式）
jadx -d work/dex/jadx_FULL --no-res samples/com.huachenjie.shandong_school.apk

# 清单类脚本（产出统一进 work/meta/）——见 work/README.md 的「常用复现命令」
```

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
| **首页** | 全屏地图（围栏 + 起点）+ 右侧目标距离下拉、**开始**大圆钮、**更多**小圆钮、底部进度条 |
| **跑步** | 同一张地图跟踪本次轨迹；右侧距离 / 配速、摇杆、**结束**小圆钮 |
| **更多** | 跑步参数 / 学校规则 / 账号 / 本次跑步 / 地图与起点 / 高级调试 / 服务器记录 / 事件流 |

**典型主流程**：

```text
登录 → （自动拉取围栏与规则）→ 选起始点页（点地图选点 → 确认）
     → 首页点「开始」→ 跑步页摇杆 → 「结束」上传结算 → 回到首页
```
到达目标里程会自动结算，同样回到首页。

> 提示：启动总是先进登录页（即使本地会话还在）——点「**选择已有账号**」即可免密进入。
> 「运行模式（真实服务端 / 本地 Mock）」在「更多 → 跑步参数」里切；
> 选起始点入口在「更多 → 地图与起点」。想纯本地调试就把登录方式切成「本地登录」。

### 命令行（CLI）

```bash
# ① 桌面窗口（默认；真实模式，登录卡片里可切本地登录）
./shandong-school_cracked-<平台> gui

# ② 纯本地仿真，不碰真实服务端
./shandong-school_cracked-<平台> --mode mock gui

# ③ 跑一次完整流程（不开界面，适合脚本化 / 排错）
./shandong-school_cracked-<平台> run -d 2000                 # 跑 2 公里并上传
./shandong-school_cracked-<平台> run -d 1500 --no-upload --json | tail -40

# ④ 只起本地 Mock 服务端
./shandong-school_cracked-<平台> mock --port 8899

# ⑤ 环境信息（后端、数据目录、默认目标）
./shandong-school_cracked-<平台> info
```

源码方式运行时把 `./shandong-school_cracked-<平台>` 换成 `.venv/bin/python -m shandong_school_cracked` 即可。
所有子命令见 `--help`。
## 开发指南

```bash
cd projects/desktop
.venv/bin/python -m unittest discover -s tests -q     # 单元测试（187 项左右）
.venv/bin/python scripts/selfcheck.py -v               # 自检
.venv/bin/python -m shandong_school_cracked check      # 两个自检一起跑
```

**目录约定（务必遵守）**

- `work/` 只留证据与输入：`report/` 里每条结论都标了对应路径；不要对 `work/` 做破坏性修改。
- `samples/` 只读：脚本默认从 `samples/com.huachenjie.shandong_school.apk` 取样本。
- `tmp/` 可随时清；只保留可重建的产物。
- 代码/报告改动**提交并推送**（本机推送方式见上方）。

**想改哪里**

| 想改什么 | 改哪里 |
|---|---|
| 桌面工作台功能 | `projects/desktop/`（`shandong_school_cracked/` 包，README 有模块导览） |
| 协议 / 逆向结论 | `report/`（报告是唯一出处），配套脚本在 `report/` 目录的 `scripts/` |
| 整理记录 | `docs/`（新增清理/归档记录时更新 `docs/CLEANUP-2026-10-22.md` 或另起一文件） |

**CI**

`.github/workflows/build-release.yml`：push 以 `v*` 开头的 tag → 双平台（Linux/Windows）构建单文件可执行程序 → 发 GitHub Release；手动触发只构建不发版。

---

## 免责声明

- 本项目是**逆向学习与协议研究**的产物，与「闪动校园 / 华辰杰（hewc / huachenjie）」**官方及其作者无关**。
- 协议细节来自对本机 APK（`com.huachenjie.shandong_school` v8.7.7）的**静态分析**与**服务端常量交叉验证**。
- **仅用于**个人学习、协议研究与本地仿真调试。**请勿**：
  - 用于模拟/伪造真实成绩，影响任何平台的公平性与数据真实性；
  - 用于与自身无关的账号，或任何违反校规、平台条款或法律法规的用途。
- 本项目按「AS-IS」提供，**不提供任何形式的担保**；使用者对其任何形式的**后果自负**（学业、平台、法律风险）。
- 若你是权益方并要求移除相关内容，请通过本仓库的 issue 联系。

---

## 许可证

本项目 **未声明具体开源许可证（All Rights Reserved，保留所有权利）**——所有内容（代码、脚本、报告、文档、样本分析产品）归作者所有，**仅供个人学习与使用，禁止商用与二次分发**。

若需其他任何许可，请先联系作者（见仓库主页）。
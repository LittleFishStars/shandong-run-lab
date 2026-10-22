# 闪动校园（com.huachenjie.shandong_school v8.7.7）逆向与复刻

本目录同时是三样东西：**逆向工作区**、**24 篇分析报告**、以及一个**可运行的桌面前端复刻工程（shandong-school_cracked）**。
下面只说明「东西在哪、怎么用」，逆向结论本身见 `report/`。

```
ShanDong/
├── samples/        原始样本（唯一的 APK，勿改）
├── report/         分析报告 01–24（逆向结论的唯一出处）
├── docs/           整理记录（每轮删了什么、怎么复原）
├── reference/      签名算法的参考实现 + 外部规格（spec-b18）
├── scripts/        逆向脚本（dump / 脱壳 / 签名 / 核对，共 120 个）
├── work/           逆向工作区：dex/ native/ evidence/ dumps/ records/ meta/ toolchain/
├── projects/       可运行工程
│   └── desktop/    桌面工作台 shandong-school_cracked（Python，GUI+CLI，已发版 v1.1.0）
└── tmp/            临时产物（脚本会自动重建，可随时清）
```

## 一、怎么跑起来

```bash
cd projects/desktop
.venv/bin/python -m shandong_school_cracked            # 图形界面
.venv/bin/python -m shandong_school_cracked --help     # 命令行
```

单文件可执行程序见 [Releases](https://github.com/LittleFishStars/shandong-school_cracked/releases)。

## 二、work/ 里有什么

按用途分成 8 个类别目录（`work/README.md` 有逐项说明）：

| 类别 | 内容 |
|---|---|
| `dex/` | **脱壳与反编译核心**：`APP_ALL4/`（16 DEX、108,363 类）、`jadx_FULL/`、`jadx_shell/`、`rebuild/`、两个小 dex |
| `native/` | 原生层证据：`allso/`（179 个 SO）、`hidden_so3/`、`ghidra_blob/`、`liby_runtime/`、`liby_segs/`，本级还有 libart/wrapper smali/探针 |
| `evidence/` | 静态证据：`certs/`、`blob_info/`、`plugins/`（三方载荷）、`jars/` |
| `dumps/` | 内存 dump 与易盾 payload：`dump/`、`dump_final/`、`dump_nesec_*`、`liby/`、`shots/` |
| `records/` | 运行时记录：`notes/`（37 个 trace/参数表）、`logs/`、`frida/` |
| `scripts/` | 工作区内的分析脚本（26 个 py + 5 个 sh） |
| `meta/` | 盘点清单与产出：inventory、manifest、plugin_risk、yidun_*、domains/urls |
| `toolchain/` | 工具链：apktool、smali/baksmali、frida-server、`.venv-frida`、`node_modules` |

## 三、约定

- **`samples/` 只读**：脚本默认从 `samples/com.huachenjie.shandong_school.apk` 取样本。
- **`work/` 只留证据与输入**：`report/` 里每条结论都标了对应路径；`jadx_V2`（残缺）、`rebuilt/`、
  `peek/classes.dex`、设备 APK 副本、模拟器镜像等派生物已于 2026-10-22 清理，
  `peek` 可用 `unzip -p samples/*.apk classes.dex` 现场解包。
- **`report/` 是历史文档**：里面写的 `shandong-run-lab/`、`report/xx` 等路径是整理前的相对位置，
  对应关系见 `docs/CLEANUP-2026-10-22.md` 的「目录迁移对照」。
- 只提交 `projects/desktop`（独立 git 仓库，仓库名 `LittleFishStars/shandong-school_cracked`，本地目录叫 desktop）；
  其余目录不入版本控制。它的数据/配置目录同名：`~/.local/share/shandong-school_cracked/`、
  `~/.config/shandong-school_cracked/`。

## 四、版本控制

本仓库（根目录）只跟踪**文本成果**，约 2 MB / 200 个文件：

| 跟踪 | 说明 |
|---|---|
| `report/` `scripts/` `docs/` `reference/` | 报告、逆向脚本、整理记录、参考实现 |
| `work/meta/` `work/scripts/` `work/README.md` | 盘点清单与工作区分析脚本 |
| `projects/desktop` | **submodule**，指向独立仓库 `LittleFishStars/shandong-school_cracked` |

不跟踪（`.gitignore`，均可由 `samples/` 的 APK 重新生成，且单文件超过 GitHub 100 MB 上限）：
`samples/`、`work/{dex,native,evidence,dumps,records,toolchain}/`、`tmp/`、签名密钥 `work/noshell.keystore`。

远程：**`github.com/LittleFishStars/shandong-school_cracked-workspace`**（私有）。
本机推送（`/etc/ssh` 配置属主异常，需要脚本包一层空配置）：

```bash
GIT_SSH_COMMAND="$PWD/scripts/git-ssh-wrap.sh" git push origin main
```

```bash
# 首次克隆：连子工程一起
git clone --recurse-submodules <本仓库地址>
# 已克隆但没初始化子工程
git submodule update --init --recursive
# 更新子工程到它自己的最新提交
git -C projects/desktop pull && git add projects/desktop && git commit -m "bump desktop"
```

## 五、整理记录

- 2026-10-22：清理 8.2 GB 可重建中间物（重打包中间 APK、gradle 构建目录、apktool 解包副本、重复的 classes.dex），
  顶层重组为 `samples/ report/ docs/ reference/ scripts/ work/ projects/ tmp/`。
  删除清单与每个文件的 sha256 见 `docs/CLEANUP-2026-10-22.md`。
- 2026-10-22（第二轮）：只保留主工程，`projects/shandong-run-lab` → `projects/desktop`；
  另外三个工程拆出有用部分暂存 `archive/`，其余（apktool 解包、与 `work/` 重复的 SO/证书/dump/报告副本）已删。
- 2026-10-22（第三轮）：按「只留主工程与逆向证据」再删 7.8 G —— 模拟器镜像（6 G）、`archive/`
  里的退役成品、设备 APK 副本、`jadx_V2`、`rebuilt/`、`peek/`、第三方资料等；工作区降到 1.6 G。
  详见 `docs/CLEANUP-2026-10-22.md` 第五、六节。
- 2026-10-22（第四轮）：`work/` 内部按用途归位 —— 工具链进 `toolchain/`、盘点清单进 `meta/`、
  清掉一批空目录，并新增 `work/README.md` 逐项说明。

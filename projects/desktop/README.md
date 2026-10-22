# 闪动校园·阳光跑 桌面工作台（shandong-school_cracked）

一个用 Python 重写的**桌面程序**，把「闪动校园」（`com.huachenjie.shandong_school`）阳光跑的整条链路
从 App 里搬出来：**登录 → 选围栏/规则 → 开跑 → 轨迹与步频记录 → 分批上传 → 结算**，
并且内置一套**离线 Mock 服务端**与**传感器仿真器**（移植自 [FUCK-RUN-](https://github.com/BieFan1029/FUCK-RUN-)），
不开手机、不连服务器也能把全流程跑通、看数据、调参数。

界面是本地 Web（HTML/CSS/JS，无构建链），由 **pywebview** 装进原生窗口；没有 pywebview 时自动降级成
「本地 HTTP + 浏览器」，功能完全一致。

> ⚠️ **用途声明**：本项目仅用于**个人学习、协议研究与本地仿真调试**。请勿用于任何
> 影响真实校园跑数据、或与自身无关的账号。默认运行在 **真实模式**（直连 api.huachenjie.com）；想纯本地调试就把登录方式切成「本地登录」。

---

## 版本更新

| 版本 | 摘要 |
| --- | --- |
| **v1.2.0**（2026-10-23） | 界面重构：右栏改为**服务器记录**（`run/pageSunRunRecord` + `run/runRecordDetail`），点记录回显到「本次跑步」；**登录/启动自动拉取配置**（去掉「拉取配置」按钮）；目标距离改为按学校规则区间、从高到低每 1 km 的下拉；参数简化为**平均步频 ± 波动**与**配速**，移除失败率/实时仿真；学校规则改从 `run/querySunRunAbstractInfoV2` 的 `schoolDemandRule` 解析（修复“拉取后规则不更新”）；历史账号下拉显示手机号/学号。上传报文已逐一核对，与 v1.1.0 **逐字段一致**（仅时间戳/记录号/防篡改码不同）。 |
| v1.1.0 | 到达目标自动结算；结算补发 pois 修复 |

---

## 一、它能做什么

| 环节 | 能力 |
| --- | --- |
| 登录 | `loginCheck` → 滑块验证码（内置不依赖 OpenCV 的缺口求解）→ `loginPassword`；会话与 deviceId 持久化 |
| 备跑 | 拉学期、围栏列表（多边形）、阳光跑规则（配速/距离/打卡/步幅阈值）、跑量计划，解析成规则对象 |
| 开跑 | 九参数开跑报文，写入本地 SQLite（记录号、打卡点、围栏） |
| 记录 | 轨迹点（3 秒一采）、步频段（20 秒一段）、配速段（50 米一段）、步幅段（100/200 米一段）、打卡点命中，全部落库 |
| 上传 | `uploadRunRecord`（★唯一需签名的接口：整表一次 POST，`state∈{1,4} 且 isValid=1`，总数 ≤ 3 不发）→ 步频段（20 秒一段）/配速段（50 米一段）/步幅段（`strideStatisticsInterval` 米一段，每次只发 1 段）→ 打卡点 |
| 结算 | 完全照搬原版 `DataComponent.t1()` 的 Map：`runRecordCode / duration / distance / totalStep / status / stepInterval / paceInterval / targetPoints / alignType / pauseCount / pauseTimes / sportType`（非空时加 `invalidReasons`）；**不含** pois/stepList/paceList |
| 调试 | Mock 服务端（可注入延迟与随机失败率）、传感器仿真器（步频/抖动/丢包/暂停）、实时仿真（逐点推进，可在界面上看轨迹长出来）、事件流面板、服务器记录浏览（`run/pageSunRunRecord` 分页 + `run/runRecordDetail` 详情，数据以服务端为准） |
| 地图 | Leaflet 真实底图（高德路网/卫星、OSM、或关闭底图），围栏、打卡点、轨迹、规划路线、**起跑点**矢量叠加；**拉到电子围栏后镜头自动飞到围栏**（围栏换了才动；用户自己拖过镜头之后不再抢镜）；UI 自动验证布局与几何 |
| 手控 | **摇杆实走**（摇杆钉在地图右下角常驻，拖动摇杆 / 方向键逐帧推进位置与传感器；推满杆默认 2.5 m/s，可调）；**自动跑**（一个按钮在「沿规划路线自动巡航」与「手动摇杆」之间切，推杆即接管）；**只规划不动**（按打卡点最近邻连成闭环、或地图上点选路点，只画出来不升跑）；**实跑边跑边落库**（完全按原 App 记录链路：定位回调 3 秒一条、精度/速度过滤、有效点折线累距、步频段 20 秒一段、配速段 50 米一段、打卡半径 25 米），干跑/实跑结束后可一键上传结算 |
| 续传 | 断点续传：只补传「未成功」的点/段，含尾部补齐段 |

---

## 二、安装

### 方式 A：直接下载可执行文件（不用装 Python）

到 [Releases](https://github.com/LittleFishStars/shandong-school_cracked/releases) 下对应平台的那一个，双击即用：

| 平台 | 文件 | 启动 |
|---|---|---|
| Linux x86_64 | `shandong-school_cracked-<版本>-linux-x86_64`（或 `.zip`） | `chmod +x` 后双击，或终端 `./shandong-school_cracked-… ` |
| Windows x64 | `shandong-school_cracked-<版本>-windows-x64.exe`（或 `.zip`） | 双击；命令行用法见下文 |

> 注意：**已发布的 v1.1.0 及更早版本**是改名前的构建，附件名仍为 `sdlab-*`；
> 从下一个版本起产物名与本仓库一致（`shandong-school_cracked-*`）。自行构建见下方方式 B。

命令行和界面是同一个程序：不带参数双击 = 开界面；在终端里带参数 = CLI。

```bash
./shandong-school_cracked-<版本>-linux-x86_64 --help          # 全部命令
./shandong-school_cracked-<版本>-linux-x86_64 --mode mock gui  # 纯本地仿真，真接口一根毛都不碰
# Windows（PowerShell）
.\shandong-school_cracked-<版本>-windows-x64.exe --mode mock gui
```

自己构建看 [`docs/打包与发布.md`](../../docs/desktop/打包与发布.md)：`python scripts/build_bin.py --zip`
一条命令出本平台单文件。

> 单文件启动时会先解压到临时目录（首次 1-2 秒），属正常现象。

### 方式 B：从源码跑

需要 Python 3.10+（本机实测 3.14）。Arch Linux：

```bash
# 依赖（大多数系统已自带 requests/cryptography/Pillow）
sudo pacman -S --needed python-requests python-cryptography python-pillow

cd projects/desktop
python3 -m venv --system-site-packages .venv       # 继承系统包，省一次下载
.venv/bin/pip install pywebview                    # 桌面窗口（可选，缺了就自动走浏览器）
.venv/bin/pip install pycryptodome                 # 可选，密码学后端更快（没有则用 cryptography）
```

`pycryptodome` / `cryptography` / 纯标准库三种密码学后端会自动择优（见 `ciphers.py`），
**全部缺失也能跑**（内置纯 Python AES）。

## 三、运行

```bash
# ① 桌面窗口（默认命令；真实模式，登录卡片里可切本地登录）
.venv/bin/python -m shandong_school_cracked

# ② 不开窗口，用浏览器（端口随机，终端会打印地址）
.venv/bin/python -m shandong_school_cracked gui --browser

# ③ 命令行跑一次完整流程（不开界面，适合脚本化 / 排错）
.venv/bin/python -m shandong_school_cracked run -d 2000            # 2000 米
.venv/bin/python -m shandong_school_cracked run -d 1500 --no-upload --json | tail -40

# ③′ 实时仿真：按真实时间推进数据写入，能在界面上看到轨迹一笔笔长出来（调试友好）
#     默认关闭（瞬间算完）。倍速 8 ≈ 真实跑步耗时的 1/8。
.venv/bin/python -m shandong_school_cracked run -d 1200 --realtime --speed 8
# ④ 只起 Mock 服务端（给别的东西当靶子）
.venv/bin/python -m shandong_school_cracked mock --port 8899 --latency 200 --fail-rate 0.3

# ⑤ 其它
.venv/bin/python -m shandong_school_cracked info                   # 环境信息（后端、数据目录、默认目标）
.venv/bin/python -m shandong_school_cracked login --prepare        # 登录并拉围栏/规则
.venv/bin/python -m shandong_school_cracked records list           # 本地记录
.venv/bin/python -m shandong_school_cracked records show --points  # 明细（含轨迹点）
.venv/bin/python -m shandong_school_cracked records export MCKXXXX --format gpx
.venv/bin/python -m shandong_school_cracked records resume MCKXXXX # 断点续传
.venv/bin/python -m shandong_school_cracked start-point          # 看当前跑步起点（围栏中心 / 图上选的）
.venv/bin/python -m shandong_school_cracked start-point --lat 36.6637 --lng 117.0265   # 设起点（围栏外自动吸附）
.venv/bin/python -m shandong_school_cracked start-point --clear  # 回围栏中心
.venv/bin/python -m shandong_school_cracked check -v               # 跑自检（等价下面两脚本）
```

```bash
# ③′ 默认就是真实服务端：填上账号密码就是真登录，不用额外开关
.venv/bin/python -m shandong_school_cracked -p 手机号 -w 密码 run -d 2000
#    只想离线自己玩，显式切到本地 Mock（真接口一根毛都不会碰）：
.venv/bin/python -m shandong_school_cracked --mode mock gui
#    临时用代理观察流量：
.venv/bin/python -m shandong_school_cracked --proxy http://127.0.0.1:8080 gui
```

#### 登录：默认真实，本地登录是可选项

- **真实登录是默认**：直连 `api.huachenjie.com`，手机号 + 密码。服务端口 `captchaEnable=true`，
  登录会先过滑块验证码，求解器本地自动解（失败会自动换一张新挑战重试）；登录后再拉围栏/规则/服务端运行参数。
- **本地登录只是调试开关**：界面上把「登录方式」切到「本地登录」，或 CLI 加 `--mode mock`。
  切过去后所有请求都打内置 Mock（127.0.0.1 随机端口），真实接口一个字节都不会发。
- 两种模式的会话**分开存在本地**（`session` / `session_mock`），来回切换不用反复登录，
  也不会把 Mock 的假 token 带去真实服务端（那个报错是 `1516 请登录后操作`，很难排查）。

#### 真实接口已实测到的行为

`scripts/realcheck.py` 会把下面这些逐条跑一遍（当前 **12/12 通过**）：

| 环节 | 实测结果 |
| --- | --- |
| `common/syncTime`（**GET**，路径就带 common，不是 run-front/syncTime） | `code=0` |
| `auth/loginCheck` | `code=0`，回显 `data.phone` 与本地 `crypto.encrypt_field()` **逐字节相同** |
| `common/getConfig`（**GET**） | `runFilterAccuracy=30`（APK 默认 50）、`gpsFilterAccuracy=150`、`paceInterval=50`、`validDistance=25`、`poiInterval=15`、`stepInterval=20` |
| 未登录调 `run/*` | `code=1516 请登录后操作！`（路由存在，只缺 token） |
| 滑块验证码 | `captcha/get` → 本地求解 → `captcha/check`，**一次挑战内通过 5/5** |
| `e` 头 / 字段加密对照 | `e=0 + 明文` 与 `e=1 + 密文` 送 `school/firstPageSchoolList`，返回逐条一致；响应 `schoolName` 解出「山东轻工职业学院」 |

三个必须知道的服务端口径：

- **标了 `e:1` 的接口必须真发 `e:1`，并把字段加密后再送**。登录恒定 `code=1604 密码不正确`
  （密码明明是对的）就是踩在这里：发成 `e=0` 时服务端不解密，把 Base64 密文当明文密码比对。
 修法见 `constants.EP` 里登录四接口的 `encrypt=True` 与 `shandong-school_cracked/crypto.py` 的 `encrypt_body_fields()`。
- **`v` / `api` 请求头不能少**。少了会被当成参数不合法（`code=1002`），很容易误判成「接口不可用」。
- **滑块 `captcha/check` 是一次性的**：调一次就消费掉该 token。所以求解失败要**重新 `captcha/get` 拿新挑战**，不能在同一个 token 上换坐标重试（早期就是在这里踩了坑，全 x 扫描零命中）。

服务端 `captchaEnable=true`，所以真实登录流程是：`loginCheck` → `captcha/get` → 本地求解 → `captcha/check` → `loginPassword(captchaPoint)`。

#### 接口的编码方式不统一

反编译 `com/huachenjie/**/*Api.java` 的结果：**上传/结算四个接口是 JSON，而登录/围栏/规则/榜单是表单（`@FormUrlEncoded`）**。实测 JSON 文体也能被接受，所以本项目统一用 JSON；需要时可在 `constants.EP` 的 `Endpoint` 上加 `content_type` 单独覆盖。
### 界面速览

界面按**页面**组织（顶部栏常驻：模式 / 登录状态 / 设备 / 版本 / 数据目录），不再是单页三栏：

| 页面 | 内容 |
|---|---|
| **登录** | 左侧品牌 + 右侧卡片：手机号 + 密码 + 登录（右上角小下拉切真实 / 本地 Mock）；点「选择已有账号」切成历史账号下拉（显示手机号/学号，免密登录），可再切回「登录新账号」 |
| **首页** | 左侧地图（高德瓦片 + 围栏 / 规划路线 / 打卡点 / 起点 / 图例，左上「高级 / 调试」折叠面板）；右侧面板：logo、目标距离下拉、**开始**大圆按钮、**更多**小圆按钮、进度条 |
| **选起始点** | 点首页地图上的「① 选择起始点」进入：顶部「选择起始点」+ 右上「确认」，下方全屏地图；在图上点一下即设起点（自动吸附进围栏），「确认」返回首页 |

| **跑步** | 同一个地图跟踪本次轨迹；右侧：距离 / 配速大字、摇杆（手动 / 自动）、**结束**按钮 |
| **更多** | 跑步参数（围栏、平均步频 ± 波动、步幅、配速、到达目标自动结算、保存参数、换 deviceId）、学校规则、账号（当前用户信息 / 退出登录）、本次跑步、服务器记录、事件流 |

流程：**登录 → 自动拉取围栏与规则 → 首页点「开始」→ 跑步页摇杆/自动跑 → 「结束」上传结算 → 回到首页**；
到达目标里程自动结算后同样回到首页。

- 目标距离是下拉：按学校规则的单次距离区间、从高到低每 1 km 一项（真实规则 2000–3000 → `3 km` / `2 km`）。
- 打卡点数量优先取最近一次记录的 `targetPoints`，其次本次开跑下发，最后回退围栏的 `requiredPointCounts`。
- 地图在首页与跑步页之间**复用同一个 Leaflet 实例**：切页时把 `#map` 挂到当前页的槽位并 `invalidateSize()`。
- 旧的截图在 `docs/desktop/screenshots/`（三栏布局时期），仅作历史参考。

## 四、数据与配置

| 内容 | 默认路径 |
| --- | --- |
| 配置 | `~/.config/shandong-school_cracked/config.json` |
| 数据目录（SQLite / 导出） | `~/.local/share/shandong-school_cracked/` （记录库 `records.db`） |
| 环境变量覆盖 | `SDLAB_HOME=/some/dir` 或 `--data-dir`（沙箱/便携场景用） |

数据库表：`runs`（记录头）、`points`（轨迹点，带 `is_valid/is_uploaded/state`）、`steps`（步频段）、`paces`（配速段）、`strides`（步幅段）、`checkpoints`（打卡点）、
`upload_log` / `api_log`（上传与接口日志）、`kv`（会话与配置缓存）。WAL 模式，短连接，线程安全。

### 四个上传接口与原版的一一对应

| 接口 | 原版方法 | 取数条件 | 发送门限 |
| --- | --- | --- | --- |
| `run/uploadRunRecord` | `ApiDataComponent.c0()` | `state ∈ {1,4}` **且** `isValid=1` | `size <= 3` 不发；**整表一次 POST**（200 只是状态回写分片）；**跑中每 `poiInterval=15` 秒增量发一批**（`m0()`） |
| `run/uploadStepsRecord` | `d0()` | `is_uploaded=0`（**不过滤 isValid**） | `size >= 3` 才发 |
| `run/uploadPaceRecord` | `b0()` | `is_uploaded=0` 且 `isValid=1` | `size < 3` 不发 |
| `run/uploadStrideRecord` | `n0()` | 每段即时发（`E0()` 每满 `strideStatisticsInterval` 米封一段） | 无门限，`strideList` **恒为单元素数组** |
| `run/uploadPassPoint` | `p0()` | 打卡点 | 发**全量** `targetPoints`（含 `passStatus=false`），不是只发已通过的 |

---

## 五、自检与测试

```bash
export SDLAB_HOME=$PWD/.run          # 沙箱内 ~/.local/share 只读时必加

# 单元测试（187 项）
.venv/bin/python -m unittest discover -s tests

# 端到端自检（68 项：密码学 / 结算码原生预言机 / 仿真 / 跑步起点 / 打卡点来源 / 自动跑与手动摇杆 / 停下来时间照走 /
#   轨迹点报文口径（runTime 整数秒 / createTime / offFenceDisM=-1 / 跑中增量上传）/ 全链路 /
#   失败注入+续传）
.venv/bin/python scripts/selfcheck.py -v

# 前端桥自检（59 项：用和浏览器一模一样的 HTTP 调用驱动后端，含 app.js 语法校验、摇杆干跑、
#   只规划路径、起点选点/吸附、打卡点只在开跑后下发、自动跑开关与推杆接管、实跑边跑边落库、
#   实时面板的时长/配速走墙钟口径）
.venv/bin/python scripts/webcheck.py

# 桌面外壳自检（真的开窗口、点界面按钮：主流程只剩 4 个按钮、摇杆与「自动跑」常驻右下角、高级默认折叠、
#   登录后自动拉取配置、镜头飞到围栏、图上选起点、地图上没有打卡点、② 开始跑步后才拿到服务端下发的打卡点、
#   点「自动跑」才沿路线巡航、窗口压矮时右下角摇杆簇不被裁掉、摇杆中心点命中的是摇杆本身
#   （卡片没被提示行撑出中栏）、实跑中摇杆与「自动跑」仍完整可见、首屏把布局自检写进事件流、
#   停杆期间时长照走/配速跟着变大、③ 结束跑步上传结算；实跑中后端 live 进度真实推进（看 S.progress））
.venv/bin/python scripts/gui_probe.py --distance 1200 --speed 8

# 真实服务端连通性自检（不需要账号；会真的去 api.huachenjie.com 打请求，并实测滑块验证码）
.venv/bin/python scripts/realcheck.py --captcha-trials 5

.venv/bin/python -m shandong_school_cracked check      # 两个自检一起跑
```

---

## 六、目录结构

```
shandong-school_cracked/
├── shandong-school_cracked/                  # Python 后端（可独立当库用）
│   ├── constants.py        #   全部常量/密钥/端点表的唯一出口
│   ├── ciphers.py          #   可插拔密码学原语（pycryptodome→cryptography→纯标准库）
│   ├── crypto.py           #   签名、字段加解密、滑块混淆、结算码、DES
│   ├── protocol.py         #   几何、打卡点、轨迹生成、有效性判定、报文构造
│   ├── simulator.py        #   传感器仿真（FUCK-RUN- 移植：加速度/步检测/步频漂移）
│   ├── net.py              #   HTTP 传输层（公共字段、UA、签名、Cookie、代理）
│   ├── walker.py           #   摇杆实走引擎（手动控向、沿路线巡航、采样、打卡）
│   ├── walk.py             #   实走会话（后台线程推进 + 增量落库 + 干跑/实跑）
│   ├── captcha.py          #   滑块验证码求解（无 OpenCV）
│   ├── client.py           #   业务门面：登录→备跑→开跑→上传→结算
│   ├── store.py            #   SQLite 记录库
│   ├── mock.py             #   离线 Mock 服务端（含服务端侧规则复核）
│   ├── engine.py           #   运行引擎：一次跑步的完整编排 + 断点续传
│   ├── bus.py              #   事件总线 + 配置存储
│   ├── app.py              #   GUI/CLI 共用的应用门面（含导出、记录管理）
│   ├── gui.py              #   pywebview 桌面外壳 / HTTP 降级
│   ├── cli.py              #   命令行
│   └── __init__.py, __main__.py
├── web/                    # 前端（原生 JS，无构建）
│   ├── index.html  ├── style.css  └── app.js
├── scripts/
│   ├── selfcheck.py        # 端到端自检
│   ├── webcheck.py         #   前端桥自检
│   ├── gui_probe.py        #   桌面外壳冒烟（真开窗口、点按钮、断言布局）
│   └── build_bin.py        #   打包单文件可执行程序（Linux/Windows 同一套）
├── packaging/              # PyInstaller 配置
│   ├── shandong-school_cracked.spec          #   打包描述（数据文件、可选 pywebview、图标、版本资源）
│   ├── launcher.py         #   打包入口（绝对导入）
│   ├── make_icon.py        #   图标生成脚本
│   └── icon.png, icon.ico
└── tests/                  # 单元测试（crypto/protocol/simulator/store/walker/e2e）
```

仓库根还放着与本工程配套的东西（不属于应用代码）：

| 路径 | 内容 |
|---|---|
| `.github/workflows/build-release.yml` | 打 tag 自动双平台构建 + 发 Release |
| `docs/desktop/协议说明.md` | 协议与逆向要点 |
| `docs/desktop/打包与发布.md` | 打包、发版、常见问题 |
| `docs/desktop/screenshots/` | README 用到的截图 |

---

## 七、免责与致谢

* 协议细节来自对本机 APK `com.huachenjie.shandong_school` v8.7.7 的**静态分析**与
  **服务端常量交叉验证**（字段密文逐字节一致）。
* 仿真模块参考并移植了 [BieFan1029/FUCK-RUN-](https://github.com/BieFan1029/FUCK-RUN-)（Xposed 模块）的
  传感器伪造思路；工程组织参考了 [Inverx/com.huachenjie.shandong_school](https://github.com/Inverx/com.huachenjie.shandong_school)。
* 本项目与其作者无关，仅作学习研究；请在合法合规范围内使用。

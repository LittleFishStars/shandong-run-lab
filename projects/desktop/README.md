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

![桌面工作台](../../docs/desktop/screenshots/gui-2-running.png)

> 上图是**高级 / 调试**里「一键跑」进行中的实拍（开启实时仿真，20 倍速）：中栏是**真实地图底图**（高德瓦片，
> 与记录坐标同为 GCJ-02，无需纠偏），围栏多边形、紫色编号打卡点与轨迹都叠加在底图之上，
> 轨迹按上传状态着色（已上传=绿、失败=红、待传=蓝），轨迹正一笔笔画出来；地图卡左上角就是
> 主流程四个按钮（拉取配置 / 选择起始点 / 开始跑步 / 结束跑步）。
>
> ![拉取配置后：地图上只有围栏](../../docs/desktop/screenshots/gui-3-fence-only.png)
>
> 这张是点「① 拉取配置」之后的样子：地图自动移到围栏处，**地图上只有围栏、没有打卡点**——
> 围栏数据里只有打卡点的**数量**，坐标要等开跑时由服务端下发（见「协议说明」§5.1.1），与原版一致。
>
> ![摇杆实走](../../docs/desktop/screenshots/gui-4-walk.png)
>
> 这张是**摇杆干跑**的实拍（摇杆就钉在地图右下角，随手就能推）：拖动摇杆（或按方向键）自己控制方向，轨迹实时长出来，
> 右栏事件流同步打印「实走中：X 米 / Y 步 / Z 打卡」；干跑全程**不升跑、不落库、不上传**。
>
> 实跑到**目标里程会自动结束**：结束时先补上没封口的尾段（步频尾段 / 配速尾段）并把
> 距离·时长·步数·有效性写回本地库，然后**自动补传轨迹并结算**（`walk.auto_settle`，
> 界面上的「到达目标自动结算」开关，默认开）。若关掉这个开关，就只停不结，
> 之后仍可点「④ 结束跑步」或「上传结算」手动补。
>
> ![图上选起点](../../docs/desktop/screenshots/gui-3-start-point.png)
>
> 这张是**图上选跑步起点**的实拍：点「② 选择起始点」后在地图上点一下，青色「起」标就是起点
> （落在围栏外会自动吸附进围栏，与边界留 10 米）；拿到电子围栏那一下镜头会自动飞到围栏上（
> 之后自己拖过镜头就不再抢镜，换围栏才会再飞一次）。同一个坐标同时决定开跑报文的 `lat`/`lng`、
> 实走轨迹的起点与路径规划的起点，并写进本地库，重启仍然生效。
>
> 另几张：`docs/desktop/screenshots/gui-1-init.png`（首屏——主流程 4 个按钮，地图右下角常驻摇杆与「手动（摇杆）」）、
> `docs/desktop/screenshots/gui-3-done.png`（跑完结算）。
>
> ![实跑边跑边落库](../../docs/desktop/screenshots/gui-5-walk-real.png)
>
> 这张是**实跑**（③ 开始跑步）的实拍：点③升跑拿到 `runRecordCode`，服务端**在响应里**才下发本次打卡点
> （`targetPoints`），地图随即画出紫色编号点与路线；这里点了一下右下角的「自动跑」，于是沿路线自动巡航、
> 边跑边落库——轨迹点每 3 秒一条、命中打卡点即刻写库（地图上 1 号紫点已转为**绿点**）、
> 步频段每 20 秒切一段、配速段每 50 米切一段（对齐原版 `CommonConfig.stepInterval=20` /
> `paceInterval=50`），左下「本次跑步」的打卡计数同步变成 `1/3`；不点「自动跑」就是全程手动，
> 靠右下角那只摇杆控方向。


* **左栏**：登录/注销、模式切换、围栏选择（可能多个）、目标距离与跑步参数（平均步频 ± 波动、
  步幅、配速、到达目标自动结算）、学校规则阈值与进度条。
  （服务端注入失败率、实时仿真开关、仿真倍速已从界面移除：失败率固定 0、仿真固定瞬间算完；
  这两个能力仍在 CLI / Mock 内部保留，只是不摆在主界面上。）
* **中栏**：**真实地图 + 矢量叠加**——底图用 Leaflet 渲染（底图可在「高级 / 调试」里切：高德路网 /
  高德卫星 / OSM / 无底图；选择存在浏览器 localStorage，不写后端配置，右侧标签会同步显示
  当前底图与坐标系统），其上叠加围栏多边形、规划路线与路点、打卡点编号（命中后紫转绿）、
  按状态着色的轨迹。地图卡固定钉在**页面上半部**，显示区域随卡片尺寸自适应
  （卡片尺寸变化会自动 `invalidateSize`，不会有瓦片错位或留白）。
  下方是本次跑步的实时进度条与统计。
  跑步过程中地图**每隔约 1.4 秒自动重绘**，轨迹一笔笔长出来，「本次跑步」面板同步累计
  距离/步数。实时仿真（按真实时间推进）现在只保留在 CLI：`gui --realtime --speed 8`，界面默认瞬间算完。
* **中栏（主流程四个按钮）**：地图左上角只剩一条主流程工具条，右侧一行提示直接告诉你下一步点哪儿，
  不再需要在一堆按钮里自己找路：
  * **① 拉取配置**：拉围栏与规则（围栏数据里只有打卡点**数量**，坐标要等开跑才由服务端下发）；
    拿到电子围栏后地图**自动移到围栏处**（见下）。
  * **② 选择起始点**：点它再在地图上点一下，那里就是起跑点（青色地标「起」，提示行显示坐标）；
    不选则默认围栏中心。
  * **③ 开始跑步**：升跑（`run/startSunRun_v2`）——服务端在这一步才下发本次的**真实打卡点**
    （`targetPoints`），地图随即画出紫色编号点与路线；轨迹点实时入库，提示行同步显示
    距离/步数/速度/打卡数。（开跑前地图上不画打卡点，与原版一致；“高级 / 调试”里的
    「只规划路径」画的是按围栏几何预估的预览点，会在回执里标 `estimated`。）
  * **④ 结束跑步**：停止记录 → 上传轨迹 → 结算；上传是后台线程，提示行显示进度百分比，跑完自动
    刷新右栏记录列表。没在跑时它是灰的。
  * **地图右下角常驻摇杆 + 「自动跑」**（不随「高级 / 调试」折叠，任何时候都看得见）：默认是**手动**——
    开跑后用摇杆（或方向键）自己控方向；点一下「自动跑」改为沿规划路线自动巡航（按钮点亮、状态行
    同步），再点一次交回摇杆；任何时候**推杆即接管**，自动巡航会立刻让位给手控。
    摇杆是「随时都在」的：它挂在**地图卡**上（不是地图区里），而地图区是 `overflow:hidden` 的——
    之前它挂在地图区里，窗口一矮、或者 ③ 开始跑步 后提示行变长把工具行撑高，地图区被压扁就会
    把整簇摇杆连同按钮一起裁掉（用户 2026-10-18 报的「点了开始跑步摇杆就没了、得全屏才看得到」）。
    现在即使地图区再矮也裁不到它；另外窗口变矮（非全屏）时它随视口自动缩一档（820 / 700 / 620 px 三档，
    同时收窄右下角边距），地图区优先保证装得下，「本次跑步」卡这时让位（内部滚动）
    ——**不用全屏也不会把摇杆裁掉**。
    第二个更隐蔽的原因（也是 2026-10-18 实测抓到的）：中栏的网格列原本是「内容尺寸」的，
    而主流程提示行 `#flow-info` 是 `nowrap` 长文案——它会按自己的全文宽度把地图卡撑到 **622px**
    （而中栏只有 342px），绝对定位的摇杆按卡片右边缘摆到中栏之外，被 `.col-mid{overflow:hidden}`
    整块裁掉；DOM 里矩形、可见性、`offsetParent` 全部正常，屏幕上什么都没有。
    现在中栏列宽固定为栏宽（`grid-template-columns: minmax(0, 1fr)` + `.col-mid > .card{min-width:0}`），
    卡片不再被内容撑宽，提示行自己省略号收尾。
    兜底与取证：前端每次**加载 / 开跑 / 结束 / 改窗口大小**都会实测一次「卡片・地图区・摇杆簇」的矩形，
    越出卡片就自动夹回去（必要时整体缩一档），并把结果回传后端写成事件流里的
    `界面自检：{…}`（同时落 `app.log`）——以后“某个控件看不见”能直接从日志定位，不用等用户截图。
* **中栏（高级 / 调试）**：其余控件全部收进地图卡上的「高级 / 调试」折叠区（默认折叠，需要时才展开，
  功能一个没少）：
  * **只规划路径 / 点选路点 / 清除起点 / 适应**：按打卡点做最近邻排序连成一条闭环，或点「点选路点」
    在地图上依次点击，画出的路线只渲染（黄色折线 + 白色路点），**不升跑、不落库、不上传**；
    「清除起点」回到围栏中心。
  * **起点的细节**：② 选的起点落在围栏外会**自动吸附进围栏**（与边界留 10 米，既不在围栏中心、
    也不贴边，避免 GPS 抖动被判出界），同一个坐标同时决定**开跑报文的 `lat`/`lng`**、
    **实走轨迹的起点**与**路径规划的起点**，并写进本地库（重启不丢）。
  * **镜头跟随围栏**：备跑拿到电子围栏后地图**自动移到围栏处**（按围栏指纹判断，换围栏才重飞），
    不用手工去拖地图找围栏。
  * **摇杆 / 方向键 / 自动跑**：摇杆在右下角常驻（不在这块折叠区里）——拖动摇杆或按方向键实时控制
    前进方向，位置、步数、步频、加速度逐帧推进；点「自动跑」沿规划路线自动巡航，推杆会自动接管。
  * **干跑调试 / 停止 / 上传结算 / 存草稿**：干跑只推位置与传感器数据，不升跑、不写库、不上传
    （步频段与配速段只在内存里切，状态栏显示“内存已切 N 个步频段”）；实跑单开要「先开跑」，
    然后**边跑边落库**——链路逐项对齐原 App：定位回调 3 秒一条、`H0` 精度/速度过滤
    （精度 ≤ 50 米、两点间距 ≤ 10.438 m/s）、距离只按**有效点折线**累加、命中打卡点即刻
    `mark_checkpoint_hit`（半径 = `validDistance` 25 米，地图上紫点转绿）、步频段每 20 秒切一段、
    配速段每 50 米切一段，收尾还会把距离/步数/有效性写回 `runs`（界面上的**时长按墙钟走**——原版 `DataComponent.Q0()`：站着不动也照走表，所以原地歇着配速会一路变慢；配速 = 时长 ÷ 公里数，即原版 `J0()`）；单独点「上传结算」走与一键跑
    完全相同的链路（④ 结束跑步就是把“停止 + 上传结算”串成一步）。
  * **整场仿真**：一键跑完整链路 / 断点续传 / 保存参数 / 换 deviceId，以及底图切换与显示开关。
  * **配速**：摇杆推满时的配速，界面上按 `分'秒"/公里` 填（默认 6'40"，约 2.5 m/s，正常慢跑 6'~7'30"）；
    保存时换算成后端 `walk.speed_mps`，夹在 0.5~6 m/s；实走按真实时间推进（固定 1 倍速）。
* **右栏**：事件流（请求/响应/状态/进度/Mock 注入分色显示）、**服务器记录**（`run/pageSunRunRecord`
  分页，只读，以服务端为准）、打开数据目录。点某条记录时信息显示在「本次跑步」卡里，
  卡下不再有详情面板（详情接口 `run/runRecordDetail` 仍保留在后端与 CLI 能力中）。
  本地库仍由引擎与断点续传使用，但界面不再展示；导出/删除/续传仍在 CLI（`records`）。
* **右栏高度与联动**：「本次跑步」与「服务器记录」按 **1 : 2** 分配高度（1/3 、 2/3，内容超出时卡内滚动）。
  点某条服务器记录时，该记录的距离 / 有效距离 / 时长 / 配速 / 步数 / 开始时间 / 状态会显示到「本次跑步」卡里；
  跑步中该卡仍然跟随实时的距离与步数；开跑时会自动退回实时显示。

---

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
#   拉取配置后镜头飞到围栏、图上选起点、拉取配置后地图上没有打卡点、③ 开始跑步后才拿到服务端下发的打卡点、
#   点「自动跑」才沿路线巡航、窗口压矮时右下角摇杆簇不被裁掉、摇杆中心点命中的是摇杆本身
#   （卡片没被提示行撑出中栏）、实跑中摇杆与「自动跑」仍完整可见、首屏把布局自检写进事件流、
#   停杆期间时长照走/配速跟着变大、④ 结束跑步上传结算；实跑中后端 live 进度真实推进（看 S.progress））
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

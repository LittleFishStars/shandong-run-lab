# 闪动校园·阳光跑 桌面工作台（shandong-run-lab）

一个用 Python 重写的**桌面程序**，把「闪动校园」（`com.huachenjie.shandong_school`）阳光跑的整条链路
从 App 里搬出来：**登录 → 选围栏/规则 → 开跑 → 轨迹与步频记录 → 分批上传 → 结算**，
并且内置一套**离线 Mock 服务端**与**传感器仿真器**（移植自 [FUCK-RUN-](https://github.com/BieFan1029/FUCK-RUN-)），
不开手机、不连服务器也能把全流程跑通、看数据、调参数。

界面是本地 Web（HTML/CSS/JS，无构建链），由 **pywebview** 装进原生窗口；没有 pywebview 时自动降级成
「本地 HTTP + 浏览器」，功能完全一致。

> ⚠️ **用途声明**：本项目仅用于**个人学习、协议研究与本地仿真调试**。请勿用于任何
> 影响真实校园跑数据、或与自身无关的账号。默认运行在 **Mock 模式**（纯本地，不发出任何真实请求）。

---

## 一、它能做什么

| 环节 | 能力 |
| --- | --- |
| 登录 | `loginCheck` → 滑块验证码（内置不依赖 OpenCV 的缺口求解）→ `loginPassword`；会话与 deviceId 持久化 |
| 备跑 | 拉学期、围栏列表（多边形）、阳光跑规则（配速/距离/打卡/步幅阈值）、跑量计划，解析成规则对象 |
| 开跑 | 九参数开跑报文，写入本地 SQLite（记录号、打卡点、围栏） |
| 记录 | 轨迹点（3 秒一采）、分段步数（3 秒一段）、分段配速、步幅、打卡点命中，全部落库 |
| 上传 | `uploadRunRecord`（★唯一需要签名的接口，分批 50 点）→ 分段步数/配速/步幅 → 打卡点 |
| 结算 | 一次性提交 `pois + stepList + paceList + runRecordCode`，服务端回 `status / invalidReasons` |
| 调试 | Mock 服务端（可注入延迟与随机失败率）、传感器仿真器（步频/抖动/丢包/暂停）、事件流面板、本地记录浏览、JSON/GPX 导出 |
| 续传 | 断点续传：只补传「未成功」的点/段，含尾部补齐段 |

---

## 二、安装

需要 Python 3.10+（本机实测 3.14）。Arch Linux：

```bash
# 依赖（大多数系统已自带 requests/cryptography/Pillow）
sudo pacman -S --needed python-requests python-cryptography python-pillow

cd shandong-run-lab
python3 -m venv --system-site-packages .venv       # 继承系统包，省一次下载
.venv/bin/pip install pywebview                    # 桌面窗口（可选，缺了就自动走浏览器）
.venv/bin/pip install pycryptodome                 # 可选，密码学后端更快（没有则用 cryptography）
```

`pycryptodome` / `cryptography` / 纯标准库三种密码学后端会自动择优（见 `sdlab/ciphers.py`），
**全部缺失也能跑**（内置纯 Python AES）。

## 三、运行

```bash
# ① 桌面窗口（默认命令；Mock 模式，纯本地）
.venv/bin/python -m sdlab

# ② 不开窗口，用浏览器（端口随机，终端会打印地址）
.venv/bin/python -m sdlab gui --browser

# ③ 命令行跑一次完整流程（不开界面，适合脚本化 / 排错）
.venv/bin/python -m sdlab run -d 2000            # 2000 米
.venv/bin/python -m sdlab run -d 1500 --no-upload --json | tail -40

# ③′ 实时仿真：按真实时间推进数据写入，能在界面上看到轨迹一笔笔长出来（调试友好）
#     默认关闭（瞬间算完）。倍速 8 ≈ 真实跑步耗时的 1/8。
.venv/bin/python -m sdlab run -d 1200 --realtime --speed 8

# ④ 只起 Mock 服务端（给别的东西当靶子）
.venv/bin/python -m sdlab mock --port 8899 --latency 200 --fail-rate 0.3

# ⑤ 其它
.venv/bin/python -m sdlab info                   # 环境信息（后端、数据目录、默认目标）
.venv/bin/python -m sdlab login --prepare        # 登录并拉围栏/规则
.venv/bin/python -m sdlab records list           # 本地记录
.venv/bin/python -m sdlab records show --points  # 明细（含轨迹点）
.venv/bin/python -m sdlab records export MCKXXXX --format gpx
.venv/bin/python -m sdlab records resume MCKXXXX # 断点续传
.venv/bin/python -m sdlab check -v               # 跑自检（等价下面两脚本）
```

连真实服务器（请自行评估并自负后果）：

```bash
.venv/bin/python -m sdlab --real -p 手机号 -w 密码 run -d 2000
# 或临时用代理观察流量：
.venv/bin/python -m sdlab --proxy http://127.0.0.1:8080 gui
```

### 界面速览

![桌面工作台](docs/screenshots/gui-2-running.png)

> 上图是「一键跑」进行中的实拍（开启实时仿真，40 倍速）：中栏地图上轨迹正一笔笔画出来，
> 紫色编号是服务端下发的打卡点，进度条与左侧参数面板同步刷新。另有两张：
> `docs/screenshots/gui-1-init.png`（首屏）、`docs/screenshots/gui-3-done.png`（跑完结算）。


* **左栏**：登录/注销、模式切换、围栏选择、目标距离与仿真参数（步频区间、步幅、失败率）、
  一键备跑 / 开跑 / 续传、学校规则阈值。
* **中栏**：Canvas 地图 —— 围栏多边形、打卡点编号、轨迹点按状态着色
  （已上传=绿、失败=红、待传=蓝）；下方是本次跑步的实时进度条与统计。
  勾选「实时仿真」后，跑步过程中地图**每隔约 1.4 秒自动重绘**，轨迹一笔笔长出来，
  「本次跑步」面板同步累计距离/步数——专门为观察逐点行为而做（默认关，关掉就是秒算完）。
* **右栏**：事件流（请求/响应/状态/进度/Mock 注入分色显示）、本地记录列表与明细、
  导出 JSON/GPX、删除、打开数据目录。

---

## 四、数据与配置

| 内容 | 默认路径 |
| --- | --- |
| 配置 | `~/.config/shandong-run-lab/config.json` |
| 数据目录（SQLite / 导出） | `~/.local/share/shandong-run-lab/` （记录库 `records.db`） |
| 环境变量覆盖 | `SDLAB_HOME=/some/dir` 或 `--data-dir`（沙箱/便携场景用） |

数据库表：`runs`（记录头）、`points`（轨迹点）、`steps` / `paces`（分段）、`checkpoints`（打卡点）、
`upload_log` / `api_log`（上传与接口日志）、`kv`（会话与配置缓存）。WAL 模式，短连接，线程安全。

---

## 五、自检与测试

```bash
export SDLAB_HOME=$PWD/.run          # 沙箱内 ~/.local/share 只读时必加

# 单元测试（104 项）
.venv/bin/python -m unittest discover -s tests

# 端到端自检（36 项：密码学 / 仿真 / 全链路 / 失败注入+续传）
.venv/bin/python scripts/selfcheck.py -v

# 前端桥自检（27 项：用和浏览器一模一样的 HTTP 调用驱动后端）
.venv/bin/python scripts/webcheck.py

.venv/bin/python -m sdlab check      # 两个自检一起跑
```

---

## 六、目录结构

```
shandong-run-lab/
├── sdlab/                  # Python 后端（可独立当库用）
│   ├── constants.py        #   全部常量/密钥/端点表的唯一出口
│   ├── ciphers.py          #   可插拔密码学原语（pycryptodome→cryptography→纯标准库）
│   ├── crypto.py           #   签名、字段加解密、滑块混淆、结算码、DES
│   ├── protocol.py         #   几何、打卡点、轨迹生成、有效性判定、报文构造
│   ├── simulator.py        #   传感器仿真（FUCK-RUN- 移植：加速度/步检测/步频漂移）
│   ├── net.py              #   HTTP 传输层（公共字段、UA、签名、Cookie、代理）
│   ├── captcha.py          #   滑块验证码求解（无 OpenCV）
│   ├── client.py           #   业务门面：登录→备跑→开跑→上传→结算
│   ├── store.py            #   SQLite 记录库
│   ├── mock.py             #   离线 Mock 服务端（含服务端侧规则复核）
│   ├── engine.py           #   运行引擎：一次跑步的完整编排 + 断点续传
│   ├── bus.py              #   事件总线 + 配置存储
│   ├── app.py              #   GUI/CLI 共用的应用门面（含导出、记录管理）
│   ├── gui.py              #   pywebview 桌面外壳 / HTTP 降级
│   ├── cli.py              #   命令行
│   └── bus.py, __init__.py, __main__.py
├── web/                    # 前端（原生 JS，无构建）
│   ├── index.html  ├── style.css  └── app.js
├── scripts/
│   ├── selfcheck.py        # 端到端自检
│   └── webcheck.py         # 前端桥自检
├── tests/                  # 单元测试（crypto/protocol/simulator/store/e2e）
└── docs/协议说明.md         # 协议与逆向要点
```

---

## 七、免责与致谢

* 协议细节来自对本机 APK `com.huachenjie.shandong_school` v8.7.7 的**静态分析**与
  **服务端常量交叉验证**（字段密文逐字节一致）。
* 仿真模块参考并移植了 [BieFan1029/FUCK-RUN-](https://github.com/BieFan1029/FUCK-RUN-)（Xposed 模块）的
  传感器伪造思路；工程组织参考了 [Inverx/com.huachenjie.shandong_school](https://github.com/Inverx/com.huachenjie.shandong_school)。
* 本项目与其作者无关，仅作学习研究；请在合法合规范围内使用。

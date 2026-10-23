# 贡献指南

面向**开发/逆向贡献者**。只想跑起来用，看根目录 [README](README.md)；工程内各目录说明见 `work/README.md`、`report/README.md`。

## 仓库结构速览

```
ShanDong/
├── samples/     原始样本（唯一 APK，只读，Git LFS）
├── report/      分析报告 01–24（逆向结论唯一出处）
├── docs/        整理记录（协议说明 / 打包发布 / 清理记录）
├── reference/   签名算法参考实现 + 外部规格
├── scripts/     逆向脚本（dump / 脱壳 / 签名 / 核对）
├── work/        逆向工作区（dex/ native/ evidence/ dumps/ records/ meta/ toolchain/）
├── projects/
│   └── desktop/ ★ 桌面工作台 shandong-school_cracked（Python 包，GUI+CLI）
└── .github/workflows/  CI（打 tag 双平台构建 + Release）
```

## 桌面工作台（projects/desktop/）

**想改哪里**

| 想改什么 | 模块 |
|---|---|
| 协议常量 / 密钥 / 接口表 | `shandong_school_cracked/constants.py` |
| 加解密、签名、滑块、结算码 | `ciphers.py` / `crypto.py` |
| 轨迹、打卡点、报文构造 | `protocol.py` |
| 摇杆实走 / 实走会话 | `walker.py` / `walk.py` |
| 登录 → 备跑 → 开跑 → 上传 → 结算 | `client.py` |
| SQLite 记录库 | `store.py` |
| 离线 Mock 服务端 | `mock.py` |
| 一次跑步完整编排 + 断点续传 | `engine.py` |
| GUI/CLI 门面 | `app.py` / `gui.py` / `cli.py` |
| 前端（原生 JS） | `web/`（`index.html` / `style.css` / `app.js`） |
| 打包单文件 | `scripts/build_bin.py` + `packaging/` |

完整模块图见 [`projects/desktop/README.md`](projects/desktop/README.md)。

### 环境与运行

```bash
cd projects/desktop
python3 -m venv --system-site-packages .venv        # Arch：继承系统包
.venv/bin/pip install pywebview pycryptodome        # 可选：原生窗口 / 更快密码学后端
.venv/bin/python -m shandong_school_cracked         # 跑起来（GUI）
```

密码学后端 `pycryptodome → cryptography → 纯标准库` 自动择优，全缺失也能跑（内置纯 Python AES）。

### 测试与自检

```bash
cd projects/desktop
.venv/bin/python -m unittest discover -s tests -q        # 单元测试（187 项）
.venv/bin/python scripts/selfcheck.py -v                 # 端到端自检（68 项）
.venv/bin/python scripts/webcheck.py                     # 前端桥自检（59 项）
.venv/bin/python scripts/gui_probe.py --distance 1200    # 桌面外壳冒烟（真开窗口、点按钮）
.venv/bin/python -m shandong_school_cracked check        # 两个自检一起跑
```

### 打包与发布

```bash
cd projects/desktop && .venv/bin/python scripts/build_bin.py --zip   # 本平台单文件
```

细节（PyInstaller spec、图标、版本资源）见 `docs/desktop/打包与发布.md`。

## 逆向工作（report/ scripts/ work/）

- `samples/` **只读**：脚本默认从 `samples/com.huachenjie.shandong_school.apk` 取样本。
- `work/` 只留证据与输入：`report/` 每条结论都标了对应路径，不要对 `work/` 做破坏性修改。
- `tmp/` 可随时清；只保留可重建的中间产物。
- 新增结论进 `report/`，配套脚本放 `report/` 旁的 `scripts/`；整理/归档记录更新 `docs/`。
- 逆向常用复现命令见 `work/README.md` 的「常用复现命令」。

## 提交与推送

- 代码 / 报告改动**提交并推送**。
- **本机推送**：本机 `/etc/ssh` 配置属主异常，需用仓库包装脚本：

  ```bash
  GIT_SSH_COMMAND="$PWD/scripts/git-ssh-wrap.sh" git push origin main
  ```

## CI

`.github/workflows/build-release.yml`：push 以 `v*` 开头的 tag → 双平台（Linux/Windows）构建单文件可执行程序 → 发 GitHub Release；手动触发只构建不发版。测试在 `projects/desktop` 下跑（Windows 侧测试失败仅告警不阻断）。
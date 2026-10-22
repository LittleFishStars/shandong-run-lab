# work/ —— 逆向工作区

**唯一权威输入是 `../samples/com.huachenjie.shandong_school.apk`**；这里的东西都是它的派生物。
`../report/` 的每条结论都标了对应路径，删目录前先确认没有报告在引用。

```
work/
├── dex/            ★ 反编译与 dex 产物
│   ├── APP_ALL4/         脱壳成果：16 个 DEX、108,363 个类（一切分析的事实来源）
│   ├── jadx_FULL/        jadx 全量反编译（注释里带原始 dex 文件名）
│   ├── jadx_shell/       壳 DEX 的 jadx 输出（报告 01 引用）
│   ├── rebuild/          早期容器 DEX 重建的输入与脚本（报告 03 的否证过程）
│   ├── shell_full.dex    壳 DEX 片段（80 K）
│   └── stars_hidden.dex  插件里的 stars dex（报告 02 引用）
│
├── native/         ★ 原生层证据
│   ├── （本级）            libart.so、wrapper smali、sigcheck、探针目录
│   ├── lib/              按 ABI 分目录的 SO（arm64-v8a / armeabi-v7a）
│   ├── allso/            从 APK 解出的全部 SO（179 个）
│   ├── hidden_so3/       运行时从内存里抠出来的隐藏 SO
│   ├── ghidra_blob/      Ghidra 工程/反汇编产物
│   ├── liby_runtime/     liby.so 的运行时处理结果
│   └── liby_segs/        liby 各段落的原始数据
│
├── evidence/       ★ 静态证据
│   ├── certs/            APK 签名证书、SSL pinning 证书
│   ├── blob_info/        解密后的 blob 与元信息
│   ├── plugins/          三方插件载荷（AdxSdk/gdtadv2/jy/kcbw/lywm/stars/zj…）
│   └── jars/             从插件里抽出的 jar
│
├── dumps/          内存 dump 与易盾 payload
│   ├── dump/  dump_final/  老一轮的 dump 输出目录
│   ├── dump_nesec_*        nesec 内存分块
│   ├── liby/  liby_proc_dec.bin
│   └── shots/              设备截图
│
├── records/        运行时记录
│   ├── notes/            抓取日志、trace、map、参数表（37 个 txt）
│   ├── logs/             构建/重签/运行会话日志（logs/run-sessions/ 为会话记录）
│   └── frida/            Frida 脚本与各轮输出（scripts/ + *_out.txt）
│
├── scripts/        工作区内的分析脚本（26 个 py + 5 个 sh）
├── meta/           盘点清单与产出（inventory、manifest、plugin_risk、yidun_*、domains/urls）
├── toolchain/      工具链（apktool.jar、smali/baksmali、frida-server、.venv-frida、node_modules）
├── noshell.keystore  重打包用的签名密钥（原 android-rebuild 用）
└── README.md       本文件
```

## 常用复现命令

```bash
cd ..                                     # 回到仓库根

# 样本里的壳 classes.dex（work/peek 已清理，按需现场解包）
unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex

# 反编译（dex/jadx_FULL 的再生方式）
jadx -d work/dex/jadx_FULL --no-res samples/com.huachenjie.shandong_school.apk

# 清单类脚本（产出统一进 work/meta/）
python3 scripts/assets_inventory.py
python3 scripts/sdk_inventory.py
python3 scripts/parse_manifest.py
```

## 路径约定

`report/` 里的 01–24 号报告写的是**整理前**的路径（`work/APP_ALL4`、`work/jadx_FULL` 等），
对应关系见 `../report/README.md` 与 `../docs/CLEANUP-2026-10-22.md` 第八节。
`scripts/` 下的脚本已全部改为新路径。

## 已清理、需要时可再生

`android-sdk/`（模拟器镜像，6 G）、`jadx_V2/`（残缺）、`rebuilt/`、`peek/`、`apks/`、
`jadx_plugins/`、`reference/`、`tools/fs` 等。详见 `../docs/CLEANUP-2026-10-22.md`。

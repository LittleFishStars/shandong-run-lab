# 闪动校园（com.huachenjie.shandong_school v8.7.7）应用图标提取

来源：`samples/com.huachenjie.shandong_school.apk` → `res/mipmap*/ic_launcher*`

Manifest 声明：`application android:icon=@0x7f100078`（aapt badging 确认为 `res/mipmap/ic_launcher`），
应用名「闪动校园」，无 roundIcon。主图标为蓝色闪电形「S」。

## 文件清单

| 文件 | 原始路径 | 尺寸 | 说明 |
|---|---|---|---|
| ic_launcher_192.png | res/mipmap-xxxhdpi-v4/ic_launcher.png | 192×192 | **主图标最高清** |
| ic_launcher_144.png | res/mipmap-xxhdpi-v4/ic_launcher.png | 144×144 | xxhdpi |
| ic_launcher_96.png | res/mipmap-xhdpi-v4/ic_launcher.png | 96×96 | xhdpi |
| ic_launcher_adaptive_fg_324.png | res/drawable-xxxhdpi-v4/ic_launcher_foreground_trimmed.png | 324×324 | 自适应图标前景（透明底） |
| ic_launcher_white_96.png | res/mipmap-xxxhdpi-v4/ic_white_launcher.png | 96×96 | 白色单色版（深色底用） |
| ic_launcher_white_72.png | res/mipmap-xxhdpi-v4/ic_white_launcher.png | 72×72 | 白色单色版 |
| ic_launcher_default_placeholder.webp | res/mipmap/ic_launcher.webp | 144×144 | 默认密度占位（未替换的安卓机器人图） |
| placeholders/ | — | — | 广告 SDK 模块的同名占位 launcher（lt/ms/ssd，安卓机器人）及自适应图标二进制 xml |

## 备注

- `res/mipmap/ic_launcher.webp`（无密度限定符）是安卓机器人默认占位图；真机按密度取
  xxxhdpi/xxhdpi/xhdpi 的真实图标。aapt badging 报的默认 icon 即该占位图。
- 自适应图标由 `ic_launcher_ext.xml（adaptive-icon）+ background（纯色 vector）+ foreground（inset→trimmed png）` 组成，
  xml 为编译态二进制，位于 placeholders/。
- 预览对照图：preview.png（深灰底，白/透明图标可见）。

#!/usr/bin/env bash
# 闪动校园 · 安卓版前端构建脚本
# 在 projects/android/web/ 下执行 esbuild 打包，产物输出到 app/src/main/assets/web/
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"   # projects/android/
WEB="$ROOT/web"
OUT="$ROOT/app/src/main/assets/web"

echo "==> 构建闪动校园安卓前端"
echo "    源码目录: $WEB"
echo "    产物目录: $OUT"

cd "$WEB"

# 1) 安装依赖（有 node_modules 就跳过）
if [ ! -d node_modules ]; then
  echo "==> npm install ..."
  npm install
else
  echo "==> node_modules 已存在，跳过 npm install"
fi

# 2) esbuild 打包
echo "==> esbuild 打包 ..."
node_modules/.bin/esbuild src/main.jsx \
  --bundle --minify --format=iife --target=es2018 \
  --loader:.js=jsx \
  --outfile="$OUT/app.bundle.js"

# 3) 复制静态资源
echo "==> 复制静态资源 ..."
mkdir -p "$OUT/vendor" "$OUT/assets"

# index.html
cp index.html "$OUT/index.html"

# style.css
cp src/style.css "$OUT/style.css"

# vendor/
cp -r vendor/leaflet "$OUT/vendor/"

# assets/
cp -r assets/. "$OUT/assets/"

# 图标：用 work/icons/ic_launcher_192.png 复制为 assets/app-icon.png
if [ -f "$ROOT/../work/icons/ic_launcher_192.png" ]; then
  cp "$ROOT/../work/icons/ic_launcher_192.png" "$OUT/assets/app-icon.png"
elif [ -f "$WEB/assets/app-icon.png" ]; then
  cp "$WEB/assets/app-icon.png" "$OUT/assets/app-icon.png"
fi

# 4) 验证
BUNDLE_SIZE=$(stat -c%s "$OUT/app.bundle.js" 2>/dev/null || echo 0)
echo ""
echo "==> 构建完成"
echo "    app.bundle.js: $(du -h "$OUT/app.bundle.js" | cut -f1) ($BUNDLE_SIZE bytes)"
echo "    产物目录内容:"
ls -la "$OUT"

if [ "$BUNDLE_SIZE" -lt 51200 ]; then
  echo "!! 警告：app.bundle.js 小于 50KB，构建可能有问题"
fi

echo "==> 构建成功 ✓"
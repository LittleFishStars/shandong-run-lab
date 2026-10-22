#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""流式 Frida runner：边收消息边落盘，避免管道缓冲导致「无输出」。

用法:
    python3 work/run_live.py <bundle.js> <out.txt> [等待秒数]

改进点（吸取前几轮挂死教训）:
  1. 每条消息立即 flush 到文件与 stdout，不进 tail 管道
  2. 顶层 try/except + 硬超时，进程必退
  3. spawn 后先 resume 再等，最后强制 kill 应用避免僵尸堆积
"""
from __future__ import annotations

import pathlib
import sys
import time

import frida

PKG = "com.huachenjie.shandong_school"


def main() -> int:
    if len(sys.argv) < 3:
        print(__doc__)
        return 2
    bundle = pathlib.Path(sys.argv[1])
    out = pathlib.Path(sys.argv[2])
    wait_s = float(sys.argv[3]) if len(sys.argv) > 3 else 55.0

    lines: list[str] = []
    fh = out.open("w", encoding="utf-8")

    def emit(text: str) -> None:
        print(text, flush=True)
        lines.append(text)
        fh.write(text + "\n")
        fh.flush()

    dev = None
    sess = None
    pid = None
    try:
        dev = frida.get_usb_device(timeout=20)
        pid = dev.spawn([PKG])
        emit(f"[*] spawned pid={pid}")
        sess = dev.attach(pid)
        sc = sess.create_script(bundle.read_text(encoding="utf-8"))

        def on_message(msg, data):
            if msg.get("type") == "error":
                emit("[err] " + str(msg.get("description"))[:300])
            elif msg.get("type") == "send":
                p = msg.get("payload") or {}
                t = p.get("t")
                if t == "log":
                    emit("[js] " + str(p.get("msg")))
                elif t in ("rn", "fn", "mid", "dumpmeta", "base"):
                    emit(f"[{t}] " + str(p))
                elif t == "newexec":
                    # ★ 二进制 dump：name + 可选 append
                    nm = str(p.get("name", "dump"))
                    dst = out.parent / ("dump_" + "".join(
                        c if c.isalnum() or c in "._-" else "_" for c in nm) + ".bin")
                    try:
                        raw = bytes(data) if data else b""
                        if raw and p.get("append"):
                            with dst.open("ab") as fh2:
                                fh2.write(raw)
                        elif raw:
                            dst.write_bytes(raw)
                        emit(f"[dump] {dst.name} {len(raw)} B")
                    except Exception as exc:  # noqa: BLE001
                        emit(f"[dump-err] {exc}")
                elif t == "chunk":
                    emit(f"[chunk] off=0x{p.get('off', 0):x} size={p.get('size')}")

        sc.on("message", on_message)
        sc.load()
        emit("[*] script loaded")
        dev.resume(pid)

        t0 = time.time()
        while time.time() - t0 < wait_s:
            time.sleep(1.0)
            try:
                alive = pid in {p.pid for p in dev.enumerate_processes()}
            except Exception:
                alive = False
            if not alive:
                emit("[!] 进程已退出")
                break
        emit("[*] 等待结束")
        try:
            sc.unload()
        except Exception:
            pass
    except Exception as exc:  # noqa: BLE001
        emit(f"[!] 异常: {type(exc).__name__}: {exc}")
    finally:
        if sess is not None:
            try:
                sess.detach()
            except Exception:
                pass
        if pid is not None:
            try:
                frida.get_usb_device(timeout=10).kill(pid)
                emit(f"[*] 已 kill pid={pid}")
            except Exception:
                pass
        fh.close()
    print(f"\n[*] {len(lines)} 行 → {out}", flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())

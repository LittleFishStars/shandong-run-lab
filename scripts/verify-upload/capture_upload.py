#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""采集一次跑步里客户端发往服务端的全部上传报文（用于跨版本一致性核对）

用法：
    python capture_upload.py <包名> <代码根目录> <输出json> <临时目录>
例：
    python capture_upload.py sdlab                   /tmp/baseline-v1.1.0 /tmp/upload-baseline.json /tmp/run-baseline
    python capture_upload.py shandong_school_cracked projects/desktop     /tmp/upload-current.json  /tmp/run-current

整条链路走本地 Mock 服务端（不碰真实网络）；固定种子/目标距离，保证两版可比。
"""
import copy
import json
import sys
from pathlib import Path

UPLOAD = {"upload_record", "upload_pace", "upload_step", "upload_stride",
          "upload_passpoint", "finish_sun_run", "abnormal_finish"}


def main(argv):
    if len(argv) != 5:
        print(__doc__)
        return 2
    pkg, root, out, tmp = argv[1], argv[2], argv[3], Path(argv[4])
    sys.path.insert(0, root)
    App = __import__(pkg + ".app", fromlist=["App"]).App

    app = App(data_dir=tmp / "data", config_path=tmp / "config.json", mode="mock")
    records = []
    orig = app.client.transport.post

    def spy(name, payload=None, **kw):
        if name in UPLOAD:
            records.append({"name": name, "payload": copy.deepcopy(payload or {})})
        return orig(name, payload, **kw)

    app.client.transport.post = spy
    print("login:", app.login("13800138000", "any-password", False).get("code"))
    print("prepare:", app.run_prepare().get("code"))
    print("run_auto:", app.run_auto(target_m=1200, fence_index=0, seed=20261023,
                                    do_upload=True, do_finish=True, sport_type=1).get("code"))
    if app._thread:
        app._thread.join(180)
    json.dump(records, open(out, "w", encoding="utf-8"), ensure_ascii=False)
    print("记录数:", len(records), [x["name"] for x in records])
    app.close()
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv))

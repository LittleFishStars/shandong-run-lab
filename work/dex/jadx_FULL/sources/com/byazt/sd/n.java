package com.byazt.sd;

import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 46})
public class n implements com.byazt.zl.ve {
    @Override // com.byazt.zl.ve
    public void c(int i, String str, JSONObject jSONObject) {
        com.byazt.dd.tt ttVarC;
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (ttVarC = com.byazt.nn.a.c().c(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = u.c(jSONObject);
            com.byazt.di.c.c(jSONObject, downloadInfo);
            u.c(jSONObject, "model_id", Long.valueOf(ttVarC.tt()));
        }
        com.byazt.zn.c.c().tt(str, jSONObject, ttVarC);
    }

    @Override // com.byazt.zl.ve
    public void tt(int i, String str, JSONObject jSONObject) {
        com.byazt.dd.tt ttVarC;
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (ttVarC = com.byazt.nn.a.c().c(downloadInfo)) == null) {
            return;
        }
        com.byazt.zn.c.c().c(str, jSONObject, ttVarC);
    }
}

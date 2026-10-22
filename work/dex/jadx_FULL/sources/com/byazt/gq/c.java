package com.byazt.gq;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 20})
public class c implements com.byazt.hu.yp.c {
    public static final String c = "c";
    public static c tt;
    public long uj;
    public com.byazt.hu.yp ve = new com.byazt.hu.yp(Looper.getMainLooper(), this);

    private c() {
    }

    public static c c() {
        if (tt == null) {
            synchronized (c.class) {
                if (tt == null) {
                    tt = new c();
                }
            }
        }
        return tt;
    }

    public void c(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.byazt.nn.c cVar = new com.byazt.nn.c(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
        if (cVarC.c("back_miui_silent_install", 1) == 0 && ((com.byazt.i.n.u() || com.byazt.i.n.yp()) && com.byazt.w.da.c(t.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.byazt.w.a.c(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.ve.obtainMessage(200, cVar);
                messageObtainMessage.arg1 = 2;
                this.ve.sendMessageDelayed(messageObtainMessage, cVarC.c("check_silent_install_interval", 60000));
                return;
            }
            com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(cVar.tt);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            t.a().c(null, new BaseException(i, jSONObject.toString()), i);
            com.byazt.zn.c.c().c(com.byazt.dyf.tt.AD_TAG_FEED, "ah_result", jSONObject, ttVarUj);
        }
        if (com.byazt.hu.n.ve()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.uj;
            long jUj = com.byazt.hu.n.uj();
            if (jCurrentTimeMillis < com.byazt.hu.n.n()) {
                long jN = com.byazt.hu.n.n() - jCurrentTimeMillis;
                jUj += jN;
                this.uj = System.currentTimeMillis() + jN;
            } else {
                this.uj = System.currentTimeMillis();
            }
            com.byazt.hu.yp ypVar = this.ve;
            ypVar.sendMessageDelayed(ypVar.obtainMessage(200, cVar), jUj);
        }
    }

    private void c(com.byazt.nn.c cVar, int i) {
        int i2;
        if (t.t() == null || t.t().c() || cVar == null) {
            return;
        }
        if (2 == i) {
            com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(cVar.tt);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.byazt.hu.u.n(t.getContext(), cVar.uj)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            t.a().c(null, new BaseException(i2, jSONObject.toString()), i2);
            com.byazt.zn.c.c().c(com.byazt.dyf.tt.AD_TAG_FEED, "ah_result", jSONObject, ttVarUj);
        }
        if (com.byazt.hu.u.n(t.getContext(), cVar.uj)) {
            com.byazt.zn.c.c().tt("delayinstall_installed", cVar.tt);
            return;
        }
        if (!com.byazt.hu.u.c(cVar.sp)) {
            com.byazt.zn.c.c().tt("delayinstall_file_lost", cVar.tt);
        } else if (com.byazt.de.c.c().c(cVar.uj)) {
            com.byazt.zn.c.c().tt("delayinstall_conflict_with_back_dialog", cVar.tt);
        } else {
            com.byazt.zn.c.c().tt("delayinstall_install_start", cVar.tt);
            com.byazt.z.uj.c(t.getContext(), (int) cVar.c);
        }
    }

    @Override // com.byazt.hu.yp.c
    public void c(Message message) {
        if (message.what != 200) {
            return;
        }
        c((com.byazt.nn.c) message.obj, message.arg1);
    }
}

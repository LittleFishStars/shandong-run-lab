package com.byazt.tg;

import android.text.TextUtils;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 13})
public class tt implements sp {
    public static com.byazt.de.uj c;
    public static com.byazt.de.ve tt;

    public static com.byazt.de.ve tt() {
        return tt;
    }

    public static com.byazt.de.uj c() {
        return c;
    }

    public static void c(com.byazt.de.ve veVar) {
        tt = veVar;
    }

    @Override // com.byazt.tg.sp
    public boolean c(final com.byazt.dd.tt ttVar, int i, final x xVar, final com.byazt.de.ve veVar) {
        DownloadInfo downloadInfoTt;
        if (ttVar == null || !c(ttVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(ttVar.oz())) {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).c(ttVar.oz(), null, true);
        } else {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).tt(ttVar.c());
        }
        if (downloadInfoTt == null) {
            return false;
        }
        long jC = com.byazt.gq.da.c(downloadInfoTt.getId(), downloadInfoTt.getCurBytes(), downloadInfoTt.getTotalBytes());
        long totalBytes = downloadInfoTt.getTotalBytes();
        if (jC >= 0 && totalBytes > 0) {
            if (totalBytes <= c(ttVar.my())) {
                final int i2 = (int) (jC / 1048576);
                c = new com.byazt.de.uj() { // from class: com.byazt.tg.tt.1
                    @Override // com.byazt.de.uj
                    public void c() {
                        com.byazt.de.uj unused = tt.c = null;
                        tt.this.c(i2, i2, ttVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.byazt.de.uj
                    public void tt() {
                        com.byazt.de.uj unused = tt.c = null;
                        tt.this.c(i2, i2, ttVar, "apk_size_cancel", "cancel");
                        xVar.c(ttVar);
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", u.c(totalBytes - jC));
                if (veVar != null) {
                    c(new com.byazt.de.ve() { // from class: com.byazt.tg.tt.2
                        @Override // com.byazt.de.ve
                        public void delete() {
                            com.byazt.de.uj unused = tt.c = null;
                            tt.this.c(i2, i2, ttVar, "apk_size_cancel", "delete");
                            veVar.delete();
                        }
                    });
                }
                TTDelegateActivity.c(ttVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int c(int i) {
        return com.byazt.k.c.c(i).c("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean c(com.byazt.dd.c cVar) {
        return com.byazt.hu.n.c(cVar).c("cancel_pause_optimise_apk_retain_switch", 0) == 1 && cVar.nu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, com.byazt.dd.tt ttVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("pause_cancel_optimise", jSONObject, ttVar);
    }
}

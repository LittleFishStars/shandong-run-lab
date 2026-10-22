package com.byazt.tg;

import android.text.TextUtils;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 54})
public class ve implements sp {
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
        String str;
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
        long curBytes = downloadInfoTt.getCurBytes();
        long totalBytes = downloadInfoTt.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int iC = com.byazt.gq.da.c(downloadInfoTt.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i2 = (int) (curBytes / 1048576);
        boolean z = iC > c(ttVar.my());
        c = new com.byazt.de.uj() { // from class: com.byazt.tg.ve.1
            @Override // com.byazt.de.uj
            public void c() {
                com.byazt.de.uj unused = ve.c = null;
                ve.this.c(iC, i2, i2, ttVar, "download_percent_cancel", "confirm");
            }

            @Override // com.byazt.de.uj
            public void tt() {
                com.byazt.de.uj unused = ve.c = null;
                ve.this.c(iC, i2, i2, ttVar, "download_percent_cancel", "cancel");
                xVar.c(ttVar);
            }
        };
        String strC = u.c(com.byazt.gq.da.c(ttVar.my(), curBytes, totalBytes));
        if (z) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strC, u.c(totalBytes - curBytes));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strC);
        }
        String str2 = str;
        if (veVar != null) {
            c(new com.byazt.de.ve() { // from class: com.byazt.tg.ve.2
                @Override // com.byazt.de.ve
                public void delete() {
                    com.byazt.de.uj unused = ve.c = null;
                    ve.this.c(iC, i2, i2, ttVar, "download_percent_cancel", "delete");
                    veVar.delete();
                }
            });
        }
        TTDelegateActivity.tt(ttVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int c(int i) {
        return com.byazt.k.c.c(i).c("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean c(com.byazt.dd.c cVar) {
        return com.byazt.hu.n.c(cVar).c("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && cVar.nu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, int i3, com.byazt.dd.tt ttVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("pause_cancel_optimise", jSONObject, ttVar);
    }
}

package com.byazt.tg;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 34})
public class a implements i {
    public static com.byazt.de.uj c;

    public static com.byazt.de.uj c() {
        return c;
    }

    @Override // com.byazt.tg.i
    public boolean c(final com.byazt.dd.tt ttVar, int i, final x xVar) {
        DownloadInfo downloadInfoTt;
        if (ttVar == null || ttVar.v() || !c(ttVar)) {
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
        if (curBytes > 0 && totalBytes > 0) {
            int iC = com.byazt.gq.da.c(downloadInfoTt.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iC > c(ttVar.my())) {
                c = new com.byazt.de.uj() { // from class: com.byazt.tg.a.1
                    @Override // com.byazt.de.uj
                    public void c() {
                        com.byazt.de.uj unused = a.c = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            m.c(e);
                        }
                        com.byazt.zn.c.c().c("pause_optimise", jSONObject, ttVar);
                    }

                    @Override // com.byazt.de.uj
                    public void tt() {
                        com.byazt.de.uj unused = a.c = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e) {
                            m.c(e);
                        }
                        com.byazt.zn.c.c().c("pause_optimise", jSONObject, ttVar);
                        xVar.c(ttVar);
                    }
                };
                TTDelegateActivity.tt(ttVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iC)), "继续", "暂停");
                ttVar.z(true);
                return true;
            }
        }
        return false;
    }

    private int c(int i) {
        return com.byazt.k.c.c(i).c("pause_optimise_download_percent", 50);
    }

    private boolean c(com.byazt.dd.c cVar) {
        return com.byazt.hu.n.c(cVar).c("pause_optimise_download_percent_switch", 0) == 1 && cVar.nu();
    }
}

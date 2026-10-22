package com.byazt.cc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.os;
import com.byazt.ete.xd;
import com.byazt.fk.u;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 71})
public class x {
    public static void c(long j, boolean z, boolean z2, ic icVar, long j2, String str) {
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            str2 = z2 ? "load_video_success" : "load_video_error";
        } else {
            str2 = z2 ? "download_video_image_success" : "download_video_image_fail";
        }
        String str3 = str2;
        if (z) {
            Map<String, Object> mapC = nb.c(z2, icVar, jElapsedRealtime, j2, str);
            mapC.put("splash_show_type", 1);
            com.byazt.ddx.uj.n(icVar, "splash_ad", str3, mapC);
        } else {
            Map<String, Object> mapTt = nb.tt(z2, icVar, jElapsedRealtime, j2, str);
            mapTt.put("splash_show_type", 2);
            com.byazt.ddx.uj.uj(icVar, "splash_ad", str3, mapTt);
        }
    }

    public static boolean tt(com.byazt.ete.c cVar) {
        return (cVar == null || cVar.tt() == null || cVar.tt().isEmpty() || cVar.tt().get(0) == null) ? false : true;
    }

    public static int ve(com.byazt.ete.c cVar) {
        if (cVar != null) {
            return cVar.c();
        }
        return 0;
    }

    public static boolean tt(ic icVar) {
        if (icVar == null || icVar.w() == 1 || xd.z(icVar) == null || TextUtils.isEmpty(xd.c(icVar))) {
            return true;
        }
        icVar.t(true);
        return false;
    }

    public static void c(com.byazt.ete.c cVar) {
        com.byazt.jzl.a aVarC;
        if (tt(cVar)) {
            ic icVar = cVar.tt().get(0);
            int iT = nb.t(icVar);
            com.byazt.jzl.uj ujVarZ = xd.z(icVar);
            if (ujVarZ != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String video_url = ujVarZ.getVideo_url();
                if (TextUtils.isEmpty(video_url)) {
                    c(jElapsedRealtime, true, false, icVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(ujVarZ.getFileHash())) {
                    com.byazt.nr.a.tt(video_url);
                }
                if (icVar.ox()) {
                    aVarC = xd.c(2, icVar);
                } else {
                    aVarC = xd.c(3, icVar);
                }
                aVarC.putExtra("material_meta", icVar);
                if (!gt.tt().sp(String.valueOf(iT)) || rh.uj(gt.getContext())) {
                    ujVarZ.setRewardVideoCachedType(0);
                    com.byazt.ri.c.c();
                    com.byazt.btt.ve.c(aVarC, new com.byazt.ols.c() { // from class: com.byazt.cc.x.1
                        @Override // com.byazt.fk.da.c
                        public void onVideoPreloadFail(u uVar, int i, String str) {
                        }

                        @Override // com.byazt.fk.da.c
                        public void onVideoPreloadSuccess(u uVar, int i) {
                        }
                    });
                }
            }
        }
    }

    public static int c(os osVar) {
        if (osVar == null) {
            return 0;
        }
        int iVe = ve(osVar.tt());
        return iVe <= 0 ? c(osVar.c()) : iVe;
    }

    public static int c(ic icVar) {
        if (icVar != null) {
            return nb.t(icVar);
        }
        return 0;
    }
}

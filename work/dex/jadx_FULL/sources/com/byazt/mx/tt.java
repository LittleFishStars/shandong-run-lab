package com.byazt.mx;

import com.byazt.blh.ve;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.log.ZeusLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 13})
public class tt {
    public static boolean c(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new c(new com.byazt.po.c().c(str)).c(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i6 = com.byazt.gvs.tt.c.tt;
                } else {
                    i5 = 0;
                }
                String str3 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                c(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                return true;
            }
            i6 = com.byazt.gvs.tt.c.c;
            i5 = i6;
            String str4 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
            c(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str4);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i4 = com.byazt.gvs.tt.c.ve;
                    } else {
                        i4 = i2 == 2 ? com.byazt.gvs.tt.c.uj : 0;
                    }
                }
                return false;
            } finally {
                if (i2 != 0) {
                    if (i2 != 1) {
                        i3 = i2 == 2 ? com.byazt.gvs.tt.c.uj : 0;
                    } else {
                        i3 = com.byazt.gvs.tt.c.ve;
                    }
                    String string = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(string)));
                    c(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, string);
                }
            }
        }
    }

    private static void c(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", ve.c(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", ve.c(str));
            jSONObject.putOpt("version_code", ve.c(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(ve.tt(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + ve.c(th));
        } catch (JSONException e) {
            a.c(e);
        }
        com.byazt.gvs.tt.c().c(com.byazt.gvs.tt.da, jSONObject, jSONObject3, jSONObject2);
    }
}

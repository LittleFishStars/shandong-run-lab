package com.byazt.hu;

import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 34})
public class a {
    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            ve(downloadInfo, jSONObject);
            com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
            if (ttVarC == null) {
                return;
            }
            jSONObject.put("is_update_download", ttVarC.lt() ? 1 : 2);
            c(ttVarC, jSONObject);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void tt(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.byazt.dd.tt ttVarC;
        if (jSONObject == null || (ttVarC = com.byazt.nn.a.c().c(downloadInfo)) == null) {
            return;
        }
        try {
            ve(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - ttVarC.lo()));
            jSONObject.putOpt("click_download_size", Long.valueOf(ttVarC.pu()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            ttVarC.p();
            com.byazt.nn.i.c().c(ttVarC);
            jSONObject.put("click_pause_times", ttVarC.yv());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? AudioStats.AUDIO_AMPLITUDE_NONE : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jCu = ttVarC.cu();
            if (jCu > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jCu);
            }
            long jMd = ttVarC.md();
            if (jMd > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jMd);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(ttVarC.eo()));
            jSONObject.putOpt("fail_msg", ttVarC.zb());
            jSONObject.put("download_failed_times", ttVarC.gr());
            jSONObject.put("can_show_notification", com.byazt.p.uj.c() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void ve(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo.getId());
                if (ttVarC != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(ttVarC.lo()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(ttVarC.pu()));
                }
            } catch (Exception e) {
                m.c(e);
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.byazt.p.uj.c() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.byazt.w.a.ve(com.byazt.gq.t.getContext()) ? 1 : 2));
        if (!com.byazt.w.a.tt(com.byazt.gq.t.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void c(com.byazt.dd.tt ttVar, JSONObject jSONObject) {
        if (jSONObject == null || ttVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", ttVar.tk() ? 1 : 0);
            jSONObject.put("origin_mime_type", ttVar.to());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void c(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayN = com.byazt.k.c.c(i).n("ah_report_config");
        if (jSONArrayN != null) {
            for (int i2 = 0; i2 < jSONArrayN.length(); i2++) {
                try {
                    String string = jSONArrayN.getString(i2);
                    com.byazt.z.a.c cVarC = com.byazt.i.c.c(string);
                    if (cVarC != null) {
                        jSONObject.put(string.replaceAll("\\.", LoginConstants.UNDER_LINE), cVarC.a() + LoginConstants.UNDER_LINE + cVarC.sp());
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.byazt.z.tt.c(com.byazt.zz.ve.ic()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c(@NonNull JSONObject jSONObject, com.byazt.dd.c cVar) {
        u.c(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, u.c(cVar.a(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void c(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.byazt.i.uj.c());
            jSONObject.putOpt("harmony_release_type", com.byazt.i.uj.ve());
            jSONObject.putOpt("harmony_build_version", com.byazt.i.uj.uj());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.byazt.i.uj.c(com.byazt.gq.t.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.byazt.i.uj.n() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.byazt.i.uj.tt());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.byazt.i.uj.tt(com.byazt.gq.t.getContext()) ? 1 : 2));
            if (!com.byazt.i.uj.a()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static JSONObject tt(@NonNull JSONObject jSONObject, com.byazt.dd.c cVar) {
        u.c(jSONObject, com.byazt.i.n.da().replaceAll("\\.", LoginConstants.UNDER_LINE) + " versionCode", Integer.valueOf(u.tt(com.byazt.gq.t.getContext(), com.byazt.i.n.da())));
        u.c(jSONObject, com.byazt.i.n.da().replaceAll("\\.", LoginConstants.UNDER_LINE) + " versionName", u.ve(com.byazt.gq.t.getContext(), com.byazt.i.n.da()));
        return jSONObject;
    }
}

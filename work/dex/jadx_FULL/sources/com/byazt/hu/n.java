package com.byazt.hu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.byazt.su.DownloadModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 46})
public class n {
    public static boolean a(int i) {
        return com.byazt.k.c.c(i).c("clean_space_switch", 0) == 1;
    }

    @Nullable
    public static JSONObject c() {
        return com.byazt.gq.t.i().optJSONObject("ad");
    }

    public static boolean n(int i) {
        return com.byazt.k.c.c(i).c("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean sp(int i) {
        return com.byazt.k.c.c(i).c("clean_app_cache_dir", 0) == 1;
    }

    @NonNull
    public static com.byazt.k.c tt(DownloadModel downloadModel) {
        return com.byazt.k.c.c(c(downloadModel));
    }

    public static boolean uj(int i) {
        return com.byazt.k.c.c(i).c("clean_fetch_apk_switch", 0L) == 1;
    }

    public static int ve(@NonNull DownloadModel downloadModel) {
        return c(tt(downloadModel));
    }

    public static int a(com.byazt.dd.tt ttVar) {
        return c((com.byazt.dd.c) ttVar).c("app_install_keep_receiver_time_s", 60);
    }

    public static JSONObject c(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? u.c(com.byazt.gq.t.i(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long n() {
        long jOptLong = com.byazt.gq.t.i().optLong("next_install_min_interval");
        if (jOptLong == 0) {
            return 10000L;
        }
        return jOptLong;
    }

    public static long sp(com.byazt.dd.tt ttVar) {
        return c((com.byazt.dd.c) ttVar).c("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }

    public static boolean tt(com.byazt.dd.c cVar) {
        return c(cVar).c("pause_reserve_on_wifi", 0) == 1 && cVar.nu();
    }

    public static long uj() {
        long jOptLong = com.byazt.gq.t.i().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static boolean n(com.byazt.dd.tt ttVar) {
        return com.byazt.gq.t.i().optInt("market_install_finish_opt_polling_thread", 0) == 1 || c((com.byazt.dd.c) ttVar).c("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static boolean uj(com.byazt.dd.tt ttVar) {
        return com.byazt.gq.t.i().optInt("market_install_finish_opt_broadcast", 0) == 1 || c((com.byazt.dd.c) ttVar).c("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean ve(com.byazt.dd.c cVar) {
        return c(cVar).c("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && cVar.nu();
    }

    public static long tt(int i) {
        return com.byazt.k.c.c(i).c("storage_min_size", 0L);
    }

    @NonNull
    public static com.byazt.k.c c(com.byazt.dd.c cVar) {
        if (cVar == null) {
            return com.byazt.k.c.ve();
        }
        if (cVar.my() != 0) {
            return com.byazt.k.c.c(cVar.my());
        }
        if (cVar.ve()) {
            return com.byazt.k.c.c(c());
        }
        if (cVar.rh() != null) {
            return com.byazt.k.c.c(cVar.rh());
        }
        return com.byazt.k.c.ve();
    }

    public static boolean tt(com.byazt.k.c cVar) {
        return cVar != null && cVar.c("kllk_need_rename_apk", 0) == 1;
    }

    public static long ve(int i) {
        return com.byazt.k.c.c(i).c("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean tt() {
        return com.byazt.k.c.ve().c("fix_notification_anr");
    }

    public static boolean ve() {
        return com.byazt.gq.t.i().optInt("is_enable_start_install_again") == 1;
    }

    public static int tt(com.byazt.dd.tt ttVar) {
        return c((com.byazt.dd.c) ttVar).c("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean ve(com.byazt.dd.tt ttVar) {
        return com.byazt.gq.t.i().optInt("market_install_finish_opt_switch", 0) == 1 || c((com.byazt.dd.c) ttVar).c("market_install_finish_opt_switch", 0) == 1;
    }

    public static int c(@NonNull com.byazt.k.c cVar) {
        return cVar.c("external_storage_permission_path_type", 0);
    }

    public static double c(int i) {
        return com.byazt.k.c.c(i).c("clean_min_install_size", AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static int c(com.byazt.dd.tt ttVar) {
        return c((com.byazt.dd.c) ttVar).c("ttdownloader_app_install_detect_count", 15);
    }
}

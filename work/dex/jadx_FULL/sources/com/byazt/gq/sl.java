package com.byazt.gq;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28576a;
    public volatile DownloadInfo c;
    public volatile boolean n;
    public volatile boolean sp;
    public volatile DownloadInfo tt;
    public volatile DownloadInfo uj;
    public volatile DownloadInfo ve;

    @com.byazt.zqa.c(c = {0, 1, 52, 925})
    public static class c {
        public static sl c = new sl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        if (this.n) {
            return;
        }
        String strValueOf = String.valueOf(tt());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences kVStore = com.byazt.ut.a.getKVStore(t.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(kVStore.getString("unfinished_pushed_update_time", "0"))) {
            String string = kVStore.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.c = Downloader.getInstance(t.getContext()).getDownloadInfo(Integer.parseInt(string));
        }
        if (strValueOf.equals(kVStore.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = kVStore.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.tt = Downloader.getInstance(t.getContext()).getDownloadInfo(Integer.parseInt(string2));
        }
        if (strValueOf.equals(kVStore.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = kVStore.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.ve = Downloader.getInstance(t.getContext()).getDownloadInfo(Integer.parseInt(string3));
        }
        if (strValueOf.equals(kVStore.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = kVStore.getString("uninstalled_pop_up_id", "0");
            this.uj = Downloader.getInstance(t.getContext()).getDownloadInfo(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.n = true;
    }

    public void tt(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (c(downloadInfo, downloadModel) && t.qy() != null && t.qy().tt(downloadModel, downloadInfo)) {
            com.byazt.zn.c.c().c("download_uninstalled_push_retain", downloadModel.getId());
        }
    }

    private sl() {
        this.c = null;
        this.tt = null;
        this.ve = null;
        this.uj = null;
        this.n = false;
        this.f28576a = false;
        this.sp = false;
        com.byazt.di.n.c().tt(new Runnable() { // from class: com.byazt.gq.sl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sl.this.ve();
                } catch (Exception e) {
                    com.byazt.dm.ve.c().c(false, e, "读取sp出错");
                }
            }
        });
    }

    public static sl c() {
        return c.c;
    }

    public void c(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (c(downloadInfo) && t.qy() != null && t.qy().c(downloadModel, downloadInfo)) {
            com.byazt.zn.c.c().c("download_unfinished_push_retain", downloadModel.getId());
        }
    }

    public long tt() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private boolean c(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -2;
    }

    private boolean c(DownloadInfo downloadInfo, DownloadModel downloadModel) {
        return (downloadInfo == null || downloadModel == null || com.byazt.hu.u.c(downloadModel)) ? false : true;
    }
}

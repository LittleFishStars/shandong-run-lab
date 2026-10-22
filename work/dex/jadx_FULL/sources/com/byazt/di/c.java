package com.byazt.di;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.camera.video.AudioStats;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.c.zb;
import com.byazt.ev.DownloadStatus;
import com.byazt.gq.sl;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 20})
public class c implements com.byazt.pk.c, com.byazt.z.tt.ve, com.byazt.g.c.InterfaceC0409c, zb {
    public static String c = "c";
    public static volatile c uj;
    public long tt;
    public tt ve;

    /* JADX INFO: renamed from: com.byazt.di.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 345, 44})
    @WorkerThread
    public class RunnableC0387c implements Runnable {
        public final int tt;

        public RunnableC0387c(int i) {
            this.tt = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.byazt.nn.a.c().tt();
                ConcurrentHashMap<Long, com.byazt.dd.tt> concurrentHashMapVe = com.byazt.nn.a.c().ve();
                if (concurrentHashMapVe == null || concurrentHashMapVe.isEmpty()) {
                    return;
                }
                c.this.c(concurrentHashMapVe, this.tt);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 345, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt implements Runnable {
        public long c;
        public long n;
        public int tt;
        public int uj;
        public long ve;

        /* JADX INFO: Access modifiers changed from: private */
        public void tt() {
            this.n = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c()) {
                    c.c().c(this.c, this.tt);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }

        private tt(long j, int i, long j2, int i2) {
            this.c = j;
            this.tt = i;
            this.ve = j2;
            this.uj = i2;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00ad A[Catch: Exception -> 0x00f1, TryCatch #1 {Exception -> 0x00f1, blocks: (B:24:0x008c, B:26:0x00ad, B:31:0x00c0, B:34:0x00cd, B:39:0x00dc, B:42:0x00ed), top: B:54:0x008c }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:30:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:38:0x00db  */
        /* JADX WARN: Code duplicated, block: B:41:0x00eb  */
        public boolean c() {
            DownloadInfo downloadInfo;
            double d;
            boolean zC;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            int i2;
            com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(this.c);
            boolean z = false;
            if (ttVarUj == null || u.tt(ttVarUj) || ttVarUj.ve.get() || (downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVarUj.my())) == null) {
                return false;
            }
            long jSv = ttVarUj.sv();
            long jC = u.c(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jC / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            double d3 = jMin + (2.5d * d2);
            try {
                try {
                    if (jSv > -1 && totalBytes > -1) {
                        d = d2;
                        if (jSv >= d3) {
                        }
                        zC = com.byazt.z.tt.c(t.getContext());
                        jSONObject = new JSONObject();
                        int iC = c(z, ttVarUj, downloadInfo, zC, jSONObject);
                        this.uj = iC;
                        jSONObject2 = jSONObject;
                        jSONObject2.putOpt("fail_status", Integer.valueOf(iC));
                        jSONObject2.putOpt("available_space", Long.valueOf(jSv / 1048576));
                        jSONObject2.putOpt("total_space", Long.valueOf(jC / 1048576));
                        if (totalBytes > 0) {
                            jSONObject2.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                        }
                        if (z) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                        if (jSv > 0 && totalBytes > 0) {
                            jSONObject2.put("available_space_ratio", jSv / d);
                        }
                        if (zC) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                        jSONObject2.put("is_update_download", ttVarUj.lt() ? 1 : 2);
                        com.byazt.zn.c.c().tt("install_failed", jSONObject2, ttVarUj);
                        return true;
                    }
                    d = d2;
                    jSONObject2.putOpt("fail_status", Integer.valueOf(iC));
                    jSONObject2.putOpt("available_space", Long.valueOf(jSv / 1048576));
                    jSONObject2.putOpt("total_space", Long.valueOf(jC / 1048576));
                    if (totalBytes > 0) {
                        jSONObject2.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                    }
                    if (z) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                    if (jSv > 0) {
                        jSONObject2.put("available_space_ratio", jSv / d);
                    }
                    if (zC) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                    jSONObject2.put("is_update_download", ttVarUj.lt() ? 1 : 2);
                } catch (Exception e) {
                    e = e;
                    m.c(e);
                }
                jSONObject2 = jSONObject;
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject;
            }
            z = true;
            zC = com.byazt.z.tt.c(t.getContext());
            jSONObject = new JSONObject();
            int iC2 = c(z, ttVarUj, downloadInfo, zC, jSONObject);
            this.uj = iC2;
            com.byazt.zn.c.c().tt("install_failed", jSONObject2, ttVarUj);
            return true;
        }

        private int c(boolean z, com.byazt.dd.tt ttVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
            int i = 1;
            if (cVarC.c("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.byazt.w.a.c(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.uj;
            if (i2 != 2000) {
                return i2;
            }
            if (cVarC.c("install_failed_check_signature", 1) == 1 && u.n(t.getContext(), ttVar.n())) {
                if (!u.c(u.i(t.getContext(), downloadInfo.getTargetFilePath()), u.x(t.getContext(), ttVar.n()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.n;
            long j2 = this.ve;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (ttVar.h() <= this.ve) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    private c() {
        com.byazt.z.tt.c(this);
        com.byazt.g.c.c().c(this);
    }

    public static JSONObject tt(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.byazt.k.c.c(downloadInfo.getId()).c("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jTt = u.tt(0L);
            double d = jTt;
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (jTt > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return jSONObject;
    }

    public static String ve(@NonNull DownloadInfo downloadInfo, @NonNull com.byazt.dd.tt ttVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = t.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.byazt.z.ve.c());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (JSONException e2) {
            m.c(e2);
        }
        com.byazt.zn.c.c().c(com.byazt.dyf.tt.AD_TAG_FEED, "package_name_error", jSONObject, ttVar);
        return str;
    }

    public synchronized void uj() {
        tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.tt();
            this.ve = null;
        }
    }

    public static c c() {
        if (uj == null) {
            synchronized (c.class) {
                if (uj == null) {
                    uj = new c();
                }
            }
        }
        return uj;
    }

    @WorkerThread
    public static synchronized void c(DownloadInfo downloadInfo, com.byazt.dd.tt ttVar) {
        try {
            if (downloadInfo == null) {
                com.byazt.dm.ve.c().c("onDownloadFinish info null");
                return;
            }
            if (ttVar == null) {
                com.byazt.dm.ve.c().c("onDownloadFinish nativeModel null");
                return;
            }
            if (ttVar.or() != 1) {
                return;
            }
            com.byazt.sd.x.c().uj(ttVar);
            String strVe = ve(downloadInfo, ttVar);
            com.byazt.nn.a.c().tt(downloadInfo.getUrl(), strVe);
            Map<Long, com.byazt.dd.tt> mapC = com.byazt.nn.a.c().c(downloadInfo.getUrl(), strVe);
            ttVar.a(System.currentTimeMillis());
            ttVar.n(2);
            ttVar.tt(strVe);
            mapC.put(Long.valueOf(ttVar.tt()), ttVar);
            com.byazt.nn.i.c().c(mapC.values());
            c(ttVar);
            sl.c().tt(ttVar.rl(), downloadInfo);
            ttVar.t(System.currentTimeMillis());
            x.c().c(downloadInfo, strVe);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                if (com.byazt.hu.n.c((com.byazt.dd.c) ttVar).c("enable_app_install_receiver", 1) != 1 && t.i().optInt("enable_app_install_receiver", 1) != 1) {
                    com.byazt.gq.u.c().c(ttVar);
                }
                c().tt(downloadInfo, ttVar);
                if (ttVar.bx()) {
                    com.byazt.de.c.c().c(downloadInfo.getId(), ttVar.tt(), ttVar.t(), strVe, downloadInfo.getTitle(), ttVar.uj(), downloadInfo.getTargetFilePath());
                }
                ttVar.tt();
                ttVar.uj();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void tt(DownloadInfo downloadInfo, final com.byazt.dd.tt ttVar) {
        if (downloadInfo == null || ttVar == null || com.byazt.k.c.c(downloadInfo.getId()).c("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        n.c().tt(new Runnable() { // from class: com.byazt.di.c.3
            @Override // java.lang.Runnable
            public void run() {
                String strC = com.byazt.hu.c.c(targetFilePath);
                if (TextUtils.isEmpty(strC)) {
                    return;
                }
                com.byazt.ut.a.getKVStore(t.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(ttVar.tt()), strC).apply();
            }
        });
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void tt() {
        com.byazt.x.c.tt(c, "onAppForeground()");
        uj();
        c(5);
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void ve() {
        com.byazt.x.c.tt(c, "onAppBackground()");
        c(6);
    }

    private int tt(com.byazt.dd.tt ttVar) {
        int realStatus;
        double dC = com.byazt.k.c.c(ttVar.my()).c("download_failed_finally_hours", 48.0d);
        if (dC <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return -1;
        }
        if (System.currentTimeMillis() - ttVar.cu() < dC * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (ttVar.uj.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVar.my());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && ttVar.uj.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                c(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(ttVar.eo()));
                jSONObject.putOpt("fail_msg", ttVar.zb());
                jSONObject.put("download_failed_times", ttVar.gr());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", ttVar.lt() ? 1 : 2);
                com.byazt.zn.c.c().c(ttVar.da(), "download_failed_finally", jSONObject, ttVar);
                com.byazt.nn.i.c().c(ttVar);
                return 0;
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return 1;
    }

    private JSONObject tt(@NonNull DownloadInfo downloadInfo, com.byazt.z.c cVar) {
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        if (ttVarC == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        cVar.c(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            m.c(th);
        }
        com.byazt.hu.a.c(jSONObject, downloadInfo.getId());
        com.byazt.zn.c.c().c(com.byazt.dyf.tt.AD_TAG_FEED, "ah_result", jSONObject, ttVarC);
        return jSONObject;
    }

    @WorkerThread
    public synchronized void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!u.tt()) {
            final com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(str);
            if (ttVarC == null) {
                com.byazt.nn.uj.c().c(str);
                return;
            }
            com.byazt.gq.n nVarC = x.c().c(ttVarC.c());
            if (nVarC != null) {
                nVarC.a();
            }
            if (ttVarC.ve.get()) {
                return;
            }
            if (com.byazt.k.c.c(ttVarC.my()).tt("notification_opt_2") == 1) {
                com.byazt.n.tt.c().a(ttVarC.my());
            }
            new com.byazt.us.tt().c(ttVarC, new com.byazt.us.sp() { // from class: com.byazt.di.c.1
                @Override // com.byazt.us.sp
                public void c(boolean z) {
                    com.byazt.x.c.tt(c.c, "appBackForeground->".concat(String.valueOf(z)));
                    if (!z) {
                        if (com.byazt.us.c.c(str, ttVarC) || ttVarC.pf() != 4) {
                            return;
                        }
                        com.byazt.de.c.c().c(ttVarC);
                        return;
                    }
                    if (!(com.byazt.us.a.ve(ttVarC) ? com.byazt.us.c.c(str, ttVarC) : false) && com.byazt.us.a.uj(ttVarC) && ttVarC.pf() == 4) {
                        com.byazt.de.c.c().c(ttVarC);
                    }
                }
            }, com.byazt.hu.n.c((com.byazt.dd.c) ttVarC).c("try_applink_delay_after_installed", 0));
            com.byazt.sd.x.c().a(ttVarC);
            c(str, ttVarC);
            com.byazt.de.c.c().tt(str);
            DownloadInfo downloadInfoC = c((List<DownloadInfo>) Downloader.getInstance(t.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (downloadInfoC != null) {
                if (com.byazt.k.c.c(downloadInfoC.getId()).tt("no_hide_notification") != 1) {
                    com.byazt.n.tt.c().c(downloadInfoC.getId());
                }
                x.c().tt(downloadInfoC, str);
                com.byazt.ie.uj.c(downloadInfoC);
                return;
            }
            x.c().tt(null, str);
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    public void c(DownloadInfo downloadInfo, com.byazt.dd.tt ttVar, int i) {
        long jMax;
        if (downloadInfo == null || ttVar == null) {
            return;
        }
        uj();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ttVar.tt(jCurrentTimeMillis);
        ttVar.sp(u.c(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = 2000;
        } else {
            long jC = com.byazt.k.c.c(downloadInfo.getId()).c("check_install_failed_delay_time", com.igexin.push.config.c.l);
            if (jC < 0) {
                return;
            } else {
                jMax = Math.max(jC, 30000L);
            }
        }
        long j = jMax;
        tt ttVar2 = new tt(ttVar.tt(), downloadInfo.getId(), jCurrentTimeMillis, i);
        n.c().c(ttVar2, j);
        this.ve = ttVar2;
        com.byazt.nn.i.c().c(ttVar);
    }

    public void c(final long j, int i) {
        long jC = com.byazt.k.c.c(i).c("check_install_finish_hijack_delay_time", com.heytap.mcssdk.constant.a.h);
        if (jC < 0) {
            return;
        }
        n.c().c(new Runnable() { // from class: com.byazt.di.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.c().c(j);
            }
        }, Math.max(jC, 300000L));
    }

    public void c(long j) {
        com.byazt.nn.uj.c cVarC;
        int iIntValue;
        try {
            com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(j);
            if (ttVarUj != null && !u.tt(ttVarUj) && !ttVarUj.ve.get()) {
                Pair<com.byazt.nn.uj.c, Integer> pairTt = com.byazt.nn.uj.c().tt(ttVarUj);
                if (pairTt != null) {
                    cVarC = (com.byazt.nn.uj.c) pairTt.first;
                    iIntValue = ((Integer) pairTt.second).intValue();
                } else {
                    cVarC = com.byazt.nn.uj.c().c(ttVarUj);
                    iIntValue = -1;
                }
                if (cVarC == null) {
                    return;
                }
                com.byazt.nn.uj.c().tt(cVarC.c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", cVarC.uj);
                jSONObject.put("installed_pkg_name", cVarC.c);
                if (iIntValue != -1) {
                    jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, iIntValue);
                    com.byazt.hu.a.c(jSONObject, ttVarUj.my());
                    com.byazt.zn.c.c().tt("install_finish_hijack", jSONObject, ttVarUj);
                    return;
                }
                com.byazt.zn.c.c().tt("install_finish_may_hijack", jSONObject, ttVarUj);
            }
        } catch (Throwable th) {
            com.byazt.dm.ve.c().c(th, "trySendInstallFinishHijack");
        }
    }

    public void c(String str, com.byazt.dd.tt ttVar) {
        if (ttVar != null && u.tt(ttVar) && ttVar.ve.compareAndSet(false, true)) {
            int i = 4;
            if (ttVar.pf() == 4) {
                com.byazt.ou.da daVarQy = t.qy();
                if (daVarQy != null) {
                    daVarQy.c(ttVar.rl());
                }
            } else {
                i = 3;
            }
            com.byazt.zn.c.c().c(ttVar.da(), "install_finish", c(ttVar, str, i), ttVar);
            com.byazt.nn.i.c().c(ttVar);
        }
    }

    private static DownloadInfo c(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (u.c(t.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject c(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.byazt.k.c.c(downloadInfo.getId()).c("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.byazt.hs.sl.c().tt().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > AudioStats.AUDIO_AMPLITUDE_NONE && realDownloadTime > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    double d = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d);
                    } catch (Exception unused) {
                    }
                    com.byazt.x.c.tt(c, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(t.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e) {
                    m.c(e);
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.byazt.ie.uj.c().tt(downloadInfo.getUrl()));
                jSONObject.put(com.google.android.exoplayer2.offline.a.f3586e, downloadInfo.getMimeType());
                if (!com.byazt.w.a.ve(t.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                tt(jSONObject, downloadInfo);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return jSONObject;
    }

    private static void c(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        String strHd = TextUtils.isEmpty(ttVar.hd()) ? "" : ttVar.hd();
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVar.my());
        ttVar.t("");
        com.byazt.nn.i.c().c(ttVar);
        JSONObject jSONObjectC = c(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            jSONObjectC.putOpt("finish_reason", strHd);
            jSONObjectC.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        com.byazt.hu.a.c(jSONObjectC, downloadInfo.getId());
        try {
            jSONObjectC.put("download_failed_times", ttVarC.gr());
            jSONObjectC.put("can_show_notification", com.byazt.p.uj.c() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectC.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectC.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectC.put("has_send_download_failed_finally", ttVarC.uj.get() ? 1 : 2);
            if (!ttVarC.lt()) {
                i = 2;
            }
            jSONObjectC.put("is_update_download", i);
            com.byazt.hu.a.c(ttVarC, jSONObjectC);
        } catch (Throwable th) {
            m.c(th);
        }
        com.byazt.zn.c.c().tt("download_finish", jSONObjectC, ttVar);
    }

    private int c(com.byazt.dd.tt ttVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iTt = com.byazt.z.ve.tt(t.getContext(), downloadInfo);
        int iTt2 = u.tt(t.getContext(), str);
        if (iTt > 0 && iTt2 > 0 && iTt != iTt2) {
            return iTt2 > iTt ? 3011 : 3010;
        }
        if (com.byazt.k.c.c(ttVar.my()).c("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.byazt.ut.a.getKVStore(t.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(ttVar.tt()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.byazt.hu.c.c(downloadInfo.getTargetFilePath());
        }
        int iC = com.byazt.hu.c.c(string, com.byazt.hu.c.tt(str));
        try {
            jSONObject.put("ttmd5_status", iC);
        } catch (Throwable unused) {
        }
        if (iC == 0) {
            return 3000;
        }
        return iC == 1 ? 3002 : 3001;
    }

    @Override // com.byazt.pk.c
    public void c(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.tt < com.igexin.push.config.c.l) {
            return;
        }
        n.c().c(new RunnableC0387c(i), this.tt > 0 ? 2000L : 8000L);
        this.tt = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c(@NonNull ConcurrentHashMap<Long, com.byazt.dd.tt> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.byazt.dd.tt ttVar : concurrentHashMap.values()) {
            if (ttVar.ve.get()) {
                if (jCurrentTimeMillis - ttVar.cu() >= com.byazt.k.c.c(ttVar.my()).c("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(ttVar.tt()));
                }
            } else if (ttVar.or() == 1) {
                if (tt(ttVar) <= 0 && jCurrentTimeMillis - ttVar.cu() >= com.byazt.k.c.c(ttVar.my()).c("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(ttVar.tt()));
                }
            } else if (ttVar.or() == 2) {
                if (!ttVar.kp()) {
                    if (u.tt(ttVar)) {
                        if (ttVar.pf() == 4) {
                            i = ttVar.pf();
                            com.byazt.ou.da daVarQy = t.qy();
                            if (daVarQy != null) {
                                daVarQy.c(ttVar.rl());
                            }
                        }
                        ttVar.da(false);
                        com.byazt.zn.c.c().c(c(ttVar, ttVar.n(), i), ttVar);
                        arrayList.add(Long.valueOf(ttVar.tt()));
                        com.byazt.ie.uj.c(ttVar);
                    } else if (ttVar.kp() && ttVar.pf() == 4 && i == 1 && !u.tt(ttVar)) {
                        com.byazt.hu.t.c().c(c, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        i.c().c(ttVar);
                    } else if (jCurrentTimeMillis - ttVar.cu() >= com.byazt.k.c.c(ttVar.my()).c("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(ttVar.tt()));
                    } else if (TextUtils.isEmpty(ttVar.n())) {
                        arrayList.add(Long.valueOf(ttVar.tt()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(ttVar.tt()));
            }
        }
        com.byazt.nn.a.c().c(arrayList);
    }

    @Override // com.byazt.z.tt.ve
    public void c(DownloadInfo downloadInfo, com.byazt.z.c cVar) {
        JSONObject jSONObjectTt;
        if (downloadInfo == null || cVar == null) {
            return;
        }
        JSONArray jSONArrayN = com.byazt.k.c.c(downloadInfo.getId()).n("ah_report_config");
        if (cVar.tt != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayN == null || (jSONObjectTt = tt(downloadInfo, cVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectTt);
    }

    @Override // com.byazt.c.zb
    public void c(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.byazt.dm.ve.c().c("info is null");
        } else if ((com.byazt.k.c.c(downloadInfo).tt("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.byazt.us.n.c().tt(new com.byazt.us.uj() { // from class: com.byazt.di.c.4
                @Override // com.byazt.us.uj
                public void c(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.byazt.z.ve.c(t.getContext(), intent);
                            u.c(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            u.c(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
                    if (ttVarC != null) {
                        com.byazt.zn.c.c().c(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, ttVarC);
                    } else {
                        com.byazt.dm.ve.c().tt("ah nativeModel=null");
                    }
                    if (z) {
                        t.rl().c(t.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    private JSONObject c(com.byazt.dd.tt ttVar, String str, int i) {
        com.byazt.z.c cVarC;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(ttVar.my());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.byazt.hu.a.c(jSONObject, ttVar.my());
            com.byazt.hu.a.c(ttVar, jSONObject);
            jSONObject.put("is_update_download", ttVar.lt() ? 1 : 2);
            jSONObject.put("install_after_back_app", ttVar.kk() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", ttVar.lr() ? "1" : "2");
            if (downloadInfo != null) {
                c(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (ttVar.h() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - ttVar.h();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.byazt.k.c.c(downloadInfo.getId()).c("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strC = com.byazt.w.a.c(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strC) && (cVarC = com.byazt.z.c.c(strC)) != null) {
                    cVarC.c(jSONObject);
                }
            }
            int iC = c(ttVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iC);
            if (iC == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iC == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return jSONObject;
    }

    public void c(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        if (ttVarC == null) {
            com.byazt.dm.ve.c().c("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.byazt.hu.a.ve(downloadInfo, jSONObject);
            com.byazt.zn.c.c().c("cleanup", jSONObject, ttVarC);
        } catch (Exception e) {
            m.c(e);
        }
    }
}

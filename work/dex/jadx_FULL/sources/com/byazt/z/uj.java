package com.byazt.z;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.b.rh;
import com.byazt.c.IDownloadListener;
import com.byazt.c.h;
import com.byazt.c.u;
import com.byazt.c.yp;
import com.byazt.c.yv;
import com.byazt.c.zb;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.s.i;
import com.byazt.s.sl;
import com.byazt.s.x;
import com.byazt.s.z;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import com.igexin.sdk.PushConsts;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f29229a = false;
    public static final String c = "uj";
    public static boolean sp = false;
    public static volatile uj tt = null;
    public static boolean x = false;
    public int da;
    public zb gt;
    public Future i;
    public x m;
    public h my;
    public com.byazt.s.sp nu;
    public com.byazt.s.ve qy;
    public sl rh;
    public z rl;
    public com.byazt.s.uj u;
    public String uj;
    public String ve;
    public com.byazt.s.n yp;
    public i z;
    public DownloadReceiver n = new DownloadReceiver();
    public boolean sl = false;
    public boolean t = false;

    private uj() {
    }

    private void gt() {
        rh.c(new rh.tt() { // from class: com.byazt.z.uj.3
            @Override // com.byazt.b.rh.tt
            public void c(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.c(downloadInfo, j, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        synchronized (this.n) {
            if (sp) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.byazt.zz.ve.ic().registerReceiver(this.n, intentFilter);
                com.byazt.zz.ve.ic().registerReceiver(this.n, intentFilter2);
                sp = true;
            } catch (Exception e) {
                m.c(e);
            }
            com.byazt.x.c.tt(c, "registerDownloadReceiver mIsRegistered:" + sp);
        }
    }

    public static uj sl() {
        if (tt == null) {
            synchronized (uj.class) {
                if (tt == null) {
                    tt = new uj();
                }
            }
        }
        return tt;
    }

    public com.byazt.s.sp a() {
        return this.nu;
    }

    public String da() {
        return this.ve;
    }

    public File i() {
        return Downloader.getInstance(com.byazt.zz.ve.ic()).getGlobalSaveDir();
    }

    public h m() {
        return this.my;
    }

    public String n() {
        return this.uj;
    }

    public zb nu() {
        return this.gt;
    }

    public boolean sp() {
        return com.byazt.k.c.tt().optInt("package_flag_config", 1) == 1;
    }

    public void t() {
        if (com.byazt.k.c.ve().c("enable_app_install_receiver", 1) <= 0) {
            com.byazt.x.c.tt(c, "disable app install receiver");
            return;
        }
        synchronized (this.n) {
            try {
                if (x) {
                    tt(0);
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.byazt.zz.ve.ic().registerReceiver(this.n, intentFilter);
                    x = true;
                    z zVar = this.rl;
                    if (zVar != null) {
                        zVar.c();
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
                tt(0);
                com.byazt.x.c.tt(c, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + sp);
            } catch (Throwable th2) {
                tt(0);
                throw th2;
            }
        }
    }

    public void u() {
        z zVar;
        synchronized (this.n) {
            try {
                if (sp) {
                    com.byazt.zz.ve.ic().unregisterReceiver(this.n);
                    if (x && (zVar = this.rl) != null) {
                        zVar.tt();
                    }
                    sp = false;
                    x = false;
                } else {
                    sp = false;
                    x = false;
                }
            } catch (Exception e) {
                m.c(e);
            }
            throw th;
        }
        com.byazt.x.c.tt(c, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public i uj() {
        return this.z;
    }

    public com.byazt.s.n ve() {
        return this.yp;
    }

    public sl x() {
        return this.rh;
    }

    public x yp() {
        return this.m;
    }

    public com.byazt.zz.rh z() {
        return Downloader.getInstance(com.byazt.zz.ve.ic()).getReserveWifiStatusListener();
    }

    private void ve(Context context) {
        if (context == null || f29229a) {
            return;
        }
        com.byazt.ev.n.c(AdBaseConstants.MIME_APK);
        com.byazt.zz.ve.c(context);
        com.byazt.zz.ve.c(new com.byazt.r.tt());
        if (this.t) {
            com.byazt.zz.ve.c(new Runnable() { // from class: com.byazt.z.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    uj.this.my();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            my();
        }
        gt();
        f29229a = true;
    }

    public com.byazt.s.uj tt() {
        return this.u;
    }

    public com.byazt.s.ve c() {
        return this.qy;
    }

    public void tt(String str) {
        Downloader.getInstance(com.byazt.zz.ve.ic()).setDefaultSavePath(str);
    }

    private void tt(int i) {
        this.da = com.byazt.k.c.ve().c("app_install_keep_receiver_time_s", 60);
        com.byazt.x.c.tt(c, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.da);
        if (this.da <= 0) {
            return;
        }
        if (i > 0) {
            this.da = i;
        }
        Future future = this.i;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        this.i = com.byazt.zz.ve.c(new Runnable() { // from class: com.byazt.z.uj.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.x.c.tt(uj.c, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                uj.this.u();
                uj.this.my();
            }
        }, this.da, TimeUnit.SECONDS);
    }

    public void c(com.byazt.s.ve veVar) {
        this.qy = veVar;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.uj = str;
    }

    public void c(com.byazt.s.sp spVar) {
        this.nu = spVar;
    }

    public void c(sl slVar) {
        this.rh = slVar;
    }

    @Deprecated
    public void c(Context context, String str, com.byazt.s.uj ujVar, com.byazt.s.n nVar, i iVar) {
        if (ujVar != null) {
            this.u = ujVar;
        }
        if (nVar != null) {
            this.yp = nVar;
        }
        if (iVar != null) {
            this.z = iVar;
        }
        ve(context);
    }

    private DownloadInfo tt(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public static boolean c(Context context, int i) {
        return ve.c(context, i, true) == 1;
    }

    public void c(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    ve.c(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public List<DownloadInfo> tt(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public int c(n nVar) {
        int i;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (nVar == null || nVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.byazt.t.ve> listC = c(nVar.uj());
            String strC = nVar.c();
            if (TextUtils.isEmpty(strC)) {
                return 0;
            }
            final int iMy = nVar.my();
            final boolean z = iMy == 0;
            String strBx = nVar.bx();
            final String strTt = nVar.tt();
            if (TextUtils.isEmpty(strBx)) {
                strBx = ve.c(strC, strTt, nVar.t(), z);
            }
            if (strBx.length() > 255) {
                strBx = strBx.substring(strBx.length() - 255);
            }
            if (TextUtils.isEmpty(strTt)) {
                strTt = strBx;
            }
            String strT = nVar.t();
            if (strBx.endsWith(".apk") && !ve.ve(nVar.t())) {
                strT = AdBaseConstants.MIME_APK;
            }
            String strVe = nVar.ve();
            if (TextUtils.isEmpty(nVar.ve())) {
                strVe = ve.tt();
            }
            String str = strVe;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strBx)) {
                String strL = nVar.l();
                if (TextUtils.isEmpty(strL)) {
                    strL = strC;
                }
                int iC = com.byazt.zz.ve.c(strL, str);
                if (com.byazt.k.c.c(nVar.os()).c("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.byazt.zz.ve.ic()).getDownloadInfo(iC)) != null) {
                    try {
                        nVar.c(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.byazt.k.c.c(iC, nVar.os());
                boolean zPf = nVar.pf();
                boolean z2 = (com.byazt.k.c.c(iC).c("modify_force", 1) == 1 && !zPf && com.byazt.w.a.uj(str, strBx) && Downloader.getInstance(nVar.getContext()).getDownloadInfo(iC) == null) ? true : zPf;
                IDownloadListener iDownloadListenerDa = nVar.da();
                if (iDownloadListenerDa == null && (nVar.n() || nVar.a())) {
                    if (nVar.yp() != null) {
                        iDownloadListenerDa = new com.byazt.p.tt(nVar.yp());
                    } else {
                        iDownloadListenerDa = new com.byazt.p.tt(nVar.getContext(), iC, strTt, str, strBx, nVar.sl());
                    }
                }
                yp ypVarAw = nVar.aw();
                if (ypVarAw == null) {
                    ypVarAw = new yp() { // from class: com.byazt.z.uj.4
                        @Override // com.byazt.c.yp
                        public void c(DownloadInfo downloadInfo2, BaseException baseException, int i2) {
                            if (uj.this.z != null) {
                                uj.this.z.c(downloadInfo2, baseException, i2);
                            }
                        }
                    };
                }
                List<u> listMd = com.byazt.zz.ve.md();
                if (!listMd.isEmpty()) {
                    Iterator<u> it = listMd.iterator();
                    while (it.hasNext()) {
                        nVar.c(it.next());
                    }
                }
                String strSl = nVar.sl();
                try {
                    if (!TextUtils.isEmpty(strSl)) {
                        jSONObject = new JSONObject(strSl);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", nVar.sp());
                    jSONObject.put("auto_install_without_notification", nVar.a());
                    strSl = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = nVar.n() || nVar.a();
                if (!z3 || com.byazt.k.c.c(iC).tt("enable_notification_ui") <= 0) {
                    i = iC;
                } else {
                    i = iC;
                    com.byazt.p.ve.c().c(i, nVar.kk());
                }
                final DownloadTask autoInstall = com.byazt.zz.tt.with(nVar.getContext()).url(strC).backUpUrls(nVar.tx()).name(strBx).title(strTt).savePath(str).onlyWifi(nVar.x()).extraHeaders(listC).depend(ypVarAw).retryCount(nVar.gu()).backUpUrlRetryCount(nVar.gr()).showNotification(z3).extra(strSl).mimeType(strT).minProgressTimeMsInterval(nVar.d()).maxProgressCount(nVar.eo()).mainThreadListener(nVar.i()).notificationListener(iDownloadListenerDa).notificationEventListener(c(nVar.ic())).force(z2).autoResumed(nVar.nu()).showNotificationForAutoResumed(nVar.rh()).chunkStategy(nVar.z()).chunkAdjustCalculator(nVar.m()).needHttpsToHttpRetry(nVar.u()).packageName(nVar.gt()).md5(nVar.rl()).expectFileLength(nVar.qy()).needRetryDelay(nVar.zm()).retryDelayTimeArray(nVar.yv()).needDefaultHttpServiceBackUp(nVar.p()).needReuseFirstConnection(nVar.md()).needReuseChunkRunnable(nVar.zb()).needIndependentProcess(nVar.or()).enqueueType(nVar.nb()).monitorDepend(nVar.sv()).retryDelayTimeCalculator(nVar.h()).headConnectionAvailable(nVar.cu()).fileUriProvider(nVar.hd()).diskSpaceHandler(nVar.v()).needChunkDowngradeRetry(nVar.qp()).notificationClickCallback(nVar.bm()).downloadSetting(nVar.os()).iconUrl(nVar.kk()).needSDKMonitor(nVar.to()).monitorScene(nVar.tk()).extraMonitorStatus(nVar.kp()).executorGroup(nVar.pu()).throttleNetSpeed(nVar.lt()).distinctDirectory(nVar.b()).taskKey(nVar.l()).setAutoInstall(nVar.q());
                if (autoInstall != null && !nVar.lr().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(nVar.lr());
                }
                if (autoInstall != null) {
                    if (z3 && nVar.lo() && nVar.getActivity() != null && !nVar.getActivity().isFinishing() && !com.byazt.p.uj.c()) {
                        com.byazt.p.uj.c(nVar.getActivity(), new com.byazt.s.yp() { // from class: com.byazt.z.uj.5
                            @Override // com.byazt.s.yp
                            public void c() {
                                com.byazt.x.c.tt(uj.c, "notification permission granted, start download :" + strTt);
                                uj.this.c(autoInstall, iMy, z);
                            }

                            @Override // com.byazt.s.yp
                            public void tt() {
                                com.byazt.x.c.tt(uj.c, "notification permission denied, start download :" + strTt);
                                uj.this.c(autoInstall, iMy, z);
                            }
                        });
                    } else {
                        com.byazt.x.c.tt(c, "notification permission need not request, start download :".concat(String.valueOf(strTt)));
                        com.byazt.p.uj.c(i);
                        c(autoInstall, iMy, z);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i;
            }
            return 0;
        } catch (Throwable th) {
            com.byazt.zl.c.c(nVar.sv(), (DownloadInfo) null, new BaseException(1003, com.byazt.w.a.tt(th, "addDownloadTask")), 0);
            com.byazt.x.c.n(c, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.byazt.t.ve> c(List<com.byazt.t.ve> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.byazt.t.ve veVar : list) {
                if (veVar != null && !TextUtils.isEmpty(veVar.c()) && !TextUtils.isEmpty(veVar.tt())) {
                    if (veVar.c().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.byazt.t.ve(veVar.c(), veVar.tt()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.byazt.t.ve("User-Agent", com.byazt.j.c.c));
        }
        return arrayList;
    }

    public String c(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || ve.ve(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private yv c(final com.byazt.s.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new yv() { // from class: com.byazt.z.uj.6
            @Override // com.byazt.c.yv
            public void c(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 8:
                            downloadInfo.getPackageName();
                            break;
                        case 9:
                            com.byazt.zz.ve.ic();
                            break;
                    }
                    return;
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.byazt.c.yv
            public boolean c(boolean z) {
                return aVar.c(z);
            }

            @Override // com.byazt.c.yv
            public String c() {
                return aVar.c();
            }
        };
    }

    public DownloadInfo c(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoC = c(context, str, i());
                if (downloadInfoC == null) {
                    downloadInfoC = c(context, str, com.byazt.nys.tt.c(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoC == null) {
                    downloadInfoC = c(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoC == null) {
                    downloadInfoC = c(context, str, com.byazt.nys.tt.c(context));
                }
                return (downloadInfoC == null && com.byazt.k.c.ve().c("get_download_info_by_list")) ? tt(context, str) : downloadInfoC;
            } catch (Throwable th) {
                com.byazt.x.c.tt(c, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo c(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> c(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void c(x xVar) {
        this.m = xVar;
    }

    public void c(com.byazt.zz.rh rhVar) {
        Downloader.getInstance(com.byazt.zz.ve.ic()).setReserveWifiStatusListener(rhVar);
    }

    public void c(h hVar) {
        this.my = hVar;
    }

    public void c(zb zbVar) {
        this.gt = zbVar;
    }

    public void c(int i) {
        if (com.byazt.k.c.ve().c("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        t();
        tt(i);
    }

    public void c(z zVar) {
        this.rl = zVar;
    }
}

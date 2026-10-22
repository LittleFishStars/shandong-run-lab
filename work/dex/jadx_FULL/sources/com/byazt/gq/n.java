package com.byazt.gq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.ar.AdDownloadModel;
import com.byazt.c.IDownloadListener;
import com.byazt.e.DownloadShortInfo;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.ou.OnItemClickListener;
import com.byazt.ou.rl;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.byazt.t.DownloadInfo;
import com.byazt.z.DownloadHandlerService;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hjq.permissions.Permission;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 46})
public class n implements sp, com.byazt.hu.yp.c {
    public static final String c = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Object> f28575a;
    public final IDownloadListener da;
    public final boolean gt;
    public ve i;
    public DownloadEventConfig m;
    public boolean my;
    public WeakReference<Context> n;
    public DownloadController nu;
    public SoftReference<OnItemClickListener> rh;
    public SoftReference<IDownloadButtonClickListener> rl;
    public boolean sl;
    public DownloadShortInfo sp;
    public long t;
    public final com.byazt.hu.yp tt;
    public String u;
    public uj uj;
    public x ve;
    public DownloadInfo x;
    public long yp;
    public DownloadModel z;

    public interface c {
        void c();
    }

    public interface tt {
        void c(long j);
    }

    public n() {
        com.byazt.hu.yp ypVar = new com.byazt.hu.yp(Looper.getMainLooper(), this);
        this.tt = ypVar;
        this.f28575a = new ConcurrentHashMap();
        this.da = new x.c(ypVar);
        this.yp = -1L;
        this.z = null;
        this.m = null;
        this.nu = null;
        this.ve = new x(this);
        this.uj = new uj(ypVar);
        this.gt = com.byazt.k.c.ve().c("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? t.getContext() : this.n.get();
    }

    private void m() {
        ve veVar = this.i;
        if (veVar != null && veVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.i.cancel(true);
        }
        this.i = new ve();
        if (TextUtils.isEmpty(this.u)) {
            com.byazt.hu.tt.c(this.i, this.z.getDownloadUrl(), this.z.getPackageName());
        } else {
            com.byazt.hu.tt.c(this.i, this.z.getDownloadUrl(), this.z.getPackageName(), this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo nu() {
        if (this.sp == null) {
            this.sp = new DownloadShortInfo();
        }
        return this.sp;
    }

    private void sl() {
        SoftReference<OnItemClickListener> softReference = this.rh;
        if (softReference != null && softReference.get() != null) {
            this.rh.get().onItemClick(this.z, t(), u());
            this.rh = null;
        } else {
            t.tt();
            getContext();
            u();
            t();
        }
    }

    @NonNull
    private DownloadEventConfig t() {
        DownloadEventConfig downloadEventConfig = this.m;
        return downloadEventConfig == null ? new com.byazt.su.uj.c().c() : downloadEventConfig;
    }

    @NonNull
    private DownloadController u() {
        if (this.nu == null) {
            this.nu = new com.byazt.su.ve();
        }
        return this.nu;
    }

    private void yp() {
        String str = c;
        com.byazt.hu.sl.c(str, "pICD", null);
        if (this.ve.uj(this.x)) {
            com.byazt.hu.sl.c(str, "pICD BC", null);
            a(false);
        } else {
            com.byazt.hu.sl.c(str, "pICD IC", null);
            sl();
        }
    }

    private boolean z() {
        if (!com.byazt.k.c.ve().c("fix_click_start")) {
            DownloadInfo downloadInfo = this.x;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(t.getContext()).canResume(this.x.getId())) || this.x.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.x;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.x.getCurBytes() <= 0) || this.x.getStatus() == 0 || this.x.getStatus() == -4) {
            return true;
        }
        try {
            return com.byazt.w.a.c(this.x.getStatus(), this.x.getSavePath(), this.x.getName());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp(final boolean z) {
        this.uj.c(new com.byazt.nn.n(this.yp, this.z, t(), u()));
        this.uj.c(0, 0L, 0L, new c() { // from class: com.byazt.gq.n.9
            @Override // com.byazt.gq.n.c
            public void c() {
                if (n.this.uj.c()) {
                    return;
                }
                n.this.x(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        Iterator<DownloadStatusChangeListener> it = x.c(this.f28575a).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.z, u());
        }
        int iC = this.ve.c(t.getContext(), this.da);
        String str = c;
        com.byazt.hu.sl.c(str, "beginDown id:" + iC, null);
        if (iC == 0) {
            DownloadInfo downloadInfoC = new DownloadInfo.c(this.z.getDownloadUrl()).c();
            downloadInfoC.setStatus(-1);
            c(downloadInfoC);
            com.byazt.zn.c.c().c(this.yp, new BaseException(2, "start download failed, id=0"));
            com.byazt.dm.ve.c().tt("beginDown");
        } else if (this.x != null && !com.byazt.k.c.ve().c("fix_click_start")) {
            this.ve.c(this.x, false);
        } else if (z) {
            this.ve.c();
        }
        if (this.ve.c(ve())) {
            com.byazt.hu.sl.c(str, "beginDown IC id:" + iC, null);
            sl();
        }
    }

    public void a() {
        this.tt.post(new Runnable() { // from class: com.byazt.gq.n.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = x.c((Map<Integer, Object>) n.this.f28575a).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(n.this.nu());
                }
            }
        });
    }

    public boolean i() {
        SoftReference<IDownloadButtonClickListener> softReference = this.rl;
        if (softReference == null) {
            return false;
        }
        return i.c(this.z, softReference.get());
    }

    public boolean n() {
        return t.i().optInt("quick_app_enable_switch", 0) == 0 && this.z.getQuickAppModel() != null && !TextUtils.isEmpty(this.z.getQuickAppModel().c()) && com.byazt.gq.ve.c(this.x) && com.byazt.hu.u.c(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.z.getQuickAppModel().c())));
    }

    @Override // com.byazt.gq.sp
    public long uj() {
        return this.t;
    }

    public boolean ve() {
        DownloadInfo downloadInfo = this.x;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    private void a(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = c;
        com.byazt.hu.sl.c(str, "pBCD", null);
        if (z()) {
            com.byazt.nn.n nVarN = com.byazt.nn.a.c().n(this.yp);
            if (this.my) {
                if (i()) {
                    if (uj(false) && (downloadController2 = nVarN.uj) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        c(z, true);
                        return;
                    }
                    return;
                }
                c(z, true);
                return;
            }
            if (this.z.isAd() && (downloadController = nVarN.uj) != null && downloadController.enableShowComplianceDialog() && nVarN.tt != null && com.byazt.lr.tt.c().c(nVarN.tt) && com.byazt.lr.tt.c().c(nVarN)) {
                return;
            }
            c(z, true);
            return;
        }
        com.byazt.hu.sl.c(str, "pBCD continue download, status:" + this.x.getStatus(), null);
        DownloadInfo downloadInfo = this.x;
        if (downloadInfo != null && (downloadModel = this.z) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.x.getStatus();
        final int id = this.x.getId();
        final com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(this.x);
        if (status != -2 && status != -1) {
            if (z.c(status)) {
                if (this.z.enablePause()) {
                    this.uj.c(true);
                    com.byazt.sd.x.c().tt(com.byazt.nn.a.c().uj(this.yp));
                    if (com.byazt.hu.n.c((com.byazt.dd.c) ttVarC).c("cancel_pause_optimise_switch", 0) == 1) {
                        com.byazt.tg.uj.c().c(ttVarC, status, new com.byazt.tg.x() { // from class: com.byazt.gq.n.6
                            @Override // com.byazt.tg.x
                            public void c(com.byazt.dd.tt ttVar) {
                                if (n.this.x == null && com.byazt.k.c.ve().c("fix_handle_pause")) {
                                    n.this.x = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                                }
                                n.this.ve.c(n.this.x, z);
                                if (n.this.x != null && com.byazt.w.a.tt(t.getContext()) && n.this.x.isPauseReserveOnWifi()) {
                                    n.this.x.stopPauseReserveOnWifi();
                                    com.byazt.zn.c.c().c("cancel_pause_reserve_wifi_cancel_on_wifi", ttVarC);
                                } else {
                                    sl.c().c(n.this.z, n.this.x);
                                    ttVar.sl(System.currentTimeMillis());
                                    n nVar = n.this;
                                    nVar.c(id, status, nVar.x);
                                }
                            }
                        }, new com.byazt.de.ve() { // from class: com.byazt.gq.n.5
                            @Override // com.byazt.de.ve
                            public void delete() {
                                n.this.c(true);
                            }
                        });
                        return;
                    } else {
                        com.byazt.tg.sl.c().c(ttVarC, status, new com.byazt.tg.x() { // from class: com.byazt.gq.n.7
                            @Override // com.byazt.tg.x
                            public void c(com.byazt.dd.tt ttVar) {
                                if (n.this.x == null && com.byazt.k.c.ve().c("fix_handle_pause")) {
                                    n.this.x = Downloader.getInstance(t.getContext()).getDownloadInfo(id);
                                }
                                n.this.ve.c(n.this.x, z);
                                if (n.this.x != null && com.byazt.w.a.tt(t.getContext()) && n.this.x.isPauseReserveOnWifi()) {
                                    n.this.x.stopPauseReserveOnWifi();
                                    com.byazt.zn.c.c().tt("pause_reserve_wifi_cancel_on_wifi", ttVarC);
                                } else {
                                    sl.c().c(n.this.z, n.this.x);
                                    ttVar.sl(System.currentTimeMillis());
                                    n nVar = n.this;
                                    nVar.c(id, status, nVar.x);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.ve.c(this.x, z);
            c(id, status, this.x);
            return;
        }
        this.ve.c(this.x, z);
        if (ttVarC != null) {
            ttVarC.x(System.currentTimeMillis());
            ttVarC.i(this.x.getCurBytes());
        }
        this.x.setDownloadFromReserveWifi(false);
        this.uj.c(new com.byazt.nn.n(this.yp, this.z, t(), u()));
        this.uj.c(id, this.x.getCurBytes(), this.x.getTotalBytes(), new c() { // from class: com.byazt.gq.n.3
            @Override // com.byazt.gq.n.c
            public void c() {
                if (n.this.uj.c()) {
                    return;
                }
                n nVar = n.this;
                nVar.c(id, status, nVar.x);
            }
        });
        if (status == -2 && com.byazt.hu.n.c((com.byazt.dd.c) ttVarC).c("show_pause_continue_toast", 0) == 1) {
            com.byazt.di.x.c().tt().postDelayed(new Runnable() { // from class: com.byazt.gq.n.4
                @Override // java.lang.Runnable
                public void run() {
                    t.ve().c(13, t.getContext(), n.this.z, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    private boolean ve(int i) {
        int i2;
        if (!n()) {
            return false;
        }
        String strC = this.z.getQuickAppModel().c();
        if (i != 1) {
            i2 = i != 2 ? -1 : 4;
        } else {
            i2 = 5;
        }
        DownloadModel downloadModel = this.z;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zVe = com.byazt.hu.i.ve(t.getContext(), strC);
        if (zVe) {
            com.byazt.zn.c.c().c(this.yp, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.z.getId());
            com.byazt.gq.ve.c().c(this, i2, this.z);
        } else {
            com.byazt.zn.c.c().c(this.yp, false, 0);
        }
        return zVe;
    }

    public boolean uj(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.rl;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.rl.get().handleComplianceDialog(true);
                } else {
                    this.rl.get().handleMarketFailedComplianceDialog();
                }
                this.rl = null;
                return true;
            } catch (Exception unused) {
                com.byazt.dm.ve.c().tt("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.byazt.dm.ve.c().tt("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void sp() {
        if (this.f28575a.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = x.c(this.f28575a).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.x;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.byazt.gq.sp
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n tt(Context context) {
        if (context != null) {
            this.n = new WeakReference<>(context);
        }
        t.tt(context);
        return this;
    }

    private void n(boolean z) {
        if (com.byazt.hu.n.tt(this.z).tt("notification_opt_2") == 1 && this.x != null) {
            com.byazt.n.tt.c().a(this.x.getId());
        }
        a(z);
    }

    @Override // com.byazt.gq.sp
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n tt(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (t.i().optInt("back_use_softref_listener") == 1) {
                this.f28575a.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (t.i().optInt("use_weakref_listener") == 1) {
                this.f28575a.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.f28575a.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.byazt.gq.sp
    public boolean tt() {
        return this.sl;
    }

    @Override // com.byazt.gq.sp
    public void tt(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.ve.c(this.yp);
        if (!com.byazt.nn.a.c().n(this.yp).zm()) {
            com.byazt.dm.ve.c().c("handleDownload ModelBox !isStrictValid");
        }
        if (this.ve.c(i, this.z)) {
            com.byazt.lr.a.c().c(this.ve.c, new com.byazt.lr.x() { // from class: com.byazt.gq.n.1
                @Override // com.byazt.lr.x
                public void c(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (com.byazt.hu.x.c(n.this.getContext(), n.this.ve.c, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.byazt.lr.a.c().c(0, n.this.ve.c, jSONObject);
                            return;
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 0);
                        com.byazt.lr.a.c().c(1, n.this.ve.c, jSONObject);
                        int i2 = i;
                        if (i2 == 1) {
                            com.byazt.x.c.c(n.c, "miui new rollback fail: handleDownload id:" + n.this.yp + ",tryPerformButtonClick:", null);
                            n.this.ve(true);
                            return;
                        }
                        if (i2 != 2) {
                            return;
                        }
                        com.byazt.x.c.c(n.c, "miui new rollback fail: handleDownload id:" + n.this.yp + ",tryPerformButtonClick:", null);
                        n.this.tt(true);
                    } catch (Exception e) {
                        com.byazt.dm.ve.c().c(e, "generate miui new market param error");
                    }
                }

                @Override // com.byazt.lr.x
                public void c() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.byazt.x.c.c(n.c, "miui new get miui deeplink fail: handleDownload id:" + n.this.yp + ",tryPerformButtonClick:", null);
                        n.this.ve(true);
                        return;
                    }
                    if (i2 != 2) {
                        return;
                    }
                    com.byazt.x.c.c(n.c, "miui new get miui deeplink fail: handleDownload id:" + n.this.yp + ",tryPerformButtonClick:", null);
                    n.this.tt(true);
                }
            });
            return;
        }
        if (this.ve.c(getContext(), i, this.my)) {
            return;
        }
        boolean zVe = ve(i);
        if (i == 1) {
            if (zVe) {
                return;
            }
            com.byazt.hu.sl.c(c, "handleDownload id:" + this.yp + ",pIC:", null);
            ve(true);
            return;
        }
        if (i == 2 && !zVe) {
            com.byazt.hu.sl.c(c, "handleDownload id:" + this.yp + ",pBC:", null);
            tt(true);
        }
    }

    @Override // com.byazt.gq.sp
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n tt(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.byazt.dm.ve.c().c("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.byazt.dm.ve.c().c(false, "setDownloadModel id=0");
                if (com.byazt.k.c.ve().c("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.byazt.nn.a.c().c(downloadModel);
            this.yp = downloadModel.getId();
            this.z = downloadModel;
            if (i.c(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(this.yp);
                if (ttVarUj != null && ttVarUj.t() != 3) {
                    ttVarUj.n(3L);
                    com.byazt.nn.i.c().c(ttVarUj);
                }
            }
        }
        return this;
    }

    @com.byazt.zqa.c(c = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    public class ve extends com.byazt.jtc.tt<String, Void, DownloadInfo> {
        private ve() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (n.this.z != null && !TextUtils.isEmpty(n.this.z.getFilePath())) {
                if (TextUtils.isEmpty(str)) {
                    downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(str2, n.this.z.getFilePath());
                } else {
                    downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(Downloader.getInstance(t.getContext()).getDownloadId(str, n.this.z.getFilePath()));
                }
            }
            if (downloadInfo == null) {
                return !TextUtils.isEmpty(str) ? com.byazt.z.uj.sl().c(t.getContext(), str) : com.byazt.z.uj.sl().c(t.getContext(), str2);
            }
            return downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || n.this.z == null) {
                return;
            }
            try {
                com.byazt.nn.ve veVarC = com.byazt.hu.u.c(n.this.z.getPackageName(), n.this.z.getVersionCode(), n.this.z.getVersionName());
                com.byazt.nn.x.c().c(n.this.z.getVersionCode(), veVarC.tt(), com.byazt.nn.a.c().c(downloadInfo));
                boolean zC = veVarC.c();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zC || !Downloader.getInstance(t.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(t.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (n.this.x == null || n.this.x.getStatus() != -4) {
                        n.this.x = downloadInfo;
                        if (n.this.gt) {
                            Downloader.getInstance(t.getContext()).setMainThreadListener(n.this.x.getId(), n.this.da, false);
                        } else {
                            Downloader.getInstance(t.getContext()).setMainThreadListener(n.this.x.getId(), n.this.da);
                        }
                    } else {
                        n.this.x = null;
                    }
                    n.this.ve.c(n.this.x, n.this.nu(), x.c((Map<Integer, Object>) n.this.f28575a), zC);
                } else {
                    if (downloadInfo != null && Downloader.getInstance(t.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.byazt.n.tt.c().a(downloadInfo.getId());
                        n.this.x = null;
                    }
                    if (n.this.x != null) {
                        Downloader.getInstance(t.getContext()).removeTaskMainListener(n.this.x.getId());
                        if (n.this.gt) {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.x.getId(), n.this.da, false);
                        } else {
                            Downloader.getInstance(n.this.getContext()).setMainThreadListener(n.this.x.getId(), n.this.da);
                        }
                    }
                    if (!zC) {
                        Iterator<DownloadStatusChangeListener> it = x.c((Map<Integer, Object>) n.this.f28575a).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        n.this.x = null;
                    } else {
                        n nVar = n.this;
                        nVar.x = new DownloadInfo.c(nVar.z.getDownloadUrl()).c();
                        n.this.x.setStatus(-3);
                        n.this.ve.c(n.this.x, n.this.nu(), x.c((Map<Integer, Object>) n.this.f28575a), zC);
                    }
                }
                n.this.ve.ve(n.this.x);
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public void ve(boolean z) {
        if (z) {
            com.byazt.zn.c.c().c(this.yp, 1);
        }
        yp();
    }

    @Override // com.byazt.gq.sp
    public void x() {
        com.byazt.nn.a.c().a(this.yp);
    }

    public void tt(boolean z) {
        n(z);
    }

    @Override // com.byazt.gq.sp
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n tt(DownloadController downloadController) {
        JSONObject extra;
        this.nu = downloadController;
        if (com.byazt.hu.n.tt(this.z).tt("force_auto_open") == 1) {
            u().setLinkMode(1);
        }
        if (com.byazt.k.c.ve().c("fix_show_dialog") && (extra = this.z.getExtra()) != null && extra.optInt("subprocess") > 0) {
            u().setEnableNewActivity(false);
        }
        com.byazt.nn.a.c().c(this.yp, u());
        return this;
    }

    @Override // com.byazt.gq.sp
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n tt(DownloadEventConfig downloadEventConfig) {
        this.m = downloadEventConfig;
        this.my = t().getDownloadScene() == 0;
        com.byazt.nn.a.c().c(this.yp, t());
        return this;
    }

    @Override // com.byazt.gq.sp
    public sp c(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.rh = null;
        } else {
            this.rh = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.byazt.gq.sp
    public void c() {
        this.sl = true;
        com.byazt.nn.a.c().c(this.yp, t());
        com.byazt.nn.a.c().c(this.yp, u());
        this.ve.c(this.yp);
        m();
        if (t.i().optInt("enable_empty_listener", 1) == 1 && this.f28575a.get(Integer.MIN_VALUE) == null) {
            tt(Integer.MIN_VALUE, new com.byazt.ou.c());
        }
    }

    @Override // com.byazt.gq.sp
    public boolean c(int i) {
        if (i == 0) {
            this.f28575a.clear();
        } else {
            this.f28575a.remove(Integer.valueOf(i));
        }
        if (this.f28575a.isEmpty()) {
            this.sl = false;
            this.t = System.currentTimeMillis();
            if (this.x != null) {
                Downloader.getInstance(t.getContext()).removeTaskMainListener(this.x.getId());
            }
            ve veVar = this.i;
            if (veVar != null && veVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.i.cancel(true);
            }
            this.ve.c(this.x);
            String str = c;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.x;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.byazt.hu.sl.c(str, sb.toString(), null);
            this.tt.removeCallbacksAndMessages(null);
            this.sp = null;
            this.x = null;
            return true;
        }
        if (this.f28575a.size() == 1 && this.f28575a.containsKey(Integer.MIN_VALUE)) {
            this.ve.tt(this.x);
        }
        return false;
    }

    @Override // com.byazt.gq.sp
    public void c(boolean z) {
        if (this.x != null) {
            if (z) {
                com.byazt.s.n nVarVe = com.byazt.z.uj.sl().ve();
                if (nVarVe != null) {
                    nVarVe.c(this.x);
                }
                Downloader.getInstance(com.byazt.zz.ve.ic()).cancel(this.x.getId(), true);
                return;
            }
            Intent intent = new Intent(t.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.x.getId());
            t.getContext().startService(intent);
        }
    }

    @Override // com.byazt.gq.sp
    public sp c(long j) {
        if (j != 0) {
            DownloadModel downloadModelC = com.byazt.nn.a.c().c(j);
            if (downloadModelC != null) {
                this.z = downloadModelC;
                this.yp = j;
                this.ve.c(j);
            }
        } else {
            com.byazt.dm.ve.c().c(false, "setModelId");
        }
        return this;
    }

    @Override // com.byazt.hu.yp.c
    public void c(Message message) {
        if (message != null && this.sl && message.what == 3) {
            this.x = (DownloadInfo) message.obj;
            this.ve.c(message, nu(), this.f28575a);
        }
    }

    public void c(boolean z, final boolean z2) {
        if (z) {
            com.byazt.zn.c.c().c(this.yp, 2);
        }
        if (!com.byazt.hu.u.c()) {
            if (!com.byazt.hu.da.tt("android.permission.WRITE_EXTERNAL_STORAGE") && !u().enableNewActivity()) {
                this.z.setFilePath(this.ve.tt());
            }
        } else if (!com.byazt.hu.da.tt(Permission.READ_MEDIA_IMAGES) && !com.byazt.hu.da.tt(Permission.READ_MEDIA_AUDIO) && !com.byazt.hu.da.tt(Permission.READ_MEDIA_VIDEO) && !u().enableNewActivity()) {
            this.z.setFilePath(this.ve.tt());
        }
        if (com.byazt.hu.n.ve(this.z) == 0) {
            com.byazt.hu.sl.c(c, "pBCD not start", null);
            this.ve.c(new rl() { // from class: com.byazt.gq.n.8
                @Override // com.byazt.ou.rl
                public void c() {
                    com.byazt.hu.sl.c(n.c, "pBCD start download", null);
                    n.this.sp(z2);
                }

                @Override // com.byazt.ou.rl
                public void c(String str) {
                    com.byazt.hu.sl.c(n.c, "pBCD onDenied", null);
                }
            });
        } else {
            sp(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, @NonNull DownloadInfo downloadInfo) {
        if (com.byazt.k.c.ve().c("fix_click_start")) {
            if (i2 != -3 && !com.byazt.zz.uj.c().n(i)) {
                c(false, false);
                return;
            } else {
                com.byazt.z.uj.sl().c(t.getContext(), i, i2);
                return;
            }
        }
        com.byazt.z.uj.sl().c(t.getContext(), i, i2);
    }

    private void c(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.tt.sendMessage(messageObtain);
    }

    @Override // com.byazt.gq.sp
    public sp c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.u = str;
        }
        return this;
    }

    @Override // com.byazt.gq.sp
    public sp c(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.rl = null;
        } else {
            this.rl = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}

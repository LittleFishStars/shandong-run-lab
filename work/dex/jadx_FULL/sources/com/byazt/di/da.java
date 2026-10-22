package com.byazt.di;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.byazt.gq.t;
import com.byazt.gq.yp;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.ou.OnItemClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 72})
public class da {
    public static volatile da c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28403a;
    public com.byazt.pk.tt n;
    public final com.byazt.d.c tt;
    public final com.byazt.pk.c uj;
    public final x ve;

    /* JADX INFO: Access modifiers changed from: private */
    public x x() {
        return this.ve;
    }

    public String a() {
        return t.yp();
    }

    public com.byazt.pk.tt n() {
        if (this.n == null) {
            this.n = tt.c();
        }
        return this.n;
    }

    public void sp() {
        n.c().a();
    }

    public com.byazt.pk.c uj() {
        return this.uj;
    }

    public void ve() {
        this.f28403a = System.currentTimeMillis();
    }

    private da(Context context) {
        this.ve = x.c();
        this.tt = new a();
        this.f28403a = System.currentTimeMillis();
        tt(context);
        this.uj = c.c();
    }

    public static da c(final Context context) {
        if (c == null) {
            synchronized (da.class) {
                if (c == null) {
                    com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.1
                        @Override // java.lang.Runnable
                        public void run() {
                            da unused = da.c = new da(context);
                        }
                    });
                }
            }
        }
        return c;
    }

    private void tt(Context context) {
        t.c(context);
        Downloader.getInstance(t.getContext());
        com.byazt.nn.a.c().tt();
        com.byazt.z.uj.sl().c(t.getContext(), "misc_config", new com.byazt.sd.sp(), new com.byazt.sd.a(context), new ve());
        com.byazt.sd.uj ujVar = new com.byazt.sd.uj();
        com.byazt.z.uj.sl().c(ujVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(ujVar);
        com.byazt.z.uj.sl().c(new yp());
        com.byazt.zz.ve.c(new com.byazt.sd.n());
        com.byazt.z.uj.sl().c(com.byazt.xk.ve.c());
    }

    public com.byazt.d.c c() {
        return this.tt;
    }

    public com.byazt.d.c c(String str) {
        com.byazt.ou.a aVarTt = sp.c().tt();
        if (aVarTt != null && aVarTt.c(str)) {
            return aVarTt.tt(str);
        }
        return this.tt;
    }

    public long tt() {
        return this.f28403a;
    }

    @MainThread
    public void c(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.4
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.z.uj.sl().c(t.getContext(), str);
    }

    @MainThread
    public void c(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.5
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(str, j, i, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void c(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.6
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void c(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.7
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(str, j, i, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void c(final String str, final int i) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.2
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(str, i);
            }
        });
    }

    @MainThread
    public void c(final String str, final boolean z) {
        com.byazt.dm.tt.c(new Runnable() { // from class: com.byazt.di.da.3
            @Override // java.lang.Runnable
            public void run() {
                da.this.x().c(str, z);
            }
        });
    }

    public void c(com.byazt.yq.c cVar) {
        x().c(cVar);
    }

    public DownloadInfo c(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return tt(str);
        }
        return Downloader.getInstance(t.getContext()).getDownloadInfo(str, str2);
    }
}

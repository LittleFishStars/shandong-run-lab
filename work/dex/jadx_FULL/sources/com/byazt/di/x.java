package com.byazt.di;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.byazt.ar.AdDownloadModel;
import com.byazt.gq.t;
import com.byazt.m.BaseException;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.ou.OnItemClickListener;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.byazt.t.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 71})
public class x {
    public static volatile x c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28410a;
    public final List<com.byazt.gq.sp> ve = new CopyOnWriteArrayList();
    public final Map<String, com.byazt.gq.sp> uj = new ConcurrentHashMap();
    public final CopyOnWriteArrayList<Object> n = new CopyOnWriteArrayList<>();
    public final Handler tt = new Handler(Looper.getMainLooper());

    private x() {
    }

    private synchronized void tt(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.ve.size() <= 0) {
            ve(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.byazt.gq.sp spVarRemove = this.ve.remove(0);
        spVarRemove.tt(context).tt(i, downloadStatusChangeListener).tt(downloadModel).c();
        this.uj.put(downloadModel.getDownloadUrl(), spVarRemove);
    }

    private void uj() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.byazt.gq.sp spVar : this.ve) {
            if (!spVar.tt() && jCurrentTimeMillis - spVar.uj() > 300000) {
                spVar.x();
                arrayList.add(spVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.ve.removeAll(arrayList);
    }

    private void ve(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.gq.n nVar = new com.byazt.gq.n();
        nVar.tt(context).tt(i, downloadStatusChangeListener).tt(downloadModel).c();
        this.uj.put(downloadModel.getDownloadUrl(), nVar);
    }

    public static x c() {
        if (c == null) {
            synchronized (x.class) {
                if (c == null) {
                    c = new x();
                }
            }
        }
        return c;
    }

    private void ve() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f28410a < 300000) {
            return;
        }
        this.f28410a = jCurrentTimeMillis;
        if (this.ve.isEmpty()) {
            return;
        }
        uj();
    }

    public void c(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.byazt.gq.sp spVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = t.i().optInt("filter_download_url_key", 0) == 1;
        String strC = com.byazt.gq.a.c().c(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strC)) {
            spVar = this.uj.get(strC);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strC);
                }
            }
        } else {
            spVar = this.uj.get(downloadModel.getDownloadUrl());
        }
        if (spVar != null) {
            spVar.tt(context).tt(i, downloadStatusChangeListener).tt(downloadModel).c();
            return;
        }
        if (this.ve.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strC)) {
                    tt(context, i, downloadStatusChangeListener, downloadModel, strC);
                    return;
                }
                String strC2 = com.byazt.gq.a.c().c(downloadModel);
                if (!TextUtils.isEmpty(strC2)) {
                    tt(context, i, downloadStatusChangeListener, downloadModel, strC2);
                    if (downloadModel instanceof AdDownloadModel) {
                        AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                        if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(strC2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            ve(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strC)) {
                c(context, i, downloadStatusChangeListener, downloadModel, strC);
                return;
            }
            String strC3 = com.byazt.gq.a.c().c(downloadModel);
            if (TextUtils.isEmpty(strC3)) {
                tt(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            c(context, i, downloadStatusChangeListener, downloadModel, strC3);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(strC3);
                    return;
                }
                return;
            }
            return;
        }
        tt(context, i, downloadStatusChangeListener, downloadModel);
    }

    private void tt(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.byazt.gq.n nVar = new com.byazt.gq.n();
        nVar.tt(context).tt(i, downloadStatusChangeListener).tt(downloadModel).c(str).c();
        this.uj.put(str, nVar);
        com.byazt.gq.a.c().c(str, downloadModel.getDownloadUrl());
    }

    public void tt(final DownloadInfo downloadInfo, final String str) {
        this.tt.post(new Runnable() { // from class: com.byazt.di.x.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.n) {
                    if (obj instanceof com.byazt.yq.c) {
                        ((com.byazt.yq.c) obj).c(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.yq.c) {
                            ((com.byazt.yq.c) softReference.get()).c(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler tt() {
        return this.tt;
    }

    public com.byazt.gq.n c(String str) {
        com.byazt.gq.sp spVar;
        Map<String, com.byazt.gq.sp> map = this.uj;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (t.i().optInt("filter_download_url_key", 0) == 1) {
                spVar = this.uj.get(com.byazt.gq.a.c().c(str));
            } else {
                spVar = this.uj.get(str);
            }
            if (spVar instanceof com.byazt.gq.n) {
                return (com.byazt.gq.n) spVar;
            }
        }
        return null;
    }

    private synchronized void c(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.ve.size() <= 0) {
            tt(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.byazt.gq.sp spVarRemove = this.ve.remove(0);
        spVarRemove.tt(context).tt(i, downloadStatusChangeListener).tt(downloadModel).c(str).c();
        this.uj.put(str, spVarRemove);
        com.byazt.gq.a.c().c(str, downloadModel.getDownloadUrl());
    }

    public void c(String str, int i) {
        com.byazt.gq.sp spVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = t.i().optInt("filter_download_url_key", 0) == 1;
        String strC = com.byazt.gq.a.c().c(str);
        if (z && !TextUtils.isEmpty(strC)) {
            spVar = this.uj.get(strC);
        } else {
            spVar = this.uj.get(str);
        }
        if (spVar != null) {
            if (spVar.c(i)) {
                this.ve.add(spVar);
                if (z && !TextUtils.isEmpty(strC)) {
                    this.uj.remove(strC);
                    com.byazt.gq.a.c().tt(strC);
                } else {
                    this.uj.remove(str);
                }
            }
            ve();
        }
    }

    public void c(String str, boolean z) {
        com.byazt.gq.sp spVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = t.i().optInt("filter_download_url_key", 0) == 1;
        String strC = com.byazt.gq.a.c().c(str);
        if (z2 && !TextUtils.isEmpty(strC)) {
            spVar = this.uj.get(strC);
        } else {
            spVar = this.uj.get(str);
        }
        if (spVar != null) {
            spVar.c(z);
        }
    }

    public void c(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        c(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void c(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        c(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void c(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.byazt.gq.sp spVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = t.i().optInt("filter_download_url_key", 0) == 1;
        String strC = com.byazt.gq.a.c().c(str);
        if (z && !TextUtils.isEmpty(strC)) {
            spVar = this.uj.get(strC);
        } else {
            spVar = this.uj.get(str);
        }
        if (spVar != null) {
            spVar.c(j).tt(downloadEventConfig).tt(downloadController).c(onItemClickListener).c(iDownloadButtonClickListener).tt(i);
        }
    }

    public void c(com.byazt.yq.c cVar) {
        if (cVar != null) {
            if (com.byazt.k.c.ve().tt("fix_listener_oom", false)) {
                this.n.add(new SoftReference(cVar));
            } else {
                this.n.add(cVar);
            }
        }
    }

    public void c(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.tt.post(new Runnable() { // from class: com.byazt.di.x.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.n) {
                    if (!(obj instanceof com.byazt.yq.c) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.yq.c) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.tt.post(new Runnable() { // from class: com.byazt.di.x.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.n) {
                    if (!(obj instanceof com.byazt.yq.c) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.yq.c) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, final String str) {
        this.tt.post(new Runnable() { // from class: com.byazt.di.x.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.n) {
                    if (!(obj instanceof com.byazt.yq.c) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.yq.c) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo) {
        this.tt.post(new Runnable() { // from class: com.byazt.di.x.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : x.this.n) {
                    if (!(obj instanceof com.byazt.yq.c) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.yq.c) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }
}

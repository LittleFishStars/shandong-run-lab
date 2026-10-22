package com.byazt.w;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.c.IDownloadFileUriProvider;
import com.byazt.c.IDownloadInterceptor;
import com.byazt.c.IDownloadListener;
import com.byazt.c.d;
import com.byazt.c.eo;
import com.byazt.c.gr;
import com.byazt.c.gt;
import com.byazt.c.gu;
import com.byazt.c.m;
import com.byazt.c.my;
import com.byazt.c.nb;
import com.byazt.c.nu;
import com.byazt.c.or;
import com.byazt.c.qp;
import com.byazt.c.qy;
import com.byazt.c.rh;
import com.byazt.c.rl;
import com.byazt.c.t;
import com.byazt.c.u;
import com.byazt.c.yp;
import com.byazt.c.yv;
import com.byazt.c.z;
import com.byazt.c.zm;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 91})
public class sp {
    public static Handler c = new Handler(Looper.getMainLooper());

    public static com.byazt.t.c c(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new com.byazt.t.c.AbstractBinderC0530c() { // from class: com.byazt.w.sp.1
            @Override // com.byazt.t.c
            public com.byazt.c.a a() throws RemoteException {
                return sp.c(downloadTask.getDepend());
            }

            @Override // com.byazt.t.c
            public DownloadInfo c() throws RemoteException {
                return downloadTask.getDownloadInfo();
            }

            @Override // com.byazt.t.c
            public com.byazt.c.da da() throws RemoteException {
                return sp.c(downloadTask.getMonitorDepend());
            }

            @Override // com.byazt.t.c
            public m i() throws RemoteException {
                return sp.c(downloadTask.getDiskSpaceHandler());
            }

            @Override // com.byazt.t.c
            public com.byazt.c.x n() throws RemoteException {
                return sp.c(downloadTask.getInterceptor());
            }

            @Override // com.byazt.t.c
            public com.byazt.c.sp sl() throws RemoteException {
                return sp.c(downloadTask.getFileUriProvider());
            }

            @Override // com.byazt.t.c
            public rl sp() throws RemoteException {
                return sp.c(downloadTask.getForbiddenHandler());
            }

            @Override // com.byazt.t.c
            public int t() throws RemoteException {
                return downloadTask.getDownloadCompleteHandlers().size();
            }

            @Override // com.byazt.t.c
            public com.byazt.c.n tt() throws RemoteException {
                return sp.c(downloadTask.getChunkStrategy());
            }

            @Override // com.byazt.t.c
            public d uj() throws RemoteException {
                return sp.c(downloadTask.getNotificationClickCallback());
            }

            @Override // com.byazt.t.c
            public zm ve() throws RemoteException {
                return sp.c(downloadTask.getNotificationEventListener());
            }

            @Override // com.byazt.t.c
            public or x() throws RemoteException {
                return sp.c(downloadTask.getRetryDelayTimeCalculator());
            }

            @Override // com.byazt.t.c
            public int c(int i) throws RemoteException {
                return downloadTask.getDownloadListenerSize(a.n(i));
            }

            @Override // com.byazt.t.c
            public com.byazt.c.i tt(int i) throws RemoteException {
                return sp.c(downloadTask.getSingleDownloadListener(a.n(i)), i != com.byazt.ev.a.SUB.ordinal());
            }

            @Override // com.byazt.t.c
            public t ve(int i) throws RemoteException {
                return sp.c(downloadTask.getDownloadCompleteHandlerByIndex(i));
            }

            @Override // com.byazt.t.c
            public com.byazt.c.i c(int i, int i2) throws RemoteException {
                return sp.c(downloadTask.getDownloadListenerByIndex(a.n(i), i2), i != com.byazt.ev.a.SUB.ordinal());
            }
        };
    }

    public static com.byazt.c.i c(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new com.byazt.c.i.c() { // from class: com.byazt.w.sp.12
            @Override // com.byazt.c.i
            public void a(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onCanceled(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public int c() throws RemoteException {
                return iDownloadListener.hashCode();
            }

            @Override // com.byazt.c.i
            public void i(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = iDownloadListener;
                if (iDownloadListener2 instanceof my) {
                    if (z) {
                        sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((my) iDownloadListener).c(downloadInfo);
                            }
                        });
                    } else {
                        ((my) iDownloadListener2).c(downloadInfo);
                    }
                }
            }

            @Override // com.byazt.c.i
            public void n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onSuccessed(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void sp(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstStart(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void tt(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onStart(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onStart(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void uj(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPause(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPause(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void ve(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onProgress(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onProgress(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void x(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void c(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    iDownloadListener.onPrepare(downloadInfo);
                }
            }

            @Override // com.byazt.c.i
            public void tt(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.c.i
            public void ve(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.byazt.c.i
            public void c(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    sp.c.post(new Runnable() { // from class: com.byazt.w.sp.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            iDownloadListener.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    iDownloadListener.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static zm c(final yv yvVar) {
        if (yvVar == null) {
            return null;
        }
        return new zm.c() { // from class: com.byazt.w.sp.23
            @Override // com.byazt.c.zm
            public void c(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                yvVar.c(i, downloadInfo, str, str2);
            }

            @Override // com.byazt.c.zm
            public boolean c(boolean z) throws RemoteException {
                return yvVar.c(z);
            }

            @Override // com.byazt.c.zm
            public String c() throws RemoteException {
                return yvVar.c();
            }
        };
    }

    public static d c(final eo eoVar) {
        if (eoVar == null) {
            return null;
        }
        return new d.c() { // from class: com.byazt.w.sp.26
            @Override // com.byazt.c.d
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                return eoVar.c(downloadInfo);
            }

            @Override // com.byazt.c.d
            public boolean tt(DownloadInfo downloadInfo) throws RemoteException {
                return eoVar.tt(downloadInfo);
            }

            @Override // com.byazt.c.d
            public boolean ve(DownloadInfo downloadInfo) throws RemoteException {
                return eoVar.ve(downloadInfo);
            }
        };
    }

    public static or c(final com.byazt.zz.my myVar) {
        if (myVar == null) {
            return null;
        }
        return new or.c() { // from class: com.byazt.w.sp.27
            @Override // com.byazt.c.or
            public long c(int i, int i2) throws RemoteException {
                return myVar.c(i, i2);
            }
        };
    }

    public static rl c(final gu guVar) {
        if (guVar == null) {
            return null;
        }
        return new rl.c() { // from class: com.byazt.w.sp.28
            @Override // com.byazt.c.rl
            public boolean c(gt gtVar) throws RemoteException {
                return guVar.c(sp.c(gtVar));
            }
        };
    }

    public static com.byazt.c.sp c(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new com.byazt.c.sp.c() { // from class: com.byazt.w.sp.29
            @Override // com.byazt.c.sp
            public Uri c(String str, String str2) throws RemoteException {
                return iDownloadFileUriProvider.getUriForFile(str, str2);
            }
        };
    }

    public static qy c(final gt gtVar) {
        if (gtVar == null) {
            return null;
        }
        return new qy() { // from class: com.byazt.w.sp.30
            @Override // com.byazt.c.qy
            public void c(List<String> list) {
                try {
                    gtVar.c(list);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.qy
            public boolean c() {
                try {
                    return gtVar.c();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static m c(final rh rhVar) {
        if (rhVar == null) {
            return null;
        }
        return new m.c() { // from class: com.byazt.w.sp.31
            @Override // com.byazt.c.m
            public boolean c(long j, long j2, z zVar) throws RemoteException {
                return rhVar.c(j, j2, sp.c(zVar));
            }
        };
    }

    public static nu c(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new nu() { // from class: com.byazt.w.sp.2
            @Override // com.byazt.c.nu
            public void c() {
                try {
                    zVar.c();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        };
    }

    public static com.byazt.c.a c(final yp ypVar) {
        if (ypVar == null) {
            return null;
        }
        return new com.byazt.c.a.c() { // from class: com.byazt.w.sp.3
            @Override // com.byazt.c.a
            public void c(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                ypVar.c(downloadInfo, baseException, i);
            }
        };
    }

    public static com.byazt.c.da c(final gr grVar) {
        if (grVar == null) {
            return null;
        }
        return new com.byazt.c.da.c() { // from class: com.byazt.w.sp.4
            @Override // com.byazt.c.da
            public void c(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    grVar.c(new JSONObject(str));
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.da
            public int[] tt() throws RemoteException {
                gr grVar2 = grVar;
                if (grVar2 instanceof com.byazt.c.ve) {
                    return ((com.byazt.c.ve) grVar2).c();
                }
                return null;
            }

            @Override // com.byazt.c.da
            public String c() throws RemoteException {
                return grVar.tt();
            }
        };
    }

    public static com.byazt.c.n c(final com.byazt.zz.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new com.byazt.c.n.c() { // from class: com.byazt.w.sp.5
            @Override // com.byazt.c.n
            public int c(long j) throws RemoteException {
                return xVar.c(j);
            }
        };
    }

    public static com.byazt.c.x c(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new com.byazt.c.x.c() { // from class: com.byazt.w.sp.6
            @Override // com.byazt.c.x
            public boolean c() throws RemoteException {
                return iDownloadInterceptor.intercepte();
            }
        };
    }

    public static DownloadTask c(com.byazt.t.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(cVar.c());
            downloadTask.chunkStategy(c(cVar.tt())).notificationEventListener(c(cVar.ve())).interceptor(c(cVar.n())).depend(c(cVar.a())).monitorDepend(c(cVar.da())).forbiddenHandler(c(cVar.sp())).diskSpaceHandler(c(cVar.i())).fileUriProvider(c(cVar.sl())).notificationClickCallback(c(cVar.uj())).retryDelayTimeCalculator(c(cVar.x()));
            com.byazt.ev.a aVar = com.byazt.ev.a.MAIN;
            com.byazt.c.i iVarTt = cVar.tt(aVar.ordinal());
            if (iVarTt != null) {
                downloadTask.mainThreadListenerWithHashCode(iVarTt.hashCode(), c(iVarTt));
            }
            com.byazt.ev.a aVar2 = com.byazt.ev.a.SUB;
            com.byazt.c.i iVarTt2 = cVar.tt(aVar2.ordinal());
            if (iVarTt2 != null) {
                downloadTask.subThreadListenerWithHashCode(iVarTt2.hashCode(), c(iVarTt2));
            }
            com.byazt.ev.a aVar3 = com.byazt.ev.a.NOTIFICATION;
            com.byazt.c.i iVarTt3 = cVar.tt(aVar3.ordinal());
            if (iVarTt3 != null) {
                downloadTask.notificationListenerWithHashCode(iVarTt3.hashCode(), c(iVarTt3));
            }
            c(downloadTask, cVar, aVar);
            c(downloadTask, cVar, aVar2);
            c(downloadTask, cVar, aVar3);
            c(downloadTask, cVar);
            return downloadTask;
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    private static void c(DownloadTask downloadTask, com.byazt.t.c cVar, com.byazt.ev.a aVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < cVar.c(aVar.ordinal()); i++) {
            com.byazt.c.i iVarC = cVar.c(aVar.ordinal(), i);
            if (iVarC != null) {
                sparseArray.put(iVarC.c(), c(iVarC));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, aVar);
    }

    private static void c(DownloadTask downloadTask, com.byazt.t.c cVar) throws RemoteException {
        for (int i = 0; i < cVar.t(); i++) {
            t tVarVe = cVar.ve(i);
            if (tVarVe != null) {
                downloadTask.addDownloadCompleteHandler(c(tVarVe));
            }
        }
    }

    public static yv c(final zm zmVar) {
        if (zmVar == null) {
            return null;
        }
        return new yv() { // from class: com.byazt.w.sp.7
            @Override // com.byazt.c.yv
            public void c(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    zmVar.c(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.yv
            public boolean c(boolean z) {
                try {
                    return zmVar.c(z);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }

            @Override // com.byazt.c.yv
            public String c() {
                try {
                    return zmVar.c();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return null;
                }
            }
        };
    }

    public static u c(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new u() { // from class: com.byazt.w.sp.8
            @Override // com.byazt.c.u
            public void c(DownloadInfo downloadInfo) throws BaseException {
                try {
                    tVar.c(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }

            @Override // com.byazt.c.u
            public boolean tt(DownloadInfo downloadInfo) {
                try {
                    return tVar.tt(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static t c(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new t.c() { // from class: com.byazt.w.sp.9
            @Override // com.byazt.c.t
            public void c(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    uVar.c(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.byazt.c.t
            public boolean tt(DownloadInfo downloadInfo) throws RemoteException {
                return uVar.tt(downloadInfo);
            }
        };
    }

    public static eo c(final d dVar) {
        if (dVar == null) {
            return null;
        }
        return new eo() { // from class: com.byazt.w.sp.10
            @Override // com.byazt.c.eo
            public boolean c(DownloadInfo downloadInfo) {
                try {
                    return dVar.c(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }

            @Override // com.byazt.c.eo
            public boolean tt(DownloadInfo downloadInfo) {
                try {
                    return dVar.tt(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }

            @Override // com.byazt.c.eo
            public boolean ve(DownloadInfo downloadInfo) {
                try {
                    return dVar.ve(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static com.byazt.zz.x c(final com.byazt.c.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new com.byazt.zz.x() { // from class: com.byazt.w.sp.11
            @Override // com.byazt.zz.x
            public int c(long j) {
                try {
                    return nVar.c(j);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return 0;
                }
            }
        };
    }

    public static yp c(final com.byazt.c.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new yp() { // from class: com.byazt.w.sp.13
            @Override // com.byazt.c.yp
            public void c(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    aVar.c(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        };
    }

    public static gr c(final com.byazt.c.da daVar) {
        if (daVar == null) {
            return null;
        }
        return new com.byazt.c.ve() { // from class: com.byazt.w.sp.14
            @Override // com.byazt.c.gr
            public void c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    daVar.c(jSONObject.toString());
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.gr
            public String tt() {
                try {
                    return daVar.c();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return "";
                }
            }

            @Override // com.byazt.c.ve
            public int[] c() {
                try {
                    return daVar.tt();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return null;
                }
            }
        };
    }

    public static gu c(final rl rlVar) {
        if (rlVar == null) {
            return null;
        }
        return new gu() { // from class: com.byazt.w.sp.15
            @Override // com.byazt.c.gu
            public boolean c(qy qyVar) {
                try {
                    return rlVar.c(sp.c(qyVar));
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static gt c(final qy qyVar) {
        if (qyVar == null) {
            return null;
        }
        return new gt.c() { // from class: com.byazt.w.sp.16
            @Override // com.byazt.c.gt
            public void c(List<String> list) {
                qyVar.c(list);
            }

            @Override // com.byazt.c.gt
            public boolean c() {
                return qyVar.c();
            }
        };
    }

    public static qp c(final nb nbVar) {
        if (nbVar == null) {
            return null;
        }
        return new qp.c() { // from class: com.byazt.w.sp.17
            @Override // com.byazt.c.qp
            public void c(int i, int i2) {
                nbVar.c(i, i2);
            }
        };
    }

    public static nb c(final qp qpVar) {
        if (qpVar == null) {
            return null;
        }
        return new nb() { // from class: com.byazt.w.sp.18
            @Override // com.byazt.c.nb
            public void c(int i, int i2) {
                try {
                    qpVar.c(i, i2);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        };
    }

    public static rh c(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new rh() { // from class: com.byazt.w.sp.19
            @Override // com.byazt.c.rh
            public boolean c(long j, long j2, nu nuVar) {
                try {
                    return mVar.c(j, j2, sp.c(nuVar));
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static z c(final nu nuVar) {
        if (nuVar == null) {
            return null;
        }
        return new z.c() { // from class: com.byazt.w.sp.20
            @Override // com.byazt.c.z
            public void c() throws RemoteException {
                nuVar.c();
            }
        };
    }

    public static com.byazt.zz.my c(final or orVar) {
        if (orVar == null) {
            return null;
        }
        return new com.byazt.zz.my() { // from class: com.byazt.w.sp.21
            @Override // com.byazt.zz.my
            public long c(int i, int i2) {
                try {
                    return orVar.c(i, i2);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor c(final com.byazt.c.x xVar) {
        if (xVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.byazt.w.sp.22
            @Override // com.byazt.c.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return xVar.c();
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider c(final com.byazt.c.sp spVar) {
        if (spVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.byazt.w.sp.24
            @Override // com.byazt.c.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return spVar.c(str, str2);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                    return null;
                }
            }
        };
    }

    public static IDownloadListener c(final com.byazt.c.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new my() { // from class: com.byazt.w.sp.25
            @Override // com.byazt.c.my
            public void c(DownloadInfo downloadInfo) {
                try {
                    iVar.i(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    iVar.a(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.c(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    iVar.sp(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    iVar.x(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    iVar.uj(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    iVar.c(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    iVar.ve(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.tt(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    iVar.ve(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    iVar.tt(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }

            @Override // com.byazt.c.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    iVar.n(downloadInfo);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        };
    }
}

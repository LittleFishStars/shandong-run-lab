package com.byazt.zz;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.byazt.b.DownloadHandleService;
import com.byazt.c.eo;
import com.byazt.c.nb;
import com.byazt.c.p;
import com.byazt.hs.IDownloadHttpService;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.igexin.sdk.PushConsts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile com.byazt.b.c f29270a;
    public static final int aw;
    public static volatile boolean b;
    public static int bm;
    public static int bx;
    public static volatile Context c;
    public static volatile com.byazt.hs.a cu;
    public static volatile IDownloadHttpService da;
    public static volatile sp gr;
    public static volatile ExecutorService gt;
    public static volatile ScheduledExecutorService gu;
    public static volatile p h;
    public static final int hd;
    public static volatile c i;
    public static final int ic;
    public static com.byazt.zl.ve kp;
    public static final List<com.byazt.c.sl> l;
    public static final List<Object> lo;
    public static boolean lr;
    public static boolean lt;
    public static volatile ExecutorService m;
    public static volatile com.byazt.zl.tt md;
    public static volatile ExecutorService my;
    public static volatile eo n;
    public static volatile ExecutorService nu;
    public static volatile com.byazt.hs.a or;
    public static volatile nu p;
    public static int pu;
    public static volatile rl qp;
    public static volatile ExecutorService qy;
    public static volatile ExecutorService rh;
    public static volatile ExecutorService rl;
    public static volatile com.byazt.hs.x sl;
    public static volatile z sp;
    public static final int sv;
    public static volatile IDownloadHttpService t;
    public static rh tk;
    public static boolean to;
    public static volatile da tt;
    public static volatile com.byazt.hs.x u;
    public static volatile x uj;
    public static volatile sl ve;
    public static volatile z x;
    public static volatile t yp;
    public static volatile my yv;
    public static volatile ExecutorService z;
    public static volatile DownloadReceiver zm;
    public static volatile List<nb> d = new ArrayList();
    public static volatile boolean eo = false;
    public static volatile OkHttpClient zb = null;
    public static final List<com.byazt.c.u> nb = new ArrayList();
    public static boolean pf = false;

    public interface c {

        /* JADX INFO: renamed from: com.byazt.zz.ve$c$c, reason: collision with other inner class name */
        public interface InterfaceC0604c {
            void c();
        }

        gt c(InterfaceC0604c interfaceC0604c);

        z c();

        u tt();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        sv = iAvailableProcessors;
        aw = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        ic = iAvailableProcessors;
        hd = iAvailableProcessors;
        bm = 8192;
        l = new ArrayList();
        lo = new ArrayList();
        lt = true;
        to = false;
        b = false;
    }

    private ve() {
    }

    public static com.byazt.hs.x a() {
        return sl;
    }

    public static rl aw() {
        if (qp == null) {
            synchronized (ve.class) {
                if (qp == null) {
                    qp = new rl.c();
                }
            }
        }
        return qp;
    }

    @NonNull
    public static com.byazt.zl.ve bm() {
        if (kp == null) {
            kp = new com.byazt.zl.ve() { // from class: com.byazt.zz.ve.3
                @Override // com.byazt.zl.ve
                public void c(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.byazt.zl.ve
                public void tt(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return kp;
    }

    public static sp bx() {
        if (gr == null) {
            synchronized (ve.class) {
                if (gr == null) {
                    gr = new com.byazt.b.tt();
                }
            }
        }
        return gr;
    }

    public static synchronized void c(DownloaderBuilder downloaderBuilder) {
        if (b) {
            com.byazt.x.c.n("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = eo;
        ve(downloaderBuilder);
        if (tt == null) {
            tt = new com.byazt.b.uj();
        }
        if (sp == null) {
            sp = new com.byazt.b.x();
        }
        if (x == null && i != null) {
            x = i.c();
        }
        if (ve == null) {
            ve = new com.byazt.b.i();
        }
        if (f29270a == null) {
            f29270a = new com.byazt.b.n();
        }
        if (uj == null) {
            uj = new com.byazt.b.ve();
        }
        if (gr == null) {
            gr = new com.byazt.b.tt();
        }
        if (yv == null) {
            yv = new com.byazt.b.da();
        }
        int i2 = bx;
        if (i2 <= 0 || i2 > sv) {
            bx = sv;
        }
        lt();
        if (eo && !z2 && !com.byazt.w.a.ve()) {
            com.byazt.b.t.c(true).startService();
        } else if (com.byazt.w.a.uj()) {
            ExecutorService executorServiceU = u();
            if (executorServiceU != null) {
                executorServiceU.execute(new Runnable() { // from class: com.byazt.zz.ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextIc = ve.ic();
                        if (contextIc != null) {
                            com.byazt.w.a.uj(contextIc);
                        }
                    }
                });
            }
        } else {
            Context contextIc = ic();
            if (contextIc != null) {
                com.byazt.w.a.uj(contextIc);
            }
        }
        or();
        b = true;
    }

    public static void c(rh rhVar) {
    }

    public static boolean cu() {
        return lt;
    }

    public static com.byazt.b.c d() {
        if (f29270a == null) {
            synchronized (ve.class) {
                if (f29270a == null) {
                    f29270a = new com.byazt.b.n();
                }
            }
        }
        return f29270a;
    }

    public static boolean da() {
        return com.byazt.k.c.ve().c("switch_not_auto_boot_service", to ? 1 : 0) > 0;
    }

    public static int eo() {
        return pu;
    }

    public static synchronized t gr() {
        return yp;
    }

    public static ScheduledExecutorService gt() {
        if (gu == null) {
            synchronized (ve.class) {
                if (gu == null) {
                    gu = new com.byazt.jtc.n(1, new com.byazt.u.c("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return gu;
    }

    public static com.byazt.hs.a gu() {
        if (cu == null) {
            synchronized (ve.class) {
                if (cu == null) {
                    cu = new com.byazt.hs.a() { // from class: com.byazt.zz.ve.2
                        @Override // com.byazt.hs.a
                        public List<InetAddress> c(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return cu;
    }

    public static sl h() {
        if (ve == null) {
            synchronized (ve.class) {
                if (ve == null) {
                    ve = new com.byazt.b.i();
                }
            }
        }
        return ve;
    }

    public static synchronized boolean hd() {
        return lr;
    }

    public static com.byazt.hs.x i() {
        if (u == null) {
            synchronized (ve.class) {
                if (u == null) {
                    u = new com.byazt.b.a();
                }
            }
        }
        return u;
    }

    public static synchronized Context ic() {
        return c;
    }

    public static boolean l() {
        return b;
    }

    public static boolean lo() {
        StringBuilder sb = new StringBuilder("supportMultiProc::=");
        sb.append(i != null);
        com.byazt.x.c.c("wjd", sb.toString());
        return i != null;
    }

    public static rh lr() {
        return tk;
    }

    private static void lt() {
        if (zm == null) {
            zm = new DownloadReceiver();
        }
        if (pf) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            c.registerReceiver(zm, intentFilter);
            pf = true;
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public static ExecutorService m() {
        if (nu == null) {
            synchronized (ve.class) {
                if (nu == null) {
                    int i2 = ic;
                    com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.u.c("DownloadThreadPool-mix-fixed", true));
                    try {
                        ujVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                    nu = ujVar;
                }
            }
        }
        return nu;
    }

    public static List<com.byazt.c.u> md() {
        return nb;
    }

    public static OkHttpClient my() {
        if (zb == null) {
            synchronized (ve.class) {
                if (zb == null) {
                    zb = rl().build();
                }
            }
        }
        return zb;
    }

    public static List<nb> n() {
        List<nb> list;
        synchronized (d) {
            list = d;
        }
        return list;
    }

    public static x nb() {
        if (uj == null) {
            synchronized (ve.class) {
                if (uj == null) {
                    uj = new com.byazt.b.ve();
                }
            }
        }
        return uj;
    }

    public static ExecutorService nu() {
        if (rl == null) {
            synchronized (ve.class) {
                if (rl == null) {
                    int i2 = aw;
                    com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.u.c("DownloadThreadPool-chunk-fixed", true));
                    try {
                        ujVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                    rl = ujVar;
                }
            }
        }
        return rl;
    }

    public static void or() {
        if (TextUtils.isEmpty(com.byazt.ev.n.ve)) {
            com.byazt.ev.n.ve = "oppo";
            com.byazt.ev.n.tt = "oppo".toUpperCase();
        }
    }

    public static z p() {
        if (x == null) {
            synchronized (ve.class) {
                if (x == null) {
                    x = i.c();
                }
            }
        }
        return x;
    }

    public static eo pf() {
        return n;
    }

    public static c pu() {
        return i;
    }

    public static synchronized int qp() {
        return bm;
    }

    public static com.byazt.hs.a qy() {
        return or;
    }

    public static ExecutorService rh() {
        if (gt == null) {
            synchronized (ve.class) {
                if (gt == null) {
                    int i2 = hd;
                    com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.u.c("DownloadThreadPool-db-fixed", true));
                    try {
                        ujVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                    gt = ujVar;
                }
            }
        }
        return gt;
    }

    public static OkHttpClient.Builder rl() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (qy != null) {
            builder.dispatcher(new Dispatcher(qy));
        }
        return builder;
    }

    public static synchronized nu sl() {
        return p;
    }

    public static com.byazt.zl.tt sp() {
        return md;
    }

    public static my sv() {
        if (yv == null) {
            synchronized (ve.class) {
                if (yv == null) {
                    yv = new com.byazt.b.da();
                }
            }
        }
        return yv;
    }

    public static ExecutorService t() {
        if (z == null) {
            synchronized (ve.class) {
                if (z == null) {
                    int i2 = sv;
                    com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.byazt.u.c("DownloadThreadPool-cpu-fixed", true));
                    try {
                        ujVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                    z = ujVar;
                }
            }
        }
        return z;
    }

    public static synchronized void tt(DownloaderBuilder downloaderBuilder) {
        ve(downloaderBuilder);
    }

    public static ExecutorService u() {
        return m != null ? m : t();
    }

    public static IDownloadHttpService uj() {
        return da;
    }

    private static void ve(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                c(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                c(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                c(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                c(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                c(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                tt(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                c(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                c(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                c(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                ve(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                uj(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                n(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                a(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                sp(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                x(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                c(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                tt(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                c(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                p = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                bm = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                c(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                eo = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                pu = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                c(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                or = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                rl tTNetHandler = downloaderBuilder.getTTNetHandler();
                qp = tTNetHandler;
                if (tTNetHandler.c()) {
                    c(qp.tt());
                    c(qp.ve());
                } else {
                    c(x());
                    c(i());
                }
            }
            tt(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                c(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static IDownloadHttpService x() {
        if (t == null) {
            synchronized (ve.class) {
                if (t == null) {
                    t = new com.byazt.b.sp();
                }
            }
        }
        return t;
    }

    public static ExecutorService yp() {
        return rh != null ? rh : m();
    }

    public static z yv() {
        if (sp == null) {
            synchronized (ve.class) {
                if (sp == null) {
                    sp = new com.byazt.b.x();
                }
            }
        }
        return sp;
    }

    public static ExecutorService z() {
        return my != null ? my : m();
    }

    @NonNull
    public static JSONObject zb() {
        return (h == null || h.c() == null) ? com.byazt.ev.n.i : h.c();
    }

    public static da zm() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new com.byazt.b.uj();
                }
            }
        }
        return tt;
    }

    private static void a(ExecutorService executorService) {
        if (executorService != null) {
            rh = executorService;
        }
    }

    private static void sp(ExecutorService executorService) {
        if (executorService != null) {
            my = executorService;
        }
    }

    private static void uj(ExecutorService executorService) {
        if (executorService != null) {
            m = executorService;
        }
    }

    public static synchronized void tt() {
        if (eo) {
            return;
        }
        eo = true;
        try {
            Intent intent = new Intent(ic(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            ic().startService(intent);
            if (!com.byazt.w.a.ve()) {
                com.byazt.b.t.c(true).startService();
            }
        } catch (Throwable th) {
            eo = false;
            com.byazt.nr.m.c(th);
        }
    }

    private static void n(ExecutorService executorService) {
        if (executorService != null) {
            nu = executorService;
        }
    }

    private static void x(ExecutorService executorService) {
        if (executorService != null) {
            gt = executorService;
        }
    }

    public static void tt(com.byazt.c.sl slVar) {
        List<com.byazt.c.sl> list = l;
        synchronized (list) {
            if (slVar != null) {
                if (list.contains(slVar)) {
                    list.remove(slVar);
                }
            }
        }
    }

    public static void tt(DownloadTask downloadTask, int i2) {
        List<Object> list = lo;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    private static com.byazt.hs.sp tt(String str, List<com.byazt.t.ve> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        com.byazt.hs.x xVarA = i2 == 1 ? a() : i();
        if (xVarA != null) {
            IOException iOException2 = null;
            long jCurrentTimeMillis = 0;
            if (z2) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } catch (IOException e) {
                    e = e;
                    iOException2 = e;
                    throw iOException2;
                } catch (Throwable th) {
                    th = th;
                    iOException = iOException2;
                    if (z2) {
                        com.byazt.zl.c.c(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, iOException, downloadInfo);
                    }
                    throw th;
                }
            }
            try {
                try {
                    com.byazt.hs.sp spVarC = xVarA.c(str, list);
                    if (z2) {
                        com.byazt.zl.c.c(spVarC, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, null, downloadInfo);
                    }
                    return spVarC;
                } catch (IOException e2) {
                    e = e2;
                    iOException2 = e;
                    throw iOException2;
                }
            } catch (Throwable th2) {
                th = th2;
                iOException = iOException2;
                if (z2) {
                    com.byazt.zl.c.c(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i2, iOException, downloadInfo);
                }
                throw th;
            }
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
    }

    public static void tt(ExecutorService executorService) {
        if (executorService != null) {
            qy = executorService;
        }
    }

    public static void tt(Runnable runnable) {
        tt(runnable, false);
    }

    public static void tt(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.byazt.w.a.uj()) {
            runnable.run();
        } else {
            u().execute(runnable);
        }
    }

    public static synchronized void c() {
        try {
            if (pf && zm != null && c != null) {
                c.unregisterReceiver(zm);
                pf = false;
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    private static void tt(int i2) {
        if (i2 > 0) {
            bx = i2;
        }
    }

    private static void tt(boolean z2) {
        lt = z2;
    }

    public static void c(nb nbVar) {
        if (nbVar == null) {
            return;
        }
        synchronized (d) {
            d.add(nbVar);
        }
    }

    public static void c(com.byazt.c.sl slVar) {
        List<com.byazt.c.sl> list = l;
        synchronized (list) {
            if (slVar != null) {
                if (!list.contains(slVar)) {
                    list.add(slVar);
                }
            }
        }
    }

    public static void c(com.byazt.ev.uj ujVar) {
        List<com.byazt.c.sl> list = l;
        synchronized (list) {
            for (com.byazt.c.sl slVar : list) {
                if (slVar != null && ujVar != com.byazt.ev.uj.SYNC_START && ujVar == com.byazt.ev.uj.SYNC_SUCCESS) {
                    slVar.c();
                }
            }
            if (ujVar == com.byazt.ev.uj.SYNC_SUCCESS) {
                l.clear();
            }
        }
    }

    public static void c(DownloadTask downloadTask, int i2) {
        List<Object> list = lo;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static synchronized boolean ve() {
        return eo;
    }

    private static void ve(ExecutorService executorService) {
        if (executorService != null) {
            z = executorService;
        }
    }

    public static void ve(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.byazt.w.a.uj()) {
            runnable.run();
        } else {
            rh().execute(runnable);
        }
    }

    public static com.byazt.hs.i c(boolean z2, int i2, String str, List<com.byazt.t.ve> list) throws Exception {
        return c(z2, i2, str, null, list, 0, false, null);
    }

    public static com.byazt.hs.i c(boolean z2, int i2, String str, String str2, List<com.byazt.t.ve> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.byazt.t.ve> list2;
        int i4;
        if (!TextUtils.isEmpty(str2)) {
            List<com.byazt.t.ve> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.byazt.t.ve("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrC = c(i4);
        Exception exc = null;
        for (int i5 : iArrC) {
            try {
                com.byazt.hs.i iVarC = c(i2, str, str2, list2, i5, z3, downloadInfo);
                if (iVarC != null) {
                    return iVarC;
                }
            } catch (Exception e) {
                if (downloadInfo.isExpiredRedownload() && com.byazt.w.a.sp(e) && com.byazt.w.a.ve(list2)) {
                    com.byazt.x.c.c("dcach::http exception 304, throw excepiton, not retry " + e);
                    throw e;
                }
                exc = e;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    private static com.byazt.hs.i c(int i2, String str, String str2, List<com.byazt.t.ve> list, int i3, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        IOException iOException;
        IDownloadHttpService iDownloadHttpServiceUj = i3 == 1 ? uj() : x();
        if (iDownloadHttpServiceUj != null) {
            IOException iOException2 = null;
            long jCurrentTimeMillis = 0;
            if (z2) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } catch (IOException e) {
                    e = e;
                    iOException2 = e;
                    throw iOException2;
                } catch (Throwable th) {
                    th = th;
                    iOException = iOException2;
                    if (z2) {
                        com.byazt.zl.c.c(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, p3.f, i3, iOException, downloadInfo);
                    }
                    throw th;
                }
            }
            try {
                try {
                    com.byazt.hs.i iVarDownloadWithConnection = iDownloadHttpServiceUj.downloadWithConnection(i2, str, list);
                    if (z2) {
                        com.byazt.zl.c.c(iVarDownloadWithConnection, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, p3.f, i3, null, downloadInfo);
                    }
                    return iVarDownloadWithConnection;
                } catch (IOException e2) {
                    e = e2;
                    iOException2 = e;
                    throw iOException2;
                }
            } catch (Throwable th2) {
                th = th2;
                iOException = iOException2;
                if (z2) {
                    com.byazt.zl.c.c(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, p3.f, i3, iOException, downloadInfo);
                }
                throw th;
            }
        }
        throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
    }

    public static com.byazt.hs.sp c(String str, List<com.byazt.t.ve> list) throws Exception {
        return c(str, list, 0, false, null);
    }

    public static com.byazt.hs.sp c(String str, List<com.byazt.t.ve> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        Exception e = null;
        for (int i3 : c(i2)) {
            try {
                com.byazt.hs.sp spVarTt = tt(str, list, i3, z2, downloadInfo);
                if (spVarTt != null) {
                    return spVarTt;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    private static int[] c(int i2) {
        if (i2 == 1) {
            return new int[]{0};
        }
        if (i2 != 2) {
            return i2 != 3 ? new int[]{1, 0} : new int[]{0, 1};
        }
        return new int[]{1};
    }

    public static synchronized void c(t tVar) {
        if (tVar != null) {
            yp = tVar;
            if (tt instanceof com.byazt.b.uj) {
                ((com.byazt.b.uj) tt).x();
            }
        }
    }

    public static void c(ExecutorService executorService) {
        if (executorService != null) {
            rl = executorService;
        }
    }

    private static void c(List<com.byazt.c.u> list) {
        List<com.byazt.c.u> list2 = nb;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void c(boolean z2) {
        to = z2;
    }

    public static void c(Runnable runnable) {
        c(runnable, false);
    }

    public static void c(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.byazt.w.a.uj()) {
            runnable.run();
        } else {
            t().execute(runnable);
        }
    }

    public static Future c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return gt().schedule(runnable, j, timeUnit);
    }

    public static void c(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            da = iDownloadHttpService;
        }
        lr = da != null;
    }

    public static void c(com.byazt.hs.x xVar) {
        if (xVar != null) {
            sl = xVar;
        }
    }

    private static void c(da daVar) {
        if (daVar != null) {
            tt = daVar;
        }
    }

    private static void c(sl slVar) {
        if (slVar != null) {
            ve = slVar;
        }
    }

    private static void c(com.byazt.zl.tt ttVar) {
        if (ttVar != null) {
            md = ttVar;
        }
    }

    public static void c(p pVar) {
        h = pVar;
        com.byazt.k.c.c();
    }

    private static void c(x xVar) {
        if (xVar != null) {
            uj = xVar;
        }
    }

    public static void c(eo eoVar) {
        if (eoVar != null) {
            n = eoVar;
        }
    }

    private static void c(sp spVar) {
        if (spVar != null) {
            gr = spVar;
        }
    }

    public static synchronized void c(Context context) {
        if (context != null) {
            if (c == null) {
                c = context.getApplicationContext();
                com.byazt.g.c.c().c(c);
            }
        }
    }

    public static int c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return c(taskKey, downloadInfo.getSavePath());
    }

    public static int c(String str, String str2) {
        sl slVarH = h();
        if (slVarH == null) {
            return 0;
        }
        return slVarH.c(str, str2);
    }

    public static void c(com.byazt.zl.ve veVar) {
        kp = veVar;
    }

    public static void c(c cVar) {
        com.byazt.x.c.c("wjd", "setIndependentServiceCreator::creator=" + cVar);
        i = cVar;
    }
}

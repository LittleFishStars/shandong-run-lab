package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Build;
import android.os.SystemClock;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorConfigJava;
import com.efs.sdk.memleaksdk.monitor.UMonitorHeapResult;
import com.efs.sdk.memleaksdk.monitor.UMonitorReporter;
import com.efs.sdk.memleaksdk.monitor.UMonitorService;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class y extends c<UMonitorConfigJava> {
    public static final y b = new y();
    private long e;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private final List<ae> c = Arrays.asList(new ac(), new ag(), new ab(), new af(), new ad());
    private final List<String> d = new ArrayList();
    private final List<Runnable> f = new ArrayList();

    private y() {
    }

    private boolean f() {
        if (a().isDebugMode()) {
            return false;
        }
        int iA = h.a();
        g.b(UMonitor.TAG, "sp getAnalysisTimes: " + iA);
        boolean z = iA > a().getAnalysisMaxTimesPerVersion();
        if (z) {
            g.d(UMonitor.TAG, "current version is out of max analysis times");
        }
        return z;
    }

    private boolean g() {
        if (a().isDebugMode()) {
            return false;
        }
        long jC = h.c();
        g.b(UMonitor.TAG, "sp getFirstAnalysisTime: " + jC);
        boolean z = System.currentTimeMillis() - jC > ((long) a().getAnalysisPeriodPerVersion());
        if (z) {
            g.d(UMonitor.TAG, "current version is out of max analysis period!");
        }
        return z;
    }

    private c.a h() {
        ah.a();
        this.d.clear();
        for (ae aeVar : this.c) {
            if (aeVar.b()) {
                this.d.add(aeVar.d());
            }
        }
        if (this.d.isEmpty() || !a().getEnableHprofDumpAnalysis()) {
            return c.a.Continue;
        }
        if (g() || f()) {
            g.d(UMonitor.TAG, "trigger, but exec analysis times or period!");
        } else {
            d.a(new Runnable() { // from class: com.efs.sdk.memleaksdk.monitor.internal.y.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g.b(UMonitor.TAG, "reason: " + y.this.d);
                        y.this.k();
                    } catch (Throwable th) {
                        g.b(UMonitor.TAG, "startAnalysisService", th);
                    }
                }
            }, 0L);
        }
        return c.a.Terminate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.j) {
            return;
        }
        this.j = true;
        File[] fileArrListFiles = e.c().listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.exists() && !file.isDirectory()) {
                if (!file.getName().startsWith(UMUtils.getAppVersionName(UMonitor.getContext()))) {
                    file.delete();
                } else if (!file.getName().endsWith(".hprof")) {
                    file.delete();
                } else if (!new File(e.b(), file.getName()).exists()) {
                    file.delete();
                }
            }
        }
        j();
    }

    private void j() {
        File[] fileArrListFiles = e.b().listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.exists() && !file.isDirectory()) {
                if (!file.getName().startsWith(UMUtils.getAppVersionName(UMonitor.getContext()))) {
                    g.b(UMonitor.TAG, "delete other version file: " + file.getName());
                    file.delete();
                } else if (!file.getName().endsWith(".hprof")) {
                    File file2 = new File(file.getPath().replace(".hprof", ".json"));
                    if (file2.exists()) {
                        g.b(UMonitor.TAG, "json file is exist, skip analysis");
                        file2.delete();
                        file.delete();
                    } else {
                        try {
                            file2.createNewFile();
                        } catch (Exception unused) {
                        }
                        a(file, file2, "re-analysis");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            g.b(UMonitor.TAG, "dump and analysis");
            if (!e.f()) {
                g.d(UMonitor.TAG, "available space not enough");
                return;
            }
            if (this.i) {
                return;
            }
            this.i = true;
            Date date = new Date();
            File fileB = e.b(date);
            File fileA = e.a(date);
            if (fileA.exists()) {
                fileA.delete();
            }
            fileA.createNewFile();
            fileA.setWritable(true);
            fileA.setReadable(true);
            File fileC = e.c(date);
            if (fileC.exists()) {
                fileC.delete();
            }
            fileC.createNewFile();
            fileC.setWritable(true);
            fileC.setReadable(true);
            k.a.f29878a.a(fileA.getPath(), fileC.getPath());
            g.b(UMonitor.TAG, "end hprof dump");
            Thread.sleep(2000L);
            g.b(UMonitor.TAG, "start hprof analysis");
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
            a(fileA, fileB, sb.toString());
        } catch (Throwable th) {
            g.a(UMonitor.TAG, "dump and analysis failed", th);
        }
    }

    public final void e() {
        if (!f.a().c()) {
            this.h = this.g;
            g.b(UMonitor.TAG, "background");
            c();
            return;
        }
        g.b(UMonitor.TAG, "foreground");
        if (!this.i && this.h) {
            a(0L);
        }
        Iterator<Runnable> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f.clear();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.c
    public long b() {
        return a().getLoopInterval();
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.c
    public void c() {
        if (this.f29775a && UMUtils.isMainProgress(UMonitor.getContext())) {
            super.c();
            g.b(UMonitor.TAG, "stopLoop()");
            this.g = false;
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c.a call() {
        if (!UMonitor.isNotSupport()) {
            return this.i ? c.a.Terminate : h();
        }
        g.c(UMonitor.TAG, "not supported! android sdk version: " + Build.VERSION.SDK_INT);
        return c.a.Terminate;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.b
    public void a(UMonitorConfigJava uMonitorConfigJava) {
        super.a(uMonitorConfigJava);
        this.e = SystemClock.elapsedRealtime();
        h.a(UMonitor.getContext());
        e.a(new File(UMonitor.getContext().getFilesDir(), "u_monitor").getPath());
        Iterator<ae> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(uMonitorConfigJava);
        }
        g.b(UMonitor.TAG, "init");
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.c
    public void a(long j) {
        if (this.f29775a && UMUtils.isMainProgress(UMonitor.getContext())) {
            g.b(UMonitor.TAG, "startLoop");
            if (this.g) {
                return;
            }
            this.g = true;
            super.a(j);
            d.a(new Runnable() { // from class: com.efs.sdk.memleaksdk.monitor.internal.y.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        y.this.i();
                    } catch (Throwable th) {
                        g.b(UMonitor.TAG, "startLoop task", th);
                    }
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final File file, final File file2, final String str) {
        if (file.length() == 0) {
            file.delete();
            g.b(UMonitor.TAG, "hprof file size 0");
        } else {
            if (!f.a().c()) {
                g.d(UMonitor.TAG, "try start service, but not foreground");
                this.f.add(new Runnable() { // from class: com.efs.sdk.memleaksdk.monitor.internal.y.3
                    @Override // java.lang.Runnable
                    public void run() {
                        y.this.a(file, file2, str);
                    }
                });
                return;
            }
            h.b();
            z zVar = new z();
            zVar.f29892a = str;
            zVar.c = f.a().b();
            zVar.b = String.valueOf((SystemClock.elapsedRealtime() - this.e) / 1000);
            UMonitorService.startAnalysisService(UMonitor.getContext(), file.getPath(), file2.getPath(), zVar, new UMonitorHeapResult.a() { // from class: com.efs.sdk.memleaksdk.monitor.internal.y.4
                @Override // com.efs.sdk.memleaksdk.monitor.UMonitorHeapResult.a
                public void a() {
                    g.b(UMonitor.TAG, "heap analysis found leak, do upload");
                    UMonitorReporter reporter = ((UMonitorConfigJava) y.this.a()).getReporter();
                    if (reporter == null) {
                        return;
                    }
                    try {
                        reporter.onJavaHeap(new File(e.c(), file.getName()), new JSONObject(e.b(file2)));
                        file.delete();
                        file2.delete();
                    } catch (Throwable th) {
                        g.b(UMonitor.TAG, "startService result failed", th);
                    }
                }

                @Override // com.efs.sdk.memleaksdk.monitor.UMonitorHeapResult.a
                public void b() {
                    g.d(UMonitor.TAG, "heap analysis end, file delete");
                    file.delete();
                    file2.delete();
                }
            });
        }
    }
}

package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DownloadService extends Service {
    public static final int N = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30792a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashMap<Class<? extends DownloadService>, b> f3549a = new HashMap<>();
    public static final String g = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String h = "com.google.android.exoplayer.downloadService.action.RESTART";
    public static final String i = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String j = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    public static final String k = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String l = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String m = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String n = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final String o = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String p = "download_request";
    public static final String q = "content_id";
    public static final String r = "stop_reason";
    public static final String s = "requirements";
    public static final String t = "foreground";
    public static final String u = "DownloadService";

    @StringRes
    public final int K;

    @StringRes
    public final int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f3550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final c f3551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3552a;
    public boolean b;
    public boolean c;
    public boolean d;

    @Nullable
    public final String f;

    public static final class b implements DownloadManager.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f30793a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DownloadManager f3553a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public DownloadService f3554a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Requirements f3555a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Scheduler f3556a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Class<? extends DownloadService> f3557a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3558a;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(DownloadService downloadService) {
            downloadService.o(this.f3553a.g());
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void a(DownloadManager downloadManager, boolean z) {
            if (z || downloadManager.i() || !p()) {
                return;
            }
            List<Download> listG = downloadManager.g();
            for (int i = 0; i < listG.size(); i++) {
                if (listG.get(i).f30784a == 0) {
                    n();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void c(DownloadManager downloadManager, Download download) {
            DownloadService downloadService = this.f3554a;
            if (downloadService != null) {
                downloadService.n();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void d(DownloadManager downloadManager, Requirements requirements, int i) {
            q();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public final void e(DownloadManager downloadManager) {
            DownloadService downloadService = this.f3554a;
            if (downloadService != null) {
                downloadService.p();
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void f(DownloadManager downloadManager) {
            DownloadService downloadService = this.f3554a;
            if (downloadService != null) {
                downloadService.o(downloadManager.g());
            }
        }

        @Override // com.google.android.exoplayer2.offline.DownloadManager.Listener
        public void g(DownloadManager downloadManager, Download download, @Nullable Exception exc) {
            DownloadService downloadService = this.f3554a;
            if (downloadService != null) {
                downloadService.m(download);
            }
            if (p() && DownloadService.l(download.f30784a)) {
                Log.n(DownloadService.u, "DownloadService wasn't running. Restarting.");
                n();
            }
        }

        public void j(final DownloadService downloadService) {
            sb0.i(this.f3554a == null);
            this.f3554a = downloadService;
            if (this.f3553a.p()) {
                gj9.A().postAtFrontOfQueue(new Runnable() { // from class: com.zj.adlib.sq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44752a.m(downloadService);
                    }
                });
            }
        }

        @RequiresNonNull({"scheduler"})
        public final void k() {
            Requirements requirements = new Requirements(0);
            if (o(requirements)) {
                this.f3556a.cancel();
                this.f3555a = requirements;
            }
        }

        public void l(DownloadService downloadService) {
            sb0.i(this.f3554a == downloadService);
            this.f3554a = null;
        }

        public final void n() {
            if (this.f3558a) {
                try {
                    gj9.x1(this.f30793a, DownloadService.i(this.f30793a, this.f3557a, DownloadService.h));
                    return;
                } catch (IllegalStateException unused) {
                    Log.n(DownloadService.u, "Failed to restart (foreground launch restriction)");
                    return;
                }
            }
            try {
                this.f30793a.startService(DownloadService.i(this.f30793a, this.f3557a, "com.google.android.exoplayer.downloadService.action.INIT"));
            } catch (IllegalStateException unused2) {
                Log.n(DownloadService.u, "Failed to restart (process is idle)");
            }
        }

        public final boolean o(Requirements requirements) {
            return !gj9.c(this.f3555a, requirements);
        }

        public final boolean p() {
            DownloadService downloadService = this.f3554a;
            return downloadService == null || downloadService.k();
        }

        public boolean q() {
            boolean zQ = this.f3553a.q();
            if (this.f3556a == null) {
                return !zQ;
            }
            if (!zQ) {
                k();
                return true;
            }
            Requirements requirementsM = this.f3553a.m();
            if (!this.f3556a.a(requirementsM).equals(requirementsM)) {
                k();
                return false;
            }
            if (!o(requirementsM)) {
                return true;
            }
            if (this.f3556a.b(requirementsM, this.f30793a.getPackageName(), DownloadService.h)) {
                this.f3555a = requirementsM;
                return true;
            }
            Log.n(DownloadService.u, "Failed to schedule restart");
            k();
            return false;
        }

        public b(Context context, DownloadManager downloadManager, boolean z, @Nullable Scheduler scheduler, Class<? extends DownloadService> cls) {
            this.f30793a = context;
            this.f3553a = downloadManager;
            this.f3558a = z;
            this.f3556a = scheduler;
            this.f3557a = cls;
            downloadManager.e(this);
            q();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30794a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3559a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Handler f3560a = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3562a;
        public boolean b;

        public c(int i, long j) {
            this.f30794a = i;
            this.f3559a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update() {
            DownloadManager downloadManager = ((b) sb0.g(DownloadService.this.f3550a)).f3553a;
            Notification foregroundNotification = DownloadService.this.getForegroundNotification(downloadManager.g(), downloadManager.l());
            if (this.b) {
                ((NotificationManager) DownloadService.this.getSystemService("notification")).notify(this.f30794a, foregroundNotification);
            } else {
                DownloadService.this.startForeground(this.f30794a, foregroundNotification);
                this.b = true;
            }
            if (this.f3562a) {
                this.f3560a.removeCallbacksAndMessages(null);
                this.f3560a.postDelayed(new Runnable() { // from class: com.zj.adlib.tq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44981a.update();
                    }
                }, this.f3559a);
            }
        }

        public void b() {
            if (this.b) {
                update();
            }
        }

        public void c() {
            if (this.b) {
                return;
            }
            update();
        }

        public void d() {
            this.f3562a = true;
            update();
        }

        public void e() {
            this.f3562a = false;
            this.f3560a.removeCallbacksAndMessages(null);
        }
    }

    public DownloadService(int i2) {
        this(i2, 1000L);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS", z);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS", z);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z).putExtra("content_id", str);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS", z);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS", z).putExtra("requirements", requirements);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON", z).putExtra("content_id", str).putExtra("stop_reason", i2);
    }

    public static Intent i(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public static Intent j(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return i(context, cls, str).putExtra("foreground", z);
    }

    public static boolean l(int i2) {
        return i2 == 2 || i2 == 5 || i2 == 7;
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        startService(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        startService(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        startService(context, buildSetStopReasonIntent(context, cls, str, i2, z), z);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(i(context, cls, "com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        gj9.x1(context, j(context, cls, "com.google.android.exoplayer.downloadService.action.INIT", true));
    }

    private static void startService(Context context, Intent intent, boolean z) {
        if (z) {
            gj9.x1(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public abstract DownloadManager getDownloadManager();

    public abstract Notification getForegroundNotification(List<Download> list, int i2);

    @Nullable
    public abstract Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        c cVar = this.f3551a;
        if (cVar == null || this.d) {
            return;
        }
        cVar.b();
    }

    public final boolean k() {
        return this.c;
    }

    public final void m(Download download) {
        if (this.f3551a != null) {
            if (l(download.f30784a)) {
                this.f3551a.d();
            } else {
                this.f3551a.b();
            }
        }
    }

    public final void n() {
        c cVar = this.f3551a;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void o(List<Download> list) {
        if (this.f3551a != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (l(list.get(i2).f30784a)) {
                    this.f3551a.d();
                    return;
                }
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f;
        if (str != null) {
            NotificationUtil.a(this, str, this.K, this.L, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, b> map = f3549a;
        b bVar = map.get(cls);
        if (bVar == null) {
            boolean z = this.f3551a != null;
            Scheduler scheduler = (z && (gj9.f41922a < 31)) ? getScheduler() : null;
            DownloadManager downloadManager = getDownloadManager();
            downloadManager.C();
            bVar = new b(getApplicationContext(), downloadManager, z, scheduler, cls);
            map.put((Class<? extends DownloadService>) cls, bVar);
        }
        this.f3550a = bVar;
        bVar.j(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.d = true;
        ((b) sb0.g(this.f3550a)).l(this);
        c cVar = this.f3551a;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        String action;
        String stringExtra;
        c cVar;
        this.M = i3;
        this.b = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            this.f3552a |= intent.getBooleanExtra("foreground", false) || h.equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        DownloadManager downloadManager = ((b) sb0.g(this.f3550a)).f3553a;
        switch (action) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) sb0.g(intent)).getParcelableExtra("download_request");
                if (downloadRequest != null) {
                    downloadManager.d(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    Log.d(u, "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.C();
                break;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.z();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                Requirements requirements = (Requirements) ((Intent) sb0.g(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    downloadManager.G(requirements);
                    break;
                } else {
                    Log.d(u, "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.x();
                break;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) sb0.g(intent)).hasExtra("stop_reason")) {
                    Log.d(u, "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.H(stringExtra, intent.getIntExtra("stop_reason", 0));
                    break;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    downloadManager.A(stringExtra);
                    break;
                } else {
                    Log.d(u, "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
                break;
            default:
                Log.d(u, "Ignored unrecognized action: " + action);
                break;
        }
        if (gj9.f41922a >= 26 && this.f3552a && (cVar = this.f3551a) != null) {
            cVar.c();
        }
        this.c = false;
        if (downloadManager.o()) {
            p();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.b = true;
    }

    public final void p() {
        c cVar = this.f3551a;
        if (cVar != null) {
            cVar.e();
        }
        if (((b) sb0.g(this.f3550a)).q()) {
            if (gj9.f41922a >= 28 || !this.b) {
                this.c |= stopSelfResult(this.M);
            } else {
                stopSelf();
                this.c = true;
            }
        }
    }

    public DownloadService(int i2, long j2) {
        this(i2, j2, null, 0, 0);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        return j(context, cls, "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD", z).putExtra("download_request", downloadRequest).putExtra("stop_reason", i2);
    }

    @Deprecated
    public DownloadService(int i2, long j2, @Nullable String str, @StringRes int i3) {
        this(i2, j2, str, i3, 0);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, i2, z), z);
    }

    public DownloadService(int i2, long j2, @Nullable String str, @StringRes int i3, @StringRes int i4) {
        if (i2 == 0) {
            this.f3551a = null;
            this.f = null;
            this.K = 0;
            this.L = 0;
            return;
        }
        this.f3551a = new c(i2, j2);
        this.f = str;
        this.K = i3;
        this.L = i4;
    }
}

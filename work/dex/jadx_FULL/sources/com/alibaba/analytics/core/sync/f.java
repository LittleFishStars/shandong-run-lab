package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.a.x;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f implements com.alibaba.appmonitor.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static f f23793a = new f();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.analytics.core.f.a f664a;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private ScheduledFuture f668f;
    private long i;
    private long g = 30000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private UploadMode f666a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private h f667a = new h();
    private long h = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private UploadLog.NetworkStatus f665a = UploadLog.NetworkStatus.ALL;
    private long f = 0;
    private long j = 0;

    /* JADX INFO: renamed from: com.alibaba.analytics.core.sync.f$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23794a;

        static {
            int[] iArr = new int[UploadMode.values().length];
            f23794a = iArr;
            try {
                iArr[UploadMode.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23794a[UploadMode.BATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23794a[UploadMode.LAUNCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23794a[UploadMode.DEVELOPMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private f() {
        com.alibaba.appmonitor.a.b.a(this);
    }

    private void L() {
        String strA = com.alibaba.analytics.a.a.a(com.alibaba.analytics.core.d.a().getContext(), "UTANALYTICS_UPLOAD_ALLOWED_NETWORK_STATUS");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if ("ALL".equalsIgnoreCase(strA)) {
            this.f665a = UploadLog.NetworkStatus.ALL;
            return;
        }
        if (NetworkUtil.NETWORK_TYPE_2G.equalsIgnoreCase(strA)) {
            this.f665a = UploadLog.NetworkStatus.TWO_GENERATION;
            return;
        }
        if (NetworkUtil.NETWORK_TYPE_3G.equalsIgnoreCase(strA)) {
            this.f665a = UploadLog.NetworkStatus.THRID_GENERATION;
        } else if (NetworkUtil.NETWORK_TYPE_4G.equalsIgnoreCase(strA)) {
            this.f665a = UploadLog.NetworkStatus.FOUR_GENERATION;
        } else if (NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(strA)) {
            this.f665a = UploadLog.NetworkStatus.WIFI;
        }
    }

    private void M() {
        if (this.f664a != null) {
            com.alibaba.analytics.core.f.d.a().b(this.f664a);
        }
        this.f664a = new com.alibaba.analytics.core.f.a() { // from class: com.alibaba.analytics.core.sync.f.1
            @Override // com.alibaba.analytics.core.f.a
            public void a(long j, long j2) {
                com.alibaba.analytics.a.j.d("RealTimeMode", "count", Long.valueOf(j), "dbSize", Long.valueOf(j2));
                if (j <= 0 || j2 <= 0 || UploadMode.REALTIME != f.this.f666a) {
                    return;
                }
                f.this.f668f = x.a().schedule(null, f.this.f667a, 0L);
            }

            @Override // com.alibaba.analytics.core.f.a
            public void b(long j, long j2) {
            }
        };
        com.alibaba.analytics.core.f.d.a().a(this.f664a);
    }

    private void N() {
        if (this.f664a != null) {
            com.alibaba.analytics.core.f.d.a().b(this.f664a);
        }
        e.a().a((d) null);
        e.a().a(this.f665a);
        this.f664a = new com.alibaba.analytics.core.f.a() { // from class: com.alibaba.analytics.core.sync.f.2
            @Override // com.alibaba.analytics.core.f.a
            public void a(long j, long j2) {
                com.alibaba.analytics.a.j.d("BatchMode", "count", Long.valueOf(j), "dbSize", Long.valueOf(j2));
                if (j2 < f.this.h || UploadMode.BATCH != f.this.f666a) {
                    return;
                }
                e.a().a(f.this.f665a);
                f.this.f668f = x.a().schedule(f.this.f668f, f.this.f667a, 0L);
            }

            @Override // com.alibaba.analytics.core.f.a
            public void b(long j, long j2) {
            }
        };
        com.alibaba.analytics.core.f.d.a().a(this.f664a);
    }

    private void O() {
        long jCount = com.alibaba.analytics.core.f.d.a().count();
        this.j = jCount;
        if (jCount > 0) {
            this.f = 0L;
            e.a().a(new d() { // from class: com.alibaba.analytics.core.sync.f.3
                @Override // com.alibaba.analytics.core.sync.d
                public void b(long j) {
                    f.this.f = j;
                    if (UploadMode.LAUNCH != f.this.f666a || f.this.f < f.this.j) {
                        return;
                    }
                    f.this.f668f.cancel(false);
                }
            });
            e.a().a(this.f665a);
            this.f668f = x.a().a(this.f668f, this.f667a, 5000L);
        }
    }

    private void P() {
        e.a().a((d) null);
        this.f668f = x.a().schedule(this.f668f, this.f667a, 0L);
    }

    private void Q() {
        long jG = g();
        this.g = jG;
        com.alibaba.analytics.a.j.d("UploadMgr", "startIntervalMode CurrentUploadInterval", Long.valueOf(jG));
        e.a().a(new d() { // from class: com.alibaba.analytics.core.sync.f.4
            @Override // com.alibaba.analytics.core.sync.d
            public void b(long j) {
                f fVar = f.this;
                fVar.g = fVar.g();
                com.alibaba.analytics.a.j.d("UploadMgr", "CurrentUploadInterval", Long.valueOf(f.this.g));
                e.a().a(f.this.f665a);
                f.this.f668f = x.a().schedule(f.this.f668f, f.this.f667a, f.this.g);
            }
        });
        this.f668f = x.a().schedule(this.f668f, this.f667a, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g() {
        if (!com.alibaba.analytics.a.a.b(com.alibaba.analytics.core.d.a().getContext())) {
            long j = com.alibaba.analytics.core.a.d.a().getInt(AliyunLogKey.KEY_BUCKET) * 1000;
            if (j == 0) {
                return 300000L;
            }
            return j;
        }
        long j2 = com.alibaba.analytics.core.a.d.a().getInt("fu") * 1000;
        if (j2 != 0) {
            return j2;
        }
        long j3 = this.i;
        if (j3 < 30000) {
            return 30000L;
        }
        return j3;
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void B() {
        com.alibaba.analytics.a.j.d();
        if (UploadMode.INTERVAL == this.f666a) {
            if (this.g != g()) {
                start();
            }
        }
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void C() {
        com.alibaba.analytics.a.j.d();
        if (UploadMode.INTERVAL == this.f666a) {
            if (this.g != g()) {
                start();
            }
        }
    }

    @Deprecated
    public void R() {
        x.a().submit(this.f667a);
    }

    public long h() {
        return this.g;
    }

    public synchronized void start() {
        com.alibaba.analytics.a.j.d();
        L();
        g.a().start();
        if (this.f666a == null) {
            this.f666a = UploadMode.INTERVAL;
        }
        ScheduledFuture scheduledFuture = this.f668f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        b(this.f666a);
    }

    private synchronized void b(UploadMode uploadMode) {
        com.alibaba.analytics.a.j.d("startMode", "mode", uploadMode);
        int i = AnonymousClass5.f23794a[uploadMode.ordinal()];
        if (i == 1) {
            M();
        } else if (i == 2) {
            N();
        } else if (i == 3) {
            O();
        } else if (i != 4) {
            Q();
        } else {
            P();
        }
    }

    public static f a() {
        return f23793a;
    }

    public void a(UploadMode uploadMode) {
        if (uploadMode == null || this.f666a == uploadMode) {
            return;
        }
        this.f666a = uploadMode;
        start();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public UploadMode m138a() {
        return this.f666a;
    }
}

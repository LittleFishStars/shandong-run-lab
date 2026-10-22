package com.kwad.sdk;

import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class f {
    private static boolean aFQ = true;
    private static volatile List<m> aFR = new CopyOnWriteArrayList();

    public static class a extends bi {
        protected KsInitCallback aFU;

        public a() {
            super(false);
        }

        public final void a(KsInitCallback ksInitCallback) {
            this.aFU = ksInitCallback;
        }

        @Override // com.kwad.sdk.utils.bi
        public void doTask() {
        }
    }

    public static void a(SdkConfig sdkConfig) {
        if (aFQ) {
            a(sdkConfig, true, new a() { // from class: com.kwad.sdk.f.1
                @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
                public final void doTask() {
                    this.aFU.onSuccess();
                }
            });
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.5
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public static void b(SdkConfig sdkConfig) {
        if (aFQ) {
            a(sdkConfig, false, new a() { // from class: com.kwad.sdk.f.6
                @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
                public final void doTask() {
                    this.aFU.onSuccess();
                }
            });
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.7
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public static void c(SdkConfig sdkConfig) {
        if (!aFQ) {
            a(sdkConfig, false, new a() { // from class: com.kwad.sdk.f.12
                @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
                public final void doTask() {
                    this.aFU.onSuccess();
                }
            });
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.2
            private static void b(m mVar) {
                mVar.M();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(m mVar) {
                b(mVar);
            }
        });
    }

    private static void e(com.kwad.sdk.g.a<m> aVar) {
        try {
            ArrayList arrayList = new ArrayList();
            for (m mVar : aFR) {
                try {
                    if (mVar != null) {
                        aVar.accept(mVar);
                        if (mVar.isDone()) {
                            arrayList.add(mVar);
                        }
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.crash.b.u(th);
                }
            }
            aFR.removeAll(arrayList);
            arrayList.clear();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            com.kwad.sdk.crash.b.u(th2);
        }
    }

    private static boolean isMainThread() {
        return Objects.equals(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public static void a(SdkConfig sdkConfig, final long j) {
        a(sdkConfig, true, new a() { // from class: com.kwad.sdk.f.8
            @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
            public final void doTask() {
                if (j > 0) {
                    p.as(SystemClock.elapsedRealtime() - j);
                }
                if (f.aFQ) {
                    return;
                }
                this.aFU.onSuccess();
            }
        });
        try {
            if (sdkConfig.ksInitCallback != null) {
                com.kwad.sdk.monitor.a.d(sdkConfig);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.9
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public static void b(SdkConfig sdkConfig, final e eVar) {
        if (!aFQ) {
            a(sdkConfig, false, new a() { // from class: com.kwad.sdk.f.3
                @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
                public final void doTask() {
                    KsInitCallback ksInitCallback = this.aFU;
                    e eVar2 = eVar;
                    ksInitCallback.onFail(eVar2.code, eVar2.msg);
                }
            });
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.4
            private static void b(m mVar) {
                mVar.N();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(m mVar) {
                b(mVar);
            }
        });
    }

    public static void a(SdkConfig sdkConfig, final e eVar) {
        if (!aFQ) {
            a(sdkConfig, true, new a() { // from class: com.kwad.sdk.f.10
                @Override // com.kwad.sdk.f.a, com.kwad.sdk.utils.bi
                public final void doTask() {
                    KsInitCallback ksInitCallback = this.aFU;
                    e eVar2 = eVar;
                    ksInitCallback.onFail(eVar2.code, eVar2.msg);
                }
            });
        }
        e(new com.kwad.sdk.g.a<m>() { // from class: com.kwad.sdk.f.11
            @Override // com.kwad.sdk.g.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public static void a(m mVar) {
        aFR.add(mVar);
    }

    private static void a(SdkConfig sdkConfig, boolean z, a aVar) {
        KsInitCallback ksInitCallback;
        if (sdkConfig != null) {
            try {
                if (z) {
                    ksInitCallback = sdkConfig.ksInitCallback;
                } else {
                    ksInitCallback = sdkConfig.ksStartCallback;
                }
                if (ksInitCallback != null) {
                    aVar.a(ksInitCallback);
                    if (isMainThread()) {
                        aVar.run();
                    } else {
                        by.postOnUiThread(aVar);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}

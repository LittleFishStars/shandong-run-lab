package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
final class s {

    public static abstract class a<T> implements c<T> {
        c<T> aID;

        public a(c<T> cVar) {
            this.aID = cVar;
        }
    }

    public static class b implements f<com.kwad.sdk.api.loader.a.C1266a> {
        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C1266a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new com.kwad.sdk.api.loader.h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    @WorkerThread
                    public final void a(com.kwad.sdk.api.loader.a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.isLegal()) {
                            cVar.m(bVar.aHF);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.bn(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public interface c<T> {
        void m(T t);
    }

    public static class d implements f<com.kwad.sdk.api.loader.a.C1266a> {
        f<com.kwad.sdk.api.loader.a.C1266a> aIH;

        public d(f<com.kwad.sdk.api.loader.a.C1266a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C1266a> cVar) {
            this.aIH.a(abVar, new a<com.kwad.sdk.api.loader.a.C1266a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                @WorkerThread
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(@NonNull com.kwad.sdk.api.loader.a.C1266a c1266a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileV = null;
                    try {
                        l.a(c1266a);
                        fileV = j.v(abVar.getContext(), c1266a.sdkVersion);
                        k.c(c1266a.aHD, fileV);
                        l.a(c1266a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c1266a.aHE = fileV;
                        cVar.m(c1266a);
                    } catch (Throwable th) {
                        l.a(c1266a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileV);
                    }
                }
            });
        }
    }

    public static class e implements f<Boolean> {
        f<com.kwad.sdk.api.loader.a.C1266a> aIH;

        public e(f<com.kwad.sdk.api.loader.a.C1266a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.aIH.a(abVar, new c<com.kwad.sdk.api.loader.a.C1266a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                private void a(com.kwad.sdk.api.loader.a.C1266a c1266a, int i, Throwable th) {
                    j.j(c1266a.aHE);
                    l.b(c1266a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(@NonNull com.kwad.sdk.api.loader.a.C1266a c1266a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c1266a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), AnonymousClass1.class.getClassLoader(), c1266a.aHE.getPath(), c1266a.sdkVersion)) {
                            a(c1266a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.t(abVar.getContext(), c1266a.sdkVersion);
                        j.j(c1266a.aHE);
                        l.b(c1266a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.m(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c1266a, 2, th);
                    }
                }
            });
        }
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    public static class g implements f<com.kwad.sdk.api.loader.a.C1266a> {
        f<com.kwad.sdk.api.loader.a.C1266a> aIH;

        public g(f<com.kwad.sdk.api.loader.a.C1266a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<com.kwad.sdk.api.loader.a.C1266a> cVar) {
            this.aIH.a(abVar, new a<com.kwad.sdk.api.loader.a.C1266a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                private void a(com.kwad.sdk.api.loader.a.C1266a c1266a, int i, Throwable th) {
                    j.j(c1266a.aHE);
                    l.a(c1266a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(@NonNull com.kwad.sdk.api.loader.a.C1266a c1266a) {
                    try {
                        File file = c1266a.aHE;
                        if (!x.k(file)) {
                            a(c1266a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (x.a(file, c1266a.md5)) {
                            cVar.m(c1266a);
                        } else {
                            a(c1266a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c1266a, 3, th);
                    }
                }
            });
        }
    }

    public static class h implements f<com.kwad.sdk.api.loader.a.C1266a> {
        f<com.kwad.sdk.api.loader.a.C1266a> aIH;

        public h(f<com.kwad.sdk.api.loader.a.C1266a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C1266a> cVar) {
            this.aIH.a(abVar, new c<com.kwad.sdk.api.loader.a.C1266a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(com.kwad.sdk.api.loader.a.C1266a c1266a) {
                    String strBo = i.bo(abVar.getContext());
                    if (TextUtils.isEmpty(strBo)) {
                        strBo = com.kwad.sdk.api.c.Hu().getSDKVersion();
                    }
                    String str = c1266a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "interval", c1266a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c1266a.HB()) {
                        aa.bv(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strBo);
                        return;
                    }
                    if (i.N(c1266a.sdkVersion, strBo) && c1266a.HA()) {
                        cVar.m(c1266a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1266a.sdkVersion + " currentDynamicVersion:" + strBo + " dynamicType:" + c1266a.aHC);
                }
            });
        }
    }

    public static f<Boolean> HK() {
        return new e(new g(new d(new h(new b()))));
    }
}

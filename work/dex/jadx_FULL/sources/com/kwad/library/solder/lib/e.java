package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c aEj;
    private final com.kwad.library.solder.lib.a.c aEl;
    private final com.kwad.library.solder.lib.a.f aEm;
    private final com.kwad.library.solder.lib.a.b aEn;
    private final com.kwad.library.solder.lib.ext.a aEo;
    private Map<String, b> aEp;

    public static abstract class a {
        final com.kwad.library.solder.lib.a.d aEt;

        /* JADX INFO: renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        public static class C1263a extends a {
            public C1263a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aEt.DL().g(eVar);
            }
        }

        public static class b extends a {
            public b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aEt.DM().k(eVar);
            }
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.aEt = dVar;
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            return i != 1 ? new C1263a(dVar) : new b(dVar);
        }

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);
    }

    public static class b {
        private final com.kwad.library.solder.lib.a.e aEu;
        private final Future<com.kwad.library.solder.lib.a.e> aEv;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aEu = eVar;
            this.aEv = future;
        }

        public final void cancel() {
            this.aEu.cancel();
            this.aEv.cancel(true);
        }
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aEl = cVar;
        this.aEm = fVar;
        this.aEn = bVar;
        this.aEj = cVar2;
        this.aEo = aVar;
    }

    private b b(@NonNull final com.kwad.library.solder.lib.a.e eVar, @NonNull final a aVar) {
        b bVarCz = cz(eVar.Eb());
        if (bVarCz != null) {
            bVarCz.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aEj.Eu().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: DP, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.Eb(), bVar);
        return bVar;
    }

    @Nullable
    private synchronized b cz(String str) {
        Map<String, b> mapE = e(this.aEp);
        this.aEp = mapE;
        if (str == null) {
            return null;
        }
        return mapE.get(str);
    }

    private static Map<String, b> e(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c DK() {
        return this.aEj;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c DL() {
        return this.aEl;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f DM() {
        return this.aEm;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b DN() {
        return this.aEn;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a DO() {
        return this.aEo;
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.DX() == null) {
            eVar.a(this);
        }
        eVar.Eb();
        eVar.DY();
        aVar.j(eVar);
        return eVar;
    }

    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bVarCz = cz(eVar.Eb());
        if (bVarCz != null) {
            bVarCz.cancel();
        }
        a(eVar.Eb(), (b) null);
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i) {
        return b(eVar, a.a(this, 16));
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> mapE = e(this.aEp);
        this.aEp = mapE;
        if (str != null) {
            mapE.put(str, bVar);
        }
    }
}

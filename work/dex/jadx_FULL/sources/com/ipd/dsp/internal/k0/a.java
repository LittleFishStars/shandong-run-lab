package com.ipd.dsp.internal.k0;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final String c = "CallbackDispatcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.f0.c f38385a;
    public final Handler b;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.k0.a$a, reason: collision with other inner class name */
    public class RunnableC0889a implements Runnable {
        public final /* synthetic */ Collection f;
        public final /* synthetic */ Exception g;

        public RunnableC0889a(Collection collection, Exception exc) {
            this.f = collection;
            this.g = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f) {
                fVar.n().taskEnd(fVar, com.ipd.dsp.internal.i0.a.ERROR, this.g);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Collection f;
        public final /* synthetic */ Collection g;
        public final /* synthetic */ Collection h;

        public b(Collection collection, Collection collection2, Collection collection3) {
            this.f = collection;
            this.g = collection2;
            this.h = collection3;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f) {
                fVar.n().taskEnd(fVar, com.ipd.dsp.internal.i0.a.COMPLETED, null);
            }
            for (f fVar2 : this.g) {
                fVar2.n().taskEnd(fVar2, com.ipd.dsp.internal.i0.a.SAME_TASK_BUSY, null);
            }
            for (f fVar3 : this.h) {
                fVar3.n().taskEnd(fVar3, com.ipd.dsp.internal.i0.a.FILE_BUSY, null);
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Collection f;

        public c(Collection collection) {
            this.f = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (f fVar : this.f) {
                fVar.n().taskEnd(fVar, com.ipd.dsp.internal.i0.a.CANCELED, null);
            }
        }
    }

    public a(@NonNull Handler handler, @NonNull com.ipd.dsp.internal.f0.c cVar) {
        this.b = handler;
        this.f38385a = cVar;
    }

    public boolean a(f fVar) {
        long jO = fVar.o();
        return jO <= 0 || SystemClock.uptimeMillis() - f.c.a(fVar) >= jO;
    }

    public static class d implements com.ipd.dsp.internal.f0.c {

        @NonNull
        public final Handler f;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.k0.a$d$a, reason: collision with other inner class name */
        public class RunnableC0890a implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ long h;

            public RunnableC0890a(com.ipd.dsp.internal.f0.f fVar, int i, long j) {
                this.f = fVar;
                this.g = i;
                this.h = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().fetchEnd(this.f, this.g, this.h);
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ com.ipd.dsp.internal.i0.a g;
            public final /* synthetic */ Exception h;

            public b(com.ipd.dsp.internal.f0.f fVar, com.ipd.dsp.internal.i0.a aVar, Exception exc) {
                this.f = fVar;
                this.g = aVar;
                this.h = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().taskEnd(this.f, this.g, this.h);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;

            public c(com.ipd.dsp.internal.f0.f fVar) {
                this.f = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().taskStart(this.f);
            }
        }

        /* JADX INFO: renamed from: com.ipd.dsp.internal.k0.a$d$d, reason: collision with other inner class name */
        public class RunnableC0891d implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ Map g;

            public RunnableC0891d(com.ipd.dsp.internal.f0.f fVar, Map map) {
                this.f = fVar;
                this.g = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().connectTrialStart(this.f, this.g);
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ Map h;

            public e(com.ipd.dsp.internal.f0.f fVar, int i, Map map) {
                this.f = fVar;
                this.g = i;
                this.h = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().connectTrialEnd(this.f, this.g, this.h);
            }
        }

        public class f implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ com.ipd.dsp.internal.h0.b g;
            public final /* synthetic */ com.ipd.dsp.internal.i0.b h;

            public f(com.ipd.dsp.internal.f0.f fVar, com.ipd.dsp.internal.h0.b bVar, com.ipd.dsp.internal.i0.b bVar2) {
                this.f = fVar;
                this.g = bVar;
                this.h = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().downloadFromBeginning(this.f, this.g, this.h);
            }
        }

        public class g implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ com.ipd.dsp.internal.h0.b g;

            public g(com.ipd.dsp.internal.f0.f fVar, com.ipd.dsp.internal.h0.b bVar) {
                this.f = fVar;
                this.g = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().downloadFromBreakpoint(this.f, this.g);
            }
        }

        public class h implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ Map h;

            public h(com.ipd.dsp.internal.f0.f fVar, int i, Map map) {
                this.f = fVar;
                this.g = i;
                this.h = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().connectStart(this.f, this.g, this.h);
            }
        }

        public class i implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ int h;
            public final /* synthetic */ Map i;

            public i(com.ipd.dsp.internal.f0.f fVar, int i, int i2, Map map) {
                this.f = fVar;
                this.g = i;
                this.h = i2;
                this.i = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().connectEnd(this.f, this.g, this.h, this.i);
            }
        }

        public class j implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ long h;

            public j(com.ipd.dsp.internal.f0.f fVar, int i, long j) {
                this.f = fVar;
                this.g = i;
                this.h = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().fetchStart(this.f, this.g, this.h);
            }
        }

        public class k implements Runnable {
            public final /* synthetic */ com.ipd.dsp.internal.f0.f f;
            public final /* synthetic */ int g;
            public final /* synthetic */ long h;

            public k(com.ipd.dsp.internal.f0.f fVar, int i, long j) {
                this.f = fVar;
                this.g = i;
                this.h = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.n().fetchProgress(this.f, this.g, this.h);
            }
        }

        public d(@NonNull Handler handler) {
            this.f = handler;
        }

        public void a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
            com.ipd.dsp.internal.f0.d dVarG = com.ipd.dsp.internal.f0.h.j().g();
            if (dVarG != null) {
                dVarG.a(fVar, bVar);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, int i3, @NonNull Map<String, List<String>> map) {
            com.ipd.dsp.internal.g0.c.a(a.c, "<----- finish connection task(" + fVar.b() + ") block(" + i2 + ") code[" + i3 + "]" + map);
            if (fVar.y()) {
                this.f.post(new i(fVar, i2, i3, map));
            } else {
                fVar.n().connectEnd(fVar, i2, i3, map);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, @NonNull Map<String, List<String>> map) {
            com.ipd.dsp.internal.g0.c.a(a.c, "-----> start connection task(" + fVar.b() + ") block(" + i2 + ") " + map);
            if (fVar.y()) {
                this.f.post(new h(fVar, i2, map));
            } else {
                fVar.n().connectStart(fVar, i2, map);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectTrialEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, @NonNull Map<String, List<String>> map) {
            com.ipd.dsp.internal.g0.c.a(a.c, "<----- finish trial task(" + fVar.b() + ") code[" + i2 + "]" + map);
            if (fVar.y()) {
                this.f.post(new e(fVar, i2, map));
            } else {
                fVar.n().connectTrialEnd(fVar, i2, map);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void connectTrialStart(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull Map<String, List<String>> map) {
            com.ipd.dsp.internal.g0.c.a(a.c, "-----> start trial task(" + fVar.b() + ") " + map);
            if (fVar.y()) {
                this.f.post(new RunnableC0891d(fVar, map));
            } else {
                fVar.n().connectTrialStart(fVar, map);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void downloadFromBeginning(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
            com.ipd.dsp.internal.g0.c.a(a.c, "downloadFromBeginning: " + fVar.b());
            a(fVar, bVar, bVar2);
            if (fVar.y()) {
                this.f.post(new f(fVar, bVar, bVar2));
            } else {
                fVar.n().downloadFromBeginning(fVar, bVar, bVar2);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void downloadFromBreakpoint(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
            com.ipd.dsp.internal.g0.c.a(a.c, "downloadFromBreakpoint: " + fVar.b());
            a(fVar, bVar);
            if (fVar.y()) {
                this.f.post(new g(fVar, bVar));
            } else {
                fVar.n().downloadFromBreakpoint(fVar, bVar);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, long j2) {
            com.ipd.dsp.internal.g0.c.a(a.c, "fetchEnd: " + fVar.b());
            if (fVar.y()) {
                this.f.post(new RunnableC0890a(fVar, i2, j2));
            } else {
                fVar.n().fetchEnd(fVar, i2, j2);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchProgress(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, long j2) {
            if (fVar.o() > 0) {
                com.ipd.dsp.internal.f0.f.c.a(fVar, SystemClock.uptimeMillis());
            }
            if (fVar.y()) {
                this.f.post(new k(fVar, i2, j2));
            } else {
                fVar.n().fetchProgress(fVar, i2, j2);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void fetchStart(@NonNull com.ipd.dsp.internal.f0.f fVar, int i2, long j2) {
            com.ipd.dsp.internal.g0.c.a(a.c, "fetchStart: " + fVar.b());
            if (fVar.y()) {
                this.f.post(new j(fVar, i2, j2));
            } else {
                fVar.n().fetchStart(fVar, i2, j2);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
            if (aVar == com.ipd.dsp.internal.i0.a.ERROR) {
                com.ipd.dsp.internal.g0.c.a(a.c, "taskEnd: " + fVar.b() + " " + aVar + " " + exc);
            }
            a(fVar, aVar, exc);
            if (fVar.y()) {
                this.f.post(new b(fVar, aVar, exc));
            } else {
                fVar.n().taskEnd(fVar, aVar, exc);
            }
        }

        @Override // com.ipd.dsp.internal.f0.c
        public void taskStart(@NonNull com.ipd.dsp.internal.f0.f fVar) {
            com.ipd.dsp.internal.g0.c.a(a.c, "taskStart: " + fVar.b());
            a(fVar);
            if (fVar.y()) {
                this.f.post(new c(fVar));
            } else {
                fVar.n().taskStart(fVar);
            }
        }

        public void a(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.i0.b bVar2) {
            com.ipd.dsp.internal.f0.d dVarG = com.ipd.dsp.internal.f0.h.j().g();
            if (dVarG != null) {
                dVarG.a(fVar, bVar, bVar2);
            }
        }

        public void a(com.ipd.dsp.internal.f0.f fVar) {
            com.ipd.dsp.internal.f0.d dVarG = com.ipd.dsp.internal.f0.h.j().g();
            if (dVarG != null) {
                dVarG.taskStart(fVar);
            }
        }

        public void a(com.ipd.dsp.internal.f0.f fVar, com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
            com.ipd.dsp.internal.f0.d dVarG = com.ipd.dsp.internal.f0.h.j().g();
            if (dVarG != null) {
                dVarG.taskEnd(fVar, aVar, exc);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        this.f38385a = new d(handler);
    }

    public void a(@NonNull Collection<f> collection, @NonNull Exception exc) {
        if (collection.size() <= 0) {
            return;
        }
        com.ipd.dsp.internal.g0.c.a(c, "endTasksWithError error[" + collection.size() + "] realCause: " + exc);
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.y()) {
                next.n().taskEnd(next, com.ipd.dsp.internal.i0.a.ERROR, exc);
                it.remove();
            }
        }
        this.b.post(new RunnableC0889a(collection, exc));
    }

    public void a(@NonNull Collection<f> collection, @NonNull Collection<f> collection2, @NonNull Collection<f> collection3) {
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        com.ipd.dsp.internal.g0.c.a(c, "endTasks completed[" + collection.size() + "] sameTask[" + collection2.size() + "] fileBusy[" + collection3.size() + "]");
        if (collection.size() > 0) {
            Iterator<f> it = collection.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!next.y()) {
                    next.n().taskEnd(next, com.ipd.dsp.internal.i0.a.COMPLETED, null);
                    it.remove();
                }
            }
        }
        if (collection2.size() > 0) {
            Iterator<f> it2 = collection2.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (!next2.y()) {
                    next2.n().taskEnd(next2, com.ipd.dsp.internal.i0.a.SAME_TASK_BUSY, null);
                    it2.remove();
                }
            }
        }
        if (collection3.size() > 0) {
            Iterator<f> it3 = collection3.iterator();
            while (it3.hasNext()) {
                f next3 = it3.next();
                if (!next3.y()) {
                    next3.n().taskEnd(next3, com.ipd.dsp.internal.i0.a.FILE_BUSY, null);
                    it3.remove();
                }
            }
        }
        if (collection.size() == 0 && collection2.size() == 0 && collection3.size() == 0) {
            return;
        }
        this.b.post(new b(collection, collection2, collection3));
    }

    public void a(@NonNull Collection<f> collection) {
        if (collection.size() <= 0) {
            return;
        }
        com.ipd.dsp.internal.g0.c.a(c, "endTasksWithCanceled canceled[" + collection.size() + "]");
        Iterator<f> it = collection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.y()) {
                next.n().taskEnd(next, com.ipd.dsp.internal.i0.a.CANCELED, null);
                it.remove();
            }
        }
        this.b.post(new c(collection));
    }

    public com.ipd.dsp.internal.f0.c a() {
        return this.f38385a;
    }
}

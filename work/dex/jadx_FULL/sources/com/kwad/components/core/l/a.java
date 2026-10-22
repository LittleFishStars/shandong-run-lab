package com.kwad.components.core.l;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private CopyOnWriteArrayList<b> abc = new CopyOnWriteArrayList<>();
    private volatile boolean abd;

    /* JADX INFO: renamed from: com.kwad.components.core.l.a$a, reason: collision with other inner class name */
    public static final class C1215a {
        private static final a abe = new a();
    }

    public static class b {
        private final c abf;
        public boolean abg;

        public b(c cVar) {
            this.abf = cVar;
        }
    }

    public interface c {
        void bL();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.abg;
    }

    public static a tm() {
        return C1215a.abe;
    }

    public final void a(b bVar) {
        if (this.abc.contains(bVar)) {
            return;
        }
        if (!this.abd) {
            this.abd = true;
            bVar.abg = true;
        }
        this.abc.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.abg) {
            bVar.abg = false;
            this.abd = false;
        }
        this.abc.remove(bVar);
        if (this.abc.size() == 0 || this.abd) {
            return;
        }
        this.abc.get(0).abg = true;
        this.abd = true;
        this.abc.get(0).abf.bL();
    }
}

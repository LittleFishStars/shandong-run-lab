package com.kwad.framework.filedownloader;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class q {
    private final b aAd = new b();

    public static class a {
        private static final q aAe = new q();

        static {
            com.kwad.framework.filedownloader.message.e.CR().a(new aa());
        }
    }

    public static class b {
        private ThreadPoolExecutor aAf;
        private LinkedBlockingQueue<Runnable> aAg;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aAg = linkedBlockingQueue;
            this.aAf = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aAg.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aAf.execute(new c(bVar));
        }
    }

    public static class c implements Runnable {
        private final x.b aAh;
        private boolean aAi = false;

        public c(x.b bVar) {
            this.aAh = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aAh;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aAi) {
                return;
            }
            this.aAh.start();
        }
    }

    public static q BE() {
        return a.aAe;
    }

    public final synchronized void a(x.b bVar) {
        this.aAd.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aAd.b(bVar);
    }
}

package com.kwad.framework.filedownloader.message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private volatile g aCy;
    private volatile b aCz;

    public static final class a {
        private static final e aCA = new e();
    }

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e CR() {
        return a.aCA;
    }

    public final void a(b bVar) {
        this.aCz = bVar;
        if (bVar == null) {
            this.aCy = null;
        } else {
            this.aCy = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aCz != null) {
                this.aCz.r(messageSnapshot);
            }
        } else if (this.aCy != null) {
            this.aCy.u(messageSnapshot);
        }
    }
}

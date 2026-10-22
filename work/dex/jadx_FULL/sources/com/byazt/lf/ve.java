package com.byazt.lf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 526, 54})
public final class ve {
    public c c;
    public tt tt;

    public enum c {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface tt {
        void c(String str, String str2);
    }

    /* JADX INFO: renamed from: com.byazt.lf.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 526, 917})
    public static class C0462ve {
        public static final ve c = new ve();
    }

    public static void c(c cVar) {
        synchronized (ve.class) {
            C0462ve.c.c = cVar;
        }
    }

    public static void tt(String str, String str2) {
        if (C0462ve.c.c.compareTo(c.DEBUG) <= 0) {
            ve unused = C0462ve.c;
        }
    }

    private ve() {
        this.c = c.OFF;
        this.tt = new com.byazt.lf.tt();
    }

    public static void c(String str, String str2) {
        if (C0462ve.c.c.compareTo(c.ERROR) <= 0) {
            C0462ve.c.tt.c(str, str2);
        }
    }
}

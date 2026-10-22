package com.kwad.components.core.e.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    public static class C1198a {
        private static final c Qs = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static String B(long j) {
        String strC = pC().C(j);
        return strC.endsWith("=") ? strC.replace("=", "") : strC;
    }

    public static long am(String str) {
        return pC().an(str);
    }

    private static c pC() {
        return C1198a.Qs;
    }
}

package com.baidu.location.e.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f26457a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$1, reason: invalid class name */
    public class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26458a;

        static {
            int[] iArr = new int[EnumC0267b.values().length];
            f26458a = iArr;
            try {
                iArr[EnumC0267b.SUBWAY_STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26458a[EnumC0267b.TRAFFIC_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26458a[EnumC0267b.VDR_INDOOR_SPEED_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26458a[EnumC0267b.INDOOR_POI_DATA_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26458a[EnumC0267b.OUTDOOR_POI_DATA_STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26458a[EnumC0267b.GPS_CHECKER_STATUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f26459a = new b(null);
    }

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$b, reason: collision with other inner class name */
    public enum EnumC0267b {
        SUBWAY_STATIC,
        TRAFFIC_STATUS,
        VDR_INDOOR_SPEED_STATUS,
        INDOOR_POI_DATA_STATUS,
        OUTDOOR_POI_DATA_STATUS,
        GPS_CHECKER_STATUS
    }

    private b() {
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f26459a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(EnumC0267b enumC0267b) {
        switch (AnonymousClass2.f26458a[enumC0267b.ordinal()]) {
            case 1:
                if (f26457a == 0) {
                    return com.baidu.location.e.b.a.e.b;
                }
                return null;
            case 2:
                if (b == 0) {
                    return com.baidu.location.e.b.a.f.b;
                }
                return null;
            case 3:
                if (c == 0) {
                    return com.baidu.location.e.b.a.c.b;
                }
                return null;
            case 4:
                if (d == 0) {
                    return com.baidu.location.e.b.a.b.f26452a;
                }
                return null;
            case 5:
                if (e == 0) {
                    return com.baidu.location.e.b.a.d.f26454a;
                }
                return null;
            case 6:
                if (f == 0) {
                    return com.baidu.location.e.b.a.C0266a.f26451a;
                }
                return null;
            default:
                return null;
        }
    }
}

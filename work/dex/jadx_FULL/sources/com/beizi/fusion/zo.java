package com.beizi.fusion;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class zo implements ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zo f28110a = new a("DOUBLE", 0);
    public static final zo b = new b("LAZILY_PARSED_NUMBER", 1);
    public static final zo c = new c("LONG_OR_DOUBLE", 2);
    public static final zo d = new d("BIG_DECIMAL", 3);
    private static final /* synthetic */ zo[] e = a();

    public final enum a extends zo {
        private a(String str, int i) {
            super(str, i);
        }
    }

    public final enum b extends zo {
        private b(String str, int i) {
            super(str, i);
        }
    }

    public final enum c extends zo {
        private c(String str, int i) {
            super(str, i);
        }
    }

    public final enum d extends zo {
        private d(String str, int i) {
            super(str, i);
        }
    }

    private zo(String str, int i) {
        super(str, i);
    }

    private static /* synthetic */ zo[] a() {
        return new zo[]{f28110a, b, c, d};
    }

    public static zo valueOf(String str) {
        return (zo) Enum.valueOf(zo.class, str);
    }

    public static zo[] values() {
        return (zo[]) e.clone();
    }
}

package com.beizi.fusion;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class y7 implements z7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y7 f28059a = new a("IDENTITY", 0);
    public static final y7 b = new b("UPPER_CAMEL_CASE", 1);
    public static final y7 c = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
    public static final y7 d = new d("UPPER_CASE_WITH_UNDERSCORES", 3);
    public static final y7 e = new e("LOWER_CASE_WITH_UNDERSCORES", 4);
    public static final y7 f = new f("LOWER_CASE_WITH_DASHES", 5);
    public static final y7 g = new g("LOWER_CASE_WITH_DOTS", 6);
    private static final /* synthetic */ y7[] h = a();

    public final enum a extends y7 {
        private a(String str, int i) {
            super(str, i);
        }
    }

    public final enum b extends y7 {
        private b(String str, int i) {
            super(str, i);
        }
    }

    public final enum c extends y7 {
        private c(String str, int i) {
            super(str, i);
        }
    }

    public final enum d extends y7 {
        private d(String str, int i) {
            super(str, i);
        }
    }

    public final enum e extends y7 {
        private e(String str, int i) {
            super(str, i);
        }
    }

    public final enum f extends y7 {
        private f(String str, int i) {
            super(str, i);
        }
    }

    public final enum g extends y7 {
        private g(String str, int i) {
            super(str, i);
        }
    }

    private y7(String str, int i) {
        super(str, i);
    }

    private static /* synthetic */ y7[] a() {
        return new y7[]{f28059a, b, c, d, e, f, g};
    }

    public static y7 valueOf(String str) {
        return (y7) Enum.valueOf(y7.class, str);
    }

    public static y7[] values() {
        return (y7[]) h.clone();
    }
}

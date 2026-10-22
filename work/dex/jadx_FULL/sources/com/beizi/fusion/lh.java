package com.beizi.fusion;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class lh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lh f27511a = new a("DEFAULT", 0);
    public static final lh b = new b("STRING", 1);
    private static final /* synthetic */ lh[] c = a();

    public final enum a extends lh {
        private a(String str, int i) {
            super(str, i);
        }
    }

    public final enum b extends lh {
        private b(String str, int i) {
            super(str, i);
        }
    }

    private lh(String str, int i) {
        super(str, i);
    }

    private static /* synthetic */ lh[] a() {
        return new lh[]{f27511a, b};
    }

    public static lh valueOf(String str) {
        return (lh) Enum.valueOf(lh.class, str);
    }

    public static lh[] values() {
        return (lh[]) c.clone();
    }
}

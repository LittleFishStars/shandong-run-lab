package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class p9 {

    public enum a {
        UNKNOWN(-1),
        ADULT(0),
        UNDERAGE(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27651a;

        a(int i) {
            this.f27651a = i;
        }

        public int b() {
            return this.f27651a;
        }
    }

    public c0 a() {
        return null;
    }

    public String b() {
        return "";
    }

    public String c() {
        return "";
    }

    public String d() {
        return "";
    }

    public a e() {
        return a.UNKNOWN;
    }

    public String f() {
        return "";
    }

    public abstract boolean g();

    public boolean h() {
        return true;
    }

    public boolean i() {
        return true;
    }

    public abstract boolean j();

    public abstract boolean k();
}

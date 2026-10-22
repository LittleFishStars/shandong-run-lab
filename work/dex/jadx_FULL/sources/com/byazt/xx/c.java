package com.byazt.xx;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1007, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29193a;
    public double c;
    public String da;
    public String n;
    public String sl;
    public double tt;
    public double uj;
    public double ve;
    public int sp = 0;
    public int x = 0;
    public int i = 0;

    public c(double d, double d2, double d3, double d4, int i, String str) {
        this.c = d;
        this.tt = d2;
        this.ve = d3;
        this.uj = d4;
        this.n = str;
        this.f29193a = i;
    }

    private boolean n() {
        return c(this.tt, this.uj);
    }

    private boolean uj() {
        return c(this.c, this.ve);
    }

    public boolean c() {
        return uj();
    }

    public String toString() {
        return "adnName = " + this.da + " adnRit = " + this.sl + ", send = " + this.sp + ", fill = " + this.x + ", show = " + this.i + " localSsr = " + this.c + ", serviceSsr = " + this.ve + ", localSrr = " + this.tt + ", serviceSrr = " + this.uj + ", opt = " + this.n + ", condition = " + this.f29193a + ", compareBehaviorSsr = " + uj() + ", compareBehaviorSrr = " + n() + ", checkBehaviorRule = " + c();
    }

    public double tt() {
        return this.c;
    }

    public double ve() {
        return this.tt;
    }

    private boolean c(double d, double d2) {
        String str = this.n;
        str.hashCode();
        switch (str) {
            case "1":
                return d > d2;
            case "2":
                return d < d2;
            case "3":
                return d >= d2;
            case "4":
                return d <= d2;
            case "5":
                return d == d2;
            default:
                return true;
        }
    }

    public void tt(int i) {
        this.x = i;
    }

    public void ve(int i) {
        this.i = i;
    }

    public void c(int i) {
        this.sp = i;
    }

    public void tt(String str) {
        this.sl = str;
    }

    public void c(String str) {
        this.da = str;
    }
}

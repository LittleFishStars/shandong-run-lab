package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f24584a;
    private boolean b = false;

    public m(int i) {
        this.f24584a = i;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean a(w wVar) {
        return wVar.i() && this.f24584a == ((m) wVar).f24584a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public String a_(com.alibaba.jsi.standard.b bVar) {
        return this.b ? String.valueOf((int) this.f24584a) : String.valueOf(this.f24584a);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public w b(com.alibaba.jsi.standard.b bVar) {
        return this.b ? new m((int) this.f24584a) : new m(this.f24584a);
    }

    public double c_() {
        return this.f24584a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean i() {
        return true;
    }

    public boolean j() {
        return this.b;
    }

    public int l() {
        if (this.b) {
            return (int) this.f24584a;
        }
        throw new AssertionError("Not a integer");
    }

    public m(double d) {
        this.f24584a = d;
    }
}

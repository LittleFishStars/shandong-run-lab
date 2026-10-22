package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24590a;

    public y() {
        this.f24590a = true;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean a(w wVar) {
        return wVar.u() && this.f24590a == ((y) wVar).f24590a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public String a_(com.alibaba.jsi.standard.b bVar) {
        Object[] objArr = new Object[1];
        objArr[0] = this.f24590a ? "undefined" : "null";
        return String.format("Void(%s)", objArr);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public w b(com.alibaba.jsi.standard.b bVar) {
        return new y(this.f24590a);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean u() {
        return true;
    }

    public boolean w() {
        return this.f24590a;
    }

    public boolean x() {
        return !this.f24590a;
    }

    public y(boolean z) {
        this.f24590a = z;
    }
}

package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24587a;

    public s(String str) {
        super(null, 0L);
        this.f24587a = str;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean a(w wVar) {
        if (wVar.p()) {
            return this.f24587a.equals(((s) wVar).f24587a);
        }
        return false;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public String a_(com.alibaba.jsi.standard.b bVar) {
        return this.f24587a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public w b(com.alibaba.jsi.standard.b bVar) {
        return new s(this.f24587a);
    }

    public String f_() {
        return this.f24587a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean p() {
        return true;
    }
}

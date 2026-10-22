package com.alibaba.jsi.standard.js;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24581a;

    public f(boolean z) {
        this.f24581a = z;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean a(w wVar) {
        return wVar.d() && this.f24581a == ((f) wVar).f24581a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public String a_(com.alibaba.jsi.standard.b bVar) {
        return this.f24581a ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public w b(com.alibaba.jsi.standard.b bVar) {
        return new f(this.f24581a);
    }

    public boolean b_() {
        return this.f24581a;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean d() {
        return true;
    }
}

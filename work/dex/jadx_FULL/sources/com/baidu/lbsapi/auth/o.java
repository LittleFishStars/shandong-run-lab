package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class o implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f26316a;
    final /* synthetic */ LBSAuthManager b;

    public o(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f26316a = str;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public void a(String str) {
        this.b.a(str, this.f26316a);
    }
}

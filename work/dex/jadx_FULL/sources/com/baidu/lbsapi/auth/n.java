package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class n implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f26315a;
    final /* synthetic */ LBSAuthManager b;

    public n(LBSAuthManager lBSAuthManager, String str) {
        this.b = lBSAuthManager;
        this.f26315a = str;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.b.a(str, this.f26315a);
    }
}

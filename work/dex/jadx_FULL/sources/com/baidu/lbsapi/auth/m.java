package com.baidu.lbsapi.auth;

import java.util.Hashtable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f26314a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    public m(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f26314a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a("status = " + this.f26314a + "; forced = " + this.b + "checkAK = " + this.f.b(this.c));
        int i = this.f26314a;
        if (i != 601 && !this.b && i != -1 && !this.f.b(this.c)) {
            if (602 == this.f26314a) {
                b.a("authenticate wait ");
                if (LBSAuthManager.h != null) {
                    LBSAuthManager.h.b();
                }
            } else {
                b.a("authenticate else");
            }
            this.f.a((String) null, this.c);
            return;
        }
        b.a("authenticate sendAuthRequest");
        String[] strArrB = d.b(LBSAuthManager.f26303a);
        if (strArrB == null || strArrB.length <= 1) {
            this.f.a(this.b, this.d, this.e, this.c, LBSAuthManager.b, LBSAuthManager.c, LBSAuthManager.d, LBSAuthManager.e);
            return;
        }
        b.a("authStrings.length:" + strArrB.length);
        b.a("more sha1 auth");
        this.f.a(this.b, this.d, this.e, strArrB, this.c, LBSAuthManager.b, LBSAuthManager.c, LBSAuthManager.d, LBSAuthManager.e);
    }
}

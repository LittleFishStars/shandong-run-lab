package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f26309a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ g e;

    public h(g gVar, String str, int i, String str2, String str3) {
        this.e = gVar;
        this.f26309a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        g gVar = this.e;
        gVar.a(gVar.b, this.f26309a, this.b, this.c, this.d);
    }
}

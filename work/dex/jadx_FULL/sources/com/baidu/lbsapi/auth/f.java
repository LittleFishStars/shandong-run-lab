package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f26307a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ e e;

    public f(e eVar, String str, int i, String str2, String str3) {
        this.e = eVar;
        this.f26307a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        this.e.a(new i(this.e.f26306a).a(this.e.b, this.f26307a, this.b, this.c, this.d));
    }
}

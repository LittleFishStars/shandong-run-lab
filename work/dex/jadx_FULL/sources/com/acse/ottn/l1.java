package com.acse.ottn;

import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.model.AccessiblityModel;
import okhttp3.RequestBody;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l1 extends q3 {
    public l4 g = (l4) a().g(l4.class);

    public Observable<String> a(RequestBody requestBody) {
        return this.g.y(requestBody);
    }

    public Observable<String> b(RequestBody requestBody) {
        return this.g.e(requestBody);
    }

    @Override // com.acse.ottn.q3
    public String c() {
        return AcseHelpManager.mIsDebug ? "http://a.idazhe.net/ss/tongji_oozk_cn/" : "http://tongji.oozk.cn";
    }

    public Observable<String> d(RequestBody requestBody) {
        return this.g.c(requestBody);
    }

    public Observable<String> e(RequestBody requestBody) {
        return this.g.j(requestBody);
    }

    public Observable<String> f(RequestBody requestBody) {
        return this.g.C(requestBody);
    }

    public Observable<String> g(RequestBody requestBody) {
        return this.g.w(requestBody);
    }

    public Observable<String> h(RequestBody requestBody) {
        return this.g.q(requestBody);
    }

    public Observable<String> i(RequestBody requestBody) {
        return this.g.E(requestBody);
    }

    public Observable<AccessiblityModel> j(RequestBody requestBody) {
        return this.g.l(requestBody);
    }

    public Observable<String> k(RequestBody requestBody) {
        return this.g.b(requestBody);
    }

    public Observable<String> l(RequestBody requestBody) {
        return this.g.f(requestBody);
    }

    public Observable<AccessiblityModel> c(RequestBody requestBody) {
        return this.g.B(requestBody);
    }
}

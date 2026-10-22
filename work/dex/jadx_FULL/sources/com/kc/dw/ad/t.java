package com.kc.dw.ad;

import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t extends com.kc.dw.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.splash.d f39171a;
    public final k b;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f39172a;

        public a(t tVar) {
            this.f39172a = tVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            k kVar = this.f39172a.b;
            if (kVar.v.e || kVar.t.b > 4) {
                return;
            }
            String[] eventUrl = this.f39172a.f39171a.getEventUrl();
            int iIntValue = com.kc.dw.core.exception.b.c.intValue();
            StringBuilder sbA = com.kc.dw.activity.a.a("load res error 5000timeout,cid=");
            sbA.append(this.f39172a.f39171a.getCid());
            s1.a(eventUrl, 12, iIntValue, sbA.toString());
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.f39172a.b.w, new LoadResState().setFail(1));
        }
    }

    public t(k kVar, com.kc.dw.ad.splash.d dVar) {
        this.b = kVar;
        this.f39171a = dVar;
    }

    @Override // com.kc.dw.core.safe.l
    public void a() {
        cancel();
        SdkHandler.getInstance().runOnUiThread(new a(this));
    }
}

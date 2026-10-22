package com.kc.dw.ad;

import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class v extends com.kc.dw.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f39174a;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f39175a;

        public a(v vVar) {
            this.f39175a = vVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            k kVar = this.f39175a.f39174a;
            com.kc.dw.platform.ad_adapter.splash.e eVar = kVar.v;
            if (eVar == null || eVar.j == null || kVar.D[0]) {
                return;
            }
            com.kc.dw.core.service.logrecord.a.a(5, "f7", kVar.w, new ShowAdState().setFail(2, 9000003, "广告展示超时5000"));
        }
    }

    public v(k kVar) {
        this.f39174a = kVar;
    }

    @Override // com.kc.dw.core.safe.l
    public void a() {
        cancel();
        SdkHandler.getInstance().runOnUiThread(new a(this));
    }
}

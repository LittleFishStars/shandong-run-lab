package com.huachenjie.run.page.free_run;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.UnfinishedRun;
import com.zj.adlib.ai9;
import com.zj.adlib.in3;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class b extends FreeRunContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public in3 f35863a;

    public class a extends BizSubscriber<SportStatics> {
        public a(boolean showErrorToast) {
            super(showErrorToast);
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SportStatics data) {
            if (data != null) {
                ai9.v(data);
                ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).queryStaticsSuccess();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.free_run.b$b, reason: collision with other inner class name */
    public class C0820b extends BizSubscriber<JSONObject> {
        public C0820b(boolean showErrorToast) {
            super(showErrorToast);
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(JSONObject data) {
            if (data == null || !data.containsKey("runRecordCode")) {
                ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).startRunFailed("");
            } else {
                ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).startRunSucceed(data.getString("runRecordCode"));
            }
        }
    }

    public class c extends BizSubscriber<UnfinishedRun> {
        public c(boolean showErrorToast) {
            super(showErrorToast);
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(UnfinishedRun data) {
            if (data == null) {
                ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).noUnFinishedRun();
            } else {
                ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).haveUnFinishedRun(data);
            }
        }
    }

    public class d extends BizSubscriber<JSONObject> {
        public d() {
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).finishRunFailed(code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(JSONObject data) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) b.this).f33638a).finishRunSucceed();
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f35863a = new in3();
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.Presenter
    public void f() {
        n76.d(this.f35863a.a(2)).c(this).p5(new c(true));
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.Presenter
    public void g(int timeType, int sportType) {
        n76.d(this.f35863a.e(timeType, sportType)).c(this).p5(new a(true));
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.Presenter
    public void h(double lat, double lng, long aimDistance, long aimDuration, int aimCalorie) {
        n76.d(this.f35863a.f(lat, lng, aimDistance, aimDuration, aimCalorie)).c(this).p5(new C0820b(true));
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.Presenter
    public void i(Map<String, Object> params) {
        n76.d(this.f35863a.b(params)).c(this).p5(new d());
    }
}

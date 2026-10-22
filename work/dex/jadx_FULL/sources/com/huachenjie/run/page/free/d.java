package com.huachenjie.run.page.free;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.run.bean.FinishFreeRunResult;
import com.huachenjie.run.bean.FinishRunResult;
import com.zj.adlib.km7;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class d extends TargetSettingContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public km7 f35844a;

    public class a extends BizSubscriber<JSONObject> {
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean showErrorToast, final long val$aimDistance, final long val$aimDuration, final long val$aimCalorie) {
            super(showErrorToast);
            this.c = val$aimDistance;
            this.d = val$aimDuration;
            this.e = val$aimCalorie;
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
                ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).startRunFailed("");
            } else {
                ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).g(data.getString("runRecordCode"), this.c, this.d, this.e);
            }
        }
    }

    public class b extends BizSubscriber<UnfinishedRun> {
        public b(boolean showErrorToast) {
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
                ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).noUnFinishedRun();
            } else {
                ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).haveUnFinishedRun(data);
            }
        }
    }

    public class c extends BizSubscriber<FinishRunResult> {
        public c() {
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).finishRunFailed(code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(FinishRunResult data) {
            ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).finishRunSucceed();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.free.d$d, reason: collision with other inner class name */
    public class C0818d extends BizSubscriber<FinishFreeRunResult> {
        public C0818d() {
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).finishRunFailed(code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(FinishFreeRunResult data) {
            ((TargetSettingContact.TargetSettingView) ((BasePresenter) d.this).f33638a).finishRunSucceed();
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f35844a = new km7();
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.Presenter
    public void f() {
        n76.d(this.f35844a.a(2)).c(this).p5(new b(true));
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.Presenter
    public void g(double lat, double lng, long aimDistance, long aimDuration, long aimCalorie) {
        n76.d(this.f35844a.g(lat, lng, aimDistance, aimDuration, aimCalorie)).c(this).p5(new a(true, aimDistance, aimDuration, aimCalorie));
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.Presenter
    public void h(Map<String, Object> params) {
        n76.d(this.f35844a.b(params)).c(this).p5(new C0818d());
    }

    @Override // com.huachenjie.run.page.free.TargetSettingContact.Presenter
    public void i(Map<String, Object> params) {
        n76.d(this.f35844a.c(params)).c(this).p5(new c());
    }
}

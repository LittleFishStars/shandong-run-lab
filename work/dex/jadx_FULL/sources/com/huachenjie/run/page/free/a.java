package com.huachenjie.run.page.free;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.run.bean.FinishFreeRunResult;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.UploadData;
import com.zj.adlib.ai9;
import com.zj.adlib.km7;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class a extends FreeRunContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public km7 f35837a;

    /* JADX INFO: renamed from: com.huachenjie.run.page.free.a$a, reason: collision with other inner class name */
    public class C0817a extends BizSubscriber<UploadData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f12436a;

        public C0817a(final List val$pathList) {
            this.f12436a = val$pathList;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            if (a.this.q(baseEntity.code, baseEntity.message, 0)) {
                return true;
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(UploadData data) {
        }

        public void onFailed(int code, String message) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).a(this.f12436a);
        }

        public void onFinish() {
            super.onFinish();
        }
    }

    public class b extends BizSubscriber<UploadData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f12437a;

        public b(final List val$paceList) {
            this.f12437a = val$paceList;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            if (a.this.q(baseEntity.code, baseEntity.message, 0)) {
                return true;
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(UploadData data) {
        }

        public void onFailed(int code, String message) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).B(this.f12437a);
        }

        public void onFinish() {
            super.onFinish();
        }
    }

    public class c extends BizSubscriber<UploadData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f12438a;

        public c(final List val$stepList) {
            this.f12438a = val$stepList;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            if (a.this.q(baseEntity.code, baseEntity.message, 0)) {
                return true;
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(UploadData data) {
        }

        public void onFailed(int code, String message) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).D(this.f12438a);
        }

        public void onFinish() {
            super.onFinish();
        }
    }

    public class d extends BizSubscriber<FinishFreeRunResult> {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public d(final boolean val$isAuto, final boolean val$isDataError, final boolean val$isValid) {
            this.b = val$isAuto;
            this.c = val$isDataError;
            this.d = val$isValid;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).x(this.b, this.c, this.d, code, message);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(FinishFreeRunResult data) {
            if (data == null || data.getInspiration() == null) {
                ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).A(this.b, this.c, this.d, 0);
            } else {
                ((FreeRunContact.FreeRunView) ((BasePresenter) a.this).f33638a).A(this.b, this.c, this.d, data.getInspiration().getValue());
            }
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f35837a = new km7();
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.Presenter
    public void f(boolean isAuto, boolean isDataError, Map<String, Object> params, boolean isValid) {
        if (ai9.l()) {
            n76.d(this.f35837a.b(params)).c(this).p5(new d(isAuto, isDataError, isValid));
        } else {
            ((FreeRunContact.FreeRunView) ((BasePresenter) this).f33638a).A(false, true, true, 0);
        }
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.Presenter
    public void g(List<IntervalPace> paceList, long paceInterval, String runRecordCode) {
        n76.d(this.f35837a.h(paceList, paceInterval, runRecordCode)).c(this).p5(new b(paceList));
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.Presenter
    public void h(List<HCJLatLng> pathList, String runRecordCode) {
        n76.d(this.f35837a.i(pathList, runRecordCode)).c(this).p5(new C0817a(pathList));
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.Presenter
    public void i(List<IntervalStep> stepList, long stepInterval, String runRecordCode) {
        n76.d(this.f35837a.k(stepList, stepInterval, runRecordCode)).c(this).p5(new c(stepList));
    }

    public final boolean q(int code, String message, int inspirationValue) {
        switch (code) {
            case 2072:
                ((FreeRunContact.FreeRunView) ((BasePresenter) this).f33638a).v(false, inspirationValue);
                return true;
            case 2073:
            case 2074:
                ((FreeRunContact.FreeRunView) ((BasePresenter) this).f33638a).w(message);
                return true;
            default:
                return false;
        }
    }
}

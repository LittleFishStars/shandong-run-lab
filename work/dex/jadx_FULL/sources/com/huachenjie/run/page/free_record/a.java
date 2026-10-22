package com.huachenjie.run.page.free_record;

import android.app.Activity;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.zj.adlib.in3;
import com.zj.adlib.km7;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogSubscriber;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class a extends FreeRecordContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public in3 f35855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public km7 f12448a;

    /* JADX INFO: renamed from: com.huachenjie.run.page.free_record.a$a, reason: collision with other inner class name */
    public class C0819a extends DialogSubscriber<SportStatics> {
        public C0819a(Activity activity, boolean showErrorToast) {
            super(activity, showErrorToast);
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super/*huachenjie.sdk.http.subscriber.BizSubscriber*/.onBizError(baseEntity);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SportStatics data) {
            if (data != null) {
                ((FreeRecordContact.FreeRecordView) ((BasePresenter) a.this).f33638a).queryStaticsSuccess(data);
            }
        }
    }

    public class b extends BizSubscriber<SunshineRecordListEntity> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean showErrorToast, final int val$pageNo) {
            super(showErrorToast);
            this.K = val$pageNo;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            ((FreeRecordContact.FreeRecordView) ((BasePresenter) a.this).f33638a).queryFreeRecordFailed();
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SunshineRecordListEntity data) {
            if (data == null) {
                a.this.c().queryFreeRecordFailed();
            } else if (this.K == 1) {
                ((FreeRecordContact.FreeRecordView) ((BasePresenter) a.this).f33638a).refreshFreeRecordSucceed(data);
            } else {
                ((FreeRecordContact.FreeRecordView) ((BasePresenter) a.this).f33638a).loadMoreFreeRecordSucceed(data);
            }
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f12448a = new km7();
        this.f35855a = new in3();
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.Presenter
    public Subscription f(int timeType, int pageNo) {
        return n76.d(this.f35855a.d(timeType, pageNo)).c(this).p5(new b(true, pageNo));
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.Presenter
    public void g(int timeType, int sportType) {
        n76.d(this.f12448a.f(timeType, sportType)).c(this).p5(new C0819a((Activity) ((FreeRecordContact.FreeRecordView) ((BasePresenter) this).f33638a).getContext(), true));
    }
}

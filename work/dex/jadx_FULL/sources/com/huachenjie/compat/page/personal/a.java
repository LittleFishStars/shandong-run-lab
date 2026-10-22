package com.huachenjie.compat.page.personal;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.SendMsgEntity;
import com.huachenjie.compat.bean.ConfirmPhoneEntity;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.DialogSubscriber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class a extends ConfirmPhoneContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rq1 f34160a;

    /* JADX INFO: renamed from: com.huachenjie.compat.page.personal.a$a, reason: collision with other inner class name */
    public class C0800a extends DialogSubscriber<SendMsgEntity> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0800a(Activity activity, boolean z, String str) {
            super(activity, z);
            this.f = str;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            if (baseEntity.code != 1600) {
                return super/*huachenjie.sdk.http.subscriber.BizSubscriber*/.onBizError(baseEntity);
            }
            ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).needCaptchaCheck(this.f);
            return true;
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).sendSMSFailed("");
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SendMsgEntity sendMsgEntity) {
            if (sendMsgEntity != null) {
                ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).sendSMSSucceed(sendMsgEntity.getTicket());
            } else {
                ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).sendSMSFailed("");
            }
        }
    }

    public class b extends DialogSubscriber<ConfirmPhoneEntity> {
        public b(Activity activity, boolean z) {
            super(activity, z);
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super/*huachenjie.sdk.http.subscriber.BizSubscriber*/.onBizError(baseEntity);
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).sendSMSFailed("");
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(ConfirmPhoneEntity confirmPhoneEntity) {
            ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) a.this).f33638a).confirmPhoneSucceed(confirmPhoneEntity);
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        super.e();
        this.f34160a = new rq1();
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.Presenter
    public void f(String str, String str2, String str3, int i) {
        n76.d(this.f34160a.b(str, str2, str3, i)).c(this).p5(new b((Activity) ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) this).f33638a).getContext(), true));
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.Presenter
    public void g(String str, int i, @Nullable String str2) {
        n76.d(this.f34160a.n(str, i, str2)).c(this).p5(new C0800a((Activity) ((ConfirmPhoneContact.ConfirmPhoneView) ((BasePresenter) this).f33638a).getContext(), true, str));
    }
}

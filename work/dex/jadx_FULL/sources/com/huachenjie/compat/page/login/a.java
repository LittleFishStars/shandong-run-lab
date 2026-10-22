package com.huachenjie.compat.page.login;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.compat.bean.SchoolListEntity;
import com.zj.adlib.k25;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class a extends SearchSchoolContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k25 f34117a;

    /* JADX INFO: renamed from: com.huachenjie.compat.page.login.a$a, reason: collision with other inner class name */
    public class C0799a extends BizSubscriber<SchoolListEntity> {
        public final /* synthetic */ int K;

        public C0799a(int i) {
            this.K = i;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int i, String str) {
            ((SearchSchoolContact.SearchSchoolView) ((BasePresenter) a.this).f33638a).o(str);
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SchoolListEntity schoolListEntity) {
            if (schoolListEntity == null) {
                ((SearchSchoolContact.SearchSchoolView) ((BasePresenter) a.this).f33638a).o("");
            } else if (this.K == 1) {
                ((SearchSchoolContact.SearchSchoolView) ((BasePresenter) a.this).f33638a).d(schoolListEntity);
            } else {
                ((SearchSchoolContact.SearchSchoolView) ((BasePresenter) a.this).f33638a).c(schoolListEntity);
            }
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f34117a = new k25();
    }

    @Override // com.huachenjie.compat.page.login.SearchSchoolContact.Presenter
    public Subscription f(String str, int i) {
        return n76.d(this.f34117a.e(str, i)).c(this).p5(new C0799a(i));
    }
}

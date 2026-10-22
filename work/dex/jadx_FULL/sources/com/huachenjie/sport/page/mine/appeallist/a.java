package com.huachenjie.sport.page.mine.appeallist;

import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.sport.api.SportModel;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class a extends AppealListContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SportModel f36578a;

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.appeallist.a$a, reason: collision with other inner class name */
    public class C0825a extends BizSubscriber<SunshineRecordListEntity> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0825a(boolean z, int i) {
            super(z);
            this.K = i;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            return super.onBizError(baseEntity);
        }

        public void onFailed(int i, String str) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
            ((AppealListContact.AppealListView) ((BasePresenter) a.this).f33638a).queryAppealListFailed();
        }

        public void onFinish() {
            super.onFinish();
        }

        public void onCCSuccess(SunshineRecordListEntity sunshineRecordListEntity) {
            if (sunshineRecordListEntity == null) {
                a.this.c().queryAppealListFailed();
            } else if (this.K == 1) {
                ((AppealListContact.AppealListView) ((BasePresenter) a.this).f33638a).refreshAppealListSucceed(sunshineRecordListEntity);
            } else {
                ((AppealListContact.AppealListView) ((BasePresenter) a.this).f33638a).loadMoreAppealListSucceed(sunshineRecordListEntity);
            }
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.f36578a = new SportModel();
    }

    @Override // com.huachenjie.sport.page.mine.appeallist.AppealListContact.Presenter
    public Subscription f(int i, int i2) {
        return n76.d(this.f36578a.o(i, i2)).c(this).p5(new C0825a(true, i2));
    }
}

package com.huachenjie.run.page.free_record;

import android.os.Bundle;
import com.huachenjie.common.base.BaseFragment;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.run.R;
import java.lang.ref.WeakReference;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRecordFragment extends BaseFragment<com.huachenjie.run.page.free_record.a> implements FreeRecordContact.FreeRecordView {
    private static final String TAG = "FreeRecordFragment";
    private static final String TIME_TYPE = "time_type";
    private FreeRecordPageComponent mFreeRecordPageComponent;
    private a mRecordPageListener;
    private Subscription mSearchRecordSubscription;
    private int mTimeType;

    public static class a implements FreeRecordPageComponent.OnRecordListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<FreeRecordFragment> f35850a;

        public a(FreeRecordFragment fragment) {
            if (fragment != null) {
                this.f35850a = new WeakReference<>(fragment);
            }
        }

        @Override // com.huachenjie.run.page.free_record.FreeRecordPageComponent.OnRecordListener
        public void a(int pageNo) {
            FreeRecordFragment freeRecordFragment;
            WeakReference<FreeRecordFragment> weakReference = this.f35850a;
            if (weakReference == null || (freeRecordFragment = weakReference.get()) == null) {
                return;
            }
            freeRecordFragment.searchRecord(pageNo);
        }
    }

    public static FreeRecordFragment newInstance(int timeType) {
        FreeRecordFragment freeRecordFragment = new FreeRecordFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TIME_TYPE, timeType);
        freeRecordFragment.setArguments(bundle);
        return freeRecordFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchRecord(int pageNo) {
        Subscription subscription = this.mSearchRecordSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.mSearchRecordSubscription = ((com.huachenjie.run.page.free_record.a) this.mPresenter).f(this.mTimeType, pageNo);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public int getContentViewRes() {
        return R.layout.run_fragment_free_record;
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void getServerData() {
        ((com.huachenjie.run.page.free_record.a) this.mPresenter).g(this.mTimeType, 2);
        this.mFreeRecordPageComponent.p();
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void handleArguments(Bundle arguments) {
        this.mTimeType = arguments.getInt(TIME_TYPE);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initField() {
        this.mRecordPageListener = new a(this);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initView() {
        FreeRecordPageComponent freeRecordPageComponent = new FreeRecordPageComponent(this);
        this.mFreeRecordPageComponent = freeRecordPageComponent;
        freeRecordPageComponent.setOnRecordListener(this.mRecordPageListener);
        getLifecycle().addObserver(this.mFreeRecordPageComponent);
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.FreeRecordView
    public void loadMoreFreeRecordSucceed(SunshineRecordListEntity listEntity) {
        this.mFreeRecordPageComponent.w(listEntity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Subscription subscription = this.mSearchRecordSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.FreeRecordView
    public void queryFreeRecordFailed() {
        this.mFreeRecordPageComponent.q("");
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.FreeRecordView
    public void queryStaticsFailed() {
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.FreeRecordView
    public void queryStaticsSuccess(SportStatics sportStatics) {
        this.mFreeRecordPageComponent.A(sportStatics);
    }

    @Override // com.huachenjie.run.page.free_record.FreeRecordContact.FreeRecordView
    public void refreshFreeRecordSucceed(SunshineRecordListEntity listEntity) {
        this.mFreeRecordPageComponent.z(listEntity);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public com.huachenjie.run.page.free_record.a initPresenter() {
        return new com.huachenjie.run.page.free_record.a();
    }
}

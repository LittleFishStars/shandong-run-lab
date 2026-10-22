package com.huachenjie.sport.page.mine.appeallist;

import android.os.Bundle;
import com.huachenjie.common.base.BaseFragment;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.sport.R;
import java.lang.ref.WeakReference;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AppealListFragment extends BaseFragment<com.huachenjie.sport.page.mine.appeallist.a> implements AppealListContact.AppealListView {
    private static final String AUDIT_STATUS = "auditStatus";
    private static final String TAG = "AppealListFragment";
    private int auditStatus;
    private AppealPageComponent mAppealPageComponent;
    private a mRecordPageListener;
    private Subscription mSearchRecordSubscription;

    public static class a implements AppealPageComponent.OnAppealListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<AppealListFragment> f36570a;

        public a(AppealListFragment appealListFragment) {
            if (appealListFragment != null) {
                this.f36570a = new WeakReference<>(appealListFragment);
            }
        }

        @Override // com.huachenjie.sport.page.mine.appeallist.AppealPageComponent.OnAppealListener
        public void a(int i) {
            AppealListFragment appealListFragment;
            WeakReference<AppealListFragment> weakReference = this.f36570a;
            if (weakReference == null || (appealListFragment = weakReference.get()) == null) {
                return;
            }
            appealListFragment.searchRecord(i);
        }
    }

    public static AppealListFragment newInstance(int i) {
        AppealListFragment appealListFragment = new AppealListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AUDIT_STATUS, i);
        appealListFragment.setArguments(bundle);
        return appealListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchRecord(int i) {
        Subscription subscription = this.mSearchRecordSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.mSearchRecordSubscription = ((com.huachenjie.sport.page.mine.appeallist.a) this.mPresenter).f(this.auditStatus, i);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public int getContentViewRes() {
        return R.layout.fragment_appeal_list;
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void getServerData() {
        this.mAppealPageComponent.p();
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void handleArguments(Bundle bundle) {
        this.auditStatus = bundle.getInt(AUDIT_STATUS);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initField() {
        this.mRecordPageListener = new a(this);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initView() {
        AppealPageComponent appealPageComponent = new AppealPageComponent(this);
        this.mAppealPageComponent = appealPageComponent;
        appealPageComponent.setOnRecordListener(this.mRecordPageListener);
        getLifecycle().addObserver(this.mAppealPageComponent);
    }

    @Override // com.huachenjie.sport.page.mine.appeallist.AppealListContact.AppealListView
    public void loadMoreAppealListSucceed(SunshineRecordListEntity sunshineRecordListEntity) {
        this.mAppealPageComponent.w(sunshineRecordListEntity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Subscription subscription = this.mSearchRecordSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.huachenjie.sport.page.mine.appeallist.AppealListContact.AppealListView
    public void queryAppealListFailed() {
        this.mAppealPageComponent.q("");
    }

    @Override // com.huachenjie.sport.page.mine.appeallist.AppealListContact.AppealListView
    public void refreshAppealListSucceed(SunshineRecordListEntity sunshineRecordListEntity) {
        this.mAppealPageComponent.z(sunshineRecordListEntity);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public com.huachenjie.sport.page.mine.appeallist.a initPresenter() {
        return new com.huachenjie.sport.page.mine.appeallist.a();
    }
}

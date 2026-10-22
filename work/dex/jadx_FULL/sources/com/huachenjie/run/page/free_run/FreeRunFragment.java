package com.huachenjie.run.page.free_run;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.baidu.location.LocationClientOption;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.BaseFragment;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.run.R;
import com.huachenjie.run.page.free_run.FreeRunFragment;
import com.huachenjie.run.utils.StopRunUtils;
import com.zj.adlib.ai9;
import com.zj.adlib.en7;
import com.zj.adlib.ew;
import com.zj.adlib.fv5;
import com.zj.adlib.kh3;
import com.zj.adlib.kq5;
import com.zj.adlib.lj0;
import com.zj.adlib.qo5;
import com.zj.adlib.r90;
import com.zj.adlib.vo6;
import com.zj.adlib.ys8;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRunFragment extends BaseFragment<b> implements FreeRunContact.FreeRunView {
    private static final String TAG = "FreeRunFragment";
    private FrameLayout mAdContainer;
    private ImageView mIvBack;
    private ImageView mIvStartRun;
    private a mLocationListener;
    private TextView mTvTargetSetting;
    private TextView mTvTip;
    private TextView mTvTotalDistanceTitle;
    private TextView mTvTotalDistanceValue;
    private RequiredSettingComponent requiredSettingComponent;

    public static class a implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<FreeRunFragment> f35861a;

        public a(FreeRunFragment fragment) {
            if (fragment != null) {
                this.f35861a = new WeakReference<>(fragment);
            }
        }

        public void onLocationListener(int code, HCJAddressInfo hcjAddressInfo) {
            FreeRunFragment freeRunFragment;
            WeakReference<FreeRunFragment> weakReference = this.f35861a;
            if (weakReference == null || (freeRunFragment = weakReference.get()) == null || freeRunFragment.isDetached()) {
                return;
            }
            Log.e(FreeRunFragment.TAG, "location code:+" + code);
            if (hcjAddressInfo != null) {
                Log.e(FreeRunFragment.TAG, "location code:+" + code + "   lat,lng:" + hcjAddressInfo.getLat() + "," + hcjAddressInfo.getLng() + "    accuracy:" + hcjAddressInfo.getAccuracy());
            }
            freeRunFragment.stopLocationOnce();
            freeRunFragment.dismissLoadingDialogs();
            if (code != 0 || hcjAddressInfo == null) {
                freeRunFragment.onLocationOnceFailed(code);
            } else {
                r90.k0(hcjAddressInfo);
                freeRunFragment.onLocationOnceSuccess();
            }
        }
    }

    private void checkLocationInvalid(HCJAddressInfo addressInfo) {
        ((b) this.mPresenter).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$haveUnFinishedRun$6(UnfinishedRun unfinishedRun) {
        StopRunUtils.o(unfinishedRun, StopRunUtils.h(unfinishedRun.getRunRecordCode()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$haveUnFinishedRun$7() {
        ARouter.getInstance().build(RoutePathConstants.Run.j).navigation();
        kq5.b(getContext(), "start_sun_run", null);
        this._mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$haveUnFinishedRun$8(UnfinishedRun unfinishedRun) {
        HashMap map = new HashMap();
        map.put("runRecordCode", unfinishedRun.getRunRecordCode());
        ((b) this.mPresenter).i(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initView$1() {
        ARouter.getInstance().build(RoutePathConstants.Run.f).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initView$2() {
        ARouter.getInstance().build(RoutePathConstants.Run.d).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(boolean z) {
        if (z) {
            syncStartRunCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4() {
        if (!vo6.a(this._mActivity)) {
            this.requiredSettingComponent.d(1);
        } else if (vo6.c(requireContext(), Permission.POST_NOTIFICATIONS)) {
            en7.e(requireContext(), new PermissionResultListener() { // from class: com.zj.adlib.hn3
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    this.f42163a.lambda$initView$3(z);
                }
            });
        } else {
            this.requiredSettingComponent.d(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(View view) {
        this.mTvTip.setVisibility(8);
    }

    private void loadAd() {
        AdPlatformSwitch adPlatformSwitchE = r90.e("rslb");
        if (adPlatformSwitchE == null || !adPlatformSwitchE.getOpenFlag()) {
            return;
        }
        ew.h().d(qo5.b, requireActivity(), getLifecycle(), this.mAdContainer, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationOnceFailed(int code) {
        fv5.b("定位失败" + code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLocationOnceSuccess() {
        checkLocationInvalid(r90.o());
    }

    private void refreshSportStatics() {
        this.mTvTotalDistanceValue.setText(BigDecimal.valueOf(ai9.g().getTotalDistance()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString());
    }

    private void startLocationOnce(long outtimeMills) {
        showLoadingDialog(false);
        if (this.mLocationListener == null) {
            this.mLocationListener = new a(this);
        }
        lj0.o(this._mActivity, false, LocationClientOption.LocationMode.Hight_Accuracy, this.mLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationOnce() {
        lj0.s(this._mActivity, false);
    }

    private void syncStartRunCheck() {
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (hCJAddressInfoO == null || System.currentTimeMillis() - hCJAddressInfoO.getTime() >= 3000) {
            startLocationOnce(10000L);
        } else {
            checkLocationInvalid(hCJAddressInfoO);
        }
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void finishRunFailed(int code, String message) {
        fv5.a(R.string.finish_run_failed_warn);
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void finishRunSucceed() {
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public int getContentViewRes() {
        return R.layout.run_fragment_free_run;
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void getServerData() {
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void handleArguments(Bundle arguments) {
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void haveUnFinishedRun(final UnfinishedRun unfinishedRun) {
        if (unfinishedRun.getSportType() == 6) {
            AlertTip alertTip = unfinishedRun.getAlertTip();
            DialogUtil.u(alertTip.getTitle(), alertTip.getContent(), "立即结束", true, true, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.en3
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    FreeRunFragment.lambda$haveUnFinishedRun$6(unfinishedRun);
                }
            }).create(this._mActivity).show();
        } else if (unfinishedRun.getSportType() == 1) {
            AlertTip alertTip2 = unfinishedRun.getAlertTip();
            DialogUtil.H(this._mActivity, alertTip2.getTitle(), alertTip2.getContent(), ys8.e(R.string.unfinish_sunshine_run_button), new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.fn3
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    this.f41712a.lambda$haveUnFinishedRun$7();
                }
            });
        } else if (unfinishedRun.getSportType() == 2) {
            DialogUtil.H(this._mActivity, ys8.e(R.string.unfinish_free_run_title), ys8.e(R.string.unfinish_free_run_content), ys8.e(R.string.unfinish_free_run_button), new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.gn3
                @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                public final void onClicked() {
                    this.f16825a.lambda$haveUnFinishedRun$8(unfinishedRun);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initView() {
        EventBus.f().v(this);
        this.mIvBack = (ImageView) f(R.id.iv_back);
        this.mTvTotalDistanceTitle = (TextView) f(R.id.total_distance_title);
        this.mTvTotalDistanceValue = (TextView) f(R.id.total_distance_value);
        this.mTvTargetSetting = (TextView) f(R.id.tv_tartget_setting);
        this.mIvStartRun = (ImageView) f(R.id.iv_start_run);
        this.mTvTip = (TextView) f(R.id.tvTip);
        this.mAdContainer = (FrameLayout) f(R.id.flFd);
        RxViewUtil.f(this.mIvBack, 100L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.zm3
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f46293a.lambda$initView$0();
            }
        });
        RxViewUtil.f(this.mTvTotalDistanceTitle, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.an3
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                FreeRunFragment.lambda$initView$1();
            }
        });
        RxViewUtil.f(this.mTvTargetSetting, 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.bn3
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                FreeRunFragment.lambda$initView$2();
            }
        });
        this.requiredSettingComponent = new RequiredSettingComponent(this);
        getLifecycle().addObserver(this.requiredSettingComponent);
        RxViewUtil.f(this.mIvStartRun, 2000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.cn3
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                this.f41003a.lambda$initView$4();
            }
        });
        this.mTvTip.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41232a.lambda$initView$5(view);
            }
        });
        refreshSportStatics();
        loadAd();
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void noUnFinishedRun() {
        ((b) this.mPresenter).h(r90.o().getLat(), r90.o().getLng(), 0L, 0L, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.f().A(this);
        super.onDestroyView();
        stopLocationOnce();
        this.mLocationListener = null;
        dismissLoadingDialogs();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(kh3 error) {
        this.mTvTip.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((b) this.mPresenter).g(3, 2);
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void queryStaticsFailed() {
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void queryStaticsSuccess() {
        refreshSportStatics();
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void startRunFailed(String message) {
    }

    @Override // com.huachenjie.run.page.free_run.FreeRunContact.FreeRunView
    public void startRunSucceed(String runRecordCode) {
        ARouter.getInstance().build(RoutePathConstants.Run.e).withString("runRecordCode", runRecordCode).navigation();
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public b initPresenter() {
        return new b();
    }
}

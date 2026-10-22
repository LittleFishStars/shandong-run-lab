package com.huachenjie.run.page.sun_run.success;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityCameraRunSuccessBinding;
import com.huachenjie.run.page.sun_run.success.CameraRunSuccessActivity;
import com.zj.adlib.ew;
import com.zj.adlib.fx7;
import com.zj.adlib.hp4;
import com.zj.adlib.i90;
import com.zj.adlib.kq5;
import com.zj.adlib.lk0;
import com.zj.adlib.r90;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/run/page/sun_run/success/CameraRunSuccessActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityCameraRunSuccessBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "initTitleBar", "b0", "f0", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "d0", "e0", "<init>", "()V", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class CameraRunSuccessActivity extends BaseMVVMActivity<RunActivityCameraRunSuccessBinding, BaseTitleViewModel> {

    @NotNull
    public static final String t = "runResultType";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/sun_run/success/CameraRunSuccessActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/page/sun_run/success/CameraRunSuccessActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CameraRunSuccessActivity.this.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sun_run/success/CameraRunSuccessActivity$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = CameraRunSuccessActivity.a0(CameraRunSuccessActivity.this).f35451a.getWidth();
            int height = CameraRunSuccessActivity.a0(CameraRunSuccessActivity.this).f35451a.getHeight();
            if (width == 0 || height == 0 || (((double) height) * 1.0d) / ((double) width) < 1.0d) {
                return;
            }
            CameraRunSuccessActivity.a0(CameraRunSuccessActivity.this).f35451a.setVisibility(8);
            CameraRunSuccessActivity.a0(CameraRunSuccessActivity.this).f35451a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sun_run/success/CameraRunSuccessActivity$d", "Lcom/huachenjie/ad/interfaces/FDAdListener;", "", "d", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends FDAdListener {
        public d() {
        }

        @Override // com.huachenjie.ad.interfaces.FDAdListener
        public void d() {
            kq5.b(CameraRunSuccessActivity.this, "BagAdLoadedSuccessful", null);
        }
    }

    public static final /* synthetic */ RunActivityCameraRunSuccessBinding a0(CameraRunSuccessActivity cameraRunSuccessActivity) {
        return cameraRunSuccessActivity.getMBinding();
    }

    public static final void c0(CameraRunSuccessActivity cameraRunSuccessActivity, View view) {
        Intrinsics.checkNotNullParameter(cameraRunSuccessActivity, "this$0");
        cameraRunSuccessActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    public final void b0() {
        ViewGroup.LayoutParams layoutParams = getMBinding().b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = fx7.j();
        getMBinding().b.setLayoutParams(layoutParams2);
    }

    public final void d0(AdPlatformSwitch adConfig) {
        getMBinding().f35451a.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        int iJ = fx7.j();
        ew.p(this, adConfig, getLifecycle(), getMBinding().f35451a, iJ, (iJ * 9) / 16, null);
    }

    public final void e0() {
        ew.f().g(hp4.b, this, getLifecycle(), getMBinding().b, new d());
    }

    public final void f0() {
        i90.l(this, getLifecycle(), null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_camera_run_success;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String str;
        super.initData();
        Intent intent = getIntent();
        boolean z = false;
        Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra(t, 0)) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            str = "跑步数据已提交，系统将进行视频人像识别分析，请耐心等待本次跑步的最终结果。";
        } else {
            str = (numValueOf != null && numValueOf.intValue() == 2) ? "跑步数据已提交，系统人脸校验结果存疑，需人工复核，三个工作日内会自动完成复核，请耐心等待跑步的最终结果。" : "";
        }
        RunActivityCameraRunSuccessBinding mBinding = getMBinding();
        TextView textView = mBinding != null ? mBinding.f11433a : null;
        if (textView != null) {
            textView.setText(str);
        }
        AdPlatformSwitch adPlatformSwitchE = r90.e("rst");
        AdPlatformSwitch adPlatformSwitchE2 = r90.e("sro");
        if (adPlatformSwitchE != null) {
            f0();
        } else {
            if (adPlatformSwitchE2 != null && adPlatformSwitchE2.getOpenFlag()) {
                d0(adPlatformSwitchE2);
            }
        }
        AdPlatformSwitch adPlatformSwitchE3 = r90.e("rslb");
        if (adPlatformSwitchE3 != null && adPlatformSwitchE3.getOpenFlag()) {
            z = true;
        }
        if (z) {
            e0();
        }
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_white);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraRunSuccessActivity.c0(this.f43948a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
        b0();
    }
}

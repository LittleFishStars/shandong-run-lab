package com.huachenjie.run.page.activities_run;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.baidu.location.LocationClientOption;
import com.google.android.exoplayer2.extractor.flv.c;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.OnLocationResultCB;
import com.huachenjie.run.page.activities_run.GPSDiagnosisActivity;
import com.ipd.dsp.internal.v1.b;
import com.zj.adlib.i62;
import com.zj.adlib.lj0;
import com.zj.adlib.lk0;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.l)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/huachenjie/run/page/activities_run/GPSDiagnosisActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/run/page/activities_run/GPSDiagnosisVM;", "Lcom/huachenjie/run/dialog/OnLocationResultCB;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initViewModel", "Landroid/os/Bundle;", "savedInstanceState", "init", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "m", "", "code", TriverEmbedVideoView.b, "onComplete", "d0", "i0", "k0", "l0", "Lcom/huachenjie/run/page/activities_run/GPSDiagnosisActivity$a;", "a", "Lcom/huachenjie/run/page/activities_run/GPSDiagnosisActivity$a;", "mLocationListener", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "K", "I", c.f2766e, "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class GPSDiagnosisActivity extends BaseVmActivity<GPSDiagnosisVM> implements OnLocationResultCB {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int times;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ValueAnimator animator;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public a mLocationListener;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/activities_run/GPSDiagnosisActivity$a;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "", "code", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "", "onLocationListener", "Ljava/lang/ref/WeakReference;", "Lcom/huachenjie/run/dialog/OnLocationResultCB;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "onLocationResultCB", "<init>", "(Lcom/huachenjie/run/dialog/OnLocationResultCB;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public WeakReference<OnLocationResultCB> weakReference;

        public a(@Nullable OnLocationResultCB onLocationResultCB) {
            this.weakReference = new WeakReference<>(onLocationResultCB);
        }

        public void onLocationListener(int code, @Nullable HCJAddressInfo hcjAddressInfo) {
            OnLocationResultCB onLocationResultCB;
            WeakReference<OnLocationResultCB> weakReference = this.weakReference;
            if (weakReference == null || (onLocationResultCB = weakReference.get()) == null) {
                return;
            }
            if (code != 0 || hcjAddressInfo == null) {
                onLocationResultCB.onError(code);
            } else {
                onLocationResultCB.m(hcjAddressInfo);
            }
            onLocationResultCB.onComplete();
        }
    }

    public static final void h0(GPSDiagnosisActivity gPSDiagnosisActivity, View view) {
        Intrinsics.checkNotNullParameter(gPSDiagnosisActivity, "this$0");
        gPSDiagnosisActivity.onBackPressed();
    }

    public static final void j0(View view, View view2, float f, float f2, float f3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$sideFront");
        Intrinsics.checkNotNullParameter(view2, "$sideAfter");
        Intrinsics.checkNotNullParameter(valueAnimator, com.ipd.dsp.internal.l.a.l);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (fFloatValue > 1.0f) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view2.setScaleX(1.0f);
            view2.setScaleY(1.0f);
            view.setAlpha(0.0f);
            view2.setAlpha(0.0f);
            view.setVisibility(8);
            view2.setVisibility(8);
            return;
        }
        if (fFloatValue > 0.0f) {
            float f4 = 1;
            float fPow = (f > 0.0f ? (float) Math.pow(fFloatValue, 2 * f) : fFloatValue) + f4;
            view2.setScaleX(fPow);
            view2.setScaleY(fPow);
            if (fFloatValue > f2) {
                float fPow2 = (f > 0.0f ? (float) Math.pow(fFloatValue - f2, 2 * f) : fFloatValue - f2) + 1.0f;
                view.setScaleX(fPow2);
                view.setScaleY(fPow2);
            }
            if (fFloatValue > f3) {
                float f5 = f4 - f3;
                float f6 = f4 - (((1.0f / f5) * fFloatValue) - (f3 / f5));
                view.setAlpha(f6);
                view2.setAlpha(f6);
            } else {
                view.setAlpha(1.0f);
                view2.setAlpha(1.0f);
            }
            view.setVisibility(0);
            view2.setVisibility(0);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void d0() {
        super.d0();
        l0();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(false).u1(R.color.transparent).G1(false).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.run_activity_gps_diagnosis), Integer.valueOf(lk0.p0), ((BaseVmActivity) this).f8507a);
    }

    public final void i0() {
        final View viewFindViewById = findViewById(R.id.v_side_after);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.v_side_after)");
        final View viewFindViewById2 = findViewById(R.id.v_side_front);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.v_side_front)");
        final float f = 0.25f;
        final float f2 = 0.5f;
        final float f3 = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f, 1.01f);
        this.animator = valueAnimatorOfFloat;
        if (valueAnimatorOfFloat != null) {
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.ur3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GPSDiagnosisActivity.j0(viewFindViewById2, viewFindViewById, f3, f, f2, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(b.C0923b.f);
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator4 = this.animator;
        if (valueAnimator4 != null) {
            valueAnimator4.setRepeatMode(1);
        }
        ValueAnimator valueAnimator5 = this.animator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        GPSDiagnosisVM gPSDiagnosisVM = (GPSDiagnosisVM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<BindingTitleBean> mutableLiveDataJ = gPSDiagnosisVM != null ? gPSDiagnosisVM.j() : null;
        if (mutableLiveDataJ != null) {
            BindingTitleBean bindingTitleBean = new BindingTitleBean();
            Integer value = ((BaseVM) ((GPSDiagnosisVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
            Intrinsics.checkNotNull(value);
            mutableLiveDataJ.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-11450269).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vr3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GPSDiagnosisActivity.h0(this.f45427a, view);
                }
            }).setTitleName("手机GPS诊断").setTitleTextColor(-1));
        }
        i0();
        k0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void k0() {
        if (this.mLocationListener == null) {
            this.mLocationListener = new a(this);
        }
        a aVar = this.mLocationListener;
        Intrinsics.checkNotNull(aVar);
        lj0.n(this, 2000L, aVar, LocationClientOption.LocationMode.Hight_Accuracy, false, 16, null);
    }

    public final void l0() {
        lj0.t(this, false, 2, null);
    }

    @Override // com.huachenjie.run.dialog.OnLocationResultCB
    public void m(@Nullable HCJAddressInfo hcjAddressInfo) {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ;
        BindingTitleBean value;
        int i = this.times + 1;
        this.times = i;
        if (i >= 5) {
            l0();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            GPSDiagnosisVM gPSDiagnosisVM = (GPSDiagnosisVM) ((BaseVmActivity) this).f8507a;
            MutableLiveData<Boolean> mutableLiveDataI = gPSDiagnosisVM != null ? gPSDiagnosisVM.i() : null;
            if (mutableLiveDataI != null) {
                mutableLiveDataI.setValue(Boolean.TRUE);
            }
            GPSDiagnosisVM gPSDiagnosisVM2 = (GPSDiagnosisVM) ((BaseVmActivity) this).f8507a;
            MutableLiveData<BindingTitleBean> mutableLiveDataJ2 = gPSDiagnosisVM2 != null ? gPSDiagnosisVM2.j() : null;
            if (mutableLiveDataJ2 != null) {
                GPSDiagnosisVM gPSDiagnosisVM3 = (GPSDiagnosisVM) ((BaseVmActivity) this).f8507a;
                mutableLiveDataJ2.setValue((gPSDiagnosisVM3 == null || (mutableLiveDataJ = gPSDiagnosisVM3.j()) == null || (value = mutableLiveDataJ.getValue()) == null) ? null : value.setTitleName("诊断结果"));
            }
            GPSDiagnosisVM gPSDiagnosisVM4 = (GPSDiagnosisVM) ((BaseVmActivity) this).f8507a;
            MutableLiveData<HCJAddressInfo> mutableLiveDataH = gPSDiagnosisVM4 != null ? gPSDiagnosisVM4.h() : null;
            if (mutableLiveDataH == null) {
                return;
            }
            mutableLiveDataH.setValue(hcjAddressInfo);
        }
    }

    @Override // com.huachenjie.run.dialog.OnLocationResultCB
    public void onComplete() {
    }

    @Override // com.huachenjie.run.dialog.OnLocationResultCB
    public void onError(int code) {
        m(new HCJAddressInfo());
    }
}

package com.huachenjie.shandong_school.splash;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.os.MessageQueue;
import android.widget.ImageView;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.databinding.ActivitySplashBinding;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ew;
import com.zj.adlib.i62;
import com.zj.adlib.kq5;
import com.zj.adlib.zn1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001fB\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "injectArouter", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "d0", "onResume", "onPause", bo.g, "q0", "initView", "u0", "n0", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "t0", "s0", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mHandler", "Lcom/huachenjie/shandong_school/splash/SplashActivity$b;", "Lcom/huachenjie/shandong_school/splash/SplashActivity$b;", "routeRunnable", "b", "adTimeoutRunnable", "", "Z", "canJump", "Landroid/os/MessageQueue$IdleHandler;", "Lkotlin/Lazy;", "o0", "()Landroid/os/MessageQueue$IdleHandler;", "idleHandler", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSplashActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashActivity.kt\ncom/huachenjie/shandong_school/splash/SplashActivity\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,287:1\n95#2,14:288\n*S KotlinDebug\n*F\n+ 1 SplashActivity.kt\ncom/huachenjie/shandong_school/splash/SplashActivity\n*L\n114#1:288,14\n*E\n"})
public final class SplashActivity extends BaseVmActivity<BaseVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f36053a = 6000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f12672a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Handler mHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public b routeRunnable;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy idleHandler = LazyKt.lazy(new SplashActivity$idleHandler$2(this));

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean canJump;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public b adTimeoutRunnable;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashActivity$a;", "", "", "DEFAULT_DELAY_AD_TIMEOUT_MILLS", "J", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashActivity$b;", "Ljava/lang/Runnable;", "", "run", "Ljava/lang/ref/WeakReference;", "Lcom/huachenjie/shandong_school/splash/SplashActivity;", "a", "Ljava/lang/ref/WeakReference;", "activityWeakReference", TTDownloadField.TT_ACTIVITY, "<init>", "(Lcom/huachenjie/shandong_school/splash/SplashActivity;)V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public WeakReference<SplashActivity> activityWeakReference;

        public b(@Nullable SplashActivity splashActivity) {
            if (splashActivity != null) {
                this.activityWeakReference = new WeakReference<>(splashActivity);
            }
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/shandong_school/splash/SplashActivity$c", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", "", "loadSupplier", "", "f", "d", "", "platform", "e", "code", "errorMsg", "c", "a", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c extends SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdPlatformSwitch f36055a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ActivitySplashBinding f12677a;

        public c(ActivitySplashBinding activitySplashBinding, AdPlatformSwitch adPlatformSwitch) {
            this.f12677a = activitySplashBinding;
            this.f36055a = adPlatformSwitch;
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void a(int loadSupplier, @Nullable String platform) {
            String advertisementPlanCode;
            HashMap map = new HashMap();
            String str = "";
            if (platform == null) {
                platform = "";
            }
            map.put("platform", platform);
            AdPlatformSwitch adPlatformSwitch = this.f36055a;
            if (adPlatformSwitch != null && (advertisementPlanCode = adPlatformSwitch.getAdvertisementPlanCode()) != null) {
                str = advertisementPlanCode;
            }
            map.put("advertisementPlanCode", str);
            if (loadSupplier == 2) {
                kq5.b(SplashActivity.this.getContext(), "lingyeAdClicked", map);
            } else {
                if (loadSupplier != 4) {
                    return;
                }
                kq5.b(SplashActivity.this.getContext(), "selfAdClick", map);
            }
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void b(int loadSupplier) {
            if (SplashActivity.this.canJump) {
                SplashActivity.this.s0();
            } else {
                SplashActivity.this.canJump = true;
            }
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void c(int loadSupplier, @Nullable String code, @Nullable String errorMsg) {
            Handler handler;
            b bVar = SplashActivity.this.adTimeoutRunnable;
            if (bVar != null && (handler = SplashActivity.this.mHandler) != null) {
                handler.removeCallbacks(bVar);
            }
            SplashActivity.this.s0();
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void d(int loadSupplier) {
            Handler handler;
            b bVar = SplashActivity.this.adTimeoutRunnable;
            if (bVar == null || (handler = SplashActivity.this.mHandler) == null) {
                return;
            }
            handler.removeCallbacks(bVar);
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void e(int loadSupplier, @Nullable String platform) {
            String advertisementPlanCode;
            ew.b(loadSupplier);
            this.f12677a.f12639a.setVisibility(8);
            this.f12677a.b.setVisibility(0);
            this.f12677a.f36025a.setBackgroundColor(zn1.a(2131101240));
            this.f12677a.f12640a.setText(ew.d(loadSupplier, platform));
            HashMap map = new HashMap();
            String str = "";
            if (platform == null) {
                platform = "";
            }
            map.put("platform", platform);
            AdPlatformSwitch adPlatformSwitch = this.f36055a;
            if (adPlatformSwitch != null && (advertisementPlanCode = adPlatformSwitch.getAdvertisementPlanCode()) != null) {
                str = advertisementPlanCode;
            }
            map.put("advertisementPlanCode", str);
            if (loadSupplier == 2) {
                kq5.b(SplashActivity.this.getContext(), "lingyeAdLoadSuccess", map);
            } else {
                if (loadSupplier != 4) {
                    return;
                }
                kq5.b(SplashActivity.this.getContext(), "selfAdExposure", map);
            }
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void f(int loadSupplier) {
            if (loadSupplier == 2) {
                kq5.b(SplashActivity.this.getContext(), "lingyeAdStartLoad", null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$4\n+ 3 SplashActivity.kt\ncom/huachenjie/shandong_school/splash/SplashActivity\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$3\n+ 5 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$2\n*L\n1#1,136:1\n99#2:137\n115#3,2:138\n98#4:140\n97#5:141\n*E\n"})
    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f36056a;

        public d(ImageView imageView) {
            this.f36056a = imageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ImageView imageView = this.f36056a;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ic_splash_logo_step2);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    public static final native void r0(SplashActivity splashActivity);

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public native void d0();

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public native void e0();

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public native i62 getDataBindingConfig();

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public native void init(@Nullable Bundle savedInstanceState);

    public final native void initView();

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void injectArouter() {
    }

    public final native void n0();

    public final native MessageQueue.IdleHandler o0();

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public native void onPause();

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public native void onResume();

    public final native void p0();

    public final native void q0();

    public final native void s0();

    public final native void t0(AdPlatformSwitch adConfig);

    public final native void u0();
}

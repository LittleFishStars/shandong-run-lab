package com.huachenjie.shandong_school.splash;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.coroutines.ViewDataBinding;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.databinding.ActivitySplashBinding;
import com.huachenjie.shandong_school.splash.SplashAdNewDialog;
import com.zj.adlib.cr2;
import com.zj.adlib.ew;
import com.zj.adlib.i62;
import com.zj.adlib.i90;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = zj7.a.SPLASH_AD_NEW)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "checkData", "showAd", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "init", "onDestroyView", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog$b;", "adTimeoutRunnable", "Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog$b;", "<init>", "()V", "Companion", "a", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class SplashAdNewDialog extends BaseVMDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_DELAY_AD_TIMEOUT_MILLS = 5000;

    @Nullable
    private b adTimeoutRunnable;

    @Nullable
    private Handler mHandler;

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.splash.SplashAdNewDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog$a;", "", "Lcom/huachenjie/shandong_school/splash/SplashAdDialog;", "a", "", "DEFAULT_DELAY_AD_TIMEOUT_MILLS", "J", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SplashAdDialog a() {
            SplashAdDialog splashAdDialog = new SplashAdDialog();
            splashAdDialog.setStyle(1, 2132018723);
            splashAdDialog.setCancelable(false);
            return splashAdDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog$b;", "Ljava/lang/Runnable;", "", "run", "Ljava/lang/ref/WeakReference;", "Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "dialog", "<init>", "(Lcom/huachenjie/shandong_school/splash/SplashAdNewDialog;)V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public WeakReference<SplashAdNewDialog> weakReference;

        public b(@Nullable SplashAdNewDialog splashAdNewDialog) {
            if (splashAdNewDialog != null) {
                this.weakReference = new WeakReference<>(splashAdNewDialog);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SplashAdNewDialog splashAdNewDialog;
            WeakReference<SplashAdNewDialog> weakReference = this.weakReference;
            if (weakReference == null || (splashAdNewDialog = weakReference.get()) == null) {
                return;
            }
            splashAdNewDialog.dismissAllowingStateLoss();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/shandong_school/splash/SplashAdNewDialog$c", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", "", "loadSupplier", "", "f", "d", "", "platform", "e", "code", "errorMsg", "c", "a", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c extends SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivitySplashBinding f36060a;

        public c(ActivitySplashBinding activitySplashBinding) {
            this.f36060a = activitySplashBinding;
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void a(int loadSupplier, @Nullable String platform) {
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void b(int loadSupplier) {
            if (SplashAdNewDialog.this.isAdded()) {
                SplashAdNewDialog.this.dismissAllowingStateLoss();
            }
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void c(int loadSupplier, @Nullable String code, @Nullable String errorMsg) {
            Handler handler;
            b bVar = SplashAdNewDialog.this.adTimeoutRunnable;
            if (bVar != null && (handler = SplashAdNewDialog.this.mHandler) != null) {
                handler.removeCallbacks(bVar);
            }
            if (SplashAdNewDialog.this.isAdded()) {
                SplashAdNewDialog.this.dismissAllowingStateLoss();
            }
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void d(int loadSupplier) {
            Handler handler;
            b bVar = SplashAdNewDialog.this.adTimeoutRunnable;
            if (bVar == null || (handler = SplashAdNewDialog.this.mHandler) == null) {
                return;
            }
            handler.removeCallbacks(bVar);
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void e(int loadSupplier, @Nullable String platform) {
            this.f36060a.f12639a.setVisibility(8);
            this.f36060a.b.setVisibility(0);
            this.f36060a.f36025a.setBackgroundColor(zn1.a(2131101240));
            this.f36060a.f12640a.setText(ew.d(loadSupplier, platform));
        }

        @Override // com.huachenjie.ad.interfaces.SplashAdListener
        public void f(int loadSupplier) {
        }
    }

    private final void checkData() {
        Handler handler = this.mHandler;
        if (handler != null) {
            b bVar = this.adTimeoutRunnable;
            Intrinsics.checkNotNull(bVar);
            handler.postDelayed(bVar, 5000L);
        }
        showAd();
    }

    @JvmStatic
    @NotNull
    public static final SplashAdDialog getInstance() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(SplashAdNewDialog splashAdNewDialog) {
        Intrinsics.checkNotNullParameter(splashAdNewDialog, "this$0");
        splashAdNewDialog.checkData();
    }

    private final void showAd() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.shandong_school.databinding.ActivitySplashBinding");
        ActivitySplashBinding activitySplashBinding = (ActivitySplashBinding) binding;
        int iC = cr2.c(requireContext(), 90.0f);
        i90.n(false, requireActivity(), getLifecycle(), activitySplashBinding.f36025a, requireContext().getResources().getDisplayMetrics().widthPixels, requireContext().getResources().getDisplayMetrics().heightPixels - iC, new c(activitySplashBinding));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_splash), 37, ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.adTimeoutRunnable = new b(this);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.zj.adlib.cn8
                @Override // java.lang.Runnable
                public final void run() {
                    SplashAdNewDialog.init$lambda$0(this.f41005a);
                }
            }, 800L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (getContext() == null) {
            Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
            Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
            return dialogOnCreateDialog;
        }
        Dialog dialog = new Dialog(requireContext(), getTheme());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setType(99);
        }
        return dialog;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.adTimeoutRunnable = null;
    }
}

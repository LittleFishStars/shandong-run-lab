package com.ltmb.ltadsdk.adx.ad.interstitial;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.api.ad.AdError;
import com.ltmb.ltadsdk.api.ad.SYInterstitialAd;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e5;
import com.ltmb.ltadsdk.pkg.j5;
import com.ltmb.ltadsdk.pkg.k5;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ad/interstitial/AdxInterstitialActivity;", "Landroid/app/Activity;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public class AdxInterstitialActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j5 f40291a;

    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        public Object invoke() {
            AdxInterstitialActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ltad_activitydialog_exit_anim);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SYInterstitialAd sYInterstitialAd;
        try {
            if (Build.VERSION.SDK_INT != 26) {
                if (!(this instanceof AdxInterstitialLandscapeActivity)) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(0);
                }
            }
            super.onCreate(bundle);
            int intExtra = getIntent().getIntExtra("get_data_key", -1);
            if (intExtra == -1) {
                finish();
                return;
            }
            e5 e5Var = e5.f;
            try {
                sYInterstitialAd = (SYInterstitialAd) e5.a.get(intExtra);
            } catch (Throwable th) {
                d9.d.a(th);
                sYInterstitialAd = null;
            }
            if (!(sYInterstitialAd instanceof k5)) {
                finish();
                return;
            }
            e5 e5Var2 = e5.f;
            try {
                e5.a.remove(intExtra);
            } catch (Throwable th2) {
                d9.d.a(th2);
            }
            Intrinsics.checkNotNullParameter(this, "context");
            this.f40291a = new j5(this, (AttributeSet) null);
            d9.d.a("interstitialView = " + this.f40291a);
            if (this.f40291a == null) {
                SYInterstitialAd sYInterstitialAd2 = (k5) sYInterstitialAd;
                AdError adError = new AdError(AdError.ERROR_INTERSTITIAL_RENDER_TEMP_NO_SUPPORT);
                sYInterstitialAd2.getClass();
                Intrinsics.checkNotNullParameter(adError, "error");
                try {
                    SYInterstitialAd.AdInteractionListener adInteractionListener = ((k5) sYInterstitialAd2).f;
                    if (adInteractionListener != null) {
                        adInteractionListener.onInterstitialAdRenderFail(sYInterstitialAd2, adError);
                    }
                } catch (Throwable th3) {
                    d9.d.a(th3);
                }
                finish();
                return;
            }
            overridePendingTransition(0, 0);
            j5 j5Var = this.f40291a;
            if (j5Var != null) {
                j5Var.setOnCloseCallback(new a());
            }
            setContentView((View) this.f40291a);
            j5 j5Var2 = this.f40291a;
            if (j5Var2 != null) {
                j5Var2.setData((k5) sYInterstitialAd);
            }
            Window window = getWindow();
            int i = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
            decorView.setSystemUiVisibility(1280);
            if (i >= 30) {
                window.setDecorFitsSystemWindows(false);
            }
            window.setBackgroundDrawableResource(android.R.color.transparent);
            window.addFlags(32);
            window.addFlags(262144);
            Window window2 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "window");
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.screenBrightness = -1.0f;
            Window window3 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window3, "window");
            window3.setAttributes(attributes);
        } catch (Throwable th4) {
            d9.d.a(th4);
            try {
                finish();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            j5 j5Var = this.f40291a;
            if (j5Var != null) {
                j5Var.b();
            }
            this.f40291a = null;
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            if (Build.VERSION.SDK_INT == 26) {
                d9.d.a("8.0 透明activity不支持设置Orientation");
            } else {
                super.setRequestedOrientation(i);
            }
        } catch (Throwable unused) {
        }
    }
}

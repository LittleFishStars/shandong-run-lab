package com.ltmb.ltadsdk.adx.ad.splash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ltmb.ltadsdk.adx.ui.view.AdxVideoView;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.y9;
import com.ltmb.ltadsdk.pkg.z9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0015\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ad/splash/view/AdxSplashVideoView;", "Landroid/widget/FrameLayout;", "", "Lcom/ltmb/ltadsdk/pkg/e;", "ad", "", "setDataSource", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnPlayStartCallback", "()Lkotlin/jvm/functions/Function0;", "setOnPlayStartCallback", "(Lkotlin/jvm/functions/Function0;)V", "onPlayStartCallback", "c", "getOnPlayCompleteCallback", "setOnPlayCompleteCallback", "onPlayCompleteCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxSplashVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdxVideoView f40295a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onPlayStartCallback;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public Function0<Unit> onPlayCompleteCallback;
    public boolean d;
    public boolean e;

    public static final class a implements y9 {
        public a() {
        }

        public void a() {
        }

        public void a(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str, "message");
        }

        public void a(long j, long j2) {
        }

        public void b() {
        }

        public void a(@NotNull z9 z9Var) {
            Function0<Unit> onPlayCompleteCallback;
            Intrinsics.checkNotNullParameter(z9Var, "state");
            if (Intrinsics.areEqual(z9Var, z9.e.a)) {
                AdxSplashVideoView adxSplashVideoView = AdxSplashVideoView.this;
                if (adxSplashVideoView.d) {
                    Function0<Unit> onPlayStartCallback = adxSplashVideoView.getOnPlayStartCallback();
                    if (onPlayStartCallback != null) {
                    }
                    AdxSplashVideoView.this.d = false;
                    return;
                }
            }
            if (!Intrinsics.areEqual(z9Var, z9.a.a) || (onPlayCompleteCallback = AdxSplashVideoView.this.getOnPlayCompleteCallback()) == null) {
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdxSplashVideoView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        AdxVideoView adxVideoView = this.f40295a;
        if (adxVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        }
        adxVideoView.setVideoListener(new a());
        AdxVideoView adxVideoView2 = this.f40295a;
        if (adxVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        }
        adxVideoView2.setVideoMute(true);
    }

    @Nullable
    public final Function0<Unit> getOnPlayCompleteCallback() {
        return this.onPlayCompleteCallback;
    }

    @Nullable
    public final Function0<Unit> getOnPlayStartCallback() {
        return this.onPlayStartCallback;
    }

    public final void setDataSource(@NotNull e ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        AdxVideoView adxVideoView = this.f40295a;
        if (adxVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        }
        adxVideoView.setDataSource(ad);
        this.e = !ad.y();
    }

    public final void setOnPlayCompleteCallback(@Nullable Function0<Unit> function0) {
        this.onPlayCompleteCallback = function0;
    }

    public final void setOnPlayStartCallback(@Nullable Function0<Unit> function0) {
        this.onPlayStartCallback = function0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdxSplashVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxSplashVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = true;
        this.e = true;
        this.f40295a = new AdxVideoView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        AdxVideoView adxVideoView = this.f40295a;
        if (adxVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
        }
        addView(adxVideoView, layoutParams);
        a();
    }
}

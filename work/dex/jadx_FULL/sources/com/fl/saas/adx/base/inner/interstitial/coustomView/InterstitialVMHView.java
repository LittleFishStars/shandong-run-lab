package com.fl.saas.adx.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialVMHView implements InnerNativeCustomView {
    private final TextView CATView;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final FrameLayout fl_media;
    private final ImageView logoIcon;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialVMHView(Context context) {
        this.mContext = context;
        View viewInflate = ViewHelper.inflate(context, R.layout.fl_adx_interstitial_v_material_h);
        this.adView = viewInflate;
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_media);
        this.fl_media = frameLayout;
        this.logoIcon = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitia_icon);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_interstitial_media_container);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitial);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_desc);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_btn);
        FLImageLoader.getInstance(context).loadBitmap("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp", new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.zj.adlib.xe4
            @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
            public final void onSuccess(String str, Bitmap bitmap, boolean z) {
                this.f45806a.lambda$new$0(str, bitmap, z);
            }
        });
        frameLayout.post(new Runnable() { // from class: com.zj.adlib.ze4
            @Override // java.lang.Runnable
            public final void run() {
                this.f46248a.lambda$new$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$5(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str, Bitmap bitmap, boolean z) {
        Drawable drawableA = AbstractC1398a0.a(this.mContext, bitmap);
        if (drawableA != null) {
            this.adView.setBackground(drawableA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        int width = (this.fl_media.getWidth() * 9) / 16;
        if (width > 0) {
            this.fl_media.getLayoutParams().height = width;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        if (this.mediaContainer.getVisibility() == 0) {
            this.mainImageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(Drawable drawable) {
        final Bitmap bitmapA = AbstractC1398a0.a(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.ff4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16516a.lambda$setMediaView$2(bitmapA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$4(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.gf4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16753a.lambda$setMediaView$3(drawable);
            }
        });
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getCATView() {
        return this.CATView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public B loadIcon() {
        return new B() { // from class: com.zj.adlib.bf4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f40738a.lambda$loadIcon$5((Bitmap) obj);
            }
        };
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable final Drawable drawable) {
        this.bgView.setVisibility(drawable == null ? 8 : 0);
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round(((InterstitialViewHelper.getInterstitialSize().first.intValue() - (DeviceUtil.dip2px(15.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            } else {
                this.mainImageView.setVisibility(8);
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
            if (drawable instanceof BitmapDrawable) {
                this.bgView.post(new Runnable() { // from class: com.zj.adlib.df4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15984a.lambda$setMediaView$4(drawable);
                    }
                });
            }
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}

package com.fl.saas.adx.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeAdLogo;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialVMVView implements InnerNativeCustomView, InnerNativeAdLogo {
    private final TextView CATView;
    private final ImageView adLogo;
    private final View adView;
    private final ImageView bgView;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final View textContent;
    private final TextView titleView;

    public InterstitialVMVView(Context context) {
        View viewInflate = ViewHelper.inflate(context, R.layout.fl_adx_interstitial_v_material_v);
        this.adView = viewInflate;
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_vertical_title);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_vertical_btn);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_img);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_video);
        this.adLogo = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_adlogo);
        this.textContent = viewInflate.findViewById(R.id.rl_yd_saas_custom_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapA = AbstractC1398a0.a(DeviceUtil.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        if (bitmapA != null) {
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.if4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17206a.lambda$setMediaView$0(bitmapA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.kf4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17673a.lambda$setMediaView$1(drawable);
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
        return null;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        this.adLogo.setImageBitmap(bitmap);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable final Drawable drawable) {
        ImageView imageView = this.bgView;
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            imageView.post(new Runnable() { // from class: com.zj.adlib.mf4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18186a.lambda$setMediaView$2(drawable);
                }
            });
        }
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view, ViewHelper.getMatchParent());
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        if (!TextUtils.isEmpty(str)) {
            this.textContent.setVisibility(0);
        }
        return this;
    }
}

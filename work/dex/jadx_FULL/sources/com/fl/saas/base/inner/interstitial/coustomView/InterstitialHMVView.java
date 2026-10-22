package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialHMVView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final View adView;
    private final TextView desView;
    private final ImageView logoIcon;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMVView(Context context) {
        View viewInflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_h_material_v);
        this.adView = viewInflate;
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.yd_saas_interstitial_img);
        this.logoIcon = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_interstitial_icon);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_interstitial_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_interstitial_des);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_interstitial_cta);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_interstitial_media_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$2(View view) {
        FrameLayout.LayoutParams layoutParams;
        int width = this.mainImageView.getWidth();
        int height = this.mainImageView.getHeight();
        if (width <= 0 || height <= 0) {
            view.setScaleY(0.8f);
            view.setScaleX(0.8f);
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, DeviceUtil.dip2px(20.0f));
        } else {
            int[] iArrSelfMeasure = ViewHelper.selfMeasure(view);
            int i = iArrSelfMeasure[0];
            int i2 = iArrSelfMeasure[1];
            int iDip2px = DeviceUtil.dip2px(10.0f);
            int iMin = Math.min(width - (iDip2px * 6), Math.round((width * 5) / 8.0f));
            int i3 = height - (iDip2px * 10);
            if (iMin < i || i3 < i2) {
                float f = i2;
                view.setPivotY(f);
                float f2 = i;
                view.setPivotX(f2 / 2.0f);
                float fMin = Math.min(iMin / f2, i3 / f);
                view.setScaleY(fMin);
                view.setScaleX(fMin);
            }
            layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, iDip2px * 2);
        }
        ((FrameLayout) this.adView.findViewById(R.id.yd_saas_interstitial_container)).addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$1(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Drawable drawable) {
        ImageUtils.setBlurImage(this.mainImageView, drawable);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(final View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new Runnable() { // from class: com.zj.adlib.pe4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18826a.lambda$bindActionView$2(view);
            }
        });
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getCATView() {
        return this.CATView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public Consumer<Bitmap> loadIcon() {
        return new Consumer() { // from class: com.zj.adlib.ne4
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f43507a.lambda$loadIcon$1((Bitmap) obj);
            }
        };
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable final Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round((Math.round((InterstitialViewHelper.getInterstitialSize().first.intValue() * 5) / 9) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
                this.mediaContainer.post(new Runnable() { // from class: com.zj.adlib.re4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19276a.lambda$setMediaView$0(drawable);
                    }
                });
            } else {
                this.mainImageView.setVisibility(8);
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}

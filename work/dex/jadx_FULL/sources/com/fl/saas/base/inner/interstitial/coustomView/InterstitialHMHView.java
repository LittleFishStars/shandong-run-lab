package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialHMHView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final RelativeLayout adView;
    private final TextView desView;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMHView(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) ViewHelper.inflate(context, R.layout.yd_saas_interstitial_h_material_h);
        this.adView = relativeLayout;
        this.mainImageView = (ImageView) relativeLayout.findViewById(R.id.yd_saas_interstitial_img);
        this.mediaContainer = (FrameLayout) relativeLayout.findViewById(R.id.yd_saas_interstitial_media_container);
        this.titleView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_title);
        this.desView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_des);
        this.CATView = (TextView) relativeLayout.findViewById(R.id.tv_yd_saas_interstitial_cta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$0(View view) {
        ViewGroup.LayoutParams layoutParams;
        int width = this.mainImageView.getWidth();
        int height = this.mainImageView.getHeight();
        if (width <= 0 || height <= 0) {
            view.setScaleY(0.8f);
            view.setScaleX(0.8f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams = layoutParams2;
        } else {
            int[] iArrSelfMeasure = ViewHelper.selfMeasure(view);
            int i = iArrSelfMeasure[0];
            int i2 = iArrSelfMeasure[1];
            int iDip2px = DeviceUtil.dip2px(10.0f);
            int i3 = width - (iDip2px * 10);
            int iMin = Math.min(height - (iDip2px * 5), Math.round(width / 3.0f));
            if (i3 < i || iMin < i2) {
                float f = i2;
                view.setPivotY(f);
                float f2 = i;
                view.setPivotX(f2 / 2.0f);
                float fMin = Math.min(i3 / f2, iMin / f);
                view.setScaleY(fMin);
                view.setScaleX(fMin);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i2);
            layoutParams3.addRule(6);
            layoutParams3.addRule(14);
            layoutParams3.setMargins(0, (height - iDip2px) - i2, 0, 0);
            layoutParams = layoutParams3;
        }
        this.adView.addView(view, layoutParams);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(final View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new Runnable() { // from class: com.zj.adlib.he4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16975a.lambda$bindActionView$0(view);
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
        return null;
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
    public InnerNativeCustomView setMediaView(View view, @Nullable Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round((InterstitialViewHelper.getInterstitialSize().first.intValue() * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
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

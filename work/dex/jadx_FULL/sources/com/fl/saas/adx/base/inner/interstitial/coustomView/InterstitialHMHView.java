package com.fl.saas.adx.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.base.innterNative.BindActionView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialHMHView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final RelativeLayout adView;
    private final ImageView bgView;
    private final TextView desView;
    private final FrameLayout fl_top;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMHView(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) ViewHelper.inflate(context, R.layout.fl_adx_interstitial_h_material_h);
        this.adView = relativeLayout;
        FrameLayout frameLayout = (FrameLayout) relativeLayout.findViewById(R.id.fl_top);
        this.fl_top = frameLayout;
        this.bgView = (ImageView) relativeLayout.findViewById(R.id.yd_saas_view_background);
        this.mainImageView = (ImageView) relativeLayout.findViewById(R.id.fl_saas_interstitial_img);
        this.mediaContainer = (FrameLayout) relativeLayout.findViewById(R.id.fl_saas_interstitial_media_container);
        this.titleView = (TextView) relativeLayout.findViewById(R.id.tv_fl_saas_interstitial_title);
        this.desView = (TextView) relativeLayout.findViewById(R.id.tv_fl_saas_interstitial_des);
        this.CATView = (TextView) relativeLayout.findViewById(R.id.tv_fl_saas_interstitial_cta);
        frameLayout.post(new Runnable() { // from class: com.zj.adlib.me4
            @Override // java.lang.Runnable
            public final void run() {
                this.f43280a.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$4(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        int width = (this.fl_top.getWidth() * 9) / 16;
        if (width > 0) {
            this.fl_top.getLayoutParams().height = width;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        final Bitmap bitmapA = AbstractC1398a0.a(DeviceUtil.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        if (bitmapA != null) {
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.je4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17378a.lambda$setMediaView$1(bitmapA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.ke4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17668a.lambda$setMediaView$2(drawable);
            }
        });
    }

    @Override // com.fl.saas.adx.base.innterNative.BindActionView
    public void bindActionView(final View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new Runnable() { // from class: com.zj.adlib.ie4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17203a.lambda$bindActionView$4(view);
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
        ImageView imageView = this.bgView;
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            imageView.post(new Runnable() { // from class: com.zj.adlib.le4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17926a.lambda$setMediaView$3(drawable);
                }
            });
        }
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view);
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
        return this;
    }
}

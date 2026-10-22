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
import com.fl.saas.adx.base.innterNative.BindActionView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialHMVView implements InnerNativeCustomView, BindActionView {
    private final TextView CATView;
    private final FrameLayout actionContainer;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final ImageView logoIcon;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialHMVView(Context context) {
        View viewInflate = ViewHelper.inflate(context, R.layout.fl_adx_interstitial_h_material_v);
        this.adView = viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_saas_interstitial_container);
        this.actionContainer = frameLayout;
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.fl_saas_interstitial_img);
        this.logoIcon = (ImageView) viewInflate.findViewById(R.id.iv_fl_saas_interstitial_icon);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_fl_saas_interstitial_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_fl_saas_interstitial_des);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_fl_saas_interstitial_cta);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.fl_saas_interstitial_media_container);
        frameLayout.post(new Runnable() { // from class: com.zj.adlib.qe4
            @Override // java.lang.Runnable
            public final void run() {
                this.f44190a.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindActionView$5(View view) {
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
        this.actionContainer.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$4(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        int width = (this.actionContainer.getWidth() * 16) / 9;
        if (width > 0) {
            this.actionContainer.getLayoutParams().height = width;
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
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.oe4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18624a.lambda$setMediaView$1(bitmapA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.ve4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20210a.lambda$setMediaView$2(drawable);
            }
        });
    }

    @Override // com.fl.saas.adx.base.innterNative.BindActionView
    public void bindActionView(final View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        this.mainImageView.post(new Runnable() { // from class: com.zj.adlib.ue4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20049a.lambda$bindActionView$5(view);
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
        return new B() { // from class: com.zj.adlib.se4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f44670a.lambda$loadIcon$4((Bitmap) obj);
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
        ImageView imageView = this.bgView;
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            imageView.post(new Runnable() { // from class: com.zj.adlib.te4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19783a.lambda$setMediaView$3(drawable);
                }
            });
        }
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view);
            this.mainImageView.setVisibility(8);
            this.mediaContainer.setVisibility(0);
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

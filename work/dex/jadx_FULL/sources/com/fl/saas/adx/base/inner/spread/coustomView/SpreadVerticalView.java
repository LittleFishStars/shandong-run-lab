package com.fl.saas.adx.base.inner.spread.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SpreadVerticalView implements InnerNativeCustomView {
    private final FrameLayout adView;
    private final ImageView bgView;
    private final Context mContext;
    private final ImageView mainImageView;

    public SpreadVerticalView(Context context) {
        this.mContext = context;
        FrameLayout frameLayout = (FrameLayout) ViewHelper.inflate(context, R.layout.fl_adx_spread_material_vertical);
        this.adView = frameLayout;
        this.mainImageView = (ImageView) frameLayout.findViewById(R.id.iv_yd_saas_custom_spread_vertical_img);
        this.bgView = (ImageView) frameLayout.findViewById(R.id.yd_saas_view_background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapA = AbstractC1398a0.a(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.io8
            @Override // java.lang.Runnable
            public final void run() {
                this.f17248a.lambda$setMediaView$0(bitmapA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.eo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f16371a.lambda$setMediaView$1(drawable);
            }
        });
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getCATView() {
        return null;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public B loadIcon() {
        return null;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, final Drawable drawable) {
        ImageView imageView;
        int i;
        if (view == null) {
            if (drawable != null) {
                ImageView.ScaleType scaleType = DeviceUtil.scaleType;
                if (scaleType != null) {
                    this.mainImageView.setScaleType(scaleType);
                    if (drawable instanceof BitmapDrawable) {
                        this.adView.post(new Runnable() { // from class: com.zj.adlib.go8
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f16833a.lambda$setMediaView$2(drawable);
                            }
                        });
                    }
                }
                this.mainImageView.setImageDrawable(drawable);
                imageView = this.mainImageView;
                i = 0;
            }
            return this;
        }
        this.adView.removeAllViews();
        this.adView.addView(view, ViewHelper.getMatchParent());
        imageView = this.mainImageView;
        i = 8;
        imageView.setVisibility(i);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        return this;
    }
}

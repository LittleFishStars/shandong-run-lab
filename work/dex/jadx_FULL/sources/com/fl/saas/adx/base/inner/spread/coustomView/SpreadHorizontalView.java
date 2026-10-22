package com.fl.saas.adx.base.inner.spread.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SpreadHorizontalView implements InnerNativeCustomView {
    private final TextView CATView;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final ImageView iconView;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final RatingBar reserveView;
    private final TextView titleView;

    public SpreadHorizontalView(Context context) {
        this.mContext = context;
        View viewInflate = ViewHelper.inflate(context, R.layout.fl_adx_spread_material_horizontal);
        this.adView = viewInflate;
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_desc);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_btn);
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.iconView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_spread_icon);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_spread);
        this.reserveView = (RatingBar) viewInflate.findViewById(R.id.rb_yd_saas_custom_spread_icon_reserve);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_spread_media_container);
        FLImageLoader.getInstance(context).loadBitmap("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp", new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.adx.base.inner.spread.coustomView.SpreadHorizontalView.1
            @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
            public void onSuccess(String str, Bitmap bitmap, boolean z) {
                try {
                    Drawable drawableA = AbstractC1398a0.a(SpreadHorizontalView.this.mContext, bitmap);
                    if (drawableA == null || SpreadHorizontalView.this.adView == null) {
                        return;
                    }
                    SpreadHorizontalView.this.adView.setBackground(drawableA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$3(Bitmap bitmap) {
        if (bitmap == null) {
            this.iconView.setVisibility(8);
            this.reserveView.setVisibility(0);
        } else {
            this.iconView.setImageBitmap(bitmap);
            this.iconView.setVisibility(0);
            this.reserveView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapA = AbstractC1398a0.a(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.bo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f15606a.lambda$setMediaView$0(bitmapA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.zn8
            @Override // java.lang.Runnable
            public final void run() {
                this.f21095a.lambda$setMediaView$1(drawable);
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
        return new B() { // from class: com.zj.adlib.xn8
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f45856a.lambda$loadIcon$3((Bitmap) obj);
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
    public InnerNativeCustomView setMediaView(View view, final Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round(((DeviceUtil.getMobileWidth() - (DeviceUtil.dip2px(25.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
        }
        if (drawable instanceof BitmapDrawable) {
            this.adView.post(new Runnable() { // from class: com.zj.adlib.vn8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20260a.lambda$setMediaView$2(drawable);
                }
            });
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}

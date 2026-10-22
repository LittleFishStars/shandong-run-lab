package com.fl.saas.base.inner.spread.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

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
        View viewInflate = ViewHelper.inflate(context, R.layout.yd_saas_spread_material_horizontal);
        this.adView = viewInflate;
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_desc);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_spread_btn);
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.iconView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_spread_icon);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_spread);
        this.reserveView = (RatingBar) viewInflate.findViewById(R.id.rb_yd_saas_custom_spread_icon_reserve);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_spread_media_container);
        ImageLoader.loadImageBitmap("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp", new Consumer() { // from class: com.zj.adlib.ao8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f40570a.lambda$new$0((Bitmap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$4(Bitmap bitmap) {
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
    public /* synthetic */ void lambda$new$0(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.adView.setBackground(new BitmapDrawable(this.mContext.getResources(), bitmap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        final Bitmap bitmapRsBlur = ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.co8
            @Override // java.lang.Runnable
            public final void run() {
                this.f15866a.lambda$setMediaView$1(bitmapRsBlur);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(final Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.yn8
            @Override // java.lang.Runnable
            public final void run() {
                this.f20911a.lambda$setMediaView$2(drawable);
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
        return new Consumer() { // from class: com.zj.adlib.un8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f45188a.lambda$loadIcon$4((Bitmap) obj);
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
    public InnerNativeCustomView setMediaView(View view, final Drawable drawable) {
        if (view != null) {
            ViewHelper.removeParent(view);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round(((DeviceUtil.getMobileWidth() - (DeviceUtil.dip2px(25.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        }
        if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mainImageView.setVisibility(0);
        }
        if (drawable instanceof BitmapDrawable) {
            this.adView.post(new Runnable() { // from class: com.zj.adlib.wn8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20473a.lambda$setMediaView$3(drawable);
                }
            });
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}

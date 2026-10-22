package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialFullScreenView implements InnerNativeCustomView, InnerNativeAdLogo, BindActionView {
    private final TextView CATView;
    private final ImageView adLogo;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final FrameLayout fl_horizontal;
    private final FrameLayout fl_vertical;
    private final ImageView iv_sound_control;
    private final ImageView logoIcon;
    private final NativeMaterial mMaterial;
    private final ImageView mainImageView;
    private final ImageView mainImageViewVertical;
    private final FrameLayout mediaContainer;
    private final FrameLayout mediaContainerVertical;
    private final TextView titleView;

    public InterstitialFullScreenView(Context context, NativeMaterial nativeMaterial) {
        this.mMaterial = nativeMaterial;
        View viewInflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_fullscreen);
        this.adView = viewInflate;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.bgView = imageView;
        this.logoIcon = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitia_icon);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_interstitial_media_container);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitial);
        this.fl_horizontal = (FrameLayout) viewInflate.findViewById(R.id.fl_yd_saas_horizontal_container);
        this.mediaContainerVertical = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_vertical_interstitial_media_container);
        this.mainImageViewVertical = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_interstitial);
        this.fl_vertical = (FrameLayout) viewInflate.findViewById(R.id.fl_yd_saas_vertical_container);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_desc);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_btn);
        this.adLogo = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_adlogo);
        this.iv_sound_control = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_media_sound);
        ImageLoader.loadImage("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp", imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$6(Bitmap bitmap) {
        ImageView imageView = this.logoIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.logoIcon.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapRsBlur = ImageUtils.rsBlur(DeviceUtil.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        if (bitmapRsBlur != null) {
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.ud4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20040a.lambda$setMediaView$0(bitmapRsBlur);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.wd4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20421a.lambda$setMediaView$1(drawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(int i, int i2, FrameLayout.LayoutParams layoutParams, View view) {
        layoutParams.width = (int) (((double) this.fl_vertical.getHeight()) * (((double) i) / ((double) i2)));
        this.mediaContainerVertical.removeAllViews();
        this.mediaContainerVertical.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$4(boolean z) {
        this.iv_sound_control.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$5(VideoSoundControlListener videoSoundControlListener, View view) {
        boolean z = !videoSoundControlListener.getSoundEnable();
        this.iv_sound_control.setImageResource(z ? R.drawable.yd_saas_volume_on : R.drawable.yd_saas_volume_off);
        videoSoundControlListener.changeSoundEnable(z);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002a  */
    private void showHorizontalMedia(View view, Size size) {
        double d;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.fl_horizontal.setVisibility(0);
        this.fl_vertical.setVisibility(8);
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (size != null) {
            int width = size.getWidth();
            int height = size.getHeight();
            if (width <= 0 || height <= 0) {
                d = 0.5625d;
            } else {
                d = ((double) height) / ((double) width);
            }
        } else {
            d = 0.5625d;
        }
        layoutParams.height = (int) (((double) mobileWidth) * d);
        this.mediaContainer.removeAllViews();
        this.mediaContainer.addView(view, layoutParams);
    }

    @Override // com.fl.saas.base.innterNative.BindActionView
    public void bindActionView(View view) {
        if (view == null) {
            return;
        }
        ViewHelper.removeParent(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ((RelativeLayout) this.adView.findViewById(R.id.yd_saas_interstitial_container)).addView(view, layoutParams);
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
        return new Consumer() { // from class: com.zj.adlib.yd4
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f46004a.lambda$loadIcon$6((Bitmap) obj);
            }
        };
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        ImageView imageView = this.adLogo;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
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

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:25:0x007c  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(final View view, @Nullable final Drawable drawable) {
        ImageView imageView;
        Size size;
        final VideoSoundControlListener videoSoundControlListener;
        ImageView imageView2;
        boolean soundEnable;
        int i;
        ImageView imageView3 = this.bgView;
        if (imageView3 != null && (drawable instanceof BitmapDrawable)) {
            imageView3.post(new Runnable() { // from class: com.zj.adlib.ae4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15259a.lambda$setMediaView$2(drawable);
                }
            });
        }
        if (view != 0) {
            NativeMaterial nativeMaterial = this.mMaterial;
            if (nativeMaterial == null || nativeMaterial.getSize() == null) {
                size = null;
            } else {
                final int width = this.mMaterial.getSize().getWidth();
                final int height = this.mMaterial.getSize().getHeight();
                if (height > width) {
                    final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                    this.fl_horizontal.setVisibility(8);
                    this.fl_vertical.setVisibility(0);
                    this.fl_vertical.post(new Runnable() { // from class: com.zj.adlib.ce4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f15806a.lambda$setMediaView$3(width, height, layoutParams, view);
                        }
                    });
                } else {
                    size = this.mMaterial.getSize();
                }
                if (view instanceof VideoSoundControlListener) {
                    videoSoundControlListener = (VideoSoundControlListener) view;
                    imageView2 = this.iv_sound_control;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                        videoSoundControlListener.setSoundControlViewStateChangeListener(new VideoSoundControlListener.SoundControlViewStateChangeListener() { // from class: com.zj.adlib.ee4
                            @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener.SoundControlViewStateChangeListener
                            public final void changeViewVisible(boolean z) {
                                this.f41415a.lambda$setMediaView$4(z);
                            }
                        });
                        soundEnable = videoSoundControlListener.getSoundEnable();
                        ImageView imageView4 = this.iv_sound_control;
                        if (soundEnable) {
                            i = R.drawable.yd_saas_volume_on;
                        } else {
                            i = R.drawable.yd_saas_volume_off;
                        }
                        imageView4.setImageResource(i);
                        this.iv_sound_control.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ge4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                this.f41882a.lambda$setMediaView$5(videoSoundControlListener, view2);
                            }
                        });
                    }
                }
            }
            showHorizontalMedia(view, size);
            if (view instanceof VideoSoundControlListener) {
                videoSoundControlListener = (VideoSoundControlListener) view;
                imageView2 = this.iv_sound_control;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    videoSoundControlListener.setSoundControlViewStateChangeListener(new VideoSoundControlListener.SoundControlViewStateChangeListener() { // from class: com.zj.adlib.ee4
                        @Override // com.fl.saas.base.inner.interstitial.coustomView.VideoSoundControlListener.SoundControlViewStateChangeListener
                        public final void changeViewVisible(boolean z) {
                            this.f41415a.lambda$setMediaView$4(z);
                        }
                    });
                    soundEnable = videoSoundControlListener.getSoundEnable();
                    ImageView imageView5 = this.iv_sound_control;
                    if (soundEnable) {
                        i = R.drawable.yd_saas_volume_on;
                    } else {
                        i = R.drawable.yd_saas_volume_off;
                    }
                    imageView5.setImageResource(i);
                    this.iv_sound_control.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ge4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f41882a.lambda$setMediaView$5(videoSoundControlListener, view2);
                        }
                    });
                }
            }
        } else if (drawable != null) {
            if (drawable.getIntrinsicWidth() < drawable.getIntrinsicHeight()) {
                this.fl_vertical.setVisibility(0);
                this.fl_horizontal.setVisibility(8);
                imageView = this.mainImageViewVertical;
            } else {
                this.fl_vertical.setVisibility(8);
                this.fl_horizontal.setVisibility(0);
                imageView = this.mainImageView;
            }
            imageView.setImageDrawable(drawable);
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}

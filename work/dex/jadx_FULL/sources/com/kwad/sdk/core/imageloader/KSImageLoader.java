package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ai;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    private static OnRenderResultListener<AdTemplate> mDefaultListener;

    /* JADX INFO: renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.IO_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class InnerImageLoadingListener implements ImageLoadingListener {
        public static final int MAX_DURATION = 30000;

        @Nullable
        AdTemplate adTemplate;

        @Nullable
        ImageLoadingListener loadingListener;
        private long startTime;

        public InnerImageLoadingListener(@Nullable AdTemplate adTemplate, @Nullable ImageLoadingListener imageLoadingListener) {
            this.adTemplate = adTemplate;
            this.loadingListener = imageLoadingListener;
        }

        private long getDuration(long j) {
            if (j == 0) {
                return -1L;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (jElapsedRealtime >= 30000) {
                return -1L;
            }
            return jElapsedRealtime;
        }

        private void recordDuration(long j) {
            try {
                long duration = getDuration(j);
                if (duration >= 0) {
                    ai.bf(duration);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                return imageLoadingListener.onDecode(str, inputStream, decodedResult);
            }
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(str, view, decodedResult);
            }
            recordDuration(this.startTime);
            ai.Vx();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view, failReason);
            }
            if (this.adTemplate != null) {
                StringBuilder sb = new StringBuilder("ImageLoader:");
                if (failReason != null) {
                    Throwable cause = failReason.getCause();
                    if (cause == null || cause.getStackTrace().length <= 0) {
                        str2 = "";
                    } else {
                        str2 = cause.getMessage() + " @ " + cause.getStackTrace()[0].getFileName() + cause.getStackTrace()[0].getClassName() + cause.getStackTrace()[0].getLineNumber();
                    }
                    int i = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failReason.getType().ordinal()];
                    if (i == 1) {
                        sb.append("UNKNOWN");
                    } else if (i == 2) {
                        sb.append("IO_ERROR");
                        sb.append(str2);
                    } else if (i == 3) {
                        sb.append("OUT_OF_MEMORY");
                    } else if (i == 4) {
                        sb.append("NETWORK_DENIED");
                    } else if (i == 5) {
                        sb.append("DECODING_ERROR");
                    }
                }
                if (KSImageLoader.getGlobalImageListener() != null) {
                    KSImageLoader.getGlobalImageListener().onRenderResult(false, this.adTemplate, str, sb.toString());
                }
            }
            ai.Vy();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
            this.startTime = SystemClock.elapsedRealtime();
            ai.Vw();
        }
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i) {
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCopy = config == config2 ? bitmap : bitmap.copy(config2, true);
            if (bitmapCopy == null) {
                bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCopy.getWidth(), bitmapCopy.getHeight(), bitmapCopy.getConfig());
            RenderScript renderScriptCreate = RenderScript.create(context);
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(i);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
            allocationCreateFromBitmap.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static void clearMemory() {
        ImageLoaderProxy.INSTANCE.clearMemory(((f) ServiceProvider.get(f.class)).getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OnRenderResultListener<AdTemplate> getGlobalImageListener() {
        if (mDefaultListener == null) {
            mDefaultListener = new GlobalImageListener();
        }
        return mDefaultListener;
    }

    private static Context getSDKContext() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            return fVar.getContext();
        }
        return null;
    }

    public static boolean isImageExist(String str) {
        File fileIsImageExistOnDisk;
        return !TextUtils.isEmpty(str) && (fileIsImageExistOnDisk = ImageLoaderProxy.INSTANCE.isImageExistOnDisk(str)) != null && fileIsImageExistOnDisk.exists() && fileIsImageExistOnDisk.length() > 0;
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i2 = R.drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i2)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i2)).showImageOnFail(imageView.getContext().getResources().getDrawable(i2)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(i).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCircle(true).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadFeeImage(imageView, str, adTemplate, null);
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static Bitmap loadImageSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ImageLoaderProxy.INSTANCE.loadImageSync(str);
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i2 = R.drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i2)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i2)).showImageOnFail(imageView.getContext().getResources().getDrawable(i2)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void pause() {
        ImageLoaderProxy.INSTANCE.pause();
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
    }

    public static void resume() {
        ImageLoaderProxy.INSTANCE.resume();
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener) {
        if (imageView == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(((f) ServiceProvider.get(f.class)).getContext(), str, imageView, IMGOPTION_NORMAL, imageLoadingListener);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(((f) ServiceProvider.get(f.class)).getContext(), str, imageView, displayImageOptionsCompat, (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str) {
        loadImage(imageView, str, (AdTemplate) null, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }
}

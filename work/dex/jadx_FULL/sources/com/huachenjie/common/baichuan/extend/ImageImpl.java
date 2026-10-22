package com.huachenjie.common.baichuan.extend;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.facebook.cache.common.CacheKey;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.zj.adlib.ad3;
import com.zj.adlib.ax6;
import com.zj.adlib.jg8;
import com.zj.adlib.on3;
import com.zj.adlib.rm1;
import com.zj.adlib.sm1;
import com.zj.adlib.uf9;
import com.zj.adlib.un0;
import com.zj.adlib.x64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ImageImpl implements IImageProxy {

    public class a extends un0<ImageInfo> {
        public a() {
        }

        @Override // com.zj.adlib.un0, com.facebook.drawee.controller.ControllerListener
        public void e(String id, Throwable throwable) {
            ad3.t(getClass(), throwable, "Error loading %s", id);
        }

        @Override // com.zj.adlib.un0, com.facebook.drawee.controller.ControllerListener
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void a(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
            if (imageInfo == null) {
                return;
            }
            QualityInfo qualityInfoG = imageInfo.g();
            ad3.o("Final image received! Size %d x %d", "Quality level %d, good enough: %s, full quality: %s", Integer.valueOf(imageInfo.getWidth()), Integer.valueOf(imageInfo.getHeight()), Integer.valueOf(qualityInfoG.b()), Boolean.valueOf(qualityInfoG.a()), Boolean.valueOf(qualityInfoG.c()));
        }

        @Override // com.zj.adlib.un0, com.facebook.drawee.controller.ControllerListener
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void f(String id, @Nullable ImageInfo imageInfo) {
            ad3.i("", "Intermediate image received");
        }
    }

    public class b extends BaseDataSubscriber<rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f33631a;

        public b(final ImageView val$view) {
            this.f33631a = val$view;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<rm1<CloseableImage>> dataSource) {
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<rm1<CloseableImage>> dataSource) {
            rm1<CloseableImage> result = dataSource.getResult();
            if (result != null) {
                try {
                    ax6.o(rm1.F(result));
                    CloseableImage closeableImageS = result.s();
                    if (closeableImageS instanceof sm1) {
                        this.f33631a.setImageBitmap(((sm1) closeableImageS).k());
                        result.close();
                    } else {
                        throw new UnsupportedOperationException("Unrecognized image class: " + closeableImageS);
                    }
                } catch (Throwable th) {
                    result.close();
                    throw th;
                }
            }
        }
    }

    public class c implements Postprocessor {
        public c() {
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public rm1<Bitmap> a(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
            rm1<Bitmap> rm1VarA = bitmapFactory.a(sourceBitmap.getWidth(), sourceBitmap.getHeight());
            try {
                Bitmap bitmapS = rm1VarA.s();
                new Canvas(bitmapS).drawBitmap(sourceBitmap, (Rect) null, new Rect(0, 0, bitmapS.getWidth(), bitmapS.getHeight()), new Paint());
                return rm1.l(rm1VarA);
            } finally {
                rm1.p(rm1VarA);
            }
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public CacheKey b() {
            return new jg8("BlurTransformation(radius=)");
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public String getName() {
            return "BlurTransformation(radius=)";
        }
    }

    public class d extends BaseDataSubscriber<rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IImageProxy.ImageListener f33633a;

        public d(final IImageProxy.ImageListener val$imageListener) {
            this.f33633a = val$imageListener;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<rm1<CloseableImage>> dataSource) {
            Log.w("TAG", "fail");
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<rm1<CloseableImage>> dataSource) {
            rm1<CloseableImage> result = dataSource.getResult();
            if (result != null) {
                try {
                    ax6.o(rm1.F(result));
                    CloseableImage closeableImageS = result.s();
                    if (!(closeableImageS instanceof sm1)) {
                        throw new UnsupportedOperationException("Unrecognized image class: " + closeableImageS);
                    }
                    sm1 sm1Var = (sm1) closeableImageS;
                    IImageProxy.ImageListener imageListener = this.f33633a;
                    if (imageListener != null) {
                        imageListener.onImageFinish(new BitmapDrawable(sm1Var.k()));
                    }
                    result.close();
                } catch (Throwable th) {
                    result.close();
                    throw th;
                }
            }
        }
    }

    public ImageImpl(Application application) {
        on3.d(application);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IImageProxy
    public void loadImage(String url, IImageProxy.ImageStrategy imageStrategy, final IImageProxy.ImageListener imageListener) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri uri = Uri.parse(url);
        on3.b().i(ImageRequestBuilder.p(uri).r(x64.b().h(-16711936).a()).v(new c()).q(true).t(true).u(ImageRequest.RequestLevel.FULL_FETCH).w(false).a(), new Object()).e(new d(imageListener), uf9.d());
    }

    @Override // com.alibaba.triver.kit.api.proxy.IImageProxy
    public void setImageUrl(final ImageView view, String url, IImageProxy.ImageStrategy imageStrategy) {
        String str;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            view.setImageBitmap(null);
            return;
        }
        if (url.startsWith("//")) {
            str = "http:" + url;
        } else {
            str = url;
        }
        if (view.getLayoutParams().width <= 0 || view.getLayoutParams().height <= 0) {
            return;
        }
        Uri uri = Uri.parse(str);
        ImageRequest imageRequestA = ImageRequestBuilder.p(uri).r(x64.b().h(-16711936).a()).q(true).t(true).u(ImageRequest.RequestLevel.FULL_FETCH).w(false).a();
        if (!(view instanceof DraweeView)) {
            on3.b().i(imageRequestA, new Object()).e(new b(view), uf9.d());
            return;
        }
        Log.d("FrescoImageAdapter", "load: " + url);
        ((DraweeView) view).setController(on3.g().s(true).u(new a()).c(uri).y(imageRequestA).d());
    }
}

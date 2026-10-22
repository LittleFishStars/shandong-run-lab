package cn.hzjizhun.admin.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.util.ALog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ImageLoaderImp implements ImageLoader {
    private static int iconId = R.drawable.ad_sdk_icon;
    private static boolean isSetTag;
    private Context context;
    private boolean mIsRetry = false;
    private Object tag;

    public class a implements RequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageLoaderCallback f22742a;
        public final /* synthetic */ String f;

        public a(String str, ImageLoaderCallback imageLoaderCallback) {
            this.f = str;
            this.f22742a = imageLoaderCallback;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            ImageLoaderImp.this.mIsRetry = false;
            ImageLoaderCallback imageLoaderCallback = this.f22742a;
            if (imageLoaderCallback != null) {
                imageLoaderCallback.onSuccess();
            }
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            if (ImageLoaderImp.this.mIsRetry) {
                ImageLoaderImp.this.mIsRetry = false;
                ImageLoaderCallback imageLoaderCallback = this.f22742a;
                if (imageLoaderCallback != null) {
                    imageLoaderCallback.onError();
                }
            } else {
                ALog.e("ImageLoader", "重试加载 preLoadImage");
                ImageLoaderImp.this.mIsRetry = true;
                ImageLoaderImp.this.preLoadImage(this.f, this.f22742a);
            }
            return true;
        }
    }

    public class b implements RequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f22743a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ImageLoaderCallback f312a;
        public final /* synthetic */ String f;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                ImageLoaderImp.this.loadImage(bVar.f, bVar.f22743a, bVar.f312a);
            }
        }

        public b(ImageView imageView, String str, ImageLoaderCallback imageLoaderCallback) {
            this.f22743a = imageView;
            this.f = str;
            this.f312a = imageLoaderCallback;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
            ImageLoaderImp.this.mIsRetry = false;
            ImageLoaderCallback imageLoaderCallback = this.f312a;
            if (imageLoaderCallback != null) {
                imageLoaderCallback.onSuccess();
            }
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            if (ImageLoaderImp.this.mIsRetry) {
                ImageLoaderImp.this.mIsRetry = false;
                ImageLoaderCallback imageLoaderCallback = this.f312a;
                if (imageLoaderCallback != null) {
                    imageLoaderCallback.onError();
                }
            } else {
                ALog.e("ImageLoader", "重试加载 loadImage");
                ImageLoaderImp.this.mIsRetry = true;
                this.f22743a.post(new a());
            }
            return true;
        }
    }

    public ImageLoaderImp(Context context) {
        this.context = context;
        setTagId();
    }

    private void loadImageId(int i, ImageView imageView) {
        try {
            Glide.with(this.context).load(Integer.valueOf(i)).into(imageView);
        } catch (Throwable unused) {
        }
    }

    private void setTagId() {
        try {
            if (isSetTag) {
                return;
            }
            isSetTag = true;
            ViewTarget.setTagId(R.id.rc_glide_imageid);
        } catch (Throwable unused) {
        }
    }

    public void loadIcon(String str, ImageView imageView) {
        try {
            Glide.with(this.context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().error(iconId)).into(imageView);
        } catch (Throwable unused) {
            loadImageId(iconId, imageView);
        }
    }

    @Override // cn.hzjizhun.admin.image.ImageLoader
    public void loadImage(String str, ImageView imageView) {
        if (this.context == null || TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).into(imageView);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cn.hzjizhun.admin.image.ImageLoader
    public void preLoadImage(String str) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).preload();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void release() {
        this.context = null;
    }

    public ImageLoaderImp(Context context, Object obj) {
        this.context = context;
        this.tag = obj;
        setTagId();
    }

    @Override // cn.hzjizhun.admin.image.ImageLoader
    public void loadImage(String str, ImageView imageView, ImageLoaderCallback imageLoaderCallback) {
        if (this.context == null || TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).listener(new b(imageView, str, imageLoaderCallback)).into(imageView);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cn.hzjizhun.admin.image.ImageLoader
    public void preLoadImage(String str, ImageLoaderCallback imageLoaderCallback) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).listener(new a(str, imageLoaderCallback)).preload();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

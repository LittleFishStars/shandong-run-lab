package com.bwt.top.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bwt.top.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ImageLoaderImp implements ImageLoader {
    private static boolean isSetTag;
    private Context context;
    private Object tag;

    public class a implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageLoaderCallback f28261a;

        public a(ImageLoaderImp imageLoaderImp, ImageLoaderCallback imageLoaderCallback) {
            this.f28261a = imageLoaderCallback;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            ImageLoaderCallback imageLoaderCallback = this.f28261a;
            if (imageLoaderCallback == null) {
                return false;
            }
            imageLoaderCallback.onSuccess();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            ImageLoaderCallback imageLoaderCallback = this.f28261a;
            if (imageLoaderCallback == null) {
                return true;
            }
            imageLoaderCallback.onError();
            return true;
        }
    }

    public class b implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageLoaderCallback f28262a;

        public b(ImageLoaderImp imageLoaderImp, ImageLoaderCallback imageLoaderCallback) {
            this.f28262a = imageLoaderCallback;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            ImageLoaderCallback imageLoaderCallback = this.f28262a;
            if (imageLoaderCallback == null) {
                return false;
            }
            imageLoaderCallback.onSuccess();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            ImageLoaderCallback imageLoaderCallback = this.f28262a;
            if (imageLoaderCallback == null) {
                return true;
            }
            imageLoaderCallback.onError();
            return true;
        }
    }

    public ImageLoaderImp(Context context) {
        this.context = context;
        setTagId();
    }

    public ImageLoaderImp(Context context, Object obj) {
        this.context = context;
        this.tag = obj;
        setTagId();
    }

    private void setTagId() {
        try {
            if (isSetTag) {
                return;
            }
            isSetTag = true;
            ViewTarget.setTagId(R.id.rc_glide_imageid);
        } catch (Exception unused) {
        }
    }

    public void loadIcon(String str, ImageView imageView) {
        try {
            Glide.with(imageView).setDefaultRequestOptions(new RequestOptions().error(R.drawable.ad_sdk_icon_bwt)).load(str).into(imageView);
        } catch (Exception unused) {
        }
    }

    @Override // com.bwt.top.image.ImageLoader
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bwt.top.image.ImageLoader
    public void loadImage(String str, ImageView imageView, ImageLoaderCallback imageLoaderCallback) {
        if (this.context == null || TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).listener(new b(this, imageLoaderCallback)).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bwt.top.image.ImageLoader
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bwt.top.image.ImageLoader
    public void preLoadImage(String str, ImageLoaderCallback imageLoaderCallback) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Context context = this.context;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            Glide.with(this.context).load(str).listener(new a(this, imageLoaderCallback)).preload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        this.context = null;
    }
}

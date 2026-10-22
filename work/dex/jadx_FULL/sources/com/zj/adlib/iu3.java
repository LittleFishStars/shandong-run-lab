package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class iu3 implements UnicornImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f42443a;

    public class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageLoaderListener f42444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int width, int height, final ImageLoaderListener val$listener) {
            super(width, height);
            this.f42444a = val$listener;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable placeholder) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable errorDrawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable placeholder) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object resource, Transition transition) {
            onResourceReady((Bitmap) resource, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@NonNull Bitmap resource, Transition<? super Bitmap> transition) {
            ImageLoaderListener imageLoaderListener = this.f42444a;
            if (imageLoaderListener != null) {
                imageLoaderListener.onLoadComplete(resource);
            }
        }
    }

    public iu3(Context context) {
        this.f42443a = context.getApplicationContext();
    }

    public void loadImage(String uri, int width, int height, final ImageLoaderListener listener) {
        if (width <= 0) {
            width = Integer.MIN_VALUE;
        }
        if (height <= 0) {
            height = Integer.MIN_VALUE;
        }
        Glide.with(this.f42443a).asBitmap().load(uri).into(new a(width, height, listener));
    }

    @Nullable
    public Bitmap loadImageSync(String uri, int width, int height) {
        try {
            return Glide.with(this.f42443a).asBitmap().load(uri).submit().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

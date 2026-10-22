package com.czhj.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.czhj.volley.VolleyError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetworkImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29496a;
    private int b;
    private int c;
    private ImageLoader d;
    private ImageLoader.ImageContainer e;

    /* JADX INFO: renamed from: com.czhj.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageLoader.ImageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f29497a;

        public AnonymousClass1(boolean z) {
            this.f29497a = z;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.c);
            }
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer imageContainer, boolean z) {
            if (z && this.f29497a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.czhj.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(imageContainer, false);
                    }
                });
                return;
            }
            if (imageContainer.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer.getBitmap());
            } else if (NetworkImageView.this.b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.b);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        int i = this.b;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (getLayoutParams() != null) {
            z2 = getLayoutParams().width == -2;
            z3 = getLayoutParams().height == -2;
        } else {
            z2 = false;
            z3 = false;
        }
        boolean z4 = z2 && z3;
        if (width == 0 && height == 0 && !z4) {
            return;
        }
        if (TextUtils.isEmpty(this.f29496a)) {
            ImageLoader.ImageContainer imageContainer = this.e;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.e = null;
            }
            a();
            return;
        }
        ImageLoader.ImageContainer imageContainer2 = this.e;
        if (imageContainer2 != null && imageContainer2.getRequestUrl() != null) {
            if (this.e.getRequestUrl().equals(this.f29496a)) {
                return;
            }
            this.e.cancelRequest();
            a();
        }
        if (z2) {
            width = 0;
        }
        this.e = this.d.get(this.f29496a, new AnonymousClass1(z), width, z3 ? 0 : height, scaleType);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.e;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(true);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        Threads.a();
        this.f29496a = str;
        this.d = imageLoader;
        a(false);
    }
}

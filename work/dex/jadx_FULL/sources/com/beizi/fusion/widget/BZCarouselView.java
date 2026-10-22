package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.beizi.fusion.of;
import com.beizi.fusion.qf;
import com.beizi.fusion.w3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BZCarouselView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f27911a;
    private final List b;
    private int c;
    private long d;
    private e e;
    private final AccelerateDecelerateInterpolator f;
    private final Handler g;
    private final Runnable h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BZCarouselView.this.performCarousel();
                BZCarouselView bZCarouselView = BZCarouselView.this;
                bZCarouselView.g.postDelayed(this, bZCarouselView.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27913a;
        final /* synthetic */ int b;
        final /* synthetic */ ImageView c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f27914a;

            /* JADX INFO: renamed from: com.beizi.fusion.widget.BZCarouselView$b$a$a, reason: collision with other inner class name */
            public class RunnableC0328a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ BitmapDrawable f27915a;

                public RunnableC0328a(BitmapDrawable bitmapDrawable) {
                    this.f27915a = bitmapDrawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView;
                    try {
                        BitmapDrawable bitmapDrawable = this.f27915a;
                        if (bitmapDrawable == null || (imageView = b.this.c) == null) {
                            return;
                        }
                        imageView.setBackground(bitmapDrawable);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public a(Bitmap bitmap) {
                this.f27914a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f27914a != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(qf.a(BZCarouselView.this.getContext(), this.f27914a, 20.0f));
                        Handler handler = BZCarouselView.this.g;
                        if (handler != null) {
                            handler.post(new RunnableC0328a(bitmapDrawable));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public b(int i, int i2, ImageView imageView) {
            this.f27913a = i;
            this.b = i2;
            this.c = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                float fAbs = Math.abs(((float) ((((double) this.f27913a) * 1.0d) / ((double) this.b))) - ((float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()))));
                if (fAbs > 0.1f) {
                    this.c.setScaleType(ImageView.ScaleType.CENTER);
                    w3.c().e().execute(new a(bitmap));
                } else if (fAbs > 0.07d) {
                    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                this.c.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27916a;
        final /* synthetic */ int b;

        public c(ImageView imageView, int i) {
            this.f27916a = imageView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = this.f27916a;
            if (imageView != null) {
                imageView.setTranslationX(this.b);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27917a;
        final /* synthetic */ int b;

        public d(ImageView imageView, int i) {
            this.f27917a = imageView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = this.f27917a;
            if (imageView != null) {
                imageView.setTranslationX(-this.b);
            }
        }
    }

    public interface e {
        void a(int i);
    }

    public BZCarouselView(Context context) {
        this(context, null);
    }

    private void a(int i, int i2) {
        try {
            this.b.clear();
            removeAllViews();
            if (i <= 0) {
                i = getResources().getDisplayMetrics().widthPixels;
            }
            if (i2 <= 0) {
                i2 = getResources().getDisplayMetrics().heightPixels;
            }
            for (String str : this.f27911a) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
                imageView.setTranslationX(this.b.isEmpty() ? 0.0f : i);
                this.b.add(imageView);
                addView(imageView, new ViewGroup.LayoutParams(i, i2));
                a(str, imageView, i, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            stopCarousel();
            this.g.removeCallbacksAndMessages(null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void performCarousel() {
        try {
            if (this.b.size() <= 1) {
                return;
            }
            int i = getResources().getDisplayMetrics().widthPixels;
            ImageView imageView = (ImageView) this.b.get(this.c);
            int size = (this.c + 1) % this.b.size();
            ImageView imageView2 = (ImageView) this.b.get(size);
            float f = i;
            imageView.animate().translationX(-f).setDuration(500L).setInterpolator(this.f).start();
            imageView2.setTranslationX(f);
            imageView2.animate().translationX(0.0f).setDuration(500L).setInterpolator(this.f).start();
            this.c = size;
            this.g.postDelayed(new c(imageView, i), 500L);
            e eVar = this.e;
            if (eVar != null) {
                eVar.a(this.c);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void performLastCarousel() {
        try {
            if (this.b.size() <= 1) {
                return;
            }
            stopCarousel();
            int i = getResources().getDisplayMetrics().widthPixels;
            ImageView imageView = (ImageView) this.b.get(this.c);
            int size = ((this.c - 1) + this.b.size()) % this.b.size();
            ImageView imageView2 = (ImageView) this.b.get(size);
            float f = i;
            imageView.animate().translationX(f).setDuration(500L).setInterpolator(this.f).start();
            imageView2.setTranslationX(-f);
            imageView2.animate().translationX(0.0f).setDuration(500L).setInterpolator(this.f).start();
            this.c = size;
            this.g.postDelayed(new d(imageView, i), 500L);
            e eVar = this.e;
            if (eVar != null) {
                eVar.a(this.c);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void performNextCarousel() {
        try {
            if (this.b.size() > 1) {
                stopCarousel();
                performCarousel();
            } else {
                e eVar = this.e;
                if (eVar != null) {
                    eVar.a(this.c);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setImageUrls(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f27911a = list;
        a(0, 0);
    }

    public void setOnContentChangeListener(e eVar) {
        this.e = eVar;
    }

    public void setScrollInterval(int i) {
        if (i > 0) {
            this.d = i * 1000;
        }
    }

    public void startCarousel() {
        try {
            List list = this.f27911a;
            if (list != null && !list.isEmpty()) {
                stopCarousel();
                Handler handler = this.g;
                if (handler != null) {
                    handler.postDelayed(this.h, this.d);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopCarousel() {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.removeCallbacks(this.h);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public BZCarouselView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BZCarouselView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.c = 0;
        this.d = 5000L;
        this.f = new AccelerateDecelerateInterpolator();
        this.g = new Handler(Looper.getMainLooper());
        this.h = new a();
    }

    public void setImageUrls(List<String> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f27911a = list;
        a(i, i2);
    }

    private void a(String str, ImageView imageView, int i, int i2) {
        of.a(getContext()).a(str, new b(i, i2, imageView));
    }
}

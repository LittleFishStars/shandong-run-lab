package com.huachenjie.sport.widget.photowall;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.huachenjie.common.R;
import com.zj.adlib.jj8;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class PhotoWall extends LinearLayout {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f36751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemClickListener f13797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f13798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f13799a;
    public List<Bitmap> c;

    public interface OnItemClickListener {
        void a();

        void b(View view, int i);

        void c(View view, int i);
    }

    public PhotoWall(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        this.f13797a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i, View view) {
        OnItemClickListener onItemClickListener = this.f13797a;
        if (onItemClickListener != null) {
            onItemClickListener.b(this, i);
            this.f13797a.c(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        this.f13797a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        this.f13797a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i, View view) {
        OnItemClickListener onItemClickListener = this.f13797a;
        if (onItemClickListener != null) {
            onItemClickListener.b(this, i);
            this.f13797a.c(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.f13797a.a();
    }

    public List<String> getImages() {
        return this.f13798a;
    }

    public final void i() {
        this.f36751a = (LinearLayout) View.inflate(getContext(), R.layout.widget_photo_wall, this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f13799a) {
            this.f13799a = false;
            int size = View.MeasureSpec.getSize(i);
            this.P = size;
            int i3 = this.K;
            int i4 = this.L;
            this.N = (size - ((i3 - 1) * i4)) / i3;
            this.O = (size - ((i3 - 1) * i4)) / i3;
        }
    }

    public final void p() {
        this.f36751a.removeAllViews();
        List<String> list = this.f13798a;
        if (list == null || list.size() == 0) {
            HasCloseImage hasCloseImage = new HasCloseImage(getContext());
            hasCloseImage.setLayoutParams(new LinearLayout.LayoutParams(this.N, this.O));
            hasCloseImage.setCloseType();
            if (this.f13797a != null) {
                hasCloseImage.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.oq6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f43814a.j(view);
                    }
                });
            }
            this.f36751a.addView(hasCloseImage);
            return;
        }
        for (final int i = 0; i < this.f13798a.size(); i++) {
            if (i > this.K - 1) {
                return;
            }
            String str = this.f13798a.get(i);
            HasCloseImage hasCloseImage2 = new HasCloseImage(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.N, this.O);
            if (i != 0) {
                layoutParams.setMarginStart(this.L);
            }
            hasCloseImage2.setLayoutParams(layoutParams);
            hasCloseImage2.setImage(str, this.M);
            this.f36751a.addView(hasCloseImage2);
            hasCloseImage2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.pq6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44044a.k(i, view);
                }
            });
        }
        HasCloseImage hasCloseImage3 = new HasCloseImage(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.N, this.O);
        layoutParams2.setMarginStart(this.L);
        hasCloseImage3.setLayoutParams(layoutParams2);
        hasCloseImage3.setCloseType();
        if (this.f13797a != null) {
            hasCloseImage3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.qq6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44278a.l(view);
                }
            });
        }
        this.f36751a.addView(hasCloseImage3);
    }

    public final void q() {
        this.f36751a.removeAllViews();
        List<Bitmap> list = this.c;
        if (list == null || list.size() == 0) {
            HasCloseImage hasCloseImage = new HasCloseImage(getContext());
            hasCloseImage.setLayoutParams(new LinearLayout.LayoutParams(this.N, this.O));
            hasCloseImage.setCloseType();
            if (this.f13797a != null) {
                hasCloseImage.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.sq6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f44753a.m(view);
                    }
                });
            }
            this.f36751a.addView(hasCloseImage);
            return;
        }
        for (final int i = 0; i < this.c.size(); i++) {
            if (i > this.K - 1) {
                return;
            }
            Bitmap bitmap = this.c.get(i);
            HasCloseImage hasCloseImage2 = new HasCloseImage(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.N, this.O);
            if (i != 0) {
                layoutParams.setMarginStart(this.L);
            }
            hasCloseImage2.setLayoutParams(layoutParams);
            hasCloseImage2.setImage(bitmap, this.M);
            this.f36751a.addView(hasCloseImage2);
            hasCloseImage2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tq6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44983a.n(i, view);
                }
            });
        }
        HasCloseImage hasCloseImage3 = new HasCloseImage(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.N, this.O);
        layoutParams2.setMarginStart(this.L);
        hasCloseImage3.setLayoutParams(layoutParams2);
        hasCloseImage3.setCloseType();
        if (this.f13797a != null) {
            hasCloseImage3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.uq6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45206a.o(view);
                }
            });
        }
        this.f36751a.addView(hasCloseImage3);
    }

    public void setBitmapImages(List<Bitmap> list) {
        if (list == null) {
            return;
        }
        this.c = list;
        post(new Runnable() { // from class: com.zj.adlib.rq6
            @Override // java.lang.Runnable
            public final void run() {
                this.f44513a.q();
            }
        });
    }

    public void setImages(List<String> list) {
        if (list == null) {
            return;
        }
        this.f13798a = list;
        post(new Runnable() { // from class: com.zj.adlib.vq6
            @Override // java.lang.Runnable
            public final void run() {
                this.f45420a.p();
            }
        });
    }

    public void setMaxItem(int i) {
        if (i <= 0) {
            return;
        }
        this.K = i;
        if (this.f13799a) {
            return;
        }
        int i2 = this.P;
        int i3 = this.L;
        this.N = (i2 - ((i - 1) * i3)) / i;
        this.O = (i2 - ((i - 1) * i3)) / i;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f13797a = onItemClickListener;
    }

    public void setRadius(int i) {
        if (i < 0) {
            return;
        }
        this.M = jj8.a(i);
        if (this.f13798a != null) {
            p();
        }
        if (this.c != null) {
            q();
        }
    }

    public void setSpaceBetween(int i) {
        if (i < 0) {
            return;
        }
        int iA = jj8.a(i);
        this.L = iA;
        if (this.f13799a) {
            return;
        }
        int i2 = this.P;
        int i3 = this.K;
        this.N = (i2 - ((i3 - 1) * iA)) / i3;
        this.O = (i2 - ((i3 - 1) * iA)) / i3;
    }

    public PhotoWall(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoWall(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.K = 5;
        this.L = jj8.a(5.0f);
        this.M = 0;
        this.f13799a = true;
        i();
    }
}

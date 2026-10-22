package com.fl.saas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import com.fl.saas.Q0;
import com.fl.saas.adx.base.widget.InterceptClickLayout;
import com.fl.saas.adx.base.widget.RoundedFrameLayout;
import com.fl.saas.adx.base.widget.S2SVideoView;
import com.fl.saas.adx.base.widget.ShaderRoundImageView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f30081a;
    private final View b;
    private final RoundedFrameLayout c;
    private final FrameLayout d;
    private final TextView e;
    private final TextView f;
    private S2SVideoView g;
    private final c h;
    private View i;
    private FrameLayout j;
    private ImageView k;
    private int l;
    private int m;
    private int n;
    private int o;
    private b p;
    private boolean q = false;

    public class a implements FLImageLoader.OnBitmapLoadListener {
        public a() {
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
        public void onBitmapLoadFailed(String str, String str2) {
            if (Q0.this.p != null) {
                Q0.this.p.a();
            }
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
        public void onBitmapLoaded(String str, Bitmap bitmap, boolean z) {
            Drawable drawableA = AbstractC1398a0.a(Q0.this.f30081a, bitmap);
            if (drawableA == null) {
                if (Q0.this.p != null) {
                    Q0.this.p.a();
                    return;
                }
                return;
            }
            ImageView imageView = new ImageView(Q0.this.f30081a);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AbstractC1398a0.a(imageView, drawableA);
            ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(Q0.this.f30081a);
            shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            shaderRoundImageView.setAdjustViewBounds(true);
            FrameLayout.LayoutParams layoutParams = Q0.this.h.b() ? new FrameLayout.LayoutParams(-2, -1) : new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            Q0.this.c.addView(shaderRoundImageView, 0, layoutParams);
            Q0.this.c.addView(imageView, 0, ViewHelper.getMatchParent());
            shaderRoundImageView.setImageDrawable(drawableA);
        }
    }

    public interface b {
        void a();

        void onClose();
    }

    public enum c {
        MIXED_TEXT_IMAGE(true, R.layout.fl_adx_template_view_text_img_mixture),
        TEXT_OVERLAY(true, R.layout.fl_adx_template_view_text_float_layer),
        TOP_TEXT_BOTTOM_IMAGE(true, R.layout.fl_adx_template_view_top_text_bottom_img_with_btn),
        TOP_IMAGE_BOTTOM_TEXT(true, R.layout.fl_adx_template_view_top_img_bottom_text_with_btn),
        LEFT_TEXT_RIGHT_IMAGE(false, R.layout.fl_adx_template_view_left_text_right_img),
        LEFT_IMAGE_RIGHT_TEXT(false, R.layout.fl_adx_template_view_left_img_right_text),
        IMAGE_ONLY(true, R.layout.fl_adx_template_view_img);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30083a;
        private final boolean b;

        c(boolean z, int i) {
            this.f30083a = i;
            this.b = z;
        }

        public boolean b() {
            return this.b;
        }

        public View a(Context context) {
            return ViewHelper.inflate(context, this.f30083a);
        }

        public static c a(int i) {
            for (c cVar : values()) {
                if (cVar.ordinal() == i) {
                    return cVar;
                }
            }
            return MIXED_TEXT_IMAGE;
        }
    }

    public Q0(Context context, c cVar) {
        this.f30081a = context;
        this.h = cVar;
        View viewA = cVar.a(context);
        this.b = viewA;
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewA.findViewById(R.id.fl_template_view_media_container);
        this.c = roundedFrameLayout;
        this.d = (FrameLayout) C1428p0.a(viewA).a(new Function() { // from class: com.zj.adlib.u47
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Q0.f((View) obj);
            }
        }).c(roundedFrameLayout);
        TextView textView = (TextView) viewA.findViewById(R.id.fl_template_view_title);
        this.e = textView;
        TextView textView2 = (TextView) viewA.findViewById(R.id.fl_template_view_des);
        this.f = textView2;
        if (cVar == c.TEXT_OVERLAY) {
            if (textView != null) {
                textView.setTextColor(-1);
            }
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FrameLayout f(View view) {
        return (FrameLayout) view.findViewById(R.id.s2s_template_action_container);
    }

    public Q0 b(String str) {
        return this;
    }

    public Q0 d(String str) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        int width = this.d.getWidth();
        int height = this.d.getHeight();
        int[] iArrSelfMeasure = ViewHelper.selfMeasure(view);
        int i = iArrSelfMeasure[0];
        int i2 = iArrSelfMeasure[1];
        int iDip2px = DeviceUtil.dip2px(5.0f) * 2;
        int i3 = width - iDip2px;
        int i4 = height - iDip2px;
        if (i4 <= 0 || i3 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        if (i3 < i || i4 < i2) {
            float fMin = Math.min(i3 / i, i4 / i2);
            view.setScaleX(fMin);
            view.setScaleY(fMin);
        }
        this.d.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        ViewHelper.removeParent(this.i);
        b bVar = this.p;
        if (bVar != null) {
            bVar.onClose();
        }
    }

    public void a(final View view) {
        if (view == null) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.zj.adlib.v47
            @Override // java.lang.Runnable
            public final void run() {
                this.f20176a.c(view);
            }
        });
    }

    public void b(final View view) {
        if (view == null) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.zj.adlib.w47
            @Override // java.lang.Runnable
            public final void run() {
                this.f20368a.e(view);
            }
        });
    }

    public Q0 e(String str) {
        ViewHelper.setTextView(this.e, str);
        return this;
    }

    public Q0 a() {
        int i;
        int i2;
        if (this.d == null) {
            return this;
        }
        try {
            this.k = new ImageView(this.f30081a);
            c cVar = this.h;
            if (cVar == c.LEFT_TEXT_RIGHT_IMAGE || cVar == c.LEFT_IMAGE_RIGHT_TEXT) {
                i = 16;
                i2 = 6;
            } else {
                i = 20;
                i2 = 12;
            }
            float f = i;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(f), DeviceUtil.dip2px(f));
            layoutParams.gravity = 8388661;
            int iDip2px = DeviceUtil.dip2px(i2);
            layoutParams.setMargins(iDip2px, iDip2px, iDip2px, iDip2px);
            this.k.setImageResource(R.mipmap.fl_adx_ad_dialog_close);
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.x47
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45743a.d(view);
                }
            });
            this.d.addView(this.k, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public void b() {
        if (this.q) {
            return;
        }
        this.q = true;
        S2SVideoView s2SVideoView = this.g;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
    }

    public View c() {
        if (this.i == null) {
            InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(this.f30081a, R.layout.fl_adx_template_view);
            int i = this.n;
            int i2 = this.o;
            interceptClickLayout.setPadding(i, i2, i, i2);
            interceptClickLayout.setLayoutParams(new ViewGroup.LayoutParams(this.l, this.m));
            this.j = (FrameLayout) interceptClickLayout.findViewById(R.id.s2s_template_container);
            this.j.addView(this.b, new FrameLayout.LayoutParams(this.l - (this.n * 2), this.m - (this.o * 2)));
            this.i = interceptClickLayout;
        }
        return this.i;
    }

    private void a(String str) {
        FLImageLoader.getInstance(this.f30081a).loadBitmap(str, new a());
    }

    public Q0 b(C1415j c1415j) {
        if (c1415j == null) {
            return this;
        }
        C1415j.c cVar = c1415j.P0;
        if (cVar == null || cVar.b != 2 || TextUtils.isEmpty(c1415j.t1)) {
            a(c1415j.p1);
        } else {
            a(c1415j);
        }
        return this;
    }

    public Q0 c(String str) {
        ViewHelper.setTextView(this.f, str);
        return this;
    }

    private void a(C1415j c1415j) {
        S2SVideoView s2SVideoView = new S2SVideoView(this.f30081a);
        this.g = s2SVideoView;
        s2SVideoView.setVideo(c1415j);
        this.c.addView(this.g, ViewHelper.getMatchParent());
    }

    public Q0 b(int i, int i2) {
        float f;
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (mobileWidth >= i && i > 0) {
            mobileWidth = i;
        }
        this.l = mobileWidth;
        if (this.h.b()) {
            f = 1.78f;
            if (i2 > i) {
                this.m = Math.round(i / f);
            } else {
                if (i2 <= 0) {
                    i2 = Math.round(i / f);
                }
                this.m = i2;
            }
        } else {
            f = 19.0f;
            if (i2 > i) {
                i *= 5;
                this.m = Math.round(i / f);
            } else {
                if (i2 <= 0) {
                    i *= 5;
                    i2 = Math.round(i / f);
                }
                this.m = i2;
            }
        }
        return this;
    }

    public Q0 a(Bitmap bitmap) {
        if (bitmap == null) {
            return this;
        }
        ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(this.f30081a);
        shaderRoundImageView.setRadius(DeviceUtil.dip2px(2.0f));
        shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        shaderRoundImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, DeviceUtil.dip2px(12.0f));
        layoutParams.gravity = 85;
        int iDip2px = DeviceUtil.dip2px(4.0f);
        layoutParams.setMargins(iDip2px, iDip2px, iDip2px, iDip2px);
        shaderRoundImageView.setImageBitmap(bitmap);
        this.d.addView(shaderRoundImageView, layoutParams);
        return this;
    }

    public void a(b bVar) {
        this.p = bVar;
    }

    public Q0 a(int i, int i2) {
        this.n = i;
        this.o = i2;
        return this;
    }
}

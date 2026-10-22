package com.ipd.dsp.internal.s1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class d extends com.ipd.dsp.internal.x1.c {
    public final int g;
    public final int h;
    public Bitmap i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public a o;
    public List<View> p;

    public interface a {
        void a(Map<String, Object> map);
    }

    public d(@NonNull Context context, boolean z, int i, int i2, com.ipd.dsp.internal.e1.d dVar, Bitmap bitmap, a aVar) {
        super(context);
        this.p = new ArrayList();
        this.g = i;
        this.h = i2;
        this.i = bitmap;
        this.o = aVar;
        setClickable(true);
        a(context, z);
        a(dVar, z);
    }

    public final void a(Context context, boolean z) {
        int i;
        if (!z) {
            int iA = (int) s.a(context, 10.0f);
            int iA2 = (int) s.a(context, 12.0f);
            int iA3 = (int) s.a(context, 36.0f);
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(iA).a(-1).a());
            ImageView imageView = new ImageView(context);
            this.j = imageView;
            addView(imageView, new FrameLayout.LayoutParams(-1, (int) (this.h * 0.4f)));
            View view = new View(context);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            if (Build.VERSION.SDK_INT >= 29) {
                gradientDrawable.setColors(new int[]{0, 0, -1}, new float[]{0.0f, 0.66f, 1.0f});
            } else {
                gradientDrawable.setColors(new int[]{0, 0, -1});
            }
            view.setBackground(gradientDrawable);
            addView(view, new FrameLayout.LayoutParams(-1, (int) (this.h * 0.4f)));
            int i2 = (int) (this.g * 0.2f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
            layoutParams.gravity = 17;
            layoutParams.topMargin = ((int) ((-this.g) * 0.1f)) - iA2;
            ImageView imageView2 = new ImageView(context);
            this.k = imageView2;
            addView(imageView2, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = (int) (this.h / 2.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            TextView textView = new TextView(context);
            this.l = textView;
            textView.setTextColor(-16777216);
            this.l.setTextSize(22.0f);
            TextView textView2 = this.l;
            Typeface typeface = Typeface.DEFAULT_BOLD;
            textView2.setTypeface(typeface);
            linearLayout.addView(this.l, layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 1;
            layoutParams4.topMargin = iA2;
            TextView textView3 = new TextView(context);
            this.m = textView3;
            textView3.setTextSize(16.0f);
            linearLayout.addView(this.m, layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 1;
            layoutParams5.topMargin = iA2;
            TextView textView4 = new TextView(context);
            this.n = textView4;
            textView4.setBackgroundResource(R.drawable.ipd_bg_blue);
            this.n.setPadding(iA3, iA2, iA3, iA2);
            this.n.setTextColor(-1);
            this.n.setTextSize(14.0f);
            this.n.setTypeface(typeface);
            linearLayout.addView(this.n, layoutParams5);
            return;
        }
        int iA4 = (int) s.a(context, 10.0f);
        int iA5 = (int) s.a(context, 12.0f);
        int iA6 = (int) s.a(context, 24.0f);
        int iA7 = (int) s.a(context, 36.0f);
        int iA8 = (int) s.a(context, 40.0f);
        int iA9 = (int) s.a(context, 60.0f);
        int iA10 = (int) s.a(context, 100.0f);
        ImageView imageView3 = new ImageView(context);
        this.j = imageView3;
        addView(imageView3, new FrameLayout.LayoutParams(-1, -1));
        float f = this.g * 0.75f;
        float f2 = 0.78f * f;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams((int) f, (int) f2);
        layoutParams6.gravity = 17;
        FrameLayout frameLayout = new FrameLayout(context);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        float f3 = iA4;
        gradientDrawable2.setCornerRadius(f3);
        if (Build.VERSION.SDK_INT >= 29) {
            gradientDrawable2.setColors(new int[]{Color.parseColor("#B3E7FF"), -1, -1}, new float[]{0.0f, 0.15f, 1.0f});
            i = 5;
        } else {
            i = 5;
            gradientDrawable2.setColors(new int[]{Color.parseColor("#B3E7FF"), -1, -1, -1, -1});
        }
        IPDGlideHelper.loadCustomRoundedCornersBlur(getContext(), frameLayout, gradientDrawable2, 10, i);
        addView(frameLayout, layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 17;
        layoutParams7.setMargins(iA6, iA8 * (-1), iA6, 0);
        TextView textView5 = new TextView(context);
        this.l = textView5;
        textView5.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setMaxLines(1);
        this.l.setTextColor(-16777216);
        this.l.setTextSize(20.0f);
        TextView textView6 = this.l;
        Typeface typeface2 = Typeface.DEFAULT_BOLD;
        textView6.setTypeface(typeface2);
        frameLayout.addView(this.l, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 17;
        layoutParams8.setMarginStart(iA5);
        layoutParams8.setMarginEnd(iA5);
        TextView textView7 = new TextView(context);
        this.m = textView7;
        textView7.setGravity(17);
        this.m.setMaxLines(2);
        this.m.setTextSize(18.0f);
        frameLayout.addView(this.m, layoutParams8);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 17;
        layoutParams9.topMargin = iA9;
        TextView textView8 = new TextView(context);
        this.n = textView8;
        textView8.setBackgroundResource(R.drawable.ipd_bg_blue);
        this.n.setPadding(iA7, iA5, iA7, iA5);
        this.n.setTextColor(-1);
        this.n.setTextSize(16.0f);
        this.n.setTypeface(typeface2);
        frameLayout.addView(this.n, layoutParams9);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(iA10, iA10);
        layoutParams10.gravity = 17;
        layoutParams10.topMargin = (int) (((f2 / 2.0f) - f3) * (-1.0f));
        ImageView imageView4 = new ImageView(context);
        this.k = imageView4;
        addView(imageView4, layoutParams10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
        List<View> list = this.p;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().setOnClickListener(null);
                } catch (Throwable unused) {
                }
            }
            this.p.clear();
            this.p = null;
        }
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            try {
                bitmap.recycle();
            } catch (Throwable unused2) {
            }
            this.i = null;
        }
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void setCTABtnText(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void a(com.ipd.dsp.internal.e1.d dVar, boolean z) {
        if (dVar == null) {
            return;
        }
        if (!dVar.p) {
            this.p.add(this);
        }
        if (this.j != null && (o.c(dVar.o) || this.i != null)) {
            if (z) {
                if (this.i == null) {
                    IPDGlideHelper.loadImageCenterCropBlur(getContext(), this.j, dVar.o);
                } else {
                    IPDGlideHelper.loadImageCenterCropBlur(getContext(), this.j, this.i);
                }
            } else if (this.i == null) {
                IPDGlideHelper.loadImageRoundedCorners(getContext(), this.j, dVar.o, 10.0f, 10.0f, 0.0f, 0.0f);
            } else {
                IPDGlideHelper.loadImageRoundedCorners(getContext(), this.j, this.i, 10.0f, 10.0f, 0.0f, 0.0f);
            }
        }
        if (this.k != null && o.c(dVar.n)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.k, dVar.n, 10);
        }
        if (this.l != null && o.c(dVar.k)) {
            this.l.setText(dVar.k);
        }
        if (this.m != null && o.c(dVar.l)) {
            this.m.setText(dVar.l);
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setText("查看详情");
            if (dVar.p) {
                this.p.add(this.n);
            }
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.kta
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f42906a.a(view);
            }
        };
        Iterator<View> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(onClickListener);
        }
    }

    public final /* synthetic */ void a(View view) {
        Map<String, Object> touchCoordsMap;
        if (this.o != null) {
            try {
                touchCoordsMap = getTouchCoordsMap();
            } catch (Throwable unused) {
                touchCoordsMap = null;
            }
            this.o.a(touchCoordsMap);
        }
    }
}

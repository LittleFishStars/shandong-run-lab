package com.ipd.dsp.internal.s1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i extends com.ipd.dsp.internal.x1.c {
    public static final int n = Color.parseColor("#3185FC");
    public TextView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public a k;
    public TextView l;
    public TextView m;

    public interface a {
        void a();

        void a(Map<String, Object> map);

        void b();
    }

    public i(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        int iA = (int) s.a(context, 2.0f);
        int iA2 = (int) s.a(context, 4.0f);
        int iA3 = (int) s.a(context, 12.0f);
        int iA4 = (int) s.a(context, 18.0f);
        int iA5 = (int) s.a(context, 24.0f);
        int iA6 = (int) s.a(context, 60.0f);
        int iA7 = (int) s.a(context, 280.0f);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.u9b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45097a.a(view);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.zj.adlib.eab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41393a.b(view);
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.zj.adlib.nab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43485a.c(view);
            }
        };
        setClickable(true);
        setBackgroundColor(Color.parseColor("#66000000"));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA7, -2);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundResource(R.drawable.ipd_bg_light);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(iA4, iA5, iA4, iA5);
        frameLayout.addView(linearLayout, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA5, iA5);
        layoutParams3.setMargins(iA2, iA2, 0, 0);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ipd_close_dark);
        imageView.setOnClickListener(onClickListener2);
        frameLayout.addView(imageView, layoutParams3);
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setMaxLines(2);
        this.g.setTextColor(-16777216);
        this.g.setTextSize(20.0f);
        TextView textView2 = this.g;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView2.setTypeface(typeface);
        linearLayout.addView(this.g, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iA6, iA6);
        layoutParams4.topMargin = iA3;
        ImageView imageView2 = new ImageView(context);
        this.h = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.h, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = iA3;
        TextView textView3 = new TextView(context);
        this.i = textView3;
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setGravity(17);
        this.i.setMaxLines(2);
        this.i.setTextSize(20.0f);
        this.i.setTypeface(typeface);
        linearLayout.addView(this.i, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = iA3;
        TextView textView4 = new TextView(context);
        this.j = textView4;
        textView4.setPadding(iA, iA, iA, iA);
        this.j.setText("查看详情 >");
        this.j.setTextColor(n);
        this.j.setTextSize(16.0f);
        this.j.setTypeface(typeface);
        this.j.setOnClickListener(onClickListener);
        linearLayout.addView(this.j, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = iA3;
        layoutParams7.setMarginStart(iA3);
        layoutParams7.setMarginEnd(iA3);
        TextView textView5 = new TextView(context);
        this.l = textView5;
        textView5.setBackgroundResource(R.drawable.ipd_bg_blue);
        this.l.setGravity(17);
        this.l.setPadding(iA3, iA3, iA3, iA3);
        this.l.setText("继续观看");
        this.l.setTextColor(-1);
        this.l.setTextSize(12.0f);
        this.l.setOnClickListener(onClickListener2);
        linearLayout.addView(this.l, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = iA3;
        TextView textView6 = new TextView(context);
        this.m = textView6;
        textView6.setPadding(iA, iA, iA, iA);
        this.m.setText("放弃奖励");
        this.m.setTextSize(12.0f);
        this.m.setOnClickListener(onClickListener3);
        linearLayout.addView(this.m, layoutParams8);
    }

    public final /* synthetic */ void b(View view) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        i();
    }

    public final /* synthetic */ void c(View view) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        i();
    }

    public final void i() {
        this.k = null;
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public i(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public final SpannableString c(int i) {
        String str = String.format(Locale.getDefault(), "再看%d秒，即可获得奖励", Integer.valueOf(i));
        SpannableString spannableString = new SpannableString(str);
        int i2 = n;
        spannableString.setSpan(new ForegroundColorSpan(i2), 2, i > 10 ? 5 : 4, 33);
        spannableString.setSpan(new ForegroundColorSpan(i2), str.length() - 2, str.length(), 33);
        return spannableString;
    }

    public final /* synthetic */ void a(View view) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(getTouchCoordsMap());
        }
        i();
    }

    public void a(int i, String str, String str2, a aVar) {
        this.k = aVar;
        setVisibility(0);
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(c(i));
        }
        if (o.c(str)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.h, str, 10);
        } else {
            this.h.setVisibility(8);
        }
        if (o.c(str2)) {
            this.i.setText(str2);
        } else {
            this.i.setVisibility(8);
        }
    }
}

package com.ipd.dsp.internal.p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class b extends LinearLayout {
    public ImageView f;
    public Button g;
    public TextView h;

    public b(Context context, String str) {
        super(context);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        float fB = s.b(context);
        int iA = (int) s.a(fB, 8.0f);
        int iA2 = (int) s.a(fB, 16.0f);
        int iA3 = (int) s.a(fB, 20.0f);
        setPadding(iA3, iA2, iA3, iA2);
        setBackgroundResource(R.drawable.ipd_bg_card_bottom);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(18.0f);
        textView.setTextColor(-16777216);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView.setTypeface(typeface);
        textView.setText("应用详情");
        this.f = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA3, iA3);
        layoutParams2.gravity = 8388661;
        this.f.setLayoutParams(layoutParams2);
        this.f.setImageResource(R.drawable.ipd_close_dark);
        frameLayout.addView(textView);
        frameLayout.addView(this.f);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        layoutParams3.setMargins(0, iA, 0, iA);
        scrollView.setLayoutParams(layoutParams3);
        TextView textView2 = new TextView(context);
        this.h = textView2;
        textView2.setTextColor(-16777216);
        this.h.setLinkTextColor(Color.rgb(0, 116, 204));
        this.h.setText(Html.fromHtml(str, 63));
        this.h.setLinksClickable(true);
        this.h.setMovementMethod(LinkMovementMethod.getInstance());
        scrollView.addView(this.h);
        Button button = new Button(context);
        this.g = button;
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) s.a(fB, 44.0f)));
        this.g.setTextSize(16.0f);
        this.g.setTextColor(-1);
        this.g.setTypeface(typeface);
        this.g.setBackgroundResource(R.drawable.ipd_bg_blue);
        linearLayout.addView(scrollView);
        linearLayout.addView(this.g);
        addView(linearLayout);
    }
}

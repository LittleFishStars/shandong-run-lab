package com.alibaba.ariver.remotedebug.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f24396a;
    private a b;
    private TextView c;

    public b(Context context) {
        super(context);
        a();
    }

    public void setActionEventListener(a aVar) {
        this.b = aVar;
    }

    public void setExitText(String str) {
        this.c.setText(str);
    }

    public void setStateText(String str) {
        this.f24396a.setText(str);
    }

    private void a() {
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).findViewById(R.id.content);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 0, 0, 30);
        TextView textView = new TextView(getContext());
        this.f24396a = textView;
        textView.setTextSize(18.0f);
        this.f24396a.setTextColor(-1);
        this.f24396a.setBackgroundColor(0);
        this.f24396a.setLayoutParams(layoutParams);
        TextView textView2 = new TextView(getContext());
        this.c = textView2;
        textView2.setText(com.alibaba.ariver.remotedebug.R.string.remote_debug_exit);
        textView2.setTextSize(15.0f);
        textView2.setTextColor(-1);
        textView2.setPadding(25, 8, 25, 8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(3.0f);
        gradientDrawable.setStroke(3, -1);
        textView2.setBackgroundDrawable(gradientDrawable);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.b != null) {
                    b.this.b.a();
                }
            }
        });
        textView2.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(0);
        linearLayout.addView(this.f24396a);
        linearLayout.addView(textView2);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(linearLayout, layoutParams2);
        setBackgroundColor(getResources().getColor(com.alibaba.ariver.remotedebug.R.color.default_remote_debug_modal_bg_color));
        setClickable(true);
        viewGroup.addView(this, -1, -1);
    }
}

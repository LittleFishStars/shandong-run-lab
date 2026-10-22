package com.byazt.ows;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.byazt.aas.pf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1068, 20})
public class c implements com.byazt.lbn.c {
    @Override // com.byazt.lbn.c
    public View inflate(Context context) {
        Button button = new Button(context);
        button.setId(2114387729);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, pf.ve(context, 48.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        button.setBackground(gradientDrawable);
        button.setText("立即下载");
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTextSize(2, 16.0f);
        return button;
    }
}

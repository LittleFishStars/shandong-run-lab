package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class bq {
    public static FrameLayout a(Context context, on.e eVar) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (eVar != null) {
                if (eVar.b() == on.e.c) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(85, 42, 17));
                    imageView.setVisibility(0);
                    of.a(context).a(eVar.a()).a(imageView);
                    frameLayout.addView(imageView);
                    return frameLayout;
                }
                if (eVar.b() == on.e.d) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.beizi_button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(eVar.a());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static FrameLayout b(Context context, on.e eVar) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (eVar != null) {
                if (eVar.b() == on.e.c) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(42, 42, 17));
                    imageView.setVisibility(0);
                    of.a(context).a(eVar.a()).a(imageView);
                    frameLayout.addView(imageView);
                    return frameLayout;
                }
                if (eVar.b() == on.e.d) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.beizi_button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(eVar.a());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}

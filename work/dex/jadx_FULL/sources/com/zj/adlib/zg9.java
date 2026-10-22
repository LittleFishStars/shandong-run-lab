package com.zj.adlib;

import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.flyco.tablayout.widget.MsgView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class zg9 {
    public static void a(MsgView msgView, int i) {
        if (msgView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) msgView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        msgView.setLayoutParams(layoutParams);
    }

    public static void b(MsgView msgView, int i) {
        if (msgView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) msgView.getLayoutParams();
        DisplayMetrics displayMetrics = msgView.getResources().getDisplayMetrics();
        msgView.setVisibility(0);
        if (i <= 0) {
            msgView.setStrokeWidth(0);
            msgView.setText("");
            float f = displayMetrics.density;
            layoutParams.width = (int) (f * 5.0f);
            layoutParams.height = (int) (f * 5.0f);
            msgView.setLayoutParams(layoutParams);
            return;
        }
        float f2 = displayMetrics.density;
        layoutParams.height = (int) (f2 * 18.0f);
        if (i > 0 && i < 10) {
            layoutParams.width = (int) (f2 * 18.0f);
            msgView.setText(i + "");
        } else if (i <= 9 || i >= 100) {
            layoutParams.width = -2;
            msgView.setPadding((int) (f2 * 6.0f), 0, (int) (f2 * 6.0f), 0);
            msgView.setText("99+");
        } else {
            layoutParams.width = -2;
            msgView.setPadding((int) (f2 * 6.0f), 0, (int) (f2 * 6.0f), 0);
            msgView.setText(i + "");
        }
        msgView.setLayoutParams(layoutParams);
    }
}

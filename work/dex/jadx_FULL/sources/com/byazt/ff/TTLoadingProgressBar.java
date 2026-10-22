package com.byazt.ff;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 2476})
public class TTLoadingProgressBar extends LinearLayout {
    public View c;
    public ImageView tt;
    public View ve;

    private int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View getProgressBar() {
        return this.c;
    }

    public ImageView getProgressIcon() {
        return this.tt;
    }

    public void setProgress(int i) {
        if (this.tt.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.tt.getLayoutParams()).leftMargin = c(this.c.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.c.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ve.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.ve.setLayoutParams(layoutParams2);
        requestLayout();
    }
}

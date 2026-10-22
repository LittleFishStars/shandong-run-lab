package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class AppScoreView extends LinearLayout {
    private ImageView NY;
    private ImageView NZ;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.ksad_app_score, this);
        this.NY = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.NZ = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            ImageView imageView = this.NY;
            int i = R.drawable.ksad_star_checked;
            imageView.setImageResource(i);
            this.NZ.setImageResource(i);
            return;
        }
        if (d > 4.0d) {
            this.NY.setImageResource(R.drawable.ksad_star_checked);
            this.NZ.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d > 3.5d) {
            this.NY.setImageResource(R.drawable.ksad_star_checked);
            this.NZ.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.NY.setImageResource(R.drawable.ksad_star_half);
            this.NZ.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            ImageView imageView2 = this.NY;
            int i2 = R.drawable.ksad_star_unchecked;
            imageView2.setImageResource(i2);
            this.NZ.setImageResource(i2);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}

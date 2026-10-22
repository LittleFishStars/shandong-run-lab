package com.kc.cw.ad.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.cw.ad.internal.q;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38829a;
    private TextView b;
    private String c;
    private AnimationDrawable d;

    public b(Context context, int i, float f, float f2, int i2) {
        super(context);
        this.f38829a = false;
        a(context, i, f, f2, i2);
    }

    public void a() {
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void a(Context context, int i, float f, float f2, int i2) {
        if (this.f38829a) {
            return;
        }
        this.f38829a = true;
        setGravity(1);
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        int i3 = (int) (((double) i) * 0.5d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        if (i2 == 0) {
            imageView.setImageResource(R.drawable.ss_anim_shake);
        } else {
            int iApplyDimension = (int) TypedValue.applyDimension(1, 3.0f, q.a().r());
            layoutParams.setMargins(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
            imageView.setImageResource(R.drawable.ss_anim_rotate);
            imageView.setBackgroundResource(R.drawable.ss_bg_rotate);
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, q.a().r());
            imageView.setPadding(iApplyDimension2, (int) TypedValue.applyDimension(1, f2 * 6.0f, q.a().r()), iApplyDimension2, iApplyDimension2);
        }
        this.d = (AnimationDrawable) imageView.getDrawable();
        addView(imageView, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.getPaint().setFakeBoldText(true);
        this.b.setGravity(1);
        this.b.setTextColor(-1);
        this.b.setTextSize(2, f);
        this.b.setText(this.c);
        this.b.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        addView(this.b, layoutParams2);
    }

    public void b() {
        AnimationDrawable animationDrawable = this.d;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void setTitleText(String str) {
        this.c = str;
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }
}

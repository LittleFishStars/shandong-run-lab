package com.kc.aw.component.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw._lz;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgShakeView extends LinearLayout {
    public ImageView _a;
    public TextView _b;
    public int _c;
    public _lz _d;
    public final int[] _e;
    public final int[] _f;
    public final int[] _g;
    public final int[] _h;

    public PtgShakeView(Context context) {
        super(context);
        this._e = new int[]{20, 70};
        this._f = new int[]{5, 10};
        this._g = new int[]{8, 14};
        this._h = new int[]{5, 10};
        _a(context);
    }

    public PtgShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._e = new int[]{20, 70};
        this._f = new int[]{5, 10};
        this._g = new int[]{8, 14};
        this._h = new int[]{5, 10};
        _a(context);
    }

    public PtgShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._e = new int[]{20, 70};
        this._f = new int[]{5, 10};
        this._g = new int[]{8, 14};
        this._h = new int[]{5, 10};
        _a(context);
    }

    public final void _a(Context context) {
        this._c = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setGravity(17);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setGravity(17);
        Context context2 = getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 100.0f, context2.getResources().getDisplayMetrics()));
        gradientDrawable.setColor(-1724697805);
        linearLayout.setBackground(gradientDrawable);
        addView(linearLayout);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        ImageView imageView = new ImageView(context);
        int i = this._c;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        imageView.setImageResource(R.drawable.aw_icon_shark);
        imageView.setPadding(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        imageView.setRotation(0.0f);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this._a = imageView;
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setText("摇动手机 了解更多");
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setTextSize(1, 16.0f);
        textView.setGravity(17);
        textView.setPadding(0, (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()), 0, 0);
        textView.setShadowLayer((int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()), 0.0f, (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()), Color.parseColor("#A0000000"));
        this._b = textView;
        addView(textView);
        _lz _lzVar = this._d;
        if (_lzVar != null) {
            _lzVar.cancel();
            this._d = null;
        }
        float f = this._c / 2.0f;
        _lz _lzVar2 = new _lz(f, f);
        this._d = _lzVar2;
        _lzVar2.setDuration(800L);
        this._d.setRepeatMode(2);
        this._d.setRepeatCount(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ImageView imageView;
        super.onAttachedToWindow();
        if (getVisibility() != 0 || (imageView = this._a) == null || this._d == null) {
            return;
        }
        imageView.clearAnimation();
        this._a.startAnimation(this._d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this._a;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            ImageView imageView = this._a;
            if (imageView != null) {
                imageView.clearAnimation();
                return;
            }
            return;
        }
        ImageView imageView2 = this._a;
        if (imageView2 == null || this._d == null) {
            return;
        }
        imageView2.clearAnimation();
        this._a.startAnimation(this._d);
    }
}

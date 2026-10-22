package com.kc.aw;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.gyf.immersionbar.b;
import com.ipd.dsp.internal.i.q;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _k4 extends ViewGroup implements View.OnClickListener {
    public LinearLayout _a;
    public TextView _b;
    public ImageView _c;
    public LinearLayout _d;
    public ImageView _e;
    public TextView _f;
    public LinearLayout _g;
    public TextView _h;
    public TextView _i;
    public View _j;
    public View _k;
    public boolean _l;
    public int _m;
    public int _n;
    public int _o;
    public ViewGroup.LayoutParams _p;
    public int _q;
    public int _r;
    public CharSequence _s;

    @Keep
    public interface _a {
        void _a();
    }

    public _k4(Context context) {
        super(context);
        this._q = 23;
        _a(context);
    }

    public _k4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._q = 23;
        _a(context);
    }

    public _k4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._q = 23;
        _a(context);
    }

    public static int _a(int i) {
        return (int) ((i * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean _a(Window window) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean _b(Window window) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField(b.o).getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void _a() {
        this._g.addView(this._h);
        this._g.addView(this._i);
        addView(this._g);
    }

    public final void _a(Context context) {
        this._m = getResources().getDisplayMetrics().widthPixels;
        if (this._l) {
            this._n = getStatusBarHeight();
        }
        this._o = _a(50);
        this._a = new LinearLayout(context);
        this._b = new TextView(context);
        this._c = new ImageView(context);
        this._g = new LinearLayout(context);
        this._e = new ImageView(context);
        this._f = new TextView(context);
        this._d = new LinearLayout(context);
        this._k = new View(context);
        this._p = new ViewGroup.LayoutParams(-2, -1);
        this._g.setGravity(17);
        this._g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this._a.setGravity(16);
        this._b.setTextSize(16.0f);
        this._b.setSingleLine();
        this._b.setGravity(16);
        this._b.setPadding(_a(10), 0, _a(15), 0);
        this._b.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(_a(44), _a(22));
        layoutParams.setMargins(_a(10), 0, 0, 0);
        this._c.setScaleType(ImageView.ScaleType.FIT_START);
        this._c.setLayoutParams(layoutParams);
        this._d.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(_a(19), _a(19));
        layoutParams2.setMargins(0, 0, _a(4), 0);
        this._e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this._e.setLayoutParams(layoutParams2);
        this._e.setVisibility(8);
        this._f.setTextSize(16.0f);
        this._f.setTextColor(-11908534);
        this._f.setSingleLine();
        this._f.setGravity(16);
        this._h = new TextView(context);
        this._i = new TextView(context);
        this._h.setTextSize(18.0f);
        this._h.setSingleLine();
        this._h.setGravity(17);
        this._h.setEllipsize(TextUtils.TruncateAt.END);
        this._i.setTextSize(12.0f);
        this._i.setSingleLine();
        this._i.setGravity(17);
        this._i.setEllipsize(TextUtils.TruncateAt.END);
        this._d.setPadding(0, 0, _a(15), 0);
        _b();
        _a();
        _c();
        addView(this._k, new ViewGroup.LayoutParams(-1, 1));
    }

    public final void _a(Window window, boolean z) {
        setImmersive(z);
        try {
            _c(window);
        } catch (Exception unused) {
        }
    }

    public void _b() {
        this._a.addView(this._c);
        addView(this._a, this._p);
    }

    public void _c() {
        this._d.addView(this._e);
        this._d.addView(this._f);
        addView(this._d, this._p);
    }

    public final void _c(Window window) {
        if (Build.VERSION.SDK_INT < this._q) {
            if (_b(window)) {
                return;
            }
            _a(window);
        } else if (window != null) {
            Class<?> cls = window.getClass();
            try {
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i = cls2.getField(b.o).getInt(cls2);
                    Class<?> cls3 = Integer.TYPE;
                    cls.getMethod("setExtraFlags", cls3, cls3).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                    window.getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
                } catch (Exception unused) {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public int getActionCount() {
        return this._d.getChildCount();
    }

    public int getDefaultTitleBarHeight() {
        return ((int) ((this._n / Resources.getSystem().getDisplayMetrics().density) + 0.5f)) + 50;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof _a) {
            ((_a) tag)._a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        int measuredWidth;
        int i5;
        int i6;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3 = this._a;
        linearLayout3.layout(0, this._n, linearLayout3.getMeasuredWidth(), this._a.getMeasuredHeight() + this._n);
        LinearLayout linearLayout4 = this._d;
        linearLayout4.layout(this._m - linearLayout4.getMeasuredWidth(), this._n, this._m, this._d.getMeasuredHeight() + this._n);
        if (this._a.getMeasuredWidth() > this._d.getMeasuredWidth()) {
            linearLayout = this._g;
            measuredWidth = this._a.getMeasuredWidth();
            i5 = this._n;
            i6 = this._m;
            linearLayout2 = this._a;
        } else {
            linearLayout = this._g;
            measuredWidth = this._d.getMeasuredWidth();
            i5 = this._n;
            i6 = this._m;
            linearLayout2 = this._d;
        }
        linearLayout.layout(measuredWidth, i5, i6 - linearLayout2.getMeasuredWidth(), getMeasuredHeight());
        this._k.layout(0, getMeasuredHeight() - this._k.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size;
        LinearLayout linearLayout;
        int i3;
        LinearLayout linearLayout2;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            int i4 = this._o;
            size = this._n + i4;
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            size = View.MeasureSpec.getSize(i2) + this._n;
        }
        measureChild(this._a, i, i2);
        measureChild(this._d, i, i2);
        if (this._a.getMeasuredWidth() > this._d.getMeasuredWidth()) {
            linearLayout = this._g;
            i3 = this._m;
            linearLayout2 = this._a;
        } else {
            linearLayout = this._g;
            i3 = this._m;
            linearLayout2 = this._d;
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i3 - (linearLayout2.getMeasuredWidth() * 2), 1073741824), i2);
        measureChild(this._k, i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
    }

    public void setActionImageViewVisibility(int i) {
    }

    public void setActionText(String str) {
        TextUtils.isEmpty(str);
    }

    public void setActionTextColor(int i) {
    }

    public void setActionTextVisibility(int i) {
    }

    public void setCenterClickListener(View.OnClickListener onClickListener) {
        this._g.setOnClickListener(onClickListener);
    }

    public void setCustomTitle(View view) {
        if (view == null) {
            this._h.setVisibility(0);
            View view2 = this._j;
            if (view2 != null) {
                this._g.removeView(view2);
                return;
            }
            return;
        }
        View view3 = this._j;
        if (view3 != null) {
            this._g.removeView(view3);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this._j = view;
        this._g.addView(view, layoutParams);
        this._h.setVisibility(8);
    }

    public void setDivider(Drawable drawable) {
        this._k.setBackgroundDrawable(drawable);
    }

    public void setDividerColor(int i) {
        this._k.setBackgroundColor(i);
    }

    public void setDividerHeight(int i) {
        this._k.getLayoutParams().height = i;
    }

    public void setHeight(int i) {
        this._o = i;
        setMeasuredDimension(getMeasuredWidth(), this._o);
    }

    public void setImmersive(boolean z) {
        this._l = z;
        this._n = z ? getStatusBarHeight() : 0;
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        this._a.setOnClickListener(onClickListener);
    }

    public void setLeftImageResource(int i) {
        this._r = i;
        ImageView imageView = this._c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setLeftStatus(boolean z) {
        TextView textView = this._b;
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setText(this._s);
            this._b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setText("");
            this._b.setCompoundDrawablesWithIntrinsicBounds(this._r, 0, 0, 0);
        }
    }

    public void setLeftText(int i) {
        this._b.setText(i);
    }

    public void setLeftText(CharSequence charSequence) {
        this._s = charSequence;
        this._b.setText(charSequence);
    }

    public void setLeftTextColor(int i) {
        this._b.setTextColor(i);
    }

    public void setLeftTextColorByDrawable(int i) {
        ColorStateList colorStateList = getContext().getResources().getColorStateList(i);
        if (colorStateList != null) {
            this._b.setTextColor(colorStateList);
        }
    }

    public void setLeftTextSize(float f) {
        this._b.setTextSize(f);
    }

    public void setLeftVisible(boolean z) {
        this._b.setVisibility(z ? 0 : 8);
    }

    public void setOnTitleClickListener(View.OnClickListener onClickListener) {
        this._h.setOnClickListener(onClickListener);
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        this._d.setOnClickListener(onClickListener);
    }

    public void setRightImageResource(int i) {
        ImageView imageView = this._e;
        if (imageView == null || i <= 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
            this._e.setVisibility(0);
        }
    }

    public void setRightText(CharSequence charSequence) {
        this._f.setText(charSequence);
    }

    public void setRightTextColor(int i) {
        this._f.setTextColor(i);
    }

    public void setRightTextColorByDrawable(int i) {
        ColorStateList colorStateList = getContext().getResources().getColorStateList(i);
        if (colorStateList != null) {
            this._f.setTextColor(colorStateList);
        }
    }

    public void setRightTextSize(float f) {
        this._f.setTextSize(f);
    }

    public void setSubTitleColor(int i) {
        this._i.setTextColor(i);
    }

    public void setSubTitleSize(float f) {
        this._i.setTextSize(f);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        CharSequence charSequenceSubSequence;
        CharSequence string;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        int iIndexOf = charSequence.toString().indexOf("\n");
        int i = 1;
        if (iIndexOf > 0) {
            charSequenceSubSequence = charSequence.subSequence(0, iIndexOf);
            string = charSequence.subSequence(iIndexOf + 1, charSequence.length());
        } else {
            int iIndexOf2 = charSequence.toString().indexOf("\t");
            if (iIndexOf2 <= 0) {
                this._h.setText(charSequence);
                this._i.setVisibility(8);
                return;
            } else {
                charSequenceSubSequence = charSequence.subSequence(0, iIndexOf2);
                StringBuilder sb_a = _jf._a(q.a.i);
                sb_a.append((Object) charSequence.subSequence(iIndexOf2 + 1, charSequence.length()));
                string = sb_a.toString();
                i = 0;
            }
        }
        this._g.setOrientation(i);
        this._h.setText(charSequenceSubSequence);
        this._i.setText(string);
        this._i.setVisibility(0);
    }

    public void setTitleBackground(int i) {
        this._h.setBackgroundResource(i);
    }

    public void setTitleColor(int i) {
        this._h.setTextColor(i);
    }

    public void setTitleSize(float f) {
        this._h.setTextSize(f);
    }
}

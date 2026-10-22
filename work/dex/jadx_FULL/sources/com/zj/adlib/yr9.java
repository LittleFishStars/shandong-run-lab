package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class yr9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46102a = "ViewUtil";

    public static void a(TextView... views) {
        if (views == null) {
            return;
        }
        for (TextView textView : views) {
            u(textView, "");
        }
    }

    public static void b(View... views) {
        p(false, views);
    }

    public static int c(float dipValue) {
        return (int) ((dipValue * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void d(View... views) {
        p(true, views);
    }

    public static <T extends View> T e(View view, int i) {
        if (view == null) {
            return null;
        }
        return (T) view.findViewById(i);
    }

    public static Rect f(Paint paint, String content) {
        if (TextUtils.isEmpty(content)) {
            return new Rect();
        }
        Rect rect = new Rect();
        paint.getTextBounds(content, 0, content.length(), rect);
        return rect;
    }

    public static int g(Paint paint, String content) {
        return f(paint, content).height();
    }

    public static int h(Paint paint, String content) {
        return f(paint, content).width();
    }

    public static void i(View rootView, int id) {
        if (rootView == null) {
            return;
        }
        j(rootView.findViewById(id));
    }

    public static void j(View... views) {
        for (View view : views) {
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public static void k(View... views) {
        for (View view : views) {
            if (view != null) {
                view.setVisibility(4);
            }
        }
    }

    public static boolean l(TextView textView) {
        if (textView == null) {
            return true;
        }
        return TextUtils.isEmpty(textView.getText().toString());
    }

    public static int m(float pxValue) {
        return (int) ((pxValue / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void n(Context ctx, int drawableId, TextView tv) {
        if (drawableId <= 0 || tv == null) {
            return;
        }
        Drawable drawable = ctx.getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(drawable, null, null, null);
    }

    public static void o(Context ctx, int drawableId, TextView tv) {
        if (drawableId <= 0 || tv == null) {
            return;
        }
        Drawable drawable = ctx.getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, drawable, null, null);
    }

    public static void p(boolean enable, View... views) {
        for (View view : views) {
            if (view != null) {
                view.setEnabled(enable);
            }
        }
    }

    public static void q(ImageView view, @DrawableRes int resID) {
        if (view == null) {
            return;
        }
        view.setBackgroundResource(resID);
    }

    public static void r(ImageView view, @DrawableRes int resID) {
        if (view == null) {
            return;
        }
        view.setImageResource(resID);
    }

    public static void s(View rootView, int textViewID, String content) {
        if (rootView == null) {
            return;
        }
        ((TextView) rootView.findViewById(textViewID)).setText(content);
    }

    public static void t(TextView view, int content) {
        if (view == null) {
            return;
        }
        view.setText(content + "");
    }

    public static void u(TextView view, String content) {
        if (view == null) {
            return;
        }
        view.setText(content);
    }

    public static void v(TextView view, @StringRes int resID) {
        if (view == null) {
            return;
        }
        view.setText(resID);
        view.setVisibility(0);
    }

    public static void w(TextView view, String content) {
        if (view == null) {
            return;
        }
        view.setText(content);
        view.setVisibility(0);
    }

    public static void x(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static String y(TextView textView) {
        return textView == null ? "" : textView.getText().toString();
    }

    public static void z(View... views) {
        for (View view : views) {
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }
}

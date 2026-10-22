package com.blankj.utilcode.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class SnackbarUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Snackbar> f28177a = null;
    public static final int g = -2;
    public static final int h = -1;
    public static final int i = 0;
    public static final int j = -16777217;
    public static final int k = -13912576;
    public static final int l = -16128;
    public static final int m = -65536;
    public static final int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f1344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1346a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f1347b;
    public int c;
    public int d;
    public int e;
    public int f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    public SnackbarUtils(View view) {
        k();
        this.f1345a = view;
    }

    public static void a(@LayoutRes int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        View viewE = e();
        if (viewE != null) {
            viewE.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) viewE).addView(LayoutInflater.from(viewE.getContext()).inflate(i2, (ViewGroup) null), -1, layoutParams);
        }
    }

    public static void b(@NonNull View view, @NonNull ViewGroup.LayoutParams layoutParams) {
        View viewE = e();
        if (viewE != null) {
            viewE.setPadding(0, 0, 0, 0);
            ((Snackbar.SnackbarLayout) viewE).addView(view, layoutParams);
        }
    }

    public static void c() {
        WeakReference<Snackbar> weakReference = f28177a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        f28177a.get().dismiss();
        f28177a = null;
    }

    public static ViewGroup d(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public static View e() {
        Snackbar snackbar = f28177a.get();
        if (snackbar == null) {
            return null;
        }
        return snackbar.getView();
    }

    public static SnackbarUtils w(@NonNull View view) {
        return new SnackbarUtils(view);
    }

    public SnackbarUtils f(@NonNull CharSequence charSequence, @ColorInt int i2, @NonNull View.OnClickListener onClickListener) {
        this.f1347b = charSequence;
        this.e = i2;
        this.f1344a = onClickListener;
        return this;
    }

    public SnackbarUtils g(@NonNull CharSequence charSequence, @NonNull View.OnClickListener onClickListener) {
        return f(charSequence, -16777217, onClickListener);
    }

    public SnackbarUtils h(@ColorInt int i2) {
        this.b = i2;
        return this;
    }

    public SnackbarUtils i(@DrawableRes int i2) {
        this.c = i2;
        return this;
    }

    public SnackbarUtils j(@IntRange(from = 1) int i2) {
        this.f = i2;
        return this;
    }

    public final void k() {
        this.f1346a = "";
        this.f1343a = -16777217;
        this.b = -16777217;
        this.c = -1;
        this.d = -1;
        this.f1347b = "";
        this.e = -16777217;
        this.f = 0;
    }

    public SnackbarUtils l(int i2) {
        this.d = i2;
        return this;
    }

    public SnackbarUtils m(@NonNull CharSequence charSequence) {
        this.f1346a = charSequence;
        return this;
    }

    public SnackbarUtils n(@ColorInt int i2) {
        this.f1343a = i2;
        return this;
    }

    public Snackbar o() {
        return p(false);
    }

    public Snackbar p(boolean z) {
        View view = this.f1345a;
        if (view == null) {
            return null;
        }
        if (z) {
            ViewGroup viewGroupD = d(view);
            View viewFindViewWithTag = viewGroupD.findViewWithTag("topSnackBarCoordinatorLayout");
            if (viewFindViewWithTag == null) {
                viewFindViewWithTag = new CoordinatorLayout(view.getContext());
                viewFindViewWithTag.setTag("topSnackBarCoordinatorLayout");
                viewFindViewWithTag.setRotation(180.0f);
                viewFindViewWithTag.setElevation(100.0f);
                viewGroupD.addView(viewFindViewWithTag, -1, -1);
            }
            view = viewFindViewWithTag;
        }
        if (this.f1343a != -16777217) {
            SpannableString spannableString = new SpannableString(this.f1346a);
            spannableString.setSpan(new ForegroundColorSpan(this.f1343a), 0, spannableString.length(), 33);
            f28177a = new WeakReference<>(Snackbar.make(view, spannableString, this.d));
        } else {
            f28177a = new WeakReference<>(Snackbar.make(view, this.f1346a, this.d));
        }
        Snackbar snackbar = f28177a.get();
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        if (z) {
            for (int i2 = 0; i2 < snackbarLayout.getChildCount(); i2++) {
                snackbarLayout.getChildAt(i2).setRotation(180.0f);
            }
        }
        int i3 = this.c;
        if (i3 != -1) {
            snackbarLayout.setBackgroundResource(i3);
        } else {
            int i4 = this.b;
            if (i4 != -16777217) {
                snackbarLayout.setBackgroundColor(i4);
            }
        }
        if (this.f != 0) {
            ((ViewGroup.MarginLayoutParams) snackbarLayout.getLayoutParams()).bottomMargin = this.f;
        }
        if (this.f1347b.length() > 0 && this.f1344a != null) {
            int i5 = this.e;
            if (i5 != -16777217) {
                snackbar.setActionTextColor(i5);
            }
            snackbar.setAction(this.f1347b, this.f1344a);
        }
        snackbar.show();
        return snackbar;
    }

    public void q() {
        r(false);
    }

    public void r(boolean z) {
        this.b = -65536;
        this.f1343a = -1;
        this.e = -1;
        p(z);
    }

    public void s() {
        t(false);
    }

    public void t(boolean z) {
        this.b = k;
        this.f1343a = -1;
        this.e = -1;
        p(z);
    }

    public void u() {
        v(false);
    }

    public void v(boolean z) {
        this.b = l;
        this.f1343a = -1;
        this.e = -1;
        p(z);
    }
}

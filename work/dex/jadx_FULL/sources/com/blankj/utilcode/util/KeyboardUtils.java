package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class KeyboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28140a = -8;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long f1272a;
    public static int b;

    public interface OnSoftInputChangedListener {
        void a(int i);
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f28141a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnSoftInputChangedListener f1273a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int[] f1274a;

        public a(Window window, int[] iArr, OnSoftInputChangedListener onSoftInputChangedListener) {
            this.f28141a = window;
            this.f1274a = iArr;
            this.f1273a = onSoftInputChangedListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i = KeyboardUtils.i(this.f28141a);
            if (this.f1274a[0] != i) {
                this.f1273a.a(i);
                this.f1274a[0] = i;
            }
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f28142a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Window f1275a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ int[] f1276a;

        public b(Window window, int[] iArr, View view, int i) {
            this.f1275a = window;
            this.f1276a = iArr;
            this.f28142a = view;
            this.K = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iH = KeyboardUtils.h(this.f1275a);
            if (this.f1276a[0] != iH) {
                View view = this.f28142a;
                view.setPadding(view.getPaddingLeft(), this.f28142a.getPaddingTop(), this.f28142a.getPaddingRight(), this.K + KeyboardUtils.i(this.f1275a));
                this.f1276a[0] = iH;
            }
        }
    }

    public KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void c() {
        Log.i("KeyboardUtils", "Please refer to the following code.");
    }

    public static void d(@NonNull Activity activity) {
        e(activity.getWindow());
    }

    public static void e(@NonNull Window window) {
        window.setSoftInputMode(window.getAttributes().softInputMode & (-17));
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        View childAt = frameLayout.getChildAt(0);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b(window, new int[]{h(window)}, childAt, childAt.getPaddingBottom()));
    }

    public static void f(@NonNull Activity activity) {
        g(activity.getWindow());
    }

    public static void g(@NonNull Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 4; i++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int h(Window window) {
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById == null) {
            return 0;
        }
        Rect rect = new Rect();
        viewFindViewById.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (viewFindViewById.getBottom() - rect.bottom));
        int iAbs = Math.abs(viewFindViewById.getBottom() - rect.bottom);
        if (iAbs <= i.d0() + i.Z()) {
            return 0;
        }
        return iAbs;
    }

    public static int i(@NonNull Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs > i.Z() + i.d0()) {
            return iAbs - b;
        }
        b = iAbs;
        return 0;
    }

    public static void j(@NonNull Activity activity) {
        l(activity.getWindow());
    }

    public static void k(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void l(@NonNull Window window) {
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            View viewFindViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (viewFindViewWithTag == null) {
                viewFindViewWithTag = new EditText(window.getContext());
                viewFindViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(viewFindViewWithTag, 0, 0);
            }
            currentFocus = viewFindViewWithTag;
            currentFocus.requestFocus();
        }
        k(currentFocus);
    }

    public static void m(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(jElapsedRealtime - f1272a) > 500 && n(activity)) {
            u();
        }
        f1272a = jElapsedRealtime;
    }

    public static boolean n(@NonNull Activity activity) {
        return i(activity.getWindow()) > 0;
    }

    public static void o(@NonNull Activity activity, @NonNull OnSoftInputChangedListener onSoftInputChangedListener) {
        p(activity.getWindow(), onSoftInputChangedListener);
    }

    public static void p(@NonNull Window window, @NonNull OnSoftInputChangedListener onSoftInputChangedListener) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        a aVar = new a(window, new int[]{i(window)}, onSoftInputChangedListener);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        frameLayout.setTag(-8, aVar);
    }

    public static void q() {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void r(@NonNull Activity activity) {
        if (n(activity)) {
            return;
        }
        u();
    }

    public static void s(@NonNull View view) {
        t(view, 0);
    }

    public static void t(@NonNull View view, int i) {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i, new ResultReceiver(new Handler()) { // from class: com.blankj.utilcode.util.KeyboardUtils.1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i2, Bundle bundle) {
                if (i2 == 1 || i2 == 3) {
                    KeyboardUtils.u();
                }
            }
        });
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void u() {
        InputMethodManager inputMethodManager = (InputMethodManager) Utils.a().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void v(@NonNull Window window) {
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById == null) {
            return;
        }
        Object tag = viewFindViewById.getTag(-8);
        if (tag instanceof ViewTreeObserver.OnGlobalLayoutListener) {
            viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
        }
    }
}

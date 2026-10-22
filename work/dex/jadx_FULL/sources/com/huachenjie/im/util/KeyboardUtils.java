package com.huachenjie.im.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KeyboardUtils implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int K = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<SoftKeyboardToggleListener, KeyboardUtils> f34585a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f9904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f9905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SoftKeyboardToggleListener f9906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f9907a = null;

    public interface SoftKeyboardToggleListener {
        void a(boolean z);
    }

    public KeyboardUtils(Activity activity, SoftKeyboardToggleListener softKeyboardToggleListener) {
        this.f9906a = softKeyboardToggleListener;
        View childAt = ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0);
        this.f9905a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f9904a = activity.getResources().getDisplayMetrics().density;
    }

    public static void a(Activity activity, SoftKeyboardToggleListener softKeyboardToggleListener) {
        d(softKeyboardToggleListener);
        f34585a.put(softKeyboardToggleListener, new KeyboardUtils(activity, softKeyboardToggleListener));
    }

    public static void b(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void c() {
        Iterator<SoftKeyboardToggleListener> it = f34585a.keySet().iterator();
        while (it.hasNext()) {
            f34585a.get(it.next()).e();
        }
        f34585a.clear();
    }

    public static void d(SoftKeyboardToggleListener softKeyboardToggleListener) {
        if (f34585a.containsKey(softKeyboardToggleListener)) {
            f34585a.get(softKeyboardToggleListener).e();
            f34585a.remove(softKeyboardToggleListener);
        }
    }

    public static void f(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    public final void e() {
        this.f9906a = null;
        this.f9905a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f9905a.getWindowVisibleDisplayFrame(rect);
        boolean z = ((float) (this.f9905a.getRootView().getHeight() - (rect.bottom - rect.top))) / this.f9904a > 200.0f;
        if (this.f9906a != null) {
            Boolean bool = this.f9907a;
            if (bool == null || z != bool.booleanValue()) {
                this.f9907a = Boolean.valueOf(z);
                this.f9906a.a(z);
            }
        }
    }
}

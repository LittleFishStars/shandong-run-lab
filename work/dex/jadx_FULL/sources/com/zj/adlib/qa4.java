package com.zj.adlib;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¨\u0006\b"}, d2 = {"Landroid/view/View;", "view", "", "c", "", "delay", "d", "b", "common_release"}, k = 2, mv = {1, 8, 0})
public final class qa4 {
    public static final void b(@Nullable View view) {
        Context context;
        Object systemService = (view == null || (context = view.getContext()) == null) ? null : context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final void c(@Nullable View view) {
        Context context;
        Object systemService = (view == null || (context = view.getContext()) == null) ? null : context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 1);
    }

    public static final void d(@Nullable final View view, long j) {
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.zj.adlib.pa4
                @Override // java.lang.Runnable
                public final void run() {
                    qa4.e(view);
                }
            }, j);
        }
    }

    public static final void e(View view) {
        c(view);
    }
}

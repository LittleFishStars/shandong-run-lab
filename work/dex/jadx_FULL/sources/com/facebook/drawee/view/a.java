package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: com.facebook.drawee.view.a$a, reason: collision with other inner class name */
    public static class C0635a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29980a;
        public int b;
    }

    public static boolean a(int i) {
        return i == 0 || i == -2;
    }

    public static void b(C0635a c0635a, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f <= 0.0f || layoutParams == null) {
            return;
        }
        if (a(layoutParams.height)) {
            c0635a.b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0635a.f29980a) - i) / f) + i2), c0635a.b), 1073741824);
        } else if (a(layoutParams.width)) {
            c0635a.f29980a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0635a.b) - i2) * f) + i), c0635a.f29980a), 1073741824);
        }
    }
}

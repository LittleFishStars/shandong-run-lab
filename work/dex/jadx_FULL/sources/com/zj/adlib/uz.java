package com.zj.adlib;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.Utils;
import com.gyf.immersionbar.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class uz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Field> f45254a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            uz.l();
        }
    }

    public uz() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @NonNull
    public static Resources b(@NonNull Resources resources, int i) {
        return c(resources, i, false);
    }

    @NonNull
    public static Resources c(@NonNull Resources resources, int i, boolean z) {
        e(resources, ((resources.getDisplayMetrics().heightPixels + (z ? j(resources) : 0)) * 72.0f) / i);
        return resources;
    }

    @NonNull
    public static Resources d(@NonNull Resources resources, int i) {
        e(resources, (resources.getDisplayMetrics().widthPixels * 72.0f) / i);
        return resources;
    }

    public static void e(@NonNull Resources resources, float f) {
        resources.getDisplayMetrics().xdpi = f;
        Utils.a().getResources().getDisplayMetrics().xdpi = f;
        g(resources, f);
    }

    public static void f(Resources resources, float f) {
        Iterator<Field> it = f45254a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void g(Resources resources, float f) {
        if (f45254a != null) {
            f(resources, f);
            return;
        }
        f45254a = new ArrayList();
        Class<?> superclass = resources.getClass();
        Field[] declaredFields = superclass.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics displayMetricsI = i(resources, field);
                    if (displayMetricsI != null) {
                        f45254a.add(field);
                        displayMetricsI.xdpi = f;
                    }
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return;
            } else {
                declaredFields = superclass.getDeclaredFields();
            }
        }
    }

    @NonNull
    public static Resources h(@NonNull Resources resources) {
        e(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f);
        return resources;
    }

    public static DisplayMetrics i(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int j(@NonNull Resources resources) {
        int identifier = resources.getIdentifier(b.f6803b, "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Runnable k() {
        return new a();
    }

    public static void l() {
        e(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }

    public static int m(float f) {
        return (int) (((double) ((f * Utils.a().getResources().getDisplayMetrics().xdpi) / 72.0f)) + 0.5d);
    }

    public static int n(float f) {
        return (int) (((double) ((f * 72.0f) / Utils.a().getResources().getDisplayMetrics().xdpi)) + 0.5d);
    }
}

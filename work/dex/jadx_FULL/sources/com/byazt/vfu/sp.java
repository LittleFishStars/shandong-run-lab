package com.byazt.vfu;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 91})
public class sp {
    public static void c(ProgressBar progressBar, Drawable drawable) {
        c(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    public static void tt(AlertDialog alertDialog) {
        Window window;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setFlags(1024, 1024);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        window.clearFlags(2);
        alertDialog.setCanceledOnTouchOutside(true);
    }

    private static void c(Object obj, String str, Object obj2) {
        try {
            Field fieldC = c(obj, str);
            if (fieldC != null) {
                c(fieldC);
                fieldC.set(obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
        } catch (Throwable unused) {
        }
    }

    public static void tt(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        activity.requestWindowFeature(1);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.clearFlags(134217728);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.type = 2;
        window.setAttributes(attributes);
        window.setStatusBarColor(Color.parseColor("#000000"));
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.setWindowAnimations(0);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#88000000")));
    }

    private static Field c(Object obj, String str) {
        return c((Class) obj.getClass(), str);
    }

    private static Field c(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void c(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }

    public static void c(AlertDialog alertDialog) {
        Window window;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.requestWindowFeature(1);
        window.setDimAmount(0.5f);
    }

    public static void c(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        activity.requestWindowFeature(1);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.clearFlags(134217728);
        window.setBackgroundDrawable(new ColorDrawable(-1));
        window.setStatusBarColor(-16777216);
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
    }
}

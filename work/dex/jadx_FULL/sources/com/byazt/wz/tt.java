package com.byazt.wz;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.byazt.nr.m;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 13})
public class tt {
    public static Activity c(View view) {
        if (view == null) {
            return null;
        }
        Activity activityC = c(view.getContext());
        if (activityC != null) {
            return activityC;
        }
        Object parent = view.getParent();
        if ((parent instanceof View) && (activityC = c((View) parent)) != null) {
            return activityC;
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return activityC;
        }
        Context context = rootView.getContext();
        Activity activityC2 = c(context);
        return activityC2 != null ? activityC2 : tt(context);
    }

    private static Activity tt(Context context) {
        if (context != null && context.getClass().getName().contains("DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivity");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                if (obj instanceof Activity) {
                    return (Activity) obj;
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        return null;
    }

    private static Activity c(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == null || baseContext == context) {
            return null;
        }
        return c(baseContext);
    }
}

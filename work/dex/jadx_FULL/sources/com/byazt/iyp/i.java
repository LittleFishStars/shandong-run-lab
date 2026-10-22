package com.byazt.iyp;

import android.view.View;
import android.widget.AbsListView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 42})
public final class i {
    public static volatile Class<?> c;
    public static boolean n;
    public static volatile Class<?> tt;
    public static boolean uj;
    public static Method ve;

    public static void c(JSONObject jSONObject, View view, int i) {
        if (jSONObject == null || view == null) {
            return;
        }
        int i2 = 0;
        View view2 = view;
        while (view2 != null) {
            int i3 = i2 + 1;
            if (i2 >= i) {
                return;
            }
            try {
                String name = view2.getClass().getName();
                if (c(view2)) {
                    jSONObject.put("list_component_type", name);
                    jSONObject.put("adapter_position", c(view2, tt(view2, view)));
                    return;
                } else if (view2 instanceof AbsListView) {
                    jSONObject.put("list_component_type", name);
                    jSONObject.put("adapter_position", ((AbsListView) view2).getPositionForView(view));
                    return;
                } else {
                    Object parent = view2.getParent();
                    view2 = parent instanceof View ? (View) parent : null;
                    i2 = i3;
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }

    private static View tt(Object obj, View view) {
        if (obj != null && view != null) {
            View view2 = view;
            while (view2 != null) {
                Object parent = view2.getParent();
                if (parent == obj) {
                    return view2;
                }
                view2 = parent instanceof View ? (View) parent : null;
            }
        }
        return view;
    }

    private static boolean c(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Class<?> cls = c;
            if (cls == null) {
                try {
                    cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
                    c = cls;
                } catch (Throwable unused) {
                }
            }
            if (cls != null && cls.isInstance(obj)) {
                return true;
            }
            Class<?> cls2 = tt;
            if (cls2 == null) {
                try {
                    cls2 = Class.forName("androidx.recyclerview.widget.RecyclerView");
                    tt = cls2;
                } catch (Throwable unused2) {
                }
            }
            if (cls2 != null && cls2.isInstance(obj)) {
                return true;
            }
            obj.getClass().getMethod("getChildAdapterPosition", View.class);
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }

    private static Integer c(Object obj, View view) {
        if (!uj && !n) {
            try {
                try {
                    ve = obj.getClass().getMethod("getChildAdapterPosition", View.class);
                } catch (NoSuchMethodException unused) {
                    n = true;
                }
                uj = true;
            } catch (Throwable th) {
                uj = true;
                throw th;
            }
        }
        Method method = ve;
        if (method != null && !n) {
            try {
                Object objInvoke = method.invoke(obj, view);
                if (objInvoke instanceof Integer) {
                    return (Integer) objInvoke;
                }
            } catch (Throwable unused2) {
                n = true;
                ve = null;
            }
        }
        return null;
    }
}

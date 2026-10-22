package com.byazt.iyp;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 158})
public final class sl {
    public static Object c(Context context) {
        Object obj;
        if (context != null) {
            try {
                if (context.getClass() == PluginActivityWrapper.class) {
                    obj = ((PluginActivityWrapper) context).mOriginActivity;
                } else {
                    obj = context.getClass() == PluginApplicationWrapper.class ? ((PluginApplicationWrapper) context).mOriginApplication : null;
                }
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }

    public static void c(JSONObject jSONObject, Activity activity) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (activity == null) {
                com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
                WeakReference<Activity> weakReferenceC = cVarVe != null ? cVarVe.c() : null;
                Activity activity2 = weakReferenceC != null ? weakReferenceC.get() : null;
                if (activity2 == null) {
                    return;
                }
                c(activity2, jSONObject);
                return;
            }
            c(activity, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void c(Activity activity, JSONObject jSONObject) {
        try {
            c(activity);
            String strA = uj.a();
            if (strA == null || strA.isEmpty()) {
                strA = " ";
            }
            jSONObject.put("t_name", strA);
            CharSequence title = activity.getTitle();
            jSONObject.put("top_page_title", title != null ? title.toString() : " ");
            jSONObject.put("has_window_focus", activity.hasWindowFocus());
            jSONObject.put("top_page_name", activity.getClass().getName());
        } catch (Throwable unused) {
        }
    }
}

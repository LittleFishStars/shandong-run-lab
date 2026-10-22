package com.ali.auth.third.ui.context;

import android.app.Activity;
import android.content.Intent;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.ui.support.ActivityResultHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CallbackContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23522a = "CallbackContext";
    public static volatile WeakReference<Activity> activity;
    public static volatile Object loginCallback;
    public static LoginCallback mGlobalLoginCallback;

    public static boolean onActivityResult(int i, int i2, Intent intent) {
        return onActivityResult(activity != null ? activity.get() : null, i, i2, intent);
    }

    public static boolean onActivityResult(Activity activity2, int i, int i2, Intent intent) {
        String str = f23522a;
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d(str, sb.toString());
        HashMap map = new HashMap();
        map.put(ActivityResultHandler.REQUEST_CODE_KEY, String.valueOf(i));
        ActivityResultHandler activityResultHandler = (ActivityResultHandler) KernelContext.getService(ActivityResultHandler.class, map);
        if (activityResultHandler == null) {
            SDKLogger.i(str, "No ActivityResultHandler handler to support the request code " + i);
            return false;
        }
        if (activity2 != null) {
            activityResultHandler.onActivityResult(1, i, i2, intent, activity2, null, null);
            return true;
        }
        SDKLogger.e(str, "No active activity is set, ignore invoke " + activityResultHandler);
        return false;
    }

    public static void setActivity(Activity activity2) {
        activity = new WeakReference<>(activity2);
    }
}

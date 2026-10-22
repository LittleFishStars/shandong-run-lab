package cn.hzjizhun.admin.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.hzjizhun.admin.util.ReflectUtil;
import com.igexin.assist.util.AssistUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReflectUtil {

    public interface DeeplinkStatusCallback {
        void onStatusChecked(boolean z);
    }

    public static void checkDeeplinkStatus(final Context context, final DeeplinkStatusCallback deeplinkStatusCallback) {
        if (context == null || !(context instanceof Activity)) {
            notifyCallback(deeplinkStatusCallback, false);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.jd7
                @Override // java.lang.Runnable
                public final void run() {
                    ReflectUtil.lambda$checkDeeplinkStatus$0(deeplinkStatusCallback, context);
                }
            }, 700L);
        }
    }

    private static int getRomType() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String lowerCase = str.toLowerCase();
            if (!"unknown".equals(lowerCase) && !"generic".equals(lowerCase) && !"android".equals(lowerCase) && !"google".equals(lowerCase) && ("xiaomi".equals(lowerCase) || AssistUtils.BRAND_HW.equals(lowerCase))) {
                return 1;
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static boolean isActivityStopped(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mStopped");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(activity)).booleanValue();
        } catch (Throwable unused) {
            ALog.e("Failed to get mStopped field, fallback to foreground check");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkDeeplinkStatus$0(DeeplinkStatusCallback deeplinkStatusCallback, Context context) {
        notifyCallback(deeplinkStatusCallback, isActivityStopped((Activity) context));
    }

    private static boolean launch(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if (getRomType() == 1) {
                    intent.addFlags(335544320);
                    if (context instanceof Application) {
                        intent.addFlags(268435456);
                    }
                    context.startActivities(new Intent[]{intent});
                    return true;
                }
                Intent intentCreateChooser = Intent.createChooser(intent, "FLAG_ACTIVITY_NEW_TASK");
                intentCreateChooser.addFlags(335544320);
                if (context instanceof Application) {
                    intentCreateChooser.addFlags(268435456);
                }
                context.startActivity(intentCreateChooser);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void notifyCallback(DeeplinkStatusCallback deeplinkStatusCallback, boolean z) {
        if (deeplinkStatusCallback != null) {
            try {
                deeplinkStatusCallback.onStatusChecked(z);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean openDeeplink(Context context, Intent intent) {
        try {
            launch(context, intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}

package cj.mobile.wm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import cj.mobile.wm.appsdkdex.WMDexAdHelper;
import cj.mobile.wm.common.utils.DebugLog;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexi {
    public static AtomicInteger dexa = new AtomicInteger(0);
    public static boolean dexb = false;

    public class dexa implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            WMDexAdHelper.setCurrentActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            dexi.dexa.incrementAndGet();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            dexi.dexa.decrementAndGet();
        }
    }

    public static void dexa(Context context) {
        if (!(context instanceof Application)) {
            DebugLog.common_w(dexc.dexa("hfuDpoufyu!jt!opu!bo!jotubodf!pg!uif!bqqmjdbujpo"));
        } else {
            dexb = true;
            ((Application) context).registerActivityLifecycleCallbacks(new dexa());
        }
    }

    public static boolean dexa() {
        return dexa.get() > 0;
    }
}

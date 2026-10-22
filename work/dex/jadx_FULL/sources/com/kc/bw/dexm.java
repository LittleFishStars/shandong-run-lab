package com.kc.bw;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.kc.bw.appsdkdex.WMDexAdHelper;
import com.kc.bw.common.utils.DebugLog;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexm {
    public static AtomicInteger dexa = new AtomicInteger(0);
    public static boolean dexb = false;

    @Keep
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
            dexm.dexa.incrementAndGet();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            dexm.dexa.decrementAndGet();
        }
    }

    public static void dexa(Context context) {
        if (!(context instanceof Application)) {
            DebugLog.common_w(dexg.dexa("hfuDpoufyu!jt!opu!bo!jotubodf!pg!uif!bqqmjdbujpo"));
        } else {
            dexb = true;
            ((Application) context).registerActivityLifecycleCallbacks(new dexa());
        }
    }

    public static boolean dexa() {
        return dexa.get() > 0;
    }
}

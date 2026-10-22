package com.kc.openset.hook;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.SSActivityLifecycleCallbacks;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class ActivityLifecycleManager {
    private static final String TAG = OSETSDKProtected.getString2(1731);
    private static volatile ActivityLifecycleManager sActivityLifecycleManager;
    private WeakReference<Activity> mTopActivity;
    private final List<SSActivityLifecycleCallbacks> mSSActivityLifecycleCallbacksList = new CopyOnWriteArrayList();
    private final Map<String, SSActivityLifecycleCallbacks> mSSActivityLifecycleCallbacksMap = new ConcurrentHashMap();
    private final Set<Integer> mStartedActivitySet = new HashSet();
    private boolean mIsInBackground = true;
    private boolean mHasInit = false;

    /* JADX INFO: renamed from: com.kc.openset.hook.ActivityLifecycleManager$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        final ActivityLifecycleManager this$0;

        public AnonymousClass1(ActivityLifecycleManager activityLifecycleManager) {
            this.this$0 = activityLifecycleManager;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityCreated(activity, bundle);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityCreated(activity, bundle);
                    }
                }
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityDestroyed(activity);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityDestroyed(activity);
                    }
                }
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityPaused(activity);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityPaused(activity);
                    }
                }
                if (ActivityLifecycleManager.access$500(this.this$0) == null || ActivityLifecycleManager.access$500(this.this$0).get() == null || !((Activity) ActivityLifecycleManager.access$500(this.this$0).get()).equals(activity)) {
                    return;
                }
                ActivityLifecycleManager.access$502(this.this$0, null);
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityResumed(activity);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityResumed(activity);
                    }
                }
                ActivityLifecycleManager.access$502(this.this$0, new WeakReference(activity));
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivitySaveInstanceState(activity, bundle);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivitySaveInstanceState(activity, bundle);
                    }
                }
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityStarted(activity);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityStarted(activity);
                    }
                }
                ActivityLifecycleManager.access$300(this.this$0).add(Integer.valueOf(activity.hashCode()));
                if (ActivityLifecycleManager.access$300(this.this$0).size() == 1) {
                    ActivityLifecycleManager.access$400(this.this$0);
                }
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            try {
                for (SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks : ActivityLifecycleManager.access$000(this.this$0)) {
                    if (sSActivityLifecycleCallbacks != null) {
                        sSActivityLifecycleCallbacks.onActivityStopped(activity);
                    }
                }
                for (Map.Entry entry : ActivityLifecycleManager.access$100(this.this$0).entrySet()) {
                    String str = (String) entry.getKey();
                    SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks2 = (SSActivityLifecycleCallbacks) entry.getValue();
                    if (str != null && str.contains(activity.getClass().getName()) && sSActivityLifecycleCallbacks2 != null) {
                        sSActivityLifecycleCallbacks2.onActivityStopped(activity);
                    }
                }
                ActivityLifecycleManager.access$300(this.this$0).remove(Integer.valueOf(activity.hashCode()));
                if (ActivityLifecycleManager.access$300(this.this$0).isEmpty()) {
                    ActivityLifecycleManager.access$600(this.this$0);
                }
            } catch (Throwable th) {
                ActivityLifecycleManager.access$200(this.this$0, th);
            }
        }
    }

    static {
        OSETSDKProtected.interface11(4430);
    }

    private ActivityLifecycleManager() {
    }

    public static native /* synthetic */ List access$000(ActivityLifecycleManager activityLifecycleManager);

    public static native /* synthetic */ Map access$100(ActivityLifecycleManager activityLifecycleManager);

    public static native /* synthetic */ void access$200(ActivityLifecycleManager activityLifecycleManager, Throwable th);

    public static native /* synthetic */ Set access$300(ActivityLifecycleManager activityLifecycleManager);

    public static native /* synthetic */ void access$400(ActivityLifecycleManager activityLifecycleManager);

    public static native /* synthetic */ WeakReference access$500(ActivityLifecycleManager activityLifecycleManager);

    public static native /* synthetic */ WeakReference access$502(ActivityLifecycleManager activityLifecycleManager, WeakReference weakReference);

    public static native /* synthetic */ void access$600(ActivityLifecycleManager activityLifecycleManager);

    public static native ActivityLifecycleManager getInstance();

    private native void lifecycleError(Throwable th);

    private native void onAppBackToForeground();

    private native void onAppGoToBackground();

    public native Activity getKsRewardActivity();

    public native Activity getTopActivity();

    public native void initLifecycle(Context context);

    public native boolean isAppOnForeground();

    public native void registerActivityLifecycleCallbacks(SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks);

    public native void registerActivityLifecycleCallbacksByName(String str, SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks);

    public native void unregisterActivityLifecycleCallbacks(SSActivityLifecycleCallbacks sSActivityLifecycleCallbacks);

    public native void unregisterActivityLifecycleCallbacksByName(String str);
}

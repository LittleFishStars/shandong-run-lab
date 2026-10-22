package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class tt {

    public static class a extends bn0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ActivityListener> f44999a;

        public a(ActivityListener activityListener) {
            this.f44999a = new WeakReference<>(activityListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ActivityListener a(Activity activity) {
            ActivityListener activityListener = this.f44999a.get();
            if (activityListener == null) {
                ax6.d(activity instanceof ListenableActivity);
                ((ListenableActivity) activity).b(this);
            }
            return activityListener;
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onActivityCreate(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onActivityCreate(activity);
            }
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onDestroy(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onDestroy(activity);
            }
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onPause(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onPause(activity);
            }
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onResume(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onResume(activity);
            }
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onStart(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onStart(activity);
            }
        }

        @Override // com.zj.adlib.bn0, com.facebook.common.activitylistener.ActivityListener
        public void onStop(Activity activity) {
            ActivityListener activityListenerA = a(activity);
            if (activityListenerA != null) {
                activityListenerA.onStop(activity);
            }
        }
    }

    public static void a(ActivityListener activityListener, Context context) {
        boolean z = context instanceof ListenableActivity;
        Object baseContext = context;
        if (!z && (context instanceof ContextWrapper)) {
            baseContext = context;
            baseContext = ((ContextWrapper) context).getBaseContext();
        }
        baseContext = context;
        if (baseContext instanceof ListenableActivity) {
            ((ListenableActivity) baseContext).a(new a(activityListener));
        }
    }
}

package com.kc.bw.appsdkdex;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.kc.bw.common.utils.ContextContainer;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMDexAdHelper {
    public static Application application;
    public static Context applicationContext;
    public static WeakReference<Activity> topActivity;
    public static final String TAG = dexg.dexa("XN`XNEfyBeIfmqfs");
    public static final String EXTRA_KEY = dexg.dexa("nbq`lfz");
    public static final LinkedHashMap<String, WeakReference<Activity>> activityMap = new LinkedHashMap<>();
    public static final LinkedHashMap<String, ViewGroup> loadViewGroupMap = new LinkedHashMap<>();

    public static WeakReference<Activity> gac() {
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference != null && weakReference.get() != null) {
            DebugLog.common_weak(dexg.dexa("hbd!upq"));
            return topActivity;
        }
        Activity activityGacref = gacref();
        if (activityGacref != null) {
            DebugLog.common_weak(dexg.dexa("hbd!sfg"));
            return new WeakReference<>(activityGacref);
        }
        DebugLog.release_e(TAG, dexg.dexa("bdujwjuz!jt!ovmm"));
        return null;
    }

    public static WeakReference<Activity> gac(View view) {
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference != null && weakReference.get() != null) {
            DebugLog.common_weak(dexg.dexa("hbd)wjfx*!upq"));
            return topActivity;
        }
        Activity activityGacView = gacView(view);
        if (activityGacView != null) {
            DebugLog.common_weak(dexg.dexa("hbd)wjfx*!wjfx"));
            return new WeakReference<>(activityGacView);
        }
        Activity activityGacref = gacref();
        if (activityGacref != null) {
            DebugLog.common_weak(dexg.dexa("hbd)wjfx*!sfg"));
            return new WeakReference<>(activityGacref);
        }
        DebugLog.release_e(TAG, dexg.dexa("bdujwjuz)wjfx*!jt!ovmm"));
        return null;
    }

    public static Activity gacView(View view) {
        try {
            if (view == null) {
                DebugLog.common_w(dexg.dexa("hbd)wjfx*!gbjm-wjfx!jt!ovmm"));
                return null;
            }
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    DebugLog.common_weak(dexg.dexa("hbd)wjfx*!pl"));
                    return activity;
                }
            }
            DebugLog.common_weak(dexg.dexa("hbd)wjfx*!gbjm-opu!gpvoe"));
            return null;
        } catch (Throwable th) {
            DebugLog.common_weak(dexg.dexa("hbd)wjfx*!gbjm-") + th);
        }
    }

    public static Activity gacref() {
        try {
            Class<?> cls = Class.forName(dexg.dexa("boespje/bqq/BdujwjuzUisfbe"));
            Object objInvoke = cls.getMethod(dexg.dexa("dvssfouBdujwjuzUisfbe"), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField(dexg.dexa("nBdujwjujft"));
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField(dexg.dexa("qbvtfe"));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(dexg.dexa("bdujwjuz"));
                    declaredField3.setAccessible(true);
                    Activity activity = (Activity) declaredField3.get(obj);
                    if (activity.getPackageName().equals(ContextContainer.getApplicationContext().getPackageName())) {
                        DebugLog.common_weak(dexg.dexa("hbd)sfg*!pl"));
                        return activity;
                    }
                }
            }
            DebugLog.common_weak(dexg.dexa("hbd)sfg*!gbjm-opu!gpvoe"));
        } catch (Throwable th) {
            DebugLog.common_weak(dexg.dexa("hbd)sfg*!gbjm-") + th);
        }
        return null;
    }

    public static Application gap() {
        Application application2 = application;
        if (application2 != null) {
            return application2;
        }
        Context applicationContext2 = ContextContainer.getApplicationContext();
        if (applicationContext2 != null && (applicationContext2 instanceof Application)) {
            Application application3 = (Application) applicationContext2;
            application = application3;
            return application3;
        }
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference != null && weakReference.get() != null) {
            DebugLog.common_weak(dexg.dexa("hbq!upq"));
            Application application4 = topActivity.get().getApplication();
            application = application4;
            return application4;
        }
        Application applicationGapref = gapref();
        application = applicationGapref;
        if (applicationGapref != null) {
            DebugLog.common_weak(dexg.dexa("hbq!sfg"));
            return application;
        }
        DebugLog.release_e(TAG, dexg.dexa("bqqmjdbujpo!jt!ovmm"));
        return null;
    }

    public static Context gapc() {
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Context applicationContext2 = ContextContainer.getApplicationContext();
        if (applicationContext2 != null) {
            applicationContext = applicationContext2;
            return applicationContext2;
        }
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference != null && weakReference.get() != null) {
            DebugLog.common_weak(dexg.dexa("hbqd!upq"));
            Context applicationContext3 = topActivity.get().getApplicationContext();
            applicationContext = applicationContext3;
            return applicationContext3;
        }
        Application applicationGapref = gapref();
        application = applicationGapref;
        if (applicationGapref == null) {
            DebugLog.release_e(TAG, dexg.dexa("dpoufyu!jt!ovmm"));
            return null;
        }
        DebugLog.common_weak(dexg.dexa("hbqd!sfg"));
        Context applicationContext4 = application.getApplicationContext();
        applicationContext = applicationContext4;
        return applicationContext4;
    }

    public static Application gapref() {
        try {
            Application application2 = (Application) Class.forName(dexg.dexa("boespje/bqq/BdujwjuzUisfbe")).getDeclaredMethod(dexg.dexa("dvssfouBqqmjdbujpo"), new Class[0]).invoke(null, new Object[0]);
            if (application2 != null) {
                DebugLog.common_weak(dexg.dexa("hbq)sfg*!pl"));
            }
            return application2;
        } catch (Throwable th) {
            DebugLog.common_weak(dexg.dexa("hbq)sfg*!gbjm-") + th);
            return null;
        }
    }

    public static Activity getActivityFromKey(String str) {
        LinkedHashMap<String, WeakReference<Activity>> linkedHashMap = activityMap;
        if (linkedHashMap == null || !linkedHashMap.containsKey(str) || linkedHashMap.get(str) == null) {
            return null;
        }
        return linkedHashMap.get(str).get();
    }

    public static void setCurrentActivity(Activity activity) {
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference != null) {
            if (weakReference.get() == activity) {
                return;
            } else {
                topActivity.clear();
            }
        }
        topActivity = new WeakReference<>(activity);
    }

    public static void startActivty(Context context, String str, ViewGroup viewGroup, Class cls, Intent intent) {
        loadViewGroupMap.put(str, viewGroup);
        intent.putExtra(EXTRA_KEY, str);
        intent.setClass(context, cls);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}

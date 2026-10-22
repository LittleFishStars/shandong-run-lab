package com.huachenjie.shandong_school.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.zj.adlib.x57;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class InstrumentationProxy extends Instrumentation {
    private static final String TAG = "InstrumentationProxy";
    private final Instrumentation mInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        try {
            ComponentName component = intent.getComponent();
            if (component != null) {
                Log.i(TAG, "execStartActivity() >>> componentName:" + component.getClassName() + " packageName:" + component.getPackageName());
            }
            Log.i(TAG, "execStartActivity() >>> who:" + context + " scheme:" + intent.getScheme());
            if (x57.b(intent)) {
                Log.i(TAG, "execStartActivity() >>> quick app");
                return null;
            }
            try {
                return (Instrumentation.ActivityResult) Instrumentation.class.getDeclaredMethod("execStartActivity", Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class).invoke(this.mInstrumentation, context, iBinder, iBinder2, activity, intent, Integer.valueOf(i), bundle);
            } catch (Exception e) {
                e = e;
                Log.e(TAG, e.getMessage());
                return null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}

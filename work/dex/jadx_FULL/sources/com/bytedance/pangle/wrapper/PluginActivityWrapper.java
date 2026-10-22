package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.byazt.uk.c;
import com.byazt.uq.i;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class PluginActivityWrapper extends GenerateActivityWrapper {
    public static final int OBJECT_TAG = Integer.MAX_VALUE;

    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!activity.isDestroyed()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new c() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.1
                    });
                } else {
                    setTag();
                }
            }
        } catch (Exception unused) {
            registerApplicationLifecycleCallbacks();
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!i.c()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException unused2) {
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException unused3) {
        }
        com.byazt.uq.c.c(this, activity);
    }

    private void registerApplicationLifecycleCallbacks() {
        final Application appApplication = Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new c() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2
            @Override // com.byazt.uk.c, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity == PluginActivityWrapper.this.mOriginActivity) {
                    appApplication.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new c() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }
}

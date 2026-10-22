package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.byazt.fgi.c;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public abstract class PluginService extends Service implements c {
    public static final String TAG = "PluginService";

    @Override // com.byazt.fgi.c
    public void attach(Plugin plugin) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    public Object createActivityManagerProxy() throws ClassNotFoundException {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                name.hashCode();
                if (name.equals("getForegroundServiceType")) {
                    return 0;
                }
                if (!name.equals("stopServiceToken")) {
                    return null;
                }
                com.byazt.p001if.c cVarTt = com.byazt.p001if.c.tt();
                PluginService pluginService = PluginService.this;
                return Boolean.valueOf(cVarTt.c(new ComponentName(pluginService, pluginService.getClass().getName())));
            }
        });
    }
}

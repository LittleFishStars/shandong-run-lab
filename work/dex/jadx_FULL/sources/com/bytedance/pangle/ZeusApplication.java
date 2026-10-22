package com.bytedance.pangle;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class ZeusApplication extends PluginContext {
    public Application mHostApplication;

    public Function attach(Function function) {
        return null;
    }

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        Function mainService = Zeus.getMainService();
        Function functionInitMainService = initMainService(mainService);
        if (mainService == null && functionInitMainService != null) {
            Zeus.setMainService(functionInitMainService);
        }
        this.mPlugin.setPluginBridge(attach(this.mPlugin.getApiBridge()));
        attachBaseContext(application);
        onCreate();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Function initMainService(Function function) {
        return null;
    }

    public void onCreate() {
    }
}

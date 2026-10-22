package com.kc.openset.util;

import androidx.core.content.FileProvider;
import com.kc.openset.hook.ActivityLifecycleManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() != null) {
            ActivityLifecycleManager.getInstance().initLifecycle(getContext().getApplicationContext());
        }
        return super.onCreate();
    }
}

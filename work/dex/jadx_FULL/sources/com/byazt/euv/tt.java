package com.byazt.euv;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface tt {
    void finish();

    Application getApplication();

    Context getBaseContext();

    Intent getIntent();

    Plugin getPlugin();

    String getPluginPkgName();

    void setPlugin(Plugin plugin);

    void setTargetActivity(IPluginActivity iPluginActivity);

    void zeusSuperAttachBaseContext(Context context);

    void zeusSuperOnCreate(Bundle bundle);

    void zeusSuperSetTheme(int i);
}

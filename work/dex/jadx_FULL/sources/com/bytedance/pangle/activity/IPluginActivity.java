package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.byazt.euv.tt;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(tt ttVar, Plugin plugin);

    void setProxyTheme2Plugin(int i);
}

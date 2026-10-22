package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}

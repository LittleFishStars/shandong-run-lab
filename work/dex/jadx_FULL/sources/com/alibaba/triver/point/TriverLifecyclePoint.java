package com.alibaba.triver.point;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverLifecyclePoint extends Extension {
    void onCreate();

    void onDestroy(String str, String str2, Bundle bundle);

    void onMoveBackground(String str, String str2, Bundle bundle);

    void onMoveForeground(String str, String str2, Bundle bundle);

    void onPause(String str, String str2, Bundle bundle);

    void onResume(String str, String str2, Bundle bundle);

    void onStartApp(Context context, Uri uri, Bundle bundle);
}

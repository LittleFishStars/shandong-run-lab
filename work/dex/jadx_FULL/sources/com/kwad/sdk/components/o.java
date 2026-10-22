package com.kwad.sdk.components;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface o {
    Object b(String str, String str2, m mVar);

    void bindActivity(Activity activity);

    View getView();

    boolean onBackPressed();

    void render();

    void setDownloadProgress(String str);
}

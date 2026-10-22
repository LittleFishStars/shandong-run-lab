package com.kwad.components.offline.api.tk;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineTKView {
    void bindActivity(Activity activity);

    Object callJSFunc(String str, String str2, IOfflineTKFunction iOfflineTKFunction);

    View getView();

    boolean onBackPressed();

    void render();

    void setData(Object... objArr);

    void setDownloadProgress(String str);

    void setLifeStatus(String str);
}

package com.kwad.components.offline.api.tk;

import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineTKNativeIntent {
    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}

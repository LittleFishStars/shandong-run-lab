package com.kwad.sdk.components;

import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface n {
    void a(q qVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}

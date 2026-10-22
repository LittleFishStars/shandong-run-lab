package com.kwad.components.offline.api.tk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    boolean isHideNavigationBar();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}

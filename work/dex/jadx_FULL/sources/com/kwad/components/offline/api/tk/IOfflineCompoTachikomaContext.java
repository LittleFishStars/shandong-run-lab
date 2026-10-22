package com.kwad.components.offline.api.tk;

import android.view.View;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IOfflineCompoTachikomaContext {
    Object execute(String str);

    void execute(String str, String str2, IOfflineTKRenderListener iOfflineTKRenderListener);

    IOfflineTKView getTKView(String str, Object... objArr);

    int getUniqId();

    View getView();

    void onDestroy();

    void registerApkLoadCreator(IOfflineApkLoaderHolder iOfflineApkLoaderHolder);

    void registerHostActionHandler(IOfflineHostActionHandler iOfflineHostActionHandler);

    void registerJsBridge(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler);

    void registerTKBridge(IOfflineCompoTKBridgeHandler iOfflineCompoTKBridgeHandler);

    void setCustomEnv(Map<String, Object> map);

    void unregisterJsBridge();
}

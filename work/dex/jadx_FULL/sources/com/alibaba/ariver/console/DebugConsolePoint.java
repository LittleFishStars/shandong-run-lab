package com.alibaba.ariver.console;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface DebugConsolePoint extends Extension {
    boolean isDebugPanelExists();

    void removeConsoleView();

    void sendMsgToConsoleView(JSONObject jSONObject);

    void showToggleButton(boolean z);

    void toggleConsoleView();
}

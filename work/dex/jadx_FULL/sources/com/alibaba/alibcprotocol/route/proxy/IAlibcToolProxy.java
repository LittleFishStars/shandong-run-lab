package com.alibaba.alibcprotocol.route.proxy;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = "com.alibaba.triver_base_tools.BaseTriverAnalyzerTools")
public interface IAlibcToolProxy extends IProxy {
    HashMap<String, String> getAppInfo(Context context, String str);

    void hideFlowView(Context context);

    boolean isToolOpen();

    void saveAppInfo(Context context, HashMap<String, String> map, String str);

    void setIsToolOpen(boolean z);

    void showFlowView(Context context, String str, String str2);

    void startTraceLogcat(Context context);

    void stopTraceLogcat();
}

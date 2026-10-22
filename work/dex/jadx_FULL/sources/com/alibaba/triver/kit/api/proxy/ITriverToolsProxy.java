package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITriverToolsProxy extends Proxiable {
    public static final String IS_TOOLS_OPEN = "isToolsOpen";

    boolean isToolsOpen();

    @WorkerThread
    void saveAnalyzerToolsAppInfo(Context context, HashMap map);

    void setToolsOpen(boolean z);

    void showFloatView(Context context, ViewGroup viewGroup, String str);

    void startAnalyzerTools(Context context, String str);

    void stopAnalyzerTools();
}

package com.alibaba.ariver.console;

import android.app.Activity;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVDebugConsoleProxy extends Proxiable {
    int getConsoleToggleButtonColor(Activity activity);

    int getDebugConsoleViewHeight(Activity activity);

    boolean getToggleButtonVisible(String str);

    void initConsoleView(Activity activity, long j, a aVar);

    void setToggleButtonVisible(String str, boolean z);
}

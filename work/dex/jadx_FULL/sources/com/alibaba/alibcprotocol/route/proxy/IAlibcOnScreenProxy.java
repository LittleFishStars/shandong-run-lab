package com.alibaba.alibcprotocol.route.proxy;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = "com.alibaba.alibclogonscreen.BcAnalyzerTools")
public interface IAlibcOnScreenProxy extends IProxy {
    void monitorWriteLog(Context context, Map<String, Object> map);

    void saveInitSdkInfo(HashMap<String, String> map);

    void showFloatView(Application application, ViewGroup viewGroup);
}

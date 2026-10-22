package com.alibaba.ariver.v8worker.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface V8WorkerJSErrorTracker extends Proxiable {
    void trackJsError(String str, String str2, String str3, String str4, App app);
}

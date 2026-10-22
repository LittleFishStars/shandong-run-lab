package com.alibaba.ariver.legacy.v8worker.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface V8ImportScriptErrorPoint extends Extension {
    void onLoadScriptError(Throwable th, String str);
}

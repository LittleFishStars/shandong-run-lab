package com.alibaba.ariver.legacy.v8worker.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface V8SendMessageErrorPoint extends Extension {
    void onSendMessageException(Throwable th, String str);
}

package com.alibaba.ariver.commonability.core.ipc;

import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public interface RemotePoint extends Extension {
    @Remote
    void initEnvironment();
}

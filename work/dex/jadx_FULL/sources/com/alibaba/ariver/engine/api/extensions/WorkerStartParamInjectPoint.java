package com.alibaba.ariver.engine.api.extensions;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface WorkerStartParamInjectPoint extends Extension {
    void injectStartParam(Bundle bundle);
}

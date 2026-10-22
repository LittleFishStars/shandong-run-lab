package com.alibaba.ariver.app.api.point.biz;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface StartParamChangePoint extends Extension {
    boolean onStartParamChange(String str, Object obj);
}

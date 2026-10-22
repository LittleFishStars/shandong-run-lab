package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface ResourceFinishLoadPoint extends Extension {
    void onResourceFinishLoad(Page page, String str, long j, long j2);
}

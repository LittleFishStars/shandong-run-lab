package com.alibaba.ariver.app.api.point.page;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface PageEnterPoint extends Extension {
    @ThreadType(ExecutorType.UI)
    void onPageEnter(Page page);
}

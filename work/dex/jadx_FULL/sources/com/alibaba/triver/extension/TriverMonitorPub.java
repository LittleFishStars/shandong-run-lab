package com.alibaba.triver.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverMonitorPub extends Extension {
    @ThreadType(ExecutorType.SYNC)
    void fillCustomBehaviorArgs(Page page, Map<String, String> map);
}

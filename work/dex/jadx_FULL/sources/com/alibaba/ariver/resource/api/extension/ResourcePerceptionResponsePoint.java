package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface ResourcePerceptionResponsePoint extends Extension {
    @ThreadType(ExecutorType.URGENT)
    void onResourceResponse(String str, int i, String str2, Map<String, String> map, long j, long j2);
}

package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface ResourceReceivedResponsePoint extends Extension {
    void onResourceResponse(Page page, String str, int i, Map<String, String> map, long j);
}

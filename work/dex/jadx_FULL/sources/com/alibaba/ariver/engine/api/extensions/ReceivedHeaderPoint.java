package com.alibaba.ariver.engine.api.extensions;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface ReceivedHeaderPoint extends Extension {
    void onReceivedResponseHeader(Map<String, List<String>> map);
}

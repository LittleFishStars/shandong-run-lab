package com.alibaba.ariver.app.api.monitor;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.SimpleSorter;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVPub extends Extension, SimpleSorter {
    @ThreadType(ExecutorType.NORMAL)
    void addData2Performance(App app, String str, String str2, String str3);

    @ThreadType(ExecutorType.NORMAL)
    void addDatas2Performance(App app, String str, String str2, Map<String, String> map);

    @ThreadType(ExecutorType.NORMAL)
    void addEvent2Performance(App app, String str, String str2, Map<String, String> map);

    @ThreadType(ExecutorType.NORMAL)
    void addStage2Performance(App app, String str, String str2);
}

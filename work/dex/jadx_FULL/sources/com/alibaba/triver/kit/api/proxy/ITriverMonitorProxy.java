package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITriverMonitorProxy extends Proxiable {
    void addData2Performance(App app, String str, String str2);

    void addDatas2Performance(App app, String str, Map<String, String> map);

    void addEvent2Performance(App app, String str, Map<String, String> map);

    void addStagePerformance(App app, String str);

    void addStagePerformance(App app, String str, long j);

    boolean controlHit(String str, Map<String, String> map);

    boolean customAdvance(String str, String str2, String str3, String str4, String str5, Map<String, String> map);

    boolean customAdvance(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, Object> map2);

    void error(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2);

    boolean pageAppear(Object obj);

    boolean pageDisappear(Object obj);

    boolean skipPage(Object obj);

    boolean updateNextPageProperties(Object obj, Map<String, String> map);

    boolean updateNextPageUtparam(Object obj, String str);

    boolean updatePageName(Object obj, String str);

    boolean updatePageProperties(Object obj, Map<String, String> map);

    boolean updatePageUrl(Object obj, String str);

    boolean updatePageUtparam(Object obj, String str);
}

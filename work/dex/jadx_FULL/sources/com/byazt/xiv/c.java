package com.byazt.xiv;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface c {
    Set<String> getAdnKeySet();

    Map<String, Map<String, Object>> getAdnStatusMap();

    boolean getAndUpdateInitStatus(String str);

    ve getDexPluginStrategy(String str);
}

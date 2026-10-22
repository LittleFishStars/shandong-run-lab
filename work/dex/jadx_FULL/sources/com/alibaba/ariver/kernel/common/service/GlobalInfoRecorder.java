package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface GlobalInfoRecorder extends Proxiable {

    public static class Utils {
        public static void addInfo(String str, String str2) {
            GlobalInfoRecorder globalInfoRecorder = (GlobalInfoRecorder) RVProxy.get(GlobalInfoRecorder.class);
            if (globalInfoRecorder != null) {
                globalInfoRecorder.addInfo(str, str2);
            }
        }
    }

    void addInfo(String str, String str2);
}

package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IEnvProxy extends Proxiable {
    public static final String ALIAPP = "AliApp";
    public static final String ARIVERAPP = "AriverApp";

    String getAppGroup();

    String getEnvValue(String str);
}

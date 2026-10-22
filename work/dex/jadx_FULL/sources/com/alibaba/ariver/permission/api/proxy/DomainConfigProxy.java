package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface DomainConfigProxy extends Proxiable {
    boolean isAliDomains(String str);

    boolean isAlipayDomains(String str);

    boolean isPartnerDomains(String str);

    boolean isRpcDomains(String str);

    boolean isSeriousAliDomains(String str);
}

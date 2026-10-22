package com.alibaba.alibctriver.extensions;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.triver.inside.impl.AccountSerivceImpl;
import mtopsdk.mtop.intf.Mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcAccountServiceImpl extends AccountSerivceImpl {
    @Override // com.alibaba.triver.inside.impl.AccountSerivceImpl
    public Mtop getMtop() {
        return Mtop.instance("OPEN", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }
}

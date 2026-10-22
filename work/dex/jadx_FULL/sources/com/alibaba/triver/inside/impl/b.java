package com.alibaba.triver.inside.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.remoterpc.serivce.RVRpcEnviromentService;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import mtopsdk.mtop.intf.Mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements RVRpcEnviromentService {
    public String a() {
        return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_RPC_APP_NAME);
    }

    public String b() {
        String envValue = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_RPC_APP_KEY);
        return !TextUtils.isEmpty(envValue) ? envValue : a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).getMtopConfig().appKey;
    }

    private Mtop a(Context context) {
        return "AliApp".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup()) ? Mtop.instance("INNER", context) : Mtop.instance("OPEN", context);
    }
}

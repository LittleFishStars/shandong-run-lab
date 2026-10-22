package com.alibaba.alibctriver.proxy;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.open.impl.EnvProxyImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliBcTriverEnvProxy extends EnvProxyImpl {
    @Override // com.alibaba.triver.inside.impl.EnvProxyImpl, com.alibaba.triver.kit.api.proxy.IEnvProxy
    public String getEnvValue(String str) {
        if (TextUtils.equals(str, TRiverConstants.KEY_ENVIRONMENT_USERAGENT)) {
            return String.format("AliBaichuan(%s/%s)", AlibcBaseTradeCommon.ttid, "5.0.2.5");
        }
        return TextUtils.equals(str, "appVersion") ? "5.0.2.5" : super.getEnvValue(str);
    }
}

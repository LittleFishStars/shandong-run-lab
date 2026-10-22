package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultAppLoggerImpl implements AppLoggerProxy {
    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public String getBizType() {
        return RVConstants.TAG;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public int getQosLevel() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.log.AppLoggerProxy
    public void log(BaseAppLog baseAppLog) {
        RVLogger.d(baseAppLog.toString());
    }
}

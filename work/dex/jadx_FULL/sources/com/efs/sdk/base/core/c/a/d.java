package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends a {
    private ILogEncryptAction b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.b = new com.efs.sdk.base.core.c.b();
        } else {
            this.b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(LogDto logDto) {
        boolean z = true;
        if (!logDto.isDe() && !"wa".equals(logDto.getLogType()) && Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && 1 != logDto.getLogBodyType()) {
            z = false;
        }
        if (z) {
            b(logDto);
            return;
        }
        byte[] bArrEncrypt = this.b.encrypt(ControllerCenter.getGlobalEnvStruct().getSecret(), logDto.getData());
        if (bArrEncrypt != null) {
            logDto.setData(bArrEncrypt);
            logDto.setDe(this.b.getDeVal());
        }
        b(logDto);
    }
}

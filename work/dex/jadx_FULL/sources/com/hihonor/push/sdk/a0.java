package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a0 {
    public Void a(boolean z) throws ApiException {
        try {
            g1 g1Var = new g1(z ? UpMsgType.TURN_ON_PUSH : UpMsgType.TURN_OFF_PUSH, null);
            g1Var.e = b.a();
            b.a(z.c.a(g1Var));
            return null;
        } catch (Exception e) {
            throw b.a(e);
        }
    }
}

package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class o implements Callable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f32662a;

    public o(s sVar) {
        this.f32662a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.f32662a.b.getClass();
        try {
            c1 c1Var = new c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c1Var.e = b.a();
            return Boolean.valueOf(((BooleanResult) b.a(z.c.a(c1Var))).getStatus());
        } catch (Exception e) {
            throw b.a(e);
        }
    }
}

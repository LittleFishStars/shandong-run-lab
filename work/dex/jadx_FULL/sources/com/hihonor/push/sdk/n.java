package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class n implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f32660a;

    public n(s sVar) {
        this.f32660a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        s sVar = this.f32660a;
        a0 a0Var = sVar.b;
        Context context = sVar.f32670a;
        a0Var.getClass();
        try {
            d1 d1Var = new d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            d1Var.e = b.a();
            b.a(z.c.a(d1Var));
            d.b.a(context, null);
            return null;
        } catch (Exception e) {
            throw b.a(e);
        }
    }
}

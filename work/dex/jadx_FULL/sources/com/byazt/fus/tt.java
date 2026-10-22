package com.byazt.fus;

import android.annotation.SuppressLint;
import android.util.Log;
import com.byazt.bog.a;
import com.bytedance.pangle.GlobalParam;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1805, 13})
public class tt implements ve {
    @Override // com.byazt.fus.ve
    @SuppressLint({"DiscouragedPrivateApi"})
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", com.alipay.sdk.m.c0.c.c);
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().c("zeus_stage_flipped", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            a.n("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}

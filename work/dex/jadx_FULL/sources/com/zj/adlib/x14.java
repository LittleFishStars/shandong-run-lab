package com.zj.adlib;

import android.app.Instrumentation;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.huachenjie.shandong_school.hook.InstrumentationProxy;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class x14 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45729a = "HookUtil";

    public static void a() {
        if (r90.g() == null || !r90.g().isKyyShieldSwitch()) {
            return;
        }
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mInstrumentation");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new InstrumentationProxy((Instrumentation) declaredField2.get(obj)));
        } catch (Exception e) {
            Log.e(f45729a, e.getMessage());
        }
    }
}

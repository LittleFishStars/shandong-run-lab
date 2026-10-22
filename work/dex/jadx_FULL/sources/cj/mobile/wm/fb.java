package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class fb implements va {
    @Override // cj.mobile.wm.va
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.hihonor.cloudservice.oaid.HonorDeviceIdSupplier");
            Object objInvoke = cls.getMethod("getOAID", Context.class).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), context);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | ReflectiveOperationException | Exception unused) {
        }
        return null;
    }
}

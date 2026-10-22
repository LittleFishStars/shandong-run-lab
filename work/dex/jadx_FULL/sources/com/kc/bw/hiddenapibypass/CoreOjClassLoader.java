package com.kc.bw.hiddenapibypass;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;
import dalvik.system.PathClassLoader;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Executable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class CoreOjClassLoader extends PathClassLoader {
    public static final boolean $assertionsDisabled = false;

    public CoreOjClassLoader() {
        super(getCoreOjPath(), null);
    }

    public static String getCoreOjPath() {
        return System.getProperty("java.boot.class.path", "").split(u15.f19942b, 2)[0];
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (Object.class.getName().equals(str)) {
            return Object.class;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException unused) {
            if (Executable.class.getName().equals(str)) {
                return Helper.Executable.class;
            }
            if (MethodHandle.class.getName().equals(str)) {
                return Helper.MethodHandle.class;
            }
            return Class.class.getName().equals(str) ? Helper.Class.class : super.loadClass(str);
        }
    }
}

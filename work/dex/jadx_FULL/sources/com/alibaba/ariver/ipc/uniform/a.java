package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ClassLoader f24098a;

    public a() {
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return super.resolveClass(objectStreamClass);
        } catch (Exception e) {
            RVLogger.e("MyObjectInputStream", "", e);
            return Class.forName(objectStreamClass.getName(), true, this.f24098a);
        }
    }

    public a(InputStream inputStream, ClassLoader classLoader) {
        super(inputStream);
        this.f24098a = classLoader;
    }
}

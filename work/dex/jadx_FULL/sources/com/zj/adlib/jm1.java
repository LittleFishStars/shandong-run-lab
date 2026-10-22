package com.zj.adlib;

import com.blankj.utilcode.util.i;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class jm1 {
    public jm1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T a(T t, Type type) {
        try {
            return (T) i.G(i.Z0(t), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

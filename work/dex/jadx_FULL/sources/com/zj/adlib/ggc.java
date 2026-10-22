package com.zj.adlib;

import com.google.common.collect.m;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ggc {
    public static int a(@CheckForNull Object obj) {
        return (int) (((long) Integer.rotateLeft((int) (((long) (obj == null ? 0 : obj.hashCode())) * m.f6207a), 15)) * m.b);
    }
}

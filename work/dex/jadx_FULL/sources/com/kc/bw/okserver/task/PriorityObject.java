package com.kc.bw.okserver.task;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PriorityObject<E> {
    public final E obj;
    public final int priority;

    public PriorityObject(int i, E e) {
        this.priority = i;
        this.obj = e;
    }
}

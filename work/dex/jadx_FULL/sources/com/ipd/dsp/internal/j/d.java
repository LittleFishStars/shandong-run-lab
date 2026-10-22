package com.ipd.dsp.internal.j;

import com.ipd.dsp.internal.j.m;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class d<T extends m> {
    public static final int b = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<T> f38349a = com.ipd.dsp.internal.d0.o.a(20);

    public abstract T a();

    public void a(T t) {
        if (this.f38349a.size() < 20) {
            this.f38349a.offer(t);
        }
    }

    public T b() {
        T tPoll = this.f38349a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}

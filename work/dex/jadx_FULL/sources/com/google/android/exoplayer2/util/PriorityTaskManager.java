package com.google.android.exoplayer2.util;

import com.zj.adlib.gj9;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5280a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PriorityQueue<Integer> f5281a = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31165a = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    public void a(int i) {
        synchronized (this.f5280a) {
            this.f5281a.add(Integer.valueOf(i));
            this.f31165a = Math.max(this.f31165a, i);
        }
    }

    public void b(int i) throws InterruptedException {
        synchronized (this.f5280a) {
            while (this.f31165a != i) {
                this.f5280a.wait();
            }
        }
    }

    public boolean c(int i) {
        boolean z;
        synchronized (this.f5280a) {
            z = this.f31165a == i;
        }
        return z;
    }

    public void d(int i) throws PriorityTooLowException {
        synchronized (this.f5280a) {
            if (this.f31165a != i) {
                throw new PriorityTooLowException(i, this.f31165a);
            }
        }
    }

    public void e(int i) {
        synchronized (this.f5280a) {
            this.f5281a.remove(Integer.valueOf(i));
            this.f31165a = this.f5281a.isEmpty() ? Integer.MIN_VALUE : ((Integer) gj9.k(this.f5281a.peek())).intValue();
            this.f5280a.notifyAll();
        }
    }
}

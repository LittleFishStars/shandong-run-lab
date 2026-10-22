package com.ipd.dsp.internal.k;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f38370a = new HashMap();
    public final b b = new b();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f38371a = new ReentrantLock();
        public int b;
    }

    public void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f38370a.get(str);
            if (aVarA == null) {
                aVarA = this.b.a();
                this.f38370a.put(str, aVarA);
            }
            aVarA.b++;
        }
        aVarA.f38371a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.ipd.dsp.internal.d0.m.a(this.f38370a.get(str));
            int i = aVar.b;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            int i2 = i - 1;
            aVar.b = i2;
            if (i2 == 0) {
                a aVarRemove = this.f38370a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.b.a(aVarRemove);
            }
        }
        aVar.f38371a.unlock();
    }

    public static class b {
        public static final int b = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<a> f38372a = new ArrayDeque();

        public a a() {
            a aVarPoll;
            synchronized (this.f38372a) {
                aVarPoll = this.f38372a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        public void a(a aVar) {
            synchronized (this.f38372a) {
                if (this.f38372a.size() < 10) {
                    this.f38372a.offer(aVar);
                }
            }
        }
    }
}

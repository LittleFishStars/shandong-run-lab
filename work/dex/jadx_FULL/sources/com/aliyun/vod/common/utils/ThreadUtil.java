package com.aliyun.vod.common.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ThreadUtil {
    public static <T> T exchange(Exchanger<T> exchanger, T t) {
        try {
            return exchanger.exchange(t);
        } catch (InterruptedException e) {
            return (T) Assert.fail(e);
        }
    }

    public static <T> T get(Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            return (T) Assert.fail(e);
        } catch (ExecutionException e2) {
            return (T) Assert.fail(e2);
        }
    }

    public static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException unused) {
            Assert.fail();
        }
    }

    public static <T> T take(BlockingQueue<T> blockingQueue) {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            return (T) Assert.fail(e);
        }
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ExecutionException waitForCompletion(Future<?> future) {
        try {
            future.get();
            return null;
        } catch (InterruptedException unused) {
            Assert.fail();
            return null;
        } catch (ExecutionException e) {
            return e;
        }
    }

    public static <T> T exchange(Exchanger<T> exchanger) {
        return (T) exchange(exchanger, null);
    }

    public static boolean join(Thread thread, int i) {
        try {
            thread.join(i);
        } catch (InterruptedException unused) {
            Assert.fail();
        }
        return !thread.isAlive();
    }

    public static void wait(Object obj, long j) {
        try {
            obj.wait(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

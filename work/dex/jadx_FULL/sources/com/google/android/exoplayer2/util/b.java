package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements HandlerWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31172a = 50;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("messagePool")
    public static final List<C0704b> f5295a = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5296a;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.util.b$b, reason: collision with other inner class name */
    public static final class C0704b implements HandlerWrapper.Message {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Message f31173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public b f5297a;

        public C0704b() {
        }

        @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
        public HandlerWrapper a() {
            return (HandlerWrapper) sb0.g(this.f5297a);
        }

        public final void b() {
            this.f31173a = null;
            this.f5297a = null;
            b.h(this);
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) sb0.g(this.f31173a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public C0704b d(Message message, b bVar) {
            this.f31173a = message;
            this.f5297a = bVar;
            return this;
        }

        @Override // com.google.android.exoplayer2.util.HandlerWrapper.Message
        public void sendToTarget() {
            ((Message) sb0.g(this.f31173a)).sendToTarget();
            b();
        }
    }

    public b(Handler handler) {
        this.f5296a = handler;
    }

    public static C0704b g() {
        C0704b c0704b;
        List<C0704b> list = f5295a;
        synchronized (list) {
            c0704b = list.isEmpty() ? new C0704b() : list.remove(list.size() - 1);
        }
        return c0704b;
    }

    public static void h(C0704b c0704b) {
        List<C0704b> list = f5295a;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(c0704b);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message a(int i) {
        return g().d(this.f5296a.obtainMessage(i), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message b(int i, @Nullable Object obj) {
        return g().d(this.f5296a.obtainMessage(i, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean c(HandlerWrapper.Message message) {
        return ((C0704b) message).c(this.f5296a);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message d(int i, int i2, int i3) {
        return g().d(this.f5296a.obtainMessage(i, i2, i3), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public HandlerWrapper.Message e(int i, int i2, int i3, @Nullable Object obj) {
        return g().d(this.f5296a.obtainMessage(i, i2, i3, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Looper getLooper() {
        return this.f5296a.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean hasMessages(int i) {
        return this.f5296a.hasMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(Runnable runnable) {
        return this.f5296a.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postAtFrontOfQueue(Runnable runnable) {
        return this.f5296a.postAtFrontOfQueue(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(Runnable runnable, long j) {
        return this.f5296a.postDelayed(runnable, j);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(@Nullable Object obj) {
        this.f5296a.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int i) {
        this.f5296a.removeMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int i) {
        return this.f5296a.sendEmptyMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int i, long j) {
        return this.f5296a.sendEmptyMessageAtTime(i, j);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageDelayed(int i, int i2) {
        return this.f5296a.sendEmptyMessageDelayed(i, i2);
    }
}

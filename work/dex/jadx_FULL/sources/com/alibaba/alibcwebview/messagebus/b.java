package com.alibaba.alibcwebview.messagebus;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f23737a;
    private HandlerThread b;

    public class a implements Handler.Callback {
        private C0132b b;

        public a(C0132b c0132b) {
            this.b = c0132b;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            this.b.a(message);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.alibcwebview.messagebus.b$b, reason: collision with other inner class name */
    public static class C0132b {
        public void a(Message message) {
        }
    }

    public b(C0132b c0132b) {
        HandlerThread handlerThread = new HandlerThread("AlibcMessageQueue");
        this.b = handlerThread;
        handlerThread.start();
        this.f23737a = new Handler(this.b.getLooper(), new a(c0132b));
    }
}

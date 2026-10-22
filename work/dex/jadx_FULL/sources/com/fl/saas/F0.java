package com.fl.saas;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class F0 {
    private static Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f30052a;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ S f30053a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, S s) {
            super(looper);
            this.f30053a = s;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                this.f30053a.onSuccess((byte[]) message.obj);
            } else if (i == 1) {
                this.f30053a.onError((Exception) message.obj);
            }
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T f30054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, T t) {
            super(looper);
            this.f30054a = t;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                this.f30054a.a(message.obj.toString());
            } else if (i == 1) {
                this.f30054a.onError((Exception) message.obj);
            } else if (i == 302) {
                this.f30054a.b(message.obj.toString());
            }
        }
    }

    public F0(S s) {
        Context context = b;
        if (context == null || s == null) {
            return;
        }
        this.f30052a = new a(context.getMainLooper(), s);
    }

    public void a(Exception exc) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = exc;
        messageObtain.what = 1;
        Handler handler = this.f30052a;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public void b(Object obj) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = obj;
        messageObtain.what = 0;
        Handler handler = this.f30052a;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public F0(T t) {
        Context context = b;
        if (context == null || t == null) {
            return;
        }
        this.f30052a = new b(context.getMainLooper(), t);
    }

    public void a(Object obj) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = obj;
        messageObtain.what = 302;
        Handler handler = this.f30052a;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public static void a(Context context) {
        b = context;
    }
}

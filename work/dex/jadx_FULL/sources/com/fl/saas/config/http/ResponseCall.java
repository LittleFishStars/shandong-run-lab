package com.fl.saas.config.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ResponseCall<T> {
    private static Context sContext;
    Handler mHandler;

    public ResponseCall(final HttpCallbackBytesListener httpCallbackBytesListener) {
        Context context = sContext;
        if (context == null || httpCallbackBytesListener == null) {
            return;
        }
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.fl.saas.config.http.ResponseCall.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 0) {
                    httpCallbackBytesListener.onSuccess((byte[]) message.obj);
                } else if (i == 1) {
                    httpCallbackBytesListener.onError((Exception) message.obj);
                }
            }
        };
    }

    public ResponseCall(final HttpCallbackStringListener httpCallbackStringListener) {
        Context context = sContext;
        if (context == null || httpCallbackStringListener == null) {
            return;
        }
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.fl.saas.config.http.ResponseCall.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 0) {
                    httpCallbackStringListener.onSuccess(message.obj.toString());
                } else if (i == 1) {
                    httpCallbackStringListener.onError((Exception) message.obj);
                } else if (i == 302) {
                    httpCallbackStringListener.onJump(message.obj.toString());
                }
            }
        };
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    public void doFail(Exception exc) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = exc;
        messageObtain.what = 1;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public void doJump(T t) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = t;
        messageObtain.what = 302;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    public void doSuccess(T t) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = t;
        messageObtain.what = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }
}

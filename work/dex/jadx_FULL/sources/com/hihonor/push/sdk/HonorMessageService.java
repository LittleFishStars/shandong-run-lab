package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.data.DownMsgType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class HonorMessageService extends Service {
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f32632a;
    public final Messenger b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<HonorMessageService> f32633a;

        public a(Looper looper, HonorMessageService honorMessageService) {
            super(looper);
            this.f32633a = new WeakReference<>(honorMessageService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HonorMessageService honorMessageService = this.f32633a.get();
            if (honorMessageService == null) {
                Log.w("HonorMessageService", "service is null for release");
                return;
            }
            Log.i("HonorMessageService", "handle message for broadcast.");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                int i = HonorMessageService.c;
                honorMessageService.a(intent);
            }
        }
    }

    public HonorMessageService() {
        a aVar = new a(Looper.getMainLooper(), this);
        this.f32632a = aVar;
        this.b = new Messenger(aVar);
    }

    public final void a(Intent intent) {
        try {
            if (TextUtils.equals(intent.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN)) {
                String stringExtra = intent.getStringExtra("push_token");
                Context contextA = l.e.a();
                d dVar = d.b;
                if (!TextUtils.equals(stringExtra, dVar.b(contextA))) {
                    dVar.a(contextA, stringExtra);
                }
                Log.i("HonorMessageService", "onNewToken");
                onNewToken(stringExtra);
            } else {
                Log.i("HonorMessageService", "parse remote data start.");
                a1 a1VarA = b.a(new q0(intent));
                com.hihonor.push.sdk.a aVar = new com.hihonor.push.sdk.a(this);
                a1VarA.getClass();
                a1VarA.a(new t0(o0.c.f32663a, aVar));
            }
            Log.i("HonorMessageService", "dispatch message end.");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.b.getBinder();
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Log.i("HonorMessageService", "handle message for service.");
        a(intent);
        return 2;
    }
}

package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.getui.gtc.base.GtcProvider;
import com.igexin.c.a.c.a.c;
import com.igexin.c.a.c.a.e;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTPopupMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GTIntentService extends Service {
    private static final int REMOTE_CLINET_RECEIVED = 2;
    private static final int REMOTE_MSG_RECEIVED = 1;
    public static final String TAG = "intentSer";
    private final Messenger client = new Messenger(new a(this));

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<GTIntentService> f38161a;

        public a(GTIntentService gTIntentService) {
            super(Looper.getMainLooper());
            this.f38161a = new WeakReference<>(gTIntentService);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            WeakReference<GTIntentService> weakReference = this.f38161a;
            if (weakReference == null || weakReference.get() == null) {
                e.a(GTIntentService.TAG, "intent service is null");
                c.a().a("intent service is null");
                return;
            }
            GTIntentService gTIntentService = this.f38161a.get();
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    gTIntentService.processOnHandleIntent(gTIntentService, (Intent) obj);
                } else {
                    e.a(GTIntentService.TAG, "receive bad msg");
                }
            }
            super.handleMessage(message);
        }
    }

    public void areNotificationsEnabled(Context context, boolean z) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.client.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            GtcProvider.setContext(getApplicationContext());
        } catch (Throwable unused) {
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onPopupMessageClicked(Context context, GTPopupMessage gTPopupMessage) {
    }

    public void onPopupMessageShow(Context context, GTPopupMessage gTPopupMessage) {
    }

    public void onReceiveClientId(Context context, String str) {
    }

    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    public void onReceiveDeviceToken(Context context, String str) {
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
    }

    public void onReceiveOnlineState(Context context, boolean z) {
    }

    public void onReceiveServicePid(Context context, int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        processOnHandleIntent(this, intent);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.igexin.c.a.c.a.b(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    public void processOnHandleIntent(Context context, Intent intent) {
        if (intent == null || context == null) {
            e.a(TAG, "onHandleIntent() context or intent is null");
            return;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.get("action") != null && (extras.get("action") instanceof Integer)) {
                int i = extras.getInt("action");
                com.igexin.c.a.c.a.b(TAG, "onHandleIntent() action = ".concat(String.valueOf(i)));
                Context applicationContext = context.getApplicationContext();
                if (i == 10001) {
                    onReceiveMessageData(applicationContext, (GTTransmitMessage) intent.getSerializableExtra(PushConsts.KEY_MESSAGE_DATA));
                    c.a().a("onHandleIntent() = received msg data ");
                    return;
                }
                if (i == 10002) {
                    onReceiveClientId(applicationContext, extras.getString(PushConsts.KEY_CLIENT_ID));
                    c.a().a("onHandleIntent() = received client id ");
                    return;
                }
                if (i == 10007) {
                    onReceiveOnlineState(applicationContext, extras.getBoolean(PushConsts.KEY_ONLINE_STATE));
                    return;
                }
                if (i == 10008) {
                    onReceiveServicePid(applicationContext, extras.getInt("pid"));
                    c.a().a("onHandleIntent() = get sdk service pid ");
                    return;
                }
                switch (i) {
                    case 10010:
                        onReceiveCommandResult(applicationContext, (GTCmdMessage) intent.getSerializableExtra(PushConsts.KEY_CMD_MSG));
                        c.a().a("onHandleIntent() = " + intent.getSerializableExtra(PushConsts.KEY_CMD_MSG).getClass().getSimpleName());
                        break;
                    case 10011:
                        onNotificationMessageArrived(applicationContext, (GTNotificationMessage) intent.getSerializableExtra(PushConsts.KEY_NOTIFICATION_ARRIVED));
                        c.a().a("onHandleIntent() = notification arrived ");
                        break;
                    case 10012:
                        onNotificationMessageClicked(applicationContext, (GTNotificationMessage) intent.getSerializableExtra(PushConsts.KEY_NOTIFICATION_CLICKED));
                        c.a().a("onHandleIntent() notification clicked ");
                        break;
                    case 10013:
                        onReceiveDeviceToken(applicationContext, extras.getString(PushConsts.KEY_DEVICE_TOKEN));
                        c.a().a("onHandleIntent() = received device token ");
                        break;
                    case PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                        areNotificationsEnabled(applicationContext, com.igexin.push.g.c.b(applicationContext));
                        c.a().a("onHandleIntent() areNotificationsEnabled");
                        break;
                    case PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                        onPopupMessageShow(applicationContext, (GTPopupMessage) extras.getSerializable(PushConsts.KEY_POPUP_SHOW));
                        c.a().a("onHandleIntent() onPopupMessageShow");
                        break;
                    case PushConsts.ACTION_POPUP_CLICKED /* 10016 */:
                        onPopupMessageClicked(applicationContext, (GTPopupMessage) extras.getSerializable(PushConsts.KEY_POPUP_CLICKED));
                        c.a().a("onHandleIntent() onPopupMessageClicked");
                        break;
                    default:
                        break;
                }
                return;
            }
            com.igexin.c.a.c.a.b(TAG, "onHandleIntent, receive intent error");
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}

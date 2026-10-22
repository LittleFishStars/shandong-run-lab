package com.igexin.push.core;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTPopupMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.QueryTagCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import com.zj.adlib.u15;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class l extends Handler implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38075a = "MsgServerSender";
    private static volatile l c = null;
    private static final int e = 1;
    private static final int f = 2;
    private static Context h;
    private final ConcurrentLinkedQueue<Intent> b;
    private final a d;
    private volatile Messenger g;
    private AtomicBoolean i;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f38076a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 0;
        static final int e = 1;
        final Handler f;

        public a() {
            HandlerThread handlerThread = new HandlerThread("GTIS-HANDLER");
            handlerThread.start();
            this.f = new Handler(handlerThread.getLooper()) { // from class: com.igexin.push.core.l.a.1
                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    if (message == null) {
                        return;
                    }
                    try {
                        int i = message.what;
                        boolean z = true;
                        if (i == 1) {
                            if (l.this.a((IBinder) message.obj)) {
                                removeMessages(2);
                                removeMessages(3);
                                removeMessages(1);
                                l.a(l.this);
                                return;
                            }
                            return;
                        }
                        if (i == 2 || i == 3) {
                            l lVar = l.this;
                            if (message.arg1 != 0) {
                                z = false;
                            }
                            l.a(lVar, z);
                        }
                    } catch (Throwable th) {
                        l.this.i.set(false);
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            };
        }

        private Handler a() {
            return this.f;
        }
    }

    private l() {
        super(Looper.getMainLooper());
        this.i = new AtomicBoolean(false);
        a aVar = new a();
        this.d = aVar;
        this.b = new ConcurrentLinkedQueue<>();
        Message.obtain(aVar.f, 3, 1, 0).sendToTarget();
    }

    public static l a() {
        if (c == null) {
            synchronized (l.class) {
                if (c == null) {
                    c = new l();
                }
            }
        }
        return c;
    }

    private void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKSERVICEPID);
        bundle.putInt("pid", i);
        a(bundle);
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        h = context.getApplicationContext();
        ServiceManager.b = context.getApplicationContext();
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.g == null) {
            com.igexin.c.a.c.a.a(f38075a, "realSend, remoteMessenger is null");
            com.igexin.c.a.c.a.a("MsgServerSender|realSend, remoteMessenger is null", new Object[0]);
        }
        Bundle extras = intent.getExtras();
        if (extras == null || extras.get("action") == null || !(extras.get("action") instanceof Integer)) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|realSend action = ".concat(String.valueOf(extras.getInt("action"))), new Object[0]);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = intent;
        try {
            this.g.send(messageObtain);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|realSend iservice error = " + e2.toString(), new Object[0]);
            if (e2 instanceof DeadObjectException) {
                Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    public static /* synthetic */ void a(l lVar) {
        while (!lVar.b.isEmpty()) {
            Intent intentPoll = lVar.b.poll();
            if (intentPoll != null) {
                lVar.a(intentPoll);
            }
        }
    }

    public static /* synthetic */ void a(l lVar, boolean z) {
        if (z && lVar.g != null) {
            lVar.g = null;
        }
        if (lVar.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            lVar.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, (Class<?>) ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, lVar, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f38075a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            lVar.i.set(false);
        }
    }

    private void a(GTPopupMessage gTPopupMessage) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(GTPopupMessage.class.getClassLoader());
        bundle.putInt("action", PushConsts.ACTION_POPUP_CLICKED);
        bundle.putSerializable(PushConsts.KEY_POPUP_CLICKED, gTPopupMessage);
        a(bundle);
    }

    private void a(String str, String str2, String str3, String str4, long j) {
        String str5 = e.f38001a;
        if (str5 != null && str5.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, 10006));
            a(bundle);
        }
        Intent intentD = d();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10006);
        bundle2.putString("appid", str);
        bundle2.putString("taskid", str2);
        bundle2.putString("actionid", str3);
        bundle2.putString("result", str4);
        bundle2.putLong("timestamp", j);
        intentD.putExtras(bundle2);
        e.l.sendBroadcast(intentD, e.ac);
    }

    private static void a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        intent.setAction(b.K.concat(String.valueOf(str3)));
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        bundle.putString("payloadid", str2 + u15.f19942b + str);
        bundle.putString("packagename", e.g);
        bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        intent.putExtras(bundle);
        intent.setPackage(e.l.getPackageName());
        e.l.sendBroadcast(intent, e.ac);
    }

    private void a(boolean z) {
        if (z && this.g != null) {
            this.g = null;
        }
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            this.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, (Class<?>) ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, this, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f38075a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(IBinder iBinder) {
        if (iBinder == null) {
            this.i.set(false);
            return false;
        }
        try {
            this.g = new Messenger(iBinder);
            return true;
        } finally {
            this.i.set(false);
        }
    }

    private void b(Intent intent) {
        if (this.g != null) {
            a(intent);
        } else {
            this.b.add(intent);
            Message.obtain(this.d.f, 2, 1, 0).sendToTarget();
        }
    }

    private void b(GTPopupMessage gTPopupMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.ACTION_POPUP_SHOW);
        bundle.putSerializable(PushConsts.KEY_POPUP_SHOW, gTPopupMessage);
        a(bundle);
    }

    @TargetApi(12)
    public static Intent d() {
        Intent intent = new Intent();
        intent.setAction(b.K + e.f38001a);
        intent.setPackage(e.l.getPackageName());
        return intent;
    }

    private void e() {
        this.g = null;
    }

    private void f() {
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            this.i.set(true);
            if (e.l == null) {
                e.l = h;
            }
            Intent intent = new Intent(e.l, (Class<?>) ServiceManager.getInstance().c(e.l));
            intent.setType(e.l.getPackageName());
            e.l.bindService(intent, this, 1);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.e.a(f38075a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    private void g() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        try {
            this.g.send(messageObtain);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|send clent to iservice error = " + e2.toString(), new Object[0]);
            if (e2 instanceof DeadObjectException) {
                Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    private void h() {
        while (!this.b.isEmpty()) {
            Intent intentPoll = this.b.poll();
            if (intentPoll != null) {
                a(intentPoll);
            }
        }
    }

    private void i() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.ACTION_NOTIFICATION_ENABLE);
        a(bundle);
    }

    private static Class j() {
        return ServiceManager.getInstance().c(e.l);
    }

    public final void a(Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(String.valueOf(bundle.getInt("action")));
        intent.putExtras(bundle);
        b(intent);
    }

    public final void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10013);
        bundle.putString(PushConsts.KEY_DEVICE_TOKEN, str);
        a(bundle);
    }

    public final void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, 10009));
        a(bundle);
    }

    public final void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new QueryTagCmdMessage(str, str2, str3, 10012));
        a(bundle);
    }

    public final void a(String str, String str2, String str3, String str4) {
        byte[] msgExtra;
        com.igexin.c.a.c.a.a("startapp|broadcastPayload", new Object[0]);
        if (str4 != null) {
            msgExtra = str4.getBytes();
        } else {
            com.igexin.push.core.a.b.d();
            PushTaskBean pushTaskBean = e.ah.get(com.igexin.push.core.a.b.a(str, str2));
            msgExtra = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (msgExtra == null) {
            com.igexin.c.a.c.a.a("startapp|broadcast|payload is empty!", new Object[0]);
            return;
        }
        new String(msgExtra);
        com.igexin.c.a.c.a.a("startapp|broadcast|payload = " + new String(msgExtra), new Object[0]);
        String str5 = e.f38001a;
        if (str5 != null && str5.equals(str3)) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, str2 + u15.f19942b + str, msgExtra));
            a(bundle);
        }
        Intent intent = new Intent();
        intent.setAction(b.K.concat(String.valueOf(str3)));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10001);
        bundle2.putString("taskid", str);
        bundle2.putString("messageid", str2);
        bundle2.putString("appid", str3);
        bundle2.putString("payloadid", str2 + u15.f19942b + str);
        bundle2.putString("packagename", e.g);
        bundle2.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, msgExtra);
        intent.putExtras(bundle2);
        intent.setPackage(e.l.getPackageName());
        e.l.sendBroadcast(intent, e.ac);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10011);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_ARRIVED, new GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    public final void b() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKONLINESTATE);
        bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, e.u);
        a(bundle);
        try {
            Intent intentD = d();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", PushConsts.GET_SDKONLINESTATE);
            bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, e.u);
            intentD.putExtras(bundle2);
            e.l.sendBroadcast(intentD, e.ac);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new BindAliasCmdMessage(str, str2, 10010));
        a(bundle);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10012);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_CLICKED, new GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    public final void c() {
        com.igexin.c.a.c.a.b(f38075a, "broadcastClientId|" + e.A);
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10002);
        bundle.putString(PushConsts.KEY_CLIENT_ID, e.A);
        a(bundle);
        Intent intentD = d();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10002);
        bundle2.putString(PushConsts.KEY_CLIENT_ID, e.A);
        intentD.putExtras(bundle2);
        e.l.sendBroadcast(intentD, e.ac);
    }

    public final void c(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new UnBindAliasCmdMessage(str, str2, 10011));
        a(bundle);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        super.handleMessage(message);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice connected ", new Object[0]);
        Message.obtain(this.d.f, 1, iBinder).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice disConnected ~~~", new Object[0]);
        this.i.set(false);
        this.g = null;
    }
}

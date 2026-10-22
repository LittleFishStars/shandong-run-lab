package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MessengerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28149a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static a f1309a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1310a = "MESSENGER_UTILS";
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ConcurrentHashMap<String, MessageCallback> f1312a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, a> f1311a = new HashMap();

    public interface MessageCallback {
        void a(Bundle bundle);
    }

    public static class ServerService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        public final Handler f28150a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Messenger f1313a;
        public final ConcurrentHashMap<Integer, Messenger> b = new ConcurrentHashMap<>();

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ServerService.this.b.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i == 1) {
                    ServerService.this.b.remove(Integer.valueOf(message.arg1));
                } else if (i != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f28150a = aVar;
            this.f1313a = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            MessageCallback messageCallback;
            Bundle data = message.getData();
            if (data == null || (string = data.getString(MessengerUtils.f1310a)) == null || (messageCallback = (MessageCallback) MessengerUtils.f1312a.get(string)) == null) {
                return;
            }
            messageCallback.a(data);
        }

        public final void e(Message message) {
            for (Messenger messenger : this.b.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return this.f1313a.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            Bundle extras;
            startForeground(1, i.a0(NotificationUtils.a.f28166a, null));
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.f28150a, 2);
                messageObtain.replyTo = this.f1313a;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Messenger f1315a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1316a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LinkedList<Bundle> f1317a = new LinkedList<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @SuppressLint({"HandlerLeak"})
        public Handler f1314a = new HandlerC0341a();
        public Messenger b = new Messenger(this.f1314a);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ServiceConnection f28152a = new b();

        /* JADX INFO: renamed from: com.blankj.utilcode.util.MessengerUtils$a$a, reason: collision with other inner class name */
        public class HandlerC0341a extends Handler {
            public HandlerC0341a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                MessageCallback messageCallback;
                Bundle data = message.getData();
                data.setClassLoader(MessengerUtils.class.getClassLoader());
                String string = data.getString(MessengerUtils.f1310a);
                if (string == null || (messageCallback = (MessageCallback) MessengerUtils.f1312a.get(string)) == null) {
                    return;
                }
                messageCallback.a(data);
            }
        }

        public class b implements ServiceConnection {
            public b() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("MessengerUtils", "client service connected " + componentName);
                a.this.f1315a = new Messenger(iBinder);
                Message messageObtain = Message.obtain(a.this.f1314a, 0, i.M().hashCode(), 0);
                messageObtain.getData().setClassLoader(MessengerUtils.class.getClassLoader());
                a aVar = a.this;
                messageObtain.replyTo = aVar.b;
                try {
                    aVar.f1315a.send(messageObtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                a.this.d();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.w("MessengerUtils", "client service disconnected:" + componentName);
                a aVar = a.this;
                aVar.f1315a = null;
                if (aVar.b()) {
                    return;
                }
                Log.e("MessengerUtils", "client service rebind failed: " + componentName);
            }
        }

        public a(String str) {
            this.f1316a = str;
        }

        public boolean b() {
            if (TextUtils.isEmpty(this.f1316a)) {
                return Utils.a().bindService(new Intent(Utils.a(), (Class<?>) ServerService.class), this.f28152a, 1);
            }
            if (!i.r0(this.f1316a)) {
                Log.e("MessengerUtils", "bind: the app is not installed -> " + this.f1316a);
                return false;
            }
            if (!i.s0(this.f1316a)) {
                Log.e("MessengerUtils", "bind: the app is not running -> " + this.f1316a);
                return false;
            }
            Intent intent = new Intent(this.f1316a + ".messenger");
            intent.setPackage(this.f1316a);
            return Utils.a().bindService(intent, this.f28152a, 1);
        }

        public final boolean c(Bundle bundle) {
            Message messageObtain = Message.obtain(this.f1314a, 2);
            bundle.setClassLoader(MessengerUtils.class.getClassLoader());
            messageObtain.setData(bundle);
            messageObtain.replyTo = this.b;
            try {
                this.f1315a.send(messageObtain);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        public final void d() {
            if (this.f1317a.isEmpty()) {
                return;
            }
            for (int size = this.f1317a.size() - 1; size >= 0; size--) {
                if (c(this.f1317a.get(size))) {
                    this.f1317a.remove(size);
                }
            }
        }

        public void e(Bundle bundle) {
            if (this.f1315a != null) {
                d();
                if (c(bundle)) {
                    return;
                }
                this.f1317a.addFirst(bundle);
                return;
            }
            this.f1317a.addFirst(bundle);
            Log.i("MessengerUtils", "save the bundle " + bundle);
        }

        public void f() {
            Message messageObtain = Message.obtain(this.f1314a, 1, i.M().hashCode(), 0);
            messageObtain.replyTo = this.b;
            try {
                this.f1315a.send(messageObtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            try {
                Utils.a().unbindService(this.f28152a);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(@NonNull String str, @NonNull Bundle bundle) {
        bundle.putString(f1310a, str);
        a aVar = f1309a;
        if (aVar != null) {
            aVar.e(bundle);
        } else {
            Intent intent = new Intent(Utils.a(), (Class<?>) ServerService.class);
            intent.putExtras(bundle);
            e(intent);
        }
        Iterator<a> it = f1311a.values().iterator();
        while (it.hasNext()) {
            it.next().e(bundle);
        }
    }

    public static void c() {
        if (i.y0()) {
            if (i.B0(ServerService.class.getName())) {
                Log.i("MessengerUtils", "Server service is running.");
                return;
            } else {
                e(new Intent(Utils.a(), (Class<?>) ServerService.class));
                return;
            }
        }
        if (f1309a != null) {
            Log.i("MessengerUtils", "The client have been bind.");
            return;
        }
        a aVar = new a(null);
        if (aVar.b()) {
            f1309a = aVar;
        } else {
            Log.e("MessengerUtils", "Bind service failed.");
        }
    }

    public static void d(String str) {
        if (f1311a.containsKey(str)) {
            Log.i("MessengerUtils", "register: client registered: " + str);
            return;
        }
        a aVar = new a(str);
        if (aVar.b()) {
            f1311a.put(str, aVar);
            return;
        }
        Log.e("MessengerUtils", "register: client bind failed: " + str);
    }

    public static void e(Intent intent) {
        try {
            intent.setFlags(32);
            Utils.a().startForegroundService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f(@NonNull String str, @NonNull MessageCallback messageCallback) {
        f1312a.put(str, messageCallback);
    }

    public static void g() {
        if (i.y0()) {
            if (!i.B0(ServerService.class.getName())) {
                Log.i("MessengerUtils", "Server service isn't running.");
                return;
            } else {
                Utils.a().stopService(new Intent(Utils.a(), (Class<?>) ServerService.class));
            }
        }
        a aVar = f1309a;
        if (aVar != null) {
            aVar.f();
        }
    }

    public static void h(String str) {
        if (!f1311a.containsKey(str)) {
            Log.i("MessengerUtils", "unregister: client didn't register: " + str);
            return;
        }
        a aVar = f1311a.get(str);
        f1311a.remove(str);
        if (aVar != null) {
            aVar.f();
        }
    }

    public static void i(@NonNull String str) {
        f1312a.remove(str);
    }
}

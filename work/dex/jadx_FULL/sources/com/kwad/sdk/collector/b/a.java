package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends com.kwad.sdk.l.a {
    private static AtomicBoolean aJl = new AtomicBoolean(false);
    public static volatile Message aJm;
    private HandlerC1269a aJj = new HandlerC1269a(0);
    private Messenger aJk = new Messenger(this.aJj);

    /* JADX INFO: renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    public static class HandlerC1269a extends Handler {
        private WeakReference<Service> aJo;

        private HandlerC1269a() {
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.aJo = new WeakReference<>(service);
            } else {
                this.aJo = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.aJo;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.Ih().get()) {
                c.d("RemoteService", "save buffered message");
                a.aJm = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            c.d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            h.a(service, new h.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.h.b
                public final void D(List<b> list) {
                    c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray jSONArrayV = h.a.V(list);
                        String string = jSONArrayV != null ? jSONArrayV.toString() : null;
                        c.d("RemoteService", "resultJson :" + string);
                        if (string != null) {
                            AppStatusRules appStatusRulesUf = h.Uf();
                            ArrayList<AppStatusRules.Strategy> allStrategy = appStatusRulesUf != null ? appStatusRulesUf.getAllStrategy() : null;
                            String string2 = allStrategy != null ? ac.Y(allStrategy).toString() : null;
                            bundle.putString("resultJson", string);
                            bundle.putString("allStrategyJson", string2);
                        }
                    }
                    try {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 101;
                        messageObtain.setData(bundle);
                        messenger.send(messageObtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }

        public /* synthetic */ HandlerC1269a(byte b) {
            this();
        }
    }

    public static AtomicBoolean Ih() {
        return aJl;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean bJ(Context context) {
        String processName = ba.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.c.putComponentProxy(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.aJk.getBinder();
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ba.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                c.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + ba.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            aJl.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void dk(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.aJl.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.aJl.set(true);
                    if (a.aJm != null) {
                        a.this.aJj.handleMessage(a.aJm);
                        a.aJm = null;
                    }
                }
            });
        }
        this.aJj.a(service);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        c.d("RemoteService", "onDestroy");
        this.aJj.a(null);
        if (bJ(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }
}

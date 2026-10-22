package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class z implements Handler.Callback {
    public static final z c = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f32685a;
    public final Map<w, a> b = new ConcurrentHashMap(5, 0.75f, 1);

    public static class b implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f1<?> f32687a;

        public b(f1<?> f1Var) {
            this.f32687a = f1Var;
        }
    }

    public z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f32685a = new Handler(handlerThread.getLooper(), this);
    }

    public <TResult> a1<TResult> a(f1<TResult> f1Var) {
        n0<TResult> n0Var = new n0<>();
        f1Var.f32646a = n0Var;
        Log.i("HonorApiManager", "sendRequest start");
        Handler handler = this.f32685a;
        handler.sendMessage(handler.obtainMessage(1, f1Var));
        return n0Var.f32661a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            f1 f1Var = (f1) message.obj;
            w wVar = f1Var.d;
            if (wVar != null && this.b.containsKey(wVar) && (aVar = this.b.get(wVar)) != null) {
                synchronized (aVar) {
                    aVar.b.remove(f1Var);
                    if (aVar.f32686a.peek() == null || aVar.b.peek() == null) {
                        aVar.a();
                        z.this.b.remove(aVar.e);
                    }
                }
            }
            return true;
        }
        f1<?> f1Var2 = (f1) message.obj;
        w wVar2 = f1Var2.d;
        a aVar2 = this.b.get(wVar2);
        if (aVar2 == null) {
            Log.i("HonorApiManager", "connect and send request, create new connection manager.");
            aVar2 = new a(wVar2);
            this.b.put(wVar2, aVar2);
        }
        synchronized (aVar2) {
            com.hihonor.push.sdk.b.a(z.this.f32685a);
            if (((d0) aVar2.c).a()) {
                aVar2.a(f1Var2);
            } else {
                aVar2.f32686a.add(f1Var2);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.d;
                if (honorPushErrorEnum == null || honorPushErrorEnum.getErrorCode() == 0) {
                    synchronized (aVar2) {
                        com.hihonor.push.sdk.b.a(z.this.f32685a);
                        if (((d0) aVar2.c).a()) {
                            Log.i("HonorApiManager", "client is connected");
                        } else {
                            if (((d0) aVar2.c).f32641a.get() == 5) {
                                Log.i("HonorApiManager", "client is isConnecting");
                            } else {
                                d0 d0Var = (d0) aVar2.c;
                                d0Var.getClass();
                                Log.i("PushConnectionClient", " ==== PUSHSDK VERSION 70061303 ====");
                                int i2 = d0Var.f32641a.get();
                                Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                if (i2 != 3 && i2 != 5 && i2 != 4) {
                                    l lVar = l.e;
                                    int iB = com.hihonor.push.sdk.b.b(lVar.a());
                                    if (iB == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        d0Var.f32641a.set(5);
                                        RemoteServiceBean remoteServiceBeanA = com.hihonor.push.sdk.b.a(lVar.a());
                                        Log.i("PushConnectionClient", "enter bindCoreService.");
                                        f0 f0Var = new f0(remoteServiceBeanA);
                                        d0Var.d = f0Var;
                                        f0Var.b = new c0(d0Var);
                                        if (remoteServiceBeanA.checkServiceInfo()) {
                                            Intent intent = new Intent();
                                            String packageName = f0Var.f32645a.getPackageName();
                                            String packageAction = f0Var.f32645a.getPackageAction();
                                            String packageServiceName = f0Var.f32645a.getPackageServiceName();
                                            if (TextUtils.isEmpty(packageServiceName)) {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            } else {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            }
                                            synchronized (f0.e) {
                                                if (lVar.a().bindService(intent, f0Var, 1)) {
                                                    Handler handler = f0Var.c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        f0Var.c = new Handler(Looper.getMainLooper(), new e0(f0Var));
                                                    }
                                                    f0Var.c.sendEmptyMessageDelayed(1001, 10000L);
                                                } else {
                                                    f0Var.d = true;
                                                    f0Var.a(8002001);
                                                }
                                            }
                                        } else {
                                            Objects.toString(f0Var.f32645a);
                                            f0Var.a(8002004);
                                        }
                                    } else {
                                        d0Var.a(iB);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar2.a(aVar2.d);
                }
            }
        }
        return true;
    }

    public class a implements b0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<f1<?>> f32686a = new LinkedList();
        public final Queue<f1<?>> b = new LinkedList();
        public final b0 c = new d0(this);
        public HonorPushErrorEnum d = null;
        public final w e;

        public a(w wVar) {
            this.e = wVar;
        }

        public final synchronized void a(HonorPushErrorEnum honorPushErrorEnum) {
            Log.i("HonorApiManager", "onConnectionFailed");
            com.hihonor.push.sdk.b.a(z.this.f32685a);
            Iterator<f1<?>> it = this.f32686a.iterator();
            while (it.hasNext()) {
                it.next().b(honorPushErrorEnum.toApiException(), null);
            }
            this.f32686a.clear();
            this.d = honorPushErrorEnum;
            a();
            z.this.b.remove(this.e);
        }

        public final synchronized void b() {
            Log.i("HonorApiManager", "onConnected");
            com.hihonor.push.sdk.b.a(z.this.f32685a);
            this.d = null;
            Iterator<f1<?>> it = this.f32686a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f32686a.clear();
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final synchronized void a(f1<?> f1Var) {
            h0 h0Var;
            IPushInvoke iPushInvoke;
            DataBuffer dataBuffer;
            Type type;
            this.b.add(f1Var);
            b0 b0Var = this.c;
            b bVar = new b(f1Var);
            f1Var.getClass();
            Object objNewInstance = null;
            try {
                Type genericSuperclass = f1Var.getClass().getGenericSuperclass();
                Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                if (cls != null && !cls.isPrimitive()) {
                    objNewInstance = cls.newInstance();
                    h0Var = new h0(objNewInstance, bVar);
                    Log.i("IpcTransport", "start transport parse. " + f1Var.b);
                    iPushInvoke = ((d0) b0Var).b;
                    String str = f1Var.b;
                    RequestHeader requestHeader = f1Var.e;
                    IMessageEntity iMessageEntity = f1Var.c;
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = new Bundle();
                    MessageCodec.formMessageEntity(requestHeader, bundle);
                    MessageCodec.formMessageEntity(iMessageEntity, bundle2);
                    dataBuffer = new DataBuffer(str, bundle, bundle2);
                    if (iPushInvoke != null) {
                        iPushInvoke.call(dataBuffer, h0Var);
                    }
                    Log.i("IpcTransport", "end transport parse.");
                } else {
                    h0Var = new h0(objNewInstance, bVar);
                    Log.i("IpcTransport", "start transport parse. " + f1Var.b);
                    iPushInvoke = ((d0) b0Var).b;
                    String str2 = f1Var.b;
                    RequestHeader requestHeader2 = f1Var.e;
                    IMessageEntity iMessageEntity2 = f1Var.c;
                    Bundle bundle3 = new Bundle();
                    Bundle bundle4 = new Bundle();
                    MessageCodec.formMessageEntity(requestHeader2, bundle3);
                    MessageCodec.formMessageEntity(iMessageEntity2, bundle4);
                    dataBuffer = new DataBuffer(str2, bundle3, bundle4);
                    if (iPushInvoke != null) {
                        try {
                            iPushInvoke.call(dataBuffer, h0Var);
                        } catch (Exception e) {
                            e.toString();
                        }
                    }
                    Log.i("IpcTransport", "end transport parse.");
                }
            } catch (Exception e2) {
                c.a("In newResponseInstance, instancing exception." + e2.getMessage());
            }
            throw th;
        }

        public void a() {
            com.hihonor.push.sdk.b.a(z.this.f32685a);
            d0 d0Var = (d0) this.c;
            int i = d0Var.f32641a.get();
            Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
            if (i != 3) {
                if (i != 5) {
                    return;
                }
                d0Var.f32641a.set(4);
            } else {
                f0 f0Var = d0Var.d;
                if (f0Var != null) {
                    f0Var.b();
                }
                d0Var.f32641a.set(1);
            }
        }
    }
}

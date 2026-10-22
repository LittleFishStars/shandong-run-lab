package com.igexin.push.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.api.SdkInfo;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.config.a.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass27;
import com.igexin.push.core.e.f.AnonymousClass28;
import com.igexin.sdk.PushConsts;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements com.igexin.c.a.d.a.c {
    private static final String j = "CoreLogic";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f37982a;
    Handler b;
    final ConcurrentLinkedQueue<Message> c;
    com.igexin.push.core.a.b d;
    public Handler e;
    final com.igexin.c.a.b.e f;
    public com.igexin.c.a.b.d g;
    public final com.igexin.push.e.a h;
    public final com.igexin.push.b.b i;
    private final f k;
    private final AtomicBoolean l;

    /* JADX INFO: renamed from: com.igexin.push.core.d$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.c.a.b.a.a.a {
        public AnonymousClass1() {
            super(com.igexin.c.a.b.c.f, null);
        }

        @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
        public final void b_() throws Exception {
            super.b_();
            int iMyPid = Process.myPid();
            l lVarA = l.a();
            Bundle bundle = new Bundle();
            bundle.putInt("action", PushConsts.GET_SDKSERVICEPID);
            bundle.putInt("pid", iMyPid);
            lVarA.a(bundle);
            l lVarA2 = l.a();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", PushConsts.ACTION_NOTIFICATION_ENABLE);
            lVarA2.a(bundle2);
            String str = e.f38001a;
            String str2 = e.A;
            GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f38001a).cid(e.A).moduleName(b.j).version("3.3.7.0").build());
            try {
                AssistPushManager.getInstance().initialize(e.l);
                AssistPushManager.getInstance().register(e.l);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(d.j, "|init|failed|");
            }
        }

        @Override // com.igexin.c.a.d.a.e
        public final int c() {
            return 0;
        }

        @Override // com.igexin.c.a.b.a.a.a
        public final void c_() {
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f37984a = new d(0);

        private a() {
        }
    }

    private d() {
        this.c = new ConcurrentLinkedQueue<>();
        this.l = new AtomicBoolean(false);
        this.k = new f();
        com.igexin.c.a.b.e eVarA = com.igexin.c.a.b.e.a();
        this.f = eVarA;
        eVarA.g = new com.igexin.push.d.a(this.f37982a);
        eVarA.a((com.igexin.c.a.d.a.c) this);
        this.h = new com.igexin.push.e.a();
        this.i = new com.igexin.push.b.b(ServiceManager.b);
        this.g = com.igexin.push.d.a.c.a();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static boolean a(com.igexin.push.f.b.f fVar) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVar, false, true);
    }

    public static boolean a(boolean z) {
        com.igexin.c.a.c.a.a("CoreLogic|start sdkSwitch isSlave = ".concat(String.valueOf(z)), new Object[0]);
        if (e.l == null) {
            return false;
        }
        if (!com.igexin.push.core.d.d.a().b("i")) {
            com.igexin.push.core.d.d dVarA = com.igexin.push.core.d.d.a();
            Boolean bool = Boolean.TRUE;
            dVarA.a("i", bool);
            com.igexin.push.core.d.d.a().a("p", bool);
            e.s = true;
        }
        if (z) {
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            e.s = true;
        }
        a.f37984a.h.a();
        return true;
    }

    public static boolean c() {
        com.igexin.c.a.c.a.a("CoreLogic|ext init ###", new Object[0]);
        Process.myPid();
        DisplayMetrics displayMetrics = e.l.getResources().getDisplayMetrics();
        e.j = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        e.k = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
        try {
            if (Build.VERSION.SDK_INT < 30) {
                com.igexin.push.g.j.j();
            }
        } catch (Throwable unused) {
        }
        if (e.aC == null) {
            e.aC = com.igexin.c.b.a.b(e.l.getPackageName() + System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass1(e.aC), false, true);
            String str = e.aC;
        }
        boolean z = e.u;
        return true;
    }

    public static String h() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) e.l.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return "mobile";
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return null;
    }

    private Handler i() {
        return this.e;
    }

    private static d j() {
        return a.f37984a;
    }

    private com.igexin.c.a.b.d k() {
        return this.g;
    }

    private com.igexin.push.e.a l() {
        return this.h;
    }

    private com.igexin.push.b.b m() {
        return this.i;
    }

    private void n() {
        Handler handler;
        try {
            e.a(this.f37982a);
            com.igexin.push.config.b.a();
            com.igexin.push.config.b.b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction(b.L);
            intentFilter.addAction(b.N);
            intentFilter.addAction("com.igexin.action.notification.click");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            int i = Build.VERSION.SDK_INT;
            if (i > 33) {
                this.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null, 4);
            } else {
                this.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null);
            }
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            this.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (TextUtils.isEmpty(com.igexin.push.g.g.c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass27(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass28(), true, false);
            }
            com.igexin.push.core.d.b.d().a();
            com.igexin.push.f.h.b();
            com.igexin.c.a.b.e eVar = this.f;
            Context context = this.f37982a;
            if (!eVar.I) {
                if (!com.igexin.push.g.n.l()) {
                    eVar.v = (PowerManager) context.getSystemService("power");
                    eVar.D = true;
                    eVar.w = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                    try {
                        if (i >= 31) {
                            eVar.t = ((Boolean) AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", new Class[0]).invoke(eVar.w, new Object[0])).booleanValue();
                        } else {
                            eVar.t = true;
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                    com.igexin.c.a.d.g.AnonymousClass1 anonymousClass1 = new com.igexin.c.a.d.g.AnonymousClass1(context);
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 > 33) {
                        context.registerReceiver(eVar, anonymousClass1, e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, anonymousClass1, e.ac, null);
                    }
                    eVar.B = "AlarmNioTaskSchedule." + context.getPackageName();
                    if (i2 > 33) {
                        context.registerReceiver(eVar, new IntentFilter(eVar.B), e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, new IntentFilter(eVar.B), e.ac, null);
                    }
                    int i3 = (com.igexin.push.g.n.a(context) < 31 || i2 < 30) ? 134217728 : 201326592;
                    eVar.x = new Intent("AlarmTaskSchedule." + context.getPackageName());
                    eVar.y = PendingIntent.getBroadcast(context, eVar.hashCode(), eVar.x, i3);
                    eVar.hashCode();
                    eVar.z = new Intent(eVar.B);
                    eVar.A = PendingIntent.getBroadcast(context, eVar.hashCode() + 2, eVar.z, i3);
                    eVar.hashCode();
                }
                eVar.p.start();
                try {
                    Thread.yield();
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
                eVar.I = true;
            }
            com.igexin.c.a.b.e eVar2 = this.f;
            byte[] bArrA = com.igexin.c.b.a.a(e.L.getBytes());
            eVar2.e = bArrA;
            byte[] bArrA2 = com.igexin.c.b.a.a(bArrA);
            eVar2.f = bArrA2;
            if (bArrA2 != null) {
                new String(bArrA2);
            }
            e.ae = this.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.b.g(), false, true);
            e.af = this.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.e.g(), true, true);
            com.igexin.push.c.c.a();
            com.igexin.push.c.c.b();
            b();
            this.d = com.igexin.push.core.a.b.d();
            this.h.a();
            e.m.set(true);
            com.igexin.push.f.g.a().d();
            while (!this.c.isEmpty()) {
                Message messagePoll = this.c.poll();
                if (messagePoll != null && (handler = this.b) != null) {
                    handler.sendMessage(messagePoll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), true);
        } catch (Throwable th3) {
            th = th3;
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = th.getStackTrace();
            while (th.getCause() != null) {
                th = th.getCause();
            }
            sb.append(th.toString());
            sb.append("\n");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            String string = sb.toString();
            com.igexin.c.a.c.a.b(j, string);
            com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + string + " ------");
        }
    }

    private void o() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction(b.L);
        intentFilter.addAction(b.N);
        intentFilter.addAction("com.igexin.action.notification.click");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (Build.VERSION.SDK_INT > 33) {
            this.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null, 4);
        } else {
            this.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null);
        }
    }

    private boolean p() {
        if (e.l == null) {
            return true;
        }
        com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
        e.s = false;
        e.v = false;
        this.h.b();
        return true;
    }

    private static void q() {
        String str = e.f38001a;
        String str2 = e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f38001a).cid(e.A).moduleName(b.j).version("3.3.7.0").build());
    }

    private void r() {
        try {
            this.f37982a.unregisterReceiver(i.a());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static /* synthetic */ void s() {
        String str = e.f38001a;
        String str2 = e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f38001a).cid(e.A).moduleName(b.j).version("3.3.7.0").build());
    }

    public final long a() {
        Handler handler = this.b;
        if (handler == null) {
            return -2L;
        }
        return handler.getLooper().getThread().getId();
    }

    @Override // com.igexin.c.a.d.a.c
    public final void a(long j2) {
    }

    public final boolean a(Context context) {
        this.f37982a = context.getApplicationContext();
        f fVar = this.k;
        if (fVar != null && fVar.isAlive()) {
            com.igexin.c.a.c.a.a("CoreLogic|coreThread is alive +++++", new Object[0]);
            return true;
        }
        if (!this.l.getAndSet(true)) {
            com.igexin.c.a.c.a.a("CoreLogic|start coreThread +++++", new Object[0]);
            this.k.start();
            this.b = new c(this.k.getLooper());
            this.e = new com.igexin.c.a.b.a.a.c(this.k.getLooper());
        }
        return true;
    }

    public final boolean a(Message message) {
        if (e.m.get()) {
            this.b.sendMessage(message);
            return true;
        }
        this.c.add(message);
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean a(com.igexin.c.a.d.a.e eVar) {
        com.igexin.push.core.a.b bVar = this.d;
        return bVar != null && bVar.a(eVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b() {
        com.igexin.push.f.b.a aVarG = com.igexin.push.f.b.a.g();
        com.igexin.push.f.c cVar = new com.igexin.push.f.c();
        aVarG.a((com.igexin.push.f.b.c) cVar);
        aVarG.a((com.igexin.push.f.b.c) com.igexin.push.f.a.a());
        aVarG.a((com.igexin.push.f.b.c) com.igexin.push.f.f.a());
        aVarG.a((com.igexin.push.f.b.c) com.igexin.push.f.g.a());
        aVarG.a((com.igexin.push.f.b.c) com.igexin.push.f.e.a());
        try {
            com.igexin.push.f.a.a().a(false);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        try {
            com.igexin.c.a.c.a.a("ReDisplayTask | execute redisplayTask", new Object[0]);
            com.igexin.push.f.e.a().b();
            com.igexin.push.f.e.a().d();
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        try {
            cVar.b();
            cVar.b = System.currentTimeMillis();
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
        e.ag = this.f.a((com.igexin.c.a.d.f) aVarG, false, true);
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean d() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean e() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean f() {
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final long g() {
        return 94808L;
    }
}

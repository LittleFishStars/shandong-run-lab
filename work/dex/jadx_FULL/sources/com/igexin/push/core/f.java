package com.igexin.push.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.igexin.push.core.d.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass27;
import com.igexin.push.core.e.f.AnonymousClass28;
import com.igexin.sdk.PushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends HandlerThread {
    public f() {
        super("CoreThread");
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        Handler handler;
        d dVar = d.a.f37984a;
        try {
            e.a(dVar.f37982a);
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
                dVar.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null, 4);
            } else {
                dVar.f37982a.registerReceiver(i.a(), intentFilter, e.ac, null);
            }
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            dVar.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (TextUtils.isEmpty(com.igexin.push.g.g.c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass27(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass28(), true, false);
            }
            com.igexin.push.core.d.b.d().a();
            com.igexin.push.f.h.b();
            com.igexin.c.a.b.e eVar = dVar.f;
            Context context = dVar.f37982a;
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
            com.igexin.c.a.b.e eVar2 = dVar.f;
            byte[] bArrA = com.igexin.c.b.a.a(e.L.getBytes());
            eVar2.e = bArrA;
            byte[] bArrA2 = com.igexin.c.b.a.a(bArrA);
            eVar2.f = bArrA2;
            if (bArrA2 != null) {
                new String(bArrA2);
            }
            e.ae = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.b.g(), false, true);
            e.af = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.e.g(), true, true);
            com.igexin.push.c.c.a();
            com.igexin.push.c.c.b();
            dVar.b();
            dVar.d = com.igexin.push.core.a.b.d();
            dVar.h.a();
            e.m.set(true);
            com.igexin.push.f.g.a().d();
            while (!dVar.c.isEmpty()) {
                Message messagePoll = dVar.c.poll();
                if (messagePoll != null && (handler = dVar.b) != null) {
                    handler.sendMessage(messagePoll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) dVar.new AnonymousClass1(), true);
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
            com.igexin.c.a.c.a.b("CoreLogic", string);
            com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + string + " ------");
        }
    }
}

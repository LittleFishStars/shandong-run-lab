package com.google.common.eventbus;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.base.i;
import com.google.common.util.concurrent.j;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32032a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Dispatcher f6243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SubscriberExceptionHandler f6244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f6245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f6247a;

    public static final class a implements SubscriberExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32033a = new a();

        public static Logger b(e eVar) {
            String name = c.class.getName();
            String strC = eVar.b().c();
            StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(strC).length());
            sb.append(name);
            sb.append(Consts.DOT);
            sb.append(strC);
            return Logger.getLogger(sb.toString());
        }

        public static String c(e eVar) {
            Method methodD = eVar.d();
            String name = methodD.getName();
            String name2 = methodD.getParameterTypes()[0].getName();
            String strValueOf = String.valueOf(eVar.c());
            String strValueOf2 = String.valueOf(eVar.a());
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 80 + name2.length() + strValueOf.length() + strValueOf2.length());
            sb.append("Exception thrown by subscriber method ");
            sb.append(name);
            sb.append('(');
            sb.append(name2);
            sb.append(')');
            sb.append(" on subscriber ");
            sb.append(strValueOf);
            sb.append(" when dispatching event: ");
            sb.append(strValueOf2);
            return sb.toString();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void a(Throwable th, e eVar) {
            Logger loggerB = b(eVar);
            Level level = Level.SEVERE;
            if (loggerB.isLoggable(level)) {
                loggerB.log(level, c(eVar), th);
            }
        }
    }

    public c() {
        this("default");
    }

    public final Executor a() {
        return this.f6247a;
    }

    public void b(Throwable th, e eVar) {
        i.E(th);
        i.E(eVar);
        try {
            this.f6244a.a(th, eVar);
        } catch (Throwable th2) {
            f32032a.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    public final String c() {
        return this.f6246a;
    }

    public void d(Object obj) {
        Iterator<d> itF = this.f6245a.f(obj);
        if (itF.hasNext()) {
            this.f6243a.a(obj, itF);
        } else {
            if (obj instanceof b) {
                return;
            }
            d(new b(this, obj));
        }
    }

    public void e(Object obj) {
        this.f6245a.h(obj);
    }

    public void f(Object obj) {
        this.f6245a.i(obj);
    }

    public String toString() {
        return com.google.common.base.e.c(this).s(this.f6246a).toString();
    }

    public c(String str) {
        this(str, j.c(), Dispatcher.d(), a.f32033a);
    }

    public c(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", j.c(), Dispatcher.d(), subscriberExceptionHandler);
    }

    public c(String str, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.f6245a = new f(this);
        this.f6246a = (String) i.E(str);
        this.f6247a = (Executor) i.E(executor);
        this.f6243a = (Dispatcher) i.E(dispatcher);
        this.f6244a = (SubscriberExceptionHandler) i.E(subscriberExceptionHandler);
    }
}

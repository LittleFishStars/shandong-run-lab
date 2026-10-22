package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32410a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    @GuardedBy("this")
    public a f6577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public boolean f6578a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public a f32411a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Runnable f6579a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Executor f6580a;

        public a(Runnable runnable, Executor executor, @CheckForNull a aVar) {
            this.f6579a = runnable;
            this.f6580a = executor;
            this.f32411a = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f32410a;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.log(level, sb.toString(), (Throwable) e);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.i.F(runnable, "Runnable was null.");
        com.google.common.base.i.F(executor, "Executor was null.");
        synchronized (this) {
            if (this.f6578a) {
                c(runnable, executor);
            } else {
                this.f6577a = new a(runnable, executor, this.f6577a);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f6578a) {
                return;
            }
            this.f6578a = true;
            a aVar = this.f6577a;
            a aVar2 = null;
            this.f6577a = null;
            while (aVar != null) {
                a aVar3 = aVar.f32411a;
                aVar.f32411a = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f6579a, aVar2.f6580a);
                aVar2 = aVar2.f32411a;
            }
        }
    }
}

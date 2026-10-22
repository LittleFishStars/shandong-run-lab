package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.bmc;
import com.zj.adlib.ylc;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e0 extends zzec.zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Unsafe f5749a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;

    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new a());
        }
        try {
            b = unsafe.objectFieldOffset(zzec.class.getDeclaredField("a"));
            f31345a = unsafe.objectFieldOffset(zzec.class.getDeclaredField("a"));
            c = unsafe.objectFieldOffset(zzec.class.getDeclaredField("a"));
            d = unsafe.objectFieldOffset(f0.class.getDeclaredField("a"));
            e = unsafe.objectFieldOffset(f0.class.getDeclaredField("a"));
            f5749a = unsafe;
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        } catch (RuntimeException e4) {
            throw e4;
        }
    }

    public e0() {
        super(null);
    }

    public /* synthetic */ e0(bmc bmcVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final a0 a(zzec zzecVar, a0 a0Var) {
        a0 a0Var2;
        do {
            a0Var2 = zzecVar.f5785a;
            if (a0Var == a0Var2) {
                return a0Var2;
            }
        } while (!e(zzecVar, a0Var2, a0Var));
        return a0Var2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final f0 b(zzec zzecVar, f0 f0Var) {
        f0 f0Var2;
        do {
            f0Var2 = zzecVar.f5786a;
            if (f0Var == f0Var2) {
                return f0Var2;
            }
        } while (!g(zzecVar, f0Var2, f0Var));
        return f0Var2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void c(f0 f0Var, @CheckForNull f0 f0Var2) {
        f5749a.putObject(f0Var, e, f0Var2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void d(f0 f0Var, Thread thread) {
        f5749a.putObject(f0Var, d, thread);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean e(zzec zzecVar, @CheckForNull a0 a0Var, a0 a0Var2) {
        return ylc.a(f5749a, zzecVar, f31345a, a0Var, a0Var2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean f(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
        return ylc.a(f5749a, zzecVar, c, obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean g(zzec zzecVar, @CheckForNull f0 f0Var, @CheckForNull f0 f0Var2) {
        return ylc.a(f5749a, zzecVar, b, f0Var, f0Var2);
    }
}

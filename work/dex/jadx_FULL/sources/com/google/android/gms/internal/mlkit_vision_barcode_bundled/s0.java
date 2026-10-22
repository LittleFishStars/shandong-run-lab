package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.hgc;
import com.zj.adlib.uwc;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzhh f5822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class f5823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Unsafe f5824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f5825a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;

    /* JADX WARN: Code duplicated, block: B:11:0x003e  */
    static {
        boolean z;
        boolean z2;
        zzhh zzhhVar;
        Unsafe unsafeL = l();
        f5824a = unsafeL;
        int i = hgc.f42123a;
        f5823a = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zA = A(cls);
        f5825a = zA;
        boolean zA2 = A(Integer.TYPE);
        zzhh q0Var = null;
        if (unsafeL != null) {
            if (zA) {
                q0Var = new r0(unsafeL);
            } else if (zA2) {
                q0Var = new q0(unsafeL);
            }
        }
        f5822a = q0Var;
        if (q0Var == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = q0Var.f31403a.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (b() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } catch (Throwable th) {
                m(th);
            }
        }
        b = z;
        zzhh zzhhVar2 = f5822a;
        if (zzhhVar2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = zzhhVar2.f31403a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                m(th2);
                z2 = false;
            }
        }
        c = z2;
        f31393a = E(byte[].class);
        E(boolean[].class);
        a(boolean[].class);
        E(int[].class);
        a(int[].class);
        E(long[].class);
        a(long[].class);
        E(float[].class);
        a(float[].class);
        E(double[].class);
        a(double[].class);
        E(Object[].class);
        a(Object[].class);
        Field fieldB = b();
        if (fieldB != null && (zzhhVar = f5822a) != null) {
            zzhhVar.f31403a.objectFieldOffset(fieldB);
        }
        d = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A(Class cls) {
        int i = hgc.f42123a;
        try {
            Class cls2 = f5823a;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean B(Object obj, long j) {
        return f5822a.g(obj, j);
    }

    public static boolean C() {
        return c;
    }

    public static boolean D() {
        return b;
    }

    public static int E(Class cls) {
        if (c) {
            return f5822a.f31403a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Class cls) {
        if (c) {
            return f5822a.f31403a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field b() {
        int i = hgc.f42123a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, "address");
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    public static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Object obj, long j, byte b2) {
        zzhh zzhhVar = f5822a;
        long j2 = (-4) & j;
        int i = zzhhVar.f31403a.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zzhhVar.f31403a.putInt(obj, j2, ((255 & b2) << i2) | (i & (~(255 << i2))));
    }

    public static void e(Object obj, long j, byte b2) {
        zzhh zzhhVar = f5822a;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzhhVar.f31403a.putInt(obj, j2, ((255 & b2) << i) | (zzhhVar.f31403a.getInt(obj, j2) & (~(255 << i))));
    }

    public static double f(Object obj, long j) {
        return f5822a.a(obj, j);
    }

    public static float g(Object obj, long j) {
        return f5822a.b(obj, j);
    }

    public static int h(Object obj, long j) {
        return f5822a.f31403a.getInt(obj, j);
    }

    public static long i(Object obj, long j) {
        return f5822a.f31403a.getLong(obj, j);
    }

    public static Object j(Class cls) {
        try {
            return f5824a.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object k(Object obj, long j) {
        return f5822a.f31403a.getObject(obj, j);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new uwc());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void m(Throwable th) {
        Logger.getLogger(s0.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void r(Object obj, long j, boolean z) {
        f5822a.c(obj, j, z);
    }

    public static void s(byte[] bArr, long j, byte b2) {
        f5822a.d(bArr, f31393a + j, b2);
    }

    public static void t(Object obj, long j, double d2) {
        f5822a.e(obj, j, d2);
    }

    public static void u(Object obj, long j, float f) {
        f5822a.f(obj, j, f);
    }

    public static void v(Object obj, long j, int i) {
        f5822a.f31403a.putInt(obj, j, i);
    }

    public static void w(Object obj, long j, long j2) {
        f5822a.f31403a.putLong(obj, j, j2);
    }

    public static void x(Object obj, long j, Object obj2) {
        f5822a.f31403a.putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j) {
        return ((byte) ((f5822a.f31403a.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj, long j) {
        return ((byte) ((f5822a.f31403a.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }
}

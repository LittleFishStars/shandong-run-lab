package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.zj.adlib.hlc;
import com.zj.adlib.kgc;
import com.zj.adlib.llc;
import com.zj.adlib.qjc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzed<MessageType extends zzed<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> extends zzck<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected o0 zzc = o0.c();

    public static llc g(zzfo zzfoVar, Object obj, zzfo zzfoVar2, zzeg zzegVar, int i, zzho zzhoVar, Class cls) {
        return new llc(zzfoVar, obj, zzfoVar2, new hlc(null, i, zzhoVar, false, false), cls);
    }

    public static zzed j(Class cls) {
        Map map = zza;
        zzed zzedVar = (zzed) map.get(cls);
        if (zzedVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzedVar = (zzed) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzedVar == null) {
            zzedVar = (zzed) ((zzed) s0.j(cls)).zzg(6, null, null);
            if (zzedVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzedVar);
        }
        return zzedVar;
    }

    public static Object n(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static zzed s(zzed zzedVar, byte[] bArr, int i, int i2, qjc qjcVar) throws zzeo {
        zzed zzedVarM = zzedVar.m();
        try {
            zzgh zzghVarB = g0.a().b(zzedVarM.getClass());
            zzghVarB.i(zzedVarM, bArr, 0, i2, new kgc(qjcVar));
            zzghVarB.b(zzedVarM);
            return zzedVarM;
        } catch (zzeo e) {
            e.zzf(zzedVarM);
            throw e;
        } catch (zzgx e2) {
            zzeo zzeoVarZza = e2.zza();
            zzeoVarZza.zzf(zzedVarM);
            throw zzeoVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzeo) {
                throw ((zzeo) e3.getCause());
            }
            zzeo zzeoVar = new zzeo(e3);
            zzeoVar.zzf(zzedVarM);
            throw zzeoVar;
        } catch (IndexOutOfBoundsException unused) {
            zzeo zzeoVarZzg = zzeo.zzg();
            zzeoVarZzg.zzf(zzedVarM);
            throw zzeoVarZzg;
        }
    }

    public static zzed zzK(zzed zzedVar, byte[] bArr, qjc qjcVar) throws zzeo {
        zzed zzedVarS = s(zzedVar, bArr, 0, bArr.length, qjcVar);
        if (zzedVarS == null || zzedVarS.i()) {
            return zzedVarS;
        }
        zzeo zzeoVarZza = new zzgx(zzedVarS).zza();
        zzeoVarZza.zzf(zzedVarS);
        throw zzeoVarZza;
    }

    public static zzei zzL() {
        return p.b();
    }

    public static zzei zzM(zzei zzeiVar) {
        int size = zzeiVar.size();
        return zzeiVar.W(size == 0 ? 10 : size + size);
    }

    public static zzej zzN() {
        return t.b();
    }

    public static zzel zzO() {
        return h0.b();
    }

    public static zzel zzP(zzel zzelVar) {
        int size = zzelVar.size();
        return zzelVar.W(size == 0 ? 10 : size + size);
    }

    public static Object zzR(zzfo zzfoVar, String str, Object[] objArr) {
        return new i0(zzfoVar, str, objArr);
    }

    public static void zzU(Class cls, zzed zzedVar) {
        zzedVar.o();
        zza.put(cls, zzedVar);
    }

    public static final boolean zzW(zzed zzedVar, boolean z) {
        byte bByteValue = ((Byte) zzedVar.zzg(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zH = g0.a().b(zzedVar.getClass()).h(zzedVar);
        if (z) {
            zzedVar.zzg(2, true != zH ? null : zzedVar, null);
        }
        return zH;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final /* synthetic */ zzfo a() {
        return (zzed) zzg(6, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck
    public final int c(zzgh zzghVar) {
        if (q()) {
            int iR = r(zzghVar);
            if (iR >= 0) {
                return iR;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iR);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iR2 = r(zzghVar);
        if (iR2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iR2;
            return iR2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iR2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final /* synthetic */ zzfn d() {
        return (r) zzg(5, null, null);
    }

    public final int e() {
        return g0.a().b(getClass()).g(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return g0.a().b(getClass()).c(this, (zzed) obj);
    }

    public final r f() {
        r rVar = (r) zzg(5, null, null);
        rVar.p(this);
        return rVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final /* synthetic */ zzfn h() {
        r rVar = (r) zzg(5, null, null);
        rVar.p(this);
        return rVar;
    }

    public final int hashCode() {
        if (q()) {
            return e();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iE = e();
        this.zzb = iE;
        return iE;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp
    public final boolean i() {
        return zzW(this, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final void k(zzdj zzdjVar) throws IOException {
        g0.a().b(getClass()).a(this, l.L(zzdjVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
    public final int l() {
        int iR;
        if (q()) {
            iR = r(null);
            if (iR < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iR);
            }
        } else {
            iR = this.zzd & Integer.MAX_VALUE;
            if (iR == Integer.MAX_VALUE) {
                iR = r(null);
                if (iR < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iR);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iR;
            }
        }
        return iR;
    }

    public final zzed m() {
        return (zzed) zzg(4, null, null);
    }

    public final void o() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void p(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean q() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final int r(zzgh zzghVar) {
        if (zzghVar != null) {
            return zzghVar.f(this);
        }
        return g0.a().b(getClass()).f(this);
    }

    public final String toString() {
        return d0.a(this, super.toString());
    }

    public final r zzF() {
        return (r) zzg(5, null, null);
    }

    public final void zzS() {
        g0.a().b(getClass()).b(this);
        o();
    }

    public abstract Object zzg(int i, Object obj, Object obj2);
}

package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcl;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bkc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bkc f40768a = new bkc(true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bvc f15553a = new ntc(16);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15554a;
    public boolean b;

    public bkc() {
    }

    public static int a(zzds zzdsVar, Object obj) {
        int iZzd;
        int iA;
        zzho zzhoVarH0 = zzdsVar.h0();
        int iZza = zzdsVar.zza();
        zzdsVar.zzg();
        int i = zzdj.f31401a;
        int iA2 = zzdj.A(iZza << 3);
        if (zzhoVarH0 == zzho.zzj) {
            zzfo zzfoVar = (zzfo) obj;
            byte[] bArr = rmc.f19385a;
            if (zzfoVar instanceof zzcl) {
                throw null;
            }
            iA2 += iA2;
        }
        zzhp zzhpVar = zzhp.INT;
        int iB = 4;
        switch (zzhoVarH0.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                iB = 8;
                return iA2 + iB;
            case 1:
                ((Float) obj).floatValue();
                return iA2 + iB;
            case 2:
                iB = zzdj.B(((Long) obj).longValue());
                return iA2 + iB;
            case 3:
                iB = zzdj.B(((Long) obj).longValue());
                return iA2 + iB;
            case 4:
                iB = zzdj.w(((Integer) obj).intValue());
                return iA2 + iB;
            case 5:
                ((Long) obj).longValue();
                iB = 8;
                return iA2 + iB;
            case 6:
                ((Integer) obj).intValue();
                return iA2 + iB;
            case 7:
                ((Boolean) obj).booleanValue();
                iB = 1;
                return iA2 + iB;
            case 8:
                if (obj instanceof zzdb) {
                    iZzd = ((zzdb) obj).zzd();
                    iA = zzdj.A(iZzd);
                    iB = iA + iZzd;
                } else {
                    iB = zzdj.z((String) obj);
                }
                return iA2 + iB;
            case 9:
                iB = ((zzfo) obj).l();
                return iA2 + iB;
            case 10:
                if (obj instanceof pnc) {
                    iZzd = ((pnc) obj).a();
                    iA = zzdj.A(iZzd);
                    iB = iA + iZzd;
                } else {
                    iB = zzdj.x((zzfo) obj);
                }
                return iA2 + iB;
            case 11:
                if (obj instanceof zzdb) {
                    iZzd = ((zzdb) obj).zzd();
                    iA = zzdj.A(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iA = zzdj.A(iZzd);
                }
                iB = iA + iZzd;
                return iA2 + iB;
            case 12:
                iB = zzdj.A(((Integer) obj).intValue());
                return iA2 + iB;
            case 13:
                iB = obj instanceof zzef ? zzdj.w(((zzef) obj).zza()) : zzdj.w(((Integer) obj).intValue());
                return iA2 + iB;
            case 14:
                ((Integer) obj).intValue();
                return iA2 + iB;
            case 15:
                ((Long) obj).longValue();
                iB = 8;
                return iA2 + iB;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iB = zzdj.A((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iA2 + iB;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iB = zzdj.B((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iA2 + iB;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static bkc d() {
        return f40768a;
    }

    public static Object l(Object obj) {
        if (obj instanceof zzft) {
            return ((zzft) obj).v1();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static boolean n(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        if (zzdsVar.x0() != zzhp.MESSAGE) {
            return true;
        }
        zzdsVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            return ((zzfp) value).i();
        }
        if (value instanceof pnc) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static final int o(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (zzdsVar.x0() != zzhp.MESSAGE) {
            return a(zzdsVar, value);
        }
        zzdsVar.zzg();
        zzdsVar.I();
        if (!(value instanceof pnc)) {
            int iA = zzdj.A(((zzds) entry.getKey()).zza());
            int iA2 = zzdj.A(24) + zzdj.x((zzfo) value);
            int iA3 = zzdj.A(16);
            int iA4 = zzdj.A(8);
            return iA4 + iA4 + iA3 + iA + iA2;
        }
        int iA5 = zzdj.A(((zzds) entry.getKey()).zza());
        int iA6 = ((pnc) value).a();
        int iA7 = zzdj.A(iA6) + iA6;
        int iA8 = zzdj.A(24);
        int iA9 = zzdj.A(16);
        int iA10 = zzdj.A(8);
        return iA10 + iA10 + iA9 + iA5 + iA8 + iA7;
    }

    public final int b() {
        int iO = 0;
        for (int i = 0; i < this.f15553a.c(); i++) {
            iO += o(this.f15553a.h(i));
        }
        Iterator it = this.f15553a.d().iterator();
        while (it.hasNext()) {
            iO += o((Map.Entry) it.next());
        }
        return iO;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final bkc clone() {
        bkc bkcVar = new bkc();
        for (int i = 0; i < this.f15553a.c(); i++) {
            Map.Entry entryH = this.f15553a.h(i);
            bkcVar.i((zzds) entryH.getKey(), entryH.getValue());
        }
        for (Map.Entry entry : this.f15553a.d()) {
            bkcVar.i((zzds) entry.getKey(), entry.getValue());
        }
        bkcVar.b = this.b;
        return bkcVar;
    }

    public final Object e(zzds zzdsVar) {
        Object obj = this.f15553a.get(zzdsVar);
        if (!(obj instanceof pnc)) {
            return obj;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bkc) {
            return this.f15553a.equals(((bkc) obj).f15553a);
        }
        return false;
    }

    public final Iterator f() {
        return this.b ? new lnc(this.f15553a.entrySet().iterator()) : this.f15553a.entrySet().iterator();
    }

    public final void g() {
        if (this.f15554a) {
            return;
        }
        for (int i = 0; i < this.f15553a.c(); i++) {
            Map.Entry entryH = this.f15553a.h(i);
            if (entryH.getValue() instanceof zzed) {
                ((zzed) entryH.getValue()).zzS();
            }
        }
        this.f15553a.b();
        this.f15554a = true;
    }

    public final void h(bkc bkcVar) {
        for (int i = 0; i < bkcVar.f15553a.c(); i++) {
            m(bkcVar.f15553a.h(i));
        }
        Iterator it = bkcVar.f15553a.d().iterator();
        while (it.hasNext()) {
            m((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f15553a.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if ((r7 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if ((r7 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        if (r0 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if ((r7 instanceof com.zj.adlib.pnc) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(zzds zzdsVar, Object obj) {
        boolean z;
        zzdsVar.zzg();
        zzdsVar.h0();
        byte[] bArr = rmc.f19385a;
        obj.getClass();
        zzho zzhoVar = zzho.zza;
        zzhp zzhpVar = zzhp.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zzdb)) {
                    break;
                }
                if (obj instanceof pnc) {
                    this.b = true;
                }
                this.f15553a.put(zzdsVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof pnc) {
                    this.b = true;
                }
                this.f15553a.put(zzdsVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zzfo)) {
                    break;
                }
                if (obj instanceof pnc) {
                    this.b = true;
                }
                this.f15553a.put(zzdsVar, obj);
                return;
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzdsVar.zza()), zzdsVar.h0().zza(), obj.getClass().getName()));
        }
    }

    public final boolean j() {
        return this.f15554a;
    }

    public final boolean k() {
        for (int i = 0; i < this.f15553a.c(); i++) {
            if (!n(this.f15553a.h(i))) {
                return false;
            }
        }
        Iterator it = this.f15553a.d().iterator();
        while (it.hasNext()) {
            if (!n((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void m(Map.Entry entry) {
        zzfo zzfoVarL1;
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof pnc) {
            throw null;
        }
        zzdsVar.zzg();
        if (zzdsVar.x0() != zzhp.MESSAGE) {
            this.f15553a.put(zzdsVar, l(value));
            return;
        }
        Object objE = e(zzdsVar);
        if (objE == null) {
            this.f15553a.put(zzdsVar, l(value));
            return;
        }
        if (objE instanceof zzft) {
            zzfoVarL1 = zzdsVar.t0((zzft) objE, (zzft) value);
        } else {
            zzfn zzfnVarH = ((zzfo) objE).h();
            zzdsVar.u0(zzfnVarH, (zzfo) value);
            zzfoVarL1 = zzfnVarH.L1();
        }
        this.f15553a.put(zzdsVar, zzfoVarL1);
    }

    public bkc(boolean z) {
        g();
        g();
    }
}

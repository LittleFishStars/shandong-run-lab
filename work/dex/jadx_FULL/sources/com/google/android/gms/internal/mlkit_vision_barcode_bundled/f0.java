package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bkc;
import com.zj.adlib.hnc;
import com.zj.adlib.kgc;
import com.zj.adlib.llc;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f0 implements zzgh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzdp f31375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzfo f5801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzgy f5802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5803a;

    public f0(zzgy zzgyVar, zzdp zzdpVar, zzfo zzfoVar) {
        this.f5802a = zzgyVar;
        this.f5803a = zzdpVar.g(zzfoVar);
        this.f31375a = zzdpVar;
        this.f5801a = zzfoVar;
    }

    public static f0 j(zzgy zzgyVar, zzdp zzdpVar, zzfo zzfoVar) {
        return new f0(zzgyVar, zzdpVar, zzfoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void a(Object obj, zzhq zzhqVar) throws IOException {
        Iterator itF = this.f31375a.b(obj).f();
        while (itF.hasNext()) {
            Map.Entry entry = (Map.Entry) itF.next();
            zzds zzdsVar = (zzds) entry.getKey();
            if (zzdsVar.x0() != zzhp.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdsVar.zzg();
            zzdsVar.I();
            if (entry instanceof hnc) {
                zzhqVar.w(zzdsVar.zza(), ((hnc) entry).a().b());
            } else {
                zzhqVar.w(zzdsVar.zza(), entry.getValue());
            }
        }
        zzgy zzgyVar = this.f5802a;
        zzgyVar.i(zzgyVar.d(obj), zzhqVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void b(Object obj) {
        this.f5802a.g(obj);
        this.f31375a.e(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean c(Object obj, Object obj2) {
        if (!this.f5802a.d(obj).equals(this.f5802a.d(obj2))) {
            return false;
        }
        if (this.f5803a) {
            return this.f31375a.b(obj).equals(this.f31375a.b(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void d(Object obj, Object obj2) {
        m0.c(this.f5802a, obj, obj2);
        if (this.f5803a) {
            m0.b(this.f31375a, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final Object e() {
        zzfo zzfoVar = this.f5801a;
        return zzfoVar instanceof zzed ? ((zzed) zzfoVar).m() : zzfoVar.d().K1();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int f(Object obj) {
        zzgy zzgyVar = this.f5802a;
        int iB = zzgyVar.b(zzgyVar.d(obj));
        return this.f5803a ? iB + this.f31375a.b(obj).b() : iB;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final int g(Object obj) {
        int iHashCode = this.f5802a.d(obj).hashCode();
        return this.f5803a ? (iHashCode * 53) + this.f31375a.b(obj).f15553a.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final boolean h(Object obj) {
        return this.f31375a.b(obj).k();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bf A[EDGE_INSN: B:57:0x00bf->B:33:0x00bf BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgh
    public final void i(Object obj, byte[] bArr, int i, int i2, kgc kgcVar) throws IOException {
        zzed zzedVar = (zzed) obj;
        o0 o0VarF = zzedVar.zzc;
        if (o0VarF == o0.c()) {
            o0VarF = o0.f();
            zzedVar.zzc = o0VarF;
        }
        bkc bkcVarT = ((zzdz) obj).t();
        Object objD = null;
        while (i < i2) {
            int iJ = h.j(bArr, i, kgcVar);
            int i3 = kgcVar.f42815a;
            if (i3 == 11) {
                int i4 = 0;
                zzdb zzdbVar = null;
                while (iJ < i2) {
                    iJ = h.j(bArr, iJ, kgcVar);
                    int i5 = kgcVar.f42815a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iJ = h.p(i5, bArr, iJ, i2, kgcVar);
                        } else {
                            iJ = h.j(bArr, iJ, kgcVar);
                            i4 = kgcVar.f42815a;
                            objD = this.f31375a.d(kgcVar.f17677a, this.f5801a, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (objD != null) {
                                llc llcVar = (llc) objD;
                                iJ = h.d(g0.a().b(llcVar.b.getClass()), bArr, iJ, i2, kgcVar);
                                bkcVarT.i(llcVar.f17992a, kgcVar.f17678a);
                            } else if (i7 == 2) {
                                iJ = h.a(bArr, iJ, kgcVar);
                                zzdbVar = (zzdb) kgcVar.f17678a;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iJ = h.p(i5, bArr, iJ, i2, kgcVar);
                        }
                    }
                }
                if (zzdbVar != null) {
                    o0VarF.j((i4 << 3) | 2, zzdbVar);
                }
                i = iJ;
            } else if ((i3 & 7) == 2) {
                Object objD2 = this.f31375a.d(kgcVar.f17677a, this.f5801a, i3 >>> 3);
                if (objD2 != null) {
                    llc llcVar2 = (llc) objD2;
                    i = h.d(g0.a().b(llcVar2.b.getClass()), bArr, iJ, i2, kgcVar);
                    bkcVarT.i(llcVar2.f17992a, kgcVar.f17678a);
                } else {
                    i = h.i(i3, bArr, iJ, i2, o0VarF, kgcVar);
                }
                objD = objD2;
            } else {
                i = h.p(i3, bArr, iJ, i2, kgcVar);
            }
        }
        if (i != i2) {
            throw zzeo.zze();
        }
    }
}

package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.SignedBytes;
import com.zj.adlib.en1;
import com.zj.adlib.om6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;
    public static final int i = 134;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<com.google.android.exoplayer2.d> f3067a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    @Nullable
    public TsPayloadReader a(int i2, TsPayloadReader.b bVar) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return new p(new n(bVar.f3091a));
            }
            if (i2 == 21) {
                return new p(new l());
            }
            if (i2 == 27) {
                if (e(4)) {
                    return null;
                }
                return new p(new j(b(bVar), e(1), e(8)));
            }
            if (i2 == 36) {
                return new p(new k(b(bVar)));
            }
            if (i2 == 89) {
                return new p(new g(bVar.f3092a));
            }
            if (i2 != 138) {
                if (i2 == 172) {
                    return new p(new d(bVar.f3091a));
                }
                if (i2 == 257) {
                    return new r(new o("application/vnd.dvb.ait"));
                }
                if (i2 == 134) {
                    if (e(16)) {
                        return null;
                    }
                    return new r(new o("application/x-scte35"));
                }
                if (i2 != 135) {
                    switch (i2) {
                        case 15:
                            if (e(2)) {
                                return null;
                            }
                            return new p(new e(false, bVar.f3091a));
                        case 16:
                            return new p(new i(c(bVar)));
                        case 17:
                            if (e(2)) {
                                return null;
                            }
                            return new p(new m(bVar.f3091a));
                        default:
                            switch (i2) {
                                case 128:
                                    break;
                                case 129:
                                    break;
                                case 130:
                                    if (!e(64)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    return null;
                            }
                            break;
                    }
                }
                return new p(new b(bVar.f3091a));
            }
            return new p(new f(bVar.f3091a));
        }
        return new p(new h(c(bVar)));
    }

    public final s b(TsPayloadReader.b bVar) {
        return new s(d(bVar));
    }

    public final t c(TsPayloadReader.b bVar) {
        return new t(d(bVar));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final List<com.google.android.exoplayer2.d> d(TsPayloadReader.b bVar) {
        String str;
        int i2;
        if (e(32)) {
            return this.f3067a;
        }
        om6 om6Var = new om6(bVar.f3093a);
        List<com.google.android.exoplayer2.d> arrayList = this.f3067a;
        while (om6Var.a() > 0) {
            int iG = om6Var.G();
            int iE = om6Var.e() + om6Var.G();
            if (iG == 134) {
                arrayList = new ArrayList<>();
                int iG2 = om6Var.G() & 31;
                for (int i3 = 0; i3 < iG2; i3++) {
                    String strD = om6Var.D(3);
                    int iG3 = om6Var.G();
                    boolean z = (iG3 & 128) != 0;
                    if (z) {
                        i2 = iG3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte bG = (byte) om6Var.G();
                    om6Var.T(1);
                    arrayList.add(new com.google.android.exoplayer2.d.b().e0(str).V(strD).F(i2).T(z ? en1.b((bG & SignedBytes.f32242a) != 0) : null).E());
                }
            }
            om6Var.S(iE);
        }
        return arrayList;
    }

    public final boolean e(int i2) {
        return (i2 & this.f30701a) != 0;
    }

    public DefaultTsPayloadReaderFactory(int i2) {
        this(i2, ImmutableList.of());
    }

    public DefaultTsPayloadReaderFactory(int i2, List<com.google.android.exoplayer2.d> list) {
        this.f30701a = i2;
        this.f3067a = list;
    }
}

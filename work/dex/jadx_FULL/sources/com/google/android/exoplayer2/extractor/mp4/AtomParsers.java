package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.zj.adlib.bp2;
import com.zj.adlib.bp5;
import com.zj.adlib.cs3;
import com.zj.adlib.en1;
import com.zj.adlib.fc3;
import com.zj.adlib.gj9;
import com.zj.adlib.ma9;
import com.zj.adlib.mr;
import com.zj.adlib.om6;
import com.zj.adlib.ri0;
import com.zj.adlib.sb0;
import com.zj.adlib.sd6;
import com.zj.adlib.tn1;
import com.zj.adlib.tz3;
import com.zj.adlib.z99;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AtomParsers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30672a = 1668047728;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2940a = "AtomParsers";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f2941a = gj9.z0("OpusHead");
    public static final int b = 1835299937;
    public static final int c = 1835365473;
    public static final int d = 1852009571;
    public static final int e = 1852009592;
    public static final int f = 1935832172;
    public static final int g = 1936684398;
    public static final int h = 1937072756;
    public static final int i = 1952807028;
    public static final int j = 1986618469;
    public static final int k = 4;

    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30673a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2942a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f2943a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2944a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final om6 f2945b;
        public int c;
        public int d;
        public int e;

        public a(om6 om6Var, om6 om6Var2, boolean z) throws ParserException {
            this.f2945b = om6Var;
            this.f2943a = om6Var2;
            this.f2944a = z;
            om6Var2.S(12);
            this.f30673a = om6Var2.K();
            om6Var.S(12);
            this.e = om6Var.K();
            fc3.a(om6Var.o() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f30673a) {
                return false;
            }
            this.f2942a = this.f2944a ? this.f2943a.L() : this.f2943a.I();
            if (this.b == this.d) {
                this.c = this.f2945b.K();
                this.f2945b.T(4);
                int i2 = this.e - 1;
                this.e = i2;
                this.d = i2 > 0 ? this.f2945b.K() - 1 : -1;
            }
            return true;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30674a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2946a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2947a;
        public final long b;

        public b(String str, byte[] bArr, long j, long j2) {
            this.f2946a = str;
            this.f2947a = bArr;
            this.f30674a = j;
            this.b = j2;
        }
    }

    public static final class c {
        public static final int c = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30675a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public com.google.android.exoplayer2.d f2948a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final z99[] f2949a;
        public int b = 0;

        public c(int i) {
            this.f2949a = new z99[i];
        }
    }

    public static final class d implements SampleSizeBox {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30676a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f2950a;
        public final int b;

        public d(Atom.b bVar, com.google.android.exoplayer2.d dVar) {
            om6 om6Var = bVar.f30671a;
            this.f2950a = om6Var;
            om6Var.S(12);
            int iK = om6Var.K();
            if ("audio/raw".equals(dVar.k)) {
                int iP0 = gj9.p0(dVar.W, dVar.U);
                if (iK == 0 || iK % iP0 != 0) {
                    Log.n(AtomParsers.f2940a, "Audio sample size mismatch. stsd sample size: " + iP0 + ", stsz sample size: " + iK);
                    iK = iP0;
                }
            }
            this.f30676a = iK == 0 ? -1 : iK;
            this.b = om6Var.K();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.f30676a;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.f30676a;
            return i == -1 ? this.f2950a.K() : i;
        }
    }

    public static final class e implements SampleSizeBox {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30677a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f2951a;
        public final int b;
        public int c;
        public int d;

        public e(Atom.b bVar) {
            om6 om6Var = bVar.f30671a;
            this.f2951a = om6Var;
            om6Var.S(12);
            this.b = om6Var.K() & 255;
            this.f30677a = om6Var.K();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.f30677a;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.b;
            if (i == 8) {
                return this.f2951a.G();
            }
            if (i == 16) {
                return this.f2951a.M();
            }
            int i2 = this.c;
            this.c = i2 + 1;
            if (i2 % 2 != 0) {
                return this.d & 15;
            }
            int iG = this.f2951a.G();
            this.d = iG;
            return (iG & 240) >> 4;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30678a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2952a;
        public final int b;

        public f(int i, long j, int i2) {
            this.f30678a = i;
            this.f2952a = j;
            this.b = i2;
        }
    }

    public static List<ma9> A(Atom.a aVar, cs3 cs3Var, long j2, @Nullable DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.b.size(); i2++) {
            Atom.a aVar2 = aVar.b.get(i2);
            if (((Atom) aVar2).f30669a == 1953653099 && (trackApply = function.apply(z(aVar2, (Atom.b) sb0.g(aVar.h(1836476516)), j2, drmInitData, z, z2))) != null) {
                arrayList.add(v(trackApply, (Atom.a) sb0.g(((Atom.a) sb0.g(((Atom.a) sb0.g(aVar2.g(1835297121))).g(1835626086))).g(1937007212)), cs3Var));
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> B(Atom.b bVar) {
        om6 om6Var = bVar.f30671a;
        om6Var.S(8);
        Metadata metadataC = null;
        Metadata metadataU = null;
        while (om6Var.a() >= 8) {
            int iE = om6Var.e();
            int iO = om6Var.o();
            int iO2 = om6Var.o();
            if (iO2 == 1835365473) {
                om6Var.S(iE);
                metadataC = C(om6Var, iE + iO);
            } else if (iO2 == 1936553057) {
                om6Var.S(iE);
                metadataU = u(om6Var, iE + iO);
            }
            om6Var.S(iE + iO);
        }
        return Pair.create(metadataC, metadataU);
    }

    @Nullable
    public static Metadata C(om6 om6Var, int i2) {
        om6Var.T(8);
        e(om6Var);
        while (om6Var.e() < i2) {
            int iE = om6Var.e();
            int iO = om6Var.o();
            if (om6Var.o() == 1768715124) {
                om6Var.S(iE);
                return l(om6Var, iE + iO);
            }
            om6Var.S(iE + iO);
        }
        return null;
    }

    public static void D(om6 om6Var, int i2, int i3, int i4, int i5, int i6, @Nullable DrmInitData drmInitData, c cVar, int i7) throws ParserException {
        String str;
        DrmInitData drmInitData2;
        byte[] bArr;
        float f2;
        List<byte[]> list;
        String str2;
        int i8 = i3;
        int i9 = i4;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        c cVar2 = cVar;
        om6Var.S(i8 + 8 + 8);
        om6Var.T(16);
        int iM = om6Var.M();
        int iM2 = om6Var.M();
        om6Var.T(50);
        int iE = om6Var.e();
        int iIntValue = i2;
        if (iIntValue == 1701733238) {
            Pair<Integer, z99> pairS = s(om6Var, i8, i9);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((z99) pairS.second).f21010a);
                cVar2.f2949a[i7] = (z99) pairS.second;
            }
            om6Var.S(iE);
        }
        String str3 = "video/3gpp";
        if (iIntValue == 1831958048) {
            str = "video/mpeg";
        } else {
            str = iIntValue == 1211250227 ? "video/3gpp" : null;
        }
        float fQ = 1.0f;
        byte[] bArrR = null;
        String str4 = null;
        List<byte[]> listOf = null;
        int i10 = -1;
        int iB = -1;
        int i11 = -1;
        int iC = -1;
        ByteBuffer byteBuffer = null;
        b bVarI = null;
        boolean z = false;
        while (true) {
            if (iE - i8 >= i9) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                break;
            }
            om6Var.S(iE);
            int iE2 = om6Var.e();
            String str5 = str3;
            int iO = om6Var.o();
            if (iO == 0) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                if (om6Var.e() - i8 == i9) {
                    break;
                }
            } else {
                drmInitData2 = drmInitDataCopyWithSchemeType;
            }
            fc3.a(iO > 0, "childAtomSize must be positive");
            int iO2 = om6Var.o();
            if (iO2 == 1635148611) {
                fc3.a(str == null, null);
                om6Var.S(iE2 + 8);
                ri0 ri0VarB = ri0.b(om6Var);
                listOf = ri0VarB.f19329a;
                cVar2.f30675a = ri0VarB.f19327a;
                if (!z) {
                    fQ = ri0VarB.f44460a;
                }
                str4 = ri0VarB.f19328a;
                str2 = "video/avc";
            } else if (iO2 == 1752589123) {
                fc3.a(str == null, null);
                om6Var.S(iE2 + 8);
                tz3 tz3VarA = tz3.a(om6Var);
                listOf = tz3VarA.f19923a;
                cVar2.f30675a = tz3VarA.f19921a;
                if (!z) {
                    fQ = tz3VarA.f45033a;
                }
                str4 = tz3VarA.f19922a;
                str2 = "video/hevc";
            } else {
                if (iO2 == 1685480259 || iO2 == 1685485123) {
                    iM2 = iM2;
                    iIntValue = iIntValue;
                    bArr = bArrR;
                    f2 = fQ;
                    list = listOf;
                    bp2 bp2VarA = bp2.a(om6Var);
                    if (bp2VarA != null) {
                        str4 = bp2VarA.f15608a;
                        str = "video/dolby-vision";
                    }
                } else if (iO2 == 1987076931) {
                    fc3.a(str == null, null);
                    str2 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else {
                    if (iO2 == 1635135811) {
                        fc3.a(str == null, null);
                        str2 = "video/av01";
                    } else if (iO2 == 1668050025) {
                        ByteBuffer byteBufferA = byteBuffer == null ? a() : byteBuffer;
                        byteBufferA.position(21);
                        byteBufferA.putShort(om6Var.C());
                        byteBufferA.putShort(om6Var.C());
                        byteBuffer = byteBufferA;
                    } else if (iO2 == 1835295606) {
                        ByteBuffer byteBufferA2 = byteBuffer == null ? a() : byteBuffer;
                        short sC = om6Var.C();
                        short sC2 = om6Var.C();
                        short sC3 = om6Var.C();
                        short sC4 = om6Var.C();
                        short sC5 = om6Var.C();
                        List<byte[]> list2 = listOf;
                        short sC6 = om6Var.C();
                        byte[] bArr2 = bArrR;
                        short sC7 = om6Var.C();
                        float f3 = fQ;
                        short sC8 = om6Var.C();
                        long jI = om6Var.I();
                        long jI2 = om6Var.I();
                        byteBufferA2.position(1);
                        byteBufferA2.putShort(sC5);
                        byteBufferA2.putShort(sC6);
                        byteBufferA2.putShort(sC);
                        byteBufferA2.putShort(sC2);
                        byteBufferA2.putShort(sC3);
                        byteBufferA2.putShort(sC4);
                        byteBufferA2.putShort(sC7);
                        byteBufferA2.putShort(sC8);
                        byteBufferA2.putShort((short) (jI / 10000));
                        byteBufferA2.putShort((short) (jI2 / 10000));
                        byteBuffer = byteBufferA2;
                        listOf = list2;
                        bArrR = bArr2;
                        fQ = f3;
                    } else {
                        iM2 = iM2;
                        iIntValue = iIntValue;
                        bArr = bArrR;
                        f2 = fQ;
                        list = listOf;
                        if (iO2 == 1681012275) {
                            fc3.a(str == null, null);
                            str = str5;
                        } else if (iO2 == 1702061171) {
                            fc3.a(str == null, null);
                            bVarI = i(om6Var, iE2);
                            String str6 = bVarI.f2946a;
                            byte[] bArr3 = bVarI.f2947a;
                            listOf = bArr3 != null ? ImmutableList.of(bArr3) : list;
                            str = str6;
                            bArrR = bArr;
                            fQ = f2;
                        } else if (iO2 == 1885434736) {
                            fQ = q(om6Var, iE2);
                            listOf = list;
                            bArrR = bArr;
                            z = true;
                        } else {
                            if (iO2 == 1937126244) {
                                bArrR = r(om6Var, iE2, iO);
                                listOf = list;
                            } else if (iO2 == 1936995172) {
                                int iG = om6Var.G();
                                om6Var.T(3);
                                if (iG == 0) {
                                    int iG2 = om6Var.G();
                                    if (iG2 == 0) {
                                        i10 = 0;
                                    } else if (iG2 == 1) {
                                        i10 = 1;
                                    } else if (iG2 == 2) {
                                        i10 = 2;
                                    } else if (iG2 == 3) {
                                        i10 = 3;
                                    }
                                }
                            } else if (iO2 == 1668246642) {
                                int iO3 = om6Var.o();
                                if (iO3 == 1852009592 || iO3 == 1852009571) {
                                    int iM3 = om6Var.M();
                                    int iM4 = om6Var.M();
                                    om6Var.T(2);
                                    boolean z2 = iO == 19 && (om6Var.G() & 128) != 0;
                                    iB = tn1.b(iM3);
                                    i11 = z2 ? 1 : 2;
                                    iC = tn1.c(iM4);
                                } else {
                                    Log.n(f2940a, "Unsupported color type: " + Atom.a(iO3));
                                }
                            }
                            fQ = f2;
                        }
                    }
                    iE += iO;
                    i8 = i3;
                    i9 = i4;
                    cVar2 = cVar;
                    str3 = str5;
                    drmInitDataCopyWithSchemeType = drmInitData2;
                    iIntValue = iIntValue;
                    iM2 = iM2;
                }
                listOf = list;
                bArrR = bArr;
                fQ = f2;
                iE += iO;
                i8 = i3;
                i9 = i4;
                cVar2 = cVar;
                str3 = str5;
                drmInitDataCopyWithSchemeType = drmInitData2;
                iIntValue = iIntValue;
                iM2 = iM2;
            }
            str = str2;
            iE += iO;
            i8 = i3;
            i9 = i4;
            cVar2 = cVar;
            str3 = str5;
            drmInitDataCopyWithSchemeType = drmInitData2;
            iIntValue = iIntValue;
            iM2 = iM2;
        }
        int i12 = iM2;
        byte[] bArr4 = bArrR;
        float f4 = fQ;
        List<byte[]> list3 = listOf;
        if (str == null) {
            return;
        }
        com.google.android.exoplayer2.d.b bVarM = new com.google.android.exoplayer2.d.b().R(i5).e0(str).I(str4).j0(iM).Q(i12).a0(f4).d0(i6).b0(bArr4).h0(i10).T(list3).M(drmInitData2);
        int i13 = iB;
        int i14 = i11;
        int i15 = iC;
        if (i13 != -1 || i14 != -1 || i15 != -1 || byteBuffer != null) {
            bVarM.J(new tn1(i13, i14, i15, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (bVarI != null) {
            bVarM.G(Ints.x(bVarI.f30674a)).Z(Ints.x(bVarI.b));
        }
        cVar.f2948a = bVarM.E();
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[gj9.s(4, 0, length)] && jArr[gj9.s(jArr.length - 4, 0, length)] < j4 && j4 <= j2;
    }

    public static int c(om6 om6Var, int i2, int i3, int i4) throws ParserException {
        int iE = om6Var.e();
        fc3.a(iE >= i3, null);
        while (iE - i3 < i4) {
            om6Var.S(iE);
            int iO = om6Var.o();
            fc3.a(iO > 0, "childAtomSize must be positive");
            if (om6Var.o() == i2) {
                return iE;
            }
            iE += iO;
        }
        return -1;
    }

    public static int d(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void e(om6 om6Var) {
        int iE = om6Var.e();
        om6Var.T(4);
        if (om6Var.o() != 1751411826) {
            iE += 4;
        }
        om6Var.S(iE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0167  */
    /* JADX WARN: Code duplicated, block: B:102:0x0170  */
    /* JADX WARN: Code duplicated, block: B:103:0x0172  */
    /* JADX WARN: Code duplicated, block: B:106:0x0181  */
    /* JADX WARN: Code duplicated, block: B:109:0x019c  */
    /* JADX WARN: Code duplicated, block: B:145:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:148:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:153:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:172:0x0303 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0303 A[SYNTHETIC] */
    public static void f(om6 om6Var, int i2, int i3, int i4, int i5, String str, boolean z, @Nullable DrmInitData drmInitData, c cVar, int i6) throws ParserException {
        int iM;
        int iH;
        int iO;
        int iK;
        String str2;
        String str3;
        int i7;
        String str4;
        b bVarI;
        String str5;
        List<byte[]> listOf;
        int iO2;
        boolean z2;
        int iO3;
        int iC;
        byte[] bArr;
        boolean z3;
        int i8 = i3;
        int i9 = i4;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        om6Var.S(i8 + 8 + 8);
        if (z) {
            iM = om6Var.M();
            om6Var.T(6);
        } else {
            om6Var.T(8);
            iM = 0;
        }
        if (iM == 0 || iM == 1) {
            int iM2 = om6Var.M();
            om6Var.T(6);
            iH = om6Var.H();
            om6Var.S(om6Var.e() - 4);
            iO = om6Var.o();
            if (iM == 1) {
                om6Var.T(16);
            }
            iK = iM2;
        } else {
            if (iM != 2) {
                return;
            }
            om6Var.T(16);
            iH = (int) Math.round(om6Var.m());
            iK = om6Var.K();
            om6Var.T(20);
            iO = 0;
        }
        int iE = om6Var.e();
        int iIntValue = i2;
        if (iIntValue == 1701733217) {
            Pair<Integer, z99> pairS = s(om6Var, i8, i9);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((z99) pairS.second).f21010a);
                cVar.f2949a[i6] = (z99) pairS.second;
            }
            om6Var.S(iE);
        }
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (iIntValue != 1935767394) {
                str3 = "audio/raw";
                if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                    i7 = 2;
                } else if (iIntValue == 1953984371) {
                    i7 = 268435456;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = "audio/mpeg";
                } else if (iIntValue == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (iIntValue == 1634492771) {
                    str2 = "audio/alac";
                } else if (iIntValue == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (iIntValue == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (iIntValue == 1332770163) {
                    str2 = "audio/opus";
                } else if (iIntValue == 1716281667) {
                    str2 = "audio/flac";
                } else if (iIntValue == 1835823201) {
                    str2 = "audio/true-hd";
                } else {
                    i7 = -1;
                    str3 = null;
                }
                str4 = str3;
                bVarI = null;
                str5 = null;
                listOf = null;
                while (iE - i8 < i9) {
                    om6Var.S(iE);
                    iO2 = om6Var.o();
                    if (iO2 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    fc3.a(z2, "childAtomSize must be positive");
                    iO3 = om6Var.o();
                    if (iO3 == 1835557187) {
                        int i10 = iO2 - 13;
                        byte[] bArr2 = new byte[i10];
                        om6Var.S(iE + 13);
                        om6Var.k(bArr2, 0, i10);
                        listOf = ImmutableList.of(bArr2);
                    } else {
                        if (iO3 != 1702061171 || (z && iO3 == 2002876005)) {
                            if (iO3 == 1702061171) {
                                iC = iE;
                            } else {
                                iC = c(om6Var, 1702061171, iE, iO2);
                            }
                            if (iC != -1) {
                                bVarI = i(om6Var, iC);
                                str4 = bVarI.f2946a;
                                bArr = bVarI.f2947a;
                                if (bArr != null) {
                                    if ("audio/mp4a-latm".equals(str4)) {
                                        AacUtil.b bVarF = AacUtil.f(bArr);
                                        iH = bVarF.f30530a;
                                        iK = bVarF.b;
                                        str5 = bVarF.f2344a;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        } else {
                            if (iO3 == 1684103987) {
                                om6Var.S(iE + 8);
                                cVar.f2948a = Ac3Util.c(om6Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                            } else if (iO3 == 1684366131) {
                                om6Var.S(iE + 8);
                                cVar.f2948a = Ac3Util.g(om6Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                            } else if (iO3 == 1684103988) {
                                om6Var.S(iE + 8);
                                cVar.f2948a = mr.b(om6Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                            } else if (iO3 == 1684892784) {
                                if (iO <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + iO, null);
                                }
                                iH = iO;
                                iK = 2;
                            } else if (iO3 == 1684305011) {
                                cVar.f2948a = new com.google.android.exoplayer2.d.b().R(i5).e0(str4).H(iK).f0(iH).M(drmInitDataCopyWithSchemeType).V(str).E();
                            } else if (iO3 == 1682927731) {
                                int i11 = iO2 - 8;
                                byte[] bArr3 = f2941a;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i11);
                                om6Var.S(iE + 8);
                                om6Var.k(bArrCopyOf, bArr3.length, i11);
                                listOf = sd6.a(bArrCopyOf);
                            } else if (iO3 == 1684425825) {
                                int i12 = iO2 - 12;
                                byte[] bArr4 = new byte[i12 + 4];
                                bArr4[0] = 102;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                om6Var.S(iE + 12);
                                om6Var.k(bArr4, 4, i12);
                                listOf = ImmutableList.of(bArr4);
                            } else if (iO3 == 1634492771) {
                                int i13 = iO2 - 12;
                                byte[] bArr5 = new byte[i13];
                                om6Var.S(iE + 12);
                                om6Var.k(bArr5, 0, i13);
                                Pair<Integer, Integer> pairH = en1.h(bArr5);
                                int iIntValue2 = ((Integer) pairH.first).intValue();
                                int iIntValue3 = ((Integer) pairH.second).intValue();
                                listOf = ImmutableList.of(bArr5);
                                iH = iIntValue2;
                                iK = iIntValue3;
                            } else {
                                z3 = false;
                            }
                            z3 = false;
                        }
                        iE += iO2;
                        i8 = i3;
                        i9 = i4;
                    }
                    iE += iO2;
                    i8 = i3;
                    i9 = i4;
                }
                if (cVar.f2948a == null || str4 == null) {
                }
                com.google.android.exoplayer2.d.b bVarV = new com.google.android.exoplayer2.d.b().R(i5).e0(str4).I(str5).H(iK).f0(iH).Y(i7).T(listOf).M(drmInitDataCopyWithSchemeType).V(str);
                if (bVarI != null) {
                    bVarV.G(Ints.x(bVarI.f30674a)).Z(Ints.x(bVarI.b));
                }
                cVar.f2948a = bVarV.E();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i7 = -1;
        str4 = str3;
        bVarI = null;
        str5 = null;
        listOf = null;
        while (iE - i8 < i9) {
            om6Var.S(iE);
            iO2 = om6Var.o();
            if (iO2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            fc3.a(z2, "childAtomSize must be positive");
            iO3 = om6Var.o();
            if (iO3 == 1835557187) {
                int i14 = iO2 - 13;
                byte[] bArr6 = new byte[i14];
                om6Var.S(iE + 13);
                om6Var.k(bArr6, 0, i14);
                listOf = ImmutableList.of(bArr6);
            } else {
                if (iO3 != 1702061171) {
                    if (iO3 == 1702061171) {
                        iC = iE;
                    } else {
                        iC = c(om6Var, 1702061171, iE, iO2);
                    }
                    if (iC != -1) {
                        bVarI = i(om6Var, iC);
                        str4 = bVarI.f2946a;
                        bArr = bVarI.f2947a;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str4)) {
                                AacUtil.b bVarF2 = AacUtil.f(bArr);
                                iH = bVarF2.f30530a;
                                iK = bVarF2.b;
                                str5 = bVarF2.f2344a;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                    }
                } else {
                    if (iO3 == 1702061171) {
                        iC = iE;
                    } else {
                        iC = c(om6Var, 1702061171, iE, iO2);
                    }
                    if (iC != -1) {
                        bVarI = i(om6Var, iC);
                        str4 = bVarI.f2946a;
                        bArr = bVarI.f2947a;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str4)) {
                                AacUtil.b bVarF3 = AacUtil.f(bArr);
                                iH = bVarF3.f30530a;
                                iK = bVarF3.b;
                                str5 = bVarF3.f2344a;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                    }
                }
                iE += iO2;
                i8 = i3;
                i9 = i4;
            }
            iE += iO2;
            i8 = i3;
            i9 = i4;
        }
        if (cVar.f2948a == null) {
        }
    }

    @Nullable
    public static Pair<Integer, z99> g(om6 om6Var, int i2, int i3) throws ParserException {
        int i4 = i2 + 8;
        int i5 = -1;
        int i6 = 0;
        String strD = null;
        Integer numValueOf = null;
        while (i4 - i2 < i3) {
            om6Var.S(i4);
            int iO = om6Var.o();
            int iO2 = om6Var.o();
            if (iO2 == 1718775137) {
                numValueOf = Integer.valueOf(om6Var.o());
            } else if (iO2 == 1935894637) {
                om6Var.T(4);
                strD = om6Var.D(4);
            } else if (iO2 == 1935894633) {
                i5 = i4;
                i6 = iO;
            }
            i4 += iO;
        }
        if (!"cenc".equals(strD) && !"cbc1".equals(strD) && !"cens".equals(strD) && !"cbcs".equals(strD)) {
            return null;
        }
        fc3.a(numValueOf != null, "frma atom is mandatory");
        fc3.a(i5 != -1, "schi atom is mandatory");
        z99 z99VarT = t(om6Var, i5, i6, strD);
        fc3.a(z99VarT != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (z99) gj9.k(z99VarT));
    }

    @Nullable
    public static Pair<long[], long[]> h(Atom.a aVar) {
        Atom.b bVarH = aVar.h(1701606260);
        if (bVarH == null) {
            return null;
        }
        om6 om6Var = bVarH.f30671a;
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        int iK = om6Var.K();
        long[] jArr = new long[iK];
        long[] jArr2 = new long[iK];
        for (int i2 = 0; i2 < iK; i2++) {
            jArr[i2] = iC == 1 ? om6Var.L() : om6Var.I();
            jArr2[i2] = iC == 1 ? om6Var.z() : om6Var.o();
            if (om6Var.C() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            om6Var.T(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static b i(om6 om6Var, int i2) {
        om6Var.S(i2 + 8 + 4);
        om6Var.T(1);
        j(om6Var);
        om6Var.T(2);
        int iG = om6Var.G();
        if ((iG & 128) != 0) {
            om6Var.T(2);
        }
        if ((iG & 64) != 0) {
            om6Var.T(om6Var.G());
        }
        if ((iG & 32) != 0) {
            om6Var.T(2);
        }
        om6Var.T(1);
        j(om6Var);
        String strH = bp5.h(om6Var.G());
        if ("audio/mpeg".equals(strH) || "audio/vnd.dts".equals(strH) || "audio/vnd.dts.hd".equals(strH)) {
            return new b(strH, null, -1L, -1L);
        }
        om6Var.T(4);
        long jI = om6Var.I();
        long jI2 = om6Var.I();
        om6Var.T(1);
        int iJ = j(om6Var);
        byte[] bArr = new byte[iJ];
        om6Var.k(bArr, 0, iJ);
        return new b(strH, bArr, jI2 > 0 ? jI2 : -1L, jI > 0 ? jI : -1L);
    }

    public static int j(om6 om6Var) {
        int iG = om6Var.G();
        int i2 = iG & 127;
        while ((iG & 128) == 128) {
            iG = om6Var.G();
            i2 = (i2 << 7) | (iG & 127);
        }
        return i2;
    }

    public static int k(om6 om6Var) {
        om6Var.S(16);
        return om6Var.o();
    }

    @Nullable
    public static Metadata l(om6 om6Var, int i2) {
        om6Var.T(8);
        ArrayList arrayList = new ArrayList();
        while (om6Var.e() < i2) {
            Metadata.Entry entryC = com.google.android.exoplayer2.extractor.mp4.b.c(om6Var);
            if (entryC != null) {
                arrayList.add(entryC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> m(om6 om6Var) {
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        om6Var.T(iC == 0 ? 8 : 16);
        long jI = om6Var.I();
        om6Var.T(iC == 0 ? 4 : 8);
        int iM = om6Var.M();
        return Pair.create(Long.valueOf(jI), "" + ((char) (((iM >> 10) & 31) + 96)) + ((char) (((iM >> 5) & 31) + 96)) + ((char) ((iM & 31) + 96)));
    }

    @Nullable
    public static Metadata n(Atom.a aVar) {
        Atom.b bVarH = aVar.h(1751411826);
        Atom.b bVarH2 = aVar.h(1801812339);
        Atom.b bVarH3 = aVar.h(1768715124);
        if (bVarH == null || bVarH2 == null || bVarH3 == null || k(bVarH.f30671a) != 1835299937) {
            return null;
        }
        om6 om6Var = bVarH2.f30671a;
        om6Var.S(12);
        int iO = om6Var.o();
        String[] strArr = new String[iO];
        for (int i2 = 0; i2 < iO; i2++) {
            int iO2 = om6Var.o();
            om6Var.T(4);
            strArr[i2] = om6Var.D(iO2 - 8);
        }
        om6 om6Var2 = bVarH3.f30671a;
        om6Var2.S(8);
        ArrayList arrayList = new ArrayList();
        while (om6Var2.a() > 8) {
            int iE = om6Var2.e();
            int iO3 = om6Var2.o();
            int iO4 = om6Var2.o() - 1;
            if (iO4 < 0 || iO4 >= iO) {
                Log.n(f2940a, "Skipped metadata with unknown key index: " + iO4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = com.google.android.exoplayer2.extractor.mp4.b.f(om6Var2, iE + iO3, strArr[iO4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            om6Var2.S(iE + iO3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void o(om6 om6Var, int i2, int i3, int i4, c cVar) {
        om6Var.S(i3 + 8 + 8);
        if (i2 == 1835365492) {
            om6Var.A();
            String strA = om6Var.A();
            if (strA != null) {
                cVar.f2948a = new com.google.android.exoplayer2.d.b().R(i4).e0(strA).E();
            }
        }
    }

    public static long p(om6 om6Var) {
        om6Var.S(8);
        om6Var.T(Atom.c(om6Var.o()) != 0 ? 16 : 8);
        return om6Var.I();
    }

    public static float q(om6 om6Var, int i2) {
        om6Var.S(i2 + 8);
        return om6Var.K() / om6Var.K();
    }

    @Nullable
    public static byte[] r(om6 om6Var, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            om6Var.S(i4);
            int iO = om6Var.o();
            if (om6Var.o() == 1886547818) {
                return Arrays.copyOfRange(om6Var.d(), i4, iO + i4);
            }
            i4 += iO;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, z99> s(om6 om6Var, int i2, int i3) throws ParserException {
        Pair<Integer, z99> pairG;
        int iE = om6Var.e();
        while (iE - i2 < i3) {
            om6Var.S(iE);
            int iO = om6Var.o();
            fc3.a(iO > 0, "childAtomSize must be positive");
            if (om6Var.o() == 1936289382 && (pairG = g(om6Var, iE, iO)) != null) {
                return pairG;
            }
            iE += iO;
        }
        return null;
    }

    @Nullable
    public static z99 t(om6 om6Var, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            om6Var.S(i6);
            int iO = om6Var.o();
            if (om6Var.o() == 1952804451) {
                int iC = Atom.c(om6Var.o());
                om6Var.T(1);
                if (iC == 0) {
                    om6Var.T(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iG = om6Var.G();
                    i4 = iG & 15;
                    i5 = (iG & 240) >> 4;
                }
                boolean z = om6Var.G() == 1;
                int iG2 = om6Var.G();
                byte[] bArr2 = new byte[16];
                om6Var.k(bArr2, 0, 16);
                if (z && iG2 == 0) {
                    int iG3 = om6Var.G();
                    bArr = new byte[iG3];
                    om6Var.k(bArr, 0, iG3);
                }
                return new z99(z, str, iG2, bArr2, i5, i4, bArr);
            }
            i6 += iO;
        }
    }

    @Nullable
    public static Metadata u(om6 om6Var, int i2) {
        om6Var.T(12);
        while (om6Var.e() < i2) {
            int iE = om6Var.e();
            int iO = om6Var.o();
            if (om6Var.o() == 1935766900) {
                if (iO < 14) {
                    return null;
                }
                om6Var.T(5);
                int iG = om6Var.G();
                if (iG != 12 && iG != 13) {
                    return null;
                }
                float f2 = iG == 12 ? 240.0f : 120.0f;
                om6Var.T(1);
                return new Metadata(new SmtaMetadataEntry(f2, om6Var.G()));
            }
            om6Var.S(iE + iO);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:150:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:154:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x040f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0411  */
    /* JADX WARN: Code duplicated, block: B:167:0x0415  */
    /* JADX WARN: Code duplicated, block: B:172:0x0431  */
    /* JADX WARN: Code duplicated, block: B:175:0x0436  */
    /* JADX WARN: Code duplicated, block: B:176:0x0439  */
    /* JADX WARN: Code duplicated, block: B:178:0x043c  */
    /* JADX WARN: Code duplicated, block: B:179:0x043f  */
    /* JADX WARN: Code duplicated, block: B:181:0x0442  */
    /* JADX WARN: Code duplicated, block: B:182:0x0444  */
    /* JADX WARN: Code duplicated, block: B:184:0x0448  */
    /* JADX WARN: Code duplicated, block: B:185:0x044b  */
    /* JADX WARN: Code duplicated, block: B:189:0x045a  */
    /* JADX WARN: Code duplicated, block: B:191:0x0468  */
    /* JADX WARN: Code duplicated, block: B:192:0x0478  */
    /* JADX WARN: Code duplicated, block: B:195:0x0480  */
    /* JADX WARN: Code duplicated, block: B:197:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:199:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:200:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:210:0x0426 A[EDGE_INSN: B:210:0x0426->B:169:0x0426 BREAK  A[LOOP:2: B:152:0x03c5->B:168:0x041f], SYNTHETIC] */
    public static ma9 v(Track track, Atom.a aVar, cs3 cs3Var) throws ParserException {
        SampleSizeBox eVar;
        boolean z;
        int iK;
        int iK2;
        int iK3;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        Track track2;
        int i6;
        long[] jArr;
        int[] iArr;
        int i7;
        long j2;
        long[] jArr2;
        int[] iArr2;
        int iO;
        int i8;
        int i9;
        int i10;
        long[] jArr3;
        boolean z3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr4;
        int i11;
        boolean z4;
        int i12;
        int i13;
        long[] jArr5;
        long[] jArr6;
        int[] iArr5;
        int i14;
        boolean z5;
        long[] jArr7;
        int[] iArr6;
        int i15;
        int[] iArr7;
        long[] jArr8;
        int i16;
        int[] iArr8;
        long j3;
        int i17;
        long j4;
        int i18;
        int i19;
        int[] iArr9;
        int i20;
        int i21;
        int i22;
        long j5;
        boolean z6;
        int i23;
        int i24;
        int i25;
        boolean z7;
        Atom.b bVarH = aVar.h(1937011578);
        if (bVarH != null) {
            eVar = new d(bVarH, track.f3009a);
        } else {
            Atom.b bVarH2 = aVar.h(1937013298);
            if (bVarH2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            eVar = new e(bVarH2);
        }
        int sampleCount = eVar.getSampleCount();
        if (sampleCount == 0) {
            return new ma9(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.b bVarH3 = aVar.h(1937007471);
        if (bVarH3 == null) {
            bVarH3 = (Atom.b) sb0.g(aVar.h(1668232756));
            z = true;
        } else {
            z = false;
        }
        om6 om6Var = bVarH3.f30671a;
        om6 om6Var2 = ((Atom.b) sb0.g(aVar.h(1937011555))).f30671a;
        om6 om6Var3 = ((Atom.b) sb0.g(aVar.h(1937011827))).f30671a;
        Atom.b bVarH4 = aVar.h(1937011571);
        om6 om6Var4 = bVarH4 != null ? bVarH4.f30671a : null;
        Atom.b bVarH5 = aVar.h(1668576371);
        om6 om6Var5 = bVarH5 != null ? bVarH5.f30671a : null;
        a aVar2 = new a(om6Var2, om6Var, z);
        om6Var3.S(12);
        int iK4 = om6Var3.K() - 1;
        int iK5 = om6Var3.K();
        int iK6 = om6Var3.K();
        if (om6Var5 != null) {
            om6Var5.S(12);
            iK = om6Var5.K();
        } else {
            iK = 0;
        }
        if (om6Var4 != null) {
            om6Var4.S(12);
            iK3 = om6Var4.K();
            if (iK3 > 0) {
                iK2 = om6Var4.K() - 1;
            } else {
                iK2 = -1;
                om6Var4 = null;
            }
        } else {
            iK2 = -1;
            iK3 = 0;
        }
        int fixedSampleSize = eVar.getFixedSampleSize();
        String str = track.f3009a.k;
        if (fixedSampleSize != -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iK4 == 0 && iK == 0 && iK3 == 0) {
            int i26 = aVar2.f30673a;
            long[] jArr9 = new long[i26];
            int[] iArr10 = new int[i26];
            while (aVar2.a()) {
                int i27 = aVar2.b;
                jArr9[i27] = aVar2.f2942a;
                iArr10[i27] = aVar2.c;
            }
            com.google.android.exoplayer2.extractor.mp4.a.b bVarA = com.google.android.exoplayer2.extractor.mp4.a.a(fixedSampleSize, jArr9, iArr10, iK6);
            long[] jArr10 = bVarA.f3017a;
            int[] iArr11 = bVarA.f3016a;
            int i28 = bVarA.f30686a;
            long[] jArr11 = bVarA.f3018b;
            int[] iArr12 = bVarA.b;
            long j6 = bVarA.f3015a;
            track2 = track;
            i6 = sampleCount;
            jArr = jArr10;
            iArr = iArr11;
            i7 = i28;
            iArr2 = iArr12;
            j2 = j6;
            jArr2 = jArr11;
        } else {
            long[] jArrCopyOf = new long[sampleCount];
            int[] iArrCopyOf = new int[sampleCount];
            long[] jArrCopyOf2 = new long[sampleCount];
            int[] iArrCopyOf2 = new int[sampleCount];
            int iK7 = iK2;
            int i29 = 0;
            int i30 = 0;
            int iO2 = 0;
            int i31 = 0;
            int iK8 = 0;
            long j7 = 0;
            long j8 = 0;
            int i32 = iK;
            int i33 = iK6;
            int i34 = iK5;
            int i35 = iK4;
            int i36 = iK3;
            while (true) {
                i2 = i35;
                if (i29 >= sampleCount) {
                    i3 = i34;
                    i4 = i31;
                    break;
                }
                long j9 = j8;
                int i37 = i31;
                boolean zA = true;
                while (i37 == 0) {
                    zA = aVar2.a();
                    if (!zA) {
                        break;
                    }
                    int i38 = i34;
                    long j10 = aVar2.f2942a;
                    i37 = aVar2.c;
                    j9 = j10;
                    i34 = i38;
                    i33 = i33;
                    sampleCount = sampleCount;
                }
                int i39 = sampleCount;
                i3 = i34;
                int i40 = i33;
                if (!zA) {
                    Log.n(f2940a, "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i29);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i29);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i29);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i29);
                    sampleCount = i29;
                    i4 = i37;
                    break;
                }
                if (om6Var5 != null) {
                    while (iK8 == 0 && i32 > 0) {
                        iK8 = om6Var5.K();
                        iO2 = om6Var5.o();
                        i32--;
                    }
                    iK8--;
                }
                int i41 = iO2;
                jArrCopyOf[i29] = j9;
                int nextSampleSize = eVar.readNextSampleSize();
                iArrCopyOf[i29] = nextSampleSize;
                if (nextSampleSize > i30) {
                    i30 = nextSampleSize;
                }
                jArrCopyOf2[i29] = j7 + ((long) i41);
                iArrCopyOf2[i29] = om6Var4 == null ? 1 : 0;
                if (i29 == iK7) {
                    iArrCopyOf2[i29] = 1;
                    i36--;
                    if (i36 > 0) {
                        iK7 = ((om6) sb0.g(om6Var4)).K() - 1;
                    }
                }
                int i42 = iK7;
                j7 += (long) i40;
                int iK9 = i3 - 1;
                if (iK9 != 0 || i2 <= 0) {
                    iO = i40;
                    i8 = i2;
                } else {
                    iK9 = om6Var3.K();
                    iO = om6Var3.o();
                    i8 = i2 - 1;
                }
                int i43 = iK9;
                long j11 = j9 + ((long) iArrCopyOf[i29]);
                i31 = i37 - 1;
                i29++;
                j8 = j11;
                iK7 = i42;
                i33 = iO;
                sampleCount = i39;
                iO2 = i41;
                i35 = i8;
                i34 = i43;
            }
            long j12 = j7 + ((long) iO2);
            if (om6Var5 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i32 <= 0) {
                    z2 = true;
                    break;
                }
                if (om6Var5.K() != 0) {
                    z2 = false;
                    break;
                }
                om6Var5.o();
                i32--;
            }
            if (i36 == 0 && i3 == 0 && i4 == 0 && i2 == 0) {
                i5 = iK8;
                if (i5 == 0 && z2) {
                    track2 = track;
                }
                i6 = sampleCount;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i7 = i30;
                j2 = j12;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            } else {
                i5 = iK8;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            track2 = track;
            sb.append(track2.f30684a);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i36);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i3);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i4);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i2);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i5);
            sb.append(!z2 ? ", ctts invalid" : "");
            Log.n(f2940a, sb.toString());
            i6 = sampleCount;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i7 = i30;
            j2 = j12;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        long jO1 = gj9.o1(j2, 1000000L, track2.f3008a);
        long[] jArr12 = track2.f3010a;
        if (jArr12 == null) {
            gj9.q1(jArr2, 1000000L, track2.f3008a);
            return new ma9(track, jArr, iArr, i7, jArr2, iArr2, jO1);
        }
        if (jArr12.length == 1 && track2.b == 1 && jArr2.length >= 2) {
            long j13 = ((long[]) sb0.g(track2.f3013b))[0];
            long jO2 = j13 + gj9.o1(track2.f3010a[0], track2.f3008a, track2.f3012b);
            i9 = i6;
            if (b(jArr2, j2, j13, jO2)) {
                long jO3 = gj9.o1(j13 - jArr2[0], track2.f3009a.V, track2.f3008a);
                i10 = i7;
                long jO4 = gj9.o1(j2 - jO2, track2.f3009a.V, track2.f3008a);
                if ((jO3 != 0 || jO4 != 0) && jO3 <= 2147483647L && jO4 <= 2147483647L) {
                    cs3Var.f15885a = (int) jO3;
                    cs3Var.f15886b = (int) jO4;
                    gj9.q1(jArr2, 1000000L, track2.f3008a);
                    return new ma9(track, jArr, iArr, i10, jArr2, iArr2, gj9.o1(track2.f3010a[0], 1000000L, track2.f3012b));
                }
            }
            jArr3 = track2.f3010a;
            if (jArr3.length != 1 && jArr3[0] == 0) {
                long j14 = ((long[]) sb0.g(track2.f3013b))[0];
                for (int i44 = 0; i44 < jArr2.length; i44++) {
                    jArr2[i44] = gj9.o1(jArr2[i44] - j14, 1000000L, track2.f3008a);
                }
                return new ma9(track, jArr, iArr, i10, jArr2, iArr2, gj9.o1(j2 - j14, 1000000L, track2.f3008a));
            }
            if (track2.b == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            iArr3 = new int[jArr3.length];
            iArr4 = new int[jArr3.length];
            jArr4 = (long[]) sb0.g(track2.f3013b);
            i11 = 0;
            z4 = false;
            i12 = 0;
            i13 = 0;
            while (true) {
                jArr5 = track2.f3010a;
                if (i11 < jArr5.length) {
                    break;
                }
                long[] jArr13 = jArr;
                int[] iArr13 = iArr;
                j5 = jArr4[i11];
                if (j5 != -1) {
                    i24 = i13;
                    boolean z8 = z4;
                    int i45 = i12;
                    long jO5 = gj9.o1(jArr5[i11], track2.f3008a, track2.f3012b);
                    iArr3[i11] = gj9.j(jArr2, j5, true, true);
                    iArr4[i11] = gj9.f(jArr2, j5 + jO5, z3, false);
                    while (true) {
                        i25 = iArr3[i11];
                        i23 = iArr4[i11];
                        if (i25 >= i23 || (iArr2[i25] & 1) != 0) {
                            break;
                        }
                        iArr3[i11] = i25 + 1;
                    }
                    i12 = i45 + (i23 - i25);
                    if (i24 != i25) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z6 = z8 | z7;
                } else {
                    z6 = z4;
                    i23 = i13;
                }
                i11++;
                z4 = z6;
                i13 = i23;
                jArr = jArr13;
                iArr = iArr13;
            }
            jArr6 = jArr;
            iArr5 = iArr;
            boolean z9 = z4;
            i14 = 0;
            z5 = z9 | (i12 != i9);
            if (z5) {
                jArr7 = new long[i12];
            } else {
                jArr7 = jArr6;
            }
            if (z5) {
                iArr6 = new int[i12];
            } else {
                iArr6 = iArr5;
            }
            if (z5) {
                i15 = 0;
            } else {
                i15 = i10;
            }
            if (z5) {
                iArr7 = new int[i12];
            } else {
                iArr7 = iArr2;
            }
            jArr8 = new long[i12];
            i16 = i15;
            iArr8 = iArr5;
            j3 = 0;
            i17 = 0;
            while (i14 < track2.f3010a.length) {
                j4 = track2.f3013b[i14];
                i18 = iArr3[i14];
                int[] iArr14 = iArr3;
                i19 = iArr4[i14];
                int[] iArr15 = iArr4;
                if (z5) {
                    int i46 = i19 - i18;
                    System.arraycopy(jArr6, i18, jArr7, i17, i46);
                    iArr9 = iArr8;
                    System.arraycopy(iArr9, i18, iArr6, i17, i46);
                    System.arraycopy(iArr2, i18, iArr7, i17, i46);
                } else {
                    iArr9 = iArr8;
                }
                i20 = i16;
                while (i18 < i19) {
                    i21 = i20;
                    int i47 = i19;
                    long[] jArr14 = jArr2;
                    int[] iArr16 = iArr2;
                    int[] iArr17 = iArr7;
                    long j15 = j3;
                    jArr8[i17] = gj9.o1(j3, 1000000L, track2.f3012b) + gj9.o1(Math.max(0L, jArr2[i18] - j4), 1000000L, track2.f3008a);
                    if (z5) {
                        i22 = i21;
                        if (iArr6[i17] > i22) {
                            i20 = iArr9[i18];
                        }
                        i17++;
                        i18++;
                        i19 = i47;
                        j3 = j15;
                        jArr2 = jArr14;
                        iArr2 = iArr16;
                        iArr7 = iArr17;
                    } else {
                        i22 = i21;
                    }
                    i20 = i22;
                    i17++;
                    i18++;
                    i19 = i47;
                    j3 = j15;
                    jArr2 = jArr14;
                    iArr2 = iArr16;
                    iArr7 = iArr17;
                }
                long[] jArr15 = jArr2;
                long j16 = j3 + track2.f3010a[i14];
                i14++;
                i16 = i20;
                iArr8 = iArr9;
                j3 = j16;
                iArr3 = iArr14;
                jArr2 = jArr15;
                iArr2 = iArr2;
                iArr4 = iArr15;
                jArr6 = jArr6;
                iArr7 = iArr7;
            }
            return new ma9(track, jArr7, iArr6, i16, jArr8, iArr7, gj9.o1(j3, 1000000L, track2.f3012b));
        }
        i9 = i6;
        i10 = i7;
        jArr3 = track2.f3010a;
        if (jArr3.length != 1) {
        }
        if (track2.b == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        iArr3 = new int[jArr3.length];
        iArr4 = new int[jArr3.length];
        jArr4 = (long[]) sb0.g(track2.f3013b);
        i11 = 0;
        z4 = false;
        i12 = 0;
        i13 = 0;
        while (true) {
            jArr5 = track2.f3010a;
            if (i11 < jArr5.length) {
                break;
                break;
            }
            long[] jArr16 = jArr;
            int[] iArr18 = iArr;
            j5 = jArr4[i11];
            if (j5 != -1) {
                i24 = i13;
                boolean z10 = z4;
                int i48 = i12;
                long jO6 = gj9.o1(jArr5[i11], track2.f3008a, track2.f3012b);
                iArr3[i11] = gj9.j(jArr2, j5, true, true);
                iArr4[i11] = gj9.f(jArr2, j5 + jO6, z3, false);
                while (true) {
                    i25 = iArr3[i11];
                    i23 = iArr4[i11];
                    if (i25 >= i23) {
                        break;
                    }
                    break;
                    break;
                    iArr3[i11] = i25 + 1;
                }
                i12 = i48 + (i23 - i25);
                if (i24 != i25) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z6 = z10 | z7;
            } else {
                z6 = z4;
                i23 = i13;
            }
            i11++;
            z4 = z6;
            i13 = i23;
            jArr = jArr16;
            iArr = iArr18;
        }
        jArr6 = jArr;
        iArr5 = iArr;
        boolean z11 = z4;
        i14 = 0;
        z5 = z11 | (i12 != i9);
        if (z5) {
            jArr7 = new long[i12];
        } else {
            jArr7 = jArr6;
        }
        if (z5) {
            iArr6 = new int[i12];
        } else {
            iArr6 = iArr5;
        }
        if (z5) {
            i15 = 0;
        } else {
            i15 = i10;
        }
        if (z5) {
            iArr7 = new int[i12];
        } else {
            iArr7 = iArr2;
        }
        jArr8 = new long[i12];
        i16 = i15;
        iArr8 = iArr5;
        j3 = 0;
        i17 = 0;
        while (i14 < track2.f3010a.length) {
            j4 = track2.f3013b[i14];
            i18 = iArr3[i14];
            int[] iArr19 = iArr3;
            i19 = iArr4[i14];
            int[] iArr110 = iArr4;
            if (z5) {
                int i49 = i19 - i18;
                System.arraycopy(jArr6, i18, jArr7, i17, i49);
                iArr9 = iArr8;
                System.arraycopy(iArr9, i18, iArr6, i17, i49);
                System.arraycopy(iArr2, i18, iArr7, i17, i49);
            } else {
                iArr9 = iArr8;
            }
            i20 = i16;
            while (i18 < i19) {
                i21 = i20;
                int i410 = i19;
                long[] jArr17 = jArr2;
                int[] iArr111 = iArr2;
                int[] iArr112 = iArr7;
                long j17 = j3;
                jArr8[i17] = gj9.o1(j3, 1000000L, track2.f3012b) + gj9.o1(Math.max(0L, jArr2[i18] - j4), 1000000L, track2.f3008a);
                if (z5) {
                    i22 = i21;
                    if (iArr6[i17] > i22) {
                        i20 = iArr9[i18];
                    }
                    i17++;
                    i18++;
                    i19 = i410;
                    j3 = j17;
                    jArr2 = jArr17;
                    iArr2 = iArr111;
                    iArr7 = iArr112;
                } else {
                    i22 = i21;
                }
                i20 = i22;
                i17++;
                i18++;
                i19 = i410;
                j3 = j17;
                jArr2 = jArr17;
                iArr2 = iArr111;
                iArr7 = iArr112;
            }
            long[] jArr18 = jArr2;
            long j18 = j3 + track2.f3010a[i14];
            i14++;
            i16 = i20;
            iArr8 = iArr9;
            j3 = j18;
            iArr3 = iArr19;
            jArr2 = jArr18;
            iArr2 = iArr2;
            iArr4 = iArr110;
            jArr6 = jArr6;
            iArr7 = iArr7;
        }
        return new ma9(track, jArr7, iArr6, i16, jArr8, iArr7, gj9.o1(j3, 1000000L, track2.f3012b));
    }

    public static c w(om6 om6Var, int i2, int i3, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i4;
        om6Var.S(12);
        int iO = om6Var.o();
        c cVar = new c(iO);
        for (int i5 = 0; i5 < iO; i5++) {
            int iE = om6Var.e();
            int iO2 = om6Var.o();
            fc3.a(iO2 > 0, "childAtomSize must be positive");
            int iO3 = om6Var.o();
            if (iO3 == 1635148593 || iO3 == 1635148595 || iO3 == 1701733238 || iO3 == 1831958048 || iO3 == 1836070006 || iO3 == 1752589105 || iO3 == 1751479857 || iO3 == 1932670515 || iO3 == 1211250227 || iO3 == 1987063864 || iO3 == 1987063865 || iO3 == 1635135537 || iO3 == 1685479798 || iO3 == 1685479729 || iO3 == 1685481573 || iO3 == 1685481521) {
                i4 = iE;
                D(om6Var, iO3, i4, iO2, i2, i3, drmInitData, cVar, i5);
            } else if (iO3 == 1836069985 || iO3 == 1701733217 || iO3 == 1633889587 || iO3 == 1700998451 || iO3 == 1633889588 || iO3 == 1835823201 || iO3 == 1685353315 || iO3 == 1685353317 || iO3 == 1685353320 || iO3 == 1685353324 || iO3 == 1685353336 || iO3 == 1935764850 || iO3 == 1935767394 || iO3 == 1819304813 || iO3 == 1936684916 || iO3 == 1953984371 || iO3 == 778924082 || iO3 == 778924083 || iO3 == 1835557169 || iO3 == 1835560241 || iO3 == 1634492771 || iO3 == 1634492791 || iO3 == 1970037111 || iO3 == 1332770163 || iO3 == 1716281667) {
                i4 = iE;
                f(om6Var, iO3, iE, iO2, i2, str, z, drmInitData, cVar, i5);
            } else {
                if (iO3 == 1414810956 || iO3 == 1954034535 || iO3 == 2004251764 || iO3 == 1937010800 || iO3 == 1664495672) {
                    x(om6Var, iO3, iE, iO2, i2, str, cVar);
                } else if (iO3 == 1835365492) {
                    o(om6Var, iO3, iE, i2, cVar);
                } else if (iO3 == 1667329389) {
                    cVar.f2948a = new com.google.android.exoplayer2.d.b().R(i2).e0("application/x-camera-motion").E();
                }
                i4 = iE;
            }
            om6Var.S(i4 + iO2);
        }
        return cVar;
    }

    public static void x(om6 om6Var, int i2, int i3, int i4, int i5, String str, c cVar) {
        om6Var.S(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j2 = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                om6Var.k(bArr, 0, i6);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j2 = 0;
            } else {
                if (i2 != 1664495672) {
                    throw new IllegalStateException();
                }
                cVar.b = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        cVar.f2948a = new com.google.android.exoplayer2.d.b().R(i5).e0(str2).V(str).i0(j2).T(immutableListOf).E();
    }

    public static f y(om6 om6Var) {
        boolean z;
        om6Var.S(8);
        int iC = Atom.c(om6Var.o());
        om6Var.T(iC == 0 ? 8 : 16);
        int iO = om6Var.o();
        om6Var.T(4);
        int iE = om6Var.e();
        int i2 = iC == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (om6Var.d()[iE + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long j2 = -9223372036854775807L;
        if (z) {
            om6Var.T(i2);
        } else {
            long jI = iC == 0 ? om6Var.I() : om6Var.L();
            if (jI != 0) {
                j2 = jI;
            }
        }
        om6Var.T(16);
        int iO2 = om6Var.o();
        int iO3 = om6Var.o();
        om6Var.T(4);
        int iO4 = om6Var.o();
        int iO5 = om6Var.o();
        if (iO2 == 0 && iO3 == 65536 && iO4 == -65536 && iO5 == 0) {
            i3 = 90;
        } else if (iO2 == 0 && iO3 == -65536 && iO4 == 65536 && iO5 == 0) {
            i3 = 270;
        } else if (iO2 == -65536 && iO3 == 0 && iO4 == 0 && iO5 == -65536) {
            i3 = 180;
        }
        return new f(iO, j2, i3);
    }

    @Nullable
    public static Track z(Atom.a aVar, Atom.b bVar, long j2, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.a aVarG;
        Pair<long[], long[]> pairH;
        Atom.a aVar2 = (Atom.a) sb0.g(aVar.g(1835297121));
        int iD = d(k(((Atom.b) sb0.g(aVar2.h(1751411826))).f30671a));
        if (iD == -1) {
            return null;
        }
        f fVarY = y(((Atom.b) sb0.g(aVar.h(1953196132))).f30671a);
        long j3 = j2 == -9223372036854775807L ? fVarY.f2952a : j2;
        long jP = p(bVar.f30671a);
        long jO1 = j3 != -9223372036854775807L ? gj9.o1(j3, 1000000L, jP) : -9223372036854775807L;
        Atom.a aVar3 = (Atom.a) sb0.g(((Atom.a) sb0.g(aVar2.g(1835626086))).g(1937007212));
        Pair<Long, String> pairM = m(((Atom.b) sb0.g(aVar2.h(1835296868))).f30671a);
        c cVarW = w(((Atom.b) sb0.g(aVar3.h(1937011556))).f30671a, fVarY.f30678a, fVarY.b, (String) pairM.second, drmInitData, z2);
        if (z || (aVarG = aVar.g(1701082227)) == null || (pairH = h(aVarG)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairH.first;
            jArr2 = (long[]) pairH.second;
            jArr = jArr3;
        }
        if (cVarW.f2948a == null) {
            return null;
        }
        return new Track(fVarY.f30678a, iD, ((Long) pairM.first).longValue(), jP, jO1, cVarW.f2948a, cVarW.b, cVarW.f2949a, cVarW.f30675a, jArr, jArr2);
    }
}

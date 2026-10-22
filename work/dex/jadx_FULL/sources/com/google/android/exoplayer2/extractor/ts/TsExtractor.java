package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.zj.adlib.g89;
import com.zj.adlib.gj9;
import com.zj.adlib.id9;
import com.zj.adlib.iv6;
import com.zj.adlib.jd9;
import com.zj.adlib.md9;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TsExtractor implements Extractor {
    public static final int A = 21;
    public static final int B = 134;
    public static final int C = 89;
    public static final int D = 128;
    public static final int E = 257;
    public static final int F = 71;
    public static final int G = 0;
    public static final int H = 8192;
    public static final int I = 9400;
    public static final int J = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30702a = 1094921523;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExtractorsFactory f3068a = new ExtractorsFactory() { // from class: com.zj.adlib.ld9
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return TsExtractor.v();
        }
    };
    public static final long b = 1161904947;
    public static final long c = 1094921524;
    public static final long d = 1212503619;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 188;
    public static final int m = 112800;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 15;
    public static final int q = 17;
    public static final int r = 129;
    public static final int s = 138;
    public static final int t = 130;
    public static final int u = 135;
    public static final int v = 172;
    public static final int w = 2;
    public static final int x = 16;
    public static final int y = 27;
    public static final int z = 36;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<TsPayloadReader> f3069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseBooleanArray f3070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseIntArray f3071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TsPayloadReader.Factory f3073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TsPayloadReader f3074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public id9 f3075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jd9 f3076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<g89> f3078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3079a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final SparseBooleanArray f3080b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3081b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3082c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f3083d;
    public final int e;
    public int f;
    public int g;
    public int h;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class a implements SectionPayloadReader {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final nm6 f3084a = new nm6(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void a(om6 om6Var) {
            if (om6Var.G() == 0 && (om6Var.G() & 128) != 0) {
                om6Var.T(6);
                int iA = om6Var.a() / 4;
                for (int i = 0; i < iA; i++) {
                    om6Var.i(this.f3084a, 4);
                    int iH = this.f3084a.h(16);
                    this.f3084a.s(3);
                    if (iH == 0) {
                        this.f3084a.s(13);
                    } else {
                        int iH2 = this.f3084a.h(13);
                        if (TsExtractor.this.f3069a.get(iH2) == null) {
                            TsExtractor.this.f3069a.put(iH2, new r(TsExtractor.this.new b(iH2)));
                            TsExtractor.j(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.f3083d != 2) {
                    TsExtractor.this.f3069a.remove(0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void b(g89 g89Var, ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        }
    }

    public class b implements SectionPayloadReader {
        public static final int b = 5;
        public static final int c = 10;
        public static final int d = 106;
        public static final int e = 111;
        public static final int f = 122;
        public static final int g = 123;
        public static final int h = 127;
        public static final int i = 89;
        public static final int j = 21;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30704a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final nm6 f3088a = new nm6(new byte[5]);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<TsPayloadReader> f3085a = new SparseArray<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseIntArray f3086a = new SparseIntArray();

        public b(int i2) {
            this.f30704a = i2;
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void a(om6 om6Var) {
            g89 g89Var;
            if (om6Var.G() != 2) {
                return;
            }
            if (TsExtractor.this.f3083d == 1 || TsExtractor.this.f3083d == 2 || TsExtractor.this.f == 1) {
                g89Var = (g89) TsExtractor.this.f3078a.get(0);
            } else {
                g89Var = new g89(((g89) TsExtractor.this.f3078a.get(0)).c());
                TsExtractor.this.f3078a.add(g89Var);
            }
            if ((om6Var.G() & 128) == 0) {
                return;
            }
            om6Var.T(1);
            int iM = om6Var.M();
            int i2 = 3;
            om6Var.T(3);
            om6Var.i(this.f3088a, 2);
            this.f3088a.s(3);
            int i3 = 13;
            TsExtractor.this.h = this.f3088a.h(13);
            om6Var.i(this.f3088a, 2);
            int i4 = 4;
            this.f3088a.s(4);
            om6Var.T(this.f3088a.h(12));
            if (TsExtractor.this.f3083d == 2 && TsExtractor.this.f3074a == null) {
                TsPayloadReader.b bVar = new TsPayloadReader.b(21, null, null, gj9.f16790a);
                TsExtractor tsExtractor = TsExtractor.this;
                tsExtractor.f3074a = tsExtractor.f3073a.a(21, bVar);
                if (TsExtractor.this.f3074a != null) {
                    TsExtractor.this.f3074a.b(g89Var, TsExtractor.this.f3072a, new TsPayloadReader.c(iM, 21, 8192));
                }
            }
            this.f3085a.clear();
            this.f3086a.clear();
            int iA = om6Var.a();
            while (iA > 0) {
                om6Var.i(this.f3088a, 5);
                int iH = this.f3088a.h(8);
                this.f3088a.s(i2);
                int iH2 = this.f3088a.h(i3);
                this.f3088a.s(i4);
                int iH3 = this.f3088a.h(12);
                TsPayloadReader.b bVarC = c(om6Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.f30707a;
                }
                iA -= iH3 + 5;
                int i5 = TsExtractor.this.f3083d == 2 ? iH : iH2;
                if (!TsExtractor.this.f3070a.get(i5)) {
                    TsPayloadReader tsPayloadReaderA = (TsExtractor.this.f3083d == 2 && iH == 21) ? TsExtractor.this.f3074a : TsExtractor.this.f3073a.a(iH, bVarC);
                    if (TsExtractor.this.f3083d != 2 || iH2 < this.f3086a.get(i5, 8192)) {
                        this.f3086a.put(i5, iH2);
                        this.f3085a.put(i5, tsPayloadReaderA);
                    }
                }
                i2 = 3;
                i4 = 4;
                i3 = 13;
            }
            int size = this.f3086a.size();
            for (int i6 = 0; i6 < size; i6++) {
                int iKeyAt = this.f3086a.keyAt(i6);
                int iValueAt = this.f3086a.valueAt(i6);
                TsExtractor.this.f3070a.put(iKeyAt, true);
                TsExtractor.this.f3080b.put(iValueAt, true);
                TsPayloadReader tsPayloadReaderValueAt = this.f3085a.valueAt(i6);
                if (tsPayloadReaderValueAt != null) {
                    if (tsPayloadReaderValueAt != TsExtractor.this.f3074a) {
                        tsPayloadReaderValueAt.b(g89Var, TsExtractor.this.f3072a, new TsPayloadReader.c(iM, iKeyAt, 8192));
                    }
                    TsExtractor.this.f3069a.put(iValueAt, tsPayloadReaderValueAt);
                }
            }
            if (TsExtractor.this.f3083d == 2) {
                if (TsExtractor.this.f3079a) {
                    return;
                }
                TsExtractor.this.f3072a.endTracks();
                TsExtractor.this.f = 0;
                TsExtractor.this.f3079a = true;
                return;
            }
            TsExtractor.this.f3069a.remove(this.f30704a);
            TsExtractor tsExtractor2 = TsExtractor.this;
            tsExtractor2.f = tsExtractor2.f3083d == 1 ? 0 : TsExtractor.this.f - 1;
            if (TsExtractor.this.f == 0) {
                TsExtractor.this.f3072a.endTracks();
                TsExtractor.this.f3079a = true;
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void b(g89 g89Var, ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0043  */
        /* JADX WARN: Code duplicated, block: B:24:0x0055  */
        /* JADX WARN: Code duplicated, block: B:27:0x005b  */
        public final TsPayloadReader.b c(om6 om6Var, int i2) {
            int iE = om6Var.e();
            int i3 = i2 + iE;
            int i4 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (om6Var.e() < i3) {
                int iG = om6Var.G();
                int iE2 = om6Var.e() + om6Var.G();
                if (iE2 > i3) {
                    break;
                }
                if (iG == 5) {
                    long jI = om6Var.I();
                    if (jI == TsExtractor.f30702a) {
                        i4 = 129;
                    } else if (jI == TsExtractor.b) {
                        i4 = 135;
                    } else if (jI == TsExtractor.c) {
                        i4 = 172;
                    } else if (jI == TsExtractor.d) {
                        i4 = 36;
                    }
                } else if (iG == 106) {
                    i4 = 129;
                } else if (iG == 122) {
                    i4 = 135;
                } else if (iG == 127) {
                    if (om6Var.G() == 21) {
                        i4 = 172;
                    }
                } else if (iG == 123) {
                    i4 = 138;
                } else if (iG == 10) {
                    strTrim = om6Var.D(3).trim();
                } else if (iG == 89) {
                    ArrayList arrayList2 = new ArrayList();
                    while (om6Var.e() < iE2) {
                        String strTrim2 = om6Var.D(3).trim();
                        int iG2 = om6Var.G();
                        byte[] bArr = new byte[4];
                        om6Var.k(bArr, 0, 4);
                        arrayList2.add(new TsPayloadReader.a(strTrim2, iG2, bArr));
                    }
                    arrayList = arrayList2;
                    i4 = 89;
                } else if (iG == 111) {
                    i4 = 257;
                }
                om6Var.T(iE2 - om6Var.e());
            }
            om6Var.S(i3);
            return new TsPayloadReader.b(i4, strTrim, arrayList, Arrays.copyOfRange(om6Var.d(), iE, i3));
        }
    }

    public TsExtractor() {
        this(0);
    }

    public static /* synthetic */ int j(TsExtractor tsExtractor) {
        int i2 = tsExtractor.f;
        tsExtractor.f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ Extractor[] v() {
        return new Extractor[]{new TsExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3072a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        long length = extractorInput.getLength();
        if (this.f3079a) {
            if (((length == -1 || this.f3083d == 2) ? false : true) && !this.f3076a.d()) {
                return this.f3076a.e(extractorInput, iv6Var, this.h);
            }
            w(length);
            if (this.f3082c) {
                this.f3082c = false;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    iv6Var.f42452a = 0L;
                    return 1;
                }
            }
            id9 id9Var = this.f3075a;
            if (id9Var != null && id9Var.c()) {
                return this.f3075a.b(extractorInput, iv6Var);
            }
        }
        if (!t(extractorInput)) {
            return -1;
        }
        int iU = u();
        int iF = this.f3077a.f();
        if (iU > iF) {
            return 0;
        }
        int iO = this.f3077a.o();
        if ((8388608 & iO) != 0) {
            this.f3077a.S(iU);
            return 0;
        }
        int i2 = ((4194304 & iO) != 0 ? 1 : 0) | 0;
        int i3 = (2096896 & iO) >> 8;
        boolean z2 = (iO & 32) != 0;
        TsPayloadReader tsPayloadReader = (iO & 16) != 0 ? this.f3069a.get(i3) : null;
        if (tsPayloadReader == null) {
            this.f3077a.S(iU);
            return 0;
        }
        if (this.f3083d != 2) {
            int i4 = iO & 15;
            int i5 = this.f3071a.get(i3, i4 - 1);
            this.f3071a.put(i3, i4);
            if (i5 == i4) {
                this.f3077a.S(iU);
                return 0;
            }
            if (i4 != ((i5 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z2) {
            int iG = this.f3077a.G();
            i2 |= (this.f3077a.G() & 64) != 0 ? 2 : 0;
            this.f3077a.T(iG - 1);
        }
        boolean z3 = this.f3079a;
        if (y(i3)) {
            this.f3077a.R(iU);
            tsPayloadReader.a(this.f3077a, i2);
            this.f3077a.R(iF);
        }
        if (this.f3083d != 2 && !z3 && this.f3079a && length != -1) {
            this.f3082c = true;
        }
        this.f3077a.S(iU);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] bArrD = this.f3077a.d();
        extractorInput.peekFully(bArrD, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArrD[(i3 * 188) + i2] != 71) {
                    z2 = false;
                    break;
                }
                i3++;
            }
            if (z2) {
                extractorInput.skipFully(i2);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        id9 id9Var;
        sb0.i(this.f3083d != 2);
        int size = this.f3078a.size();
        for (int i2 = 0; i2 < size; i2++) {
            g89 g89Var = this.f3078a.get(i2);
            boolean z2 = g89Var.e() == -9223372036854775807L;
            if (!z2) {
                long jC = g89Var.c();
                z2 = (jC == -9223372036854775807L || jC == 0 || jC == j3) ? false : true;
            }
            if (z2) {
                g89Var.g(j3);
            }
        }
        if (j3 != 0 && (id9Var = this.f3075a) != null) {
            id9Var.d(j3);
        }
        this.f3077a.O(0);
        this.f3071a.clear();
        for (int i3 = 0; i3 < this.f3069a.size(); i3++) {
            this.f3069a.valueAt(i3).seek();
        }
        this.g = 0;
    }

    public final boolean t(ExtractorInput extractorInput) throws IOException {
        byte[] bArrD = this.f3077a.d();
        if (9400 - this.f3077a.e() < 188) {
            int iA = this.f3077a.a();
            if (iA > 0) {
                System.arraycopy(bArrD, this.f3077a.e(), bArrD, 0, iA);
            }
            this.f3077a.Q(bArrD, iA);
        }
        while (this.f3077a.a() < 188) {
            int iF = this.f3077a.f();
            int i2 = extractorInput.read(bArrD, iF, 9400 - iF);
            if (i2 == -1) {
                return false;
            }
            this.f3077a.R(iF + i2);
        }
        return true;
    }

    public final int u() throws ParserException {
        int iE = this.f3077a.e();
        int iF = this.f3077a.f();
        int iA = md9.a(this.f3077a.d(), iE, iF);
        this.f3077a.S(iA);
        int i2 = iA + 188;
        if (i2 > iF) {
            int i3 = this.g + (iA - iE);
            this.g = i3;
            if (this.f3083d == 2 && i3 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.g = 0;
        }
        return i2;
    }

    public final void w(long j2) {
        if (this.f3081b) {
            return;
        }
        this.f3081b = true;
        if (this.f3076a.b() == -9223372036854775807L) {
            this.f3072a.d(new SeekMap.b(this.f3076a.b()));
            return;
        }
        id9 id9Var = new id9(this.f3076a.c(), this.f3076a.b(), j2, this.h, this.e);
        this.f3075a = id9Var;
        this.f3072a.d(id9Var.a());
    }

    public final void x() {
        this.f3070a.clear();
        this.f3069a.clear();
        SparseArray<TsPayloadReader> sparseArrayCreateInitialPayloadReaders = this.f3073a.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3069a.put(sparseArrayCreateInitialPayloadReaders.keyAt(i2), sparseArrayCreateInitialPayloadReaders.valueAt(i2));
        }
        this.f3069a.put(0, new r(new a()));
        this.f3074a = null;
    }

    public final boolean y(int i2) {
        return this.f3083d == 2 || this.f3079a || !this.f3080b.get(i2, false);
    }

    public TsExtractor(int i2) {
        this(1, i2, 112800);
    }

    public TsExtractor(int i2, int i3, int i4) {
        this(i2, new g89(0L), new DefaultTsPayloadReaderFactory(i3), i4);
    }

    public TsExtractor(int i2, g89 g89Var, TsPayloadReader.Factory factory) {
        this(i2, g89Var, factory, 112800);
    }

    public TsExtractor(int i2, g89 g89Var, TsPayloadReader.Factory factory, int i3) {
        this.f3073a = (TsPayloadReader.Factory) sb0.g(factory);
        this.e = i3;
        this.f3083d = i2;
        if (i2 != 1 && i2 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f3078a = arrayList;
            arrayList.add(g89Var);
        } else {
            this.f3078a = Collections.singletonList(g89Var);
        }
        this.f3077a = new om6(new byte[9400], 0);
        this.f3070a = new SparseBooleanArray();
        this.f3080b = new SparseBooleanArray();
        this.f3069a = new SparseArray<>();
        this.f3071a = new SparseIntArray();
        this.f3076a = new jd9(i3);
        this.f3072a = ExtractorOutput.f30621a;
        this.h = -1;
        x();
    }
}

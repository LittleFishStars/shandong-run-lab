package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.common.base.Function;
import com.zj.adlib.bl8;
import com.zj.adlib.cs3;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.kw5;
import com.zj.adlib.ma9;
import com.zj.adlib.mr;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;
import com.zj.adlib.y38;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Mp4Extractor implements Extractor, SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30682a = new ExtractorsFactory() { // from class: com.zj.adlib.cs5
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return Mp4Extractor.n();
        }
    };
    public static final long c = 262144;
    public static final long d = 10485760;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 4;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 3;
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MotionPhotoMetadata f2992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final y38 f2994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<Atom.a> f2995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Metadata.Entry> f2996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a[] f2997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[][] f2998a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f2999b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final om6 f3000c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f3001d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final om6 f3002d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public om6 f3003e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30683a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final TrackOutput f3004a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final i f3005a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Track f3006a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ma9 f3007a;

        public a(Track track, ma9 ma9Var, TrackOutput trackOutput) {
            this.f3006a = track;
            this.f3007a = ma9Var;
            this.f3004a = trackOutput;
            this.f3005a = "audio/true-hd".equals(track.f3009a.k) ? new i() : null;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    public static boolean A(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    public static int g(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] h(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].f3007a.f43259a];
            jArr2[i] = aVarArr[i].f3007a.f18163b[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            ma9 ma9Var = aVarArr[i3].f3007a;
            j += (long) ma9Var.f18160a[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = ma9Var.f18163b[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    public static int k(ma9 ma9Var, long j) {
        int iA = ma9Var.a(j);
        return iA == -1 ? ma9Var.b(j) : iA;
    }

    public static /* synthetic */ Track m(Track track) {
        return track;
    }

    public static /* synthetic */ Extractor[] n() {
        return new Extractor[]{new Mp4Extractor()};
    }

    public static long o(ma9 ma9Var, long j, long j2) {
        int iK = k(ma9Var, j);
        return iK == -1 ? j2 : Math.min(ma9Var.f18161a[iK], j2);
    }

    public static int s(om6 om6Var) {
        om6Var.S(8);
        int iG = g(om6Var.o());
        if (iG != 0) {
            return iG;
        }
        om6Var.T(4);
        while (om6Var.a() > 0) {
            int iG2 = g(om6Var.o());
            if (iG2 != 0) {
                return iG2;
            }
        }
        return 0;
    }

    public static boolean z(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    public final void B(a aVar, long j) {
        ma9 ma9Var = aVar.f3007a;
        int iA = ma9Var.a(j);
        if (iA == -1) {
            iA = ma9Var.b(j);
        }
        aVar.f30683a = iA;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        return j(j, -1);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2991a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        while (true) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return x(extractorInput, iv6Var);
                    }
                    if (i == 3) {
                        return y(extractorInput, iv6Var);
                    }
                    throw new IllegalStateException();
                }
                if (w(extractorInput, iv6Var)) {
                    return 1;
                }
            } else if (!v(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        return bl8.e(extractorInput, (this.f3001d & 2) != 0);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.b;
    }

    public final void i() {
        this.e = 0;
        this.g = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x008e  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f A[EDGE_INSN: B:42:0x007f->B:36:0x007f BREAK  A[LOOP:0: B:28:0x0063->B:35:0x007c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007c A[SYNTHETIC] */
    public SeekMap.a j(long j, int i) {
        long jO;
        long j2;
        long jO2;
        long j3;
        int i2;
        a[] aVarArr;
        ma9 ma9Var;
        int iB;
        a[] aVarArr2 = this.f2997a;
        if (aVarArr2.length == 0) {
            return new SeekMap.a(x38.f45741a);
        }
        int i3 = i != -1 ? i : this.l;
        if (i3 != -1) {
            ma9 ma9Var2 = aVarArr2[i3].f3007a;
            int iK = k(ma9Var2, j);
            if (iK == -1) {
                return new SeekMap.a(x38.f45741a);
            }
            j2 = ma9Var2.f18163b[iK];
            jO = ma9Var2.f18161a[iK];
            if (j2 < j && iK < ma9Var2.f43259a - 1 && (iB = ma9Var2.b(j)) != -1 && iB != iK) {
                j3 = ma9Var2.f18163b[iB];
                jO2 = ma9Var2.f18161a[iB];
            }
            if (i == -1) {
                i2 = 0;
                while (true) {
                    aVarArr = this.f2997a;
                    if (i2 < aVarArr.length) {
                        break;
                    }
                    if (i2 != this.l) {
                        ma9Var = aVarArr[i2].f3007a;
                        jO = o(ma9Var, j2, jO);
                        if (j3 != -9223372036854775807L) {
                            jO2 = o(ma9Var, j3, jO2);
                        }
                    }
                    i2++;
                }
            }
            x38 x38Var = new x38(j2, jO);
            return j3 == -9223372036854775807L ? new SeekMap.a(x38Var) : new SeekMap.a(x38Var, new x38(j3, jO2));
        }
        jO = Long.MAX_VALUE;
        j2 = j;
        jO2 = -1;
        j3 = -9223372036854775807L;
        if (i == -1) {
            i2 = 0;
            while (true) {
                aVarArr = this.f2997a;
                if (i2 < aVarArr.length) {
                    break;
                    break;
                }
                if (i2 != this.l) {
                    ma9Var = aVarArr[i2].f3007a;
                    jO = o(ma9Var, j2, jO);
                    if (j3 != -9223372036854775807L) {
                        jO2 = o(ma9Var, j3, jO2);
                    }
                }
                i2++;
            }
        }
        x38 x38Var2 = new x38(j2, jO);
        if (j3 == -9223372036854775807L) {
        }
    }

    public final int l(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f2997a;
            if (i3 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.f30683a;
            ma9 ma9Var = aVar.f3007a;
            if (i4 != ma9Var.f43259a) {
                long j5 = ma9Var.f18161a[i4];
                long j6 = ((long[][]) gj9.k(this.f2998a))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    public final void p(ExtractorInput extractorInput) throws IOException {
        this.f3000c.O(8);
        extractorInput.peekFully(this.f3000c.d(), 0, 8);
        AtomParsers.e(this.f3000c);
        extractorInput.skipFully(this.f3000c.e());
        extractorInput.resetPeekPosition();
    }

    public final void q(long j) throws ParserException {
        while (!this.f2995a.isEmpty() && this.f2995a.peek().f30670a == j) {
            Atom.a aVarPop = this.f2995a.pop();
            if (((Atom) aVarPop).f30669a == 1836019574) {
                t(aVarPop);
                this.f2995a.clear();
                this.e = 2;
            } else if (!this.f2995a.isEmpty()) {
                this.f2995a.peek().d(aVarPop);
            }
        }
        if (this.e != 2) {
            i();
        }
    }

    public final void r() {
        if (this.m != 2 || (this.f3001d & 2) == 0) {
            return;
        }
        this.f2991a.b(0, 4).f(new d.b().X(this.f2992a == null ? null : new Metadata(this.f2992a)).E());
        this.f2991a.endTracks();
        this.f2991a.d(new SeekMap.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f2995a.clear();
        this.g = 0;
        this.h = -1;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        if (j == 0) {
            if (this.e != 3) {
                i();
                return;
            } else {
                this.f2994a.g();
                this.f2996a.clear();
                return;
            }
        }
        for (a aVar : this.f2997a) {
            B(aVar, j2);
            i iVar = aVar.f3005a;
            if (iVar != null) {
                iVar.b();
            }
        }
    }

    public final void t(Atom.a aVar) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        int i;
        ArrayList arrayList = new ArrayList();
        boolean z = this.m == 1;
        cs3 cs3Var = new cs3();
        Atom.b bVarH = aVar.h(1969517665);
        if (bVarH != null) {
            Pair<Metadata, Metadata> pairB = AtomParsers.B(bVarH);
            Metadata metadata3 = (Metadata) pairB.first;
            Metadata metadata4 = (Metadata) pairB.second;
            if (metadata3 != null) {
                cs3Var.c(metadata3);
            }
            metadata = metadata4;
            metadata2 = metadata3;
        } else {
            metadata = null;
            metadata2 = null;
        }
        Atom.a aVarG = aVar.g(1835365473);
        Metadata metadataN = aVarG != null ? AtomParsers.n(aVarG) : null;
        List<ma9> listA = AtomParsers.A(aVar, cs3Var, -9223372036854775807L, null, (this.f3001d & 1) != 0, z, new Function() { // from class: com.zj.adlib.es5
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Mp4Extractor.m((Track) obj);
            }
        });
        int size = listA.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i2 = 0;
        int size2 = -1;
        while (i2 < size) {
            ma9 ma9Var = listA.get(i2);
            if (ma9Var.f43259a != 0) {
                Track track = ma9Var.f18159a;
                long j3 = track.f3014c;
                if (j3 == j) {
                    j3 = ma9Var.f18158a;
                }
                long jMax = Math.max(j2, j3);
                a aVar2 = new a(track, ma9Var, this.f2991a.b(i2, track.b));
                int i3 = "audio/true-hd".equals(track.f3009a.k) ? ma9Var.b * 16 : ma9Var.b + 30;
                d.b bVarB = track.f3009a.b();
                bVarB.W(i3);
                if (track.b == 2 && j3 > 0 && (i = ma9Var.f43259a) > 1) {
                    bVarB.P(i / (j3 / 1000000.0f));
                }
                b.k(track.b, cs3Var, bVarB);
                int i4 = track.b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata;
                metadataArr[1] = this.f2996a.isEmpty() ? null : new Metadata(this.f2996a);
                b.l(i4, metadata2, metadataN, bVarB, metadataArr);
                aVar2.f3004a.f(bVarB.E());
                if (track.b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar2);
                j2 = jMax;
            }
            i2++;
            listA = listA;
            size = size;
            j = -9223372036854775807L;
        }
        this.l = size2;
        this.b = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.f2997a = aVarArr;
        this.f2998a = h(aVarArr);
        this.f2991a.endTracks();
        this.f2991a.d(this);
    }

    public final void u(long j) {
        if (this.f == 1836086884) {
            int i = this.g;
            this.f2992a = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + ((long) i), this.f2990a - ((long) i));
        }
    }

    public final boolean v(ExtractorInput extractorInput) throws IOException {
        Atom.a aVarPeek;
        if (this.g == 0) {
            if (!extractorInput.readFully(this.f3002d.d(), 0, 8, true)) {
                r();
                return false;
            }
            this.g = 8;
            this.f3002d.S(0);
            this.f2990a = this.f3002d.I();
            this.f = this.f3002d.o();
        }
        long j = this.f2990a;
        if (j == 1) {
            extractorInput.readFully(this.f3002d.d(), 8, 8);
            this.g += 8;
            this.f2990a = this.f3002d.L();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (aVarPeek = this.f2995a.peek()) != null) {
                length = aVarPeek.f30670a;
            }
            if (length != -1) {
                this.f2990a = (length - extractorInput.getPosition()) + ((long) this.g);
            }
        }
        if (this.f2990a < this.g) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (z(this.f)) {
            long position = extractorInput.getPosition();
            long j2 = this.f2990a;
            int i = this.g;
            long j3 = (position + j2) - ((long) i);
            if (j2 != i && this.f == 1835365473) {
                p(extractorInput);
            }
            this.f2995a.push(new Atom.a(this.f, j3));
            if (this.f2990a == this.g) {
                q(j3);
            } else {
                i();
            }
        } else if (A(this.f)) {
            sb0.i(this.g == 8);
            sb0.i(this.f2990a <= 2147483647L);
            om6 om6Var = new om6((int) this.f2990a);
            System.arraycopy(this.f3002d.d(), 0, om6Var.d(), 0, 8);
            this.f3003e = om6Var;
            this.e = 1;
        } else {
            u(extractorInput.getPosition() - ((long) this.g));
            this.f3003e = null;
            this.e = 1;
        }
        return true;
    }

    public final boolean w(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        boolean z;
        long j = this.f2990a - ((long) this.g);
        long position = extractorInput.getPosition() + j;
        om6 om6Var = this.f3003e;
        if (om6Var == null) {
            if (j < 262144) {
                extractorInput.skipFully((int) j);
            } else {
                iv6Var.f42452a = extractorInput.getPosition() + j;
                z = true;
            }
            q(position);
            return (z || this.e == 2) ? false : true;
        }
        extractorInput.readFully(om6Var.d(), this.g, (int) j);
        if (this.f == 1718909296) {
            this.m = s(om6Var);
        } else if (!this.f2995a.isEmpty()) {
            this.f2995a.peek().e(new Atom.b(this.f, om6Var));
        }
        z = false;
        q(position);
        if (z) {
        }
    }

    public final int x(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        long position = extractorInput.getPosition();
        if (this.h == -1) {
            int iL = l(position);
            this.h = iL;
            if (iL == -1) {
                return -1;
            }
        }
        a aVar = this.f2997a[this.h];
        TrackOutput trackOutput = aVar.f3004a;
        int i = aVar.f30683a;
        ma9 ma9Var = aVar.f3007a;
        long j = ma9Var.f18161a[i];
        int i2 = ma9Var.f18160a[i];
        i iVar = aVar.f3005a;
        long j2 = (j - position) + ((long) this.i);
        if (j2 < 0 || j2 >= 262144) {
            iv6Var.f42452a = j;
            return 1;
        }
        if (aVar.f3006a.c == 1) {
            j2 += 8;
            i2 -= 8;
        }
        extractorInput.skipFully((int) j2);
        Track track = aVar.f3006a;
        if (track.d == 0) {
            if ("audio/ac4".equals(track.f3009a.k)) {
                if (this.j == 0) {
                    mr.a(i2, this.f3000c);
                    trackOutput.c(this.f3000c, 7);
                    this.j += 7;
                }
                i2 += 7;
            } else if (iVar != null) {
                iVar.d(extractorInput);
            }
            while (true) {
                int i3 = this.j;
                if (i3 >= i2) {
                    break;
                }
                int iB = trackOutput.b(extractorInput, i2 - i3, false);
                this.i += iB;
                this.j += iB;
                this.k -= iB;
            }
        } else {
            byte[] bArrD = this.f2999b.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i4 = aVar.f3006a.d;
            int i5 = 4 - i4;
            while (this.j < i2) {
                int i6 = this.k;
                if (i6 == 0) {
                    extractorInput.readFully(bArrD, i5, i4);
                    this.i += i4;
                    this.f2999b.S(0);
                    int iO = this.f2999b.o();
                    if (iO < 0) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.k = iO;
                    this.f2993a.S(0);
                    trackOutput.c(this.f2993a, 4);
                    this.j += 4;
                    i2 += i5;
                } else {
                    int iB2 = trackOutput.b(extractorInput, i6, false);
                    this.i += iB2;
                    this.j += iB2;
                    this.k -= iB2;
                }
            }
        }
        int i7 = i2;
        ma9 ma9Var2 = aVar.f3007a;
        long j3 = ma9Var2.f18163b[i];
        int i8 = ma9Var2.f18162b[i];
        if (iVar != null) {
            iVar.c(trackOutput, j3, i8, i7, 0, null);
            if (i + 1 == aVar.f3007a.f43259a) {
                iVar.a(trackOutput, null);
            }
        } else {
            trackOutput.e(j3, i8, i7, 0, null);
        }
        aVar.f30683a++;
        this.h = -1;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        return 0;
    }

    public final int y(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int iC = this.f2994a.c(extractorInput, iv6Var, this.f2996a);
        if (iC == 1 && iv6Var.f42452a == 0) {
            i();
        }
        return iC;
    }

    public Mp4Extractor(int i) {
        this.f3001d = i;
        this.e = (i & 4) != 0 ? 3 : 0;
        this.f2994a = new y38();
        this.f2996a = new ArrayList();
        this.f3002d = new om6(16);
        this.f2995a = new ArrayDeque<>();
        this.f2993a = new om6(kw5.f17801a);
        this.f2999b = new om6(4);
        this.f3000c = new om6();
        this.h = -1;
        this.f2991a = ExtractorOutput.f30621a;
        this.f2997a = new a[0];
    }
}

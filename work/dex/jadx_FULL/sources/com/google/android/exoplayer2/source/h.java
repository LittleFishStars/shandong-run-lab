package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.common.primitives.UnsignedBytes;
import com.zj.adlib.b50;
import com.zj.adlib.gj9;
import com.zj.adlib.jy1;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h {
    public static final int b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f4031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f4032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f4033a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public a f4034b;
    public a c;

    public static final class a implements Allocator.AllocationNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30909a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public a f4035a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public b50 f4036a;
        public long b;

        public a(long j, int i) {
            e(j, i);
        }

        @Override // com.google.android.exoplayer2.upstream.Allocator.AllocationNode
        public b50 a() {
            return (b50) sb0.g(this.f4036a);
        }

        @Override // com.google.android.exoplayer2.upstream.Allocator.AllocationNode
        @Nullable
        public Allocator.AllocationNode b() {
            a aVar = this.f4035a;
            if (aVar == null || aVar.f4036a == null) {
                return null;
            }
            return aVar;
        }

        public a c() {
            this.f4036a = null;
            a aVar = this.f4035a;
            this.f4035a = null;
            return aVar;
        }

        public void d(b50 b50Var, a aVar) {
            this.f4036a = b50Var;
            this.f4035a = aVar;
        }

        public void e(long j, int i) {
            sb0.i(this.f4036a == null);
            this.f30909a = j;
            this.b = j + ((long) i);
        }

        public int f(long j) {
            return ((int) (j - this.f30909a)) + this.f4036a.f40678a;
        }
    }

    public h(Allocator allocator) {
        this.f4032a = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.f30908a = individualAllocationLength;
        this.f4033a = new om6(32);
        a aVar = new a(0L, individualAllocationLength);
        this.f4031a = aVar;
        this.f4034b = aVar;
        this.c = aVar;
    }

    public static a d(a aVar, long j) {
        while (j >= aVar.b) {
            aVar = aVar.f4035a;
        }
        return aVar;
    }

    public static a i(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a aVarD = d(aVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVarD.b - j));
            byteBuffer.put(aVarD.f4036a.f15443a, aVarD.f(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.f4035a;
            }
        }
        return aVarD;
    }

    public static a j(a aVar, long j, byte[] bArr, int i) {
        a aVarD = d(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVarD.b - j));
            System.arraycopy(aVarD.f4036a.f15443a, aVarD.f(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.f4035a;
            }
        }
        return aVarD;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar, om6 om6Var) {
        long j = bVar.f3753a;
        int iM = 1;
        om6Var.O(1);
        a aVarJ = j(aVar, j, om6Var.d(), 1);
        long j2 = j + 1;
        byte b2 = om6Var.d()[0];
        boolean z = (b2 & UnsignedBytes.f32243a) != 0;
        int i = b2 & 127;
        jy1 jy1Var = decoderInputBuffer.f2587a;
        byte[] bArr = jy1Var.f17525a;
        if (bArr == null) {
            jy1Var.f17525a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j2, jy1Var.f17525a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            om6Var.O(2);
            aVarJ2 = j(aVarJ2, j3, om6Var.d(), 2);
            j3 += 2;
            iM = om6Var.M();
        }
        int i2 = iM;
        int[] iArr = jy1Var.f17526a;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = jy1Var.f17528b;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            om6Var.O(i3);
            aVarJ2 = j(aVarJ2, j3, om6Var.d(), i3);
            j3 += (long) i3;
            om6Var.S(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = om6Var.M();
                iArr4[i4] = om6Var.K();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f30833a - ((int) (j3 - bVar.f3753a));
        }
        TrackOutput.a aVar2 = (TrackOutput.a) gj9.k(bVar.f3754a);
        jy1Var.c(i2, iArr2, iArr4, aVar2.f2706a, jy1Var.f17525a, aVar2.f30626a, aVar2.b, aVar2.c);
        long j4 = bVar.f3753a;
        int i5 = (int) (j3 - j4);
        bVar.f3753a = j4 + ((long) i5);
        bVar.f30833a -= i5;
        return aVarJ2;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar, om6 om6Var) {
        if (decoderInputBuffer.m()) {
            aVar = k(aVar, decoderInputBuffer, bVar, om6Var);
        }
        if (!decoderInputBuffer.d()) {
            decoderInputBuffer.k(bVar.f30833a);
            return i(aVar, bVar.f3753a, decoderInputBuffer.f2588a, bVar.f30833a);
        }
        om6Var.O(4);
        a aVarJ = j(aVar, bVar.f3753a, om6Var.d(), 4);
        int iK = om6Var.K();
        bVar.f3753a += 4;
        bVar.f30833a -= 4;
        decoderInputBuffer.k(iK);
        a aVarI = i(aVarJ, bVar.f3753a, decoderInputBuffer.f2588a, iK);
        bVar.f3753a += (long) iK;
        int i = bVar.f30833a - iK;
        bVar.f30833a = i;
        decoderInputBuffer.o(i);
        return i(aVarI, bVar.f3753a, decoderInputBuffer.b, bVar.f30833a);
    }

    public final void a(a aVar) {
        if (aVar.f4036a == null) {
            return;
        }
        this.f4032a.b(aVar);
        aVar.c();
    }

    public void b(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.f4031a;
            if (j < aVar.b) {
                break;
            }
            this.f4032a.a(aVar.f4036a);
            this.f4031a = this.f4031a.c();
        }
        if (this.f4034b.f30909a < aVar.f30909a) {
            this.f4034b = aVar;
        }
    }

    public void c(long j) {
        sb0.a(j <= this.f4030a);
        this.f4030a = j;
        if (j != 0) {
            a aVar = this.f4031a;
            if (j != aVar.f30909a) {
                while (this.f4030a > aVar.b) {
                    aVar = aVar.f4035a;
                }
                a aVar2 = (a) sb0.g(aVar.f4035a);
                a(aVar2);
                a aVar3 = new a(aVar.b, this.f30908a);
                aVar.f4035a = aVar3;
                if (this.f4030a == aVar.b) {
                    aVar = aVar3;
                }
                this.c = aVar;
                if (this.f4034b == aVar2) {
                    this.f4034b = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f4031a);
        a aVar4 = new a(this.f4030a, this.f30908a);
        this.f4031a = aVar4;
        this.f4034b = aVar4;
        this.c = aVar4;
    }

    public long e() {
        return this.f4030a;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar) {
        l(this.f4034b, decoderInputBuffer, bVar, this.f4033a);
    }

    public final void g(int i) {
        long j = this.f4030a + ((long) i);
        this.f4030a = j;
        a aVar = this.c;
        if (j == aVar.b) {
            this.c = aVar.f4035a;
        }
    }

    public final int h(int i) {
        a aVar = this.c;
        if (aVar.f4036a == null) {
            aVar.d(this.f4032a.c(), new a(this.c.b, this.f30908a));
        }
        return Math.min(i, (int) (this.c.b - this.f4030a));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.b bVar) {
        this.f4034b = l(this.f4034b, decoderInputBuffer, bVar, this.f4033a);
    }

    public void n() {
        a(this.f4031a);
        this.f4031a.e(0L, this.f30908a);
        a aVar = this.f4031a;
        this.f4034b = aVar;
        this.c = aVar;
        this.f4030a = 0L;
        this.f4032a.trim();
    }

    public void o() {
        this.f4034b = this.f4031a;
    }

    public int p(DataReader dataReader, int i, boolean z) throws IOException {
        int iH = h(i);
        a aVar = this.c;
        int i2 = dataReader.read(aVar.f4036a.f15443a, aVar.f(this.f4030a), iH);
        if (i2 != -1) {
            g(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(om6 om6Var, int i) {
        while (i > 0) {
            int iH = h(i);
            a aVar = this.c;
            om6Var.k(aVar.f4036a.f15443a, aVar.f(this.f4030a), iH);
            i -= iH;
            g(iH);
        }
    }
}

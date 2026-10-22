package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.zj.adlib.sb0;
import com.zj.adlib.yl9;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements EbmlReader {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 4;
    public static final int g = 8;
    public static final int h = 8;
    public static final int i = 4;
    public static final int j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EbmlProcessor f2909a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2912a = new byte[8];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<b> f2911a = new ArrayDeque<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yl9 f2910a = new yl9();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30663a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2913a;

        public b(int i, long j) {
            this.f30663a = i;
            this.f2913a = j;
        }
    }

    public static String f(ExtractorInput extractorInput, int i2) throws IOException {
        if (i2 == 0) {
            return "";
        }
        byte[] bArr = new byte[i2];
        extractorInput.readFully(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean a(ExtractorInput extractorInput) throws IOException {
        sb0.k(this.f2909a);
        while (true) {
            b bVarPeek = this.f2911a.peek();
            if (bVarPeek != null && extractorInput.getPosition() >= bVarPeek.f2913a) {
                this.f2909a.endMasterElement(this.f2911a.pop().f30663a);
                return true;
            }
            if (this.f30662a == 0) {
                long jD = this.f2910a.d(extractorInput, true, false, 4);
                if (jD == -2) {
                    jD = c(extractorInput);
                }
                if (jD == -1) {
                    return false;
                }
                this.b = (int) jD;
                this.f30662a = 1;
            }
            if (this.f30662a == 1) {
                this.f2908a = this.f2910a.d(extractorInput, false, true, 8);
                this.f30662a = 2;
            }
            int elementType = this.f2909a.getElementType(this.b);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = extractorInput.getPosition();
                    this.f2911a.push(new b(this.b, this.f2908a + position));
                    this.f2909a.startMasterElement(this.b, position, this.f2908a);
                    this.f30662a = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j2 = this.f2908a;
                    if (j2 <= 8) {
                        this.f2909a.integerElement(this.b, e(extractorInput, (int) j2));
                        this.f30662a = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.f2908a, null);
                }
                if (elementType == 3) {
                    long j3 = this.f2908a;
                    if (j3 <= 2147483647L) {
                        this.f2909a.stringElement(this.b, f(extractorInput, (int) j3));
                        this.f30662a = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.f2908a, null);
                }
                if (elementType == 4) {
                    this.f2909a.a(this.b, (int) this.f2908a, extractorInput);
                    this.f30662a = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j4 = this.f2908a;
                if (j4 == 4 || j4 == 8) {
                    this.f2909a.floatElement(this.b, d(extractorInput, (int) j4));
                    this.f30662a = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.f2908a, null);
            }
            extractorInput.skipFully((int) this.f2908a);
            this.f30662a = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void b(EbmlProcessor ebmlProcessor) {
        this.f2909a = ebmlProcessor;
    }

    @RequiresNonNull({"processor"})
    public final long c(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.f2912a, 0, 4);
            int iC = yl9.c(this.f2912a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) yl9.a(this.f2912a, iC, false);
                if (this.f2909a.isLevel1Element(iA)) {
                    extractorInput.skipFully(iC);
                    return iA;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    public final double d(ExtractorInput extractorInput, int i2) throws IOException {
        long jE = e(extractorInput, i2);
        return i2 == 4 ? Float.intBitsToFloat((int) jE) : Double.longBitsToDouble(jE);
    }

    public final long e(ExtractorInput extractorInput, int i2) throws IOException {
        extractorInput.readFully(this.f2912a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | ((long) (this.f2912a[i3] & 255));
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.f30662a = 0;
        this.f2911a.clear();
        this.f2910a.e();
    }
}

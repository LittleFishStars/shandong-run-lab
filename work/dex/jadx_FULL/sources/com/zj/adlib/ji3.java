package com.zj.adlib;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.g;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ji3 extends BinarySearchSeeker {

    public static final class b implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42594a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final g f17404a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ni3.a f17405a;

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.d a(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long jB = b(extractorInput);
            long peekPosition = extractorInput.getPeekPosition();
            extractorInput.advancePeekPosition(Math.max(6, this.f17404a.c));
            long jB2 = b(extractorInput);
            long peekPosition2 = extractorInput.getPeekPosition();
            if (jB > j || jB2 <= j) {
                return jB2 <= j ? BinarySearchSeeker.d.f(jB2, peekPosition2) : BinarySearchSeeker.d.d(jB, position);
            }
            return BinarySearchSeeker.d.e(peekPosition);
        }

        public final long b(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.getPeekPosition() < extractorInput.getLength() - 6 && !ni3.h(extractorInput, this.f17404a, this.f42594a, this.f17405a)) {
                extractorInput.advancePeekPosition(1);
            }
            if (extractorInput.getPeekPosition() < extractorInput.getLength() - 6) {
                return this.f17405a.f43530a;
            }
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return this.f17404a.f2775a;
        }

        public b(g gVar, int i) {
            this.f17404a = gVar;
            this.f42594a = i;
            this.f17405a = new ni3.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji3(final g gVar, int i, long j, long j2) {
        super(new BinarySearchSeeker.SeekTimestampConverter() { // from class: com.zj.adlib.ii3
            @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
            public final long timeUsToTargetTime(long j3) {
                return gVar.l(j3);
            }
        }, new b(gVar, i), gVar.h(), 0L, gVar.f2775a, j, j2, gVar.e(), Math.max(6, gVar.c));
        Objects.requireNonNull(gVar);
    }
}

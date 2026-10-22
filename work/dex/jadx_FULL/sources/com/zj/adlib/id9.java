package com.zj.adlib;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class id9 extends BinarySearchSeeker {
    public static final int b = 940;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f17198b = 100000;

    public static final class a implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42341a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final g89 f17199a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f17200a = new om6();
        public final int b;

        public a(int i, g89 g89Var, int i2) {
            this.f42341a = i;
            this.f17199a = g89Var;
            this.b = i2;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.d a(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(this.b, extractorInput.getLength() - position);
            this.f17200a.O(iMin);
            extractorInput.peekFully(this.f17200a.d(), 0, iMin);
            return b(this.f17200a, j, position);
        }

        public final BinarySearchSeeker.d b(om6 om6Var, long j, long j2) {
            int iA;
            int iA2;
            int iF = om6Var.f();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (om6Var.a() >= 188 && (iA2 = (iA = md9.a(om6Var.d(), om6Var.e(), iF)) + 188) <= iF) {
                long jC = md9.c(om6Var, iA, this.f42341a);
                if (jC != -9223372036854775807L) {
                    long jB = this.f17199a.b(jC);
                    if (jB > j) {
                        return j5 == -9223372036854775807L ? BinarySearchSeeker.d.d(jB, j2) : BinarySearchSeeker.d.e(j2 + j4);
                    }
                    if (100000 + jB > j) {
                        return BinarySearchSeeker.d.e(j2 + ((long) iA));
                    }
                    j4 = iA;
                    j5 = jB;
                }
                om6Var.S(iA2);
                j3 = iA2;
            }
            return j5 != -9223372036854775807L ? BinarySearchSeeker.d.f(j5, j2 + j3) : BinarySearchSeeker.d.f30617a;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.f17200a.P(gj9.f16790a);
        }
    }

    public id9(g89 g89Var, long j, long j2, int i, int i2) {
        super(new BinarySearchSeeker.b(), new a(i, g89Var, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}

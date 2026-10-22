package com.zj.adlib;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f27 extends BinarySearchSeeker {
    public static final int b = 1000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f16436b = 100000;
    public static final int c = 20000;

    public static final class b implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g89 f41579a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final om6 f16437a;

        public static void c(om6 om6Var) {
            int iF;
            int iF2 = om6Var.f();
            if (om6Var.a() < 10) {
                om6Var.S(iF2);
                return;
            }
            om6Var.T(9);
            int iG = om6Var.G() & 7;
            if (om6Var.a() < iG) {
                om6Var.S(iF2);
                return;
            }
            om6Var.T(iG);
            if (om6Var.a() < 4) {
                om6Var.S(iF2);
                return;
            }
            if (f27.f(om6Var.d(), om6Var.e()) == 443) {
                om6Var.T(4);
                int iM = om6Var.M();
                if (om6Var.a() < iM) {
                    om6Var.S(iF2);
                    return;
                }
                om6Var.T(iM);
            }
            while (om6Var.a() >= 4 && (iF = f27.f(om6Var.d(), om6Var.e())) != 442 && iF != 441 && (iF >>> 8) == 1) {
                om6Var.T(4);
                if (om6Var.a() < 2) {
                    om6Var.S(iF2);
                    return;
                }
                om6Var.S(Math.min(om6Var.f(), om6Var.e() + om6Var.M()));
            }
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.d a(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(20000L, extractorInput.getLength() - position);
            this.f16437a.O(iMin);
            extractorInput.peekFully(this.f16437a.d(), 0, iMin);
            return b(this.f16437a, j, position);
        }

        public final BinarySearchSeeker.d b(om6 om6Var, long j, long j2) {
            int iE = -1;
            int iE2 = -1;
            long j3 = -9223372036854775807L;
            while (om6Var.a() >= 4) {
                if (f27.f(om6Var.d(), om6Var.e()) != 442) {
                    om6Var.T(1);
                } else {
                    om6Var.T(4);
                    long jL = g27.l(om6Var);
                    if (jL != -9223372036854775807L) {
                        long jB = this.f41579a.b(jL);
                        if (jB > j) {
                            return j3 == -9223372036854775807L ? BinarySearchSeeker.d.d(jB, j2) : BinarySearchSeeker.d.e(j2 + ((long) iE2));
                        }
                        if (100000 + jB > j) {
                            return BinarySearchSeeker.d.e(j2 + ((long) om6Var.e()));
                        }
                        iE2 = om6Var.e();
                        j3 = jB;
                    }
                    c(om6Var);
                    iE = om6Var.e();
                }
            }
            return j3 != -9223372036854775807L ? BinarySearchSeeker.d.f(j3, j2 + ((long) iE)) : BinarySearchSeeker.d.f30617a;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.f16437a.P(gj9.f16790a);
        }

        public b(g89 g89Var) {
            this.f41579a = g89Var;
            this.f16437a = new om6();
        }
    }

    public f27(g89 g89Var, long j, long j2) {
        super(new BinarySearchSeeker.b(), new b(g89Var), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}

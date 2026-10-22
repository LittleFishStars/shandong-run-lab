package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ShuffleOrder {

    public static class a implements ShuffleOrder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f30835a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3756a;
        public final int[] b;

        public a(int i) {
            this(i, new Random());
        }

        public static int[] d(int i, Random random) {
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int iNextInt = random.nextInt(i3);
                iArr[i2] = iArr[iNextInt];
                iArr[iNextInt] = i2;
                i2 = i3;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder a(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.f3756a.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f3756a;
                if (i4 >= iArr2.length) {
                    return new a(iArr, new Random(this.f30835a.nextLong()));
                }
                int i6 = iArr2[i4];
                if (i6 < i || i6 >= i2) {
                    int i7 = i4 - i5;
                    if (i6 >= i) {
                        i6 -= i3;
                    }
                    iArr[i7] = i6;
                } else {
                    i5++;
                }
                i4++;
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder b(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                iArr[i4] = this.f30835a.nextInt(this.f3756a.length + 1);
                int i5 = i4 + 1;
                int iNextInt = this.f30835a.nextInt(i5);
                iArr2[i4] = iArr2[iNextInt];
                iArr2[iNextInt] = i4 + i;
                i4 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f3756a.length + i2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f3756a;
                if (i3 >= iArr4.length + i2) {
                    return new a(iArr3, new Random(this.f30835a.nextLong()));
                }
                if (i6 >= i2 || i7 != iArr[i6]) {
                    int i8 = i7 + 1;
                    int i9 = iArr4[i7];
                    iArr3[i3] = i9;
                    if (i9 >= i) {
                        iArr3[i3] = i9 + i2;
                    }
                    i7 = i8;
                } else {
                    iArr3[i3] = iArr2[i6];
                    i6++;
                }
                i3++;
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder c() {
            return new a(0, new Random(this.f30835a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            int[] iArr = this.f3756a;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int[] iArr = this.f3756a;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.f3756a.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = this.b[i] + 1;
            int[] iArr = this.f3756a;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = this.b[i] - 1;
            if (i2 >= 0) {
                return this.f3756a[i2];
            }
            return -1;
        }

        public a(int i, long j) {
            this(i, new Random(j));
        }

        public a(int[] iArr, long j) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j));
        }

        public a(int i, Random random) {
            this(d(i, random), random);
        }

        public a(int[] iArr, Random random) {
            this.f3756a = iArr;
            this.f30835a = random;
            this.b = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.b[iArr[i]] = i;
            }
        }
    }

    public static final class b implements ShuffleOrder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30836a;

        public b(int i) {
            this.f30836a = i;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder a(int i, int i2) {
            return new b((this.f30836a - i2) + i);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder b(int i, int i2) {
            return new b(this.f30836a + i2);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder c() {
            return new b(0);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.f30836a > 0 ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int i = this.f30836a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.f30836a;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = i + 1;
            if (i2 < this.f30836a) {
                return i2;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }
    }

    ShuffleOrder a(int i, int i2);

    ShuffleOrder b(int i, int i2);

    ShuffleOrder c();

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i);

    int getPreviousIndex(int i);
}

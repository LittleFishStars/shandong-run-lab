package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.baichuan.log.TLogConstant;
import com.aliyun.tea.logging.DefaultLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\"B!\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\u0012\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006#"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayTimSort;", "", "", "minCapacity", "", "ensureCapacity", "i", "", "mergeAt", "mergeCollapse", "mergeForceCollapse", "base1", "len1", "base2", "len2", "mergeHi", "mergeLo", "runBase", "runLen", "pushRun", "a", "[B", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayComparator;", "c", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayComparator;", "entrySize", "I", "minGallop", "", "[I", "stackSize", TLogConstant.RUBBISH_DIR, "<init>", "([BLcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayComparator;I)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29860a = new a(0);
    private static final int j = 32;
    private static final int k = 7;
    private static final int l = 256;
    private static final boolean m = false;
    private int b;
    private byte[] c;
    private int d;
    private final int[] e;
    private final int[] f;
    private final byte[] g;
    private final cv h;
    private final int i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayTimSort$Companion;", "", "()V", DefaultLogger.DEBUG, "", "INITIAL_TMP_STORAGE_LENGTH", "", "MIN_GALLOP", "MIN_MERGE", "binarySort", "", "a", "", "lo", "hi", "start", "entrySize", "c", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayComparator;", "checkStartAndEnd", "len", "end", "countRunAndMakeAscending", "gallopLeft", "keyArray", "keyIndex", "base", "hint", "gallopRight", "minRunLength", "n", "reverseRange", "sort", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private final int b(byte[] bArr, int i, int i2, int i3, cv cvVar) {
            boolean unused = cw.m;
            int i4 = i + 1;
            if (i4 == i2) {
                return 1;
            }
            int iA = cvVar.a(i3, bArr, i4, bArr, i);
            int i5 = i4 + 1;
            if (iA >= 0) {
                while (i5 < i2) {
                    if (cvVar.a(i3, bArr, i5, bArr, i5 - 1) < 0) {
                        break;
                    }
                    i5++;
                }
            } else {
                while (i5 < i2) {
                    if (cvVar.a(i3, bArr, i5, bArr, i5 - 1) >= 0) {
                        break;
                    }
                    i5++;
                }
                a(bArr, i, i5, i3);
            }
            return i5 - i;
        }

        public final void a(@NotNull byte[] bArr, int i, int i2, int i3, @NotNull cv cvVar) {
            Intrinsics.checkNotNullParameter(bArr, "a");
            Intrinsics.checkNotNullParameter(cvVar, "c");
            a(bArr.length / i3, i, i2);
            int i4 = i2 - i;
            if (i4 < 2) {
                return;
            }
            if (i4 < cw.j) {
                a(bArr, i, i2, i + b(bArr, i, i2, i3, cvVar), i3, cvVar);
                return;
            }
            cw cwVar = new cw(bArr, cvVar, i3, (byte) 0);
            int iA = a(i4);
            int i5 = i4;
            int i6 = i;
            do {
                int iB = b(bArr, i6, i2, i3, cvVar);
                if (iB < iA) {
                    int i7 = i5 <= iA ? i5 : iA;
                    a(bArr, i6, i6 + i7, i6 + iB, i3, cvVar);
                    iB = i7;
                }
                cwVar.a(i6, iB);
                cwVar.c();
                i6 += iB;
                i5 -= iB;
            } while (i5 != 0);
            boolean unused = cw.m;
            cwVar.d();
            if (cw.m) {
                int unused2 = cwVar.d;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, cv cvVar) {
            int i6;
            int i7;
            boolean unused = cw.m;
            int i8 = i2 + i4;
            if (cvVar.a(i5, bArr, i, bArr2, i8) < 0) {
                int i9 = i4 + 1;
                int i10 = 0;
                int i11 = 1;
                while (i11 < i9 && cvVar.a(i5, bArr, i, bArr2, i8 - i11) < 0) {
                    int i12 = (i11 * 2) + 1;
                    if (i12 <= 0) {
                        i12 = i9;
                    }
                    int i13 = i12;
                    i10 = i11;
                    i11 = i13;
                }
                if (i11 <= i9) {
                    i9 = i11;
                }
                i6 = i4 - i9;
                i7 = i4 - i10;
            } else {
                int i14 = i3 - i4;
                int i15 = 0;
                int i16 = 1;
                while (i16 < i14 && cvVar.a(i5, bArr, i, bArr2, i8 + i16) >= 0) {
                    int i17 = (i16 * 2) + 1;
                    if (i17 <= 0) {
                        i17 = i14;
                    }
                    int i18 = i17;
                    i15 = i16;
                    i16 = i18;
                }
                if (i16 <= i14) {
                    i14 = i16;
                }
                i6 = i15 + i4;
                i7 = i4 + i14;
            }
            if (cw.m) {
            }
            int i19 = i6 + 1;
            while (i19 < i7) {
                int i20 = ((i7 - i19) >>> 1) + i19;
                if (cvVar.a(i5, bArr, i, bArr2, i2 + i20) < 0) {
                    i7 = i20;
                } else {
                    i19 = i20 + 1;
                }
            }
            boolean unused2 = cw.m;
            return i7;
        }

        private final void a(int i, int i2, int i3) {
            if (i2 < 0 || i3 > i) {
                throw new ArrayIndexOutOfBoundsException("start < 0 || end > len. start=" + i2 + ", end=" + i3 + ", len=" + i);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("start > end: " + i2 + " > " + i3);
        }

        private final void a(byte[] bArr, int i, int i2, int i3, int i4, cv cvVar) {
            int i5 = i3;
            boolean unused = cw.m;
            if (i5 == i) {
                i5++;
            }
            byte[] bArr2 = new byte[i4];
            for (int i6 = i5; i6 < i2; i6++) {
                int i7 = i6 * i4;
                for (int i8 = 0; i8 < i4; i8++) {
                    bArr2[i8] = bArr[i7 + i8];
                }
                boolean unused2 = cw.m;
                int i9 = i;
                int i10 = i6;
                while (i9 < i10) {
                    int i11 = (i9 + i10) >>> 1;
                    if (cvVar.a(i4, bArr2, 0, bArr, i11) < 0) {
                        i10 = i11;
                    } else {
                        i9 = i11 + 1;
                    }
                }
                boolean unused3 = cw.m;
                int i12 = i6 - i9;
                if (i12 == 1) {
                    int i13 = i9 * i4;
                    int i14 = (i9 + 1) * i4;
                    for (int i15 = 0; i15 < i4; i15++) {
                        bArr[i14 + i15] = bArr[i13 + i15];
                    }
                } else if (i12 != 2) {
                    System.arraycopy(bArr, i9 * i4, bArr, (i9 + 1) * i4, i12 * i4);
                } else {
                    int i16 = i9 * i4;
                    int i17 = (i9 + 1) * i4;
                    int i18 = (i9 + 2) * i4;
                    for (int i19 = 0; i19 < i4; i19++) {
                        bArr[i18 + i19] = bArr[i17 + i19];
                    }
                    for (int i20 = 0; i20 < i4; i20++) {
                        bArr[i17 + i20] = bArr[i16 + i20];
                    }
                }
                int i21 = i9 * i4;
                for (int i22 = 0; i22 < i4; i22++) {
                    bArr[i21 + i22] = bArr2[i22];
                }
            }
        }

        private final void a(byte[] bArr, int i, int i2, int i3) {
            while (true) {
                i2--;
                if (i >= i2) {
                    return;
                }
                int i4 = i * i3;
                int i5 = i2 * i3;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i4 + i6;
                    byte b = bArr[i7];
                    int i8 = i5 + i6;
                    bArr[i7] = bArr[i8];
                    bArr[i8] = b;
                }
                i++;
            }
        }

        private final int a(int i) {
            boolean unused = cw.m;
            int i2 = 0;
            while (i >= cw.j) {
                i2 |= i & 1;
                i >>= 1;
            }
            return i + i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, cv cvVar) {
            int i6;
            int i7;
            boolean unused = cw.m;
            int i8 = i2 + i4;
            if (cvVar.a(i5, bArr, i, bArr2, i8) > 0) {
                int i9 = i3 - i4;
                int i10 = 0;
                int i11 = 1;
                while (i11 < i9 && cvVar.a(i5, bArr, i, bArr2, i8 + i11) > 0) {
                    int i12 = (i11 * 2) + 1;
                    if (i12 <= 0) {
                        i12 = i9;
                    }
                    int i13 = i12;
                    i10 = i11;
                    i11 = i13;
                }
                if (i11 <= i9) {
                    i9 = i11;
                }
                i7 = i10 + i4;
                i6 = i9 + i4;
            } else {
                int i14 = i4 + 1;
                int i15 = 0;
                int i16 = 1;
                while (i16 < i14 && cvVar.a(i5, bArr, i, bArr2, i8 - i16) <= 0) {
                    int i17 = (i16 * 2) + 1;
                    if (i17 <= 0) {
                        i17 = i14;
                    }
                    int i18 = i17;
                    i15 = i16;
                    i16 = i18;
                }
                if (i16 <= i14) {
                    i14 = i16;
                }
                int i19 = i4 - i14;
                i6 = i4 - i15;
                i7 = i19;
            }
            if (cw.m) {
            }
            int i20 = i7 + 1;
            while (i20 < i6) {
                int i21 = ((i6 - i20) >>> 1) + i20;
                if (cvVar.a(i5, bArr, i, bArr2, i2 + i21) > 0) {
                    i20 = i21 + 1;
                } else {
                    i6 = i21;
                }
            }
            boolean unused2 = cw.m;
            return i6;
        }
    }

    public /* synthetic */ cw(byte[] bArr, cv cvVar, int i, byte b) {
        this(bArr, cvVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        while (true) {
            int i = this.d;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 > 0) {
                int[] iArr = this.f;
                if (iArr[i2 - 1] < iArr[i2 + 1]) {
                    i2--;
                }
            }
            a(i2);
        }
    }

    private cw(byte[] bArr, cv cvVar, int i) {
        this.g = bArr;
        this.h = cvVar;
        this.i = i;
        this.b = k;
        int length = bArr.length / i;
        int i2 = l;
        this.c = new byte[i * (length < i2 * 2 ? length >>> 1 : i2)];
        int i3 = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.e = new int[i3];
        this.f = new int[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final void c() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        while (true) {
            int i = this.d;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 >= 1) {
                int[] iArr4 = this.f;
                if (iArr4[i2 - 1] > iArr4[i2] + iArr4[i2 + 1]) {
                    if (i2 >= 2) {
                        iArr2 = this.f;
                        if (iArr2[i2 - 2] <= iArr2[i2] + iArr2[i2 - 1]) {
                            iArr3 = this.f;
                            if (iArr3[i2 - 1] < iArr3[i2 + 1]) {
                                i2--;
                            }
                        }
                    }
                    iArr = this.f;
                    if (iArr[i2] > iArr[i2 + 1]) {
                        return;
                    }
                } else {
                    iArr3 = this.f;
                    if (iArr3[i2 - 1] < iArr3[i2 + 1]) {
                        i2--;
                    }
                }
            } else {
                if (i2 >= 2) {
                    iArr2 = this.f;
                    if (iArr2[i2 - 2] <= iArr2[i2] + iArr2[i2 - 1]) {
                        iArr3 = this.f;
                        if (iArr3[i2 - 1] < iArr3[i2 + 1]) {
                            i2--;
                        }
                    }
                }
                iArr = this.f;
                if (iArr[i2] > iArr[i2 + 1]) {
                    return;
                }
            }
            a(i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:46:0x010e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0112  */
    /* JADX WARN: Code duplicated, block: B:50:0x011b A[LOOP:6: B:49:0x0119->B:50:0x011b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0134  */
    /* JADX WARN: Code duplicated, block: B:56:0x0151  */
    /* JADX WARN: Code duplicated, block: B:60:0x016a  */
    /* JADX WARN: Code duplicated, block: B:61:0x016c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0178 A[LOOP:7: B:63:0x0176->B:64:0x0178, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:80:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01da  */
    /* JADX WARN: Code duplicated, block: B:85:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:86:0x01df  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fb A[LOOP:5: B:41:0x00d5->B:93:0x01fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x0201 A[LOOP:3: B:21:0x0072->B:94:0x0201, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x0102 A[SYNTHETIC] */
    private final void b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iB;
        int i16;
        int i17;
        int i18;
        cv cvVar;
        int iA;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28 = i4;
        if (m && i2 > 0 && i28 > 0) {
            int i29 = i + i2;
        }
        byte[] bArr = this.g;
        byte[] bArrB = b(i28);
        int i30 = this.i;
        int i31 = i28 * i30;
        int i32 = 0;
        System.arraycopy(bArr, i3 * i30, bArrB, 0, i31);
        int i33 = 1;
        int i34 = (i + i2) - 1;
        int i35 = i28 - 1;
        int i36 = (i3 + i28) - 1;
        int i37 = i36 * i30;
        int i38 = i34 * i30;
        for (int i39 = 0; i39 < i30; i39++) {
            bArr[i37 + i39] = bArr[i38 + i39];
        }
        int i40 = i36 - 1;
        int i41 = i34 - 1;
        int i42 = i2 - 1;
        if (i42 == 0) {
            System.arraycopy(bArrB, 0, bArr, (i40 - i35) * i30, i31);
            return;
        }
        if (i28 == 1) {
            int i43 = i40 - i42;
            System.arraycopy(bArr, ((i41 - i42) + 1) * i30, bArr, (i43 + 1) * i30, i42 * i30);
            int i44 = i43 * i30;
            int i45 = i35 * i30;
            while (i32 < i30) {
                bArr[i44 + i32] = bArrB[i45 + i32];
                i32++;
            }
            return;
        }
        cv cvVar2 = this.h;
        int i46 = this.b;
        while (true) {
            int i47 = i35;
            int i48 = i42;
            int i49 = i32;
            int i50 = i49;
            while (true) {
                boolean z = m;
                int i51 = i46;
                if (cvVar2.a(i30, bArrB, i47, bArr, i41) < 0) {
                    int i52 = i40 * i30;
                    int i53 = i41 * i30;
                    for (int i54 = 0; i54 < i30; i54++) {
                        bArr[i52 + i54] = bArr[i53 + i54];
                    }
                    i40--;
                    i41--;
                    i49++;
                    i48--;
                    if (i48 == 0) {
                        i5 = i33;
                        i6 = i51;
                        i7 = i28;
                        i8 = i40;
                        i9 = 0;
                    } else {
                        i50 = 0;
                        if ((i49 | i50) >= i51) {
                            i10 = i28;
                            i11 = i47;
                            i12 = i48;
                            i13 = i41;
                            i6 = i51;
                            i14 = i40;
                            while (true) {
                                boolean z2 = m;
                                i15 = i10;
                                iB = i12 - f29860a.b(bArrB, i11, bArr, i, i12, i12 - 1, i30, cvVar2);
                                if (iB != 0) {
                                    i8 = i14 - iB;
                                    i41 = i13 - iB;
                                    i27 = i12 - iB;
                                    System.arraycopy(bArr, (i41 + 1) * i30, bArr, (i8 + 1) * i30, iB * i30);
                                    if (i27 == 0) {
                                        i5 = i33;
                                        i6 = i6;
                                        i47 = i11;
                                        i7 = i15;
                                        i9 = 0;
                                        i48 = i27;
                                    } else {
                                        i14 = i8;
                                        i12 = i27;
                                    }
                                } else {
                                    i41 = i13;
                                }
                                i16 = i14 * i30;
                                i17 = i11 * i30;
                                for (i18 = 0; i18 < i30; i18++) {
                                    bArr[i16 + i18] = bArrB[i17 + i18];
                                }
                                i8 = i14 - 1;
                                i47 = i11 - 1;
                                i7 = i15 - 1;
                                if (i7 == i33) {
                                    i5 = i33;
                                    i6 = i6;
                                    i48 = i12;
                                    i9 = 0;
                                } else {
                                    cvVar = cvVar2;
                                    i9 = 0;
                                    iA = i7 - f29860a.a(bArr, i41, bArrB, 0, i7, i7 - 1, i30, cvVar);
                                    if (iA != 0) {
                                        i8 -= iA;
                                        i47 -= iA;
                                        i26 = i7 - iA;
                                        System.arraycopy(bArrB, (i47 + 1) * i30, bArr, (i8 + 1) * i30, iA * i30);
                                        i5 = 1;
                                        if (i26 <= 1) {
                                            i7 = i26;
                                        } else {
                                            i10 = i26;
                                        }
                                        i48 = i12;
                                    } else {
                                        i5 = 1;
                                        i10 = i7;
                                    }
                                    i11 = i47;
                                    i19 = i8 * i30;
                                    i20 = i41 * i30;
                                    for (i21 = 0; i21 < i30; i21++) {
                                        bArr[i19 + i21] = bArr[i20 + i21];
                                    }
                                    i8--;
                                    i13 = i41 - 1;
                                    i12--;
                                    if (i12 == 0) {
                                        i7 = i10;
                                        i41 = i13;
                                        i47 = i11;
                                        i48 = i12;
                                    } else {
                                        i6--;
                                        i22 = k;
                                        if (iB >= i22) {
                                            i23 = i5;
                                        } else {
                                            i23 = 0;
                                        }
                                        if (iA >= i22) {
                                            i24 = i5;
                                        } else {
                                            i24 = 0;
                                        }
                                        if ((i23 | i24) == 0) {
                                            if (i6 < 0) {
                                                i25 = 0;
                                            } else {
                                                i25 = i6;
                                            }
                                            int i55 = i25 + 2;
                                            i32 = 0;
                                            i40 = i8;
                                            i33 = i5;
                                            i28 = i10;
                                            i35 = i11;
                                            i42 = i12;
                                            cvVar2 = cvVar;
                                            i46 = i55;
                                            i41 = i13;
                                        } else {
                                            i14 = i8;
                                            i33 = i5;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                            }
                        } else {
                            i46 = i51;
                        }
                    }
                } else {
                    int i56 = i40 * i30;
                    int i57 = i47 * i30;
                    for (int i58 = 0; i58 < i30; i58++) {
                        bArr[i56 + i58] = bArrB[i57 + i58];
                    }
                    i40--;
                    i47--;
                    i50++;
                    i28--;
                    if (i28 == i33) {
                        i5 = i33;
                        i6 = i51;
                        i7 = i28;
                        i8 = i40;
                        i9 = 0;
                    } else {
                        i49 = 0;
                        if ((i49 | i50) >= i51) {
                            i10 = i28;
                            i11 = i47;
                            i12 = i48;
                            i13 = i41;
                            i6 = i51;
                            i14 = i40;
                            while (true) {
                                boolean z3 = m;
                                i15 = i10;
                                iB = i12 - f29860a.b(bArrB, i11, bArr, i, i12, i12 - 1, i30, cvVar2);
                                if (iB != 0) {
                                    i8 = i14 - iB;
                                    i41 = i13 - iB;
                                    i27 = i12 - iB;
                                    System.arraycopy(bArr, (i41 + 1) * i30, bArr, (i8 + 1) * i30, iB * i30);
                                    if (i27 == 0) {
                                        i5 = i33;
                                        i6 = i6;
                                        i47 = i11;
                                        i7 = i15;
                                        i9 = 0;
                                        i48 = i27;
                                    } else {
                                        i14 = i8;
                                        i12 = i27;
                                    }
                                } else {
                                    i41 = i13;
                                }
                                i16 = i14 * i30;
                                i17 = i11 * i30;
                                while (i18 < i30) {
                                    bArr[i16 + i18] = bArrB[i17 + i18];
                                }
                                i8 = i14 - 1;
                                i47 = i11 - 1;
                                i7 = i15 - 1;
                                if (i7 == i33) {
                                    i5 = i33;
                                    i6 = i6;
                                    i48 = i12;
                                    i9 = 0;
                                } else {
                                    cvVar = cvVar2;
                                    i9 = 0;
                                    iA = i7 - f29860a.a(bArr, i41, bArrB, 0, i7, i7 - 1, i30, cvVar);
                                    if (iA != 0) {
                                        i8 -= iA;
                                        i47 -= iA;
                                        i26 = i7 - iA;
                                        System.arraycopy(bArrB, (i47 + 1) * i30, bArr, (i8 + 1) * i30, iA * i30);
                                        i5 = 1;
                                        if (i26 <= 1) {
                                            i7 = i26;
                                        } else {
                                            i10 = i26;
                                        }
                                        i48 = i12;
                                    } else {
                                        i5 = 1;
                                        i10 = i7;
                                    }
                                    i11 = i47;
                                    i19 = i8 * i30;
                                    i20 = i41 * i30;
                                    while (i21 < i30) {
                                        bArr[i19 + i21] = bArr[i20 + i21];
                                    }
                                    i8--;
                                    i13 = i41 - 1;
                                    i12--;
                                    if (i12 == 0) {
                                        i7 = i10;
                                        i41 = i13;
                                        i47 = i11;
                                        i48 = i12;
                                    } else {
                                        i6--;
                                        i22 = k;
                                        if (iB >= i22) {
                                            i23 = i5;
                                        } else {
                                            i23 = 0;
                                        }
                                        if (iA >= i22) {
                                            i24 = i5;
                                        } else {
                                            i24 = 0;
                                        }
                                        if ((i23 | i24) == 0) {
                                            if (i6 < 0) {
                                                i25 = 0;
                                            } else {
                                                i25 = i6;
                                            }
                                            int i59 = i25 + 2;
                                            i32 = 0;
                                            i40 = i8;
                                            i33 = i5;
                                            i28 = i10;
                                            i35 = i11;
                                            i42 = i12;
                                            cvVar2 = cvVar;
                                            i46 = i59;
                                            i41 = i13;
                                        } else {
                                            i14 = i8;
                                            i33 = i5;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                            }
                        } else {
                            i46 = i51;
                        }
                    }
                }
                if (i6 < i5) {
                    i6 = i5;
                }
                this.b = i6;
                if (i7 != i5) {
                    if (i7 != 0) {
                        boolean z4 = m;
                        System.arraycopy(bArrB, i9, bArr, (i8 - (i7 - 1)) * i30, i7 * i30);
                        return;
                    }
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
                boolean z5 = m;
                int i60 = i8 - i48;
                System.arraycopy(bArr, ((i41 - i48) + i5) * i30, bArr, (i60 + 1) * i30, i48 * i30);
                int i61 = i60 * i30;
                int i62 = i47 * i30;
                for (int i63 = i9; i63 < i30; i63++) {
                    bArr[i61 + i63] = bArrB[i62 + i63];
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        int[] iArr = this.e;
        int i3 = this.d;
        iArr[i3] = i;
        this.f[i3] = i2;
        this.d = i3 + 1;
    }

    private final void a(int i) {
        byte[] bArr;
        int iA;
        if (m) {
            int i2 = this.d;
            if (i != i2 - 2) {
                int i3 = i2 - 3;
            }
        }
        int[] iArr = this.e;
        int i4 = iArr[i];
        int[] iArr2 = this.f;
        int i5 = iArr2[i];
        int i6 = i + 1;
        int i7 = iArr[i6];
        int i8 = iArr2[i6];
        iArr2[i] = i5 + i8;
        int i9 = this.d;
        if (i == i9 - 3) {
            int i10 = i + 2;
            iArr[i6] = iArr[i10];
            iArr2[i6] = iArr2[i10];
        }
        this.d = i9 - 1;
        a aVar = f29860a;
        byte[] bArr2 = this.g;
        int iB = aVar.b(bArr2, i7, bArr2, i4, i5, 0, this.i, this.h);
        int i11 = i4 + iB;
        int i12 = i5 - iB;
        if (i12 == 0 || (iA = aVar.a((bArr = this.g), (i11 + i12) - 1, bArr, i7, i8, i8 - 1, this.i, this.h)) == 0) {
            return;
        }
        if (i12 <= iA) {
            a(i11, i12, i7, iA);
        } else {
            b(i11, i12, i7, iA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00df  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fb A[PHI: r1 r17 r18
      0x00fb: PHI (r1v13 int) = (r1v12 int), (r1v16 int) binds: [B:41:0x00dd, B:45:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r17v9 int) = (r17v8 int), (r17v18 int) binds: [B:41:0x00dd, B:45:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r18v7 int) = (r18v6 int), (r18v13 int) binds: [B:41:0x00dd, B:45:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x0102 A[LOOP:7: B:47:0x0100->B:48:0x0102, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x011e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0133  */
    /* JADX WARN: Code duplicated, block: B:57:0x014c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0157 A[LOOP:8: B:59:0x0155->B:60:0x0157, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:79:0x01af  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ca A[LOOP:5: B:40:0x00c8->B:88:0x01ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x01d0 A[LOOP:3: B:21:0x006b->B:89:0x01d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01bc A[SYNTHETIC] */
    private final void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        cv cvVar;
        int iB;
        int i14;
        int i15;
        int i16;
        int iA;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26 = i2;
        if (m && i26 > 0 && i4 > 0) {
            int i27 = i + i26;
        }
        byte[] bArr = this.g;
        int i28 = this.i;
        byte[] bArrB = b(i26);
        int i29 = i * i28;
        int i30 = i26 * i28;
        int i31 = 0;
        System.arraycopy(bArr, i29, bArrB, 0, i30);
        int i32 = i3 * i28;
        for (int i33 = 0; i33 < i28; i33++) {
            bArr[i29 + i33] = bArr[i32 + i33];
        }
        int i34 = 1;
        int i35 = i + 1;
        int i36 = i3 + 1;
        int i37 = i4 - 1;
        if (i37 == 0) {
            System.arraycopy(bArrB, i28 * 0, bArr, i35 * i28, i30);
            return;
        }
        if (i26 == 1) {
            System.arraycopy(bArr, i36 * i28, bArr, i35 * i28, i37 * i28);
            int i38 = (i35 + i37) * i28;
            int i39 = i28 * 0;
            while (i31 < i28) {
                bArr[i38 + i31] = bArrB[i39 + i31];
                i31++;
            }
            return;
        }
        cv cvVar2 = this.h;
        int i40 = this.b;
        int i41 = 0;
        loop2: while (true) {
            i5 = i35;
            i6 = i41;
            i7 = i37;
            int i42 = i31;
            int i43 = i42;
            while (true) {
                boolean z = m;
                if (cvVar2.a(i28, bArr, i36, bArrB, i6) < 0) {
                    int i44 = i5 * i28;
                    int i45 = i36 * i28;
                    for (int i46 = i31; i46 < i28; i46++) {
                        bArr[i44 + i46] = bArr[i45 + i46];
                    }
                    i5++;
                    i36++;
                    i43++;
                    i7--;
                    if (i7 == 0) {
                        i8 = i34;
                        i9 = i40;
                        break loop2;
                    }
                    i42 = i31;
                    if ((i42 | i43) >= i40) {
                        i10 = i7;
                        i11 = i6;
                        i12 = i5;
                        i13 = i40;
                        while (true) {
                            boolean z2 = m;
                            cvVar = cvVar2;
                            i8 = i34;
                            iB = f29860a.b(bArr, i36, bArrB, i11, i26, 0, i28, cvVar);
                            if (iB != 0) {
                                i14 = i12 * i28;
                                i15 = i36 * i28;
                                for (i16 = 0; i16 < i28; i16++) {
                                    bArr[i14 + i16] = bArr[i15 + i16];
                                }
                                i12++;
                                i36++;
                                i10--;
                                if (i10 != 0) {
                                    iA = f29860a.a(bArrB, i11, bArr, i36, i10, 0, i28, cvVar);
                                    if (iA != 0) {
                                        System.arraycopy(bArr, i36 * i28, bArr, i12 * i28, iA * i28);
                                        i23 = i12 + iA;
                                        i36 += iA;
                                        i24 = i10 - iA;
                                        if (i24 == 0) {
                                            i9 = i13;
                                            i6 = i11;
                                            i5 = i23;
                                            i7 = i24;
                                            break loop2;
                                        }
                                        i12 = i23;
                                        i10 = i24;
                                    }
                                    i17 = i12 * i28;
                                    i18 = i11 * i28;
                                    for (i19 = 0; i19 < i28; i19++) {
                                        bArr[i17 + i19] = bArrB[i18 + i19];
                                    }
                                    i12++;
                                    i11++;
                                    i26--;
                                    if (i26 == i8) {
                                        i13--;
                                        i20 = k;
                                        if (iB >= i20) {
                                            i21 = i8;
                                        } else {
                                            i21 = 0;
                                        }
                                        if (iA >= i20) {
                                            i22 = i8;
                                        } else {
                                            i22 = 0;
                                        }
                                        if ((i22 | i21) == 0) {
                                            if (i13 < 0) {
                                                i13 = 0;
                                            }
                                            i40 = i13 + 2;
                                            i34 = i8;
                                            i35 = i12;
                                            i41 = i11;
                                            i37 = i10;
                                            cvVar2 = cvVar;
                                            i31 = 0;
                                        } else {
                                            i34 = i8;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                                i9 = i13;
                                i5 = i12;
                                i6 = i11;
                                i7 = i10;
                                break loop2;
                            }
                            System.arraycopy(bArrB, i11 * i28, bArr, i12 * i28, iB * i28);
                            i25 = i12 + iB;
                            i6 = i11 + iB;
                            i26 -= iB;
                            if (i26 <= i8) {
                                i11 = i6;
                                i12 = i25;
                                i14 = i12 * i28;
                                i15 = i36 * i28;
                                while (i16 < i28) {
                                    bArr[i14 + i16] = bArr[i15 + i16];
                                }
                                i12++;
                                i36++;
                                i10--;
                                if (i10 != 0) {
                                    iA = f29860a.a(bArrB, i11, bArr, i36, i10, 0, i28, cvVar);
                                    if (iA != 0) {
                                        System.arraycopy(bArr, i36 * i28, bArr, i12 * i28, iA * i28);
                                        i23 = i12 + iA;
                                        i36 += iA;
                                        i24 = i10 - iA;
                                        if (i24 == 0) {
                                            i9 = i13;
                                            i6 = i11;
                                            i5 = i23;
                                            i7 = i24;
                                            break loop2;
                                        }
                                        i12 = i23;
                                        i10 = i24;
                                    }
                                    i17 = i12 * i28;
                                    i18 = i11 * i28;
                                    while (i19 < i28) {
                                        bArr[i17 + i19] = bArrB[i18 + i19];
                                    }
                                    i12++;
                                    i11++;
                                    i26--;
                                    if (i26 == i8) {
                                        i13--;
                                        i20 = k;
                                        if (iB >= i20) {
                                            i21 = i8;
                                        } else {
                                            i21 = 0;
                                        }
                                        if (iA >= i20) {
                                            i22 = i8;
                                        } else {
                                            i22 = 0;
                                        }
                                        if ((i22 | i21) == 0) {
                                            if (i13 < 0) {
                                                i13 = 0;
                                            }
                                            i40 = i13 + 2;
                                            i34 = i8;
                                            i35 = i12;
                                            i41 = i11;
                                            i37 = i10;
                                            cvVar2 = cvVar;
                                            i31 = 0;
                                        } else {
                                            i34 = i8;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                                i9 = i13;
                                i5 = i12;
                                i6 = i11;
                                i7 = i10;
                                break loop2;
                            }
                            i9 = i13;
                            i7 = i10;
                            i5 = i25;
                            break loop2;
                        }
                    }
                    i31 = 0;
                } else {
                    int i47 = i5 * i28;
                    int i48 = i6 * i28;
                    for (int i49 = i31; i49 < i28; i49++) {
                        bArr[i47 + i49] = bArrB[i48 + i49];
                    }
                    i5++;
                    i6++;
                    i42++;
                    i26--;
                    if (i26 == i34) {
                        i8 = i34;
                        i9 = i40;
                        break loop2;
                    }
                    i43 = i31;
                    if ((i42 | i43) >= i40) {
                        i10 = i7;
                        i11 = i6;
                        i12 = i5;
                        i13 = i40;
                        while (true) {
                            boolean z3 = m;
                            cvVar = cvVar2;
                            i8 = i34;
                            iB = f29860a.b(bArr, i36, bArrB, i11, i26, 0, i28, cvVar);
                            if (iB != 0) {
                                i14 = i12 * i28;
                                i15 = i36 * i28;
                                while (i16 < i28) {
                                    bArr[i14 + i16] = bArr[i15 + i16];
                                }
                                i12++;
                                i36++;
                                i10--;
                                if (i10 != 0) {
                                    iA = f29860a.a(bArrB, i11, bArr, i36, i10, 0, i28, cvVar);
                                    if (iA != 0) {
                                        System.arraycopy(bArr, i36 * i28, bArr, i12 * i28, iA * i28);
                                        i23 = i12 + iA;
                                        i36 += iA;
                                        i24 = i10 - iA;
                                        if (i24 == 0) {
                                            i9 = i13;
                                            i6 = i11;
                                            i5 = i23;
                                            i7 = i24;
                                            break loop2;
                                        }
                                        i12 = i23;
                                        i10 = i24;
                                    }
                                    i17 = i12 * i28;
                                    i18 = i11 * i28;
                                    while (i19 < i28) {
                                        bArr[i17 + i19] = bArrB[i18 + i19];
                                    }
                                    i12++;
                                    i11++;
                                    i26--;
                                    if (i26 == i8) {
                                        i13--;
                                        i20 = k;
                                        if (iB >= i20) {
                                            i21 = i8;
                                        } else {
                                            i21 = 0;
                                        }
                                        if (iA >= i20) {
                                            i22 = i8;
                                        } else {
                                            i22 = 0;
                                        }
                                        if ((i22 | i21) == 0) {
                                            if (i13 < 0) {
                                                i13 = 0;
                                            }
                                            i40 = i13 + 2;
                                            i34 = i8;
                                            i35 = i12;
                                            i41 = i11;
                                            i37 = i10;
                                            cvVar2 = cvVar;
                                            i31 = 0;
                                        } else {
                                            i34 = i8;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                                i9 = i13;
                                i5 = i12;
                                i6 = i11;
                                i7 = i10;
                                break loop2;
                            }
                            System.arraycopy(bArrB, i11 * i28, bArr, i12 * i28, iB * i28);
                            i25 = i12 + iB;
                            i6 = i11 + iB;
                            i26 -= iB;
                            if (i26 <= i8) {
                                i11 = i6;
                                i12 = i25;
                                i14 = i12 * i28;
                                i15 = i36 * i28;
                                while (i16 < i28) {
                                    bArr[i14 + i16] = bArr[i15 + i16];
                                }
                                i12++;
                                i36++;
                                i10--;
                                if (i10 != 0) {
                                    iA = f29860a.a(bArrB, i11, bArr, i36, i10, 0, i28, cvVar);
                                    if (iA != 0) {
                                        System.arraycopy(bArr, i36 * i28, bArr, i12 * i28, iA * i28);
                                        i23 = i12 + iA;
                                        i36 += iA;
                                        i24 = i10 - iA;
                                        if (i24 == 0) {
                                            i9 = i13;
                                            i6 = i11;
                                            i5 = i23;
                                            i7 = i24;
                                            break loop2;
                                        }
                                        i12 = i23;
                                        i10 = i24;
                                    }
                                    i17 = i12 * i28;
                                    i18 = i11 * i28;
                                    while (i19 < i28) {
                                        bArr[i17 + i19] = bArrB[i18 + i19];
                                    }
                                    i12++;
                                    i11++;
                                    i26--;
                                    if (i26 == i8) {
                                        i13--;
                                        i20 = k;
                                        if (iB >= i20) {
                                            i21 = i8;
                                        } else {
                                            i21 = 0;
                                        }
                                        if (iA >= i20) {
                                            i22 = i8;
                                        } else {
                                            i22 = 0;
                                        }
                                        if ((i22 | i21) == 0) {
                                            if (i13 < 0) {
                                                i13 = 0;
                                            }
                                            i40 = i13 + 2;
                                            i34 = i8;
                                            i35 = i12;
                                            i41 = i11;
                                            i37 = i10;
                                            cvVar2 = cvVar;
                                            i31 = 0;
                                        } else {
                                            i34 = i8;
                                            cvVar2 = cvVar;
                                        }
                                    }
                                }
                                i9 = i13;
                                i5 = i12;
                                i6 = i11;
                                i7 = i10;
                                break loop2;
                            }
                            i9 = i13;
                            i7 = i10;
                            i5 = i25;
                            break loop2;
                        }
                    }
                    i31 = 0;
                }
            }
        }
        if (i9 < i8) {
            i9 = i8;
        }
        this.b = i9;
        if (i26 != i8) {
            if (i26 != 0) {
                boolean z4 = m;
                System.arraycopy(bArrB, i6 * i28, bArr, i5 * i28, i26 * i28);
                return;
            }
            throw new IllegalArgumentException("Comparison method violates its general contract!");
        }
        boolean z5 = m;
        System.arraycopy(bArr, i36 * i28, bArr, i5 * i28, i7 * i28);
        int i50 = (i5 + i7) * i28;
        int i51 = i6 * i28;
        for (int i52 = 0; i52 < i28; i52++) {
            bArr[i50 + i52] = bArrB[i51 + i52];
        }
    }

    private final byte[] b(int i) {
        byte[] bArr = this.c;
        Intrinsics.checkNotNull(bArr);
        int length = bArr.length;
        int i2 = this.i;
        if (length < i * i2) {
            int i3 = (i >> 1) | i;
            int i4 = i3 | (i3 >> 2);
            int i5 = i4 | (i4 >> 4);
            int i6 = i5 | (i5 >> 8);
            int i7 = (i6 | (i6 >> 16)) + 1;
            if (i7 >= 0) {
                i = Math.min(i7, (this.g.length / i2) >>> 1);
            }
            this.c = new byte[i * this.i];
        }
        byte[] bArr2 = this.c;
        Intrinsics.checkNotNull(bArr2);
        return bArr2;
    }
}

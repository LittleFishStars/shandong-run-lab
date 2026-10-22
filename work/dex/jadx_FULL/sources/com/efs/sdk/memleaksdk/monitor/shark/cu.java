package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0012\u001a\u00060\u0010R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0015\u0010\u001e\u001a\u00020\u0003*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0082\fJ\u0015\u0010\u001e\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0082\fR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries;", "", "bytesPerValue", "", "longIdentifiers", "", "initialCapacity", "growthFactor", "", "(IZID)V", "assigned", "bytesPerEntry", "currentCapacity", "entries", "", "subArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries$MutableByteSubArray;", "subArrayIndex", RequestParameters.SUBRESOURCE_APPEND, CachedContentIndex.a.e, "", "growEntries", "", "newCapacity", "moveToSortedMap", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;", "readInt", "array", "index", "readLong", "and", "", "other", "MutableByteSubArray", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f29857a;
    byte[] b;
    int c;
    int d;
    final boolean e;
    private final a f;
    private int g;
    private final int h;
    private final int i;
    private final double j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries$moveToSortedMap$1", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/aosp/ByteArrayComparator;", "compare", "", "entrySize", "o1Array", "", "o1Index", "o2Array", "o2Index", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b implements cv {
        public b() {
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.cv
        public int a(int i, @NotNull byte[] bArr, int i2, @NotNull byte[] bArr2, int i3) {
            Intrinsics.checkNotNullParameter(bArr, "o1Array");
            Intrinsics.checkNotNullParameter(bArr2, "o2Array");
            cu cuVar = cu.this;
            return cuVar.e ? (cuVar.b(bArr, i2 * i) > cu.this.b(bArr2, i3 * i) ? 1 : (cuVar.b(bArr, i2 * i) == cu.this.b(bArr2, i3 * i) ? 0 : -1)) : Intrinsics.compare(cuVar.a(bArr, i2 * i), cu.this.a(bArr2, i3 * i));
        }
    }

    public cu(int i, boolean z, int i2, double d) {
        this.h = i;
        this.e = z;
        this.i = i2;
        this.j = d;
        this.f29857a = i + (z ? 8 : 4);
        this.f = new a();
    }

    @NotNull
    public final a a(long j) {
        if (this.b == null) {
            int i = this.i;
            this.g = i;
            this.b = new byte[i * this.f29857a];
        } else {
            int i2 = this.g;
            if (i2 == this.d) {
                int i3 = (int) (((double) i2) * this.j);
                a(i3);
                this.g = i3;
            }
        }
        this.d++;
        this.c = 0;
        this.f.a(j);
        return this.f;
    }

    public final long b(byte[] bArr, int i) {
        int i2 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        return (((long) bArr[i8]) & 255) | j5 | ((((long) bArr[i7]) & 255) << 8);
    }

    public /* synthetic */ cu(int i, boolean z, int i2, double d, int i3) {
        this(i, z, (i3 & 4) != 0 ? 4 : i2, (i3 & 8) != 0 ? 2.0d : d);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries$MutableByteSubArray;", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/UnsortedByteEntries;)V", "writeByte", "", "value", "", "writeId", "", "writeInt", "", "writeLong", "writeTruncatedLong", "byteCount", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public final class a {
        public a() {
        }

        public final void a(byte b) {
            cu cuVar = cu.this;
            int i = cuVar.c;
            cuVar.c = i + 1;
            int i2 = cuVar.f29857a;
            if (i >= 0 && i2 >= i) {
                int i3 = ((cuVar.d - 1) * i2) + i;
                byte[] bArr = cuVar.b;
                Intrinsics.checkNotNull(bArr);
                bArr[i3] = b;
                return;
            }
            throw new IllegalArgumentException(("Index " + i + " should be between 0 and " + cu.this.f29857a).toString());
        }

        public final void b(long j) {
            cu cuVar = cu.this;
            int i = cuVar.c;
            cuVar.c = i + 8;
            if (!(i >= 0 && i <= cuVar.f29857a - 8)) {
                throw new IllegalArgumentException(("Index " + i + " should be between 0 and " + (cu.this.f29857a - 8)).toString());
            }
            int i2 = ((cuVar.d - 1) * cuVar.f29857a) + i;
            byte[] bArr = cuVar.b;
            Intrinsics.checkNotNull(bArr);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((j >>> 56) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((j >>> 48) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((j >>> 40) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j >>> 32) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j >>> 24) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j >>> 16) & 255);
            bArr[i8] = (byte) ((j >>> 8) & 255);
            bArr[i8 + 1] = (byte) (j & 255);
        }

        public final void a(long j) {
            if (cu.this.e) {
                b(j);
            } else {
                a((int) j);
            }
        }

        public final void a(int i) {
            cu cuVar = cu.this;
            int i2 = cuVar.c;
            cuVar.c = i2 + 4;
            if (i2 >= 0 && i2 <= cuVar.f29857a + (-4)) {
                int i3 = ((cuVar.d - 1) * cuVar.f29857a) + i2;
                byte[] bArr = cuVar.b;
                Intrinsics.checkNotNull(bArr);
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((i >>> 24) & 255);
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((i >>> 16) & 255);
                bArr[i5] = (byte) ((i >>> 8) & 255);
                bArr[i5 + 1] = (byte) (i & 255);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i2);
            sb.append(" should be between 0 and ");
            sb.append(cu.this.f29857a - 4);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public final void a(long j, int i) {
            cu cuVar = cu.this;
            int i2 = cuVar.c;
            cuVar.c = i2 + i;
            if (i2 >= 0 && i2 <= cuVar.f29857a - i) {
                int i3 = ((cuVar.d - 1) * cuVar.f29857a) + i2;
                byte[] bArr = cuVar.b;
                Intrinsics.checkNotNull(bArr);
                int i4 = (i - 1) * 8;
                while (i4 >= 8) {
                    bArr[i3] = (byte) (255 & (j >>> i4));
                    i4 -= 8;
                    i3++;
                }
                bArr[i3] = (byte) (j & 255);
                return;
            }
            throw new IllegalArgumentException(("Index " + i2 + " should be between 0 and " + (cu.this.f29857a - i)).toString());
        }
    }

    @NotNull
    public final cs a() {
        if (this.d == 0) {
            return new cs(this.e, this.h, new byte[0]);
        }
        byte[] bArrCopyOf = this.b;
        Intrinsics.checkNotNull(bArrCopyOf);
        cw.f29860a.a(bArrCopyOf, 0, this.d, this.f29857a, new b());
        int length = bArrCopyOf.length;
        int i = this.d;
        int i2 = this.f29857a;
        if (length > i * i2) {
            bArrCopyOf = Arrays.copyOf(bArrCopyOf, i * i2);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        }
        this.b = null;
        this.d = 0;
        return new cs(this.e, this.h, bArrCopyOf);
    }

    public final int a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
        int i5 = i3 + 1;
        return (bArr[i5] & 255) | i4 | ((bArr[i3] & 255) << 8);
    }

    private final void a(int i) {
        int i2 = this.f29857a;
        byte[] bArr = new byte[i * i2];
        System.arraycopy(this.b, 0, bArr, 0, this.d * i2);
        this.b = bArr;
    }
}

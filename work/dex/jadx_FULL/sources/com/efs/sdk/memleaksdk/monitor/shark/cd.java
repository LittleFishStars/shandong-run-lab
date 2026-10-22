package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ByteSubArray;", "", "array", "", "rangeStart", "", "size", "longIdentifiers", "", "([BIIZ)V", "currentIndex", "endInclusive", "readByte", "", "readId", "", "readInt", "readLong", "readTruncatedLong", "byteCount", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29823a;
    private int b;
    private final byte[] c;
    private final int d;
    private final boolean e;

    public cd(@NotNull byte[] bArr, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        this.c = bArr;
        this.d = i;
        this.e = z;
        this.f29823a = i2 - 1;
    }

    public final byte a() {
        int i = this.b;
        this.b = i + 1;
        if (i >= 0 && this.f29823a >= i) {
            return this.c[this.d + i];
        }
        throw new IllegalArgumentException(("Index " + i + " should be between 0 and " + this.f29823a).toString());
    }

    public final long b() {
        return this.e ? d() : c();
    }

    public final int c() {
        int i = this.b;
        this.b = i + 4;
        if (i >= 0 && i <= this.f29823a + (-3)) {
            return ce.b(this.c, this.d + i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" should be between 0 and ");
        sb.append(this.f29823a - 3);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final long d() {
        int i = this.b;
        this.b = i + 8;
        if (i >= 0 && i <= this.f29823a + (-7)) {
            return ce.c(this.c, this.d + i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" should be between 0 and ");
        sb.append(this.f29823a - 7);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final long a(int i) {
        int i2 = this.b;
        this.b = i2 + i;
        if (i2 >= 0 && i2 <= this.f29823a - (i + (-1))) {
            int i3 = this.d + i2;
            byte[] bArr = this.c;
            int i4 = (i - 1) * 8;
            long j = 0;
            while (i4 >= 8) {
                j |= (255 & ((long) bArr[i3])) << i4;
                i4 -= 8;
                i3++;
            }
            return (((long) bArr[i3]) & 255) | j;
        }
        throw new IllegalArgumentException(("Index " + i2 + " should be between 0 and " + (this.f29823a - (i - 1))).toString());
    }
}

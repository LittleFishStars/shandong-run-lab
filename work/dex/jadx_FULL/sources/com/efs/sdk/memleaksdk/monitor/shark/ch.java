package com.efs.sdk.memleaksdk.monitor.shark;

import com.aliyun.vod.log.core.AliyunLogCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010\u0014\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0082\fJ\u0015\u0010\u0014\u001a\u00020\t*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0082\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldIdReader;", "", AliyunLogCommon.SubModule.RECORD, "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readByteId", "", "index", "array", "", "readId", "readIntId", "readLongId", "readShortId", "skipBytes", "", "count", "and", "", "other", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29827a;
    private final HprofRecord.a.AbstractC0624a.b b;
    private final int c;

    public ch(@NotNull HprofRecord.a.AbstractC0624a.b bVar, int i) {
        Intrinsics.checkNotNullParameter(bVar, AliyunLogCommon.SubModule.RECORD);
        this.b = bVar;
        this.c = i;
    }

    private final long b(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255);
    }

    private final long c(int i, byte[] bArr) {
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

    public final long a() {
        long jA;
        int i = this.c;
        if (i == 1) {
            jA = this.b.f29779a[this.f29827a];
        } else if (i == 2) {
            jA = a(this.f29827a, this.b.f29779a);
        } else if (i == 4) {
            jA = b(this.f29827a, this.b.f29779a);
        } else {
            if (i != 8) {
                throw new IllegalStateException("ID Length must be 1, 2, 4, or 8".toString());
            }
            jA = c(this.f29827a, this.b.f29779a);
        }
        this.f29827a += this.c;
        return jA;
    }

    public final void a(int i) {
        this.f29827a += i;
    }

    private final long a(int i, byte[] bArr) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }
}

package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ax, reason: from Kotlin metadata and from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0004HÆ\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "component1", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "component2", "component3", "heapDumpTimestamp", "version", "identifierByteSize", OperatePopupWindow.g, "J", "getHeapDumpTimestamp", "()J", "I", "getIdentifierByteSize", "()I", "recordsPosition", "getRecordsPosition", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "getVersion", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "<init>", "(JLcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;I)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class HprofHeader {

    @NotNull
    public static final a d = new a(0 == true ? 1 : 0);
    private static final Map<String, HprofVersion> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f29764a;

    /* JADX INFO: renamed from: b, reason: from toString */
    @NotNull
    public final HprofVersion version;

    /* JADX INFO: renamed from: c, reason: from toString */
    public final int identifierByteSize;

    /* JADX INFO: renamed from: e, reason: from toString */
    private final long heapDumpTimestamp;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ax$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader$Companion;", "", "()V", "supportedVersions", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "parseHeaderOf", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "source", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        @NotNull
        public final HprofHeader a(@NotNull n nVar) throws IOException {
            Intrinsics.checkNotNullParameter(nVar, "source");
            if (!(!nVar.b())) {
                throw new IllegalArgumentException("Source has no available bytes");
            }
            String strA = nVar.a(nVar.a((byte) 0));
            HprofVersion hprofVersion = (HprofVersion) HprofHeader.f.get(strA);
            if (hprofVersion != null) {
                nVar.c(1L);
                return new HprofHeader(nVar.f(), hprofVersion, nVar.e());
            }
            throw new IllegalStateException(("Unsupported Hprof version [" + strA + "] not in supported list " + HprofHeader.f.keySet()).toString());
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HprofVersion[] hprofVersionArrValues = HprofVersion.values();
        ArrayList arrayList = new ArrayList(hprofVersionArrValues.length);
        for (HprofVersion hprofVersion : hprofVersionArrValues) {
            arrayList.add(TuplesKt.to(hprofVersion.e, hprofVersion));
        }
        f = MapsKt.toMap(arrayList);
    }

    public HprofHeader() {
        this(0L, null, 0, 7);
    }

    public HprofHeader(long j, @NotNull HprofVersion hprofVersion, int i) {
        Intrinsics.checkNotNullParameter(hprofVersion, "version");
        this.heapDumpTimestamp = j;
        this.version = hprofVersion;
        this.identifierByteSize = i;
        String str = hprofVersion.e;
        Charset charset = Charsets.UTF_8;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.f29764a = bytes.length + 1 + 4 + 8;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HprofHeader)) {
            return false;
        }
        HprofHeader hprofHeader = (HprofHeader) other;
        return this.heapDumpTimestamp == hprofHeader.heapDumpTimestamp && Intrinsics.areEqual(this.version, hprofHeader.version) && this.identifierByteSize == hprofHeader.identifierByteSize;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.heapDumpTimestamp) * 31;
        HprofVersion hprofVersion = this.version;
        return ((iHashCode + (hprofVersion != null ? hprofVersion.hashCode() : 0)) * 31) + Integer.hashCode(this.identifierByteSize);
    }

    @NotNull
    public String toString() {
        return "HprofHeader(heapDumpTimestamp=" + this.heapDumpTimestamp + ", version=" + this.version + ", identifierByteSize=" + this.identifierByteSize + ")";
    }

    public /* synthetic */ HprofHeader(long j, HprofVersion hprofVersion, int i, int i2) {
        this((i2 & 1) != 0 ? System.currentTimeMillis() : j, (i2 & 2) != 0 ? HprofVersion.ANDROID : hprofVersion, (i2 & 4) != 0 ? 4 : i);
    }
}

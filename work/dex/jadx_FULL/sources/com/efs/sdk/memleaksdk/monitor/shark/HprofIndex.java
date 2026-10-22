package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.az, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB!\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/CloseableHeapGraph;", "openHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "index", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;", "sourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/HprofInMemoryIndex;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29774a = new a(0);
    private final RandomAccessSourceProvider b;
    private final HprofHeader c;
    private final cj d;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.az$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex$Companion;", "", "()V", "defaultIndexedGcRootTags", "Ljava/util/EnumSet;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "kotlin.jvm.PlatformType", "indexRecordsOf", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofIndex;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/DualSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "indexedGcRootTags", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        @NotNull
        public final HprofIndex a(@NotNull DualSourceProvider dualSourceProvider, @NotNull HprofHeader hprofHeader, @Nullable ProguardMapping proguardMapping, @NotNull Set<? extends HprofRecordTag> set) {
            Intrinsics.checkNotNullParameter(dualSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            Intrinsics.checkNotNullParameter(set, "indexedGcRootTags");
            return new HprofIndex(dualSourceProvider, hprofHeader, cj.e.a(StreamingHprofReader.f29818a.a(dualSourceProvider, hprofHeader), hprofHeader, proguardMapping, set), (byte) 0);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private HprofIndex(RandomAccessSourceProvider randomAccessSourceProvider, HprofHeader hprofHeader, cj cjVar) {
        this.b = randomAccessSourceProvider;
        this.c = hprofHeader;
        this.d = cjVar;
    }

    @NotNull
    public final CloseableHeapGraph a() {
        return new HprofHeapGraph(this.c, RandomAccessHprofReader.f29815a.a(this.b, this.c), this.d);
    }

    public /* synthetic */ HprofIndex(RandomAccessSourceProvider randomAccessSourceProvider, HprofHeader hprofHeader, cj cjVar, byte b) {
        this(randomAccessSourceProvider, hprofHeader, cjVar);
    }
}

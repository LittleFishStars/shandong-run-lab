package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0010\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&¨\u0006'"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "", "()V", "id", "", "getId", "()J", "Debugger", "Finalizing", "InternedString", "JavaFrame", "JniGlobal", "JniLocal", "JniMonitor", "MonitorUsed", "NativeStack", "ReferenceCleanup", "StickyClass", "ThreadBlock", "ThreadObject", "Unknown", "Unreachable", "VmInternal", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unknown;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniGlobal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniLocal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JavaFrame;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$NativeStack;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$StickyClass;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadBlock;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$MonitorUsed;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ReferenceCleanup;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$VmInternal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniMonitor;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$InternedString;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Finalizing;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Debugger;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unreachable;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class GcRoot {

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Debugger;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29726a;

        public a(long j) {
            super((byte) 0);
            this.f29726a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29726a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Finalizing;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29727a;

        public b(long j) {
            super((byte) 0);
            this.f29727a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29727a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$InternedString;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class c extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29728a;

        public c(long j) {
            super((byte) 0);
            this.f29728a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29728a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JavaFrame;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "threadSerialNumber", "", "frameNumber", "(JII)V", "getFrameNumber", "()I", "getId", "()J", "getThreadSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29729a;
        private final long b;
        private final int c;

        public d(long j, int i, int i2) {
            super((byte) 0);
            this.b = j;
            this.f29729a = i;
            this.c = i2;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniGlobal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "jniGlobalRefId", "(JJ)V", "getId", "()J", "getJniGlobalRefId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class e extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29730a;
        private final long b;

        public e(long j, long j2) {
            super((byte) 0);
            this.f29730a = j;
            this.b = j2;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29730a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$f */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniLocal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "threadSerialNumber", "", "frameNumber", "(JII)V", "getFrameNumber", "()I", "getId", "()J", "getThreadSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class f extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29731a;
        private final int b;
        private final int c;

        public f(long j, int i, int i2) {
            super((byte) 0);
            this.f29731a = j;
            this.b = i;
            this.c = i2;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29731a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$g */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniMonitor;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "stackTraceSerialNumber", "", "stackDepth", "(JII)V", "getId", "()J", "getStackDepth", "()I", "getStackTraceSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class g extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29732a;
        private final int b;
        private final int c;

        public g(long j, int i, int i2) {
            super((byte) 0);
            this.f29732a = j;
            this.b = i;
            this.c = i2;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29732a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$h */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$MonitorUsed;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class h extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29733a;

        public h(long j) {
            super((byte) 0);
            this.f29733a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29733a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$i */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$NativeStack;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "threadSerialNumber", "", "(JI)V", "getId", "()J", "getThreadSerialNumber", "()I", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class i extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29734a;
        private final int b;

        public i(long j, int i) {
            super((byte) 0);
            this.f29734a = j;
            this.b = i;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29734a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$j */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ReferenceCleanup;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class j extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29735a;

        public j(long j) {
            super((byte) 0);
            this.f29735a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29735a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$k */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$StickyClass;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class k extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29736a;

        public k(long j) {
            super((byte) 0);
            this.f29736a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29736a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$l */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadBlock;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "threadSerialNumber", "", "(JI)V", "getId", "()J", "getThreadSerialNumber", "()I", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class l extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29737a;
        private final int b;

        public l(long j, int i) {
            super((byte) 0);
            this.f29737a = j;
            this.b = i;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29737a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$m */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "threadSerialNumber", "", "stackTraceSerialNumber", "(JII)V", "getId", "()J", "getStackTraceSerialNumber", "()I", "getThreadSerialNumber", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class m extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29738a;
        private final long b;
        private final int c;

        public m(long j, int i, int i2) {
            super((byte) 0);
            this.b = j;
            this.f29738a = i;
            this.c = i2;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$n */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unknown;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class n extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29739a;

        public n(long j) {
            super((byte) 0);
            this.f29739a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29739a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$o */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unreachable;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class o extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29740a;

        public o(long j) {
            super((byte) 0);
            this.f29740a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29740a;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ap$p */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$VmInternal;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "id", "", "(J)V", "getId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class p extends GcRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29741a;

        public p(long j) {
            super((byte) 0);
            this.f29741a = j;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.GcRoot
        /* JADX INFO: renamed from: a, reason: from getter */
        public long getF29741a() {
            return this.f29741a;
        }
    }

    private GcRoot() {
    }

    /* JADX INFO: renamed from: a */
    public abstract long getF29741a();

    public /* synthetic */ GcRoot(byte b2) {
        this();
    }
}

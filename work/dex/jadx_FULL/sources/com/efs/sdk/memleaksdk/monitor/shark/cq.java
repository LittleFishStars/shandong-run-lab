package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "", "()V", "objectId", "", "getObjectId", "()J", "ChildNode", "LibraryLeakNode", "RootNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class cq {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "()V", "owningClassId", "", "getOwningClassId", "()J", "parent", "getParent", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "refFromParentName", "", "getRefFromParentName", "()Ljava/lang/String;", "refFromParentType", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "getRefFromParentType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "LibraryLeakChildNode", "NormalNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode$LibraryLeakChildNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode$NormalNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class a extends cq {

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cq$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode$LibraryLeakChildNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$LibraryLeakNode;", "objectId", "", "parent", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "refFromParentType", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "refFromParentName", "", "matcher", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "owningClassId", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;Ljava/lang/String;Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;J)V", "getMatcher", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "getObjectId", "()J", "getOwningClassId", "getParent", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "getRefFromParentName", "()Ljava/lang/String;", "getRefFromParentType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class C0630a extends a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f29849a;

            @NotNull
            private final cq b;

            @NotNull
            private final LeakTraceReference.b c;

            @NotNull
            private final String d;

            @NotNull
            private final LibraryLeakReferenceMatcher e;
            private final long f;

            public /* synthetic */ C0630a(long j, cq cqVar, LeakTraceReference.b bVar, String str, LibraryLeakReferenceMatcher libraryLeakReferenceMatcher, long j2, int i) {
                this(j, cqVar, bVar, str, libraryLeakReferenceMatcher, (i & 32) != 0 ? 0L : j2);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.cq
            /* JADX INFO: renamed from: a, reason: from getter */
            public long getF29852a() {
                return this.f29849a;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: from getter */
            public cq getB() {
                return this.b;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: c, reason: from getter */
            public LeakTraceReference.b getC() {
                return this.c;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: d, reason: from getter */
            public String getD() {
                return this.d;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            /* JADX INFO: renamed from: e, reason: from getter */
            public long getE() {
                return this.f;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.b
            @NotNull
            /* JADX INFO: renamed from: f, reason: from getter */
            public LibraryLeakReferenceMatcher getC() {
                return this.e;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0630a(long j, @NotNull cq cqVar, @NotNull LeakTraceReference.b bVar, @NotNull String str, @NotNull LibraryLeakReferenceMatcher libraryLeakReferenceMatcher, long j2) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(cqVar, "parent");
                Intrinsics.checkNotNullParameter(bVar, "refFromParentType");
                Intrinsics.checkNotNullParameter(str, "refFromParentName");
                Intrinsics.checkNotNullParameter(libraryLeakReferenceMatcher, "matcher");
                this.f29849a = j;
                this.b = cqVar;
                this.c = bVar;
                this.d = str;
                this.e = libraryLeakReferenceMatcher;
                this.f = j2;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode$NormalNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "objectId", "", "parent", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "refFromParentType", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "refFromParentName", "", "owningClassId", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;Ljava/lang/String;J)V", "getObjectId", "()J", "getOwningClassId", "getParent", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "getRefFromParentName", "()Ljava/lang/String;", "getRefFromParentType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference$ReferenceType;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f29850a;

            @NotNull
            private final cq b;

            @NotNull
            private final LeakTraceReference.b c;

            @NotNull
            private final String d;
            private final long e;

            public /* synthetic */ b(long j, cq cqVar, LeakTraceReference.b bVar, String str, long j2, int i) {
                this(j, cqVar, bVar, str, (i & 16) != 0 ? 0L : j2);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.cq
            /* JADX INFO: renamed from: a, reason: from getter */
            public long getF29852a() {
                return this.f29850a;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: from getter */
            public cq getB() {
                return this.b;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: c, reason: from getter */
            public LeakTraceReference.b getC() {
                return this.c;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            @NotNull
            /* JADX INFO: renamed from: d, reason: from getter */
            public String getD() {
                return this.d;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.a
            /* JADX INFO: renamed from: e, reason: from getter */
            public long getE() {
                return this.e;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, @NotNull cq cqVar, @NotNull LeakTraceReference.b bVar, @NotNull String str, long j2) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(cqVar, "parent");
                Intrinsics.checkNotNullParameter(bVar, "refFromParentType");
                Intrinsics.checkNotNullParameter(str, "refFromParentName");
                this.f29850a = j;
                this.b = cqVar;
                this.c = bVar;
                this.d = str;
                this.e = j2;
            }
        }

        private a() {
            super((byte) 0);
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public abstract cq getB();

        @NotNull
        /* JADX INFO: renamed from: c */
        public abstract LeakTraceReference.b getC();

        @NotNull
        /* JADX INFO: renamed from: d */
        public abstract String getD();

        /* JADX INFO: renamed from: e */
        public abstract long getE();

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$LibraryLeakNode;", "", "matcher", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "getMatcher", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public interface b {
        @NotNull
        /* JADX INFO: renamed from: f */
        LibraryLeakReferenceMatcher getC();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "()V", "gcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getGcRoot", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "LibraryLeakRootNode", "NormalRootNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode$NormalRootNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class c extends cq {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode$LibraryLeakRootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$LibraryLeakNode;", "objectId", "", "gcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "matcher", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "(JLcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;)V", "getGcRoot", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getMatcher", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "getObjectId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a extends c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f29851a;

            @NotNull
            private final GcRoot b;

            @NotNull
            private final LibraryLeakReferenceMatcher c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, @NotNull GcRoot gcRoot, @NotNull LibraryLeakReferenceMatcher libraryLeakReferenceMatcher) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(gcRoot, "gcRoot");
                Intrinsics.checkNotNullParameter(libraryLeakReferenceMatcher, "matcher");
                this.f29851a = j;
                this.b = gcRoot;
                this.c = libraryLeakReferenceMatcher;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.cq
            /* JADX INFO: renamed from: a, reason: from getter */
            public long getF29852a() {
                return this.f29851a;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.c
            @NotNull
            /* JADX INFO: renamed from: b, reason: from getter */
            public GcRoot getB() {
                return this.b;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.b
            @NotNull
            /* JADX INFO: renamed from: f, reason: from getter */
            public LibraryLeakReferenceMatcher getC() {
                return this.c;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode$NormalRootNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "objectId", "", "gcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "(JLcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;)V", "getGcRoot", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getObjectId", "()J", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f29852a;

            @NotNull
            private final GcRoot b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, @NotNull GcRoot gcRoot) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(gcRoot, "gcRoot");
                this.f29852a = j;
                this.b = gcRoot;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.cq
            /* JADX INFO: renamed from: a, reason: from getter */
            public long getF29852a() {
                return this.f29852a;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.cq.c
            @NotNull
            /* JADX INFO: renamed from: b, reason: from getter */
            public GcRoot getB() {
                return this.b;
            }
        }

        private c() {
            super((byte) 0);
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public abstract GcRoot getB();

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    private cq() {
    }

    /* JADX INFO: renamed from: a */
    public abstract long getF29852a();

    public /* synthetic */ cq(byte b2) {
        this();
    }
}

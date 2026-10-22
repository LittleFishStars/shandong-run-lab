package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0004@ABCB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#0\u0007H\u0002J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007*\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0014\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\f\u0010-\u001a\u00020)*\u00020*H\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020*H\u0002J\u0014\u0010.\u001a\u00020\u000b*\u00020\u00032\u0006\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\u00020,*\u00020*H\u0002J \u00102\u001a\b\u0012\u0004\u0012\u00020403*\u00020!2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007H\u0002J\u0012\u00106\u001a\u000207*\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u001c\u00108\u001a\u00020)*\u00020*2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020,H\u0002J\u001c\u0010;\u001a\u00020)*\u00020*2\u0006\u0010<\u001a\u00020!2\u0006\u0010:\u001a\u00020,H\u0002J\u001c\u0010=\u001a\u00020)*\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010:\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;Ljava/util/List;)V", "SAME_INSTANCE_THRESHOLD", "", "fieldNameByClassName", "", "", "instanceCountMap", "", "", "", "jniGlobalReferenceMatchers", "staticFieldNameByClassName", "threadNameReferenceMatchers", "determineSizeOfObjectInstances", "objectClass", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "findPathsFromGcRoots", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "computeRetainedHeapSize", "", "isOverThresholdInstance", "graphObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "sortedGcRoots", "Lkotlin/Pair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "classHierarchyWithoutJavaLangObject", "javaLangObjectId", "enqueue", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$State;", "node", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "enqueueGcRoots", "getRecordSize", "field", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "poll", "readAllNonNullFieldsOfReferenceType", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$InstanceRefField;", "classHierarchy", "toLongScatterSet", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "visitClassRecord", "heapClass", "parent", "visitInstance", "instance", "visitObjectArray", "objectArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "InstanceRefField", "PathFindingResults", "State", "VisitTracker", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, ReferenceMatcher>> f29839a;
    private final Map<String, Map<String, ReferenceMatcher>> b;
    private final Map<String, ReferenceMatcher> c;
    private final Map<String, ReferenceMatcher> d;
    private final int e;
    private Map<Long, Short> f;
    private final HeapGraph g;
    private final OnAnalysisProgressListener h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$InstanceRefField;", "", "declaringClassId", "", "refObjectId", "fieldName", "", "(JJLjava/lang/String;)V", "getDeclaringClassId", "()J", "getFieldName", "()Ljava/lang/String;", "getRefObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f29840a;
        final long b;

        @NotNull
        final String c;

        public a(long j, long j2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "fieldName");
            this.f29840a = j;
            this.b = j2;
            this.c = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "(Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;)V", "getDominatorTree", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "getPathsToLeakingObjects", "()Ljava/util/List;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final List<cq> f29841a;

        @Nullable
        public final cg b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends cq> list, @Nullable cg cgVar) {
            Intrinsics.checkNotNullParameter(list, "pathsToLeakingObjects");
            this.f29841a = list;
            this.b = cgVar;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$State;", "", "leakingObjectIds", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "sizeOfObjectInstances", "", "computeRetainedHeapSize", "", "javaLangObjectId", "", "estimatedVisitedObjects", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;IZJI)V", "getComputeRetainedHeapSize", "()Z", "getJavaLangObjectId", "()J", "getLeakingObjectIds", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "queuesNotEmpty", "getQueuesNotEmpty", "getSizeOfObjectInstances", "()I", "toVisitLastQueue", "Ljava/util/Deque;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "getToVisitLastSet", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitTracker", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "getVisitTracker", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "visitingLast", "getVisitingLast", "setVisitingLast", "(Z)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        final Deque<cq> f29842a;

        @NotNull
        final Deque<cq> b;

        @NotNull
        final dd c;

        @NotNull
        final dd d;

        @NotNull
        final d e;
        boolean f;

        @NotNull
        final dd g;
        final int h;
        final boolean i;
        final long j;

        public c(@NotNull dd ddVar, int i, boolean z, long j, int i2) {
            Intrinsics.checkNotNullParameter(ddVar, "leakingObjectIds");
            this.g = ddVar;
            this.h = i;
            this.i = z;
            this.j = j;
            this.f29842a = new ArrayDeque();
            this.b = new ArrayDeque();
            this.c = new dd(0, 1);
            this.d = new dd(0, 1);
            this.e = z ? new d.a(i2) : new d.b(i2);
        }

        public final boolean a() {
            return (this.f29842a.isEmpty() ^ true) || (this.b.isEmpty() ^ true);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "", "()V", "visited", "", "objectId", "", "parentObjectId", "Dominated", "Visited", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Dominated;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Visited;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class d {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Dominated;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "getDominatorTree", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "visited", "", "objectId", "", "parentObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            final cg f29843a;

            public a(int i) {
                super((byte) 0);
                this.f29843a = new cg(i);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.co.d
            public boolean a(long j, long j2) {
                return this.f29843a.a(j, j2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker$Visited;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$VisitTracker;", "expectedElements", "", "(I)V", "visitedSet", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongScatterSet;", "visited", "", "objectId", "", "parentObjectId", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final dd f29844a;

            public b(int i) {
                super((byte) 0);
                this.f29844a = new dd(i);
            }

            @Override // com.efs.sdk.memleaksdk.monitor.internal.co.d
            public boolean a(long j, long j2) {
                return !this.f29844a.a(j);
            }
        }

        private d() {
        }

        public abstract boolean a(long j, long j2);

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", BridgeDSL.INVOKE, "()Ljava/lang/String;", "com/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$enqueueGcRoots$1$threadName$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class e extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c f29845a;
        final /* synthetic */ co b;
        final /* synthetic */ c c;
        final /* synthetic */ Map d;
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar, co coVar, c cVar2, Map map, Map map2) {
            super(0);
            this.f29845a = cVar;
            this.b = coVar;
            this.c = cVar2;
            this.d = map;
            this.e = map2;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String strG;
            HeapValue heapValue;
            HeapField heapFieldB = this.f29845a.b(Reflection.getOrCreateKotlinClass(Thread.class), "name");
            if (heapFieldB == null || (heapValue = heapFieldB.c) == null || (strG = heapValue.g()) == null) {
                strG = "";
            }
            this.e.put(this.f29845a, strG);
            return strG;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u00002&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "<name for destructuring parameter 1>", "", "compare", "(Lkotlin/Pair;Lkotlin/Pair;)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class f<T> implements Comparator<Pair<? extends com.efs.sdk.memleaksdk.monitor.shark.HeapObject, ? extends GcRoot>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f29846a;

        public f(Function1 function1) {
            this.f29846a = function1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(Pair<? extends com.efs.sdk.memleaksdk.monitor.shark.HeapObject, ? extends GcRoot> pair, Pair<? extends com.efs.sdk.memleaksdk.monitor.shark.HeapObject, ? extends GcRoot> pair2) {
            com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObject = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject) pair.component1();
            GcRoot gcRoot = (GcRoot) pair.component2();
            com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObject2 = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject) pair2.component1();
            String name = ((GcRoot) pair2.component2()).getClass().getName();
            String name2 = gcRoot.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "root1::class.java.name");
            int iCompareTo = name.compareTo(name2);
            return iCompareTo != 0 ? iCompareTo : ((String) this.f29846a.invoke(heapObject)).compareTo((String) this.f29846a.invoke(heapObject2));
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.co$g, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "graphObject", "", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class HeapObject extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.HeapObject, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HeapObject f29847a = new HeapObject();

        public HeapObject() {
            super(1);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObject) throws NoWhenBranchMatchedException {
            Intrinsics.checkNotNullParameter(heapObject, "graphObject");
            if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) {
                return ((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) heapObject).f();
            }
            if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) {
                return ((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) heapObject).h();
            }
            if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) {
                return ((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) heapObject).f();
            }
            if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.e) {
                return ((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.e) heapObject).g();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 4, 1})
    public static final class h<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((a) t).c, ((a) t2).c);
        }
    }

    public co(@NotNull HeapGraph heapGraph, @NotNull OnAnalysisProgressListener onAnalysisProgressListener, @NotNull List<? extends ReferenceMatcher> list) {
        Intrinsics.checkNotNullParameter(heapGraph, "graph");
        Intrinsics.checkNotNullParameter(onAnalysisProgressListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Intrinsics.checkNotNullParameter(list, "referenceMatchers");
        this.g = heapGraph;
        this.h = onAnalysisProgressListener;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        ArrayList<ReferenceMatcher> arrayList = new ArrayList();
        for (Object obj : list) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) obj;
            if ((referenceMatcher instanceof IgnoredReferenceMatcher) || ((referenceMatcher instanceof LibraryLeakReferenceMatcher) && ((Boolean) ((LibraryLeakReferenceMatcher) referenceMatcher).b.invoke(this.g)).booleanValue())) {
                arrayList.add(obj);
            }
        }
        for (ReferenceMatcher referenceMatcher2 : arrayList) {
            ReferencePattern f29792a = referenceMatcher2.getF29792a();
            if (f29792a instanceof ReferencePattern.c) {
                linkedHashMap3.put(((ReferencePattern.c) f29792a).b, referenceMatcher2);
            } else if (f29792a instanceof ReferencePattern.e) {
                ReferencePattern.e eVar = (ReferencePattern.e) f29792a;
                Map linkedHashMap5 = (Map) linkedHashMap2.get(eVar.b);
                if (linkedHashMap5 == null) {
                    linkedHashMap5 = new LinkedHashMap();
                    linkedHashMap2.put(eVar.b, linkedHashMap5);
                }
                linkedHashMap5.put(eVar.c, referenceMatcher2);
            } else if (f29792a instanceof ReferencePattern.b) {
                ReferencePattern.b bVar = (ReferencePattern.b) f29792a;
                Map linkedHashMap6 = (Map) linkedHashMap.get(bVar.b);
                if (linkedHashMap6 == null) {
                    linkedHashMap6 = new LinkedHashMap();
                    linkedHashMap.put(bVar.b, linkedHashMap6);
                }
                linkedHashMap6.put(bVar.c, referenceMatcher2);
            } else if (f29792a instanceof ReferencePattern.d) {
                linkedHashMap4.put(((ReferencePattern.d) f29792a).b, referenceMatcher2);
            }
        }
        this.f29839a = linkedHashMap;
        this.b = linkedHashMap2;
        this.c = linkedHashMap3;
        this.d = linkedHashMap4;
        this.e = 1024;
        this.f = new LinkedHashMap();
    }

    private final cq b(c cVar) {
        if (!cVar.f && !cVar.f29842a.isEmpty()) {
            cq cqVarPoll = cVar.f29842a.poll();
            cVar.c.c(cqVarPoll.getF29852a());
            Intrinsics.checkNotNullExpressionValue(cqVarPoll, "removedNode");
            return cqVarPoll;
        }
        cVar.f = true;
        cq cqVarPoll2 = cVar.b.poll();
        cVar.d.c(cqVarPoll2.getF29852a());
        Intrinsics.checkNotNullExpressionValue(cqVarPoll2, "removedNode");
        return cqVarPoll2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void c(c cVar) throws NoWhenBranchMatchedException {
        ReferenceMatcher referenceMatcher;
        List<Pair<com.efs.sdk.memleaksdk.monitor.shark.HeapObject, GcRoot>> listA = a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObject = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject) pair.component1();
            GcRoot gcRoot = (GcRoot) pair.component2();
            if (gcRoot instanceof GcRoot.m) {
                Integer numValueOf = Integer.valueOf(((GcRoot.m) gcRoot).f29738a);
                com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVarE = heapObject.e();
                Intrinsics.checkNotNull(cVarE);
                linkedHashMap2.put(numValueOf, TuplesKt.to(cVarE, gcRoot));
                a(cVar, new cq.c.b(gcRoot.getF29741a(), gcRoot));
            } else if (gcRoot instanceof GcRoot.d) {
                Pair pair2 = (Pair) linkedHashMap2.get(Integer.valueOf(((GcRoot.d) gcRoot).f29729a));
                if (pair2 == null) {
                    a(cVar, new cq.c.b(gcRoot.getF29741a(), gcRoot));
                } else {
                    com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar2 = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) pair2.component1();
                    GcRoot.m mVar = (GcRoot.m) pair2.component2();
                    String str = (String) linkedHashMap.get(cVar2);
                    if (str == null) {
                        str = (String) new e(cVar2, this, cVar, linkedHashMap2, linkedHashMap).invoke();
                    }
                    ReferenceMatcher referenceMatcher2 = this.c.get(str);
                    if (!(referenceMatcher2 instanceof IgnoredReferenceMatcher)) {
                        cq.c.b bVar = new cq.c.b(mVar.getF29741a(), gcRoot);
                        LeakTraceReference.b bVar2 = LeakTraceReference.b.LOCAL;
                        a(cVar, referenceMatcher2 instanceof LibraryLeakReferenceMatcher ? new cq.a.C0630a(gcRoot.getF29741a(), bVar, bVar2, "", (LibraryLeakReferenceMatcher) referenceMatcher2, 0L, 32) : new cq.a.b(gcRoot.getF29741a(), bVar, bVar2, "", 0L, 16));
                    }
                }
            } else if (gcRoot instanceof GcRoot.e) {
                if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) {
                    referenceMatcher = this.d.get(((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) heapObject).f());
                } else if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) {
                    referenceMatcher = this.d.get(((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) heapObject).h());
                } else if (heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) {
                    referenceMatcher = this.d.get(((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) heapObject).f());
                } else {
                    if (!(heapObject instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.e)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    referenceMatcher = this.d.get(((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.e) heapObject).g());
                }
                if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                    if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                        a(cVar, new cq.c.a(gcRoot.getF29741a(), gcRoot, (LibraryLeakReferenceMatcher) referenceMatcher));
                    } else {
                        a(cVar, new cq.c.b(gcRoot.getF29741a(), gcRoot));
                    }
                }
            } else {
                a(cVar, new cq.c.b(gcRoot.getF29741a(), gcRoot));
            }
        }
    }

    @NotNull
    public final b a(@NotNull Set<Long> set, boolean z) {
        Intrinsics.checkNotNullParameter(set, "leakingObjectIds");
        this.h.a(OnAnalysisProgressListener.b.FINDING_PATHS_TO_RETAINED_OBJECTS);
        com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVarA = this.g.a("java.lang.Object");
        return a(new c(a(set), a(bVarA, this.g), z, bVarA != null ? bVarA.getE() : -1L, RangesKt.coerceAtLeast(this.g.c() / 2, 4)));
    }

    private final int a(com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVar, HeapGraph heapGraph) {
        if (bVar == null) {
            return 0;
        }
        int i = bVar.i();
        int iA = heapGraph.a() + PrimitiveType.INT.j;
        if (i == iA) {
            return iA;
        }
        return 0;
    }

    private final dd a(Set<Long> set) {
        dd ddVar = new dd(0, 1);
        ddVar.a(set.size());
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ddVar.a(((Number) it.next()).longValue());
        }
        return ddVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final b a(c cVar) throws NoWhenBranchMatchedException {
        c(cVar);
        ArrayList arrayList = new ArrayList();
        while (cVar.a()) {
            cq cqVarB = b(cVar);
            if (cVar.g.b(cqVarB.getF29852a())) {
                arrayList.add(cqVarB);
                if (arrayList.size() == cVar.g.a()) {
                    if (!cVar.i) {
                        break;
                    }
                    this.h.a(OnAnalysisProgressListener.b.FINDING_DOMINATORS);
                }
            }
            com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObjectA = this.g.a(cqVarB.getF29852a());
            if (heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) {
                a(cVar, (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) heapObjectA, cqVarB);
            } else if (heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) {
                a(cVar, (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) heapObjectA, cqVarB);
            } else if (heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) {
                a(cVar, (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) heapObjectA, cqVarB);
            }
        }
        d dVar = cVar.e;
        return new b(arrayList, dVar instanceof d.a ? ((d.a) dVar).f29843a : null);
    }

    private final List<Pair<com.efs.sdk.memleaksdk.monitor.shark.HeapObject, GcRoot>> a() {
        HeapObject heapObject = HeapObject.f29847a;
        List<GcRoot> listD = this.g.d();
        ArrayList<GcRoot> arrayList = new ArrayList();
        for (Object obj : listD) {
            if (this.g.c(((GcRoot) obj).getF29741a())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (GcRoot gcRoot : arrayList) {
            arrayList2.add(TuplesKt.to(this.g.a(gcRoot.getF29741a()), gcRoot));
        }
        return CollectionsKt.sortedWith(arrayList2, new f(heapObject));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void a(c cVar, com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVar, cq cqVar) throws NoWhenBranchMatchedException {
        cq c0630a;
        Map<String, ReferenceMatcher> mapEmptyMap = this.b.get(bVar.f());
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        for (HeapField heapField : bVar.p()) {
            if (heapField.c.e()) {
                String str = heapField.b;
                if (!Intrinsics.areEqual(str, "$staticOverhead") && !Intrinsics.areEqual(str, "$classOverhead")) {
                    ValueHolder valueHolder = heapField.c.f29763a;
                    if (valueHolder != null) {
                        long j = ((ValueHolder.ReferenceHolder) valueHolder).value;
                        ReferenceMatcher referenceMatcher = mapEmptyMap.get(str);
                        if (referenceMatcher == null) {
                            c0630a = new cq.a.b(j, cqVar, LeakTraceReference.b.STATIC_FIELD, str, 0L, 16);
                        } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                            c0630a = new cq.a.C0630a(j, cqVar, LeakTraceReference.b.STATIC_FIELD, str, (LibraryLeakReferenceMatcher) referenceMatcher, 0L, 32);
                        } else {
                            if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            c0630a = null;
                        }
                        if (c0630a != null) {
                            a(cVar, c0630a);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.ValueHolder.ReferenceHolder");
                    }
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void a(c cVar, com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar2, cq cqVar) throws NoWhenBranchMatchedException {
        cq c0630a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = cVar2.i().k().iterator();
        while (it.hasNext()) {
            Map<String, ReferenceMatcher> map = this.f29839a.get(((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) it.next()).f());
            if (map != null) {
                for (Map.Entry<String, ReferenceMatcher> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ReferenceMatcher value = entry.getValue();
                    if (!linkedHashMap.containsKey(key)) {
                        linkedHashMap.put(key, value);
                    }
                }
            }
        }
        List<a> listA = a(cVar2, a(cVar2.i(), cVar.j));
        if (listA.size() > 1) {
            CollectionsKt.sortWith(listA, new h());
        }
        for (a aVar : listA) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) linkedHashMap.get(aVar.c);
            if (referenceMatcher == null) {
                c0630a = new cq.a.b(aVar.b, cqVar, LeakTraceReference.b.INSTANCE_FIELD, aVar.c, aVar.f29840a);
            } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                c0630a = new cq.a.C0630a(aVar.b, cqVar, LeakTraceReference.b.INSTANCE_FIELD, aVar.c, (LibraryLeakReferenceMatcher) referenceMatcher, aVar.f29840a);
            } else {
                if (!(referenceMatcher instanceof IgnoredReferenceMatcher)) {
                    throw new NoWhenBranchMatchedException();
                }
                c0630a = null;
            }
            if (c0630a != null) {
                a(cVar, c0630a);
            }
        }
    }

    private final List<a> a(com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar, List<com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b> list) {
        HeapGraph heapGraphG = cVar.g();
        ArrayList arrayList = new ArrayList();
        ch chVar = null;
        int iA = 0;
        for (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVar : list) {
            for (HprofRecord.a.AbstractC0624a.C0625a.FieldRecord fieldRecord : bVar.o()) {
                if (fieldRecord.type != 2) {
                    iA += a(heapGraphG, fieldRecord);
                } else {
                    if (chVar == null) {
                        chVar = new ch(cVar.b(), heapGraphG.a());
                    }
                    chVar.a(iA);
                    long jA = chVar.a();
                    if (jA != 0) {
                        arrayList.add(new a(bVar.getE(), jA, bVar.a(fieldRecord)));
                    }
                    iA = 0;
                }
            }
        }
        return arrayList;
    }

    private final List<com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b> a(com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVar, long j) {
        ArrayList arrayList = new ArrayList();
        while (bVar != null && bVar.getE() != j) {
            arrayList.add(bVar);
            bVar = bVar.j();
        }
        return arrayList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final void a(c cVar, com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d dVar, cq cqVar) throws NoWhenBranchMatchedException {
        long[] jArr = dVar.b().f29780a;
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            long j = jArr[i2];
            if (j != 0 && this.g.c(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        for (Object obj : arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            a(cVar, new cq.a.b(((Number) obj).longValue(), cqVar, LeakTraceReference.b.ARRAY_ENTRY, String.valueOf(i), 0L, 16));
            i = i3;
        }
    }

    private final boolean a(com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar) {
        if (StringsKt.startsWith$default(cVar.h(), "java.util", false, 2, (Object) null) || StringsKt.startsWith$default(cVar.h(), "android.util", false, 2, (Object) null) || StringsKt.startsWith$default(cVar.h(), "java.lang.String", false, 2, (Object) null)) {
            return false;
        }
        Short sh = this.f.get(Long.valueOf(cVar.j()));
        if (sh == null) {
            sh = (short) 0;
        }
        if (sh.shortValue() < this.e) {
            this.f.put(Long.valueOf(cVar.j()), Short.valueOf((short) (sh.shortValue() + 1)));
        }
        return sh.shortValue() >= this.e;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    private final void a(c cVar, cq cqVar) throws NoWhenBranchMatchedException {
        boolean z;
        boolean z2;
        if (cqVar.getF29852a() == 0) {
            return;
        }
        boolean z3 = false;
        if (cVar.f || (cqVar instanceof cq.b) || ((cqVar instanceof cq.c) && (((cq.c) cqVar).getB() instanceof GcRoot.m))) {
            z = true;
        } else {
            if (cqVar instanceof cq.a.b) {
                cq.a.b bVar = (cq.a.b) cqVar;
                if ((bVar.getB() instanceof cq.c) && (((cq.c) bVar.getB()).getB() instanceof GcRoot.d)) {
                    z = true;
                }
            }
            z = false;
        }
        boolean zA = cVar.e.a(cqVar.getF29852a(), cqVar instanceof cq.c ? 0L : ((cq.a) cqVar).getB().getF29852a());
        if (zA && (z || cVar.c.b(cqVar.getF29852a()) || !cVar.d.b(cqVar.getF29852a()))) {
            return;
        }
        if (zA) {
            cVar.f29842a.add(cqVar);
            cVar.c.a(cqVar.getF29852a());
            for (cq cqVar2 : cVar.b) {
                if (cqVar2.getF29852a() == cqVar.getF29852a()) {
                    cVar.b.remove(cqVar2);
                    cVar.d.c(cqVar.getF29852a());
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        if (!cVar.g.b(cqVar.getF29852a())) {
            com.efs.sdk.memleaksdk.monitor.shark.HeapObject heapObjectA = this.g.a(cqVar.getF29852a());
            if (!(heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b)) {
                if (heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) {
                    com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c cVar2 = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.c) heapObjectA;
                    if (cVar2.f() || Intrinsics.areEqual(cVar2.h(), "java.lang.String") || cVar2.i().g() <= cVar.h) {
                        z3 = true;
                    } else {
                        Iterator it = cVar2.i().k().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = true;
                                break;
                            }
                            com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b bVar2 = (com.efs.sdk.memleaksdk.monitor.shark.HeapObject.b) it.next();
                            if (!(bVar2.getE() == cVar.j || !bVar2.h())) {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2 || a(cVar2)) {
                            z3 = true;
                        }
                    }
                } else {
                    if (heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) {
                        if (cp.a((com.efs.sdk.memleaksdk.monitor.shark.HeapObject.d) heapObjectA)) {
                        }
                    } else if (!(heapObjectA instanceof com.efs.sdk.memleaksdk.monitor.shark.HeapObject.e)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z3 = true;
                }
            }
            if (z3) {
                return;
            }
        }
        if (z) {
            cVar.b.add(cqVar);
            cVar.d.a(cqVar.getF29852a());
        } else {
            cVar.f29842a.add(cqVar);
            cVar.c.a(cqVar.getF29852a());
        }
    }

    private final int a(HeapGraph heapGraph, HprofRecord.a.AbstractC0624a.C0625a.FieldRecord fieldRecord) {
        int i = fieldRecord.type;
        if (i == 2) {
            return heapGraph.a();
        }
        if (i != PrimitiveType.BOOLEAN.i) {
            if (i == PrimitiveType.CHAR.i) {
                return 2;
            }
            if (i != PrimitiveType.FLOAT.i) {
                if (i != PrimitiveType.DOUBLE.i) {
                    if (i != PrimitiveType.BYTE.i) {
                        if (i == PrimitiveType.SHORT.i) {
                            return 2;
                        }
                        if (i != PrimitiveType.INT.i) {
                            if (i != PrimitiveType.LONG.i) {
                                throw new IllegalStateException("Unknown type " + fieldRecord.type);
                            }
                        }
                    }
                }
                return 8;
            }
            return 4;
        }
        return 1;
    }
}

package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005TUVWXB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015JV\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J>\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001dH\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000eH\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eH\u0002J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J$\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/0\u001f2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0011H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001eH\u0002J.\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020'2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e2\u0006\u0010;\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J,\u0010<\u001a\u00020=*\u00020>2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00107\u001a\u00020\u001eH\u0002Jh\u0010?\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u000e0\u001f*\u00020>2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u000e2\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e2 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001dH\u0002J.\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u000e*\u00020>2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000e2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eH\u0002JB\u0010I\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001d*\u00020>2\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e2\u0006\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020M*\u00020>2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001e0OJ(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e*\u00020>2\u0006\u0010Q\u001a\u00020R2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001e0OH\u0002J&\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000e0\u000e*\u00020>2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer;", "", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/OnAnalysisProgressListener;)V", "analyze", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "leakingObjectFinder", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakingObjectFinder;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectInspector;", "metadataExtractor", "Lcom/efs/sdk/memleaksdk/monitor/shark/MetadataExtractor;", "proguardMapping", "Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "buildLeakTraceObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "inspectedObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$InspectedObject;", "retainedSizes", "", "", "Lkotlin/Pair;", "", "computeLeakStatuses", "leakReporters", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectReporter;", "deduplicateShortestPaths", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$ShortestPath;", "inputPathResults", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "findResultsInTrie", "", "parentNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "outputPathResults", "", "recordClassName", "", "heap", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "resolveStatus", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "reporter", "leakingWins", "since", "analysisStartNanoTime", "updateTrie", "pathNode", "path", "pathIndex", "analyzeGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalysisSuccess;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$FindLeakInput;", "buildLeakTraces", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "shortestPaths", "inspectedObjectsByPath", "buildReferencePath", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "shortestChildPath", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "leakTraceObjects", "computeRetainedSizes", "dominatorTree", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "findLeaks", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$LeaksAndUnreachableObjects;", "leakingObjectIds", "", "findUnreachableObjects", "pathFindingResults", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/PathFinder$PathFindingResults;", "inspectObjects", "FindLeakInput", "InspectedObject", "LeaksAndUnreachableObjects", "ShortestPath", "TrieNode", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalyzer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnAnalysisProgressListener f29743a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$FindLeakInput;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectInspector;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;Ljava/util/List;ZLjava/util/List;)V", "getComputeRetainedHeapSize", "()Z", "getGraph", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "getObjectInspectors", "()Ljava/util/List;", "getReferenceMatchers", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        final HeapGraph f29744a;

        @NotNull
        final List<ReferenceMatcher> b;
        final boolean c;

        @NotNull
        final List<Object> d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull HeapGraph heapGraph, @NotNull List<? extends ReferenceMatcher> list, boolean z, @NotNull List<? extends Object> list2) {
            Intrinsics.checkNotNullParameter(heapGraph, "graph");
            Intrinsics.checkNotNullParameter(list, "referenceMatchers");
            Intrinsics.checkNotNullParameter(list2, "objectInspectors");
            this.f29744a = heapGraph;
            this.b = list;
            this.c = z;
            this.d = list2;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$b */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$InspectedObject;", "", "heapObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "leakingStatus", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "leakingStatusReason", "", "labels", "", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/util/Set;)V", "getHeapObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "getLabels", "()Ljava/util/Set;", "getLeakingStatus", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "()Ljava/lang/String;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        final HeapObject f29745a;

        @NotNull
        final LeakTraceObject.b b;

        @NotNull
        final String c;

        @NotNull
        final Set<String> d;

        public b(@NotNull HeapObject heapObject, @NotNull LeakTraceObject.b bVar, @NotNull String str, @NotNull Set<String> set) {
            Intrinsics.checkNotNullParameter(heapObject, "heapObject");
            Intrinsics.checkNotNullParameter(bVar, "leakingStatus");
            Intrinsics.checkNotNullParameter(str, "leakingStatusReason");
            Intrinsics.checkNotNullParameter(set, "labels");
            this.f29745a = heapObject;
            this.b = bVar;
            this.c = str;
            this.d = set;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$c, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$LeaksAndUnreachableObjects;", "", "applicationLeaks", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ApplicationLeak;", "libraryLeaks", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeak;", "unreachableObjects", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApplicationLeaks", "()Ljava/util/List;", "getLibraryLeaks", "getUnreachableObjects", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class LeaksAndUnreachableObjects {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from toString */
        @NotNull
        public final List<ApplicationLeak> applicationLeaks;

        /* JADX INFO: renamed from: b, reason: from toString */
        @NotNull
        private final List<LibraryLeak> libraryLeaks;

        /* JADX INFO: renamed from: c, reason: from toString */
        @NotNull
        private final List<LeakTraceObject> unreachableObjects;

        public LeaksAndUnreachableObjects(@NotNull List<ApplicationLeak> list, @NotNull List<LibraryLeak> list2, @NotNull List<LeakTraceObject> list3) {
            Intrinsics.checkNotNullParameter(list, "applicationLeaks");
            Intrinsics.checkNotNullParameter(list2, "libraryLeaks");
            Intrinsics.checkNotNullParameter(list3, "unreachableObjects");
            this.applicationLeaks = list;
            this.libraryLeaks = list2;
            this.unreachableObjects = list3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LeaksAndUnreachableObjects)) {
                return false;
            }
            LeaksAndUnreachableObjects leaksAndUnreachableObjects = (LeaksAndUnreachableObjects) other;
            return Intrinsics.areEqual(this.applicationLeaks, leaksAndUnreachableObjects.applicationLeaks) && Intrinsics.areEqual(this.libraryLeaks, leaksAndUnreachableObjects.libraryLeaks) && Intrinsics.areEqual(this.unreachableObjects, leaksAndUnreachableObjects.unreachableObjects);
        }

        public int hashCode() {
            List<ApplicationLeak> list = this.applicationLeaks;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<LibraryLeak> list2 = this.libraryLeaks;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<LeakTraceObject> list3 = this.unreachableObjects;
            return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LeaksAndUnreachableObjects(applicationLeaks=" + this.applicationLeaks + ", libraryLeaks=" + this.libraryLeaks + ", unreachableObjects=" + this.unreachableObjects + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$ShortestPath;", "", "root", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "childPath", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$ChildNode;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;Ljava/util/List;)V", "getChildPath", "()Ljava/util/List;", "getRoot", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode$RootNode;", "asList", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        final cq.c f29747a;

        @NotNull
        final List<cq.a> b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull cq.c cVar, @NotNull List<? extends cq.a> list) {
            Intrinsics.checkNotNullParameter(cVar, "root");
            Intrinsics.checkNotNullParameter(list, "childPath");
            this.f29747a = cVar;
            this.b = list;
        }

        @NotNull
        public final List<cq> a() {
            return CollectionsKt.plus(CollectionsKt.listOf(this.f29747a), this.b);
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "", "()V", "objectId", "", "getObjectId", "()J", "LeafNode", "ParentNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$LeafNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static abstract class e {

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$LeafNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "objectId", "", "pathNode", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "(JLcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;)V", "getObjectId", "()J", "getPathNode", "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ReferencePathNode;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            final cq f29748a;
            private final long b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, @NotNull cq cqVar) {
                super((byte) 0);
                Intrinsics.checkNotNullParameter(cqVar, "pathNode");
                this.b = j;
                this.f29748a = cqVar;
            }
        }

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$e$b, reason: from toString */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode;", "objectId", "", "(J)V", "children", "", "getChildren", "()Ljava/util/Map;", "getObjectId", "()J", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class ParentNode extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from toString */
            @NotNull
            final Map<Long, e> children;
            private final long b;

            public ParentNode(long j) {
                super((byte) 0);
                this.b = j;
                this.children = new LinkedHashMap();
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public long getB() {
                return this.b;
            }

            @NotNull
            public String toString() {
                return "ParentNode(objectId=" + getB() + ", children=" + this.children + ')';
            }
        }

        private e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$f */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "index", BridgeDSL.INVOKE, "(I)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class f extends Lambda implements Function1<Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f29750a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Ref.IntRef intRef) {
            super(1);
            this.f29750a = intRef;
        }

        @Nullable
        public final Integer a(int i) {
            if (i < this.f29750a.element) {
                return Integer.valueOf(i + 1);
            }
            return null;
        }

        public /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$g */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "index", BridgeDSL.INVOKE, "(I)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class g extends Lambda implements Function1<Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f29751a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Ref.IntRef intRef) {
            super(1);
            this.f29751a = intRef;
        }

        @Nullable
        public final Integer a(int i) {
            if (i > this.f29751a.element) {
                return Integer.valueOf(i - 1);
            }
            return null;
        }

        public /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$h */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "objectId", "", BridgeDSL.INVOKE, "(J)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class h extends Lambda implements Function1<Long, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f29752a;
        final /* synthetic */ cr b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Map map, cr crVar) {
            super(1);
            this.f29752a = map;
            this.b = crVar;
        }

        public final int a(long j) {
            Integer num = (Integer) this.f29752a.get(Long.valueOf(j));
            return (num != null ? num.intValue() : 0) + this.b.a(j);
        }

        public /* synthetic */ Object invoke(Object obj) {
            return Integer.valueOf(a(((Number) obj).longValue()));
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ar$i */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", BridgeDSL.INVOKE, "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapAnalyzer$TrieNode$ParentNode;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class i extends Lambda implements Function0<e.ParentNode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f29753a;
        final /* synthetic */ e.ParentNode b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(long j, e.ParentNode parentNode) {
            super(0);
            this.f29753a = j;
            this.b = parentNode;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.ParentNode invoke() {
            e.ParentNode parentNode = new e.ParentNode(this.f29753a);
            this.b.children.put(Long.valueOf(this.f29753a), parentNode);
            return parentNode;
        }
    }

    public HeapAnalyzer(@NotNull OnAnalysisProgressListener onAnalysisProgressListener) {
        Intrinsics.checkNotNullParameter(onAnalysisProgressListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.f29743a = onAnalysisProgressListener;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final List<b> b(List<ObjectReporter> list) throws NoWhenBranchMatchedException {
        int i2;
        Number number;
        LeakTraceObject.b bVar;
        LeakTraceObject.b bVar2;
        Pair pair;
        Number number2;
        LeakTraceObject.b bVar3;
        LeakTraceObject.b bVar4;
        Pair pair2;
        int size = list.size() - 1;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = size;
        ArrayList arrayList = new ArrayList();
        List<ObjectReporter> list2 = list;
        Iterator<T> it = list2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Pair<LeakTraceObject.b, String> pairA = a((ObjectReporter) it.next(), i3 == size);
            if (i3 == size) {
                int i4 = as.b[((LeakTraceObject.b) pairA.getFirst()).ordinal()];
                if (i4 != 1) {
                    if (i4 == 2) {
                        pairA = TuplesKt.to(LeakTraceObject.b.LEAKING, "This is the leaking object");
                    } else {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        pairA = TuplesKt.to(LeakTraceObject.b.LEAKING, "This is the leaking object. Conflicts with " + ((String) pairA.getSecond()));
                    }
                }
            }
            arrayList.add(pairA);
            LeakTraceObject.b bVar5 = (LeakTraceObject.b) pairA.component1();
            if (bVar5 == LeakTraceObject.b.NOT_LEAKING) {
                intRef.element = i3;
                intRef2.element = size;
            } else if (bVar5 == LeakTraceObject.b.LEAKING && intRef2.element == size) {
                intRef2.element = i3;
            }
            i3++;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(ct.a(a(((ObjectReporter) it2.next()).d), '.'));
        }
        int i5 = intRef.element;
        int i6 = 0;
        while (i6 < i5) {
            Pair pair3 = (Pair) arrayList.get(i6);
            LeakTraceObject.b bVar6 = (LeakTraceObject.b) pair3.component1();
            String str = (String) pair3.component2();
            int i7 = i6 + 1;
            Iterator it3 = SequencesKt.generateSequence(Integer.valueOf(i7), new f(intRef)).iterator();
            do {
                if (!it3.hasNext()) {
                    throw new NoSuchElementException("Sequence contains no element matching the predicate.");
                }
                number2 = (Number) it3.next();
                bVar3 = (LeakTraceObject.b) ((Pair) arrayList.get(number2.intValue())).getFirst();
                bVar4 = LeakTraceObject.b.NOT_LEAKING;
            } while (!(bVar3 == bVar4));
            String str2 = (String) arrayList2.get(number2.intValue());
            int i8 = as.c[bVar6.ordinal()];
            if (i8 == 1) {
                pair2 = TuplesKt.to(bVar4, str2 + "↓ is not leaking");
            } else if (i8 == 2) {
                pair2 = TuplesKt.to(bVar4, str2 + "↓ is not leaking and " + str);
            } else {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                pair2 = TuplesKt.to(bVar4, str2 + "↓ is not leaking. Conflicts with " + str);
            }
            arrayList.set(i6, pair2);
            i6 = i7;
        }
        int i9 = intRef2.element;
        int i10 = size - 1;
        if (i9 < i10 && i10 >= (i2 = i9 + 1)) {
            while (true) {
                Pair pair4 = (Pair) arrayList.get(i10);
                LeakTraceObject.b bVar7 = (LeakTraceObject.b) pair4.component1();
                String str3 = (String) pair4.component2();
                Iterator it4 = SequencesKt.generateSequence(Integer.valueOf(i10 - 1), new g(intRef2)).iterator();
                do {
                    if (!it4.hasNext()) {
                        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
                    }
                    number = (Number) it4.next();
                    bVar = (LeakTraceObject.b) ((Pair) arrayList.get(number.intValue())).getFirst();
                    bVar2 = LeakTraceObject.b.LEAKING;
                } while (!(bVar == bVar2));
                String str4 = (String) arrayList2.get(number.intValue());
                int i11 = as.d[bVar7.ordinal()];
                if (i11 == 1) {
                    pair = TuplesKt.to(bVar2, str4 + "↑ is leaking");
                } else {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new IllegalStateException("Should never happen");
                    }
                    pair = TuplesKt.to(bVar2, str4 + "↑ is leaking and " + str3);
                }
                arrayList.set(i10, pair);
                if (i10 == i2) {
                    break;
                }
                i10--;
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i12 = 0;
        for (Object obj : list2) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ObjectReporter objectReporter = (ObjectReporter) obj;
            Pair pair5 = (Pair) arrayList.get(i12);
            arrayList3.add(new b(objectReporter.d, (LeakTraceObject.b) pair5.component1(), (String) pair5.component2(), objectReporter.f29807a));
            i12 = i13;
        }
        return arrayList3;
    }

    @NotNull
    public final LeaksAndUnreachableObjects a(@NotNull a aVar, @NotNull Set<Long> set) {
        Intrinsics.checkNotNullParameter(aVar, "$this$findLeaks");
        Intrinsics.checkNotNullParameter(set, "leakingObjectIds");
        co.b bVarA = new co(aVar.f29744a, this.f29743a, aVar.b).a(set, aVar.c);
        List<LeakTraceObject> listA = a(aVar, bVarA, set);
        List<d> listA2 = a(bVarA.f29841a);
        List<List<b>> listA3 = a(aVar, listA2);
        cg cgVar = bVarA.b;
        Pair<List<ApplicationLeak>, List<LibraryLeak>> pairA = a(aVar, listA2, listA3, cgVar != null ? a(aVar, listA3, cgVar) : null);
        return new LeaksAndUnreachableObjects((List) pairA.component1(), (List) pairA.component2(), listA);
    }

    private final List<d> a(List<? extends cq> list) {
        e.ParentNode parentNode = new e.ParentNode(0L);
        for (cq cqVar : list) {
            ArrayList arrayList = new ArrayList();
            cq b2 = cqVar;
            while (b2 instanceof cq.a) {
                arrayList.add(0, Long.valueOf(b2.getF29852a()));
                b2 = ((cq.a) b2).getB();
            }
            arrayList.add(0, Long.valueOf(b2.getF29852a()));
            a(cqVar, arrayList, 0, parentNode);
        }
        ArrayList<cq> arrayList2 = new ArrayList();
        a(parentNode, arrayList2);
        if (arrayList2.size() != list.size()) {
            SharkLog sharkLog = SharkLog.b;
            if (SharkLog.f29817a != null) {
                list.size();
                arrayList2.size();
            }
        } else {
            SharkLog sharkLog2 = SharkLog.b;
            if (SharkLog.f29817a != null) {
                arrayList2.size();
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (cq b3 : arrayList2) {
            ArrayList arrayList4 = new ArrayList();
            while (b3 instanceof cq.a) {
                arrayList4.add(0, b3);
                b3 = ((cq.a) b3).getB();
            }
            if (b3 != null) {
                arrayList3.add(new d((cq.c) b3, arrayList4));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.efs.sdk.memleaksdk.monitor.shark.internal.ReferencePathNode.RootNode");
            }
        }
        return arrayList3;
    }

    private final void a(cq cqVar, List<Long> list, int i2, e.ParentNode parentNode) {
        while (true) {
            long jLongValue = list.get(i2).longValue();
            if (i2 == CollectionsKt.getLastIndex(list)) {
                parentNode.children.put(Long.valueOf(jLongValue), new e.a(jLongValue, cqVar));
                return;
            }
            e eVar = parentNode.children.get(Long.valueOf(jLongValue));
            if (eVar == null) {
                eVar = (e) new i(jLongValue, parentNode).invoke();
            }
            if (!(eVar instanceof e.ParentNode)) {
                return;
            }
            i2++;
            parentNode = (e.ParentNode) eVar;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final Pair<List<ApplicationLeak>, List<LibraryLeak>> a(a aVar, List<d> list, List<? extends List<b>> list2, Map<Long, Pair<Integer, Integer>> map) throws NoWhenBranchMatchedException {
        Object next;
        cq.b bVar;
        this.f29743a.a(OnAnalysisProgressListener.b.BUILDING_LEAK_TRACES);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            d dVar = (d) obj;
            List<LeakTraceObject> listA = a(list2.get(i2), map);
            LeakTrace leakTrace = new LeakTrace(LeakTrace.b.k.a(dVar.f29747a.getB()), a(aVar, dVar.b, listA), (LeakTraceObject) CollectionsKt.last(listA));
            Object obj2 = dVar.f29747a;
            if (obj2 instanceof cq.b) {
                bVar = (cq.b) obj2;
            } else {
                Iterator<T> it = dVar.b.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(((cq.a) next) instanceof cq.b));
                bVar = (cq.b) next;
            }
            if (bVar != null) {
                LibraryLeakReferenceMatcher c = bVar.getC();
                String strA = ct.a(c.getF29792a().toString());
                Object obj3 = linkedHashMap2.get(strA);
                if (obj3 == null) {
                    obj3 = TuplesKt.to(c, new ArrayList());
                    linkedHashMap2.put(strA, obj3);
                }
                ((List) ((Pair) obj3).getSecond()).add(leakTrace);
            } else {
                String strC = leakTrace.c();
                Object arrayList = linkedHashMap.get(strC);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strC, arrayList);
                }
                ((List) arrayList).add(leakTrace);
            }
            i2 = i3;
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList2.add(new ApplicationLeak((List) ((Map.Entry) it2.next()).getValue()));
        }
        ArrayList arrayList3 = new ArrayList(linkedHashMap2.size());
        Iterator it3 = linkedHashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Pair pair = (Pair) ((Map.Entry) it3.next()).getValue();
            LibraryLeakReferenceMatcher libraryLeakReferenceMatcher = (LibraryLeakReferenceMatcher) pair.component1();
            arrayList3.add(new LibraryLeak((List) pair.component2(), libraryLeakReferenceMatcher.getF29792a(), libraryLeakReferenceMatcher.f29806a));
        }
        return TuplesKt.to(arrayList2, arrayList3);
    }

    private final List<List<b>> a(a aVar, List<d> list) {
        this.f29743a.a(OnAnalysisProgressListener.b.INSPECTING_OBJECTS);
        List<d> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            List<cq> listA = ((d) it.next()).a();
            List<cq> list3 = listA;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            int i2 = 0;
            for (Object obj : list3) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ObjectReporter objectReporter = new ObjectReporter(aVar.f29744a.a(((cq) obj).getF29852a()));
                Object obj2 = i3 < listA.size() ? (cq) listA.get(i3) : null;
                if (obj2 instanceof cq.b) {
                    objectReporter.f29807a.add("Library leak match: " + ((cq.b) obj2).getC().getF29792a());
                }
                arrayList2.add(objectReporter);
                i2 = i3;
            }
            arrayList.add(arrayList2);
        }
        Iterator<T> it2 = aVar.d.iterator();
        while (it2.hasNext()) {
            it2.next();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Iterator it4 = ((List) it3.next()).iterator();
                while (it4.hasNext()) {
                    it4.next();
                }
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList3.add(b((List) it5.next()));
        }
        return arrayList3;
    }

    private final Map<Long, Pair<Integer, Integer>> a(a aVar, List<? extends List<b>> list, cg cgVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List list2 = (List) it.next();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                LeakTraceObject.b bVar = ((b) obj).b;
                if (bVar == LeakTraceObject.b.UNKNOWN || bVar == LeakTraceObject.b.LEAKING) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Long.valueOf(((b) it2.next()).f29745a.getE()));
            }
            CollectionsKt.addAll(arrayList, arrayList3);
        }
        Set<Long> set = CollectionsKt.toSet(arrayList);
        this.f29743a.a(OnAnalysisProgressListener.b.COMPUTING_NATIVE_RETAINED_SIZE);
        Map<Long, Integer> mapA = new cc(aVar.f29744a).a();
        this.f29743a.a(OnAnalysisProgressListener.b.COMPUTING_RETAINED_SIZE);
        return cgVar.a(set, new h(mapA, new cr(aVar.f29744a)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final List<LeakTraceObject> a(List<b> list, Map<Long, Pair<Integer, Integer>> map) throws NoWhenBranchMatchedException {
        LeakTraceObject.c cVar;
        List<b> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (b bVar : list2) {
            HeapObject heapObject = bVar.f29745a;
            String strA = a(heapObject);
            if (heapObject instanceof HeapObject.b) {
                cVar = LeakTraceObject.c.CLASS;
            } else if (!(heapObject instanceof HeapObject.d) && !(heapObject instanceof HeapObject.e)) {
                cVar = LeakTraceObject.c.INSTANCE;
            } else {
                cVar = LeakTraceObject.c.ARRAY;
            }
            LeakTraceObject.c cVar2 = cVar;
            Integer num = null;
            Pair<Integer, Integer> pair = map != null ? map.get(Long.valueOf(bVar.f29745a.getE())) : null;
            long e2 = heapObject.getE();
            Set<String> set = bVar.d;
            LeakTraceObject.b bVar2 = bVar.b;
            String str = bVar.c;
            Integer num2 = pair != null ? (Integer) pair.getFirst() : null;
            if (pair != null) {
                num = (Integer) pair.getSecond();
            }
            arrayList.add(new LeakTraceObject(e2, cVar2, strA, set, bVar2, str, num2, num));
        }
        return arrayList;
    }

    private final List<LeakTraceReference> a(a aVar, List<? extends cq.a> list, List<LeakTraceObject> list2) {
        String strF;
        List<? extends cq.a> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        int i2 = 0;
        for (Object obj : list3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            cq.a aVar2 = (cq.a) obj;
            LeakTraceObject leakTraceObject = list2.get(i2);
            LeakTraceReference.b c = aVar2.getC();
            if (aVar2.getE() != 0) {
                HeapObject.b bVarD = aVar.f29744a.a(aVar2.getE()).d();
                Intrinsics.checkNotNull(bVarD);
                strF = bVarD.f();
            } else {
                strF = list2.get(i2).b;
            }
            arrayList.add(new LeakTraceReference(leakTraceObject, c, strF, aVar2.getD()));
            i2 = i3;
        }
        return arrayList;
    }

    private final Pair<LeakTraceObject.b, String> a(ObjectReporter objectReporter, boolean z) {
        String strJoinToString$default;
        LeakTraceObject.b bVar = LeakTraceObject.b.UNKNOWN;
        if (!objectReporter.c.isEmpty()) {
            bVar = LeakTraceObject.b.NOT_LEAKING;
            strJoinToString$default = CollectionsKt.joinToString$default(objectReporter.c, " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } else {
            strJoinToString$default = "";
        }
        Set<String> set = objectReporter.b;
        if (!set.isEmpty()) {
            String strJoinToString$default2 = CollectionsKt.joinToString$default(set, " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (bVar != LeakTraceObject.b.NOT_LEAKING) {
                bVar = LeakTraceObject.b.LEAKING;
                strJoinToString$default = strJoinToString$default2;
            } else if (z) {
                bVar = LeakTraceObject.b.LEAKING;
                strJoinToString$default = strJoinToString$default2 + ". Conflicts with " + strJoinToString$default;
            } else {
                strJoinToString$default = strJoinToString$default + ". Conflicts with " + strJoinToString$default2;
            }
        }
        return TuplesKt.to(bVar, strJoinToString$default);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final String a(HeapObject heapObject) throws NoWhenBranchMatchedException {
        if (heapObject instanceof HeapObject.b) {
            return ((HeapObject.b) heapObject).f();
        }
        if (heapObject instanceof HeapObject.c) {
            return ((HeapObject.c) heapObject).h();
        }
        if (heapObject instanceof HeapObject.d) {
            return ((HeapObject.d) heapObject).f();
        }
        if (heapObject instanceof HeapObject.e) {
            return ((HeapObject.e) heapObject).g();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final List<LeakTraceObject> a(a aVar, co.b bVar, Set<Long> set) throws NoWhenBranchMatchedException {
        List<cq> list = bVar.f29841a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((cq) it.next()).getF29852a()));
        }
        Set setMinus = SetsKt.minus(set, CollectionsKt.toSet(arrayList));
        ArrayList<ObjectReporter> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setMinus, 10));
        Iterator it2 = setMinus.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new ObjectReporter(aVar.f29744a.a(((Number) it2.next()).longValue())));
        }
        Iterator<T> it3 = aVar.d.iterator();
        while (it3.hasNext()) {
            it3.next();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ObjectReporter objectReporter : arrayList2) {
            Pair<LeakTraceObject.b, String> pairA = a(objectReporter, true);
            LeakTraceObject.b bVar2 = (LeakTraceObject.b) pairA.component1();
            String str = (String) pairA.component2();
            int i2 = as.f29754a[bVar2.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    str = "This is a leaking object";
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "This is a leaking object. Conflicts with " + str;
                }
            }
            arrayList3.add(new b(objectReporter.d, LeakTraceObject.b.LEAKING, str, objectReporter.f29807a));
        }
        return a(arrayList3, (Map<Long, Pair<Integer, Integer>>) null);
    }

    private final void a(e.ParentNode parentNode, List<cq> list) {
        for (e eVar : parentNode.children.values()) {
            if (eVar instanceof e.ParentNode) {
                a((e.ParentNode) eVar, list);
            } else if (eVar instanceof e.a) {
                list.add(((e.a) eVar).f29748a);
            }
        }
    }
}

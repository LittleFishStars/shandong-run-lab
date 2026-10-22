package com.efs.sdk.memleaksdk.monitor.shark;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\fJ@\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e0\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree;", "", "expectedElements", "", "(I)V", "dominated", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap;", "buildFullDominatorTree", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ObjectDominators$DominatorNode;", "computeSize", "Lkotlin/Function1;", "computeRetainedSizes", "Lkotlin/Pair;", "retainedObjectIds", "", "updateDominated", "", "objectId", "parentObjectId", "updateDominatedAsRoot", "MutableDominatorNode", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final da f29825a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/efs/sdk/memleaksdk/monitor/shark/internal/DominatorTree$computeRetainedSizes$2", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap$ForEachCallback;", "onEntry", "", CachedContentIndex.a.e, "", "value", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a implements da.a {
        final /* synthetic */ Map b;
        final /* synthetic */ Function1 c;

        public a(Map map, Function1 function1) {
            this.b = map;
            this.c = function1;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.internal.da.a
        public void a(long j, long j2) {
            int iIntValue;
            Pair pair = (Pair) this.b.get(Long.valueOf(j));
            if (pair != null) {
                int iIntValue2 = ((Number) pair.component1()).intValue();
                int iIntValue3 = ((Number) pair.component2()).intValue();
                iIntValue = ((Number) this.c.invoke(Long.valueOf(j))).intValue();
                this.b.put(Long.valueOf(j), TuplesKt.to(Integer.valueOf(iIntValue2 + iIntValue), Integer.valueOf(iIntValue3 + 1)));
            } else {
                iIntValue = -1;
            }
            if (j2 != 0) {
                List listMutableListOf = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(j)});
                while (j2 != 0) {
                    if (this.b.containsKey(Long.valueOf(j2))) {
                        Iterator it = listMutableListOf.iterator();
                        while (it.hasNext()) {
                            cg.this.f29825a.a(((Number) it.next()).longValue(), j2);
                        }
                        if (iIntValue == -1) {
                            iIntValue = ((Number) this.c.invoke(Long.valueOf(j))).intValue();
                        }
                        Pair pair2 = (Pair) MapsKt.getValue(this.b, Long.valueOf(j2));
                        this.b.put(Long.valueOf(j2), TuplesKt.to(Integer.valueOf(((Number) pair2.component1()).intValue() + iIntValue), Integer.valueOf(((Number) pair2.component2()).intValue() + 1)));
                        listMutableListOf.clear();
                    } else {
                        listMutableListOf.add(Long.valueOf(j2));
                    }
                    j2 = cg.this.f29825a.b(j2);
                }
                Iterator it2 = listMutableListOf.iterator();
                while (it2.hasNext()) {
                    cg.this.f29825a.a(((Number) it2.next()).longValue(), 0L);
                }
            }
        }
    }

    public cg() {
        this(0, 1);
    }

    public cg(int i) {
        this.f29825a = new da(i);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ad  */
    public final boolean a(long j, long j2) {
        int iA = this.f29825a.a(j);
        boolean z = iA != -1;
        if (z) {
            if (j2 == 0) {
                this.f29825a.a(j, j2);
            } else {
                long j3 = this.f29825a.b[iA];
                if (j3 != 0) {
                    dd ddVar = new dd(0, 1);
                    long j4 = j3;
                    for (long j5 = 0; j4 != j5; j5 = 0) {
                        ddVar.a(j4);
                        int iA2 = this.f29825a.a(j4);
                        if (iA2 == -1) {
                            throw new IllegalStateException("Did not find dominator for " + j4 + " when going through the dominator chain for " + j3 + ": " + ddVar);
                        }
                        j4 = this.f29825a.b[iA2];
                    }
                    long j6 = j2;
                    while (j6 != 0 && !ddVar.b(j6)) {
                        int iA3 = this.f29825a.a(j6);
                        if (iA3 == -1) {
                            throw new IllegalStateException("Did not find dominator for " + j6 + " when going through the dominator chain for " + j2);
                        }
                        j6 = this.f29825a.b[iA3];
                    }
                    this.f29825a.a(j, j6);
                }
            }
        } else {
            this.f29825a.a(j, j2);
        }
        return z;
    }

    public /* synthetic */ cg(int i, int i2) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    @NotNull
    public final Map<Long, Pair<Integer, Integer>> a(@NotNull Set<Long> set, @NotNull Function1<? super Long, Integer> function1) {
        Intrinsics.checkNotNullParameter(set, "retainedObjectIds");
        Intrinsics.checkNotNullParameter(function1, "computeSize");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Long.valueOf(((Number) it.next()).longValue()), TuplesKt.to(0, 0));
        }
        this.f29825a.a(new a(linkedHashMap, function1));
        this.f29825a.c();
        return linkedHashMap;
    }
}

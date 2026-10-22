package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractGraph<N> extends AbstractBaseGraph<N> implements Graph<N> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int d(Object obj) {
        return super.d(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return super.e(obj);
    }

    @Override // com.google.common.graph.Graph
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Graph)) {
            return false;
        }
        Graph graph = (Graph) obj;
        return j() == graph.j() && f().equals(graph.f()) && i().equals(graph.i());
    }

    @Override // com.google.common.graph.Graph
    public final int hashCode() {
        return i().hashCode();
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set i() {
        return super.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean l(EndpointPair endpointPair) {
        return super.l(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int p(Object obj) {
        return super.p(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ ElementOrder s() {
        return super.s();
    }

    public String toString() {
        boolean zJ = j();
        boolean zG = g();
        String strValueOf = String.valueOf(f());
        String strValueOf2 = String.valueOf(i());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 59 + strValueOf2.length());
        sb.append("isDirected: ");
        sb.append(zJ);
        sb.append(", allowsSelfLoops: ");
        sb.append(zG);
        sb.append(", nodes: ");
        sb.append(strValueOf);
        sb.append(", edges: ");
        sb.append(strValueOf2);
        return sb.toString();
    }
}

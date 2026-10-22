package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseGraph<N> f32081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final N f6275a;

    public IncidentEdgeSet(BaseGraph<N> baseGraph, N n) {
        this.f32081a = baseGraph;
        this.f6275a = n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.f32081a.j()) {
            if (!endpointPair.b()) {
                return false;
            }
            Object objI = endpointPair.i();
            Object objJ = endpointPair.j();
            return (this.f6275a.equals(objI) && this.f32081a.b(this.f6275a).contains(objJ)) || (this.f6275a.equals(objJ) && this.f32081a.a(this.f6275a).contains(objI));
        }
        if (endpointPair.b()) {
            return false;
        }
        Set<N> setO = this.f32081a.o(this.f6275a);
        Object objD = endpointPair.d();
        Object objE = endpointPair.e();
        return (this.f6275a.equals(objE) && setO.contains(objD)) || (this.f6275a.equals(objD) && setO.contains(objE));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f32081a.j() ? (this.f32081a.p(this.f6275a) + this.f32081a.d(this.f6275a)) - (this.f32081a.b(this.f6275a).contains(this.f6275a) ? 1 : 0) : this.f32081a.o(this.f6275a).size();
    }
}

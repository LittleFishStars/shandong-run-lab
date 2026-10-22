package com.ltmb.ltadsdk.api.ad;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u0017\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\n\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\r\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/AdPair;", "A", "B", "Ljava/io/Serializable;", "", "toString", "a", "Ljava/lang/Object;", "getFirst", "()Ljava/lang/Object;", "first", "b", "getSecond", "second", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdPair<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final A first;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final B second;

    public AdPair(A a2, B b) {
        this.first = a2;
        this.second = b;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    @NotNull
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}

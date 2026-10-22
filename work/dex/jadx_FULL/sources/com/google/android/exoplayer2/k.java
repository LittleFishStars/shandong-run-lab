package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;
import com.zj.adlib.gj9;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k extends AbstractConcatenatedTimeline {
    public final int O;
    public final int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Object, Integer> f30758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline[] f3401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f3402a;
    public final int[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int iV = 0;
        int size = collection.size();
        this.f3400a = new int[size];
        this.b = new int[size];
        this.f3401a = new Timeline[size];
        this.f3402a = new Object[size];
        this.f30758a = new HashMap<>();
        int iM = 0;
        int i = 0;
        for (MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.f3401a[i] = mediaSourceInfoHolder.a();
            this.b[i] = iV;
            this.f3400a[i] = iM;
            iV += this.f3401a[i].v();
            iM += this.f3401a[i].m();
            this.f3402a[i] = mediaSourceInfoHolder.getUid();
            this.f30758a.put(this.f3402a[i], Integer.valueOf(i));
            i++;
        }
        this.O = iV;
        this.P = iM;
    }

    public List<Timeline> F() {
        return Arrays.asList(this.f3401a);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByChildUid(Object obj) {
        Integer num = this.f30758a.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByPeriodIndex(int i) {
        return gj9.i(this.f3400a, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByWindowIndex(int i) {
        return gj9.i(this.b, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public Object getChildUidByChildIndex(int i) {
        return this.f3402a[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstPeriodIndexByChildIndex(int i) {
        return this.f3400a[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstWindowIndexByChildIndex(int i) {
        return this.b[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public Timeline getTimelineByChildIndex(int i) {
        return this.f3401a[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int m() {
        return this.P;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int v() {
        return this.O;
    }
}

package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractConcatenatedTimeline extends Timeline {
    public final int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShuffleOrder f30470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1970a;

    public AbstractConcatenatedTimeline(boolean z, ShuffleOrder shuffleOrder) {
        this.f1970a = z;
        this.f30470a = shuffleOrder;
        this.N = shuffleOrder.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object B(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object C(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public final int D(int i, boolean z) {
        if (z) {
            return this.f30470a.getNextIndex(i);
        }
        if (i < this.N - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int E(int i, boolean z) {
        if (z) {
            return this.f30470a.getPreviousIndex(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int e(boolean z) {
        if (this.N == 0) {
            return -1;
        }
        if (this.f1970a) {
            z = false;
        }
        int firstIndex = z ? this.f30470a.getFirstIndex() : 0;
        while (getTimelineByChildIndex(firstIndex).w()) {
            firstIndex = D(firstIndex, z);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(firstIndex) + getTimelineByChildIndex(firstIndex).e(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final int f(Object obj) {
        int iF;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objB = B(obj);
        Object objA = A(obj);
        int childIndexByChildUid = getChildIndexByChildUid(objB);
        if (childIndexByChildUid == -1 || (iF = getTimelineByChildIndex(childIndexByChildUid).f(objA)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + iF;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int g(boolean z) {
        int i = this.N;
        if (i == 0) {
            return -1;
        }
        if (this.f1970a) {
            z = false;
        }
        int lastIndex = z ? this.f30470a.getLastIndex() : i - 1;
        while (getTimelineByChildIndex(lastIndex).w()) {
            lastIndex = E(lastIndex, z);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).g(z);
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i);

    public abstract int getChildIndexByWindowIndex(int i);

    public abstract Object getChildUidByChildIndex(int i);

    public abstract int getFirstPeriodIndexByChildIndex(int i);

    public abstract int getFirstWindowIndexByChildIndex(int i);

    public abstract Timeline getTimelineByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public int i(int i, int i2, boolean z) {
        if (this.f1970a) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int i3 = getTimelineByChildIndex(childIndexByWindowIndex).i(i - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z);
        if (i3 != -1) {
            return firstWindowIndexByChildIndex + i3;
        }
        int iD = D(childIndexByWindowIndex, z);
        while (iD != -1 && getTimelineByChildIndex(iD).w()) {
            iD = D(iD, z);
        }
        if (iD != -1) {
            return getFirstWindowIndexByChildIndex(iD) + getTimelineByChildIndex(iD).e(z);
        }
        if (i2 == 2) {
            return e(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.b k(int i, Timeline.b bVar, boolean z) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).k(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), bVar, z);
        bVar.K += firstWindowIndexByChildIndex;
        if (z) {
            bVar.f2194b = C(getChildUidByChildIndex(childIndexByPeriodIndex), sb0.g(bVar.f2194b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.b l(Object obj, Timeline.b bVar) {
        Object objB = B(obj);
        Object objA = A(obj);
        int childIndexByChildUid = getChildIndexByChildUid(objB);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).l(objA, bVar);
        bVar.K += firstWindowIndexByChildIndex;
        bVar.f2194b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int r(int i, int i2, boolean z) {
        if (this.f1970a) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int iR = getTimelineByChildIndex(childIndexByWindowIndex).r(i - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z);
        if (iR != -1) {
            return firstWindowIndexByChildIndex + iR;
        }
        int iE = E(childIndexByWindowIndex, z);
        while (iE != -1 && getTimelineByChildIndex(iE).w()) {
            iE = E(iE, z);
        }
        if (iE != -1) {
            return getFirstWindowIndexByChildIndex(iE) + getTimelineByChildIndex(iE).g(z);
        }
        if (i2 == 2) {
            return g(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Object s(int i) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        return C(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).s(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.d u(int i, Timeline.d dVar, long j) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).u(i - firstWindowIndexByChildIndex, dVar, j);
        Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!Timeline.d.d.equals(dVar.f2200a)) {
            childUidByChildIndex = C(childUidByChildIndex, dVar.f2200a);
        }
        dVar.f2200a = childUidByChildIndex;
        dVar.K += firstPeriodIndexByChildIndex;
        dVar.L += firstPeriodIndexByChildIndex;
        return dVar;
    }
}

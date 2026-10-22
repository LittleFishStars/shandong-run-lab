package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/run/bean/SunshineRankingData;", "", "myRank", "Lcom/huachenjie/run/bean/RankItemData;", "rankList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rankUpdateTime", "", "(Lcom/huachenjie/run/bean/RankItemData;Ljava/util/ArrayList;J)V", "getMyRank", "()Lcom/huachenjie/run/bean/RankItemData;", "getRankList", "()Ljava/util/ArrayList;", "getRankUpdateTime", "()J", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SunshineRankingData {

    @Nullable
    private final RankItemData myRank;

    @Nullable
    private final ArrayList<RankItemData> rankList;
    private final long rankUpdateTime;

    public SunshineRankingData(@Nullable RankItemData rankItemData, @Nullable ArrayList<RankItemData> arrayList, long j) {
        this.myRank = rankItemData;
        this.rankList = arrayList;
        this.rankUpdateTime = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SunshineRankingData copy$default(SunshineRankingData sunshineRankingData, RankItemData rankItemData, ArrayList arrayList, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            rankItemData = sunshineRankingData.myRank;
        }
        if ((i & 2) != 0) {
            arrayList = sunshineRankingData.rankList;
        }
        if ((i & 4) != 0) {
            j = sunshineRankingData.rankUpdateTime;
        }
        return sunshineRankingData.copy(rankItemData, arrayList, j);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RankItemData getMyRank() {
        return this.myRank;
    }

    @Nullable
    public final ArrayList<RankItemData> component2() {
        return this.rankList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getRankUpdateTime() {
        return this.rankUpdateTime;
    }

    @NotNull
    public final SunshineRankingData copy(@Nullable RankItemData myRank, @Nullable ArrayList<RankItemData> rankList, long rankUpdateTime) {
        return new SunshineRankingData(myRank, rankList, rankUpdateTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SunshineRankingData)) {
            return false;
        }
        SunshineRankingData sunshineRankingData = (SunshineRankingData) other;
        return Intrinsics.areEqual(this.myRank, sunshineRankingData.myRank) && Intrinsics.areEqual(this.rankList, sunshineRankingData.rankList) && this.rankUpdateTime == sunshineRankingData.rankUpdateTime;
    }

    @Nullable
    public final RankItemData getMyRank() {
        return this.myRank;
    }

    @Nullable
    public final ArrayList<RankItemData> getRankList() {
        return this.rankList;
    }

    public final long getRankUpdateTime() {
        return this.rankUpdateTime;
    }

    public int hashCode() {
        RankItemData rankItemData = this.myRank;
        int iHashCode = (rankItemData == null ? 0 : rankItemData.hashCode()) * 31;
        ArrayList<RankItemData> arrayList = this.rankList;
        return ((iHashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31) + Long.hashCode(this.rankUpdateTime);
    }

    @NotNull
    public String toString() {
        return "SunshineRankingData(myRank=" + this.myRank + ", rankList=" + this.rankList + ", rankUpdateTime=" + this.rankUpdateTime + ')';
    }

    public /* synthetic */ SunshineRankingData(RankItemData rankItemData, ArrayList arrayList, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rankItemData, arrayList, (i & 4) != 0 ? 0L : j);
    }
}

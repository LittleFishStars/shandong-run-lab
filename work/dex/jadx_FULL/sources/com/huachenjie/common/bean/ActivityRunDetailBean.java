package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u0099\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u00106\u001a\u00020\nHÖ\u0001J\u0013\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 ¨\u0006A"}, d2 = {"Lcom/huachenjie/common/bean/ActivityRunDetailBean;", "Landroid/os/Parcelable;", "activityName", "", "activityCode", "", "date", "dateList", "", "joinCount", "", "ruleList", "Lcom/huachenjie/common/bean/ActivityRunRule;", "status", "", "totalCount", "singleMaxDistance", "singleMinDistance", "activityMaxPace", "activityMinPace", "runPlanName", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;ILjava/util/List;ZIJJJJLjava/lang/String;)V", "getActivityCode", "()J", "getActivityMaxPace", "getActivityMinPace", "getActivityName", "()Ljava/lang/String;", "getDate", "getDateList", "()Ljava/util/List;", "getJoinCount", "()I", "getRuleList", "getRunPlanName", "getSingleMaxDistance", "getSingleMinDistance", "getStatus", "()Z", "getTotalCount", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActivityRunDetailBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ActivityRunDetailBean> CREATOR = new Creator();
    private final long activityCode;
    private final long activityMaxPace;
    private final long activityMinPace;

    @NotNull
    private final String activityName;

    @NotNull
    private final String date;

    @NotNull
    private final List<String> dateList;
    private final int joinCount;

    @NotNull
    private final List<ActivityRunRule> ruleList;

    @Nullable
    private final String runPlanName;
    private final long singleMaxDistance;
    private final long singleMinDistance;
    private final boolean status;
    private final int totalCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActivityRunDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActivityRunDetailBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            long j = parcel.readLong();
            String string2 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(ActivityRunRule.CREATOR.createFromParcel(parcel));
            }
            return new ActivityRunDetailBean(string, j, string2, arrayListCreateStringArrayList, i, arrayList, parcel.readInt() != 0, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActivityRunDetailBean[] newArray(int i) {
            return new ActivityRunDetailBean[i];
        }
    }

    public ActivityRunDetailBean(@NotNull String str, long j, @NotNull String str2, @NotNull List<String> list, int i, @NotNull List<ActivityRunRule> list2, boolean z, int i2, long j2, long j3, long j4, long j5, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "activityName");
        Intrinsics.checkNotNullParameter(str2, "date");
        Intrinsics.checkNotNullParameter(list, "dateList");
        Intrinsics.checkNotNullParameter(list2, "ruleList");
        this.activityName = str;
        this.activityCode = j;
        this.date = str2;
        this.dateList = list;
        this.joinCount = i;
        this.ruleList = list2;
        this.status = z;
        this.totalCount = i2;
        this.singleMaxDistance = j2;
        this.singleMinDistance = j3;
        this.activityMaxPace = j4;
        this.activityMinPace = j5;
        this.runPlanName = str3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getSingleMinDistance() {
        return this.singleMinDistance;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getActivityMaxPace() {
        return this.activityMaxPace;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getActivityMinPace() {
        return this.activityMinPace;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getActivityCode() {
        return this.activityCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final List<String> component4() {
        return this.dateList;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getJoinCount() {
        return this.joinCount;
    }

    @NotNull
    public final List<ActivityRunRule> component6() {
        return this.ruleList;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getSingleMaxDistance() {
        return this.singleMaxDistance;
    }

    @NotNull
    public final ActivityRunDetailBean copy(@NotNull String activityName, long activityCode, @NotNull String date, @NotNull List<String> dateList, int joinCount, @NotNull List<ActivityRunRule> ruleList, boolean status, int totalCount, long singleMaxDistance, long singleMinDistance, long activityMaxPace, long activityMinPace, @Nullable String runPlanName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(dateList, "dateList");
        Intrinsics.checkNotNullParameter(ruleList, "ruleList");
        return new ActivityRunDetailBean(activityName, activityCode, date, dateList, joinCount, ruleList, status, totalCount, singleMaxDistance, singleMinDistance, activityMaxPace, activityMinPace, runPlanName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityRunDetailBean)) {
            return false;
        }
        ActivityRunDetailBean activityRunDetailBean = (ActivityRunDetailBean) other;
        return Intrinsics.areEqual(this.activityName, activityRunDetailBean.activityName) && this.activityCode == activityRunDetailBean.activityCode && Intrinsics.areEqual(this.date, activityRunDetailBean.date) && Intrinsics.areEqual(this.dateList, activityRunDetailBean.dateList) && this.joinCount == activityRunDetailBean.joinCount && Intrinsics.areEqual(this.ruleList, activityRunDetailBean.ruleList) && this.status == activityRunDetailBean.status && this.totalCount == activityRunDetailBean.totalCount && this.singleMaxDistance == activityRunDetailBean.singleMaxDistance && this.singleMinDistance == activityRunDetailBean.singleMinDistance && this.activityMaxPace == activityRunDetailBean.activityMaxPace && this.activityMinPace == activityRunDetailBean.activityMinPace && Intrinsics.areEqual(this.runPlanName, activityRunDetailBean.runPlanName);
    }

    public final long getActivityCode() {
        return this.activityCode;
    }

    public final long getActivityMaxPace() {
        return this.activityMaxPace;
    }

    public final long getActivityMinPace() {
        return this.activityMinPace;
    }

    @NotNull
    public final String getActivityName() {
        return this.activityName;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final List<String> getDateList() {
        return this.dateList;
    }

    public final int getJoinCount() {
        return this.joinCount;
    }

    @NotNull
    public final List<ActivityRunRule> getRuleList() {
        return this.ruleList;
    }

    @Nullable
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    public final long getSingleMaxDistance() {
        return this.singleMaxDistance;
    }

    public final long getSingleMinDistance() {
        return this.singleMinDistance;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int iHashCode = ((((((((((this.activityName.hashCode() * 31) + Long.hashCode(this.activityCode)) * 31) + this.date.hashCode()) * 31) + this.dateList.hashCode()) * 31) + Integer.hashCode(this.joinCount)) * 31) + this.ruleList.hashCode()) * 31;
        boolean z = this.status;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((iHashCode + r1) * 31) + Integer.hashCode(this.totalCount)) * 31) + Long.hashCode(this.singleMaxDistance)) * 31) + Long.hashCode(this.singleMinDistance)) * 31) + Long.hashCode(this.activityMaxPace)) * 31) + Long.hashCode(this.activityMinPace)) * 31;
        String str = this.runPlanName;
        return iHashCode2 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "ActivityRunDetailBean(activityName=" + this.activityName + ", activityCode=" + this.activityCode + ", date=" + this.date + ", dateList=" + this.dateList + ", joinCount=" + this.joinCount + ", ruleList=" + this.ruleList + ", status=" + this.status + ", totalCount=" + this.totalCount + ", singleMaxDistance=" + this.singleMaxDistance + ", singleMinDistance=" + this.singleMinDistance + ", activityMaxPace=" + this.activityMaxPace + ", activityMinPace=" + this.activityMinPace + ", runPlanName=" + this.runPlanName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityName);
        parcel.writeLong(this.activityCode);
        parcel.writeString(this.date);
        parcel.writeStringList(this.dateList);
        parcel.writeInt(this.joinCount);
        List<ActivityRunRule> list = this.ruleList;
        parcel.writeInt(list.size());
        Iterator<ActivityRunRule> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.status ? 1 : 0);
        parcel.writeInt(this.totalCount);
        parcel.writeLong(this.singleMaxDistance);
        parcel.writeLong(this.singleMinDistance);
        parcel.writeLong(this.activityMaxPace);
        parcel.writeLong(this.activityMinPace);
        parcel.writeString(this.runPlanName);
    }

    public /* synthetic */ ActivityRunDetailBean(String str, long j, String str2, List list, int i, List list2, boolean z, int i2, long j2, long j3, long j4, long j5, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? "" : str2, list, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? new ArrayList() : list2, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? 0 : i2, (i3 & 256) != 0 ? 0L : j2, (i3 & 512) != 0 ? 0L : j3, (i3 & 1024) != 0 ? 0L : j4, (i3 & 2048) != 0 ? 0L : j5, (i3 & 4096) == 0 ? str3 : "");
    }
}

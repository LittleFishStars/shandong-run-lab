package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.R;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020!J\u0006\u0010+\u001a\u00020!J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006-"}, d2 = {"Lcom/huachenjie/college/bean/PointActivityBean;", "", "activityNo", "", "name", "description", "mainImageUrl", "activityType", "status", "activityStart", "", "activityEnd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getActivityEnd", "()J", "getActivityNo", "()Ljava/lang/String;", "getActivityStart", "getActivityType", "getDescription", "getMainImageUrl", "getName", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "", "other", "formatterDesColor", "formatterStatusBgColor", "formatterStatusColor", "formatterStatusName", "hashCode", "", "isEndedStatus", "isNotStartingStatus", "isStartingStatus", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PointActivityBean {
    private final long activityEnd;

    @NotNull
    private final String activityNo;
    private final long activityStart;

    @NotNull
    private final String activityType;

    @NotNull
    private final String description;

    @NotNull
    private final String mainImageUrl;

    @NotNull
    private final String name;

    @NotNull
    private final String status;

    public PointActivityBean() {
        this(null, null, null, null, null, null, 0L, 0L, 255, null);
    }

    public PointActivityBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "activityNo");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "mainImageUrl");
        Intrinsics.checkNotNullParameter(str5, "activityType");
        Intrinsics.checkNotNullParameter(str6, "status");
        this.activityNo = str;
        this.name = str2;
        this.description = str3;
        this.mainImageUrl = str4;
        this.activityType = str5;
        this.status = str6;
        this.activityStart = j;
        this.activityEnd = j2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityNo() {
        return this.activityNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMainImageUrl() {
        return this.mainImageUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getActivityType() {
        return this.activityType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getActivityStart() {
        return this.activityStart;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getActivityEnd() {
        return this.activityEnd;
    }

    @NotNull
    public final PointActivityBean copy(@NotNull String activityNo, @NotNull String name, @NotNull String description, @NotNull String mainImageUrl, @NotNull String activityType, @NotNull String status, long activityStart, long activityEnd) {
        Intrinsics.checkNotNullParameter(activityNo, "activityNo");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(mainImageUrl, "mainImageUrl");
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new PointActivityBean(activityNo, name, description, mainImageUrl, activityType, status, activityStart, activityEnd);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointActivityBean)) {
            return false;
        }
        PointActivityBean pointActivityBean = (PointActivityBean) other;
        return Intrinsics.areEqual(this.activityNo, pointActivityBean.activityNo) && Intrinsics.areEqual(this.name, pointActivityBean.name) && Intrinsics.areEqual(this.description, pointActivityBean.description) && Intrinsics.areEqual(this.mainImageUrl, pointActivityBean.mainImageUrl) && Intrinsics.areEqual(this.activityType, pointActivityBean.activityType) && Intrinsics.areEqual(this.status, pointActivityBean.status) && this.activityStart == pointActivityBean.activityStart && this.activityEnd == pointActivityBean.activityEnd;
    }

    @NotNull
    public final String formatterDesColor() {
        return isStartingStatus() ? "#2c3e50" : "#C1C1C1";
    }

    @NotNull
    public final String formatterStatusBgColor() {
        return isStartingStatus() ? "#FFFFFF" : "#80000000";
    }

    @NotNull
    public final String formatterStatusColor() {
        return isStartingStatus() ? "#00C97C" : "#FFFFFF";
    }

    @NotNull
    public final String formatterStatusName() {
        String str = this.status;
        int iHashCode = str.hashCode();
        if (iHashCode != -1391247659) {
            if (iHashCode != -600583333) {
                if (iHashCode == 66114202 && str.equals("ENDED")) {
                    String strE = ys8.e(R.string.college_point_activity_list_end);
                    Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.colle…_point_activity_list_end)");
                    return strE;
                }
            } else if (str.equals("ONGOING")) {
                String strE2 = ys8.e(R.string.college_point_activity_list_starting);
                Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.colle…t_activity_list_starting)");
                return strE2;
            }
        } else if (str.equals("NOT_STARTED")) {
            String strE3 = ys8.e(R.string.college_point_activity_list_no_start);
            Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.colle…t_activity_list_no_start)");
            return strE3;
        }
        return "";
    }

    public final long getActivityEnd() {
        return this.activityEnd;
    }

    @NotNull
    public final String getActivityNo() {
        return this.activityNo;
    }

    public final long getActivityStart() {
        return this.activityStart;
    }

    @NotNull
    public final String getActivityType() {
        return this.activityType;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getMainImageUrl() {
        return this.mainImageUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((((((this.activityNo.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.mainImageUrl.hashCode()) * 31) + this.activityType.hashCode()) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.activityStart)) * 31) + Long.hashCode(this.activityEnd);
    }

    public final boolean isEndedStatus() {
        return Intrinsics.areEqual(this.status, "ENDED");
    }

    public final boolean isNotStartingStatus() {
        return Intrinsics.areEqual(this.status, "NOT_STARTED");
    }

    public final boolean isStartingStatus() {
        return Intrinsics.areEqual(this.status, "ONGOING");
    }

    @NotNull
    public String toString() {
        return "PointActivityBean(activityNo=" + this.activityNo + ", name=" + this.name + ", description=" + this.description + ", mainImageUrl=" + this.mainImageUrl + ", activityType=" + this.activityType + ", status=" + this.status + ", activityStart=" + this.activityStart + ", activityEnd=" + this.activityEnd + ')';
    }

    public /* synthetic */ PointActivityBean(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? j2 : 0L);
    }
}

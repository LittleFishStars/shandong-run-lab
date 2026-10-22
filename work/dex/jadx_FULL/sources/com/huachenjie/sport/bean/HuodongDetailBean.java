package com.huachenjie.sport.bean;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.zj.adlib.h46;
import com.zj.adlib.ll7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0010HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u001aHÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\fHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003JÓ\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001aHÆ\u0001J\u0013\u0010N\u001a\u00020\u001a2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010P\u001a\u00020\fJ\u0006\u0010Q\u001a\u00020\u0003J\t\u0010R\u001a\u00020\fHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001d¨\u0006T"}, d2 = {"Lcom/huachenjie/sport/bean/HuodongDetailBean;", "", "activityCode", "", "activityStartTime", "", "activityEndTime", "signUpStartTime", "signUpEndTime", "activityOrganizer", "activityRule", "activityStatus", "", "activityTitle", "coverImage", "detail", "Lcom/huachenjie/sport/bean/HuodongDetail;", RequestParameters.SUBRESOURCE_LOCATION, "signUpCount", "signUpLimit", "signUpRemainTime", "signUpStatus", "activityType", "activityFenceCode", FreeRunActivity.y, "runFlag", "", "(Ljava/lang/String;JJJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/huachenjie/sport/bean/HuodongDetail;Ljava/lang/String;IIJIILjava/lang/String;Ljava/lang/String;Z)V", "getActivityCode", "()Ljava/lang/String;", "getActivityEndTime", "()J", "getActivityFenceCode", "getActivityOrganizer", "getActivityRule", "getActivityStartTime", "getActivityStatus", "()I", "setActivityStatus", "(I)V", "getActivityTitle", "getActivityType", "getCoverImage", "getDetail", "()Lcom/huachenjie/sport/bean/HuodongDetail;", "getLocation", "getRunFlag", "()Z", "getSignUpCount", "setSignUpCount", "getSignUpEndTime", "getSignUpLimit", "getSignUpRemainTime", "getSignUpStartTime", "getSignUpStatus", "setSignUpStatus", "getTargetDistance", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "findDistance", "formatDistance", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuodongDetailBean {

    @NotNull
    private final String activityCode;
    private final long activityEndTime;

    @NotNull
    private final String activityFenceCode;

    @NotNull
    private final String activityOrganizer;

    @NotNull
    private final String activityRule;
    private final long activityStartTime;
    private int activityStatus;

    @NotNull
    private final String activityTitle;
    private final int activityType;

    @NotNull
    private final String coverImage;

    @NotNull
    private final HuodongDetail detail;

    @NotNull
    private final String location;
    private final boolean runFlag;
    private int signUpCount;
    private final long signUpEndTime;
    private final int signUpLimit;
    private final long signUpRemainTime;
    private final long signUpStartTime;
    private int signUpStatus;

    @Nullable
    private final String targetDistance;

    public HuodongDetailBean() {
        this(null, 0L, 0L, 0L, 0L, null, null, 0, null, null, null, null, 0, 0, 0L, 0, 0, null, null, false, 1048575, null);
    }

    public HuodongDetailBean(@NotNull String str, long j, long j2, long j3, long j4, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @NotNull String str5, @NotNull HuodongDetail huodongDetail, @NotNull String str6, int i2, int i3, long j5, int i4, int i5, @NotNull String str7, @Nullable String str8, boolean z) {
        Intrinsics.checkNotNullParameter(str, "activityCode");
        Intrinsics.checkNotNullParameter(str2, "activityOrganizer");
        Intrinsics.checkNotNullParameter(str3, "activityRule");
        Intrinsics.checkNotNullParameter(str4, "activityTitle");
        Intrinsics.checkNotNullParameter(str5, "coverImage");
        Intrinsics.checkNotNullParameter(huodongDetail, "detail");
        Intrinsics.checkNotNullParameter(str6, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(str7, "activityFenceCode");
        this.activityCode = str;
        this.activityStartTime = j;
        this.activityEndTime = j2;
        this.signUpStartTime = j3;
        this.signUpEndTime = j4;
        this.activityOrganizer = str2;
        this.activityRule = str3;
        this.activityStatus = i;
        this.activityTitle = str4;
        this.coverImage = str5;
        this.detail = huodongDetail;
        this.location = str6;
        this.signUpCount = i2;
        this.signUpLimit = i3;
        this.signUpRemainTime = j5;
        this.signUpStatus = i4;
        this.activityType = i5;
        this.activityFenceCode = str7;
        this.targetDistance = str8;
        this.runFlag = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityCode() {
        return this.activityCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final HuodongDetail getDetail() {
        return this.detail;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getSignUpCount() {
        return this.signUpCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getSignUpLimit() {
        return this.signUpLimit;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getSignUpRemainTime() {
        return this.signUpRemainTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getSignUpStatus() {
        return this.signUpStatus;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getActivityType() {
        return this.activityType;
    }

    @NotNull
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getActivityFenceCode() {
        return this.activityFenceCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getTargetDistance() {
        return this.targetDistance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getActivityStartTime() {
        return this.activityStartTime;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getRunFlag() {
        return this.runFlag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getActivityEndTime() {
        return this.activityEndTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSignUpStartTime() {
        return this.signUpStartTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getSignUpEndTime() {
        return this.signUpEndTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getActivityOrganizer() {
        return this.activityOrganizer;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getActivityRule() {
        return this.activityRule;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    @NotNull
    public final HuodongDetailBean copy(@NotNull String activityCode, long activityStartTime, long activityEndTime, long signUpStartTime, long signUpEndTime, @NotNull String activityOrganizer, @NotNull String activityRule, int activityStatus, @NotNull String activityTitle, @NotNull String coverImage, @NotNull HuodongDetail detail, @NotNull String location, int signUpCount, int signUpLimit, long signUpRemainTime, int signUpStatus, int activityType, @NotNull String activityFenceCode, @Nullable String targetDistance, boolean runFlag) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        Intrinsics.checkNotNullParameter(activityOrganizer, "activityOrganizer");
        Intrinsics.checkNotNullParameter(activityRule, "activityRule");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(coverImage, "coverImage");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(location, RequestParameters.SUBRESOURCE_LOCATION);
        Intrinsics.checkNotNullParameter(activityFenceCode, "activityFenceCode");
        return new HuodongDetailBean(activityCode, activityStartTime, activityEndTime, signUpStartTime, signUpEndTime, activityOrganizer, activityRule, activityStatus, activityTitle, coverImage, detail, location, signUpCount, signUpLimit, signUpRemainTime, signUpStatus, activityType, activityFenceCode, targetDistance, runFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuodongDetailBean)) {
            return false;
        }
        HuodongDetailBean huodongDetailBean = (HuodongDetailBean) other;
        return Intrinsics.areEqual(this.activityCode, huodongDetailBean.activityCode) && this.activityStartTime == huodongDetailBean.activityStartTime && this.activityEndTime == huodongDetailBean.activityEndTime && this.signUpStartTime == huodongDetailBean.signUpStartTime && this.signUpEndTime == huodongDetailBean.signUpEndTime && Intrinsics.areEqual(this.activityOrganizer, huodongDetailBean.activityOrganizer) && Intrinsics.areEqual(this.activityRule, huodongDetailBean.activityRule) && this.activityStatus == huodongDetailBean.activityStatus && Intrinsics.areEqual(this.activityTitle, huodongDetailBean.activityTitle) && Intrinsics.areEqual(this.coverImage, huodongDetailBean.coverImage) && Intrinsics.areEqual(this.detail, huodongDetailBean.detail) && Intrinsics.areEqual(this.location, huodongDetailBean.location) && this.signUpCount == huodongDetailBean.signUpCount && this.signUpLimit == huodongDetailBean.signUpLimit && this.signUpRemainTime == huodongDetailBean.signUpRemainTime && this.signUpStatus == huodongDetailBean.signUpStatus && this.activityType == huodongDetailBean.activityType && Intrinsics.areEqual(this.activityFenceCode, huodongDetailBean.activityFenceCode) && Intrinsics.areEqual(this.targetDistance, huodongDetailBean.targetDistance) && this.runFlag == huodongDetailBean.runFlag;
    }

    public final int findDistance() {
        if (!h46.f42049a.m(this.targetDistance)) {
            return 0;
        }
        try {
            String str = this.targetDistance;
            if (str == null) {
                str = "0";
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    @NotNull
    public final String formatDistance() {
        if (!h46.f42049a.m(this.targetDistance)) {
            String str = this.targetDistance;
            return str == null ? "" : str;
        }
        try {
            String strE = ll7.f43096a.e(Integer.valueOf(Integer.parseInt(this.targetDistance)), true, true);
            return strE == null ? "" : strE;
        } catch (Exception unused) {
            String str2 = this.targetDistance;
            return str2 == null ? "" : str2;
        }
    }

    @NotNull
    public final String getActivityCode() {
        return this.activityCode;
    }

    public final long getActivityEndTime() {
        return this.activityEndTime;
    }

    @NotNull
    public final String getActivityFenceCode() {
        return this.activityFenceCode;
    }

    @NotNull
    public final String getActivityOrganizer() {
        return this.activityOrganizer;
    }

    @NotNull
    public final String getActivityRule() {
        return this.activityRule;
    }

    public final long getActivityStartTime() {
        return this.activityStartTime;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    @NotNull
    public final String getCoverImage() {
        return this.coverImage;
    }

    @NotNull
    public final HuodongDetail getDetail() {
        return this.detail;
    }

    @NotNull
    public final String getLocation() {
        return this.location;
    }

    public final boolean getRunFlag() {
        return this.runFlag;
    }

    public final int getSignUpCount() {
        return this.signUpCount;
    }

    public final long getSignUpEndTime() {
        return this.signUpEndTime;
    }

    public final int getSignUpLimit() {
        return this.signUpLimit;
    }

    public final long getSignUpRemainTime() {
        return this.signUpRemainTime;
    }

    public final long getSignUpStartTime() {
        return this.signUpStartTime;
    }

    public final int getSignUpStatus() {
        return this.signUpStatus;
    }

    @Nullable
    public final String getTargetDistance() {
        return this.targetDistance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r1v38, types: [int] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v41 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((this.activityCode.hashCode() * 31) + Long.hashCode(this.activityStartTime)) * 31) + Long.hashCode(this.activityEndTime)) * 31) + Long.hashCode(this.signUpStartTime)) * 31) + Long.hashCode(this.signUpEndTime)) * 31) + this.activityOrganizer.hashCode()) * 31) + this.activityRule.hashCode()) * 31) + Integer.hashCode(this.activityStatus)) * 31) + this.activityTitle.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + this.detail.hashCode()) * 31) + this.location.hashCode()) * 31) + Integer.hashCode(this.signUpCount)) * 31) + Integer.hashCode(this.signUpLimit)) * 31) + Long.hashCode(this.signUpRemainTime)) * 31) + Integer.hashCode(this.signUpStatus)) * 31) + Integer.hashCode(this.activityType)) * 31) + this.activityFenceCode.hashCode()) * 31;
        String str = this.targetDistance;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.runFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final void setActivityStatus(int i) {
        this.activityStatus = i;
    }

    public final void setSignUpCount(int i) {
        this.signUpCount = i;
    }

    public final void setSignUpStatus(int i) {
        this.signUpStatus = i;
    }

    @NotNull
    public String toString() {
        return "HuodongDetailBean(activityCode=" + this.activityCode + ", activityStartTime=" + this.activityStartTime + ", activityEndTime=" + this.activityEndTime + ", signUpStartTime=" + this.signUpStartTime + ", signUpEndTime=" + this.signUpEndTime + ", activityOrganizer=" + this.activityOrganizer + ", activityRule=" + this.activityRule + ", activityStatus=" + this.activityStatus + ", activityTitle=" + this.activityTitle + ", coverImage=" + this.coverImage + ", detail=" + this.detail + ", location=" + this.location + ", signUpCount=" + this.signUpCount + ", signUpLimit=" + this.signUpLimit + ", signUpRemainTime=" + this.signUpRemainTime + ", signUpStatus=" + this.signUpStatus + ", activityType=" + this.activityType + ", activityFenceCode=" + this.activityFenceCode + ", targetDistance=" + this.targetDistance + ", runFlag=" + this.runFlag + ')';
    }

    public /* synthetic */ HuodongDetailBean(String str, long j, long j2, long j3, long j4, String str2, String str3, int i, String str4, String str5, HuodongDetail huodongDetail, String str6, int i2, int i3, long j5, int i4, int i5, String str7, String str8, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? 0L : j, (i6 & 4) != 0 ? 0L : j2, (i6 & 8) != 0 ? 0L : j3, (i6 & 16) != 0 ? 0L : j4, (i6 & 32) != 0 ? "" : str2, (i6 & 64) != 0 ? "" : str3, (i6 & 128) != 0 ? 0 : i, (i6 & 256) != 0 ? "" : str4, (i6 & 512) != 0 ? "" : str5, (i6 & 1024) != 0 ? new HuodongDetail(null, null, 3, null) : huodongDetail, (i6 & 2048) != 0 ? "" : str6, (i6 & 4096) != 0 ? 0 : i2, (i6 & 8192) != 0 ? 0 : i3, (i6 & 16384) != 0 ? 0L : j5, (32768 & i6) != 0 ? 0 : i4, (i6 & 65536) != 0 ? 0 : i5, (i6 & 131072) != 0 ? "" : str7, (i6 & 262144) != 0 ? "" : str8, (i6 & 524288) == 0 ? z : false);
    }
}

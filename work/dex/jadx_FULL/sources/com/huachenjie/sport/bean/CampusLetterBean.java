package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.sport.R;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0007J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/huachenjie/sport/bean/CampusLetterBean;", "", "readFlag", "", "source", "", "schoolLetterRelationCode", "", "schoolLetterTitle", "schoolLetterSummary", "schoolLetterTime", "", "messageNotificationInfo", "Lcom/huachenjie/sport/bean/CampusLetterInfo;", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/huachenjie/sport/bean/CampusLetterInfo;)V", "getMessageNotificationInfo", "()Lcom/huachenjie/sport/bean/CampusLetterInfo;", "getReadFlag", "()Z", "setReadFlag", "(Z)V", "getSchoolLetterRelationCode", "()Ljava/lang/String;", "getSchoolLetterSummary", "getSchoolLetterTime", "()J", "getSchoolLetterTitle", "getSource", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "other", "formatIcon", "formatLetterTime", "formatPassBg", "formatPassStatus", "hashCode", "showDetail", "showPassStatus", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CampusLetterBean {

    @Nullable
    private final CampusLetterInfo messageNotificationInfo;
    private boolean readFlag;

    @NotNull
    private final String schoolLetterRelationCode;

    @NotNull
    private final String schoolLetterSummary;
    private final long schoolLetterTime;

    @NotNull
    private final String schoolLetterTitle;
    private final int source;

    public CampusLetterBean() {
        this(false, 0, null, null, null, 0L, null, 127, null);
    }

    public CampusLetterBean(boolean z, int i, @NotNull String str, @NotNull String str2, @NotNull String str3, long j, @Nullable CampusLetterInfo campusLetterInfo) {
        Intrinsics.checkNotNullParameter(str, "schoolLetterRelationCode");
        Intrinsics.checkNotNullParameter(str2, "schoolLetterTitle");
        Intrinsics.checkNotNullParameter(str3, "schoolLetterSummary");
        this.readFlag = z;
        this.source = i;
        this.schoolLetterRelationCode = str;
        this.schoolLetterTitle = str2;
        this.schoolLetterSummary = str3;
        this.schoolLetterTime = j;
        this.messageNotificationInfo = campusLetterInfo;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getReadFlag() {
        return this.readFlag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSchoolLetterRelationCode() {
        return this.schoolLetterRelationCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolLetterTitle() {
        return this.schoolLetterTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchoolLetterSummary() {
        return this.schoolLetterSummary;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSchoolLetterTime() {
        return this.schoolLetterTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final CampusLetterInfo getMessageNotificationInfo() {
        return this.messageNotificationInfo;
    }

    @NotNull
    public final CampusLetterBean copy(boolean readFlag, int source, @NotNull String schoolLetterRelationCode, @NotNull String schoolLetterTitle, @NotNull String schoolLetterSummary, long schoolLetterTime, @Nullable CampusLetterInfo messageNotificationInfo) {
        Intrinsics.checkNotNullParameter(schoolLetterRelationCode, "schoolLetterRelationCode");
        Intrinsics.checkNotNullParameter(schoolLetterTitle, "schoolLetterTitle");
        Intrinsics.checkNotNullParameter(schoolLetterSummary, "schoolLetterSummary");
        return new CampusLetterBean(readFlag, source, schoolLetterRelationCode, schoolLetterTitle, schoolLetterSummary, schoolLetterTime, messageNotificationInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampusLetterBean)) {
            return false;
        }
        CampusLetterBean campusLetterBean = (CampusLetterBean) other;
        return this.readFlag == campusLetterBean.readFlag && this.source == campusLetterBean.source && Intrinsics.areEqual(this.schoolLetterRelationCode, campusLetterBean.schoolLetterRelationCode) && Intrinsics.areEqual(this.schoolLetterTitle, campusLetterBean.schoolLetterTitle) && Intrinsics.areEqual(this.schoolLetterSummary, campusLetterBean.schoolLetterSummary) && this.schoolLetterTime == campusLetterBean.schoolLetterTime && Intrinsics.areEqual(this.messageNotificationInfo, campusLetterBean.messageNotificationInfo);
    }

    public final int formatIcon() {
        int i = this.source;
        if (i == 10) {
            return R.drawable.ic_campus_letter_shcool;
        }
        if (i == 20) {
            return R.drawable.ic_campus_letter_shandong;
        }
        if (i != 30) {
            return i != 40 ? R.drawable.ic_campus_letter_promote : R.drawable.ic_campus_letter_promote;
        }
        return R.drawable.ic_campus_letter_operate;
    }

    @NotNull
    public final String formatLetterTime() {
        long j = this.schoolLetterTime;
        if (j == 0) {
            return "";
        }
        if (s72.z(j)) {
            String strC = s72.A(this.schoolLetterTime) ? s72.c(this.schoolLetterTime, "HH:mm") : s72.c(this.schoolLetterTime, "MM.dd HH:mm");
            Intrinsics.checkNotNullExpressionValue(strC, "{\n            if (DateUt…)\n            }\n        }");
            return strC;
        }
        String strC2 = s72.c(this.schoolLetterTime, "yyyy.MM.dd");
        Intrinsics.checkNotNullExpressionValue(strC2, "{\n            DateUtil.f…, \"yyyy.MM.dd\")\n        }");
        return strC2;
    }

    public final int formatPassBg() {
        if (!showPassStatus()) {
            return 0;
        }
        CampusLetterInfo campusLetterInfo = this.messageNotificationInfo;
        Integer numValueOf = campusLetterInfo != null ? Integer.valueOf(campusLetterInfo.getBusinessSubType()) : null;
        boolean z = true;
        if (((numValueOf != null && numValueOf.intValue() == 10) || (numValueOf != null && numValueOf.intValue() == 31)) || (numValueOf != null && numValueOf.intValue() == 33)) {
            return R.drawable.bg_appeal_pass;
        }
        if (!((numValueOf != null && numValueOf.intValue() == 11) || (numValueOf != null && numValueOf.intValue() == 32)) && (numValueOf == null || numValueOf.intValue() != 34)) {
            z = false;
        }
        if (z) {
            return R.drawable.bg_appeal_no_pass;
        }
        return 0;
    }

    @NotNull
    public final String formatPassStatus() {
        if (!showPassStatus()) {
            return "";
        }
        CampusLetterInfo campusLetterInfo = this.messageNotificationInfo;
        Integer numValueOf = campusLetterInfo != null ? Integer.valueOf(campusLetterInfo.getBusinessSubType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 10) {
            return "已通过";
        }
        if (numValueOf != null && numValueOf.intValue() == 11) {
            return "未通过";
        }
        boolean z = false;
        if ((numValueOf != null && numValueOf.intValue() == 31) || (numValueOf != null && numValueOf.intValue() == 33)) {
            return "通过";
        }
        if ((numValueOf != null && numValueOf.intValue() == 32) || (numValueOf != null && numValueOf.intValue() == 34)) {
            z = true;
        }
        return z ? "驳回" : "";
    }

    @Nullable
    public final CampusLetterInfo getMessageNotificationInfo() {
        return this.messageNotificationInfo;
    }

    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final String getSchoolLetterRelationCode() {
        return this.schoolLetterRelationCode;
    }

    @NotNull
    public final String getSchoolLetterSummary() {
        return this.schoolLetterSummary;
    }

    public final long getSchoolLetterTime() {
        return this.schoolLetterTime;
    }

    @NotNull
    public final String getSchoolLetterTitle() {
        return this.schoolLetterTitle;
    }

    public final int getSource() {
        return this.source;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z = this.readFlag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((((((((r0 * 31) + Integer.hashCode(this.source)) * 31) + this.schoolLetterRelationCode.hashCode()) * 31) + this.schoolLetterTitle.hashCode()) * 31) + this.schoolLetterSummary.hashCode()) * 31) + Long.hashCode(this.schoolLetterTime)) * 31;
        CampusLetterInfo campusLetterInfo = this.messageNotificationInfo;
        return iHashCode + (campusLetterInfo == null ? 0 : campusLetterInfo.hashCode());
    }

    public final void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    public final boolean showDetail() {
        if (this.source != 20) {
            return true;
        }
        CampusLetterInfo campusLetterInfo = this.messageNotificationInfo;
        return !(campusLetterInfo != null && campusLetterInfo.getBusinessType() == 50);
    }

    public final boolean showPassStatus() {
        if (this.source != 20) {
            return false;
        }
        CampusLetterInfo campusLetterInfo = this.messageNotificationInfo;
        if ((campusLetterInfo != null && campusLetterInfo.getBusinessType() == 10) && (this.messageNotificationInfo.getBusinessSubType() == 10 || this.messageNotificationInfo.getBusinessSubType() == 11)) {
            return true;
        }
        CampusLetterInfo campusLetterInfo2 = this.messageNotificationInfo;
        if ((campusLetterInfo2 != null && campusLetterInfo2.getBusinessType() == 70) && (this.messageNotificationInfo.getBusinessSubType() == 33 || this.messageNotificationInfo.getBusinessSubType() == 34)) {
            return true;
        }
        CampusLetterInfo campusLetterInfo3 = this.messageNotificationInfo;
        return (campusLetterInfo3 != null && campusLetterInfo3.getBusinessType() == 80) && (this.messageNotificationInfo.getBusinessSubType() == 31 || this.messageNotificationInfo.getBusinessSubType() == 32);
    }

    @NotNull
    public String toString() {
        return "CampusLetterBean(readFlag=" + this.readFlag + ", source=" + this.source + ", schoolLetterRelationCode=" + this.schoolLetterRelationCode + ", schoolLetterTitle=" + this.schoolLetterTitle + ", schoolLetterSummary=" + this.schoolLetterSummary + ", schoolLetterTime=" + this.schoolLetterTime + ", messageNotificationInfo=" + this.messageNotificationInfo + ')';
    }

    public /* synthetic */ CampusLetterBean(boolean z, int i, String str, String str2, String str3, long j, CampusLetterInfo campusLetterInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? 0L : j, (i2 & 64) != 0 ? null : campusLetterInfo);
    }
}

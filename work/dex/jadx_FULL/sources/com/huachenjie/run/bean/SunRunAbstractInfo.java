package com.huachenjie.run.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001f\u001a\u00020\u001aJ\t\u0010 \u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/huachenjie/run/bean/SunRunAbstractInfo;", "", "planType", "", "deductionDistance", "deductionTimes", "schoolDemandRule", "Lcom/huachenjie/run/bean/SchoolDemandRule;", "studentDoneRuleInfo", "Lcom/huachenjie/run/bean/StudentDoneRuleInfo;", "(IIILcom/huachenjie/run/bean/SchoolDemandRule;Lcom/huachenjie/run/bean/StudentDoneRuleInfo;)V", "getDeductionDistance", "()I", "getDeductionTimes", "getPlanType", "getSchoolDemandRule", "()Lcom/huachenjie/run/bean/SchoolDemandRule;", "getStudentDoneRuleInfo", "()Lcom/huachenjie/run/bean/StudentDoneRuleInfo;", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "getDeductionInfo", "", "hashCode", "showDeductionTip", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SunRunAbstractInfo {
    private final int deductionDistance;
    private final int deductionTimes;
    private final int planType;

    @Nullable
    private final SchoolDemandRule schoolDemandRule;

    @Nullable
    private final StudentDoneRuleInfo studentDoneRuleInfo;

    public SunRunAbstractInfo() {
        this(0, 0, 0, null, null, 31, null);
    }

    public SunRunAbstractInfo(int i, int i2, int i3, @Nullable SchoolDemandRule schoolDemandRule, @Nullable StudentDoneRuleInfo studentDoneRuleInfo) {
        this.planType = i;
        this.deductionDistance = i2;
        this.deductionTimes = i3;
        this.schoolDemandRule = schoolDemandRule;
        this.studentDoneRuleInfo = studentDoneRuleInfo;
    }

    public static /* synthetic */ SunRunAbstractInfo copy$default(SunRunAbstractInfo sunRunAbstractInfo, int i, int i2, int i3, SchoolDemandRule schoolDemandRule, StudentDoneRuleInfo studentDoneRuleInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sunRunAbstractInfo.planType;
        }
        if ((i4 & 2) != 0) {
            i2 = sunRunAbstractInfo.deductionDistance;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = sunRunAbstractInfo.deductionTimes;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            schoolDemandRule = sunRunAbstractInfo.schoolDemandRule;
        }
        SchoolDemandRule schoolDemandRule2 = schoolDemandRule;
        if ((i4 & 16) != 0) {
            studentDoneRuleInfo = sunRunAbstractInfo.studentDoneRuleInfo;
        }
        return sunRunAbstractInfo.copy(i, i5, i6, schoolDemandRule2, studentDoneRuleInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPlanType() {
        return this.planType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeductionDistance() {
        return this.deductionDistance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SchoolDemandRule getSchoolDemandRule() {
        return this.schoolDemandRule;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StudentDoneRuleInfo getStudentDoneRuleInfo() {
        return this.studentDoneRuleInfo;
    }

    @NotNull
    public final SunRunAbstractInfo copy(int planType, int deductionDistance, int deductionTimes, @Nullable SchoolDemandRule schoolDemandRule, @Nullable StudentDoneRuleInfo studentDoneRuleInfo) {
        return new SunRunAbstractInfo(planType, deductionDistance, deductionTimes, schoolDemandRule, studentDoneRuleInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SunRunAbstractInfo)) {
            return false;
        }
        SunRunAbstractInfo sunRunAbstractInfo = (SunRunAbstractInfo) other;
        return this.planType == sunRunAbstractInfo.planType && this.deductionDistance == sunRunAbstractInfo.deductionDistance && this.deductionTimes == sunRunAbstractInfo.deductionTimes && Intrinsics.areEqual(this.schoolDemandRule, sunRunAbstractInfo.schoolDemandRule) && Intrinsics.areEqual(this.studentDoneRuleInfo, sunRunAbstractInfo.studentDoneRuleInfo);
    }

    public final int getDeductionDistance() {
        return this.deductionDistance;
    }

    @Nullable
    public final String getDeductionInfo() {
        int i = this.deductionDistance;
        if (i > 0 && this.planType == 3) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("AI锻炼已抵扣%.1f公里", Arrays.copyOf(new Object[]{Float.valueOf(i / 1000.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
        int i2 = this.deductionTimes;
        if (i2 <= 0 || this.planType != 2) {
            return "";
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("AI锻炼已抵扣%d次", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        return str2;
    }

    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    public final int getPlanType() {
        return this.planType;
    }

    @Nullable
    public final SchoolDemandRule getSchoolDemandRule() {
        return this.schoolDemandRule;
    }

    @Nullable
    public final StudentDoneRuleInfo getStudentDoneRuleInfo() {
        return this.studentDoneRuleInfo;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.planType) * 31) + Integer.hashCode(this.deductionDistance)) * 31) + Integer.hashCode(this.deductionTimes)) * 31;
        SchoolDemandRule schoolDemandRule = this.schoolDemandRule;
        int iHashCode2 = (iHashCode + (schoolDemandRule == null ? 0 : schoolDemandRule.hashCode())) * 31;
        StudentDoneRuleInfo studentDoneRuleInfo = this.studentDoneRuleInfo;
        return iHashCode2 + (studentDoneRuleInfo != null ? studentDoneRuleInfo.hashCode() : 0);
    }

    public final boolean showDeductionTip() {
        return !TextUtils.isEmpty(getDeductionInfo());
    }

    @NotNull
    public String toString() {
        return "SunRunAbstractInfo(planType=" + this.planType + ", deductionDistance=" + this.deductionDistance + ", deductionTimes=" + this.deductionTimes + ", schoolDemandRule=" + this.schoolDemandRule + ", studentDoneRuleInfo=" + this.studentDoneRuleInfo + ')';
    }

    public /* synthetic */ SunRunAbstractInfo(int i, int i2, int i3, SchoolDemandRule schoolDemandRule, StudentDoneRuleInfo studentDoneRuleInfo, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? null : schoolDemandRule, (i4 & 16) != 0 ? null : studentDoneRuleInfo);
    }
}

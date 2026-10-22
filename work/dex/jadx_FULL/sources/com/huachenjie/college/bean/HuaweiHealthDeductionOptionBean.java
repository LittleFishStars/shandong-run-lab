package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/college/bean/HuaweiHealthDeductionOptionBean;", "", "dedPlanCode", "", "runPlanName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDedPlanCode", "()Ljava/lang/String;", "getRunPlanName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuaweiHealthDeductionOptionBean {

    @NotNull
    private final String dedPlanCode;

    @NotNull
    private final String runPlanName;

    /* JADX WARN: Illegal instructions before constructor call */
    public HuaweiHealthDeductionOptionBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public HuaweiHealthDeductionOptionBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "dedPlanCode");
        Intrinsics.checkNotNullParameter(str2, "runPlanName");
        this.dedPlanCode = str;
        this.runPlanName = str2;
    }

    public static /* synthetic */ HuaweiHealthDeductionOptionBean copy$default(HuaweiHealthDeductionOptionBean huaweiHealthDeductionOptionBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = huaweiHealthDeductionOptionBean.dedPlanCode;
        }
        if ((i & 2) != 0) {
            str2 = huaweiHealthDeductionOptionBean.runPlanName;
        }
        return huaweiHealthDeductionOptionBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDedPlanCode() {
        return this.dedPlanCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    @NotNull
    public final HuaweiHealthDeductionOptionBean copy(@NotNull String dedPlanCode, @NotNull String runPlanName) {
        Intrinsics.checkNotNullParameter(dedPlanCode, "dedPlanCode");
        Intrinsics.checkNotNullParameter(runPlanName, "runPlanName");
        return new HuaweiHealthDeductionOptionBean(dedPlanCode, runPlanName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuaweiHealthDeductionOptionBean)) {
            return false;
        }
        HuaweiHealthDeductionOptionBean huaweiHealthDeductionOptionBean = (HuaweiHealthDeductionOptionBean) other;
        return Intrinsics.areEqual(this.dedPlanCode, huaweiHealthDeductionOptionBean.dedPlanCode) && Intrinsics.areEqual(this.runPlanName, huaweiHealthDeductionOptionBean.runPlanName);
    }

    @NotNull
    public final String getDedPlanCode() {
        return this.dedPlanCode;
    }

    @NotNull
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    public int hashCode() {
        return (this.dedPlanCode.hashCode() * 31) + this.runPlanName.hashCode();
    }

    @NotNull
    public String toString() {
        return "HuaweiHealthDeductionOptionBean(dedPlanCode=" + this.dedPlanCode + ", runPlanName=" + this.runPlanName + ')';
    }

    public /* synthetic */ HuaweiHealthDeductionOptionBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

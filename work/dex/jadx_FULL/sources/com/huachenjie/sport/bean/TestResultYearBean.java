package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/sport/bean/TestResultYearBean;", "", "academicYearCode", "", "yearName", "currentYear", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAcademicYearCode", "()Ljava/lang/String;", "getCurrentYear", "()Ljava/lang/Boolean;", "setCurrentYear", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getYearName", "component1", "component2", "component3", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/huachenjie/sport/bean/TestResultYearBean;", "equals", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TestResultYearBean {

    @Nullable
    private final String academicYearCode;

    @Nullable
    private Boolean currentYear;

    @Nullable
    private final String yearName;

    public TestResultYearBean() {
        this(null, null, null, 7, null);
    }

    public TestResultYearBean(@Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        this.academicYearCode = str;
        this.yearName = str2;
        this.currentYear = bool;
    }

    public static /* synthetic */ TestResultYearBean copy$default(TestResultYearBean testResultYearBean, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = testResultYearBean.academicYearCode;
        }
        if ((i & 2) != 0) {
            str2 = testResultYearBean.yearName;
        }
        if ((i & 4) != 0) {
            bool = testResultYearBean.currentYear;
        }
        return testResultYearBean.copy(str, str2, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAcademicYearCode() {
        return this.academicYearCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getYearName() {
        return this.yearName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getCurrentYear() {
        return this.currentYear;
    }

    @NotNull
    public final TestResultYearBean copy(@Nullable String academicYearCode, @Nullable String yearName, @Nullable Boolean currentYear) {
        return new TestResultYearBean(academicYearCode, yearName, currentYear);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestResultYearBean)) {
            return false;
        }
        TestResultYearBean testResultYearBean = (TestResultYearBean) other;
        return Intrinsics.areEqual(this.academicYearCode, testResultYearBean.academicYearCode) && Intrinsics.areEqual(this.yearName, testResultYearBean.yearName) && Intrinsics.areEqual(this.currentYear, testResultYearBean.currentYear);
    }

    @Nullable
    public final String getAcademicYearCode() {
        return this.academicYearCode;
    }

    @Nullable
    public final Boolean getCurrentYear() {
        return this.currentYear;
    }

    @Nullable
    public final String getYearName() {
        return this.yearName;
    }

    public int hashCode() {
        String str = this.academicYearCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.yearName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.currentYear;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setCurrentYear(@Nullable Boolean bool) {
        this.currentYear = bool;
    }

    @NotNull
    public String toString() {
        return "TestResultYearBean(academicYearCode=" + this.academicYearCode + ", yearName=" + this.yearName + ", currentYear=" + this.currentYear + ')';
    }

    public /* synthetic */ TestResultYearBean(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? Boolean.FALSE : bool);
    }
}

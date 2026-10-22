package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/bean/SubjectBean;", "", "subjectCode", "", "subjectName", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubjectCode", "()Ljava/lang/String;", "getSubjectName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubjectBean {

    @Nullable
    private final String subjectCode;

    @Nullable
    private final String subjectName;

    /* JADX WARN: Illegal instructions before constructor call */
    public SubjectBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public SubjectBean(@Nullable String str, @Nullable String str2) {
        this.subjectCode = str;
        this.subjectName = str2;
    }

    public static /* synthetic */ SubjectBean copy$default(SubjectBean subjectBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjectBean.subjectCode;
        }
        if ((i & 2) != 0) {
            str2 = subjectBean.subjectName;
        }
        return subjectBean.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectCode() {
        return this.subjectCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final SubjectBean copy(@Nullable String subjectCode, @Nullable String subjectName) {
        return new SubjectBean(subjectCode, subjectName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectBean)) {
            return false;
        }
        SubjectBean subjectBean = (SubjectBean) other;
        return Intrinsics.areEqual(this.subjectCode, subjectBean.subjectCode) && Intrinsics.areEqual(this.subjectName, subjectBean.subjectName);
    }

    @Nullable
    public final String getSubjectCode() {
        return this.subjectCode;
    }

    @Nullable
    public final String getSubjectName() {
        return this.subjectName;
    }

    public int hashCode() {
        String str = this.subjectCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subjectName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SubjectBean(subjectCode=" + this.subjectCode + ", subjectName=" + this.subjectName + ')';
    }

    public /* synthetic */ SubjectBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}

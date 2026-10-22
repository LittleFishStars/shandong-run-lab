package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/PEClassesSelectorBean;", "", "semesterList", "", "Lcom/huachenjie/sport/bean/SemesterBean;", "subjectList", "Lcom/huachenjie/sport/bean/SubjectBean;", "(Ljava/util/List;Ljava/util/List;)V", "getSemesterList", "()Ljava/util/List;", "getSubjectList", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PEClassesSelectorBean {

    @Nullable
    private final List<SemesterBean> semesterList;

    @Nullable
    private final List<SubjectBean> subjectList;

    /* JADX WARN: Illegal instructions before constructor call */
    public PEClassesSelectorBean() {
        List list = null;
        this(list, list, 3, list);
    }

    public PEClassesSelectorBean(@Nullable List<SemesterBean> list, @Nullable List<SubjectBean> list2) {
        this.semesterList = list;
        this.subjectList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PEClassesSelectorBean copy$default(PEClassesSelectorBean pEClassesSelectorBean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pEClassesSelectorBean.semesterList;
        }
        if ((i & 2) != 0) {
            list2 = pEClassesSelectorBean.subjectList;
        }
        return pEClassesSelectorBean.copy(list, list2);
    }

    @Nullable
    public final List<SemesterBean> component1() {
        return this.semesterList;
    }

    @Nullable
    public final List<SubjectBean> component2() {
        return this.subjectList;
    }

    @NotNull
    public final PEClassesSelectorBean copy(@Nullable List<SemesterBean> semesterList, @Nullable List<SubjectBean> subjectList) {
        return new PEClassesSelectorBean(semesterList, subjectList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PEClassesSelectorBean)) {
            return false;
        }
        PEClassesSelectorBean pEClassesSelectorBean = (PEClassesSelectorBean) other;
        return Intrinsics.areEqual(this.semesterList, pEClassesSelectorBean.semesterList) && Intrinsics.areEqual(this.subjectList, pEClassesSelectorBean.subjectList);
    }

    @Nullable
    public final List<SemesterBean> getSemesterList() {
        return this.semesterList;
    }

    @Nullable
    public final List<SubjectBean> getSubjectList() {
        return this.subjectList;
    }

    public int hashCode() {
        List<SemesterBean> list = this.semesterList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SubjectBean> list2 = this.subjectList;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PEClassesSelectorBean(semesterList=" + this.semesterList + ", subjectList=" + this.subjectList + ')';
    }

    public /* synthetic */ PEClassesSelectorBean(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}

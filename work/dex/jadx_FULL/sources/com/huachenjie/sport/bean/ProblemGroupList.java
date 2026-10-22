package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/ProblemGroupList;", "", "problemList", "", "Lcom/huachenjie/sport/bean/ProblemList;", "categoryName", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getProblemList", "()Ljava/util/List;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProblemGroupList {

    @NotNull
    private final String categoryName;

    @NotNull
    private final List<ProblemList> problemList;

    public ProblemGroupList(@NotNull List<ProblemList> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "problemList");
        Intrinsics.checkNotNullParameter(str, "categoryName");
        this.problemList = list;
        this.categoryName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProblemGroupList copy$default(ProblemGroupList problemGroupList, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = problemGroupList.problemList;
        }
        if ((i & 2) != 0) {
            str = problemGroupList.categoryName;
        }
        return problemGroupList.copy(list, str);
    }

    @NotNull
    public final List<ProblemList> component1() {
        return this.problemList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final ProblemGroupList copy(@NotNull List<ProblemList> problemList, @NotNull String categoryName) {
        Intrinsics.checkNotNullParameter(problemList, "problemList");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        return new ProblemGroupList(problemList, categoryName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProblemGroupList)) {
            return false;
        }
        ProblemGroupList problemGroupList = (ProblemGroupList) other;
        return Intrinsics.areEqual(this.problemList, problemGroupList.problemList) && Intrinsics.areEqual(this.categoryName, problemGroupList.categoryName);
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final List<ProblemList> getProblemList() {
        return this.problemList;
    }

    public int hashCode() {
        return (this.problemList.hashCode() * 31) + this.categoryName.hashCode();
    }

    @NotNull
    public String toString() {
        return "ProblemGroupList(problemList=" + this.problemList + ", categoryName=" + this.categoryName + ')';
    }
}

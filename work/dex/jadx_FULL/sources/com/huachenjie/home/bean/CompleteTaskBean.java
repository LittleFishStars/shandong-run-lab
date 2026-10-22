package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/home/bean/CompleteTaskBean;", "", "taskNoList", "", "", "(Ljava/util/List;)V", "getTaskNoList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CompleteTaskBean {

    @NotNull
    private final List<String> taskNoList;

    /* JADX WARN: Illegal instructions before constructor call */
    public CompleteTaskBean() {
        List list = null;
        this(list, 1, list);
    }

    public CompleteTaskBean(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "taskNoList");
        this.taskNoList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompleteTaskBean copy$default(CompleteTaskBean completeTaskBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = completeTaskBean.taskNoList;
        }
        return completeTaskBean.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.taskNoList;
    }

    @NotNull
    public final CompleteTaskBean copy(@NotNull List<String> taskNoList) {
        Intrinsics.checkNotNullParameter(taskNoList, "taskNoList");
        return new CompleteTaskBean(taskNoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CompleteTaskBean) && Intrinsics.areEqual(this.taskNoList, ((CompleteTaskBean) other).taskNoList);
    }

    @NotNull
    public final List<String> getTaskNoList() {
        return this.taskNoList;
    }

    public int hashCode() {
        return this.taskNoList.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompleteTaskBean(taskNoList=" + this.taskNoList + ')';
    }

    public /* synthetic */ CompleteTaskBean(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}

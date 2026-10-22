package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/bean/MultipleActivityData;", "", "activityList", "", "Lcom/huachenjie/works/bean/MultipleActivityBean;", "title", "", "(Ljava/util/List;Ljava/lang/String;)V", "getActivityList", "()Ljava/util/List;", "setActivityList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MultipleActivityData {

    @NotNull
    private List<MultipleActivityBean> activityList;

    @NotNull
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public MultipleActivityData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MultipleActivityData(@NotNull List<MultipleActivityBean> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "activityList");
        Intrinsics.checkNotNullParameter(str, "title");
        this.activityList = list;
        this.title = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipleActivityData copy$default(MultipleActivityData multipleActivityData, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = multipleActivityData.activityList;
        }
        if ((i & 2) != 0) {
            str = multipleActivityData.title;
        }
        return multipleActivityData.copy(list, str);
    }

    @NotNull
    public final List<MultipleActivityBean> component1() {
        return this.activityList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final MultipleActivityData copy(@NotNull List<MultipleActivityBean> activityList, @NotNull String title) {
        Intrinsics.checkNotNullParameter(activityList, "activityList");
        Intrinsics.checkNotNullParameter(title, "title");
        return new MultipleActivityData(activityList, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultipleActivityData)) {
            return false;
        }
        MultipleActivityData multipleActivityData = (MultipleActivityData) other;
        return Intrinsics.areEqual(this.activityList, multipleActivityData.activityList) && Intrinsics.areEqual(this.title, multipleActivityData.title);
    }

    @NotNull
    public final List<MultipleActivityBean> getActivityList() {
        return this.activityList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.activityList.hashCode() * 31) + this.title.hashCode();
    }

    public final void setActivityList(@NotNull List<MultipleActivityBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.activityList = list;
    }

    @NotNull
    public String toString() {
        return "MultipleActivityData(activityList=" + this.activityList + ", title=" + this.title + ')';
    }

    public /* synthetic */ MultipleActivityData(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? "" : str);
    }
}

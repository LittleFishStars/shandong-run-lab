package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/sport/bean/SportTestListBean;", "", "completedTests", "", "Lcom/huachenjie/sport/bean/SportTestItemBean;", "undoneTests", "(Ljava/util/List;Ljava/util/List;)V", "getCompletedTests", "()Ljava/util/List;", "getUndoneTests", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportTestListBean {

    @Nullable
    private final List<SportTestItemBean> completedTests;

    @Nullable
    private final List<SportTestItemBean> undoneTests;

    /* JADX WARN: Illegal instructions before constructor call */
    public SportTestListBean() {
        List list = null;
        this(list, list, 3, list);
    }

    public SportTestListBean(@Nullable List<SportTestItemBean> list, @Nullable List<SportTestItemBean> list2) {
        this.completedTests = list;
        this.undoneTests = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportTestListBean copy$default(SportTestListBean sportTestListBean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sportTestListBean.completedTests;
        }
        if ((i & 2) != 0) {
            list2 = sportTestListBean.undoneTests;
        }
        return sportTestListBean.copy(list, list2);
    }

    @Nullable
    public final List<SportTestItemBean> component1() {
        return this.completedTests;
    }

    @Nullable
    public final List<SportTestItemBean> component2() {
        return this.undoneTests;
    }

    @NotNull
    public final SportTestListBean copy(@Nullable List<SportTestItemBean> completedTests, @Nullable List<SportTestItemBean> undoneTests) {
        return new SportTestListBean(completedTests, undoneTests);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportTestListBean)) {
            return false;
        }
        SportTestListBean sportTestListBean = (SportTestListBean) other;
        return Intrinsics.areEqual(this.completedTests, sportTestListBean.completedTests) && Intrinsics.areEqual(this.undoneTests, sportTestListBean.undoneTests);
    }

    @Nullable
    public final List<SportTestItemBean> getCompletedTests() {
        return this.completedTests;
    }

    @Nullable
    public final List<SportTestItemBean> getUndoneTests() {
        return this.undoneTests;
    }

    public int hashCode() {
        List<SportTestItemBean> list = this.completedTests;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SportTestItemBean> list2 = this.undoneTests;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportTestListBean(completedTests=" + this.completedTests + ", undoneTests=" + this.undoneTests + ')';
    }

    public /* synthetic */ SportTestListBean(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}

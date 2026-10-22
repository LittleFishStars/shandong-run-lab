package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/bean/ActivityRunListBean;", "", "activityList", "", "Lcom/huachenjie/run/bean/ActivityRunBean;", "(Ljava/util/List;)V", "getActivityList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActivityRunListBean {

    @Nullable
    private final List<ActivityRunBean> activityList;

    public ActivityRunListBean(@Nullable List<ActivityRunBean> list) {
        this.activityList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityRunListBean copy$default(ActivityRunListBean activityRunListBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = activityRunListBean.activityList;
        }
        return activityRunListBean.copy(list);
    }

    @Nullable
    public final List<ActivityRunBean> component1() {
        return this.activityList;
    }

    @NotNull
    public final ActivityRunListBean copy(@Nullable List<ActivityRunBean> activityList) {
        return new ActivityRunListBean(activityList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ActivityRunListBean) && Intrinsics.areEqual(this.activityList, ((ActivityRunListBean) other).activityList);
    }

    @Nullable
    public final List<ActivityRunBean> getActivityList() {
        return this.activityList;
    }

    public int hashCode() {
        List<ActivityRunBean> list = this.activityList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityRunListBean(activityList=" + this.activityList + ')';
    }
}

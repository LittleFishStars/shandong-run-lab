package com.huachenjie.base.interact.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/base/interact/bean/WorksInteractBean;", "", "eventList", "", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", UserTrackConstant.SIGN, "", "(Ljava/util/List;Ljava/lang/String;)V", "getEventList", "()Ljava/util/List;", "getSign", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorksInteractBean {

    @NotNull
    private final List<WorksInteractEventBean> eventList;

    @NotNull
    private final String sign;

    /* JADX WARN: Multi-variable type inference failed */
    public WorksInteractBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public WorksInteractBean(@NotNull List<WorksInteractEventBean> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "eventList");
        Intrinsics.checkNotNullParameter(str, UserTrackConstant.SIGN);
        this.eventList = list;
        this.sign = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorksInteractBean copy$default(WorksInteractBean worksInteractBean, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = worksInteractBean.eventList;
        }
        if ((i & 2) != 0) {
            str = worksInteractBean.sign;
        }
        return worksInteractBean.copy(list, str);
    }

    @NotNull
    public final List<WorksInteractEventBean> component1() {
        return this.eventList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    @NotNull
    public final WorksInteractBean copy(@NotNull List<WorksInteractEventBean> eventList, @NotNull String sign) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        Intrinsics.checkNotNullParameter(sign, UserTrackConstant.SIGN);
        return new WorksInteractBean(eventList, sign);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorksInteractBean)) {
            return false;
        }
        WorksInteractBean worksInteractBean = (WorksInteractBean) other;
        return Intrinsics.areEqual(this.eventList, worksInteractBean.eventList) && Intrinsics.areEqual(this.sign, worksInteractBean.sign);
    }

    @NotNull
    public final List<WorksInteractEventBean> getEventList() {
        return this.eventList;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    public int hashCode() {
        return (this.eventList.hashCode() * 31) + this.sign.hashCode();
    }

    @NotNull
    public String toString() {
        return "WorksInteractBean(eventList=" + this.eventList + ", sign=" + this.sign + ')';
    }

    public /* synthetic */ WorksInteractBean(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? "" : str);
    }
}

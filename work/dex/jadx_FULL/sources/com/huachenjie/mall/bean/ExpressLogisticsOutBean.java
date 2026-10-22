package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressLogisticsOutBean;", "", "logisticCoName", "", "logisticSid", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/mall/bean/ExpressLogisticsBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", ExpressLogisticsActivity.x, "", "()Z", "setLightStatus", "(Z)V", "getList", "()Ljava/util/List;", "getLogisticCoName", "()Ljava/lang/String;", "getLogisticSid", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExpressLogisticsOutBean {
    private boolean isLightStatus;

    @NotNull
    private final List<ExpressLogisticsBean> list;

    @NotNull
    private final String logisticCoName;

    @NotNull
    private final String logisticSid;

    public ExpressLogisticsOutBean() {
        this(null, null, null, 7, null);
    }

    public ExpressLogisticsOutBean(@NotNull String str, @NotNull String str2, @NotNull List<ExpressLogisticsBean> list) {
        Intrinsics.checkNotNullParameter(str, "logisticCoName");
        Intrinsics.checkNotNullParameter(str2, "logisticSid");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.logisticCoName = str;
        this.logisticSid = str2;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpressLogisticsOutBean copy$default(ExpressLogisticsOutBean expressLogisticsOutBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expressLogisticsOutBean.logisticCoName;
        }
        if ((i & 2) != 0) {
            str2 = expressLogisticsOutBean.logisticSid;
        }
        if ((i & 4) != 0) {
            list = expressLogisticsOutBean.list;
        }
        return expressLogisticsOutBean.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogisticCoName() {
        return this.logisticCoName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogisticSid() {
        return this.logisticSid;
    }

    @NotNull
    public final List<ExpressLogisticsBean> component3() {
        return this.list;
    }

    @NotNull
    public final ExpressLogisticsOutBean copy(@NotNull String logisticCoName, @NotNull String logisticSid, @NotNull List<ExpressLogisticsBean> list) {
        Intrinsics.checkNotNullParameter(logisticCoName, "logisticCoName");
        Intrinsics.checkNotNullParameter(logisticSid, "logisticSid");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new ExpressLogisticsOutBean(logisticCoName, logisticSid, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressLogisticsOutBean)) {
            return false;
        }
        ExpressLogisticsOutBean expressLogisticsOutBean = (ExpressLogisticsOutBean) other;
        return Intrinsics.areEqual(this.logisticCoName, expressLogisticsOutBean.logisticCoName) && Intrinsics.areEqual(this.logisticSid, expressLogisticsOutBean.logisticSid) && Intrinsics.areEqual(this.list, expressLogisticsOutBean.list);
    }

    @NotNull
    public final List<ExpressLogisticsBean> getList() {
        return this.list;
    }

    @NotNull
    public final String getLogisticCoName() {
        return this.logisticCoName;
    }

    @NotNull
    public final String getLogisticSid() {
        return this.logisticSid;
    }

    public int hashCode() {
        return (((this.logisticCoName.hashCode() * 31) + this.logisticSid.hashCode()) * 31) + this.list.hashCode();
    }

    /* JADX INFO: renamed from: isLightStatus, reason: from getter */
    public final boolean getIsLightStatus() {
        return this.isLightStatus;
    }

    public final void setLightStatus(boolean z) {
        this.isLightStatus = z;
    }

    @NotNull
    public String toString() {
        return "ExpressLogisticsOutBean(logisticCoName=" + this.logisticCoName + ", logisticSid=" + this.logisticSid + ", list=" + this.list + ')';
    }

    public /* synthetic */ ExpressLogisticsOutBean(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : list);
    }
}

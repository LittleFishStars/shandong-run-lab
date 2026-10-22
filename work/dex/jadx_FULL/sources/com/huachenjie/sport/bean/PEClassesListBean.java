package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\fJD\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/bean/PEClassesListBean;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/sport/bean/PEClassBean;", "pageSize", "", "pageNum", "hasNext", "", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getHasNext", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getList", "()Ljava/util/List;", "getPageNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/huachenjie/sport/bean/PEClassesListBean;", "equals", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PEClassesListBean {

    @Nullable
    private final Boolean hasNext;

    @Nullable
    private final List<PEClassBean> list;

    @Nullable
    private final Integer pageNum;

    @Nullable
    private final Integer pageSize;

    public PEClassesListBean() {
        this(null, null, null, null, 15, null);
    }

    public PEClassesListBean(@Nullable List<PEClassBean> list, @Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool) {
        this.list = list;
        this.pageSize = num;
        this.pageNum = num2;
        this.hasNext = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PEClassesListBean copy$default(PEClassesListBean pEClassesListBean, List list, Integer num, Integer num2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pEClassesListBean.list;
        }
        if ((i & 2) != 0) {
            num = pEClassesListBean.pageSize;
        }
        if ((i & 4) != 0) {
            num2 = pEClassesListBean.pageNum;
        }
        if ((i & 8) != 0) {
            bool = pEClassesListBean.hasNext;
        }
        return pEClassesListBean.copy(list, num, num2, bool);
    }

    @Nullable
    public final List<PEClassBean> component1() {
        return this.list;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    @NotNull
    public final PEClassesListBean copy(@Nullable List<PEClassBean> list, @Nullable Integer pageSize, @Nullable Integer pageNum, @Nullable Boolean hasNext) {
        return new PEClassesListBean(list, pageSize, pageNum, hasNext);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PEClassesListBean)) {
            return false;
        }
        PEClassesListBean pEClassesListBean = (PEClassesListBean) other;
        return Intrinsics.areEqual(this.list, pEClassesListBean.list) && Intrinsics.areEqual(this.pageSize, pEClassesListBean.pageSize) && Intrinsics.areEqual(this.pageNum, pEClassesListBean.pageNum) && Intrinsics.areEqual(this.hasNext, pEClassesListBean.hasNext);
    }

    @Nullable
    public final Boolean getHasNext() {
        return this.hasNext;
    }

    @Nullable
    public final List<PEClassBean> getList() {
        return this.list;
    }

    @Nullable
    public final Integer getPageNum() {
        return this.pageNum;
    }

    @Nullable
    public final Integer getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        List<PEClassBean> list = this.list;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.pageSize;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pageNum;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.hasNext;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PEClassesListBean(list=" + this.list + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", hasNext=" + this.hasNext + ')';
    }

    public /* synthetic */ PEClassesListBean(List list, Integer num, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 1 : num2, (i & 8) != 0 ? Boolean.FALSE : bool);
    }
}

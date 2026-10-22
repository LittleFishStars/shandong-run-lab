package com.huachenjie.login.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006 "}, d2 = {"Lcom/huachenjie/login/bean/SearchSchoolInfoBean;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/common/bean/SchoolInfo;", "pageNum", "", "hasNext", "", "pageSize", "(Ljava/util/List;IZI)V", "getHasNext", "()Z", "setHasNext", "(Z)V", "getList", "()Ljava/util/List;", "getPageNum", "()I", "setPageNum", "(I)V", "getPageSize", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SearchSchoolInfoBean {
    private boolean hasNext;

    @NotNull
    private final List<SchoolInfo> list;
    private int pageNum;
    private final int pageSize;

    public SearchSchoolInfoBean() {
        this(null, 0, false, 0, 15, null);
    }

    public SearchSchoolInfoBean(@NotNull List<SchoolInfo> list, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
        this.pageNum = i;
        this.hasNext = z;
        this.pageSize = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchSchoolInfoBean copy$default(SearchSchoolInfoBean searchSchoolInfoBean, List list, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = searchSchoolInfoBean.list;
        }
        if ((i3 & 2) != 0) {
            i = searchSchoolInfoBean.pageNum;
        }
        if ((i3 & 4) != 0) {
            z = searchSchoolInfoBean.hasNext;
        }
        if ((i3 & 8) != 0) {
            i2 = searchSchoolInfoBean.pageSize;
        }
        return searchSchoolInfoBean.copy(list, i, z, i2);
    }

    @NotNull
    public final List<SchoolInfo> component1() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final SearchSchoolInfoBean copy(@NotNull List<SchoolInfo> list, int pageNum, boolean hasNext, int pageSize) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new SearchSchoolInfoBean(list, pageNum, hasNext, pageSize);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSchoolInfoBean)) {
            return false;
        }
        SearchSchoolInfoBean searchSchoolInfoBean = (SearchSchoolInfoBean) other;
        return Intrinsics.areEqual(this.list, searchSchoolInfoBean.list) && this.pageNum == searchSchoolInfoBean.pageNum && this.hasNext == searchSchoolInfoBean.hasNext && this.pageSize == searchSchoolInfoBean.pageSize;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    @NotNull
    public final List<SchoolInfo> getList() {
        return this.list;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.list.hashCode() * 31) + Integer.hashCode(this.pageNum)) * 31;
        boolean z = this.hasNext;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + Integer.hashCode(this.pageSize);
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    @NotNull
    public String toString() {
        return "SearchSchoolInfoBean(list=" + this.list + ", pageNum=" + this.pageNum + ", hasNext=" + this.hasNext + ", pageSize=" + this.pageSize + ')';
    }

    public /* synthetic */ SearchSchoolInfoBean(List list, int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
    }
}

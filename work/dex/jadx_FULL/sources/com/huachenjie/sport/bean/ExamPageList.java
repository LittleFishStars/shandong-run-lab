package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006#"}, d2 = {"Lcom/huachenjie/sport/bean/ExamPageList;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/sport/bean/ExamListData;", "pageSize", "", "pageNum", "hasNext", "", "(Ljava/util/List;IIZ)V", "getHasNext", "()Z", "setHasNext", "(Z)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getPageNum", "()I", "setPageNum", "(I)V", "getPageSize", "setPageSize", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamPageList {
    private boolean hasNext;

    @Nullable
    private List<ExamListData> list;
    private int pageNum;
    private int pageSize;

    public ExamPageList(@Nullable List<ExamListData> list, int i, int i2, boolean z) {
        this.list = list;
        this.pageSize = i;
        this.pageNum = i2;
        this.hasNext = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamPageList copy$default(ExamPageList examPageList, List list, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = examPageList.list;
        }
        if ((i3 & 2) != 0) {
            i = examPageList.pageSize;
        }
        if ((i3 & 4) != 0) {
            i2 = examPageList.pageNum;
        }
        if ((i3 & 8) != 0) {
            z = examPageList.hasNext;
        }
        return examPageList.copy(list, i, i2, z);
    }

    @Nullable
    public final List<ExamListData> component1() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    @NotNull
    public final ExamPageList copy(@Nullable List<ExamListData> list, int pageSize, int pageNum, boolean hasNext) {
        return new ExamPageList(list, pageSize, pageNum, hasNext);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamPageList)) {
            return false;
        }
        ExamPageList examPageList = (ExamPageList) other;
        return Intrinsics.areEqual(this.list, examPageList.list) && this.pageSize == examPageList.pageSize && this.pageNum == examPageList.pageNum && this.hasNext == examPageList.hasNext;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    @Nullable
    public final List<ExamListData> getList() {
        return this.list;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        List<ExamListData> list = this.list;
        int iHashCode = (((((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.pageSize)) * 31) + Integer.hashCode(this.pageNum)) * 31;
        boolean z = this.hasNext;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public final void setList(@Nullable List<ExamListData> list) {
        this.list = list;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    @NotNull
    public String toString() {
        return "ExamPageList(list=" + this.list + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", hasNext=" + this.hasNext + ')';
    }
}

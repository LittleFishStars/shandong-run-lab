package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.home.page.SignUpWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/home/bean/BrowseGoodsDetailBean;", "", SignUpWebActivity.A, "", "date", "browseCount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBrowseCount", "()I", "setBrowseCount", "(I)V", "getDate", "()Ljava/lang/String;", "getTaskConfigNo", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BrowseGoodsDetailBean {
    private int browseCount;

    @NotNull
    private final String date;

    @NotNull
    private final String taskConfigNo;

    public BrowseGoodsDetailBean(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, SignUpWebActivity.A);
        Intrinsics.checkNotNullParameter(str2, "date");
        this.taskConfigNo = str;
        this.date = str2;
        this.browseCount = i;
    }

    public static /* synthetic */ BrowseGoodsDetailBean copy$default(BrowseGoodsDetailBean browseGoodsDetailBean, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = browseGoodsDetailBean.taskConfigNo;
        }
        if ((i2 & 2) != 0) {
            str2 = browseGoodsDetailBean.date;
        }
        if ((i2 & 4) != 0) {
            i = browseGoodsDetailBean.browseCount;
        }
        return browseGoodsDetailBean.copy(str, str2, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTaskConfigNo() {
        return this.taskConfigNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBrowseCount() {
        return this.browseCount;
    }

    @NotNull
    public final BrowseGoodsDetailBean copy(@NotNull String taskConfigNo, @NotNull String date, int browseCount) {
        Intrinsics.checkNotNullParameter(taskConfigNo, SignUpWebActivity.A);
        Intrinsics.checkNotNullParameter(date, "date");
        return new BrowseGoodsDetailBean(taskConfigNo, date, browseCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrowseGoodsDetailBean)) {
            return false;
        }
        BrowseGoodsDetailBean browseGoodsDetailBean = (BrowseGoodsDetailBean) other;
        return Intrinsics.areEqual(this.taskConfigNo, browseGoodsDetailBean.taskConfigNo) && Intrinsics.areEqual(this.date, browseGoodsDetailBean.date) && this.browseCount == browseGoodsDetailBean.browseCount;
    }

    public final int getBrowseCount() {
        return this.browseCount;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final String getTaskConfigNo() {
        return this.taskConfigNo;
    }

    public int hashCode() {
        return (((this.taskConfigNo.hashCode() * 31) + this.date.hashCode()) * 31) + Integer.hashCode(this.browseCount);
    }

    public final void setBrowseCount(int i) {
        this.browseCount = i;
    }

    @NotNull
    public String toString() {
        return "BrowseGoodsDetailBean(taskConfigNo=" + this.taskConfigNo + ", date=" + this.date + ", browseCount=" + this.browseCount + ')';
    }
}

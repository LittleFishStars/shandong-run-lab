package com.huachenjie.works.bean.search;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/bean/search/SearchHotSpotItemBean;", "", "subjectName", "", yj7.b.b, "popularityValue", "indexFormat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIndexFormat", "()Ljava/lang/String;", "setIndexFormat", "(Ljava/lang/String;)V", "getPopularityValue", "getSubjectName", "getSubjectNo", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SearchHotSpotItemBean {

    @NotNull
    private String indexFormat;

    @NotNull
    private final String popularityValue;

    @NotNull
    private final String subjectName;

    @NotNull
    private final String subjectNo;

    public SearchHotSpotItemBean() {
        this(null, null, null, null, 15, null);
    }

    public SearchHotSpotItemBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "subjectName");
        Intrinsics.checkNotNullParameter(str2, yj7.b.b);
        Intrinsics.checkNotNullParameter(str3, "popularityValue");
        Intrinsics.checkNotNullParameter(str4, "indexFormat");
        this.subjectName = str;
        this.subjectNo = str2;
        this.popularityValue = str3;
        this.indexFormat = str4;
    }

    public static /* synthetic */ SearchHotSpotItemBean copy$default(SearchHotSpotItemBean searchHotSpotItemBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchHotSpotItemBean.subjectName;
        }
        if ((i & 2) != 0) {
            str2 = searchHotSpotItemBean.subjectNo;
        }
        if ((i & 4) != 0) {
            str3 = searchHotSpotItemBean.popularityValue;
        }
        if ((i & 8) != 0) {
            str4 = searchHotSpotItemBean.indexFormat;
        }
        return searchHotSpotItemBean.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIndexFormat() {
        return this.indexFormat;
    }

    @NotNull
    public final SearchHotSpotItemBean copy(@NotNull String subjectName, @NotNull String subjectNo, @NotNull String popularityValue, @NotNull String indexFormat) {
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.b);
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        Intrinsics.checkNotNullParameter(indexFormat, "indexFormat");
        return new SearchHotSpotItemBean(subjectName, subjectNo, popularityValue, indexFormat);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchHotSpotItemBean)) {
            return false;
        }
        SearchHotSpotItemBean searchHotSpotItemBean = (SearchHotSpotItemBean) other;
        return Intrinsics.areEqual(this.subjectName, searchHotSpotItemBean.subjectName) && Intrinsics.areEqual(this.subjectNo, searchHotSpotItemBean.subjectNo) && Intrinsics.areEqual(this.popularityValue, searchHotSpotItemBean.popularityValue) && Intrinsics.areEqual(this.indexFormat, searchHotSpotItemBean.indexFormat);
    }

    @NotNull
    public final String getIndexFormat() {
        return this.indexFormat;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    public int hashCode() {
        return (((((this.subjectName.hashCode() * 31) + this.subjectNo.hashCode()) * 31) + this.popularityValue.hashCode()) * 31) + this.indexFormat.hashCode();
    }

    public final void setIndexFormat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.indexFormat = str;
    }

    @NotNull
    public String toString() {
        return "SearchHotSpotItemBean(subjectName=" + this.subjectName + ", subjectNo=" + this.subjectNo + ", popularityValue=" + this.popularityValue + ", indexFormat=" + this.indexFormat + ')';
    }

    public /* synthetic */ SearchHotSpotItemBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}

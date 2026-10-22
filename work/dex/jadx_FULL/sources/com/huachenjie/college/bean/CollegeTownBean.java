package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/college/bean/CollegeTownBean;", "", "bannerList", "", "Lcom/huachenjie/college/bean/CollegeTownBannerBean;", "typeList", "Lcom/huachenjie/college/bean/CollegeRecommendBean;", "livePostFeedList", "Lcom/huachenjie/college/bean/CollegePostBean;", "excludeSchool", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)V", "getBannerList", "()Ljava/util/List;", "getExcludeSchool", "()Z", "getLivePostFeedList", "getTypeList", "setTypeList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollegeTownBean {

    @NotNull
    private final List<CollegeTownBannerBean> bannerList;
    private final boolean excludeSchool;

    @NotNull
    private final List<CollegePostBean> livePostFeedList;

    @NotNull
    private List<CollegeRecommendBean> typeList;

    public CollegeTownBean() {
        this(null, null, null, false, 15, null);
    }

    public CollegeTownBean(@NotNull List<CollegeTownBannerBean> list, @NotNull List<CollegeRecommendBean> list2, @NotNull List<CollegePostBean> list3, boolean z) {
        Intrinsics.checkNotNullParameter(list, "bannerList");
        Intrinsics.checkNotNullParameter(list2, "typeList");
        Intrinsics.checkNotNullParameter(list3, "livePostFeedList");
        this.bannerList = list;
        this.typeList = list2;
        this.livePostFeedList = list3;
        this.excludeSchool = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollegeTownBean copy$default(CollegeTownBean collegeTownBean, List list, List list2, List list3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = collegeTownBean.bannerList;
        }
        if ((i & 2) != 0) {
            list2 = collegeTownBean.typeList;
        }
        if ((i & 4) != 0) {
            list3 = collegeTownBean.livePostFeedList;
        }
        if ((i & 8) != 0) {
            z = collegeTownBean.excludeSchool;
        }
        return collegeTownBean.copy(list, list2, list3, z);
    }

    @NotNull
    public final List<CollegeTownBannerBean> component1() {
        return this.bannerList;
    }

    @NotNull
    public final List<CollegeRecommendBean> component2() {
        return this.typeList;
    }

    @NotNull
    public final List<CollegePostBean> component3() {
        return this.livePostFeedList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getExcludeSchool() {
        return this.excludeSchool;
    }

    @NotNull
    public final CollegeTownBean copy(@NotNull List<CollegeTownBannerBean> bannerList, @NotNull List<CollegeRecommendBean> typeList, @NotNull List<CollegePostBean> livePostFeedList, boolean excludeSchool) {
        Intrinsics.checkNotNullParameter(bannerList, "bannerList");
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        Intrinsics.checkNotNullParameter(livePostFeedList, "livePostFeedList");
        return new CollegeTownBean(bannerList, typeList, livePostFeedList, excludeSchool);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollegeTownBean)) {
            return false;
        }
        CollegeTownBean collegeTownBean = (CollegeTownBean) other;
        return Intrinsics.areEqual(this.bannerList, collegeTownBean.bannerList) && Intrinsics.areEqual(this.typeList, collegeTownBean.typeList) && Intrinsics.areEqual(this.livePostFeedList, collegeTownBean.livePostFeedList) && this.excludeSchool == collegeTownBean.excludeSchool;
    }

    @NotNull
    public final List<CollegeTownBannerBean> getBannerList() {
        return this.bannerList;
    }

    public final boolean getExcludeSchool() {
        return this.excludeSchool;
    }

    @NotNull
    public final List<CollegePostBean> getLivePostFeedList() {
        return this.livePostFeedList;
    }

    @NotNull
    public final List<CollegeRecommendBean> getTypeList() {
        return this.typeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.bannerList.hashCode() * 31) + this.typeList.hashCode()) * 31) + this.livePostFeedList.hashCode()) * 31;
        boolean z = this.excludeSchool;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setTypeList(@NotNull List<CollegeRecommendBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typeList = list;
    }

    @NotNull
    public String toString() {
        return "CollegeTownBean(bannerList=" + this.bannerList + ", typeList=" + this.typeList + ", livePostFeedList=" + this.livePostFeedList + ", excludeSchool=" + this.excludeSchool + ')';
    }

    public /* synthetic */ CollegeTownBean(List list, List list2, List list3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2, (i & 4) != 0 ? new ArrayList() : list3, (i & 8) != 0 ? false : z);
    }
}

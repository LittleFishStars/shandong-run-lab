package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/college/bean/CollegeRecommendBean;", "", "name", "", "type", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/college/bean/RecommendItemBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollegeRecommendBean {

    @NotNull
    private List<? extends RecommendItemBean> list;

    @NotNull
    private final String name;

    @NotNull
    private final String type;

    public CollegeRecommendBean() {
        this(null, null, null, 7, null);
    }

    public CollegeRecommendBean(@NotNull String str, @NotNull String str2, @NotNull List<? extends RecommendItemBean> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.name = str;
        this.type = str2;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollegeRecommendBean copy$default(CollegeRecommendBean collegeRecommendBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collegeRecommendBean.name;
        }
        if ((i & 2) != 0) {
            str2 = collegeRecommendBean.type;
        }
        if ((i & 4) != 0) {
            list = collegeRecommendBean.list;
        }
        return collegeRecommendBean.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final List<RecommendItemBean> component3() {
        return this.list;
    }

    @NotNull
    public final CollegeRecommendBean copy(@NotNull String name, @NotNull String type, @NotNull List<? extends RecommendItemBean> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new CollegeRecommendBean(name, type, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollegeRecommendBean)) {
            return false;
        }
        CollegeRecommendBean collegeRecommendBean = (CollegeRecommendBean) other;
        return Intrinsics.areEqual(this.name, collegeRecommendBean.name) && Intrinsics.areEqual(this.type, collegeRecommendBean.type) && Intrinsics.areEqual(this.list, collegeRecommendBean.list);
    }

    @NotNull
    public final List<RecommendItemBean> getList() {
        return this.list;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.list.hashCode();
    }

    public final void setList(@NotNull List<? extends RecommendItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    @NotNull
    public String toString() {
        return "CollegeRecommendBean(name=" + this.name + ", type=" + this.type + ", list=" + this.list + ')';
    }

    public /* synthetic */ CollegeRecommendBean(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : list);
    }
}

package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/HuodongDetail;", "", "activityDescription", "", "imgsList", "", "Lcom/huachenjie/sport/bean/HuodongDetailImgs;", "(Ljava/lang/String;Ljava/util/List;)V", "getActivityDescription", "()Ljava/lang/String;", "getImgsList", "()Ljava/util/List;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuodongDetail {

    @NotNull
    private final String activityDescription;

    @NotNull
    private final List<HuodongDetailImgs> imgsList;

    /* JADX WARN: Multi-variable type inference failed */
    public HuodongDetail() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public HuodongDetail(@NotNull String str, @NotNull List<HuodongDetailImgs> list) {
        Intrinsics.checkNotNullParameter(str, "activityDescription");
        Intrinsics.checkNotNullParameter(list, "imgsList");
        this.activityDescription = str;
        this.imgsList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HuodongDetail copy$default(HuodongDetail huodongDetail, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = huodongDetail.activityDescription;
        }
        if ((i & 2) != 0) {
            list = huodongDetail.imgsList;
        }
        return huodongDetail.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityDescription() {
        return this.activityDescription;
    }

    @NotNull
    public final List<HuodongDetailImgs> component2() {
        return this.imgsList;
    }

    @NotNull
    public final HuodongDetail copy(@NotNull String activityDescription, @NotNull List<HuodongDetailImgs> imgsList) {
        Intrinsics.checkNotNullParameter(activityDescription, "activityDescription");
        Intrinsics.checkNotNullParameter(imgsList, "imgsList");
        return new HuodongDetail(activityDescription, imgsList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuodongDetail)) {
            return false;
        }
        HuodongDetail huodongDetail = (HuodongDetail) other;
        return Intrinsics.areEqual(this.activityDescription, huodongDetail.activityDescription) && Intrinsics.areEqual(this.imgsList, huodongDetail.imgsList);
    }

    @NotNull
    public final String getActivityDescription() {
        return this.activityDescription;
    }

    @NotNull
    public final List<HuodongDetailImgs> getImgsList() {
        return this.imgsList;
    }

    public int hashCode() {
        return (this.activityDescription.hashCode() * 31) + this.imgsList.hashCode();
    }

    @NotNull
    public String toString() {
        return "HuodongDetail(activityDescription=" + this.activityDescription + ", imgsList=" + this.imgsList + ')';
    }

    public /* synthetic */ HuodongDetail(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}

package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/works/bean/GoodsRecommendData;", "Landroid/os/Parcelable;", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/works/bean/RecommendGoodsBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "formatGoodRecommendNum", "getRecommendGoodName", "", "getRecommendGoodUrl", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsRecommendData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsRecommendData> CREATOR = new Creator();

    @NotNull
    private final List<RecommendGoodsBean> list;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsRecommendData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsRecommendData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(RecommendGoodsBean.CREATOR.createFromParcel(parcel));
            }
            return new GoodsRecommendData(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsRecommendData[] newArray(int i) {
            return new GoodsRecommendData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GoodsRecommendData() {
        List list = null;
        this(list, 1, list);
    }

    public GoodsRecommendData(@NotNull List<RecommendGoodsBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodsRecommendData copy$default(GoodsRecommendData goodsRecommendData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = goodsRecommendData.list;
        }
        return goodsRecommendData.copy(list);
    }

    @NotNull
    public final List<RecommendGoodsBean> component1() {
        return this.list;
    }

    @NotNull
    public final GoodsRecommendData copy(@NotNull List<RecommendGoodsBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new GoodsRecommendData(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoodsRecommendData) && Intrinsics.areEqual(this.list, ((GoodsRecommendData) other).list);
    }

    public final int formatGoodRecommendNum() {
        List<RecommendGoodsBean> list = this.list;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.list.size();
    }

    @NotNull
    public final List<RecommendGoodsBean> getList() {
        return this.list;
    }

    @NotNull
    public final String getRecommendGoodName() {
        List<RecommendGoodsBean> list = this.list;
        if (list == null || list.isEmpty()) {
            return "";
        }
        int size = this.list.size();
        if (size == 1) {
            return this.list.get(0).getGoodsName();
        }
        return "TA提到了" + size + "个商品";
    }

    @NotNull
    public final String getRecommendGoodUrl() {
        List<RecommendGoodsBean> list = this.list;
        return (list == null || list.isEmpty()) ? "" : this.list.get(0).formatImageUrl();
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsRecommendData(list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<RecommendGoodsBean> list = this.list;
        parcel.writeInt(list.size());
        Iterator<RecommendGoodsBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ GoodsRecommendData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}

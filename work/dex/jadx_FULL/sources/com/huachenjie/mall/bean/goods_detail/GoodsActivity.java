package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsActivity;", "Landroid/os/Parcelable;", "activityTypeValue", "", "activityNo", "", "materialList", "", "Lcom/huachenjie/mall/bean/goods_detail/GoodsActivityMaterial;", "(ILjava/lang/String;Ljava/util/List;)V", "getActivityNo", "()Ljava/lang/String;", "getActivityTypeValue", "()I", "getMaterialList", "()Ljava/util/List;", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsActivity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsActivity> CREATOR = new Creator();

    @NotNull
    private final String activityNo;
    private final int activityTypeValue;

    @NotNull
    private final List<GoodsActivityMaterial> materialList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsActivity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsActivity createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(GoodsActivityMaterial.CREATOR.createFromParcel(parcel));
            }
            return new GoodsActivity(i, string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsActivity[] newArray(int i) {
            return new GoodsActivity[i];
        }
    }

    public GoodsActivity() {
        this(0, null, null, 7, null);
    }

    public GoodsActivity(int i, @NotNull String str, @NotNull List<GoodsActivityMaterial> list) {
        Intrinsics.checkNotNullParameter(str, "activityNo");
        Intrinsics.checkNotNullParameter(list, "materialList");
        this.activityTypeValue = i;
        this.activityNo = str;
        this.materialList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodsActivity copy$default(GoodsActivity goodsActivity, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = goodsActivity.activityTypeValue;
        }
        if ((i2 & 2) != 0) {
            str = goodsActivity.activityNo;
        }
        if ((i2 & 4) != 0) {
            list = goodsActivity.materialList;
        }
        return goodsActivity.copy(i, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getActivityTypeValue() {
        return this.activityTypeValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityNo() {
        return this.activityNo;
    }

    @NotNull
    public final List<GoodsActivityMaterial> component3() {
        return this.materialList;
    }

    @NotNull
    public final GoodsActivity copy(int activityTypeValue, @NotNull String activityNo, @NotNull List<GoodsActivityMaterial> materialList) {
        Intrinsics.checkNotNullParameter(activityNo, "activityNo");
        Intrinsics.checkNotNullParameter(materialList, "materialList");
        return new GoodsActivity(activityTypeValue, activityNo, materialList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsActivity)) {
            return false;
        }
        GoodsActivity goodsActivity = (GoodsActivity) other;
        return this.activityTypeValue == goodsActivity.activityTypeValue && Intrinsics.areEqual(this.activityNo, goodsActivity.activityNo) && Intrinsics.areEqual(this.materialList, goodsActivity.materialList);
    }

    @NotNull
    public final String getActivityNo() {
        return this.activityNo;
    }

    public final int getActivityTypeValue() {
        return this.activityTypeValue;
    }

    @NotNull
    public final List<GoodsActivityMaterial> getMaterialList() {
        return this.materialList;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.activityTypeValue) * 31) + this.activityNo.hashCode()) * 31) + this.materialList.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsActivity(activityTypeValue=" + this.activityTypeValue + ", activityNo=" + this.activityNo + ", materialList=" + this.materialList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.activityTypeValue);
        parcel.writeString(this.activityNo);
        List<GoodsActivityMaterial> list = this.materialList;
        parcel.writeInt(list.size());
        Iterator<GoodsActivityMaterial> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ GoodsActivity(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }
}

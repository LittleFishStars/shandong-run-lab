package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpec;", "Landroid/os/Parcelable;", "specName", "", "specNo", "pictureEnable", "", "specValueList", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;)V", "getPictureEnable", "()Z", "getSpecName", "()Ljava/lang/String;", "getSpecNo", "getSpecValueList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailSpec implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailSpec> CREATOR = new Creator();
    private final boolean pictureEnable;

    @NotNull
    private final String specName;

    @NotNull
    private final String specNo;

    @NotNull
    private final ArrayList<GoodsDetailSpecValue> specValueList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailSpec> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSpec createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(GoodsDetailSpecValue.CREATOR.createFromParcel(parcel));
            }
            return new GoodsDetailSpec(string, string2, z, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSpec[] newArray(int i) {
            return new GoodsDetailSpec[i];
        }
    }

    public GoodsDetailSpec() {
        this(null, null, false, null, 15, null);
    }

    public GoodsDetailSpec(@NotNull String str, @NotNull String str2, boolean z, @NotNull ArrayList<GoodsDetailSpecValue> arrayList) {
        Intrinsics.checkNotNullParameter(str, "specName");
        Intrinsics.checkNotNullParameter(str2, "specNo");
        Intrinsics.checkNotNullParameter(arrayList, "specValueList");
        this.specName = str;
        this.specNo = str2;
        this.pictureEnable = z;
        this.specValueList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodsDetailSpec copy$default(GoodsDetailSpec goodsDetailSpec, String str, String str2, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsDetailSpec.specName;
        }
        if ((i & 2) != 0) {
            str2 = goodsDetailSpec.specNo;
        }
        if ((i & 4) != 0) {
            z = goodsDetailSpec.pictureEnable;
        }
        if ((i & 8) != 0) {
            arrayList = goodsDetailSpec.specValueList;
        }
        return goodsDetailSpec.copy(str, str2, z, arrayList);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSpecName() {
        return this.specName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSpecNo() {
        return this.specNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPictureEnable() {
        return this.pictureEnable;
    }

    @NotNull
    public final ArrayList<GoodsDetailSpecValue> component4() {
        return this.specValueList;
    }

    @NotNull
    public final GoodsDetailSpec copy(@NotNull String specName, @NotNull String specNo, boolean pictureEnable, @NotNull ArrayList<GoodsDetailSpecValue> specValueList) {
        Intrinsics.checkNotNullParameter(specName, "specName");
        Intrinsics.checkNotNullParameter(specNo, "specNo");
        Intrinsics.checkNotNullParameter(specValueList, "specValueList");
        return new GoodsDetailSpec(specName, specNo, pictureEnable, specValueList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailSpec)) {
            return false;
        }
        GoodsDetailSpec goodsDetailSpec = (GoodsDetailSpec) other;
        return Intrinsics.areEqual(this.specName, goodsDetailSpec.specName) && Intrinsics.areEqual(this.specNo, goodsDetailSpec.specNo) && this.pictureEnable == goodsDetailSpec.pictureEnable && Intrinsics.areEqual(this.specValueList, goodsDetailSpec.specValueList);
    }

    public final boolean getPictureEnable() {
        return this.pictureEnable;
    }

    @NotNull
    public final String getSpecName() {
        return this.specName;
    }

    @NotNull
    public final String getSpecNo() {
        return this.specNo;
    }

    @NotNull
    public final ArrayList<GoodsDetailSpecValue> getSpecValueList() {
        return this.specValueList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.specName.hashCode() * 31) + this.specNo.hashCode()) * 31;
        boolean z = this.pictureEnable;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.specValueList.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsDetailSpec(specName=" + this.specName + ", specNo=" + this.specNo + ", pictureEnable=" + this.pictureEnable + ", specValueList=" + this.specValueList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.specName);
        parcel.writeString(this.specNo);
        parcel.writeInt(this.pictureEnable ? 1 : 0);
        ArrayList<GoodsDetailSpecValue> arrayList = this.specValueList;
        parcel.writeInt(arrayList.size());
        Iterator<GoodsDetailSpecValue> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ GoodsDetailSpec(String str, String str2, boolean z, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new ArrayList() : arrayList);
    }
}

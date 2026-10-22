package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailAttribute;", "Landroid/os/Parcelable;", "attributesName", "", "attributesValues", "", "(Ljava/lang/String;Ljava/util/List;)V", "getAttributesName", "()Ljava/lang/String;", "getAttributesValues", "()Ljava/util/List;", "attributesValuesStr", "getAttributesValuesStr", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoodsDetailBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodsDetailBean.kt\ncom/huachenjie/mall/bean/goods_detail/GoodsDetailAttribute\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,418:1\n1864#2,3:419\n*S KotlinDebug\n*F\n+ 1 GoodsDetailBean.kt\ncom/huachenjie/mall/bean/goods_detail/GoodsDetailAttribute\n*L\n241#1:419,3\n*E\n"})
public final /* data */ class GoodsDetailAttribute implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailAttribute> CREATOR = new Creator();

    @NotNull
    private final String attributesName;

    @NotNull
    private final List<String> attributesValues;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailAttribute> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsDetailAttribute(parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailAttribute[] newArray(int i) {
            return new GoodsDetailAttribute[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GoodsDetailAttribute() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public GoodsDetailAttribute(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "attributesName");
        Intrinsics.checkNotNullParameter(list, "attributesValues");
        this.attributesName = str;
        this.attributesValues = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodsDetailAttribute copy$default(GoodsDetailAttribute goodsDetailAttribute, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsDetailAttribute.attributesName;
        }
        if ((i & 2) != 0) {
            list = goodsDetailAttribute.attributesValues;
        }
        return goodsDetailAttribute.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttributesName() {
        return this.attributesName;
    }

    @NotNull
    public final List<String> component2() {
        return this.attributesValues;
    }

    @NotNull
    public final GoodsDetailAttribute copy(@NotNull String attributesName, @NotNull List<String> attributesValues) {
        Intrinsics.checkNotNullParameter(attributesName, "attributesName");
        Intrinsics.checkNotNullParameter(attributesValues, "attributesValues");
        return new GoodsDetailAttribute(attributesName, attributesValues);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailAttribute)) {
            return false;
        }
        GoodsDetailAttribute goodsDetailAttribute = (GoodsDetailAttribute) other;
        return Intrinsics.areEqual(this.attributesName, goodsDetailAttribute.attributesName) && Intrinsics.areEqual(this.attributesValues, goodsDetailAttribute.attributesValues);
    }

    @NotNull
    public final String getAttributesName() {
        return this.attributesName;
    }

    @NotNull
    public final List<String> getAttributesValues() {
        return this.attributesValues;
    }

    @NotNull
    public final String getAttributesValuesStr() {
        int i = 0;
        String str = "";
        for (Object obj : this.attributesValues) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            str = str + (i > 0 ? "、" : "") + str2;
            i = i2;
        }
        return str;
    }

    public int hashCode() {
        return (this.attributesName.hashCode() * 31) + this.attributesValues.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsDetailAttribute(attributesName=" + this.attributesName + ", attributesValues=" + this.attributesValues + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.attributesName);
        parcel.writeStringList(this.attributesValues);
    }

    public /* synthetic */ GoodsDetailAttribute(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}

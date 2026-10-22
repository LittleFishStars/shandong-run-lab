package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ir5;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\u0006\u0010&\u001a\u00020\u0006J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006."}, d2 = {"Lcom/huachenjie/social_contact/bean/PayBean;", "Landroid/os/Parcelable;", "type", "", "goodsSubType", "goodsCode", "", "payNum", "", "payDes", "(IILjava/lang/String;FLjava/lang/String;)V", "getGoodsCode", "()Ljava/lang/String;", "setGoodsCode", "(Ljava/lang/String;)V", "getGoodsSubType", "()I", "setGoodsSubType", "(I)V", "getPayDes", "setPayDes", "getPayNum", "()F", "setPayNum", "(F)V", "getType", "setType", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getPatNumStr", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PayBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PayBean> CREATOR = new Creator();

    @Nullable
    private String goodsCode;
    private int goodsSubType;

    @NotNull
    private String payDes;
    private float payNum;
    private int type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PayBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PayBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PayBean(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readFloat(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PayBean[] newArray(int i) {
            return new PayBean[i];
        }
    }

    public PayBean(int i, int i2, @Nullable String str, float f, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "payDes");
        this.type = i;
        this.goodsSubType = i2;
        this.goodsCode = str;
        this.payNum = f;
        this.payDes = str2;
    }

    public static /* synthetic */ PayBean copy$default(PayBean payBean, int i, int i2, String str, float f, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = payBean.type;
        }
        if ((i3 & 2) != 0) {
            i2 = payBean.goodsSubType;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = payBean.goodsCode;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            f = payBean.payNum;
        }
        float f2 = f;
        if ((i3 & 16) != 0) {
            str2 = payBean.payDes;
        }
        return payBean.copy(i, i4, str3, f2, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGoodsSubType() {
        return this.goodsSubType;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoodsCode() {
        return this.goodsCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getPayNum() {
        return this.payNum;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPayDes() {
        return this.payDes;
    }

    @NotNull
    public final PayBean copy(int type, int goodsSubType, @Nullable String goodsCode, float payNum, @NotNull String payDes) {
        Intrinsics.checkNotNullParameter(payDes, "payDes");
        return new PayBean(type, goodsSubType, goodsCode, payNum, payDes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayBean)) {
            return false;
        }
        PayBean payBean = (PayBean) other;
        return this.type == payBean.type && this.goodsSubType == payBean.goodsSubType && Intrinsics.areEqual(this.goodsCode, payBean.goodsCode) && Float.compare(this.payNum, payBean.payNum) == 0 && Intrinsics.areEqual(this.payDes, payBean.payDes);
    }

    @Nullable
    public final String getGoodsCode() {
        return this.goodsCode;
    }

    public final int getGoodsSubType() {
        return this.goodsSubType;
    }

    @NotNull
    public final String getPatNumStr() {
        String strA = ir5.a(Float.valueOf(this.payNum));
        Intrinsics.checkNotNullExpressionValue(strA, "getMoneyStr(payNum)");
        return strA;
    }

    @NotNull
    public final String getPayDes() {
        return this.payDes;
    }

    public final float getPayNum() {
        return this.payNum;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.goodsSubType)) * 31;
        String str = this.goodsCode;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.hashCode(this.payNum)) * 31) + this.payDes.hashCode();
    }

    public final void setGoodsCode(@Nullable String str) {
        this.goodsCode = str;
    }

    public final void setGoodsSubType(int i) {
        this.goodsSubType = i;
    }

    public final void setPayDes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payDes = str;
    }

    public final void setPayNum(float f) {
        this.payNum = f;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "PayBean(type=" + this.type + ", goodsSubType=" + this.goodsSubType + ", goodsCode=" + this.goodsCode + ", payNum=" + this.payNum + ", payDes=" + this.payDes + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.type);
        parcel.writeInt(this.goodsSubType);
        parcel.writeString(this.goodsCode);
        parcel.writeFloat(this.payNum);
        parcel.writeString(this.payDes);
    }

    public /* synthetic */ PayBean(int i, int i2, String str, float f, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, i2, str, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? "" : str2);
    }
}

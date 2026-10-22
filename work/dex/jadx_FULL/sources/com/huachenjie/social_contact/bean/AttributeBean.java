package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/bean/AttributeBean;", "Landroid/os/Parcelable;", "attributeCode", "", "attributeValue", "(II)V", "getAttributeCode", "()I", "getAttributeValue", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttributeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AttributeBean> CREATOR = new Creator();
    private final int attributeCode;
    private final int attributeValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AttributeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AttributeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AttributeBean(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AttributeBean[] newArray(int i) {
            return new AttributeBean[i];
        }
    }

    public AttributeBean(int i, int i2) {
        this.attributeCode = i;
        this.attributeValue = i2;
    }

    public static /* synthetic */ AttributeBean copy$default(AttributeBean attributeBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = attributeBean.attributeCode;
        }
        if ((i3 & 2) != 0) {
            i2 = attributeBean.attributeValue;
        }
        return attributeBean.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAttributeCode() {
        return this.attributeCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAttributeValue() {
        return this.attributeValue;
    }

    @NotNull
    public final AttributeBean copy(int attributeCode, int attributeValue) {
        return new AttributeBean(attributeCode, attributeValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributeBean)) {
            return false;
        }
        AttributeBean attributeBean = (AttributeBean) other;
        return this.attributeCode == attributeBean.attributeCode && this.attributeValue == attributeBean.attributeValue;
    }

    public final int getAttributeCode() {
        return this.attributeCode;
    }

    public final int getAttributeValue() {
        return this.attributeValue;
    }

    public int hashCode() {
        return (Integer.hashCode(this.attributeCode) * 31) + Integer.hashCode(this.attributeValue);
    }

    @NotNull
    public String toString() {
        return "AttributeBean(attributeCode=" + this.attributeCode + ", attributeValue=" + this.attributeValue + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.attributeCode);
        parcel.writeInt(this.attributeValue);
    }
}

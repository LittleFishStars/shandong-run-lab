package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/huachenjie/social_contact/bean/ModelListBean;", "Landroid/os/Parcelable;", "modelName", "", "metaverseModelCode", "modelImg", "wearStatus", "", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getMetaverseModelCode", "()Ljava/lang/String;", "setMetaverseModelCode", "(Ljava/lang/String;)V", "getModelImg", "getModelName", "getType", "()I", "getWearStatus", "setWearStatus", "(I)V", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ModelListBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ModelListBean> CREATOR = new Creator();

    @NotNull
    private String metaverseModelCode;

    @NotNull
    private final String modelImg;

    @NotNull
    private final String modelName;
    private final int type;
    private int wearStatus;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ModelListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelListBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ModelListBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelListBean[] newArray(int i) {
            return new ModelListBean[i];
        }
    }

    public ModelListBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "modelName");
        Intrinsics.checkNotNullParameter(str2, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(str3, "modelImg");
        this.modelName = str;
        this.metaverseModelCode = str2;
        this.modelImg = str3;
        this.wearStatus = i;
        this.type = i2;
    }

    public static /* synthetic */ ModelListBean copy$default(ModelListBean modelListBean, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = modelListBean.modelName;
        }
        if ((i3 & 2) != 0) {
            str2 = modelListBean.metaverseModelCode;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = modelListBean.modelImg;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = modelListBean.wearStatus;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = modelListBean.type;
        }
        return modelListBean.copy(str, str4, str5, i4, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getModelImg() {
        return this.modelImg;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWearStatus() {
        return this.wearStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final ModelListBean copy(@NotNull String modelName, @NotNull String metaverseModelCode, @NotNull String modelImg, int wearStatus, int type) {
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(modelImg, "modelImg");
        return new ModelListBean(modelName, metaverseModelCode, modelImg, wearStatus, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelListBean)) {
            return false;
        }
        ModelListBean modelListBean = (ModelListBean) other;
        return Intrinsics.areEqual(this.modelName, modelListBean.modelName) && Intrinsics.areEqual(this.metaverseModelCode, modelListBean.metaverseModelCode) && Intrinsics.areEqual(this.modelImg, modelListBean.modelImg) && this.wearStatus == modelListBean.wearStatus && this.type == modelListBean.type;
    }

    @NotNull
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    public final String getModelImg() {
        return this.modelImg;
    }

    @NotNull
    public final String getModelName() {
        return this.modelName;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWearStatus() {
        return this.wearStatus;
    }

    public int hashCode() {
        return (((((((this.modelName.hashCode() * 31) + this.metaverseModelCode.hashCode()) * 31) + this.modelImg.hashCode()) * 31) + Integer.hashCode(this.wearStatus)) * 31) + Integer.hashCode(this.type);
    }

    public final void setMetaverseModelCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.metaverseModelCode = str;
    }

    public final void setWearStatus(int i) {
        this.wearStatus = i;
    }

    @NotNull
    public String toString() {
        return "ModelListBean(modelName=" + this.modelName + ", metaverseModelCode=" + this.metaverseModelCode + ", modelImg=" + this.modelImg + ", wearStatus=" + this.wearStatus + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.modelName);
        parcel.writeString(this.metaverseModelCode);
        parcel.writeString(this.modelImg);
        parcel.writeInt(this.wearStatus);
        parcel.writeInt(this.type);
    }

    public /* synthetic */ ModelListBean(String str, String str2, String str3, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, (i3 & 16) != 0 ? 0 : i2);
    }
}

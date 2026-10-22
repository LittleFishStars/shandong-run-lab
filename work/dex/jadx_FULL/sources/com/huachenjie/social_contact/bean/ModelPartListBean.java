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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/huachenjie/social_contact/bean/ModelPartListBean;", "Landroid/os/Parcelable;", "metaverseModelPartCode", "", "modelImg", "modelName", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMetaverseModelPartCode", "()Ljava/lang/String;", "setMetaverseModelPartCode", "(Ljava/lang/String;)V", "getModelImg", "setModelImg", "getModelName", "setModelName", "getType", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ModelPartListBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ModelPartListBean> CREATOR = new Creator();

    @NotNull
    private String metaverseModelPartCode;

    @NotNull
    private String modelImg;

    @NotNull
    private String modelName;
    private final int type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ModelPartListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelPartListBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ModelPartListBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelPartListBean[] newArray(int i) {
            return new ModelPartListBean[i];
        }
    }

    public ModelPartListBean() {
        this(null, null, null, 0, 15, null);
    }

    public ModelPartListBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "metaverseModelPartCode");
        Intrinsics.checkNotNullParameter(str2, "modelImg");
        Intrinsics.checkNotNullParameter(str3, "modelName");
        this.metaverseModelPartCode = str;
        this.modelImg = str2;
        this.modelName = str3;
        this.type = i;
    }

    public static /* synthetic */ ModelPartListBean copy$default(ModelPartListBean modelPartListBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = modelPartListBean.metaverseModelPartCode;
        }
        if ((i2 & 2) != 0) {
            str2 = modelPartListBean.modelImg;
        }
        if ((i2 & 4) != 0) {
            str3 = modelPartListBean.modelName;
        }
        if ((i2 & 8) != 0) {
            i = modelPartListBean.type;
        }
        return modelPartListBean.copy(str, str2, str3, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseModelPartCode() {
        return this.metaverseModelPartCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModelImg() {
        return this.modelImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final ModelPartListBean copy(@NotNull String metaverseModelPartCode, @NotNull String modelImg, @NotNull String modelName, int type) {
        Intrinsics.checkNotNullParameter(metaverseModelPartCode, "metaverseModelPartCode");
        Intrinsics.checkNotNullParameter(modelImg, "modelImg");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        return new ModelPartListBean(metaverseModelPartCode, modelImg, modelName, type);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPartListBean)) {
            return false;
        }
        ModelPartListBean modelPartListBean = (ModelPartListBean) other;
        return Intrinsics.areEqual(this.metaverseModelPartCode, modelPartListBean.metaverseModelPartCode) && Intrinsics.areEqual(this.modelImg, modelPartListBean.modelImg) && Intrinsics.areEqual(this.modelName, modelPartListBean.modelName) && this.type == modelPartListBean.type;
    }

    @NotNull
    public final String getMetaverseModelPartCode() {
        return this.metaverseModelPartCode;
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

    public int hashCode() {
        return (((((this.metaverseModelPartCode.hashCode() * 31) + this.modelImg.hashCode()) * 31) + this.modelName.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    public final void setMetaverseModelPartCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.metaverseModelPartCode = str;
    }

    public final void setModelImg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelImg = str;
    }

    public final void setModelName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelName = str;
    }

    @NotNull
    public String toString() {
        return "ModelPartListBean(metaverseModelPartCode=" + this.metaverseModelPartCode + ", modelImg=" + this.modelImg + ", modelName=" + this.modelName + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.metaverseModelPartCode);
        parcel.writeString(this.modelImg);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.type);
    }

    public /* synthetic */ ModelPartListBean(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}

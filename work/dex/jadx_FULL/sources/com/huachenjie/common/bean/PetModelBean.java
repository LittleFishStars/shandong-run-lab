package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/common/bean/PetModelBean;", "Landroid/os/Parcelable;", "metaverseModelCode", "", "modelImg", "(Ljava/lang/String;Ljava/lang/String;)V", "getMetaverseModelCode", "()Ljava/lang/String;", "getModelImg", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PetModelBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PetModelBean> CREATOR = new Creator();

    @NotNull
    private final String metaverseModelCode;

    @NotNull
    private final String modelImg;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PetModelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PetModelBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PetModelBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PetModelBean[] newArray(int i) {
            return new PetModelBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PetModelBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public PetModelBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(str2, "modelImg");
        this.metaverseModelCode = str;
        this.modelImg = str2;
    }

    public static /* synthetic */ PetModelBean copy$default(PetModelBean petModelBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = petModelBean.metaverseModelCode;
        }
        if ((i & 2) != 0) {
            str2 = petModelBean.modelImg;
        }
        return petModelBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModelImg() {
        return this.modelImg;
    }

    @NotNull
    public final PetModelBean copy(@NotNull String metaverseModelCode, @NotNull String modelImg) {
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(modelImg, "modelImg");
        return new PetModelBean(metaverseModelCode, modelImg);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PetModelBean)) {
            return false;
        }
        PetModelBean petModelBean = (PetModelBean) other;
        return Intrinsics.areEqual(this.metaverseModelCode, petModelBean.metaverseModelCode) && Intrinsics.areEqual(this.modelImg, petModelBean.modelImg);
    }

    @NotNull
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    public final String getModelImg() {
        return this.modelImg;
    }

    public int hashCode() {
        return (this.metaverseModelCode.hashCode() * 31) + this.modelImg.hashCode();
    }

    @NotNull
    public String toString() {
        return "PetModelBean(metaverseModelCode=" + this.metaverseModelCode + ", modelImg=" + this.modelImg + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.metaverseModelCode);
        parcel.writeString(this.modelImg);
    }

    public /* synthetic */ PetModelBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

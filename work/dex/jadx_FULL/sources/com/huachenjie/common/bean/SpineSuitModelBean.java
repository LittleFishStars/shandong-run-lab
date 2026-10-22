package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/common/bean/SpineSuitModelBean;", "Landroid/os/Parcelable;", "modelCode", "", "partCodeList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getModelCode", "()Ljava/lang/String;", "setModelCode", "(Ljava/lang/String;)V", "getPartCodeList", "()Ljava/util/List;", "setPartCodeList", "(Ljava/util/List;)V", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SpineSuitModelBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SpineSuitModelBean> CREATOR = new Creator();

    @NotNull
    private String modelCode;

    @Nullable
    private List<String> partCodeList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpineSuitModelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpineSuitModelBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SpineSuitModelBean(parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpineSuitModelBean[] newArray(int i) {
            return new SpineSuitModelBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpineSuitModelBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SpineSuitModelBean(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "modelCode");
        this.modelCode = str;
        this.partCodeList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpineSuitModelBean copy$default(SpineSuitModelBean spineSuitModelBean, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = spineSuitModelBean.modelCode;
        }
        if ((i & 2) != 0) {
            list = spineSuitModelBean.partCodeList;
        }
        return spineSuitModelBean.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModelCode() {
        return this.modelCode;
    }

    @Nullable
    public final List<String> component2() {
        return this.partCodeList;
    }

    @NotNull
    public final SpineSuitModelBean copy(@NotNull String modelCode, @Nullable List<String> partCodeList) {
        Intrinsics.checkNotNullParameter(modelCode, "modelCode");
        return new SpineSuitModelBean(modelCode, partCodeList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpineSuitModelBean)) {
            return false;
        }
        SpineSuitModelBean spineSuitModelBean = (SpineSuitModelBean) other;
        return Intrinsics.areEqual(this.modelCode, spineSuitModelBean.modelCode) && Intrinsics.areEqual(this.partCodeList, spineSuitModelBean.partCodeList);
    }

    @NotNull
    public final String getModelCode() {
        return this.modelCode;
    }

    @Nullable
    public final List<String> getPartCodeList() {
        return this.partCodeList;
    }

    public int hashCode() {
        int iHashCode = this.modelCode.hashCode() * 31;
        List<String> list = this.partCodeList;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setModelCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelCode = str;
    }

    public final void setPartCodeList(@Nullable List<String> list) {
        this.partCodeList = list;
    }

    @NotNull
    public String toString() {
        return "SpineSuitModelBean(modelCode=" + this.modelCode + ", partCodeList=" + this.partCodeList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.modelCode);
        parcel.writeStringList(this.partCodeList);
    }

    public /* synthetic */ SpineSuitModelBean(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list);
    }
}

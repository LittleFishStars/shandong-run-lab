package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/ChannelTabBean;", "Landroid/os/Parcelable;", "classificationName", "", "channelClassificationNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelClassificationNo", "()Ljava/lang/String;", "getClassificationName", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelTabBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ChannelTabBean> CREATOR = new Creator();

    @Nullable
    private final String channelClassificationNo;

    @NotNull
    private final String classificationName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChannelTabBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelTabBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChannelTabBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelTabBean[] newArray(int i) {
            return new ChannelTabBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelTabBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public ChannelTabBean(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "classificationName");
        this.classificationName = str;
        this.channelClassificationNo = str2;
    }

    public static /* synthetic */ ChannelTabBean copy$default(ChannelTabBean channelTabBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelTabBean.classificationName;
        }
        if ((i & 2) != 0) {
            str2 = channelTabBean.channelClassificationNo;
        }
        return channelTabBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassificationName() {
        return this.classificationName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelClassificationNo() {
        return this.channelClassificationNo;
    }

    @NotNull
    public final ChannelTabBean copy(@NotNull String classificationName, @Nullable String channelClassificationNo) {
        Intrinsics.checkNotNullParameter(classificationName, "classificationName");
        return new ChannelTabBean(classificationName, channelClassificationNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelTabBean)) {
            return false;
        }
        ChannelTabBean channelTabBean = (ChannelTabBean) other;
        return Intrinsics.areEqual(this.classificationName, channelTabBean.classificationName) && Intrinsics.areEqual(this.channelClassificationNo, channelTabBean.channelClassificationNo);
    }

    @Nullable
    public final String getChannelClassificationNo() {
        return this.channelClassificationNo;
    }

    @NotNull
    public final String getClassificationName() {
        return this.classificationName;
    }

    public int hashCode() {
        int iHashCode = this.classificationName.hashCode() * 31;
        String str = this.channelClassificationNo;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "ChannelTabBean(classificationName=" + this.classificationName + ", channelClassificationNo=" + this.channelClassificationNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.classificationName);
        parcel.writeString(this.channelClassificationNo);
    }

    public /* synthetic */ ChannelTabBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

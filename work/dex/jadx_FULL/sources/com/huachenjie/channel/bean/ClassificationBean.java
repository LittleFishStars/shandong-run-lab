package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/bean/ClassificationBean;", "Landroid/os/Parcelable;", "classificationName", "", "channelClassificationNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelClassificationNo", "()Ljava/lang/String;", "getClassificationName", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClassificationBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClassificationBean> CREATOR = new Creator();

    @NotNull
    private final String channelClassificationNo;

    @NotNull
    private final String classificationName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClassificationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClassificationBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClassificationBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClassificationBean[] newArray(int i) {
            return new ClassificationBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClassificationBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public ClassificationBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "classificationName");
        Intrinsics.checkNotNullParameter(str2, "channelClassificationNo");
        this.classificationName = str;
        this.channelClassificationNo = str2;
    }

    public static /* synthetic */ ClassificationBean copy$default(ClassificationBean classificationBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = classificationBean.classificationName;
        }
        if ((i & 2) != 0) {
            str2 = classificationBean.channelClassificationNo;
        }
        return classificationBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassificationName() {
        return this.classificationName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelClassificationNo() {
        return this.channelClassificationNo;
    }

    @NotNull
    public final ClassificationBean copy(@NotNull String classificationName, @NotNull String channelClassificationNo) {
        Intrinsics.checkNotNullParameter(classificationName, "classificationName");
        Intrinsics.checkNotNullParameter(channelClassificationNo, "channelClassificationNo");
        return new ClassificationBean(classificationName, channelClassificationNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassificationBean)) {
            return false;
        }
        ClassificationBean classificationBean = (ClassificationBean) other;
        return Intrinsics.areEqual(this.classificationName, classificationBean.classificationName) && Intrinsics.areEqual(this.channelClassificationNo, classificationBean.channelClassificationNo);
    }

    @NotNull
    public final String getChannelClassificationNo() {
        return this.channelClassificationNo;
    }

    @NotNull
    public final String getClassificationName() {
        return this.classificationName;
    }

    public int hashCode() {
        return (this.classificationName.hashCode() * 31) + this.channelClassificationNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassificationBean(classificationName=" + this.classificationName + ", channelClassificationNo=" + this.channelClassificationNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.classificationName);
        parcel.writeString(this.channelClassificationNo);
    }

    public /* synthetic */ ClassificationBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

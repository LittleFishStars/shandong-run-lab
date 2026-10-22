package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/OriginalChannelHotspotWorksBean;", "Landroid/os/Parcelable;", "name", "", AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, "(Ljava/lang/String;Ljava/lang/String;)V", "getCover", "()Ljava/lang/String;", "getName", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OriginalChannelHotspotWorksBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OriginalChannelHotspotWorksBean> CREATOR = new Creator();

    @NotNull
    private final String cover;

    @NotNull
    private final String name;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OriginalChannelHotspotWorksBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OriginalChannelHotspotWorksBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OriginalChannelHotspotWorksBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OriginalChannelHotspotWorksBean[] newArray(int i) {
            return new OriginalChannelHotspotWorksBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OriginalChannelHotspotWorksBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public OriginalChannelHotspotWorksBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
        this.name = str;
        this.cover = str2;
    }

    public static /* synthetic */ OriginalChannelHotspotWorksBean copy$default(OriginalChannelHotspotWorksBean originalChannelHotspotWorksBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = originalChannelHotspotWorksBean.name;
        }
        if ((i & 2) != 0) {
            str2 = originalChannelHotspotWorksBean.cover;
        }
        return originalChannelHotspotWorksBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    @NotNull
    public final OriginalChannelHotspotWorksBean copy(@NotNull String name, @NotNull String cover) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(cover, AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
        return new OriginalChannelHotspotWorksBean(name, cover);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OriginalChannelHotspotWorksBean)) {
            return false;
        }
        OriginalChannelHotspotWorksBean originalChannelHotspotWorksBean = (OriginalChannelHotspotWorksBean) other;
        return Intrinsics.areEqual(this.name, originalChannelHotspotWorksBean.name) && Intrinsics.areEqual(this.cover, originalChannelHotspotWorksBean.cover);
    }

    @NotNull
    public final String getCover() {
        return this.cover;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.cover.hashCode();
    }

    @NotNull
    public String toString() {
        return "OriginalChannelHotspotWorksBean(name=" + this.name + ", cover=" + this.cover + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.cover);
    }

    public /* synthetic */ OriginalChannelHotspotWorksBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

package com.huachenjie.base.bean;

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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/VideoBean;", "Landroid/os/Parcelable;", "previewUrl", "", "url", "width", "", "height", "scaleType", "(Ljava/lang/String;Ljava/lang/String;III)V", "getHeight", "()I", "getPreviewUrl", "()Ljava/lang/String;", "getScaleType", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VideoBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VideoBean> CREATOR = new Creator();
    private final int height;

    @NotNull
    private final String previewUrl;
    private final int scaleType;

    @NotNull
    private final String url;
    private final int width;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VideoBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoBean[] newArray(int i) {
            return new VideoBean[i];
        }
    }

    public VideoBean() {
        this(null, null, 0, 0, 0, 31, null);
    }

    public VideoBean(@NotNull String str, @NotNull String str2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "previewUrl");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.previewUrl = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
        this.scaleType = i3;
    }

    public static /* synthetic */ VideoBean copy$default(VideoBean videoBean, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = videoBean.previewUrl;
        }
        if ((i4 & 2) != 0) {
            str2 = videoBean.url;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            i = videoBean.width;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = videoBean.height;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = videoBean.scaleType;
        }
        return videoBean.copy(str, str3, i5, i6, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getScaleType() {
        return this.scaleType;
    }

    @NotNull
    public final VideoBean copy(@NotNull String previewUrl, @NotNull String url, int width, int height, int scaleType) {
        Intrinsics.checkNotNullParameter(previewUrl, "previewUrl");
        Intrinsics.checkNotNullParameter(url, "url");
        return new VideoBean(previewUrl, url, width, height, scaleType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoBean)) {
            return false;
        }
        VideoBean videoBean = (VideoBean) other;
        return Intrinsics.areEqual(this.previewUrl, videoBean.previewUrl) && Intrinsics.areEqual(this.url, videoBean.url) && this.width == videoBean.width && this.height == videoBean.height && this.scaleType == videoBean.scaleType;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final int getScaleType() {
        return this.scaleType;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.previewUrl.hashCode() * 31) + this.url.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.scaleType);
    }

    @NotNull
    public String toString() {
        return "VideoBean(previewUrl=" + this.previewUrl + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", scaleType=" + this.scaleType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.scaleType);
    }

    public /* synthetic */ VideoBean(String str, String str2, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) == 0 ? str2 : "", (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }
}

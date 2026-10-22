package com.huachenjie.works.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006*"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Landroid/os/Parcelable;", "picPath", "", "videoPath", "mediaWidth", "", "mediaHeight", "(Ljava/lang/String;Ljava/lang/String;II)V", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getMediaHeight", "setMediaHeight", "(I)V", "getMediaWidth", "setMediaWidth", "getPicPath", "()Ljava/lang/String;", "setPicPath", "(Ljava/lang/String;)V", "getVideoPath", "setVideoPath", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorkMediaData implements MultiItemEntity, Parcelable {
    public static final int TYPE_ADD_MEDIA = 0;
    public static final int TYPE_PIC = 1;
    public static final int TYPE_VIDEO = 2;
    private int mediaHeight;
    private int mediaWidth;

    @Nullable
    private String picPath;

    @Nullable
    private String videoPath;

    @NotNull
    public static final Parcelable.Creator<PubWorkMediaData> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PubWorkMediaData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkMediaData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PubWorkMediaData(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkMediaData[] newArray(int i) {
            return new PubWorkMediaData[i];
        }
    }

    public PubWorkMediaData() {
        this(null, null, 0, 0, 15, null);
    }

    public PubWorkMediaData(@Nullable String str, @Nullable String str2, int i, int i2) {
        this.picPath = str;
        this.videoPath = str2;
        this.mediaWidth = i;
        this.mediaHeight = i2;
    }

    public static /* synthetic */ PubWorkMediaData copy$default(PubWorkMediaData pubWorkMediaData, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pubWorkMediaData.picPath;
        }
        if ((i3 & 2) != 0) {
            str2 = pubWorkMediaData.videoPath;
        }
        if ((i3 & 4) != 0) {
            i = pubWorkMediaData.mediaWidth;
        }
        if ((i3 & 8) != 0) {
            i2 = pubWorkMediaData.mediaHeight;
        }
        return pubWorkMediaData.copy(str, str2, i, i2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPicPath() {
        return this.picPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideoPath() {
        return this.videoPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    @NotNull
    public final PubWorkMediaData copy(@Nullable String picPath, @Nullable String videoPath, int mediaWidth, int mediaHeight) {
        return new PubWorkMediaData(picPath, videoPath, mediaWidth, mediaHeight);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PubWorkMediaData)) {
            return false;
        }
        PubWorkMediaData pubWorkMediaData = (PubWorkMediaData) other;
        return Intrinsics.areEqual(this.picPath, pubWorkMediaData.picPath) && Intrinsics.areEqual(this.videoPath, pubWorkMediaData.videoPath) && this.mediaWidth == pubWorkMediaData.mediaWidth && this.mediaHeight == pubWorkMediaData.mediaHeight;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        String str = this.picPath;
        if (str == null || str.length() == 0) {
            String str2 = this.videoPath;
            if (str2 == null || str2.length() == 0) {
                return 0;
            }
        }
        String str3 = this.videoPath;
        return str3 == null || str3.length() == 0 ? 1 : 2;
    }

    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    @Nullable
    public final String getPicPath() {
        return this.picPath;
    }

    @Nullable
    public final String getVideoPath() {
        return this.videoPath;
    }

    public int hashCode() {
        String str = this.picPath;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoPath;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.mediaWidth)) * 31) + Integer.hashCode(this.mediaHeight);
    }

    public final void setMediaHeight(int i) {
        this.mediaHeight = i;
    }

    public final void setMediaWidth(int i) {
        this.mediaWidth = i;
    }

    public final void setPicPath(@Nullable String str) {
        this.picPath = str;
    }

    public final void setVideoPath(@Nullable String str) {
        this.videoPath = str;
    }

    @NotNull
    public String toString() {
        return "PubWorkMediaData(picPath=" + this.picPath + ", videoPath=" + this.videoPath + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.picPath);
        parcel.writeString(this.videoPath);
        parcel.writeInt(this.mediaWidth);
        parcel.writeInt(this.mediaHeight);
    }

    public /* synthetic */ PubWorkMediaData(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }
}

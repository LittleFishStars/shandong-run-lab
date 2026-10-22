package com.huachenjie.works.bean.publish;

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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006)"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "Landroid/os/Parcelable;", "coverImgUrl", "", "channelNo", "channelType", "", "title", "description", "popularityValue", "logoUrl", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelNo", "()Ljava/lang/String;", "getChannelType", "()I", "getCoverImgUrl", "getDescription", "getLogoUrl", "getPopularityValue", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorkChannelBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PubWorkChannelBean> CREATOR = new Creator();

    @NotNull
    private final String channelNo;
    private final int channelType;

    @NotNull
    private final String coverImgUrl;

    @NotNull
    private final String description;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String popularityValue;

    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PubWorkChannelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkChannelBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PubWorkChannelBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkChannelBean[] newArray(int i) {
            return new PubWorkChannelBean[i];
        }
    }

    public PubWorkChannelBean() {
        this(null, null, 0, null, null, null, null, 127, null);
    }

    public PubWorkChannelBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "coverImgUrl");
        Intrinsics.checkNotNullParameter(str2, "channelNo");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "popularityValue");
        Intrinsics.checkNotNullParameter(str6, "logoUrl");
        this.coverImgUrl = str;
        this.channelNo = str2;
        this.channelType = i;
        this.title = str3;
        this.description = str4;
        this.popularityValue = str5;
        this.logoUrl = str6;
    }

    public static /* synthetic */ PubWorkChannelBean copy$default(PubWorkChannelBean pubWorkChannelBean, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pubWorkChannelBean.coverImgUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = pubWorkChannelBean.channelNo;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            i = pubWorkChannelBean.channelType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = pubWorkChannelBean.title;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = pubWorkChannelBean.description;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = pubWorkChannelBean.popularityValue;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            str6 = pubWorkChannelBean.logoUrl;
        }
        return pubWorkChannelBean.copy(str, str7, i3, str8, str9, str10, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final PubWorkChannelBean copy(@NotNull String coverImgUrl, @NotNull String channelNo, int channelType, @NotNull String title, @NotNull String description, @NotNull String popularityValue, @NotNull String logoUrl) {
        Intrinsics.checkNotNullParameter(coverImgUrl, "coverImgUrl");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(popularityValue, "popularityValue");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        return new PubWorkChannelBean(coverImgUrl, channelNo, channelType, title, description, popularityValue, logoUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PubWorkChannelBean)) {
            return false;
        }
        PubWorkChannelBean pubWorkChannelBean = (PubWorkChannelBean) other;
        return Intrinsics.areEqual(this.coverImgUrl, pubWorkChannelBean.coverImgUrl) && Intrinsics.areEqual(this.channelNo, pubWorkChannelBean.channelNo) && this.channelType == pubWorkChannelBean.channelType && Intrinsics.areEqual(this.title, pubWorkChannelBean.title) && Intrinsics.areEqual(this.description, pubWorkChannelBean.description) && Intrinsics.areEqual(this.popularityValue, pubWorkChannelBean.popularityValue) && Intrinsics.areEqual(this.logoUrl, pubWorkChannelBean.logoUrl);
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getPopularityValue() {
        return this.popularityValue;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((this.coverImgUrl.hashCode() * 31) + this.channelNo.hashCode()) * 31) + Integer.hashCode(this.channelType)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.popularityValue.hashCode()) * 31) + this.logoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "PubWorkChannelBean(coverImgUrl=" + this.coverImgUrl + ", channelNo=" + this.channelNo + ", channelType=" + this.channelType + ", title=" + this.title + ", description=" + this.description + ", popularityValue=" + this.popularityValue + ", logoUrl=" + this.logoUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.coverImgUrl);
        parcel.writeString(this.channelNo);
        parcel.writeInt(this.channelType);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.popularityValue);
        parcel.writeString(this.logoUrl);
    }

    public /* synthetic */ PubWorkChannelBean(String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6);
    }
}

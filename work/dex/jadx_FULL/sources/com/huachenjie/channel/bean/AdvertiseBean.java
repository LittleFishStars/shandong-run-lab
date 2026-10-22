package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u00060"}, d2 = {"Lcom/huachenjie/channel/bean/AdvertiseBean;", "Landroid/os/Parcelable;", "coverUrl", "", "adStatus", "", "channelAdCode", "content", "linkType", "", "linkUrl", "failReason", "imgList", "", "Lcom/huachenjie/channel/bean/AdvertiseImageBean;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAdStatus", "()I", "getChannelAdCode", "()Ljava/lang/String;", "getContent", "getCoverUrl", "getFailReason", "getImgList", "()Ljava/util/List;", "getLinkType", "()Z", "getLinkUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdvertiseBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AdvertiseBean> CREATOR = new Creator();
    private final int adStatus;

    @NotNull
    private final String channelAdCode;

    @NotNull
    private final String content;

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String failReason;

    @NotNull
    private final List<AdvertiseImageBean> imgList;
    private final boolean linkType;

    @NotNull
    private final String linkUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AdvertiseBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertiseBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(AdvertiseImageBean.CREATOR.createFromParcel(parcel));
            }
            return new AdvertiseBean(string, i, string2, string3, z, string4, string5, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertiseBean[] newArray(int i) {
            return new AdvertiseBean[i];
        }
    }

    public AdvertiseBean() {
        this(null, 0, null, null, false, null, null, null, 255, null);
    }

    public AdvertiseBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, boolean z, @NotNull String str4, @NotNull String str5, @NotNull List<AdvertiseImageBean> list) {
        Intrinsics.checkNotNullParameter(str, "coverUrl");
        Intrinsics.checkNotNullParameter(str2, "channelAdCode");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "linkUrl");
        Intrinsics.checkNotNullParameter(str5, "failReason");
        Intrinsics.checkNotNullParameter(list, "imgList");
        this.coverUrl = str;
        this.adStatus = i;
        this.channelAdCode = str2;
        this.content = str3;
        this.linkType = z;
        this.linkUrl = str4;
        this.failReason = str5;
        this.imgList = list;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAdStatus() {
        return this.adStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelAdCode() {
        return this.channelAdCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getLinkType() {
        return this.linkType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    @NotNull
    public final List<AdvertiseImageBean> component8() {
        return this.imgList;
    }

    @NotNull
    public final AdvertiseBean copy(@NotNull String coverUrl, int adStatus, @NotNull String channelAdCode, @NotNull String content, boolean linkType, @NotNull String linkUrl, @NotNull String failReason, @NotNull List<AdvertiseImageBean> imgList) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(channelAdCode, "channelAdCode");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        Intrinsics.checkNotNullParameter(imgList, "imgList");
        return new AdvertiseBean(coverUrl, adStatus, channelAdCode, content, linkType, linkUrl, failReason, imgList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvertiseBean)) {
            return false;
        }
        AdvertiseBean advertiseBean = (AdvertiseBean) other;
        return Intrinsics.areEqual(this.coverUrl, advertiseBean.coverUrl) && this.adStatus == advertiseBean.adStatus && Intrinsics.areEqual(this.channelAdCode, advertiseBean.channelAdCode) && Intrinsics.areEqual(this.content, advertiseBean.content) && this.linkType == advertiseBean.linkType && Intrinsics.areEqual(this.linkUrl, advertiseBean.linkUrl) && Intrinsics.areEqual(this.failReason, advertiseBean.failReason) && Intrinsics.areEqual(this.imgList, advertiseBean.imgList);
    }

    public final int getAdStatus() {
        return this.adStatus;
    }

    @NotNull
    public final String getChannelAdCode() {
        return this.channelAdCode;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getFailReason() {
        return this.failReason;
    }

    @NotNull
    public final List<AdvertiseImageBean> getImgList() {
        return this.imgList;
    }

    public final boolean getLinkType() {
        return this.linkType;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((this.coverUrl.hashCode() * 31) + Integer.hashCode(this.adStatus)) * 31) + this.channelAdCode.hashCode()) * 31) + this.content.hashCode()) * 31;
        boolean z = this.linkType;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + this.linkUrl.hashCode()) * 31) + this.failReason.hashCode()) * 31) + this.imgList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdvertiseBean(coverUrl=" + this.coverUrl + ", adStatus=" + this.adStatus + ", channelAdCode=" + this.channelAdCode + ", content=" + this.content + ", linkType=" + this.linkType + ", linkUrl=" + this.linkUrl + ", failReason=" + this.failReason + ", imgList=" + this.imgList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.adStatus);
        parcel.writeString(this.channelAdCode);
        parcel.writeString(this.content);
        parcel.writeInt(this.linkType ? 1 : 0);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.failReason);
        List<AdvertiseImageBean> list = this.imgList;
        parcel.writeInt(list.size());
        Iterator<AdvertiseImageBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ AdvertiseBean(String str, int i, String str2, String str3, boolean z, String str4, String str5, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) == 0 ? z : false, (i2 & 32) != 0 ? "" : str4, (i2 & 64) == 0 ? str5 : "", (i2 & 128) != 0 ? new ArrayList() : list);
    }
}

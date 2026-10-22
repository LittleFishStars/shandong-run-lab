package com.huachenjie.channel.bean;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010#\u001a\u00020\u0013HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020\u0013HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR \u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\f¨\u00062"}, d2 = {"Lcom/huachenjie/channel/bean/JoinAllChannelBean;", "Landroid/os/Parcelable;", "coverImgUrl", "", "title", "blurb", "channelNo", "avatar", "ownerName", "memberCountStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getBlurb", "getChannelNo", "getCoverImgUrl", "getMemberCountStr", "getOwnerName", "position", "", "getPosition$annotations", "()V", "getPosition", "()I", "setPosition", "(I)V", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getBgColor", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JoinAllChannelBean implements Parcelable {

    @NotNull
    private final String avatar;

    @NotNull
    private final String blurb;

    @NotNull
    private final String channelNo;

    @NotNull
    private final String coverImgUrl;

    @NotNull
    private final String memberCountStr;

    @NotNull
    private final String ownerName;
    private int position;

    @NotNull
    private final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<JoinAllChannelBean> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/channel/bean/JoinAllChannelBean$Companion;", "", "()V", "getOption", "Lcom/bumptech/glide/request/RequestOptions;", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RequestOptions getOption() {
            RequestOptions requestOptions = new RequestOptions();
            int i = R.drawable.base_bg_channel_main_head;
            RequestOptions requestOptionsTransforms = requestOptions.placeholder(i).error(i).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
            Intrinsics.checkNotNullExpressionValue(requestOptionsTransforms, "RequestOptions()\n       …ers(SizeUtils.dp2px(8f)))");
            return requestOptionsTransforms;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<JoinAllChannelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JoinAllChannelBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new JoinAllChannelBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final JoinAllChannelBean[] newArray(int i) {
            return new JoinAllChannelBean[i];
        }
    }

    public JoinAllChannelBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public JoinAllChannelBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "coverImgUrl");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "blurb");
        Intrinsics.checkNotNullParameter(str4, "channelNo");
        Intrinsics.checkNotNullParameter(str5, "avatar");
        Intrinsics.checkNotNullParameter(str6, "ownerName");
        Intrinsics.checkNotNullParameter(str7, "memberCountStr");
        this.coverImgUrl = str;
        this.title = str2;
        this.blurb = str3;
        this.channelNo = str4;
        this.avatar = str5;
        this.ownerName = str6;
        this.memberCountStr = str7;
    }

    public static /* synthetic */ JoinAllChannelBean copy$default(JoinAllChannelBean joinAllChannelBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = joinAllChannelBean.coverImgUrl;
        }
        if ((i & 2) != 0) {
            str2 = joinAllChannelBean.title;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = joinAllChannelBean.blurb;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = joinAllChannelBean.channelNo;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = joinAllChannelBean.avatar;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = joinAllChannelBean.ownerName;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = joinAllChannelBean.memberCountStr;
        }
        return joinAllChannelBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @JvmStatic
    @NotNull
    public static final RequestOptions getOption() {
        return INSTANCE.getOption();
    }

    public static /* synthetic */ void getPosition$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBlurb() {
        return this.blurb;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOwnerName() {
        return this.ownerName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMemberCountStr() {
        return this.memberCountStr;
    }

    @NotNull
    public final JoinAllChannelBean copy(@NotNull String coverImgUrl, @NotNull String title, @NotNull String blurb, @NotNull String channelNo, @NotNull String avatar, @NotNull String ownerName, @NotNull String memberCountStr) {
        Intrinsics.checkNotNullParameter(coverImgUrl, "coverImgUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(blurb, "blurb");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(ownerName, "ownerName");
        Intrinsics.checkNotNullParameter(memberCountStr, "memberCountStr");
        return new JoinAllChannelBean(coverImgUrl, title, blurb, channelNo, avatar, ownerName, memberCountStr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinAllChannelBean)) {
            return false;
        }
        JoinAllChannelBean joinAllChannelBean = (JoinAllChannelBean) other;
        return Intrinsics.areEqual(this.coverImgUrl, joinAllChannelBean.coverImgUrl) && Intrinsics.areEqual(this.title, joinAllChannelBean.title) && Intrinsics.areEqual(this.blurb, joinAllChannelBean.blurb) && Intrinsics.areEqual(this.channelNo, joinAllChannelBean.channelNo) && Intrinsics.areEqual(this.avatar, joinAllChannelBean.avatar) && Intrinsics.areEqual(this.ownerName, joinAllChannelBean.ownerName) && Intrinsics.areEqual(this.memberCountStr, joinAllChannelBean.memberCountStr);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final int[] getBgColor() {
        int i = this.position % 5;
        if (i == 0) {
            return new int[]{Color.parseColor("#1A8485FF"), Color.parseColor("#1ADF97FF")};
        }
        if (i == 1) {
            return new int[]{Color.parseColor("#1A6DCFF9"), Color.parseColor("#1A6073F5")};
        }
        if (i == 2) {
            return new int[]{Color.parseColor("#1AFF4C83"), Color.parseColor("#1A6B1EFF")};
        }
        if (i != 3) {
            return i != 4 ? new int[]{Color.parseColor("#1A8485FF"), Color.parseColor("#1ADF97FF")} : new int[]{Color.parseColor("#1AFFDF75"), Color.parseColor("#1AFF8E38")};
        }
        return new int[]{Color.parseColor("#1A0DEEC3"), Color.parseColor("#1A1FA7D1")};
    }

    @NotNull
    public final String getBlurb() {
        return this.blurb;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getCoverImgUrl() {
        return this.coverImgUrl;
    }

    @NotNull
    public final String getMemberCountStr() {
        return this.memberCountStr;
    }

    @NotNull
    public final String getOwnerName() {
        return this.ownerName;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((this.coverImgUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.blurb.hashCode()) * 31) + this.channelNo.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.memberCountStr.hashCode();
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    @NotNull
    public String toString() {
        return "JoinAllChannelBean(coverImgUrl=" + this.coverImgUrl + ", title=" + this.title + ", blurb=" + this.blurb + ", channelNo=" + this.channelNo + ", avatar=" + this.avatar + ", ownerName=" + this.ownerName + ", memberCountStr=" + this.memberCountStr + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.coverImgUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.blurb);
        parcel.writeString(this.channelNo);
        parcel.writeString(this.avatar);
        parcel.writeString(this.ownerName);
        parcel.writeString(this.memberCountStr);
    }

    public /* synthetic */ JoinAllChannelBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }
}

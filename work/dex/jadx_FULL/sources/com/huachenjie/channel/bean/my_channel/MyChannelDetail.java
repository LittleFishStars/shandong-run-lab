package com.huachenjie.channel.bean.my_channel;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.BaseChannelBean;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.xf7;
import com.zj.adlib.ys8;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÂ\u0003J\t\u0010<\u001a\u00020\u0010HÂ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\u0010HÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÂ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÂ\u0003J¡\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010HÆ\u0001J\t\u0010J\u001a\u00020\u0004HÖ\u0001J\u0013\u0010K\u001a\u00020\u00102\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0004HÖ\u0001J\u0006\u0010O\u001a\u00020\u0010J\t\u0010P\u001a\u00020\u0006HÖ\u0001J\u0019\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\u0017R\u0011\u0010-\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b-\u0010$R\u0011\u0010.\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b.\u0010$R\u0011\u0010/\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b/\u0010$R\u0011\u00100\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b0\u0010$R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0017R\u0013\u00103\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b4\u0010\"R\u0013\u00105\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b6\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u00108\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b9\u0010$¨\u0006V"}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelDetail;", "Lcom/huachenjie/channel/bean/BaseChannelBean;", "Landroid/os/Parcelable;", "channelType", "", "failReason", "", "channelStatus", "logo", "coverHue", "avatar", "avatarFrameImgUrl", UserConstants.USER_PARAMS.b, "acquireAvatarFrameName", "acquireAttitudeName", "firstAcquireFlag", "", "popFlag", "channelMemberType", "certificationFlag", "clubAdminFlag", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZIZZ)V", "getAvatar", "()Ljava/lang/String;", "avatar1", "getAvatar1", "avatar2", "getAvatar2", "avatar3", "getAvatar3", "getAvatarFrameImgUrl", "bottomBg", "Landroid/graphics/drawable/Drawable;", "getBottomBg", "()Landroid/graphics/drawable/Drawable;", "getCertificationFlag", "()Z", "getChannelMemberType", "()I", "getChannelStatus", "getChannelType", "getClubAdminFlag", "getFailReason", "firstAcquireTip", "getFirstAcquireTip", "isAdminOrSubAdmin", "isOfficial", "isRunOrUniverseChannel", "isShowOptBtn", "getLogo", "getNickName", "optBtnIcon", "getOptBtnIcon", "optBtnText", "getOptBtnText", "getPopFlag", "showAdmin", "getShowAdmin", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "isBgDark", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelDetail extends BaseChannelBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MyChannelDetail> CREATOR = new Creator();

    @NotNull
    private final String acquireAttitudeName;

    @NotNull
    private final String acquireAvatarFrameName;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;
    private final boolean certificationFlag;
    private final int channelMemberType;
    private final int channelStatus;
    private final int channelType;
    private final boolean clubAdminFlag;

    @NotNull
    private final String coverHue;

    @Nullable
    private final String failReason;
    private final boolean firstAcquireFlag;

    @NotNull
    private final String logo;

    @NotNull
    private final String nickName;
    private final boolean popFlag;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MyChannelDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelDetail createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MyChannelDetail(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelDetail[] newArray(int i) {
            return new MyChannelDetail[i];
        }
    }

    public /* synthetic */ MyChannelDetail(int i, String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, int i3, boolean z3, boolean z4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, str, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? "" : str5, (i4 & 128) != 0 ? "" : str6, (i4 & 256) != 0 ? "" : str7, (i4 & 512) != 0 ? "" : str8, (i4 & 1024) != 0 ? false : z, (i4 & 2048) != 0 ? false : z2, (i4 & 4096) != 0 ? 0 : i3, (i4 & 8192) != 0 ? false : z3, (i4 & 16384) != 0 ? false : z4);
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final String getAcquireAttitudeName() {
        return this.acquireAttitudeName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    private final boolean getFirstAcquireFlag() {
        return this.firstAcquireFlag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final String getCoverHue() {
        return this.coverHue;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final String getAcquireAvatarFrameName() {
        return this.acquireAvatarFrameName;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getPopFlag() {
        return this.popFlag;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getChannelMemberType() {
        return this.channelMemberType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getClubAdminFlag() {
        return this.clubAdminFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getChannelStatus() {
        return this.channelStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final MyChannelDetail copy(int channelType, @Nullable String failReason, int channelStatus, @NotNull String logo, @NotNull String coverHue, @NotNull String avatar, @NotNull String avatarFrameImgUrl, @NotNull String nickName, @NotNull String acquireAvatarFrameName, @NotNull String acquireAttitudeName, boolean firstAcquireFlag, boolean popFlag, int channelMemberType, boolean certificationFlag, boolean clubAdminFlag) {
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(coverHue, "coverHue");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(acquireAvatarFrameName, "acquireAvatarFrameName");
        Intrinsics.checkNotNullParameter(acquireAttitudeName, "acquireAttitudeName");
        return new MyChannelDetail(channelType, failReason, channelStatus, logo, coverHue, avatar, avatarFrameImgUrl, nickName, acquireAvatarFrameName, acquireAttitudeName, firstAcquireFlag, popFlag, channelMemberType, certificationFlag, clubAdminFlag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelDetail)) {
            return false;
        }
        MyChannelDetail myChannelDetail = (MyChannelDetail) other;
        return this.channelType == myChannelDetail.channelType && Intrinsics.areEqual(this.failReason, myChannelDetail.failReason) && this.channelStatus == myChannelDetail.channelStatus && Intrinsics.areEqual(this.logo, myChannelDetail.logo) && Intrinsics.areEqual(this.coverHue, myChannelDetail.coverHue) && Intrinsics.areEqual(this.avatar, myChannelDetail.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, myChannelDetail.avatarFrameImgUrl) && Intrinsics.areEqual(this.nickName, myChannelDetail.nickName) && Intrinsics.areEqual(this.acquireAvatarFrameName, myChannelDetail.acquireAvatarFrameName) && Intrinsics.areEqual(this.acquireAttitudeName, myChannelDetail.acquireAttitudeName) && this.firstAcquireFlag == myChannelDetail.firstAcquireFlag && this.popFlag == myChannelDetail.popFlag && this.channelMemberType == myChannelDetail.channelMemberType && this.certificationFlag == myChannelDetail.certificationFlag && this.clubAdminFlag == myChannelDetail.clubAdminFlag;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatar1() {
        return (String) CollectionsKt.getOrNull(getAvatarList(), 0);
    }

    @Nullable
    public final String getAvatar2() {
        return (String) CollectionsKt.getOrNull(getAvatarList(), 1);
    }

    @Nullable
    public final String getAvatar3() {
        return (String) CollectionsKt.getOrNull(getAvatarList(), 2);
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final Drawable getBottomBg() {
        if (TextUtils.isEmpty(this.coverHue)) {
            return new ColorDrawable(0);
        }
        int color = Color.parseColor(this.coverHue);
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(0, Color.red(color), Color.green(color), Color.blue(color)), Color.argb(255, Color.red(color), Color.green(color), Color.blue(color))});
    }

    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    public final int getChannelMemberType() {
        return this.channelMemberType;
    }

    public final int getChannelStatus() {
        return this.channelStatus;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    public final boolean getClubAdminFlag() {
        return this.clubAdminFlag;
    }

    @Nullable
    public final String getFailReason() {
        return this.failReason;
    }

    @NotNull
    public final String getFirstAcquireTip() {
        if (!this.firstAcquireFlag) {
            return "";
        }
        if (!TextUtils.isEmpty(this.acquireAvatarFrameName) && !TextUtils.isEmpty(this.acquireAttitudeName)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ys8.e(R.string.channel_my_channel_reward);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.channel_my_channel_reward)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{this.acquireAvatarFrameName + '*' + this.acquireAttitudeName}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
        if (!TextUtils.isEmpty(this.acquireAvatarFrameName)) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String strE2 = ys8.e(R.string.channel_my_channel_reward);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.channel_my_channel_reward)");
            String str2 = String.format(strE2, Arrays.copyOf(new Object[]{this.acquireAvatarFrameName}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            return str2;
        }
        if (TextUtils.isEmpty(this.acquireAttitudeName)) {
            return "";
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String strE3 = ys8.e(R.string.channel_my_channel_reward);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.channel_my_channel_reward)");
        String str3 = String.format(strE3, Arrays.copyOf(new Object[]{this.acquireAttitudeName}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        return str3;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    public final Drawable getOptBtnIcon() {
        int i = this.channelType;
        if (i == 1) {
            return xf7.f(R.drawable.channel_ic_main_kf);
        }
        if (i != 2) {
            return null;
        }
        return xf7.f(R.drawable.channel_ic_main_gk);
    }

    @Nullable
    public final String getOptBtnText() {
        int i = this.channelType;
        if (i == 1) {
            return ys8.e(R.string.channel_my_channel_kf);
        }
        if (i != 2) {
            return null;
        }
        return ys8.e(R.string.channel_my_channel_gk);
    }

    public final boolean getPopFlag() {
        return this.popFlag;
    }

    public final boolean getShowAdmin() {
        return this.channelStatus == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.channelType) * 31;
        String str = this.failReason;
        int iHashCode2 = (((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.channelStatus)) * 31) + this.logo.hashCode()) * 31) + this.coverHue.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.acquireAvatarFrameName.hashCode()) * 31) + this.acquireAttitudeName.hashCode()) * 31;
        boolean z = this.firstAcquireFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.popFlag;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((i + r2) * 31) + Integer.hashCode(this.channelMemberType)) * 31;
        boolean z3 = this.certificationFlag;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode3 + r3) * 31;
        boolean z4 = this.clubAdminFlag;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isAdminOrSubAdmin() {
        int i = this.channelMemberType;
        return i == 1 || i == 2;
    }

    public final boolean isBgDark() {
        return !TextUtils.isEmpty(this.coverHue) && ColorUtils.calculateLuminance(Color.parseColor(this.coverHue)) < 0.5d;
    }

    public final boolean isOfficial() {
        int i = this.channelType;
        return i == 1 || i == 2 || i == 3;
    }

    public final boolean isRunOrUniverseChannel() {
        int i = this.channelType;
        return i == 1 || i == 2;
    }

    public final boolean isShowOptBtn() {
        int i = this.channelType;
        return i == 1 || i == 2;
    }

    @NotNull
    public String toString() {
        return "MyChannelDetail(channelType=" + this.channelType + ", failReason=" + this.failReason + ", channelStatus=" + this.channelStatus + ", logo=" + this.logo + ", coverHue=" + this.coverHue + ", avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", nickName=" + this.nickName + ", acquireAvatarFrameName=" + this.acquireAvatarFrameName + ", acquireAttitudeName=" + this.acquireAttitudeName + ", firstAcquireFlag=" + this.firstAcquireFlag + ", popFlag=" + this.popFlag + ", channelMemberType=" + this.channelMemberType + ", certificationFlag=" + this.certificationFlag + ", clubAdminFlag=" + this.clubAdminFlag + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.channelType);
        parcel.writeString(this.failReason);
        parcel.writeInt(this.channelStatus);
        parcel.writeString(this.logo);
        parcel.writeString(this.coverHue);
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeString(this.nickName);
        parcel.writeString(this.acquireAvatarFrameName);
        parcel.writeString(this.acquireAttitudeName);
        parcel.writeInt(this.firstAcquireFlag ? 1 : 0);
        parcel.writeInt(this.popFlag ? 1 : 0);
        parcel.writeInt(this.channelMemberType);
        parcel.writeInt(this.certificationFlag ? 1 : 0);
        parcel.writeInt(this.clubAdminFlag ? 1 : 0);
    }

    public MyChannelDetail(int i, @Nullable String str, int i2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, boolean z, boolean z2, int i3, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(str2, "logo");
        Intrinsics.checkNotNullParameter(str3, "coverHue");
        Intrinsics.checkNotNullParameter(str4, "avatar");
        Intrinsics.checkNotNullParameter(str5, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str6, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str7, "acquireAvatarFrameName");
        Intrinsics.checkNotNullParameter(str8, "acquireAttitudeName");
        this.channelType = i;
        this.failReason = str;
        this.channelStatus = i2;
        this.logo = str2;
        this.coverHue = str3;
        this.avatar = str4;
        this.avatarFrameImgUrl = str5;
        this.nickName = str6;
        this.acquireAvatarFrameName = str7;
        this.acquireAttitudeName = str8;
        this.firstAcquireFlag = z;
        this.popFlag = z2;
        this.channelMemberType = i3;
        this.certificationFlag = z3;
        this.clubAdminFlag = z4;
    }
}

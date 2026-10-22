package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÂ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006*"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelMainBean;", "Lcom/huachenjie/channel/bean/BaseChannelBean;", "channelDescription", "", "channelType", "", "joinFlag", "", "channelNumber", "logo", "certificationFlag", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Z)V", "avatar1", "getAvatar1", "()Ljava/lang/String;", "avatar2", "getAvatar2", "avatar3", "getAvatar3", "getCertificationFlag", "()Z", "getChannelDescription", "getChannelNumber", "hostFlag", "getHostFlag", "isRunOrUniverseChannel", "getJoinFlag", "setJoinFlag", "(Z)V", "getLogo", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelMainBean extends BaseChannelBean {
    private final boolean certificationFlag;

    @NotNull
    private final String channelDescription;

    @NotNull
    private final String channelNumber;
    private final int channelType;
    private boolean joinFlag;

    @NotNull
    private final String logo;

    public ChannelMainBean() {
        this(null, 0, false, null, null, false, 63, null);
    }

    public /* synthetic */ ChannelMainBean(String str, int i, boolean z, String str2, String str3, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getChannelType() {
        return this.channelType;
    }

    public static /* synthetic */ ChannelMainBean copy$default(ChannelMainBean channelMainBean, String str, int i, boolean z, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelMainBean.channelDescription;
        }
        if ((i2 & 2) != 0) {
            i = channelMainBean.channelType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z = channelMainBean.joinFlag;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            str2 = channelMainBean.channelNumber;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = channelMainBean.logo;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            z2 = channelMainBean.certificationFlag;
        }
        return channelMainBean.copy(str, i3, z3, str4, str5, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelDescription() {
        return this.channelDescription;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    @NotNull
    public final ChannelMainBean copy(@NotNull String channelDescription, int channelType, boolean joinFlag, @NotNull String channelNumber, @NotNull String logo, boolean certificationFlag) {
        Intrinsics.checkNotNullParameter(channelDescription, "channelDescription");
        Intrinsics.checkNotNullParameter(channelNumber, "channelNumber");
        Intrinsics.checkNotNullParameter(logo, "logo");
        return new ChannelMainBean(channelDescription, channelType, joinFlag, channelNumber, logo, certificationFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMainBean)) {
            return false;
        }
        ChannelMainBean channelMainBean = (ChannelMainBean) other;
        return Intrinsics.areEqual(this.channelDescription, channelMainBean.channelDescription) && this.channelType == channelMainBean.channelType && this.joinFlag == channelMainBean.joinFlag && Intrinsics.areEqual(this.channelNumber, channelMainBean.channelNumber) && Intrinsics.areEqual(this.logo, channelMainBean.logo) && this.certificationFlag == channelMainBean.certificationFlag;
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

    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    @NotNull
    public final String getChannelDescription() {
        return this.channelDescription;
    }

    @NotNull
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    public final boolean getHostFlag() {
        int i = this.channelType;
        return i == 1 || i == 2 || i == 3;
    }

    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.channelDescription.hashCode() * 31) + Integer.hashCode(this.channelType)) * 31;
        boolean z = this.joinFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((iHashCode + r1) * 31) + this.channelNumber.hashCode()) * 31) + this.logo.hashCode()) * 31;
        boolean z2 = this.certificationFlag;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    public final boolean isRunOrUniverseChannel() {
        int i = this.channelType;
        return i == 1 || i == 2;
    }

    public final void setJoinFlag(boolean z) {
        this.joinFlag = z;
    }

    @NotNull
    public String toString() {
        return "ChannelMainBean(channelDescription=" + this.channelDescription + ", channelType=" + this.channelType + ", joinFlag=" + this.joinFlag + ", channelNumber=" + this.channelNumber + ", logo=" + this.logo + ", certificationFlag=" + this.certificationFlag + ')';
    }

    public ChannelMainBean(@NotNull String str, int i, boolean z, @NotNull String str2, @NotNull String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "channelDescription");
        Intrinsics.checkNotNullParameter(str2, "channelNumber");
        Intrinsics.checkNotNullParameter(str3, "logo");
        this.channelDescription = str;
        this.channelType = i;
        this.joinFlag = z;
        this.channelNumber = str2;
        this.logo = str3;
        this.certificationFlag = z2;
    }
}

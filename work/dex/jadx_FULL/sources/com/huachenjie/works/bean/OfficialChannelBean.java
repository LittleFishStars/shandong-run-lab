package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Ji\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006,"}, d2 = {"Lcom/huachenjie/works/bean/OfficialChannelBean;", "", "coverUrl", "", "coverHue", "logo", "channelNo", "channelNumber", "channelName", "channelUserValue", "avatarList", "", "joinFlag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getAvatarList", "()Ljava/util/List;", "getChannelName", "()Ljava/lang/String;", "getChannelNo", "getChannelNumber", "getChannelUserValue", "getCoverHue", "getCoverUrl", "getJoinFlag", "()Z", "setJoinFlag", "(Z)V", "getLogo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OfficialChannelBean {

    @NotNull
    private final List<String> avatarList;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelNo;

    @NotNull
    private final String channelNumber;

    @NotNull
    private final String channelUserValue;

    @NotNull
    private final String coverHue;

    @NotNull
    private final String coverUrl;
    private boolean joinFlag;

    @NotNull
    private final String logo;

    public OfficialChannelBean() {
        this(null, null, null, null, null, null, null, null, false, 511, null);
    }

    public OfficialChannelBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "coverUrl");
        Intrinsics.checkNotNullParameter(str2, "coverHue");
        Intrinsics.checkNotNullParameter(str3, "logo");
        Intrinsics.checkNotNullParameter(str4, "channelNo");
        Intrinsics.checkNotNullParameter(str5, "channelNumber");
        Intrinsics.checkNotNullParameter(str6, "channelName");
        Intrinsics.checkNotNullParameter(str7, "channelUserValue");
        Intrinsics.checkNotNullParameter(list, "avatarList");
        this.coverUrl = str;
        this.coverHue = str2;
        this.logo = str3;
        this.channelNo = str4;
        this.channelNumber = str5;
        this.channelName = str6;
        this.channelUserValue = str7;
        this.avatarList = list;
        this.joinFlag = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getChannelUserValue() {
        return this.channelUserValue;
    }

    @NotNull
    public final List<String> component8() {
        return this.avatarList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    public final OfficialChannelBean copy(@NotNull String coverUrl, @NotNull String coverHue, @NotNull String logo, @NotNull String channelNo, @NotNull String channelNumber, @NotNull String channelName, @NotNull String channelUserValue, @NotNull List<String> avatarList, boolean joinFlag) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverHue, "coverHue");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelNumber, "channelNumber");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(channelUserValue, "channelUserValue");
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        return new OfficialChannelBean(coverUrl, coverHue, logo, channelNo, channelNumber, channelName, channelUserValue, avatarList, joinFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialChannelBean)) {
            return false;
        }
        OfficialChannelBean officialChannelBean = (OfficialChannelBean) other;
        return Intrinsics.areEqual(this.coverUrl, officialChannelBean.coverUrl) && Intrinsics.areEqual(this.coverHue, officialChannelBean.coverHue) && Intrinsics.areEqual(this.logo, officialChannelBean.logo) && Intrinsics.areEqual(this.channelNo, officialChannelBean.channelNo) && Intrinsics.areEqual(this.channelNumber, officialChannelBean.channelNumber) && Intrinsics.areEqual(this.channelName, officialChannelBean.channelName) && Intrinsics.areEqual(this.channelUserValue, officialChannelBean.channelUserValue) && Intrinsics.areEqual(this.avatarList, officialChannelBean.avatarList) && this.joinFlag == officialChannelBean.joinFlag;
    }

    @NotNull
    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    @NotNull
    public final String getChannelUserValue() {
        return this.channelUserValue;
    }

    @NotNull
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final boolean getJoinFlag() {
        return this.joinFlag;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.coverUrl.hashCode() * 31) + this.coverHue.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.channelNo.hashCode()) * 31) + this.channelNumber.hashCode()) * 31) + this.channelName.hashCode()) * 31) + this.channelUserValue.hashCode()) * 31) + this.avatarList.hashCode()) * 31;
        boolean z = this.joinFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setJoinFlag(boolean z) {
        this.joinFlag = z;
    }

    @NotNull
    public String toString() {
        return "OfficialChannelBean(coverUrl=" + this.coverUrl + ", coverHue=" + this.coverHue + ", logo=" + this.logo + ", channelNo=" + this.channelNo + ", channelNumber=" + this.channelNumber + ", channelName=" + this.channelName + ", channelUserValue=" + this.channelUserValue + ", avatarList=" + this.avatarList + ", joinFlag=" + this.joinFlag + ')';
    }

    public /* synthetic */ OfficialChannelBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) == 0 ? str7 : "", (i & 128) != 0 ? new ArrayList() : list, (i & 256) != 0 ? false : z);
    }
}

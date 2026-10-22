package com.huachenjie.im.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006)"}, d2 = {"Lcom/huachenjie/im/bean/FriendUserInfo;", "", "accId", "", "name", "avatar", "alias", "appUserCode", "avatarFrameImgUrl", SignatureFragment.SIGNATURE, "isFriend", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAccId", "()Ljava/lang/String;", "getAlias", "setAlias", "(Ljava/lang/String;)V", "getAppUserCode", "getAvatar", "getAvatarFrameImgUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getSignature", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/huachenjie/im/bean/FriendUserInfo;", "equals", "other", "formatNickName", "hashCode", "", "toString", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FriendUserInfo {

    @Nullable
    private final String accId;

    @Nullable
    private String alias;

    @Nullable
    private final String appUserCode;

    @Nullable
    private final String avatar;

    @Nullable
    private final String avatarFrameImgUrl;

    @Nullable
    private final Boolean isFriend;

    @Nullable
    private final String name;

    @Nullable
    private final String signature;

    public FriendUserInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public FriendUserInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool) {
        this.accId = str;
        this.name = str2;
        this.avatar = str3;
        this.alias = str4;
        this.appUserCode = str5;
        this.avatarFrameImgUrl = str6;
        this.signature = str7;
        this.isFriend = bool;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAlias() {
        return this.alias;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsFriend() {
        return this.isFriend;
    }

    @NotNull
    public final FriendUserInfo copy(@Nullable String accId, @Nullable String name, @Nullable String avatar, @Nullable String alias, @Nullable String appUserCode, @Nullable String avatarFrameImgUrl, @Nullable String signature, @Nullable Boolean isFriend) {
        return new FriendUserInfo(accId, name, avatar, alias, appUserCode, avatarFrameImgUrl, signature, isFriend);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendUserInfo)) {
            return false;
        }
        FriendUserInfo friendUserInfo = (FriendUserInfo) other;
        return Intrinsics.areEqual(this.accId, friendUserInfo.accId) && Intrinsics.areEqual(this.name, friendUserInfo.name) && Intrinsics.areEqual(this.avatar, friendUserInfo.avatar) && Intrinsics.areEqual(this.alias, friendUserInfo.alias) && Intrinsics.areEqual(this.appUserCode, friendUserInfo.appUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, friendUserInfo.avatarFrameImgUrl) && Intrinsics.areEqual(this.signature, friendUserInfo.signature) && Intrinsics.areEqual(this.isFriend, friendUserInfo.isFriend);
    }

    @NotNull
    public final String formatNickName() {
        boolean zIsEmpty = TextUtils.isEmpty(this.name);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.alias);
        if (zIsEmpty && zIsEmpty2) {
            return "";
        }
        if (zIsEmpty2) {
            String str = this.name;
            return str == null ? "" : str;
        }
        String str2 = this.alias;
        return str2 == null ? "" : str2;
    }

    @Nullable
    public final String getAccId() {
        return this.accId;
    }

    @Nullable
    public final String getAlias() {
        return this.alias;
    }

    @Nullable
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        String str = this.accId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.alias;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appUserCode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.avatarFrameImgUrl;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.signature;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.isFriend;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    @Nullable
    public final Boolean isFriend() {
        return this.isFriend;
    }

    public final void setAlias(@Nullable String str) {
        this.alias = str;
    }

    @NotNull
    public String toString() {
        return "FriendUserInfo(accId=" + this.accId + ", name=" + this.name + ", avatar=" + this.avatar + ", alias=" + this.alias + ", appUserCode=" + this.appUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", signature=" + this.signature + ", isFriend=" + this.isFriend + ')';
    }

    public /* synthetic */ FriendUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) == 0 ? str7 : "", (i & 128) != 0 ? Boolean.FALSE : bool);
    }
}

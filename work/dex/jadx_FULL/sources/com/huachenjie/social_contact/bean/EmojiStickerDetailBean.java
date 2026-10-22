package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'J\t\u0010(\u001a\u00020'HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006*"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "", "emojiBagCode", "", ShareEmojiFriendDialog.EMOJI_BAG_NAME, UserConstants.EMOJI_PARAMS.d, UserConstants.EMOJI_PARAMS.e, "appUserCode", "myOwnFlag", "", UserConstants.EMOJI_PARAMS.c, "emojiList", "", "Lcom/huachenjie/social_contact/bean/EmojiStickerImageBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;)V", "getAppUserCode", "()Ljava/lang/String;", "getAuthHeadImg", "getAuthName", "getDownloadFlag", "()Z", "getEmojiBagCode", "getEmojiBagName", "getEmojiList", "()Ljava/util/List;", "getMyOwnFlag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "other", "findEmojiImageUrl", "index", "", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerDetailBean {

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String authHeadImg;

    @NotNull
    private final String authName;
    private final boolean downloadFlag;

    @NotNull
    private final String emojiBagCode;

    @NotNull
    private final String emojiBagName;

    @NotNull
    private final List<EmojiStickerImageBean> emojiList;
    private final boolean myOwnFlag;

    public EmojiStickerDetailBean() {
        this(null, null, null, null, null, false, false, null, 255, null);
    }

    public EmojiStickerDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, boolean z2, @NotNull List<EmojiStickerImageBean> list) {
        Intrinsics.checkNotNullParameter(str, "emojiBagCode");
        Intrinsics.checkNotNullParameter(str2, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(str3, UserConstants.EMOJI_PARAMS.d);
        Intrinsics.checkNotNullParameter(str4, UserConstants.EMOJI_PARAMS.e);
        Intrinsics.checkNotNullParameter(str5, "appUserCode");
        Intrinsics.checkNotNullParameter(list, "emojiList");
        this.emojiBagCode = str;
        this.emojiBagName = str2;
        this.authName = str3;
        this.authHeadImg = str4;
        this.appUserCode = str5;
        this.myOwnFlag = z;
        this.downloadFlag = z2;
        this.emojiList = list;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmojiBagName() {
        return this.emojiBagName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuthName() {
        return this.authName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAuthHeadImg() {
        return this.authHeadImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getMyOwnFlag() {
        return this.myOwnFlag;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDownloadFlag() {
        return this.downloadFlag;
    }

    @NotNull
    public final List<EmojiStickerImageBean> component8() {
        return this.emojiList;
    }

    @NotNull
    public final EmojiStickerDetailBean copy(@NotNull String emojiBagCode, @NotNull String emojiBagName, @NotNull String authName, @NotNull String authHeadImg, @NotNull String appUserCode, boolean myOwnFlag, boolean downloadFlag, @NotNull List<EmojiStickerImageBean> emojiList) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(authName, UserConstants.EMOJI_PARAMS.d);
        Intrinsics.checkNotNullParameter(authHeadImg, UserConstants.EMOJI_PARAMS.e);
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        return new EmojiStickerDetailBean(emojiBagCode, emojiBagName, authName, authHeadImg, appUserCode, myOwnFlag, downloadFlag, emojiList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerDetailBean)) {
            return false;
        }
        EmojiStickerDetailBean emojiStickerDetailBean = (EmojiStickerDetailBean) other;
        return Intrinsics.areEqual(this.emojiBagCode, emojiStickerDetailBean.emojiBagCode) && Intrinsics.areEqual(this.emojiBagName, emojiStickerDetailBean.emojiBagName) && Intrinsics.areEqual(this.authName, emojiStickerDetailBean.authName) && Intrinsics.areEqual(this.authHeadImg, emojiStickerDetailBean.authHeadImg) && Intrinsics.areEqual(this.appUserCode, emojiStickerDetailBean.appUserCode) && this.myOwnFlag == emojiStickerDetailBean.myOwnFlag && this.downloadFlag == emojiStickerDetailBean.downloadFlag && Intrinsics.areEqual(this.emojiList, emojiStickerDetailBean.emojiList);
    }

    @NotNull
    public final String findEmojiImageUrl(int index) {
        List<EmojiStickerImageBean> list = this.emojiList;
        return (list == null || list.isEmpty() || index >= this.emojiList.size()) ? "" : this.emojiList.get(index).getImgUrl();
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getAuthHeadImg() {
        return this.authHeadImg;
    }

    @NotNull
    public final String getAuthName() {
        return this.authName;
    }

    public final boolean getDownloadFlag() {
        return this.downloadFlag;
    }

    @NotNull
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    public final String getEmojiBagName() {
        return this.emojiBagName;
    }

    @NotNull
    public final List<EmojiStickerImageBean> getEmojiList() {
        return this.emojiList;
    }

    public final boolean getMyOwnFlag() {
        return this.myOwnFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.emojiBagCode.hashCode() * 31) + this.emojiBagName.hashCode()) * 31) + this.authName.hashCode()) * 31) + this.authHeadImg.hashCode()) * 31) + this.appUserCode.hashCode()) * 31;
        boolean z = this.myOwnFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.downloadFlag;
        return ((i + (z2 ? 1 : z2)) * 31) + this.emojiList.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiStickerDetailBean(emojiBagCode=" + this.emojiBagCode + ", emojiBagName=" + this.emojiBagName + ", authName=" + this.authName + ", authHeadImg=" + this.authHeadImg + ", appUserCode=" + this.appUserCode + ", myOwnFlag=" + this.myOwnFlag + ", downloadFlag=" + this.downloadFlag + ", emojiList=" + this.emojiList + ')';
    }

    public /* synthetic */ EmojiStickerDetailBean(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? false : z, (i & 64) == 0 ? z2 : false, (i & 128) != 0 ? new ArrayList() : list);
    }
}

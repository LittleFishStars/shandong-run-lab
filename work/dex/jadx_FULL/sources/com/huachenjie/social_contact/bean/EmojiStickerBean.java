package com.huachenjie.social_contact.bean;

import com.alibaba.ariver.permission.b;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.zj.adlib.h46;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0087\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\u0006\u0010:\u001a\u00020\u0003J\u0006\u0010;\u001a\u00020\u0003J\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u0005J\u0006\u0010>\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0003J\u0006\u0010A\u001a\u00020\u0005J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0006\u0010C\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020\u000bJ\u0006\u0010E\u001a\u00020\u000bJ\u0006\u0010F\u001a\u00020\u000bJ\u0006\u0010G\u001a\u00020\u000bJ\t\u0010H\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u001eR\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014¨\u0006I"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemStatusType", "", "emojiBagCode", "", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "emojiBagCover", b.b, "downloadTotal", UserConstants.EMOJI_PARAMS.c, "", "emojiList", "", UserConstants.EMOJI_PARAMS.d, UserConstants.EMOJI_PARAMS.e, "auidtStatus", "illegalStatus", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/util/List;Ljava/lang/String;Ljava/lang/String;II)V", "getAuidtStatus", "()I", "getAuthHeadImg", "()Ljava/lang/String;", "getAuthName", "getDownloadFlag", "()Z", "setDownloadFlag", "(Z)V", "getDownloadTotal", "setDownloadTotal", "(I)V", "getEmojiBagCode", "getEmojiBagCover", "getEmojiBagName", "getEmojiList", "()Ljava/util/List;", "getIllegalStatus", "getItemStatusType", "setItemStatusType", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "getLevel", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "", "formatBottomIcon", "formatBottomIconSub", "formatBottomText", "formatBottomTextSub", "formatDownloadTotal", "formatEmojiUrl", "position", "formatLevel", "hashCode", "obtain", "showBottomOperateSub", "showFail", "showReview", "showSuccess", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerBean implements MultiItemEntity {
    private final int auidtStatus;

    @NotNull
    private final String authHeadImg;

    @NotNull
    private final String authName;
    private boolean downloadFlag;
    private int downloadTotal;

    @NotNull
    private final String emojiBagCode;

    @NotNull
    private final String emojiBagCover;

    @NotNull
    private final String emojiBagName;

    @NotNull
    private final List<String> emojiList;
    private final int illegalStatus;
    private int itemStatusType;
    private final int level;

    public EmojiStickerBean() {
        this(0, null, null, null, 0, 0, false, null, null, null, 0, 0, 4095, null);
    }

    public EmojiStickerBean(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, int i3, boolean z, @NotNull List<String> list, @NotNull String str4, @NotNull String str5, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "emojiBagCode");
        Intrinsics.checkNotNullParameter(str2, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(str3, "emojiBagCover");
        Intrinsics.checkNotNullParameter(list, "emojiList");
        Intrinsics.checkNotNullParameter(str4, UserConstants.EMOJI_PARAMS.d);
        Intrinsics.checkNotNullParameter(str5, UserConstants.EMOJI_PARAMS.e);
        this.itemStatusType = i;
        this.emojiBagCode = str;
        this.emojiBagName = str2;
        this.emojiBagCover = str3;
        this.level = i2;
        this.downloadTotal = i3;
        this.downloadFlag = z;
        this.emojiList = list;
        this.authName = str4;
        this.authHeadImg = str5;
        this.auidtStatus = i4;
        this.illegalStatus = i5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getItemStatusType() {
        return this.itemStatusType;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAuthHeadImg() {
        return this.authHeadImg;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getAuidtStatus() {
        return this.auidtStatus;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getIllegalStatus() {
        return this.illegalStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmojiBagName() {
        return this.emojiBagName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmojiBagCover() {
        return this.emojiBagCover;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDownloadTotal() {
        return this.downloadTotal;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDownloadFlag() {
        return this.downloadFlag;
    }

    @NotNull
    public final List<String> component8() {
        return this.emojiList;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAuthName() {
        return this.authName;
    }

    @NotNull
    public final EmojiStickerBean copy(int itemStatusType, @NotNull String emojiBagCode, @NotNull String emojiBagName, @NotNull String emojiBagCover, int level, int downloadTotal, boolean downloadFlag, @NotNull List<String> emojiList, @NotNull String authName, @NotNull String authHeadImg, int auidtStatus, int illegalStatus) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(emojiBagCover, "emojiBagCover");
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        Intrinsics.checkNotNullParameter(authName, UserConstants.EMOJI_PARAMS.d);
        Intrinsics.checkNotNullParameter(authHeadImg, UserConstants.EMOJI_PARAMS.e);
        return new EmojiStickerBean(itemStatusType, emojiBagCode, emojiBagName, emojiBagCover, level, downloadTotal, downloadFlag, emojiList, authName, authHeadImg, auidtStatus, illegalStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerBean)) {
            return false;
        }
        EmojiStickerBean emojiStickerBean = (EmojiStickerBean) other;
        return this.itemStatusType == emojiStickerBean.itemStatusType && Intrinsics.areEqual(this.emojiBagCode, emojiStickerBean.emojiBagCode) && Intrinsics.areEqual(this.emojiBagName, emojiStickerBean.emojiBagName) && Intrinsics.areEqual(this.emojiBagCover, emojiStickerBean.emojiBagCover) && this.level == emojiStickerBean.level && this.downloadTotal == emojiStickerBean.downloadTotal && this.downloadFlag == emojiStickerBean.downloadFlag && Intrinsics.areEqual(this.emojiList, emojiStickerBean.emojiList) && Intrinsics.areEqual(this.authName, emojiStickerBean.authName) && Intrinsics.areEqual(this.authHeadImg, emojiStickerBean.authHeadImg) && this.auidtStatus == emojiStickerBean.auidtStatus && this.illegalStatus == emojiStickerBean.illegalStatus;
    }

    public final int formatBottomIcon() {
        int i = this.itemStatusType;
        if (i == 1) {
            return 0;
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                return R.drawable.ic_emoji_sticker_obtain;
            }
            if (i != 5) {
                return 0;
            }
            return R.drawable.ic_emoji_sticker_own;
        }
        return R.drawable.ic_emoji_sticker_delete;
    }

    public final int formatBottomIconSub() {
        int i = this.itemStatusType;
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return R.drawable.ic_emoji_sticker_edit;
        }
        if (i == 3 || i == 4 || i == 5) {
            return R.drawable.ic_emoji_sticker_share;
        }
        return 0;
    }

    @NotNull
    public final String formatBottomText() {
        int i = this.itemStatusType;
        if (i == 1) {
            return "";
        }
        if (i == 2 || i == 3) {
            return "删除";
        }
        if (i != 4) {
            return i != 5 ? "" : "已拥有";
        }
        return "获取";
    }

    @NotNull
    public final String formatBottomTextSub() {
        int i = this.itemStatusType;
        if (i == 1) {
            return "";
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 5) ? "分享" : "";
        }
        return "编辑";
    }

    @NotNull
    public final String formatDownloadTotal() {
        int i = this.downloadTotal;
        if (i == 0) {
            return "0";
        }
        if (i <= 9999) {
            return String.valueOf(i);
        }
        return h46.f42049a.j(Float.valueOf(this.downloadTotal / 10000.0f), 1) + 'w';
    }

    @NotNull
    public final String formatEmojiUrl(int position) {
        List<String> list = this.emojiList;
        return (list == null || list.isEmpty() || position >= this.emojiList.size()) ? "" : this.emojiList.get(position);
    }

    @NotNull
    public final String formatLevel() {
        int i = this.level;
        if (i == 0) {
            return "";
        }
        if (i > 9999) {
            return (char) 12304 + h46.f42049a.j(Float.valueOf(this.level / 10000.0f), 1) + "w楼住户】";
        }
        return (char) 12304 + this.level + "楼住户】";
    }

    public final int getAuidtStatus() {
        return this.auidtStatus;
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

    public final int getDownloadTotal() {
        return this.downloadTotal;
    }

    @NotNull
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    public final String getEmojiBagCover() {
        return this.emojiBagCover;
    }

    @NotNull
    public final String getEmojiBagName() {
        return this.emojiBagName;
    }

    @NotNull
    public final List<String> getEmojiList() {
        return this.emojiList;
    }

    public final int getIllegalStatus() {
        return this.illegalStatus;
    }

    public final int getItemStatusType() {
        return this.itemStatusType;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    public final int getLevel() {
        return this.level;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.itemStatusType) * 31) + this.emojiBagCode.hashCode()) * 31) + this.emojiBagName.hashCode()) * 31) + this.emojiBagCover.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.downloadTotal)) * 31;
        boolean z = this.downloadFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((iHashCode + r1) * 31) + this.emojiList.hashCode()) * 31) + this.authName.hashCode()) * 31) + this.authHeadImg.hashCode()) * 31) + Integer.hashCode(this.auidtStatus)) * 31) + Integer.hashCode(this.illegalStatus);
    }

    public final boolean obtain() {
        return this.itemStatusType == 4;
    }

    public final void setDownloadFlag(boolean z) {
        this.downloadFlag = z;
    }

    public final void setDownloadTotal(int i) {
        this.downloadTotal = i;
    }

    public final void setItemStatusType(int i) {
        this.itemStatusType = i;
    }

    public final boolean showBottomOperateSub() {
        int i = this.itemStatusType;
        if (i != 1) {
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
        return false;
    }

    public final boolean showFail() {
        return this.auidtStatus == 2 && this.illegalStatus == 1;
    }

    public final boolean showReview() {
        return this.auidtStatus != 2;
    }

    public final boolean showSuccess() {
        return this.auidtStatus == 2 && this.illegalStatus != 1;
    }

    @NotNull
    public String toString() {
        return "EmojiStickerBean(itemStatusType=" + this.itemStatusType + ", emojiBagCode=" + this.emojiBagCode + ", emojiBagName=" + this.emojiBagName + ", emojiBagCover=" + this.emojiBagCover + ", level=" + this.level + ", downloadTotal=" + this.downloadTotal + ", downloadFlag=" + this.downloadFlag + ", emojiList=" + this.emojiList + ", authName=" + this.authName + ", authHeadImg=" + this.authHeadImg + ", auidtStatus=" + this.auidtStatus + ", illegalStatus=" + this.illegalStatus + ')';
    }

    public /* synthetic */ EmojiStickerBean(int i, String str, String str2, String str3, int i2, int i3, boolean z, List list, String str4, String str5, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? "" : str3, (i6 & 16) != 0 ? 0 : i2, (i6 & 32) != 0 ? 0 : i3, (i6 & 64) != 0 ? false : z, (i6 & 128) != 0 ? new ArrayList() : list, (i6 & 256) != 0 ? "" : str4, (i6 & 512) == 0 ? str5 : "", (i6 & 1024) != 0 ? 2 : i4, (i6 & 2048) == 0 ? i5 : 0);
    }
}

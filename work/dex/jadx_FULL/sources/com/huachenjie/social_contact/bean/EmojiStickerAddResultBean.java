package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerAddResultBean;", "", "emojiBagCode", "", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "(Ljava/lang/String;Ljava/lang/String;)V", "getEmojiBagCode", "()Ljava/lang/String;", "getEmojiBagName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerAddResultBean {

    @NotNull
    private final String emojiBagCode;

    @NotNull
    private final String emojiBagName;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiStickerAddResultBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public EmojiStickerAddResultBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "emojiBagCode");
        Intrinsics.checkNotNullParameter(str2, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        this.emojiBagCode = str;
        this.emojiBagName = str2;
    }

    public static /* synthetic */ EmojiStickerAddResultBean copy$default(EmojiStickerAddResultBean emojiStickerAddResultBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiStickerAddResultBean.emojiBagCode;
        }
        if ((i & 2) != 0) {
            str2 = emojiStickerAddResultBean.emojiBagName;
        }
        return emojiStickerAddResultBean.copy(str, str2);
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
    public final EmojiStickerAddResultBean copy(@NotNull String emojiBagCode, @NotNull String emojiBagName) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        return new EmojiStickerAddResultBean(emojiBagCode, emojiBagName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerAddResultBean)) {
            return false;
        }
        EmojiStickerAddResultBean emojiStickerAddResultBean = (EmojiStickerAddResultBean) other;
        return Intrinsics.areEqual(this.emojiBagCode, emojiStickerAddResultBean.emojiBagCode) && Intrinsics.areEqual(this.emojiBagName, emojiStickerAddResultBean.emojiBagName);
    }

    @NotNull
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    public final String getEmojiBagName() {
        return this.emojiBagName;
    }

    public int hashCode() {
        return (this.emojiBagCode.hashCode() * 31) + this.emojiBagName.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiStickerAddResultBean(emojiBagCode=" + this.emojiBagCode + ", emojiBagName=" + this.emojiBagName + ')';
    }

    public /* synthetic */ EmojiStickerAddResultBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

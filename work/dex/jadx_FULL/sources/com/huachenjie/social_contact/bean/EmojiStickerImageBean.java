package com.huachenjie.social_contact.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.im.page.emoji.StickerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerImageBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", StickerFragment.EMOJI_CODE, "", "imgUrl", "fileMD5", "isLocalFile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getEmojiCode", "()Ljava/lang/String;", "getFileMD5", "getImgUrl", "()Z", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerImageBean implements MultiItemEntity {

    @NotNull
    private final String emojiCode;

    @NotNull
    private final String fileMD5;

    @NotNull
    private final String imgUrl;
    private final boolean isLocalFile;

    public EmojiStickerImageBean() {
        this(null, null, null, false, 15, null);
    }

    public EmojiStickerImageBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, StickerFragment.EMOJI_CODE);
        Intrinsics.checkNotNullParameter(str2, "imgUrl");
        Intrinsics.checkNotNullParameter(str3, "fileMD5");
        this.emojiCode = str;
        this.imgUrl = str2;
        this.fileMD5 = str3;
        this.isLocalFile = z;
    }

    public static /* synthetic */ EmojiStickerImageBean copy$default(EmojiStickerImageBean emojiStickerImageBean, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiStickerImageBean.emojiCode;
        }
        if ((i & 2) != 0) {
            str2 = emojiStickerImageBean.imgUrl;
        }
        if ((i & 4) != 0) {
            str3 = emojiStickerImageBean.fileMD5;
        }
        if ((i & 8) != 0) {
            z = emojiStickerImageBean.isLocalFile;
        }
        return emojiStickerImageBean.copy(str, str2, str3, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmojiCode() {
        return this.emojiCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFileMD5() {
        return this.fileMD5;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLocalFile() {
        return this.isLocalFile;
    }

    @NotNull
    public final EmojiStickerImageBean copy(@NotNull String emojiCode, @NotNull String imgUrl, @NotNull String fileMD5, boolean isLocalFile) {
        Intrinsics.checkNotNullParameter(emojiCode, StickerFragment.EMOJI_CODE);
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(fileMD5, "fileMD5");
        return new EmojiStickerImageBean(emojiCode, imgUrl, fileMD5, isLocalFile);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerImageBean)) {
            return false;
        }
        EmojiStickerImageBean emojiStickerImageBean = (EmojiStickerImageBean) other;
        return Intrinsics.areEqual(this.emojiCode, emojiStickerImageBean.emojiCode) && Intrinsics.areEqual(this.imgUrl, emojiStickerImageBean.imgUrl) && Intrinsics.areEqual(this.fileMD5, emojiStickerImageBean.fileMD5) && this.isLocalFile == emojiStickerImageBean.isLocalFile;
    }

    @NotNull
    public final String getEmojiCode() {
        return this.emojiCode;
    }

    @NotNull
    public final String getFileMD5() {
        return this.fileMD5;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.emojiCode.hashCode() * 31) + this.imgUrl.hashCode()) * 31) + this.fileMD5.hashCode()) * 31;
        boolean z = this.isLocalFile;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isLocalFile() {
        return this.isLocalFile;
    }

    @NotNull
    public String toString() {
        return "EmojiStickerImageBean(emojiCode=" + this.emojiCode + ", imgUrl=" + this.imgUrl + ", fileMD5=" + this.fileMD5 + ", isLocalFile=" + this.isLocalFile + ')';
    }

    public /* synthetic */ EmojiStickerImageBean(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }
}

package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.im.page.emoji.StickerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/im/bean/EmojiBean;", "", StickerFragment.EMOJI_CODE, "", "imgUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmojiCode", "()Ljava/lang/String;", "getImgUrl", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiBean {

    @NotNull
    private final String emojiCode;

    @NotNull
    private final String imgUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public EmojiBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, StickerFragment.EMOJI_CODE);
        Intrinsics.checkNotNullParameter(str2, "imgUrl");
        this.emojiCode = str;
        this.imgUrl = str2;
    }

    public static /* synthetic */ EmojiBean copy$default(EmojiBean emojiBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiBean.emojiCode;
        }
        if ((i & 2) != 0) {
            str2 = emojiBean.imgUrl;
        }
        return emojiBean.copy(str, str2);
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
    public final EmojiBean copy(@NotNull String emojiCode, @NotNull String imgUrl) {
        Intrinsics.checkNotNullParameter(emojiCode, StickerFragment.EMOJI_CODE);
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        return new EmojiBean(emojiCode, imgUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiBean)) {
            return false;
        }
        EmojiBean emojiBean = (EmojiBean) other;
        return Intrinsics.areEqual(this.emojiCode, emojiBean.emojiCode) && Intrinsics.areEqual(this.imgUrl, emojiBean.imgUrl);
    }

    @NotNull
    public final String getEmojiCode() {
        return this.emojiCode;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    public int hashCode() {
        return (this.emojiCode.hashCode() * 31) + this.imgUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiBean(emojiCode=" + this.emojiCode + ", imgUrl=" + this.imgUrl + ')';
    }

    public /* synthetic */ EmojiBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

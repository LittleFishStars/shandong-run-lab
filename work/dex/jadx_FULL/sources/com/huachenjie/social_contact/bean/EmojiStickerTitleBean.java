package com.huachenjie.social_contact.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerTitleBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemTitle", "", "paddingTop", "", "(Ljava/lang/String;I)V", "getItemTitle", "()Ljava/lang/String;", "setItemTitle", "(Ljava/lang/String;)V", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getPaddingTop", "setPaddingTop", "(I)V", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerTitleBean implements MultiItemEntity {

    @NotNull
    private String itemTitle;
    private int paddingTop;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiStickerTitleBean() {
        String str = null;
        this(str, 0, 3, str);
    }

    public EmojiStickerTitleBean(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "itemTitle");
        this.itemTitle = str;
        this.paddingTop = i;
    }

    public static /* synthetic */ EmojiStickerTitleBean copy$default(EmojiStickerTitleBean emojiStickerTitleBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emojiStickerTitleBean.itemTitle;
        }
        if ((i2 & 2) != 0) {
            i = emojiStickerTitleBean.paddingTop;
        }
        return emojiStickerTitleBean.copy(str, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemTitle() {
        return this.itemTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPaddingTop() {
        return this.paddingTop;
    }

    @NotNull
    public final EmojiStickerTitleBean copy(@NotNull String itemTitle, int paddingTop) {
        Intrinsics.checkNotNullParameter(itemTitle, "itemTitle");
        return new EmojiStickerTitleBean(itemTitle, paddingTop);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerTitleBean)) {
            return false;
        }
        EmojiStickerTitleBean emojiStickerTitleBean = (EmojiStickerTitleBean) other;
        return Intrinsics.areEqual(this.itemTitle, emojiStickerTitleBean.itemTitle) && this.paddingTop == emojiStickerTitleBean.paddingTop;
    }

    @NotNull
    public final String getItemTitle() {
        return this.itemTitle;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public int hashCode() {
        return (this.itemTitle.hashCode() * 31) + Integer.hashCode(this.paddingTop);
    }

    public final void setItemTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemTitle = str;
    }

    public final void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    @NotNull
    public String toString() {
        return "EmojiStickerTitleBean(itemTitle=" + this.itemTitle + ", paddingTop=" + this.paddingTop + ')';
    }

    public /* synthetic */ EmojiStickerTitleBean(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }
}

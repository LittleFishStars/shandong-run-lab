package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiStickerFileBean;", "", "fileUrl", "", "fileMD5", "(Ljava/lang/String;Ljava/lang/String;)V", "getFileMD5", "()Ljava/lang/String;", "getFileUrl", "setFileUrl", "(Ljava/lang/String;)V", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiStickerFileBean {

    @NotNull
    private final String fileMD5;

    @NotNull
    private String fileUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiStickerFileBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public EmojiStickerFileBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "fileUrl");
        Intrinsics.checkNotNullParameter(str2, "fileMD5");
        this.fileUrl = str;
        this.fileMD5 = str2;
    }

    public static /* synthetic */ EmojiStickerFileBean copy$default(EmojiStickerFileBean emojiStickerFileBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiStickerFileBean.fileUrl;
        }
        if ((i & 2) != 0) {
            str2 = emojiStickerFileBean.fileMD5;
        }
        return emojiStickerFileBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileMD5() {
        return this.fileMD5;
    }

    @NotNull
    public final EmojiStickerFileBean copy(@NotNull String fileUrl, @NotNull String fileMD5) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(fileMD5, "fileMD5");
        return new EmojiStickerFileBean(fileUrl, fileMD5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiStickerFileBean)) {
            return false;
        }
        EmojiStickerFileBean emojiStickerFileBean = (EmojiStickerFileBean) other;
        return Intrinsics.areEqual(this.fileUrl, emojiStickerFileBean.fileUrl) && Intrinsics.areEqual(this.fileMD5, emojiStickerFileBean.fileMD5);
    }

    @NotNull
    public final String getFileMD5() {
        return this.fileMD5;
    }

    @NotNull
    public final String getFileUrl() {
        return this.fileUrl;
    }

    public int hashCode() {
        return (this.fileUrl.hashCode() * 31) + this.fileMD5.hashCode();
    }

    public final void setFileUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileUrl = str;
    }

    @NotNull
    public String toString() {
        return "EmojiStickerFileBean(fileUrl=" + this.fileUrl + ", fileMD5=" + this.fileMD5 + ')';
    }

    public /* synthetic */ EmojiStickerFileBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

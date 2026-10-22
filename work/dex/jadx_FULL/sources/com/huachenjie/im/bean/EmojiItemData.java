package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/im/bean/EmojiItemData;", "", "emojiBagCode", "", "emojiBagIcon", "emojiBagIconRes", "", "selected", "", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getEmojiBagCode", "()Ljava/lang/String;", "getEmojiBagIcon", "getEmojiBagIconRes", "()I", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiItemData {

    @NotNull
    private final String emojiBagCode;

    @NotNull
    private final String emojiBagIcon;
    private final int emojiBagIconRes;
    private boolean selected;

    public EmojiItemData() {
        this(null, null, 0, false, 15, null);
    }

    public EmojiItemData(@NotNull String str, @NotNull String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "emojiBagCode");
        Intrinsics.checkNotNullParameter(str2, "emojiBagIcon");
        this.emojiBagCode = str;
        this.emojiBagIcon = str2;
        this.emojiBagIconRes = i;
        this.selected = z;
    }

    public static /* synthetic */ EmojiItemData copy$default(EmojiItemData emojiItemData, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emojiItemData.emojiBagCode;
        }
        if ((i2 & 2) != 0) {
            str2 = emojiItemData.emojiBagIcon;
        }
        if ((i2 & 4) != 0) {
            i = emojiItemData.emojiBagIconRes;
        }
        if ((i2 & 8) != 0) {
            z = emojiItemData.selected;
        }
        return emojiItemData.copy(str, str2, i, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmojiBagIcon() {
        return this.emojiBagIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEmojiBagIconRes() {
        return this.emojiBagIconRes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final EmojiItemData copy(@NotNull String emojiBagCode, @NotNull String emojiBagIcon, int emojiBagIconRes, boolean selected) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagIcon, "emojiBagIcon");
        return new EmojiItemData(emojiBagCode, emojiBagIcon, emojiBagIconRes, selected);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiItemData)) {
            return false;
        }
        EmojiItemData emojiItemData = (EmojiItemData) other;
        return Intrinsics.areEqual(this.emojiBagCode, emojiItemData.emojiBagCode) && Intrinsics.areEqual(this.emojiBagIcon, emojiItemData.emojiBagIcon) && this.emojiBagIconRes == emojiItemData.emojiBagIconRes && this.selected == emojiItemData.selected;
    }

    @NotNull
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @NotNull
    public final String getEmojiBagIcon() {
        return this.emojiBagIcon;
    }

    public final int getEmojiBagIconRes() {
        return this.emojiBagIconRes;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((((this.emojiBagCode.hashCode() * 31) + this.emojiBagIcon.hashCode()) * 31) + Integer.hashCode(this.emojiBagIconRes)) * 31;
        boolean z = this.selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    @NotNull
    public String toString() {
        return "EmojiItemData(emojiBagCode=" + this.emojiBagCode + ", emojiBagIcon=" + this.emojiBagIcon + ", emojiBagIconRes=" + this.emojiBagIconRes + ", selected=" + this.selected + ')';
    }

    public /* synthetic */ EmojiItemData(String str, String str2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }
}

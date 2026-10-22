package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.permission.b;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.zj.adlib.h46;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/huachenjie/social_contact/bean/EmojiPropBean;", "Landroid/os/Parcelable;", "emojiBagCode", "", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "emojiBagCover", b.b, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEmojiBagCode", "()Ljava/lang/String;", "getEmojiBagCover", "getEmojiBagName", "getLevel", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "formatLevel", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiPropBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EmojiPropBean> CREATOR = new Creator();

    @NotNull
    private final String emojiBagCode;

    @NotNull
    private final String emojiBagCover;

    @NotNull
    private final String emojiBagName;
    private final int level;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmojiPropBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmojiPropBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EmojiPropBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmojiPropBean[] newArray(int i) {
            return new EmojiPropBean[i];
        }
    }

    public EmojiPropBean() {
        this(null, null, null, 0, 15, null);
    }

    public EmojiPropBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "emojiBagCode");
        Intrinsics.checkNotNullParameter(str2, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(str3, "emojiBagCover");
        this.emojiBagCode = str;
        this.emojiBagName = str2;
        this.emojiBagCover = str3;
        this.level = i;
    }

    public static /* synthetic */ EmojiPropBean copy$default(EmojiPropBean emojiPropBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emojiPropBean.emojiBagCode;
        }
        if ((i2 & 2) != 0) {
            str2 = emojiPropBean.emojiBagName;
        }
        if ((i2 & 4) != 0) {
            str3 = emojiPropBean.emojiBagCover;
        }
        if ((i2 & 8) != 0) {
            i = emojiPropBean.level;
        }
        return emojiPropBean.copy(str, str2, str3, i);
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
    public final String getEmojiBagCover() {
        return this.emojiBagCover;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    @NotNull
    public final EmojiPropBean copy(@NotNull String emojiBagCode, @NotNull String emojiBagName, @NotNull String emojiBagCover, int level) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
        Intrinsics.checkNotNullParameter(emojiBagCover, "emojiBagCover");
        return new EmojiPropBean(emojiBagCode, emojiBagName, emojiBagCover, level);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiPropBean)) {
            return false;
        }
        EmojiPropBean emojiPropBean = (EmojiPropBean) other;
        return Intrinsics.areEqual(this.emojiBagCode, emojiPropBean.emojiBagCode) && Intrinsics.areEqual(this.emojiBagName, emojiPropBean.emojiBagName) && Intrinsics.areEqual(this.emojiBagCover, emojiPropBean.emojiBagCover) && this.level == emojiPropBean.level;
    }

    @NotNull
    public final String formatLevel() {
        int i = this.level;
        if (i == 0) {
            return "";
        }
        if (i > 9999) {
            return h46.f42049a.j(Float.valueOf(this.level / 10000.0f), 1) + "w楼";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.level);
        sb.append((char) 27004);
        return sb.toString();
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

    public final int getLevel() {
        return this.level;
    }

    public int hashCode() {
        return (((((this.emojiBagCode.hashCode() * 31) + this.emojiBagName.hashCode()) * 31) + this.emojiBagCover.hashCode()) * 31) + Integer.hashCode(this.level);
    }

    @NotNull
    public String toString() {
        return "EmojiPropBean(emojiBagCode=" + this.emojiBagCode + ", emojiBagName=" + this.emojiBagName + ", emojiBagCover=" + this.emojiBagCover + ", level=" + this.level + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.emojiBagCode);
        parcel.writeString(this.emojiBagName);
        parcel.writeString(this.emojiBagCover);
        parcel.writeInt(this.level);
    }

    public /* synthetic */ EmojiPropBean(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}

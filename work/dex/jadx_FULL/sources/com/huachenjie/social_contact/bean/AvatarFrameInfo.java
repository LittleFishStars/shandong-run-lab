package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;", "", "avatarFrameImg", "", "backgroundImg", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvatarFrameImg", "()Ljava/lang/String;", "setAvatarFrameImg", "(Ljava/lang/String;)V", "getBackgroundImg", "setBackgroundImg", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AvatarFrameInfo {

    @Nullable
    private String avatarFrameImg;

    @Nullable
    private String backgroundImg;

    /* JADX WARN: Illegal instructions before constructor call */
    public AvatarFrameInfo() {
        String str = null;
        this(str, str, 3, str);
    }

    public AvatarFrameInfo(@Nullable String str, @Nullable String str2) {
        this.avatarFrameImg = str;
        this.backgroundImg = str2;
    }

    public static /* synthetic */ AvatarFrameInfo copy$default(AvatarFrameInfo avatarFrameInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatarFrameInfo.avatarFrameImg;
        }
        if ((i & 2) != 0) {
            str2 = avatarFrameInfo.backgroundImg;
        }
        return avatarFrameInfo.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatarFrameImg() {
        return this.avatarFrameImg;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    @NotNull
    public final AvatarFrameInfo copy(@Nullable String avatarFrameImg, @Nullable String backgroundImg) {
        return new AvatarFrameInfo(avatarFrameImg, backgroundImg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarFrameInfo)) {
            return false;
        }
        AvatarFrameInfo avatarFrameInfo = (AvatarFrameInfo) other;
        return Intrinsics.areEqual(this.avatarFrameImg, avatarFrameInfo.avatarFrameImg) && Intrinsics.areEqual(this.backgroundImg, avatarFrameInfo.backgroundImg);
    }

    @Nullable
    public final String getAvatarFrameImg() {
        return this.avatarFrameImg;
    }

    @Nullable
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    public int hashCode() {
        String str = this.avatarFrameImg;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.backgroundImg;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAvatarFrameImg(@Nullable String str) {
        this.avatarFrameImg = str;
    }

    public final void setBackgroundImg(@Nullable String str) {
        this.backgroundImg = str;
    }

    @NotNull
    public String toString() {
        return "AvatarFrameInfo(avatarFrameImg=" + this.avatarFrameImg + ", backgroundImg=" + this.backgroundImg + ')';
    }

    public /* synthetic */ AvatarFrameInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

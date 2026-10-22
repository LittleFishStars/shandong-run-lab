package com.huachenjie.mine.bean;

import com.huachenjie.base.bean.UnlockMode;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jk\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001b¨\u00060"}, d2 = {"Lcom/huachenjie/mine/bean/AvatarFrameBean;", "", "metaversePhotoFrameCode", "", "frameName", "frameDescription", "avatarFrameImgUrl", "sellingRemak", "freeFlag", "", "unlockFlag", "", "wearFlag", "unlockingModeDOS", "Lcom/huachenjie/base/bean/UnlockMode;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZLcom/huachenjie/base/bean/UnlockMode;)V", "getAvatarFrameImgUrl", "()Ljava/lang/String;", "getFrameDescription", "getFrameName", "getFreeFlag", "()I", "getMetaversePhotoFrameCode", "getSellingRemak", "getUnlockFlag", "()Z", "setUnlockFlag", "(Z)V", "getUnlockingModeDOS", "()Lcom/huachenjie/base/bean/UnlockMode;", "setUnlockingModeDOS", "(Lcom/huachenjie/base/bean/UnlockMode;)V", "getWearFlag", "setWearFlag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AvatarFrameBean {

    @NotNull
    private final String avatarFrameImgUrl;

    @Nullable
    private final String frameDescription;

    @Nullable
    private final String frameName;
    private final int freeFlag;

    @NotNull
    private final String metaversePhotoFrameCode;

    @Nullable
    private final String sellingRemak;
    private boolean unlockFlag;

    @Nullable
    private UnlockMode unlockingModeDOS;
    private boolean wearFlag;

    public AvatarFrameBean(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, int i, boolean z, boolean z2, @Nullable UnlockMode unlockMode) {
        Intrinsics.checkNotNullParameter(str, "metaversePhotoFrameCode");
        Intrinsics.checkNotNullParameter(str4, "avatarFrameImgUrl");
        this.metaversePhotoFrameCode = str;
        this.frameName = str2;
        this.frameDescription = str3;
        this.avatarFrameImgUrl = str4;
        this.sellingRemak = str5;
        this.freeFlag = i;
        this.unlockFlag = z;
        this.wearFlag = z2;
        this.unlockingModeDOS = unlockMode;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaversePhotoFrameCode() {
        return this.metaversePhotoFrameCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFrameName() {
        return this.frameName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFrameDescription() {
        return this.frameDescription;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSellingRemak() {
        return this.sellingRemak;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFreeFlag() {
        return this.freeFlag;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getUnlockFlag() {
        return this.unlockFlag;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getWearFlag() {
        return this.wearFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final UnlockMode getUnlockingModeDOS() {
        return this.unlockingModeDOS;
    }

    @NotNull
    public final AvatarFrameBean copy(@NotNull String metaversePhotoFrameCode, @Nullable String frameName, @Nullable String frameDescription, @NotNull String avatarFrameImgUrl, @Nullable String sellingRemak, int freeFlag, boolean unlockFlag, boolean wearFlag, @Nullable UnlockMode unlockingModeDOS) {
        Intrinsics.checkNotNullParameter(metaversePhotoFrameCode, "metaversePhotoFrameCode");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        return new AvatarFrameBean(metaversePhotoFrameCode, frameName, frameDescription, avatarFrameImgUrl, sellingRemak, freeFlag, unlockFlag, wearFlag, unlockingModeDOS);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarFrameBean)) {
            return false;
        }
        AvatarFrameBean avatarFrameBean = (AvatarFrameBean) other;
        return Intrinsics.areEqual(this.metaversePhotoFrameCode, avatarFrameBean.metaversePhotoFrameCode) && Intrinsics.areEqual(this.frameName, avatarFrameBean.frameName) && Intrinsics.areEqual(this.frameDescription, avatarFrameBean.frameDescription) && Intrinsics.areEqual(this.avatarFrameImgUrl, avatarFrameBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.sellingRemak, avatarFrameBean.sellingRemak) && this.freeFlag == avatarFrameBean.freeFlag && this.unlockFlag == avatarFrameBean.unlockFlag && this.wearFlag == avatarFrameBean.wearFlag && Intrinsics.areEqual(this.unlockingModeDOS, avatarFrameBean.unlockingModeDOS);
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    public final String getFrameDescription() {
        return this.frameDescription;
    }

    @Nullable
    public final String getFrameName() {
        return this.frameName;
    }

    public final int getFreeFlag() {
        return this.freeFlag;
    }

    @NotNull
    public final String getMetaversePhotoFrameCode() {
        return this.metaversePhotoFrameCode;
    }

    @Nullable
    public final String getSellingRemak() {
        return this.sellingRemak;
    }

    public final boolean getUnlockFlag() {
        return this.unlockFlag;
    }

    @Nullable
    public final UnlockMode getUnlockingModeDOS() {
        return this.unlockingModeDOS;
    }

    public final boolean getWearFlag() {
        return this.wearFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = this.metaversePhotoFrameCode.hashCode() * 31;
        String str = this.frameName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.frameDescription;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.avatarFrameImgUrl.hashCode()) * 31;
        String str3 = this.sellingRemak;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.freeFlag)) * 31;
        boolean z = this.unlockFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        boolean z2 = this.wearFlag;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        UnlockMode unlockMode = this.unlockingModeDOS;
        return i2 + (unlockMode != null ? unlockMode.hashCode() : 0);
    }

    public final void setUnlockFlag(boolean z) {
        this.unlockFlag = z;
    }

    public final void setUnlockingModeDOS(@Nullable UnlockMode unlockMode) {
        this.unlockingModeDOS = unlockMode;
    }

    public final void setWearFlag(boolean z) {
        this.wearFlag = z;
    }

    @NotNull
    public String toString() {
        return "AvatarFrameBean(metaversePhotoFrameCode=" + this.metaversePhotoFrameCode + ", frameName=" + this.frameName + ", frameDescription=" + this.frameDescription + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", sellingRemak=" + this.sellingRemak + ", freeFlag=" + this.freeFlag + ", unlockFlag=" + this.unlockFlag + ", wearFlag=" + this.wearFlag + ", unlockingModeDOS=" + this.unlockingModeDOS + ')';
    }

    public /* synthetic */ AvatarFrameBean(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2, UnlockMode unlockMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, str4, (i2 & 16) != 0 ? "" : str5, i, z, z2, (i2 & 256) != 0 ? null : unlockMode);
    }
}

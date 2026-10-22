package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Jm\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013¨\u00060"}, d2 = {"Lcom/huachenjie/social_contact/bean/IPBean;", "", "metaverseIpCode", "", "ipName", "ipDescription", "freeFlag", "", "haveFlag", "", "img", "checkedFlag", "metaverseModelCode", "componentSellingRemak", "newFlag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "getCheckedFlag", "()Z", "setCheckedFlag", "(Z)V", "getComponentSellingRemak", "()Ljava/lang/String;", "getFreeFlag", "()I", "getHaveFlag", "setHaveFlag", "getImg", "getIpDescription", "getIpName", "getMetaverseIpCode", "getMetaverseModelCode", "getNewFlag", "setNewFlag", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class IPBean {
    private boolean checkedFlag;

    @NotNull
    private final String componentSellingRemak;
    private final int freeFlag;
    private boolean haveFlag;

    @NotNull
    private final String img;

    @NotNull
    private final String ipDescription;

    @NotNull
    private final String ipName;

    @NotNull
    private final String metaverseIpCode;

    @NotNull
    private final String metaverseModelCode;
    private boolean newFlag;

    public IPBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @NotNull String str4, boolean z2, @NotNull String str5, @NotNull String str6, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "metaverseIpCode");
        Intrinsics.checkNotNullParameter(str2, "ipName");
        Intrinsics.checkNotNullParameter(str3, "ipDescription");
        Intrinsics.checkNotNullParameter(str4, "img");
        Intrinsics.checkNotNullParameter(str5, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(str6, "componentSellingRemak");
        this.metaverseIpCode = str;
        this.ipName = str2;
        this.ipDescription = str3;
        this.freeFlag = i;
        this.haveFlag = z;
        this.img = str4;
        this.checkedFlag = z2;
        this.metaverseModelCode = str5;
        this.componentSellingRemak = str6;
        this.newFlag = z3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseIpCode() {
        return this.metaverseIpCode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getNewFlag() {
        return this.newFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIpName() {
        return this.ipName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIpDescription() {
        return this.ipDescription;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFreeFlag() {
        return this.freeFlag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHaveFlag() {
        return this.haveFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCheckedFlag() {
        return this.checkedFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getComponentSellingRemak() {
        return this.componentSellingRemak;
    }

    @NotNull
    public final IPBean copy(@NotNull String metaverseIpCode, @NotNull String ipName, @NotNull String ipDescription, int freeFlag, boolean haveFlag, @NotNull String img, boolean checkedFlag, @NotNull String metaverseModelCode, @NotNull String componentSellingRemak, boolean newFlag) {
        Intrinsics.checkNotNullParameter(metaverseIpCode, "metaverseIpCode");
        Intrinsics.checkNotNullParameter(ipName, "ipName");
        Intrinsics.checkNotNullParameter(ipDescription, "ipDescription");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        Intrinsics.checkNotNullParameter(componentSellingRemak, "componentSellingRemak");
        return new IPBean(metaverseIpCode, ipName, ipDescription, freeFlag, haveFlag, img, checkedFlag, metaverseModelCode, componentSellingRemak, newFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IPBean)) {
            return false;
        }
        IPBean iPBean = (IPBean) other;
        return Intrinsics.areEqual(this.metaverseIpCode, iPBean.metaverseIpCode) && Intrinsics.areEqual(this.ipName, iPBean.ipName) && Intrinsics.areEqual(this.ipDescription, iPBean.ipDescription) && this.freeFlag == iPBean.freeFlag && this.haveFlag == iPBean.haveFlag && Intrinsics.areEqual(this.img, iPBean.img) && this.checkedFlag == iPBean.checkedFlag && Intrinsics.areEqual(this.metaverseModelCode, iPBean.metaverseModelCode) && Intrinsics.areEqual(this.componentSellingRemak, iPBean.componentSellingRemak) && this.newFlag == iPBean.newFlag;
    }

    public final boolean getCheckedFlag() {
        return this.checkedFlag;
    }

    @NotNull
    public final String getComponentSellingRemak() {
        return this.componentSellingRemak;
    }

    public final int getFreeFlag() {
        return this.freeFlag;
    }

    public final boolean getHaveFlag() {
        return this.haveFlag;
    }

    @NotNull
    public final String getImg() {
        return this.img;
    }

    @NotNull
    public final String getIpDescription() {
        return this.ipDescription;
    }

    @NotNull
    public final String getIpName() {
        return this.ipName;
    }

    @NotNull
    public final String getMetaverseIpCode() {
        return this.metaverseIpCode;
    }

    @NotNull
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    public final boolean getNewFlag() {
        return this.newFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((this.metaverseIpCode.hashCode() * 31) + this.ipName.hashCode()) * 31) + this.ipDescription.hashCode()) * 31) + Integer.hashCode(this.freeFlag)) * 31;
        boolean z = this.haveFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.img.hashCode()) * 31;
        boolean z2 = this.checkedFlag;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((((iHashCode2 + r2) * 31) + this.metaverseModelCode.hashCode()) * 31) + this.componentSellingRemak.hashCode()) * 31;
        boolean z3 = this.newFlag;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public final void setCheckedFlag(boolean z) {
        this.checkedFlag = z;
    }

    public final void setHaveFlag(boolean z) {
        this.haveFlag = z;
    }

    public final void setNewFlag(boolean z) {
        this.newFlag = z;
    }

    @NotNull
    public String toString() {
        return "IPBean(metaverseIpCode=" + this.metaverseIpCode + ", ipName=" + this.ipName + ", ipDescription=" + this.ipDescription + ", freeFlag=" + this.freeFlag + ", haveFlag=" + this.haveFlag + ", img=" + this.img + ", checkedFlag=" + this.checkedFlag + ", metaverseModelCode=" + this.metaverseModelCode + ", componentSellingRemak=" + this.componentSellingRemak + ", newFlag=" + this.newFlag + ')';
    }
}

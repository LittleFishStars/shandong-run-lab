package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/bean/RoleInfo;", "", "metaverseModelCode", "", "desc", "ipName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getIpName", "setIpName", "getMetaverseModelCode", "setMetaverseModelCode", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RoleInfo {

    @Nullable
    private String desc;

    @Nullable
    private String ipName;

    @Nullable
    private String metaverseModelCode;

    public RoleInfo() {
        this(null, null, null, 7, null);
    }

    public RoleInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.metaverseModelCode = str;
        this.desc = str2;
        this.ipName = str3;
    }

    public static /* synthetic */ RoleInfo copy$default(RoleInfo roleInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roleInfo.metaverseModelCode;
        }
        if ((i & 2) != 0) {
            str2 = roleInfo.desc;
        }
        if ((i & 4) != 0) {
            str3 = roleInfo.ipName;
        }
        return roleInfo.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIpName() {
        return this.ipName;
    }

    @NotNull
    public final RoleInfo copy(@Nullable String metaverseModelCode, @Nullable String desc, @Nullable String ipName) {
        return new RoleInfo(metaverseModelCode, desc, ipName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleInfo)) {
            return false;
        }
        RoleInfo roleInfo = (RoleInfo) other;
        return Intrinsics.areEqual(this.metaverseModelCode, roleInfo.metaverseModelCode) && Intrinsics.areEqual(this.desc, roleInfo.desc) && Intrinsics.areEqual(this.ipName, roleInfo.ipName);
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getIpName() {
        return this.ipName;
    }

    @Nullable
    public final String getMetaverseModelCode() {
        return this.metaverseModelCode;
    }

    public int hashCode() {
        String str = this.metaverseModelCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.desc;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ipName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setIpName(@Nullable String str) {
        this.ipName = str;
    }

    public final void setMetaverseModelCode(@Nullable String str) {
        this.metaverseModelCode = str;
    }

    @NotNull
    public String toString() {
        return "RoleInfo(metaverseModelCode=" + this.metaverseModelCode + ", desc=" + this.desc + ", ipName=" + this.ipName + ')';
    }

    public /* synthetic */ RoleInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}

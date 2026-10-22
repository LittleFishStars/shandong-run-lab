package com.huachenjie.base.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006\""}, d2 = {"Lcom/huachenjie/base/bean/NotifySubConfig;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "notifySubType", "", "notifySubTypeName", "", "openFlag", "", "isGroupLastItem", CollegeTownItemFragment.ITEM_TYPE, "(ILjava/lang/String;ZZI)V", "()Z", "setGroupLastItem", "(Z)V", "getItemType", "()I", "getNotifySubType", "getNotifySubTypeName", "()Ljava/lang/String;", "getOpenFlag", "setOpenFlag", "tip", "getTip", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NotifySubConfig implements MultiItemEntity {
    private boolean isGroupLastItem;
    private final int itemType;
    private final int notifySubType;

    @NotNull
    private final String notifySubTypeName;
    private boolean openFlag;

    public NotifySubConfig() {
        this(0, null, false, false, 0, 31, null);
    }

    public NotifySubConfig(int i, @NotNull String str, boolean z, boolean z2, int i2) {
        Intrinsics.checkNotNullParameter(str, "notifySubTypeName");
        this.notifySubType = i;
        this.notifySubTypeName = str;
        this.openFlag = z;
        this.isGroupLastItem = z2;
        this.itemType = i2;
    }

    public static /* synthetic */ NotifySubConfig copy$default(NotifySubConfig notifySubConfig, int i, String str, boolean z, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = notifySubConfig.notifySubType;
        }
        if ((i3 & 2) != 0) {
            str = notifySubConfig.notifySubTypeName;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            z = notifySubConfig.openFlag;
        }
        boolean z3 = z;
        if ((i3 & 8) != 0) {
            z2 = notifySubConfig.isGroupLastItem;
        }
        boolean z4 = z2;
        if ((i3 & 16) != 0) {
            i2 = notifySubConfig.getItemType();
        }
        return notifySubConfig.copy(i, str2, z3, z4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNotifySubType() {
        return this.notifySubType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNotifySubTypeName() {
        return this.notifySubTypeName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOpenFlag() {
        return this.openFlag;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGroupLastItem() {
        return this.isGroupLastItem;
    }

    public final int component5() {
        return getItemType();
    }

    @NotNull
    public final NotifySubConfig copy(int notifySubType, @NotNull String notifySubTypeName, boolean openFlag, boolean isGroupLastItem, int itemType) {
        Intrinsics.checkNotNullParameter(notifySubTypeName, "notifySubTypeName");
        return new NotifySubConfig(notifySubType, notifySubTypeName, openFlag, isGroupLastItem, itemType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifySubConfig)) {
            return false;
        }
        NotifySubConfig notifySubConfig = (NotifySubConfig) other;
        return this.notifySubType == notifySubConfig.notifySubType && Intrinsics.areEqual(this.notifySubTypeName, notifySubConfig.notifySubTypeName) && this.openFlag == notifySubConfig.openFlag && this.isGroupLastItem == notifySubConfig.isGroupLastItem && getItemType() == notifySubConfig.getItemType();
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getNotifySubType() {
        return this.notifySubType;
    }

    @NotNull
    public final String getNotifySubTypeName() {
        return this.notifySubTypeName;
    }

    public final boolean getOpenFlag() {
        return this.openFlag;
    }

    @NotNull
    public final String getTip() {
        int i = this.notifySubType;
        if (i == 4) {
            return "(点赞、收藏、评论、@我)";
        }
        if (i != 5) {
            return i != 11 ? "" : "(点赞、评论)";
        }
        return "(点赞、评论、@我)";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.notifySubType) * 31) + this.notifySubTypeName.hashCode()) * 31;
        boolean z = this.openFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isGroupLastItem;
        return ((i + (z2 ? 1 : z2)) * 31) + Integer.hashCode(getItemType());
    }

    public final boolean isGroupLastItem() {
        return this.isGroupLastItem;
    }

    public final void setGroupLastItem(boolean z) {
        this.isGroupLastItem = z;
    }

    public final void setOpenFlag(boolean z) {
        this.openFlag = z;
    }

    @NotNull
    public String toString() {
        return "NotifySubConfig(notifySubType=" + this.notifySubType + ", notifySubTypeName=" + this.notifySubTypeName + ", openFlag=" + this.openFlag + ", isGroupLastItem=" + this.isGroupLastItem + ", itemType=" + getItemType() + ')';
    }

    public /* synthetic */ NotifySubConfig(int i, String str, boolean z, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z, (i3 & 8) == 0 ? z2 : false, (i3 & 16) != 0 ? 2 : i2);
    }
}

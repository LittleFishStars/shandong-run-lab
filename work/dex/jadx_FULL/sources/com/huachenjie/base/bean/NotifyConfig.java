package com.huachenjie.base.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.zj.adlib.q47;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/base/bean/NotifyConfig;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", q47.f18999a, "", "notifyTypeName", "", "childList", "", "Lcom/huachenjie/base/bean/NotifySubConfig;", CollegeTownItemFragment.ITEM_TYPE, "(ILjava/lang/String;Ljava/util/List;I)V", "getChildList", "()Ljava/util/List;", "getItemType", "()I", "getNotifyType", "getNotifyTypeName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NotifyConfig implements MultiItemEntity {

    @NotNull
    private final List<NotifySubConfig> childList;
    private final int itemType;
    private final int notifyType;

    @NotNull
    private final String notifyTypeName;

    public NotifyConfig() {
        this(0, null, null, 0, 15, null);
    }

    public NotifyConfig(int i, @NotNull String str, @NotNull List<NotifySubConfig> list, int i2) {
        Intrinsics.checkNotNullParameter(str, "notifyTypeName");
        Intrinsics.checkNotNullParameter(list, "childList");
        this.notifyType = i;
        this.notifyTypeName = str;
        this.childList = list;
        this.itemType = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotifyConfig copy$default(NotifyConfig notifyConfig, int i, String str, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = notifyConfig.notifyType;
        }
        if ((i3 & 2) != 0) {
            str = notifyConfig.notifyTypeName;
        }
        if ((i3 & 4) != 0) {
            list = notifyConfig.childList;
        }
        if ((i3 & 8) != 0) {
            i2 = notifyConfig.getItemType();
        }
        return notifyConfig.copy(i, str, list, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNotifyType() {
        return this.notifyType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNotifyTypeName() {
        return this.notifyTypeName;
    }

    @NotNull
    public final List<NotifySubConfig> component3() {
        return this.childList;
    }

    public final int component4() {
        return getItemType();
    }

    @NotNull
    public final NotifyConfig copy(int notifyType, @NotNull String notifyTypeName, @NotNull List<NotifySubConfig> childList, int itemType) {
        Intrinsics.checkNotNullParameter(notifyTypeName, "notifyTypeName");
        Intrinsics.checkNotNullParameter(childList, "childList");
        return new NotifyConfig(notifyType, notifyTypeName, childList, itemType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyConfig)) {
            return false;
        }
        NotifyConfig notifyConfig = (NotifyConfig) other;
        return this.notifyType == notifyConfig.notifyType && Intrinsics.areEqual(this.notifyTypeName, notifyConfig.notifyTypeName) && Intrinsics.areEqual(this.childList, notifyConfig.childList) && getItemType() == notifyConfig.getItemType();
    }

    @NotNull
    public final List<NotifySubConfig> getChildList() {
        return this.childList;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getNotifyType() {
        return this.notifyType;
    }

    @NotNull
    public final String getNotifyTypeName() {
        return this.notifyTypeName;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.notifyType) * 31) + this.notifyTypeName.hashCode()) * 31) + this.childList.hashCode()) * 31) + Integer.hashCode(getItemType());
    }

    @NotNull
    public String toString() {
        return "NotifyConfig(notifyType=" + this.notifyType + ", notifyTypeName=" + this.notifyTypeName + ", childList=" + this.childList + ", itemType=" + getItemType() + ')';
    }

    public /* synthetic */ NotifyConfig(int i, String str, List list, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? 1 : i2);
    }
}

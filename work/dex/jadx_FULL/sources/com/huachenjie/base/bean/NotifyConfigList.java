package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/base/bean/NotifyConfigList;", "", "notifyConfigList", "", "Lcom/huachenjie/base/bean/NotifyConfig;", "(Ljava/util/List;)V", "getNotifyConfigList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NotifyConfigList {

    @NotNull
    private final List<NotifyConfig> notifyConfigList;

    /* JADX WARN: Illegal instructions before constructor call */
    public NotifyConfigList() {
        List list = null;
        this(list, 1, list);
    }

    public NotifyConfigList(@NotNull List<NotifyConfig> list) {
        Intrinsics.checkNotNullParameter(list, "notifyConfigList");
        this.notifyConfigList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotifyConfigList copy$default(NotifyConfigList notifyConfigList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = notifyConfigList.notifyConfigList;
        }
        return notifyConfigList.copy(list);
    }

    @NotNull
    public final List<NotifyConfig> component1() {
        return this.notifyConfigList;
    }

    @NotNull
    public final NotifyConfigList copy(@NotNull List<NotifyConfig> notifyConfigList) {
        Intrinsics.checkNotNullParameter(notifyConfigList, "notifyConfigList");
        return new NotifyConfigList(notifyConfigList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NotifyConfigList) && Intrinsics.areEqual(this.notifyConfigList, ((NotifyConfigList) other).notifyConfigList);
    }

    @NotNull
    public final List<NotifyConfig> getNotifyConfigList() {
        return this.notifyConfigList;
    }

    public int hashCode() {
        return this.notifyConfigList.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotifyConfigList(notifyConfigList=" + this.notifyConfigList + ')';
    }

    public /* synthetic */ NotifyConfigList(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}

package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/works/bean/WorksDetailMenuBean;", "", "name", "", RemoteMessageConst.Notification.ICON, "", "(Ljava/lang/String;I)V", "getIcon", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorksDetailMenuBean {
    private final int icon;

    @NotNull
    private final String name;

    public WorksDetailMenuBean(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.icon = i;
    }

    public static /* synthetic */ WorksDetailMenuBean copy$default(WorksDetailMenuBean worksDetailMenuBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = worksDetailMenuBean.name;
        }
        if ((i2 & 2) != 0) {
            i = worksDetailMenuBean.icon;
        }
        return worksDetailMenuBean.copy(str, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final WorksDetailMenuBean copy(@NotNull String name, int icon) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new WorksDetailMenuBean(name, icon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorksDetailMenuBean)) {
            return false;
        }
        WorksDetailMenuBean worksDetailMenuBean = (WorksDetailMenuBean) other;
        return Intrinsics.areEqual(this.name, worksDetailMenuBean.name) && this.icon == worksDetailMenuBean.icon;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.icon);
    }

    @NotNull
    public String toString() {
        return "WorksDetailMenuBean(name=" + this.name + ", icon=" + this.icon + ')';
    }
}

package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/common/bean/UsableGeoFence;", "", "fenceCode", "", "(Ljava/lang/String;)V", "getFenceCode", "()Ljava/lang/String;", "setFenceCode", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UsableGeoFence {

    @Nullable
    private String fenceCode;

    public UsableGeoFence(@Nullable String str) {
        this.fenceCode = str;
    }

    public static /* synthetic */ UsableGeoFence copy$default(UsableGeoFence usableGeoFence, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = usableGeoFence.fenceCode;
        }
        return usableGeoFence.copy(str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFenceCode() {
        return this.fenceCode;
    }

    @NotNull
    public final UsableGeoFence copy(@Nullable String fenceCode) {
        return new UsableGeoFence(fenceCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UsableGeoFence) && Intrinsics.areEqual(this.fenceCode, ((UsableGeoFence) other).fenceCode);
    }

    @Nullable
    public final String getFenceCode() {
        return this.fenceCode;
    }

    public int hashCode() {
        String str = this.fenceCode;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setFenceCode(@Nullable String str) {
        this.fenceCode = str;
    }

    @NotNull
    public String toString() {
        return "UsableGeoFence(fenceCode=" + this.fenceCode + ")";
    }
}

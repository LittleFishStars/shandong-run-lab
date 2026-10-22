package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/base/bean/WorksConfig;", "", "vipOpenFlag", "", "videoTime", "", "friendVisitLevel", "(ZIZ)V", "getFriendVisitLevel", "()Z", "getVideoTime", "()I", "getVipOpenFlag", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorksConfig {
    private final boolean friendVisitLevel;
    private final int videoTime;
    private final boolean vipOpenFlag;

    public WorksConfig() {
        this(false, 0, false, 7, null);
    }

    public WorksConfig(boolean z, int i, boolean z2) {
        this.vipOpenFlag = z;
        this.videoTime = i;
        this.friendVisitLevel = z2;
    }

    public static /* synthetic */ WorksConfig copy$default(WorksConfig worksConfig, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = worksConfig.vipOpenFlag;
        }
        if ((i2 & 2) != 0) {
            i = worksConfig.videoTime;
        }
        if ((i2 & 4) != 0) {
            z2 = worksConfig.friendVisitLevel;
        }
        return worksConfig.copy(z, i, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getVipOpenFlag() {
        return this.vipOpenFlag;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVideoTime() {
        return this.videoTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFriendVisitLevel() {
        return this.friendVisitLevel;
    }

    @NotNull
    public final WorksConfig copy(boolean vipOpenFlag, int videoTime, boolean friendVisitLevel) {
        return new WorksConfig(vipOpenFlag, videoTime, friendVisitLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorksConfig)) {
            return false;
        }
        WorksConfig worksConfig = (WorksConfig) other;
        return this.vipOpenFlag == worksConfig.vipOpenFlag && this.videoTime == worksConfig.videoTime && this.friendVisitLevel == worksConfig.friendVisitLevel;
    }

    public final boolean getFriendVisitLevel() {
        return this.friendVisitLevel;
    }

    public final int getVideoTime() {
        return this.videoTime;
    }

    public final boolean getVipOpenFlag() {
        return this.vipOpenFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z = this.vipOpenFlag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + Integer.hashCode(this.videoTime)) * 31;
        boolean z2 = this.friendVisitLevel;
        return iHashCode + (z2 ? 1 : z2);
    }

    @NotNull
    public String toString() {
        return "WorksConfig(vipOpenFlag=" + this.vipOpenFlag + ", videoTime=" + this.videoTime + ", friendVisitLevel=" + this.friendVisitLevel + ')';
    }

    public /* synthetic */ WorksConfig(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 120 : i, (i2 & 4) != 0 ? false : z2);
    }
}

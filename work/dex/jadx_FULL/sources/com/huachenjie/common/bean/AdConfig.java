package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/common/bean/AdConfig;", "", "compliance", "", "adInfoList", "", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "(ZLjava/util/List;)V", "getAdInfoList", "()Ljava/util/List;", "getCompliance", "()Z", "component1", "component2", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdConfig {

    @Nullable
    private final List<AdPlatformSwitch> adInfoList;
    private final boolean compliance;

    /* JADX WARN: Illegal instructions before constructor call */
    public AdConfig() {
        List list = null;
        this(false, list, 3, list);
    }

    public AdConfig(boolean z, @Nullable List<AdPlatformSwitch> list) {
        this.compliance = z;
        this.adInfoList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdConfig copy$default(AdConfig adConfig, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adConfig.compliance;
        }
        if ((i & 2) != 0) {
            list = adConfig.adInfoList;
        }
        return adConfig.copy(z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCompliance() {
        return this.compliance;
    }

    @Nullable
    public final List<AdPlatformSwitch> component2() {
        return this.adInfoList;
    }

    @NotNull
    public final AdConfig copy(boolean compliance, @Nullable List<AdPlatformSwitch> adInfoList) {
        return new AdConfig(compliance, adInfoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdConfig)) {
            return false;
        }
        AdConfig adConfig = (AdConfig) other;
        return this.compliance == adConfig.compliance && Intrinsics.areEqual(this.adInfoList, adConfig.adInfoList);
    }

    @Nullable
    public final List<AdPlatformSwitch> getAdInfoList() {
        return this.adInfoList;
    }

    public final boolean getCompliance() {
        return this.compliance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.compliance;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<AdPlatformSwitch> list = this.adInfoList;
        return i + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "AdConfig(compliance=" + this.compliance + ", adInfoList=" + this.adInfoList + ")";
    }

    public /* synthetic */ AdConfig(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : list);
    }
}

package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/bean/AdPositionConfig;", "", "adSwitch", "", "bambooMallSwitch", "adPositionList", "", "Lcom/huachenjie/common/bean/AdPositionSwitch;", "(ZZLjava/util/List;)V", "getAdPositionList", "()Ljava/util/List;", "getAdSwitch", "()Z", "getBambooMallSwitch", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdPositionConfig {

    @NotNull
    private final List<AdPositionSwitch> adPositionList;
    private final boolean adSwitch;
    private final boolean bambooMallSwitch;

    public AdPositionConfig() {
        this(false, false, null, 7, null);
    }

    public AdPositionConfig(boolean z, boolean z2, @NotNull List<AdPositionSwitch> list) {
        Intrinsics.checkNotNullParameter(list, "adPositionList");
        this.adSwitch = z;
        this.bambooMallSwitch = z2;
        this.adPositionList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdPositionConfig copy$default(AdPositionConfig adPositionConfig, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adPositionConfig.adSwitch;
        }
        if ((i & 2) != 0) {
            z2 = adPositionConfig.bambooMallSwitch;
        }
        if ((i & 4) != 0) {
            list = adPositionConfig.adPositionList;
        }
        return adPositionConfig.copy(z, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAdSwitch() {
        return this.adSwitch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getBambooMallSwitch() {
        return this.bambooMallSwitch;
    }

    @NotNull
    public final List<AdPositionSwitch> component3() {
        return this.adPositionList;
    }

    @NotNull
    public final AdPositionConfig copy(boolean adSwitch, boolean bambooMallSwitch, @NotNull List<AdPositionSwitch> adPositionList) {
        Intrinsics.checkNotNullParameter(adPositionList, "adPositionList");
        return new AdPositionConfig(adSwitch, bambooMallSwitch, adPositionList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPositionConfig)) {
            return false;
        }
        AdPositionConfig adPositionConfig = (AdPositionConfig) other;
        return this.adSwitch == adPositionConfig.adSwitch && this.bambooMallSwitch == adPositionConfig.bambooMallSwitch && Intrinsics.areEqual(this.adPositionList, adPositionConfig.adPositionList);
    }

    @NotNull
    public final List<AdPositionSwitch> getAdPositionList() {
        return this.adPositionList;
    }

    public final boolean getAdSwitch() {
        return this.adSwitch;
    }

    public final boolean getBambooMallSwitch() {
        return this.bambooMallSwitch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.adSwitch;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.bambooMallSwitch;
        return ((i + (z2 ? 1 : z2)) * 31) + this.adPositionList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdPositionConfig(adSwitch=" + this.adSwitch + ", bambooMallSwitch=" + this.bambooMallSwitch + ", adPositionList=" + this.adPositionList + ")";
    }

    public /* synthetic */ AdPositionConfig(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? new ArrayList() : list);
    }
}

package com.huachenjie.home.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/home/bean/HomeData;", "", "functionEntries", "", "Lcom/huachenjie/home/bean/HomeHeaderBean;", "seaview", "Lcom/huachenjie/home/bean/SeaViewBean;", "hasSeaview", "", "(Ljava/util/List;Lcom/huachenjie/home/bean/SeaViewBean;Z)V", "getFunctionEntries", "()Ljava/util/List;", "getHasSeaview", "()Z", "getSeaview", "()Lcom/huachenjie/home/bean/SeaViewBean;", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "findSeaViewBgColor", "", "findSeaViewUrl", "", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeData {

    @NotNull
    private final List<HomeHeaderBean> functionEntries;
    private final boolean hasSeaview;

    @NotNull
    private final SeaViewBean seaview;

    public HomeData() {
        this(null, null, false, 7, null);
    }

    public HomeData(@NotNull List<HomeHeaderBean> list, @NotNull SeaViewBean seaViewBean, boolean z) {
        Intrinsics.checkNotNullParameter(list, "functionEntries");
        Intrinsics.checkNotNullParameter(seaViewBean, "seaview");
        this.functionEntries = list;
        this.seaview = seaViewBean;
        this.hasSeaview = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeData copy$default(HomeData homeData, List list, SeaViewBean seaViewBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = homeData.functionEntries;
        }
        if ((i & 2) != 0) {
            seaViewBean = homeData.seaview;
        }
        if ((i & 4) != 0) {
            z = homeData.hasSeaview;
        }
        return homeData.copy(list, seaViewBean, z);
    }

    @NotNull
    public final List<HomeHeaderBean> component1() {
        return this.functionEntries;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SeaViewBean getSeaview() {
        return this.seaview;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasSeaview() {
        return this.hasSeaview;
    }

    @NotNull
    public final HomeData copy(@NotNull List<HomeHeaderBean> functionEntries, @NotNull SeaViewBean seaview, boolean hasSeaview) {
        Intrinsics.checkNotNullParameter(functionEntries, "functionEntries");
        Intrinsics.checkNotNullParameter(seaview, "seaview");
        return new HomeData(functionEntries, seaview, hasSeaview);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeData)) {
            return false;
        }
        HomeData homeData = (HomeData) other;
        return Intrinsics.areEqual(this.functionEntries, homeData.functionEntries) && Intrinsics.areEqual(this.seaview, homeData.seaview) && this.hasSeaview == homeData.hasSeaview;
    }

    public final int findSeaViewBgColor() {
        if (!this.hasSeaview || TextUtils.isEmpty(this.seaview.getBgColor())) {
            return 0;
        }
        return zn1.o(this.seaview.getBgColor());
    }

    @NotNull
    public final String findSeaViewUrl() {
        return !this.hasSeaview ? "" : this.seaview.getImageUrl();
    }

    @NotNull
    public final List<HomeHeaderBean> getFunctionEntries() {
        return this.functionEntries;
    }

    public final boolean getHasSeaview() {
        return this.hasSeaview;
    }

    @NotNull
    public final SeaViewBean getSeaview() {
        return this.seaview;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.functionEntries.hashCode() * 31) + this.seaview.hashCode()) * 31;
        boolean z = this.hasSeaview;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "HomeData(functionEntries=" + this.functionEntries + ", seaview=" + this.seaview + ", hasSeaview=" + this.hasSeaview + ')';
    }

    public /* synthetic */ HomeData(List list, SeaViewBean seaViewBean, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new SeaViewBean(null, null, 0, null, 15, null) : seaViewBean, (i & 4) != 0 ? false : z);
    }
}

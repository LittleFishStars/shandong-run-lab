package com.ltmb.ltadsdk.api;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0004\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/ltmb/ltadsdk/api/AdBidWinInfo;", "", "", "component1", "secondPrice", OperatePopupWindow.g, "", "toString", "hashCode", "other", "", "equals", "a", "I", "getSecondPrice", "()I", "<init>", "(I)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final /* data */ class AdBidWinInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int secondPrice;

    public AdBidWinInfo(int i) {
        this.secondPrice = i;
    }

    public static /* synthetic */ AdBidWinInfo copy$default(AdBidWinInfo adBidWinInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adBidWinInfo.secondPrice;
        }
        return adBidWinInfo.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSecondPrice() {
        return this.secondPrice;
    }

    @NotNull
    public final AdBidWinInfo copy(int secondPrice) {
        return new AdBidWinInfo(secondPrice);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            return (other instanceof AdBidWinInfo) && this.secondPrice == ((AdBidWinInfo) other).secondPrice;
        }
        return true;
    }

    public final int getSecondPrice() {
        return this.secondPrice;
    }

    public int hashCode() {
        return Integer.hashCode(this.secondPrice);
    }

    @NotNull
    public String toString() {
        return "AdBidWinInfo(secondPrice=" + this.secondPrice + ")";
    }
}

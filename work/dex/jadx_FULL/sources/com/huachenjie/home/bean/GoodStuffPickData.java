package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/home/bean/GoodStuffPickData;", "", "promoSlots", "", "Lcom/huachenjie/home/bean/PromoSlotBean;", "(Ljava/util/List;)V", "getPromoSlots", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "findPromoSlot", "index", "", "hashCode", "toString", "", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodStuffPickData {

    @NotNull
    private final List<PromoSlotBean> promoSlots;

    /* JADX WARN: Illegal instructions before constructor call */
    public GoodStuffPickData() {
        List list = null;
        this(list, 1, list);
    }

    public GoodStuffPickData(@NotNull List<PromoSlotBean> list) {
        Intrinsics.checkNotNullParameter(list, "promoSlots");
        this.promoSlots = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodStuffPickData copy$default(GoodStuffPickData goodStuffPickData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = goodStuffPickData.promoSlots;
        }
        return goodStuffPickData.copy(list);
    }

    @NotNull
    public final List<PromoSlotBean> component1() {
        return this.promoSlots;
    }

    @NotNull
    public final GoodStuffPickData copy(@NotNull List<PromoSlotBean> promoSlots) {
        Intrinsics.checkNotNullParameter(promoSlots, "promoSlots");
        return new GoodStuffPickData(promoSlots);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoodStuffPickData) && Intrinsics.areEqual(this.promoSlots, ((GoodStuffPickData) other).promoSlots);
    }

    @NotNull
    public final PromoSlotBean findPromoSlot(int index) {
        boolean z = false;
        if (index >= 0 && index < this.promoSlots.size()) {
            z = true;
        }
        return !z ? new PromoSlotBean(null, 0, null, null, null, 0, null, null, null, 511, null) : this.promoSlots.get(index);
    }

    @NotNull
    public final List<PromoSlotBean> getPromoSlots() {
        return this.promoSlots;
    }

    public int hashCode() {
        return this.promoSlots.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodStuffPickData(promoSlots=" + this.promoSlots + ')';
    }

    public /* synthetic */ GoodStuffPickData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}

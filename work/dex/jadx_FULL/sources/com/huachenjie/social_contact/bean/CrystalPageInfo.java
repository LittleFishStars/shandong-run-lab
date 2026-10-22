package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/social_contact/bean/CrystalPageInfo;", "", "exchangeNum", "", "starDrill", "starStone", "crystalValue", "(IIII)V", "getCrystalValue", "()I", "setCrystalValue", "(I)V", "getExchangeNum", "setExchangeNum", "getStarDrill", "setStarDrill", "getStarStone", "setStarStone", "canBuy", "", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CrystalPageInfo {
    private int crystalValue;
    private int exchangeNum;
    private int starDrill;
    private int starStone;

    public CrystalPageInfo() {
        this(0, 0, 0, 0, 15, null);
    }

    public CrystalPageInfo(int i, int i2, int i3, int i4) {
        this.exchangeNum = i;
        this.starDrill = i2;
        this.starStone = i3;
        this.crystalValue = i4;
    }

    public static /* synthetic */ CrystalPageInfo copy$default(CrystalPageInfo crystalPageInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = crystalPageInfo.exchangeNum;
        }
        if ((i5 & 2) != 0) {
            i2 = crystalPageInfo.starDrill;
        }
        if ((i5 & 4) != 0) {
            i3 = crystalPageInfo.starStone;
        }
        if ((i5 & 8) != 0) {
            i4 = crystalPageInfo.crystalValue;
        }
        return crystalPageInfo.copy(i, i2, i3, i4);
    }

    public final boolean canBuy() {
        int i = this.starDrill;
        return i > 0 && this.exchangeNum > 0 && i >= this.starStone;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getExchangeNum() {
        return this.exchangeNum;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStarStone() {
        return this.starStone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCrystalValue() {
        return this.crystalValue;
    }

    @NotNull
    public final CrystalPageInfo copy(int exchangeNum, int starDrill, int starStone, int crystalValue) {
        return new CrystalPageInfo(exchangeNum, starDrill, starStone, crystalValue);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CrystalPageInfo)) {
            return false;
        }
        CrystalPageInfo crystalPageInfo = (CrystalPageInfo) other;
        return this.exchangeNum == crystalPageInfo.exchangeNum && this.starDrill == crystalPageInfo.starDrill && this.starStone == crystalPageInfo.starStone && this.crystalValue == crystalPageInfo.crystalValue;
    }

    public final int getCrystalValue() {
        return this.crystalValue;
    }

    public final int getExchangeNum() {
        return this.exchangeNum;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    public final int getStarStone() {
        return this.starStone;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.exchangeNum) * 31) + Integer.hashCode(this.starDrill)) * 31) + Integer.hashCode(this.starStone)) * 31) + Integer.hashCode(this.crystalValue);
    }

    public final void setCrystalValue(int i) {
        this.crystalValue = i;
    }

    public final void setExchangeNum(int i) {
        this.exchangeNum = i;
    }

    public final void setStarDrill(int i) {
        this.starDrill = i;
    }

    public final void setStarStone(int i) {
        this.starStone = i;
    }

    @NotNull
    public String toString() {
        return "CrystalPageInfo(exchangeNum=" + this.exchangeNum + ", starDrill=" + this.starDrill + ", starStone=" + this.starStone + ", crystalValue=" + this.crystalValue + ')';
    }

    public /* synthetic */ CrystalPageInfo(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }
}

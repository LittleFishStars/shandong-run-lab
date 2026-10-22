package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/social_contact/bean/UserAssetsBean;", "", "crystalValue", "", "inspirationValue", "starDrill", "skinVoucher", "(IIII)V", "getCrystalValue", "()I", "setCrystalValue", "(I)V", "getInspirationValue", "setInspirationValue", "getSkinVoucher", "setSkinVoucher", "getStarDrill", "setStarDrill", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserAssetsBean {
    private int crystalValue;
    private int inspirationValue;
    private int skinVoucher;
    private int starDrill;

    public UserAssetsBean() {
        this(0, 0, 0, 0, 15, null);
    }

    public UserAssetsBean(int i, int i2, int i3, int i4) {
        this.crystalValue = i;
        this.inspirationValue = i2;
        this.starDrill = i3;
        this.skinVoucher = i4;
    }

    public static /* synthetic */ UserAssetsBean copy$default(UserAssetsBean userAssetsBean, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = userAssetsBean.crystalValue;
        }
        if ((i5 & 2) != 0) {
            i2 = userAssetsBean.inspirationValue;
        }
        if ((i5 & 4) != 0) {
            i3 = userAssetsBean.starDrill;
        }
        if ((i5 & 8) != 0) {
            i4 = userAssetsBean.skinVoucher;
        }
        return userAssetsBean.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCrystalValue() {
        return this.crystalValue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getInspirationValue() {
        return this.inspirationValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    @NotNull
    public final UserAssetsBean copy(int crystalValue, int inspirationValue, int starDrill, int skinVoucher) {
        return new UserAssetsBean(crystalValue, inspirationValue, starDrill, skinVoucher);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAssetsBean)) {
            return false;
        }
        UserAssetsBean userAssetsBean = (UserAssetsBean) other;
        return this.crystalValue == userAssetsBean.crystalValue && this.inspirationValue == userAssetsBean.inspirationValue && this.starDrill == userAssetsBean.starDrill && this.skinVoucher == userAssetsBean.skinVoucher;
    }

    public final int getCrystalValue() {
        return this.crystalValue;
    }

    public final int getInspirationValue() {
        return this.inspirationValue;
    }

    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.crystalValue) * 31) + Integer.hashCode(this.inspirationValue)) * 31) + Integer.hashCode(this.starDrill)) * 31) + Integer.hashCode(this.skinVoucher);
    }

    public final void setCrystalValue(int i) {
        this.crystalValue = i;
    }

    public final void setInspirationValue(int i) {
        this.inspirationValue = i;
    }

    public final void setSkinVoucher(int i) {
        this.skinVoucher = i;
    }

    public final void setStarDrill(int i) {
        this.starDrill = i;
    }

    @NotNull
    public String toString() {
        return "UserAssetsBean(crystalValue=" + this.crystalValue + ", inspirationValue=" + this.inspirationValue + ", starDrill=" + this.starDrill + ", skinVoucher=" + this.skinVoucher + ')';
    }

    public /* synthetic */ UserAssetsBean(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }
}

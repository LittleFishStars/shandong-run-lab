package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/bean/FavorabilityBean;", "", "favorabilityDesc", "", "favorabilityLevel", "", "favorabilityAmount", "highFavorability", "(Ljava/lang/String;III)V", "getFavorabilityAmount", "()I", "getFavorabilityDesc", "()Ljava/lang/String;", "getFavorabilityLevel", "getHighFavorability", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FavorabilityBean {
    private final int favorabilityAmount;

    @NotNull
    private final String favorabilityDesc;
    private final int favorabilityLevel;
    private final int highFavorability;

    public FavorabilityBean() {
        this(null, 0, 0, 0, 15, null);
    }

    public FavorabilityBean(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "favorabilityDesc");
        this.favorabilityDesc = str;
        this.favorabilityLevel = i;
        this.favorabilityAmount = i2;
        this.highFavorability = i3;
    }

    public static /* synthetic */ FavorabilityBean copy$default(FavorabilityBean favorabilityBean, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = favorabilityBean.favorabilityDesc;
        }
        if ((i4 & 2) != 0) {
            i = favorabilityBean.favorabilityLevel;
        }
        if ((i4 & 4) != 0) {
            i2 = favorabilityBean.favorabilityAmount;
        }
        if ((i4 & 8) != 0) {
            i3 = favorabilityBean.highFavorability;
        }
        return favorabilityBean.copy(str, i, i2, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFavorabilityDesc() {
        return this.favorabilityDesc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFavorabilityLevel() {
        return this.favorabilityLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFavorabilityAmount() {
        return this.favorabilityAmount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHighFavorability() {
        return this.highFavorability;
    }

    @NotNull
    public final FavorabilityBean copy(@NotNull String favorabilityDesc, int favorabilityLevel, int favorabilityAmount, int highFavorability) {
        Intrinsics.checkNotNullParameter(favorabilityDesc, "favorabilityDesc");
        return new FavorabilityBean(favorabilityDesc, favorabilityLevel, favorabilityAmount, highFavorability);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavorabilityBean)) {
            return false;
        }
        FavorabilityBean favorabilityBean = (FavorabilityBean) other;
        return Intrinsics.areEqual(this.favorabilityDesc, favorabilityBean.favorabilityDesc) && this.favorabilityLevel == favorabilityBean.favorabilityLevel && this.favorabilityAmount == favorabilityBean.favorabilityAmount && this.highFavorability == favorabilityBean.highFavorability;
    }

    public final int getFavorabilityAmount() {
        return this.favorabilityAmount;
    }

    @NotNull
    public final String getFavorabilityDesc() {
        return this.favorabilityDesc;
    }

    public final int getFavorabilityLevel() {
        return this.favorabilityLevel;
    }

    public final int getHighFavorability() {
        return this.highFavorability;
    }

    public int hashCode() {
        return (((((this.favorabilityDesc.hashCode() * 31) + Integer.hashCode(this.favorabilityLevel)) * 31) + Integer.hashCode(this.favorabilityAmount)) * 31) + Integer.hashCode(this.highFavorability);
    }

    @NotNull
    public String toString() {
        return "FavorabilityBean(favorabilityDesc=" + this.favorabilityDesc + ", favorabilityLevel=" + this.favorabilityLevel + ", favorabilityAmount=" + this.favorabilityAmount + ", highFavorability=" + this.highFavorability + ')';
    }

    public /* synthetic */ FavorabilityBean(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}

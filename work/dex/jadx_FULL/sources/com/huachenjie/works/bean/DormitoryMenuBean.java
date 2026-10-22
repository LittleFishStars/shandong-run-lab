package com.huachenjie.works.bean;

import androidx.annotation.DrawableRes;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/DormitoryMenuBean;", "", "iconRes", "", "title", "", "showVipTag", "entryType", "(ILjava/lang/String;II)V", "getEntryType", "()I", "getIconRes", "getShowVipTag", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormitoryMenuBean {
    private final int entryType;
    private final int iconRes;
    private final int showVipTag;

    @NotNull
    private final String title;

    public DormitoryMenuBean(@DrawableRes int i, @NotNull String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.iconRes = i;
        this.title = str;
        this.showVipTag = i2;
        this.entryType = i3;
    }

    public static /* synthetic */ DormitoryMenuBean copy$default(DormitoryMenuBean dormitoryMenuBean, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = dormitoryMenuBean.iconRes;
        }
        if ((i4 & 2) != 0) {
            str = dormitoryMenuBean.title;
        }
        if ((i4 & 4) != 0) {
            i2 = dormitoryMenuBean.showVipTag;
        }
        if ((i4 & 8) != 0) {
            i3 = dormitoryMenuBean.entryType;
        }
        return dormitoryMenuBean.copy(i, str, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getShowVipTag() {
        return this.showVipTag;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getEntryType() {
        return this.entryType;
    }

    @NotNull
    public final DormitoryMenuBean copy(@DrawableRes int iconRes, @NotNull String title, int showVipTag, int entryType) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new DormitoryMenuBean(iconRes, title, showVipTag, entryType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormitoryMenuBean)) {
            return false;
        }
        DormitoryMenuBean dormitoryMenuBean = (DormitoryMenuBean) other;
        return this.iconRes == dormitoryMenuBean.iconRes && Intrinsics.areEqual(this.title, dormitoryMenuBean.title) && this.showVipTag == dormitoryMenuBean.showVipTag && this.entryType == dormitoryMenuBean.entryType;
    }

    public final int getEntryType() {
        return this.entryType;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getShowVipTag() {
        return this.showVipTag;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.iconRes) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.showVipTag)) * 31) + Integer.hashCode(this.entryType);
    }

    @NotNull
    public String toString() {
        return "DormitoryMenuBean(iconRes=" + this.iconRes + ", title=" + this.title + ", showVipTag=" + this.showVipTag + ", entryType=" + this.entryType + ')';
    }

    public /* synthetic */ DormitoryMenuBean(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i4 & 4) != 0 ? 8 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}

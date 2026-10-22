package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/sport/bean/HuodongDetailImgs;", "", "height", "", "url", "", "width", "(ILjava/lang/String;I)V", "getHeight", "()I", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuodongDetailImgs {
    private final int height;

    @NotNull
    private final String url;
    private final int width;

    public HuodongDetailImgs() {
        this(0, null, 0, 7, null);
    }

    public HuodongDetailImgs(int i, @NotNull String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.height = i;
        this.url = str;
        this.width = i2;
    }

    public static /* synthetic */ HuodongDetailImgs copy$default(HuodongDetailImgs huodongDetailImgs, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = huodongDetailImgs.height;
        }
        if ((i3 & 2) != 0) {
            str = huodongDetailImgs.url;
        }
        if ((i3 & 4) != 0) {
            i2 = huodongDetailImgs.width;
        }
        return huodongDetailImgs.copy(i, str, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public final HuodongDetailImgs copy(int height, @NotNull String url, int width) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new HuodongDetailImgs(height, url, width);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuodongDetailImgs)) {
            return false;
        }
        HuodongDetailImgs huodongDetailImgs = (HuodongDetailImgs) other;
        return this.height == huodongDetailImgs.height && Intrinsics.areEqual(this.url, huodongDetailImgs.url) && this.width == huodongDetailImgs.width;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.height) * 31) + this.url.hashCode()) * 31) + Integer.hashCode(this.width);
    }

    @NotNull
    public String toString() {
        return "HuodongDetailImgs(height=" + this.height + ", url=" + this.url + ", width=" + this.width + ')';
    }

    public /* synthetic */ HuodongDetailImgs(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2);
    }
}

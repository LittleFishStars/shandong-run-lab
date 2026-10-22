package com.ltmb.ltadsdk.api.ad;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYImage;", "", "", "component1", "", "component2", "component3", "url", "width", "height", OperatePopupWindow.g, "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "b", "I", "getWidth", "()I", "c", "getHeight", "<init>", "(Ljava/lang/String;II)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final /* data */ class SYImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final int width;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final int height;

    public SYImage() {
        this(null, 0, 0, 7, null);
    }

    public SYImage(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ SYImage copy$default(SYImage sYImage, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sYImage.url;
        }
        if ((i3 & 2) != 0) {
            i = sYImage.width;
        }
        if ((i3 & 4) != 0) {
            i2 = sYImage.height;
        }
        return sYImage.copy(str, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final SYImage copy(@NotNull String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new SYImage(url, width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SYImage)) {
            return false;
        }
        SYImage sYImage = (SYImage) other;
        return Intrinsics.areEqual(this.url, sYImage.url) && this.width == sYImage.width && this.height == sYImage.height;
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
        String str = this.url;
        return ((((str != null ? str.hashCode() : 0) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    @NotNull
    public String toString() {
        return "SYImage(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public /* synthetic */ SYImage(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}

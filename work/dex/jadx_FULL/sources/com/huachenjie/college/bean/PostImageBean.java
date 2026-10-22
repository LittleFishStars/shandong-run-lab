package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/college/bean/PostImageBean;", "", "path", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getWidth", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostImageBean {
    private final int height;

    @NotNull
    private String path;
    private final int width;

    public PostImageBean() {
        this(null, 0, 0, 7, null);
    }

    public PostImageBean(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.path = str;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ PostImageBean copy$default(PostImageBean postImageBean, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = postImageBean.path;
        }
        if ((i3 & 2) != 0) {
            i = postImageBean.width;
        }
        if ((i3 & 4) != 0) {
            i2 = postImageBean.height;
        }
        return postImageBean.copy(str, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
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
    public final PostImageBean copy(@NotNull String path, int width, int height) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new PostImageBean(path, width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostImageBean)) {
            return false;
        }
        PostImageBean postImageBean = (PostImageBean) other;
        return Intrinsics.areEqual(this.path, postImageBean.path) && this.width == postImageBean.width && this.height == postImageBean.height;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    @NotNull
    public String toString() {
        return "PostImageBean(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public /* synthetic */ PostImageBean(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}

package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/bean/AttachmentBean;", "", "url", "", "coverPath", "attachmentType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAttachmentType", "()I", "getCoverPath", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttachmentBean {
    private final int attachmentType;

    @NotNull
    private final String coverPath;

    @NotNull
    private final String url;

    public AttachmentBean() {
        this(null, null, 0, 7, null);
    }

    public AttachmentBean(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "coverPath");
        this.url = str;
        this.coverPath = str2;
        this.attachmentType = i;
    }

    public static /* synthetic */ AttachmentBean copy$default(AttachmentBean attachmentBean, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = attachmentBean.url;
        }
        if ((i2 & 2) != 0) {
            str2 = attachmentBean.coverPath;
        }
        if ((i2 & 4) != 0) {
            i = attachmentBean.attachmentType;
        }
        return attachmentBean.copy(str, str2, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final AttachmentBean copy(@NotNull String url, @NotNull String coverPath, int attachmentType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        return new AttachmentBean(url, coverPath, attachmentType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentBean)) {
            return false;
        }
        AttachmentBean attachmentBean = (AttachmentBean) other;
        return Intrinsics.areEqual(this.url, attachmentBean.url) && Intrinsics.areEqual(this.coverPath, attachmentBean.coverPath) && this.attachmentType == attachmentBean.attachmentType;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getCoverPath() {
        return this.coverPath;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.coverPath.hashCode()) * 31) + Integer.hashCode(this.attachmentType);
    }

    @NotNull
    public String toString() {
        return "AttachmentBean(url=" + this.url + ", coverPath=" + this.coverPath + ", attachmentType=" + this.attachmentType + ')';
    }

    public /* synthetic */ AttachmentBean(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 1 : i);
    }
}

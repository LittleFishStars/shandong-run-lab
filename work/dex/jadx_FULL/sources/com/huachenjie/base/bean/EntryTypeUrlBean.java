package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/base/bean/EntryTypeUrlBean;", "", "linkUrl", "", "(Ljava/lang/String;)V", "getLinkUrl", "()Ljava/lang/String;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EntryTypeUrlBean {

    @NotNull
    private final String linkUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public EntryTypeUrlBean() {
        String str = null;
        this(str, 1, str);
    }

    public EntryTypeUrlBean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "linkUrl");
        this.linkUrl = str;
    }

    public static /* synthetic */ EntryTypeUrlBean copy$default(EntryTypeUrlBean entryTypeUrlBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entryTypeUrlBean.linkUrl;
        }
        return entryTypeUrlBean.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    public final EntryTypeUrlBean copy(@NotNull String linkUrl) {
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        return new EntryTypeUrlBean(linkUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EntryTypeUrlBean) && Intrinsics.areEqual(this.linkUrl, ((EntryTypeUrlBean) other).linkUrl);
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public int hashCode() {
        return this.linkUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "EntryTypeUrlBean(linkUrl=" + this.linkUrl + ')';
    }

    public /* synthetic */ EntryTypeUrlBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}

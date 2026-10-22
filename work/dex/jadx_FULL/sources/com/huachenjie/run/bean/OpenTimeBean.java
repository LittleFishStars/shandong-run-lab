package com.huachenjie.run.bean;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/run/bean/OpenTimeBean;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "isHeader", "", "content", "", "(ZLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "()Z", "component1", "component2", OperatePopupWindow.g, "equals", "other", "", "hashCode", "", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OpenTimeBean implements SectionEntity {

    @NotNull
    private final String content;
    private final boolean isHeader;

    public OpenTimeBean(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.isHeader = z;
        this.content = str;
    }

    public static /* synthetic */ OpenTimeBean copy$default(OpenTimeBean openTimeBean, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = openTimeBean.getIsHeader();
        }
        if ((i & 2) != 0) {
            str = openTimeBean.content;
        }
        return openTimeBean.copy(z, str);
    }

    public final boolean component1() {
        return getIsHeader();
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final OpenTimeBean copy(boolean isHeader, @NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new OpenTimeBean(isHeader, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenTimeBean)) {
            return false;
        }
        OpenTimeBean openTimeBean = (OpenTimeBean) other;
        return getIsHeader() == openTimeBean.getIsHeader() && Intrinsics.areEqual(this.content, openTimeBean.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean isHeader = getIsHeader();
        ?? r0 = isHeader;
        if (isHeader) {
            r0 = 1;
        }
        return (r0 * 31) + this.content.hashCode();
    }

    @Override // com.chad.library.adapter.base.entity.SectionEntity
    /* JADX INFO: renamed from: isHeader, reason: from getter */
    public boolean getIsHeader() {
        return this.isHeader;
    }

    @NotNull
    public String toString() {
        return "OpenTimeBean(isHeader=" + getIsHeader() + ", content=" + this.content + ')';
    }
}

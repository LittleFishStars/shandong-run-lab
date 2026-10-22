package com.huachenjie.works.bean.publish;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorksRequestIdBean;", "", "requestId", "", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PubWorksRequestIdBean {

    @NotNull
    private final String requestId;

    /* JADX WARN: Illegal instructions before constructor call */
    public PubWorksRequestIdBean() {
        String str = null;
        this(str, 1, str);
    }

    public PubWorksRequestIdBean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.requestId = str;
    }

    public static /* synthetic */ PubWorksRequestIdBean copy$default(PubWorksRequestIdBean pubWorksRequestIdBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pubWorksRequestIdBean.requestId;
        }
        return pubWorksRequestIdBean.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final PubWorksRequestIdBean copy(@NotNull String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return new PubWorksRequestIdBean(requestId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PubWorksRequestIdBean) && Intrinsics.areEqual(this.requestId, ((PubWorksRequestIdBean) other).requestId);
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return this.requestId.hashCode();
    }

    @NotNull
    public String toString() {
        return "PubWorksRequestIdBean(requestId=" + this.requestId + ')';
    }

    public /* synthetic */ PubWorksRequestIdBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}

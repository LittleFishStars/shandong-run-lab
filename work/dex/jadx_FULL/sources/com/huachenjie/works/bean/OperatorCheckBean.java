package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/bean/OperatorCheckBean;", "", "operatorCount", "", "(I)V", "getOperatorCount", "()I", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OperatorCheckBean {
    private final int operatorCount;

    public OperatorCheckBean() {
        this(0, 1, null);
    }

    public OperatorCheckBean(int i) {
        this.operatorCount = i;
    }

    public static /* synthetic */ OperatorCheckBean copy$default(OperatorCheckBean operatorCheckBean, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = operatorCheckBean.operatorCount;
        }
        return operatorCheckBean.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOperatorCount() {
        return this.operatorCount;
    }

    @NotNull
    public final OperatorCheckBean copy(int operatorCount) {
        return new OperatorCheckBean(operatorCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OperatorCheckBean) && this.operatorCount == ((OperatorCheckBean) other).operatorCount;
    }

    public final int getOperatorCount() {
        return this.operatorCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.operatorCount);
    }

    @NotNull
    public String toString() {
        return "OperatorCheckBean(operatorCount=" + this.operatorCount + ')';
    }

    public /* synthetic */ OperatorCheckBean(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}

package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/home/bean/InspirationBean;", "", "total", "", "convertedAmount", "", "(IF)V", "getConvertedAmount", "()F", "getTotal", "()I", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "findAmount", "", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InspirationBean {
    private final float convertedAmount;
    private final int total;

    public InspirationBean() {
        this(0, 0.0f, 3, null);
    }

    public InspirationBean(int i, float f) {
        this.total = i;
        this.convertedAmount = f;
    }

    public static /* synthetic */ InspirationBean copy$default(InspirationBean inspirationBean, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = inspirationBean.total;
        }
        if ((i2 & 2) != 0) {
            f = inspirationBean.convertedAmount;
        }
        return inspirationBean.copy(i, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getConvertedAmount() {
        return this.convertedAmount;
    }

    @NotNull
    public final InspirationBean copy(int total, float convertedAmount) {
        return new InspirationBean(total, convertedAmount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InspirationBean)) {
            return false;
        }
        InspirationBean inspirationBean = (InspirationBean) other;
        return this.total == inspirationBean.total && Float.compare(this.convertedAmount, inspirationBean.convertedAmount) == 0;
    }

    @NotNull
    public final String findAmount() {
        String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.convertedAmount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        return str;
    }

    public final float getConvertedAmount() {
        return this.convertedAmount;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.total) * 31) + Float.hashCode(this.convertedAmount);
    }

    @NotNull
    public String toString() {
        return "InspirationBean(total=" + this.total + ", convertedAmount=" + this.convertedAmount + ')';
    }

    public /* synthetic */ InspirationBean(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? -1.0f : f);
    }
}

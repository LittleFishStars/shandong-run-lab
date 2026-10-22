package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/bean/RemainCountBean;", "", "remainCount", "", "(Ljava/lang/Integer;)V", "getRemainCount", "()Ljava/lang/Integer;", "setRemainCount", "Ljava/lang/Integer;", "component1", OperatePopupWindow.g, "(Ljava/lang/Integer;)Lcom/huachenjie/sport/bean/RemainCountBean;", "equals", "", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RemainCountBean {

    @Nullable
    private Integer remainCount;

    /* JADX WARN: Illegal instructions before constructor call */
    public RemainCountBean() {
        Integer num = null;
        this(num, 1, num);
    }

    public RemainCountBean(@Nullable Integer num) {
        this.remainCount = num;
    }

    public static /* synthetic */ RemainCountBean copy$default(RemainCountBean remainCountBean, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = remainCountBean.remainCount;
        }
        return remainCountBean.copy(num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    @NotNull
    public final RemainCountBean copy(@Nullable Integer remainCount) {
        return new RemainCountBean(remainCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RemainCountBean) && Intrinsics.areEqual(this.remainCount, ((RemainCountBean) other).remainCount);
    }

    @Nullable
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    public int hashCode() {
        Integer num = this.remainCount;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setRemainCount(@Nullable Integer num) {
        this.remainCount = num;
    }

    @NotNull
    public String toString() {
        return "RemainCountBean(remainCount=" + this.remainCount + ')';
    }

    public /* synthetic */ RemainCountBean(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1 : num);
    }
}

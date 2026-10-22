package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/base/bean/AliPay;", "", "bindStatus", "", "(Ljava/lang/Boolean;)V", "getBindStatus", "()Ljava/lang/Boolean;", "setBindStatus", "Ljava/lang/Boolean;", "component1", OperatePopupWindow.g, "(Ljava/lang/Boolean;)Lcom/huachenjie/base/bean/AliPay;", "equals", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AliPay {

    @Nullable
    private Boolean bindStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    public AliPay() {
        Boolean bool = null;
        this(bool, 1, bool);
    }

    public AliPay(@Nullable Boolean bool) {
        this.bindStatus = bool;
    }

    public static /* synthetic */ AliPay copy$default(AliPay aliPay, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = aliPay.bindStatus;
        }
        return aliPay.copy(bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getBindStatus() {
        return this.bindStatus;
    }

    @NotNull
    public final AliPay copy(@Nullable Boolean bindStatus) {
        return new AliPay(bindStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AliPay) && Intrinsics.areEqual(this.bindStatus, ((AliPay) other).bindStatus);
    }

    @Nullable
    public final Boolean getBindStatus() {
        return this.bindStatus;
    }

    public int hashCode() {
        Boolean bool = this.bindStatus;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setBindStatus(@Nullable Boolean bool) {
        this.bindStatus = bool;
    }

    @NotNull
    public String toString() {
        return "AliPay(bindStatus=" + this.bindStatus + ')';
    }

    public /* synthetic */ AliPay(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool);
    }
}

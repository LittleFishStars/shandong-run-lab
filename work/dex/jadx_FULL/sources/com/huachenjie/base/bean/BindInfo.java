package com.huachenjie.base.bean;

import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/base/bean/BindInfo;", "", ShareDialog.QQ, "Lcom/huachenjie/base/bean/Qq;", "wx", "Lcom/huachenjie/base/bean/Wx;", "aliPay", "Lcom/huachenjie/base/bean/AliPay;", "(Lcom/huachenjie/base/bean/Qq;Lcom/huachenjie/base/bean/Wx;Lcom/huachenjie/base/bean/AliPay;)V", "getAliPay", "()Lcom/huachenjie/base/bean/AliPay;", "getQq", "()Lcom/huachenjie/base/bean/Qq;", "getWx", "()Lcom/huachenjie/base/bean/Wx;", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BindInfo {

    @Nullable
    private final AliPay aliPay;

    @Nullable
    private final Qq qq;

    @Nullable
    private final Wx wx;

    public BindInfo() {
        this(null, null, null, 7, null);
    }

    public BindInfo(@Nullable Qq qq, @Nullable Wx wx, @Nullable AliPay aliPay) {
        this.qq = qq;
        this.wx = wx;
        this.aliPay = aliPay;
    }

    public static /* synthetic */ BindInfo copy$default(BindInfo bindInfo, Qq qq, Wx wx, AliPay aliPay, int i, Object obj) {
        if ((i & 1) != 0) {
            qq = bindInfo.qq;
        }
        if ((i & 2) != 0) {
            wx = bindInfo.wx;
        }
        if ((i & 4) != 0) {
            aliPay = bindInfo.aliPay;
        }
        return bindInfo.copy(qq, wx, aliPay);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Qq getQq() {
        return this.qq;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Wx getWx() {
        return this.wx;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AliPay getAliPay() {
        return this.aliPay;
    }

    @NotNull
    public final BindInfo copy(@Nullable Qq qq, @Nullable Wx wx, @Nullable AliPay aliPay) {
        return new BindInfo(qq, wx, aliPay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindInfo)) {
            return false;
        }
        BindInfo bindInfo = (BindInfo) other;
        return Intrinsics.areEqual(this.qq, bindInfo.qq) && Intrinsics.areEqual(this.wx, bindInfo.wx) && Intrinsics.areEqual(this.aliPay, bindInfo.aliPay);
    }

    @Nullable
    public final AliPay getAliPay() {
        return this.aliPay;
    }

    @Nullable
    public final Qq getQq() {
        return this.qq;
    }

    @Nullable
    public final Wx getWx() {
        return this.wx;
    }

    public int hashCode() {
        Qq qq = this.qq;
        int iHashCode = (qq == null ? 0 : qq.hashCode()) * 31;
        Wx wx = this.wx;
        int iHashCode2 = (iHashCode + (wx == null ? 0 : wx.hashCode())) * 31;
        AliPay aliPay = this.aliPay;
        return iHashCode2 + (aliPay != null ? aliPay.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BindInfo(qq=" + this.qq + ", wx=" + this.wx + ", aliPay=" + this.aliPay + ')';
    }

    public /* synthetic */ BindInfo(Qq qq, Wx wx, AliPay aliPay, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : qq, (i & 2) != 0 ? null : wx, (i & 4) != 0 ? null : aliPay);
    }
}

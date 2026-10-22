package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/home/bean/AccountInspirationBean;", "", "balance", "", "(J)V", "getBalance", "()J", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AccountInspirationBean {
    private final long balance;

    public AccountInspirationBean(long j) {
        this.balance = j;
    }

    public static /* synthetic */ AccountInspirationBean copy$default(AccountInspirationBean accountInspirationBean, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = accountInspirationBean.balance;
        }
        return accountInspirationBean.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getBalance() {
        return this.balance;
    }

    @NotNull
    public final AccountInspirationBean copy(long balance) {
        return new AccountInspirationBean(balance);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AccountInspirationBean) && this.balance == ((AccountInspirationBean) other).balance;
    }

    public final long getBalance() {
        return this.balance;
    }

    public int hashCode() {
        return Long.hashCode(this.balance);
    }

    @NotNull
    public String toString() {
        return "AccountInspirationBean(balance=" + this.balance + ')';
    }
}

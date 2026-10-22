package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/common/bean/CustomerServerStatusData;", "", "customerStatus", "", "url", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getCustomerStatus", "()Ljava/lang/Boolean;", "setCustomerStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", OperatePopupWindow.g, "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/huachenjie/common/bean/CustomerServerStatusData;", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomerServerStatusData {

    @Nullable
    private Boolean customerStatus;

    @Nullable
    private String url;

    public CustomerServerStatusData(@Nullable Boolean bool, @Nullable String str) {
        this.customerStatus = bool;
        this.url = str;
    }

    public static /* synthetic */ CustomerServerStatusData copy$default(CustomerServerStatusData customerServerStatusData, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = customerServerStatusData.customerStatus;
        }
        if ((i & 2) != 0) {
            str = customerServerStatusData.url;
        }
        return customerServerStatusData.copy(bool, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getCustomerStatus() {
        return this.customerStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final CustomerServerStatusData copy(@Nullable Boolean customerStatus, @Nullable String url) {
        return new CustomerServerStatusData(customerStatus, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerServerStatusData)) {
            return false;
        }
        CustomerServerStatusData customerServerStatusData = (CustomerServerStatusData) other;
        return Intrinsics.areEqual(this.customerStatus, customerServerStatusData.customerStatus) && Intrinsics.areEqual(this.url, customerServerStatusData.url);
    }

    @Nullable
    public final Boolean getCustomerStatus() {
        return this.customerStatus;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Boolean bool = this.customerStatus;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.url;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setCustomerStatus(@Nullable Boolean bool) {
        this.customerStatus = bool;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "CustomerServerStatusData(customerStatus=" + this.customerStatus + ", url=" + this.url + ")";
    }
}

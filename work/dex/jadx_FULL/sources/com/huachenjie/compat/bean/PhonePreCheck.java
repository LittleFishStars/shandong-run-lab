package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/compat/bean/PhonePreCheck;", "", "count", "", "(I)V", "getCount", "()I", "setCount", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PhonePreCheck {
    private int count;

    public PhonePreCheck(int i) {
        this.count = i;
    }

    public static /* synthetic */ PhonePreCheck copy$default(PhonePreCheck phonePreCheck, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = phonePreCheck.count;
        }
        return phonePreCheck.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final PhonePreCheck copy(int count) {
        return new PhonePreCheck(count);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PhonePreCheck) && this.count == ((PhonePreCheck) other).count;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return Integer.hashCode(this.count);
    }

    public final void setCount(int i) {
        this.count = i;
    }

    @NotNull
    public String toString() {
        return "PhonePreCheck(count=" + this.count + ')';
    }
}

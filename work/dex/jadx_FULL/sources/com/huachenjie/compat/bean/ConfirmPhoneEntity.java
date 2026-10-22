package com.huachenjie.compat.bean;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/compat/bean/ConfirmPhoneEntity;", "", "token", "", "satoken", AliyunLogCommon.TERMINAL_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "getSatoken", "getToken", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConfirmPhoneEntity {

    @NotNull
    private final String phone;

    @NotNull
    private final String satoken;

    @NotNull
    private final String token;

    public ConfirmPhoneEntity(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "satoken");
        Intrinsics.checkNotNullParameter(str3, AliyunLogCommon.TERMINAL_TYPE);
        this.token = str;
        this.satoken = str2;
        this.phone = str3;
    }

    public static /* synthetic */ ConfirmPhoneEntity copy$default(ConfirmPhoneEntity confirmPhoneEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmPhoneEntity.token;
        }
        if ((i & 2) != 0) {
            str2 = confirmPhoneEntity.satoken;
        }
        if ((i & 4) != 0) {
            str3 = confirmPhoneEntity.phone;
        }
        return confirmPhoneEntity.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSatoken() {
        return this.satoken;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final ConfirmPhoneEntity copy(@NotNull String token, @NotNull String satoken, @NotNull String phone) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(satoken, "satoken");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        return new ConfirmPhoneEntity(token, satoken, phone);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmPhoneEntity)) {
            return false;
        }
        ConfirmPhoneEntity confirmPhoneEntity = (ConfirmPhoneEntity) other;
        return Intrinsics.areEqual(this.token, confirmPhoneEntity.token) && Intrinsics.areEqual(this.satoken, confirmPhoneEntity.satoken) && Intrinsics.areEqual(this.phone, confirmPhoneEntity.phone);
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getSatoken() {
        return this.satoken;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.satoken.hashCode()) * 31) + this.phone.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfirmPhoneEntity(token=" + this.token + ", satoken=" + this.satoken + ", phone=" + this.phone + ')';
    }
}

package com.huachenjie.common.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.reconfig.net.IResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\fJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/common/bean/BaseEntity;", "T", "Lcom/huachenjie/common/reconfig/net/IResponse;", "code", "", "data", "message", "", "(ILjava/lang/Object;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", OperatePopupWindow.g, "(ILjava/lang/Object;Ljava/lang/String;)Lcom/huachenjie/common/bean/BaseEntity;", "equals", "", "other", "", "getResponseCode", "getResponseData", "getResponseMsg", "hashCode", UserTrackConstant.IS_SUCCESS, "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BaseEntity<T> implements IResponse<T> {
    private final int code;

    @Nullable
    private final T data;

    @Nullable
    private final String message;

    public BaseEntity() {
        this(0, null, null, 7, null);
    }

    public BaseEntity(int i, @Nullable T t, @Nullable String str) {
        this.code = i;
        this.data = t;
        this.message = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseEntity copy$default(BaseEntity baseEntity, int i, Object obj, String str, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = baseEntity.code;
        }
        if ((i2 & 2) != 0) {
            obj = baseEntity.data;
        }
        if ((i2 & 4) != 0) {
            str = baseEntity.message;
        }
        return baseEntity.copy(i, obj, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T component2() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final BaseEntity<T> copy(int code, @Nullable T data, @Nullable String message) {
        return new BaseEntity<>(code, data, message);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseEntity)) {
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) other;
        return this.code == baseEntity.code && Intrinsics.areEqual(this.data, baseEntity.data) && Intrinsics.areEqual(this.message, baseEntity.message);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Override // com.huachenjie.common.reconfig.net.IResponse
    public int getResponseCode() {
        return this.code;
    }

    @Override // com.huachenjie.common.reconfig.net.IResponse
    @Nullable
    public T getResponseData() {
        return this.data;
    }

    @Override // com.huachenjie.common.reconfig.net.IResponse
    @Nullable
    public String getResponseMsg() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        T t = this.data;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.message;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.huachenjie.common.reconfig.net.IResponse
    public boolean isSuccess() {
        return this.code == 0;
    }

    @NotNull
    public String toString() {
        return "BaseEntity(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ")";
    }

    public /* synthetic */ BaseEntity(int i, Object obj, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : str);
    }
}

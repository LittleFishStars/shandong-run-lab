package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/base/bean/AddressInfo;", "", "code", "", "value", "children", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getCode", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AddressInfo {

    @Nullable
    private final List<AddressInfo> children;

    @Nullable
    private final String code;

    @Nullable
    private final String value;

    public AddressInfo(@Nullable String str, @Nullable String str2, @Nullable List<AddressInfo> list) {
        this.code = str;
        this.value = str2;
        this.children = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddressInfo copy$default(AddressInfo addressInfo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addressInfo.code;
        }
        if ((i & 2) != 0) {
            str2 = addressInfo.value;
        }
        if ((i & 4) != 0) {
            list = addressInfo.children;
        }
        return addressInfo.copy(str, str2, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final List<AddressInfo> component3() {
        return this.children;
    }

    @NotNull
    public final AddressInfo copy(@Nullable String code, @Nullable String value, @Nullable List<AddressInfo> children) {
        return new AddressInfo(code, value, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressInfo)) {
            return false;
        }
        AddressInfo addressInfo = (AddressInfo) other;
        return Intrinsics.areEqual(this.code, addressInfo.code) && Intrinsics.areEqual(this.value, addressInfo.value) && Intrinsics.areEqual(this.children, addressInfo.children);
    }

    @Nullable
    public final List<AddressInfo> getChildren() {
        return this.children;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<AddressInfo> list = this.children;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AddressInfo(code=" + this.code + ", value=" + this.value + ", children=" + this.children + ')';
    }

    public /* synthetic */ AddressInfo(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, list);
    }
}

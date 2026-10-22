package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/compat/bean/DepartmentClassBean;", "", "departmentCode", "", "departmentName", "classList", "", "Lcom/huachenjie/compat/bean/ClazzBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getClassList", "()Ljava/util/List;", "setClassList", "(Ljava/util/List;)V", "getDepartmentCode", "()Ljava/lang/String;", "setDepartmentCode", "(Ljava/lang/String;)V", "getDepartmentName", "setDepartmentName", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DepartmentClassBean {

    @NotNull
    private List<ClazzBean> classList;

    @NotNull
    private String departmentCode;

    @NotNull
    private String departmentName;

    public DepartmentClassBean() {
        this(null, null, null, 7, null);
    }

    public DepartmentClassBean(@NotNull String str, @NotNull String str2, @NotNull List<ClazzBean> list) {
        Intrinsics.checkNotNullParameter(str, "departmentCode");
        Intrinsics.checkNotNullParameter(str2, "departmentName");
        Intrinsics.checkNotNullParameter(list, "classList");
        this.departmentCode = str;
        this.departmentName = str2;
        this.classList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DepartmentClassBean copy$default(DepartmentClassBean departmentClassBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = departmentClassBean.departmentCode;
        }
        if ((i & 2) != 0) {
            str2 = departmentClassBean.departmentName;
        }
        if ((i & 4) != 0) {
            list = departmentClassBean.classList;
        }
        return departmentClassBean.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDepartmentCode() {
        return this.departmentCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDepartmentName() {
        return this.departmentName;
    }

    @NotNull
    public final List<ClazzBean> component3() {
        return this.classList;
    }

    @NotNull
    public final DepartmentClassBean copy(@NotNull String departmentCode, @NotNull String departmentName, @NotNull List<ClazzBean> classList) {
        Intrinsics.checkNotNullParameter(departmentCode, "departmentCode");
        Intrinsics.checkNotNullParameter(departmentName, "departmentName");
        Intrinsics.checkNotNullParameter(classList, "classList");
        return new DepartmentClassBean(departmentCode, departmentName, classList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartmentClassBean)) {
            return false;
        }
        DepartmentClassBean departmentClassBean = (DepartmentClassBean) other;
        return Intrinsics.areEqual(this.departmentCode, departmentClassBean.departmentCode) && Intrinsics.areEqual(this.departmentName, departmentClassBean.departmentName) && Intrinsics.areEqual(this.classList, departmentClassBean.classList);
    }

    @NotNull
    public final List<ClazzBean> getClassList() {
        return this.classList;
    }

    @NotNull
    public final String getDepartmentCode() {
        return this.departmentCode;
    }

    @NotNull
    public final String getDepartmentName() {
        return this.departmentName;
    }

    public int hashCode() {
        return (((this.departmentCode.hashCode() * 31) + this.departmentName.hashCode()) * 31) + this.classList.hashCode();
    }

    public final void setClassList(@NotNull List<ClazzBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.classList = list;
    }

    public final void setDepartmentCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.departmentCode = str;
    }

    public final void setDepartmentName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.departmentName = str;
    }

    @NotNull
    public String toString() {
        return "DepartmentClassBean(departmentCode=" + this.departmentCode + ", departmentName=" + this.departmentName + ", classList=" + this.classList + ')';
    }

    public /* synthetic */ DepartmentClassBean(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : list);
    }
}

package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/compat/bean/ClazzBean;", "", "classCode", "", "className", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassCode", "()Ljava/lang/String;", "setClassCode", "(Ljava/lang/String;)V", "getClassName", "setClassName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClazzBean {

    @NotNull
    private String classCode;

    @NotNull
    private String className;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClazzBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public ClazzBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "classCode");
        Intrinsics.checkNotNullParameter(str2, "className");
        this.classCode = str;
        this.className = str2;
    }

    public static /* synthetic */ ClazzBean copy$default(ClazzBean clazzBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clazzBean.classCode;
        }
        if ((i & 2) != 0) {
            str2 = clazzBean.className;
        }
        return clazzBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassCode() {
        return this.classCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final ClazzBean copy(@NotNull String classCode, @NotNull String className) {
        Intrinsics.checkNotNullParameter(classCode, "classCode");
        Intrinsics.checkNotNullParameter(className, "className");
        return new ClazzBean(classCode, className);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClazzBean)) {
            return false;
        }
        ClazzBean clazzBean = (ClazzBean) other;
        return Intrinsics.areEqual(this.classCode, clazzBean.classCode) && Intrinsics.areEqual(this.className, clazzBean.className);
    }

    @NotNull
    public final String getClassCode() {
        return this.classCode;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    public int hashCode() {
        return (this.classCode.hashCode() * 31) + this.className.hashCode();
    }

    public final void setClassCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classCode = str;
    }

    public final void setClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    @NotNull
    public String toString() {
        return "ClazzBean(classCode=" + this.classCode + ", className=" + this.className + ')';
    }

    public /* synthetic */ ClazzBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

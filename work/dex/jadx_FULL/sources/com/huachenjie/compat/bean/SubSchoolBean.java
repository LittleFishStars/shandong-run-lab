package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/compat/bean/SubSchoolBean;", "", "subSchoolCode", "", "subSchoolName", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubSchoolCode", "()Ljava/lang/String;", "getSubSchoolName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubSchoolBean {

    @NotNull
    private final String subSchoolCode;

    @NotNull
    private final String subSchoolName;

    public SubSchoolBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "subSchoolCode");
        Intrinsics.checkNotNullParameter(str2, "subSchoolName");
        this.subSchoolCode = str;
        this.subSchoolName = str2;
    }

    public static /* synthetic */ SubSchoolBean copy$default(SubSchoolBean subSchoolBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subSchoolBean.subSchoolCode;
        }
        if ((i & 2) != 0) {
            str2 = subSchoolBean.subSchoolName;
        }
        return subSchoolBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubSchoolName() {
        return this.subSchoolName;
    }

    @NotNull
    public final SubSchoolBean copy(@NotNull String subSchoolCode, @NotNull String subSchoolName) {
        Intrinsics.checkNotNullParameter(subSchoolCode, "subSchoolCode");
        Intrinsics.checkNotNullParameter(subSchoolName, "subSchoolName");
        return new SubSchoolBean(subSchoolCode, subSchoolName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubSchoolBean)) {
            return false;
        }
        SubSchoolBean subSchoolBean = (SubSchoolBean) other;
        return Intrinsics.areEqual(this.subSchoolCode, subSchoolBean.subSchoolCode) && Intrinsics.areEqual(this.subSchoolName, subSchoolBean.subSchoolName);
    }

    @NotNull
    public final String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    @NotNull
    public final String getSubSchoolName() {
        return this.subSchoolName;
    }

    public int hashCode() {
        return (this.subSchoolCode.hashCode() * 31) + this.subSchoolName.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubSchoolBean(subSchoolCode=" + this.subSchoolCode + ", subSchoolName=" + this.subSchoolName + ')';
    }
}

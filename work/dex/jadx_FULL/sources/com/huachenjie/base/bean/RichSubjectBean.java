package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/base/bean/RichSubjectBean;", "", "subjectName", "", yj7.b.b, "(Ljava/lang/String;Ljava/lang/String;)V", "getSubjectName", "()Ljava/lang/String;", "setSubjectName", "(Ljava/lang/String;)V", "getSubjectNo", "setSubjectNo", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RichSubjectBean {

    @NotNull
    private String subjectName;

    @NotNull
    private String subjectNo;

    /* JADX WARN: Illegal instructions before constructor call */
    public RichSubjectBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public RichSubjectBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "subjectName");
        Intrinsics.checkNotNullParameter(str2, yj7.b.b);
        this.subjectName = str;
        this.subjectNo = str2;
    }

    public static /* synthetic */ RichSubjectBean copy$default(RichSubjectBean richSubjectBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = richSubjectBean.subjectName;
        }
        if ((i & 2) != 0) {
            str2 = richSubjectBean.subjectNo;
        }
        return richSubjectBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    public final RichSubjectBean copy(@NotNull String subjectName, @NotNull String subjectNo) {
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.b);
        return new RichSubjectBean(subjectName, subjectNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RichSubjectBean)) {
            return false;
        }
        RichSubjectBean richSubjectBean = (RichSubjectBean) other;
        return Intrinsics.areEqual(this.subjectName, richSubjectBean.subjectName) && Intrinsics.areEqual(this.subjectNo, richSubjectBean.subjectNo);
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    public int hashCode() {
        return (this.subjectName.hashCode() * 31) + this.subjectNo.hashCode();
    }

    public final void setSubjectName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectName = str;
    }

    public final void setSubjectNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectNo = str;
    }

    @NotNull
    public String toString() {
        return "RichSubjectBean(subjectName=" + this.subjectName + ", subjectNo=" + this.subjectNo + ')';
    }

    public /* synthetic */ RichSubjectBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

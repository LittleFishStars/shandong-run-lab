package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/bean/EmaSelectionBean;", "", "questionNo", "", "optionNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getOptionNo", "()Ljava/lang/String;", "getQuestionNo", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmaSelectionBean {

    @NotNull
    private final String optionNo;

    @NotNull
    private final String questionNo;

    public EmaSelectionBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "questionNo");
        Intrinsics.checkNotNullParameter(str2, "optionNo");
        this.questionNo = str;
        this.optionNo = str2;
    }

    public static /* synthetic */ EmaSelectionBean copy$default(EmaSelectionBean emaSelectionBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emaSelectionBean.questionNo;
        }
        if ((i & 2) != 0) {
            str2 = emaSelectionBean.optionNo;
        }
        return emaSelectionBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOptionNo() {
        return this.optionNo;
    }

    @NotNull
    public final EmaSelectionBean copy(@NotNull String questionNo, @NotNull String optionNo) {
        Intrinsics.checkNotNullParameter(questionNo, "questionNo");
        Intrinsics.checkNotNullParameter(optionNo, "optionNo");
        return new EmaSelectionBean(questionNo, optionNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmaSelectionBean)) {
            return false;
        }
        EmaSelectionBean emaSelectionBean = (EmaSelectionBean) other;
        return Intrinsics.areEqual(this.questionNo, emaSelectionBean.questionNo) && Intrinsics.areEqual(this.optionNo, emaSelectionBean.optionNo);
    }

    @NotNull
    public final String getOptionNo() {
        return this.optionNo;
    }

    @NotNull
    public final String getQuestionNo() {
        return this.questionNo;
    }

    public int hashCode() {
        return (this.questionNo.hashCode() * 31) + this.optionNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmaSelectionBean(questionNo=" + this.questionNo + ", optionNo=" + this.optionNo + ')';
    }
}

package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/college/bean/FitnessPermissionBean;", "", "fitnessScoreVisible", "", "(Z)V", "getFitnessScoreVisible", "()Z", "component1", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FitnessPermissionBean {
    private final boolean fitnessScoreVisible;

    public FitnessPermissionBean(boolean z) {
        this.fitnessScoreVisible = z;
    }

    public static /* synthetic */ FitnessPermissionBean copy$default(FitnessPermissionBean fitnessPermissionBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fitnessPermissionBean.fitnessScoreVisible;
        }
        return fitnessPermissionBean.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getFitnessScoreVisible() {
        return this.fitnessScoreVisible;
    }

    @NotNull
    public final FitnessPermissionBean copy(boolean fitnessScoreVisible) {
        return new FitnessPermissionBean(fitnessScoreVisible);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FitnessPermissionBean) && this.fitnessScoreVisible == ((FitnessPermissionBean) other).fitnessScoreVisible;
    }

    public final boolean getFitnessScoreVisible() {
        return this.fitnessScoreVisible;
    }

    public int hashCode() {
        boolean z = this.fitnessScoreVisible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "FitnessPermissionBean(fitnessScoreVisible=" + this.fitnessScoreVisible + ')';
    }
}

package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/sport/bean/AddPointItem;", "", "extraScore", "", "projectType", "", "testResult", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getExtraScore", "()Ljava/lang/String;", "getProjectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTestResult", "component1", "component2", "component3", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/huachenjie/sport/bean/AddPointItem;", "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AddPointItem {

    @Nullable
    private final String extraScore;

    @Nullable
    private final Integer projectType;

    @Nullable
    private final String testResult;

    public AddPointItem() {
        this(null, null, null, 7, null);
    }

    public AddPointItem(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        this.extraScore = str;
        this.projectType = num;
        this.testResult = str2;
    }

    public static /* synthetic */ AddPointItem copy$default(AddPointItem addPointItem, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addPointItem.extraScore;
        }
        if ((i & 2) != 0) {
            num = addPointItem.projectType;
        }
        if ((i & 4) != 0) {
            str2 = addPointItem.testResult;
        }
        return addPointItem.copy(str, num, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getExtraScore() {
        return this.extraScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getProjectType() {
        return this.projectType;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTestResult() {
        return this.testResult;
    }

    @NotNull
    public final AddPointItem copy(@Nullable String extraScore, @Nullable Integer projectType, @Nullable String testResult) {
        return new AddPointItem(extraScore, projectType, testResult);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddPointItem)) {
            return false;
        }
        AddPointItem addPointItem = (AddPointItem) other;
        return Intrinsics.areEqual(this.extraScore, addPointItem.extraScore) && Intrinsics.areEqual(this.projectType, addPointItem.projectType) && Intrinsics.areEqual(this.testResult, addPointItem.testResult);
    }

    @Nullable
    public final String getExtraScore() {
        return this.extraScore;
    }

    @Nullable
    public final Integer getProjectType() {
        return this.projectType;
    }

    @Nullable
    public final String getTestResult() {
        return this.testResult;
    }

    public int hashCode() {
        String str = this.extraScore;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.projectType;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.testResult;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AddPointItem(extraScore=" + this.extraScore + ", projectType=" + this.projectType + ", testResult=" + this.testResult + ')';
    }

    public /* synthetic */ AddPointItem(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
    }
}

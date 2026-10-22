package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/base/bean/LetterData;", "", "letterList", "", "Lcom/huachenjie/base/bean/LetterBean;", "(Ljava/util/List;)V", "getLetterList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LetterData {

    @NotNull
    private final List<LetterBean> letterList;

    /* JADX WARN: Illegal instructions before constructor call */
    public LetterData() {
        List list = null;
        this(list, 1, list);
    }

    public LetterData(@NotNull List<LetterBean> list) {
        Intrinsics.checkNotNullParameter(list, "letterList");
        this.letterList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LetterData copy$default(LetterData letterData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = letterData.letterList;
        }
        return letterData.copy(list);
    }

    @NotNull
    public final List<LetterBean> component1() {
        return this.letterList;
    }

    @NotNull
    public final LetterData copy(@NotNull List<LetterBean> letterList) {
        Intrinsics.checkNotNullParameter(letterList, "letterList");
        return new LetterData(letterList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LetterData) && Intrinsics.areEqual(this.letterList, ((LetterData) other).letterList);
    }

    @NotNull
    public final List<LetterBean> getLetterList() {
        return this.letterList;
    }

    public int hashCode() {
        return this.letterList.hashCode();
    }

    @NotNull
    public String toString() {
        return "LetterData(letterList=" + this.letterList + ')';
    }

    public /* synthetic */ LetterData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}

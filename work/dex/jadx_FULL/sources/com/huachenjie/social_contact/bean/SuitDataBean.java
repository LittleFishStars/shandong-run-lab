package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/social_contact/bean/SuitDataBean;", "", "type", "", "suitList", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/SuitBean;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getSuitList", "()Ljava/util/ArrayList;", "getType", "()I", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SuitDataBean {

    @NotNull
    private final ArrayList<SuitBean> suitList;
    private final int type;

    public SuitDataBean(int i, @NotNull ArrayList<SuitBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "suitList");
        this.type = i;
        this.suitList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuitDataBean copy$default(SuitDataBean suitDataBean, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = suitDataBean.type;
        }
        if ((i2 & 2) != 0) {
            arrayList = suitDataBean.suitList;
        }
        return suitDataBean.copy(i, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final ArrayList<SuitBean> component2() {
        return this.suitList;
    }

    @NotNull
    public final SuitDataBean copy(int type, @NotNull ArrayList<SuitBean> suitList) {
        Intrinsics.checkNotNullParameter(suitList, "suitList");
        return new SuitDataBean(type, suitList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuitDataBean)) {
            return false;
        }
        SuitDataBean suitDataBean = (SuitDataBean) other;
        return this.type == suitDataBean.type && Intrinsics.areEqual(this.suitList, suitDataBean.suitList);
    }

    @NotNull
    public final ArrayList<SuitBean> getSuitList() {
        return this.suitList;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + this.suitList.hashCode();
    }

    @NotNull
    public String toString() {
        return "SuitDataBean(type=" + this.type + ", suitList=" + this.suitList + ')';
    }
}

package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.home_tab.MallItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/bean/MallNavigationBean;", "", "name", "", MallItemFragment.NAVIGATION_NO, "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNavigationNo", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MallNavigationBean {

    @NotNull
    private final String name;

    @NotNull
    private final String navigationNo;

    /* JADX WARN: Illegal instructions before constructor call */
    public MallNavigationBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public MallNavigationBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, MallItemFragment.NAVIGATION_NO);
        this.name = str;
        this.navigationNo = str2;
    }

    public static /* synthetic */ MallNavigationBean copy$default(MallNavigationBean mallNavigationBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mallNavigationBean.name;
        }
        if ((i & 2) != 0) {
            str2 = mallNavigationBean.navigationNo;
        }
        return mallNavigationBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNavigationNo() {
        return this.navigationNo;
    }

    @NotNull
    public final MallNavigationBean copy(@NotNull String name, @NotNull String navigationNo) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(navigationNo, MallItemFragment.NAVIGATION_NO);
        return new MallNavigationBean(name, navigationNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MallNavigationBean)) {
            return false;
        }
        MallNavigationBean mallNavigationBean = (MallNavigationBean) other;
        return Intrinsics.areEqual(this.name, mallNavigationBean.name) && Intrinsics.areEqual(this.navigationNo, mallNavigationBean.navigationNo);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNavigationNo() {
        return this.navigationNo;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.navigationNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "MallNavigationBean(name=" + this.name + ", navigationNo=" + this.navigationNo + ')';
    }

    public /* synthetic */ MallNavigationBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

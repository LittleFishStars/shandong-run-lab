package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/BuddyTypeScopeBean;", "", "scopeName", "", "scopeType", "", "typeList", "", "Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;", "(Ljava/lang/String;ILjava/util/List;)V", "getScopeName", "()Ljava/lang/String;", "getScopeType", "()I", "getTypeList", "()Ljava/util/List;", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyTypeScopeBean {

    @NotNull
    private final String scopeName;
    private final int scopeType;

    @NotNull
    private final List<BuddyTypeScopeTypeBean> typeList;

    public BuddyTypeScopeBean() {
        this(null, 0, null, 7, null);
    }

    public BuddyTypeScopeBean(@NotNull String str, int i, @NotNull List<BuddyTypeScopeTypeBean> list) {
        Intrinsics.checkNotNullParameter(str, "scopeName");
        Intrinsics.checkNotNullParameter(list, "typeList");
        this.scopeName = str;
        this.scopeType = i;
        this.typeList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuddyTypeScopeBean copy$default(BuddyTypeScopeBean buddyTypeScopeBean, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = buddyTypeScopeBean.scopeName;
        }
        if ((i2 & 2) != 0) {
            i = buddyTypeScopeBean.scopeType;
        }
        if ((i2 & 4) != 0) {
            list = buddyTypeScopeBean.typeList;
        }
        return buddyTypeScopeBean.copy(str, i, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScopeName() {
        return this.scopeName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getScopeType() {
        return this.scopeType;
    }

    @NotNull
    public final List<BuddyTypeScopeTypeBean> component3() {
        return this.typeList;
    }

    @NotNull
    public final BuddyTypeScopeBean copy(@NotNull String scopeName, int scopeType, @NotNull List<BuddyTypeScopeTypeBean> typeList) {
        Intrinsics.checkNotNullParameter(scopeName, "scopeName");
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        return new BuddyTypeScopeBean(scopeName, scopeType, typeList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyTypeScopeBean)) {
            return false;
        }
        BuddyTypeScopeBean buddyTypeScopeBean = (BuddyTypeScopeBean) other;
        return Intrinsics.areEqual(this.scopeName, buddyTypeScopeBean.scopeName) && this.scopeType == buddyTypeScopeBean.scopeType && Intrinsics.areEqual(this.typeList, buddyTypeScopeBean.typeList);
    }

    @NotNull
    public final String getScopeName() {
        return this.scopeName;
    }

    public final int getScopeType() {
        return this.scopeType;
    }

    @NotNull
    public final List<BuddyTypeScopeTypeBean> getTypeList() {
        return this.typeList;
    }

    public int hashCode() {
        return (((this.scopeName.hashCode() * 31) + Integer.hashCode(this.scopeType)) * 31) + this.typeList.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyTypeScopeBean(scopeName=" + this.scopeName + ", scopeType=" + this.scopeType + ", typeList=" + this.typeList + ')';
    }

    public /* synthetic */ BuddyTypeScopeBean(String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new ArrayList() : list);
    }
}

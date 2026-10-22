package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.dx7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/base/bean/MainTabRedDotBean;", "", "inspiration", "", "school", "home", dx7.f41301a, "(ZZZZ)V", "getHome", "()Z", "getInspiration", "getProfile", "getSchool", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MainTabRedDotBean {
    private final boolean home;
    private final boolean inspiration;
    private final boolean profile;
    private final boolean school;

    public MainTabRedDotBean() {
        this(false, false, false, false, 15, null);
    }

    public MainTabRedDotBean(boolean z, boolean z2, boolean z3, boolean z4) {
        this.inspiration = z;
        this.school = z2;
        this.home = z3;
        this.profile = z4;
    }

    public static /* synthetic */ MainTabRedDotBean copy$default(MainTabRedDotBean mainTabRedDotBean, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mainTabRedDotBean.inspiration;
        }
        if ((i & 2) != 0) {
            z2 = mainTabRedDotBean.school;
        }
        if ((i & 4) != 0) {
            z3 = mainTabRedDotBean.home;
        }
        if ((i & 8) != 0) {
            z4 = mainTabRedDotBean.profile;
        }
        return mainTabRedDotBean.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getInspiration() {
        return this.inspiration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSchool() {
        return this.school;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHome() {
        return this.home;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getProfile() {
        return this.profile;
    }

    @NotNull
    public final MainTabRedDotBean copy(boolean inspiration, boolean school, boolean home, boolean profile) {
        return new MainTabRedDotBean(inspiration, school, home, profile);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainTabRedDotBean)) {
            return false;
        }
        MainTabRedDotBean mainTabRedDotBean = (MainTabRedDotBean) other;
        return this.inspiration == mainTabRedDotBean.inspiration && this.school == mainTabRedDotBean.school && this.home == mainTabRedDotBean.home && this.profile == mainTabRedDotBean.profile;
    }

    public final boolean getHome() {
        return this.home;
    }

    public final boolean getInspiration() {
        return this.inspiration;
    }

    public final boolean getProfile() {
        return this.profile;
    }

    public final boolean getSchool() {
        return this.school;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z = this.inspiration;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.school;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.home;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z4 = this.profile;
        return i3 + (z4 ? 1 : z4);
    }

    @NotNull
    public String toString() {
        return "MainTabRedDotBean(inspiration=" + this.inspiration + ", school=" + this.school + ", home=" + this.home + ", profile=" + this.profile + ')';
    }

    public /* synthetic */ MainTabRedDotBean(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}

package com.huachenjie.login.bean;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/login/bean/GradeBean;", "", CachedContentIndex.a.e, "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GradeBean {

    @NotNull
    private final String key;

    @NotNull
    private final String name;

    /* JADX WARN: Illegal instructions before constructor call */
    public GradeBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public GradeBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(str2, "name");
        this.key = str;
        this.name = str2;
    }

    public static /* synthetic */ GradeBean copy$default(GradeBean gradeBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gradeBean.key;
        }
        if ((i & 2) != 0) {
            str2 = gradeBean.name;
        }
        return gradeBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final GradeBean copy(@NotNull String key, @NotNull String name) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(name, "name");
        return new GradeBean(key, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GradeBean)) {
            return false;
        }
        GradeBean gradeBean = (GradeBean) other;
        return Intrinsics.areEqual(this.key, gradeBean.key) && Intrinsics.areEqual(this.name, gradeBean.name);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "GradeBean(key=" + this.key + ", name=" + this.name + ')';
    }

    public /* synthetic */ GradeBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}

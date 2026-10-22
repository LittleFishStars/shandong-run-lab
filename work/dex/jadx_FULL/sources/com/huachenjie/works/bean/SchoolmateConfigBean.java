package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0003JG\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/SchoolmateConfigBean;", "", "hasUserTag", "", "gradeList", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/SchoolmateGradeBean;", "Lkotlin/collections/ArrayList;", "tagList", "Lcom/huachenjie/works/bean/InterestTagGroupBean;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getGradeList", "()Ljava/util/ArrayList;", "getHasUserTag", "()Z", "setHasUserTag", "(Z)V", "getTagList", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolmateConfigBean {

    @NotNull
    private final ArrayList<SchoolmateGradeBean> gradeList;
    private boolean hasUserTag;

    @NotNull
    private final ArrayList<InterestTagGroupBean> tagList;

    public SchoolmateConfigBean() {
        this(false, null, null, 7, null);
    }

    public SchoolmateConfigBean(boolean z, @NotNull ArrayList<SchoolmateGradeBean> arrayList, @NotNull ArrayList<InterestTagGroupBean> arrayList2) {
        Intrinsics.checkNotNullParameter(arrayList, "gradeList");
        Intrinsics.checkNotNullParameter(arrayList2, "tagList");
        this.hasUserTag = z;
        this.gradeList = arrayList;
        this.tagList = arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchoolmateConfigBean copy$default(SchoolmateConfigBean schoolmateConfigBean, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = schoolmateConfigBean.hasUserTag;
        }
        if ((i & 2) != 0) {
            arrayList = schoolmateConfigBean.gradeList;
        }
        if ((i & 4) != 0) {
            arrayList2 = schoolmateConfigBean.tagList;
        }
        return schoolmateConfigBean.copy(z, arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasUserTag() {
        return this.hasUserTag;
    }

    @NotNull
    public final ArrayList<SchoolmateGradeBean> component2() {
        return this.gradeList;
    }

    @NotNull
    public final ArrayList<InterestTagGroupBean> component3() {
        return this.tagList;
    }

    @NotNull
    public final SchoolmateConfigBean copy(boolean hasUserTag, @NotNull ArrayList<SchoolmateGradeBean> gradeList, @NotNull ArrayList<InterestTagGroupBean> tagList) {
        Intrinsics.checkNotNullParameter(gradeList, "gradeList");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        return new SchoolmateConfigBean(hasUserTag, gradeList, tagList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolmateConfigBean)) {
            return false;
        }
        SchoolmateConfigBean schoolmateConfigBean = (SchoolmateConfigBean) other;
        return this.hasUserTag == schoolmateConfigBean.hasUserTag && Intrinsics.areEqual(this.gradeList, schoolmateConfigBean.gradeList) && Intrinsics.areEqual(this.tagList, schoolmateConfigBean.tagList);
    }

    @NotNull
    public final ArrayList<SchoolmateGradeBean> getGradeList() {
        return this.gradeList;
    }

    public final boolean getHasUserTag() {
        return this.hasUserTag;
    }

    @NotNull
    public final ArrayList<InterestTagGroupBean> getTagList() {
        return this.tagList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.hasUserTag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.gradeList.hashCode()) * 31) + this.tagList.hashCode();
    }

    public final void setHasUserTag(boolean z) {
        this.hasUserTag = z;
    }

    @NotNull
    public String toString() {
        return "SchoolmateConfigBean(hasUserTag=" + this.hasUserTag + ", gradeList=" + this.gradeList + ", tagList=" + this.tagList + ')';
    }

    public /* synthetic */ SchoolmateConfigBean(boolean z, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList() : arrayList2);
    }
}

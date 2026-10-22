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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0011J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/bean/PostCategoryDataBean;", "", "typeList", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lkotlin/collections/ArrayList;", "tagList", "", "(Ljava/util/ArrayList;Ljava/util/List;)V", "getTagList", "()Ljava/util/List;", "getTypeList", "()Ljava/util/ArrayList;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "findCategory", "index", "", "hashCode", "showTag", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostCategoryDataBean {

    @NotNull
    private final List<PostCategoryBean> tagList;

    @NotNull
    private final ArrayList<PostCategoryBean> typeList;

    /* JADX WARN: Illegal instructions before constructor call */
    public PostCategoryDataBean() {
        ArrayList arrayList = null;
        this(arrayList, arrayList, 3, arrayList);
    }

    public PostCategoryDataBean(@NotNull ArrayList<PostCategoryBean> arrayList, @NotNull List<PostCategoryBean> list) {
        Intrinsics.checkNotNullParameter(arrayList, "typeList");
        Intrinsics.checkNotNullParameter(list, "tagList");
        this.typeList = arrayList;
        this.tagList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostCategoryDataBean copy$default(PostCategoryDataBean postCategoryDataBean, ArrayList arrayList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = postCategoryDataBean.typeList;
        }
        if ((i & 2) != 0) {
            list = postCategoryDataBean.tagList;
        }
        return postCategoryDataBean.copy(arrayList, list);
    }

    @NotNull
    public final ArrayList<PostCategoryBean> component1() {
        return this.typeList;
    }

    @NotNull
    public final List<PostCategoryBean> component2() {
        return this.tagList;
    }

    @NotNull
    public final PostCategoryDataBean copy(@NotNull ArrayList<PostCategoryBean> typeList, @NotNull List<PostCategoryBean> tagList) {
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        return new PostCategoryDataBean(typeList, tagList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostCategoryDataBean)) {
            return false;
        }
        PostCategoryDataBean postCategoryDataBean = (PostCategoryDataBean) other;
        return Intrinsics.areEqual(this.typeList, postCategoryDataBean.typeList) && Intrinsics.areEqual(this.tagList, postCategoryDataBean.tagList);
    }

    @NotNull
    public final PostCategoryBean findCategory(int index) {
        List<PostCategoryBean> list;
        if (index >= 0 && index < 3) {
            ArrayList<PostCategoryBean> arrayList = this.typeList;
            if (arrayList != null) {
                if (index >= 0 && index < arrayList.size()) {
                    PostCategoryBean postCategoryBean = this.typeList.get(index);
                    Intrinsics.checkNotNullExpressionValue(postCategoryBean, "typeList[index]");
                    return postCategoryBean;
                }
            }
        } else {
            if ((3 <= index && index < 6) && (list = this.tagList) != null) {
                int i = index - 3;
                if (i >= 0 && i < list.size()) {
                    return this.tagList.get(i);
                }
            }
        }
        return new PostCategoryBean(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    public final List<PostCategoryBean> getTagList() {
        return this.tagList;
    }

    @NotNull
    public final ArrayList<PostCategoryBean> getTypeList() {
        return this.typeList;
    }

    public int hashCode() {
        return (this.typeList.hashCode() * 31) + this.tagList.hashCode();
    }

    public final boolean showTag() {
        List<PostCategoryBean> list = this.tagList;
        return (list == null || list.isEmpty() || this.tagList.size() < 3) ? false : true;
    }

    @NotNull
    public String toString() {
        return "PostCategoryDataBean(typeList=" + this.typeList + ", tagList=" + this.tagList + ')';
    }

    public /* synthetic */ PostCategoryDataBean(ArrayList arrayList, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : list);
    }
}

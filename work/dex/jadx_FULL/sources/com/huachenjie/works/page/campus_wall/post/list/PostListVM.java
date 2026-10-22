package com.huachenjie.works.page.campus_wall.post.list;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002J,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002J.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002R%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\r8\u0006¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010\u0013¨\u0006."}, d2 = {"Lcom/huachenjie/works/page/campus_wall/post/list/PostListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "postTypeId", "", "q", "", "postType", "tagNo", "schoolCode", "r", j.b, "p", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/works/page/campus_wall/post/PostAdapter;", "c", "j", "adapter", "K", "I", "k", "()I", "s", "(I)V", "pageNum", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "refreshTime", "", "Lcom/huachenjie/works/bean/PostCategoryBean;", "d", "m", "tagList", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PostListVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PostAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<PostCategoryBean>> tagList = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<PostAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<List<PostCategoryBean>> m() {
        return this.tagList;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.isRefreshing;
    }

    public final void o(int postType, @Nullable String postTypeId, @Nullable String tagNo, @Nullable String schoolCode) {
        this.pageNum++;
        p(postType, postTypeId, tagNo, schoolCode);
    }

    public final void p(int postType, String postTypeId, String tagNo, String schoolCode) {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.n().setValue(Boolean.FALSE);
                    PostAdapter value = this.this$0.j().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    PostAdapter value2 = this.this$0.j().getValue();
                    if (value2 != null) {
                        value2.p();
                    }
                } else {
                    PostListVM postListVM = this.this$0;
                    postListVM.s(postListVM.getPageNum() - 1);
                }
                PostAdapter value3 = this.this$0.j().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new PostListVM$queryPageList$2(postType, this, schoolCode, postTypeId, tagNo, null), 11, null);
    }

    public final void q(@NotNull String postTypeId) {
        Intrinsics.checkNotNullParameter(postTypeId, "postTypeId");
        BaseViewModelExtKt.b(this, true, false, null, null, new PostListVM$queryPostCategoryTagList$1(postTypeId, this, null), 14, null);
    }

    public final void r(int postType, @Nullable String postTypeId, @Nullable String tagNo, @Nullable String schoolCode) {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        p(postType, postTypeId, tagNo, schoolCode);
    }

    public final void s(int i) {
        this.pageNum = i;
    }

    public final void t(@Nullable String str) {
        this.refreshTime = str;
    }
}

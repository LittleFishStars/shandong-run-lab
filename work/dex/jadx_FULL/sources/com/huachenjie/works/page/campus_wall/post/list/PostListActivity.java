package com.huachenjie.works.page.campus_wall.post.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.broadcast.post.PostOperateListener;
import com.huachenjie.base.broadcast.post.PostOperateReceiver;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.databinding.WorksActivityHotListBinding;
import com.huachenjie.works.page.campus_wall.dialog.PostCategoryDrawer;
import com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.qk0;
import com.zj.adlib.tv6;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0019B\u0007¢\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010!R\u001b\u0010(\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010!R\u001b\u0010+\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010!R)\u00102\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010-0-0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001a\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/post/list/PostListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityHotListBinding;", "Lcom/huachenjie/works/page/campus_wall/post/list/PostListVM;", "", "w0", "x0", "u0", "m0", "", "", "", "V", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "initView", "initData", "W", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "b", "Lkotlin/Lazy;", "s0", "()I", "postType", "", "c", "r0", "()Ljava/lang/String;", PostListActivity.z, "d", "t0", PostListActivity.A, "e", "q0", PostListActivity.B, "f", bo.g, PostListActivity.C, "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "kotlin.jvm.PlatformType", y6b.f, "n0", "()Ljava/util/ArrayList;", yj7.g.WORKS_PUBLISH_CATEGORY_LIST, "t", "Ljava/lang/String;", "postTypeNo", "x", "postTagNo", "Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", y6b.g, "o0", "()Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "postOperateReceiver", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PostListActivity extends BaseMVVMActivity<WorksActivityHotListBinding, PostListVM> {

    @NotNull
    public static final String A = "postTypeCode";

    @NotNull
    public static final String B = "postTagCode";

    @NotNull
    public static final String C = "postSchoolCode";

    @NotNull
    public static final String D = "postCategoryList";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String y = "postType";

    @NotNull
    public static final String z = "postTitle";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.sv6
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            PostListActivity.A0(this.f44782a);
        }
    };

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy postType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m890invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("postType", 1));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy postTitle = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postTitle$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(PostListActivity.z);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy postTypeCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postTypeCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(PostListActivity.A);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy postTagCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postTagCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(PostListActivity.B);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy postSchoolCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postSchoolCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(PostListActivity.C);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy categoryList = LazyKt.lazy(new Function0<ArrayList<PostCategoryBean>>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$categoryList$2
        {
            super(0);
        }

        @NotNull
        public final ArrayList<PostCategoryBean> invoke() {
            ArrayList<PostCategoryBean> parcelableArrayListExtra = this.this$0.getIntent().getParcelableArrayListExtra(PostListActivity.D);
            return parcelableArrayListExtra == null ? new ArrayList<>() : parcelableArrayListExtra;
        }
    });

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy postOperateReceiver = LazyKt.lazy(new Function0<PostOperateReceiver>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$postOperateReceiver$2

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/campus_wall/post/list/PostListActivity$postOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/post/PostOperateListener;", "", "postNo", "", "isChecked", "", "likeCount", "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nPostListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostListActivity.kt\ncom/huachenjie/works/page/campus_wall/post/list/PostListActivity$postOperateReceiver$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,206:1\n350#2,7:207\n*S KotlinDebug\n*F\n+ 1 PostListActivity.kt\ncom/huachenjie/works/page/campus_wall/post/list/PostListActivity$postOperateReceiver$2$1\n*L\n92#1:207,7\n*E\n"})
        public static final class a implements PostOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PostListActivity f37237a;

            public a(PostListActivity postListActivity) {
                this.f37237a = postListActivity;
            }

            @Override // com.huachenjie.base.broadcast.post.PostOperateListener
            public void a(@Nullable String postNo, boolean isChecked, int likeCount) {
                PostAdapter value;
                if (TextUtils.isEmpty(postNo) || (value = this.f37237a.getMViewModel().j().getValue()) == null) {
                    return;
                }
                Iterator it = value.getData().iterator();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(((PostItemBean) it.next()).getPostInfo().getPostNo(), postNo)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && i < value.getData().size()) {
                    z = true;
                }
                if (z) {
                    ((PostItemBean) value.getData().get(i)).setLiked(isChecked, likeCount);
                    value.notifyItemChanged(i + value.getHeaderLayoutCount());
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PostOperateReceiver m886invoke() {
            return new PostOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Nullable
    public String postTypeNo;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Nullable
    public String postTagNo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/post/list/PostListActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/campus_wall/post/list/PostListActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (PostListActivity.this.s0() != 1) {
                PublishPostActivity.Companion bVar = PublishPostActivity.INSTANCE;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                String strT0 = PostListActivity.this.t0();
                Intrinsics.checkNotNullExpressionValue(strT0, PostListActivity.A);
                bVar.a(context, strT0, PostListActivity.this.q0());
                return;
            }
            if (PostListActivity.this.n0().isEmpty()) {
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            PublishPostDialog publishPostDialogA = PublishPostDialog.INSTANCE.a(iArr[0], iArr[1], PostListActivity.this.n0());
            FragmentManager supportFragmentManager = PostListActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            publishPostDialogA.show(supportFragmentManager, PublishPostDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019JR\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/post/list/PostListActivity$b;", "", "Landroid/content/Context;", "context", "", "type", "", "title", "typeCode", "tagCode", "schoolCode", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lkotlin/collections/ArrayList;", yj7.g.WORKS_PUBLISH_CATEGORY_LIST, "", "a", "POST_CATEGORY_LIST", "Ljava/lang/String;", "POST_SCHOOL_CODE", "POST_TAG_CODE", "POST_TITLE", "POST_TYPE", "POST_TYPE_CODE", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int type, @NotNull String title, @NotNull String typeCode, @NotNull String tagCode, @Nullable String schoolCode, @NotNull ArrayList<PostCategoryBean> categoryList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(typeCode, "typeCode");
            Intrinsics.checkNotNullParameter(tagCode, "tagCode");
            Intrinsics.checkNotNullParameter(categoryList, yj7.g.WORKS_PUBLISH_CATEGORY_LIST);
            Intent intent = new Intent(context, (Class<?>) PostListActivity.class);
            intent.putExtra("postType", type);
            intent.putExtra(PostListActivity.z, title);
            intent.putExtra(PostListActivity.A, typeCode);
            intent.putExtra(PostListActivity.B, tagCode);
            if (schoolCode == null) {
                schoolCode = "";
            }
            intent.putExtra(PostListActivity.C, schoolCode);
            intent.putParcelableArrayListExtra(PostListActivity.D, categoryList);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37236a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37236a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37236a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37236a.invoke(obj);
        }
    }

    public static final void A0(PostListActivity postListActivity) {
        Intrinsics.checkNotNullParameter(postListActivity, "this$0");
        postListActivity.getMViewModel().r(postListActivity.s0(), postListActivity.postTypeNo, postListActivity.postTagNo, postListActivity.p0());
    }

    public static final void v0(PostListActivity postListActivity) {
        Intrinsics.checkNotNullParameter(postListActivity, "this$0");
        postListActivity.getMViewModel().o(postListActivity.s0(), postListActivity.postTypeNo, postListActivity.postTagNo, postListActivity.p0());
    }

    public static final void y0(PostListActivity postListActivity, View view) {
        Intrinsics.checkNotNullParameter(postListActivity, "this$0");
        postListActivity.finish();
    }

    public static final void z0(PostListActivity postListActivity, View view) {
        Intrinsics.checkNotNullParameter(postListActivity, "this$0");
        postListActivity.m0();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().m().observe(this, new c(new Function1<List<? extends PostCategoryBean>, Unit>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<PostCategoryBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<PostCategoryBean> list) {
                PostListActivity postListActivity = this.this$0;
                String str = postListActivity.postTagNo;
                final PostListActivity postListActivity2 = this.this$0;
                new PostCategoryDrawer(postListActivity, list, str, new Function1<String, Unit>() { // from class: com.huachenjie.works.page.campus_wall.post.list.PostListActivity$initDataObserve$1.1
                    {
                        super(1);
                    }

                    public final void invoke(@Nullable String str2) {
                        postListActivity2.postTagNo = str2;
                        postListActivity2.getMViewModel().r(postListActivity2.s0(), postListActivity2.postTypeNo, postListActivity2.postTagNo, postListActivity2.p0());
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }
                }).show();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_hot_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        this.postTypeNo = t0();
        this.postTagNo = q0();
        getMViewModel().r(s0(), this.postTypeNo, this.postTagNo, p0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        w0();
        x0();
        u0();
    }

    public final void m0() {
        List<PostCategoryBean> value = getMViewModel().m().getValue();
        List<PostCategoryBean> list = value;
        if (!(list == null || list.isEmpty())) {
            getMViewModel().m().setValue(value);
            return;
        }
        PostListVM mViewModel = getMViewModel();
        String strT0 = t0();
        Intrinsics.checkNotNullExpressionValue(strT0, A);
        mViewModel.q(strT0);
    }

    public final ArrayList<PostCategoryBean> n0() {
        return (ArrayList) this.categoryList.getValue();
    }

    public final PostOperateReceiver o0() {
        return (PostOperateReceiver) this.postOperateReceiver.getValue();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv6.f45013a.registerReceiver(this, o0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv6.f45013a.unregisterReceiver(this, o0());
        super.onDestroy();
    }

    public final String p0() {
        return (String) this.postSchoolCode.getValue();
    }

    public final String q0() {
        return (String) this.postTagCode.getValue();
    }

    public final String r0() {
        return (String) this.postTitle.getValue();
    }

    public final int s0() {
        return ((Number) this.postType.getValue()).intValue();
    }

    public final String t0() {
        return (String) this.postTypeCode.getValue();
    }

    public final void u0() {
        PostAdapter postAdapter = new PostAdapter(getMViewModel(), s0(), 0.0f, 4, null);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_empty_work, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.emptyView);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.emptyView)");
            if (viewFindViewById.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.4f;
            }
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        postAdapter.o(viewInflate);
        postAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.pv6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PostListActivity.v0(this.f44066a);
            }
        });
        getMViewModel().j().setValue(postAdapter);
    }

    public final void w0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void x0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName(r0());
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.qv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostListActivity.y0(this.f44308a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        bindingTitleBean.setShowRightIcon(s0() == 2);
        bindingTitleBean.setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.rv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostListActivity.z0(this.f44542a, view);
            }
        });
        bindingTitleBean.setRightIconResId(R.mipmap.ic_filter_black);
        mutableLiveDataI.setValue(bindingTitleBean);
    }
}

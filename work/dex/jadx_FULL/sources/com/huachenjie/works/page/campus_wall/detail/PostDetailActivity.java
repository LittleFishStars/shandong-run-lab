package com.huachenjie.works.page.campus_wall.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostDetailBean;
import com.huachenjie.works.databinding.WorksActivityPostDetailBinding;
import com.huachenjie.works.databinding.WorksViewPostDetailHeaderBinding;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.page.campus_wall.detail.PostDetailActivity.a;
import com.huachenjie.works.page.comment.base.BaseCommentFragment;
import com.igexin.push.g.o;
import com.zj.adlib.qk0;
import com.zj.adlib.tv6;
import com.zj.adlib.y6b;
import com.zj.adlib.z88;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.POST_DETAIL)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00013B\u0007¢\u0006\u0004\b1\u00102J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR#\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*R\u001f\u00100\u001a\u00060,R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/detail/PostDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityPostDetailBinding;", "Lcom/huachenjie/works/page/campus_wall/detail/PostDetailViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "n0", "Lcom/huachenjie/works/bean/PostDetailBean;", "detailBean", "m0", "", "b", "Lkotlin/Lazy;", "k0", "()Ljava/lang/String;", "postNo", "", "c", "i0", "()Z", "fromMine", "Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "d", "h0", "()Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "commentFragment", "Lcom/huachenjie/works/databinding/WorksViewPostDetailHeaderBinding;", "kotlin.jvm.PlatformType", "e", "j0", "()Lcom/huachenjie/works/databinding/WorksViewPostDetailHeaderBinding;", "headerBinding", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "f", "l0", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "Lcom/huachenjie/works/page/campus_wall/detail/PostDetailActivity$a;", y6b.f, "g0", "()Lcom/huachenjie/works/page/campus_wall/detail/PostDetailActivity$a;", "clickProxy", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPostDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostDetailActivity.kt\ncom/huachenjie/works/page/campus_wall/detail/PostDetailActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n1549#2:213\n1620#2,3:214\n*S KotlinDebug\n*F\n+ 1 PostDetailActivity.kt\ncom/huachenjie/works/page/campus_wall/detail/PostDetailActivity\n*L\n175#1:213\n175#1:214,3\n*E\n"})
public final class PostDetailActivity extends BaseMVVMActivity<WorksActivityPostDetailBinding, PostDetailViewModel> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy postNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$postNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("postNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromMine = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$fromMine$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m877invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra("fromMine", false));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy commentFragment = LazyKt.lazy(new Function0<BaseCommentFragment>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$commentFragment$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseCommentFragment m876invoke() {
            String appUserCode;
            UserInfoBean userInfo;
            FragmentTransaction fragmentTransactionBeginTransaction = this.this$0.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
            Fragment fragmentFindFragmentByTag = this.this$0.getSupportFragmentManager().findFragmentByTag(BaseCommentFragment.class.getName());
            if (fragmentFindFragmentByTag != null) {
                return (BaseCommentFragment) fragmentFindFragmentByTag;
            }
            BaseCommentFragment.Companion companion = BaseCommentFragment.INSTANCE;
            String strK0 = this.this$0.k0();
            Intrinsics.checkNotNullExpressionValue(strK0, "postNo");
            PostDetailBean value = PostDetailActivity.c0(this.this$0).n().getValue();
            if (value == null || (userInfo = value.getUserInfo()) == null || (appUserCode = userInfo.getAppUserCode()) == null) {
                appUserCode = "";
            }
            String str = appUserCode;
            PostDetailBean value2 = PostDetailActivity.c0(this.this$0).n().getValue();
            int commentCount = value2 != null ? value2.getCommentCount() : 0;
            final PostDetailActivity postDetailActivity = this.this$0;
            BaseCommentFragment baseCommentFragmentA = companion.a(3, strK0, str, commentCount, 10, (32 & 32) != 0 ? false : false, (32 & 64) != 0 ? null : new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$commentFragment$2$fragmentNew$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    PostDetailBean value3 = PostDetailActivity.c0(postDetailActivity).n().getValue();
                    if (value3 != null) {
                        value3.setCommentCount(i);
                    }
                }
            });
            fragmentTransactionBeginTransaction.add(R.id.fl_container, baseCommentFragmentA, BaseCommentFragment.class.getName());
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
            return baseCommentFragmentA;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerBinding = LazyKt.lazy(new Function0<WorksViewPostDetailHeaderBinding>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$headerBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksViewPostDetailHeaderBinding m878invoke() {
            LayoutInflater layoutInflater = this.this$0.getLayoutInflater();
            int i = R.layout.works_view_post_detail_header;
            View view = this.this$0.h0().getView();
            WorksViewPostDetailHeaderBinding worksViewPostDetailHeaderBinding = (WorksViewPostDetailHeaderBinding) DataBindingUtil.inflate(layoutInflater, i, view instanceof ViewGroup ? (ViewGroup) view : null, false);
            worksViewPostDetailHeaderBinding.setVariable(qk0.p0, PostDetailActivity.c0(this.this$0));
            worksViewPostDetailHeaderBinding.setVariable(qk0.k, this.this$0.g0());
            return worksViewPostDetailHeaderBinding;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$stateView$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m880invoke() {
            return StateUtilsKt.a(this.this$0);
        }
    });

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PostDetailActivity.a m875invoke() {
            return this.this$0.new a();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/detail/PostDetailActivity$a;", "", "Landroid/view/View;", "v", "", "a", "c", "b", "d", "<init>", "(Lcom/huachenjie/works/page/campus_wall/detail/PostDetailActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPostDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostDetailActivity.kt\ncom/huachenjie/works/page/campus_wall/detail/PostDetailActivity$ClickProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,212:1\n1#2:213\n*E\n"})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PostDetailActivity.this.onBackPressed();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PostDetailActivity.this.h0().showCommentInput();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PostDetailBean value = PostDetailActivity.c0(PostDetailActivity.this).n().getValue();
            if (value == null || value.getUserInfo().getAnonymous()) {
                return;
            }
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", value.getUserInfo().getAppUserCode()).navigation();
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PostDetailBean value = PostDetailActivity.c0(PostDetailActivity.this).n().getValue();
            if (value != null) {
                PostDetailActivity.c0(PostDetailActivity.this).q(value.getPostNo());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37226a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37226a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37226a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37226a.invoke(obj);
        }
    }

    public static final /* synthetic */ PostDetailViewModel c0(PostDetailActivity postDetailActivity) {
        return postDetailActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.k), g0()), TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().k().observe(this, new b(new Function1<ResultException, Unit>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResultException) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResultException resultException) {
                StateLayout.showError$default(this.this$0.l0(), null, 1, null);
            }
        }));
        getMViewModel().n().observe(this, new b(new Function1<PostDetailBean, Unit>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PostDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PostDetailBean postDetailBean) {
                BaseCommentFragment baseCommentFragmentH0 = this.this$0.h0();
                View root = this.this$0.j0().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "headerBinding.root");
                baseCommentFragmentH0.setHeaderView(root);
                this.this$0.h0().updateCommentCount(postDetailBean.getCommentCount());
                this.this$0.h0().updateAuthCode(postDetailBean.getUserInfo().getAppUserCode());
                PostDetailActivity postDetailActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(postDetailBean, o.f);
                postDetailActivity.m0(postDetailBean);
                StateLayout.showContent$default(this.this$0.l0(), null, 1, null);
            }
        }));
        getMViewModel().o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                ImageBean imageBean;
                if (!Intrinsics.areEqual(bool, Boolean.TRUE) || PostDetailActivity.c0(this.this$0).n().getValue() == null) {
                    return;
                }
                z88 z88Var = z88.f46210a;
                FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                StringBuilder sb = new StringBuilder();
                sb.append('#');
                PostDetailBean value = PostDetailActivity.c0(this.this$0).n().getValue();
                Intrinsics.checkNotNull(value);
                sb.append(value.getTag());
                String string = sb.toString();
                PostDetailBean value2 = PostDetailActivity.c0(this.this$0).n().getValue();
                Intrinsics.checkNotNull(value2);
                String content = value2.getContent();
                PostDetailBean value3 = PostDetailActivity.c0(this.this$0).n().getValue();
                Intrinsics.checkNotNull(value3);
                String postNo = value3.getPostNo();
                PostDetailBean value4 = PostDetailActivity.c0(this.this$0).n().getValue();
                Intrinsics.checkNotNull(value4);
                List<ImageBean> imageList = value4.getImageList();
                String url = (imageList == null || (imageBean = imageList.get(0)) == null) ? null : imageBean.getUrl();
                Resources resources = this.this$0.getResources();
                final PostDetailActivity postDetailActivity = this.this$0;
                z88Var.b(supportFragmentManager, string, content, postNo, url, resources, new ShareDialog.OnShareCallback() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initDataObserve$3.1
                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void a(boolean shareToInternal, @NotNull String shareFlavour) {
                        Intrinsics.checkNotNullParameter(shareFlavour, "shareFlavour");
                        BaseViewModelExtKt.b(PostDetailActivity.c0(postDetailActivity), false, false, null, null, new PostDetailActivity$initDataObserve$3$1$onShare$1(postDetailActivity, shareFlavour, null), 15, null);
                    }

                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void onFailed(@Nullable String str) {
                        ShareDialog.OnShareCallback.a.a(this, str);
                    }

                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void onSuccess() {
                        ShareDialog.OnShareCallback.a.c(this);
                    }
                });
            }
        }));
    }

    public final a g0() {
        return (a) this.clickProxy.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_post_detail;
    }

    public final BaseCommentFragment h0() {
        return (BaseCommentFragment) this.commentFragment.getValue();
    }

    public final boolean i0() {
        return ((Boolean) this.fromMine.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        l0().setFilterContentViewIds(new int[]{R.id.iv_back, R.id.v_head});
        StateLayout.showLoading$default(l0(), null, false, false, 7, null);
        getMViewModel().l().setValue(Boolean.valueOf(i0()));
        PostDetailViewModel mViewModel = getMViewModel();
        String strK0 = k0();
        Intrinsics.checkNotNullExpressionValue(strK0, "postNo");
        mViewModel.m(strK0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        h0();
        n0();
    }

    public final WorksViewPostDetailHeaderBinding j0() {
        return (WorksViewPostDetailHeaderBinding) this.headerBinding.getValue();
    }

    public final String k0() {
        return (String) this.postNo.getValue();
    }

    public final StateLayout l0() {
        return (StateLayout) this.stateView.getValue();
    }

    public final void m0(PostDetailBean detailBean) {
        List<ImageBean> imageList = detailBean.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            return;
        }
        CommonBanner commonBanner = j0().f37107a;
        Intrinsics.checkNotNullExpressionValue(commonBanner, "headerBinding.banner");
        List<ImageBean> imageList2 = detailBean.getImageList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageList2, 10));
        for (ImageBean imageBean : imageList2) {
            arrayList.add(new CommonBannerBean(imageBean.getPath(), imageBean.getWidth(), imageBean.getHeight(), false, 0.0f, 16, null));
        }
        CommonBanner.setImageList$default(commonBanner, this, arrayList, (CommonBannerConfig) null, 4, (Object) null);
    }

    public final void n0() {
        final BLOperateAnimView bLOperateAnimView = getMBinding().f13888a;
        bLOperateAnimView.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initLikeEvent$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.huachenjie.works.external.widget.BLOperateAnimView] */
            public final void invoke(boolean z, int i) {
                PostDetailBean value = PostDetailActivity.c0(this.this$0).n().getValue();
                if (value != null) {
                    ?? r0 = bLOperateAnimView;
                    value.setLikeCount(i);
                    Context context = r0.getContext();
                    if (context != null) {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        tv6.f45013a.a(context, value.getPostNo(), r0.getIsCheckedState(), i);
                    }
                }
            }
        });
    }
}

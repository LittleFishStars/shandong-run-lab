package com.huachenjie.works.page.details.picture;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.huachenjie.works.bean.InteractBean;
import com.huachenjie.works.bean.RecommendGoodsBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.databinding.WorksFragmentPictureWorksDetailBinding;
import com.huachenjie.works.databinding.WorksHeadPictureWorksDetailBinding;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.page.comment.base.BaseCommentFragment;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment.a;
import com.huachenjie.works.page.share.OnShareSuccessCallback;
import com.igexin.push.g.o;
import com.zj.adlib.gv1;
import com.zj.adlib.oz9;
import com.zj.adlib.qk0;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002/0B\u0007¢\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010!\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010%R\u001f\u0010+\u001a\u00060'R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentPictureWorksDetailBinding;", "Lcom/huachenjie/works/page/details/picture/PictureWorksDetailModel;", "", "initLikeAndCollectEvent", "Lcom/huachenjie/works/bean/WorkDetailBean;", "detailBean", "initHeadView", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "initDataObservable", "", "worksNo$delegate", "Lkotlin/Lazy;", "getWorksNo", "()Ljava/lang/String;", yj7.g.WORKS_NO, "Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "commentFragment$delegate", "getCommentFragment", "()Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "commentFragment", "Lcom/huachenjie/works/databinding/WorksHeadPictureWorksDetailBinding;", "kotlin.jvm.PlatformType", "detailHeadBinding$delegate", "getDetailHeadBinding", "()Lcom/huachenjie/works/databinding/WorksHeadPictureWorksDetailBinding;", "detailHeadBinding", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView$delegate", "getStateView", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment$a;", "clickProxy$delegate", "getClickProxy", "()Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment$a;", "clickProxy", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPictureWorksDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PictureWorksDetailFragment.kt\ncom/huachenjie/works/page/details/picture/PictureWorksDetailFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,250:1\n1549#2:251\n1620#2,3:252\n*S KotlinDebug\n*F\n+ 1 PictureWorksDetailFragment.kt\ncom/huachenjie/works/page/details/picture/PictureWorksDetailFragment\n*L\n177#1:251\n177#1:252,3\n*E\n"})
public final class PictureWorksDetailFragment extends BaseMVVMFragment<WorksFragmentPictureWorksDetailBinding, PictureWorksDetailModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_FROM_MINE = "from_mine";

    @NotNull
    private static final String KEY_WORKS_NO = "works_no";

    /* JADX INFO: renamed from: worksNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$worksNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("works_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: commentFragment$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentFragment = LazyKt.lazy(new Function0<BaseCommentFragment>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$commentFragment$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseCommentFragment m926invoke() {
            String appUserCode;
            InteractBean interactInfo;
            UserInfoBean userInfo;
            FragmentTransaction fragmentTransactionBeginTransaction = this.this$0.getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
            Fragment fragmentFindFragmentByTag = this.this$0.getChildFragmentManager().findFragmentByTag(BaseCommentFragment.class.getName());
            if (fragmentFindFragmentByTag != null) {
                return (BaseCommentFragment) fragmentFindFragmentByTag;
            }
            BaseCommentFragment.Companion companion = BaseCommentFragment.INSTANCE;
            String worksNo = this.this$0.getWorksNo();
            Intrinsics.checkNotNullExpressionValue(worksNo, yj7.g.WORKS_NO);
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(this.this$0).m().getValue();
            if (value == null || (userInfo = value.getUserInfo()) == null || (appUserCode = userInfo.getAppUserCode()) == null) {
                appUserCode = "";
            }
            String str = appUserCode;
            WorkDetailBean value2 = PictureWorksDetailFragment.access$getMViewModel(this.this$0).m().getValue();
            int commentCount = (value2 == null || (interactInfo = value2.getInteractInfo()) == null) ? 0 : interactInfo.getCommentCount();
            final PictureWorksDetailFragment pictureWorksDetailFragment = this.this$0;
            BaseCommentFragment baseCommentFragmentA = companion.a(1, worksNo, str, commentCount, 1, (32 & 32) != 0 ? false : false, (32 & 64) != 0 ? null : new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$commentFragment$2$fragmentNew$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    WorkDetailBean value3 = PictureWorksDetailFragment.access$getMViewModel(pictureWorksDetailFragment).m().getValue();
                    if (value3 != null) {
                        PictureWorksDetailFragment pictureWorksDetailFragment2 = pictureWorksDetailFragment;
                        value3.getInteractInfo().setCommentCount(i);
                        PictureWorksDetailFragment.access$getMViewModel(pictureWorksDetailFragment2).i().setValue(value3.formatCommentCount());
                    }
                }
            });
            fragmentTransactionBeginTransaction.add(R.id.fl_container, baseCommentFragmentA, BaseCommentFragment.class.getName());
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
            return baseCommentFragmentA;
        }
    });

    /* JADX INFO: renamed from: detailHeadBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy detailHeadBinding = LazyKt.lazy(new Function0<WorksHeadPictureWorksDetailBinding>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$detailHeadBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksHeadPictureWorksDetailBinding m927invoke() {
            LayoutInflater layoutInflater = this.this$0.getLayoutInflater();
            int i = R.layout.works_head_picture_works_detail;
            View view = this.this$0.getCommentFragment().getView();
            WorksHeadPictureWorksDetailBinding worksHeadPictureWorksDetailBinding = (WorksHeadPictureWorksDetailBinding) DataBindingUtil.inflate(layoutInflater, i, view instanceof ViewGroup ? (ViewGroup) view : null, false);
            worksHeadPictureWorksDetailBinding.setVariable(qk0.p0, PictureWorksDetailFragment.access$getMViewModel(this.this$0));
            worksHeadPictureWorksDetailBinding.setVariable(qk0.k, this.this$0.getClickProxy());
            return worksHeadPictureWorksDetailBinding;
        }
    });

    /* JADX INFO: renamed from: stateView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$stateView$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m928invoke() {
            return StateUtilsKt.c(this.this$0);
        }
    });

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PictureWorksDetailFragment.a m925invoke() {
            return this.this$0.new a();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment$a;", "", "Landroid/view/View;", "v", "", "b", "f", "d", "e", y6b.f, "c", "<init>", "(Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void h(PictureWorksDetailFragment pictureWorksDetailFragment) {
            Intrinsics.checkNotNullParameter(pictureWorksDetailFragment, "this$0");
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(pictureWorksDetailFragment).m().getValue();
            if (value == null) {
                return;
            }
            value.setShareCount(value.getShareCount() + 1);
            WorksFragmentPictureWorksDetailBinding worksFragmentPictureWorksDetailBindingAccess$getMBinding = PictureWorksDetailFragment.access$getMBinding(pictureWorksDetailFragment);
            TextView textView = worksFragmentPictureWorksDetailBindingAccess$getMBinding != null ? worksFragmentPictureWorksDetailBindingAccess$getMBinding.c : null;
            if (textView == null) {
                return;
            }
            textView.setText(value.formatShareCount());
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            FragmentActivity activity = PictureWorksDetailFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        public final void c(@NotNull View v) {
            GoodsRecommendData goodsRecommend;
            Intrinsics.checkNotNullParameter(v, "v");
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(PictureWorksDetailFragment.this).m().getValue();
            if (value == null || (goodsRecommend = value.getGoodsRecommend()) == null) {
                return;
            }
            List<RecommendGoodsBean> list = goodsRecommend.getList();
            PictureWorksDetailFragment pictureWorksDetailFragment = PictureWorksDetailFragment.this;
            if (list.isEmpty()) {
                return;
            }
            if (list.size() == 1) {
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", ((RecommendGoodsBean) CollectionsKt.first(list)).getGoodsNo()).withString("source", "30").withString("traceNo", pictureWorksDetailFragment.getWorksNo()).navigation();
                return;
            }
            Activity activity = gv1.getActivity(pictureWorksDetailFragment.getContext());
            if (activity == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(activity, "ContextUtils.getActivity(context) ?: return@let");
            WorksDetailsGoodsFragment.Companion companion = WorksDetailsGoodsFragment.INSTANCE;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
            String worksNo = pictureWorksDetailFragment.getWorksNo();
            Intrinsics.checkNotNullExpressionValue(worksNo, yj7.g.WORKS_NO);
            companion.a(supportFragmentManager, worksNo, goodsRecommend);
        }

        public final void d(@NotNull View v) {
            String channelNo;
            Intrinsics.checkNotNullParameter(v, "v");
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(PictureWorksDetailFragment.this).m().getValue();
            if (value == null || (channelNo = value.getChannelNo()) == null) {
                channelNo = "";
            }
            ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", channelNo).navigation();
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PictureWorksDetailFragment.this.getCommentFragment().showCommentInput();
        }

        public final void f(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(PictureWorksDetailFragment.this).m().getValue();
            if (value != null) {
                ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", value.getUserInfo().getAppUserCode()).navigation();
            }
        }

        public final void g(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(PictureWorksDetailFragment.this).m().getValue();
            if (value == null) {
                return;
            }
            FragmentManager childFragmentManager = PictureWorksDetailFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            final PictureWorksDetailFragment pictureWorksDetailFragment = PictureWorksDetailFragment.this;
            com.huachenjie.works.page.share.a.c(value, childFragmentManager, new OnShareSuccessCallback() { // from class: com.zj.adlib.lr6
                @Override // com.huachenjie.works.page.share.OnShareSuccessCallback
                public final void a() {
                    PictureWorksDetailFragment.a.h(pictureWorksDetailFragment);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment$b;", "", "", yj7.g.WORKS_NO, "", "fromMine", "Lcom/huachenjie/works/page/details/picture/PictureWorksDetailFragment;", "a", "KEY_FROM_MINE", "Ljava/lang/String;", "KEY_WORKS_NO", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PictureWorksDetailFragment a(@NotNull String worksNo, boolean fromMine) {
            Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
            PictureWorksDetailFragment pictureWorksDetailFragment = new PictureWorksDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PictureWorksDetailFragment.KEY_WORKS_NO, worksNo);
            bundle.putBoolean(PictureWorksDetailFragment.KEY_FROM_MINE, fromMine);
            pictureWorksDetailFragment.setArguments(bundle);
            return pictureWorksDetailFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37266a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37266a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37266a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37266a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentPictureWorksDetailBinding access$getMBinding(PictureWorksDetailFragment pictureWorksDetailFragment) {
        return pictureWorksDetailFragment.getMBinding();
    }

    public static final /* synthetic */ PictureWorksDetailModel access$getMViewModel(PictureWorksDetailFragment pictureWorksDetailFragment) {
        return pictureWorksDetailFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a getClickProxy() {
        return (a) this.clickProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseCommentFragment getCommentFragment() {
        return (BaseCommentFragment) this.commentFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WorksHeadPictureWorksDetailBinding getDetailHeadBinding() {
        return (WorksHeadPictureWorksDetailBinding) this.detailHeadBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateLayout getStateView() {
        return (StateLayout) this.stateView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getWorksNo() {
        return (String) this.worksNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initHeadView(WorkDetailBean detailBean) {
        if (detailBean.getAttachmentInfo().getImageList().isEmpty()) {
            return;
        }
        CommonBanner commonBanner = getDetailHeadBinding().f14376a;
        Intrinsics.checkNotNullExpressionValue(commonBanner, "detailHeadBinding.banner");
        List<WorkImageBean> imageList = detailBean.getAttachmentInfo().getImageList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageList, 10));
        for (WorkImageBean workImageBean : imageList) {
            arrayList.add(new CommonBannerBean(workImageBean.getPath(), workImageBean.getWidth(), workImageBean.getHeight(), workImageBean.getDelFlag(), 0.0f, 16, null));
        }
        CommonBanner.setImageList$default(commonBanner, this, arrayList, (CommonBannerConfig) null, 4, (Object) null);
    }

    private final void initLikeAndCollectEvent() {
        final BLOperateAnimView bLOperateAnimView;
        final BLOperateAnimView bLOperateAnimView2;
        WorksFragmentPictureWorksDetailBinding mBinding = getMBinding();
        if (mBinding != null && (bLOperateAnimView2 = mBinding.f14253a) != null) {
            bLOperateAnimView2.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$initLikeAndCollectEvent$1$1
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
                    WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(this.this$0).m().getValue();
                    if (value != null) {
                        ?? r0 = bLOperateAnimView2;
                        value.getInteractInfo().setCollecteCount(i);
                        Context context = r0.getContext();
                        if (context != null) {
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            oz9.f43864a.b(context, value.getWorksNo(), r0.getIsCheckedState(), i);
                        }
                    }
                }
            });
        }
        WorksFragmentPictureWorksDetailBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (bLOperateAnimView = mBinding2.f14260b) == null) {
            return;
        }
        bLOperateAnimView.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment$initLikeAndCollectEvent$2$1
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
                WorkDetailBean value = PictureWorksDetailFragment.access$getMViewModel(this.this$0).m().getValue();
                if (value != null) {
                    ?? r0 = bLOperateAnimView;
                    value.getInteractInfo().setLikeCount(i);
                    Context context = r0.getContext();
                    if (context != null) {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        oz9.f43864a.c(context, value.getWorksNo(), r0.getIsCheckedState(), i);
                    }
                }
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_picture_works_detail;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.k), getClickProxy()), TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getStateView().setFilterContentViewIds(new int[]{R.id.iv_back, R.id.v_head});
        StateLayout.showLoading$default(getStateView(), null, false, false, 7, null);
        MutableLiveData<Boolean> mutableLiveDataK = getMViewModel().k();
        Bundle arguments = getArguments();
        mutableLiveDataK.setValue(arguments != null ? Boolean.valueOf(arguments.getBoolean(KEY_FROM_MINE)) : Boolean.FALSE);
        PictureWorksDetailModel mViewModel = getMViewModel();
        String worksNo = getWorksNo();
        Intrinsics.checkNotNullExpressionValue(worksNo, yj7.g.WORKS_NO);
        mViewModel.l(worksNo);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().j().observe(this, new c(new Function1<ResultException, Unit>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResultException) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResultException resultException) {
                StateLayout.showError$default(PictureWorksDetailFragment.this.getStateView(), null, 1, null);
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<WorkDetailBean, Unit>() { // from class: com.huachenjie.works.page.details.picture.PictureWorksDetailFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WorkDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WorkDetailBean workDetailBean) {
                BaseCommentFragment commentFragment = PictureWorksDetailFragment.this.getCommentFragment();
                View root = PictureWorksDetailFragment.this.getDetailHeadBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "detailHeadBinding.root");
                commentFragment.setHeaderView(root);
                PictureWorksDetailFragment.this.getCommentFragment().updateCommentCount(workDetailBean.getInteractInfo().getCommentCount());
                PictureWorksDetailFragment.this.getCommentFragment().updateAuthCode(workDetailBean.getUserInfo().getAppUserCode());
                PictureWorksDetailFragment pictureWorksDetailFragment = PictureWorksDetailFragment.this;
                Intrinsics.checkNotNullExpressionValue(workDetailBean, o.f);
                pictureWorksDetailFragment.initHeadView(workDetailBean);
                StateLayout.showContent$default(PictureWorksDetailFragment.this.getStateView(), null, 1, null);
                PictureWorksDetailFragment.access$getMViewModel(PictureWorksDetailFragment.this).i().setValue(workDetailBean.formatCommentCount());
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getCommentFragment();
        initLikeAndCollectEvent();
    }
}

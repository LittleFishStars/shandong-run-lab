package com.huachenjie.works.page.comment.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.coroutines.ViewStubProxy;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.databinding.WorksFragmentBaseCommentBinding;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.base.BaseCommentFragment;
import com.huachenjie.works.page.comment.base.BaseCommentFragment.ClickProxy;
import com.huachenjie.works.page.comment.base.provider.CommentProvider;
import com.huachenjie.works.page.comment.base.provider.CommentReplyProvider;
import com.huachenjie.works.page.comment.report.CommentOptDialog;
import com.igexin.push.g.o;
import com.zj.adlib.qk0;
import com.zj.adlib.ur5;
import com.zj.adlib.zj7;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000267B\u0007¢\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0004R\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001f\u0010-\u001a\u00060)R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u00101¨\u00068"}, d2 = {"Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentBaseCommentBinding;", "Lcom/huachenjie/works/page/comment/base/BaseCommentVM;", "", "initTitleView", "initAdapter", "", "diffCount", "changeCommentCount", "getLayoutResID", "", "getVariables", "initView", "initData", "Landroid/view/View;", "view", "setHeaderView", "count", "updateCommentCount", "", "authCode", "updateAuthCode", "showCommentInput", "commentType$delegate", "Lkotlin/Lazy;", "getCommentType", "()I", "commentType", "bizNo$delegate", "getBizNo", "()Ljava/lang/String;", "bizNo", "commentSource$delegate", "getCommentSource", "commentSource", "commentCount", "I", "Lkotlin/Function1;", "onCountChange", "Lkotlin/jvm/functions/Function1;", "Lcom/huachenjie/works/page/comment/base/BaseCommentFragment$ClickProxy;", "clickProxy$delegate", "getClickProxy", "()Lcom/huachenjie/works/page/comment/base/BaseCommentFragment$ClickProxy;", "clickProxy", "Landroid/widget/TextView;", "titleView$delegate", "getTitleView", "()Landroid/widget/TextView;", "titleView", "<init>", "()V", "Companion", "ClickProxy", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BaseCommentFragment extends BaseMVVMFragment<WorksFragmentBaseCommentBinding, BaseCommentVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_AUTH_CODE = "auth_code";

    @NotNull
    private static final String KEY_BIZ_NO = "biz_no";

    @NotNull
    private static final String KEY_COMMENT_COUNT = "comment_count";

    @NotNull
    private static final String KEY_COMMENT_SOURCE = "comment_source";

    @NotNull
    private static final String KEY_COMMENT_TYPE = "comment_type";

    @NotNull
    private static final String TITLE_FIXED = "title_fixed";
    private int commentCount;

    @Nullable
    private Function1<? super Integer, Unit> onCountChange;

    /* JADX INFO: renamed from: commentType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$commentType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m908invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("comment_type") : 1);
        }
    });

    /* JADX INFO: renamed from: bizNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bizNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$bizNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("biz_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: commentSource$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentSource = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$commentSource$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m907invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("comment_source") : 1);
        }
    });

    /* JADX INFO: renamed from: clickProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clickProxy = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BaseCommentFragment.ClickProxy m906invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    /* JADX INFO: renamed from: titleView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleView = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$titleView$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m909invoke() {
            ViewStubProxy viewStubProxy;
            ViewStub viewStub;
            Bundle arguments = this.this$0.getArguments();
            boolean z = false;
            if (arguments != null && arguments.getBoolean("title_fixed")) {
                z = true;
            }
            if (!z) {
                View viewInflate = this.this$0.getLayoutInflater().inflate(R.layout.works_view_base_comment_title, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) viewInflate;
                textView.setGravity(16);
                return textView;
            }
            WorksFragmentBaseCommentBinding mBinding = this.this$0.getMBinding();
            TextView textView2 = (TextView) ((mBinding == null || (viewStubProxy = mBinding.f36900a) == null || (viewStub = viewStubProxy.getViewStub()) == null) ? null : viewStub.inflate());
            if (textView2 == null) {
                return null;
            }
            textView2.setGravity(17);
            return textView2;
        }
    });

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/comment/base/BaseCommentFragment$ClickProxy;", "", "", "f", "Lcom/huachenjie/works/bean/comment/CommentBean;", "comment", "b", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "replyBean", "e", "Lcom/huachenjie/works/bean/comment/CommentMoreBean;", "moreBean", "d", "", "userId", "a", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "node", "c", "<init>", "(Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", userId).navigation();
        }

        public final void b(@NotNull final CommentBean comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseCommentFragment.this.getString(R.string.works_comment_reply_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_reply_hint)");
            String str = String.format(string, Arrays.copyOf(new Object[]{comment.getUserInfo().getNickName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            CommentInputDialog.Companion companion = CommentInputDialog.INSTANCE;
            int commentType = BaseCommentFragment.this.getCommentType();
            String bizNo = BaseCommentFragment.this.getBizNo();
            Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
            String commentNo = comment.getCommentNo();
            final BaseCommentFragment baseCommentFragment = BaseCommentFragment.this;
            CommentInputDialog commentInputDialogA = companion.a(commentType, bizNo, (16 & 4) != 0 ? null : commentNo, str, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickComment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CommentReplyBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull final CommentReplyBean commentReplyBean) {
                    RecyclerView recyclerView;
                    Intrinsics.checkNotNullParameter(commentReplyBean, "oldReply");
                    BaseCommentAdapter value = BaseCommentFragment.access$getMViewModel(baseCommentFragment).i().getValue();
                    if (value != null) {
                        CommentBean commentBean = comment;
                        BaseCommentFragment baseCommentFragment2 = baseCommentFragment;
                        value.nodeAddData(commentBean, 0, commentReplyBean);
                        WorksFragmentBaseCommentBinding mBinding = baseCommentFragment2.getMBinding();
                        if (mBinding != null && (recyclerView = mBinding.f14176a) != null) {
                            recyclerView.smoothScrollToPosition(value.getItemPosition(commentReplyBean) + value.getHeaderLayoutCount());
                        }
                        baseCommentFragment2.changeCommentCount(1);
                    }
                    CommentUtil commentUtil = CommentUtil.f37253a;
                    Context contextRequireContext = baseCommentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    BaseCommentVM baseCommentVMAccess$getMViewModel = BaseCommentFragment.access$getMViewModel(baseCommentFragment);
                    int commentType2 = baseCommentFragment.getCommentType();
                    final BaseCommentFragment baseCommentFragment3 = baseCommentFragment;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickComment$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m902invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m902invoke() {
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment3).i().getValue();
                            if (value2 != null) {
                                CommentReplyBean commentReplyBean2 = commentReplyBean;
                                commentReplyBean2.setPublishStatus(1);
                                int itemPosition = value2.getItemPosition(commentReplyBean2);
                                if (itemPosition > -1) {
                                    value2.notifyItemChanged(itemPosition + value2.getHeaderLayoutCount());
                                }
                            }
                        }
                    };
                    final BaseCommentFragment baseCommentFragment4 = baseCommentFragment;
                    final CommentBean commentBean2 = comment;
                    commentUtil.g(contextRequireContext, baseCommentVMAccess$getMViewModel, commentReplyBean, (8 & 8) != 0 ? false : false, commentType2, (8 & 32) != 0 ? null : function0, new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickComment$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CommentReplyBean) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull CommentReplyBean commentReplyBean2) {
                            Intrinsics.checkNotNullParameter(commentReplyBean2, "newReply");
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment4).i().getValue();
                            if (value2 != null) {
                                CommentBean commentBean3 = commentBean2;
                                CommentReplyBean commentReplyBean3 = commentReplyBean;
                                List<BaseNode> childNode = commentBean3.getChildNode();
                                int iIndexOf = childNode != null ? childNode.indexOf(commentReplyBean3) : -1;
                                if (iIndexOf > -1) {
                                    value2.nodeSetData(commentBean3, iIndexOf, commentReplyBean2);
                                }
                            }
                        }
                    });
                }
            });
            FragmentManager childFragmentManager = BaseCommentFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            commentInputDialogA.show(childFragmentManager, CommentInputDialog.class.getSimpleName());
        }

        public final void c(@NotNull final BaseNode node) {
            String string;
            Intrinsics.checkNotNullParameter(node, "node");
            Bundle arguments = BaseCommentFragment.this.getArguments();
            if (arguments == null || (string = arguments.getString(BaseCommentFragment.KEY_AUTH_CODE)) == null) {
                string = "";
            }
            String str = string;
            if (node instanceof CommentBean) {
                CommentOptDialog.Companion companion = CommentOptDialog.INSTANCE;
                int commentType = BaseCommentFragment.this.getCommentType();
                CommentBean commentBean = (CommentBean) node;
                String commentNo = commentBean.getCommentNo();
                String appUserCode = commentBean.getUserInfo().getAppUserCode();
                final BaseCommentFragment baseCommentFragment = BaseCommentFragment.this;
                CommentOptDialog commentOptDialogA = companion.a(commentType, commentNo, str, appUserCode, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickCommentOpt$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        BaseCommentAdapter value = BaseCommentFragment.access$getMViewModel(baseCommentFragment).i().getValue();
                        if (value != null) {
                            value.remove(node);
                        }
                        baseCommentFragment.changeCommentCount(-i);
                    }
                });
                FragmentManager childFragmentManager = BaseCommentFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                commentOptDialogA.show(childFragmentManager, CommentOptDialog.class.getSimpleName());
                return;
            }
            if (node instanceof CommentReplyBean) {
                CommentOptDialog.Companion companion2 = CommentOptDialog.INSTANCE;
                int commentType2 = BaseCommentFragment.this.getCommentType();
                CommentReplyBean commentReplyBean = (CommentReplyBean) node;
                String commentNo2 = commentReplyBean.getCommentNo();
                String appUserCode2 = commentReplyBean.getUserInfo().getAppUserCode();
                final BaseCommentFragment baseCommentFragment2 = BaseCommentFragment.this;
                CommentOptDialog commentOptDialogA2 = companion2.a(commentType2, commentNo2, str, appUserCode2, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickCommentOpt$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        BaseNode baseNode;
                        int iFindParentNode;
                        BaseCommentAdapter value = BaseCommentFragment.access$getMViewModel(baseCommentFragment2).i().getValue();
                        if (value != null && (iFindParentNode = value.findParentNode((baseNode = node))) >= 0) {
                            value.nodeRemoveData(value.getItem(iFindParentNode), baseNode);
                        }
                        baseCommentFragment2.changeCommentCount(-i);
                    }
                });
                FragmentManager childFragmentManager2 = BaseCommentFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                commentOptDialogA2.show(childFragmentManager2, CommentOptDialog.class.getSimpleName());
            }
        }

        public final void d(@NotNull CommentBean comment, @NotNull CommentMoreBean moreBean) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(moreBean, "moreBean");
            BaseCommentFragment.access$getMViewModel(BaseCommentFragment.this).n(comment, moreBean, BaseCommentFragment.this.getCommentType());
        }

        public final void e(@NotNull final CommentBean comment, @NotNull CommentReplyBean replyBean) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(replyBean, "replyBean");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseCommentFragment.this.getString(R.string.works_comment_reply_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_reply_hint)");
            String str = String.format(string, Arrays.copyOf(new Object[]{replyBean.getUserInfo().getNickName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            CommentInputDialog.Companion companion = CommentInputDialog.INSTANCE;
            int commentType = BaseCommentFragment.this.getCommentType();
            String bizNo = BaseCommentFragment.this.getBizNo();
            Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
            String commentNo = replyBean.getCommentNo();
            final BaseCommentFragment baseCommentFragment = BaseCommentFragment.this;
            CommentInputDialog commentInputDialogA = companion.a(commentType, bizNo, (16 & 4) != 0 ? null : commentNo, str, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickReply$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CommentReplyBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull final CommentReplyBean commentReplyBean) {
                    RecyclerView recyclerView;
                    Intrinsics.checkNotNullParameter(commentReplyBean, "oldReply");
                    BaseCommentAdapter value = BaseCommentFragment.access$getMViewModel(baseCommentFragment).i().getValue();
                    if (value != null) {
                        CommentBean commentBean = comment;
                        BaseCommentFragment baseCommentFragment2 = baseCommentFragment;
                        value.nodeAddData(commentBean, 0, commentReplyBean);
                        WorksFragmentBaseCommentBinding mBinding = baseCommentFragment2.getMBinding();
                        if (mBinding != null && (recyclerView = mBinding.f14176a) != null) {
                            recyclerView.smoothScrollToPosition(value.getItemPosition(commentReplyBean) + value.getHeaderLayoutCount());
                        }
                        baseCommentFragment2.changeCommentCount(1);
                    }
                    CommentUtil commentUtil = CommentUtil.f37253a;
                    Context contextRequireContext = baseCommentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    BaseCommentVM baseCommentVMAccess$getMViewModel = BaseCommentFragment.access$getMViewModel(baseCommentFragment);
                    int commentType2 = baseCommentFragment.getCommentType();
                    final BaseCommentFragment baseCommentFragment3 = baseCommentFragment;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickReply$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m903invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m903invoke() {
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment3).i().getValue();
                            if (value2 != null) {
                                CommentReplyBean commentReplyBean2 = commentReplyBean;
                                commentReplyBean2.setPublishStatus(1);
                                int itemPosition = value2.getItemPosition(commentReplyBean2);
                                if (itemPosition > -1) {
                                    value2.notifyItemChanged(itemPosition + value2.getHeaderLayoutCount());
                                }
                            }
                        }
                    };
                    final BaseCommentFragment baseCommentFragment4 = baseCommentFragment;
                    final CommentBean commentBean2 = comment;
                    commentUtil.g(contextRequireContext, baseCommentVMAccess$getMViewModel, commentReplyBean, (8 & 8) != 0 ? false : false, commentType2, (8 & 32) != 0 ? null : function0, new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$clickReply$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CommentReplyBean) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull CommentReplyBean commentReplyBean2) {
                            Intrinsics.checkNotNullParameter(commentReplyBean2, "newReply");
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment4).i().getValue();
                            if (value2 != null) {
                                CommentBean commentBean3 = commentBean2;
                                CommentReplyBean commentReplyBean3 = commentReplyBean;
                                List<BaseNode> childNode = commentBean3.getChildNode();
                                int iIndexOf = childNode != null ? childNode.indexOf(commentReplyBean3) : -1;
                                if (iIndexOf > -1) {
                                    value2.nodeSetData(commentBean3, iIndexOf, commentReplyBean2);
                                }
                            }
                        }
                    });
                }
            });
            FragmentManager childFragmentManager = BaseCommentFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            commentInputDialogA.show(childFragmentManager, CommentInputDialog.class.getSimpleName());
        }

        public final void f() {
            CommentInputDialog.Companion companion = CommentInputDialog.INSTANCE;
            int commentType = BaseCommentFragment.this.getCommentType();
            String bizNo = BaseCommentFragment.this.getBizNo();
            Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
            String string = BaseCommentFragment.this.getString(R.string.works_comment_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_hint)");
            final BaseCommentFragment baseCommentFragment = BaseCommentFragment.this;
            CommentInputDialog commentInputDialogA = companion.a(commentType, bizNo, (16 & 4) != 0 ? null : null, string, (16 & 16) != 0 ? null : new Function1<CommentBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$comment$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CommentBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull final CommentBean commentBean) {
                    RecyclerView recyclerView;
                    Intrinsics.checkNotNullParameter(commentBean, "oldComment");
                    BaseCommentAdapter value = BaseCommentFragment.access$getMViewModel(baseCommentFragment).i().getValue();
                    if (value != null) {
                        BaseCommentFragment baseCommentFragment2 = baseCommentFragment;
                        value.addData(0, (BaseNode) commentBean);
                        if (value.getData().size() == 1) {
                            BaseLoadMoreModule.loadMoreEnd$default(value.getLoadMoreModule(), false, 1, null);
                        }
                        WorksFragmentBaseCommentBinding mBinding = baseCommentFragment2.getMBinding();
                        if (mBinding != null && (recyclerView = mBinding.f14176a) != null) {
                            recyclerView.smoothScrollToPosition(value.getHeaderLayoutCount() + 0);
                        }
                        baseCommentFragment2.changeCommentCount(1);
                    }
                    CommentUtil commentUtil = CommentUtil.f37253a;
                    Context contextRequireContext = baseCommentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    BaseCommentVM baseCommentVMAccess$getMViewModel = BaseCommentFragment.access$getMViewModel(baseCommentFragment);
                    int commentType2 = baseCommentFragment.getCommentType();
                    final BaseCommentFragment baseCommentFragment3 = baseCommentFragment;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$comment$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m904invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m904invoke() {
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment3).i().getValue();
                            if (value2 != null) {
                                CommentBean commentBean2 = commentBean;
                                commentBean2.setPublishStatus(1);
                                int itemPosition = value2.getItemPosition(commentBean2);
                                if (itemPosition > -1) {
                                    value2.notifyItemChanged(itemPosition + value2.getHeaderLayoutCount());
                                }
                            }
                        }
                    };
                    final BaseCommentFragment baseCommentFragment4 = baseCommentFragment;
                    commentUtil.e(contextRequireContext, baseCommentVMAccess$getMViewModel, commentBean, commentType2, function0, new Function1<CommentBean, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment$ClickProxy$comment$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CommentBean) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull CommentBean commentBean2) {
                            int itemPosition;
                            Intrinsics.checkNotNullParameter(commentBean2, "newComment");
                            BaseCommentAdapter value2 = BaseCommentFragment.access$getMViewModel(baseCommentFragment4).i().getValue();
                            if (value2 == null || (itemPosition = value2.getItemPosition(commentBean)) <= -1) {
                                return;
                            }
                            value2.setData(itemPosition, (BaseNode) commentBean2);
                        }
                    });
                }
            }, (16 & 32) != 0 ? null : null);
            FragmentManager childFragmentManager = BaseCommentFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            commentInputDialogA.show(childFragmentManager, CommentInputDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.comment.base.BaseCommentFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JP\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/comment/base/BaseCommentFragment$a;", "", "", "commentType", "", "bizNo", "authCode", "commentCount", "commentSource", "", "titleFixed", "Lkotlin/Function1;", "", "onCountChange", "Lcom/huachenjie/works/page/comment/base/BaseCommentFragment;", "a", "KEY_AUTH_CODE", "Ljava/lang/String;", "KEY_BIZ_NO", "KEY_COMMENT_COUNT", "KEY_COMMENT_SOURCE", "KEY_COMMENT_TYPE", "TITLE_FIXED", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BaseCommentFragment a(int commentType, @NotNull String bizNo, @NotNull String authCode, int commentCount, int commentSource, boolean titleFixed, @Nullable Function1<? super Integer, Unit> onCountChange) {
            Intrinsics.checkNotNullParameter(bizNo, "bizNo");
            Intrinsics.checkNotNullParameter(authCode, "authCode");
            BaseCommentFragment baseCommentFragment = new BaseCommentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(BaseCommentFragment.KEY_COMMENT_TYPE, commentType);
            bundle.putString(BaseCommentFragment.KEY_BIZ_NO, bizNo);
            bundle.putString(BaseCommentFragment.KEY_AUTH_CODE, authCode);
            bundle.putInt(BaseCommentFragment.KEY_COMMENT_COUNT, commentCount);
            bundle.putInt(BaseCommentFragment.KEY_COMMENT_SOURCE, commentSource);
            bundle.putBoolean(BaseCommentFragment.TITLE_FIXED, titleFixed);
            baseCommentFragment.setArguments(bundle);
            baseCommentFragment.onCountChange = onCountChange;
            return baseCommentFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37250a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37250a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37250a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37250a.invoke(obj);
        }
    }

    public static final /* synthetic */ BaseCommentVM access$getMViewModel(BaseCommentFragment baseCommentFragment) {
        return baseCommentFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeCommentCount(int diffCount) {
        int i = this.commentCount + diffCount;
        this.commentCount = i;
        if (i < 0) {
            this.commentCount = 0;
        }
        initTitleView();
        Function1<? super Integer, Unit> function1 = this.onCountChange;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.commentCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBizNo() {
        return (String) this.bizNo.getValue();
    }

    private final ClickProxy getClickProxy() {
        return (ClickProxy) this.clickProxy.getValue();
    }

    private final int getCommentSource() {
        return ((Number) this.commentSource.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCommentType() {
        return ((Number) this.commentType.getValue()).intValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.titleView.getValue();
    }

    private final void initAdapter() {
        CommentProvider commentProvider = new CommentProvider(getCommentType(), getCommentSource(), new BaseCommentFragment$initAdapter$commentProvider$1(getClickProxy()), new BaseCommentFragment$initAdapter$commentProvider$2(getClickProxy()), new BaseCommentFragment$initAdapter$commentProvider$3(getClickProxy()));
        CommentReplyProvider commentReplyProvider = new CommentReplyProvider(getCommentType(), getCommentSource(), new BaseCommentFragment$initAdapter$commentReplyProvider$1(getClickProxy()), new BaseCommentFragment$initAdapter$commentReplyProvider$2(getClickProxy()), new BaseCommentFragment$initAdapter$commentReplyProvider$3(getClickProxy()));
        ur5 ur5Var = new ur5(new BaseCommentFragment$initAdapter$moreProvider$1(getClickProxy()));
        MutableLiveData<BaseCommentAdapter> mutableLiveDataI = getMViewModel().i();
        BaseCommentAdapter baseCommentAdapter = new BaseCommentAdapter(commentProvider, commentReplyProvider, ur5Var);
        baseCommentAdapter.setHeaderWithEmptyEnable(true);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        viewInflate.setPadding(0, SizeUtils.b(80.0f), 0, 0);
        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText(getString(R.string.works_comment_no_data));
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…o_data)\n                }");
        baseCommentAdapter.setEmptyView(viewInflate);
        baseCommentAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.tn0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                BaseCommentFragment.initAdapter$lambda$3$lambda$2(this.f44959a);
            }
        });
        mutableLiveDataI.setValue(baseCommentAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(BaseCommentFragment baseCommentFragment) {
        Intrinsics.checkNotNullParameter(baseCommentFragment, "this$0");
        BaseCommentVM mViewModel = baseCommentFragment.getMViewModel();
        String bizNo = baseCommentFragment.getBizNo();
        Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
        mViewModel.m(bizNo, baseCommentFragment.getCommentType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTitleView() {
        LinearLayout headerLayout;
        Sequence<View> children;
        LinearLayout headerLayout2;
        TextView titleView = getTitleView();
        if (titleView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.works_comment_count);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_count)");
            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.commentCount)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            titleView.setText(str);
            Bundle arguments = getArguments();
            if (arguments != null && arguments.getBoolean(TITLE_FIXED)) {
                return;
            }
            BaseCommentAdapter value = getMViewModel().i().getValue();
            int childCount = (value == null || (headerLayout2 = value.getHeaderLayout()) == null) ? 0 : headerLayout2.getChildCount();
            if (childCount == 0) {
                BaseCommentAdapter value2 = getMViewModel().i().getValue();
                if (value2 != null) {
                    Intrinsics.checkNotNullExpressionValue(value2, "value");
                    BaseQuickAdapter.setHeaderView$default(value2, titleView, 0, 0, 4, null);
                    return;
                }
                return;
            }
            if (childCount != 1) {
                BaseCommentAdapter value3 = getMViewModel().i().getValue();
                if (value3 != null) {
                    Intrinsics.checkNotNullExpressionValue(value3, "value");
                    BaseQuickAdapter.setHeaderView$default(value3, titleView, 1, 0, 4, null);
                    return;
                }
                return;
            }
            BaseCommentAdapter value4 = getMViewModel().i().getValue();
            if ((value4 == null || (headerLayout = value4.getHeaderLayout()) == null || (children = ViewGroupKt.getChildren(headerLayout)) == null || !SequencesKt.contains(children, titleView)) ? false : true) {
                BaseCommentAdapter value5 = getMViewModel().i().getValue();
                if (value5 != null) {
                    Intrinsics.checkNotNullExpressionValue(value5, "value");
                    BaseQuickAdapter.setHeaderView$default(value5, titleView, 0, 0, 4, null);
                    return;
                }
                return;
            }
            BaseCommentAdapter value6 = getMViewModel().i().getValue();
            if (value6 != null) {
                Intrinsics.checkNotNullExpressionValue(value6, "value");
                BaseQuickAdapter.addHeaderView$default(value6, titleView, 1, 0, 4, null);
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_base_comment;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, BaseCommentVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().j().observe(this, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.comment.base.BaseCommentFragment.initData.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                if (num.intValue() <= 0 || num.intValue() <= BaseCommentFragment.this.commentCount) {
                    return;
                }
                BaseCommentFragment.this.commentCount = num.intValue();
                BaseCommentFragment.this.initTitleView();
                Function1 function1 = BaseCommentFragment.this.onCountChange;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(BaseCommentFragment.this.commentCount));
                }
            }
        }));
        BaseCommentVM mViewModel = getMViewModel();
        String bizNo = getBizNo();
        Intrinsics.checkNotNullExpressionValue(bizNo, "bizNo");
        mViewModel.m(bizNo, getCommentType());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        Bundle arguments = getArguments();
        this.commentCount = arguments != null ? arguments.getInt(KEY_COMMENT_COUNT) : 0;
        initAdapter();
        initTitleView();
    }

    public final void setHeaderView(@NotNull View view) {
        Sequence<View> children;
        Intrinsics.checkNotNullParameter(view, "view");
        BaseCommentAdapter value = getMViewModel().i().getValue();
        if (value != null) {
            LinearLayout headerLayout = value.getHeaderLayout();
            boolean z = false;
            int childCount = headerLayout != null ? headerLayout.getChildCount() : 0;
            if (childCount == 0) {
                BaseQuickAdapter.setHeaderView$default(value, view, 0, 0, 4, null);
                return;
            }
            if (childCount != 1) {
                BaseQuickAdapter.setHeaderView$default(value, view, 0, 0, 4, null);
                return;
            }
            if (getTitleView() != null) {
                LinearLayout headerLayout2 = value.getHeaderLayout();
                if (headerLayout2 != null && (children = ViewGroupKt.getChildren(headerLayout2)) != null) {
                    TextView titleView = getTitleView();
                    Intrinsics.checkNotNull(titleView);
                    if (SequencesKt.contains(children, titleView)) {
                        z = true;
                    }
                }
                if (z) {
                    BaseQuickAdapter.addHeaderView$default(value, view, 0, 0, 4, null);
                    return;
                }
            }
            BaseQuickAdapter.setHeaderView$default(value, view, 0, 0, 4, null);
        }
    }

    public final void showCommentInput() {
        getClickProxy().f();
    }

    public final void updateAuthCode(@NotNull String authCode) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString(KEY_AUTH_CODE, authCode);
        }
    }

    public final void updateCommentCount(int count) {
        this.commentCount = count;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putInt(KEY_COMMENT_COUNT, count);
        }
        TextView titleView = getTitleView();
        if (titleView == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.works_comment_count);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_count)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.commentCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        titleView.setText(str);
    }
}

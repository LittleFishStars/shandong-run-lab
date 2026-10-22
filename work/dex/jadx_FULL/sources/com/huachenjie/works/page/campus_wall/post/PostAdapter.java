package com.huachenjie.works.page.campus_wall.post;

import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCommentBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.databinding.WorksItemPostBinding;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.huachenjie.works.page.comment.CommentDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.cs6;
import com.zj.adlib.gv1;
import com.zj.adlib.i4a;
import com.zj.adlib.jj8;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zz8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B#\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\b\u0002\u0010$\u001a\u00020\u0018\u0012\b\b\u0002\u0010'\u001a\u00020%¢\u0006\u0004\b.\u0010/J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u001b\u0010+\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010,¨\u00060"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/post/PostAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/works/bean/PostItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "Landroid/view/View;", "view", j.b, "p", "n", "Landroid/widget/TextView;", "textView", "", "tag", "content", "r", "", "index", "Lcom/huachenjie/works/databinding/WorksItemPostBinding;", "binding", "q", t.d, "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "a", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "viewModel", "K", "I", "postType", "", "F", "firstItemTopMargin", "Lkotlin/Lazy;", "m", "()I", "firstTopMargin", "Landroid/view/View;", "mEmptyView", "<init>", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;IF)V", "works_release"}, k = 1, mv = {1, 8, 0})
public class PostAdapter extends BaseMultiItemQuickAdapter<PostItemBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int postType;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final float firstItemTopMargin;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final BaseViewModel viewModel;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy firstTopMargin;

    public /* synthetic */ PostAdapter(BaseViewModel baseViewModel, int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseViewModel, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0.0f : f);
    }

    public static final void g(PostAdapter postAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(postAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        ARouter.getInstance().build(zj7.i.POST_DETAIL).withString("postNo", ((PostItemBean) postAdapter.getData().get(i)).getPostInfo().getPostNo()).navigation();
    }

    public static final void h(final PostAdapter postAdapter, final BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        FragmentManager fragmentManagerB;
        Intrinsics.checkNotNullParameter(postAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        final PostItemBean postItemBean = (PostItemBean) postAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ivAvatar) {
            if (postItemBean.getUserInfo().getAnonymous()) {
                return;
            }
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", postItemBean.getUserInfo().getAppUserCode()).navigation();
        } else {
            if (id == R.id.llShare) {
                FragmentManager fragmentManagerB2 = gv1.b(view.getContext());
                if (fragmentManagerB2 != null) {
                    BaseViewModelExtKt.b(postAdapter.viewModel, true, false, null, null, new PostAdapter$2$1$1(postItemBean, fragmentManagerB2, view, postAdapter, null), 14, null);
                    return;
                }
                return;
            }
            if (id != R.id.v_comment_container || (fragmentManagerB = gv1.b(view.getContext())) == null) {
                return;
            }
            CommentDialog.INSTANCE.a(3, postItemBean.getPostInfo().getPostNo(), postItemBean.getUserInfo().getAppUserCode(), postItemBean.getComment().getTotal(), 9, true, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.campus_wall.post.PostAdapter$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    if (postItemBean.getComment().getTotal() != i2) {
                        postItemBean.getComment().setTotal(i2);
                        baseQuickAdapter.notifyItemChanged(i + postAdapter.getHeaderLayoutCount());
                    }
                }
            }).show(fragmentManagerB, CommentDialog.class.getName());
        }
    }

    public final TextView l(int index, WorksItemPostBinding binding) {
        if (index == 0) {
            return binding.f14622c.f37100a;
        }
        if (index == 1) {
            return binding.f14624e.f37100a;
        }
        if (index == 2) {
            return binding.f14623d.f37100a;
        }
        if (index == 3) {
            return binding.f14620b.f37100a;
        }
        if (index != 4) {
            return null;
        }
        return binding.f14615a.f37100a;
    }

    public final int m() {
        return ((Number) this.firstTopMargin.getValue()).intValue();
    }

    public final void n() {
        removeEmptyView();
    }

    public final void o(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.works.page.campus_wall.post.PostAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (PostAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        i4a.c("position:" + childAdapterPosition);
                        if (childAdapterPosition != 1) {
                            outRect.set(0, 0, 0, 0);
                        } else {
                            outRect.set(0, PostAdapter.this.m(), 0, 0);
                        }
                        break;
                }
            }
        });
    }

    public final void p() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    public final void q(int index, WorksItemPostBinding binding, PostItemBean item) {
        TextView textViewL;
        if (item.showCommentUser(index) && (textViewL = l(index, binding)) != null) {
            PostCommentBean postCommentBeanFindCommentUse = item.findCommentUse(index);
            String str = postCommentBeanFindCommentUse.getUserInfo().getNickName() + (char) 65306;
            SpannableString spannableString = new SpannableString(" " + str + postCommentBeanFindCommentUse.getContent());
            spannableString.setSpan(new cs6(SizeUtils.b(24.0f)), 0, 1, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#757979")), 1, str.length() + 1, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#191F20")), 1 + str.length(), spannableString.length(), 33);
            textViewL.setText(spannableString);
        }
    }

    public final void r(TextView textView, String tag, String content) {
        SpannableString spannableString = new SpannableString(tag + content);
        spannableString.setSpan(new zz8(Color.parseColor("#FF9118"), -1, jj8.e(12.0f, getContext()), SizeUtils.b(18.0f), SizeUtils.b(8.0f), SizeUtils.b(9.0f), SizeUtils.b(4.0f)), 0, tag.length(), 33);
        textView.setText(spannableString);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostAdapter(@NotNull BaseViewModel baseViewModel, int i, float f) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(baseViewModel, "viewModel");
        this.viewModel = baseViewModel;
        this.postType = i;
        this.firstItemTopMargin = f;
        addItemType(0, R.layout.works_item_post);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.jv6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                PostAdapter.g(this.f42681a, baseQuickAdapter, view, i2);
            }
        }, 1, null);
        addChildClickViewIds(R.id.ivAvatar, R.id.llShare, R.id.v_comment_container);
        y57.b(this, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.kv6
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                PostAdapter.h(this.f42919a, baseQuickAdapter, view, i2);
            }
        }, 1, null);
        this.firstTopMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.campus_wall.post.PostAdapter$firstTopMargin$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m884invoke() {
                return Integer.valueOf(jj8.a(this.this$0.firstItemTopMargin));
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull final PostItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int postType = item.getPostType();
            if (postType == 0 || postType == 1) {
                WorksItemPostBinding worksItemPostBinding = (WorksItemPostBinding) dataBinding;
                TextView textView = worksItemPostBinding.b;
                Intrinsics.checkNotNullExpressionValue(textView, "tvContent");
                r(textView, '#' + item.getPostInfo().getTag(), item.getPostInfo().getContent());
                q(0, worksItemPostBinding, item);
                q(1, worksItemPostBinding, item);
                q(2, worksItemPostBinding, item);
                q(3, worksItemPostBinding, item);
                q(4, worksItemPostBinding, item);
                worksItemPostBinding.f14616a.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.campus_wall.post.PostAdapter$convert$1$1$1
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z, int i) {
                        item.setLiked(z, i);
                    }
                });
                worksItemPostBinding.m(Integer.valueOf(getItemPosition(item)));
                worksItemPostBinding.n(Integer.valueOf(this.postType));
                worksItemPostBinding.o(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}

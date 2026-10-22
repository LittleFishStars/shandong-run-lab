package com.huachenjie.mine.page.home.post;

import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineItemPostBinding;
import com.huachenjie.mine.page.home.post.MyPostAdapter;
import com.huachenjie.works.bean.PostItemBean;
import com.zj.adlib.jj8;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import com.zj.adlib.zz8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mine/page/home/post/MyPostAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/PostItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mine/databinding/MineItemPostBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.g, "i", y6b.f, "Landroid/widget/TextView;", "textView", "", "tag", "content", "j", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyPostAdapter extends BaseQuickAdapter<PostItemBean, BaseDataBindingHolder<MineItemPostBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public MyPostAdapter() {
        super(R.layout.mine_item_post, null, 2, null);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.av5
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyPostAdapter.f(this.f40619a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void f(MyPostAdapter myPostAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(myPostAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        ARouter.getInstance().build(zj7.i.POST_DETAIL).withString("postNo", myPostAdapter.getData().get(i).getPostInfo().getPostNo()).withBoolean("fromMine", true).navigation();
    }

    public final void g() {
        removeEmptyView();
    }

    public final void h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void i() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    public final void j(TextView textView, String tag, String content) {
        SpannableString spannableString = new SpannableString(tag + content);
        spannableString.setSpan(new zz8(Color.parseColor("#FF762F"), -1, jj8.e(12.0f, getContext()), SizeUtils.b(18.0f), SizeUtils.b(8.0f), SizeUtils.b(9.0f), SizeUtils.b(4.0f)), 0, tag.length(), 33);
        textView.setText(spannableString);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MineItemPostBinding> holder, @NotNull PostItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MineItemPostBinding mineItemPostBinding = (MineItemPostBinding) holder.getDataBinding();
        if (mineItemPostBinding != null) {
            TextView textView = mineItemPostBinding.f35347a;
            Intrinsics.checkNotNullExpressionValue(textView, "tvContent");
            j(textView, item.getPostInfo().getTag(), item.getPostInfo().getContent());
            mineItemPostBinding.k(item);
            mineItemPostBinding.executePendingBindings();
        }
    }
}

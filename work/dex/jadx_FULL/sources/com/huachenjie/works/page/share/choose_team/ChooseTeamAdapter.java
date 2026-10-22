package com.huachenjie.works.page.share.choose_team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.bean.ChatTeamHeaderBean;
import com.huachenjie.works.databinding.WorksItemChooseTeamBinding;
import com.huachenjie.works.databinding.WorksItemChooseTeamHeadreBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "", "f", "i", y6b.g, "Landroid/view/View;", y6b.f, "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseTeamAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseDataBindingHolder<ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public ChooseTeamAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.works_item_choose_team);
        addItemType(1, R.layout.works_item_choose_team_headre);
    }

    public final int f() {
        return R.layout.layout_empty_chat_team;
    }

    public final View g() {
        if (this.mEmptyView == null) {
            this.mEmptyView = LayoutInflater.from(getContext()).inflate(f(), (ViewGroup) null);
        }
        return this.mEmptyView;
    }

    public final void h() {
        removeEmptyView();
    }

    public final void i() {
        if (hasEmptyView() || g() == null) {
            return;
        }
        View viewG = g();
        Intrinsics.checkNotNull(viewG);
        setEmptyView(viewG);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull MultiItemEntity item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int postType = item.getPostType();
            if (postType == 0) {
                ((WorksItemChooseTeamBinding) dataBinding).k((ChatTeamBean) item);
            } else if (postType == 1) {
                ((WorksItemChooseTeamHeadreBinding) dataBinding).k((ChatTeamHeaderBean) item);
            }
            dataBinding.executePendingBindings();
        }
    }
}

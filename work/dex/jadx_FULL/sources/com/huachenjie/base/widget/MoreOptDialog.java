package com.huachenjie.base.widget;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.databinding.BaseDialogMoreOptBinding;
import com.huachenjie.base.databinding.BaseItemMoreOptBinding;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.zj.adlib.sk0;
import com.zj.adlib.y57;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R*\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/base/widget/MoreOptDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/base/databinding/BaseDialogMoreOptBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "Lkotlin/Function2;", "Lcom/huachenjie/base/bean/MoreOptBean;", "onMenuClickListener", "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Companion", "a", "MoreOptAdapter", "base_release"}, k = 1, mv = {1, 8, 0})
public final class MoreOptDialog extends BaseMVVMBottomDialogFragment<BaseDialogMoreOptBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_MENUS = "menus";

    @Nullable
    private Function2<? super MoreOptBean, ? super Integer, Unit> onMenuClickListener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/widget/MoreOptDialog$MoreOptAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/MoreOptBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/base/databinding/BaseItemMoreOptBinding;", "()V", "convert", "", "holder", "item", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MoreOptAdapter extends BaseQuickAdapter<MoreOptBean, BaseDataBindingHolder<BaseItemMoreOptBinding>> {
        public MoreOptAdapter() {
            super(R.layout.base_item_more_opt, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(@NotNull BaseDataBindingHolder<BaseItemMoreOptBinding> holder, @NotNull MoreOptBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            BaseItemMoreOptBinding baseItemMoreOptBinding = (BaseItemMoreOptBinding) holder.getDataBinding();
            if (baseItemMoreOptBinding != null) {
                baseItemMoreOptBinding.setVariable(sk0.g, item);
                baseItemMoreOptBinding.executePendingBindings();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.widget.MoreOptDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/base/widget/MoreOptDialog$a;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/base/bean/MoreOptBean;", "Lkotlin/collections/ArrayList;", MoreOptDialog.KEY_MENUS, "Lkotlin/Function2;", "", "", "onMenuClickListener", "Lcom/huachenjie/base/widget/MoreOptDialog;", "a", "", "KEY_MENUS", "Ljava/lang/String;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MoreOptDialog a(@NotNull ArrayList<MoreOptBean> menus, @NotNull Function2<? super MoreOptBean, ? super Integer, Unit> onMenuClickListener) {
            Intrinsics.checkNotNullParameter(menus, MoreOptDialog.KEY_MENUS);
            Intrinsics.checkNotNullParameter(onMenuClickListener, "onMenuClickListener");
            MoreOptDialog moreOptDialog = new MoreOptDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(MoreOptDialog.KEY_MENUS, menus);
            moreOptDialog.setArguments(bundle);
            moreOptDialog.onMenuClickListener = onMenuClickListener;
            return moreOptDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(MoreOptDialog moreOptDialog, MoreOptAdapter moreOptAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(moreOptDialog, "this$0");
        Intrinsics.checkNotNullParameter(moreOptAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Function2<? super MoreOptBean, ? super Integer, Unit> function2 = moreOptDialog.onMenuClickListener;
        if (function2 != null) {
            function2.invoke(moreOptAdapter.getItem(i), Integer.valueOf(i));
        }
        moreOptDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.base_dialog_more_opt;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        final MoreOptAdapter moreOptAdapter = new MoreOptAdapter();
        y57.d(moreOptAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.or5
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MoreOptDialog.initView$lambda$1$lambda$0(this.f18715a, moreOptAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        Bundle arguments = getArguments();
        moreOptAdapter.setList(arguments != null ? arguments.getParcelableArrayList(KEY_MENUS) : null);
        BaseDialogMoreOptBinding baseDialogMoreOptBinding = (BaseDialogMoreOptBinding) getMBinding();
        RecyclerView recyclerView = baseDialogMoreOptBinding != null ? baseDialogMoreOptBinding.f32807a : null;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(moreOptAdapter);
    }
}

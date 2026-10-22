package com.huachenjie.run.page.run_reward;

import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunRewardBean;
import com.huachenjie.run.databinding.RunRunItemRunRewardBinding;
import com.huachenjie.run.page.run_reward.RunRewardListAdapter;
import com.zj.adlib.lk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J \u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/RunRewardBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunRunItemRunRewardBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/widget/TextView;", "tvRemark", "btLookMore", "f", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunRewardListAdapter extends BaseQuickAdapter<RunRewardBean, BaseDataBindingHolder<RunRunItemRunRewardBinding>> implements LoadMoreModule {
    /* JADX WARN: Illegal instructions before constructor call */
    public RunRewardListAdapter() {
        List list = null;
        super(R.layout.run_run_item_run_reward, list, 2, list);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    public static final void g(TextView textView, RunRewardBean runRewardBean, TextView textView2) {
        boolean z;
        Intrinsics.checkNotNullParameter(textView, "$tvRemark");
        Intrinsics.checkNotNullParameter(runRewardBean, "$item");
        Intrinsics.checkNotNullParameter(textView2, "$btLookMore");
        if (textView.getTag() != runRewardBean) {
            return;
        }
        Layout layout = textView.getLayout();
        if (layout != null && layout.getLineCount() > 0) {
            z = layout.getEllipsisCount(layout.getLineCount() - 1) > 0;
        }
        runRewardBean.setShowLookMore(Boolean.valueOf(z));
        textView2.setVisibility(z ? 0 : 8);
    }

    public final void f(final TextView tvRemark, final TextView btLookMore, final RunRewardBean item) {
        if (TextUtils.isEmpty(item.getRemarks())) {
            item.setShowLookMore(Boolean.FALSE);
        } else {
            if (item.getExpanded()) {
                item.setShowLookMore(Boolean.TRUE);
                return;
            }
            tvRemark.setTag(item);
            btLookMore.setVisibility(4);
            tvRemark.post(new Runnable() { // from class: com.zj.adlib.om7
                @Override // java.lang.Runnable
                public final void run() {
                    RunRewardListAdapter.g(tvRemark, item, btLookMore);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunRunItemRunRewardBinding> holder, @NotNull RunRewardBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        item.setIndex(holder.getBindingAdapterPosition() + 1);
        RunRunItemRunRewardBinding runRunItemRunRewardBinding = (RunRunItemRunRewardBinding) holder.getDataBinding();
        if (runRunItemRunRewardBinding != null) {
            if (TextUtils.isEmpty(item.getRemarks())) {
                item.setShowLookMore(Boolean.FALSE);
            }
            runRunItemRunRewardBinding.setVariable(lk0.g, item);
            runRunItemRunRewardBinding.d.setMaxLines(item.getExpanded() ? Integer.MAX_VALUE : 2);
            runRunItemRunRewardBinding.executePendingBindings();
            TextView textView = runRunItemRunRewardBinding.d;
            Intrinsics.checkNotNullExpressionValue(textView, "tvRemarkContent");
            TextView textView2 = runRunItemRunRewardBinding.f35745a;
            Intrinsics.checkNotNullExpressionValue(textView2, "btRemarkLook");
            f(textView, textView2, item);
        }
    }
}

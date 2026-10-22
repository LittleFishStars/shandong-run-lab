package com.huachenjie.run.page.rankinglist;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankingRangeBean;
import com.huachenjie.run.page.rankinglist.RankingDrawerAdapter;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/RankingDrawerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/RankingRangeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "K", "I", y6b.f, "()I", y6b.g, "(I)V", "checkedCode", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RankingDrawerAdapter extends BaseQuickAdapter<RankingRangeBean, BaseViewHolder> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int checkedCode;

    public RankingDrawerAdapter() {
        super(R.layout.run_item_ranking_drawer, null, 2, null);
    }

    public static final void f(RankingDrawerAdapter rankingDrawerAdapter, RankingRangeBean rankingRangeBean, View view) {
        Intrinsics.checkNotNullParameter(rankingDrawerAdapter, "this$0");
        Intrinsics.checkNotNullParameter(rankingRangeBean, "$item");
        Integer code = rankingRangeBean.getCode();
        Intrinsics.checkNotNull(code);
        rankingDrawerAdapter.checkedCode = code.intValue();
        rankingDrawerAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getCheckedCode() {
        return this.checkedCode;
    }

    public final void h(int i) {
        this.checkedCode = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull final RankingRangeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        CheckTextView checkTextView = (CheckTextView) holder.getView(R.id.tv);
        checkTextView.setText(item.getName());
        int i = this.checkedCode;
        Integer code = item.getCode();
        checkTextView.setChecked(code != null && i == code.intValue());
        checkTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.na7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingDrawerAdapter.f(this.f18381a, item, view);
            }
        });
    }
}

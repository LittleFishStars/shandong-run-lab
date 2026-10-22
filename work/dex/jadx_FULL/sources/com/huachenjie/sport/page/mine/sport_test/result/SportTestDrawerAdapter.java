package com.huachenjie.sport.page.mine.sport_test.result;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.TestResultYearBean;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestDrawerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/TestResultYearBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "position", y6b.f, "f", "K", "I", "checkedIndex", "<init>", "(I)V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestDrawerAdapter extends BaseQuickAdapter<TestResultYearBean, BaseViewHolder> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int checkedIndex;

    public SportTestDrawerAdapter(int i) {
        super(R.layout.item_pe_classes_selector, null, 2, null);
        this.checkedIndex = i;
    }

    @NotNull
    public final TestResultYearBean f() {
        return getData().get(this.checkedIndex);
    }

    public final void g(int position) {
        int i = this.checkedIndex;
        getData().get(i).setCurrentYear(Boolean.FALSE);
        this.checkedIndex = position;
        getData().get(this.checkedIndex).setCurrentYear(Boolean.TRUE);
        notifyItemChanged(i);
        notifyItemChanged(this.checkedIndex);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull TestResultYearBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        CheckTextView checkTextView = (CheckTextView) holder.getView(R.id.tv);
        checkTextView.setText(item.getYearName());
        Boolean currentYear = item.getCurrentYear();
        checkTextView.setChecked(currentYear != null ? currentYear.booleanValue() : false);
    }
}

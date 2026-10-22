package com.huachenjie.mine.page.history.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.history.IHistoryFragmentListener;
import com.huachenjie.works.databinding.WorksFragmentWorkListBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorkListFragment;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/history/fragment/HistoryWorksFragment;", "Lcom/huachenjie/works/external/base/BaseWorkListFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentWorkListBinding;", "Lcom/huachenjie/mine/page/history/fragment/HistoryWorksViewModel;", "Lcom/huachenjie/mine/page/history/IHistoryFragmentListener;", "()V", "clearHistory", "", "initAdapter", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HistoryWorksFragment extends BaseWorkListFragment<WorksFragmentWorkListBinding, HistoryWorksViewModel> implements IHistoryFragmentListener {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.mine.page.history.IHistoryFragmentListener
    public void clearHistory() {
        WorksAdapter value;
        if (getMViewModel() == 0 || (value = ((HistoryWorksViewModel) getMViewModel()).i().getValue()) == null) {
            return;
        }
        value.setList(CollectionsKt.emptyList());
        value.r();
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    @NotNull
    public WorksAdapter initAdapter() {
        return new WorksAdapter() { // from class: com.huachenjie.mine.page.history.fragment.HistoryWorksFragment.initAdapter.1
            {
                super(false, false, false, 7, null);
            }

            @Override // com.huachenjie.works.external.adapter.WorksAdapter
            public void s(@NotNull TextView tvEmpty, @NotNull ConstraintLayout.LayoutParams ivLayoutParams) {
                Intrinsics.checkNotNullParameter(tvEmpty, "tvEmpty");
                Intrinsics.checkNotNullParameter(ivLayoutParams, "ivLayoutParams");
                ivLayoutParams.verticalBias = 0.38f;
                tvEmpty.setText(HistoryWorksFragment.this.getString(R.string.mine_history_record_empty));
            }
        };
    }
}

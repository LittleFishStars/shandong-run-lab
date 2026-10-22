package com.huachenjie.run.page.activities_run.dialog;

import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\b\u0001\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006R\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialogAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "index", y6b.f, "f", "K", "I", "selIndex", "layoutResId", "<init>", "(I)V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class DanmuDialogAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selIndex;

    /* JADX WARN: Illegal instructions before constructor call */
    public DanmuDialogAdapter(@LayoutRes int i) {
        List list = null;
        super(i, list, 2, list);
    }

    public final void f() {
        this.selIndex = 0;
    }

    public final void g(int index) {
        if (index < 0 || index >= getData().size()) {
            return;
        }
        int i = this.selIndex;
        this.selIndex = index;
        boolean z = false;
        if (i >= 0 && i < getData().size()) {
            z = true;
        }
        if (z) {
            notifyItemChanged(i);
        }
        notifyItemChanged(this.selIndex);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        boolean z = bindingAdapterPosition != -1 && this.selIndex == bindingAdapterPosition;
        ((LinearLayout) holder.getView(R.id.ll_root)).setBackground(new DrawableCreator.Builder().setCornersRadius(cr2.c(getContext(), 12.0f)).setSolidColor(z ? -1 : -526345).setStrokeWidth(cr2.c(getContext(), 2.0f)).setStrokeColor(z ? RunIndexRecordAdapter.K : -526345).build());
        holder.setGone(R.id.tv_send, !z);
        holder.setText(R.id.tv_content, item);
    }
}

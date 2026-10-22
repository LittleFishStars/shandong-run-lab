package com.huachenjie.run.page.run_detail.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemRunRecordFaceThumbBinding;
import com.zj.adlib.RunRecordFaceThumb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/page/run_detail/adapter/RunRecordFaceThumbAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/zj/adlib/lm7;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemRunRecordFaceThumbBinding;", "holder", "item", "", "convert", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunRecordFaceThumbAdapter extends BaseQuickAdapter<RunRecordFaceThumb, BaseDataBindingHolder<RunItemRunRecordFaceThumbBinding>> {
    public RunRecordFaceThumbAdapter() {
        super(R.layout.run_item_run_record_face_thumb, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemRunRecordFaceThumbBinding> holder, @NotNull RunRecordFaceThumb item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemRunRecordFaceThumbBinding runItemRunRecordFaceThumbBinding = (RunItemRunRecordFaceThumbBinding) holder.getDataBinding();
        if (runItemRunRecordFaceThumbBinding != null) {
            runItemRunRecordFaceThumbBinding.k(item);
            runItemRunRecordFaceThumbBinding.executePendingBindings();
        }
    }
}

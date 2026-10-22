package com.zj.adlib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.mall.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/kr6;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "data", "", "a", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class kr6 extends BaseItemBinder<String, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder holder, @NotNull String data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item_goods_detail_picture_title, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return new BaseViewHolder(viewInflate);
    }
}

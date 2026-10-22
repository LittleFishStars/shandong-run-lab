package com.chad.library.adapter.base;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B-\b\u0016\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0002\u0010\u000bB#\b\u0007\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0011J+\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nH\u0014¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u001d\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u001bJ+\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nH\u0016¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u000e2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "T", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "sectionHeadResId", "", "layoutResId", "data", "", "(IILjava/util/List;)V", "(ILjava/util/List;)V", "convertHeader", "", "helper", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;)V", "payloads", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/chad/library/adapter/base/entity/SectionEntity;Ljava/util/List;)V", "isFixedViewType", "", "type", "onBindViewHolder", "holder", "position", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "setNormalLayout", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, VH extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T, VH> {
    private final int sectionHeadResId;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public BaseSectionQuickAdapter(@LayoutRes int i) {
        List list = null;
        this(i, list, 2, list);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    public abstract void convertHeader(@NotNull VH helper, @NotNull T item);

    public void convertHeader(@NotNull VH helper, @NotNull T item, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int type) {
        return super.isFixedViewType(type) || type == -99;
    }

    public final void setNormalLayout(@LayoutRes int layoutResId) {
        addItemType(-100, layoutResId);
    }

    @JvmOverloads
    public BaseSectionQuickAdapter(@LayoutRes int i, @Nullable List<T> list) {
        super(list);
        this.sectionHeadResId = i;
        addItemType(-99, i);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((BaseViewHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getItemViewType() == -99) {
            convertHeader(holder, getItem(position - getHeaderLayoutCount()));
        } else {
            super.onBindViewHolder((BaseViewHolder) holder, position);
        }
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : list);
    }

    public BaseSectionQuickAdapter(@LayoutRes int i, @LayoutRes int i2, @Nullable List<T> list) {
        this(i, list);
        setNormalLayout(i2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(@NotNull VH holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder((BaseViewHolder) holder, position);
        } else if (holder.getItemViewType() == -99) {
            convertHeader(holder, getItem(position - getHeaderLayoutCount()), payloads);
        } else {
            super.onBindViewHolder((BaseViewHolder) holder, position, payloads);
        }
    }
}

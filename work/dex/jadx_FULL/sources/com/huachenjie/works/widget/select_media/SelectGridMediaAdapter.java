package com.huachenjie.works.widget.select_media;

import android.graphics.Canvas;
import android.view.ViewGroup;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.databinding.WorksItemPublishWorkVideoBinding;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.fx7;
import com.zj.adlib.lj7;
import com.zj.adlib.qk0;
import com.zj.adlib.y6b;
import java.util.Collections;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00162\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001:\u0002\u0016#B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010 \u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0013¨\u0006$"}, d2 = {"Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "", "fromPosition", "toPosition", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "K", "I", "getType", "()I", "type", "Lcom/bumptech/glide/request/RequestOptions;", "a", "Lcom/bumptech/glide/request/RequestOptions;", y6b.f, "()Lcom/bumptech/glide/request/RequestOptions;", "blurOptions", "Lkotlin/Lazy;", y6b.g, "itemMargin", "b", "i", "itemSideLength", "<init>", "(I)V", "PicItemHelperCallback", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SelectGridMediaAdapter extends BaseMultiItemQuickAdapter<PubWorkMediaData, BaseDataBindingHolder<? extends ViewDataBinding>> {
    public static final int L = 3;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int type;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RequestOptions blurOptions;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy itemMargin;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy itemSideLength;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter$PicItemHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lcom/huachenjie/works/widget/select_media/SelectGridMediaAdapter;)V", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onChildDraw", "", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSwiped", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class PicItemHelperCallback extends ItemTouchHelper.Callback {
        public PicItemHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (viewHolder.getItemViewType() == 0) {
                return 0;
            }
            return ItemTouchHelper.Callback.makeFlag(2, 15);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(@NotNull Canvas c, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
            super.onChildDraw(c, recyclerView, viewHolder, dX < 0.0f ? RangesKt.coerceAtLeast(dX, -((bindingAdapterPosition % 3) * (SelectGridMediaAdapter.this.i() + SelectGridMediaAdapter.this.h()))) : RangesKt.coerceAtMost(dX, (2 - (bindingAdapterPosition % 3)) * (SelectGridMediaAdapter.this.i() + SelectGridMediaAdapter.this.h())), dY < 0.0f ? RangesKt.coerceAtLeast(dY, -((bindingAdapterPosition / 3) * (SelectGridMediaAdapter.this.i() + SelectGridMediaAdapter.this.h()))) : RangesKt.coerceAtMost(dY, ((((SelectGridMediaAdapter.this.getData().size() / 3) + (SelectGridMediaAdapter.this.getData().size() % 3 > 0 ? 1 : 0)) - 1) - (bindingAdapterPosition / 3)) * (SelectGridMediaAdapter.this.i() + SelectGridMediaAdapter.this.h())), actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            SelectGridMediaAdapter.this.j(viewHolder.getBindingAdapterPosition(), target.getBindingAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectGridMediaAdapter(int i) {
        super(null, 1, null);
        this.type = i;
        BaseRequestOptions baseRequestOptionsTransforms = new RequestOptions().transforms(new CenterCrop(), new lj7(6, 2, SizeUtils.b(4.5f)));
        Intrinsics.checkNotNullExpressionValue(baseRequestOptionsTransforms, "RequestOptions().transfo…, SizeUtils.dp2px(4.5f)))");
        this.blurOptions = (RequestOptions) baseRequestOptionsTransforms;
        this.itemMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaAdapter$itemMargin$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m993invoke() {
                return Integer.valueOf(SizeUtils.b(10.0f));
            }
        });
        this.itemSideLength = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.widget.select_media.SelectGridMediaAdapter$itemSideLength$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m994invoke() {
                return Integer.valueOf((int) ((fx7.j() - SizeUtils.b(52.0f)) / 3.0f));
            }
        });
        addItemType(0, R.layout.works_item_pub_work_add_media);
        addItemType(1, R.layout.works_item_publish_work_pic);
        addItemType(2, R.layout.works_item_publish_work_video);
    }

    @NotNull
    /* JADX INFO: renamed from: g, reason: from getter */
    public final RequestOptions getBlurOptions() {
        return this.blurOptions;
    }

    public final int getType() {
        return this.type;
    }

    public final int h() {
        return ((Number) this.itemMargin.getValue()).intValue();
    }

    public final int i() {
        return ((Number) this.itemSideLength.getValue()).intValue();
    }

    public final void j(int fromPosition, int toPosition) {
        boolean z = ((PubWorkMediaData) getData().get(toPosition)).getPostType() == 0;
        if (fromPosition == toPosition || z) {
            return;
        }
        if (fromPosition >= toPosition) {
            int i = toPosition + 1;
            if (i <= fromPosition) {
                int i2 = fromPosition;
                while (true) {
                    Collections.swap(getData(), i2, i2 - 1);
                    if (i2 == i) {
                        break;
                    } else {
                        i2--;
                    }
                }
            }
        } else {
            int i3 = fromPosition;
            while (i3 < toPosition) {
                int i4 = i3 + 1;
                Collections.swap(getData(), i3, i4);
                i3 = i4;
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (this.type == 2) {
            return;
        }
        new ItemTouchHelper(new PicItemHelperCallback()).attachToRecyclerView(recyclerView);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull PubWorkMediaData item) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        if (holder.getItemViewType() == 2) {
            ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
            layoutParams2.width = i() * 3;
            layoutParams2.height = -2;
            if ((dataBinding instanceof WorksItemPublishWorkVideoBinding) && (layoutParams = ((WorksItemPublishWorkVideoBinding) dataBinding).f37060a.getLayoutParams()) != null) {
                layoutParams.width = i();
                layoutParams.height = i();
            }
        } else {
            ViewGroup.LayoutParams layoutParams3 = holder.itemView.getLayoutParams();
            layoutParams3.width = i();
            layoutParams3.height = i();
        }
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            dataBinding.setVariable(qk0.b, this);
        } else if (itemViewType == 1 || itemViewType == 2) {
            dataBinding.setVariable(qk0.b, this);
            dataBinding.setVariable(qk0.o, item);
        }
        dataBinding.executePendingBindings();
    }
}

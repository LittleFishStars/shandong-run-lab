package com.chad.library.adapter.base;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseBinderAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.push.g.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J9\u0010\u0011\u001a\u00020\u0000\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u0002H\u0012\u0012\u0002\b\u00030\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\nH\u0086\bJF\u0010\u0011\u001a\u00020\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00022\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00120\t2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u0002H\u0012\u0012\u0002\b\u00030\u000e2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\nH\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0014J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J&\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0014J\u0014\u0010!\u001a\u00020\u00102\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\tH\u0004J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0014J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003H\u0016RB\u0010\u0007\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n0\bj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00100\bj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0010`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", GoodsSpecificationPreviewActivity.z, "", "(Ljava/util/List;)V", "classDiffMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlin/collections/HashMap;", "mBinderArray", "Landroid/util/SparseArray;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "mTypeMap", "", "addItemBinder", "T", "baseItemBinder", RenderCallContext.TYPE_CALLBACK, "clazz", "bindChildClick", "", "viewHolder", "viewType", "bindClick", "bindViewClickListener", "convert", "holder", "item", "payloads", "", "findViewType", "getDefItemViewType", "position", "getItemBinder", "getItemBinderOrNull", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ItemCallback", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseBinderAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,233:1\n1#2:234\n1855#3,2:235\n1855#3,2:237\n*S KotlinDebug\n*F\n+ 1 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n*L\n160#1:235,2\n180#1:237,2\n*E\n"})
public class BaseBinderAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    @NotNull
    private final HashMap<Class<?>, DiffUtil.ItemCallback<Object>> classDiffMap;

    @NotNull
    private final SparseArray<BaseItemBinder<Object, ?>> mBinderArray;

    @NotNull
    private final HashMap<Class<?>, Integer> mTypeMap;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "(Lcom/chad/library/adapter/base/BaseBinderAdapter;)V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ItemCallback extends DiffUtil.ItemCallback<Object> {
        public ItemCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (DiffUtil.ItemCallback) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return true;
            }
            return itemCallback.areContentsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return (!Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (DiffUtil.ItemCallback) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) ? Intrinsics.areEqual(oldItem, newItem) : itemCallback.areItemsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        public Object getChangePayload(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (DiffUtil.ItemCallback) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return null;
            }
            return itemCallback.getChangePayload(oldItem, newItem);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseBinderAdapter() {
        List list = null;
        this(list, 1, list);
    }

    public BaseBinderAdapter(@Nullable List<Object> list) {
        super(0, list);
        this.classDiffMap = new HashMap<>();
        this.mTypeMap = new HashMap<>();
        this.mBinderArray = new SparseArray<>();
        setDiffCallback(new ItemCallback());
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter baseBinderAdapter, Class cls, BaseItemBinder baseItemBinder, DiffUtil.ItemCallback itemCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 4) != 0) {
            itemCallback = null;
        }
        return baseBinderAdapter.addItemBinder(cls, baseItemBinder, itemCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChildClick$lambda$11$lambda$10$lambda$9(BaseViewHolder baseViewHolder, BaseBinderAdapter baseBinderAdapter, BaseItemBinder baseItemBinder, View view) {
        int headerLayoutCount;
        Object orNull;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseBinderAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseItemBinder, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || (orNull = CollectionsKt.getOrNull(baseBinderAdapter.getData(), (headerLayoutCount = bindingAdapterPosition - baseBinderAdapter.getHeaderLayoutCount()))) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(view, "v");
        return baseItemBinder.onChildLongClick(baseViewHolder, view, orNull, headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindChildClick$lambda$8$lambda$7$lambda$6(BaseViewHolder baseViewHolder, BaseBinderAdapter baseBinderAdapter, BaseItemBinder baseItemBinder, View view) {
        int headerLayoutCount;
        Object orNull;
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseBinderAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseItemBinder, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1 || (orNull = CollectionsKt.getOrNull(baseBinderAdapter.getData(), (headerLayoutCount = bindingAdapterPosition - baseBinderAdapter.getHeaderLayoutCount()))) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "v");
        baseItemBinder.onChildClick(baseViewHolder, view, orNull, headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClick$lambda$4(BaseViewHolder baseViewHolder, BaseBinderAdapter baseBinderAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseBinderAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - baseBinderAdapter.getHeaderLayoutCount();
        BaseItemBinder<Object, BaseViewHolder> itemBinder = baseBinderAdapter.getItemBinder(baseViewHolder.getItemViewType());
        if (CollectionsKt.getOrNull(baseBinderAdapter.getData(), headerLayoutCount) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        itemBinder.onClick(baseViewHolder, view, baseBinderAdapter.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindClick$lambda$5(BaseViewHolder baseViewHolder, BaseBinderAdapter baseBinderAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseBinderAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - baseBinderAdapter.getHeaderLayoutCount();
        BaseItemBinder<Object, BaseViewHolder> itemBinder = baseBinderAdapter.getItemBinder(baseViewHolder.getItemViewType());
        Object orNull = CollectionsKt.getOrNull(baseBinderAdapter.getData(), headerLayoutCount);
        if (orNull == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        return itemBinder.onLongClick(baseViewHolder, view, orNull, headerLayoutCount);
    }

    @JvmOverloads
    @NotNull
    public final <T> BaseBinderAdapter addItemBinder(@NotNull Class<? extends T> cls, @NotNull BaseItemBinder<T, ?> baseItemBinder) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        return addItemBinder$default(this, cls, baseItemBinder, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final <T> BaseBinderAdapter addItemBinder(@NotNull Class<? extends T> clazz, @NotNull BaseItemBinder<T, ?> baseItemBinder, @Nullable DiffUtil.ItemCallback<T> callback) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        int size = this.mTypeMap.size() + 1;
        this.mTypeMap.put(clazz, Integer.valueOf(size));
        this.mBinderArray.append(size, baseItemBinder);
        baseItemBinder.set_adapter$com_github_CymChad_brvah(this);
        if (callback != null) {
            this.classDiffMap.put(clazz, callback);
        }
        return this;
    }

    public void bindChildClick(@NotNull final BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemChildClickListener() == null) {
            final BaseItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(viewType);
            Iterator<T> it = itemBinder.getChildClickViewIds().iterator();
            while (it.hasNext()) {
                View viewFindViewById = viewHolder.itemView.findViewById(((Number) it.next()).intValue());
                if (viewFindViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(id)");
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.on0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseBinderAdapter.bindChildClick$lambda$8$lambda$7$lambda$6(viewHolder, this, itemBinder, view);
                        }
                    });
                }
            }
        }
        if (getMOnItemChildLongClickListener() == null) {
            final BaseItemBinder<Object, BaseViewHolder> itemBinder2 = getItemBinder(viewType);
            Iterator<T> it2 = itemBinder2.getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                View viewFindViewById2 = viewHolder.itemView.findViewById(((Number) it2.next()).intValue());
                if (viewFindViewById2 != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(id)");
                    if (!viewFindViewById2.isLongClickable()) {
                        viewFindViewById2.setLongClickable(true);
                    }
                    viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.pn0
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            return BaseBinderAdapter.bindChildClick$lambda$11$lambda$10$lambda$9(viewHolder, this, itemBinder2, view);
                        }
                    });
                }
            }
        }
    }

    public void bindClick(@NotNull final BaseViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mn0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseBinderAdapter.bindClick$lambda$4(viewHolder, this, view);
                }
            });
        }
        if (getMOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.nn0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BaseBinderAdapter.bindClick$lambda$5(viewHolder, this, view);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(@NotNull BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.bindViewClickListener(viewHolder, viewType);
        bindClick(viewHolder);
        bindChildClick(viewHolder, viewType);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull Object item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        getItemBinder(holder.getItemViewType()).convert(holder, item);
    }

    public final int findViewType(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Integer num = this.mTypeMap.get(clazz);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(("findViewType: ViewType: " + clazz + " Not Find!").toString());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        return findViewType(getData().get(position).getClass());
    }

    @NotNull
    public BaseItemBinder<Object, BaseViewHolder> getItemBinder(int viewType) {
        BaseItemBinder<Object, BaseViewHolder> baseItemBinder = (BaseItemBinder) this.mBinderArray.get(viewType);
        if (baseItemBinder != null) {
            return baseItemBinder;
        }
        throw new IllegalStateException(("getItemBinder: viewType '" + viewType + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    @Nullable
    public BaseItemBinder<Object, BaseViewHolder> getItemBinderOrNull(int viewType) {
        BaseItemBinder<Object, BaseViewHolder> baseItemBinder = (BaseItemBinder) this.mBinderArray.get(viewType);
        if (baseItemBinder == null) {
            return null;
        }
        return baseItemBinder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(viewType);
        itemBinder.set_context$com_github_CymChad_brvah(getContext());
        return itemBinder.onCreateViewHolder(parent, viewType);
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter baseBinderAdapter, BaseItemBinder baseItemBinder, DiffUtil.ItemCallback itemCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i & 2) != 0) {
            itemCallback = null;
        }
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        Intrinsics.reifiedOperationMarker(4, "T");
        baseBinderAdapter.addItemBinder(Object.class, baseItemBinder, itemCallback);
        return baseBinderAdapter;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull Object item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        getItemBinder(holder.getItemViewType()).convert(holder, item, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            return itemBinderOrNull.onFailedToRecycleView(holder);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewDetachedFromWindow(holder);
        }
    }

    public /* synthetic */ BaseBinderAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final /* synthetic */ <T> BaseBinderAdapter addItemBinder(BaseItemBinder<T, ?> baseItemBinder, DiffUtil.ItemCallback<T> callback) {
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        Intrinsics.reifiedOperationMarker(4, "T");
        addItemBinder(Object.class, baseItemBinder, callback);
        return this;
    }
}

package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.igexin.push.g.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u001d\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001aJ+\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0014¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0014J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u001e\u0010\"\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010 \u001a\u00020\u0014H$J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "T", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "mItemProviders", "Landroid/util/SparseArray;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "getMItemProviders", "()Landroid/util/SparseArray;", "mItemProviders$delegate", "Lkotlin/Lazy;", "addItemProvider", "", "provider", "bindChildClick", "viewHolder", "viewType", "", "bindClick", "bindViewClickListener", "convert", "holder", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "getDefItemViewType", "position", "getItemProvider", "getItemType", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseProviderMultiAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseProviderMultiAdapter.kt\ncom/chad/library/adapter/base/BaseProviderMultiAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n1#2:167\n1855#3,2:168\n1855#3,2:170\n*S KotlinDebug\n*F\n+ 1 BaseProviderMultiAdapter.kt\ncom/chad/library/adapter/base/BaseProviderMultiAdapter\n*L\n130#1:168,2\n149#1:170,2\n*E\n"})
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    /* JADX INFO: renamed from: mItemProviders$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mItemProviders;

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseProviderMultiAdapter() {
        List list = null;
        this(list, 1, list);
    }

    public /* synthetic */ BaseProviderMultiAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindChildClick$lambda$6$lambda$5$lambda$4(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter, BaseItemProvider baseItemProvider, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseProviderMultiAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseItemProvider, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - baseProviderMultiAdapter.getHeaderLayoutCount();
        Intrinsics.checkNotNullExpressionValue(view, "v");
        baseItemProvider.onChildClick(baseViewHolder, view, baseProviderMultiAdapter.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChildClick$lambda$9$lambda$8$lambda$7(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter, BaseItemProvider baseItemProvider, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseProviderMultiAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseItemProvider, "$provider");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - baseProviderMultiAdapter.getHeaderLayoutCount();
        Intrinsics.checkNotNullExpressionValue(view, "v");
        return baseItemProvider.onChildLongClick(baseViewHolder, view, baseProviderMultiAdapter.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClick$lambda$2(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseProviderMultiAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int headerLayoutCount = bindingAdapterPosition - baseProviderMultiAdapter.getHeaderLayoutCount();
        BaseItemProvider<T> baseItemProvider = baseProviderMultiAdapter.getMItemProviders().get(baseViewHolder.getItemViewType());
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        baseItemProvider.onClick(baseViewHolder, view, baseProviderMultiAdapter.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindClick$lambda$3(BaseViewHolder baseViewHolder, BaseProviderMultiAdapter baseProviderMultiAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseProviderMultiAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = bindingAdapterPosition - baseProviderMultiAdapter.getHeaderLayoutCount();
        BaseItemProvider<T> baseItemProvider = baseProviderMultiAdapter.getMItemProviders().get(baseViewHolder.getItemViewType());
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        return baseItemProvider.onLongClick(baseViewHolder, view, baseProviderMultiAdapter.getData().get(headerLayoutCount), headerLayoutCount);
    }

    private final SparseArray<BaseItemProvider<T>> getMItemProviders() {
        return (SparseArray) this.mItemProviders.getValue();
    }

    public void addItemProvider(@NotNull BaseItemProvider<T> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        provider.setAdapter$com_github_CymChad_brvah(this);
        getMItemProviders().put(provider.getItemViewType(), provider);
    }

    public void bindChildClick(@NotNull final BaseViewHolder viewHolder, int viewType) {
        final BaseItemProvider<T> itemProvider;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemChildClickListener() == null) {
            final BaseItemProvider<T> itemProvider2 = getItemProvider(viewType);
            if (itemProvider2 == null) {
                return;
            }
            Iterator<T> it = itemProvider2.getChildClickViewIds().iterator();
            while (it.hasNext()) {
                View viewFindViewById = viewHolder.itemView.findViewById(((Number) it.next()).intValue());
                if (viewFindViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(id)");
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.rq0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseProviderMultiAdapter.bindChildClick$lambda$6$lambda$5$lambda$4(viewHolder, this, itemProvider2, view);
                        }
                    });
                }
            }
        }
        if (getMOnItemChildLongClickListener() != null || (itemProvider = getItemProvider(viewType)) == null) {
            return;
        }
        Iterator<T> it2 = itemProvider.getChildLongClickViewIds().iterator();
        while (it2.hasNext()) {
            View viewFindViewById2 = viewHolder.itemView.findViewById(((Number) it2.next()).intValue());
            if (viewFindViewById2 != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(id)");
                if (!viewFindViewById2.isLongClickable()) {
                    viewFindViewById2.setLongClickable(true);
                }
                viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.sq0
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return BaseProviderMultiAdapter.bindChildClick$lambda$9$lambda$8$lambda$7(viewHolder, this, itemProvider, view);
                    }
                });
            }
        }
    }

    public void bindClick(@NotNull final BaseViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tq0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseProviderMultiAdapter.bindClick$lambda$2(viewHolder, this, view);
                }
            });
        }
        if (getMOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.uq0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BaseProviderMultiAdapter.bindClick$lambda$3(viewHolder, this, view);
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
    public void convert(@NotNull BaseViewHolder holder, T item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        Intrinsics.checkNotNull(itemProvider);
        itemProvider.convert(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int position) {
        return getItemType(getData(), position);
    }

    @Nullable
    public BaseItemProvider<T> getItemProvider(int viewType) {
        return getMItemProviders().get(viewType);
    }

    public abstract int getItemType(@NotNull List<? extends T> data, int position);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BaseItemProvider<T> itemProvider = getItemProvider(viewType);
        if (itemProvider == null) {
            throw new IllegalStateException(("ViewType: " + viewType + " no such provider found，please use addItemProvider() first!").toString());
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        itemProvider.setContext(context);
        BaseViewHolder baseViewHolderOnCreateViewHolder = itemProvider.onCreateViewHolder(parent, viewType);
        itemProvider.onViewHolderCreated(baseViewHolderOnCreateViewHolder, viewType);
        return baseViewHolderOnCreateViewHolder;
    }

    public BaseProviderMultiAdapter(@Nullable List<T> list) {
        super(0, list);
        this.mItemProviders = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<SparseArray<BaseItemProvider<T>>>() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SparseArray<BaseItemProvider<T>> m177invoke() {
                return new SparseArray<>();
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, T item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        Intrinsics.checkNotNull(itemProvider);
        itemProvider.convert(holder, item, payloads);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewDetachedFromWindow(holder);
        }
    }
}

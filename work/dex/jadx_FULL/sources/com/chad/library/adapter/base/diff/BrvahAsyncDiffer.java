package com.chad.library.adapter.base.diff;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.heytap.mcssdk.constant.b;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001/B%\u0012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00132\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J%\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00028\u00002\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0013J(\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J \u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0013\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000eJ\u0014\u0010-\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ$\u0010.\u001a\u00020\u00132\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007R\u0018\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "T", "Lcom/chad/library/adapter/base/diff/DifferImp;", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;)V", "mListeners", "", "Lcom/chad/library/adapter/base/diff/ListChangeListener;", "mMainThreadExecutor", "Ljava/util/concurrent/Executor;", "mMaxScheduledGeneration", "", "mUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "sMainThreadExecutor", "addData", "", "data", "(Ljava/lang/Object;)V", "index", "(ILjava/lang/Object;)V", "addList", GoodsSpecificationPreviewActivity.z, "", "addListListener", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "changeData", "newData", AssistPushConsts.MSG_TYPE_PAYLOAD, "(ILjava/lang/Object;Ljava/lang/Object;)V", "clearAllListListener", "latchList", "newList", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "commitCallback", "Ljava/lang/Runnable;", "onCurrentListChanged", "previousList", "remove", "t", "removeAt", "removeListListener", "submitList", "MainThreadExecutor", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrvahAsyncDiffer<T> implements DifferImp<T> {

    @NotNull
    private final BaseQuickAdapter<T, ?> adapter;

    @NotNull
    private final BrvahAsyncDifferConfig<T> config;

    @NotNull
    private final List<ListChangeListener<T>> mListeners;

    @NotNull
    private Executor mMainThreadExecutor;
    private int mMaxScheduledGeneration;

    @NotNull
    private final ListUpdateCallback mUpdateCallback;

    @NotNull
    private final Executor sMainThreadExecutor;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "execute", "", b.y, "Ljava/lang/Runnable;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MainThreadExecutor implements Executor {

        @NotNull
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable command) {
            Intrinsics.checkNotNullParameter(command, b.y);
            this.mHandler.post(command);
        }

        @NotNull
        public final Handler getMHandler() {
            return this.mHandler;
        }
    }

    public BrvahAsyncDiffer(@NotNull BaseQuickAdapter<T, ?> baseQuickAdapter, @NotNull BrvahAsyncDifferConfig<T> brvahAsyncDifferConfig) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(brvahAsyncDifferConfig, "config");
        this.adapter = baseQuickAdapter;
        this.config = brvahAsyncDifferConfig;
        this.mUpdateCallback = new BrvahListUpdateCallback(baseQuickAdapter);
        Executor mainThreadExecutor = new MainThreadExecutor();
        this.sMainThreadExecutor = mainThreadExecutor;
        Executor mainThreadExecutor2 = brvahAsyncDifferConfig.getMainThreadExecutor();
        this.mMainThreadExecutor = mainThreadExecutor2 != null ? mainThreadExecutor2 : mainThreadExecutor;
        this.mListeners = new CopyOnWriteArrayList();
    }

    private final void latchList(List<T> newList, DiffUtil.DiffResult diffResult, Runnable commitCallback) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.setData$com_github_CymChad_brvah(newList);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(data, commitCallback);
    }

    private final void onCurrentListChanged(List<? extends T> previousList, Runnable commitCallback) {
        Iterator<ListChangeListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(previousList, this.adapter.getData());
        }
        if (commitCallback != null) {
            commitCallback.run();
        }
    }

    public static /* synthetic */ void submitList$default(BrvahAsyncDiffer brvahAsyncDiffer, List list, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            runnable = null;
        }
        brvahAsyncDiffer.submitList(list, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitList$lambda$1(final BrvahAsyncDiffer brvahAsyncDiffer, final List list, final List list2, final int i, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(brvahAsyncDiffer, "this$0");
        Intrinsics.checkNotNullParameter(list, "$oldList");
        final DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1$result$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                Object obj = list.get(oldItemPosition);
                Object obj2 = list2.get(newItemPosition);
                if (obj != null && obj2 != null) {
                    return ((BrvahAsyncDiffer) brvahAsyncDiffer).config.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                Object obj = list.get(oldItemPosition);
                Object obj2 = list2.get(newItemPosition);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return ((BrvahAsyncDiffer) brvahAsyncDiffer).config.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @Nullable
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                Object obj = list.get(oldItemPosition);
                Object obj2 = list2.get(newItemPosition);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return ((BrvahAsyncDiffer) brvahAsyncDiffer).config.getDiffCallback().getChangePayload(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return list2.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return list.size();
            }
        });
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "@JvmOverloads\n    fun su…        }\n        }\n    }");
        brvahAsyncDiffer.mMainThreadExecutor.execute(new Runnable() { // from class: com.zj.adlib.r01
            @Override // java.lang.Runnable
            public final void run() {
                BrvahAsyncDiffer.submitList$lambda$1$lambda$0(this.f19206a, i, list2, diffResultCalculateDiff, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitList$lambda$1$lambda$0(BrvahAsyncDiffer brvahAsyncDiffer, int i, List list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        Intrinsics.checkNotNullParameter(brvahAsyncDiffer, "this$0");
        Intrinsics.checkNotNullParameter(diffResult, "$result");
        if (brvahAsyncDiffer.mMaxScheduledGeneration == i) {
            brvahAsyncDiffer.latchList(list, diffResult, runnable);
        }
    }

    public final void addData(int index, T data) {
        List<? extends T> data2 = this.adapter.getData();
        this.adapter.getData().add(index, data);
        this.mUpdateCallback.onInserted(index, 1);
        onCurrentListChanged(data2, null);
    }

    public final void addList(@Nullable List<? extends T> list) {
        if (list == null) {
            return;
        }
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().addAll(list);
        this.mUpdateCallback.onInserted(data.size(), list.size());
        onCurrentListChanged(data, null);
    }

    @Override // com.chad.library.adapter.base.diff.DifferImp
    public void addListListener(@NotNull ListChangeListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.mListeners.add(listener);
    }

    public final void changeData(int index, T newData, @Nullable T payload) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().set(index, newData);
        this.mUpdateCallback.onChanged(index, 1, payload);
        onCurrentListChanged(data, null);
    }

    public final void clearAllListListener() {
        this.mListeners.clear();
    }

    public final void remove(T t) {
        List<? extends T> data = this.adapter.getData();
        int iIndexOf = this.adapter.getData().indexOf(t);
        if (iIndexOf == -1) {
            return;
        }
        this.adapter.getData().remove(iIndexOf);
        this.mUpdateCallback.onRemoved(iIndexOf, 1);
        onCurrentListChanged(data, null);
    }

    public final void removeAt(int index) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().remove(index);
        this.mUpdateCallback.onRemoved(index, 1);
        onCurrentListChanged(data, null);
    }

    public final void removeListListener(@NotNull ListChangeListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.mListeners.remove(listener);
    }

    @JvmOverloads
    public final void submitList(@Nullable List<T> list) {
        submitList$default(this, list, null, 2, null);
    }

    @JvmOverloads
    public final void submitList(@Nullable final List<T> newList, @Nullable final Runnable commitCallback) {
        final int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        if (newList == this.adapter.getData()) {
            if (commitCallback != null) {
                commitCallback.run();
                return;
            }
            return;
        }
        final List<? extends T> data = this.adapter.getData();
        if (newList == null) {
            int size = this.adapter.getData().size();
            this.adapter.setData$com_github_CymChad_brvah(new ArrayList());
            this.mUpdateCallback.onRemoved(0, size);
            onCurrentListChanged(data, commitCallback);
            return;
        }
        if (!this.adapter.getData().isEmpty()) {
            this.config.getBackgroundThreadExecutor().execute(new Runnable() { // from class: com.zj.adlib.s01
                @Override // java.lang.Runnable
                public final void run() {
                    BrvahAsyncDiffer.submitList$lambda$1(this.f44576a, data, newList, i, commitCallback);
                }
            });
            return;
        }
        this.adapter.setData$com_github_CymChad_brvah(newList);
        this.mUpdateCallback.onInserted(0, newList.size());
        onCurrentListChanged(data, commitCallback);
    }

    public final void addData(T data) {
        List<? extends T> data2 = this.adapter.getData();
        this.adapter.getData().add(data);
        this.mUpdateCallback.onInserted(data2.size(), 1);
        onCurrentListChanged(data2, null);
    }
}

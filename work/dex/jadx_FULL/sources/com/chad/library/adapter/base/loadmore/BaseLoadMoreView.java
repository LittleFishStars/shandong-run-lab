package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "()V", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "position", "", "loadMoreStatus", "Lcom/chad/library/adapter/base/loadmore/LoadMoreStatus;", "getLoadComplete", "Landroid/view/View;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "isVisible", "visible", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseLoadMoreView {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadMoreStatus.End.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void isVisible(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void convert(@NotNull BaseViewHolder holder, int position, @NotNull LoadMoreStatus loadMoreStatus) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(loadMoreStatus, "loadMoreStatus");
        int i = WhenMappings.$EnumSwitchMapping$0[loadMoreStatus.ordinal()];
        if (i == 1) {
            isVisible(getLoadingView(holder), false);
            isVisible(getLoadComplete(holder), true);
            isVisible(getLoadFailView(holder), false);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i == 2) {
            isVisible(getLoadingView(holder), true);
            isVisible(getLoadComplete(holder), false);
            isVisible(getLoadFailView(holder), false);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i == 3) {
            isVisible(getLoadingView(holder), false);
            isVisible(getLoadComplete(holder), false);
            isVisible(getLoadFailView(holder), true);
            isVisible(getLoadEndView(holder), false);
            return;
        }
        if (i != 4) {
            return;
        }
        isVisible(getLoadingView(holder), false);
        isVisible(getLoadComplete(holder), false);
        isVisible(getLoadFailView(holder), false);
        isVisible(getLoadEndView(holder), true);
    }

    @NotNull
    public abstract View getLoadComplete(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View getLoadEndView(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View getLoadFailView(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View getLoadingView(@NotNull BaseViewHolder holder);

    @NotNull
    public abstract View getRootView(@NotNull ViewGroup parent);
}

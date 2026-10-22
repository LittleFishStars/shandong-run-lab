package com.zj.adlib;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a8\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000b\u001a8\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\t*\u00020\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Landroid/view/View;", "", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "Landroid/view/View$OnClickListener;", "click", "", "e", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "c", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "a", "common_release"}, k = 2, mv = {1, 8, 0})
public final class y57 {
    public static final <T, VH extends BaseViewHolder> void a(@NotNull BaseQuickAdapter<T, VH> baseQuickAdapter, long j, @NotNull OnItemChildClickListener onItemChildClickListener) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<this>");
        Intrinsics.checkNotNullParameter(onItemChildClickListener, "click");
        new a67(baseQuickAdapter, onItemChildClickListener, Long.valueOf(j));
    }

    public static /* synthetic */ void b(BaseQuickAdapter baseQuickAdapter, long j, OnItemChildClickListener onItemChildClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        a(baseQuickAdapter, j, onItemChildClickListener);
    }

    public static final <T, VH extends BaseViewHolder> void c(@NotNull BaseQuickAdapter<T, VH> baseQuickAdapter, long j, @NotNull OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<this>");
        Intrinsics.checkNotNullParameter(onItemClickListener, "click");
        new b67(baseQuickAdapter, onItemClickListener, Long.valueOf(j));
    }

    public static /* synthetic */ void d(BaseQuickAdapter baseQuickAdapter, long j, OnItemClickListener onItemClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        c(baseQuickAdapter, j, onItemClickListener);
    }

    public static final void e(@NotNull View view, long j, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "click");
        new c67(view, onClickListener, Long.valueOf(j));
    }

    public static /* synthetic */ void f(View view, long j, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        e(view, j, onClickListener);
    }
}

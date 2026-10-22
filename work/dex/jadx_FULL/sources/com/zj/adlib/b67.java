package com.zj.adlib;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \r*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004:\u0001\rB/\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/b67;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "Landroid/view/View;", "view", "", "position", "", "onItemClick", "a", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "clickListener", "", "J", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "b", "time", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Lcom/chad/library/adapter/base/listener/OnItemClickListener;Ljava/lang/Long;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class b67<T, VH extends BaseViewHolder> implements OnItemClickListener {
    public static final long c = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long waitTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final OnItemClickListener clickListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public long time;

    public b67(@NotNull BaseQuickAdapter<T, VH> baseQuickAdapter, @NotNull OnItemClickListener onItemClickListener, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        Intrinsics.checkNotNullParameter(onItemClickListener, "clickListener");
        this.clickListener = onItemClickListener;
        this.waitTime = 1000L;
        if (l != null && l.longValue() >= 0) {
            this.waitTime = l.longValue();
        }
        baseQuickAdapter.setOnItemClickListener(this);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int position) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.time) > this.waitTime) {
            this.clickListener.onItemClick(adapter, view, position);
            this.time = jCurrentTimeMillis;
        }
    }

    public /* synthetic */ b67(BaseQuickAdapter baseQuickAdapter, OnItemClickListener onItemClickListener, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(baseQuickAdapter, onItemClickListener, (i & 4) != 0 ? null : l);
    }
}

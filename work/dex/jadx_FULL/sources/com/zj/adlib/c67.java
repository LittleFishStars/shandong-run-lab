package com.zj.adlib;

import android.view.View;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B#\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/zj/adlib/c67;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "onClick", "a", "Landroid/view/View$OnClickListener;", "clickListener", "", "J", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "b", "time", "view", "<init>", "(Landroid/view/View;Landroid/view/View$OnClickListener;Ljava/lang/Long;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class c67 implements View.OnClickListener {
    public static final long c = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long waitTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final View.OnClickListener clickListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public long time;

    public c67(@NotNull View view, @NotNull View.OnClickListener onClickListener, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.clickListener = onClickListener;
        this.waitTime = 1000L;
        if (l != null && l.longValue() >= 0) {
            this.waitTime = l.longValue();
        }
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.time) > this.waitTime) {
            this.clickListener.onClick(v);
            this.time = jCurrentTimeMillis;
        }
    }

    public /* synthetic */ c67(View view, View.OnClickListener onClickListener, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, onClickListener, (i & 4) != 0 ? null : l);
    }
}

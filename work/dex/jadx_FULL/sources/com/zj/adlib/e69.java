package com.zj.adlib;

import android.view.View;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B4\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR'\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/e69;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "onClick", "", "a", "J", "interval", "Ljava/util/concurrent/TimeUnit;", "Ljava/util/concurrent/TimeUnit;", "unit", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function1;", "block", "b", "lastTime", "<init>", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class e69 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long interval;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final TimeUnit unit;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public Function1<? super View, Unit> block;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public long lastTime;

    public e69(long j, @NotNull TimeUnit timeUnit, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.interval = j;
        this.unit = timeUnit;
        this.block = function1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastTime > this.unit.toMillis(this.interval)) {
            this.lastTime = jCurrentTimeMillis;
            this.block.invoke(v);
        }
    }

    public /* synthetic */ e69(long j, TimeUnit timeUnit, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 500L : j, (i & 2) != 0 ? TimeUnit.MILLISECONDS : timeUnit, function1);
    }
}

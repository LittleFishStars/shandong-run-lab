package com.zj.adlib;

import android.view.View;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u001a@\u0010\t\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000e\u001a\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000b2\u0006\u0010\r\u001a\u00020\f\u001a\u001d\u0010\u0010\u001a\u00020\u0001\"\b\b\u0000\u0010\u000f*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"2\u0010\u0018\u001a\u00020\u0012\"\b\b\u0000\u0010\u000f*\u00020\u0000*\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\"2\u0010\u001b\u001a\u00020\u0012\"\b\b\u0000\u0010\u000f*\u00020\u0000*\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroid/view/View;", "", "hideSoft", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "", t.d, "e", "(Landroid/view/View;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, y6b.g, "T", "b", "(Landroid/view/View;)Z", "", "value", "d", "(Landroid/view/View;)J", "j", "(Landroid/view/View;J)V", "triggerLastTime", "c", "i", "triggerDelay", "common_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nViewExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewExt.kt\ncom/huachenjie/common/util/ViewExtKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n1855#2,2:54\n*S KotlinDebug\n*F\n+ 1 ViewExt.kt\ncom/huachenjie/common/util/ViewExtKt\n*L\n26#1:54,2\n*E\n"})
public final class sq9 {
    public static final <T extends View> boolean b(T t) {
        if (System.currentTimeMillis() - d(t) < c(t)) {
            return false;
        }
        j(t, System.currentTimeMillis());
        return true;
    }

    public static final <T extends View> long c(T t) {
        if (t.getTag(1123461123) == null) {
            return -1L;
        }
        Object tag = t.getTag(1123461123);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    public static final <T extends View> long d(T t) {
        if (t.getTag(1123460103) == null) {
            return 0L;
        }
        Object tag = t.getTag(1123460103);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) tag).longValue();
    }

    public static final void e(@NotNull final View view, @Nullable final Boolean bool, @NotNull final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, t.d);
        i(view, 400L);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.rq9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                sq9.g(view, bool, function1, view2);
            }
        });
    }

    public static /* synthetic */ void f(View view, Boolean bool, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.TRUE;
        }
        e(view, bool, function1);
    }

    public static final void g(View view, Boolean bool, Function1 function1, View view2) {
        Intrinsics.checkNotNullParameter(view, "$this_onAvoidFastClick");
        Intrinsics.checkNotNullParameter(function1, "$l");
        if (!b(view)) {
            i4a.b("onAvoidFastClick", "点击频率太快，已拦截");
            return;
        }
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            KeyboardUtils.k(view);
        }
        Intrinsics.checkNotNullExpressionValue(view2, o.f);
        function1.invoke(view2);
        i4a.b("onAvoidFastClick", "点击事件已处理");
    }

    public static final void h(@NotNull List<? extends View> list, @NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public static final <T extends View> void i(T t, long j) {
        t.setTag(1123461123, Long.valueOf(j));
    }

    public static final <T extends View> void j(T t, long j) {
        t.setTag(1123460103, Long.valueOf(j));
    }
}

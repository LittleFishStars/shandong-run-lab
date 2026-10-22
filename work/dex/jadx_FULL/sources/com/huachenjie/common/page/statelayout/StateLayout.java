package com.huachenjie.common.page.statelayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.common.R;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.zj.adlib.d69;
import com.zj.adlib.tq8;
import com.zj.adlib.y6b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 m2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010g\u001a\u00020\f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\b\b\u0002\u0010j\u001a\u00020#¢\u0006\u0004\bk\u0010lJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0014J6\u0010\u0017\u001a\u00020\u00002.\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u0016J6\u0010\u0018\u001a\u00020\u00002.\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u0016J6\u0010\u0019\u001a\u00020\u00002.\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u0016J6\u0010\u001a\u001a\u00020\u00002.\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u0016J6\u0010\u001b\u001a\u00020\u00002.\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u0016J&\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\rJ\u0012\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010 \u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0014\u0010%\u001a\u00020\u00002\f\b\u0001\u0010$\u001a\u00020\"\"\u00020#J\u0006\u0010&\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\bJ\u0010\u0010*\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020#R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010/R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010/R$\u00107\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010;\u001a\u0004\u0018\u00010\"8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b,\u00108\u001a\u0004\b9\u0010:RF\u0010\u0017\u001a,\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00168B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\b=\u0010>RF\u0010\u0018\u001a,\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00168B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000b\u0010<\u001a\u0004\b?\u0010>RF\u0010\u001b\u001a,\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00168B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000e\u0010<\u001a\u0004\b@\u0010>RF\u0010\u0019\u001a,\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00168B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\bA\u0010>R@\u0010\u001a\u001a,\u0012\u0004\u0012\u00020\u0000\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010<R\"\u0010E\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00108\u001a\u0004\bB\u0010:\"\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010R\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010/\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010S\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010T\u001a\u0004\bU\u0010VR*\u0010^\u001a\u00020#2\u0006\u0010W\u001a\u00020#8F@FX\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R*\u0010b\u001a\u00020#2\u0006\u0010W\u001a\u00020#8F@FX\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010Y\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R*\u0010f\u001a\u00020#2\u0006\u0010W\u001a\u00020#8F@FX\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010[\"\u0004\be\u0010]¨\u0006n"}, d2 = {"Lcom/huachenjie/common/page/statelayout/StateLayout;", "Landroid/widget/FrameLayout;", "Lcom/huachenjie/common/page/statelayout/Status;", "status", "", "tag", "", y6b.f, "Landroid/view/View;", y6b.g, "d", "b", "Landroid/content/Context;", "", "c", "Lkotlin/Function0;", "block", "e", "onFinishInflate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "onEmpty", TriverEmbedVideoView.b, "onLoading", d.q, "onContent", NotificationCompat.GROUP_KEY_SILENT, d.x, RVParams.LONG_SHOW_LOADING, "showEmpty", "showError", "showContent", "", "", "ids", "setRetryIds", "trigger", "view", "setContentView", "state", "setState", "Landroidx/collection/ArrayMap;", "a", "Landroidx/collection/ArrayMap;", "views", "Z", "stateChanged", "Lcom/huachenjie/common/page/statelayout/ConvertInterface;", "Lcom/huachenjie/common/page/statelayout/ConvertInterface;", "getConvertInterface", "()Lcom/huachenjie/common/page/statelayout/ConvertInterface;", "setConvertInterface", "(Lcom/huachenjie/common/page/statelayout/ConvertInterface;)V", "convertInterface", "[I", "getRetryIds", "()[I", "retryIds", "Lkotlin/jvm/functions/Function2;", "getOnEmpty", "()Lkotlin/jvm/functions/Function2;", "getOnError", "getOnContent", "getOnLoading", "getFilterContentViewIds", "setFilterContentViewIds", "([I)V", "filterContentViewIds", "", "f", "Ljava/lang/String;", "getEmptyLabel", "()Ljava/lang/String;", "setEmptyLabel", "(Ljava/lang/String;)V", "emptyLabel", "getLoaded", "()Z", "setLoaded", "(Z)V", "loaded", "<set-?>", "Lcom/huachenjie/common/page/statelayout/Status;", "getStatus", "()Lcom/huachenjie/common/page/statelayout/Status;", "value", "K", "I", "getErrorLayout", "()I", "setErrorLayout", "(I)V", "errorLayout", "L", "getEmptyLayout", "setEmptyLayout", "emptyLayout", "M", "getLoadingLayout", "setLoadingLayout", "loadingLayout", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStateLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateLayout.kt\ncom/huachenjie/common/page/statelayout/StateLayout\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,473:1\n215#2:474\n216#2:479\n1295#3,2:475\n1295#3,2:477\n1#4:480\n*S KotlinDebug\n*F\n+ 1 StateLayout.kt\ncom/huachenjie/common/page/statelayout/StateLayout\n*L\n331#1:474\n331#1:479\n336#1:475,2\n344#1:477,2\n*E\n"})
public final class StateLayout extends FrameLayout {
    public static final int STATE_EMPTY = 2;
    public static final int STATE_ERROR = 3;
    public static final int STATE_LOADING = 4;
    public static final int STATE_NORMAL = 1;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    @LayoutRes
    public int errorLayout;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    @LayoutRes
    public int emptyLayout;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    @LayoutRes
    public int loadingLayout;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayMap<Status, View> views;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ConvertInterface convertInterface;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public Status status;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Function2<? super View, Object, Unit> onEmpty;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean refresh;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public int[] retryIds;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Function2<? super View, Object, Unit> onError;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean stateChanged;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public int[] filterContentViewIds;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public Function2<? super View, Object, Unit> onContent;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean trigger;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public Function2<? super View, Object, Unit> onLoading;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    public boolean loaded;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public Function2<? super StateLayout, Object, Unit> onRefresh;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String emptyLabel;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33833a;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f33833a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StateLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void f(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$block");
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnContent() {
        Function2 function2 = this.onContent;
        return function2 == null ? tq8.f19882a.g() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnEmpty() {
        Function2 function2 = this.onEmpty;
        return function2 == null ? tq8.f19882a.h() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnError() {
        Function2 function2 = this.onError;
        return function2 == null ? tq8.f19882a.i() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<View, Object, Unit> getOnLoading() {
        Function2 function2 = this.onLoading;
        return function2 == null ? tq8.f19882a.j() : function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] getRetryIds() {
        int[] iArr = this.retryIds;
        return iArr == null ? tq8.f19882a.k() : iArr;
    }

    public static /* synthetic */ void show$default(StateLayout stateLayout, Status status, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        stateLayout.g(status, obj);
    }

    public static /* synthetic */ void showContent$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showContent(obj);
    }

    public static /* synthetic */ void showEmpty$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showEmpty(obj);
    }

    public static /* synthetic */ void showError$default(StateLayout stateLayout, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        stateLayout.showError(obj);
    }

    public static /* synthetic */ void showLoading$default(StateLayout stateLayout, Object obj, boolean z, boolean z2, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        stateLayout.showLoading(obj, z, z2);
    }

    public final View b(Status status) throws NullPointerException {
        int emptyLayout;
        View view = this.views.get(status);
        if (view != null) {
            ConvertInterface convertInterface = this.convertInterface;
            if (convertInterface != null) {
                convertInterface.a(status, view);
            }
            return view;
        }
        int[] iArr = b.f33833a;
        int i = iArr[status.ordinal()];
        if (i == 1) {
            emptyLayout = getEmptyLayout();
        } else if (i != 2) {
            emptyLayout = i != 3 ? -1 : getLoadingLayout();
        } else {
            emptyLayout = getErrorLayout();
        }
        if (emptyLayout == -1) {
            int i2 = iArr[status.ordinal()];
            if (i2 == 1) {
                throw new Resources.NotFoundException("No StateLayout emptyLayout is set");
            }
            if (i2 == 2) {
                throw new Resources.NotFoundException("No StateLayout errorLayout is set");
            }
            if (i2 != 3) {
                throw new Resources.NotFoundException("No StateLayout contentView is set");
            }
            throw new Resources.NotFoundException("No StateLayout loadingLayout is set");
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(emptyLayout, (ViewGroup) this, false);
        ConvertInterface convertInterface2 = this.convertInterface;
        if (convertInterface2 != null) {
            convertInterface2.a(status, viewInflate);
        }
        addView(viewInflate);
        this.views.put(status, viewInflate);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return viewInflate;
    }

    public final boolean c(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public final void d(Status status) {
        View viewRemove = this.views.remove(status);
        if (viewRemove != null) {
            removeView(viewRemove);
        }
    }

    public final void e(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.wq8
                @Override // java.lang.Runnable
                public final void run() {
                    StateLayout.f(block);
                }
            });
        }
    }

    public final void g(final Status status, final Object tag) {
        if (this.trigger) {
            this.stateChanged = true;
        }
        this.status = status;
        e(new Function0<Unit>() { // from class: com.huachenjie.common.page.statelayout.StateLayout$show$1

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f33834a;

                static {
                    int[] iArr = new int[Status.values().length];
                    try {
                        iArr[Status.EMPTY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Status.ERROR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Status.LOADING.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f33834a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m351invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m351invoke() {
                TextView textView;
                Function2 function2;
                try {
                    View viewH = this.this$0.h(status);
                    int i = a.f33834a[status.ordinal()];
                    int i2 = 0;
                    if (i == 1) {
                        int[] retryIds = this.this$0.getRetryIds();
                        if (retryIds != null) {
                            final StateLayout stateLayout = this.this$0;
                            int length = retryIds.length;
                            while (i2 < length) {
                                View viewFindViewById = viewH.findViewById(retryIds[i2]);
                                if (viewFindViewById != null) {
                                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(it)");
                                    d69.b(viewFindViewById, 0L, null, new Function1<View, Unit>() { // from class: com.huachenjie.common.page.statelayout.StateLayout$show$1$1$1
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((View) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(@NotNull View view) {
                                            Intrinsics.checkNotNullParameter(view, "$this$throttleClick");
                                            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
                                        }
                                    }, 3, null);
                                }
                                i2++;
                            }
                        }
                        Function2 onEmpty = this.this$0.getOnEmpty();
                        if (onEmpty != null) {
                            onEmpty.invoke(viewH, tag);
                        }
                        String emptyLabel = this.this$0.getEmptyLabel();
                        if (emptyLabel != null && (textView = (TextView) viewH.findViewById(R.id.tv_empty)) != null) {
                            textView.setText(emptyLabel);
                            return;
                        }
                        return;
                    }
                    if (i != 2) {
                        if (i != 3) {
                            this.this$0.setLoaded(true);
                            Function2 onContent = this.this$0.getOnContent();
                            if (onContent != null) {
                                onContent.invoke(viewH, tag);
                                return;
                            }
                            return;
                        }
                        Function2 onLoading = this.this$0.getOnLoading();
                        if (onLoading != null) {
                            onLoading.invoke(viewH, tag);
                        }
                        if (!this.this$0.refresh || (function2 = this.this$0.onRefresh) == null) {
                            return;
                        }
                        function2.invoke(this.this$0, tag);
                        return;
                    }
                    int[] retryIds2 = this.this$0.getRetryIds();
                    if (retryIds2 != null) {
                        final StateLayout stateLayout2 = this.this$0;
                        final Object obj = tag;
                        int length2 = retryIds2.length;
                        while (i2 < length2) {
                            View viewFindViewById2 = viewH.findViewById(retryIds2[i2]);
                            if (viewFindViewById2 != null) {
                                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(it)");
                                d69.b(viewFindViewById2, 0L, null, new Function1<View, Unit>() { // from class: com.huachenjie.common.page.statelayout.StateLayout$show$1$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((View) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull View view) {
                                        Intrinsics.checkNotNullParameter(view, "$this$throttleClick");
                                        stateLayout2.showLoading(obj, true, true);
                                    }
                                }, 3, null);
                            }
                            i2++;
                        }
                    }
                    Function2 onError = this.this$0.getOnError();
                    if (onError != null) {
                        onError.invoke(viewH, tag);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Nullable
    public final ConvertInterface getConvertInterface() {
        return this.convertInterface;
    }

    @Nullable
    public final String getEmptyLabel() {
        return this.emptyLabel;
    }

    public final int getEmptyLayout() {
        int i = this.emptyLayout;
        return i == -1 ? tq8.a() : i;
    }

    public final int getErrorLayout() {
        int i = this.errorLayout;
        return i == -1 ? tq8.c() : i;
    }

    @NotNull
    public final int[] getFilterContentViewIds() {
        return this.filterContentViewIds;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final int getLoadingLayout() {
        int i = this.loadingLayout;
        return i == -1 ? tq8.e() : i;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    public final View h(Status status) {
        Sequence<View> children;
        View viewB = b(status);
        for (Map.Entry<Status, View> entry : this.views.entrySet()) {
            View value = entry.getValue();
            if (status == entry.getKey()) {
                value.setVisibility(0);
                if (status == Status.CONTENT) {
                    ViewGroup viewGroup = value instanceof ViewGroup ? (ViewGroup) value : null;
                    if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null) {
                        for (View view : children) {
                            if (!ArraysKt.contains(this.filterContentViewIds, view.getId())) {
                                view.setVisibility(0);
                            }
                        }
                    }
                }
            } else {
                if (entry.getKey() == Status.CONTENT && (value instanceof ViewGroup)) {
                    if (!(this.filterContentViewIds.length == 0)) {
                        for (View view2 : ViewGroupKt.getChildren((ViewGroup) value)) {
                            if (!ArraysKt.contains(this.filterContentViewIds, view2.getId())) {
                                view2.setVisibility(8);
                            }
                        }
                    }
                }
                value.setVisibility(8);
            }
        }
        return viewB;
    }

    @NotNull
    public final StateLayout onContent(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onContent = block;
        return this;
    }

    @NotNull
    public final StateLayout onEmpty(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onEmpty = block;
        return this;
    }

    @NotNull
    public final StateLayout onError(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onError = block;
        return this;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1 || getChildCount() == 0) {
            throw new UnsupportedOperationException("StateLayout only have one child view");
        }
        if (this.views.size() == 0) {
            View childAt = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "view");
            setContentView(childAt);
        }
    }

    @NotNull
    public final StateLayout onLoading(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onLoading = block;
        return this;
    }

    @NotNull
    public final StateLayout onRefresh(@NotNull Function2<? super StateLayout, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.onRefresh = block;
        return this;
    }

    public final void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.views.put(Status.CONTENT, view);
    }

    public final void setConvertInterface(@Nullable ConvertInterface convertInterface) {
        this.convertInterface = convertInterface;
    }

    public final void setEmptyLabel(@Nullable String str) {
        this.emptyLabel = str;
    }

    public final void setEmptyLayout(int i) {
        if (this.emptyLayout != i) {
            d(Status.EMPTY);
            this.emptyLayout = i;
        }
    }

    public final void setErrorLayout(int i) {
        if (this.errorLayout != i) {
            d(Status.ERROR);
            this.errorLayout = i;
        }
    }

    public final void setFilterContentViewIds(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.filterContentViewIds = iArr;
    }

    public final void setLoaded(boolean z) {
        this.loaded = z;
    }

    public final void setLoadingLayout(int i) {
        if (this.loadingLayout != i) {
            d(Status.LOADING);
            this.loadingLayout = i;
        }
    }

    @NotNull
    public final StateLayout setRetryIds(@IdRes @NotNull int... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.retryIds = ids;
        return this;
    }

    public final void setState(@IntRange(from = 1, to = 4) int state) {
        if (state == 1) {
            showContent$default(this, null, 1, null);
            return;
        }
        if (state == 2) {
            showEmpty$default(this, null, 1, null);
            return;
        }
        if (state == 3) {
            showError$default(this, null, 1, null);
        } else if (state != 4) {
            showContent$default(this, null, 1, null);
        } else {
            showLoading$default(this, null, false, false, 7, null);
        }
    }

    public final void showContent(@Nullable Object tag) {
        if (this.trigger && this.stateChanged) {
            return;
        }
        g(Status.CONTENT, tag);
    }

    public final void showEmpty(@Nullable Object tag) {
        g(Status.EMPTY, tag);
    }

    public final void showError(@Nullable Object tag) {
        g(Status.ERROR, tag);
    }

    public final void showLoading(@Nullable Object tag, boolean silent, boolean refresh) {
        this.refresh = refresh;
        if (silent && refresh) {
            Function2<? super StateLayout, Object, Unit> function2 = this.onRefresh;
            if (function2 != null) {
                function2.invoke(this, tag);
                return;
            }
            return;
        }
        Status status = this.status;
        Status status2 = Status.LOADING;
        if (status != status2) {
            g(status2, tag);
            return;
        }
        Function2<View, Object, Unit> onLoading = getOnLoading();
        if (onLoading != null) {
            onLoading.invoke(b(status2), tag);
        }
    }

    public final boolean trigger() {
        boolean z = !this.trigger;
        this.trigger = z;
        if (!z) {
            this.stateChanged = false;
        }
        return z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.views = new ArrayMap<>();
        this.refresh = true;
        this.filterContentViewIds = new int[0];
        this.status = Status.CONTENT;
        this.errorLayout = -1;
        this.emptyLayout = -1;
        this.loadingLayout = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StateLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.StateLayout)");
        try {
            setEmptyLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_empty_layout, R.layout.view_state_empty_view));
            setErrorLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_error_layout, R.layout.view_state_error_view));
            setLoadingLayout(typedArrayObtainStyledAttributes.getResourceId(R.styleable.StateLayout_loading_layout, R.layout.view_state_loading_view));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}

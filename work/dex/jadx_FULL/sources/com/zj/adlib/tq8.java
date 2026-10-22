package com.zj.adlib;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b+\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u0010-J)\u0010\u0007\u001a\u00020\u00042\u001f\u0010\u0006\u001a\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0007J)\u0010\b\u001a\u00020\u00042\u001f\u0010\u0006\u001a\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0007J)\u0010\t\u001a\u00020\u00042\u001f\u0010\u0006\u001a\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0007J)\u0010\n\u001a\u00020\u00042\u001f\u0010\u0006\u001a\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\f\b\u0001\u0010\r\u001a\u00020\u000b\"\u00020\fH\u0007R$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R=\u0010\u001b\u001a\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR=\u0010\u001f\u001a\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR=\u0010#\u001a\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR=\u0010'\u001a\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR(\u0010.\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010(\u0012\u0004\b,\u0010-\u001a\u0004\b \u0010)\"\u0004\b*\u0010+R(\u00101\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010(\u0012\u0004\b0\u0010-\u001a\u0004\b\u000f\u0010)\"\u0004\b/\u0010+R(\u00105\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b \u0010(\u0012\u0004\b4\u0010-\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+¨\u00067"}, d2 = {"Lcom/zj/adlib/tq8;", "", "Lkotlin/Function2;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "block", "m", "n", t.d, j.b, "", "", "ids", "w", "a", "[I", "k", "()[I", "x", "([I)V", "retryIds", "Lkotlin/jvm/functions/Function2;", y6b.g, "()Lkotlin/jvm/functions/Function2;", "t", "(Lkotlin/jvm/functions/Function2;)V", "onEmpty", "b", "i", "u", TriverEmbedVideoView.b, "c", "j", "v", "onLoading", "d", y6b.f, "s", "onContent", "I", "()I", "q", "(I)V", "getErrorLayout$annotations", "()V", "errorLayout", "p", "getEmptyLayout$annotations", "emptyLayout", "e", "r", "getLoadingLayout$annotations", "loadingLayout", "<init>", "common_release"}, k = 1, mv = {1, 8, 0})
public final class tq8 {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static Function2<? super View, Object, Unit> onEmpty;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static int[] retryIds;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static Function2<? super View, Object, Unit> onError;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public static Function2<? super View, Object, Unit> onLoading;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public static Function2<? super View, Object, Unit> onContent;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final tq8 f19882a = new tq8();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @LayoutRes
    public static int errorLayout = -1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @LayoutRes
    public static int emptyLayout = -1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @LayoutRes
    public static int loadingLayout = -1;

    public static final int a() {
        return emptyLayout;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    public static final int c() {
        return errorLayout;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    public static final int e() {
        return loadingLayout;
    }

    @JvmStatic
    public static /* synthetic */ void f() {
    }

    @JvmStatic
    public static final void l(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onContent = block;
    }

    @JvmStatic
    public static final void m(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onEmpty = block;
    }

    @JvmStatic
    public static final void n(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onError = block;
    }

    @JvmStatic
    public static final void o(@NotNull Function2<? super View, Object, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        onLoading = block;
    }

    public static final void p(int i) {
        emptyLayout = i;
    }

    public static final void q(int i) {
        errorLayout = i;
    }

    public static final void r(int i) {
        loadingLayout = i;
    }

    @JvmStatic
    public static final void w(@IdRes @NotNull int... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        retryIds = ids;
    }

    @Nullable
    public final Function2<View, Object, Unit> g() {
        return onContent;
    }

    @Nullable
    public final Function2<View, Object, Unit> h() {
        return onEmpty;
    }

    @Nullable
    public final Function2<View, Object, Unit> i() {
        return onError;
    }

    @Nullable
    public final Function2<View, Object, Unit> j() {
        return onLoading;
    }

    @Nullable
    public final int[] k() {
        return retryIds;
    }

    public final void s(@Nullable Function2<? super View, Object, Unit> function2) {
        onContent = function2;
    }

    public final void t(@Nullable Function2<? super View, Object, Unit> function2) {
        onEmpty = function2;
    }

    public final void u(@Nullable Function2<? super View, Object, Unit> function2) {
        onError = function2;
    }

    public final void v(@Nullable Function2<? super View, Object, Unit> function2) {
        onLoading = function2;
    }

    public final void x(@Nullable int[] iArr) {
        retryIds = iArr;
    }
}

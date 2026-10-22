package com.zj.adlib;

import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.ali.auth.third.login.LoginConstants;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.util.intercept.ActionIntercept;
import com.huachenjie.common.util.intercept.DialogIntercept;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b+\u0010,J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\rH\u0002R\u0014\u0010!\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010#¨\u0006-"}, d2 = {"Lcom/zj/adlib/tm2;", "", "", "weight", "", j.b, "Lcom/huachenjie/common/util/intercept/DialogIntercept;", "dialogIntercept", "c", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "dialog", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "show", "e", "index", "d", "k", "m", "i", "n", y6b.g, "p", y6b.f, "j", "f", "operation", t.d, "a", "Ljava/lang/String;", "TAG", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "sparseArray", "Lcom/huachenjie/common/util/intercept/DialogIntercept;", "firstIntercept", "I", "maxWeight", "b", "queueDialog", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class tm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static tm2 f19852a = null;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public DialogIntercept firstIntercept;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String TAG = "InterceptHandler";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SparseArray<DialogIntercept> sparseArray = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int maxWeight = 4;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SparseArray<DialogIntercept> queueDialog = new SparseArray<>();

    /* JADX INFO: renamed from: com.zj.adlib.tm2$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/tm2$a;", "", "Lcom/zj/adlib/tm2;", "a", "", "WEIGHT_BACK_TO_SCHOOL", "I", "WEIGHT_OFFICIAL_NOTICE", "WEIGHT_SEASON_REWARDS", "WEIGHT_SEASON_START", "mInstance", "Lcom/zj/adlib/tm2;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final tm2 a() {
            if (tm2.f19852a == null) {
                tm2.f19852a = new tm2();
            }
            tm2 tm2Var = tm2.f19852a;
            Intrinsics.checkNotNull(tm2Var, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.DialogInterceptHandler");
            return tm2Var;
        }
    }

    public final void c(@NotNull DialogIntercept dialogIntercept, int weight) {
        Intrinsics.checkNotNullParameter(dialogIntercept, "dialogIntercept");
        d(dialogIntercept, weight, 0);
    }

    public final void d(@NotNull DialogIntercept dialogIntercept, int weight, int index) {
        Intrinsics.checkNotNullParameter(dialogIntercept, "dialogIntercept");
        i4a.b(this.TAG, "add weight:" + weight);
        this.sparseArray.put(k(weight, index), dialogIntercept);
    }

    public final void e(@NotNull BaseDialogFragment dialog, @NotNull FragmentManager fragmentManager, @NotNull String tag, int weight, boolean show) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (show) {
            c(new pl3(dialog, fragmentManager, tag), weight);
        } else {
            o(weight);
        }
        m();
    }

    public final void f() {
        ActionIntercept actionIntercept = null;
        int i = 0;
        int i2 = 0;
        while (i <= this.maxWeight && this.sparseArray.size() != 0) {
            i4a.b(this.TAG, "index:" + k(i, i2));
            DialogIntercept dialogIntercept = this.sparseArray.get(k(i, i2));
            if (dialogIntercept == null || !(dialogIntercept instanceof pl3)) {
                i++;
                i2 = 0;
            } else {
                if (this.firstIntercept == null) {
                    this.firstIntercept = dialogIntercept;
                }
                if (actionIntercept != null) {
                    actionIntercept.a(dialogIntercept);
                }
                this.sparseArray.remove(i2);
                i2++;
                actionIntercept = dialogIntercept;
            }
        }
    }

    public final boolean g() {
        i4a.b(this.TAG, "checkAddFinish start");
        int i = 1;
        while (i <= this.maxWeight) {
            i4a.b(this.TAG, "weight:" + k(i, 0));
            DialogIntercept dialogIntercept = this.sparseArray.get(k(i, 0));
            i++;
            if (dialogIntercept == null) {
                l(i - 1, "intercept is null");
                return false;
            }
        }
        return true;
    }

    public final void h() {
        this.queueDialog.clear();
    }

    public final void i() {
        SparseArray<DialogIntercept> sparseArray = this.sparseArray;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public final void j() {
        for (int i = 0; i <= this.maxWeight; i++) {
            o(i);
        }
    }

    public final int k(int weight, int index) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight must greater than 0");
        }
        if (index > 99 || index < 0) {
            throw new IllegalArgumentException("The index must be 0 to 99");
        }
        return (weight * 100) + index;
    }

    public final void l(int weight, String operation) {
        if (weight == 1) {
            i4a.b(this.TAG, operation + "：官方公告");
            return;
        }
        if (weight == 2) {
            i4a.b(this.TAG, operation + "：返校奖励");
            return;
        }
        if (weight == 3) {
            i4a.b(this.TAG, operation + "：赛季开始");
            return;
        }
        if (weight != 4) {
            return;
        }
        i4a.b(this.TAG, operation + "：赛季奖励");
    }

    public final void m() {
        i4a.b(this.TAG, "proceed");
        if (g()) {
            f();
            i4a.b(this.TAG, "adjustDialogOrder Finish:" + (this.firstIntercept == null));
            DialogIntercept dialogIntercept = this.firstIntercept;
            if (dialogIntercept != null) {
                dialogIntercept.d();
            }
            this.sparseArray.clear();
            j();
            this.firstIntercept = null;
        }
    }

    public final void n(@NotNull BaseDialogFragment dialog, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        int size = this.queueDialog.size();
        this.queueDialog.put(size, new pl3(dialog, fragmentManager, dialog.getClass().getSimpleName() + LoginConstants.UNDER_LINE + size));
    }

    public final void o(int weight) {
        d(new c13(), weight, 0);
    }

    public final void p() {
        int size = this.queueDialog.size();
        DialogIntercept dialogIntercept = null;
        DialogIntercept dialogIntercept2 = null;
        for (int i = 0; i < size; i++) {
            DialogIntercept dialogIntercept3 = this.queueDialog.get(i);
            if (dialogIntercept3 != null && (dialogIntercept3 instanceof pl3)) {
                if (dialogIntercept == null) {
                    dialogIntercept = dialogIntercept3;
                }
                if (dialogIntercept2 != null) {
                    dialogIntercept2.a(dialogIntercept3);
                }
                dialogIntercept2 = dialogIntercept3;
            }
        }
        if (dialogIntercept != null) {
            dialogIntercept.d();
        }
        h();
    }
}

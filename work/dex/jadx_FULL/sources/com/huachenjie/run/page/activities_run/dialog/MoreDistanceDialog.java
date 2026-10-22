package com.huachenjie.run.page.activities_run.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ruler.IScaleTransform;
import com.huachenjie.common.widget.ruler.VerticalRulerView;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogMoreDistanceBinding;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ai9;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\fR\u00020\u00000\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R&\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogMoreDistanceBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "checked", "", "updateRememberTextColor", "", "getWidth", "getHeight", "", "Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog$a;", "getVariables", "getLayoutResID", "onStart", "initView", "Lkotlin/Function1;", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function1;", "selKm", "I", "minMeters", "", "runPlanCode", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMoreDistanceDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoreDistanceDialog.kt\ncom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,244:1\n1#2:245\n*E\n"})
public final class MoreDistanceDialog extends BaseMVVMBottomDialogFragment<RunDialogMoreDistanceBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int INTEGER_OPTION_COUNT = 10;

    @NotNull
    private static final String KEY_CURRENT_SELECTED_KM = "key_current_selected_km";

    @NotNull
    private static final String KEY_MIN_DISTANCE_METERS = "key_min_distance_meters";

    @NotNull
    private static final String KEY_RUN_PLAN_CODE = "key_run_plan_code";

    @NotNull
    public static final String PREF_KEY_PREFIX = "key_ready_remember_distance_";

    @NotNull
    private static final String PREF_PLAN_SUFFIX = "_plan";
    private static final int SCALE_MIN = -1;
    private static final int SENTINEL_MIN_MODE = Integer.MIN_VALUE;

    @NotNull
    public static final String VALUE_MIN = "min";

    @NotNull
    public static final String VALUE_NO_GOAL = "0";

    @Nullable
    private Function1<? super Integer, Unit> callback;
    private int minMeters;

    @Nullable
    private String runPlanCode;
    private int selKm;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MoreDistanceDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            CheckBox checkBox;
            Intrinsics.checkNotNullParameter(view, "view");
            Companion companion = MoreDistanceDialog.INSTANCE;
            Integer numM = companion.m(MoreDistanceDialog.this.selKm);
            RunDialogMoreDistanceBinding runDialogMoreDistanceBindingAccess$getMBinding = MoreDistanceDialog.access$getMBinding(MoreDistanceDialog.this);
            boolean z = false;
            if (runDialogMoreDistanceBindingAccess$getMBinding != null && (checkBox = runDialogMoreDistanceBindingAccess$getMBinding.f35541a) != null && checkBox.isChecked()) {
                z = true;
            }
            if (z) {
                companion.l(MoreDistanceDialog.this.runPlanCode, numM);
            } else {
                companion.b();
            }
            Function1 function1 = MoreDistanceDialog.this.callback;
            if (function1 != null) {
                function1.invoke(numM);
            }
            MoreDistanceDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J!\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\r\u001a\u00020\tJC\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\u0002H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002R\u0014\u0010$\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010%R\u0014\u0010-\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010'¨\u00062"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog$b;", "", "", "runPlanCode", "k", "", "d", "", "pickedKm", "", t.d, "(Ljava/lang/String;Ljava/lang/Integer;)V", "j", "b", "minDistanceMeters", "currentSelectedKm", "Lkotlin/Function1;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog;", y6b.f, "(ILjava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog;", "minMeters", "f", "(I)I", "c", "", "", "a", "(I)Ljava/util/List;", "scaleKm", "m", "(I)Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;I)I", "n", "i", "INTEGER_OPTION_COUNT", "I", "KEY_CURRENT_SELECTED_KM", "Ljava/lang/String;", "KEY_MIN_DISTANCE_METERS", "KEY_RUN_PLAN_CODE", "PREF_KEY_PREFIX", "PREF_PLAN_SUFFIX", "SCALE_MIN", "SENTINEL_MIN_MODE", "VALUE_MIN", "VALUE_NO_GOAL", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nMoreDistanceDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MoreDistanceDialog.kt\ncom/huachenjie/run/page/activities_run/dialog/MoreDistanceDialog$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,244:1\n1#2:245\n*E\n"})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MoreDistanceDialog h(Companion companion, int i, Integer num, String str, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                num = null;
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            return companion.g(i, num, str, function1);
        }

        @NotNull
        public final List<Double> a(int minMeters) {
            int iC = c(minMeters);
            List listCreateListBuilder = CollectionsKt.createListBuilder(12);
            listCreateListBuilder.add(Double.valueOf(-1.0d));
            int i = iC + 10;
            while (iC < i) {
                listCreateListBuilder.add(Double.valueOf(iC));
                iC++;
            }
            listCreateListBuilder.add(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            return CollectionsKt.build(listCreateListBuilder);
        }

        public final void b() {
            ai9.p(n());
            ai9.p(i());
        }

        public final int c(int minMeters) {
            return RangesKt.coerceAtLeast(((int) Math.floor(((double) minMeters) / 1000.0d)) + 1, 1);
        }

        public final boolean d(@Nullable String runPlanCode) {
            String strK = k(runPlanCode);
            return !(strK == null || strK.length() == 0);
        }

        public final int e(@Nullable Integer currentSelectedKm, int minMeters) {
            int iC = c(minMeters);
            int i = (iC + 10) - 1;
            if (currentSelectedKm == null) {
                return -1;
            }
            if (currentSelectedKm.intValue() == 0) {
                return 0;
            }
            if (new IntRange(iC, i).contains(currentSelectedKm.intValue())) {
                return currentSelectedKm.intValue();
            }
            return -1;
        }

        public final int f(int minMeters) {
            return RangesKt.coerceAtLeast((int) Math.ceil(((double) minMeters) / 1000.0d), 1);
        }

        @NotNull
        public final MoreDistanceDialog g(int minDistanceMeters, @Nullable Integer currentSelectedKm, @Nullable String runPlanCode, @NotNull Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            MoreDistanceDialog moreDistanceDialog = new MoreDistanceDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(MoreDistanceDialog.KEY_MIN_DISTANCE_METERS, minDistanceMeters);
            bundle.putInt(MoreDistanceDialog.KEY_CURRENT_SELECTED_KM, currentSelectedKm != null ? currentSelectedKm.intValue() : Integer.MIN_VALUE);
            if (runPlanCode == null) {
                runPlanCode = "";
            }
            bundle.putString(MoreDistanceDialog.KEY_RUN_PLAN_CODE, runPlanCode);
            moreDistanceDialog.setArguments(bundle);
            moreDistanceDialog.callback = callback;
            return moreDistanceDialog;
        }

        public final String i() {
            return n() + MoreDistanceDialog.PREF_PLAN_SUFFIX;
        }

        public final void j(@Nullable String runPlanCode) {
            if (runPlanCode == null || runPlanCode.length() == 0) {
                return;
            }
            String strF = ai9.f(i());
            Intrinsics.checkNotNullExpressionValue(strF, "savedPlan");
            if (!(strF.length() > 0) || Intrinsics.areEqual(strF, runPlanCode)) {
                return;
            }
            b();
        }

        @Nullable
        public final String k(@Nullable String runPlanCode) {
            if ((runPlanCode == null || runPlanCode.length() == 0) || !Intrinsics.areEqual(ai9.f(i()), runPlanCode)) {
                return null;
            }
            String strF = ai9.f(n());
            Intrinsics.checkNotNullExpressionValue(strF, o.f);
            if (strF.length() > 0) {
                return strF;
            }
            return null;
        }

        public final void l(@Nullable String runPlanCode, @Nullable Integer pickedKm) {
            String string;
            if (runPlanCode == null || runPlanCode.length() == 0) {
                return;
            }
            if (pickedKm == null) {
                string = MoreDistanceDialog.VALUE_MIN;
            } else {
                string = pickedKm.intValue() == 0 ? "0" : pickedKm.toString();
            }
            ai9.t(n(), string);
            ai9.t(i(), runPlanCode);
        }

        @Nullable
        public final Integer m(int scaleKm) {
            if (scaleKm == -1) {
                return null;
            }
            if (scaleKm == 0) {
                return 0;
            }
            return Integer.valueOf(scaleKm);
        }

        public final String n() {
            String userId = ai9.e().getUserId();
            if (userId == null) {
                userId = "";
            }
            return MoreDistanceDialog.PREF_KEY_PREFIX + userId;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RunDialogMoreDistanceBinding access$getMBinding(MoreDistanceDialog moreDistanceDialog) {
        return (RunDialogMoreDistanceBinding) moreDistanceDialog.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initView$lambda$3(MoreDistanceDialog moreDistanceDialog, String str, Double d) {
        Intrinsics.checkNotNullParameter(moreDistanceDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$minKmText");
        int iDoubleValue = (int) d.doubleValue();
        if (iDoubleValue == -1) {
            return moreDistanceDialog.getString(R.string.run_ready_min_goal, str);
        }
        if (iDoubleValue == 0) {
            return moreDistanceDialog.getString(R.string.run_ready_no_goal);
        }
        return ((int) d.doubleValue()) + "km";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(MoreDistanceDialog moreDistanceDialog, double d) {
        Intrinsics.checkNotNullParameter(moreDistanceDialog, "this$0");
        moreDistanceDialog.selKm = (int) d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(MoreDistanceDialog moreDistanceDialog, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(moreDistanceDialog, "this$0");
        moreDistanceDialog.updateRememberTextColor(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateRememberTextColor(boolean checked) {
        CheckBox checkBox;
        RunDialogMoreDistanceBinding runDialogMoreDistanceBinding = (RunDialogMoreDistanceBinding) getMBinding();
        if (runDialogMoreDistanceBinding == null || (checkBox = runDialogMoreDistanceBinding.f35541a) == null) {
            return;
        }
        checkBox.setTextColor(ContextCompat.getColor(requireContext(), checked ? R.color.color_191F20 : R.color.color_757979));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_more_distance;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, a> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.k), new a()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        Integer numValueOf;
        VerticalRulerView verticalRulerView;
        BLTextView bLTextView;
        super.initView();
        Bundle arguments = getArguments();
        boolean z = false;
        this.minMeters = arguments != null ? arguments.getInt(KEY_MIN_DISTANCE_METERS) : 0;
        Bundle arguments2 = getArguments();
        this.runPlanCode = arguments2 != null ? arguments2.getString(KEY_RUN_PLAN_CODE) : null;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            numValueOf = Integer.valueOf(arguments3.getInt(KEY_CURRENT_SELECTED_KM, Integer.MIN_VALUE));
            if (numValueOf.intValue() == Integer.MIN_VALUE) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        List<Double> listA = INSTANCE.a(this.minMeters);
        final String strJ = ll7.f43096a.j(Long.valueOf(this.minMeters), false, true, true, 1);
        if (strJ == null) {
            strJ = "";
        }
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add((listA.get(i).doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : (listA.get(i).doubleValue() == AudioStats.AUDIO_AMPLITUDE_NONE ? 0 : -1)) == 0 ? getString(R.string.run_ready_more_distance_no_goal_hint, strJ) : "");
        }
        RunDialogMoreDistanceBinding runDialogMoreDistanceBinding = (RunDialogMoreDistanceBinding) getMBinding();
        if (runDialogMoreDistanceBinding == null || (verticalRulerView = runDialogMoreDistanceBinding.f11733a) == null) {
            return;
        }
        verticalRulerView.setExtraBelowCenter(true);
        verticalRulerView.setExtraItemTitlePaint(jj8.e(32.0f, requireContext()), jj8.e(20.0f, requireContext()), ContextCompat.getColor(requireContext(), R.color.color_979A9A));
        verticalRulerView.setConfig(CollectionsKt.toDoubleArray(listA), 1.0d, 0);
        verticalRulerView.setScaleTransform(new IScaleTransform() { // from class: com.zj.adlib.lr5
            @Override // com.huachenjie.common.widget.ruler.IScaleTransform
            public final String transform(Object obj) {
                return MoreDistanceDialog.initView$lambda$3(this.f43135a, strJ, (Double) obj);
            }
        });
        verticalRulerView.setExtraInfo(arrayList);
        Companion companion = INSTANCE;
        int iE = companion.e(numValueOf, this.minMeters);
        this.selKm = iE;
        verticalRulerView.setCurrentScaleValue(iE);
        verticalRulerView.setScrollFinishListener(new VerticalRulerView.ScrollFinishListener() { // from class: com.zj.adlib.mr5
            @Override // com.huachenjie.common.widget.ruler.VerticalRulerView.ScrollFinishListener
            public final void onScrollFinish(double d) {
                MoreDistanceDialog.initView$lambda$4(this.f43371a, d);
            }
        });
        RunDialogMoreDistanceBinding runDialogMoreDistanceBinding2 = (RunDialogMoreDistanceBinding) getMBinding();
        CheckBox checkBox = runDialogMoreDistanceBinding2 != null ? runDialogMoreDistanceBinding2.f35541a : null;
        if (checkBox != null) {
            checkBox.setChecked(companion.d(this.runPlanCode));
        }
        if (checkBox != null && checkBox.isChecked()) {
            z = true;
        }
        updateRememberTextColor(z);
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.nr5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    MoreDistanceDialog.initView$lambda$5(this.f43598a, compoundButton, z2);
                }
            });
        }
        RunDialogMoreDistanceBinding runDialogMoreDistanceBinding3 = (RunDialogMoreDistanceBinding) getMBinding();
        if (runDialogMoreDistanceBinding3 == null || (bLTextView = runDialogMoreDistanceBinding3.f11735a) == null) {
            return;
        }
        bLTextView.setText(com.huachenjie.common.R.string.ok);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.5f;
        window.setAttributes(window.getAttributes());
        window.addFlags(2);
    }
}

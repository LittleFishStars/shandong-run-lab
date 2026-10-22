package com.huachenjie.run.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogFaceRecognitionTipBinding;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.lk0;
import com.zj.adlib.nl8;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001\"\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogFaceRecognitionTipBinding;", "Lcom/huachenjie/run/dialog/FaceRecognitionTipViewModel;", "", "getWidth", "getHeight", "", "", "getVariables", "getLayoutResID", "", "initView", "initData", "onDestroyView", "totalTime$delegate", "Lkotlin/Lazy;", "getTotalTime", "()I", FaceRecognitionTipDialog.TOTAL_TIME, "leftTime$delegate", "getLeftTime", FaceRecognitionTipDialog.LEFT_TIME, "Lkotlin/Function0;", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "timeChange", "Lkotlin/jvm/functions/Function1;", "Landroid/os/Handler;", "handler$delegate", "getHandler", "()Landroid/os/Handler;", "handler", "com/huachenjie/run/dialog/FaceRecognitionTipDialog$c", "countDownRunnable", "Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog$c;", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class FaceRecognitionTipDialog extends BaseMVVMDialogFragment<RunDialogFaceRecognitionTipBinding, FaceRecognitionTipViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LEFT_TIME = "leftTime";

    @NotNull
    private static final String TOTAL_TIME = "totalTime";

    @Nullable
    private Function0<Unit> callback;

    @Nullable
    private Function1<? super Integer, Unit> timeChange;

    /* JADX INFO: renamed from: totalTime$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy totalTime = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.dialog.FaceRecognitionTipDialog$totalTime$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m613invoke() {
            return Integer.valueOf(this.this$0.requireArguments().getInt("totalTime"));
        }
    });

    /* JADX INFO: renamed from: leftTime$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftTime = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.dialog.FaceRecognitionTipDialog$leftTime$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m612invoke() {
            return Integer.valueOf(this.this$0.requireArguments().getInt("leftTime"));
        }
    });

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.run.dialog.FaceRecognitionTipDialog$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m611invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @NotNull
    private final c countDownRunnable = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Function0 function0 = FaceRecognitionTipDialog.this.callback;
            if (function0 != null) {
                function0.invoke();
            }
            FaceRecognitionTipDialog.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.FaceRecognitionTipDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog$b;", "", "", FaceRecognitionTipDialog.TOTAL_TIME, FaceRecognitionTipDialog.LEFT_TIME, "Lkotlin/Function1;", "", "timeChange", "Lkotlin/Function0;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/run/dialog/FaceRecognitionTipDialog;", "a", "", "LEFT_TIME", "Ljava/lang/String;", "TOTAL_TIME", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final FaceRecognitionTipDialog a(int totalTime, int leftTime, @NotNull Function1<? super Integer, Unit> timeChange, @NotNull Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(timeChange, "timeChange");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            FaceRecognitionTipDialog faceRecognitionTipDialog = new FaceRecognitionTipDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(FaceRecognitionTipDialog.TOTAL_TIME, totalTime);
            bundle.putInt(FaceRecognitionTipDialog.LEFT_TIME, leftTime);
            faceRecognitionTipDialog.setArguments(bundle);
            faceRecognitionTipDialog.timeChange = timeChange;
            faceRecognitionTipDialog.callback = callback;
            return faceRecognitionTipDialog;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/dialog/FaceRecognitionTipDialog$c", "Ljava/lang/Runnable;", "", "run", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MutableLiveData<Integer> mutableLiveDataI = FaceRecognitionTipDialog.access$getMViewModel(FaceRecognitionTipDialog.this).i();
            Integer value = FaceRecognitionTipDialog.access$getMViewModel(FaceRecognitionTipDialog.this).i().getValue();
            Intrinsics.checkNotNull(value);
            mutableLiveDataI.setValue(Integer.valueOf(value.intValue() - 1));
            Function1 function1 = FaceRecognitionTipDialog.this.timeChange;
            if (function1 != null) {
                function1.invoke(1);
            }
            Integer value2 = FaceRecognitionTipDialog.access$getMViewModel(FaceRecognitionTipDialog.this).i().getValue();
            Intrinsics.checkNotNull(value2);
            if (value2.intValue() > 0) {
                FaceRecognitionTipDialog.this.getHandler().postDelayed(this, 1000L);
            } else {
                fv5.b("跑步校验时间已经到啦，请继续运动哦~");
                FaceRecognitionTipDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    public static final /* synthetic */ FaceRecognitionTipViewModel access$getMViewModel(FaceRecognitionTipDialog faceRecognitionTipDialog) {
        return faceRecognitionTipDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    private final int getLeftTime() {
        return ((Number) this.leftTime.getValue()).intValue();
    }

    private final int getTotalTime() {
        return ((Number) this.totalTime.getValue()).intValue();
    }

    @JvmStatic
    @NotNull
    public static final FaceRecognitionTipDialog newInstance(int i, int i2, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function0<Unit> function0) {
        return INSTANCE.a(i, i2, function1, function0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_face_recognition_tip;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(76.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().j().setValue(Integer.valueOf(getTotalTime()));
        getMViewModel().i().setValue(Integer.valueOf(getLeftTime()));
        RunDialogFaceRecognitionTipBinding mBinding = getMBinding();
        SpanUtils.c0(mBinding != null ? mBinding.f35527a : null).a("请按照学校要求在 ").a(String.valueOf(getTotalTime())).t().G(RunIndexRecordAdapter.N).a(" 秒内进行跑步校验，未完成跑步校验本次跑步将无效！").p();
        getHandler().postDelayed(this.countDownRunnable, 1000L);
        nl8.e(requireContext()).m(R.raw.run_runing_face_recognition, -1L, true);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        setCancelable(false);
        super.initView();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        nl8.e(requireContext()).t();
        getHandler().removeCallbacksAndMessages(null);
        super.onDestroyView();
    }
}

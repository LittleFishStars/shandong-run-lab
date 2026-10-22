package com.huachenjie.run.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.reconfig.baseView.BaseBottomDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.FreePunchDialog;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.noober.background.view.BLTextView;
import com.zj.adlib.fe9;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/dialog/FreePunchDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "", "goGet", "", "buildDesc", "", "getWidth", "getHeight", "getLayoutResID", "initView", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class FreePunchDialog extends BaseBottomDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DESC = "使用后（单次消耗3免卡球），下一次阳光跑无需打卡，免去前往打卡点奔波的约束，更加自由选择跑步路线进行跑步锻炼。";

    @NotNull
    private static final String HIGHLIGHT = "无需打卡";

    @NotNull
    private static final String KEY_NUM = "KEY_NUM";

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.FreePunchDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/dialog/FreePunchDialog$a;", "", "", "num", "Lcom/huachenjie/run/dialog/FreePunchDialog;", "a", "Landroidx/fragment/app/FragmentManager;", "manager", "", "b", "", "DESC", "Ljava/lang/String;", "HIGHLIGHT", FreePunchDialog.KEY_NUM, "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nFreePunchDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FreePunchDialog.kt\ncom/huachenjie/run/dialog/FreePunchDialog$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FreePunchDialog a(int num) {
            FreePunchDialog freePunchDialog = new FreePunchDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(FreePunchDialog.KEY_NUM, num);
            freePunchDialog.setArguments(bundle);
            return freePunchDialog;
        }

        public final void b(@NotNull FragmentManager manager, int num) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            a(num).show(manager, Reflection.getOrCreateKotlinClass(FreePunchDialog.class).getSimpleName());
        }
    }

    private final CharSequence buildDesc() {
        int iIndexOf$default = StringsKt.indexOf$default(DESC, HIGHLIGHT, 0, false, 6, (Object) null);
        if (iIndexOf$default < 0) {
            return DESC;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(DESC);
        int i = iIndexOf$default + 4;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9118")), iIndexOf$default, i, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, i, 33);
        return spannableStringBuilder;
    }

    private final void goGet() {
        ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FreePunchDialog freePunchDialog, View view) {
        Intrinsics.checkNotNullParameter(freePunchDialog, "this$0");
        freePunchDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FreePunchDialog freePunchDialog, View view) {
        Intrinsics.checkNotNullParameter(freePunchDialog, "this$0");
        freePunchDialog.goGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(FreePunchDialog freePunchDialog, View view) {
        Intrinsics.checkNotNullParameter(freePunchDialog, "this$0");
        freePunchDialog.goGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(FreePunchDialog freePunchDialog, View view) {
        Intrinsics.checkNotNullParameter(freePunchDialog, "this$0");
        FragmentActivity activity = freePunchDialog.getActivity();
        RunIndexActivity runIndexActivity = activity instanceof RunIndexActivity ? (RunIndexActivity) activity : null;
        if (runIndexActivity != null) {
            runIndexActivity.D0(true);
        }
        freePunchDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_free_punch;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        BLTextView bLTextViewFindViewById;
        BLTextView bLTextViewFindViewById2;
        ImageView imageView;
        super.initView();
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt(KEY_NUM) : 0;
        View view = getView();
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.ivClose)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tm3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FreePunchDialog.initView$lambda$0(this.f44952a, view2);
                }
            });
        }
        View view2 = getView();
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.tvNum) : null;
        if (textView != null) {
            textView.setText("数量 " + i);
        }
        View view3 = getView();
        TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.tvDesc) : null;
        if (textView2 != null) {
            textView2.setText(buildDesc());
        }
        View view4 = getView();
        if (view4 != null && (bLTextViewFindViewById2 = view4.findViewById(R.id.btnGet)) != null) {
            bLTextViewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.um3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    FreePunchDialog.initView$lambda$1(this.f45177a, view5);
                }
            });
        }
        View view5 = getView();
        if (view5 == null || (bLTextViewFindViewById = view5.findViewById(R.id.tvUse)) == null) {
            return;
        }
        if (i < 3) {
            bLTextViewFindViewById.setText("去获取");
            bLTextViewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vm3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    FreePunchDialog.initView$lambda$4$lambda$2(this.f45386a, view6);
                }
            });
        } else {
            bLTextViewFindViewById.setText("使用");
            bLTextViewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wm3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    FreePunchDialog.initView$lambda$4$lambda$3(this.f45627a, view6);
                }
            });
        }
    }
}

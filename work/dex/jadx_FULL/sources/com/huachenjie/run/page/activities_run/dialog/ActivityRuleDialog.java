package com.huachenjie.run.page.activities_run.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.bean.ActivityRunRule;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogActivityRuleBinding;
import com.huachenjie.run.page.activities_run.dialog.ActivityRuleDialog;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ActivityRuleDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/run/page/activities_run/dialog/ActivityRuleDialogVm;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "Landroid/view/View;", "view", "onViewCreated", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityRuleDialog extends BaseVMDialogFragment<ActivityRuleDialogVm> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.ActivityRuleDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/ActivityRuleDialog$a;", "", "", "Lcom/huachenjie/common/bean/ActivityRunRule;", "data", "Lcom/huachenjie/run/page/activities_run/dialog/ActivityRuleDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ActivityRuleDialog a(@NotNull List<ActivityRunRule> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ActivityRuleDialog activityRuleDialog = new ActivityRuleDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ruleList", new ArrayList<>(data));
            activityRuleDialog.setArguments(bundle);
            return activityRuleDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ActivityRuleDialog activityRuleDialog, View view) {
        Intrinsics.checkNotNullParameter(activityRuleDialog, "this$0");
        activityRuleDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.run_dialog_activity_rule), Integer.valueOf(lk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) {
            return;
        }
        Object obj = requireArguments().get("ruleList");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<com.huachenjie.common.bean.ActivityRunRule>{ kotlin.collections.TypeAliasesKt.ArrayList<com.huachenjie.common.bean.ActivityRunRule> }");
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunDialogActivityRuleBinding");
        ((RunDialogActivityRuleBinding) binding).f35518a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityRuleDialog.onViewCreated$lambda$0(this.f40611a, view2);
            }
        });
        ViewDataBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunDialogActivityRuleBinding");
        LinearLayoutCompat linearLayoutCompat = ((RunDialogActivityRuleBinding) binding2).f11673a;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding as RunDialogActivityRuleBinding).llContent");
        for (ActivityRunRule activityRunRule : (ArrayList) obj) {
            activityRunRule.getTitle();
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setText(activityRunRule.getTitle());
            textView.setTextSize(2, 13.0f);
            Context context = textView.getContext();
            int i = R.color.black;
            textView.setTextColor(ContextCompat.getColor(context, i));
            textView.setTypeface(Typeface.defaultFromStyle(1));
            linearLayoutCompat.addView(textView);
            TextView textView2 = new TextView(getContext());
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView2.setText(activityRunRule.getContent());
            textView2.setTextSize(2, 13.0f);
            textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), i));
            linearLayoutCompat.addView(textView2);
        }
    }
}

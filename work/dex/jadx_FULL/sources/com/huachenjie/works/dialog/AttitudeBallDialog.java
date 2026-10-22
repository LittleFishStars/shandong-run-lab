package com.huachenjie.works.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.dialog.AttitudeBallDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/works/dialog/AttitudeBallDialog;", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "", "onViewCreated", "", "name$delegate", "Lkotlin/Lazy;", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AttitudeBallDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_NAME = "name";

    /* JADX INFO: renamed from: name$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy name = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.dialog.AttitudeBallDialog$name$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("name", "") : null;
            return string == null ? "" : string;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.dialog.AttitudeBallDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/dialog/AttitudeBallDialog$a;", "", "", "name", "Lcom/huachenjie/works/dialog/AttitudeBallDialog;", "a", "KEY_NAME", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AttitudeBallDialog a(@Nullable String name) {
            AttitudeBallDialog attitudeBallDialog = new AttitudeBallDialog();
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            attitudeBallDialog.setArguments(bundle);
            return attitudeBallDialog;
        }
    }

    private final String getName() {
        return (String) this.name.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(AttitudeBallDialog attitudeBallDialog, View view) {
        Intrinsics.checkNotNullParameter(attitudeBallDialog, "this$0");
        attitudeBallDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(AttitudeBallDialog attitudeBallDialog, View view) {
        Intrinsics.checkNotNullParameter(attitudeBallDialog, "this$0");
        attitudeBallDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.works_dialog_attitude_ball, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.md0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttitudeBallDialog.onCreateView$lambda$1$lambda$0(this.f43272a, view);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.ivClose);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nd0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AttitudeBallDialog.onViewCreated$lambda$3$lambda$2(this.f43495a, view2);
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.tvName);
        if (textView != null) {
            textView.setText(getName());
        }
    }
}

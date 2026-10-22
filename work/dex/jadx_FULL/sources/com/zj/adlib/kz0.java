package com.zj.adlib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.R;
import com.huachenjie.common.dialog.OnItemClickListener;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ(\u0010\u0011\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ*\u0010\u0012\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\tJ\"\u0010$\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010)R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010+R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010,R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010-R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010.¨\u00061"}, d2 = {"Lcom/zj/adlib/kz0;", "", "", y6b.g, "Lcom/zj/adlib/lz0;", "item", "c", "", "text", "Lcom/huachenjie/common/dialog/OnItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "f", "", "textColor", "", "textSize", ALPParamConstant.ITMEID, "d", "e", "Landroid/content/Context;", "context", "Landroid/app/Dialog;", y6b.f, "Landroid/view/View$OnClickListener;", "p", "cancelText", t.d, "cancelTextColor", "m", "cancelTextSize", "n", "onCancelClickListener", j.b, "Landroid/view/View;", "view", "dialog", "i", "", "a", "Ljava/util/List;", "itemList", "Landroid/view/View$OnClickListener;", "onClickListener", "Ljava/lang/String;", "I", "F", "Lcom/huachenjie/common/dialog/OnItemClickListener;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class kz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public View.OnClickListener onClickListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OnItemClickListener onCancelClickListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<lz0> itemList = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String cancelText = OptionsPickerHelper.e;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int cancelTextColor = Color.parseColor("#007AFF");

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public float cancelTextSize = 20.0f;

    /* JADX INFO: renamed from: com.zj.adlib.kz0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/zj/adlib/kz0$a;", "", "Lcom/zj/adlib/kz0;", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final kz0 a() {
            return new kz0();
        }
    }

    public static final void j(Dialog dialog, lz0 lz0Var, View view) {
        Intrinsics.checkNotNullParameter(lz0Var, "$bottomOptItem");
        if (dialog != null) {
            dialog.dismiss();
        }
        if (lz0Var.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.a java.lang.String() != null) {
            OnItemClickListener onItemClickListener = lz0Var.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.a java.lang.String();
            Intrinsics.checkNotNull(onItemClickListener);
            onItemClickListener.a();
        }
    }

    public static final void k(Dialog dialog, kz0 kz0Var, View view) {
        Intrinsics.checkNotNullParameter(kz0Var, "this$0");
        if (dialog != null) {
            dialog.dismiss();
        }
        OnItemClickListener onItemClickListener = kz0Var.onCancelClickListener;
        if (onItemClickListener != null) {
            Intrinsics.checkNotNull(onItemClickListener);
            onItemClickListener.a();
        }
    }

    @NotNull
    public final kz0 c(@NotNull lz0 item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.itemList.add(item);
        return this;
    }

    @NotNull
    public final kz0 d(@Nullable String text, int textColor, float textSize, int itemId) {
        this.itemList.add(new lz0(text, textColor, textSize, itemId));
        return this;
    }

    @NotNull
    public final kz0 e(@Nullable String text, int textColor, float textSize, @Nullable OnItemClickListener listener) {
        this.itemList.add(new lz0(text, textColor, textSize, listener));
        return this;
    }

    @NotNull
    public final kz0 f(@Nullable String text, @Nullable OnItemClickListener listener) {
        this.itemList.add(new lz0(text, this.cancelTextColor, this.cancelTextSize, listener));
        return this;
    }

    @NotNull
    public final Dialog g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_bottom_opt, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.….dialog_bottom_opt, null)");
        Dialog dialog = new Dialog(context, R.style.BottomDialogOptStyle);
        dialog.setContentView(viewInflate);
        i(context, viewInflate, dialog);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setGravity(81);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        return dialog;
    }

    public final void h() {
        this.itemList.clear();
    }

    public final void i(Context context, View view, final Dialog dialog) {
        view.setMinimumWidth(context.getResources().getDisplayMetrics().widthPixels);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.dialog_bottom_opt_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 57.0f, context.getResources().getDisplayMetrics()));
        layoutParams.gravity = 17;
        int size = this.itemList.size() - 1;
        int i = 0;
        for (final lz0 lz0Var : this.itemList) {
            TextView textView = new TextView(context);
            textView.setText(lz0Var.getText());
            textView.setTextColor(lz0Var.getTextColor());
            textView.setTextSize(lz0Var.getTextSize());
            textView.setGravity(17);
            if (lz0Var.getCom.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant.ITMEID java.lang.String() != 0) {
                textView.setId(lz0Var.getCom.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant.ITMEID java.lang.String());
            }
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            } else {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.iz0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        kz0.j(dialog, lz0Var, view2);
                    }
                });
            }
            linearLayout.addView(textView, layoutParams);
            if (i < size) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics()));
                View view2 = new View(context);
                view2.setBackgroundColor(-1118482);
                linearLayout.addView(view2, layoutParams2);
            }
            i++;
        }
        TextView textView2 = (TextView) view.findViewById(R.id.dialog_bottom_opt_cancel);
        textView2.setText(this.cancelText);
        textView2.setTextSize(this.cancelTextSize);
        textView2.setTextColor(this.cancelTextColor);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jz0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                kz0.k(dialog, this, view3);
            }
        });
    }

    @NotNull
    public final kz0 l(@NotNull String cancelText) {
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        this.cancelText = cancelText;
        return this;
    }

    @NotNull
    public final kz0 m(int cancelTextColor) {
        this.cancelTextColor = cancelTextColor;
        return this;
    }

    @NotNull
    public final kz0 n(float cancelTextSize) {
        this.cancelTextSize = cancelTextSize;
        return this;
    }

    @NotNull
    public final kz0 o(@Nullable OnItemClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
        return this;
    }

    @NotNull
    public final kz0 p(@Nullable View.OnClickListener listener) {
        this.onClickListener = listener;
        return this;
    }
}

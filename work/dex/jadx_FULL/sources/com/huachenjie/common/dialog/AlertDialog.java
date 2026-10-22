package com.huachenjie.common.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.zj.adlib.cr2;
import com.zj.adlib.fx7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 _2\u00020\u0001:\u0002`aB\u0007¢\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\"\u0010.\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\"\u00101\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\"\u00104\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010 \u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\"\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010&\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\"\u0010=\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001a\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR\"\u0010@\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010 \u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R\"\u0010C\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010&\u001a\u0004\bD\u0010(\"\u0004\bE\u0010*R\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR\"\u0010W\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010O\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR\"\u0010Z\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010Q\"\u0004\b\\\u0010S¨\u0006b"}, d2 = {"Lcom/huachenjie/common/dialog/AlertDialog;", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "", "initData", "Landroid/view/View;", "view", "initView", "", "id", "", "text", "", "textSize", "textColor", "setTextView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "onViewCreated", "onStart", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.p, "(Ljava/lang/String;)V", "titleSize", "F", "getTitleSize", "()F", "setTitleSize", "(F)V", RVParams.LONG_TITLE_COLOR, "I", "getTitleColor", "()I", "setTitleColor", "(I)V", "content", "getContent", "setContent", "contentSize", "getContentSize", "setContentSize", "contentColor", "getContentColor", "setContentColor", "cancel", "getCancel", "setCancel", "cancelSize", "getCancelSize", "setCancelSize", "cancelColor", "getCancelColor", "setCancelColor", "confirm", "getConfirm", "setConfirm", "confirmSize", "getConfirmSize", "setConfirmSize", "confirmColor", "getConfirmColor", "setConfirmColor", "", "useVertical", "Z", "getUseVertical", "()Z", "setUseVertical", "(Z)V", "Landroid/view/View$OnClickListener;", "confirmClickListener", "Landroid/view/View$OnClickListener;", "getConfirmClickListener", "()Landroid/view/View$OnClickListener;", "setConfirmClickListener", "(Landroid/view/View$OnClickListener;)V", "cancelClickListener", "getCancelClickListener", "setCancelClickListener", "cancelClick", "getCancelClick", "setCancelClick", "confirmClick", "getConfirmClick", "setConfirmClick", "<init>", "()V", "Companion", "AlertDataBean", "a", "common_release"}, k = 1, mv = {1, 8, 0})
public final class AlertDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private View.OnClickListener cancelClickListener;

    @Nullable
    private View.OnClickListener confirmClickListener;
    private boolean useVertical;

    @NotNull
    private String title = "";
    private float titleSize = 20.0f;
    private int titleColor = Color.parseColor("#E4000000");

    @NotNull
    private String content = "";
    private float contentSize = 18.0f;
    private int contentColor = Color.parseColor("#64000000");

    @NotNull
    private String cancel = "";
    private float cancelSize = 18.0f;
    private int cancelColor = Color.parseColor("#64000000");

    @NotNull
    private String confirm = "";
    private float confirmSize = 18.0f;
    private int confirmColor = Color.parseColor("#0A0A9F");

    @NotNull
    private View.OnClickListener cancelClick = new View.OnClickListener() { // from class: com.zj.adlib.h30
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AlertDialog.cancelClick$lambda$2(this.f42038a, view);
        }
    };

    @NotNull
    private View.OnClickListener confirmClick = new View.OnClickListener() { // from class: com.zj.adlib.i30
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AlertDialog.confirmClick$lambda$4(this.f42265a, view);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.common.dialog.AlertDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/common/dialog/AlertDialog$a;", "", "", "title", "content", "cancel", "confirm", "", "useVertical", "Lcom/huachenjie/common/dialog/AlertDialog;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/huachenjie/common/dialog/AlertDialog;", "Lcom/huachenjie/common/dialog/AlertDialog$AlertDataBean;", "dataBean", "Landroid/view/View$OnClickListener;", "confirmClickListener", "b", "cancelClickListener", "c", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlertDialog a(@NotNull AlertDataBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            AlertDialog alertDialog = new AlertDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserConstants.ALERT_DIALOG_PARAMS.f33724a, dataBean);
            alertDialog.setArguments(bundle);
            return alertDialog;
        }

        @NotNull
        public final AlertDialog b(@NotNull AlertDataBean dataBean, @NotNull View.OnClickListener confirmClickListener) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(confirmClickListener, "confirmClickListener");
            AlertDialog alertDialog = new AlertDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserConstants.ALERT_DIALOG_PARAMS.f33724a, dataBean);
            alertDialog.setConfirmClickListener(confirmClickListener);
            alertDialog.setArguments(bundle);
            return alertDialog;
        }

        @NotNull
        public final AlertDialog c(@NotNull AlertDataBean dataBean, @NotNull View.OnClickListener confirmClickListener, @NotNull View.OnClickListener cancelClickListener) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(confirmClickListener, "confirmClickListener");
            Intrinsics.checkNotNullParameter(cancelClickListener, "cancelClickListener");
            AlertDialog alertDialog = new AlertDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserConstants.ALERT_DIALOG_PARAMS.f33724a, dataBean);
            alertDialog.setConfirmClickListener(confirmClickListener);
            alertDialog.setCancelClickListener(cancelClickListener);
            alertDialog.setArguments(bundle);
            return alertDialog;
        }

        @NotNull
        public final AlertDialog d(@Nullable String title, @Nullable String content, @Nullable String cancel, @Nullable String confirm, @Nullable Boolean useVertical) {
            AlertDialog alertDialog = new AlertDialog();
            Bundle bundle = new Bundle();
            if (title == null) {
                title = "";
            }
            bundle.putString(UserConstants.ALERT_DIALOG_PARAMS.b, title);
            if (content == null) {
                content = "";
            }
            bundle.putString(UserConstants.ALERT_DIALOG_PARAMS.c, content);
            if (cancel == null) {
                cancel = "";
            }
            bundle.putString(UserConstants.ALERT_DIALOG_PARAMS.d, cancel);
            if (confirm == null) {
                confirm = "";
            }
            bundle.putString(UserConstants.ALERT_DIALOG_PARAMS.e, confirm);
            bundle.putBoolean(UserConstants.ALERT_DIALOG_PARAMS.f, useVertical != null ? useVertical.booleanValue() : false);
            alertDialog.setArguments(bundle);
            return alertDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelClick$lambda$2(AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(alertDialog, "this$0");
        View.OnClickListener onClickListener = alertDialog.cancelClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmClick$lambda$4(AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(alertDialog, "this$0");
        View.OnClickListener onClickListener = alertDialog.confirmClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        alertDialog.dismiss();
    }

    private final void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            AlertDataBean alertDataBean = (AlertDataBean) arguments.getParcelable(UserConstants.ALERT_DIALOG_PARAMS.f33724a);
            if (alertDataBean != null) {
                this.title = alertDataBean.getTitle();
                this.titleSize = alertDataBean.getTitleSize();
                this.titleColor = alertDataBean.getTitleColor();
                this.content = alertDataBean.getContent();
                this.contentSize = alertDataBean.getContentSize();
                this.contentColor = alertDataBean.getContentColor();
                this.cancel = alertDataBean.getCancel();
                this.cancelSize = alertDataBean.getCancelSize();
                this.cancelColor = alertDataBean.getCancelColor();
                this.confirm = alertDataBean.getConfirm();
                this.confirmSize = alertDataBean.getConfirmSize();
                this.confirmColor = alertDataBean.getConfirmColor();
                this.useVertical = alertDataBean.getUseVertical();
                return;
            }
            String string = arguments.getString(UserConstants.ALERT_DIALOG_PARAMS.b);
            String str = "";
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "getString(UserConstants.…PARAMS.ALERT_TITLE) ?: \"\"");
            }
            this.title = string;
            String string2 = arguments.getString(UserConstants.ALERT_DIALOG_PARAMS.c);
            if (string2 == null) {
                string2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string2, "getString(UserConstants.…RAMS.ALERT_CONTENT) ?: \"\"");
            }
            this.content = string2;
            String string3 = arguments.getString(UserConstants.ALERT_DIALOG_PARAMS.d);
            if (string3 == null) {
                string3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string3, "getString(UserConstants.…ARAMS.ALERT_CANCEL) ?: \"\"");
            }
            this.cancel = string3;
            String string4 = arguments.getString(UserConstants.ALERT_DIALOG_PARAMS.e);
            if (string4 != null) {
                Intrinsics.checkNotNullExpressionValue(string4, "getString(UserConstants.…RAMS.ALERT_CONFIRM) ?: \"\"");
                str = string4;
            }
            this.confirm = str;
            this.useVertical = arguments.getBoolean(UserConstants.ALERT_DIALOG_PARAMS.f);
        }
    }

    private final void initView(View view) {
        setTextView(view, R.id.tv_title, this.title, this.titleSize, this.titleColor);
        setTextView(view, R.id.tv_message, this.content, this.contentSize, this.contentColor);
        int i = 8;
        if (!this.useVertical) {
            view.findViewById(R.id.ll_hotizontal_button).setVisibility(0);
            view.findViewById(R.id.ll_vertical_button).setVisibility(8);
            int i2 = R.id.tv_horizontal_negative;
            ((TextView) view.findViewById(i2)).setOnClickListener(this.cancelClick);
            int i3 = R.id.tv_horizontal_positive;
            ((TextView) view.findViewById(i3)).setOnClickListener(this.confirmClick);
            setTextView(view, i2, this.cancel, this.cancelSize, this.cancelColor);
            setTextView(view, i3, this.confirm, this.confirmSize, this.confirmColor);
            View viewFindViewById = view.findViewById(R.id.view_horizontal_btn_line);
            if (!TextUtils.isEmpty(this.cancel) && !TextUtils.isEmpty(this.confirm)) {
                i = 0;
            }
            viewFindViewById.setVisibility(i);
            return;
        }
        View viewFindViewById2 = view.findViewById(R.id.ll_hotizontal_button);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        View viewFindViewById3 = view.findViewById(R.id.ll_vertical_button);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(0);
        }
        int i4 = R.id.tv_vertical_negative;
        ((TextView) view.findViewById(i4)).setOnClickListener(this.cancelClick);
        int i5 = R.id.tv_vertical_positive;
        ((TextView) view.findViewById(i5)).setOnClickListener(this.confirmClick);
        setTextView(view, i4, this.cancel, this.cancelSize, this.cancelColor);
        setTextView(view, i5, this.confirm, this.confirmSize, this.confirmColor);
        View viewFindViewById4 = view.findViewById(R.id.view_vertical_btn_line);
        if (!TextUtils.isEmpty(this.cancel) && !TextUtils.isEmpty(this.confirm)) {
            i = 0;
        }
        viewFindViewById4.setVisibility(i);
    }

    private final void setTextView(View view, int id, String text, float textSize, int textColor) {
        if (TextUtils.isEmpty(text)) {
            view.findViewById(id).setVisibility(8);
            return;
        }
        view.findViewById(id).setVisibility(0);
        ((TextView) view.findViewById(id)).setText(text);
        ((TextView) view.findViewById(id)).setTextSize(textSize);
        ((TextView) view.findViewById(id)).setTextColor(textColor);
    }

    @NotNull
    public final String getCancel() {
        return this.cancel;
    }

    @NotNull
    public final View.OnClickListener getCancelClick() {
        return this.cancelClick;
    }

    @Nullable
    public final View.OnClickListener getCancelClickListener() {
        return this.cancelClickListener;
    }

    public final int getCancelColor() {
        return this.cancelColor;
    }

    public final float getCancelSize() {
        return this.cancelSize;
    }

    @NotNull
    public final String getConfirm() {
        return this.confirm;
    }

    @NotNull
    public final View.OnClickListener getConfirmClick() {
        return this.confirmClick;
    }

    @Nullable
    public final View.OnClickListener getConfirmClickListener() {
        return this.confirmClickListener;
    }

    public final int getConfirmColor() {
        return this.confirmColor;
    }

    public final float getConfirmSize() {
        return this.confirmSize;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getContentColor() {
        return this.contentColor;
    }

    public final float getContentSize() {
        return this.contentSize;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final float getTitleSize() {
        return this.titleSize;
    }

    public final boolean getUseVertical() {
        return this.useVertical;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_customize_view, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(fx7.j() - cr2.c(getContext(), 40.0f), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }

    public final void setCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancel = str;
    }

    public final void setCancelClick(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
        this.cancelClick = onClickListener;
    }

    public final void setCancelClickListener(@Nullable View.OnClickListener onClickListener) {
        this.cancelClickListener = onClickListener;
    }

    public final void setCancelColor(int i) {
        this.cancelColor = i;
    }

    public final void setCancelSize(float f) {
        this.cancelSize = f;
    }

    public final void setConfirm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.confirm = str;
    }

    public final void setConfirmClick(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
        this.confirmClick = onClickListener;
    }

    public final void setConfirmClickListener(@Nullable View.OnClickListener onClickListener) {
        this.confirmClickListener = onClickListener;
    }

    public final void setConfirmColor(int i) {
        this.confirmColor = i;
    }

    public final void setConfirmSize(float f) {
        this.confirmSize = f;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setContentColor(int i) {
        this.contentColor = i;
    }

    public final void setContentSize(float f) {
        this.contentSize = f;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTitleSize(float f) {
        this.titleSize = f;
    }

    public final void setUseVertical(boolean z) {
        this.useVertical = z;
    }

    @Parcelize
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\u008b\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\u0013\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\u0019\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006O"}, d2 = {"Lcom/huachenjie/common/dialog/AlertDialog$AlertDataBean;", "Landroid/os/Parcelable;", "title", "", "titleSize", "", RVParams.LONG_TITLE_COLOR, "", "content", "contentSize", "contentColor", "cancel", "cancelSize", "cancelColor", "confirm", "confirmSize", "confirmColor", "useVertical", "", "(Ljava/lang/String;FILjava/lang/String;FILjava/lang/String;FILjava/lang/String;FIZ)V", "getCancel", "()Ljava/lang/String;", "setCancel", "(Ljava/lang/String;)V", "getCancelColor", "()I", "setCancelColor", "(I)V", "getCancelSize", "()F", "setCancelSize", "(F)V", "getConfirm", "setConfirm", "getConfirmColor", "setConfirmColor", "getConfirmSize", "setConfirmSize", "getContent", "setContent", "getContentColor", "setContentColor", "getContentSize", "setContentSize", "getTitle", d.p, "getTitleColor", "setTitleColor", "getTitleSize", "setTitleSize", "getUseVertical", "()Z", "setUseVertical", "(Z)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AlertDataBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<AlertDataBean> CREATOR = new a();

        @NotNull
        private String cancel;
        private int cancelColor;
        private float cancelSize;

        @NotNull
        private String confirm;
        private int confirmColor;
        private float confirmSize;

        @NotNull
        private String content;
        private int contentColor;
        private float contentSize;

        @NotNull
        private String title;
        private int titleColor;
        private float titleSize;
        private boolean useVertical;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<AlertDataBean> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AlertDataBean createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AlertDataBean(parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AlertDataBean[] newArray(int i) {
                return new AlertDataBean[i];
            }
        }

        public AlertDataBean() {
            this(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
        }

        public AlertDataBean(@NotNull String str, float f, int i, @NotNull String str2, float f2, int i2, @NotNull String str3, float f3, int i3, @NotNull String str4, float f4, int i4, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "content");
            Intrinsics.checkNotNullParameter(str3, "cancel");
            Intrinsics.checkNotNullParameter(str4, "confirm");
            this.title = str;
            this.titleSize = f;
            this.titleColor = i;
            this.content = str2;
            this.contentSize = f2;
            this.contentColor = i2;
            this.cancel = str3;
            this.cancelSize = f3;
            this.cancelColor = i3;
            this.confirm = str4;
            this.confirmSize = f4;
            this.confirmColor = i4;
            this.useVertical = z;
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getConfirm() {
            return this.confirm;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final float getConfirmSize() {
            return this.confirmSize;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final int getConfirmColor() {
            return this.confirmColor;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getUseVertical() {
            return this.useVertical;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getTitleSize() {
            return this.titleSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTitleColor() {
            return this.titleColor;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getContentSize() {
            return this.contentSize;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getContentColor() {
            return this.contentColor;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCancel() {
            return this.cancel;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final float getCancelSize() {
            return this.cancelSize;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getCancelColor() {
            return this.cancelColor;
        }

        @NotNull
        public final AlertDataBean copy(@NotNull String title, float titleSize, int titleColor, @NotNull String content, float contentSize, int contentColor, @NotNull String cancel, float cancelSize, int cancelColor, @NotNull String confirm, float confirmSize, int confirmColor, boolean useVertical) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(cancel, "cancel");
            Intrinsics.checkNotNullParameter(confirm, "confirm");
            return new AlertDataBean(title, titleSize, titleColor, content, contentSize, contentColor, cancel, cancelSize, cancelColor, confirm, confirmSize, confirmColor, useVertical);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlertDataBean)) {
                return false;
            }
            AlertDataBean alertDataBean = (AlertDataBean) other;
            return Intrinsics.areEqual(this.title, alertDataBean.title) && Float.compare(this.titleSize, alertDataBean.titleSize) == 0 && this.titleColor == alertDataBean.titleColor && Intrinsics.areEqual(this.content, alertDataBean.content) && Float.compare(this.contentSize, alertDataBean.contentSize) == 0 && this.contentColor == alertDataBean.contentColor && Intrinsics.areEqual(this.cancel, alertDataBean.cancel) && Float.compare(this.cancelSize, alertDataBean.cancelSize) == 0 && this.cancelColor == alertDataBean.cancelColor && Intrinsics.areEqual(this.confirm, alertDataBean.confirm) && Float.compare(this.confirmSize, alertDataBean.confirmSize) == 0 && this.confirmColor == alertDataBean.confirmColor && this.useVertical == alertDataBean.useVertical;
        }

        @NotNull
        public final String getCancel() {
            return this.cancel;
        }

        public final int getCancelColor() {
            return this.cancelColor;
        }

        public final float getCancelSize() {
            return this.cancelSize;
        }

        @NotNull
        public final String getConfirm() {
            return this.confirm;
        }

        public final int getConfirmColor() {
            return this.confirmColor;
        }

        public final float getConfirmSize() {
            return this.confirmSize;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        public final int getContentColor() {
            return this.contentColor;
        }

        public final float getContentSize() {
            return this.contentSize;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getTitleColor() {
            return this.titleColor;
        }

        public final float getTitleSize() {
            return this.titleSize;
        }

        public final boolean getUseVertical() {
            return this.useVertical;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v25, types: [int] */
        /* JADX WARN: Type inference failed for: r1v23, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        public int hashCode() {
            int iHashCode = ((((((((((((((((((((((this.title.hashCode() * 31) + Float.hashCode(this.titleSize)) * 31) + Integer.hashCode(this.titleColor)) * 31) + this.content.hashCode()) * 31) + Float.hashCode(this.contentSize)) * 31) + Integer.hashCode(this.contentColor)) * 31) + this.cancel.hashCode()) * 31) + Float.hashCode(this.cancelSize)) * 31) + Integer.hashCode(this.cancelColor)) * 31) + this.confirm.hashCode()) * 31) + Float.hashCode(this.confirmSize)) * 31) + Integer.hashCode(this.confirmColor)) * 31;
            boolean z = this.useVertical;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final void setCancel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cancel = str;
        }

        public final void setCancelColor(int i) {
            this.cancelColor = i;
        }

        public final void setCancelSize(float f) {
            this.cancelSize = f;
        }

        public final void setConfirm(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.confirm = str;
        }

        public final void setConfirmColor(int i) {
            this.confirmColor = i;
        }

        public final void setConfirmSize(float f) {
            this.confirmSize = f;
        }

        public final void setContent(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setContentColor(int i) {
            this.contentColor = i;
        }

        public final void setContentSize(float f) {
            this.contentSize = f;
        }

        public final void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void setTitleColor(int i) {
            this.titleColor = i;
        }

        public final void setTitleSize(float f) {
            this.titleSize = f;
        }

        public final void setUseVertical(boolean z) {
            this.useVertical = z;
        }

        @NotNull
        public String toString() {
            return "AlertDataBean(title=" + this.title + ", titleSize=" + this.titleSize + ", titleColor=" + this.titleColor + ", content=" + this.content + ", contentSize=" + this.contentSize + ", contentColor=" + this.contentColor + ", cancel=" + this.cancel + ", cancelSize=" + this.cancelSize + ", cancelColor=" + this.cancelColor + ", confirm=" + this.confirm + ", confirmSize=" + this.confirmSize + ", confirmColor=" + this.confirmColor + ", useVertical=" + this.useVertical + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeFloat(this.titleSize);
            parcel.writeInt(this.titleColor);
            parcel.writeString(this.content);
            parcel.writeFloat(this.contentSize);
            parcel.writeInt(this.contentColor);
            parcel.writeString(this.cancel);
            parcel.writeFloat(this.cancelSize);
            parcel.writeInt(this.cancelColor);
            parcel.writeString(this.confirm);
            parcel.writeFloat(this.confirmSize);
            parcel.writeInt(this.confirmColor);
            parcel.writeInt(this.useVertical ? 1 : 0);
        }

        public /* synthetic */ AlertDataBean(String str, float f, int i, String str2, float f2, int i2, String str3, float f3, int i3, String str4, float f4, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 20.0f : f, (i5 & 4) != 0 ? Color.parseColor("#E4000000") : i, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? 18.0f : f2, (i5 & 32) != 0 ? Color.parseColor("#64000000") : i2, (i5 & 64) != 0 ? "" : str3, (i5 & 128) != 0 ? 18.0f : f3, (i5 & 256) != 0 ? Color.parseColor("#64000000") : i3, (i5 & 512) == 0 ? str4 : "", (i5 & 1024) == 0 ? f4 : 18.0f, (i5 & 2048) != 0 ? Color.parseColor("#0A0A9F") : i4, (i5 & 4096) != 0 ? false : z);
        }
    }
}

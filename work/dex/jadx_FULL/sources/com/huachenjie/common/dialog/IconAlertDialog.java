package com.huachenjie.common.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseAlertDialog;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class IconAlertDialog extends BaseAlertDialog {
    protected View btnLine;
    protected LinearLayout llHotizontalButton;
    protected LinearLayout llVerticalButton;
    private ImageView mImgIcon;
    protected LinearLayout messageView;
    protected TextView titleView;
    protected TextView tvMessage;
    protected TextView tvNegative;
    protected TextView tvPositive;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f33807a;

        public a(final View.OnClickListener val$clickListener) {
            this.f33807a = val$clickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            IconAlertDialog.this.dismiss();
            View.OnClickListener onClickListener = this.f33807a;
            if (onClickListener != null) {
                onClickListener.onClick(v);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DialogUtil.PositiveNegativeClickListener f8752a;

        public b(final DialogUtil.PositiveNegativeClickListener val$clickListener) {
            this.f8752a = val$clickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            IconAlertDialog.this.dismiss();
            DialogUtil.PositiveNegativeClickListener positiveNegativeClickListener = this.f8752a;
            if (positiveNegativeClickListener != null) {
                positiveNegativeClickListener.b();
            }
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DialogUtil.SingleClickListener f8753a;

        public c(final DialogUtil.SingleClickListener val$clickListener) {
            this.f8753a = val$clickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            IconAlertDialog.this.dismiss();
            DialogUtil.SingleClickListener singleClickListener = this.f8753a;
            if (singleClickListener != null) {
                singleClickListener.onClicked();
            }
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DialogUtil.PositiveNegativeClickListener f8754a;

        public d(final DialogUtil.PositiveNegativeClickListener val$clickListener) {
            this.f8754a = val$clickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            IconAlertDialog.this.dismiss();
            DialogUtil.PositiveNegativeClickListener positiveNegativeClickListener = this.f8754a;
            if (positiveNegativeClickListener != null) {
                positiveNegativeClickListener.a();
            }
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f33811a;

        public e(final View.OnClickListener val$clickListener) {
            this.f33811a = val$clickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            IconAlertDialog.this.dismiss();
            View.OnClickListener onClickListener = this.f33811a;
            if (onClickListener != null) {
                onClickListener.onClick(v);
            }
        }
    }

    public static class f {
        public static final int g = 312;
        public static final int h = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f33812a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DialogInterface.OnDismissListener f8756a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Drawable f8757a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SpannableStringBuilder f8758a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MovementMethod f8759a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View.OnClickListener f8760a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View f8761a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DialogUtil.PositiveNegativeClickListener f8762a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DialogUtil.SingleClickListener f8763a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CharSequence f8764a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f8765a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Drawable f8766b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public View.OnClickListener f8767b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public CharSequence f8768b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f8769b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Drawable f8770c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public CharSequence f8771c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public Drawable f8772d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public CharSequence f8773d;
        public int e = 312;
        public int f;

        public Drawable A() {
            return this.f8770c;
        }

        public Drawable B() {
            return this.f8766b;
        }

        public DialogUtil.SingleClickListener C() {
            return this.f8763a;
        }

        public final CharSequence D() {
            return this.f8764a;
        }

        public MovementMethod E() {
            return this.f8759a;
        }

        public SpannableStringBuilder F() {
            return this.f8758a;
        }

        public final boolean G() {
            return this.f8765a;
        }

        public final boolean H() {
            return this.f8769b;
        }

        public f I(boolean cancelable) {
            this.f8765a = cancelable;
            return this;
        }

        public f J(boolean canceledOnTouchOutside) {
            this.f8769b = canceledOnTouchOutside;
            return this;
        }

        public f K(SpannableStringBuilder spannableStringBuilder, MovementMethod movementMethod) {
            this.f8758a = spannableStringBuilder;
            this.f8759a = movementMethod;
            return this;
        }

        public f L(int width) {
            this.e = width;
            return this;
        }

        public f M(@DrawableRes int resId) {
            this.f33812a = resId;
            return this;
        }

        public f N(@DrawableRes int resId) {
            this.b = resId;
            return this;
        }

        public f O(CharSequence message) {
            this.f8768b = message;
            return this;
        }

        public f P(@LayoutRes int resource) {
            this.c = resource;
            return this;
        }

        public f Q(View messageView) {
            this.f8761a = messageView;
            return this;
        }

        public f R(CharSequence negative) {
            this.f8773d = negative;
            return this;
        }

        public f S(CharSequence negative, View.OnClickListener negativeClickListener) {
            this.f8773d = negative;
            this.f8767b = negativeClickListener;
            return this;
        }

        public f T(DialogInterface.OnDismissListener onDismissListener) {
            this.f8756a = onDismissListener;
            return this;
        }

        public f U(int orientation) {
            this.d = orientation;
            return this;
        }

        public f V(CharSequence positive) {
            this.f8771c = positive;
            return this;
        }

        public f W(CharSequence positive, View.OnClickListener positiveClickListener) {
            this.f8771c = positive;
            this.f8760a = positiveClickListener;
            return this;
        }

        public f X(int style) {
            this.f = style;
            return this;
        }

        public f Y(Drawable left, Drawable top, Drawable right, Drawable bottom) {
            this.f8757a = left;
            this.f8766b = top;
            this.f8770c = right;
            this.f8772d = bottom;
            return this;
        }

        public f Z(DialogUtil.PositiveNegativeClickListener listener) {
            this.f8762a = listener;
            return this;
        }

        public f a0(DialogUtil.SingleClickListener listener) {
            this.f8763a = listener;
            return this;
        }

        public f b0(CharSequence title) {
            this.f8764a = title;
            return this;
        }

        public IconAlertDialog k(Context context) {
            if (this.c > 0) {
                this.f8761a = LayoutInflater.from(context).inflate(this.c, (ViewGroup) null);
            }
            IconAlertDialog iconAlertDialog = new IconAlertDialog(context);
            iconAlertDialog.show();
            iconAlertDialog.initView(this);
            return iconAlertDialog;
        }

        public int l() {
            return this.e;
        }

        public int m() {
            return this.f33812a;
        }

        public int n() {
            return this.b;
        }

        public final CharSequence o() {
            return this.f8768b;
        }

        public final View p() {
            return this.f8761a;
        }

        public final CharSequence q() {
            return this.f8773d;
        }

        public final View.OnClickListener r() {
            return this.f8767b;
        }

        public final DialogInterface.OnDismissListener s() {
            return this.f8756a;
        }

        public int t() {
            return this.d;
        }

        public final CharSequence u() {
            return this.f8771c;
        }

        public Drawable v() {
            return this.f8772d;
        }

        public int w() {
            return this.f;
        }

        public final View.OnClickListener x() {
            return this.f8760a;
        }

        public Drawable y() {
            return this.f8757a;
        }

        public DialogUtil.PositiveNegativeClickListener z() {
            return this.f8762a;
        }
    }

    public IconAlertDialog(Context context) {
        super(context);
    }

    private void initView(Context context) {
        this.mImgIcon = (ImageView) findViewById(R.id.img_icon);
        this.titleView = (TextView) findViewById(R.id.tv_title);
        this.tvMessage = (TextView) findViewById(R.id.tv_message);
        this.messageView = (LinearLayout) findViewById(R.id.view_message);
        this.llHotizontalButton = (LinearLayout) findViewById(R.id.ll_hotizontal_button);
        this.llVerticalButton = (LinearLayout) findViewById(R.id.ll_vertical_button);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    @LayoutRes
    public int getLayoutId() {
        return R.layout.dialog_top_icon;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        initView(getContext());
    }

    public void setClickableText(SpannableStringBuilder spannableStringBuilder, MovementMethod movementMethod) {
        if (spannableStringBuilder != null) {
            this.tvMessage.setText(spannableStringBuilder);
            this.tvMessage.setMovementMethod(movementMethod);
        }
    }

    public void setIconBackground(@DrawableRes int resId) {
        this.mImgIcon.setBackgroundResource(resId);
    }

    public void setIconImage(@DrawableRes int resId) {
        this.mImgIcon.setImageResource(resId);
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        this.tvMessage.setText(message);
    }

    public void setMessageView(View messageView) {
        if (messageView != null) {
            this.messageView.removeAllViews();
            this.messageView.addView(messageView);
        }
    }

    public void setNegative(CharSequence negative, final DialogUtil.PositiveNegativeClickListener clickListener) {
        if (TextUtils.isEmpty(negative)) {
            this.tvNegative.setVisibility(8);
            this.btnLine.setVisibility(8);
        } else {
            this.tvNegative.setVisibility(0);
            this.btnLine.setVisibility(0);
            this.tvNegative.setText(negative);
            this.tvNegative.setOnClickListener(new d(clickListener));
        }
    }

    public void setPositive(CharSequence positive, final View.OnClickListener clickListener) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new a(clickListener));
    }

    public void setPositiveDrawable(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        TextView textView = this.tvPositive;
        if (textView == null) {
            return;
        }
        if (left == null && top == null && right == null && bottom == null) {
            return;
        }
        textView.setCompoundDrawablePadding(jj8.b(6.0f, getContext()));
        this.tvPositive.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void setTitle(CharSequence title) {
        if (TextUtils.isEmpty(title)) {
            this.titleView.setVisibility(8);
        } else {
            this.titleView.setVisibility(0);
            this.titleView.setText(title);
        }
    }

    public IconAlertDialog(Context context, int theme) {
        super(context, theme);
    }

    public void setPositive(CharSequence positive, final DialogUtil.PositiveNegativeClickListener clickListener) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new b(clickListener));
    }

    public void setPositive(CharSequence positive, final DialogUtil.SingleClickListener clickListener) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new c(clickListener));
    }

    public void initView(f builder) {
        if (builder.l() > 0) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = jj8.b(builder.l(), getContext());
            window.setAttributes(attributes);
        }
        if (builder.m() != 0) {
            setIconBackground(builder.m());
        }
        if (builder.n() != 0) {
            setIconImage(builder.n());
        }
        setTitle(builder.D());
        setMessage(builder.o());
        setClickableText(builder.F(), builder.E());
        this.llVerticalButton.setVisibility(builder.t() == 1 ? 0 : 8);
        this.llHotizontalButton.setVisibility(builder.t() == 1 ? 8 : 0);
        this.tvNegative = (TextView) findViewById(builder.t() == 1 ? R.id.tv_vertical_negative : R.id.tv_horizontal_negative);
        this.tvPositive = (TextView) findViewById(builder.t() == 1 ? R.id.tv_vertical_positive : R.id.tv_horizontal_positive);
        this.btnLine = findViewById(builder.t() == 1 ? R.id.view_vertical_btn_line : R.id.view_horizontal_btn_line);
        if (builder.w() == 1) {
            TextView textView = this.tvPositive;
            Resources resources = getContext().getResources();
            int i = R.color.white;
            textView.setBackgroundColor(ResourcesCompat.getColor(resources, i, null));
            this.tvPositive.setTextColor(ResourcesCompat.getColor(getContext().getResources(), i, null));
        } else {
            this.tvPositive.setBackground(null);
            this.tvPositive.setTextColor(ResourcesCompat.getColor(getContext().getResources(), R.color.colorPrimary, null));
        }
        if (builder.C() != null) {
            setPositive(builder.u(), builder.C());
        } else if (builder.z() != null) {
            setPositive(builder.u(), builder.z());
        } else {
            setPositive(builder.u(), builder.x());
        }
        setPositiveDrawable(builder.y(), builder.B(), builder.A(), builder.v());
        if (builder.z() != null) {
            setNegative(builder.q(), builder.z());
        } else {
            setNegative(builder.q(), builder.r());
        }
        setCancelable(builder.G());
        setCanceledOnTouchOutside(builder.H());
        setMessageView(builder.p());
        setOnDismissListener(builder.s());
    }

    public void setNegative(CharSequence negative, final View.OnClickListener clickListener) {
        if (TextUtils.isEmpty(negative)) {
            this.tvNegative.setVisibility(8);
            this.btnLine.setVisibility(8);
        } else {
            this.tvNegative.setVisibility(0);
            this.btnLine.setVisibility(0);
            this.tvNegative.setText(negative);
            this.tvNegative.setOnClickListener(new e(clickListener));
        }
    }
}

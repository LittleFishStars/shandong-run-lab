package com.huachenjie.common.widget;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseAlertDialog;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CustomizeViewDialog extends BaseAlertDialog {
    protected View btnLine;
    protected LinearLayout llHotizontalButton;
    protected LinearLayout llVerticalButton;
    protected LinearLayout messageView;
    protected TextView titleView;
    protected TextView tvMessage;
    protected TextView tvNegative;
    protected TextView tvPositive;

    public static class Builder {
        public static final int DEFAULT_DIALOG_WIDTH = 312;
        public static final int FILLED_BUTTON_STYLE = 1;
        private boolean clickPositiveKeepShow;
        private boolean mCancelable;
        private boolean mCanceledOnTouchOutside;
        private Context mContext;
        private int mDialogWidth = 312;
        private CharSequence mMessage;
        private View mMessageView;
        private int mMessageViewRes;
        private MovementMethod mMovementMethod;
        private CharSequence mNegative;
        private View.OnClickListener mNegativeClickListener;
        private DialogInterface.OnDismissListener mOnDismissListener;
        private int mOrientation;
        private CharSequence mPositive;
        private int mPositiveButtonStyle;
        private View.OnClickListener mPositiveClickListener;
        private DialogUtil.PositiveNegativeClickListener mPositiveNegativeClickListener;
        private DialogUtil.SingleClickListener mSingleClicklistener;
        private SpannableStringBuilder mSpannableStringBuilder;
        private CharSequence mTitle;
        private Drawable positiveBottom;
        private Drawable positiveLeft;
        private Drawable positiveRight;
        private Drawable positiveTop;

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getMessage() {
            return this.mMessage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View getMessageView() {
            return this.mMessageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getNegative() {
            return this.mNegative;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View.OnClickListener getNegativeClickListener() {
            return this.mNegativeClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DialogInterface.OnDismissListener getOnDismissListener() {
            return this.mOnDismissListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getPositive() {
            return this.mPositive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View.OnClickListener getPositiveClickListener() {
            return this.mPositiveClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getTitle() {
            return this.mTitle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isCancelable() {
            return this.mCancelable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isCanceledOnTouchOutside() {
            return this.mCanceledOnTouchOutside;
        }

        public CustomizeViewDialog create(Context context) {
            if (this.mMessageViewRes > 0) {
                this.mMessageView = LayoutInflater.from(context).inflate(this.mMessageViewRes, (ViewGroup) null);
            }
            CustomizeViewDialog customizeViewDialog = new CustomizeViewDialog(context);
            customizeViewDialog.show();
            customizeViewDialog.initView(this);
            return customizeViewDialog;
        }

        public boolean getClickPositiveKeepShow() {
            return this.clickPositiveKeepShow;
        }

        public int getDialogWidth() {
            return this.mDialogWidth;
        }

        public int getOrientation() {
            return this.mOrientation;
        }

        public Drawable getPositiveBottom() {
            return this.positiveBottom;
        }

        public int getPositiveButtonStyle() {
            return this.mPositiveButtonStyle;
        }

        public Drawable getPositiveLeft() {
            return this.positiveLeft;
        }

        public DialogUtil.PositiveNegativeClickListener getPositiveNegativeClickListener() {
            return this.mPositiveNegativeClickListener;
        }

        public Drawable getPositiveRight() {
            return this.positiveRight;
        }

        public Drawable getPositiveTop() {
            return this.positiveTop;
        }

        public DialogUtil.SingleClickListener getSingleClicklistener() {
            return this.mSingleClicklistener;
        }

        public MovementMethod getmMovementMethod() {
            return this.mMovementMethod;
        }

        public SpannableStringBuilder getmSpannableStringBuilder() {
            return this.mSpannableStringBuilder;
        }

        public Builder setCancelable(boolean cancelable) {
            this.mCancelable = cancelable;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
            this.mCanceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder setClickPositiveKeepShow(boolean clickPositiveKeepShow) {
            this.clickPositiveKeepShow = clickPositiveKeepShow;
            return this;
        }

        public Builder setClickableMessage(SpannableStringBuilder spannableStringBuilder, MovementMethod movementMethod) {
            this.mSpannableStringBuilder = spannableStringBuilder;
            this.mMovementMethod = movementMethod;
            return this;
        }

        public Builder setDialogWidth(int width) {
            this.mDialogWidth = width;
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.mMessage = message;
            return this;
        }

        public Builder setMessageView(View messageView) {
            this.mMessageView = messageView;
            return this;
        }

        public Builder setNegative(CharSequence negative) {
            this.mNegative = negative;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOrientation(int orientation) {
            this.mOrientation = orientation;
            return this;
        }

        public Builder setPositive(CharSequence positive) {
            this.mPositive = positive;
            return this;
        }

        public Builder setPositiveButtonStyle(int style) {
            this.mPositiveButtonStyle = style;
            return this;
        }

        public Builder setPositiveDrawable(Drawable left, Drawable top, Drawable right, Drawable bottom) {
            this.positiveLeft = left;
            this.positiveTop = top;
            this.positiveRight = right;
            this.positiveBottom = bottom;
            return this;
        }

        public Builder setPositiveNegativeClickListener(DialogUtil.PositiveNegativeClickListener listener) {
            this.mPositiveNegativeClickListener = listener;
            return this;
        }

        public Builder setSingleClickListener(DialogUtil.SingleClickListener listener) {
            this.mSingleClicklistener = listener;
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.mTitle = title;
            return this;
        }

        public Builder setMessageView(@LayoutRes int resource) {
            this.mMessageViewRes = resource;
            return this;
        }

        public Builder setNegative(CharSequence negative, View.OnClickListener negativeClickListener) {
            this.mNegative = negative;
            this.mNegativeClickListener = negativeClickListener;
            return this;
        }

        public Builder setPositive(CharSequence positive, View.OnClickListener positiveClickListener) {
            this.mPositive = positive;
            this.mPositiveClickListener = positiveClickListener;
            return this;
        }
    }

    public CustomizeViewDialog(Context context) {
        super(context);
    }

    private void initView(Context context) {
        this.titleView = (TextView) findViewById(R.id.tv_title);
        this.tvMessage = (TextView) findViewById(R.id.tv_message);
        this.messageView = (LinearLayout) findViewById(R.id.view_message);
        this.llHotizontalButton = (LinearLayout) findViewById(R.id.ll_hotizontal_button);
        this.llVerticalButton = (LinearLayout) findViewById(R.id.ll_vertical_button);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNegative$1(DialogUtil.PositiveNegativeClickListener positiveNegativeClickListener, View view) {
        if (positiveNegativeClickListener != null) {
            positiveNegativeClickListener.a();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPositive$0(boolean z, DialogUtil.SingleClickListener singleClickListener, View view) {
        if (!z) {
            dismiss();
        }
        if (singleClickListener != null) {
            singleClickListener.onClicked();
        }
    }

    @LayoutRes
    public int getLayoutId() {
        return R.layout.dialog_customize_view;
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
            this.tvNegative.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a02
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f15137a.lambda$setNegative$1(clickListener, view);
                }
            });
        }
    }

    public void setPositive(CharSequence positive, final View.OnClickListener clickListener, final boolean keepShowAfterClick) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.CustomizeViewDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!keepShowAfterClick) {
                    CustomizeViewDialog.this.dismiss();
                }
                View.OnClickListener onClickListener = clickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
            }
        });
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

    public CustomizeViewDialog(Context context, int theme) {
        super(context, theme);
    }

    public void setPositive(CharSequence positive, final DialogUtil.PositiveNegativeClickListener clickListener, final boolean keepShowAfterClick) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.CustomizeViewDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!keepShowAfterClick) {
                    CustomizeViewDialog.this.dismiss();
                }
                DialogUtil.PositiveNegativeClickListener positiveNegativeClickListener = clickListener;
                if (positiveNegativeClickListener != null) {
                    positiveNegativeClickListener.b();
                }
            }
        });
    }

    public void setPositive(CharSequence positive, final DialogUtil.SingleClickListener clickListener, final boolean keepShowAfterClick) {
        this.tvPositive.setText(positive);
        this.tvPositive.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21126a.lambda$setPositive$0(keepShowAfterClick, clickListener, view);
            }
        });
    }

    public void initView(Builder builder) {
        if (builder.getDialogWidth() > 0) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = jj8.b(builder.getDialogWidth(), getContext());
            window.setAttributes(attributes);
        }
        setTitle(builder.getTitle());
        setMessage(builder.getMessage());
        setClickableText(builder.getmSpannableStringBuilder(), builder.getmMovementMethod());
        this.llVerticalButton.setVisibility(builder.getOrientation() == 1 ? 0 : 8);
        this.llHotizontalButton.setVisibility(builder.getOrientation() == 1 ? 8 : 0);
        this.tvNegative = (TextView) findViewById(builder.getOrientation() == 1 ? R.id.tv_vertical_negative : R.id.tv_horizontal_negative);
        this.tvPositive = (TextView) findViewById(builder.getOrientation() == 1 ? R.id.tv_vertical_positive : R.id.tv_horizontal_positive);
        this.btnLine = findViewById(builder.getOrientation() == 1 ? R.id.view_vertical_btn_line : R.id.view_horizontal_btn_line);
        if (builder.getPositiveButtonStyle() == 1) {
            TextView textView = this.tvPositive;
            Resources resources = getContext().getResources();
            int i = R.color.white;
            textView.setBackgroundColor(ResourcesCompat.getColor(resources, i, null));
            this.tvPositive.setTextColor(ResourcesCompat.getColor(getContext().getResources(), i, null));
        } else {
            this.tvPositive.setBackground(null);
            this.tvPositive.setTextColor(ResourcesCompat.getColor(getContext().getResources(), R.color.colorPrimary, null));
        }
        if (builder.getSingleClicklistener() != null) {
            setPositive(builder.getPositive(), builder.getSingleClicklistener(), builder.getClickPositiveKeepShow());
        } else if (builder.getPositiveNegativeClickListener() != null) {
            setPositive(builder.getPositive(), builder.getPositiveNegativeClickListener(), builder.getClickPositiveKeepShow());
        } else {
            setPositive(builder.getPositive(), builder.getPositiveClickListener(), builder.getClickPositiveKeepShow());
        }
        setPositiveDrawable(builder.getPositiveLeft(), builder.getPositiveTop(), builder.getPositiveRight(), builder.getPositiveBottom());
        if (builder.getPositiveNegativeClickListener() != null) {
            setNegative(builder.getNegative(), builder.getPositiveNegativeClickListener());
        } else {
            setNegative(builder.getNegative(), builder.getNegativeClickListener());
        }
        setCancelable(builder.isCancelable());
        setCanceledOnTouchOutside(builder.isCanceledOnTouchOutside());
        setMessageView(builder.getMessageView());
        setOnDismissListener(builder.getOnDismissListener());
    }

    public void setNegative(CharSequence negative, final View.OnClickListener clickListener) {
        if (TextUtils.isEmpty(negative)) {
            this.tvNegative.setVisibility(8);
            this.btnLine.setVisibility(8);
        } else {
            this.tvNegative.setVisibility(0);
            this.btnLine.setVisibility(0);
            this.tvNegative.setText(negative);
            this.tvNegative.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.CustomizeViewDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CustomizeViewDialog.this.dismiss();
                    View.OnClickListener onClickListener = clickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(v);
                    }
                }
            });
        }
    }
}

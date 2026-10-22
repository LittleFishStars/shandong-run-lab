package com.huachenjie.base.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huachenjie.base.R;
import com.zj.adlib.ws1;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ConfirmBoxDialog extends CustomDialog {
    private final ws1 builder;
    private View contentView;

    public ConfirmBoxDialog(Context context, ws1 builder) {
        super(context);
        this.builder = builder;
    }

    private void initTextView(TextView textView, CharSequence text, int color, float size) {
        initTextView(textView, text, color, size, 0, null);
    }

    private void initView() {
        if (this.builder.r() == 0) {
            TextView textView = new TextView(getContext());
            this.contentView = textView;
            textView.setGravity(17);
            ((TextView) this.contentView).setText("你是不是忘记了设置dialog的布局文件？");
            ((TextView) this.contentView).setTextColor(Color.parseColor("#FFFFFF"));
            this.contentView.setBackgroundColor(Color.parseColor("#88000000"));
        } else {
            this.contentView = LayoutInflater.from(getContext()).inflate(this.builder.r(), (ViewGroup) null);
        }
        View viewFindViewById = this.contentView.findViewById(R.id.confirm_dialog_container);
        TextView textView2 = (TextView) this.contentView.findViewById(R.id.confirm_dialog_title);
        if (textView2 != null) {
            initTextView(textView2, this.builder.w(), this.builder.u(), this.builder.v());
        }
        TextView textView3 = (TextView) this.contentView.findViewById(R.id.confirm_dialog_content);
        if (textView3 != null) {
            initTextView(textView3, this.builder.q(), this.builder.o(), this.builder.p());
            if (!this.builder.z()) {
                textView3.setMaxLines(Integer.MAX_VALUE);
                textView3.setVerticalScrollBarEnabled(false);
                textView3.setMovementMethod(null);
            }
        }
        TextView textView4 = (TextView) this.contentView.findViewById(R.id.confirm_dialog_cancel);
        if (textView4 != null) {
            initTextView(textView4, this.builder.g(), this.builder.e(), this.builder.f(), this.builder.c(), this.builder.b());
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xs1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45892a.lambda$initView$0(view);
                }
            });
        }
        TextView textView5 = (TextView) this.contentView.findViewById(R.id.confirm_dialog_confirm);
        if (textView5 != null) {
            initTextView(textView5, this.builder.n(), this.builder.k(), this.builder.m(), this.builder.i(), this.builder.h());
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ys1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46106a.lambda$initView$1(view);
                }
            });
        }
        View viewFindViewById2 = this.contentView.findViewById(R.id.confirm_dialog_split_line);
        if ((TextUtils.isEmpty(this.builder.g()) || TextUtils.isEmpty(this.builder.n())) && viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        if (this.builder.s() != 0 && viewFindViewById != null) {
            viewFindViewById.setRotation(this.builder.s());
        }
        List<OnViewCreateListener> listX = this.builder.x();
        if (listX == null || listX.isEmpty()) {
            return;
        }
        Iterator<OnViewCreateListener> it = listX.iterator();
        while (it.hasNext()) {
            it.next().a(this.contentView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        if (getContext() != null) {
            if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
                return;
            }
            if (this.builder.d() != null) {
                this.builder.d().onClick(view);
            }
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(View view) {
        if (getContext() != null) {
            if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
                return;
            }
            if (this.builder.l() != null) {
                this.builder.l().a(this, view);
                return;
            }
            if (this.builder.j() != null) {
                this.builder.j().onClick(view);
            }
            dismiss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setContentView(this.contentView);
        setCancelable(this.builder.y());
        setCanceledOnTouchOutside(this.builder.y());
    }

    private void initTextView(TextView textView, CharSequence text, int color, float size, int backgroundColor, Drawable background) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(text);
        if (color != 0) {
            textView.setTextColor(color);
        }
        if (size != 0.0f) {
            textView.setTextSize(TypedValue.applyDimension(2, size, textView.getContext().getResources().getDisplayMetrics()));
        }
        if (background != null) {
            textView.setBackground(background);
        } else if (backgroundColor != 0) {
            textView.setBackgroundTintList(ColorStateList.valueOf(backgroundColor));
        }
        ClickableSpan[] clickableSpanArr = text instanceof SpannableString ? (ClickableSpan[]) ((SpannableString) text).getSpans(0, text.length(), ClickableSpan.class) : null;
        if (text instanceof SpannableStringBuilder) {
            clickableSpanArr = (ClickableSpan[]) ((SpannableStringBuilder) text).getSpans(0, text.length(), ClickableSpan.class);
        }
        if (clickableSpanArr == null || clickableSpanArr.length <= 0) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    public ConfirmBoxDialog(Context context, int themeResId, ws1 builder) {
        super(context, themeResId);
        this.builder = builder;
    }
}

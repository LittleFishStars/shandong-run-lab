package com.fl.saas.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdCommonDialog extends Dialog {
    private String cancelName;
    private String content;
    private int gravity;
    private OnCancleListener onCancleListener;
    private OnSubmitListener onSubmitListener;
    private String submitName;
    private String title;
    private TextView tv_cancel;
    private TextView tv_content;
    private TextView tv_submit;
    private TextView tv_title;

    public interface OnCancleListener {
        void onClick();
    }

    public interface OnSubmitListener {
        void onClick();
    }

    public YdCommonDialog(Context context) {
        super(context, R.style.yd_dialog);
    }

    private void initView() {
        this.tv_content = (TextView) findViewById(R.id.content);
        this.tv_title = (TextView) findViewById(R.id.title);
        TextView textView = (TextView) findViewById(R.id.submit);
        this.tv_submit = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.base.widget.YdCommonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YdCommonDialog.this.onSubmitListener != null) {
                    YdCommonDialog.this.onSubmitListener.onClick();
                }
                YdCommonDialog.this.dismiss();
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.cancel);
        this.tv_cancel = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.base.widget.YdCommonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YdCommonDialog.this.onCancleListener != null) {
                    YdCommonDialog.this.onCancleListener.onClick();
                }
                YdCommonDialog.this.dismiss();
            }
        });
        if (!TextUtils.isEmpty(this.content)) {
            this.tv_content.setText(this.content);
        }
        if (!TextUtils.isEmpty(this.submitName)) {
            this.tv_submit.setText(this.submitName);
        }
        if (!TextUtils.isEmpty(this.cancelName)) {
            this.tv_cancel.setText(this.cancelName);
        }
        if (!TextUtils.isEmpty(this.title)) {
            this.tv_title.setText(this.title);
        }
        int i = this.gravity;
        if (i != 0) {
            this.tv_content.setGravity(i);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.yd_saas_dialog_commom);
        initView();
    }

    public YdCommonDialog setCanDismiss(boolean z) {
        setCanceledOnTouchOutside(z);
        setCancelable(z);
        return this;
    }

    public YdCommonDialog setCancelName(String str) {
        this.cancelName = str;
        TextView textView = this.tv_cancel;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public YdCommonDialog setContent(String str) {
        this.content = str;
        TextView textView = this.tv_content;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public YdCommonDialog setContentGravity(int i) {
        this.gravity = i;
        TextView textView = this.tv_content;
        if (textView != null) {
            textView.setGravity(i);
        }
        return this;
    }

    public YdCommonDialog setOnCancleListener(OnCancleListener onCancleListener) {
        this.onCancleListener = onCancleListener;
        return this;
    }

    public YdCommonDialog setOnSubmitListener(OnSubmitListener onSubmitListener) {
        this.onSubmitListener = onSubmitListener;
        return this;
    }

    public YdCommonDialog setSubmitName(String str) {
        this.submitName = str;
        TextView textView = this.tv_submit;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public YdCommonDialog setTitle(String str) {
        this.title = str;
        TextView textView = this.tv_title;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }
}

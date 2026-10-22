package com.kc.dw.core.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.safe.m;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MSDialog extends Dialog {
    private boolean canceledOnTouchOutside;
    private String iconUrl;
    private View.OnClickListener negativeListener;
    private String negativeText;
    private View.OnClickListener positiveListener;
    private String positiveText;
    private boolean showCloseBtn;
    private String title;

    @Keep
    public static class Builder {
        private boolean canceledOnTouchOutside;
        private Context context;
        private String iconUrl;
        private View.OnClickListener negativeListener;
        private String negativeText;
        private View.OnClickListener positiveListener;
        private String positiveText;
        private boolean showCloseBtn;
        private String title;

        public Builder(Context context) {
            this.context = context;
        }

        public MSDialog build() {
            MSDialog mSDialog = new MSDialog(this.context);
            mSDialog.title = this.title;
            mSDialog.iconUrl = this.iconUrl;
            mSDialog.showCloseBtn = this.showCloseBtn;
            mSDialog.canceledOnTouchOutside = this.canceledOnTouchOutside;
            mSDialog.positiveText = this.positiveText;
            mSDialog.negativeText = this.negativeText;
            mSDialog.negativeListener = this.negativeListener;
            mSDialog.positiveListener = this.positiveListener;
            return mSDialog;
        }

        public Builder setCanceledOnTouchOutside(boolean z) {
            this.canceledOnTouchOutside = z;
            return this;
        }

        public Builder setIconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.negativeText = str;
            this.negativeListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str, View.OnClickListener onClickListener) {
            this.positiveText = str;
            this.positiveListener = onClickListener;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.showCloseBtn = z;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public MSDialog(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        setContentView(R.layout.ssd_dialog);
        d dVar = new d(findViewById(R.id.ms_dialog_root));
        if (!TextUtils.isEmpty(this.iconUrl)) {
            dVar.b(R.id.ms_dialog_icon).a(this.iconUrl, false);
        }
        dVar.b(R.id.ms_dialog_title).a((CharSequence) this.title);
        int i = R.id.ms_dialog_close;
        dVar.b(i).d(this.showCloseBtn ? 0 : 8);
        if (!TextUtils.isEmpty(this.negativeText)) {
            dVar.b(R.id.ms_dialog_negative).a((CharSequence) this.negativeText);
        }
        d dVarB = dVar.b(R.id.ms_dialog_negative);
        m mVar = new m(this) { // from class: com.kc.dw.core.view.MSDialog.1
            public final MSDialog this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view) {
                super.safeOnClick(view);
                this.this$0.dismiss();
                if (this.this$0.negativeListener != null) {
                    this.this$0.negativeListener.onClick(view);
                }
            }
        };
        View view = dVarB.d;
        if (view != null) {
            view.setOnClickListener(mVar);
        }
        if (!TextUtils.isEmpty(this.positiveText)) {
            dVar.b(R.id.ms_dialog_positive).a((CharSequence) this.positiveText);
        }
        m mVar2 = new m(this) { // from class: com.kc.dw.core.view.MSDialog.2
            public final MSDialog this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view2) {
                super.safeOnClick(view2);
                this.this$0.dismiss();
                if (this.this$0.positiveListener != null) {
                    this.this$0.positiveListener.onClick(view2);
                }
            }
        };
        View view2 = dVar.b(R.id.ms_dialog_positive).d;
        if (view2 != null) {
            view2.setOnClickListener(mVar2);
        }
        View view3 = dVar.b(i).d;
        if (view3 != null) {
            view3.setOnClickListener(mVar2);
        }
        setCanceledOnTouchOutside(this.canceledOnTouchOutside);
        setCancelable(this.canceledOnTouchOutside);
    }
}

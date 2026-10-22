package com.acse.ottn.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomWarnLayout extends LinearLayout {
    private RelativeLayout sncakbar_relativeLayout;
    private TextView textView;
    private TextView tv_look;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23288a;

        public a(Activity activity) {
            this.f23288a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f23288a, 10010);
        }
    }

    public CustomWarnLayout(Context context) {
        super(context);
    }

    private void initView() {
        if (AcseHelpManager.isOpenAccessiblityPermission()) {
            this.sncakbar_relativeLayout.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        this.sncakbar_relativeLayout.setBackgroundResource(i);
    }

    public void setButtonBackgroundResource(int i) {
        this.tv_look.setBackgroundResource(i);
    }

    public void setButtonPadding(int i, int i2, int i3, int i4) {
        this.tv_look.setPadding(i, i2, i3, i4);
    }

    public void setButtonText(String str) {
        this.tv_look.setText(str);
    }

    public void setButtonTextSize(float f) {
        this.tv_look.setTextSize(f);
    }

    public void setContentText(String str) {
        this.textView.setText(str);
    }

    public void setContentTextSize(float f) {
        this.textView.setTextSize(f);
    }

    public void setOnClickListener(Activity activity) {
        this.sncakbar_relativeLayout.setOnClickListener(new a(activity));
        invalidate();
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.my_seeding_snackbar, (ViewGroup) this, true);
        this.textView = (TextView) findViewById(R.id.tv_content);
        this.sncakbar_relativeLayout = (RelativeLayout) findViewById(R.id.sncakbar_relativeLayout);
        this.tv_look = (TextView) findViewById(R.id.tv_look);
        initView();
        invalidate();
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

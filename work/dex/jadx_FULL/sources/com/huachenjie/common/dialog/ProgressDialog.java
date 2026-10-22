package com.huachenjie.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseAlertDialog;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ProgressDialog extends BaseAlertDialog {
    private ProgressBar mProgress;
    private TextView mTvProgressValue;

    public ProgressDialog(Context context) {
        super(context, R.style.base_dialog_theme);
    }

    private void initView(Context context) {
        this.mTvProgressValue = (TextView) findViewById(R.id.tv_progress);
        this.mProgress = (ProgressBar) findViewById(R.id.progress_download);
        setCancelable(false);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_download_progress);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = jj8.b(260.0f, getContext());
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        initView(getContext());
    }

    public void update(int progress) {
        this.mTvProgressValue.setText(progress + "%");
        this.mProgress.setProgress(progress);
    }

    public ProgressDialog(Context context, int theme) {
        super(context, R.style.base_dialog_theme);
    }
}

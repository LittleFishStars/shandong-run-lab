package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.huachenjie.common.base.BaseDialogFragment;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.run.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunValidDialog extends BaseDialogFragment {
    private static final String KEY_TOTAL_DISTANCE = "totalDistance";
    private static final String KEY_VALID_DISTANCE = "validDistance";
    private static final String TAG = "SunshineRunValidDialog";
    private Handler mHandler;
    private ValidRunListener mListener;
    private TextView mTvClose;
    private TextView mTvContent;
    private TextView mTvSubContent;
    private TextView mTvTitle;
    private TextView mTvToShare;
    private long totalDistance;
    private long validDistance;

    public interface ValidRunListener {
        void onShare();
    }

    public class a implements RxViewUtil.ClickAction {
        public a() {
        }

        @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
        public void onClick() {
            RunValidDialog.this.dismiss();
        }
    }

    public class b implements RxViewUtil.ClickAction {
        public b() {
        }

        @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
        public void onClick() {
            if (RunValidDialog.this.mListener != null) {
                RunValidDialog.this.mListener.onShare();
            }
            RunValidDialog.this.dismiss();
        }
    }

    private void initData() {
        if (this.validDistance == 0) {
            this.mTvTitle.setText(R.string.run_free_valid_dialog_title);
            this.mTvContent.setVisibility(8);
            this.mTvSubContent.setVisibility(8);
            return;
        }
        this.mTvTitle.setText(R.string.run_sunshine_valid_dialog_title);
        this.mTvContent.setVisibility(0);
        this.mTvContent.setText(String.format(getString(R.string.run_valid_dialog_content), BigDecimal.valueOf(this.validDistance).divide(BigDecimal.valueOf(1000L), 2, 4).toString()));
        if (this.totalDistance > this.validDistance) {
            this.mTvSubContent.setVisibility(0);
            this.mTvSubContent.setText(String.format(getString(R.string.run_valid_dialog_sub_content), BigDecimal.valueOf(this.validDistance).divide(BigDecimal.valueOf(1000L), 2, 4).toString()));
        }
    }

    public static RunValidDialog newInstance(long validDistance, long distance) {
        RunValidDialog runValidDialog = new RunValidDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_VALID_DISTANCE, validDistance);
        bundle.putLong(KEY_TOTAL_DISTANCE, distance);
        runValidDialog.setArguments(bundle);
        return runValidDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (isAdded()) {
            super.dismiss();
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public void dismissLoadingDialogs() {
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment
    public int getContentViewRes() {
        return R.layout.run_dialog_sunshinerun_valid;
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment
    public void handleArguments(Bundle arguments) {
        if (arguments != null) {
            this.validDistance = arguments.getLong(KEY_VALID_DISTANCE, 0L);
            this.totalDistance = arguments.getLong(KEY_TOTAL_DISTANCE, 0L);
        }
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment
    public void initField() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment
    public void initView() {
        this.mTvClose = (TextView) f(R.id.tv_close);
        this.mTvToShare = (TextView) f(R.id.tv_to_share);
        this.mTvContent = (TextView) f(R.id.tv_content);
        this.mTvSubContent = (TextView) f(R.id.tv_sub_content);
        this.mTvTitle = (TextView) f(R.id.tv_title);
        initData();
        RxViewUtil.f(this.mTvClose, 1000L, new a());
        RxViewUtil.f(this.mTvToShare, 1000L, new b());
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, com.huachenjie.common.R.style.base_dialog_theme);
    }

    @Override // com.huachenjie.common.base.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mListener = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(com.huachenjie.common.R.style.common_bottom_dialog_style);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public void setValidRunListener(ValidRunListener listener) {
        this.mListener = listener;
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(String message, boolean cancelable) {
        return null;
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(boolean cancelable) {
        return null;
    }
}

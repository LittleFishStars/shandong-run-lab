package com.huachenjie.common.base.data_binding;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.huachenjie.common.R;
import com.huachenjie.common.callback.DefaultCallback;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BaseDialogFragment extends DialogFragment {
    private FragmentDialogDismissCallback fragmentDialogDismissCallback;
    protected Activity mActivity;
    public DefaultCallback mBaseDialogCallback;
    private boolean isShowing = false;
    private String skipClassTag = "";

    public interface FragmentDialogDismissCallback {
        void onDismiss();
    }

    private void showAllowingStateLoss(@NonNull FragmentManager manager, @Nullable String tag) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        FragmentTransaction fragmentTransactionBeginTransaction = manager.beginTransaction();
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.mActivity;
    }

    public String getSkipClassTag() {
        return this.skipClassTag;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setStyle(1, R.style.dialog_style);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        this.isShowing = false;
        FragmentDialogDismissCallback fragmentDialogDismissCallback = this.fragmentDialogDismissCallback;
        if (fragmentDialogDismissCallback != null) {
            fragmentDialogDismissCallback.onDismiss();
        }
    }

    public void setBaseDialogCallback(DefaultCallback callback) {
        this.mBaseDialogCallback = callback;
    }

    public void setFragmentDialogDismissCallback(FragmentDialogDismissCallback fragmentDialogDismissCallback) {
        this.fragmentDialogDismissCallback = fragmentDialogDismissCallback;
    }

    public void setSkipClassTag(String tag) {
        this.skipClassTag = tag;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        if (manager.isStateSaved()) {
            showAllowingStateLoss(manager, tag);
        } else {
            super.show(manager, tag);
        }
        this.isShowing = true;
    }
}

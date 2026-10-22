package com.huachenjie.common.base.data_binding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseVMBottomDialogFragment<T extends BaseVM> extends BaseVMDialogFragment<T> {
    protected final int WARP = -2;
    protected final int MATCH = -1;

    public abstract int getHeight();

    public abstract int getWidth();

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            int height = getHeight();
            int width = getWidth();
            if (height == -2) {
                attributes.height = -2;
            } else if (height == -1) {
                attributes.height = -1;
            } else {
                attributes.height = height;
            }
            if (width == -2) {
                attributes.width = -2;
            } else if (width == -1) {
                attributes.width = -1;
            } else {
                attributes.width = width;
            }
            window.setAttributes(attributes);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(getWidth(), getHeight());
        }
    }

    public void setStyle() {
        setStyle(1, R.style.ActionSheetDialogStyle);
    }
}

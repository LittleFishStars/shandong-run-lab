package com.huachenjie.run.page.free;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.run.R;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class CustomCaloriesFragment extends BaseVMDialogFragment<CustomCaloriesVM> {
    private InputComplete inputComplete;

    public interface InputComplete {
        void a(int calories);
    }

    public class a {
        public a() {
        }

        public void a(View v) {
            CustomCaloriesFragment.this.dismiss();
        }

        public void b(View v) {
            int i;
            String value = ((CustomCaloriesVM) ((BaseVMDialogFragment) CustomCaloriesFragment.this).mState).i.getValue();
            if (!TextUtils.isEmpty(value)) {
                try {
                    i = Integer.parseInt(value);
                } catch (Exception e) {
                    i4a.c(e.getMessage());
                    i = 0;
                }
                if (i >= 10 && i <= 1000) {
                    if (CustomCaloriesFragment.this.inputComplete != null) {
                        CustomCaloriesFragment.this.inputComplete.a(i * 1000);
                    }
                    CustomCaloriesFragment.this.dismiss();
                    return;
                }
            }
            fv5.b("请设置规定范围内的目标消耗热量");
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.run_fragment_custom_calories), Integer.valueOf(lk0.L), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(Bundle savedInstanceState) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment, com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(2, R.style.input_dialog_style);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.3f;
            attributes.softInputMode = 48;
            window.setAttributes(attributes);
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.gravity = 17;
            attributes2.width = fx7.j() - SizeUtils.b(50.0f);
            attributes2.height = -2;
            window.setAttributes(attributes2);
        }
    }

    public CustomCaloriesFragment setInputComplete(InputComplete inputComplete) {
        this.inputComplete = inputComplete;
        return this;
    }
}

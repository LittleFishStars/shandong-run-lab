package com.zj.adlib;

import android.text.method.HideReturnsTransformationMethod;
import android.widget.EditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class vm6 {
    public static void a(EditText editText, boolean show) {
        int selectionStart = editText.getSelectionStart();
        if (show) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(wm6.a());
        }
        if (selectionStart > 0) {
            try {
                editText.setSelection(selectionStart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

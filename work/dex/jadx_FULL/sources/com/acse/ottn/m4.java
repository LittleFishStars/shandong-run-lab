package com.acse.ottn;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.acse.ottn.util.HelpShopAppUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m4 f23085a;

    public static m4 a() {
        if (f23085a == null) {
            synchronized (m4.class) {
                if (f23085a == null) {
                    f23085a = new m4();
                }
            }
        }
        return f23085a;
    }

    public String b() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
            return clipboardManager.getText() != null ? clipboardManager.getText().toString().trim() : "";
        } catch (Exception e) {
            h2.a("SoftKeyboardUtil", e.getMessage());
            return "";
        }
    }

    public void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public void a(Context context, List<View> list) {
        if (list == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            inputMethodManager.hideSoftInputFromWindow(it.next().getWindowToken(), 2);
        }
    }
}

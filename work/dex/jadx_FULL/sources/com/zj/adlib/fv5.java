package com.zj.adlib;

import androidx.annotation.StringRes;
import com.blankj.utilcode.util.ToastUtils;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class fv5 {
    public static void a(@StringRes int textResId) {
        ToastUtils.m().w(17, 0, 0).s(R.drawable.bg_black_toast).E(12).D(-1).v(false).H(textResId);
    }

    public static void b(String text) {
        ToastUtils.m().w(17, 0, 0).s(R.drawable.bg_black_toast).E(12).D(-1).v(false).M(text);
    }

    public static void c(@StringRes int textResId) {
        ToastUtils.m().w(17, 0, 0).s(R.drawable.bg_black_toast).E(12).D(-1).v(true).s(-1).H(textResId);
    }

    public static void d(String text) {
        ToastUtils.m().w(17, 0, 0).s(R.drawable.bg_black_toast).E(12).D(-1).v(true).s(-1).M(text);
    }
}

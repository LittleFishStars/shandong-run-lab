package com.byazt.qcl;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 578, 20})
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "key_tt_csj_node_line_";
        }
        if ("ad_show".equals(str)) {
            return "key_tt_csj_node_line_" + str + LoginConstants.UNDER_LINE;
        }
        return "key_tt_csj_other_node_line_" + str + LoginConstants.UNDER_LINE;
    }
}

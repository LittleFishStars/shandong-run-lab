package com.baidu.mapsdkplatform.comapi.a.a;

import com.ali.auth.third.login.LoginConstants;
import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((File) obj2).getName().split(LoginConstants.UNDER_LINE)[2].compareTo(((File) obj).getName().split(LoginConstants.UNDER_LINE)[2]);
        } catch (Exception unused) {
            return 0;
        }
    }
}

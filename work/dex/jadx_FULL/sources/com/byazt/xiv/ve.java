package com.byazt.xiv;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve {
    String getAdnName();

    String getAdnVersion();

    String getAdnVersionListKey();

    String getClassName();

    Function<SparseArray<Object>, Object> getInitBridge();

    Function<SparseArray<Object>, Object> getManager();

    String getUnSupportVersion();

    void saveManager(Function<SparseArray<Object>, Object> function);

    void saveUnSupportVersion(String str);
}

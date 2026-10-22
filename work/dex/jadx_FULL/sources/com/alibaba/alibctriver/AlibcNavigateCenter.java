package com.alibaba.alibctriver;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcNavigateCenter {
    private static final String TAG = "AlibcNavigateCenter";
    private static List<IUrlNavigate> navigateUrlList = new ArrayList();

    public interface IUrlNavigate {
        boolean openUrl(Context context, String str);
    }

    public static List<IUrlNavigate> getNavigateUrlList() {
        return navigateUrlList;
    }

    public static synchronized void registerNavigateUrl(IUrlNavigate iUrlNavigate) {
        if (iUrlNavigate == null) {
            return;
        }
        navigateUrlList.add(0, iUrlNavigate);
    }
}

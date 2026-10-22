package com.alibaba.alibctriver;

import com.alibaba.triver.kit.api.proxy.IImageProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcImageCenter {
    private static final String TAG = "AlibcImageCenter";
    private static List<IImageProxy> imageList = new ArrayList();

    public static List<IImageProxy> getImageList() {
        return imageList;
    }

    public static synchronized void registerImage(IImageProxy iImageProxy) {
        if (iImageProxy == null) {
            return;
        }
        imageList.add(0, iImageProxy);
    }
}

package com.fl.saas.config.utils;

import com.fl.saas.base.widget.ShakeView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ShakeControlUtil {
    private static ShakeControlUtil sInstance;
    private final List<ShakeView> shakeViewList = new CopyOnWriteArrayList();

    private ShakeControlUtil() {
    }

    public static ShakeControlUtil getInstance() {
        if (sInstance == null) {
            synchronized (ShakeControlUtil.class) {
                sInstance = new ShakeControlUtil();
            }
        }
        return sInstance;
    }

    public void addView(ShakeView shakeView) {
        try {
            Iterator<ShakeView> it = this.shakeViewList.iterator();
            while (it.hasNext()) {
                it.next().unRegisterAccelerometer(false);
            }
            if (this.shakeViewList.contains(shakeView)) {
                return;
            }
            this.shakeViewList.add(shakeView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeView(ShakeView shakeView) {
        try {
            this.shakeViewList.remove(shakeView);
            if (this.shakeViewList.isEmpty()) {
                return;
            }
            List<ShakeView> list = this.shakeViewList;
            list.get(list.size() - 1).registerAccelerometer(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

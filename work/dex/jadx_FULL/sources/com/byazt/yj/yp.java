package com.byazt.yj;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface yp {
    yp cache(tt ttVar);

    yp cacheDir(String str);

    yp config(Bitmap.Config config);

    yp converter(da daVar);

    yp from(String str);

    yp headers(boolean z);

    yp height(int i);

    yp isLocalRes(boolean z);

    yp key(String str);

    yp loadSetp(gt gtVar);

    yp maxHeight(int i);

    yp maxWidth(int i);

    yp requestTime(boolean z);

    yp runIn(ExecutorService executorService);

    yp scaleType(ImageView.ScaleType scaleType);

    yp sync(boolean z);

    t to(ImageView imageView);

    t to(gr grVar);

    t to(gr grVar, int i);

    yp track(or orVar);

    yp type(int i);

    yp width(int i);
}

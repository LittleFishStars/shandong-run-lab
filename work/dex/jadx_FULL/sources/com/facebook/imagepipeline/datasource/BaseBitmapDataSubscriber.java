package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.zj.adlib.rm1;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<rm1<CloseableImage>> {
    public abstract void onNewResultImpl(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<rm1<CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            rm1<CloseableImage> result = dataSource.getResult();
            try {
                onNewResultImpl((result == null || !(result.s() instanceof CloseableBitmap)) ? null : ((CloseableBitmap) result.s()).k());
            } finally {
                rm1.p(result);
            }
        }
    }
}

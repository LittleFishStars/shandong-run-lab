package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.zj.adlib.rm1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<rm1<CloseableImage>>> {
    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<rm1<CloseableImage>>> dataSource) {
        if (dataSource.isFinished()) {
            List<rm1<CloseableImage>> result = dataSource.getResult();
            if (result == null) {
                onNewResultListImpl(null);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList(result.size());
                for (rm1<CloseableImage> rm1Var : result) {
                    if (rm1Var == null || !(rm1Var.s() instanceof CloseableBitmap)) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(((CloseableBitmap) rm1Var.s()).k());
                    }
                }
                onNewResultListImpl(arrayList);
            } finally {
                Iterator<rm1<CloseableImage>> it = result.iterator();
                while (it.hasNext()) {
                    rm1.p(it.next());
                }
            }
        }
    }

    public abstract void onNewResultListImpl(List<Bitmap> list);
}

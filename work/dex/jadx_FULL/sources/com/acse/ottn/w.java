package com.acse.ottn;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class w<T> extends u<T, x> {
    public w(List<T> list) {
        super(list);
    }

    @Override // com.acse.ottn.t1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x a(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new x(imageView);
    }
}

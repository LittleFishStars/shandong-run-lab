package com.zj.adlib;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.home.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ku3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RequestOptions f42909a;
    public static RequestOptions b;
    public static RequestOptions c;

    static {
        int i = R.drawable.home_bg_header;
        RequestOptions requestOptionsError = RequestOptions.placeholderOf(i).error(i);
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.ALL;
        f42909a = requestOptionsError.diskCacheStrategy(diskCacheStrategy);
        b = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        c = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(12.0f)));
    }
}

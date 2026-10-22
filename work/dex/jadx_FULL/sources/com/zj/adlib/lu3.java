package com.zj.adlib;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class lu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RequestOptions f43149a;

    static {
        RequestOptions requestOptions = new RequestOptions();
        int i = R.drawable.ic_publish_entry;
        f43149a = requestOptions.placeholder(i).error(i).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(26.0f))).diskCacheStrategy(DiskCacheStrategy.ALL);
    }
}

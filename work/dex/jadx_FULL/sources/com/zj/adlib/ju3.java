package com.zj.adlib;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ju3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RequestOptions f42674a;
    public static RequestOptions b;
    public static RequestOptions c;
    public static RequestOptions d;
    public static RequestOptions e;
    public static RequestOptions f;
    public static RequestOptions g;
    public static RequestOptions h;
    public static RequestOptions i;
    public static RequestOptions j;
    public static RequestOptions k;
    public static RequestOptions l;
    public static RequestOptions m;
    public static RequestOptions n;
    public static RequestOptions o;
    public static RequestOptions p;
    public static RequestOptions q;
    public static RequestOptions r;
    public static RequestOptions s;
    public static RequestOptions t;
    public static RequestOptions u;
    public static RequestOptions v;
    public static RequestOptions w;
    public static RequestOptions x;
    public static RequestOptions y;
    public static RequestOptions z;

    static {
        RequestOptions requestOptionsCircleCropTransform = RequestOptions.circleCropTransform();
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.ALL;
        f42674a = requestOptionsCircleCropTransform.diskCacheStrategy(diskCacheStrategy);
        RequestOptions requestOptionsCircleCropTransform2 = RequestOptions.circleCropTransform();
        int i2 = R.drawable.ic_default_avatar;
        b = requestOptionsCircleCropTransform2.placeholder(i2).error(i2).diskCacheStrategy(diskCacheStrategy);
        c = new RequestOptions().diskCacheStrategy(diskCacheStrategy);
        d = RequestOptions.circleCropTransform().diskCacheStrategy(diskCacheStrategy);
        RequestOptions requestOptionsCenterCrop = new RequestOptions().centerCrop();
        int i3 = R.drawable.ic_school_default;
        e = requestOptionsCenterCrop.placeholder(i3).error(i3).diskCacheStrategy(diskCacheStrategy).circleCrop();
        f = new RequestOptions().placeholder(R.color.percent_20_translucent_white).diskCacheStrategy(diskCacheStrategy);
        g = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(13.0f)));
        h = new RequestOptions().diskCacheStrategy(diskCacheStrategy);
        RequestOptions requestOptions = new RequestOptions();
        int i4 = R.mipmap.bg_authorize_credentials_front;
        i = requestOptions.placeholder(i4).error(i4).diskCacheStrategy(diskCacheStrategy);
        RequestOptions requestOptions2 = new RequestOptions();
        int i5 = R.mipmap.bg_authorize_credentials_reverse;
        j = requestOptions2.placeholder(i5).error(i5).diskCacheStrategy(diskCacheStrategy);
        k = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(20.0f)));
        l = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        m = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(12.0f)));
        n = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(20.0f)));
        RequestOptions requestOptions3 = new RequestOptions();
        int i6 = R.mipmap.ic_empty_middle_placeholder;
        RequestOptions requestOptionsPlaceholder = requestOptions3.placeholder(i6);
        int i7 = R.mipmap.ic_empty_middle;
        o = requestOptionsPlaceholder.error(i7).diskCacheStrategy(diskCacheStrategy).transforms(new FitCenter(), new RoundedCorners(SizeUtils.b(12.0f)));
        p = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        q = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(4.0f)));
        r = new RequestOptions().diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(24.0f)));
        RequestOptions requestOptions4 = new RequestOptions();
        int i8 = R.mipmap.bg_work_image_placeholder;
        s = requestOptions4.placeholder(i8).error(i8).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(12.0f)));
        t = new RequestOptions().placeholder(i8).error(i8).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(4.0f)));
        RequestOptions requestOptions5 = new RequestOptions();
        int i9 = R.mipmap.bg_topic_image_placeholder;
        u = requestOptions5.placeholder(i9).error(i9).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        RequestOptions requestOptions6 = new RequestOptions();
        int i10 = R.mipmap.bg_channel_image_placeholder;
        v = requestOptions6.placeholder(i10).error(i10).diskCacheStrategy(diskCacheStrategy);
        w = new RequestOptions().placeholder(i6).error(i7).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(4.0f)));
        RequestOptions requestOptions7 = new RequestOptions();
        int i11 = R.mipmap.bg_college_town_placeholder;
        x = requestOptions7.placeholder(i11).error(i11).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        y = new RequestOptions().placeholder(i11).error(i11).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(8.0f)));
        RequestOptions requestOptions8 = new RequestOptions();
        int i12 = R.mipmap.bg_mall_poster_placeholder;
        z = requestOptions8.placeholder(i12).error(i12).diskCacheStrategy(diskCacheStrategy).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(20.0f)));
    }
}

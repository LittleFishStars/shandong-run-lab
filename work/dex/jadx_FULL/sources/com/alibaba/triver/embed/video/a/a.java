package com.alibaba.triver.embed.video.a;

import android.content.Context;
import android.os.Environment;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f24824a = ".mp4";
    public static String b = ".aac";
    public static final String c = "/Taobao/";

    public static String a(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            TriverToastUtils.showToast(context, InternationalUtil.getString(context, R.string.triver_video_sdcard_check_tip));
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.toString() + "/Taobao/");
        if (!file.exists()) {
            file.mkdir();
        }
        return externalStorageDirectory.toString() + "/Taobao/";
    }

    public static String a(String str) {
        return "TB_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + str;
    }
}

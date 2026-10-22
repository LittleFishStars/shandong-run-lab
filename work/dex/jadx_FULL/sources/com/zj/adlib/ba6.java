package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.byazt.tk.AdBaseConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.fl.saas.common.util.FileTypeUtils;
import com.ltmb.ltadsdk.core.download.SYDownloadManager;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ba6 {
    public static Intent a(String param) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(param)), "*/*");
        return intent;
    }

    public static Intent b(String param) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(param)), AdBaseConstants.MIME_APK);
        return intent;
    }

    public static Intent c(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(Uri.fromFile(new File(param)), "audio/*");
        return intent;
    }

    public static Intent d(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/x-chm");
        return intent;
    }

    public static Intent e(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/vnd.ms-excel");
        return intent;
    }

    public static Intent f(String param) {
        Uri uriBuild = Uri.parse(param).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(param).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriBuild, "text/html");
        return intent;
    }

    public static Intent g(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "image/*");
        return intent;
    }

    public static Intent h(Context ctx, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(mf9.f(ctx, new File(param)), "application/pdf");
        return intent;
    }

    public static Intent i(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/vnd.ms-powerpoint");
        return intent;
    }

    public static String j(String url) {
        int iLastIndexOf = url.lastIndexOf(Consts.DOT) + 1;
        int iIndexOf = url.indexOf("?");
        if (iLastIndexOf < 0) {
            return "";
        }
        if (iIndexOf <= 0) {
            iIndexOf = url.length();
        }
        return url.substring(iLastIndexOf, iIndexOf);
    }

    public static Intent k(String param, boolean paramBoolean) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        if (paramBoolean) {
            intent.setDataAndType(Uri.parse(param), "text/plain");
        } else {
            intent.setDataAndType(Uri.fromFile(new File(param)), "text/plain");
        }
        return intent;
    }

    public static Intent l(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(Uri.fromFile(new File(param)), "video/*");
        return intent;
    }

    public static Intent m(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/msword");
        return intent;
    }

    public static Intent n(Context ctx, String filePath) {
        if (!new File(filePath).exists()) {
            return null;
        }
        String lowerCase = j(filePath).toLowerCase();
        if (lowerCase.equals("m4a") || lowerCase.equals(FileTypeUtils.FILE_TYPE_MP3) || lowerCase.equals("mid") || lowerCase.equals("xmf") || lowerCase.equals("ogg") || lowerCase.equals(FileTypeUtils.FILE_TYPE_WAV)) {
            return c(filePath);
        }
        if (lowerCase.equals("3gp") || lowerCase.equals("mp4")) {
            return l(filePath);
        }
        if (lowerCase.equals("jpg") || lowerCase.equals(FileTypeUtils.FILE_TYPE_GIF) || lowerCase.equals("png") || lowerCase.equals(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) || lowerCase.equals(FileTypeUtils.FILE_TYPE_BMP)) {
            return g(filePath);
        }
        if (lowerCase.equals(SYDownloadManager.DOWNLOAD_TYPE_APK)) {
            return b(filePath);
        }
        if (lowerCase.equals("ppt")) {
            return i(filePath);
        }
        if (lowerCase.equals("xls")) {
            return e(filePath);
        }
        if (lowerCase.equals("doc")) {
            return m(filePath);
        }
        if (lowerCase.equals("pdf")) {
            return h(ctx, filePath);
        }
        if (lowerCase.equals("chm")) {
            return d(filePath);
        }
        return lowerCase.equals("txt") ? k(filePath, false) : a(filePath);
    }
}

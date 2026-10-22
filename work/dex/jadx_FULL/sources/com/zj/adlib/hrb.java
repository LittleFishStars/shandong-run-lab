package com.zj.adlib;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class hrb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static hrb f42188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList f17058a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Pattern f17059a = Pattern.compile("(\\.3gp|\\.mp4|\\.m4a|\\.aac|\\.ts|\\.flac|\\.mp3|\\.mid|\\.xmf|\\.mxmf|\\.rtttl|\\.rtx|\\.ota|\\.imy|\\.ogg|\\.mkv|\\.wav|\\.webm|\\.avi|\\.flv|\\.rmvb|\\.wmv)");
    public final Pattern b = Pattern.compile("(hybrid\\.vivo\\.com|//hapjs.org/|\\.hapjs.org|statres\\.quickapp\\.cn|hap://|hwfastapp://|thefatherofsalmon|fastappjump-drcn|fastapprouter)");

    public static hrb a() {
        if (f42188a == null) {
            synchronized (hrb.class) {
                if (f42188a == null) {
                    f42188a = new hrb();
                }
            }
        }
        return f42188a;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Matcher matcher = Pattern.compile(".*/(.*)").matcher(new URL(str).getPath());
            return matcher.matches() ? matcher.group(1) : String.valueOf(str.hashCode());
        } catch (Throwable th) {
            th.getMessage();
            return "";
        }
    }

    public static synchronized boolean c(String str) {
        boolean z;
        boolean zFind;
        Pattern pattern;
        Pattern pattern2;
        boolean z2;
        ArrayList arrayList;
        hrb hrbVarA = a();
        hrbVarA.getClass();
        z = true;
        if (str != null && ((str.startsWith("http://") || str.startsWith("https://")) && !str.contains(".apk"))) {
            if (TextUtils.isEmpty(str)) {
                zFind = false;
            } else {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                zFind = mimeTypeFromExtension != null && (mimeTypeFromExtension.contains("video") || mimeTypeFromExtension.contains("audio"));
                if (!zFind && (pattern = hrbVarA.f17059a) != null) {
                    zFind = pattern.matcher(str).find();
                }
            }
            if (!zFind) {
                if (!((TextUtils.isEmpty(str) || (pattern2 = hrbVarA.b) == null) ? false : pattern2.matcher(str).find()) && !str.contains("douyin.com")) {
                    try {
                        if (!TextUtils.isEmpty(str) && (arrayList = hrbVarA.f17058a) != null && !arrayList.isEmpty()) {
                            Iterator it = hrbVarA.f17058a.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (str.contains((String) it.next())) {
                                    z2 = true;
                                    break;
                                }
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    } catch (Throwable unused) {
                    }
                    if (!z2) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }
}

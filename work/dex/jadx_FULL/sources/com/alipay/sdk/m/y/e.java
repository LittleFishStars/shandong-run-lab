package com.alipay.sdk.m.y;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    public static WebResourceResponse a(String str) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c(str));
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", "*");
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeTypeFromExtension, "UTF-8", fileInputStream);
            try {
                webResourceResponse2.setResponseHeaders(map);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                g.a(th);
                return webResourceResponse;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        b(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static String c(String str) {
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    public static JSONObject d(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    String string = sb.toString();
                    g.b(com.alipay.sdk.m.n.a.B, "readFileToJSON result=" + string);
                    return new JSONObject(string);
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }
}

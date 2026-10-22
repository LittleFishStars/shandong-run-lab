package com.acse.ottn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f1<T> implements Converter<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f22991a;

    public f1(Type type) {
        this.f22991a = type;
    }

    public static String b(String str) {
        StringBuilder sb;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Integer.toHexString(cCharAt).length() == 1) {
                sb = new StringBuilder();
                str2 = "u0";
            } else {
                sb = new StringBuilder();
                str2 = "u";
            }
            sb.append(str2);
            sb.append(Integer.toHexString(cCharAt));
            stringBuffer.append(sb.toString());
        }
        return Pattern.compile("u02").matcher(stringBuffer).replaceAll("");
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(responseBody.source());
        String utf8 = bufferedSourceBuffer.readUtf8();
        bufferedSourceBuffer.close();
        return (T) JSON.parseObject(f.b().a(utf8, f.b), this.f22991a, new Feature[0]);
    }

    public static String a(String str) {
        if (!str.contains("u")) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArrSplit = str.split("u");
        for (int i = 1; i < strArrSplit.length; i++) {
            stringBuffer.append((char) Integer.parseInt(strArrSplit[i], 16));
        }
        return stringBuffer.toString();
    }
}

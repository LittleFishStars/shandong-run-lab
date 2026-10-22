package com.acse.ottn;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g1<T> implements Converter<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f23010a;

    public g1(Type type) {
        this.f23010a = type;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(ResponseBody responseBody) throws IOException {
        String strA;
        int i;
        BufferedSource bufferedSourceBuffer = Okio.buffer(responseBody.source());
        String utf8 = bufferedSourceBuffer.readUtf8();
        bufferedSourceBuffer.close();
        T t = (T) null;
        try {
            JSONObject jSONObject = new JSONObject(utf8);
            try {
                jSONObject.getInt("r");
                t = (T) JSON.parseObject(utf8, this.f23010a, new Feature[0]);
                return t;
            } catch (Exception unused) {
                boolean z = true;
                if (jSONObject.getInt("heart_beat") != 1) {
                    z = false;
                }
                strA = l0.a(z);
                i = t;
                if (TextUtils.isEmpty(strA)) {
                    return (T) JSON.parseObject(utf8, this.f23010a, new Feature[i]);
                }
                h2.a(q3.e, "samon responese data = " + a(b(g.a().a(utf8, strA))));
                return (T) JSON.parseObject(a(b(g.a().a(utf8, strA))), this.f23010a, new Feature[i]);
            }
        } catch (JSONException unused2) {
            strA = l0.a((boolean) t);
            i = t;
        }
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

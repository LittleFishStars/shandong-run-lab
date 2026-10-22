package com.aliyun.sls.android.producer;

import android.text.TextUtils;
import com.aliyun.sls.android.producer.utils.TimeUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogProducerHttpTool {
    private static final String TAG = "LogProducerHttpTool";

    public static int android_http_post(String urlString, String[] header, byte[] body) {
        return android_http_post(urlString, "POST", header, body);
    }

    private static long toLong(String time) {
        try {
            return Long.parseLong(time);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static int android_http_post(String urlString, String method, String[] header, byte[] body) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
            if ("post".equalsIgnoreCase(method)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setRequestMethod(method);
            if (header != null) {
                int length = header.length / 2;
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    httpURLConnection.setRequestProperty(header[i2], header[i2 + 1]);
                }
            }
            if ("post".equalsIgnoreCase(method)) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(body);
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            String headerField = httpURLConnection.getHeaderField("x-log-time");
            if (headerField != null && !"".equals(headerField)) {
                long j = toLong(headerField);
                if (j > 1500000000 && j < 4294967294L) {
                    TimeUtils.updateServerTime(j);
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode / 100 == 2) {
                return responseCode;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            bufferedReader.close();
            if (400 == responseCode && TextUtils.isEmpty(httpURLConnection.getHeaderField("x-log-requestid"))) {
                android.util.Log.w(TAG, "request may have been blocked. it will be retried. errorCode: " + ((Object) sb));
                return -1;
            }
            android.util.Log.w(TAG, "code: " + responseCode + ", response: " + ((Object) sb));
            return responseCode;
        } catch (Exception e) {
            android.util.Log.w(TAG, "exception: " + e.getLocalizedMessage());
            return -1;
        }
    }
}

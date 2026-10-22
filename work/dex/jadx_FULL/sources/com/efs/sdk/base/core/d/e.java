package com.efs.sdk.base.core.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements com.efs.sdk.base.core.b.d {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(strArrSplit[1]);
                } else {
                    ((Map) httpResponse.extra).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.d
    @NonNull
    public final HttpResponse a(LogDto logDto, boolean z) {
        HttpResponse httpResponse;
        try {
            c cVar = f.a.f29604a.f29603a;
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strMd5 = EncodeUtil.md5(cVar.b + cVar.c + strValueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.f29602a;
            if (str.startsWith("http")) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(strMd5.substring(strMd5.length() - 8));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(cVar.c);
            sb.append("&app=");
            sb.append(cVar.b);
            sb.append("&zip=gzip");
            String string = sb.toString();
            int length = 0;
            byte[] data = new byte[0];
            if (logDto.getLogBodyType() == 0) {
                data = logDto.getData();
                length = data.length;
            } else if (1 == logDto.getLogBodyType()) {
                data = FileUtil.read(logDto.getFile().getPath());
                length = data.length;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Content-Length", String.valueOf(length));
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(string).a(map);
            dVarA.f29615a.c = data;
            httpResponse = dVarA.a().b();
            a(httpResponse);
            if (httpResponse.succ) {
                Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
                FileUtil.delete(logDto.getFile());
                return httpResponse;
            }
            Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
            return httpResponse;
        } catch (Throwable th) {
            httpResponse = 0 == 0 ? new HttpResponse() : null;
            Log.e("efs.wa.send", "get file size error", th);
        }
    }
}

package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.baidu.mapapi.http.wrapper.annotation.Properties;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SignUtils {
    public static String signParams(BaseParams baseParams, Map<String, String> map, boolean z) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Field field : baseParams.getClass().getFields()) {
            Properties properties = (Properties) field.getAnnotation(Properties.class);
            String name = properties == null ? field.getName() : properties.name();
            Object obj = field.get(baseParams);
            if (!UserTrackConstant.SIGN.equals(name) && obj != null && !TextUtils.isEmpty(String.valueOf(obj))) {
                sb.append(name);
                sb.append("=");
                sb.append(toValue(obj, z));
                sb.append("&");
            }
        }
        for (Field field2 : baseParams.getClass().getDeclaredFields()) {
            field2.setAccessible(true);
            Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
            String name2 = properties2 == null ? field2.getName() : properties2.name();
            Object obj2 = field2.get(baseParams);
            if (!UserTrackConstant.SIGN.equals(name2) && obj2 != null && !TextUtils.isEmpty(String.valueOf(obj2))) {
                sb.append(name2);
                sb.append("=");
                sb.append(toValue(obj2, z));
                sb.append("&");
            }
            field2.setAccessible(false);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(toValue(entry.getValue(), z));
                sb.append("&");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return AppMD5.getSignMD5StringUTF8(sb.toString());
    }

    public static String toValue(Object obj, boolean z) {
        if (obj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                int length = objArr.length;
                while (i < length) {
                    sb.append(ParamsUtils.getValue(objArr[i], z));
                    sb.append(",");
                    i++;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                while (i < list.size()) {
                    sb.append(ParamsUtils.getValue(list.get(i), z));
                    sb.append(",");
                    i++;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        } else if (obj instanceof Set) {
            Set set = (Set) obj;
            if (!set.isEmpty()) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    sb.append(ParamsUtils.getValue(it.next(), z));
                    sb.append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(ParamsUtils.getValue(obj, z));
        }
        return sb.toString();
    }
}

package huachenjie.sdk.map.lib_main;

import android.text.TextUtils;
import huachenjie.sdk.map.lib_base.MapType;
import huachenjie.sdk.map.lib_main.consts.ConstSdk;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HCJMapManager {
    public static final String NAME_GET_INSTANCE = "getInstance";

    public static int getMapType() {
        return MapType.getMapType();
    }

    public static void initMap(int i) {
        try {
            Field[] declaredFields = ConstSdk.class.getDeclaredFields();
            if (declaredFields == null || declaredFields.length <= 0) {
                return;
            }
            for (Field field : declaredFields) {
                String str = (String) field.get(null);
                if (!TextUtils.isEmpty(str)) {
                    MapType.setMapType(i);
                    Method method = Class.forName(str).getMethod("getInstance", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(null, new Object[0]);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }
}

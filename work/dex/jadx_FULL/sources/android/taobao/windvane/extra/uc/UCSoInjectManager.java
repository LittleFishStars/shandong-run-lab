package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.taobao.windvane.extra.c.c;
import com.alipay.mobile.jsengine.NativeLibs;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class UCSoInjectManager {
    private static UCSoInjectManager INSTANCE;

    private static Field getField(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        return null;
    }

    private static Object getFieldValue(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return getField(obj, str).get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static UCSoInjectManager getInstance() {
        if (INSTANCE == null) {
            synchronized (UCSoInjectManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UCSoInjectManager();
                }
            }
        }
        return INSTANCE;
    }

    private static Method getMethod(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    private static Object getPathList(Object obj) {
        try {
            return getField(obj, NativeLibs.FIELD_PATH_LIST).get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean inject(Context context) {
        return inject(UCSoInjectManager.class.getClassLoader(), c.b(context.getApplicationContext()));
    }

    private boolean inject(Object obj, String str) {
        boolean z;
        Object[] objArr;
        Object pathList = getPathList(obj);
        Object fieldValue = getFieldValue(pathList, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES);
        if (fieldValue == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            List list = (List) fieldValue;
            List list2 = (List) getFieldValue(pathList, "systemNativeLibraryDirectories");
            ArrayList arrayList = new ArrayList(list.size() + 2 + (list2 != null ? list2.size() : 0));
            arrayList.add(file);
            arrayList.addAll(list);
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            Method method = getMethod(pathList, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class);
            if (method != null) {
                objArr = (Object[]) method.invoke(pathList, arrayList);
            } else {
                objArr = (Object[]) getMethod(pathList, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class, File.class, List.class).invoke(pathList, arrayList, null, new ArrayList());
            }
            if (objArr != null) {
                getField(pathList, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(pathList, objArr);
                z = true;
            } else {
                z = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!z) {
            try {
                File[] fileArr = (File[]) fieldValue;
                ArrayList arrayList2 = new ArrayList(fileArr.length + 1);
                arrayList2.add(file);
                for (File file2 : fileArr) {
                    if (!str.equals(file2)) {
                        arrayList2.add(file2);
                    }
                }
                getField(pathList, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).set(pathList, arrayList2.toArray(new File[0]));
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return z;
    }
}

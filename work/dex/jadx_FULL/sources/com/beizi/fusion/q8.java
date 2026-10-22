package com.beizi.fusion;

import android.text.TextUtils;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class q8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f27684a = new ConcurrentHashMap();

    public static ig a(gb gbVar, boolean z) {
        return b(gbVar, z);
    }

    private static ig b(gb gbVar, boolean z) {
        kg kgVar;
        if (gbVar == null) {
            return null;
        }
        Field[] fieldArrA = a(gbVar.getClass());
        ig igVar = new ig();
        for (Field field : fieldArrA) {
            if (field != null && (kgVar = (kg) field.getAnnotation(kg.class)) != null && !kgVar.exclude()) {
                Class<?> type = field.getType();
                String strKey = kgVar.key();
                Object objA = pl.a(gbVar, field);
                if (!z) {
                    a(igVar, strKey, objA, type, z);
                } else if (objA != null) {
                    if (!(objA instanceof String)) {
                        a(igVar, strKey, objA, type, z);
                    } else if (!TextUtils.isEmpty(objA.toString())) {
                        a(igVar, strKey, objA, type, z);
                    }
                }
            }
        }
        return igVar;
    }

    public static byte[] a(fg fgVar) {
        if (fgVar != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);
                    try {
                        new p8().a(fgVar, outputStreamWriter);
                        outputStreamWriter.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (Throwable th) {
                        try {
                            outputStreamWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException unused) {
            }
        }
        return new byte[0];
    }

    private static void a(ig igVar, String str, Object obj, Class cls, boolean z) {
        if (String.class.isAssignableFrom(cls)) {
            igVar.a(str, obj != null ? obj.toString() : "");
            return;
        }
        if (Number.class.isAssignableFrom(cls)) {
            igVar.a(str, obj != null ? (Number) obj : 0);
            return;
        }
        if (List.class.isAssignableFrom(cls)) {
            igVar.a(str, a(obj, z));
        } else if (cls.isArray()) {
            igVar.a(str, a(obj, z));
        } else if (gb.class.isAssignableFrom(cls)) {
            igVar.a(str, ((gb) obj).getAnalyseGsonObject());
        }
    }

    private static eg a(Object obj, boolean z) {
        List listAsList;
        if (obj != null) {
            if (obj instanceof List) {
                listAsList = (List) obj;
            } else {
                listAsList = obj.getClass().isArray() ? Arrays.asList((Object[]) obj) : null;
            }
            if (listAsList != null) {
                eg egVar = new eg();
                for (Object obj2 : listAsList) {
                    if (obj2 != null) {
                        a(egVar, obj2, obj2.getClass(), z);
                    }
                }
                return egVar;
            }
        }
        return new eg();
    }

    private static void a(eg egVar, Object obj, Class cls, boolean z) {
        if (String.class.isAssignableFrom(cls)) {
            egVar.a(obj.toString());
        } else if (Number.class.isAssignableFrom(cls)) {
            egVar.a((Number) obj);
        } else if (obj instanceof gb) {
            egVar.a(((gb) obj).getAnalyseGsonObject());
        }
    }

    private static Field[] a(Class cls) {
        Field[] fieldArr = (Field[]) f27684a.get(cls);
        if (fieldArr != null) {
            return fieldArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Class superclass = cls; superclass != null && !superclass.equals(AnalyseBasicReceiveLog.class) && !superclass.equals(Object.class); superclass = superclass.getSuperclass()) {
            arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        Field[] fieldArr2 = (Field[]) arrayList.toArray(new Field[0]);
        f27684a.put(cls, fieldArr2);
        return fieldArr2;
    }
}

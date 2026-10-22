package com.easyjson.parser.deserializer;

import com.easyjson.JSONException;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class FieldDeserializer {
    public final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo, int i) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, double d) throws IllegalAccessException {
        this.fieldInfo.field.setDouble(obj, d);
    }

    public void setValue(Object obj, float f) throws IllegalAccessException {
        this.fieldInfo.field.setFloat(obj, f);
    }

    public void setValue(Object obj, int i) throws IllegalAccessException {
        this.fieldInfo.field.setInt(obj, i);
    }

    public void setValue(Object obj, long j) throws IllegalAccessException {
        this.fieldInfo.field.setLong(obj, j);
    }

    public void setValue(Object obj, Object obj2) {
        Collection collection;
        Map map;
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        FieldInfo fieldInfo = this.fieldInfo;
        Field field = fieldInfo.field;
        Method method = fieldInfo.method;
        try {
            if (fieldInfo.fieldAccess) {
                if (!fieldInfo.getOnly) {
                    field.set(obj, obj2);
                    return;
                }
                if (Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    map = (Map) field.get(obj);
                    if (map == null) {
                        return;
                    }
                    map.putAll((Map) obj2);
                    return;
                }
                collection = (Collection) field.get(obj);
                if (collection == null) {
                    return;
                }
                collection.addAll((Collection) obj2);
            }
            if (!fieldInfo.getOnly) {
                method.invoke(obj, obj2);
                return;
            }
            if (Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                map = (Map) method.invoke(obj, new Object[0]);
                if (map != null) {
                    map.putAll((Map) obj2);
                    return;
                }
                return;
            }
            collection = (Collection) method.invoke(obj, new Object[0]);
            if (collection != null) {
                collection.addAll((Collection) obj2);
            }
        } catch (Exception e) {
            throw new JSONException("set property error, " + this.fieldInfo.name, e);
        }
    }
}

package com.easyjson.serializer;

import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.easyjson.JSONException;
import com.easyjson.annotation.JSONField;
import com.easyjson.util.FieldInfo;
import java.lang.reflect.Member;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FieldSerializer implements Comparable<FieldSerializer> {
    protected final int features;
    public final FieldInfo fieldInfo;
    protected final String format;
    private a runtimeInfo;
    protected final boolean writeNull;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObjectSerializer f29557a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Class<?> f1520a;

        public a(ObjectSerializer objectSerializer, Class<?> cls) {
            this.f29557a = objectSerializer;
            this.f1520a = cls;
        }
    }

    public FieldSerializer(FieldInfo fieldInfo) {
        this.fieldInfo = fieldInfo;
        JSONField annotation = fieldInfo.getAnnotation();
        boolean z = false;
        String str = null;
        if (annotation != null) {
            boolean z2 = false;
            for (SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    z2 = true;
                }
            }
            String strTrim = annotation.format().trim();
            str = strTrim.length() != 0 ? strTrim : null;
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
            z = z2;
        } else {
            this.features = 0;
        }
        this.writeNull = z;
        this.format = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public Object getPropertyValue(Object obj) {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e) {
            FieldInfo fieldInfo = this.fieldInfo;
            Member member = fieldInfo.method;
            if (member == null) {
                member = fieldInfo.field;
            }
            throw new JSONException("get property error。 " + (member.getDeclaringClass().getName() + Consts.DOT + member.getName()), e);
        }
    }

    public void writePrefix(JSONSerializer jSONSerializer) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i = serializeWriter.features;
        if ((SerializerFeature.QuoteFieldNames.mask & i) == 0 || (i & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
        } else {
            char[] cArr = this.fieldInfo.name_chars;
            serializeWriter.write(cArr, 0, cArr.length);
        }
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) {
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            Class<?> cls = obj == null ? this.fieldInfo.fieldClass : obj.getClass();
            this.runtimeInfo = new a(jSONSerializer.config.get(cls), cls);
        }
        a aVar = this.runtimeInfo;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == aVar.f1520a) {
                ObjectSerializer objectSerializer = aVar.f29557a;
                FieldInfo fieldInfo = this.fieldInfo;
                objectSerializer.write(jSONSerializer, obj, fieldInfo.name, fieldInfo.fieldType);
                return;
            } else {
                ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
                FieldInfo fieldInfo2 = this.fieldInfo;
                objectSerializer2.write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType);
                return;
            }
        }
        if ((this.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0 && Number.class.isAssignableFrom(aVar.f1520a)) {
            jSONSerializer.out.write(48);
            return;
        }
        int i = this.features;
        if ((SerializerFeature.WriteNullBooleanAsFalse.mask & i) != 0 && Boolean.class == aVar.f1520a) {
            jSONSerializer.out.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else if ((i & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Collection.class.isAssignableFrom(aVar.f1520a)) {
            aVar.f29557a.write(jSONSerializer, null, this.fieldInfo.name, aVar.f1520a);
        } else {
            jSONSerializer.out.write("[]");
        }
    }
}

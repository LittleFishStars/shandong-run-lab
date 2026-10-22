package com.easyjson.parser;

import com.easyjson.parser.deserializer.FieldDeserializer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.easyjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Class<?> cls;
        if (this.fieldValueDeserilizer == null) {
            ParserConfig parserConfig = defaultJSONParser.config;
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        if (type instanceof ParameterizedType) {
            defaultJSONParser.contex.type = type;
        }
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        FieldInfo fieldInfo2 = this.fieldInfo;
        Object objDeserialze = objectDeserializer.deserialze(defaultJSONParser, fieldInfo2.fieldType, fieldInfo2.name);
        if (defaultJSONParser.resolveStatus == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser.contex;
            defaultJSONParser.resolveStatus = 0;
            return;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, objDeserialze);
            return;
        }
        if (objDeserialze == null && ((cls = this.fieldInfo.fieldClass) == Byte.TYPE || cls == Short.TYPE || cls == Float.TYPE || cls == Double.TYPE)) {
            return;
        }
        setValue(obj, objDeserialze);
    }
}

package com.easyjson.serializer;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = new BooleanCodec();

    private BooleanCodec() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r3 == 1) goto L5;
     */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i != 6) {
            if (i == 7) {
                jSONLexer.nextToken(16);
            } else {
                if (i != 2) {
                    Object obj2 = defaultJSONParser.parse();
                    if (obj2 == null) {
                        return null;
                    }
                    return (T) TypeUtils.castToBoolean(obj2);
                }
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
            }
            return (T) Boolean.FALSE;
        }
        jSONLexer.nextToken(16);
        return (T) Boolean.TRUE;
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0) {
                serializeWriter.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
    }
}

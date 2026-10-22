package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class JSONMethodCodec implements MethodCodec {
    public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();

    private JSONMethodCodec() {
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public Object decodeEnvelope(@NonNull ByteBuffer byteBuffer) {
        try {
            Object objDecodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (objDecodeMessage instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) objDecodeMessage;
                if (jSONArray.length() == 1) {
                    return unwrapNull(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object objUnwrapNull = unwrapNull(jSONArray.opt(1));
                    Object objUnwrapNull2 = unwrapNull(jSONArray.opt(2));
                    if ((obj instanceof String) && (objUnwrapNull == null || (objUnwrapNull instanceof String))) {
                        throw new FlutterException((String) obj, (String) objUnwrapNull, objUnwrapNull2);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + objDecodeMessage);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer) {
        try {
            Object objDecodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (objDecodeMessage instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objDecodeMessage;
                Object obj = jSONObject.get("method");
                Object objUnwrapNull = unwrapNull(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new MethodCall((String) obj, objUnwrapNull);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + objDecodeMessage);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeErrorEnvelope(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)));
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)).put(JSONUtil.wrap(str3)));
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", methodCall.method);
            jSONObject.put("args", JSONUtil.wrap(methodCall.arguments));
            return JSONMessageCodec.INSTANCE.encodeMessage(jSONObject);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // io.flutter.plugin.common.MethodCodec
    @NonNull
    public ByteBuffer encodeSuccessEnvelope(@Nullable Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(obj)));
    }

    public Object unwrapNull(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}

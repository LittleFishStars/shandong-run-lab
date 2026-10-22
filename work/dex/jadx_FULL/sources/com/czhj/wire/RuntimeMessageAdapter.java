package com.czhj.wire;

import com.alipay.sdk.m.p.a;
import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import com.czhj.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29515a = "██";
    private final Class<M> b;
    private final Class<B> c;
    private final Map<Integer, FieldBinding<M, B>> d;

    public RuntimeMessageAdapter(Class<M> cls, Class<B> cls2, Map<Integer, FieldBinding<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.b = cls;
        this.c = cls2;
        this.d = map;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> a(Class<M> cls) {
        Class clsB = b(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new FieldBinding(wireField, field, clsB));
            }
        }
        return new RuntimeMessageAdapter<>(cls, clsB, Collections.unmodifiableMap(linkedHashMap));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> b(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    public Map<Integer, FieldBinding<M, B>> a() {
        return this.d;
    }

    public B b() {
        try {
            return this.c.newInstance();
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public M decode(ProtoReader protoReader) throws IOException {
        Message.Builder builderB = b();
        long jBeginMessage = protoReader.beginMessage();
        while (true) {
            int iNextTag = protoReader.nextTag();
            if (iNextTag == -1) {
                protoReader.endMessage(jBeginMessage);
                return (M) builderB.build();
            }
            FieldBinding<M, B> fieldBinding = this.d.get(Integer.valueOf(iNextTag));
            if (fieldBinding != null) {
                try {
                    fieldBinding.a(builderB, (fieldBinding.a() ? fieldBinding.d() : fieldBinding.b()).decode(protoReader));
                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                    builderB.addUnknownField(iNextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                }
            } else {
                FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                builderB.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
            }
        }
    }

    @Override // com.czhj.wire.ProtoAdapter
    public void encode(ProtoWriter protoWriter, M m) throws IOException {
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object objA = fieldBinding.a(m);
            if (objA != null) {
                fieldBinding.d().encodeWithTag(protoWriter, fieldBinding.tag, objA);
            }
        }
        protoWriter.writeBytes(m.unknownFields());
    }

    @Override // com.czhj.wire.ProtoAdapter
    public int encodedSize(M m) {
        int i = m.cachedSerializedSize;
        if (i != 0) {
            return i;
        }
        int iEncodedSizeWithTag = 0;
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object objA = fieldBinding.a(m);
            if (objA != null) {
                iEncodedSizeWithTag += fieldBinding.d().encodedSizeWithTag(fieldBinding.tag, objA);
            }
        }
        int size = iEncodedSizeWithTag + m.unknownFields().size();
        m.cachedSerializedSize = size;
        return size;
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && ((RuntimeMessageAdapter) obj).b == this.b;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.czhj.wire.ProtoAdapter
    public M redact(M m) {
        Message.Builder builderNewBuilder = m.newBuilder();
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            if (fieldBinding.redacted && fieldBinding.label == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", fieldBinding.name, this.javaType.getName()));
            }
            boolean zIsAssignableFrom = Message.class.isAssignableFrom(fieldBinding.b().javaType);
            if (fieldBinding.redacted || (zIsAssignableFrom && !fieldBinding.label.a())) {
                Object objA = fieldBinding.a(builderNewBuilder);
                if (objA != null) {
                    fieldBinding.b(builderNewBuilder, fieldBinding.d().redact(objA));
                }
            } else if (zIsAssignableFrom && fieldBinding.label.a()) {
                Internal.redactElements((List) fieldBinding.a(builderNewBuilder), fieldBinding.b());
            }
        }
        builderNewBuilder.clearUnknownFields();
        return (M) builderNewBuilder.build();
    }

    @Override // com.czhj.wire.ProtoAdapter
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        for (FieldBinding<M, B> fieldBinding : this.d.values()) {
            Object objA = fieldBinding.a(m);
            if (objA != null) {
                sb.append(", ");
                sb.append(fieldBinding.name);
                sb.append(a.h);
                if (fieldBinding.redacted) {
                    objA = f29515a;
                }
                sb.append(objA);
            }
        }
        sb.replace(0, 2, this.b.getSimpleName() + '{');
        sb.append('}');
        return sb.toString();
    }
}

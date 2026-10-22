package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class EnumOptions extends Message<EnumOptions, Builder> {
    public static final ProtoAdapter<EnumOptions> ADAPTER = new ProtoAdapter_EnumOptions();
    public static final Boolean DEFAULT_ALLOW_ALIAS;
    public static final Boolean DEFAULT_DEPRECATED;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean allow_alias;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean deprecated;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption#ADAPTER", label = WireField.Label.REPEATED, tag = 999)
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends Message.Builder<EnumOptions, Builder> {
        public Boolean allow_alias;
        public Boolean deprecated;
        public List<UninterpretedOption> uninterpreted_option = Internal.newMutableList();

        public Builder allow_alias(Boolean bool) {
            this.allow_alias = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public EnumOptions build() {
            return new EnumOptions(this.allow_alias, this.deprecated, this.uninterpreted_option, super.buildUnknownFields());
        }

        public Builder deprecated(Boolean bool) {
            this.deprecated = bool;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> list) {
            Internal.checkElementsNotNull(list);
            this.uninterpreted_option = list;
            return this;
        }
    }

    public static final class ProtoAdapter_EnumOptions extends ProtoAdapter<EnumOptions> {
        public ProtoAdapter_EnumOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, EnumOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public EnumOptions decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 2) {
                    builder.allow_alias(ProtoAdapter.BOOL.decode(protoReader));
                } else if (iNextTag == 3) {
                    builder.deprecated(ProtoAdapter.BOOL.decode(protoReader));
                } else if (iNextTag != 999) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, EnumOptions enumOptions) throws IOException {
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 2, enumOptions.allow_alias);
            protoAdapter.encodeWithTag(protoWriter, 3, enumOptions.deprecated);
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(protoWriter, 999, enumOptions.uninterpreted_option);
            protoWriter.writeBytes(enumOptions.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(EnumOptions enumOptions) {
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            return protoAdapter.encodedSizeWithTag(2, enumOptions.allow_alias) + protoAdapter.encodedSizeWithTag(3, enumOptions.deprecated) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, enumOptions.uninterpreted_option) + enumOptions.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public EnumOptions redact(EnumOptions enumOptions) {
            Builder builderNewBuilder = enumOptions.newBuilder();
            Internal.redactElements(builderNewBuilder.uninterpreted_option, UninterpretedOption.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_ALLOW_ALIAS = bool;
        DEFAULT_DEPRECATED = bool;
    }

    public EnumOptions(Boolean bool, Boolean bool2, List<UninterpretedOption> list) {
        this(bool, bool2, list, ByteString.EMPTY);
    }

    public EnumOptions(Boolean bool, Boolean bool2, List<UninterpretedOption> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.allow_alias = bool;
        this.deprecated = bool2;
        this.uninterpreted_option = Internal.immutableCopyOf("uninterpreted_option", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnumOptions)) {
            return false;
        }
        EnumOptions enumOptions = (EnumOptions) obj;
        return unknownFields().equals(enumOptions.unknownFields()) && Internal.equals(this.allow_alias, enumOptions.allow_alias) && Internal.equals(this.deprecated, enumOptions.deprecated) && this.uninterpreted_option.equals(enumOptions.uninterpreted_option);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.allow_alias;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.deprecated;
        int iHashCode3 = ((iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37) + this.uninterpreted_option.hashCode();
        this.hashCode = iHashCode3;
        return iHashCode3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.allow_alias = this.allow_alias;
        builder.deprecated = this.deprecated;
        builder.uninterpreted_option = Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.allow_alias != null) {
            sb.append(", allow_alias=");
            sb.append(this.allow_alias);
        }
        if (this.deprecated != null) {
            sb.append(", deprecated=");
            sb.append(this.deprecated);
        }
        if (!this.uninterpreted_option.isEmpty()) {
            sb.append(", uninterpreted_option=");
            sb.append(this.uninterpreted_option);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "EnumOptions{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

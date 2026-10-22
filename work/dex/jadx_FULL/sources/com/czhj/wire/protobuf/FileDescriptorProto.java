package com.czhj.wire.protobuf;

import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FileDescriptorProto extends Message<FileDescriptorProto, Builder> {
    public static final ProtoAdapter<FileDescriptorProto> ADAPTER = new ProtoAdapter_FileDescriptorProto();
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PACKAGE_ = "";
    public static final String DEFAULT_SYNTAX = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> dependency;

    @WireField(adapter = "com.google.protobuf.EnumDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<EnumDescriptorProto> enum_type;

    @WireField(adapter = "com.google.protobuf.FieldDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<FieldDescriptorProto> extension;

    @WireField(adapter = "com.google.protobuf.DescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<DescriptorProto> message_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @WireField(adapter = "com.google.protobuf.FileOptions#ADAPTER", tag = 8)
    public final FileOptions options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String package_;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 10)
    public final List<Integer> public_dependency;

    @WireField(adapter = "com.google.protobuf.ServiceDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<ServiceDescriptorProto> service;

    @WireField(adapter = "com.google.protobuf.SourceCodeInfo#ADAPTER", tag = 9)
    public final SourceCodeInfo source_code_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String syntax;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 11)
    public final List<Integer> weak_dependency;

    public static final class Builder extends Message.Builder<FileDescriptorProto, Builder> {
        public String name;
        public FileOptions options;
        public String package_;
        public SourceCodeInfo source_code_info;
        public String syntax;
        public List<String> dependency = Internal.newMutableList();
        public List<Integer> public_dependency = Internal.newMutableList();
        public List<Integer> weak_dependency = Internal.newMutableList();
        public List<DescriptorProto> message_type = Internal.newMutableList();
        public List<EnumDescriptorProto> enum_type = Internal.newMutableList();
        public List<ServiceDescriptorProto> service = Internal.newMutableList();
        public List<FieldDescriptorProto> extension = Internal.newMutableList();

        @Override // com.czhj.wire.Message.Builder
        public FileDescriptorProto build() {
            return new FileDescriptorProto(this.name, this.package_, this.dependency, this.public_dependency, this.weak_dependency, this.message_type, this.enum_type, this.service, this.extension, this.options, this.source_code_info, this.syntax, super.buildUnknownFields());
        }

        public Builder dependency(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.dependency = list;
            return this;
        }

        public Builder enum_type(List<EnumDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.enum_type = list;
            return this;
        }

        public Builder extension(List<FieldDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.extension = list;
            return this;
        }

        public Builder message_type(List<DescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.message_type = list;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder options(FileOptions fileOptions) {
            this.options = fileOptions;
            return this;
        }

        public Builder package_(String str) {
            this.package_ = str;
            return this;
        }

        public Builder public_dependency(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.public_dependency = list;
            return this;
        }

        public Builder service(List<ServiceDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.service = list;
            return this;
        }

        public Builder source_code_info(SourceCodeInfo sourceCodeInfo) {
            this.source_code_info = sourceCodeInfo;
            return this;
        }

        public Builder syntax(String str) {
            this.syntax = str;
            return this;
        }

        public Builder weak_dependency(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.weak_dependency = list;
            return this;
        }
    }

    public static final class ProtoAdapter_FileDescriptorProto extends ProtoAdapter<FileDescriptorProto> {
        public ProtoAdapter_FileDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorProto decode(ProtoReader protoReader) throws IOException {
            List list;
            Object obj;
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                switch (iNextTag) {
                    case 1:
                        builder.name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.package_(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 3:
                        list = builder.dependency;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        list.add(obj);
                        break;
                    case 4:
                        list = builder.message_type;
                        obj = (DescriptorProto) DescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 5:
                        list = builder.enum_type;
                        obj = (EnumDescriptorProto) EnumDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 6:
                        list = builder.service;
                        obj = (ServiceDescriptorProto) ServiceDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 7:
                        list = builder.extension;
                        obj = (FieldDescriptorProto) FieldDescriptorProto.ADAPTER.decode(protoReader);
                        list.add(obj);
                        break;
                    case 8:
                        builder.options(FileOptions.ADAPTER.decode(protoReader));
                        break;
                    case 9:
                        builder.source_code_info(SourceCodeInfo.ADAPTER.decode(protoReader));
                        break;
                    case 10:
                        list = builder.public_dependency;
                        obj = (Integer) ProtoAdapter.INT32.decode(protoReader);
                        list.add(obj);
                        break;
                    case 11:
                        list = builder.weak_dependency;
                        obj = (Integer) ProtoAdapter.INT32.decode(protoReader);
                        list.add(obj);
                        break;
                    case 12:
                        builder.syntax(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FileDescriptorProto fileDescriptorProto) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, fileDescriptorProto.name);
            protoAdapter.encodeWithTag(protoWriter, 2, fileDescriptorProto.package_);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 3, fileDescriptorProto.dependency);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 10, fileDescriptorProto.public_dependency);
            protoAdapter2.asRepeated().encodeWithTag(protoWriter, 11, fileDescriptorProto.weak_dependency);
            DescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, fileDescriptorProto.message_type);
            EnumDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, fileDescriptorProto.enum_type);
            ServiceDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, fileDescriptorProto.service);
            FieldDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, fileDescriptorProto.extension);
            FileOptions.ADAPTER.encodeWithTag(protoWriter, 8, fileDescriptorProto.options);
            SourceCodeInfo.ADAPTER.encodeWithTag(protoWriter, 9, fileDescriptorProto.source_code_info);
            protoAdapter.encodeWithTag(protoWriter, 12, fileDescriptorProto.syntax);
            protoWriter.writeBytes(fileDescriptorProto.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FileDescriptorProto fileDescriptorProto) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int iEncodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, fileDescriptorProto.name) + protoAdapter.encodedSizeWithTag(2, fileDescriptorProto.package_) + protoAdapter.asRepeated().encodedSizeWithTag(3, fileDescriptorProto.dependency);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            return iEncodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(10, fileDescriptorProto.public_dependency) + protoAdapter2.asRepeated().encodedSizeWithTag(11, fileDescriptorProto.weak_dependency) + DescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(4, fileDescriptorProto.message_type) + EnumDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(5, fileDescriptorProto.enum_type) + ServiceDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(6, fileDescriptorProto.service) + FieldDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(7, fileDescriptorProto.extension) + FileOptions.ADAPTER.encodedSizeWithTag(8, fileDescriptorProto.options) + SourceCodeInfo.ADAPTER.encodedSizeWithTag(9, fileDescriptorProto.source_code_info) + protoAdapter.encodedSizeWithTag(12, fileDescriptorProto.syntax) + fileDescriptorProto.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorProto redact(FileDescriptorProto fileDescriptorProto) {
            Builder builderNewBuilder = fileDescriptorProto.newBuilder();
            Internal.redactElements(builderNewBuilder.message_type, DescriptorProto.ADAPTER);
            Internal.redactElements(builderNewBuilder.enum_type, EnumDescriptorProto.ADAPTER);
            Internal.redactElements(builderNewBuilder.service, ServiceDescriptorProto.ADAPTER);
            Internal.redactElements(builderNewBuilder.extension, FieldDescriptorProto.ADAPTER);
            FileOptions fileOptions = builderNewBuilder.options;
            if (fileOptions != null) {
                builderNewBuilder.options = FileOptions.ADAPTER.redact(fileOptions);
            }
            SourceCodeInfo sourceCodeInfo = builderNewBuilder.source_code_info;
            if (sourceCodeInfo != null) {
                builderNewBuilder.source_code_info = SourceCodeInfo.ADAPTER.redact(sourceCodeInfo);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    public FileDescriptorProto(String str, String str2, List<String> list, List<Integer> list2, List<Integer> list3, List<DescriptorProto> list4, List<EnumDescriptorProto> list5, List<ServiceDescriptorProto> list6, List<FieldDescriptorProto> list7, FileOptions fileOptions, SourceCodeInfo sourceCodeInfo, String str3) {
        this(str, str2, list, list2, list3, list4, list5, list6, list7, fileOptions, sourceCodeInfo, str3, ByteString.EMPTY);
    }

    public FileDescriptorProto(String str, String str2, List<String> list, List<Integer> list2, List<Integer> list3, List<DescriptorProto> list4, List<EnumDescriptorProto> list5, List<ServiceDescriptorProto> list6, List<FieldDescriptorProto> list7, FileOptions fileOptions, SourceCodeInfo sourceCodeInfo, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.name = str;
        this.package_ = str2;
        this.dependency = Internal.immutableCopyOf("dependency", list);
        this.public_dependency = Internal.immutableCopyOf("public_dependency", list2);
        this.weak_dependency = Internal.immutableCopyOf("weak_dependency", list3);
        this.message_type = Internal.immutableCopyOf(RemoteMessageConst.MSGTYPE, list4);
        this.enum_type = Internal.immutableCopyOf("enum_type", list5);
        this.service = Internal.immutableCopyOf("service", list6);
        this.extension = Internal.immutableCopyOf("extension", list7);
        this.options = fileOptions;
        this.source_code_info = sourceCodeInfo;
        this.syntax = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDescriptorProto)) {
            return false;
        }
        FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj;
        return unknownFields().equals(fileDescriptorProto.unknownFields()) && Internal.equals(this.name, fileDescriptorProto.name) && Internal.equals(this.package_, fileDescriptorProto.package_) && this.dependency.equals(fileDescriptorProto.dependency) && this.public_dependency.equals(fileDescriptorProto.public_dependency) && this.weak_dependency.equals(fileDescriptorProto.weak_dependency) && this.message_type.equals(fileDescriptorProto.message_type) && this.enum_type.equals(fileDescriptorProto.enum_type) && this.service.equals(fileDescriptorProto.service) && this.extension.equals(fileDescriptorProto.extension) && Internal.equals(this.options, fileDescriptorProto.options) && Internal.equals(this.source_code_info, fileDescriptorProto.source_code_info) && Internal.equals(this.syntax, fileDescriptorProto.syntax);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.package_;
        int iHashCode3 = (((((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.dependency.hashCode()) * 37) + this.public_dependency.hashCode()) * 37) + this.weak_dependency.hashCode()) * 37) + this.message_type.hashCode()) * 37) + this.enum_type.hashCode()) * 37) + this.service.hashCode()) * 37) + this.extension.hashCode()) * 37;
        FileOptions fileOptions = this.options;
        int iHashCode4 = (iHashCode3 + (fileOptions != null ? fileOptions.hashCode() : 0)) * 37;
        SourceCodeInfo sourceCodeInfo = this.source_code_info;
        int iHashCode5 = (iHashCode4 + (sourceCodeInfo != null ? sourceCodeInfo.hashCode() : 0)) * 37;
        String str3 = this.syntax;
        int iHashCode6 = iHashCode5 + (str3 != null ? str3.hashCode() : 0);
        this.hashCode = iHashCode6;
        return iHashCode6;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.name = this.name;
        builder.package_ = this.package_;
        builder.dependency = Internal.copyOf("dependency", this.dependency);
        builder.public_dependency = Internal.copyOf("public_dependency", this.public_dependency);
        builder.weak_dependency = Internal.copyOf("weak_dependency", this.weak_dependency);
        builder.message_type = Internal.copyOf(RemoteMessageConst.MSGTYPE, this.message_type);
        builder.enum_type = Internal.copyOf("enum_type", this.enum_type);
        builder.service = Internal.copyOf("service", this.service);
        builder.extension = Internal.copyOf("extension", this.extension);
        builder.options = this.options;
        builder.source_code_info = this.source_code_info;
        builder.syntax = this.syntax;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        if (this.package_ != null) {
            sb.append(", package=");
            sb.append(this.package_);
        }
        if (!this.dependency.isEmpty()) {
            sb.append(", dependency=");
            sb.append(this.dependency);
        }
        if (!this.public_dependency.isEmpty()) {
            sb.append(", public_dependency=");
            sb.append(this.public_dependency);
        }
        if (!this.weak_dependency.isEmpty()) {
            sb.append(", weak_dependency=");
            sb.append(this.weak_dependency);
        }
        if (!this.message_type.isEmpty()) {
            sb.append(", message_type=");
            sb.append(this.message_type);
        }
        if (!this.enum_type.isEmpty()) {
            sb.append(", enum_type=");
            sb.append(this.enum_type);
        }
        if (!this.service.isEmpty()) {
            sb.append(", service=");
            sb.append(this.service);
        }
        if (!this.extension.isEmpty()) {
            sb.append(", extension=");
            sb.append(this.extension);
        }
        if (this.options != null) {
            sb.append(", options=");
            sb.append(this.options);
        }
        if (this.source_code_info != null) {
            sb.append(", source_code_info=");
            sb.append(this.source_code_info);
        }
        if (this.syntax != null) {
            sb.append(", syntax=");
            sb.append(this.syntax);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "FileDescriptorProto{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

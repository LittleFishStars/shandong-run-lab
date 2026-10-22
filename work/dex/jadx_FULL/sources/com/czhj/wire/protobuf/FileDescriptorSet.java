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
public final class FileDescriptorSet extends Message<FileDescriptorSet, Builder> {
    public static final ProtoAdapter<FileDescriptorSet> ADAPTER = new ProtoAdapter_FileDescriptorSet();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.google.protobuf.FileDescriptorProto#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<FileDescriptorProto> file;

    public static final class Builder extends Message.Builder<FileDescriptorSet, Builder> {
        public List<FileDescriptorProto> file = Internal.newMutableList();

        @Override // com.czhj.wire.Message.Builder
        public FileDescriptorSet build() {
            return new FileDescriptorSet(this.file, super.buildUnknownFields());
        }

        public Builder file(List<FileDescriptorProto> list) {
            Internal.checkElementsNotNull(list);
            this.file = list;
            return this;
        }
    }

    public static final class ProtoAdapter_FileDescriptorSet extends ProtoAdapter<FileDescriptorSet> {
        public ProtoAdapter_FileDescriptorSet() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag != 1) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.file.add(FileDescriptorProto.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FileDescriptorSet fileDescriptorSet) throws IOException {
            FileDescriptorProto.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, fileDescriptorSet.file);
            protoWriter.writeBytes(fileDescriptorSet.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FileDescriptorSet fileDescriptorSet) {
            return FileDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(1, fileDescriptorSet.file) + fileDescriptorSet.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileDescriptorSet redact(FileDescriptorSet fileDescriptorSet) {
            Builder builderNewBuilder = fileDescriptorSet.newBuilder();
            Internal.redactElements(builderNewBuilder.file, FileDescriptorProto.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    public FileDescriptorSet(List<FileDescriptorProto> list) {
        this(list, ByteString.EMPTY);
    }

    public FileDescriptorSet(List<FileDescriptorProto> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.file = Internal.immutableCopyOf("file", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileDescriptorSet)) {
            return false;
        }
        FileDescriptorSet fileDescriptorSet = (FileDescriptorSet) obj;
        return unknownFields().equals(fileDescriptorSet.unknownFields()) && this.file.equals(fileDescriptorSet.file);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = (unknownFields().hashCode() * 37) + this.file.hashCode();
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.file = Internal.copyOf("file", this.file);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.file.isEmpty()) {
            sb.append(", file=");
            sb.append(this.file);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "FileDescriptorSet{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

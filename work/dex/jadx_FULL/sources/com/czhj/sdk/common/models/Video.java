package com.czhj.sdk.common.models;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Video extends AndroidMessage<Video, Builder> {
    public static final ProtoAdapter<Video> ADAPTER;
    public static final Parcelable.Creator<Video> CREATOR;
    public static final Integer DEFAULT_MAX_DURATION;
    public static final Integer DEFAULT_MIN_DURATION;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer max_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer min_duration;

    public static final class Builder extends Message.Builder<Video, Builder> {
        public Integer max_duration = Video.DEFAULT_MAX_DURATION;
        public Integer min_duration = Video.DEFAULT_MIN_DURATION;

        @Override // com.czhj.wire.Message.Builder
        public Video build() {
            return new Video(this.max_duration, this.min_duration, super.buildUnknownFields());
        }

        public Builder max_duration(Integer num) {
            this.max_duration = num;
            return this;
        }

        public Builder min_duration(Integer num) {
            this.min_duration = num;
            return this;
        }
    }

    public static final class ProtoAdapter_Video extends ProtoAdapter<Video> {
        public ProtoAdapter_Video() {
            super(FieldEncoding.LENGTH_DELIMITED, Video.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Video decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.max_duration(ProtoAdapter.UINT32.decode(protoReader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.min_duration(ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Video video) throws IOException {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, video.max_duration);
            protoAdapter.encodeWithTag(protoWriter, 2, video.min_duration);
            protoWriter.writeBytes(video.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Video video) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            return protoAdapter.encodedSizeWithTag(1, video.max_duration) + protoAdapter.encodedSizeWithTag(2, video.min_duration) + video.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Video redact(Video video) {
            Builder builderNewBuilder = video.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Video protoAdapter_Video = new ProtoAdapter_Video();
        ADAPTER = protoAdapter_Video;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Video);
        DEFAULT_MAX_DURATION = 0;
        DEFAULT_MIN_DURATION = 0;
    }

    public Video(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    public Video(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.max_duration = num;
        this.min_duration = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        return unknownFields().equals(video.unknownFields()) && Internal.equals(this.max_duration, video.max_duration) && Internal.equals(this.min_duration, video.min_duration);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.max_duration;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.min_duration;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        this.hashCode = iHashCode3;
        return iHashCode3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.max_duration = this.max_duration;
        builder.min_duration = this.min_duration;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.max_duration != null) {
            sb.append(", max_duration=");
            sb.append(this.max_duration);
        }
        if (this.min_duration != null) {
            sb.append(", min_duration=");
            sb.append(this.min_duration);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "Video{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

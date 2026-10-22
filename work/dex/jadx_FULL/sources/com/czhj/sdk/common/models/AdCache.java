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
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AdCache extends AndroidMessage<AdCache, Builder> {
    public static final ProtoAdapter<AdCache> ADAPTER;
    public static final Parcelable.Creator<AdCache> CREATOR;
    public static final Integer DEFAULT_AD_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> crids;

    public static final class Builder extends Message.Builder<AdCache, Builder> {
        public Integer ad_type;
        public List<String> crids = Internal.newMutableList();

        public Builder ad_type(Integer num) {
            this.ad_type = num;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public AdCache build() {
            return new AdCache(this.ad_type, this.crids, super.buildUnknownFields());
        }

        public Builder crids(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.crids = list;
            return this;
        }
    }

    public static final class ProtoAdapter_AdCache extends ProtoAdapter<AdCache> {
        public ProtoAdapter_AdCache() {
            super(FieldEncoding.LENGTH_DELIMITED, AdCache.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public AdCache decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.ad_type(ProtoAdapter.INT32.decode(protoReader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.crids.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, AdCache adCache) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, adCache.ad_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, adCache.crids);
            protoWriter.writeBytes(adCache.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(AdCache adCache) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, adCache.ad_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, adCache.crids) + adCache.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public AdCache redact(AdCache adCache) {
            Builder builderNewBuilder = adCache.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdCache protoAdapter_AdCache = new ProtoAdapter_AdCache();
        ADAPTER = protoAdapter_AdCache;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdCache);
        DEFAULT_AD_TYPE = 0;
    }

    public AdCache(Integer num, List<String> list) {
        this(num, list, ByteString.EMPTY);
    }

    public AdCache(Integer num, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_type = num;
        this.crids = Internal.immutableCopyOf("crids", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdCache)) {
            return false;
        }
        AdCache adCache = (AdCache) obj;
        return unknownFields().equals(adCache.unknownFields()) && Internal.equals(this.ad_type, adCache.ad_type) && this.crids.equals(adCache.crids);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.ad_type;
        int iHashCode2 = ((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.crids.hashCode();
        this.hashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.ad_type = this.ad_type;
        builder.crids = Internal.copyOf("crids", this.crids);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.ad_type != null) {
            sb.append(", ad_type=");
            sb.append(this.ad_type);
        }
        if (!this.crids.isEmpty()) {
            sb.append(", crids=");
            sb.append(this.crids);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AdCache{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

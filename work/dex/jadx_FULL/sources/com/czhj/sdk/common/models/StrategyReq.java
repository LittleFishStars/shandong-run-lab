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
public final class StrategyReq extends AndroidMessage<StrategyReq, Builder> {
    public static final ProtoAdapter<StrategyReq> ADAPTER;
    public static final Parcelable.Creator<StrategyReq> CREATOR;
    public static final String DEFAULT_LAST_STRATEGY_ID = "";
    public static final Boolean DEFAULT_STRATEGY_INIT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String last_strategy_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean strategy_init;

    public static final class Builder extends Message.Builder<StrategyReq, Builder> {
        public String last_strategy_id;
        public Boolean strategy_init;

        @Override // com.czhj.wire.Message.Builder
        public StrategyReq build() {
            return new StrategyReq(this.strategy_init, this.last_strategy_id, super.buildUnknownFields());
        }

        public Builder last_strategy_id(String str) {
            this.last_strategy_id = str;
            return this;
        }

        public Builder strategy_init(Boolean bool) {
            this.strategy_init = bool;
            return this;
        }
    }

    public static final class ProtoAdapter_StrategyReq extends ProtoAdapter<StrategyReq> {
        public ProtoAdapter_StrategyReq() {
            super(FieldEncoding.LENGTH_DELIMITED, StrategyReq.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public StrategyReq decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = protoReader.beginMessage();
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    protoReader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.strategy_init(ProtoAdapter.BOOL.decode(protoReader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.last_strategy_id(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, StrategyReq strategyReq) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, strategyReq.strategy_init);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, strategyReq.last_strategy_id);
            protoWriter.writeBytes(strategyReq.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(StrategyReq strategyReq) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, strategyReq.strategy_init) + ProtoAdapter.STRING.encodedSizeWithTag(2, strategyReq.last_strategy_id) + strategyReq.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public StrategyReq redact(StrategyReq strategyReq) {
            Builder builderNewBuilder = strategyReq.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_StrategyReq protoAdapter_StrategyReq = new ProtoAdapter_StrategyReq();
        ADAPTER = protoAdapter_StrategyReq;
        CREATOR = AndroidMessage.newCreator(protoAdapter_StrategyReq);
        DEFAULT_STRATEGY_INIT = Boolean.FALSE;
    }

    public StrategyReq(Boolean bool, String str) {
        this(bool, str, ByteString.EMPTY);
    }

    public StrategyReq(Boolean bool, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.strategy_init = bool;
        this.last_strategy_id = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StrategyReq)) {
            return false;
        }
        StrategyReq strategyReq = (StrategyReq) obj;
        return unknownFields().equals(strategyReq.unknownFields()) && Internal.equals(this.strategy_init, strategyReq.strategy_init) && Internal.equals(this.last_strategy_id, strategyReq.last_strategy_id);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.strategy_init;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.last_strategy_id;
        int iHashCode3 = iHashCode2 + (str != null ? str.hashCode() : 0);
        this.hashCode = iHashCode3;
        return iHashCode3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.strategy_init = this.strategy_init;
        builder.last_strategy_id = this.last_strategy_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.strategy_init != null) {
            sb.append(", strategy_init=");
            sb.append(this.strategy_init);
        }
        if (this.last_strategy_id != null) {
            sb.append(", last_strategy_id=");
            sb.append(this.last_strategy_id);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "StrategyReq{");
        sbReplace.append('}');
        return sbReplace.toString();
    }
}

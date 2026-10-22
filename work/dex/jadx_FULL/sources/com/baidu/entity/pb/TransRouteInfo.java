package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransRouteInfo extends MessageMicro {
    public static final int LABELS_FIELD_NUMBER = 1;
    private List<TransRouteLabel> labels_ = Collections.emptyList();
    private int cachedSize = -1;

    public static TransRouteInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransRouteInfo().mergeFrom(codedInputStreamMicro);
    }

    public static TransRouteInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransRouteInfo) new TransRouteInfo().mergeFrom(bArr);
    }

    public TransRouteInfo addLabels(TransRouteLabel transRouteLabel) {
        if (transRouteLabel == null) {
            return this;
        }
        if (this.labels_.isEmpty()) {
            this.labels_ = new ArrayList();
        }
        this.labels_.add(transRouteLabel);
        return this;
    }

    public final TransRouteInfo clear() {
        clearLabels();
        this.cachedSize = -1;
        return this;
    }

    public TransRouteInfo clearLabels() {
        this.labels_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransRouteLabel getLabels(int i) {
        return this.labels_.get(i);
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public List<TransRouteLabel> getLabelsList() {
        return this.labels_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        Iterator<TransRouteLabel> it = getLabelsList().iterator();
        int iComputeMessageSize = 0;
        while (it.hasNext()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(1, it.next());
        }
        this.cachedSize = iComputeMessageSize;
        return iComputeMessageSize;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransRouteInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                TransRouteLabel transRouteLabel = new TransRouteLabel();
                codedInputStreamMicro.readMessage(transRouteLabel);
                addLabels(transRouteLabel);
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public TransRouteInfo setLabels(int i, TransRouteLabel transRouteLabel) {
        if (transRouteLabel == null) {
            return this;
        }
        this.labels_.set(i, transRouteLabel);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        Iterator<TransRouteLabel> it = getLabelsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(1, it.next());
        }
    }
}

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
public final class TransCloudExplainInfo extends MessageMicro {
    public static final int DYNAMIC_INFO_FIELD_NUMBER = 1;
    private List<TransDynamicInfo> dynamicInfo_ = Collections.emptyList();
    private int cachedSize = -1;

    public static TransCloudExplainInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransCloudExplainInfo().mergeFrom(codedInputStreamMicro);
    }

    public static TransCloudExplainInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransCloudExplainInfo) new TransCloudExplainInfo().mergeFrom(bArr);
    }

    public TransCloudExplainInfo addDynamicInfo(TransDynamicInfo transDynamicInfo) {
        if (transDynamicInfo == null) {
            return this;
        }
        if (this.dynamicInfo_.isEmpty()) {
            this.dynamicInfo_ = new ArrayList();
        }
        this.dynamicInfo_.add(transDynamicInfo);
        return this;
    }

    public final TransCloudExplainInfo clear() {
        clearDynamicInfo();
        this.cachedSize = -1;
        return this;
    }

    public TransCloudExplainInfo clearDynamicInfo() {
        this.dynamicInfo_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransDynamicInfo getDynamicInfo(int i) {
        return this.dynamicInfo_.get(i);
    }

    public int getDynamicInfoCount() {
        return this.dynamicInfo_.size();
    }

    public List<TransDynamicInfo> getDynamicInfoList() {
        return this.dynamicInfo_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        int iComputeMessageSize = 0;
        while (it.hasNext()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(1, it.next());
        }
        this.cachedSize = iComputeMessageSize;
        return iComputeMessageSize;
    }

    public final boolean isInitialized() {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransCloudExplainInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                TransDynamicInfo transDynamicInfo = new TransDynamicInfo();
                codedInputStreamMicro.readMessage(transDynamicInfo);
                addDynamicInfo(transDynamicInfo);
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public TransCloudExplainInfo setDynamicInfo(int i, TransDynamicInfo transDynamicInfo) {
        if (transDynamicInfo == null) {
            return this;
        }
        this.dynamicInfo_.set(i, transDynamicInfo);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(1, it.next());
        }
    }
}

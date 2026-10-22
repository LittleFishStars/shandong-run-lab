package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CellValue extends MessageMicro {
    public static final int CELL_COMMON_VALUE_FIELD_NUMBER = 1;
    public static final int LTE_CELL_VALUE_FIELD_NUMBER = 2;
    public static final int NR_CELL_VALUE_FIELD_NUMBER = 3;
    private boolean hasCellCommonValue;
    private boolean hasLteCellValue;
    private boolean hasNrCellValue;
    private CellCommonValue cellCommonValue_ = null;
    private LteCellValue lteCellValue_ = null;
    private NrCellValue nrCellValue_ = null;
    private int cachedSize = -1;

    public static CellValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CellValue().mergeFrom(codedInputStreamMicro);
    }

    public static CellValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CellValue) new CellValue().mergeFrom(bArr);
    }

    public final CellValue clear() {
        clearCellCommonValue();
        clearLteCellValue();
        clearNrCellValue();
        this.cachedSize = -1;
        return this;
    }

    public CellValue clearCellCommonValue() {
        this.hasCellCommonValue = false;
        this.cellCommonValue_ = null;
        return this;
    }

    public CellValue clearLteCellValue() {
        this.hasLteCellValue = false;
        this.lteCellValue_ = null;
        return this;
    }

    public CellValue clearNrCellValue() {
        this.hasNrCellValue = false;
        this.nrCellValue_ = null;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CellCommonValue getCellCommonValue() {
        return this.cellCommonValue_;
    }

    public LteCellValue getLteCellValue() {
        return this.lteCellValue_;
    }

    public NrCellValue getNrCellValue() {
        return this.nrCellValue_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeMessageSize = hasCellCommonValue() ? 0 + CodedOutputStreamMicro.computeMessageSize(1, getCellCommonValue()) : 0;
        if (hasLteCellValue()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getLteCellValue());
        }
        if (hasNrCellValue()) {
            iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(3, getNrCellValue());
        }
        this.cachedSize = iComputeMessageSize;
        return iComputeMessageSize;
    }

    public boolean hasCellCommonValue() {
        return this.hasCellCommonValue;
    }

    public boolean hasLteCellValue() {
        return this.hasLteCellValue;
    }

    public boolean hasNrCellValue() {
        return this.hasNrCellValue;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CellValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                CellCommonValue cellCommonValue = new CellCommonValue();
                codedInputStreamMicro.readMessage(cellCommonValue);
                setCellCommonValue(cellCommonValue);
            } else if (tag == 18) {
                LteCellValue lteCellValue = new LteCellValue();
                codedInputStreamMicro.readMessage(lteCellValue);
                setLteCellValue(lteCellValue);
            } else if (tag == 26) {
                NrCellValue nrCellValue = new NrCellValue();
                codedInputStreamMicro.readMessage(nrCellValue);
                setNrCellValue(nrCellValue);
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public CellValue setCellCommonValue(CellCommonValue cellCommonValue) {
        if (cellCommonValue == null) {
            return clearCellCommonValue();
        }
        this.hasCellCommonValue = true;
        this.cellCommonValue_ = cellCommonValue;
        return this;
    }

    public CellValue setLteCellValue(LteCellValue lteCellValue) {
        if (lteCellValue == null) {
            return clearLteCellValue();
        }
        this.hasLteCellValue = true;
        this.lteCellValue_ = lteCellValue;
        return this;
    }

    public CellValue setNrCellValue(NrCellValue nrCellValue) {
        if (nrCellValue == null) {
            return clearNrCellValue();
        }
        this.hasNrCellValue = true;
        this.nrCellValue_ = nrCellValue;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCellCommonValue()) {
            codedOutputStreamMicro.writeMessage(1, getCellCommonValue());
        }
        if (hasLteCellValue()) {
            codedOutputStreamMicro.writeMessage(2, getLteCellValue());
        }
        if (hasNrCellValue()) {
            codedOutputStreamMicro.writeMessage(3, getNrCellValue());
        }
    }
}

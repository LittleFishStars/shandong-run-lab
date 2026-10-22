package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransRouteLabel extends MessageMicro {
    public static final int AVOID_JAM_TIPS_FIELD_NUMBER = 5;
    public static final int BASE_MAP_TYPE_FIELD_NUMBER = 12;
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int ICON_ID_FIELD_NUMBER = 11;
    public static final int LABEL_ORDER_FIELD_NUMBER = 8;
    public static final int LABEL_TYPE_FIELD_NUMBER = 10;
    public static final int SPEED_MARK_FIELD_NUMBER = 3;
    public static final int SUB_CONTENT_FIELD_NUMBER = 2;
    public static final int SWITCH_TIPS_FIELD_NUMBER = 4;
    public static final int TAB_CONTENT_FIELD_NUMBER = 9;
    public static final int THRESHOLD_FIELD_NUMBER = 6;
    public static final int TOLL_TIPS_FIELD_NUMBER = 7;
    public static final int VOICE_TEXT_FIELD_NUMBER = 13;
    public static final int VOICE_TEXT_SIMPLE_FIELD_NUMBER = 14;
    private ByteStringMicro avoidJamTips_;
    private int baseMapType_;
    private int cachedSize;
    private ByteStringMicro content_;
    private boolean hasAvoidJamTips;
    private boolean hasBaseMapType;
    private boolean hasContent;
    private boolean hasIconId;
    private boolean hasLabelOrder;
    private boolean hasLabelType;
    private boolean hasSpeedMark;
    private boolean hasSubContent;
    private boolean hasSwitchTips;
    private boolean hasTabContent;
    private boolean hasThreshold;
    private boolean hasTollTips;
    private boolean hasVoiceText;
    private boolean hasVoiceTextSimple;
    private ByteStringMicro iconId_;
    private int labelOrder_;
    private int labelType_;
    private int speedMark_;
    private ByteStringMicro subContent_;
    private ByteStringMicro switchTips_;
    private ByteStringMicro tabContent_;
    private int threshold_;
    private ByteStringMicro tollTips_;
    private ByteStringMicro voiceTextSimple_;
    private ByteStringMicro voiceText_;

    public TransRouteLabel() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.content_ = byteStringMicro;
        this.subContent_ = byteStringMicro;
        this.speedMark_ = 0;
        this.switchTips_ = byteStringMicro;
        this.avoidJamTips_ = byteStringMicro;
        this.threshold_ = -1;
        this.tollTips_ = byteStringMicro;
        this.labelOrder_ = 0;
        this.tabContent_ = byteStringMicro;
        this.labelType_ = 0;
        this.iconId_ = byteStringMicro;
        this.baseMapType_ = 0;
        this.voiceText_ = byteStringMicro;
        this.voiceTextSimple_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static TransRouteLabel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransRouteLabel().mergeFrom(codedInputStreamMicro);
    }

    public static TransRouteLabel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransRouteLabel) new TransRouteLabel().mergeFrom(bArr);
    }

    public final TransRouteLabel clear() {
        clearContent();
        clearSubContent();
        clearSpeedMark();
        clearSwitchTips();
        clearAvoidJamTips();
        clearThreshold();
        clearTollTips();
        clearLabelOrder();
        clearTabContent();
        clearLabelType();
        clearIconId();
        clearBaseMapType();
        clearVoiceText();
        clearVoiceTextSimple();
        this.cachedSize = -1;
        return this;
    }

    public TransRouteLabel clearAvoidJamTips() {
        this.hasAvoidJamTips = false;
        this.avoidJamTips_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearBaseMapType() {
        this.hasBaseMapType = false;
        this.baseMapType_ = 0;
        return this;
    }

    public TransRouteLabel clearContent() {
        this.hasContent = false;
        this.content_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearIconId() {
        this.hasIconId = false;
        this.iconId_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearLabelOrder() {
        this.hasLabelOrder = false;
        this.labelOrder_ = 0;
        return this;
    }

    public TransRouteLabel clearLabelType() {
        this.hasLabelType = false;
        this.labelType_ = 0;
        return this;
    }

    public TransRouteLabel clearSpeedMark() {
        this.hasSpeedMark = false;
        this.speedMark_ = 0;
        return this;
    }

    public TransRouteLabel clearSubContent() {
        this.hasSubContent = false;
        this.subContent_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearSwitchTips() {
        this.hasSwitchTips = false;
        this.switchTips_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearTabContent() {
        this.hasTabContent = false;
        this.tabContent_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearThreshold() {
        this.hasThreshold = false;
        this.threshold_ = -1;
        return this;
    }

    public TransRouteLabel clearTollTips() {
        this.hasTollTips = false;
        this.tollTips_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearVoiceText() {
        this.hasVoiceText = false;
        this.voiceText_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteLabel clearVoiceTextSimple() {
        this.hasVoiceTextSimple = false;
        this.voiceTextSimple_ = ByteStringMicro.EMPTY;
        return this;
    }

    public ByteStringMicro getAvoidJamTips() {
        return this.avoidJamTips_;
    }

    public int getBaseMapType() {
        return this.baseMapType_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getContent() {
        return this.content_;
    }

    public ByteStringMicro getIconId() {
        return this.iconId_;
    }

    public int getLabelOrder() {
        return this.labelOrder_;
    }

    public int getLabelType() {
        return this.labelType_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSize = hasContent() ? 0 + CodedOutputStreamMicro.computeBytesSize(1, getContent()) : 0;
        if (hasSubContent()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getSubContent());
        }
        if (hasSpeedMark()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(3, getSpeedMark());
        }
        if (hasSwitchTips()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(4, getSwitchTips());
        }
        if (hasAvoidJamTips()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(5, getAvoidJamTips());
        }
        if (hasThreshold()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(6, getThreshold());
        }
        if (hasTollTips()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(7, getTollTips());
        }
        if (hasLabelOrder()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(8, getLabelOrder());
        }
        if (hasTabContent()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(9, getTabContent());
        }
        if (hasLabelType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(10, getLabelType());
        }
        if (hasIconId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(11, getIconId());
        }
        if (hasBaseMapType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(12, getBaseMapType());
        }
        if (hasVoiceText()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(13, getVoiceText());
        }
        if (hasVoiceTextSimple()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(14, getVoiceTextSimple());
        }
        this.cachedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    public int getSpeedMark() {
        return this.speedMark_;
    }

    public ByteStringMicro getSubContent() {
        return this.subContent_;
    }

    public ByteStringMicro getSwitchTips() {
        return this.switchTips_;
    }

    public ByteStringMicro getTabContent() {
        return this.tabContent_;
    }

    public int getThreshold() {
        return this.threshold_;
    }

    public ByteStringMicro getTollTips() {
        return this.tollTips_;
    }

    public ByteStringMicro getVoiceText() {
        return this.voiceText_;
    }

    public ByteStringMicro getVoiceTextSimple() {
        return this.voiceTextSimple_;
    }

    public boolean hasAvoidJamTips() {
        return this.hasAvoidJamTips;
    }

    public boolean hasBaseMapType() {
        return this.hasBaseMapType;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasIconId() {
        return this.hasIconId;
    }

    public boolean hasLabelOrder() {
        return this.hasLabelOrder;
    }

    public boolean hasLabelType() {
        return this.hasLabelType;
    }

    public boolean hasSpeedMark() {
        return this.hasSpeedMark;
    }

    public boolean hasSubContent() {
        return this.hasSubContent;
    }

    public boolean hasSwitchTips() {
        return this.hasSwitchTips;
    }

    public boolean hasTabContent() {
        return this.hasTabContent;
    }

    public boolean hasThreshold() {
        return this.hasThreshold;
    }

    public boolean hasTollTips() {
        return this.hasTollTips;
    }

    public boolean hasVoiceText() {
        return this.hasVoiceText;
    }

    public boolean hasVoiceTextSimple() {
        return this.hasVoiceTextSimple;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransRouteLabel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    setContent(codedInputStreamMicro.readBytes());
                    break;
                case 18:
                    setSubContent(codedInputStreamMicro.readBytes());
                    break;
                case 24:
                    setSpeedMark(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    setSwitchTips(codedInputStreamMicro.readBytes());
                    break;
                case 42:
                    setAvoidJamTips(codedInputStreamMicro.readBytes());
                    break;
                case 48:
                    setThreshold(codedInputStreamMicro.readInt32());
                    break;
                case 58:
                    setTollTips(codedInputStreamMicro.readBytes());
                    break;
                case 64:
                    setLabelOrder(codedInputStreamMicro.readInt32());
                    break;
                case 74:
                    setTabContent(codedInputStreamMicro.readBytes());
                    break;
                case 80:
                    setLabelType(codedInputStreamMicro.readInt32());
                    break;
                case 90:
                    setIconId(codedInputStreamMicro.readBytes());
                    break;
                case 96:
                    setBaseMapType(codedInputStreamMicro.readInt32());
                    break;
                case 106:
                    setVoiceText(codedInputStreamMicro.readBytes());
                    break;
                case 114:
                    setVoiceTextSimple(codedInputStreamMicro.readBytes());
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    public TransRouteLabel setAvoidJamTips(ByteStringMicro byteStringMicro) {
        this.hasAvoidJamTips = true;
        this.avoidJamTips_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setBaseMapType(int i) {
        this.hasBaseMapType = true;
        this.baseMapType_ = i;
        return this;
    }

    public TransRouteLabel setContent(ByteStringMicro byteStringMicro) {
        this.hasContent = true;
        this.content_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setIconId(ByteStringMicro byteStringMicro) {
        this.hasIconId = true;
        this.iconId_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setLabelOrder(int i) {
        this.hasLabelOrder = true;
        this.labelOrder_ = i;
        return this;
    }

    public TransRouteLabel setLabelType(int i) {
        this.hasLabelType = true;
        this.labelType_ = i;
        return this;
    }

    public TransRouteLabel setSpeedMark(int i) {
        this.hasSpeedMark = true;
        this.speedMark_ = i;
        return this;
    }

    public TransRouteLabel setSubContent(ByteStringMicro byteStringMicro) {
        this.hasSubContent = true;
        this.subContent_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setSwitchTips(ByteStringMicro byteStringMicro) {
        this.hasSwitchTips = true;
        this.switchTips_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setTabContent(ByteStringMicro byteStringMicro) {
        this.hasTabContent = true;
        this.tabContent_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setThreshold(int i) {
        this.hasThreshold = true;
        this.threshold_ = i;
        return this;
    }

    public TransRouteLabel setTollTips(ByteStringMicro byteStringMicro) {
        this.hasTollTips = true;
        this.tollTips_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setVoiceText(ByteStringMicro byteStringMicro) {
        this.hasVoiceText = true;
        this.voiceText_ = byteStringMicro;
        return this;
    }

    public TransRouteLabel setVoiceTextSimple(ByteStringMicro byteStringMicro) {
        this.hasVoiceTextSimple = true;
        this.voiceTextSimple_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasContent()) {
            codedOutputStreamMicro.writeBytes(1, getContent());
        }
        if (hasSubContent()) {
            codedOutputStreamMicro.writeBytes(2, getSubContent());
        }
        if (hasSpeedMark()) {
            codedOutputStreamMicro.writeInt32(3, getSpeedMark());
        }
        if (hasSwitchTips()) {
            codedOutputStreamMicro.writeBytes(4, getSwitchTips());
        }
        if (hasAvoidJamTips()) {
            codedOutputStreamMicro.writeBytes(5, getAvoidJamTips());
        }
        if (hasThreshold()) {
            codedOutputStreamMicro.writeInt32(6, getThreshold());
        }
        if (hasTollTips()) {
            codedOutputStreamMicro.writeBytes(7, getTollTips());
        }
        if (hasLabelOrder()) {
            codedOutputStreamMicro.writeInt32(8, getLabelOrder());
        }
        if (hasTabContent()) {
            codedOutputStreamMicro.writeBytes(9, getTabContent());
        }
        if (hasLabelType()) {
            codedOutputStreamMicro.writeInt32(10, getLabelType());
        }
        if (hasIconId()) {
            codedOutputStreamMicro.writeBytes(11, getIconId());
        }
        if (hasBaseMapType()) {
            codedOutputStreamMicro.writeInt32(12, getBaseMapType());
        }
        if (hasVoiceText()) {
            codedOutputStreamMicro.writeBytes(13, getVoiceText());
        }
        if (hasVoiceTextSimple()) {
            codedOutputStreamMicro.writeBytes(14, getVoiceTextSimple());
        }
    }
}

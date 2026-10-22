package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SelectObjectRequest extends TeaModel {

    @NameInMap("Body")
    public SelectObjectRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    @Validation(required = true)
    public SelectObjectRequestFilter filter;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class SelectObjectRequestBody extends TeaModel {

        @NameInMap("SelectRequest")
        @Validation(required = true)
        public SelectObjectRequestBodySelectRequest selectRequest;

        public static SelectObjectRequestBody build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBody) TeaModel.build(map, new SelectObjectRequestBody());
        }

        public SelectObjectRequestBodySelectRequest getSelectRequest() {
            return this.selectRequest;
        }

        public SelectObjectRequestBody setSelectRequest(SelectObjectRequestBodySelectRequest selectObjectRequestBodySelectRequest) {
            this.selectRequest = selectObjectRequestBodySelectRequest;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequest extends TeaModel {

        @NameInMap("Expression")
        public String expression;

        @NameInMap("InputSerialization")
        public SelectObjectRequestBodySelectRequestInputSerialization inputSerialization;

        @NameInMap("Options")
        public SelectObjectRequestBodySelectRequestOptions options;

        @NameInMap("OutputSerialization")
        public SelectObjectRequestBodySelectRequestOutputSerialization outputSerialization;

        public static SelectObjectRequestBodySelectRequest build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequest) TeaModel.build(map, new SelectObjectRequestBodySelectRequest());
        }

        public String getExpression() {
            return this.expression;
        }

        public SelectObjectRequestBodySelectRequestInputSerialization getInputSerialization() {
            return this.inputSerialization;
        }

        public SelectObjectRequestBodySelectRequestOptions getOptions() {
            return this.options;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization getOutputSerialization() {
            return this.outputSerialization;
        }

        public SelectObjectRequestBodySelectRequest setExpression(String str) {
            this.expression = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequest setInputSerialization(SelectObjectRequestBodySelectRequestInputSerialization selectObjectRequestBodySelectRequestInputSerialization) {
            this.inputSerialization = selectObjectRequestBodySelectRequestInputSerialization;
            return this;
        }

        public SelectObjectRequestBodySelectRequest setOptions(SelectObjectRequestBodySelectRequestOptions selectObjectRequestBodySelectRequestOptions) {
            this.options = selectObjectRequestBodySelectRequestOptions;
            return this;
        }

        public SelectObjectRequestBodySelectRequest setOutputSerialization(SelectObjectRequestBodySelectRequestOutputSerialization selectObjectRequestBodySelectRequestOutputSerialization) {
            this.outputSerialization = selectObjectRequestBodySelectRequestOutputSerialization;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequestInputSerialization extends TeaModel {

        @NameInMap("CSV")
        public SelectObjectRequestBodySelectRequestInputSerializationCSV cSV;

        @NameInMap("CompressionType")
        public String compressionType;

        public static SelectObjectRequestBodySelectRequestInputSerialization build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequestInputSerialization) TeaModel.build(map, new SelectObjectRequestBodySelectRequestInputSerialization());
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV getCSV() {
            return this.cSV;
        }

        public String getCompressionType() {
            return this.compressionType;
        }

        public SelectObjectRequestBodySelectRequestInputSerialization setCSV(SelectObjectRequestBodySelectRequestInputSerializationCSV selectObjectRequestBodySelectRequestInputSerializationCSV) {
            this.cSV = selectObjectRequestBodySelectRequestInputSerializationCSV;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerialization setCompressionType(String str) {
            this.compressionType = str;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequestInputSerializationCSV extends TeaModel {

        @NameInMap("CommentCharacter")
        public String commentCharacter;

        @NameInMap("FieldDelimiter")
        public String fieldDelimiter;

        @NameInMap("FileHeaderInfo")
        public String fileHeaderInfo;

        @NameInMap("QuoteCharacter")
        public String quoteCharacter;

        @NameInMap("Range")
        public String range;

        @NameInMap("RecordDelimiter")
        public String recordDelimiter;

        public static SelectObjectRequestBodySelectRequestInputSerializationCSV build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequestInputSerializationCSV) TeaModel.build(map, new SelectObjectRequestBodySelectRequestInputSerializationCSV());
        }

        public String getCommentCharacter() {
            return this.commentCharacter;
        }

        public String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        public String getFileHeaderInfo() {
            return this.fileHeaderInfo;
        }

        public String getQuoteCharacter() {
            return this.quoteCharacter;
        }

        public String getRange() {
            return this.range;
        }

        public String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setCommentCharacter(String str) {
            this.commentCharacter = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setFieldDelimiter(String str) {
            this.fieldDelimiter = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setFileHeaderInfo(String str) {
            this.fileHeaderInfo = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setQuoteCharacter(String str) {
            this.quoteCharacter = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setRange(String str) {
            this.range = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestInputSerializationCSV setRecordDelimiter(String str) {
            this.recordDelimiter = str;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequestOptions extends TeaModel {

        @NameInMap("MaxSkippedRecordsAllowed")
        public String maxSkippedRecordsAllowed;

        @NameInMap("SkipPartialDataRecord")
        public String skipPartialDataRecord;

        public static SelectObjectRequestBodySelectRequestOptions build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequestOptions) TeaModel.build(map, new SelectObjectRequestBodySelectRequestOptions());
        }

        public String getMaxSkippedRecordsAllowed() {
            return this.maxSkippedRecordsAllowed;
        }

        public String getSkipPartialDataRecord() {
            return this.skipPartialDataRecord;
        }

        public SelectObjectRequestBodySelectRequestOptions setMaxSkippedRecordsAllowed(String str) {
            this.maxSkippedRecordsAllowed = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOptions setSkipPartialDataRecord(String str) {
            this.skipPartialDataRecord = str;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequestOutputSerialization extends TeaModel {

        @NameInMap("CSV")
        public SelectObjectRequestBodySelectRequestOutputSerializationCSV cSV;

        @NameInMap("EnablePayloadCrc")
        public String enablePayloadCrc;

        @NameInMap("KeepAllColumns")
        public String keepAllColumns;

        @NameInMap("OutputHeader")
        public String outputHeader;

        @NameInMap("OutputRawData")
        public String outputRawData;

        public static SelectObjectRequestBodySelectRequestOutputSerialization build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequestOutputSerialization) TeaModel.build(map, new SelectObjectRequestBodySelectRequestOutputSerialization());
        }

        public SelectObjectRequestBodySelectRequestOutputSerializationCSV getCSV() {
            return this.cSV;
        }

        public String getEnablePayloadCrc() {
            return this.enablePayloadCrc;
        }

        public String getKeepAllColumns() {
            return this.keepAllColumns;
        }

        public String getOutputHeader() {
            return this.outputHeader;
        }

        public String getOutputRawData() {
            return this.outputRawData;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization setCSV(SelectObjectRequestBodySelectRequestOutputSerializationCSV selectObjectRequestBodySelectRequestOutputSerializationCSV) {
            this.cSV = selectObjectRequestBodySelectRequestOutputSerializationCSV;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization setEnablePayloadCrc(String str) {
            this.enablePayloadCrc = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization setKeepAllColumns(String str) {
            this.keepAllColumns = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization setOutputHeader(String str) {
            this.outputHeader = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOutputSerialization setOutputRawData(String str) {
            this.outputRawData = str;
            return this;
        }
    }

    public static class SelectObjectRequestBodySelectRequestOutputSerializationCSV extends TeaModel {

        @NameInMap("FieldDelimiter")
        public String fieldDelimiter;

        @NameInMap("RecordDelimiter")
        public String recordDelimiter;

        public static SelectObjectRequestBodySelectRequestOutputSerializationCSV build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestBodySelectRequestOutputSerializationCSV) TeaModel.build(map, new SelectObjectRequestBodySelectRequestOutputSerializationCSV());
        }

        public String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        public String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        public SelectObjectRequestBodySelectRequestOutputSerializationCSV setFieldDelimiter(String str) {
            this.fieldDelimiter = str;
            return this;
        }

        public SelectObjectRequestBodySelectRequestOutputSerializationCSV setRecordDelimiter(String str) {
            this.recordDelimiter = str;
            return this;
        }
    }

    public static class SelectObjectRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.X_OSS_PROCESS)
        @Validation(required = true)
        public String porcess;

        public static SelectObjectRequestFilter build(Map<String, ?> map) throws Exception {
            return (SelectObjectRequestFilter) TeaModel.build(map, new SelectObjectRequestFilter());
        }

        public String getPorcess() {
            return this.porcess;
        }

        public SelectObjectRequestFilter setPorcess(String str) {
            this.porcess = str;
            return this;
        }
    }

    public static SelectObjectRequest build(Map<String, ?> map) throws Exception {
        return (SelectObjectRequest) TeaModel.build(map, new SelectObjectRequest());
    }

    public SelectObjectRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public SelectObjectRequestFilter getFilter() {
        return this.filter;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public SelectObjectRequest setBody(SelectObjectRequestBody selectObjectRequestBody) {
        this.body = selectObjectRequestBody;
        return this;
    }

    public SelectObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public SelectObjectRequest setFilter(SelectObjectRequestFilter selectObjectRequestFilter) {
        this.filter = selectObjectRequestFilter;
        return this;
    }

    public SelectObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}

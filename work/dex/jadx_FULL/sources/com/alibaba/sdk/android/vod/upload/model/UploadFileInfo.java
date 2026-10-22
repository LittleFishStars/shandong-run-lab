package com.alibaba.sdk.android.vod.upload.model;

import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadFileInfo {
    public static final int UPLOAD_FILE_TYPE_IMAGE = 0;
    public static final int UPLOAD_FILE_TYPE_VIDEO = 1;
    private String bucket;
    private String endpoint;
    private String filePath;
    private String object;
    public VodUploadResult result;
    private UploadStateType status;
    private VodInfo vodInfo;
    private int fileType = 1;
    private boolean isMultipart = false;
    private long fileLength = -1;
    private List<FilePartInfo> partInfoList = new ArrayList();

    public boolean equals(UploadFileInfo uploadFileInfo) {
        return (uploadFileInfo == null || StringUtil.isEmpty(uploadFileInfo.filePath) || !uploadFileInfo.filePath.equals(this.filePath) || StringUtil.isEmpty(uploadFileInfo.endpoint) || !uploadFileInfo.endpoint.equals(this.endpoint) || StringUtil.isEmpty(uploadFileInfo.bucket) || !uploadFileInfo.bucket.equals(this.bucket) || StringUtil.isEmpty(uploadFileInfo.object) || !uploadFileInfo.object.equals(this.object) || StringUtil.isEmpty(uploadFileInfo.object) || !uploadFileInfo.object.equals(this.object)) ? false : true;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getObject() {
        return this.object;
    }

    public List<FilePartInfo> getPartInfoList() {
        return this.partInfoList;
    }

    public UploadStateType getStatus() {
        return this.status;
    }

    public VodInfo getVodInfo() {
        return this.vodInfo;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setFileLength(long j) {
        this.fileLength = j;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setMultipart(boolean z) {
        this.isMultipart = z;
    }

    public void setObject(String str) {
        this.object = str;
    }

    public void setPartInfoList(List<FilePartInfo> list) {
        this.partInfoList = list;
    }

    public void setStatus(UploadStateType uploadStateType) {
        this.status = uploadStateType;
    }

    public void setVodInfo(VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }
}

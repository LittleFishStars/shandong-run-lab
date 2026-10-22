package com.alibaba.ariver.commonability.file;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum OfficeFileType {
    Doc("doc"),
    Docx("docx"),
    Xls("xls"),
    Xlsx("xlsx"),
    PPt("ppt"),
    PPtx("pptx"),
    Pdf("pdf");

    private String code;

    OfficeFileType(String str) {
        this.code = str;
    }

    public boolean checkType(String str) {
        return this.code.equalsIgnoreCase(str);
    }

    public String fileType() {
        return this.code;
    }
}

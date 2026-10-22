package com.huachenjie.common.aliyun.file_upload;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum UploadFileType {
    UPLOAD_OUTSIDE_ATTENDANCE("outside_clock_photo"),
    UPLOAD_VISITOR("visitor"),
    UPLOAD_AVATAR("avatar"),
    UPLOAD_STUDENT_REPORT("student/report"),
    UPLOAD_EMOJI("emoji/save"),
    UPLOAD_WORKS_PHOTO("works/photo"),
    UPLOAD_WORKS_VIDEO("works/video"),
    UPLOAD_WORKS_COMMENT("works/comment"),
    UPLOAD_WORK_REPORT("works/report"),
    UPLOAD_CHANNEL_CHANNEL("chanel/chanel"),
    UPLOAD_CHANEL_SUBJECT("chanel/subject"),
    UPLOAD_USER_THEME("user/theme"),
    UPLOAD_MALL_AFTER_SALE("mall/after_sale"),
    UPLOAD_FEEDBACK("feedback"),
    UPLOAD_CHANNEL_AD("chanel/ad"),
    UPLOAD_DORMITORY("dorm/logo"),
    UPLOAD_QUOTE_PHOTO("quote/photo"),
    UPLOAD_QUOTE_VOICE("quote/voice"),
    UPLOAD_QUOTE_COMMENT("quote/comment"),
    UPLOAD_ALUMNI_SAY_REPORT("quote/report"),
    UPLOAD_FACE_USER("face/user"),
    UPLOAD_FACE_RUN("face/run"),
    UPLOAD_LIVE_PHOTO("live/photo"),
    UPLOAD_LIVE_COMMENT("live/comment"),
    UPLOAD_LIVE_REPORT("live/report"),
    UPLOAD_DEFAULT("");

    private final String value;

    UploadFileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

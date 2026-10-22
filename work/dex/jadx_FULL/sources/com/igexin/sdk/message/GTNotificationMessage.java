package com.igexin.sdk.message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GTNotificationMessage extends GTPushMessage {
    private String content;
    private String intentUri;
    private String messageId;
    private String payload;
    private String taskId;
    private String title;
    private String url;

    public GTNotificationMessage() {
    }

    public GTNotificationMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.taskId = str;
        this.messageId = str2;
        this.title = str3;
        this.content = str4;
        this.url = str5;
        this.intentUri = str6;
        this.payload = str7;
    }

    public String getContent() {
        return this.content;
    }

    public String getIntentUri() {
        return this.intentUri;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getPayload() {
        return this.payload;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIntentUri(String str) {
        this.intentUri = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}

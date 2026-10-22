package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class JavaExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -2410125079234148135L;

    public JavaExceptionMessage() {
        this.mExceptionType = 1;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public String getTypePrefix() {
        return "";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return super.toJson();
    }
}

package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public interface INetworkClient {

    @Keep
    public static class Result {
        public final String body;
        public final int code;
        public final Exception e;
        public final String header;
        public final JSONObject response;

        @Keep
        public static class Builder {
            String body;
            int code;
            Exception e;
            String header;
            JSONObject response;

            public Result build() {
                return new Result(this);
            }

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setCode(int i) {
                this.code = i;
                return this;
            }

            public Builder setException(Exception exc) {
                this.e = exc;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }

            private Builder() {
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.e = builder.e;
            this.code = builder.code;
        }
    }

    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);
}

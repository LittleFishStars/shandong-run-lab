package com.kwad.sdk.mobileid;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@KsJson
public class UaidInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int STATUS_AFTER_REQUEST_TOKEN = 3;
    public static final int STATUS_AFTER_REQUEST_UAID = 5;
    public static final int STATUS_BEFORE_REQUEST_TOKEN = 2;
    public static final int STATUS_BEFORE_REQUEST_UAID = 4;
    public static final int STATUS_INIT_CHECK = 1;
    private static final long serialVersionUID = 7940080171183060311L;
    public String canRequest;
    public boolean dcontrollerEnableNetwork;
    public boolean dcontrollerEnablePhoneState;
    public String errorCode;
    public String errorMsg;
    public boolean imsiNotEmpty;
    public int networkType;
    public int operatorType;
    public int result;
    public int status;
    public String token;
    public String traceId;
    public String uaid;

    public static class a {
        private String canRequest;
        private boolean dcontrollerEnableNetwork;
        private boolean dcontrollerEnablePhoneState;
        private String errorCode;
        private String errorMsg;
        private boolean imsiNotEmpty;
        private int networkType;
        private int operatorType;
        private int result;
        private int status;
        private String token;
        private String traceId;
        private String uaid;

        public final UaidInfo So() {
            return new UaidInfo(this);
        }

        public final a ce(boolean z) {
            this.dcontrollerEnableNetwork = z;
            return this;
        }

        public final a cf(boolean z) {
            this.dcontrollerEnablePhoneState = z;
            return this;
        }

        public final a cg(boolean z) {
            this.imsiNotEmpty = z;
            return this;
        }

        public final a ff(int i) {
            this.status = i;
            return this;
        }

        public final a fg(int i) {
            this.operatorType = i;
            return this;
        }

        public final a fh(int i) {
            this.networkType = i;
            return this;
        }

        public final a hc(String str) {
            this.canRequest = str;
            return this;
        }

        public final a hd(String str) {
            this.traceId = str;
            return this;
        }

        public final a he(String str) {
            this.errorMsg = str;
            return this;
        }
    }

    public static a newBuilder() {
        return new a();
    }

    private UaidInfo(a aVar) {
        this.status = aVar.status;
        this.canRequest = aVar.canRequest;
        this.traceId = aVar.traceId;
        this.operatorType = aVar.operatorType;
        this.networkType = aVar.networkType;
        this.uaid = aVar.uaid;
        this.result = aVar.result;
        this.token = aVar.token;
        this.errorCode = aVar.errorCode;
        this.errorMsg = aVar.errorMsg;
        this.dcontrollerEnableNetwork = aVar.dcontrollerEnableNetwork;
        this.dcontrollerEnablePhoneState = aVar.dcontrollerEnablePhoneState;
        this.imsiNotEmpty = aVar.imsiNotEmpty;
    }
}

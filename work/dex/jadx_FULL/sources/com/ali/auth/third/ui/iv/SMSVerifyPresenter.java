package com.ali.auth.third.ui.iv;

import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SMSVerifyPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmsVerifyFormView f23533a;

    public class a implements RpcRequestCallbackWithCode {
        public a() {
        }

        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onError(String str, RpcResponse rpcResponse) {
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            SMSVerifyPresenter.this.f23533a.onSMSSendFail(rpcResponse);
        }

        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSuccess(RpcResponse rpcResponse) {
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            SMSVerifyPresenter.this.f23533a.onSendSMSSuccess(60000L);
        }

        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSystemError(String str, RpcResponse rpcResponse) {
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            SMSVerifyPresenter.this.f23533a.onSMSSendFail(rpcResponse);
        }
    }

    public class b implements RpcRequestCallbackWithCode {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onError(String str, RpcResponse rpcResponse) {
            String strOptString;
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            if (rpcResponse != null) {
                try {
                    strOptString = new JSONObject((String) rpcResponse.returnValue).optString("message");
                } catch (Throwable unused) {
                    strOptString = "";
                }
            } else {
                strOptString = "";
            }
            SMSVerifyPresenter.this.f23533a.onVerifyFail(rpcResponse == null ? 1101 : rpcResponse.code, strOptString);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSuccess(RpcResponse rpcResponse) {
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            try {
                SMSVerifyPresenter.this.f23533a.onVerifySuccess(new JSONObject((String) rpcResponse.returnValue).optString(Constants.PARAM_HAVANA_IV_TOKEN));
            } catch (Throwable unused) {
                SMSVerifyPresenter.this.f23533a.onVerifyFail(1102, "数据异常");
            }
        }

        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSystemError(String str, RpcResponse rpcResponse) {
            if (SMSVerifyPresenter.this.f23533a == null || SMSVerifyPresenter.this.f23533a == null) {
                return;
            }
            SMSVerifyPresenter.this.f23533a.onVerifyFail(rpcResponse == null ? 1101 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message);
        }
    }

    public SMSVerifyPresenter(SmsVerifyFormView smsVerifyFormView) {
        this.f23533a = smsVerifyFormView;
    }

    public void sendSMS(IVParam iVParam) {
        DataRepository.sendSMSCode(iVParam.ivToken, iVParam.validatorTag, iVParam.mobileNum, new a());
    }

    public void verifyCode(IVParam iVParam) {
        DataRepository.checkCommonCode(iVParam.ivToken, iVParam.checkCode, iVParam.mobileNum, new b());
    }
}

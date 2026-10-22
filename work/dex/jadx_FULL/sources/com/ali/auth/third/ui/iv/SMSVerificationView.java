package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.ui.R;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SMSVerificationView extends ScrollView implements SmsVerifyFormView {
    public static final String PAGE_NAME = "Page_Reg";
    public static final String TAG = "login.numAuthReg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultCallback<String> f23530a;
    protected IVParam mIVParams;
    protected SMSVerifyPresenter mPresenter;
    protected CountDownButton mSendSMSCodeBtn;
    protected AliUserSmsCodeView mSmsCodeView;

    public class a implements AliUserSmsCodeView.OnCompletedListener {
        public a() {
        }

        @Override // com.ali.auth.third.ui.iv.AliUserSmsCodeView.OnCompletedListener
        public void onCompleted(String str) {
            SMSVerificationView.this.submitRegisterForm();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SMSVerificationView.this.sendCodeAction();
        }
    }

    public SMSVerificationView(Context context) {
        this(context, null);
    }

    public SMSVerificationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIVParams = new IVParam();
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    public int getLayoutId() {
        return R.layout.ali_auth_sms_verification;
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public String getPageName() {
        return "";
    }

    public void init(Map<String, Object> map) {
        if (map != null) {
            this.mIVParams.mobileNum = (String) map.get("mobile");
            this.mIVParams.ivToken = (String) map.get(Constants.PARAM_IV_TOKEN);
            this.mIVParams.validatorTag = PrepareException.ERROR_AUTH_FAIL;
        }
        this.mPresenter = new SMSVerifyPresenter(this);
        initViews();
        this.mPresenter.sendSMS(this.mIVParams);
    }

    public void initViews() {
        if (!TextUtils.isEmpty(this.mIVParams.mobileNum)) {
            ((TextView) getRootView().findViewById(R.id.ali_auth_mobile_tv)).setText(getContext().getString(R.string.ali_auth_sms_veri_title, " " + this.mIVParams.mobileNum + " "));
        }
        AliUserSmsCodeView aliUserSmsCodeView = (AliUserSmsCodeView) getRootView().findViewById(R.id.ali_auth_sms_code_view);
        this.mSmsCodeView = aliUserSmsCodeView;
        aliUserSmsCodeView.setOnCompletedListener(new a());
        this.mSmsCodeView.focus();
        CountDownButton countDownButton = (CountDownButton) getRootView().findViewById(R.id.ali_auth_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setGetCodeTitle(R.string.ali_auth_verification_reGetCode);
        this.mSendSMSCodeBtn.setTickTitleRes(R.string.ali_auth_sms_code_success_hint);
        this.mSendSMSCodeBtn.startCountDown(60000L, 1000L);
        this.mSendSMSCodeBtn.setOnClickListener(new b());
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    public void onSendSMSAction() {
        this.mPresenter.sendSMS(this.mIVParams);
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onSendSMSSuccess(long j) {
        this.mSendSMSCodeBtn.startCountDown(j, 1000L);
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onVerifyFail(int i, String str) {
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(R.string.aliuser_network_error);
        }
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onVerifySuccess(String str) {
        ResultCallback<String> resultCallback = this.f23530a;
        if (resultCallback != null) {
            resultCallback.onSuccess(str);
        }
    }

    public void sendCodeAction() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
        try {
            onSendSMSAction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setResultCallback(ResultCallback resultCallback) {
        this.f23530a = resultCallback;
    }

    public void submitRegisterForm() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            this.mIVParams.checkCode = aliUserSmsCodeView.getText();
            this.mPresenter.verifyCode(this.mIVParams);
        }
    }
}

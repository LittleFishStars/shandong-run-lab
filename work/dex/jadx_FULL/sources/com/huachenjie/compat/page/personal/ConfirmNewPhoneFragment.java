package com.huachenjie.compat.page.personal;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.common.base.BaseFragment;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.common.widget.ClearableEditText;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.ConfirmPhoneEntity;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.lo7;
import com.zj.adlib.o38;
import com.zj.adlib.ys8;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ConfirmNewPhoneFragment extends BaseFragment<com.huachenjie.compat.page.personal.a> implements ConfirmPhoneContact.ConfirmPhoneView {
    private static final int TYPE_CONFIRM_NEW_PHONE = 2;
    private IConfirmPhoneCallback confirmPhoneCallback;
    private int count = 0;
    private ClearableEditText editCaptcha;
    private ClearableEditText editPhone;
    private Subscription mCountdownSubscription;
    private String mTicket;
    private TextView tvGetCaptcha;
    private TextView tvLeftCount;

    public class a implements RxViewUtil.ClickAction {
        public a() {
        }

        @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
        public void onClick() {
            String strTrim = ConfirmNewPhoneFragment.this.editPhone.getText().toString().trim();
            if (!TextUtils.isEmpty(strTrim) && o38.a(strTrim)) {
                ((com.huachenjie.compat.page.personal.a) ((BaseFragment) ConfirmNewPhoneFragment.this).mPresenter).g(strTrim, 2, null);
            } else {
                ConfirmNewPhoneFragment confirmNewPhoneFragment = ConfirmNewPhoneFragment.this;
                confirmNewPhoneFragment.showToast(confirmNewPhoneFragment.getString(R.string.phone_valid_error));
            }
        }
    }

    public class b implements RxViewUtil.CountDownAction {
        public b() {
        }

        @Override // com.huachenjie.common.util.RxViewUtil.CountDownAction
        public void a(long j) {
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setEnabled(false);
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setTextColor(ResourcesCompat.getColor(((BaseFragment) ConfirmNewPhoneFragment.this)._mActivity.getResources(), R.color.percent_30_translucent_black, null));
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setText(((BaseFragment) ConfirmNewPhoneFragment.this)._mActivity.getString(R.string.countdown, Long.valueOf(j)));
        }

        @Override // com.huachenjie.common.util.RxViewUtil.CountDownAction
        public void onFinish() {
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setEnabled(true);
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setTextColor(ResourcesCompat.getColor(((BaseFragment) ConfirmNewPhoneFragment.this)._mActivity.getResources(), R.color.color_139aff, null));
            ConfirmNewPhoneFragment.this.tvGetCaptcha.setText(R.string.get_captcha);
        }
    }

    private boolean checkValid() {
        return (TextUtils.isEmpty(this.editPhone.getText().toString().trim()) && TextUtils.isEmpty(this.editCaptcha.getText().toString().trim())) ? false : true;
    }

    private void countdown() {
        this.mCountdownSubscription = RxViewUtil.c(this.tvGetCaptcha, 60, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$needCaptchaCheck$0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return Unit.INSTANCE;
        }
        ((com.huachenjie.compat.page.personal.a) this.mPresenter).g(str, 2, str2);
        return Unit.INSTANCE;
    }

    public static ConfirmNewPhoneFragment newInstance(IConfirmPhoneCallback iConfirmPhoneCallback, int i) {
        ConfirmNewPhoneFragment confirmNewPhoneFragment = new ConfirmNewPhoneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", i);
        confirmNewPhoneFragment.setArguments(bundle);
        confirmNewPhoneFragment.setConfirmPhoneCallback(iConfirmPhoneCallback);
        return confirmNewPhoneFragment;
    }

    private void setConfirmPhoneCallback(IConfirmPhoneCallback iConfirmPhoneCallback) {
        this.confirmPhoneCallback = iConfirmPhoneCallback;
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.ConfirmPhoneView
    public void confirmPhoneSucceed(ConfirmPhoneEntity confirmPhoneEntity) {
        if (confirmPhoneEntity == null || TextUtils.isEmpty(confirmPhoneEntity.getToken())) {
            this.editCaptcha.setText("");
            fv5.a(R.string.modify_failed);
            return;
        }
        lo7.e().g().n().a = confirmPhoneEntity.getToken();
        lo7.e().g().n().b = confirmPhoneEntity.getSatoken();
        CommonUserInfo commonUserInfoE = ai9.e();
        commonUserInfoE.setToken(confirmPhoneEntity.getToken());
        commonUserInfoE.setSatoken(confirmPhoneEntity.getSatoken());
        commonUserInfoE.setPhone(confirmPhoneEntity.getPhone());
        ai9.s(commonUserInfoE);
        IConfirmPhoneCallback iConfirmPhoneCallback = this.confirmPhoneCallback;
        if (iConfirmPhoneCallback != null) {
            iConfirmPhoneCallback.K();
        }
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public int getContentViewRes() {
        return R.layout.fragment_confirm_new_phone;
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void handleArguments(Bundle bundle) {
        this.count = bundle.getInt("count");
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initView() {
        this.editPhone = (ClearableEditText) f(R.id.edit_phone);
        this.editCaptcha = (ClearableEditText) f(R.id.edit_captcha);
        this.tvGetCaptcha = (TextView) f(R.id.tv_get_captcha);
        TextView textView = (TextView) f(R.id.tv_left_count);
        this.tvLeftCount = textView;
        textView.setText(ys8.f(R.string.phone_modify_left_count, Integer.valueOf(this.count)));
        RxViewUtil.f(this.tvGetCaptcha, 1000L, new a());
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.ConfirmPhoneView
    public void needCaptchaCheck(final String str) {
        CaptchaDialog.show(getChildFragmentManager(), (Function1<? super String, Unit>) new Function1() { // from class: com.zj.adlib.gt1
            public final Object invoke(Object obj) {
                return this.f41980a.lambda$needCaptchaCheck$0(str, (String) obj);
            }
        });
    }

    @Override // com.huachenjie.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huachenjie.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.mCountdownSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.confirmPhoneCallback = null;
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.ConfirmPhoneView
    public void sendSMSFailed(String str) {
    }

    @Override // com.huachenjie.compat.page.personal.ConfirmPhoneContact.ConfirmPhoneView
    public void sendSMSSucceed(String str) {
        this.mTicket = str;
        countdown();
        fv5.a(R.string.get_captcha_succeed);
    }

    public void submit() {
        if (checkValid()) {
            String strTrim = this.editPhone.getText().toString().trim();
            String strTrim2 = this.editCaptcha.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim) || !o38.a(strTrim)) {
                showToast(getString(R.string.phone_valid_error));
                return;
            }
            if (TextUtils.isEmpty(strTrim2) || strTrim2.length() != 4) {
                showToast(getString(R.string.captcha_valid_error));
            } else if (TextUtils.isEmpty(this.mTicket)) {
                showToast(getString(R.string.please_get_captcha));
            } else {
                ((com.huachenjie.compat.page.personal.a) this.mPresenter).f(strTrim, strTrim2, this.mTicket, 2);
            }
        }
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public com.huachenjie.compat.page.personal.a initPresenter() {
        return new com.huachenjie.compat.page.personal.a();
    }
}

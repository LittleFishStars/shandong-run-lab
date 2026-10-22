package com.kwad.components.core.innerEc;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.kwad.components.offline.api.adInnerEc.login.InnerEcLoginResponse;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public class RouteHandlerActivityProxy extends IActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        InnerEcLoginResponse innerEcLoginResponse = new InnerEcLoginResponse();
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    innerEcLoginResponse.setCode(extras.getString("kwai_response_code"));
                    innerEcLoginResponse.setState(extras.getString("kwai_state"));
                    innerEcLoginResponse.setAccessToken(extras.getString("kwai_response_access_token"));
                    innerEcLoginResponse.setErrorCode(extras.getInt("kwai_response_error_code"));
                    innerEcLoginResponse.setErrorMsg(extras.getString("kwai_response_error_msg"));
                    innerEcLoginResponse.setCommand(extras.getString("kwai_command"));
                    innerEcLoginResponse.setHasLoggedIn(extras.getBoolean("kwai_response_login_status"));
                    e.rf().a(innerEcLoginResponse, getActivity());
                    return;
                }
            } catch (Throwable th) {
                innerEcLoginResponse.setErrorCode(-1007);
                innerEcLoginResponse.setErrorMsg("route exception = " + th.getMessage());
                e.rf().a(innerEcLoginResponse, getActivity());
                getActivity().setIntent(null);
                finish();
                return;
            }
        }
        innerEcLoginResponse.setErrorCode(-1007);
        innerEcLoginResponse.setErrorMsg("route null intent");
        e.rf().a(innerEcLoginResponse, getActivity());
    }
}

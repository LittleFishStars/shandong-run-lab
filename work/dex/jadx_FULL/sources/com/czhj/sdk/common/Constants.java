package com.czhj.sdk.common;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Constants {
    public static final String ADSCENE = "ad_scene";
    public static final String AD_SCENE_DESC = "scene_desc";
    public static final String AD_SCENE_ID = "scene_id";
    public static final String AESKEY = "sigandroid_mtadb";
    public static final String AGE_RESTRICTED_STATUS = "age_restricted_status";
    public static final String BROADCAST_IDENTIFIER_KEY = "broadcastIdentifier";
    public static final String CLICK_TYPE = "clickType";
    public static final boolean ENCRYPT = false;
    public static final String EXT_GDPR_REGION = "gdpr_region";
    public static final String FAIL = "0";
    public static final String GCMNONCE = "+lx3fUZcRI2mzU/W";
    public static final String GDPR_CONSENT_STATUS = "consent_status";
    public static final boolean GOOGLE_PLAY = false;
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    public static final String IS_REQUEST_IN_EEA_OR_UNKNOWN = "is_request_in_eea_or_unknown";
    public static final String LOAD_ID = "loadId";
    public static final String LOG_URL = "dc.sigmob.cn/log";
    public static final int RETRYMAXNUM = 3000;
    public static final String SDK_COMMON_FOLDER = "sigmob";
    public static final int SDK_VERSION = 202;
    public static final String SHOW_DOWNLOAD_DIALOG = "showDownloadDialog";
    public static final int SIG_VERSION = 159;
    public static final String SUCCESS = "1";
    public static final String TEMPLATETYPE = "templateType";
    public static final int TEN_SECONDS_MILLIS = 10000;
    public static final String TOKEN = "token";
    public static final String USER_AGE = "user_age";
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public static int getVersion() {
        return 202;
    }
}

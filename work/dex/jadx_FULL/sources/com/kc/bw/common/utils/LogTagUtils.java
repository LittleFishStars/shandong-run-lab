package com.kc.bw.common.utils;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LogTagUtils {
    public static final String TAG_COMMON_TAG = dexg.dexa("ldcx`mph>>");
    public static final String TAG_PLUGIN_WEAK = dexg.dexa("qmh}");
    public static final String TAG_INST_WEAK = dexg.dexa("jotu}");
    public static final String TAG_INIT_WEAK = dexg.dexa("joju}");
    public static final String TAG_OAID_WEAK = dexg.dexa("ype}");
    public static final String TAG_COMMON_WEAK = dexg.dexa("ydn}");
    public static final String TAG_HOOK_WEAK = dexg.dexa("yll}");

    @Keep
    public interface Reason {
        public static final String INIT_NETWORK_FAIL = dexg.dexa("joju!ofuxpsl!gbjm!");
        public static final String READ_LOCAL_CONFIG = dexg.dexa("mpbe!mdgh!!");
        public static final String READ_LOCAL_CONFIG_SUCCESS = dexg.dexa("mdgh!mpbe!epof!");
        public static final String LOCAL_CONFIG_INVALID = dexg.dexa("mdgh!jowbme");
        public static final String MEDIA_LOCAL_CONFIG_NOT_EXIST = dexg.dexa("nfejb!dgh!jowbmje!");
        public static final String READ_MEDIA_LOCAL_CONFIG = dexg.dexa("nfejb!dghObnf>");
        public static final String READ_MEDIA_LOCAL_CONFIG_COMPLETED = dexg.dexa("nfejb!dgh!mpbe!epof!");
        public static final String FETCH_REMOTE_CONFIG = dexg.dexa("gfudi!dgh!");
        public static final String FETCH_REMOTE_CONFIG_SUCCESS = dexg.dexa("gfudi!dgh!epof!");
        public static final String FETCH_REMOTE_CONFIG_FAIL = dexg.dexa("gfudi!dgh!gbjm!");
        public static final String READ_LOCAL_CACHE_OAID = dexg.dexa("smdp!");
        public static final String UPDATE_LOCAL_OAID = dexg.dexa("vmp!");
        public static final String DEV_OAID_VALUE = dexg.dexa("epw!");
        public static final String GET_OAID_FAIL = dexg.dexa("hpg!");
        public static final String FETCH_REMOTE_BLACKLIST_CONFIG = dexg.dexa("gscd!");
        public static final String FETCH_REMOTE_BLACKLIST_CONFIG_FAIL = dexg.dexa("gscdg!");
        public static final String REMOTE_BLACKLIST_INVALID = dexg.dexa("scj!");
        public static final String REMOTE_BLACKLIST_CHANGES = dexg.dexa("scmd!");
        public static final String BLACKLIST_NO_CHANGES = dexg.dexa("cmod!");
        public static final String READ_LOCAL_CREATIVE_IDS_SUCCESS = dexg.dexa("smdjt!");
        public static final String READ_LOCAL_CREATIVE_IDS_FAILED = dexg.dexa("smdjg!");
        public static final String REPORT_TRACK_LOG_FAIL = dexg.dexa("sumg!");
        public static final String BUILD_SPLASH_CONTAINER_START = dexg.dexa("ctdt!");
        public static final String BUILD_SPLASH_CONTAINER_END = dexg.dexa("ctdf!");
        public static final String API_SPLASH_SHOW = dexg.dexa("btt!");
        public static final String API_SPLASH_RENDER = dexg.dexa("bts!");
        public static final String FETCH_BANNER_AD = dexg.dexa("gfudi!tqmbti!be!");
        public static final String OAID_IS_VALID = dexg.dexa("qbtt");
        public static final String FETCH_SPLASH_AD = dexg.dexa("gfudi!tqmbti!be!");
        public static final String FETCH_BUYER_ID = dexg.dexa("gfudi!cvzfsJe");
        public static final String FETCH_POPUP_AD = dexg.dexa("gfudi!tqmbti!be!");
        public static final String FETCH_EXPRESS_AD = dexg.dexa("gfudi!fyqsftt!be!");
        public static final String FETCH_NATIVE_AD = dexg.dexa("gfudi!obujwf!be!");
        public static final String FETCH_REWARD_AD = dexg.dexa("gfudi!sfxbse!be!");
        public static final String FETCH_PATCH_AD = dexg.dexa("gfudi!qbudi!be!");
        public static final String FETCH_FULLSCREEN_AD = dexg.dexa("gfudi!GvmmTdsffo!be!");
        public static final String DISPATCH_ACTION = dexg.dexa("ejtqbudi!bdujpo!");
        public static final String REPORT_APP_DP_STATUS_SUCCESS = dexg.dexa("sbett!");
        public static final String REPORT_APP_DP_STATUS_FAIL = dexg.dexa("sbetg!");
        public static final String REGISTER_CRASH_HANDLE = dexg.dexa("sfh!dsbti!");
        public static final String REGISTER_HIDDEN_API_EXEMPTIONS = dexg.dexa("sfh!ijeefo!");
        public static final String PLUGIN_EXPORTED = dexg.dexa("sft!sfbez");
        public static final String LOCAL_PLUGIN_VERSION_INVALID = dexg.dexa("msft!wfstjpo!jowbmje!");
        public static final String HOTFIX_PLUGIN_VERSION_INVALID = dexg.dexa("igsft!wfstjpo!jowbmje!");
        public static final String PRE_PLUGIN_VERSION_INVALID = dexg.dexa("qsfsft!wfstjpo!jowbmje");
        public static final String GET_CURRENT_PLUGIN_VERSION_FAIL = dexg.dexa("gfudi!dsft!wfstjpo!gbjm!");
        public static final String CURRENT_PLUGIN_VERSION_INVALID = dexg.dexa("dsft!wfstjpo!jowbmje");
        public static final String PLUGIN_VERSION_SAME = dexg.dexa("tbnf!wfstjpo");
        public static final String PLUGIN_VERSION_DIFFERENT = dexg.dexa("ejggfsfou!wfstjpo");
        public static final String PLUGIN_PATH_INVALID = dexg.dexa("sft!qbui!jowbmje");
        public static final String PLUGIN_NAME_INVALID = dexg.dexa("sft!obnf!jowbmje");
        public static final String EXPORT_PLUGIN_COMPLETED = dexg.dexa("sft!dpnqmfufe!");
        public static final String EXPORT_PLUGIN_FAIL = dexg.dexa("sft!gbjm!");
        public static final String HOTFIX_PLUGIN_UPGRADE = dexg.dexa("igsft!bqqmz!");
        public static final String HOTFIX_PLUGIN_UPGRADE_RESPONSE = dexg.dexa("igsft!sftq!");
        public static final String HOTFIX_PLUGIN_UPGRADE_FAIL = dexg.dexa("igsft!bqqmz!gbjm!");
        public static final String CHECK_NEED_DOWNLOAD_PLUGIN_FAIL = dexg.dexa("qspcfEfmub!gbjm");
        public static final String DOWNLOAD_HOTFIX_PLUGIN = dexg.dexa("qvmm!iusft!");
        public static final String DOWNLOAD_HOTFIX_PLUGIN_DONE = dexg.dexa("qvmm!iusft!epof!");
        public static final String DOWNLOAD_HOTFIX_PLUGIN_FAIL = dexg.dexa("qvmm!iusft!gbjm!");
        public static final String HOTFIX_PLUGIN_VERIFY = dexg.dexa("iusft!wfsjgz");
        public static final String HOTFIX_PLUGIN_VERIFY_FAIL = dexg.dexa("iusft!wfsjgz!gbjm");
        public static final String OVERWRITE_HOTFIX_PLUGIN = dexg.dexa("pwfsxsjuf!iusft");
        public static final String CLEAR_AD_LOADER_INSTANCE = dexg.dexa("dmfbs!jotubodf!");
        public static final String LOCAL_PLUGIN_FILE_INVALID = dexg.dexa("msft!gjmf!jowbmje!");
        public static final String HOTFIX_PLUGIN_FILE_INVALID = dexg.dexa("igsft!gjmf!jowbmje!");
        public static final String HOTFIX_PLUGIN_PACKAGE_INVALID = dexg.dexa("igsft!qbdlbhf!jowbmje!");
        public static final String LOCAL_PLUGIN_PACKAGE_INVALID = dexg.dexa("msft!qbdlbhf!jowbmje");
        public static final String LOADER_PLUGIN_START = dexg.dexa("mpbe!sft!");
        public static final String CURRENT_PLUGIN_PATH_INVALID = dexg.dexa("dsft!qbui!jowbmje!");
        public static final String CURRENT_PLUGIN_FILE_INVALID = dexg.dexa("dsft!gjmf!jowbmje!");
        public static final String AD_LOADER_BUILD_SUCCESS = dexg.dexa("beMpbe!jotubodf!");
        public static final String AD_LOADER_INIT = dexg.dexa("beMpbe!joju!");
        public static final String ADD_ASSETS_PATH = dexg.dexa("bee!bttfut!!");
        public static final String PLUGIN_RESOURCE_BUILD_SUCCESS = dexg.dexa("sft!cvjme!epof!");
        public static final String AD_LOADER_BUILD_COMPLETED = dexg.dexa("beMpbe!cvjme!epof!");
        public static final String AD_LOADER_READY = dexg.dexa("beMpbe!sfbez!");
    }
}

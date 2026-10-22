package com.baidu.platform.comapi.license;

import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LicenseAuthManagerProvider {
    private static final String FUNCTION_NAME_MULTI_SCREEN_RIDING_NAVI = "multi_screen_navi";
    private static final String FUNCTION_NAME_MULTI_SCREEN_WALKING_NAVI = "multi_screen_navi";
    private static final String SERVICE_NAME_WALK_BIKE_NAVI = "lbs_androidsdk";
    private static volatile LicenseAuthManagerProvider provider;

    public class a implements IExtraLicenseAuth {
        public a() {
        }

        @Override // com.baidu.platform.comapi.license.IExtraLicenseAuth
        public void check() throws BaseLicenseAuthDataStandardProcess.ProcessException {
            if (!PermissionUtils.getInstance().isBWNaviMultiMapAuthorized()) {
                throw new BaseLicenseAuthDataStandardProcess.ProcessException(200, "没有步骑行多实例权限");
            }
        }
    }

    public class b implements IExtraLicenseAuth {
        public b() {
        }

        @Override // com.baidu.platform.comapi.license.IExtraLicenseAuth
        public void check() throws BaseLicenseAuthDataStandardProcess.ProcessException {
            if (!PermissionUtils.getInstance().isBWNaviMultiMapAuthorized()) {
                throw new BaseLicenseAuthDataStandardProcess.ProcessException(200, "没有步骑行多实例权限");
            }
        }
    }

    private LicenseAuthManagerProvider() {
    }

    public static LicenseAuthManagerProvider getInstance() {
        if (provider == null) {
            synchronized (LicenseAuthManagerProvider.class) {
                provider = new LicenseAuthManagerProvider();
            }
        }
        return provider;
    }

    public ILicenseAuthManager getMultiScreenRidingNaviAuthManager() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new b());
        return new LicenseAuthManager.Builder().serviceName(SERVICE_NAME_WALK_BIKE_NAVI).functionName("multi_screen_navi").type(1).extraAuth(arrayList).build();
    }

    public ILicenseAuthManager getMultiScreenWalkingNaviAuthManager() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new a());
        return new LicenseAuthManager.Builder().serviceName(SERVICE_NAME_WALK_BIKE_NAVI).functionName("multi_screen_navi").type(1).extraAuth(arrayList).build();
    }
}

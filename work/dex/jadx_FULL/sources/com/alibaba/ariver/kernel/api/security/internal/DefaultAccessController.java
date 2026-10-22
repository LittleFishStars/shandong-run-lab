package com.alibaba.ariver.kernel.api.security.internal;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultGroup;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Inquirer;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultAccessController implements AccessController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24221a = "AriverKernel:Permission";
    private AccessControlManagement b;

    private boolean a(Permission permission, Group group) {
        if (group.groupName().equalsIgnoreCase(DefaultGroup.INTERNAL.groupName())) {
            return true;
        }
        Map<String, ? extends Permission> mapPermissions = group.permissions();
        return mapPermissions != null && mapPermissions.containsKey(permission.authority());
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public boolean check(Accessor accessor, List<? extends Guard> list, @Nullable AccessController.ApplyCallback applyCallback) throws AccessControlException {
        Group group = accessor.getGroup();
        AccessControlManagement accessControlManagement = this.b;
        boolean zAsyncInterceptJsapi = false;
        if (accessControlManagement != null && !accessControlManagement.needPermissionCheck(accessor, list)) {
            if (list != null) {
                RVLogger.d(f24221a, "not need check permission" + list.size());
                for (Guard guard : list) {
                    if (guard != null && guard.permit() != null) {
                        zAsyncInterceptJsapi = this.b.asyncInterceptJsapi(guard.permit(), accessor);
                    }
                }
            }
            return zAsyncInterceptJsapi;
        }
        AccessControlManagement accessControlManagement2 = this.b;
        if (accessControlManagement2 != null) {
            group = accessControlManagement2.manageAccessorGroup(accessor);
        }
        ArrayList arrayList = new ArrayList();
        for (Guard guard2 : list) {
            Permission permissionPermit = guard2.permit();
            if (permissionPermit != null) {
                if (group == null) {
                    throw new AccessControlException("the " + accessor + " not in any group.");
                }
                if (a(permissionPermit, group)) {
                    RVLogger.d(f24221a, "access" + accessor.hashCode() + " has group permission [" + permissionPermit.authority() + "] ,group is [" + group.groupName() + "]");
                } else {
                    ApiPermissionCheckResult apiPermissionCheckResultPermissionCheck = this.b.permissionCheck(permissionPermit, accessor);
                    if (ApiPermissionCheckResult.IGNORE == apiPermissionCheckResultPermissionCheck || ApiPermissionCheckResult.ALLOW == apiPermissionCheckResultPermissionCheck) {
                        RVLogger.d(f24221a, "access" + accessor.hashCode() + " has single permission [" + permissionPermit.authority() + "]");
                        if (this.b.asyncPermissionCheck(permissionPermit, accessor)) {
                            arrayList.add(permissionPermit);
                        }
                    } else {
                        AccessControlManagement accessControlManagement3 = this.b;
                        if (accessControlManagement3 != null && accessControlManagement3.bizPermissionCheck(permissionPermit, accessor)) {
                            RVLogger.d(f24221a, "access" + accessor.hashCode() + " has custom permission [" + permissionPermit.authority() + "]");
                        } else {
                            if (!(permissionPermit instanceof Inquirer)) {
                                RVLogger.d(f24221a, "access" + accessor.hashCode() + " no permission:" + permissionPermit.authority() + " when access " + guard2);
                                throw new AccessControlException((apiPermissionCheckResultPermissionCheck == null || !apiPermissionCheckResultPermissionCheck.hasSignature()) ? accessor + " no permission:" + permissionPermit.authority() + " when access " + guard2 : apiPermissionCheckResultPermissionCheck.getSignature());
                            }
                            arrayList.add(permissionPermit);
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        a(accessor, arrayList, applyCallback);
        return true;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public void setAccessControlManagement(AccessControlManagement accessControlManagement) {
        this.b = accessControlManagement;
    }

    private void a(Accessor accessor, List<Permission> list, @Nullable final AccessController.ApplyCallback applyCallback) {
        accessor.inquiry(list, new Accessor.InquiryCallback() { // from class: com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController.1
            @Override // com.alibaba.ariver.kernel.api.security.Accessor.InquiryCallback
            public void onComplete(List<? extends Permission> list2, List<? extends Permission> list3) {
                if (applyCallback != null) {
                    if (list3 == null || list3.size() < 0) {
                        applyCallback.onSuccess();
                    } else {
                        applyCallback.onFailure(list3);
                    }
                }
            }
        });
    }
}

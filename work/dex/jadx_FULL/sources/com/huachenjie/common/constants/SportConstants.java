package com.huachenjie.common.constants;

import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0013\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants;", "", "()V", "AUDIT_STATUS", "AUTO_PAUSE_REASON", "CLOCK_IN_MODE", "CheatLevel", "INVALID_TYPE", "LOATION_TIME", "POINT_TYPE", "RUN_DIS_GOAL_MODE", "RUN_ERROR_CODE", "RUN_MAX_LIMIT", "RUN_NOTIFICATION_ID", "RUN_RESUME_OR_PAUSE", "RUN_TARGET_ARRAY", "RUN_TARGET_DEFAULT", "SPORT_TYPE", "SUNSHINERUN_RESULT_STATUS", "TIME_TYPE", "UMENG_EVENT_NAME", "VALID_SPORT_VALUE", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SportConstants {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$AUDIT_STATUS;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface AUDIT_STATUS {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33674a = 10;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8533a = a.f8534a;
        public static final int b = 100;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$AUDIT_STATUS$a;", "", "", "a", "I", "APPEALING", "b", "PROCESSED", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int APPEALING = 10;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8534a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int PROCESSED = 100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$AUTO_PAUSE_REASON;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface AUTO_PAUSE_REASON {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33676a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8535a = a.f8536a;
        public static final int b = 2;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$AUTO_PAUSE_REASON$a;", "", "", "a", "I", "REASON_OUT_OF_SCHOOL_FENCE", "b", "REASON_RUN_IN_WIFI", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int REASON_OUT_OF_SCHOOL_FENCE = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8536a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int REASON_RUN_IN_WIFI = 2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$CLOCK_IN_MODE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface CLOCK_IN_MODE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33678a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8537a = a.f8538a;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 10;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$CLOCK_IN_MODE$a;", "", "", "a", "I", "MODE_CONFIG_ERROR", "b", "MODE_FREE", "c", "MODE_IN_ORDER", "d", "MODE_IN_ORDER_ALWAYS_SHOW", "e", "MODE_NO_ANY_POINT", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int MODE_CONFIG_ERROR = 0;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8538a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int MODE_FREE = 1;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int MODE_IN_ORDER = 2;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final int MODE_IN_ORDER_ALWAYS_SHOW = 3;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata */
            public static final int MODE_NO_ANY_POINT = 10;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$CheatLevel;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface CheatLevel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33680a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8539a = a.f8540a;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$CheatLevel$a;", "", "", "a", "I", "NONE", "b", "LOW", "c", "MIDDLE", "d", "HIGH", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int NONE = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8540a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int LOW = 2;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int MIDDLE = 3;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final int HIGH = 4;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$INVALID_TYPE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface INVALID_TYPE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33682a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8541a = a.f8542a;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 25;
        public static final int e = 53;
        public static final int f = 58;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$INVALID_TYPE$a;", "", "", "a", "I", "TYPE_TARGET_UNCOMPLETED", "b", "TYPE_DISTANCE_UNCOMPLETED", "c", "TYPE_PACE_UNCOMPLETED", "d", "TYPE_CHEAT_DISABLE_GPS", "e", "ERR_SOME_PAUSE_TIME_OUT", "f", "TYPE_SECTION_STEP_DISTANCE_ERR", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int TYPE_TARGET_UNCOMPLETED = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8542a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int TYPE_DISTANCE_UNCOMPLETED = 2;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int TYPE_PACE_UNCOMPLETED = 3;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final int TYPE_CHEAT_DISABLE_GPS = 25;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata */
            public static final int ERR_SOME_PAUSE_TIME_OUT = 53;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata */
            public static final int TYPE_SECTION_STEP_DISTANCE_ERR = 58;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$LOATION_TIME;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface LOATION_TIME {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f33684a = 10000;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8543a = a.f8544a;
        public static final long b = 3000;
        public static final long c = 3000;
        public static final long d = 2000;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$LOATION_TIME$a;", "", "", "a", "J", "ONCE_LOCATION_OUTTIME", "b", "START_RUN_LOCATION_EXPIRED", "c", "RUN_LOCATION_INTERVAL", "d", "HOME_LOCATION_INTERVAL", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final long ONCE_LOCATION_OUTTIME = 10000;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8544a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final long START_RUN_LOCATION_EXPIRED = 3000;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final long RUN_LOCATION_INTERVAL = 3000;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final long HOME_LOCATION_INTERVAL = 2000;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$POINT_TYPE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface POINT_TYPE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33686a = 2;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8545a = a.f8546a;
        public static final int b = 1;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$POINT_TYPE$a;", "", "", "a", "I", "TYPE_REQUIRED", "b", "TYPE_OPTIONAL", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int TYPE_REQUIRED = 2;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8546a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int TYPE_OPTIONAL = 1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_DIS_GOAL_MODE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_DIS_GOAL_MODE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33688a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8547a = a.f8548a;
        public static final int b = 1;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_DIS_GOAL_MODE$a;", "", "", "a", "I", "MIN_MODE", "b", "UN_DEFINEED_MODE", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int MIN_MODE = 0;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8548a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int UN_DEFINEED_MODE = 1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_ERROR_CODE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_ERROR_CODE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33690a = 2072;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8549a = a.f8550a;
        public static final int b = 2073;
        public static final int c = 2074;
        public static final int d = 2075;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_ERROR_CODE$a;", "", "", "a", "I", "RUN_OVERTIME_END", "b", "UPLOAD_PACE_NOT_ALLOW", "c", "UPLOAD_STEP_NOT_ALLOW", "d", "RUN_ALREADY_FINISH", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int RUN_OVERTIME_END = 2072;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8550a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int UPLOAD_PACE_NOT_ALLOW = 2073;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int UPLOAD_STEP_NOT_ALLOW = 2074;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final int RUN_ALREADY_FINISH = 2075;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_MAX_LIMIT;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_MAX_LIMIT {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f33692a = 50000;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8551a = a.f8552a;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_MAX_LIMIT$a;", "", "", "a", "J", "MAX_DISTANCE", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final long MAX_DISTANCE = 50000;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8552a = new a();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_NOTIFICATION_ID;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_NOTIFICATION_ID {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33694a = 1235;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8553a = a.f8554a;
        public static final int b = 1236;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_NOTIFICATION_ID$a;", "", "", "a", "I", "FOREGROUND_NOTIFICATION_ID", "b", "AUTO_STOP_NOTIFICATION_ID", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int FOREGROUND_NOTIFICATION_ID = 1235;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8554a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int AUTO_STOP_NOTIFICATION_ID = 1236;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_RESUME_OR_PAUSE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_RESUME_OR_PAUSE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33696a = 2;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8555a = a.f8556a;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_RESUME_OR_PAUSE$a;", "", "", "a", "I", "RESUME", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int RESUME = 2;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8556a = new a();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_TARGET_ARRAY;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_TARGET_ARRAY {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f33699a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @JvmField
        @NotNull
        public static final double[] f8557a = {1000.0d, 1200.0d, 1500.0d, 1600.0d, 2000.0d, 3000.0d, 4000.0d, 5000.0d, 6000.0d, 7000.0d, 8000.0d, 9000.0d, 10000.0d, 19200.0d, 21250.0d, 42250.0d};

        @JvmField
        @NotNull
        public static final double[] b = {50000.0d, 100000.0d, 150000.0d, 200000.0d, 250000.0d, 300000.0d, 350000.0d, 400000.0d, 450000.0d, 500000.0d};

        /* JADX INFO: renamed from: com.huachenjie.common.constants.SportConstants$RUN_TARGET_ARRAY$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0013\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001R\u0017\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_TARGET_ARRAY$a;", "", "", "CALORIES_ARRAY", "[D", "DISTANCE_ARRAY", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f33699a = new Companion();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_TARGET_DEFAULT;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface RUN_TARGET_DEFAULT {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f33700a = 1200;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8558a = a.f8559a;
        public static final long b = 300;
        public static final long c = 200000;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$RUN_TARGET_DEFAULT$a;", "", "", "a", "J", "DEFAULT_DISTANCE", "b", "DEFAULT_DURATION", "c", "DEFAULT_CALORIES", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final long DEFAULT_DISTANCE = 1200;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8559a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final long DEFAULT_DURATION = 300;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final long DEFAULT_CALORIES = 200000;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$SPORT_TYPE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface SPORT_TYPE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33702a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8560a = a.f8561a;
        public static final int b = 2;
        public static final int c = 6;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$SPORT_TYPE$a;", "", "", "a", "I", "TYPE_SUNSHINE_RUN", "b", "TYPE_FREE_RUN", "c", "TYPE_SCHOOL_ACTIVITY_RUN", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int TYPE_SUNSHINE_RUN = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8561a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int TYPE_FREE_RUN = 2;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int TYPE_SCHOOL_ACTIVITY_RUN = 6;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$SUNSHINERUN_RESULT_STATUS;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface SUNSHINERUN_RESULT_STATUS {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33704a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8562a = a.f8563a;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 10;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$SUNSHINERUN_RESULT_STATUS$a;", "", "", "a", "I", "VALID", "b", "INVALID_CAN_NOT_APPEAL", "c", "INVALID_HAVE_NOT_APPEAL", "d", "INVALID_APPEALED", "e", "INVALID_AFTER_AUTH", "f", "VALID_AFTER_AUTH", y6b.f, "VISIONING", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int VALID = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8563a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int INVALID_CAN_NOT_APPEAL = 2;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int INVALID_HAVE_NOT_APPEAL = 3;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata */
            public static final int INVALID_APPEALED = 4;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata */
            public static final int INVALID_AFTER_AUTH = 5;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata */
            public static final int VALID_AFTER_AUTH = 6;

            /* JADX INFO: renamed from: g, reason: from kotlin metadata */
            public static final int VISIONING = 10;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$TIME_TYPE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface TIME_TYPE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33706a = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8564a = a.f8565a;
        public static final int b = 2;
        public static final int c = 3;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$TIME_TYPE$a;", "", "", "a", "I", "TYPE_WEEK", "b", "TYPE_MONTH", "c", "TYPE_ALL", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int TYPE_WEEK = 1;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8565a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final int TYPE_MONTH = 2;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            public static final int TYPE_ALL = 3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$UMENG_EVENT_NAME;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface UMENG_EVENT_NAME {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f33709a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final String f8566a = "start_sun_run";

        @NotNull
        public static final String b = "click_map_avatar";

        @NotNull
        public static final String c = "click_map_person";

        /* JADX INFO: renamed from: com.huachenjie.common.constants.SportConstants$UMENG_EVENT_NAME$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$UMENG_EVENT_NAME$a;", "", "", "a", "Ljava/lang/String;", "start_sun_run", "b", "click_map_avatar", "c", "click_map_person", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f33709a = new Companion();

            /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
            @NotNull
            public static final String start_sun_run = "start_sun_run";

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            @NotNull
            public static final String click_map_avatar = "click_map_avatar";

            /* JADX INFO: renamed from: c, reason: from kotlin metadata */
            @NotNull
            public static final String click_map_person = "click_map_person";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$VALID_SPORT_VALUE;", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface VALID_SPORT_VALUE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f33710a = 3600;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final long f8568a = 30;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        public static final a f8569a = a.f8571a;
        public static final long b = 100;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/constants/SportConstants$VALID_SPORT_VALUE$a;", "", "", "a", "I", "MAX_SHOW_PACE", "", "J", "SUNSHINE_RUN_MIN_DURATIN", "b", "SUNSHINE_RUN_MIN_DISTANCE", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public static final int MAX_SHOW_PACE = 3600;

            /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
            public static final long SUNSHINE_RUN_MIN_DURATIN = 30;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public static final /* synthetic */ a f8571a = new a();

            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final long SUNSHINE_RUN_MIN_DISTANCE = 100;
        }
    }
}

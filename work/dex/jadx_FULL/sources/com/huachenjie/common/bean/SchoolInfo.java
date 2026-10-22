package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zj.adlib.cq;
import com.zj.adlib.h33;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SchoolInfo implements Parcelable {
    public static final Parcelable.Creator<SchoolInfo> CREATOR = new Parcelable.Creator<SchoolInfo>() { // from class: com.huachenjie.common.bean.SchoolInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchoolInfo createFromParcel(Parcel source) {
            return new SchoolInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SchoolInfo[] newArray(int size) {
            return new SchoolInfo[size];
        }
    };
    private String className;
    private String departmentName;
    private String gradeName;
    private String majorName;
    private String schoolCode;
    private String schoolLogo;
    private String schoolName;
    public String shortName;
    private String studentCode;
    private String studentNumber;
    private String subSchoolCode;
    private String subSchoolName;

    public SchoolInfo() {
        this.schoolCode = "";
        this.schoolName = "";
        this.shortName = "";
        this.subSchoolCode = "";
        this.subSchoolName = "";
        this.studentNumber = "";
        this.studentCode = "";
        this.schoolLogo = "";
        this.departmentName = "";
        this.className = "";
        this.gradeName = "";
        this.majorName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String flushPlanetName() {
        if (TextUtils.isEmpty(this.shortName)) {
            return getSchoolName() + "星球";
        }
        return this.shortName + "星球";
    }

    public String getClassName() {
        return this.className;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public String getSchoolLogo() {
        return this.schoolLogo;
    }

    public String getSchoolName() {
        return cq.a(this.schoolName, h33.b());
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public String getStudentNumber() {
        return cq.a(this.studentNumber, h33.b());
    }

    public String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    public String getSubSchoolName() {
        return this.subSchoolName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setSubSchoolCode(String subSchoolCode) {
        this.subSchoolCode = subSchoolCode;
    }

    public void setSubSchoolName(String subSchoolName) {
        this.subSchoolName = subSchoolName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.schoolCode);
        dest.writeString(this.schoolName);
        dest.writeString(this.subSchoolCode);
        dest.writeString(this.subSchoolName);
        dest.writeString(this.studentNumber);
        dest.writeString(this.studentCode);
        dest.writeString(this.schoolLogo);
        dest.writeString(this.departmentName);
        dest.writeString(this.className);
        dest.writeString(this.shortName);
        dest.writeString(this.gradeName);
        dest.writeString(this.majorName);
    }

    public SchoolInfo(Parcel in) {
        this.schoolCode = "";
        this.schoolName = "";
        this.shortName = "";
        this.subSchoolCode = "";
        this.subSchoolName = "";
        this.studentNumber = "";
        this.studentCode = "";
        this.schoolLogo = "";
        this.departmentName = "";
        this.className = "";
        this.gradeName = "";
        this.majorName = "";
        this.schoolCode = in.readString();
        this.schoolName = in.readString();
        this.subSchoolCode = in.readString();
        this.subSchoolName = in.readString();
        this.studentNumber = in.readString();
        this.studentCode = in.readString();
        this.schoolLogo = in.readString();
        this.departmentName = in.readString();
        this.className = in.readString();
        this.shortName = in.readString();
        this.gradeName = in.readString();
        this.majorName = in.readString();
    }
}

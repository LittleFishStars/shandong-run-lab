package com.huachenjie.compat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.common.bean.SchoolInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class StudentInfo implements Parcelable {
    public static final Parcelable.Creator<StudentInfo> CREATOR = new Parcelable.Creator<StudentInfo>() { // from class: com.huachenjie.compat.bean.StudentInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StudentInfo createFromParcel(Parcel parcel) {
            return new StudentInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StudentInfo[] newArray(int i) {
            return new StudentInfo[i];
        }
    };
    ArrayList<String> achievementImgUrl;
    String classCode;
    ArrayList<KeyNameInfo> classInfoList;
    String className;
    String departmentCode;
    String departmentName;
    String gradeCode;
    String gradeName;
    String phone;
    SchoolInfo schoolInfo;
    int sex;
    String studentNumber;
    int studentStatus;
    String subSchoolCode;
    ArrayList<KeyNameInfo> subSchoolList;
    String subSchoolName;
    long userId;
    String userName;

    public StudentInfo() {
        this.schoolInfo = new SchoolInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<String> getAchievementImgUrl() {
        return this.achievementImgUrl;
    }

    public String getClassCode() {
        return this.classCode;
    }

    public ArrayList<KeyNameInfo> getClassInfoList() {
        return this.classInfoList;
    }

    public String getClassName() {
        return this.className;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public String getPhone() {
        return this.phone;
    }

    public SchoolInfo getSchoolInfo() {
        return this.schoolInfo;
    }

    public int getSex() {
        return this.sex;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public int getStudentStatus() {
        return this.studentStatus;
    }

    public String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    public ArrayList<KeyNameInfo> getSubSchoolList() {
        return this.subSchoolList;
    }

    public String getSubSchoolName() {
        return this.subSchoolName;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAchievementImgUrl(ArrayList<String> arrayList) {
        this.achievementImgUrl = arrayList;
    }

    public void setClassCode(String str) {
        this.classCode = str;
    }

    public void setClassInfoList(ArrayList<KeyNameInfo> arrayList) {
        this.classInfoList = arrayList;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setDepartmentCode(String str) {
        this.departmentCode = str;
    }

    public void setDepartmentName(String str) {
        this.departmentName = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSchoolInfo(SchoolInfo schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStudentNumber(String str) {
        this.studentNumber = str;
    }

    public void setStudentStatus(int i) {
        this.studentStatus = i;
    }

    public void setSubSchoolCode(String str) {
        this.subSchoolCode = str;
    }

    public void setSubSchoolList(ArrayList<KeyNameInfo> arrayList) {
        this.subSchoolList = arrayList;
    }

    public void setSubSchoolName(String str) {
        this.subSchoolName = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userName);
        parcel.writeString(this.phone);
        parcel.writeLong(this.userId);
        parcel.writeInt(this.sex);
        parcel.writeParcelable(this.schoolInfo, i);
        parcel.writeStringList(this.achievementImgUrl);
        parcel.writeString(this.studentNumber);
        parcel.writeString(this.gradeName);
        parcel.writeString(this.gradeCode);
        parcel.writeString(this.subSchoolCode);
        parcel.writeString(this.subSchoolName);
        parcel.writeString(this.className);
        parcel.writeString(this.classCode);
        parcel.writeString(this.departmentCode);
        parcel.writeString(this.departmentName);
        parcel.writeTypedList(this.subSchoolList);
        parcel.writeTypedList(this.classInfoList);
        parcel.writeInt(this.studentStatus);
    }

    public StudentInfo(Parcel parcel) {
        this.schoolInfo = new SchoolInfo();
        this.userName = parcel.readString();
        this.phone = parcel.readString();
        this.userId = parcel.readLong();
        this.sex = parcel.readInt();
        this.schoolInfo = (SchoolInfo) parcel.readParcelable(SchoolInfo.class.getClassLoader());
        this.achievementImgUrl = parcel.createStringArrayList();
        this.studentNumber = parcel.readString();
        this.gradeName = parcel.readString();
        this.gradeCode = parcel.readString();
        this.subSchoolCode = parcel.readString();
        this.subSchoolName = parcel.readString();
        this.className = parcel.readString();
        this.classCode = parcel.readString();
        this.departmentCode = parcel.readString();
        this.departmentName = parcel.readString();
        Parcelable.Creator<KeyNameInfo> creator = KeyNameInfo.CREATOR;
        this.subSchoolList = parcel.createTypedArrayList(creator);
        this.classInfoList = parcel.createTypedArrayList(creator);
        this.studentStatus = parcel.readInt();
    }
}

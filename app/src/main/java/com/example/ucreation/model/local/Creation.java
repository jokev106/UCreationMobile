package com.example.ucreation.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ucreation.util.Constants;
import com.google.gson.annotations.SerializedName;

public class Creation implements Parcelable {
    @SerializedName("name")
    String name;

    @SerializedName("date")
    String date;

    @SerializedName("course")
    String course;

    @SerializedName("short_desc")
    String short_desc;

    @SerializedName("long_desc")
    String long_desc;

    @SerializedName("picture")
    String picture;

    @SerializedName("created_by")
    String created_by;

    @SerializedName("creator_team")
    String creator_team;

    @SerializedName("status")
    String status;

    @SerializedName("course_year_lecturer")
    String course_year_lecturer;


    protected Creation(Parcel in) {
        name = in.readString();
        date = in.readString();
        course = in.readString();
        short_desc = in.readString();
        long_desc = in.readString();
        picture = in.readString();
        created_by = in.readString();
        creator_team = in.readString();
        status = in.readString();
        course_year_lecturer = in.readString();
    }

    public static final Creator<Creation> CREATOR = new Creator<Creation>() {
        @Override
        public Creation createFromParcel(Parcel in) {
            return new Creation(in);
        }

        @Override
        public Creation[] newArray(int size) {
            return new Creation[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getPicture() {
        return Constants.BASE_IMAGE_URL + picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreator_team() {
        return creator_team;
    }

    public void setCreator_team(String creator_team) {
        this.creator_team = creator_team;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourse_year_lecturer() {
        return course_year_lecturer;
    }

    public void setCourse_year_lecturer(String course_year_lecturer) {
        this.course_year_lecturer = course_year_lecturer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(course);
        dest.writeString(short_desc);
        dest.writeString(long_desc);
        dest.writeString(picture);
        dest.writeString(created_by);
        dest.writeString(creator_team);
        dest.writeString(status);
        dest.writeString(course_year_lecturer);
    }
}

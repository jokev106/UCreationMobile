package com.example.ucreation.model.local;

import com.example.ucreation.util.Constants;
import com.google.gson.annotations.SerializedName;

public class Creation {
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
}

package com.gilangwinduasmara.simplenewsapp;

import android.os.Parcel;
import android.os.Parcelable;


public class News implements Parcelable {
    private String title;
    private String body;

    public News(){

    }

    public News(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    protected News(Parcel in) {
        this.title = in.readString();
        this.body = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

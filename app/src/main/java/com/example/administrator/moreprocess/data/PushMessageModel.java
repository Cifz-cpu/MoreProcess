package com.example.administrator.moreprocess.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : cifz
 * Time : 2018/8/14
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class PushMessageModel implements Parcelable {
    private String message;
    private String title;

    public PushMessageModel() {
    }

    protected PushMessageModel(Parcel in) {
        message = in.readString();
        title = in.readString();
    }

    public static final Creator<PushMessageModel> CREATOR = new Creator<PushMessageModel>() {
        @Override
        public PushMessageModel createFromParcel(Parcel in) {
            return new PushMessageModel(in);
        }

        @Override
        public PushMessageModel[] newArray(int size) {
            return new PushMessageModel[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeString(title);
    }

    @Override
    public String toString() {
        return "PushMessageModel{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

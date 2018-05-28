package com.example.android.tourguideapp;



import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private int mName;
    private int mDescription;
    private int mAddress;
    private int mPhone;
    private int mWebsite;
    private int mImageResourceID;

    public Place(int name, int description, int address, int phone, int website, int imageResourceId) {
        mName = name;
        mDescription = description;
        mAddress = address;
        mPhone = phone;
        mWebsite = website;
        mImageResourceID = imageResourceId;
    }

    protected Place(Parcel in) {
        mName = in.readInt();
        mDescription = in.readInt();
        mAddress = in.readInt();
        mPhone = in.readInt();
        mWebsite = in.readInt();
        mImageResourceID = in.readInt();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public int getName() {
        return mName;
    }


    public int getDescription() {
        return mDescription;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getPhone() {
        return mPhone;
    }

    public int getWebsite() {
        return mWebsite;
    }


    public int getImageResourceId() {
        return mImageResourceID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mName);
        dest.writeInt(mDescription);
        dest.writeInt(mAddress);
        dest.writeInt(mPhone);
        dest.writeInt(mWebsite);
        dest.writeInt(mImageResourceID);
    }
}

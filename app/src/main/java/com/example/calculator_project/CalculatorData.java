package com.example.calculator_project;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorData implements Parcelable {
    private String data;

    public CalculatorData(String data) {
        this.data = data;
    }

    protected CalculatorData(Parcel in) {
        data = in.readString();
    }

    public static final Creator<CalculatorData> CREATOR = new Creator<CalculatorData>() {
        @Override
        public CalculatorData createFromParcel(Parcel in) {
            return new CalculatorData(in);
        }

        @Override
        public CalculatorData[] newArray(int size) {
            return new CalculatorData[size];
        }
    };

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
    }
}

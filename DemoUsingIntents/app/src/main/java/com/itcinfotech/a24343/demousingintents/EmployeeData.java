/*
package com.itcinfotech.a24343.demousingintents;

import android.os.Parcel;
import android.os.Parcelable;

*/
/**
 * Created by 24343 on 9/26/2017.
 *//*


public class EmployeeData implements Parcelable
{
    String eName,eComp,eDept,eMob;

    protected EmployeeData(Parcel in) {
        eName = in.readString();
        eComp = in.readString();
        eDept = in.readString();
        eMob = in.readString();
    }

    public static final Creator<EmployeeData> CREATOR = new Creator<EmployeeData>() {
        @Override
        public EmployeeData createFromParcel(Parcel in) {
            return new EmployeeData(in);
        }

        @Override
        public EmployeeData[] newArray(int size) {
            return new EmployeeData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(eName);
        parcel.writeString(eComp);
        parcel.writeString(eDept);
        parcel.writeString(eMob);
    }
}
*/

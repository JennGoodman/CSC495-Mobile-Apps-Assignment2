package csc495s15.assignment2;

import android.os.Parcelable;
import android.os.Parcel;

/**
 * Created by Andrew Schaefer on 1/8/15.
 * Modified by Jenn Goodman on 1/21/15.
 */

public class PositionPlayer implements Parcelable {

    private String positionName;
    private String firstName;
    private String lastName;

    PositionPlayer(String p, String f, String l) {
        positionName = p;
        firstName = f;
        lastName = l;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(positionName);
        out.writeString(firstName);
        out.writeString(lastName);
    }

    public PositionPlayer(Parcel in) {
        positionName = in.readString();
        firstName = in.readString();
        lastName = in.readString();
    }

    public static final Parcelable.Creator<PositionPlayer> CREATOR = new Parcelable.Creator<PositionPlayer>() {
        public PositionPlayer createFromParcel(Parcel in) { return new PositionPlayer(in); }
        public PositionPlayer[] newArray(int size) { return new PositionPlayer[size]; }
    };

    public void setPositionName(String p) {
        positionName = p;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return positionName + " - " + firstName + " " + lastName;
    }
}

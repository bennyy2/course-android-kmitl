package kmitl.lab04.benjarat58070079.simplemydot.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Benny on 12/9/2560.
 */

public class DotPacelable implements Parcelable {


    private int centerX;
    private int centerY;
    private int radius;

    public DotPacelable(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public DotPacelable(Parcel in) {
        centerX = in.readInt();
        centerY = in.readInt();
        radius = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(centerX);
        dest.writeInt(centerY);
        dest.writeInt(radius);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DotPacelable> CREATOR = new Creator<DotPacelable>() {
        @Override
        public DotPacelable createFromParcel(Parcel in) {
            return new DotPacelable(in);
        }

        @Override
        public DotPacelable[] newArray(int size) {
            return new DotPacelable[size];
        }
    };
}

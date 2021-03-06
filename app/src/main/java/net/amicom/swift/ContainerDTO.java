package net.amicom.swift;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by amicom on 2015. 5. 23..
 */


public class ContainerDTO implements Parcelable {

    private int MAXSIZE = 300 * (1024 * 1024); // 300mbyte

    private String name;
    private int size;
    private ArrayList<Obj> objectList;
    private String authURL;
    private String tenantName;
    private String userName;
    private String userPassword;


    public ContainerDTO(String name, int size, ArrayList<Obj> objectList) {
        this.setName(name);
        this.setObjectList(objectList);
        this.setSize(size);
    }


    public ContainerDTO(Parcel src) {
        this.setName(src.readString());
        this.setSize(src.readInt());
        this.objectList = (ArrayList<Obj>) src.readSerializable();
        setAuthURL(src.readString());
        setName(src.readString());
        setTenantName(src.readString());
        setUserPassword(src.readString());
    }

    public ContainerDTO() {

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public ContainerDTO createFromParcel(Parcel in) {
            return new ContainerDTO(in);
        }

        @Override
        public ContainerDTO[] newArray(int size) {
            // TODO Auto-generated method stub
            return new ContainerDTO[size];
        }

    };


    public int getMAXSIZE() {
        return MAXSIZE;
    }

    public void setMAXSIZE(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Obj> getObjectList() {
        return objectList;
    }

    public void setObjectList(ArrayList<Obj> objectList) {
        this.objectList = objectList;
    }

    public String getAuthURL() {
        return authURL;
    }

    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public class CustomCreator implements Parcelable.Creator<ContainerDTO> {
        public ContainerDTO createFromParcel(Parcel src) {
            return new ContainerDTO(src);
        }

        public ContainerDTO[] newArray(int size) {
            return new ContainerDTO[size];
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(size);
        dest.writeSerializable(objectList);
        dest.writeString(getAuthURL());
        dest.writeString(getName());
        dest.writeString(getTenantName());
        dest.writeString(getUserPassword());

    }
}

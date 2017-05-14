package com.sdcuike.practice.domain;

public class UserPicWithBLOBs extends UserPic {
    private byte[] pic;

    private String bio;

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }
}
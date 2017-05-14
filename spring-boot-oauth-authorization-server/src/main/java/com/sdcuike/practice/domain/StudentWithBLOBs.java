package com.sdcuike.practice.domain;

public class StudentWithBLOBs extends Student {
    private String bio;

    private byte[] pic;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
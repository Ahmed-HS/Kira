package com.example.projectmanagement.businesslogic.entities;

import androidx.annotation.NonNull;


import androidx.room.Entity;

import androidx.room.PrimaryKey;

interface MemberBuilder
{
    MemberBuilder withName(String name);
    MemberBuilder withEmail(String email);
    MemberBuilder withPassword(String password);
    MemberBuilder withPhoneNumber(String phoneNumber);
    MemberBuilder withAddress(String address);
}


@Entity(tableName = "Members")
public class Member {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int memberID;

    @NonNull
    public String name;

    @NonNull
    public String email;

    @NonNull
    public String password;

    @NonNull
    public String phoneNumber;

    @NonNull
    public String address;

    private Member(Member.Builder builder)
    {
        name = builder.toBuild.name;
        email = builder.toBuild.email;
        password = builder.toBuild.password;
        phoneNumber = builder.toBuild.phoneNumber;
        address = builder.toBuild.address;
    }

    public Member() {}


    public static class Builder implements MemberBuilder
    {
        Member toBuild = new Member();

        @Override
        public Member.Builder withName(String name) {
            toBuild.name = name;
            return this;
        }

        @Override
        public Member.Builder withEmail(String email) {
            toBuild.email = email;
            return this;
        }

        @Override
        public Member.Builder withPassword(String password) {
            toBuild.password = password;
            return this;
        }

        @Override
        public Member.Builder withPhoneNumber(String phoneNumber) {
            toBuild.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Member.Builder withAddress(String address) {
            toBuild.address = address;
            return this;
        }

        public Member build()
        {
            return new Member(this);
        }
    }

}


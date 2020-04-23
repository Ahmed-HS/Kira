package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

@Entity(primaryKeys = {"memberID", "taskID"})
public class MemberTasks {

    public int memberID;

    public int taskID;
}

@Entity(primaryKeys = {"memberID","projectID"})
class MemberProjects
{
    public int memberID;

    public int projectID;
}

@Entity
class MemberWithProjects
{
    @Embedded
    public Member member;
    @Relation(
            parentColumn = "memberID",
            entityColumn = "projectID",
            associateBy = @Junction(MemberProjects.class)
    )
    public List<Project> projects;
}

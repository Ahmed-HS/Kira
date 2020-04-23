package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class ManagerProjects
{
    @Embedded
    public Member projectManager;
    @Relation(
            parentColumn = "memberID",
            entityColumn = "projectID"
    )
    public List<Project> projects;
}

package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DepartmentProjects
{
    @Embedded
    public Department department;

    @Relation(
            parentColumn = "departmentID",
            entityColumn = "projectID"
    )
    public List<Project> projects;

}

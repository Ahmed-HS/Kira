package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TaskWithMembers {
    @Embedded
    public Task task;
    @Relation(
            parentColumn = "taskID",
            entityColumn = "memberID",
            associateBy = @Junction(MemberTasks.class)
    )
    public List<Member> members;
}

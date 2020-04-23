package com.example.projectmanagement.businesslogic.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class MemberWithTasks {
    @Embedded
    public Member playlist;
    @Relation(
            parentColumn = "memberID",
            entityColumn = "taskID",
            associateBy = @Junction(MemberTasks.class)
    )
    public List<Task> tasks;
}

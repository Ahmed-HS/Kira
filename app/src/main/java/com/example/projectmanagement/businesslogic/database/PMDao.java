package com.example.projectmanagement.businesslogic.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.projectmanagement.businesslogic.entities.Department;
import com.example.projectmanagement.businesslogic.entities.DepartmentProjects;
import com.example.projectmanagement.businesslogic.entities.ManagerProjects;
import com.example.projectmanagement.businesslogic.entities.Member;
import com.example.projectmanagement.businesslogic.entities.MemberWithTasks;
import com.example.projectmanagement.businesslogic.entities.Project;
import com.example.projectmanagement.businesslogic.entities.ProjectTasks;
import com.example.projectmanagement.businesslogic.entities.Resource;
import com.example.projectmanagement.businesslogic.entities.Task;
import com.example.projectmanagement.businesslogic.entities.TaskResources;
import com.example.projectmanagement.businesslogic.entities.TaskWithMembers;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PMDao
{
    @Insert
    void insertMember(Member newMember);

    @Insert
    void insertDepartment(Department newDepartment);

    @Insert
    void insertProject(Project newProject);

    @Insert
    void insertTask(Task newTask);

    @Insert
    void insertResource(Resource newResource);

    @Query("Select * from Members where email = :email or phoneNumber = :phone")
    Single<List<Member>> isSignedUp(String email,String phone);

    @Query("Select * From MEMBERS WHERE email = :email and password = :password")
    Single<Member> signIn(String email, String password);

    @Transaction
    @Query("Select * from Departments")
    List<DepartmentProjects> getDepartmentsProjects();

    @Transaction
    @Query("Select * from Members")
    List<ManagerProjects> getMangersProjects();

    @Transaction
    @Query("Select * from Projects")
    List<ProjectTasks> getProjectsTasks();

    @Transaction
    @Query("Select * from Tasks")
    List<TaskResources> getTasksResources();

    @Transaction
    @Query("SELECT * FROM Members")
    List<MemberWithTasks> getMembersWithTasks();

    @Transaction
    @Query("SELECT * FROM Tasks")
    List<TaskWithMembers> getTasksWithMembers();
}
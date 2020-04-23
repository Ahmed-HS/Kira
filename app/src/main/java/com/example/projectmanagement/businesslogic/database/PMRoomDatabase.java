package com.example.projectmanagement.businesslogic.database;


import android.content.Context;


import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.projectmanagement.businesslogic.entities.Department;
import com.example.projectmanagement.businesslogic.entities.LocalDateConverter;
import com.example.projectmanagement.businesslogic.entities.Member;
import com.example.projectmanagement.businesslogic.entities.Project;
import com.example.projectmanagement.businesslogic.entities.Resource;
import com.example.projectmanagement.businesslogic.entities.Task;


@Database(entities = {Member.class, Department.class, Project.class, Task.class, Resource.class
},version = 2,exportSchema = false)
@TypeConverters({LocalDateConverter.class})
public abstract class PMRoomDatabase extends RoomDatabase
{
    public abstract PMDao getDao();
    private static PMRoomDatabase instance;

    public static PMRoomDatabase getDatabase(final Context context)
    {
        if(instance == null)
        {
            synchronized (PMRoomDatabase.class)
            {
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            PMRoomDatabase.class,"ProjectManagementDB")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}

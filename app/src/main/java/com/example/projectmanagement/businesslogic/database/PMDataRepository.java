package com.example.projectmanagement.businesslogic.database;

import android.app.Application;
import android.os.AsyncTask;

import com.example.projectmanagement.businesslogic.entities.Member;
import com.example.projectmanagement.businesslogic.entities.MemberTasks;

import java.util.List;

import io.reactivex.Single;

public class PMDataRepository {

    private static PMDataRepository instance;
    private PMDao mDao;
    private Member LoggedInMember;

    public Member getLoggedInMember() {
        return LoggedInMember;
    }

    public void setLoggedInMember(Member loggedInMember) {
        LoggedInMember = loggedInMember;
    }

    private PMDataRepository(Application application) {
        mDao = PMRoomDatabase.getDatabase(application).getDao();
    }

    public static PMDataRepository getInstance(Application application)
    {
        if(instance == null)
        {
            synchronized (PMDataRepository.class)
            {
                if(instance == null)
                {
                    instance = new PMDataRepository(application);
                }
            }
        }

        return instance;
    }


    public void insertMember(Member newMember) {
        new InsertMemberAsync(mDao).execute(newMember);
    }

    static class InsertMemberAsync extends AsyncTask<Member, Void, Void> {
        private PMDao mAsyncDao;

        InsertMemberAsync(PMDao Dao) {
            mAsyncDao = Dao;
        }

        @Override
        protected Void doInBackground(Member... members) {
            mAsyncDao.insertMember(members[0]);
            return null;
        }
    }


}

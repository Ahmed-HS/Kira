package com.example.projectmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.projectmanagement.businesslogic.database.PMDataRepository;
import com.example.projectmanagement.businesslogic.database.PMRoomDatabase;
import com.example.projectmanagement.businesslogic.entities.Member;
import com.example.projectmanagement.databinding.ActivityLogInBinding;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = "LogInActivity";
    ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void logIn(View view) {
        String email = binding.email.getText().toString().toLowerCase();
        String password = binding.password.getText().toString();

        PMRoomDatabase.getDatabase(getApplication())
                .getDao()
                .signIn(email,password)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Member>() {

                    @Override
                    public void onSuccess(Member member) {
                        Utility.showToast(LogInActivity.this,"Welcome " + member.name);
                        PMDataRepository.getInstance(getApplication())
                                .setLoggedInMember(member);

                        Intent goToDashboard = new Intent(LogInActivity.this,DashboardActivity.class);
                        startActivity(goToDashboard);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utility.showToast(LogInActivity.this,"Incorrect email or password");
                    }
                });

    }
}

package com.example.projectmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.projectmanagement.businesslogic.database.PMDataRepository;
import com.example.projectmanagement.businesslogic.database.PMRoomDatabase;
import com.example.projectmanagement.businesslogic.entities.Member;
import com.example.projectmanagement.databinding.ActivitySignUpBinding;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    
    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void signUp(View view) {
        final String email = binding.email.getText().toString().toLowerCase();
        final String phoneNumber = binding.phoneNumber.getText().toString();
        PMRoomDatabase.getDatabase(getApplication()).getDao().isSignedUp(email,phoneNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Member>>() {
                    @Override
                    public void onSuccess(List<Member> members) {
                        Log.d(TAG, "onSuccess() called with: members = [" + members + "]");
                        if(!members.isEmpty())
                        {
                            Utility.showToast(SignUpActivity.this,"The email or phone number are taken");
                            return;
                        }

                        String name = binding.name.getText().toString();
                        String password = binding.password.getText().toString();
                        String address = binding.address.getText().toString();

                        Member newMember = new Member.Builder()
                                .withName(name)
                                .withEmail(email)
                                .withPassword(password)
                                .withPhoneNumber(phoneNumber)
                                .withAddress(address).build();

                        PMDataRepository.getInstance(getApplication()).insertMember(newMember);
                        Utility.showToast(SignUpActivity.this,"Registration successful");
                        SignUpActivity.this.finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }
                });
    }
}

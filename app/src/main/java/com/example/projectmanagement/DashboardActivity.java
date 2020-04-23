package com.example.projectmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.projectmanagement.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityDashboardBinding binding;
    TasksFragment tasksView;
    ProjectsFragment projectsView;
    DepartmentsFragment departmentsView;
    ResourcesFragment resourcesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tasksView = new TasksFragment();
        projectsView = new ProjectsFragment();
        departmentsView = new DepartmentsFragment();
        resourcesView = new ResourcesFragment();

        setCurrentView(tasksView);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
    }


    private void setCurrentView(Fragment newfragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.currentView,newfragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.tasks:
                setCurrentView(tasksView);
                break;

            case R.id.projects:
                setCurrentView(projectsView);
                break;

            case R.id.departments:
                setCurrentView(departmentsView);
                break;

            case R.id.resources:
                setCurrentView(resourcesView);
                break;

        }
        return true;
    }
}

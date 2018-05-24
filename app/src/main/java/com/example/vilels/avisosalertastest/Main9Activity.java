package com.example.vilels.avisosalertastest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.getMenu().getItem(3).setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        item.setChecked(true);
                        displayMessage("HOME");
                        drawerLayout.closeDrawers();
                        changeActivity(Main6Activity.class);
                        return true;
                    case R.id.nav_gestaoTemas:
                        item.setChecked(true);
                        displayMessage("GESTAO DE TEMAS");
                        drawerLayout.closeDrawers();
                        changeActivity(Main7Activity.class);
                        return true;
                    case R.id.nav_perfil:
                        item.setChecked(true);
                        displayMessage("MEU PERFIL");
                        drawerLayout.closeDrawers();
                        changeActivity(Main8Activity.class);
                        return true;
                    case R.id.nav_defenicoes:
                        item.setChecked(true);
                        displayMessage("DEFENIÇÔES");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_secao:
                        item.setChecked(true);
                        displayMessage("TERMINAR SEÇÂO");
                        drawerLayout.closeDrawers();
                        return true;
                }

                return false;
            }
        });
    }

    private void displayMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeActivity (Class<?> subActivity){
        Intent x = new Intent(this, subActivity);
        startActivity(x);
    }
}

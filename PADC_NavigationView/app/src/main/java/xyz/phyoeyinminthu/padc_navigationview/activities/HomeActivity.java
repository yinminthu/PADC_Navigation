package xyz.phyoeyinminthu.padc_navigationview.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.os.Handler;

import xyz.phyoeyinminthu.padc_navigationview.R;
import xyz.phyoeyinminthu.padc_navigationview.fragments.JobSearchFragment;
import xyz.phyoeyinminthu.padc_navigationview.fragments.LinkedInFragment;
import xyz.phyoeyinminthu.padc_navigationview.utils.MMFontUtils;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        MenuItemCompat.OnActionExpandListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fb_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        flContainer = (FrameLayout) findViewById(R.id.fl_container);
        toolbar.setTitle(R.string.app_name);

        if(savedInstanceState == null) {
            LinkedInFragment fragment = new LinkedInFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void navigateToLinkedIn(){
        LinkedInFragment fragment = new LinkedInFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container,fragment);
    }
    private void navigateToJobSearch() {
        JobSearchFragment fragment = new JobSearchFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container,fragment);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (menuItem.getItemId()) {
                    case R.id.left_menu_linkedin:
                        toolbar.setTitle(R.string.left_menu_linkedin);
                        navigateToLinkedIn();
                    case R.id.left_menu_job_search:
                        toolbar.setTitle(R.string.left_menu_job_search);
                        navigateToJobSearch();
                }
            }
        }, 100);
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }
}

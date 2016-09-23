package com.sheehan.samples.makingsense.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sheehan.samples.makingsense.MakingSenseApplication;
import com.sheehan.samples.makingsense.R;
import com.sheehan.samples.makingsense.adapter.SensorAdapter;
import com.sheehan.samples.makingsense.managers.SensorManager;
import com.sheehan.samples.makingsense.sensor.base.SensorContainer;
import com.sheehan.samples.makingsense.sensor.value.AccelerometerValue;
import com.sheehan.samples.makingsense.sensor.value.GyroscopeValue;
import com.sheehan.samples.makingsense.sensor.value.SensorValue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private int mSensorsOff = R.drawable.ic_notification_sync_disabled;
    private int mSensorsOn = R.drawable.ic_notification_sync;
    private final int POOL_SIZE = 1;
    private SensorManager mSensorManager;
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private SensorAdapter mSensorAdapter;
    private ScheduledThreadPoolExecutor mScheduledThreadPoolExecutor;
    private Runnable mSensorPullRunnable;
    private List<SensorValue> mSensorValueList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSensorManager = MakingSenseApplication.getInstance().getSensorManager();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
    }

    private void initViews(){
        //Get views
        mFab = (FloatingActionButton) findViewById(R.id.fab_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //initialize them
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSensorState();
            }
        });
        mSensorAdapter = new SensorAdapter(this, mSensorValueList = getDefaultSensorList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSensorAdapter);
    }

    private List<SensorValue> getDefaultSensorList(){
        List<SensorValue> list = new ArrayList<>();
        list.add(new AccelerometerValue(null));
        list.add(new GyroscopeValue(null));
        return list;
    }

    private void updateSensorState(){
        if(mSensorManager.isConnected()){
            cancelScheduledSensorPull();
            mSensorManager.disconnect();
            mFab.setImageResource(mSensorsOff);
            mSensorValueList.clear();
            mSensorValueList.addAll(getDefaultSensorList());
            mSensorAdapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Sensors are off...", Toast.LENGTH_SHORT).show();
        } else {
            mSensorManager.connect();
            mFab.setImageResource(mSensorsOn);
            scheduleSensorPull();
            Toast.makeText(MainActivity.this, "Sensors are on", Toast.LENGTH_SHORT).show();
        }
    }

    private void scheduleSensorPull(){
        mScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(POOL_SIZE);
        mScheduledThreadPoolExecutor.scheduleWithFixedDelay(getSensorPullRunnable(), 1, 1, TimeUnit.SECONDS);
    }

    private void cancelScheduledSensorPull(){
        if(mScheduledThreadPoolExecutor != null){
            mScheduledThreadPoolExecutor.shutdown();
        }
    }

    /**
     * Magic happens here.
     * @return
     */
    private Runnable getSensorPullRunnable(){
        if(mSensorPullRunnable == null){
            mSensorPullRunnable = new Runnable() {
                @Override
                public void run() {
                    //TODO - Do something way cooler then this...
                    mSensorValueList.clear();
                    SensorContainer sensorContainer = mSensorManager.pop();
                    for(SensorValue sensorValue: sensorContainer.getSensorValues()){
                        mSensorValueList.add(sensorValue);
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //Run on ui thread
                            mSensorAdapter.notifyDataSetChanged();
                        }
                    });

                }
            };
        }
        return mSensorPullRunnable;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

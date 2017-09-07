/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.maps.android.utils.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends Activity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private ViewGroup mListView;

    //Comment to see if I can push to the repository

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();
        //mListView = (ViewGroup) findViewById(R.id.list);

        addDemo("Clustering", ClusteringDemoActivity.class);
        addDemo("Clustering: Custom Look", CustomMarkerClusteringDemoActivity.class);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_quizzes) {
            Intent intent = new Intent(MainActivity.this, SelectBillboard.class);
            startActivity(intent);

        }  else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            signOutAccount();
        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void signOutAccount(){
        //Signs out email/password authentication
        mAuth.signOut();
        FirebaseAuth.getInstance().signOut();
    }


    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        mListView.addView(b);
    }
    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        startActivity(new Intent(this, activityClass));
    }
}

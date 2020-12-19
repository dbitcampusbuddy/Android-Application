package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("ALL")
public class Edit_Marks extends AppCompatActivity {



    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private EditText ia1_s1;
    private EditText ia2_s1;
    private EditText end_s1;
    private EditText ia1_s2;
    private EditText ia2_s2;
    private EditText end_s2;
    private EditText ia1_s3;
    private EditText ia2_s3;
    private EditText end_s3;
    private EditText ia1_s4;
    private EditText ia2_s4;
    private EditText end_s4;
    private EditText ia1_s5;
    private EditText ia2_s5;
    private EditText end_s5;
    private EditText cgpa;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__marks);

        ia1_s1 = findViewById(R.id.editText_IA2);
        ia2_s1 = findViewById(R.id.editText_IA8);
        end_s1 = findViewById(R.id.editText_IA17);
        ia1_s2 = findViewById(R.id.editText_IA9);
        ia2_s2 = findViewById(R.id.editText_IA15);
        end_s2 = findViewById(R.id.editText_IA18);
        ia1_s3 = findViewById(R.id.editText_IA10);
        ia2_s3 = findViewById(R.id.editText_IA14);
        end_s3 = findViewById(R.id.editText_IA19);
        ia1_s4 = findViewById(R.id.editText_IA11);
        ia2_s4 = findViewById(R.id.editText_IA13);
        end_s4 = findViewById(R.id.editText_IA20);
        ia1_s5 = findViewById(R.id.editText_IA12);
        ia2_s5 = findViewById(R.id.editText_IA16);
        end_s5 = findViewById(R.id.editText_IA21);
        cgpa = findViewById(R.id.editTextCGPA);

        Intent intent = getIntent();
        id = intent.getStringExtra("username");
        Toast.makeText(Edit_Marks.this, id, Toast.LENGTH_LONG).show();





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.exam);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
                switch (menuItem.getItemId()) {
                    case R.id.attendance:
                        startActivity(new Intent(getApplicationContext(), View_atn.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.exam:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), homepage.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.events:
                        startActivity(new Intent(getApplicationContext(), Events.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.placements:
                        startActivity(new Intent(getApplicationContext(), Placements.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });
    }

    //Button save_btn = (Button) findViewById(R.id.button_save);

        /*save_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Edit_Marks.this, Examination.class));
            }
        });*/

    public void editmarks(View arg0) {

        // Get text from email and passord field
        final String Ia1_s1 = ia1_s1.getText().toString();
        final String Ia2_s1 = ia2_s1.getText().toString();
        final String End_s1 = end_s1.getText().toString();

        final String Ia1_s2 = ia1_s2.getText().toString();
        final String Ia2_s2 = ia2_s2.getText().toString();
        final String End_s2 = end_s2.getText().toString();

        final String Ia1_s3 = ia1_s3.getText().toString();
        final String Ia2_s3 = ia2_s3.getText().toString();
        final String End_s3 = end_s3.getText().toString();

        final String Ia1_s4 = ia1_s4.getText().toString();
        final String Ia2_s4 = ia2_s4.getText().toString();
        final String End_s4 = end_s4.getText().toString();

        final String Ia1_s5 = ia1_s5.getText().toString();
        final String Ia2_s5 = ia2_s5.getText().toString();
        final String End_s5 = end_s5.getText().toString();

        final String CGPA = cgpa.getText().toString();

        String user_name = id;


        // Initialize  AsyncLogin() class with email and password
        new AsyncLogin().execute(Ia1_s1, Ia2_s1, End_s1, Ia1_s2, Ia2_s2, End_s2, Ia1_s3, Ia2_s3, End_s3, Ia1_s4, Ia2_s4, End_s4, Ia1_s5, Ia2_s5, End_s5,CGPA,user_name);

    }

    private class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(Edit_Marks.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://cb-in.stackstaging.com/exam.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("ia1_s1", params[0])
                        .appendQueryParameter("ia2_s1", params[1])
                        .appendQueryParameter("end_s1", params[2])
                        .appendQueryParameter("ia1_s2", params[3])
                        .appendQueryParameter("ia2_s2", params[4])
                        .appendQueryParameter("end_s2", params[5])
                        .appendQueryParameter("ia1_s3", params[6])
                        .appendQueryParameter("ia2_s3", params[7])
                        .appendQueryParameter("end_s3", params[8])
                        .appendQueryParameter("ia1_s4", params[9])
                        .appendQueryParameter("ia2_s4", params[10])
                        .appendQueryParameter("end_s4", params[11])
                        .appendQueryParameter("ia1_s5", params[12])
                        .appendQueryParameter("ia2_s5", params[13])
                        .appendQueryParameter("end_s5", params[14])
                        .appendQueryParameter("CGPA", params[15])
                        .appendQueryParameter("user_name", params[16]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            pdLoading.dismiss();

            //if((Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show())=="true")
            Toast.makeText(Edit_Marks.this, result, Toast.LENGTH_LONG).show();
            //if(temp) {
            //  Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            //}
            String tresult = result.trim();
            if (tresult.equalsIgnoreCase("yes")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */

                Toast.makeText(Edit_Marks.this, "successfull", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Edit_Marks.this, Examination.class);
                startActivity(intent);
                Edit_Marks.this.finish();

            } else if (tresult.equalsIgnoreCase("no")) {

                // If username and password does not match display a error message
                Toast.makeText(Edit_Marks.this, "Invalid email or password", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(Edit_Marks.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }

    }



}



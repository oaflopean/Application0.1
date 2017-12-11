package org.caesarnapleswiki.application01;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import static android.support.v7.appcompat.R.id.image;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.caesarnapleswiki.application01.randomw.rndMarkov;
import static org.caesarnapleswiki.application01.randomw.rndSentence;
import static org.caesarnapleswiki.application01.randomw.rndWord;

public class Front_Page extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front__page);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(Front_Page.this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(Front_Page.this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(Front_Page.this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {



            case R.id.action_favorite:
                TextView showText = new TextView(this);

                // User chose the "Settings" item, show the app settings UI...
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                showText.setText(R.string.about_me);
                showText.setPadding(45, 2, 45, 45);
                showText.setTextIsSelectable(true);
// Build the Dialog
                builder.setView(showText);
                builder.setTitle(R.string.about_me1);
                builder.setCancelable(true);
                AlertDialog dialog = builder.create();
                dialog.show();

            case R.id.action_history:
                // User chose the "Favorite" action, ark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public void onClick(View v) {
        if (v == button) {
            Integer chosen=R.raw.cnwiki;

            InputStream input= getApplicationContext().getResources().openRawResource(chosen);

            String word = null;
            try {
                TextView showText = new TextView(this);
                word = rndWord(input);
                showText.setText(word);
                showText.setPadding(45, 2, 45, 45);
                showText.setTextIsSelectable(true);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
// Build the Dialog
                builder.setView(showText);
                builder.setTitle(R.string.dialog_title_word);
                builder.setCancelable(true);
                AlertDialog dialog = builder.create();
                dialog.show();


                //AlertDialog.Builder builder = new AlertDialog.Builder(this);

                //builder.setMessage(word);

            } catch (IOException e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Error");
                builder.setTitle(R.string.dialog_title_word);
                AlertDialog dialog = builder.create();
                dialog.show();
                e.printStackTrace();
            }


        }else if (v == button2) {

            Integer chosen=R.raw.cnwiki;


            InputStream input= getApplicationContext().getResources().openRawResource(chosen);
            String sentence = null;
            try {
                TextView showText = new TextView(this);
                sentence = rndSentence(input);
                showText.setText(sentence);
                showText.setPadding(45, 2, 45, 45);

                showText.setTextIsSelectable(true);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
// Build the Dialog
                builder.setView(showText);
                builder.setTitle(R.string.dialog_title_sentence);
                builder.setCancelable(true);
                AlertDialog dialog = builder.create();
                dialog.show();
            } catch (IOException e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Error");
                builder.setTitle(R.string.sentence);
                AlertDialog dialog = builder.create();
                dialog.show();
                e.printStackTrace();
            }}
         else if (v == button3) {
            Integer chosen=randomChoice.choose();
            InputStream input= getApplicationContext().getResources().openRawResource(chosen);
            InputStream wiki= getApplicationContext().getResources().openRawResource(R.raw.cnwiki);
            InputStream extra= getApplicationContext().getResources().openRawResource(R.raw.newfile);

            String markov=null;
            try {
                TextView showText = new TextView(this);
                markov = rndMarkov(input, wiki, extra);
                showText.setText(markov);
                showText.setPadding(45, 2, 45, 45);
                showText.setTextIsSelectable(true);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
// Build the Dialog
                builder.setView(showText);
                builder.setTitle(R.string.dialog_title_markov);
                builder.setCancelable(true);
                AlertDialog dialog = builder.create();
                dialog.show();
            } catch (IOException e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Error");
                builder.setTitle(R.string.dialog_title_markov);
                AlertDialog dialog = builder.create();
                dialog.show();
                e.printStackTrace();
            }


            }
        }

    }
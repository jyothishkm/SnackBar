package com.example.bridgeit.snackbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Snackbar mSnackbar;

    private CoordinatorLayout mCoordinatorLayout;
    private Button mBtnSimpleSnackbar, mBtnActionCallback, mBtnCustomView;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        mFab = (FloatingActionButton) findViewById(R.id.fab);




        mBtnSimpleSnackbar = (Button) findViewById(R.id.btnSimpleSnackbar);
        mBtnActionCallback = (Button) findViewById(R.id.btnActionCallback);
        mBtnCustomView = (Button) findViewById(R.id.btnCustomSnackbar);

        mBtnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar = Snackbar.make(mCoordinatorLayout, "Simple Snackbar",Snackbar.LENGTH_SHORT);
                mSnackbar.show();
            }
        });



        mBtnActionCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar = Snackbar.make(mCoordinatorLayout, "Message is deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snackbar1 = Snackbar.make(mCoordinatorLayout, "Message is restored......!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                mSnackbar.show();
            }
        });


        mBtnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSnackbar = Snackbar.make(mCoordinatorLayout,"No internet connection", Snackbar.LENGTH_INDEFINITE)
        .setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
                mSnackbar.setActionTextColor(Color.RED);
                View svView = mSnackbar.getView();
                TextView txt = (TextView)svView.findViewById(android.support.design.R.id.snackbar_text);
                txt.setTextColor(Color.YELLOW);
                mSnackbar.show();

            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Floating.class);
                startActivity(intent);
            }
        });
    }
}

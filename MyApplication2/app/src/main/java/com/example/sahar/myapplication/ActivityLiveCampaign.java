package com.example.sahar.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.cert.Extension;

/**
 * Created by sahar on 14/12/17.
 */

public class ActivityLiveCampaign extends Activity implements View.OnClickListener {
TextView cur_label,pos_label,total_label,cur_val,pos_value,total_val;
Button confirm,cancel,transfer;
int btn_num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campaign_activity);

        cur_label = (TextView) findViewById(R.id.current_label);
        pos_label = (TextView) findViewById(R.id.position_label);
        total_label = (TextView) findViewById(R.id.total_label);

        cur_val = (TextView) findViewById(R.id.current_val);
        long i = 124578910L;
        String cv = String.valueOf(i);
        cur_val.setText(cv);

        pos_value = (TextView) findViewById(R.id.position_val);
        String pv = String.valueOf(456);
        pos_value.setText(pv);

        total_val = (TextView) findViewById(R.id.total_val);
        String tv = String.valueOf(100);
        total_val.setText(tv);

        confirm = (Button) findViewById(R.id.btn_confirm);
        confirm.setOnClickListener(this);

        cancel = (Button) findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(this);

        transfer = (Button) findViewById(R.id.btn_transfer);
        transfer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {

            case R.id.btn_confirm:
                btn_num=1;
                showPopupDialog();
                break;

            case R.id.btn_cancel:
                btn_num=2;
                showPopupDialog();
                break;

            case R.id.btn_transfer:
                btn_num=3;
                showPopupDialog();
                break;

            default:
                break;
        }
    }

    private void showPopupDialog() {
            try{

                LayoutInflater li = LayoutInflater.from(getApplicationContext());
                final View prompt = li.inflate(R.layout.popupdialog, null);
                final AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(ActivityLiveCampaign.this);
                final TextView posttext = (TextView) prompt.findViewById(R.id.text_sure);

                alertDialogBuilder.setView(prompt);
                alertDialogBuilder.setTitle(getString(R.string.sure));
                alertDialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btn_num==1) {
                            Intent myIntent = new Intent(ActivityLiveCampaign.this,ActivityConfirm.class);
                            startActivity(myIntent);

                        }else if(btn_num==2) {
                            Intent myIntent = new Intent(ActivityLiveCampaign.this, ActivityCancel.class);
                            startActivity(myIntent);

                        }else if(btn_num==3){
                            Intent myIntent = new Intent(ActivityLiveCampaign.this,ActivityTransfer.class);
                            startActivity(myIntent);

                        }
                    }
                 });

                    alertDialogBuilder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    alertDialogBuilder.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

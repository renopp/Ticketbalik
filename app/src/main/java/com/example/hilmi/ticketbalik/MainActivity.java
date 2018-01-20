package com.example.hilmi.ticketbalik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int qtty=0, total, price=25000;
    EditText edtPemesan, edtJam, edtMenit;
    Button btntambah, btnkurang, btnorder;
    Spinner spnAsal, spnTujuan;
    TextView txtHasil, txtJumlah;
    CheckBox cbxEco, cbxNonEco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPemesan = (EditText) findViewById(R.id.edt_pemesan);
        edtMenit = (EditText)findViewById(R.id.edt_menit);
        edtJam = (EditText)findViewById(R.id.edt_jam);
        btntambah = (Button)findViewById(R.id.btn_tambah);
        btnkurang = (Button)findViewById(R.id.btn_kurang);
        btnorder = (Button)findViewById(R.id.btn_order);
        txtHasil = (TextView)findViewById(R.id.txt_hasil);
        txtJumlah = (TextView)findViewById(R.id.txt_jumlah);
        cbxEco = (CheckBox)findViewById(R.id.cbx_eco);
        cbxNonEco = (CheckBox)findViewById(R.id.cbx_noneco);
        spnAsal = (Spinner) findViewById(R.id.spn_kota_asal);
        spnTujuan = (Spinner)findViewById(R.id.spn_kota_tujuan);


        btntambah.setOnClickListener(this);
        btnorder.setOnClickListener(this);
        btnkurang.setOnClickListener(this);
        cbxNonEco.setOnClickListener(this);
        cbxEco.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view == btntambah){
            if (qtty >= 5){
                txtJumlah.setText(5 + " ");
                Toast.makeText(this, "Maksimal Pembelian 5 Tiket", Toast.LENGTH_SHORT).show();
            }
            else
            qtty++;
            txtJumlah.setText(qtty + " ");
        }
        else if(view == btnkurang){

            if (qtty<=0){
                txtJumlah.setText(0 +" ");
            }
            else
            qtty--;
            txtJumlah.setText(qtty +" ");
        }
        if (cbxEco.isChecked()){
            price=price;
            cbxEco.setChecked(true);
            cbxNonEco.setChecked(false);
        }
        else {
            price=0;
        }
        if (cbxNonEco.isChecked()){
            price=price+10000;
            cbxNonEco.setChecked(true);
            cbxEco.setChecked(false);
        }
        else {
            cbxEco.setChecked(true);
            price=price+10000;
        }

        if (view == btnorder){
            total = price*qtty;
            
        }

    }
}

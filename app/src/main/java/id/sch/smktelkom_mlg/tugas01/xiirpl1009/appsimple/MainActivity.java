package id.sch.smktelkom_mlg.tugas01.xiirpl1009.appsimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlamat, etTelp, etTgl;
    RadioGroup rgBayar;
    CheckBox cbBaju, cbBawahan, cbKarpet, cbSprei;
    Spinner spCuci;
    TextView tvHasil;
    Button bLaundry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etTelp = (EditText) findViewById(R.id.editTextTelp);
        etTgl = (EditText) findViewById(R.id.editTextTgl);
        rgBayar = (RadioGroup) findViewById(R.id.radioGroupBayar);
        cbBaju = (CheckBox) findViewById(R.id.cbBaju);
        cbBawahan = (CheckBox) findViewById(R.id.cbBawahan);
        cbKarpet = (CheckBox) findViewById(R.id.cbKarpet);
        cbSprei = (CheckBox) findViewById(R.id.cbSprei);
        spCuci = (Spinner) findViewById(R.id.spinnerCuci);
        bLaundry = (Button) findViewById(R.id.btnLaundry);
        tvHasil = (TextView) findViewById(R.id.txtHasil);

        bLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String telp = etTelp.getText().toString();
        String tgl = etTgl.getText().toString();
        String hasil = null;

        if (rgBayar.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgBayar.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih Metode Pembayaran");
        } else {
            String cuci = spCuci.getSelectedItem().toString();
            String hasil1 = "Barang yang di laundry :\n";
            String akhir = "Nama : " + nama + "\n"
                    + "Alamat : " + alamat + "\n"
                    + "Telp : " + telp + "\n"
                    + "Tanggal : " + tgl + "\n" + "\n";
            String akhir2 = "\n" + "Jenis Laundry : " + cuci + "\n"
                    + "Pembayaran : " + hasil;
                /*int startlen = hasil1.length();*/


            if (cbKarpet.isChecked())
                hasil1 += cbKarpet.getText() + "\n";
            tvHasil.setText(akhir + hasil1 + akhir2);

            if (cbBaju.isChecked())
                hasil1 += cbBaju.getText() + "\n";
            tvHasil.setText(akhir + hasil1 + akhir2);

            if (cbBawahan.isChecked())
                hasil1 += cbBawahan.getText() + "\n";
            tvHasil.setText(akhir + hasil1 + akhir2);

            if (cbSprei.isChecked())
                hasil1 += cbSprei.getText() + "\n";
            tvHasil.setText(akhir + hasil1 + akhir2);

                /*if(hasil1.length()==startlen){
                    hasil1+="Belum ada pilihan";
                    tvHasil.setText(hasil1);}*/

        }
    }
}


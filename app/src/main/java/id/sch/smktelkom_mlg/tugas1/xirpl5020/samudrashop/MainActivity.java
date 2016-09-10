package id.sch.smktelkom_mlg.tugas1.xirpl5020.samudrashop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTelepon, etKode;
    Button btPesan;
    TextView tvHasil, tvData, tvrb, tvcb;
    Spinner spProvinsi, spKota;
    CheckBox cbXY, cbH3, cbH4;
    RadioButton rbReg, rbYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelepon = (EditText) findViewById(R.id.editTextTelepon);
        etKode = (EditText) findViewById(R.id.editTextKode);
        btPesan = (Button) findViewById(R.id.buttonPesan);
        cbXY = (CheckBox) findViewById(R.id.checkBoxXiaomi);
        cbH3 = (CheckBox) findViewById(R.id.checkBoxHero3);
        cbH4 = (CheckBox) findViewById(R.id.checkBoxHero4);
        rbReg = (RadioButton) findViewById(R.id.radioButtonReg);
        rbYes = (RadioButton) findViewById(R.id.radioButtonYes);
        tvData = (TextView) findViewById(R.id.textViewData);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvcb = (TextView) findViewById(R.id.textViewcb);
        tvrb = (TextView) findViewById(R.id.textViewrb);
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        spKota = (Spinner) findViewById(R.id.spinnerKota);
        final String[][] arKota = {
                {"Kabupaten Bangkalan", "Kabupaten Banyuwangi", "Kabupaten Blitar", "Kabupaten Bojonegoro", "Kabupaten Bondowoso", "Kabupaten Gresik", "Kabupaten Jember", "Kabupaten Jombang", "Kabupaten Kediri", "Kabupaten Lamongan", "Kabupaten Lumajang", "Kabupaten Madiun", "Kabupaten Magetan", "Kabupaten Malang", "Kabupaten Mojokerto", "Kabupaten Nganjuk", "Kabupaten Ngawi", "Kabupaten Pacitan", "Kabupaten Pamekasan", "Kabupaten Pasuruan", "Kabupaten Ponorogo", "Kabupaten Probolinggo", "Kabupaten Sampang", "Kabupaten Sidoarjo", "Kabupaten Situbondo", "Kabupaten Sumenep", "Kabupaten Trenggalek", "Kabupaten Tuban", "Kabupaten Tulungagung", "Kota Batu", "Kota Blitar", "Kota Kediri", "Kota Madiun", "Kota Malang", "Kota Mojokerto", "Kota Pasuruan", "Kota Probolinggo", "Kota Surabaya"},
                {"Kabupaten Banjarnegara", "Kabupaten Banyumas", "Kabupaten Batang", "Kabupaten Blora", "Kabupaten Boyolali", "Kabupaten Brebes", "Kabupaten Cilacap", "Kabupaten Demak", "Kabupaten Grobogan", "Kabupaten Jepara", "Kabupaten Karanganyar", "Kabupaten Kebumen", "Kabupaten Kendal", "Kabupaten Klaten", "Kabupaten Kudus", "Kabupaten Magelang", "Kabupaten Pati", "Kabupaten Pekalongan", "Kabupaten Pemalang", "Kabupaten Purbalingga", "Kabupaten Purwokerto", "Kabupaten Rembang", "Kabupaten Semarang", "Kabupaten Sragen", "Kabupaten Sukoharjo", "Kabupaten Tegal", "Kabupaten Temanggung", "Kabupaten Wonogiri", "Kabupaten Wonosobo", "Kota Magelang", "Kota Pekalongan", "Kota Salatiga", "Kota Semarang", "Kota Surakarta", "Kota Tegal"},
                {"Kabupaten Bandung", "Kabupaten Bandung Barat", "Kabupaten Bekasi", "Kabupaten Bogor", "Kabupaten Ciamis", "Kabupaten Cianjur", "Kabupaten Cirebon", "Kabupaten Garut", "Kabupaten Indramayu", "Kabupaten Karawang", "Kabupaten Kuningan", "Kabupaten Majalengka", "Kabupaten Pangandaran", "Kabupaten Purwakarta", "Kabupaten Subang", "Kabupaten Sukabumi", "Kabupaten Sumedang", "Kabupaten Tasikmalaya", "Kota Bandung", "Kota Banjar", "Kota Bekasi", "Kota Bogor", "Kota Cimahi", "Kota Cirebon", "Kota Depok", "Kota Sukabumi", "Kota Sukabumi", "Kota Tasikmalaya"},
                            };
        final ArrayList<String> daftarKota = new ArrayList<>();
        final ArrayAdapter<String> adapter;

        btPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doHasil();
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, daftarKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                daftarKota.clear();
                daftarKota.addAll(Arrays.asList(arKota[pos]));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });
    }

    private void doHasil() {
        if (isValid()) {
            String hasil="\n";
            int startlen = hasil.length();
            if(cbXY.isChecked()) hasil+=cbXY.getText()+"\n";
            if(cbH3.isChecked()) hasil+=cbH3.getText()+"\n";
            if(cbH4.isChecked()) hasil+=cbH4.getText()+"\n";
            if(hasil.length()==startlen)
            {
                tvcb.setText(hasil+="Anda belum memilih barang\n");
            }
            else
            {
                tvcb.setText("\nAnda akan membeli :"+hasil);
            }
            String hasil2 = null;
            if(rbReg.isChecked())
            {
                hasil2 = rbReg.getText().toString();
            }
            else if(rbYes.isChecked())
            {
                hasil2 = rbYes.getText().toString();
            }
            if (hasil2 == null)
            {
                tvrb.setText("Silahkan pilih Jasa Pengiriman");
            }
            else
            {
                tvrb.setText("Menggunakan Jasa Pengiriman : "+hasil2);
            }
            String nama = etNama.getText().toString();
            String telepon = etTelepon.getText().toString();
            String kode = etKode.getText().toString();
            String provinsi = spProvinsi.getSelectedItem().toString();
            String kota = spKota.getSelectedItem().toString();

            tvData.setText("\nData Pembeli");
            tvHasil.setText("Nama : " + nama + "\nTelepon : " + telepon + "\nProvinsi " + provinsi+", "+kota+"\nKode Pos : "+kode);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        }else if (nama.length()<3) {
            etNama.setError("Nama minimal 3 digit");
            valid = false;
        } else {
            etNama.setError(null);
        }

        String telepon = etTelepon.getText().toString();
        if (telepon.isEmpty()) {
            etTelepon.setError("Nomor Telepon belum diisi");
            valid = false;
        }else if (telepon.length()>12) {
            etTelepon.setError("Nomor Telepon maksimal 12 digit");
            valid = false;
        }else {
            etTelepon.setError(null);
        }

        String kode = etKode.getText().toString();
        if (kode.isEmpty()) {
            etKode.setError("Kode Pos belum diisi");
            valid = false;
        }else if (kode.length()!=5) {
            etKode.setError("Kode Pos harus 5 digit");
            valid = false;
        }
        else {
            etTelepon.setError(null);
        }
        return valid;
    }

}

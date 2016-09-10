package id.sch.smktelkom_mlg.tugas1.xirpl5020.samudrashop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTelepon, etKode;
    Button btPesan;
    TextView tvHasil, tvData;
    Spinner spProvinsi, spKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelepon = (EditText) findViewById(R.id.editTextTelepon);
        etKode = (EditText) findViewById(R.id.editTextKode);
        btPesan = (Button) findViewById(R.id.buttonPesan);
        tvData = (TextView) findViewById(R.id.textViewData);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
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
            String nama = etNama.getText().toString();
            String telepon = etTelepon.getText().toString();
            String kode = etKode.getText().toString();
            String provinsi = spProvinsi.getSelectedItem().toString();
            String kota = spKota.getSelectedItem().toString();

            tvData.setText("\nData Pembeli");
            tvHasil.setText("Nama : " + nama + "\nTelepon : " + telepon + "\nProvinsi " + provinsi+", "+kota);
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
        } else {
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

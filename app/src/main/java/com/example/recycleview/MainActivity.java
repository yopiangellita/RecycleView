package com.example.recycleview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements BuahAdapter.OnClickShowListener{
    RecyclerView recBPList;
    List<buah> BPlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBPList();

        recBPList= findViewById(R.id.BPlist);
        BuahAdapter bpAdapter= new BuahAdapter(this,BPlist,this);

        recBPList.setAdapter(bpAdapter);
        recBPList.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initBPList() {
        BPlist = new ArrayList<>();
        BPlist.add(new buah("Apel","apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon apel. Buah apel biasanya berwarna merah kulitnya jika masak dan (siap dimakan), namun bisa juga kulitnya berwarna hijau atau kuning.",R.drawable.apel));
        BPlist.add(new buah("Jambu biji","Jambu biji (Psidium guajava)adalah tanaman tropis yang berasal dari Brasil, disebarkan ke Indonesia melalui Thailand. Jambu batu memiliki buah yang berwarna hijau dengan daging buah berwarna hijau atau merah dan berasa asam-manis.",R.drawable.jambubiji));
        BPlist.add(new buah("Alpukat","Alpukat merupakan jenis buah yang memiliki kandungan lemak tinggi, sekitar 20 kali lebih tinggi dibanding buah-buahan lain.",R.drawable.alpukat));
        BPlist.add(new buah("Pepaya"," Pepaya merupakan salah satu jenis buah buni. Kulit tipis, hijau atau kuning sebelum masak, kemudian kuning atau oranye saat buah masak. Bentuk, ukuran, dan rasanya bervariasi.",R.drawable.pepaya));
        BPlist.add(new buah("Rambutan","diambil dari kata “rambut” istilah dalam bahasa Melayu yang berarti bulu. Buah rambutan mengandung arti buah yang berbulu. Nama tersebut sesuai dengan bentuk kulit buahnya yang ditumbuhi duri halus menyerupai bulu.",R.drawable.rambutan));

    }

    @Override
    public void onClickShowListener(int position) {
        String name = BPlist.get(position).getName();
        String  S =BPlist.get(position).getS();
        int logo =BPlist.get(position).getLogo();

        Intent intent = new Intent(MainActivity.this, ViewActivity.class);
        intent.putExtra("key", name);
        intent.putExtra("key", S);
        intent.putExtra("key", logo);
        startActivity(intent);

    }

}
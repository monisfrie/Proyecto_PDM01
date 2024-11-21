package com.example.proyecto_pdm01.controladores;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_pdm01.R;
import com.example.proyecto_pdm01.adaptadores.VideojuegoAdapter;
import com.example.proyecto_pdm01.modelos.Videojuego;

import java.util.ArrayList;

public class Vista_Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        Videojuego callofduty = new Videojuego(R.drawable.callofduty,"Black Ops 6","Un apasionante shooter que vuelve a resucitar la saga de Call of Duty.",59.99,"Ps5, Xbox X/S, PC");
        Videojuego eldenring = new Videojuego(R.drawable.eldenring,"Elden Ring","Apasionante Soul con una historia increíble y un mundo abierto lleno de aventuras.",59.99,"Ps5/4,Xbox One X/S,PC");
        Videojuego fc25 = new Videojuego(R.drawable.fc25,"FC 25","El rey de los juegos de fútbol con su nueva entrega que te hará querer ganar todos los partidos con su gran jugabilidad",69.99,"Todas las plataformas");
        Videojuego halo = new Videojuego(R.drawable.halo,"Halo Infinite","La última entrega de la saga Halo que te dejará boquiabierto con su historia y online",69.99,"Xbox");
        Videojuego mariowonder = new Videojuego(R.drawable.mariowonder,"Mario Bros Wonder","El mejor mario bros hasta la fecha, te encantaran las nuevas mecanicas",59.99,"Nintendo");
        Videojuego rdr2 = new Videojuego(R.drawable.rdr2,"Read Dead Redemption II","Obra maestra de RockStar que no puedes dejar pasar si te gusta el viejo oeste",39.99,"Ps5/4,Xbox One X/S,PC");
        Videojuego thelastofus2 = new Videojuego(R.drawable.tlous2,"The Last Of Us 2","Increible juego de zombies con una gran historia y jugabilidad en su segunda entrega en Playstation",69.99," Ps5/4");

        videojuegos.add(callofduty);
        videojuegos.add(eldenring);
        videojuegos.add(fc25);
        videojuegos.add(halo);
        videojuegos.add(mariowonder);
        videojuegos.add(rdr2);
        videojuegos.add(thelastofus2);

        VideojuegoAdapter adapter = new VideojuegoAdapter(videojuegos);
        recyclerView.setAdapter(adapter);
    }
}
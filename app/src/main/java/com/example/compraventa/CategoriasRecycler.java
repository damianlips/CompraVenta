package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriasRecycler extends AppCompatActivity {
    List<Categoria> categorias;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected CategoryRecyclerAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_recycler);

        mRecyclerView = findViewById(R.id.recycler_categorias);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        categorias = new ArrayList<Categoria>();
        /*
        categorias.add(new Categoria("Accesorios para Vehículos","MLA5725",R.color.accesorios_para_vehículos));
        categorias.add(new Categoria("Agro","MLA1512",R.color.agro));
        categorias.add(new Categoria("Alimentos y Bebidas","MLA5725",R.color.alimentos_y_bebidas));
        categorias.add(new Categoria("Animales y Mascotas","MLA1071",R.color.animales_y_mascotas));
        categorias.add(new Categoria("Antigüedades y Colecciones","MLA1367",R.color.antiguedades_y_colecciones));
        categorias.add(new Categoria("Arte, Librería y Mercería","MLA1368",R.color.arte_libreria_y_merceria));
        categorias.add(new Categoria("Autos, Motos y Otros","MLA1743",R.color.autos_motos_y_otros));
        categorias.add(new Categoria("Bebés","MLA1384",R.color.bebes));
        categorias.add(new Categoria("Belleza y Cuidado Personal","MLA1246",R.color.belleza_y_cuidado_personal));
        categorias.add(new Categoria("Cámaras y Accesorios","MLA1039",R.color.camaras_y_accesorios));
        categorias.add(new Categoria("Celulares y Teléfonos","MLA1051",R.color.celulares_y_telefonos));
        categorias.add(new Categoria("Computación","MLA1648",R.color.computacion));
        categorias.add(new Categoria("Consolas y Videojuegos","MLA1144",R.color.consolas_y_videojuegos));
        categorias.add(new Categoria("Construcción","MLA1500",R.color.construccion));
        categorias.add(new Categoria("Deportes y Fitness","MLA1276",R.color.deportes_y_fitness));
        categorias.add(new Categoria("Electrodomésticos y Aires Ac.","MLA5726",R.color.electrodomesticos_y_aires_ac));
        categorias.add(new Categoria("Electrónica, Audio y Video","MLA1000",R.color.electronica_audio_y_video));
        categorias.add(new Categoria("Entradas para Eventos","MLA2547",R.color.entradas_para_eventos));
        categorias.add(new Categoria("Herramientas","MLA407134",R.color.herramientas));
        categorias.add(new Categoria("Hogar, Muebles y Jardín","MLA1574",R.color.hogar_muebles_y_jardin));
        categorias.add(new Categoria("Industrias y Oficinas","MLA1499",R.color.industrias_y_oficinas));
        categorias.add(new Categoria("Inmuebles","MLA1459",R.color.inmuebles));
        categorias.add(new Categoria("Instrumentos Musicales","MLA1182",R.color.instrumentos_musicales));
        categorias.add(new Categoria("Joyas y Relojes","MLA3937",R.color.joyas_y_relojes));
        categorias.add(new Categoria("Juegos y Juguetes","MLA1132",R.color.juegos_y_juguetes));
        categorias.add(new Categoria("Libros, Revistas y Comics","MLA3025",R.color.libros_revistas_y_comics));
        categorias.add(new Categoria("Música, Películas y Series\"","MLA1168",R.color.musica_peliculas_y_series));
        categorias.add(new Categoria("Ropa y Accesorios","MLA1430",R.color.ropa_y_accesorios));
        categorias.add(new Categoria("Salud y Equipamiento Médico","MLA409431",R.color.salud_y_equipamiento_medico));
        categorias.add(new Categoria("Servicios","MLA1540",R.color.servicios));
        categorias.add(new Categoria("Souvenirs, Cotillón y Fiestas","MLA9304",R.color.souvenirs_cotillon_y_fiestas));
        categorias.add(new Categoria("Otras categorías","MLA1953",R.color.otras_categorias));
    */

        categorias.add(new Categoria("Accesorios para Vehículos","MLA5725",getString(R.string.accesorios_para_vehículos)));
        categorias.add(new Categoria("Agro","MLA1512",getString(R.string.agro)));
        categorias.add(new Categoria("Alimentos y Bebidas","MLA5725",getString(R.string.alimentos_y_bebidas)));
        categorias.add(new Categoria("Animales y Mascotas","MLA1071",getString(R.string.animales_y_mascotas)));
        categorias.add(new Categoria("Antigüedades y Colecciones","MLA1367",getString(R.string.antiguedades_y_colecciones)));
        categorias.add(new Categoria("Arte, Librería y Mercería","MLA1368",getString(R.string.arte_libreria_y_merceria)));
        categorias.add(new Categoria("Autos, Motos y Otros","MLA1743",getString(R.string.autos_motos_y_otros)));
        categorias.add(new Categoria("Bebés","MLA1384",getString(R.string.bebes)));
        categorias.add(new Categoria("Belleza y Cuidado Personal","MLA1246",getString(R.string.belleza_y_cuidado_personal)));
        categorias.add(new Categoria("Cámaras y Accesorios","MLA1039",getString(R.string.camaras_y_accesorios)));
        categorias.add(new Categoria("Celulares y Teléfonos","MLA1051",getString(R.string.celulares_y_telefonos)));
        categorias.add(new Categoria("Computación","MLA1648",getString(R.string.computacion)));
        categorias.add(new Categoria("Consolas y Videojuegos","MLA1144",getString(R.string.consolas_y_videojuegos)));
        categorias.add(new Categoria("Construcción","MLA1500",getString(R.string.construccion)));
        categorias.add(new Categoria("Deportes y Fitness","MLA1276",getString(R.string.deportes_y_fitness)));
        categorias.add(new Categoria("Electrodomésticos y Aires Ac.","MLA5726",getString(R.string.electrodomesticos_y_aires_ac)));
        categorias.add(new Categoria("Electrónica, Audio y Video","MLA1000",getString(R.string.electronica_audio_y_video)));
        categorias.add(new Categoria("Entradas para Eventos","MLA2547",getString(R.string.entradas_para_eventos)));
        categorias.add(new Categoria("Herramientas","MLA407134",getString(R.string.herramientas)));
        categorias.add(new Categoria("Hogar, Muebles y Jardín","MLA1574",getString(R.string.hogar_muebles_y_jardin)));
        categorias.add(new Categoria("Industrias y Oficinas","MLA1499",getString(R.string.industrias_y_oficinas)));
        categorias.add(new Categoria("Inmuebles","MLA1459",getString(R.string.inmuebles)));
        categorias.add(new Categoria("Instrumentos Musicales","MLA1182",getString(R.string.instrumentos_musicales)));
        categorias.add(new Categoria("Joyas y Relojes","MLA3937",getString(R.string.joyas_y_relojes)));
        categorias.add(new Categoria("Juegos y Juguetes","MLA1132",getString(R.string.juegos_y_juguetes)));
        categorias.add(new Categoria("Libros, Revistas y Comics","MLA3025",getString(R.string.libros_revistas_y_comics)));
        categorias.add(new Categoria("Música, Películas y Series\"","MLA1168",getString(R.string.musica_peliculas_y_series)));
        categorias.add(new Categoria("Ropa y Accesorios","MLA1430",getString(R.string.ropa_y_accesorios)));
        categorias.add(new Categoria("Salud y Equipamiento Médico","MLA409431",getString(R.string.salud_y_equipamiento_medico)));
        categorias.add(new Categoria("Servicios","MLA1540",getString(R.string.servicios)));
        categorias.add(new Categoria("Souvenirs, Cotillón y Fiestas","MLA9304",getString(R.string.souvenirs_cotillon_y_fiestas)));
        categorias.add(new Categoria("Otras categorías","MLA1953",getString(R.string.otras_categorias)));
        mAdapter = new CategoryRecyclerAdapter(categorias,this);
        mRecyclerView.setAdapter(mAdapter);


    }


}
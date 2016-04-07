package br.unifor.najaragois.telamenucurso;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.List;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class TelaListaCursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_cursos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView messageCCT = (TextView) findViewById(R.id.cursosCCT);
        messageCCT.setTypeface(null, Typeface.BOLD);
        ListView lista = (ListView) findViewById(R.id.listView);
        DAO dao = new DAO(this);

        List cursos = dao.recuperarRegistrosCurso();
        ArrayAdapter adapter;

        if (cursos.isEmpty()) {
            dao.loadDataBase();
            cursos = dao.recuperarRegistrosCurso();
            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cursos);
            lista.setAdapter(adapter);

        }else{
            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cursos);
            lista.setAdapter(adapter);
        }

        lista.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item

                CursoBean cursoBean = (CursoBean) parent.getAdapter().getItem(position);
                //String curso = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), TelaDetalhesCurso.class);
                // sending data to new activity
                i.putExtra("idCurso", String.valueOf(cursoBean.getId()));
                i.putExtra("nome", cursoBean.getNome());
                i.putExtra("descricao", cursoBean.getDescricao());
                i.putExtra("turno", cursoBean.getTurno());
                i.putExtra("vagas", cursoBean.getVagas());
                i.putExtra("coordenador", cursoBean.getCoordenador());
                startActivity(i);

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

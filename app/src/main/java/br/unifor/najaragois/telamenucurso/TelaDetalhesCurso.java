package br.unifor.najaragois.telamenucurso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class TelaDetalhesCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_curso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText idText = (EditText) findViewById(R.id.idText);
        EditText nomeText = (EditText) findViewById(R.id.nomeText);
        EditText descricaoText = (EditText) findViewById(R.id.descricaoText);
        EditText turnoText = (EditText) findViewById(R.id.turnoText);
        EditText vagasText = (EditText) findViewById(R.id.vagasText);
        EditText coordenadorText = (EditText) findViewById(R.id.coordenadorText);

        Intent intent = getIntent();
        String id = intent.getStringExtra("idCurso");
        String nome = intent.getStringExtra("nome");
        String descricao = intent.getStringExtra("descricao");
        String turno = intent.getStringExtra("turno");
        String vagas = intent.getStringExtra("vagas");
        String coordenador = intent.getStringExtra("coordenador");


        Button botaoEmail= (Button) findViewById(R.id.botaoEmail);
        botaoEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"eguimaraes@unifor.br"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Email para o coordenador");
                i.putExtra(Intent.EXTRA_TEXT   , "Corpo do email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    //Toast.makeText(MyActivity.this, "Não tem cliente de email.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        idText.setText(id);
        nomeText.setText(nome);
        descricaoText.setText(descricao);
        turnoText.setText(turno);
        vagasText.setText(vagas);
        coordenadorText.setText(coordenador);



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

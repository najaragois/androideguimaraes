package br.unifor.najaragois.telamenucurso;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import android.content.ContentValues;

import java.util.List;

/**
 * Created by najaragois on 4/7/16.
 */
public class DAO extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cursos.db";

    private static final String TABLE_CURSOS = "cursos";

    private static final int DATABASE_VERSION = 1;


    public DAO(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
     public List<CursoBean> recuperarRegistrosCurso(){

         // Passo 01 - Criar o arraylist de CursoBean
         List<CursoBean> listaCursoBean = new ArrayList<CursoBean>();

         // Passo 02 - Criar o SQL para selecionar os registros do banco
         String sql = "SELECT * FROM " + TABLE_CURSOS + " order by nome ";

         // Passo 03 - Recuperar os registros
         Cursor cursor = getReadableDatabase().rawQuery(sql, null);

         // Passo 04 - Percorrer o cursor e salvar os registros de CursoBean
         while (cursor.moveToNext()) {

             // Criação da instancia de cursoBean utilizando informações
             // provenientes da base de dados
             CursoBean cursoBean = new CursoBean();

             // Construindo o objeto a partir dos registros da base de dados
             cursoBean.setId(cursor.getInt(0));
             cursoBean.setNome(cursor.getString(1));
             cursoBean.setDescricao(cursor.getString(2));
             cursoBean.setTurno(cursor.getString(3));
             cursoBean.setVagas(cursor.getString(4));
             cursoBean.setCoordenador(cursor.getString(5));

             // Adicionando a instancia de curso a lista de cursos
             listaCursoBean.add(cursoBean);
         }

         return listaCursoBean;
     }


    public void inserirCurso(CursoBean bean){

        ContentValues contentValues = new ContentValues();

        contentValues.put("id", bean.getId());
        contentValues.put("nome", bean.getNome());
        contentValues.put("descricao", bean.getDescricao());
        contentValues.put("turno", bean.getTurno());
        contentValues.put("vagas", bean.getVagas());
        contentValues.put("coordenador", bean.getCoordenador());

        getWritableDatabase().insert(TABLE_CURSOS, null, contentValues);

    }

    public void loadDataBase(){
        CursoBean bean = new CursoBean();
        bean.setId(1);
        bean.setNome("ADS");
        bean.setDescricao("Curso de Analise e Desenvolvimento de Sistemas");
        bean.setTurno("Noite");
        bean.setVagas("60");
        bean.setCoordenador("Bill");

        CursoBean bean2 = new CursoBean();
        bean2.setId(2);
        bean2.setNome("Biomedicina");
        bean2.setDescricao("Curso de Análises Clínicas ");
        bean2.setTurno("Integral");
        bean2.setVagas("55");
        bean2.setCoordenador("Bob");

        CursoBean bean3 = new CursoBean();
        bean3.setId(3);
        bean3.setNome("Fisioterapia");
        bean3.setDescricao("Curso de Fisioterapia ");
        bean3.setTurno("Manha e Noite");
        bean3.setVagas("50");
        bean3.setCoordenador("Bruce");

        inserirCurso(bean);
        inserirCurso(bean2);
        inserirCurso(bean3);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE cursos"
                + "(id INTEGER PRIMARY KEY, " + "nome TEXT, "
                + "descricao TEXT, "
                + "turno TEXT,"
                + "vagas TEXT, "
                + "coordenador TEXT);";

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            String sql = "DROP TABLE IF EXISTS " + TABLE_CURSOS;

            db.execSQL(sql);

            onCreate(db);

        }

}

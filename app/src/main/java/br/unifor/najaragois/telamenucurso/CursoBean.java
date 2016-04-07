package br.unifor.najaragois.telamenucurso;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by najaragois on 4/7/16.
 */
public class CursoBean implements Parcelable {

    private String nome;
    private int id;
    private String descricao;
    private String turno;
    private String vagas;
    private String coordenador;

    private CursoBean(Parcel from){
        nome = from.readString();
        id = from.readInt();
        descricao = from.readString();
        turno = from.readString();
        vagas = from.readString();
        coordenador = from.readString();
    }

    public CursoBean(String nome, int id, String descricao, String turno, String vagas, String coordenador ) {

        this.nome = nome;
        this.id = id;
        this.descricao = descricao;
        this.turno = turno;
        this.vagas = vagas;
        this.coordenador = coordenador;
    }

    public CursoBean(){
        super();

    }

    public String toString(){
        return "Nome: " + this.nome + "(" +this.id+")";
    }

    public static final Parcelable.Creator<CursoBean>
            CREATOR = new Parcelable.Creator<CursoBean>() {

        public CursoBean createFromParcel(Parcel in) {
            return new CursoBean(in);
        }

        public CursoBean[] newArray(int size) {
            return new CursoBean[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nome);
        dest.writeInt(id);
        dest.writeString(descricao);
        dest.writeString(turno);
        dest.writeString(vagas);
        dest.writeString(coordenador);

    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTurno() {
        return turno;
    }

    public String getVagas() {
        return vagas;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
}

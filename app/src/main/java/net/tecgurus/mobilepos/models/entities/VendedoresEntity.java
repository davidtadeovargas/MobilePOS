package net.tecgurus.mobilepos.models.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "Vendedores",
        indices = {@Index(value="nombre", unique=true)},
        foreignKeys=@ForeignKey(entity=ClienteEntity.class,
        parentColumns="id",
        childColumns= "clientes"))


public class VendedoresEntity {

    @PrimaryKey(autoGenerate = true )
    private int id;
    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;
    @ColumnInfo(name = "planta")
    @NonNull
    private String planta;
    @ColumnInfo(name = "unidad")

    @Relation(parentColumn = "id",entityColumn = "clientes")
    private List<ClienteEntity> clientes;
    @ColumnInfo(name = "tipo")
    @NonNull
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteEntity> clientes) {
        this.clientes = clientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

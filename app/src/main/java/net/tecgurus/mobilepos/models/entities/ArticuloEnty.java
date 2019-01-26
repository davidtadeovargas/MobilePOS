package net.tecgurus.mobilepos.models.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Articulos",indices = {@Index(value="noCorto", unique=true)})
public class ArticuloEnty{

    @PrimaryKey(autoGenerate = true )
private int id;
    @ColumnInfo(name = "noCorto")
    @NonNull
private String noCorto;
    @ColumnInfo(name = "unidad")
private String unidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoCorto() {
        return noCorto;
    }

    public void setNoCorto(String noCorto) {
        this.noCorto = noCorto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}

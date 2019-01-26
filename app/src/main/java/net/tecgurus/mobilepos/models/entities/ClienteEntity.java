package net.tecgurus.mobilepos.models.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

@Entity(tableName = "clientes")

public class ClienteEntity {
    @PrimaryKey(autoGenerate = true )
    private int id;
    @ColumnInfo(name = "nombre")
    @NonNull
    private String nombre;
    @ColumnInfo(name = "region")
    private String region;
    @Relation(parentColumn = "id",entityColumn = "vendedor")
    private VendedoresEntity Vendedor;

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public VendedoresEntity getVendedor() {
        return Vendedor;
    }

    public void setVendedor(VendedoresEntity vendedor) {
        Vendedor = vendedor;
    }
}

package net.tecgurus.mobilepos.models.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Date;

@Entity(tableName = "Pedidos",indices = {@Index(value="noPedido", unique=true)})

public class PedidoEntity {

    @PrimaryKey(autoGenerate = true )
    private int id;

    @ColumnInfo(name = "noPedido")
    @NonNull
    private int noPedido;
    @ColumnInfo(name = "tipoPedido")
    @NonNull
    private String tipoPedido;
    @ColumnInfo(name = "FolioFactura")
    @NonNull
    private int FolioFactura;
    @ColumnInfo(name = "tipoFactura")
    @NonNull
    private String tipoFactura;
    @ColumnInfo(name="fecha")
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoPedido() {
        return noPedido;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public int getFolioFactura() {
        return FolioFactura;
    }

    public void setFolioFactura(int folioFactura) {
        FolioFactura = folioFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }
}

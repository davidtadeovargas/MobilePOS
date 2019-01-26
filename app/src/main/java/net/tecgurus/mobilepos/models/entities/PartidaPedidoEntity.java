package net.tecgurus.mobilepos.models.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
@Entity(tableName = "PartidaPedido")

public class PartidaPedidoEntity {



    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "pedido")
    @NonNull
    private PedidoEntity pedido;
    @NonNull
    @ColumnInfo(name = "articulo")
    private ArticuloEnty articulo;
    @NonNull
    @ColumnInfo(name = "Cantidad")
    private double Cantidad;
    @NonNull
    @ColumnInfo(name = "precio")
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ArticuloEnty getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloEnty articulo) {
        this.articulo = articulo;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double cantidad) {
        Cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

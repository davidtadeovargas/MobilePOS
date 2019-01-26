package net.tecgurus.mobilepos.controllers.db.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import net.tecgurus.mobilepos.models.entities.PartidaPedidoEntity;

import java.util.List;

@Dao
public interface PartidaPedidoDAO {

    @Insert
    void inserPartida(final PartidaPedidoEntity partidaPedidoEntity);

    @Query("SELECT * FROM PartidaPedido WHERE pedido=:id")
    List<PartidaPedidoEntity> getAllByPedido(final int id);
}

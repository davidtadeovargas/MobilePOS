package net.tecgurus.mobilepos.controllers.db.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import net.tecgurus.mobilepos.models.entities.PedidoEntity;

import java.util.List;

@Dao
public interface PedidosDAO {
    @Insert
    void agregarPedido(final PedidoEntity pedidoEntity);

        @Query("SELECT * FROM Pedidos")
    List<PedidoEntity> consultarPedido();
}

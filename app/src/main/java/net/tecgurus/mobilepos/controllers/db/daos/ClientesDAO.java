package net.tecgurus.mobilepos.controllers.db.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.tecgurus.mobilepos.models.entities.ClienteEntity;

import java.util.List;

@Dao
public interface ClientesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addClientes(ClienteEntity clienteEntity);

    @Insert
    void addClientes(ClienteEntity...clienteEntities);

    @Query("DELETE FROM Clientes")
    void deleteAll();

    @Query("DELETE FROM clientes WHERE id=:id")
    void deleteById(final int id);

    @Query("SELECT *FROM  clientes WHERE id=:id")
   ClienteEntity okgetClienteByID(final int id);

    @Query("SELECT *FROM clientes")
    List<ClienteEntity> getAll();
}

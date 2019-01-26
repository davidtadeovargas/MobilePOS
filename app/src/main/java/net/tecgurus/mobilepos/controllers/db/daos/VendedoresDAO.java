package net.tecgurus.mobilepos.controllers.db.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.tecgurus.mobilepos.models.entities.VendedoresEntity;

import java.util.List;

@Dao
public interface VendedoresDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void addVendedor(VendedoresEntity vendedorEntity);

    @Insert
    void addVendedores(VendedoresEntity...vendedorEntities);

    @Query("DELETE FROM Vendedores")
    void deleteAll();

    @Query("DELETE FROM Vendedores WHERE id=:id")
    void deleteById(final int id);

    @Query("SELECT *FROM  Vendedores LIMIT 1")
    VendedoresEntity getVendedorLocal();

    @Query("SELECT *FROM Vendedores")
    List<VendedoresEntity> getAll();




}

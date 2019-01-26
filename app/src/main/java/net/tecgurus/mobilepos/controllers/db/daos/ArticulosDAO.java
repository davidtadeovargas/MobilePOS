package net.tecgurus.mobilepos.controllers.db.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.tecgurus.mobilepos.models.entities.ArticuloEnty;

import java.util.List;

@Dao
public interface ArticulosDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addArticulos(ArticuloEnty articuloEnty);

    @Insert
    void addArticulos(ArticuloEnty... articuloEnties);

    @Query("DELETE FROM Articulos")
    void deleteAll();

    @Query("DELETE FROM Articulos WHERE id=:id")
    void deleteById(final int id);

    @Query("SELECT *FROM  Articulos WHERE noCorto=:noCorto")
    ArticuloEnty getArticulo(final String noCorto);

    @Query("SELECT *FROM Articulos")
    List<ArticuloEnty> getAll();
}

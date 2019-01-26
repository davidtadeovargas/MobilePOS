package net.tecgurus.mobilepos.controllers.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.tecgurus.mobilepos.controllers.db.daos.ArticulosDAO;
import net.tecgurus.mobilepos.controllers.db.daos.ClientesDAO;
import net.tecgurus.mobilepos.controllers.db.daos.PartidaPedidoDAO;
import net.tecgurus.mobilepos.controllers.db.daos.PedidosDAO;
import net.tecgurus.mobilepos.controllers.db.daos.VendedoresDAO;
import net.tecgurus.mobilepos.models.entities.ArticuloEnty;
import net.tecgurus.mobilepos.models.entities.ClienteEntity;
import net.tecgurus.mobilepos.models.entities.PartidaPedidoEntity;
import net.tecgurus.mobilepos.models.entities.PedidoEntity;
import net.tecgurus.mobilepos.models.entities.VendedoresEntity;

@Database(entities = {
        ArticuloEnty.class,
        ClienteEntity.class,
        PartidaPedidoEntity.class,
        PedidoEntity.class,
        VendedoresEntity.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract ArticulosDAO articulosDAO();
    public abstract ClientesDAO clientesDAO();
    public abstract PartidaPedidoDAO partidaPedidoDAO();
    public abstract PedidosDAO pedidosDAO();
    public abstract VendedoresDAO vendedoresDAO();

    private AppDatabase(){

    }


    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {

        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Ventas")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return appDatabase;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}


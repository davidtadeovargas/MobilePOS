package net.tecgurus.mobilepos.controllers.repository;

import android.app.Activity;

import net.tecgurus.mobilepos.models.entities.VendedoresEntity;

public class VendedoresRepository extends Repository{


    protected VendedoresRepository(Activity activity) {
        super(activity);
    }
    final public VendedoresEntity getLocalVendedor(){
        return this.appDatabase.vendedoresDAO().getVendedorLocal();
    }
    final public void addVendedor(final VendedoresEntity vendedor){
        this.appDatabase.vendedoresDAO().addVendedor(vendedor);
    }
}

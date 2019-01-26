package net.tecgurus.mobilepos.controllers.requests;

import com.google.gson.Gson;

import net.tecgurus.mobilepos.models.entities.ClienteEntity;
import net.tecgurus.mobilepos.models.requests.ClientesRequestModel;

import java.util.List;

public class ClientesRequest extends Request {

    private OnResutClients onResult;
    private OnResultSaldo onResultSaldo;
    private ClientesRequestModel clientesRequestModel;





    @Override
    protected void onResult(String result) {

        final Gson gson = new Gson();
        final ClientesRequestModel clientesRequestModel = gson.fromJson(result,ClientesRequestModel.class);
        if(clientesRequestModel.isResult()){
            if(clientesRequestModel.getType().compareTo(ClientesRequestModel.TYPE_CLIENTS)==0){
                if(this.onResult!=null){
                    this.onResult.onResult(clientesRequestModel.getClientes());
                }
            }
            else if(clientesRequestModel.getType().compareTo(ClientesRequestModel.TYPE_SALDO)==0){
                if(this.onResultSaldo!=null){
                    this.onResultSaldo.onResult(clientesRequestModel.getSaldo());
                }
            }
        }
    }

    @Override
    public void execute() throws Exception {

        //Capa de validación

        final Gson gson = new Gson();
        final String json = gson.toJson(this.clientesRequestModel);
        final String result = this.requestManager.post("http://localhost:8080/clientes",json);
        this.onResult(result);
    }

    public void setOnResult(OnResutClients onResult) {
        this.onResult = onResult;
    }

    public void setClientesRequestModel(ClientesRequestModel clientesRequestModel) {
        this.clientesRequestModel = clientesRequestModel;
    }

    public void setOnResultSaldo(OnResultSaldo onResultSaldo) {
        this.onResultSaldo = onResultSaldo;
    }

    public interface OnResutClients {
        void onResult(List<ClienteEntity> clients);
    }
    public interface OnResultSaldo{
        void onResult(double saldo);
    }
}

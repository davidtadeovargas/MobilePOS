package net.tecgurus.mobilepos.controllers.requests;

public abstract class Request {

    protected RequestManager requestManager = RequestManager.getInstances();

    protected OKRequestResponse okRequestResponse;
    protected ErrorRequestResponse errorRequestResponse;
    protected RequestResponse requestResponse;




    abstract protected void onResult(final String result);
    abstract public void execute() throws Exception;

    interface OKRequestResponse{
        void onOKResponse();
    }
    interface ErrorRequestResponse{
        void onErrorResponse();
    }
    interface RequestResponse{
        void onOKResponse();
        void onErrorResponse();
    }

    public void setOkRequestResponse(OKRequestResponse okRequestResponse) {
        this.okRequestResponse = okRequestResponse;
    }

    public void setErrorRequestResponse(ErrorRequestResponse errorRequestResponse) {
        this.errorRequestResponse = errorRequestResponse;
    }

    public void setRequestResponse(RequestResponse requestResponse) {
        this.requestResponse = requestResponse;
    }
}
